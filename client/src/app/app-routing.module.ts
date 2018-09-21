import { PageContentComponent } from './page/page-content/page-content.component';
import { Routes, RouterModule } from "../../node_modules/@angular/router";
import { PageComponent } from "./page/page.component";
import { NgModule, Component } from "@angular/core";
import { PostDetailComponent } from "./page/post-detail/post-detail.component";
import { PostListComponent } from "./page/post-list/post-list.component";

const routes: Routes =[
    {path: '', component: PostListComponent},
    {path: ':pageid',component:PageContentComponent},
    {path: 'post/:postid',component:PostDetailComponent},
    {path: 'tag', component: PageComponent, children:[
        {path: ':tagname',component: PostListComponent}
    ] }
    




];
@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule{
    
}