package com.klagu.blog.repository;

import com.klagu.blog.entity.Post;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
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

    @Override
    public List<Post> searchInPosts(String term) {
      //  createIndex();
        FullTextEntityManager fullTextEntityManager =
                org.hibernate.search.jpa.Search.
                        getFullTextEntityManager(entityManager);

        QueryBuilder queryBuilder =
                fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder().forEntity(Post.class).get();

        org.apache.lucene.search.Query query =
                queryBuilder
                .keyword()
                .onFields("title","preview","content")
                .matching(term)
                .createQuery();

        org.hibernate.search.jpa.FullTextQuery jpaQuery =
                fullTextEntityManager.createFullTextQuery(query, Post.class);

        @SuppressWarnings("unchecked")
                List<Post> results = jpaQuery.getResultList();
        return results;
    }

    @Override
    public List<Post> sortByCategory(String category) {
        FullTextEntityManager fullTextEntityManager =
                org.hibernate.search.jpa.Search.
                        getFullTextEntityManager(entityManager);

        QueryBuilder queryBuilder =
                fullTextEntityManager.getSearchFactory()
                        .buildQueryBuilder().forEntity(Post.class).get();

        org.apache.lucene.search.Query query =
                queryBuilder
                        .keyword()
                        .onFields("tags.category")
                        .matching(category)
                        .createQuery();
        org.hibernate.search.jpa.FullTextQuery jpaQuery =
                fullTextEntityManager.createFullTextQuery(query, Post.class);

        @SuppressWarnings("unchecked")
        List<Post> results = jpaQuery.getResultList();
        return results;

    }


}
