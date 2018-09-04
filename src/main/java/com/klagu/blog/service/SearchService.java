package com.klagu.blog.service;

import com.klagu.blog.entity.Post;

import java.util.List;

public interface SearchService {
    public List<Post> searchPost(String term);
    List<Post> sortByCategory(String category);

}
