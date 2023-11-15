import { Component, OnInit } from '@angular/core';
import { Login } from '../login';
import { NetBankingService } from '../net-banking.service';
import { Router } from '@angular/router';
import { Account } from '../account';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  login: Login = new Login();
  loginId: number = 0;
  password: string = "";


  constructor(private netbanking: NetBankingService, private router: Router) {
  }

  validation() {
    console.log(this.login);
    this.netbanking.getLoginByLoginId(this.login).subscribe(
      data => {
        this.login = data;
        console.log(this.login);
        this.homePage();
      }
    );
  }

  homePage() {
    if (this.login.password !== "null") {
      this.router.navigate(['homePage']);
    }
  }

}
