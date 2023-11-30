import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from 'src/app/domain/customer';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-customer-request',
  templateUrl: './customer-request.component.html',
  styleUrls: ['./customer-request.component.css']
})
export class CustomerRequestComponent implements OnInit{

  allCustomers: Customer[] = [];
  newCustomers: Customer[] = [];

  flag:boolean=false;
 // customerId:number=0;

  constructor(private activatedRouter: ActivatedRoute, private customerService: CustomerService, private router: Router) {
  }
  ngOnInit(): void {
    this.customerService.getAllCustomerByCustomerStatus().subscribe(
      data=>{
        //this.allCustomers=data.reverse();
        this.newCustomers=data;
       
       // this.newCustomers[0]=this.allCustomers[0];
       //this.newCustomers[0]=data.reverse()[0];
      }

    );
  }


  Customerdetails(customerId: number) {
    this.router.navigate(['customerdetails',customerId]);
  }

  changeCustomerStatus(customerId: number) {
    this.customerService.changeCustomerstatus(customerId).subscribe(
      data=>{
        this.flag=data;
        this.reload();
      }
    );
    

  }

 



  reload(){
    this.customerService.getAllCustomerByCustomerStatus().subscribe(
      data=>{
        this.newCustomers=data;
      }
     );
    
  }

  

}
