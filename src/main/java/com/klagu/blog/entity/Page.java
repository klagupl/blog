package com.klagu.blog.entity;

import javax.persistence.*;
import java.util.Set;

public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="pageid")
    private int pageId;

    @Column(name="pagename")
    private String pageName;

    @ManyToOne
    @JoinColumn(name="site_sitename")
    private Site site;

    @OneToMany(mappedBy = "page")
    private Set<Post> posts;

    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }
}
