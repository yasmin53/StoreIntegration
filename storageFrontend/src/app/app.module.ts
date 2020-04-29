import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import{FormsModule,ReactiveFormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import{HttpClientModule, HTTP_INTERCEPTORS}from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { StoreformComponent } from './storeform/storeform.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    StoreformComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
