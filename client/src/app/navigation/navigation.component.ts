import { NavApiServiceService } from './nav-api-service.service';
import { Component, OnInit } from '@angular/core';


export class NavModel{
  public pageId:number;
  public pageName:string;
  constructor(pageId:number,pageName:string){
    this.pageId=pageId;
    this.pageName=pageName;
  }
}
@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {
  private pages:Array<object> = [];
  constructor(private navApiServiceService:NavApiServiceService) { }

  ngOnInit() {
    this.getPages();

  }
  public getPages(){
    this.navApiServiceService.getPages().subscribe((data: Array<object>)=>{
      this.pages=data;
      console.log(data);
    })
  }
}
