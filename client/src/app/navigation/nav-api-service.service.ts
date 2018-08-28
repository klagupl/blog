import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class NavApiServiceService {
  URL='http://localhost:8087';
  constructor(private httpClient:HttpClient) { }
  getPages(){
    return this.httpClient.get(`${this.URL}/api/pages`);
  }
  
}
