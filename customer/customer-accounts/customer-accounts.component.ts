import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Account } from 'src/app/domain/account';
import { Customer } from 'src/app/domain/customer';
import { Login } from 'src/app/domain/login';
import { AccountService } from 'src/app/service/account.service';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-customer-accounts',
  templateUrl: './customer-accounts.component.html',
  styleUrls: ['./customer-accounts.component.css']
})
export class CustomerAccountsComponent implements OnInit{

  allAccounts: Account[] = [];
  login : Login=new Login();
  customerId : number=0;
  flag:boolean=false;
  loginId:number=0;
  balance:boolean=false;
  balanceAmount:number=0;
  balanceFlag:boolean=false;
  sampleAccountId:number=0;
  AccountSuccess: string='CREATED';
 // customerId:number=0;

  constructor(private activatedRouter: ActivatedRoute,private loginService :LoginService, private accountService: AccountService, private router: Router) {
  }
  ngOnInit(): void {

    this.loginId =this.activatedRouter.snapshot.params['loginId'];
    if(sessionStorage.getItem("login")!="true" || this.loginId.toString()!= sessionStorage.getItem("loginid")){
      console.log(sessionStorage) 
      this.router.navigate(['login'])
       return}
    this.loginService.adminLoginByLoginId(this.loginId).subscribe(
      data=>{
        this.login=data;
        this.accountService.accountsByCustomerId(this.login.customerId.customerId).subscribe(
          data=>{
            this.allAccounts=data;
            sessionStorage.setItem("accounts",JSON.stringify(this.allAccounts))
          }
        );
      }
    );
    

   
  }


  transfer(accountId : number) {
    sessionStorage.setItem("accountId",accountId.toString())
    this.router.navigate(['transfer',accountId]);
    
  }

  goback(){
    this.router.navigate(['customerhome',this.loginId])

  }
  checkBalance(accountId:number):Number{


    
   
    this.accountService.accountByAccountId(accountId).subscribe(
      data=>{
        this.balanceAmount=data.currentBalance;
        
        this.sampleAccountId=accountId;
       
      }
    );
    return this.sampleAccountId;
 

  }

  transaction(accountId:number){
    sessionStorage.setItem("accountId",accountId.toString())

    this.router.navigate(['transactionlist',accountId])

  }
  cheque(accountId:number){
    sessionStorage.setItem("accountId",accountId.toString())

    this.router.navigate(['chequeslip',accountId])
  }

 



 

  

}
