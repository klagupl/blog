package com.klagu.blog.controller;


import com.klagu.blog.entity.Post;
import com.klagu.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class PostApi {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/post/{postId}")
    public ResponseEntity<?> getPostById(@PathVariable int postId){
        Post post = postService.getPostById(postId);
        if(post!=null){
            return new ResponseEntity<Post>(post, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
