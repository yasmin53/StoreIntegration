import { Component, OnInit } from '@angular/core';
import { Store } from '../models/store';
import { StoreserviceService } from '../services/storeservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-storelist',
  templateUrl: './storelist.component.html',
  styleUrls: ['./storelist.component.css']
})
export class StorelistComponent implements OnInit {
  
  stores:Store[];
  // constructor() { }

  // ngOnInit() {
  // }
 
  
  constructor(private storeservice:StoreserviceService,private router: Router)  { }

  ngOnInit(){
    this.storeservice.getAllStores().subscribe(data=>{
      this.stores=data;
    })
  }
 
  updateStore(store:Store){
    localStorage.removeItem('storeId');
    localStorage.setItem('storeId',store.storeId.toString());
    this.router.navigate(['storeupdate']);
  
  }
}
