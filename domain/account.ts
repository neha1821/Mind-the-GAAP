import { Customer } from "./customer";

export class Account{
    date : string="";
    minimumBalance : number=0;
    currentBalance : number=0;
    rateOfInterest : number=0;
    accountId : number=0;
    accountType : string="";
    accountStatus : string="";
    overDraftBalance : number=0.0;
    customerId : Customer = new Customer();
}