import { Component, OnInit } from '@angular/core';
import { RouterLink, Router } from '@angular/router';
import { Validators, FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

 

  loginForm: FormGroup;
  
  //currentUser: User;

  constructor(private router:Router,private formbuilder:FormBuilder) { }
ngOnInit() {
  this.loginForm=this.formbuilder.group({
    username:['',Validators.required],
    password:['',Validators.required]
  });

}
}
