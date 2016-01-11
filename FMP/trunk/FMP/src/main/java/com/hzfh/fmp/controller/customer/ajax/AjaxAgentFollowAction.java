package com.hzfh.fmp.controller.customer.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.customer.model.AgentFollow;
import com.hzfh.api.customer.model.query.AgentFollowCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.customer.AgentFollowModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AjaxAgentFollowAction extends JqGridBaseAction<AgentFollow> {
	private AgentFollow info;

	public AgentFollow getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = JSON.parseObject(info, AgentFollow.class);
	}

	private String agentId;
	private String agentType;

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getAgentType() {
		return agentType;
	}

	public void setAgentType(String agentType) {
		this.agentType = agentType;
	}

	@Override
	public String execute() throws Exception {
		AgentFollowCondition agentFollowCondition = new AgentFollowCondition();
		agentFollowCondition.setPageSize(this.getPageSize());
		agentFollowCondition.setPageIndex(this.getPageIndex());

		if (!StringHelper.isNullOrEmpty(this.agentId)) {
			agentFollowCondition.setAgentId(Integer.parseInt(this.agentId));
		} else {
			agentFollowCondition.setAgentId(0);
		}
		if (this.agentId == "0" || this.agentId.equals("0")) {
			agentFollowCondition.setAgentId(-1);
		}

		if (!StringHelper.isNullOrEmpty(this.agentType)) {
			agentFollowCondition.setAgentType(Integer.parseInt(this.agentType));
		}

		List<SortItem> sortItemList = new ArrayList<SortItem>();
		SortItem sortItem = new SortItem();
		sortItem.setSortFeild(this.getSidx());
		sortItem.setSortType(this.getSortType());
		sortItemList.add(sortItem);
		agentFollowCondition.setSortItemList(sortItemList);

		PagedList<AgentFollow> agentFollowPagedList = AgentFollowModel
				.getPagingList(agentFollowCondition);
		this.setResultList(agentFollowPagedList.getResultList());
		this.setPageCount(agentFollowPagedList.getPagingInfo().getPageCount());
		this.setPageIndex(agentFollowPagedList.getPagingInfo().getPageIndex());
		this.setRecordCount(agentFollowPagedList.getPagingInfo()
				.getTotalCount());
		return SUCCESS;
	}

	public String edit() {
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
			info.setInUserNo(UserHelper.getEditUserNo());
			id = AgentFollowModel.add(info);
			if (id > 0) {
				this.setErrDesc(String.valueOf(id));
			} else {
				this.setErrCode("add failed");
				this.setErrDesc("add failed");
			}

		} else {
			if (info.getId() == 0) {
				this.setErrCode("NoID");
				this.setErrDesc("NoID");
			} else {
				if (this.getOper().equalsIgnoreCase("edit")) {
					if (AgentFollowModel.update(info) > 0) {
						this.setErrDesc(String.valueOf(info.getId()));
					} else {
						this.setErrCode("update failed");
						this.setErrDesc("update failed");
					}

				}
			}
		}

		return SUCCESS;
	}

	public String getInfoById() {
		if (StringHelper.isNullOrEmpty(this.getId())) {
			this.setErrCode("NoID");
			this.setErrDesc("NoID");
		} else {
			this.info = AgentFollowModel
					.getInfo(Integer.parseInt(this.getId()));
			if (this.info == null) {
				this.setErrCode("No Info");
				this.setErrDesc("No Info");
			}
		}

		return SUCCESS;
	}

	private String hideId;
	private String followType;
	private String followTime;
	private String contentFollow;
	private String editComment;
	private String contacts;
	private String position;
	private String result;
	private String nexttime;
	private String productNo;

	public String getHideId() {
		return hideId;
	}

	public void setHideId(String hideId) {
		this.hideId = hideId;
	}

	public String getFollowType() {
		return followType;
	}

	public void setFollowType(String followType) {
		this.followType = followType;
	}

	public String getFollowTime() {
		return followTime;
	}

	public void setFollowTime(String followTime) {
		this.followTime = followTime;
	}

	public String getContentFollow() {
		return contentFollow;
	}

	public void setContentFollow(String contentFollow) {
		this.contentFollow = contentFollow;
	}

	public String getEditComment() {
		return editComment;
	}

	public void setEditComment(String editComment) {
		this.editComment = editComment;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getNexttime() {
		return nexttime;
	}

	public void setNexttime(String nexttime) {
		this.nexttime = nexttime;
	}

	public void setInfo(AgentFollow info) {
		this.info = info;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String ajaxSetFollowInfo() {
		AgentFollow af = new AgentFollow();
		if (!StringHelper.isNullOrEmpty(this.productNo)) {
			af.setProductNo(Integer.parseInt(this.productNo));
		}
		if (!StringHelper.isNullOrEmpty(this.followType)) {
			af.setType(Byte.valueOf(this.followType));
		}
		if (!StringHelper.isNullOrEmpty(this.followTime)) {
			af.setTime(Timestamp.valueOf(this.followTime));
		}
		if (!StringHelper.isNullOrEmpty(this.nexttime)) {
			af.setNexttime(Timestamp.valueOf(this.nexttime));
		}
		if (!StringHelper.isNullOrEmpty(this.agentId)) {
			af.setAgentNo(Integer.parseInt(this.agentId));
		}
		if (!StringHelper.isNullOrEmpty(this.agentType)) {
			af.setAgentType(Byte.parseByte(this.agentType));
		}
		if (!StringHelper.isNullOrEmpty(this.contentFollow)) {
			af.setContent(this.contentFollow);
		}
		if (!StringHelper.isNullOrEmpty(this.result)) {
			af.setResult(this.result);
		}
		if (!StringHelper.isNullOrEmpty(this.editComment)) {
			af.setEditComment(this.editComment);
		}
		if (!StringHelper.isNullOrEmpty(this.contacts)) {
			af.setContacts(this.contacts);
		}
		if (!StringHelper.isNullOrEmpty(this.position)) {
			af.setPosition(this.position);
		}
		af.setEditUserNo(UserHelper.getEditUserNo());
		int result = -1;
		if (!StringHelper.isNullOrEmpty(this.hideId)) {
			af.setId(Integer.parseInt(this.hideId));
			result = AgentFollowModel.update(af);
		} else {
			af.setInUserNo(UserHelper.getEditUserNo());
			result = AgentFollowModel.add(af);
		}
		if (result < 0) {
			this.setErrCode("NO");
			this.setErrDesc("提交失败！");
		} else {
			this.setErrCode("OK");
			this.setErrDesc("提交成功！");
		}

		return SUCCESS;
	}

	private String followId;
	private AgentFollow agentFollow;

	public String getFollowId() {
		return followId;
	}

	public void setFollowId(String followId) {
		this.followId = followId;
	}

	public AgentFollow getAgentFollow() {
		return agentFollow;
	}

	public void setAgentFollow(AgentFollow agentFollow) {
		this.agentFollow = agentFollow;
	}

	public String ajaxGetFollowInfoById() {
		int id = -1;
		if (!StringHelper.isNullOrEmpty(this.followId)) {
			id = Integer.parseInt(this.followId);
		}
		if (id != -1) {
			this.agentFollow = AgentFollowModel.getInfo(id);
		} else {
			this.agentFollow = null;
		}

		return SUCCESS;
	}

}
