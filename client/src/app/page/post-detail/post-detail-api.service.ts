import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PostDetailApiService {
  URL='http://localhost:8087';
  constructor(private httpClient:HttpClient) { }

  getPostDetails(postId:number){
    
  }
}
