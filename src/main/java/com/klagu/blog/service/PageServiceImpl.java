package com.klagu.blog.service;

import com.klagu.blog.entity.Page;
import com.klagu.blog.entity.Post;
import com.klagu.blog.repository.PageDAO;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PageServiceImpl implements PageService {
    @Autowired
    private PageDAO pageDAO;





    @Override
    public List<Page> getAllPages() {
        return pageDAO.getAllPages();
    }
}
