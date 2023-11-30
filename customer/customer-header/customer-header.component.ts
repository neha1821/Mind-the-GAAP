import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Account } from 'src/app/domain/account';
import { Login } from 'src/app/domain/login';
import { AccountService } from 'src/app/service/account.service';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-customer-header',
  templateUrl: './customer-header.component.html',
  styleUrls: ['./customer-header.component.css']
})
export class CustomerHeaderComponent implements OnInit{
  loginId:number=0;
  login:Login=new Login();
  accountId:number=0;
  account:Account=new Account();
  constructor(private router:Router ,private activatedRouter:ActivatedRoute,private accountService:AccountService,private loginService:LoginService){}
  ngOnInit(): void {
    
    this.loginId=this.activatedRouter.snapshot.params['loginId'];
    this.accountId=this.activatedRouter.snapshot.params['accountId'];
    
    
  }


  details(){
    if(this.accountId>0){
      this.accountService.accountByAccountId(this.accountId).subscribe(
        data=>{
          this.account=data;
          this.loginService.getLoginByCustomerId(this.account.customerId.customerId).subscribe(
            data=>{
              this.login=data;
              this.router.navigate(['customerhomedetails',this.login.loginId])
            }
          );

        }
      );

    }
    

    if(this.loginId>0){
    this.router.navigate(['customerhomedetails',this.loginId]);
    }
    

  }
  accountsList(){
    if(this.accountId>0){
      this.accountService.accountByAccountId(this.accountId).subscribe(
        data=>{
          this.account=data;
          this.loginService.getLoginByCustomerId(this.account.customerId.customerId).subscribe(
            data=>{
              this.login=data;
              this.router.navigate(['customeraccounts',this.login.loginId])
            }
          );

        }
      );

    }
    if(this.loginId>0){
    this.router.navigate(['customeraccounts',this.loginId]);
    }
  }

  newAccount(){
    if(this.accountId>0){
      this.accountService.accountByAccountId(this.accountId).subscribe(
        data=>{
          this.account=data;
          this.loginService.getLoginByCustomerId(this.account.customerId.customerId).subscribe(
            data=>{
              this.login=data;
              this.router.navigate(['customernewaccount',this.login.loginId])
            }
          );

        }
      );

    }
    if(this.loginId>0){
    this.router.navigate(['customernewaccount',this.loginId])
    }
  }

  logout(){
    sessionStorage.setItem("login","")
    sessionStorage.setItem("loginid","")
    sessionStorage.setItem("accountId","")
    this.router.navigate(['login'])
  }


}
