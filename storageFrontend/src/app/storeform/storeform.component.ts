import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Store } from '../models/store';
import { StoreserviceService } from '../services/storeservice.service';

@Component({
  selector: 'app-storeform',
  templateUrl: './storeform.component.html',
  styleUrls: ['./storeform.component.css']
})
export class StoreformComponent implements OnInit {

  storeForm:FormGroup;
  stores:Store[]=[];
  nameTaken: boolean = false;
  
  
    constructor(private formBuilder:FormBuilder,private storeservice:StoreserviceService,private router:Router) { }

  ngOnInit() {
  
    this.storeForm = this.formBuilder.group({
      storeName:['',Validators.required],
      storeId: ['', Validators.required],
      addressLine1: ['', Validators.required],
      addressLine2: ['', Validators.required],
      city:['',Validators.required],
      state: ['', Validators.required],
      country: ['', Validators.required],
      pinCode: ['', Validators.required],
      holidayOn:['',Validators.required],
      openCloseTimings: ['',Validators.required],
      contact: ['',Validators.required]
      
    });
    
}
addStore(){
  this.storeservice.saveStore(this.storeForm.value).subscribe(data=>{
    alert("store added successfully");
    this.router.navigate(['storelist']);
  });
}


checkStorenameExistOrNot() {
  this.nameTaken = false;
  for (let store of this.stores) {
      if (store.storeName == this.storeForm.get("storeName").value) {
          this.nameTaken = true;
          break;
      }
  }
}
}
