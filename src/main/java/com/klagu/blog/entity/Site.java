package com.klagu.blog.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Indexed;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Indexed
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
    private List<Post> posts;

    @OneToMany(mappedBy = "sitepage")
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

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Widget> getWidgets() {
        return widgets;
    }

    public void setWidgets(List<Widget> widgets) {
        this.widgets = widgets;
    }
}
