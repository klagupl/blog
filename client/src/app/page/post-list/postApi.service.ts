import { HttpClientModule, HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PostService {
  postsChanged = new Subject<Array<object>>();
  private posts:Array<object> = [];

  URL='http://localhost:8087';
  constructor(private httpClient:HttpClient) { }

  getPosts(pageId:number){
    this.httpClient.get(`${this.URL}/api/page/`+pageId)
      .subscribe(
        (data: Array<object>)=>{
          this.setPosts(data);
        }
      )
  }
  getPostsByCategory(tagName:string){
    let params = new HttpParams().set('name', tagName);
    this.httpClient.get(`${this.URL}/api/category`,{params:params})
    .subscribe(
      (data: Array<object>)=>{
        this.setPosts(data);
      }
    )
  }
  setPosts(posts: Array<object>) {
    this.posts = posts;
    this.postsChanged.next(this.posts.slice());
  }
}
