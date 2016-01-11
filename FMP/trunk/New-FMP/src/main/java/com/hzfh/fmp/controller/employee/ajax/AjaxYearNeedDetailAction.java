package com.hzfh.fmp.controller.employee.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.YearNeedDetail;
import com.hzfh.api.employee.model.query.YearNeedDetailCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.YearNeedDetailModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxYearNeedDetailAction extends JqGridBaseAction<YearNeedDetail> {
	private YearNeedDetail info;
	public YearNeedDetail getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, YearNeedDetail.class);
    }

    @Override
    public String execute() throws Exception{
    	YearNeedDetailCondition yearNeedDetailCondition = new YearNeedDetailCondition();
        yearNeedDetailCondition.setPageSize(this.getPageSize());
        yearNeedDetailCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        yearNeedDetailCondition.setSortItemList(sortItemList);

        PagedList<YearNeedDetail> yearNeedDetailPagedList= YearNeedDetailModel.getPagingList(yearNeedDetailCondition);
        this.setResultList(yearNeedDetailPagedList.getResultList());
        this.setPageCount(yearNeedDetailPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(yearNeedDetailPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(yearNeedDetailPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
			id = YearNeedDetailModel.add(info);
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
                    if (YearNeedDetailModel.update(info) > 0){
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
            this.info = YearNeedDetailModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

}
