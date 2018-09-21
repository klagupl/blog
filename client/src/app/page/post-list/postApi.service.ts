import { HttpClientModule, HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PostService {
  postsChanged = new Subject<Array<object>>();
  private posts:Array<object> = [];

  URL='http://localhost:8087';
  private pageNum:number;
  constructor(private httpClient:HttpClient) { }
  
  getPosts(pageId:number){

    this.httpClient.get(`${this.URL}/api/page/`+pageId)
      .subscribe(
        (data: Array<object>)=>{
          this.setPosts(data);
        }
      )
  }
  getAllPosts(){
    this.httpClient.get(`${this.URL}/api/posts`)
      .subscribe(
        (data:Array<object>)=>{
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
  searchPosts(searchTerm:string){
    let header=new HttpHeaders();
    header.set('Content-Type', 'text/plain')
    this.httpClient.post(`${this.URL}/api/search`,searchTerm,{headers:header})
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
  
  getPageNum(){
    return this.pageNum;
  }
}
