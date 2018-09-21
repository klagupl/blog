package com.klagu.blog.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Indexed;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Indexed
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
    private Site sitepage;


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


    public Site getSitepage() {
        return sitepage;
    }

    public void setSitepage(Site sitepage) {
        this.sitepage = sitepage;
    }
}
