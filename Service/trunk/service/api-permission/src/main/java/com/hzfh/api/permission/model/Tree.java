package com.hzfh.api.permission.model;

import java.io.Serializable;

/**
 * Created by 磊 on 2015/11/6.
 */
public class Tree implements Serializable{
    private int id;
    private String url;
    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
