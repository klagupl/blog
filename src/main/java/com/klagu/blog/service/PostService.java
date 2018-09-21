package com.klagu.blog.service;

import com.klagu.blog.entity.Post;

import java.util.List;

public interface PostService {
    Post getPostById(int id);
    List<Post> getAllPosts();
}
