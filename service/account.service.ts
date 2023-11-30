import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Account } from '../domain/account';
import { Observable } from 'rxjs';
import { Customer } from '../domain/customer';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(private httpClient : HttpClient) { }

  addAccount(account : Account): Observable<boolean>{
    return this.httpClient.post<boolean>("http://localhost:8082/accountapi/accounts",account);
  }

  accountsByAccountStatus():Observable<Account[]>{
    return this.httpClient.get<Account[]>("http://localhost:8082/accountapi/accountsByStatus");
  }

  accountByAccountId(accountId:number):Observable<Account>{
    return this.httpClient.get<Account>("http://localhost:8082/accountapi/accountdetails/"+accountId);
  }

  changeAccountstatus(accountId : number):Observable<boolean>{
    return this.httpClient.get<boolean>("http://localhost:8082/accountapi/accountstatus/"+accountId);
  }

  accountsByCustomerId(customerId : number):Observable<Account[]>{
    return this.httpClient.get<Account[]>("http://localhost:8082/accountapi/account/"+customerId)
  }

  changeAmount(account:Account):Observable<Account>{
    return this.httpClient.put<Account>("http://localhost:8082/accountapi/account/amountTransfer",account);
  }

}