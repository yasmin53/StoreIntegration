import { Injectable, Inject } from '@angular/core';
import { Observable } from 'rxjs';
import { Store } from '../models/store';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class StoreserviceService {
  
  httpUrl ='http:/localhost:8765/store-service/store';
   constructor(private httpClient:HttpClient) { }
   getAllStores():Observable<Store[]>{
    return this.httpClient.get<Store[]>(this.httpUrl);
  }

 saveStore(store:Store):Observable<Store>{
    return this.httpClient.post<Store>(this.httpUrl,store);
  }

  updateStore(store:Store):Observable<Store>{
    return this.httpClient.put<Store>(this.httpUrl,store);
  }

  getStoreByID(storeId:number):Observable<Store>{
    return this.httpClient.get<Store>('http:/localhost:8765/store-service/store/${storeId}');
 


}

}
