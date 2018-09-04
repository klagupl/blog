package com.klagu.blog.service;

import com.klagu.blog.entity.Post;
import com.klagu.blog.repository.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private PostDAO postDAO;

    @Override
    public List<Post> searchPost(String term) {
        return postDAO.searchInPosts(term);

    }

    @Override
    public List<Post> sortByCategory(String category) {
        return postDAO.sortByCategory(category);
    }
}
