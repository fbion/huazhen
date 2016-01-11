package com.hzfh.api.workFlow.model;

import java.io.Serializable;
import java.util.Date;

public class CommentVO implements Serializable {
 	private String checkName;//签字人
	private String checkTime;//审核时间
	private String checkPosition;
	private String checkComment;
	public String getCheckName() {
		return checkName;
	}
	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}

	public String getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	public String getCheckPosition() {
		return checkPosition;
	}
	public void setCheckPosition(String checkPosition) {
		this.checkPosition = checkPosition;
	}
	public String getCheckComment() {
		return checkComment;
	}
	public void setCheckComment(String checkComment) {
		this.checkComment = checkComment;
	}
	
}
