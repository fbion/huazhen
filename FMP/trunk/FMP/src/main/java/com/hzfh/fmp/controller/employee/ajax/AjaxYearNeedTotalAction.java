package com.hzfh.fmp.controller.employee.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.YearNeedTotal;
import com.hzfh.api.employee.model.query.YearNeedTotalCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.YearNeedTotalModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxYearNeedTotalAction extends JqGridBaseAction<YearNeedTotal> {
	private YearNeedTotal info;
	public YearNeedTotal getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, YearNeedTotal.class);
    }
    private String activitiID;
    
    public void setActivitiID(String activitiID) {
		this.activitiID = activitiID;
	}

    @Override
    public String execute() throws Exception{
    	YearNeedTotalCondition yearNeedTotalCondition = new YearNeedTotalCondition();
        yearNeedTotalCondition.setPageSize(this.getPageSize());
        yearNeedTotalCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        yearNeedTotalCondition.setSortItemList(sortItemList);

        PagedList<YearNeedTotal> yearNeedTotalPagedList= YearNeedTotalModel.getPagingList(yearNeedTotalCondition);
        this.setResultList(yearNeedTotalPagedList.getResultList());
        this.setPageCount(yearNeedTotalPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(yearNeedTotalPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(yearNeedTotalPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
			int id = 0;
            info.setInUserNo(UserHelper.getEditUserNo());
            try {
            	if(!StringHelper.isNullOrEmpty(this.activitiID)){
            		info.setActivitiNo(this.activitiID);
            	}
                YearNeedTotal yearNeedTotal=YearNeedTotalModel.getInfoByYear(info.getFinancialYear());
                if(yearNeedTotal!=null){
                	int totalId=yearNeedTotal.getId();
                	info.setId(totalId);
                    id=YearNeedTotalModel.update(info);
                }
			} catch (Exception e) {
                 e.printStackTrace();
			}
			
            if (id > 0){
				this.setErrDesc(String.valueOf(id));                
            }else{
				this.setErrCode("update failed");
                this.setErrDesc("update failed");
			}
   

        return SUCCESS;
    }

	public String getInfoById() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
            this.info = YearNeedTotalModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

}
