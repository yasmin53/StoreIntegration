import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { StoreformComponent } from './storeform/storeform.component';
import { StorelistComponent } from './storelist/storelist.component';


const routes: Routes = [
  {path :'storeform',component:StoreformComponent},
  {path :'login',component:LoginComponent},
  {path :'storelist',component:StorelistComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
