package com.klagu.blog.service;

import com.klagu.blog.entity.Post;
import com.klagu.blog.entity.Widget;
import com.klagu.blog.repository.WidgetDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class WIdgetServiceImpl implements WidgetService {

    @Autowired
    private WidgetDAO widgetDAO;
    @Override
    public List<Widget> getAllWidgets() {
       return widgetDAO.getAllWidgets();
    }
}
