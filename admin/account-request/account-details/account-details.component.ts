import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Account } from 'src/app/domain/account';
import { AccountService } from 'src/app/service/account.service';

@Component({
  selector: 'app-account-details',
  templateUrl: './account-details.component.html',
  styleUrls: ['./account-details.component.css']
})
export class AccountDetailsComponent {

  account :Account=new Account();
  accountId : number =0;
  constructor(private activatedRouter : ActivatedRoute, private accountService : AccountService,private router : Router){


  }

  ngOnInit(): void {
    this.accountId =this.activatedRouter.snapshot.params['accountId'];
    this.accountService.accountByAccountId(this.accountId).subscribe(
      data=>{
        this.account=data;
      }
    );
    
    
   
    
  }
 goback(){
    
    this.router.navigate(['accountrequest'])
  }

}


