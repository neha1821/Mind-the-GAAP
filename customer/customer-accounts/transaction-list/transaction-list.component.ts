import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Account } from 'src/app/domain/account';
import { Login } from 'src/app/domain/login';
import { Transactions } from 'src/app/domain/transactions';
import { AccountService } from 'src/app/service/account.service';
import { CustomerService } from 'src/app/service/customer.service';
import { LoginService } from 'src/app/service/login.service';
import { TransactionService } from 'src/app/service/transaction.service';

@Component({
  selector: 'app-transaction-list',
  templateUrl: './transaction-list.component.html',
  styleUrls: ['./transaction-list.component.css']
})
export class TransactionListComponent implements OnInit{

  accountId:number=0;
  toAccountId:number=0;
  allTransaction:Transactions[]=[];
  transaction:Transactions=new Transactions();
  login :Login=new Login();
  account:Account=new Account();
  sno:number=1;


  constructor(private activatedRouter: ActivatedRoute,private customerService:CustomerService,private loginService :LoginService, private accountService: AccountService, private router: Router,private transactionService:TransactionService) {
  }
  ngOnInit(): void {
    
    this.accountId =this.activatedRouter.snapshot.params['accountId'];
    this.transaction.fromAccountId=this.accountId;
    this.transaction.toAccountId=this.accountId;
    this.transactionService.allTransactionCreditDebitByAccountId(this.transaction).subscribe(
      data=>{
        
        var i:number;
        
        for( i = 0; i < data.length; i ++) {
                this.allTransaction[i]=data[i];
        }
       
        

        this.accountService.accountByAccountId(this.accountId).subscribe(
          data=>{
            this.account=data;
            this.loginService.getLoginByCustomerId(this.account.customerId.customerId).subscribe(
              data=>{
                this.login=data;
                if(sessionStorage.getItem("login")!="true" || this.accountId.toString()!= sessionStorage.getItem("accountId")){
                  console.log(sessionStorage) 
                  this.router.navigate(['login'])
                   return
                }
    
              }
            );
          }
        );


        
      }
    );
    
  }

  goback(){
    this.router.navigate(['customeraccounts',this.login.loginId])
  }

}
