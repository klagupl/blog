package com.klagu.blog.service;

import com.klagu.blog.entity.Page;
import com.klagu.blog.entity.Post;
import com.klagu.blog.repository.PageDAO;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PageServiceImpl implements PageService {
    @Autowired
    private PageDAO pageDAO;

    @Override
    public List<Post> getPostsFromPage(int pageid) {

        List<Post> posts=new ArrayList<>();
        if (pageDAO.getPageById(pageid)==null){
            return posts;
        }
        posts= pageDAO.getPageById(pageid).getPosts();
        return posts;
    }

    @Override
    public List<Post> getSelPostsFromPage(int pageid, int pagination) {
        List<Post> posts=new ArrayList<>();
        if (pageDAO.getPageById(pageid)==null){
            return posts;
        }
        posts= pageDAO.getPageById(pageid).getPosts();
        int numberOfPosts=pagination*10;
        List<Post> selectedPosts=new ArrayList<Post>(posts.subList(numberOfPosts,numberOfPosts+10));

        return posts;    }

    @Override
    public List<Page> getAllPages() {
        return pageDAO.getAllPages();
    }
}
