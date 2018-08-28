import { PostService } from './postApi.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
@Component({
  selector: 'app-post-list',
  templateUrl: './post-list.component.html',
  styleUrls: ['./post-list.component.css']
})
export class PostListComponent implements OnInit {
  private pagination:number;
  private pageIdParam:number;
  private posts:Array<object> = [];
  constructor(private postService:PostService,
    private route: ActivatedRoute) { }
  
  ngOnInit() {
    this.route.params
      .subscribe(
        (params: Params)=>{
          this.pageIdParam=+params['id'];
          this.getPosts(this.pageIdParam);
          this.pagination=0;
        }
      )
     
      console.log(this.pageIdParam);
  }

  public getPosts(postId:number, page?:number){
    this.postService.getPosts(postId).subscribe((data: Array<object>)=>{
      this.posts=data;
      console.log(data);
    })
  }
  public getNewer(){
      if(this.pagination>0){
        this.pagination--;
        console.log(this.pagination);
      }
        //this.getPosts(this.pageIdParam, this.pagination);
  }
  public getOlder(){
    if (this.pagination>=0){
      this.pagination++;
      console.log(this.pagination);
      //this.getPosts(this.pageIdParam, this.pagination);
    }

  }
}
