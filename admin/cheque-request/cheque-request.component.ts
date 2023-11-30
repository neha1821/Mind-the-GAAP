import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Cheque } from 'src/app/domain/cheque';
import { Transactions } from 'src/app/domain/transactions';
import { AccountService } from 'src/app/service/account.service';
import { ChequeService } from 'src/app/service/cheque.service';
import { CustomerService } from 'src/app/service/customer.service';
import { TransactionService } from 'src/app/service/transaction.service';

@Component({
  selector: 'app-cheque-request',
  templateUrl: './cheque-request.component.html',
  styleUrls: ['./cheque-request.component.css']
})
export class ChequeRequestComponent implements OnInit{

  allCheque: Cheque[] = [];
  newCheque: Cheque[] = [];
  cheque:Cheque=new Cheque();
  newChequeCleared:Cheque=new Cheque();
  transaction:Transactions=new Transactions();

  flag:boolean=false;
  fifty:number=50;
  updatedCheque:Cheque=new Cheque();
  updatedChequeBounce:Cheque=new Cheque();
 // customerId:number=0;

  constructor(private activatedRouter: ActivatedRoute,private transactionService : TransactionService,private accountService:AccountService,private chequeService:ChequeService, private customerService: CustomerService, private router: Router) {

  }
  ngOnInit(): void {
    this.chequeService.getAllChequeStatusAcvtive().subscribe(
      data=>{
        this.allCheque=data;
        console.log(this.allCheque.reverse()[0].amount)
        
        
        //this.allCustomers=data.reverse();
     
       // this.newCustomers[0]=this.allCustomers[0];
       //this.newCustomers[0]=data.reverse()[0];
      }

    );
  }
  

  Chequedetails(customerId: number) {
    this.router.navigate(['chequedetails',customerId]);
  }

  changeChequeStatusBounced(chequeId: number) {

    this.chequeService.getChequeByChequeId(chequeId).subscribe(
      data=>{
        console.log(this.cheque)
        this.cheque=data;
        console.log(this.cheque)
        this.cheque.chequeStatus='BOUNCE';
        console.log(this.cheque.fromAccount.minimumBalance);
        this.chequeService.updateCheque(this.cheque).subscribe(
          data=>{
            this.updatedChequeBounce=data;
           
            console.log(this.cheque.fromAccount.currentBalance);
            console.log(this.cheque.chequeStatus)
            if(this.updatedChequeBounce.fromAccount.accountType=='CURRENT_ACCOUNT'){
              if(this.updatedChequeBounce.fromAccount.currentBalance>=50){
                console.log("current balance")
                this.updatedChequeBounce.fromAccount.currentBalance=this.cheque.fromAccount.currentBalance-this.fifty;
              }
              else{
                console.log("overdraft")
                this.updatedChequeBounce.fromAccount.overDraftBalance=this.cheque.fromAccount.overDraftBalance-this.fifty;
              }  
            }
            else{
              this.updatedChequeBounce.fromAccount.currentBalance=this.cheque.fromAccount.currentBalance-this.fifty;
            }
            console.log(this.cheque.fromAccount.currentBalance);
            this.chequeService.sendApprovalMail(this.updatedChequeBounce).subscribe(
              data=>{
                console.log(data);
                this.reload();
              }
            );
          }

        );
        
      }
    );
   
    

  }

  changeChequeStatusCleared(chequeId:number){
    this.chequeService.getChequeByChequeId(chequeId).subscribe(
      data=>{
        this.newChequeCleared=data;
        this.newChequeCleared.chequeStatus='CLEARED';
        this.chequeService.updateChequeAmount(this.newChequeCleared).subscribe(
          data=>{
            this.updatedCheque=data;
            this.reload();
            console.log(this.cheque.fromAccount.minimumBalance);
            this.accountService.changeAmount(this.updatedCheque.fromAccount).subscribe(
              data=>{
                console.log(data);
                this.accountService.changeAmount(this.updatedCheque.toAccount).subscribe(
                  data=>{
                    console.log(data);
                    console.log(this.newChequeCleared);
                    console.log(this.updatedCheque)
                    this.chequeService.updateCheque(this.updatedCheque).subscribe(
                      data=>{
                        this.updatedCheque = data;
                        this.transaction.fromAccount=this.updatedCheque.fromAccount;
                        this.transaction.toAccount=this.updatedCheque.toAccount;
                        this.transaction.fromAccountId=this.updatedCheque.fromAccount.accountId;
                        this.transaction.toAccountId=this.transaction.toAccount.accountId;
                        this.transaction.amount=this.updatedCheque.amount;
                        this.transaction.transactionStatus='SUCCESS';
                        this.transaction.type='CHEQUE';
                        this.transactionService.addTransaction(this.transaction).subscribe(
                          data=>{
                            console.log(data);
                            this.reload();
                          }
                        );
                        
                        

                      }
                    );
                  }
                );
              }
            );

          }
        );
      }
    );

  }

  changeChequeStatusFailed(chequeId:number){
    this.chequeService.getChequeByChequeId(chequeId).subscribe(
      data=>{
        this.cheque=data;
        this.cheque.chequeStatus='FAILED';
        this.chequeService.updateCheque(this.cheque).subscribe(
          data=>{
            this.cheque=data;
            this.reload();
          }
        );
      }
    );
  }

  bounceHidden(cheque:Cheque):boolean{
    
    if(cheque.fromAccount.overDraftBalance>0){
      if(cheque.fromAccount.overDraftBalance<=cheque.amount){
        return false;
      }
      return true;
    }
    else 
    {
      if(cheque.fromAccount.currentBalance<=cheque.amount)
    {
      return false;

    }
    return true;
  }


  }

  failedHidden(cheque:Cheque): boolean{
    if(cheque.fromAccount.overDraftBalance>0){
      if(cheque.fromAccount.overDraftBalance>=cheque.amount){
        return false;
      }
      return true;
    }
    else 
    {
      if(cheque.fromAccount.currentBalance>=cheque.amount)
    {
      return false;

    }
    return true;
  }


  }


 



  reload(){
    this.chequeService.getAllChequeStatusAcvtive().subscribe(
      data=>{
        this.allCheque=data;
      }
    );
    
  }

}