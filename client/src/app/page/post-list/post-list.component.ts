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
  private maxPages;
  private posts:Array<object> = [];
  private postsPage:Array<object>=[];
  private olderDisabled:boolean;
  private newerDisabled:boolean;
  constructor(private postService:PostService,
    private route: ActivatedRoute) { }
  
  ngOnInit() {
    this.route.params
      .subscribe(
        (params: Params)=>{
          this.pageIdParam=+params['id'];
          this.getPosts(this.pageIdParam);
          this.pagination=1;
          
        }
      )
     
      console.log(this.pageIdParam);
  }

  public getPosts(postId:number, page?:number){
    this.postService.getPosts(postId).subscribe((data: Array<object>)=>{
      this.posts=data;
      this.maxPages=Math.ceil(this.posts.length/10)
      this.postsPage=this.posts.slice(0,9);
      console.log(data, this.maxPages);
      this.olderDisabled=false;
      this.newerDisabled=false;
      this.checkPageLinkButton();
    })
  }
  public getNewer(){
      if(this.pagination>1){
        this.pagination--;
        this.postsPage=this.posts.slice(this.pagination*10-10, this.pagination*10)
        console.log(this.pagination);
        window.scroll(0,0);
        this.checkPageLinkButton();
      }
      
        //this.getPosts(this.pageIdParam, this.pagination);
  }
  public getOlder(){
    if (this.pagination<this.maxPages){
      this.pagination++;
      this.postsPage=this.posts.slice(this.pagination*10-10, this.pagination*10)
     
      console.log(this.pagination, this.olderDisabled);
     
      window.scroll(0,0);
      this.checkPageLinkButton();
      //this.getPosts(this.pageIdParam, this.pagination);
    }

  }
  checkPageLinkButton(){
    if(this.pagination<=1){
      this.newerDisabled=true;
    }else{
    this.newerDisabled=false;
  }
  if(this.pagination>=this.maxPages){
    this.olderDisabled=true;
  }else{
      this.olderDisabled=false;
  }
}
}