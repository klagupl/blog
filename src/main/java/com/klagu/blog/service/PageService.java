package com.klagu.blog.service;

import com.klagu.blog.entity.Page;
import com.klagu.blog.entity.Post;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PageService {

    List<Post> getPostsFromPage(int pageid);
    List<Page> getAllPages();



}
