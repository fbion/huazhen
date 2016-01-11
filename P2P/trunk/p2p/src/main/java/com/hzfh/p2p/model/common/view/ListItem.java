package com.hzfh.p2p.model.common.view;


import java.io.Serializable;

/**
 * Created by paul on 15-1-6.
 */
public class ListItem implements Serializable {
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getText() {

        return text;
    }

    public ListItem(String text, String value) {
        this.text = text;
        this.value = value;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String text;
    private String value;
}
