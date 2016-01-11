package com.hzfh.fmp.controller.product.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.product.model.PartnerIssuerFollow;
import com.hzfh.api.product.model.query.PartnerIssuerFollowCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.product.PartnerIssuerFollowModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxPartnerIssuerFollowAction extends JqGridBaseAction<PartnerIssuerFollow> {
	private PartnerIssuerFollow info;
	public PartnerIssuerFollow getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, PartnerIssuerFollow.class);
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
    public String execute() throws Exception{
    	PartnerIssuerFollowCondition partnerIssuerFollowCondition = new PartnerIssuerFollowCondition();
        partnerIssuerFollowCondition.setPageSize(this.getPageSize());
        partnerIssuerFollowCondition.setPageIndex(this.getPageIndex());

        if (!StringHelper.isNullOrEmpty(this.agentId)) {
        	partnerIssuerFollowCondition.setAgentId(Integer.parseInt(this.agentId));
		} else {
			partnerIssuerFollowCondition.setAgentId(0);
		}
		if (this.agentId == "0" || this.agentId.equals("0")) {
			partnerIssuerFollowCondition.setAgentId(-1);
		}

//		if (!StringHelper.isNullOrEmpty(this.agentType)) {
//			partnerIssuerFollowCondition.setAgentType(Integer.parseInt(this.agentType));
//		}
        
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        partnerIssuerFollowCondition.setSortItemList(sortItemList);

        PagedList<PartnerIssuerFollow> partnerIssuerFollowPagedList= PartnerIssuerFollowModel.getPagingList(partnerIssuerFollowCondition);
        this.setResultList(partnerIssuerFollowPagedList.getResultList());
        this.setPageCount(partnerIssuerFollowPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(partnerIssuerFollowPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(partnerIssuerFollowPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
		info.setEditUserNo(Integer.valueOf(UserHelper.getEditUserNo()));
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
			id = PartnerIssuerFollowModel.add(info);
            if (id > 0){
				this.setErrDesc(String.valueOf(id));                
            }else{
				this.setErrCode("add failed");
                this.setErrDesc("add failed");
			}
                
        }
        else
        {
            if (info.getId() == 0) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
            }
            else{
                if (this.getOper().equalsIgnoreCase("edit")) {                    
                    if (PartnerIssuerFollowModel.update(info) > 0){
						this.setErrDesc(String.valueOf(info.getId()));
                    }else{
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
            this.info = PartnerIssuerFollowModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

}
