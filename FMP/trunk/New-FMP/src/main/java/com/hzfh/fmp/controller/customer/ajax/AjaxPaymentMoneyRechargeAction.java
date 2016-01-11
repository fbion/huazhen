package com.hzfh.fmp.controller.customer.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.customer.model.PaymentMoneyRecharge;
import com.hzfh.api.customer.model.query.PaymentMoneyRechargeCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.customer.PaymentMoneyRechargeModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxPaymentMoneyRechargeAction extends JqGridBaseAction<PaymentMoneyRecharge> {
	private PaymentMoneyRecharge info;
	public PaymentMoneyRecharge getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, PaymentMoneyRecharge.class);
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

	public PaymentMoneyRechargeCondition getCondition(){
    	PaymentMoneyRechargeCondition paymentMoneyRechargeCondition = new PaymentMoneyRechargeCondition();
        paymentMoneyRechargeCondition.setPageSize(this.getPageSize());
        paymentMoneyRechargeCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild("sn");
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        paymentMoneyRechargeCondition.setSortItemList(sortItemList);
        
        if(!StringHelper.isNullOrEmpty(bySn)){
        	paymentMoneyRechargeCondition.setSn(bySn);
        }
        if(!StringHelper.isNullOrEmpty(byState)){
        	paymentMoneyRechargeCondition.setState("0"+byState);
        }
        if(!StringHelper.isNullOrEmpty(byDate)){
        	paymentMoneyRechargeCondition.setDateDown(byDate+" 00:00:00");
        	paymentMoneyRechargeCondition.setDateUp(byDate+" 23:59:59");
        }
        return paymentMoneyRechargeCondition;
    }
    @Override
    public String execute() throws Exception{
    	

        PagedList<PaymentMoneyRecharge> paymentMoneyRechargePagedList= PaymentMoneyRechargeModel.getPagingList(this.getCondition());
        this.setResultList(paymentMoneyRechargePagedList.getResultList());
        this.setPageCount(paymentMoneyRechargePagedList.getPagingInfo().getPageCount());
        this.setPageIndex(paymentMoneyRechargePagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(paymentMoneyRechargePagedList.getPagingInfo().getTotalCount());
  
        int i=0;
        for (PaymentMoneyRecharge item : paymentMoneyRechargePagedList.getResultList()) {
        	item.setId(++i);
		}
        
        return SUCCESS;
    }

    public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
			id = PaymentMoneyRechargeModel.add(info);
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
                    if (PaymentMoneyRechargeModel.update(info) > 0){
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
            this.info = PaymentMoneyRechargeModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

}
