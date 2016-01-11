package com.hzfh.api.baseInfo.model;

import com.hzframework.contract.BaseEntity;
import java.sql.Timestamp;
import java.io.Serializable;
import java.util.Date;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/7/14 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


public class Announcement extends BaseEntity implements Serializable {
    private String subject;
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    private int isTop;
    public int getIsTop() {
        return isTop;
    }
    public void setIsTop(int isTop) {
        this.isTop = isTop;
    }
    private int isRed;
    public int getIsRed() {
        return isRed;
    }
    public void setIsRed(int isRed) {
        this.isRed = isRed;
    }
    private String linkurl;
    public String getLinkurl() {
        return linkurl;
    }
    public void setLinkurl(String linkurl) {
        this.linkurl = linkurl;
    }
    private String content;
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    private int type;
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
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
    
    private String typeValue;
	public String getTypeValue() {
		return typeValue;
	}
	public void setTypeValue(String typeValue) {
		this.typeValue = typeValue;
	}
    
}