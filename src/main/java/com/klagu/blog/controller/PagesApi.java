package com.klagu.blog.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.klagu.blog.entity.Page;
import com.klagu.blog.entity.Post;
import com.klagu.blog.entity.Widget;
import com.klagu.blog.model.SearchTerms;
import com.klagu.blog.service.PageService;
import com.klagu.blog.service.SearchService;
import com.klagu.blog.service.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class PagesApi {

    @Autowired
    private WidgetService widgetService;

    @Autowired
    private PageService pageService;

    @Autowired
    private SearchService searchService;

    @GetMapping(value="/pages")
    public ResponseEntity<?> getPages(){
        List<Page> pages= new ArrayList<>();
        pages=pageService.getAllPages();
        if(!pages.isEmpty()) {
            System.out.println(pages);
            return new ResponseEntity<List<Page>>(pages, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/page/{id}")
    public ResponseEntity<?> getPostsFromPage(@PathVariable int id,
                                              @RequestParam(value = "p", required = false) Integer pageId){

        List<Post> posts=new ArrayList<>();
        if(pageId==null) {
            posts = pageService.getPostsFromPage(id);
        }else{
            posts=pageService.getSelPostsFromPage(id,pageId);
        }
        if(!posts.isEmpty()){
            return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @GetMapping(value="/widgets")
    public ResponseEntity<?> getAllWidgets(){
        List<Widget> widgets =new ArrayList<>();
        widgets = widgetService.getAllWidgets();

        if(!widgets.isEmpty()) {
            return new ResponseEntity<List<Widget>>(widgets, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
    @PostMapping(value = "/search")
    public ResponseEntity<?> searchPost(@RequestBody SearchTerms searchTerms){
        List<Post> postFound= new ArrayList<>();
        postFound=searchService.searchPost(searchTerms.getSearchTerm());
        if(!postFound.isEmpty()) {
            System.out.println(postFound);
            return new ResponseEntity<List<Post>>(postFound, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @GetMapping(value = "/category")
    public ResponseEntity<?> sortByCategory(@RequestParam(value = "name") String categoryName){
        List<Post> postFound= new ArrayList<>();
        postFound=searchService.sortByCategory(categoryName);
        if(!postFound.isEmpty()) {
            System.out.println(postFound);
            return new ResponseEntity<List<Post>>(postFound, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}
