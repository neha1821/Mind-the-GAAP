import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from 'src/app/domain/customer';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.css']
})
export class CustomerDetailsComponent implements OnInit{

  customer:Customer=new Customer();
  customerId : number =0;
  constructor(private activatedRouter : ActivatedRoute, private customerService : CustomerService,private router : Router){


  }

  ngOnInit(): void {
    this.customerId =this.activatedRouter.snapshot.params['customerId'];
    this.customerService.customerByCustomerId(this.customerId).subscribe(
      data=>{
        this.customer=data;
      }
    );
    
    
   
    
  }
 goback(){
    
    this.router.navigate(['customerrequest'])
  }

}
