package com.klagu.blog.service;

import com.klagu.blog.entity.Post;
import com.klagu.blog.repository.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDAO postDAO;
    @Override
    public Post getPostById(int id) {
        return postDAO.getPostById(id);
    }

    @Override
    public List<Post> getAllPosts() {
        return postDAO.getAllPosts();
    }
}
