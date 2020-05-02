import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { StoreserviceService } from '../services/storeservice.service';
import { Store } from '../models/store';
import { Router } from '@angular/router';

@Component({
  selector: 'app-storeupdate',
  templateUrl: './storeupdate.component.html',
  styleUrls: ['./storeupdate.component.css']
})
export class StoreupdateComponent implements OnInit {
  storeUpdate:FormGroup;
  constructor(private formBuilder:FormBuilder,private storeservice:StoreserviceService,private router:Router) { }
ngOnInit(){
   this.storeUpdate=this.formBuilder.group({
      storeName:['',Validators.required],
      storeId:[],
      addressLine1:['', Validators.required],
      addressLine2:['', Validators.required],
      city:['',Validators.required],
      state:['', Validators.required],
      country:['', Validators.required],
      pincode:['', Validators.required],
      holidayOn:['',Validators.required],
      openCloseTimings:['',Validators.required],
      contact:['',Validators.required]
      
    });
    const id=localStorage.getItem('storeID') ;
   if(+id>0){
this.storeservice.getStoreByID(+id).subscribe(store=>{
this.storeUpdate.patchValue(store);
});
   }
}
updateThisStore(store:Store){
  this.storeservice.updateStore(this.storeUpdate.value).subscribe(store=>{   
      this.router.navigate(['storeupdate']);
   })
 }
}
