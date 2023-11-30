import { Component, OnInit, TRANSLATIONS } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Account } from 'src/app/domain/account';
import { Login } from 'src/app/domain/login';
import { Transactions } from 'src/app/domain/transactions';
import { AccountService } from 'src/app/service/account.service';
import { LoginService } from 'src/app/service/login.service';
import { TransactionService } from 'src/app/service/transaction.service';

@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.component.css']
})
export class TransferComponent implements OnInit{


  transaction : Transactions=new Transactions();
  accountId :number=0;
  result : boolean=false;
  flag:boolean=false;
  alert:boolean=false;
  //allTransaction:Transactions[]=[];
  transactionId:number=0;
  login:Login=new Login();
  amountNotEnough:boolean=false;
  transaferSuccess:boolean=false;
 

  constructor(private activatedRouter : ActivatedRoute,private loginService:LoginService,private accountService:AccountService,private transactionService :TransactionService, private customerService : AccountService,private router : Router){
  }
  ngOnInit(): void {
    
    this.accountId =this.activatedRouter.snapshot.params['accountId'];
    if(sessionStorage.getItem("login")!="true" || this.accountId.toString()!= sessionStorage.getItem("accountId")){
      console.log(sessionStorage) 
      this.router.navigate(['login'])
       return
    }
    this.accountService.accountByAccountId(this.accountId).subscribe(
      data=>{
        this.transaction.fromAccount=data;
       
      }
    );
  }
 



  addTransaction(){
    if(this.transaction.amount>0){
    this.transaction.fromAccountId=this.accountId;
    this.transaction.toAccountId=this.transaction.toAccount.accountId;
    this.transaction.transactionStatus='SUCCESS';
    this.transaction.type='TRANSFER';
    if(this.amountTransfer()){
        
      this.transactionService.updateTransactionAmount(this.transaction).subscribe(
        data=>{
          this.transaction=data;
          console.log(data);
           this.accountService.changeAmount(this.transaction.fromAccount).subscribe(
        data=>{
          console.log(data);
          this.accountService.changeAmount(this.transaction.toAccount).subscribe(
            data=>{
              console.log(data);
              this.transactionService.addTransaction(this.transaction).subscribe(
                data=>{
                  this.result=data;
                 // console.log(this.transaction)
                  this.TransactionIdByAccountId();
                  this.transaction.transactionId=this.transactionId;
                  this.transaferSuccess=true;
                 
               
            
                }
              );
              }
            
          );
        
        }
      );
      
        }
      );
  
    } 
    else{
      console.log("hi")
      this.amountNotEnough=true;
      

      
    }
   

  }}

  checkToaccount(){
    this.alert=true;
    this.accountService.accountByAccountId(this.transaction.toAccount.accountId).subscribe(
      data=>{
        this.transaction.toAccount=data;
          this.flag=true;
          this.alert=false;
      }
    );
    
  }

 

  TransactionIdByAccountId() {
    this.transactionService.allTransactionByAccountId(this.accountId).subscribe(
      data=>{
       // this.allTransaction[0]=data.reverse()[0]
        this.transactionId=data.reverse()[0].transactionId;
        
       
      }
    );
  }

  amountTransfer() : boolean{
    if(this.transaction.fromAccount.accountType=='SAVING_ACCOUNT'){
      if(this.transaction.fromAccount.currentBalance>=this.transaction.amount){
      

        return true;
  
      }
      return false;
    }
    else{
      
    if(this.transaction.fromAccount.overDraftBalance>=this.transaction.amount){
      
      

      return true;

    }
    return false;
  }
  return false;
    
  }

  goback(){
    this.loginService.getLoginByCustomerId(this.transaction.fromAccount.customerId.customerId).subscribe(
      data=>{
        this.login=data;
        this.router.navigate(['customeraccounts',this.login.loginId])
      }
    );
   
  }
}
