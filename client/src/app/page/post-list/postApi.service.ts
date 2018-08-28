import { HttpClientModule, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PostService {
  URL='http://localhost:8087';
  constructor(private httpClient:HttpClient) { }

  getPosts(pageId:number){
    return this.httpClient.get(`${this.URL}/api/page/`+pageId)
  }
}
