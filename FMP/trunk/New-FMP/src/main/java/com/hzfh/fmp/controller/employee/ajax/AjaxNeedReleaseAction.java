package com.hzfh.fmp.controller.employee.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.NeedRelease;
import com.hzfh.api.employee.model.query.NeedReleaseCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.NeedReleaseModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxNeedReleaseAction extends JqGridBaseAction<NeedRelease> {
	private NeedRelease info;
	public NeedRelease getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, NeedRelease.class);
    }

    @Override
    public String execute() throws Exception{
    	NeedReleaseCondition needReleaseCondition = new NeedReleaseCondition();
        needReleaseCondition.setPageSize(this.getPageSize());
        needReleaseCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        needReleaseCondition.setSortItemList(sortItemList);

        PagedList<NeedRelease> needReleasePagedList= NeedReleaseModel.getPagingList(needReleaseCondition);
        this.setResultList(needReleasePagedList.getResultList());
        this.setPageCount(needReleasePagedList.getPagingInfo().getPageCount());
        this.setPageIndex(needReleasePagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(needReleasePagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
			id = NeedReleaseModel.add(info);
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
                    if (NeedReleaseModel.update(info) > 0){
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
            this.info = NeedReleaseModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

}
