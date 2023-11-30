import { Component, OnInit } from '@angular/core';
import { Login } from '../domain/login';
import { LoginService } from '../service/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  login: Login = new Login();
  flag: boolean = false;
  flagBlock: boolean = false;
  verifyLogin: Login = new Login();
  alreadyBlocked: boolean = false;
  alert :boolean=false;



  constructor(private loginService: LoginService, private router: Router) {

  }

  ngOnInit(): void {
    if(this.login.loginId>0){
    this.loginService.adminLoginByLoginId(this.login.loginId).subscribe(
      data => {
        this.verifyLogin = data;
      }
    );
    }

  }

  

  loginCheck() {
    this.flag = true;
    this.ngOnInit();
  }

  userLogin() {

    this.login.password=this.verifyLogin.password;
    this.alert=true;

    this.loginService.getLoginByLoginId(this.login).subscribe(
      data => {
        this.login = data;
        console.log(this.login);

        // sessionStorage.setItem('employee', JSON.stringify(this.login));

       
        if (this.verifyLogin.loginStatus == 'BLOCKED') {
          this.alreadyBlocked = true;
          this.alert=false;
          this.router.navigate(['login']);
        }
        else {
          if (this.login.typeOfMember == 'ADMIN') {
            if (this.login.typeOfMember == 'ADMIN' && this.login.loginStatus == 'SUCCESS') {

             
               this.router.navigate(['adminhome']);

            }
            if (this.login.typeOfMember == 'ADMIN' && this.login.loginStatus != 'SUCCESS') {
              console.log("asho3k");

              this.router.navigate(['login']);
            }
          }
          else if (this.login.typeOfMember == 'CUSTOMER' && this.login.loginStatus == 'SUCCESS') {
            console.log("ashok");
            this.alert=false;
            sessionStorage.setItem("login","true")
            sessionStorage.setItem("loginid",this.login.loginId.toString())
            this.router.navigate(['customerhome', this.login.loginId])
           
           
          }

          else if (this.login.loginStatus == 'Fail') {
            if (this.login.loginStatus == 'Fail' && this.login.password == this.verifyLogin.password) {

              this.login.count=3;
              this.alert=false;
              this.flag = true;
              sessionStorage.setItem("login","true")
            sessionStorage.setItem("loginid",this.login.loginId.toString())
            this.router.navigate(['customerhome', this.login.loginId])
            }
            else {

              this.flagBlock = false;
              this.flag = true;
              this.alert=false;
              this.router.navigate(['login']);
            }
          }
          if (this.login.loginStatus == 'BLOCKED') {

            this.flag = false;
            this.alert=false;

            this.flagBlock = true;
            this.router.navigate(['login']);
          }
        }

        // if(this.login.designation == 'Hr') {
        //   this.router.navigate(['hrhome']);
        // }
        // if(this.login.designation == 'Interviewer') {
        //   this.router.navigate(['interviewerhome']);
        // }
      });
  }

  homePage() {
    this.router.navigate([''])
  }

}
