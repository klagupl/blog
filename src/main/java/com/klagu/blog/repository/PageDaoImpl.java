package com.klagu.blog.repository;

import com.klagu.blog.entity.Page;
import com.klagu.blog.entity.Post;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Repository
public class PageDaoImpl implements PageDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page getPageById(int pageid) {
        return entityManager.find(Page.class, pageid);
    }

    @Override
    public List<Page> getAllPages() {
        List<Page> pages= entityManager.createQuery("SELECT new  Page(pageId, pageName) FROM Page",Page.class).getResultList();
        return pages;
    }

}
