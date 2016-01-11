package com.hzfh.fmp.controller.employee.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.RecruitFollow;
import com.hzfh.api.employee.model.query.RecruitFollowCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.employee.RecruitFollowModel;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.DateHelper;
import com.hzframework.helper.StringHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class AjaxRecruitFollowAction extends JqGridBaseAction<RecruitFollow> {
	private int rid;

	public void setRid(int rid) {
		this.rid = rid;
	}

	private RecruitFollow info;
	public RecruitFollow getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, RecruitFollow.class);
    }

    @Override
    public String execute(){
    	RecruitFollowCondition recruitFollowCondition = new RecruitFollowCondition();
    	if(this.rid!=0){
    		recruitFollowCondition.setRid(this.rid);
    	}else{
    		recruitFollowCondition.setRid(-1);
    	}
        recruitFollowCondition.setPageSize(this.getPageSize());
        recruitFollowCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        recruitFollowCondition.setSortItemList(sortItemList);
        PagedList<RecruitFollow> recruitFollowPagedList= RecruitFollowModel.getPagingList(recruitFollowCondition);
        this.setResultList(recruitFollowPagedList.getResultList());
        this.setPageCount(recruitFollowPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(recruitFollowPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(recruitFollowPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
			id = RecruitFollowModel.add(info);
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
                    if (RecruitFollowModel.update(info) > 0){
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
            this.info = RecruitFollowModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

}
