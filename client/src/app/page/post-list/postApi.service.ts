import { HttpClientModule, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PostService {
  URL='http://localhost:8087';
  private pageNum:number;
  constructor(private httpClient:HttpClient) { }
  
  getPosts(pageId:number){
    this.pageNum=pageId;
    return this.httpClient.get(`${this.URL}/api/page/`+pageId)
  }

  getPageNum(){
    return this.pageNum;
  }
}
