package com.klagu.blog.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="site")
public class Site {

    @Id
    @Column(name="sitename")
    private String siteName;

    @Column(name="description")
    private String description;

    @Column(name="owner")
    private String owner;

    @OneToMany(mappedBy = "site")
    @JsonManagedReference
    private List<Page> pages;

    @OneToMany(mappedBy = "siteWidget")
    @JsonManagedReference
    private List<Widget> widgets;

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }
}
