package com.hzfh.fmp.controller.customer.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.customer.model.PaymentMoneyWithdraw;
import com.hzfh.api.customer.model.query.PaymentMoneyWithdrawCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.customer.PaymentMoneyWithdrawModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxPaymentMoneyWithdrawAction extends JqGridBaseAction<PaymentMoneyWithdraw> {
	private PaymentMoneyWithdraw info;
	public PaymentMoneyWithdraw getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, PaymentMoneyWithdraw.class);
    }
    private String bySn;
    private String byState;
    private String byDate;
    public void setBySn(String bySn) {
		this.bySn = bySn;
	}

	public void setByState(String byState) {
		this.byState = byState;
	}

	public void setByDate(String byDate) {
		this.byDate = byDate;
	}

	public PaymentMoneyWithdrawCondition getCondition(){
		PaymentMoneyWithdrawCondition paymentMoneyWithdrawCondition = new PaymentMoneyWithdrawCondition();
        paymentMoneyWithdrawCondition.setPageSize(this.getPageSize());
        paymentMoneyWithdrawCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild("sn");
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        paymentMoneyWithdrawCondition.setSortItemList(sortItemList);
        
        if(!StringHelper.isNullOrEmpty(bySn)){
        	paymentMoneyWithdrawCondition.setSn(bySn);
        }
        if(!StringHelper.isNullOrEmpty(byState)){
        	paymentMoneyWithdrawCondition.setState("0"+byState);
        }
        if(!StringHelper.isNullOrEmpty(byDate)){
        	paymentMoneyWithdrawCondition.setDateDown(byDate+" 00:00:00");
        	paymentMoneyWithdrawCondition.setDateUp(byDate+" 23:59:59");
        }
        return paymentMoneyWithdrawCondition;
	}
    @Override
    public String execute() throws Exception{
    	

        PagedList<PaymentMoneyWithdraw> paymentMoneyWithdrawPagedList= PaymentMoneyWithdrawModel.getPagingList(this.getCondition());
        this.setResultList(paymentMoneyWithdrawPagedList.getResultList());
        this.setPageCount(paymentMoneyWithdrawPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(paymentMoneyWithdrawPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(paymentMoneyWithdrawPagedList.getPagingInfo().getTotalCount());
        int i=0;
        for (PaymentMoneyWithdraw item : paymentMoneyWithdrawPagedList.getResultList()) {
        	item.setId(++i);
		}
        return SUCCESS;
    }

    public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
			id = PaymentMoneyWithdrawModel.add(info);
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
                    if (PaymentMoneyWithdrawModel.update(info) > 0){
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
            this.info = PaymentMoneyWithdrawModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

}
