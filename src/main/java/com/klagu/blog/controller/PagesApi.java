package com.klagu.blog.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.klagu.blog.entity.Page;
import com.klagu.blog.entity.Post;
import com.klagu.blog.entity.Widget;
import com.klagu.blog.service.PageService;
import com.klagu.blog.service.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class PagesApi {

    @Autowired
    private WidgetService widgetService;

    @Autowired
    private PageService pageService;

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
    public ResponseEntity<?> getPostsFromPage(@PathVariable int id){

        List<Post> posts=new ArrayList<>();
        posts=pageService.getPostsFromPage(id);
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


}
