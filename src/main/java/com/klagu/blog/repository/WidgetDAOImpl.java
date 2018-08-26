package com.klagu.blog.repository;

import com.klagu.blog.entity.Page;
import com.klagu.blog.entity.Widget;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Repository
public class WidgetDAOImpl implements WidgetDAO {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Widget> getAllWidgets() {
        List<Widget> widgets= entityManager.createQuery("FROM Widget",Widget.class).getResultList();
        return widgets;
    }
}
