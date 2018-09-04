import { PostService } from './../post-list/postApi.service';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PostdetailApiService {
  URL='http://localhost:8087';
  private pageNum:number;
  constructor(private httpClient:HttpClient) { }


  getPost(postId:number){
    return this.httpClient.get(`${this.URL}/api/post/`+postId)
  }
}
