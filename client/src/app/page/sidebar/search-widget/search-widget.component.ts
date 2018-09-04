import { PostService } from './../../post-list/postApi.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-search-widget',
  templateUrl: './search-widget.component.html',
  styleUrls: ['./search-widget.component.css']
})
export class SearchWidgetComponent implements OnInit {
  searchTerm:string;
  @ViewChild('f') signupForm: NgForm;
  constructor(private postService:PostService) { }

  ngOnInit() {

  }

  onSubmit(){
    this.searchTerm=this.signupForm.value.searchTerm;
    this.postService.searchPosts(this.searchTerm);
    console.log(this.searchTerm)
  }
}
