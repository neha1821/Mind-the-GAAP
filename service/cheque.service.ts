import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cheque } from '../domain/cheque';
import { Account } from '../domain/account';

@Injectable({
  providedIn: 'root'
})
export class ChequeService {

  constructor(private httpClient : HttpClient) { }

  getAllReceivedCheque(account:Account):Observable<Cheque[]>{
    return this.httpClient.post<Cheque[]>("http://localhost:8082/chequeCRUDapi/getall/receive/cheque",account);
  }

  addNewCheque(cheque:Cheque):Observable<boolean>{
    return this.httpClient.post<boolean>('http://localhost:8082/chequeCRUDapi/add',cheque);
  }

  updateCheque(cheque:Cheque):Observable<Cheque>{
    return this.httpClient.put<Cheque>('http://localhost:8082/chequeCRUDapi/update',cheque);
  }

  getAllChequeStatusAcvtive():Observable<Cheque[]>{
    return this.httpClient.get<Cheque[]>("http://localhost:8082/chequeCRUDapi/getall/active");
  }

  getChequeByChequeId(chequeId:number):Observable<Cheque>{
    return this.httpClient.get<Cheque>("http://localhost:8082/chequeCRUDapi/getone/"+chequeId);
  }

  sendApprovalMail(cheque:Cheque):Observable<boolean>{
    return this.httpClient.post<boolean>("http://localhost:8082/chequeCRUDapi/send/cheque",cheque);
  }

  updateChequeAmount(cheque:Cheque):Observable<Cheque>{
    return this.httpClient.put<Cheque>("http://localhost:8082/chequeCRUDapi/updatecheque",cheque);
  }
  
 
}
