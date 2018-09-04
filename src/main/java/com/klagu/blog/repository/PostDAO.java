package com.klagu.blog.repository;

import com.klagu.blog.entity.Post;

import java.util.List;

public interface PostDAO {

    Post getPostById(int id);
    List<Post> getAllPosts();
    List<Post> searchInPosts(String term);
    List<Post> sortByCategory(String category);
}
