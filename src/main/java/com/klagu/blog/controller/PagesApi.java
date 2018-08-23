package com.klagu.blog.controller;

import com.klagu.blog.entity.Page;
import com.klagu.blog.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class PagesApi {

    @Autowired
    private PageService pageService;

    @GetMapping(value="/pages")
    public List<Page> getPages(){
        return pageService.getAllPages();
    }
    
}
