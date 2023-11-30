import { Customer } from "./customer";

export class Login{
   loginId : number =0;
   customerId : Customer=new Customer();
   password : string="";
   count : number =0;
   typeOfMember : string="";
   loginStatus : string="";
}