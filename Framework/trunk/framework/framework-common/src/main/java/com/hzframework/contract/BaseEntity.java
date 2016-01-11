package com.hzframework.contract;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by paul on 14-12-24.
 */
public abstract class BaseEntity implements Serializable {

	private int id;
	private int inUserNo;
	private Timestamp inTime;
	private int editUserNo;
	private Timestamp editTime;
	private String editComment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getInUserNo() {
		return inUserNo;
	}

	public void setInUserNo(int inUserNo) {
		this.inUserNo = inUserNo;
	}

	public Timestamp getInTime() {
		return inTime;
	}

	public void setInTime(Timestamp inTime) {
		this.inTime = inTime;
	}

	public int getEditUserNo() {
		return editUserNo;
	}

	public void setEditUserNo(int editUserNo) {
		this.editUserNo = editUserNo;
	}

	public Timestamp getEditTime() {
		return editTime;
	}

	public void setEditTime(Timestamp editTime) {
		this.editTime = editTime;
	}

	public String getEditComment() {
		return editComment;
	}

	public void setEditComment(String editComment) {
		this.editComment = editComment;
	}

}
