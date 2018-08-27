package com.klagu.blog.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="pages")
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="pageid")
    private int pageId;

    @Column(name="pagename")
    private String pageName;

    @ManyToOne
    @JoinColumn(name="site_sitename")
    @JsonBackReference
    private Site site;

    @OneToMany(mappedBy = "page")
    @JsonManagedReference
    private List<Post> posts;

    public Page(){}

    public Page(int id,String pageName) {
        this.pageName = pageName;
        this.pageId = id;
    }

    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
