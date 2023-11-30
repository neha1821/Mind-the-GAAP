import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Customer } from '../domain/customer';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private httpClient : HttpClient) { }


  upload(username:string, file: any) : Observable<boolean>{

    console.log(file);

    // Create form data 
    const formData = new FormData();  

    // Store form name as "file" with file data 
    formData.append("file", file, file.name); 

    console.log(formData);

    return this.httpClient.put<boolean>("http://localhost:8082/customerapi/upload/"+username,formData);
  }


  addCustomer(customer : Customer): Observable<boolean>{
    return this.httpClient.post<boolean>("http://localhost:8082/customerapi/customers",customer);
  }

  getCustomerByUsername(customer : Customer) :Observable<Customer>{
    return this.httpClient.post<Customer>("http://localhost:8082/customerapi/customers/username",customer);
  }

  getAllCustomerByCustomerStatus():Observable <Customer[]>{
    return this.httpClient.get<Customer[]>("http://localhost:8082/customerapi/customers/customerStatus");
  }

  customerByCustomerId(customerId:number):Observable<Customer>{
    return this.httpClient.get<Customer>("http://localhost:8082/customerapi/customers/"+customerId);
  }

  changeCustomerstatus(customerId : number):Observable<boolean>{
    return this.httpClient.get<boolean>("http://localhost:8082/customerapi/customerstatus/"+customerId);
  }

  
}
