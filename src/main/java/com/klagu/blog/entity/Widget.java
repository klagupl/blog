package com.klagu.blog.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="widgets")
public class Widget {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int widgetId;

   @Column(name="header")
   private String widgetHeader;

   @Column(name="body")
    private String widgetBody;

    @ManyToOne
    @JoinColumn(name = "site_sitename")
    @JsonBackReference
    private Site siteWidget;

    public int getWidgetId() {
        return widgetId;
    }

    public void setWidgetId(int widgetId) {
        this.widgetId = widgetId;
    }

    public String getWidgetHeader() {
        return widgetHeader;
    }

    public void setWidgetHeader(String widgetHeader) {
        this.widgetHeader = widgetHeader;
    }

    public String getWidgetBody() {
        return widgetBody;
    }

    public void setWidgetBody(String widgetBody) {
        this.widgetBody = widgetBody;
    }

    public Site getSiteWidget() {
        return siteWidget;
    }

    public void setSiteWidget(Site siteWidget) {
        this.siteWidget = siteWidget;
    }
}
