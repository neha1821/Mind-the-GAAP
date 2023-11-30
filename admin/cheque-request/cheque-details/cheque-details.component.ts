import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Cheque } from 'src/app/domain/cheque';
import { ChequeService } from 'src/app/service/cheque.service';

@Component({
  selector: 'app-cheque-details',
  templateUrl: './cheque-details.component.html',
  styleUrls: ['./cheque-details.component.css']
})
export class ChequeDetailsComponent implements OnInit{

  cheque:Cheque=new Cheque();
  chequeId : number =0;
  overDraftFlag:boolean=true;
  constructor(private activatedRouter : ActivatedRoute, private chequeService : ChequeService,private router : Router){


  }

  ngOnInit(): void {
    this.chequeId =this.activatedRouter.snapshot.params['chequeId'];
    
    this.chequeService.getChequeByChequeId(this.chequeId).subscribe(
      data=>{
        this.cheque=data;
        if(this.cheque.fromAccount.overDraftBalance>0){
          this.overDraftFlag=false;
        }
      }
    );


   
    
    
   
    
  }
 goback(){
    
    this.router.navigate(['chequerequest'])
  }

}

