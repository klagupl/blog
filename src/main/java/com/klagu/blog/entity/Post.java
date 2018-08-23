package com.klagu.blog.entity;

import javax.persistence.*;
import java.util.Date;

public class Post {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="postid")
    private int postId;


    @Column(name = "title")
    private String title;

    @Column(name="preview")
    private String preview;

    @Column(name = "content")
    private String content;

    @Column(name = "image")
    private String image;

    @Column(name ="date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "pages_pageid")
    private Page page;


    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
