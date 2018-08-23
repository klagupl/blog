package com.klagu.blog.repository;

import com.klagu.blog.entity.Page;
import com.klagu.blog.entity.Post;

import java.util.List;

public interface PageDAO {

    Page getPageById(int pageid);
    List<Page> getAllPages();
}
