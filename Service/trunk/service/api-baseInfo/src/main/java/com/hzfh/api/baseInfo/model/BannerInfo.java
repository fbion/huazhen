package com.hzfh.api.baseInfo.model;

import com.hzframework.contract.BaseEntity;
import java.sql.Timestamp;
import java.io.Serializable;
import java.util.Date;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/7/15 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


public class BannerInfo extends BaseEntity implements Serializable {
    private int locationNo;
    public int getLocationNo() {
        return locationNo;
    }
    public void setLocationNo(int locationNo) {
        this.locationNo = locationNo;
    }
    private int pageNo;
    public int getPageNo() {
        return pageNo;
    }
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
    private int exceptPageNo;
    public int getExceptPageNo() {
        return exceptPageNo;
    }
    public void setExceptPageNo(int exceptPageNo) {
        this.exceptPageNo = exceptPageNo;
    }
    private int type;
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    private String description;
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    private String title;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    private String text;
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    private String resrcurl;
    public String getResrcurl() {
        return resrcurl;
    }
    public void setResrcurl(String resrcurl) {
        this.resrcurl = resrcurl;
    }
    private String linkUrl;
    public String getLinkUrl() {
        return linkUrl;
    }
    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }
    private String script;
    public String getScript() {
        return script;
    }
    public void setScript(String script) {
        this.script = script;
    }
    private int priority;
    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    private Date startTime;
    public Date getStartTime() {
        return startTime;
    }
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    private Date endTime;
    public Date getEndTime() {
        return endTime;
    }
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    private int status;
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
}