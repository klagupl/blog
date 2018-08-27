import { PostService } from './postApi.service';
import { Component, OnInit } from '@angular/core';
@Component({
  selector: 'app-post-list',
  templateUrl: './post-list.component.html',
  styleUrls: ['./post-list.component.css']
})
export class PostListComponent implements OnInit {

  private posts:Array<object> = [];
  constructor(private postService:PostService) { }

  ngOnInit() {
    this.getPosts();
  }

  public getPosts(){
    this.postService.getPosts().subscribe((data: Array<object>)=>{
      this.posts=data;
      console.log(data);
    })
  }
}
