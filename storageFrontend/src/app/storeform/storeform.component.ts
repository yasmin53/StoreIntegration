import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-storeform',
  templateUrl: './storeform.component.html',
  styleUrls: ['./storeform.component.css']
})
export class StoreformComponent implements OnInit {

  storeForm:FormGroup;
  
  
    constructor(private formBuilder:FormBuilder,private router:Router) { }

  ngOnInit() {
  
    this.storeForm = this.formBuilder.group({
      storeManagerName:['',Validators.required],
      id: ['', Validators.required],
      city:['',Validators.required],
      fromTime: ['', Validators.required],
      toTime:['',Validators.required],
      phone:['',Validators.required],
      holidaysPerMonth: ['',Validators.required]
      
    });

}
}
