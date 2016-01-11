package com.hzfh.fmp.controller.employee.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.TempRecruitDetail;
import com.hzfh.api.employee.model.query.TempRecruitDetailCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.TempRecruitDetailModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxTempRecruitDetailAction extends JqGridBaseAction<TempRecruitDetail> {
	private TempRecruitDetail info;
	public TempRecruitDetail getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, TempRecruitDetail.class);
    }

    @Override
    public String execute() throws Exception{
    	TempRecruitDetailCondition tempRecruitDetailCondition = new TempRecruitDetailCondition();
        tempRecruitDetailCondition.setPageSize(this.getPageSize());
        tempRecruitDetailCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        tempRecruitDetailCondition.setSortItemList(sortItemList);

        PagedList<TempRecruitDetail> tempRecruitDetailPagedList= TempRecruitDetailModel.getPagingList(tempRecruitDetailCondition);
        this.setResultList(tempRecruitDetailPagedList.getResultList());
        this.setPageCount(tempRecruitDetailPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(tempRecruitDetailPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(tempRecruitDetailPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
			id = TempRecruitDetailModel.add(info);
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
                    if (TempRecruitDetailModel.update(info) > 0){
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
            this.info = TempRecruitDetailModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

}
