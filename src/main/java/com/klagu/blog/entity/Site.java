package com.klagu.blog.entity;

import javax.persistence.*;
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
    private Set<Page> pages;


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


}
