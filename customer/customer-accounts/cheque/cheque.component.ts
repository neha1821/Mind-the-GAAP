import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Cheque } from 'src/app/domain/cheque';
import { Customer } from 'src/app/domain/customer';
import { Login } from 'src/app/domain/login';
import { AccountService } from 'src/app/service/account.service';
import { ChequeService } from 'src/app/service/cheque.service';
import { CustomerService } from 'src/app/service/customer.service';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-cheque',
  templateUrl: './cheque.component.html',
  styleUrls: ['./cheque.component.css']
})
export class ChequeComponent implements OnInit{

  loginId: number = 0;
 date:Date=new Date();
 
  accountId:number=0;
  login: Login = new Login();
  cheque: Cheque = new Cheque();
  chequeFlag:boolean=false;
  allCheque:Cheque[]=[];
  alert:boolean=false;
  flag:boolean=false;
  allCustomer:Customer[]=[];
  accId:number=1001;
  result:boolean=false;
  navButton:boolean=false;
 
  active:boolean=false;
  typeChanges:string="";
  chequeAmount:number=0;
 
  constructor(private activatedRouter: ActivatedRoute,private loginService:LoginService,private customerService:CustomerService, private chequeService : ChequeService,private accountService : AccountService, private router: Router) {


  }
  ngOnInit(): void {
    //this.cheque.fromAccountId=1001;
    this.accountId =this.activatedRouter.snapshot.params['accountId'];
    this.cheque.fromAccountId=this.accountId;
    if(sessionStorage.getItem("login")!="true" || this.accountId.toString()!= sessionStorage.getItem("accountId")){
      console.log(sessionStorage) 
      this.router.navigate(['login'])
       return
    }
    
    
    console.log(this.cheque.fromAccountId);
    this.accountService.accountByAccountId(this.accountId).subscribe(
      data=>{
        this.cheque.fromAccount=data;
        
        
        this.chequeService.getAllReceivedCheque(this.cheque.fromAccount).subscribe(
          data=>{
            this.allCheque=data;
            console.log(this.date);
            
            for (var i = 0; i < data.length; i++) {
              let existingDate=new Date(data[i].clearanceChequeDate.substring(0, 10));
              console.log(existingDate);
              console.log(this.date);
              console.log(existingDate > this.date)
              if (data[i].chequeStatus=='UNCLEARED' && existingDate < this.date) {
                data[i].chequeStatus='FAILED';
                this.allCheque=data;
                console.log(data[i]);
                this.allCheque[i].chequeStatus='FAILED';
                this.chequeService.updateCheque(this.allCheque[i]).subscribe(
                  data=>{
                    
                    
                    console.log(data);
                    console.log(data.chequeStatus);
                  }
                );
                
               
              }
            }
         
           

            
            
            
          }
        );
        
      }
    );
  }
 
  gotologin(){
    this.loginService.getLoginByCustomerId(this.cheque.fromAccount.customerId.customerId).subscribe(
      data=>{
        this.loginId=data.loginId;
        this.router.navigate(['customeraccounts',this.loginId])
      }
    );

    
  }

  CreateCheque(){
    this.cheque.amount=this.chequeAmount;
    this.cheque.toAccountId=this.cheque.toAccount.accountId;
    this.cheque.chequeStatus='UNCLEARED';
    this.chequeService.addNewCheque(this.cheque).subscribe(
      data=>{
         this.result=data;
        
        this.navButton=data;
        
        
      }
    );
  }

  activeUpdate(che:Cheque){
    this.cheque.chequeId=che.chequeId;
    this.cheque.amount=che.amount;
    
    this.cheque.chequeStatus='ACTIVE';
    console.log(this.cheque);
    this.chequeService.updateCheque(this.cheque).subscribe(
      data=>{
        this.cheque=data;
        console.log(data);
        this.reload();
      }
    );
    console.log(this.cheque);
    
  }

  checkToaccount(){
    this.alert=true;
    this.accountService.accountByAccountId(this.cheque.toAccount.accountId).subscribe(
      data=>{
        this.cheque.toAccount=data;
        console.log(this.flag);
          this.flag=true;
          this.alert=false;
        
          this.cheque.toAccount=data;
          console.log(this.flag);

      }
    );

  }

  reload(){
    this.chequeService.getAllReceivedCheque(this.cheque.fromAccount).subscribe(
      data=>{
        this.allCheque=data;
        console.log(data);
      }
    );

  }

 

  

  changeIssueFlag(){
    this.chequeFlag=true;
  }
  changeClaimFlag(){
    this.chequeFlag=false;
   
    
  }
 

  

}


