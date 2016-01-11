package com.hzfh.api.baseInfo.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/4/7 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class Letter extends BaseEntity implements Serializable {
	private int recipient;

    public int getRecipient() {
        return recipient;
    }

    public void setRecipient(int recipient) {
        this.recipient = recipient;
    }

    private String subject;
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	private String content;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	private Timestamp sendTime;
	public Timestamp getSendTime() {
		return sendTime;
	}
	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}
	private byte isRead;
	public byte getIsRead() {
		return isRead;
	}
	public void setIsRead(byte isRead) {
		this.isRead = isRead;
	}
	private Timestamp readTime;
	public Timestamp getReadTime() {
		return readTime;
	}
	public void setReadTime(Timestamp readTime) {
		this.readTime = readTime;
	}
	private byte level;
	public byte getLevel() {
		return level;
	}
	public void setLevel(byte level) {
		this.level = level;
	}
	private byte type;
	public byte getType() {
		return type;
	}
	public void setType(byte type) {
		this.type = type;
	}
    private int status;
    private int sendDeplicate;
    private int importantDegree;
    private int solveUserNo;
    private Timestamp solveTime;
    private String solvePlan;
    private int closeUserNo;
    private Timestamp closeTime;
    private Date expectFinishTime;


    public Date getExpectFinishTime() {
        return expectFinishTime;
    }

    public void setExpectFinishTime(Date expectFinishTime) {
        this.expectFinishTime = expectFinishTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSendDeplicate() {
        return sendDeplicate;
    }

    public void setSendDeplicate(int sendDeplicate) {
        this.sendDeplicate = sendDeplicate;
    }

    public int getImportantDegree() {
        return importantDegree;
    }

    public void setImportantDegree(int importantDegree) {
        this.importantDegree = importantDegree;
    }

    public int getSolveUserNo() {
        return solveUserNo;
    }

    public void setSolveUserNo(int solveUserNo) {
        this.solveUserNo = solveUserNo;
    }

    public Timestamp getSolveTime() {
        return solveTime;
    }

    public void setSolveTime(Timestamp solveTime) {
        this.solveTime = solveTime;
    }

    public String getSolvePlan() {
        return solvePlan;
    }

    public void setSolvePlan(String solvePlan) {
        this.solvePlan = solvePlan;
    }

    public int getCloseUserNo() {
        return closeUserNo;
    }

    public void setCloseUserNo(int closeUserNo) {
        this.closeUserNo = closeUserNo;
    }

    public Timestamp getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Timestamp closeTime) {
        this.closeTime = closeTime;
    }
}