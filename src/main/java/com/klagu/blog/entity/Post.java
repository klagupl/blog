package com.klagu.blog.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.annotations.Indexed;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Indexed
@Table(name = "posts")
public class Post {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="postid")
    private int postId;


    @Column(name = "title")
    @Field(store = Store.NO)
    private String title;

    @Column(name="preview")
    @Field
    private String preview;

    @Column(name = "content")
    @Field
    private String content;

    @Column(name = "image")
    @Field
    private String image;


    @Column(name ="date")
    @Field
    private Date date;

    @IndexedEmbedded
    @ManyToOne
    @JoinColumn(name = "site_sitename")
    @JsonBackReference
    private Site site;

    @IndexedEmbedded
    @JsonIgnore
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name="categories_has_posts",
                    joinColumns = @JoinColumn(name="posts_postid"),
                    inverseJoinColumns = @JoinColumn(name="categories_categoryid")
    )
    private List<Category> tags = new ArrayList<>();


    public List<Category> getTags() {
        return tags;
    }

    public void setTags(List<Category> tags) {
        this.tags = tags;
    }

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


}
