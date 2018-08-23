package com.klagu.blog.service;

import com.klagu.blog.entity.Page;
import com.klagu.blog.entity.Post;
import com.klagu.blog.repository.PageDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PageServiceImpl implements PageService {
    @Autowired
    private PageDAO pageDAO;

    @Override
    public List<Post> getPostsFromPage(int pageid) {

        List<Post> posts=new ArrayList<>();
        posts.addAll(pageDAO.getPageById(pageid).getPosts());
        return posts;
    }

    @Override
    public List<Page> getAllPages() {
        return pageDAO.getAllPages();
    }
}
