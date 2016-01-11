package com.hzfh.api.baseInfo.model;

import com.hzframework.contract.BaseEntity;
import java.io.Serializable;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/7/16 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


public class BannerLocation extends BaseEntity implements Serializable {
    private int pageType;
    public int getPageType() {
        return pageType;
    }
    public void setPageType(int pageType) {
        this.pageType = pageType;
    }
    private int positionNo;
    public int getPositionNo() {
        return positionNo;
    }
    public void setPositionNo(int positionNo) {
        this.positionNo = positionNo;
    }
    private String width;
    
    private String height;
   
    public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}