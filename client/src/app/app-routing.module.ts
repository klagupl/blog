import { Routes, RouterModule } from "../../node_modules/@angular/router";
import { PageComponent } from "./page/page.component";
import { NgModule } from "@angular/core";

const routes: Routes =[
    {path: '', redirectTo:'/page/1', pathMatch: 'full'},
    {path: 'page/:id', component: PageComponent}




];
@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule{
    
}