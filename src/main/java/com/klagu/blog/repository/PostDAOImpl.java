package com.klagu.blog.repository;

import com.klagu.blog.entity.Post;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class PostDAOImpl implements PostDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Post getPostById(int id) {
        return entityManager.find(Post.class,id);
    }

    @Override
    public List<Post> getAllPosts() {
        List<Post> posts = entityManager.createQuery("FROM Post", Post.class).getResultList();
        return posts;
    }
}
