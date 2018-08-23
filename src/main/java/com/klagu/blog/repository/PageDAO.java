package com.klagu.blog.repository;

import com.klagu.blog.entity.Post;

import java.util.List;

public interface PageDAO {

    List<Post> getPostsByPageId(int pageid);
}
