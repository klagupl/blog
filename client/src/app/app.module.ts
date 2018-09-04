import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'
import { AppComponent } from './app.component';
import { NavigationComponent } from './navigation/navigation.component';
import { PageComponent } from './page/page.component';
import { PostListComponent } from './page/post-list/post-list.component';
import { SidebarComponent } from './page/sidebar/sidebar.component';
import { PostComponent } from './page/post-list/post/post.component';
import { AppRoutingModule } from './app-routing.module';
import { RouterModule } from '@angular/router';
import { PostDetailComponent } from './page/post-detail/post-detail.component';
import { SearchWidgetComponent } from './page/sidebar/search-widget/search-widget.component';
import { FormsModule } from '../../node_modules/@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    PageComponent,
    PostListComponent,
    SidebarComponent,
    PostComponent,
    PostDetailComponent,
    SearchWidgetComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
