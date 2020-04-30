import { Injectable, Inject } from '@angular/core';
import { Observable } from 'rxjs';
import { Store } from '../models/store';
import { HttpClient } from '@angular/common/http';
import {STORES} from '../models/mock';
@Injectable({
  providedIn: 'root'
})
export class StoreserviceService {
  // naga=STORES;
  // getAllStores(){
  //   return this.naga;
  //  }
  //  constructor() { }
  httpUrl=" http://localhost:3000/stores";
   constructor(private httpClient:HttpClient) { }
   getAllStores():Observable<Store[]>{
    return this.httpClient.get<Store[]>(this.httpUrl);
  }
 
  saveStore(store:Store): Observable<Store>{
    return this.httpClient.post<Store>(this.httpUrl,store);
  }
  
  storeUpdateInfo(store:Store):Observable<Store>{
    return this.httpClient.put<Store>(this.httpUrl+store.storeId,store);
  }
  geStoreByID(storeId:number):Observable<Store>{
    return this.httpClient.get<Store>(this.httpUrl+storeId);
  }
}
