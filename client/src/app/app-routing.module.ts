import { Routes, RouterModule } from "../../node_modules/@angular/router";
import { PageComponent } from "./page/page.component";
import { NgModule } from "@angular/core";
import { PostDetailComponent } from "./page/post-detail/post-detail.component";
import { PostListComponent } from "./page/post-list/post-list.component";

const routes: Routes =[
    {path: '', redirectTo:'/page/1', pathMatch: 'full'},
    {path: 'page',component:PageComponent,  children:[
        {path: ':id', component: PostListComponent},
        {path: ':id/post/:postid', component: PostDetailComponent}

    ]},
    




];
@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule{
    
}