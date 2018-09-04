import { PostService } from './../post-list/postApi.service';
import { ActivatedRoute, Params } from '@angular/router';
import { PostModel } from './../post-list/post.model';
import { PostdetailApiService } from './postdetail-api.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrls: ['./post-detail.component.css']
})
export class PostDetailComponent implements OnInit {
  private post:PostModel;
  private postIdParam;
  private pageNum:number;
  constructor(private postdetailApiService:PostdetailApiService, 
  private route:ActivatedRoute,
  private postService:PostService) { }

  ngOnInit() {
    window.scroll(0,0);
    this.route.params
      .subscribe(
        (params: Params)=>{
          this.postIdParam=+params['postid'];
          this.getPost(this.postIdParam);
          
        }
      )
     
      console.log(this.postIdParam);
  }
getPost(postId:number){
  // this.pageNum=this.postService.getPageNum();
  this.postdetailApiService.getPost(postId).subscribe((data:PostModel)=>{
    this.post=data;
    
  });

}
  
}
