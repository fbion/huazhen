package com.hzfh.fmp.controller.customer.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.customer.model.ActivityCouponsProduct;
import com.hzfh.api.customer.model.query.ActivityCouponsProductCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.customer.ActivityCouponsProductModel;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxActivityCouponsProductAction extends JqGridBaseAction<ActivityCouponsProduct> {
	private ActivityCouponsProduct info;
	public ActivityCouponsProduct getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, ActivityCouponsProduct.class);
    }

    @Override
    public String execute(){
    	ActivityCouponsProductCondition activityCouponsProductCondition = new ActivityCouponsProductCondition();
        activityCouponsProductCondition.setPageSize(this.getPageSize());
        activityCouponsProductCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        activityCouponsProductCondition.setSortItemList(sortItemList);

        PagedList<ActivityCouponsProduct> activityCouponsProductPagedList= ActivityCouponsProductModel.getPagingList(activityCouponsProductCondition);
        this.setResultList(activityCouponsProductPagedList.getResultList());
        this.setPageCount(activityCouponsProductPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(activityCouponsProductPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(activityCouponsProductPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
			id = ActivityCouponsProductModel.add(info);
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
                    if (ActivityCouponsProductModel.update(info) > 0){
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
            this.info = ActivityCouponsProductModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

}
