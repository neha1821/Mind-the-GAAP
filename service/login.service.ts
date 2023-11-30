import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Login } from '../domain/login';
import { Observable } from 'rxjs';
import { RouterTestingHarness } from '@angular/router/testing';


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private httpClient : HttpClient) { 

  }

  getLoginByLoginId(login : Login):Observable<Login>{

    return this.httpClient.post<Login>("http://localhost:8082/loginCRUDapi/login/details",login);

  }
  

  resetPasswordCount(loginId : number):Observable<boolean>{
    return this.httpClient.get<boolean>("http://localhost:8082/loginCRUDapi/admin/count/"+loginId);
  }

  loginsByLoginStatusBlocked():Observable<Login[]>{
    return this.httpClient.get<Login[]>("http://localhost:8082/loginCRUDapi/loginaccountsByStatus");
  }

  adminLoginByLoginId(loginId:number):Observable<Login>{
    return this.httpClient.get<Login>("http://localhost:8082/loginCRUDapi/admin/logindetails/"+loginId);
  }


  sendApprovalMail(login:Login):Observable<boolean>{
    return this.httpClient.post<boolean>("http://localhost:8082/loginCRUDapi/send/login",login);
  }


  createLoginByCustomerId(login:Login):Observable<Login>{
    return this.httpClient.post<Login>("http://localhost:8082/loginCRUDapi/setLogin",login);
  }

  getLoginByCustomerId(customerId:number):Observable<Login>{
    return this.httpClient.get<Login>("http://localhost:8082/loginCRUDapi/logindetails/customer/"+customerId);
  }

  updatePassword(login: Login):Observable<Login>{
    return this.httpClient.put<Login>("http://localhost:8082/loginCRUDapi/login/changePassword",login);
  }

  


 
}



