import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Account } from 'src/app/domain/account';
import { AccountService } from 'src/app/service/account.service';

@Component({
  selector: 'app-account-request',
  templateUrl: './account-request.component.html',
  styleUrls: ['./account-request.component.css']
})
export class AccountRequestComponent implements OnInit{

  flag:boolean=false;
  account : Account=new Account();
  allAccounts :Account[]=[];
  constructor(private activatedRouter: ActivatedRoute, private accountService: AccountService, private router: Router) {

  }
  ngOnInit(): void {
   this.accountService.accountsByAccountStatus().subscribe(
    data=>{
      this.allAccounts=data;
    }
   );
  }

  accountDetails(accountId : number){
    this.router.navigate(['accountdetails',accountId]);

  }

  changeAccountStatus(accountId : number){
    this.accountService.changeAccountstatus(accountId).subscribe(
      data=>{
        this.flag=data;
        this.reload();
      }
      
    );

  }

  reload(){
    this.accountService.accountsByAccountStatus().subscribe(
      data=>{
        this.allAccounts=data;
      }
     );
    
  }





}
