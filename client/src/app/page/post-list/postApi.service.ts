import { HttpClientModule, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PostService {
  URL='http://localhost:8080';
  constructor(private httpClient:HttpClient) { }

  getPosts(){
    return this.httpClient.get(`${this.URL}/api/page/2`)
  }
}
