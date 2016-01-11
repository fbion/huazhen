package com.hzfh.api.baseInfo.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2015/4/20.
 */
public class LetterStep implements Serializable {
    private int id;
    private int editNo;
    private int letterNo;
    private Timestamp editTime;
    private String comment;
    private int operate;

    public int getOperate() {
        return operate;
    }

    public void setOperate(int operate) {
        this.operate = operate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEditNo() {
        return editNo;
    }

    public void setEditNo(int editNo) {
        this.editNo = editNo;
    }

    public int getLetterNo() {
        return letterNo;
    }

    public void setLetterNo(int letterNo) {
        this.letterNo = letterNo;
    }

    public Timestamp getEditTime() {
        return editTime;
    }

    public void setEditTime(Timestamp editTime) {
        this.editTime = editTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
