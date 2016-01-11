package com.hzfh.fmp.controller.employee.ajax;

import com.hzfh.api.employee.model.Welfare;
import com.hzfh.api.employee.model.query.WelfareCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.WelfareModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class AjaxWelfareAction extends JqGridBaseAction<Welfare> {
    
	private String sendtime;
	public String getSendtime() {
		return sendtime;
	}
	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}
	private String goods;
	public String getGoods() {
		return goods;
	}
	public void setGoods(String goods) {
		this.goods = goods;
	}
	private String money;
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	private String comment;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	private String empSendNo;
	public String getEmpSendNo() {
		return empSendNo;
	}
	public void setEmpSendNo(String empSendNo) {
		this.empSendNo = empSendNo;
	}
	private String empReceiveNo;
	public String getEmpReceiveNo() {
		return empReceiveNo;
	}
	public void setEmpReceiveNo(String empReceiveNo) {
		this.empReceiveNo = empReceiveNo;
	}

    @Override
    public String execute() throws Exception{
    	WelfareCondition welfareCondition = new WelfareCondition();
        welfareCondition.setPageSize(this.getPageSize());
        welfareCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        welfareCondition.setSortItemList(sortItemList);

        PagedList<Welfare> welfarePagedList= WelfareModel.getPagingList(welfareCondition);
        this.setResultList(welfarePagedList.getResultList());
        this.setPageCount(welfarePagedList.getPagingInfo().getPageCount());
        this.setPageIndex(welfarePagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(welfarePagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
        Welfare welfare = new Welfare();
        
		welfare.setSendtime(Timestamp.valueOf(this.sendtime));
		welfare.setGoods(this.goods);
		welfare.setMoney(Double.parseDouble(this.money));
		welfare.setComment(this.comment);
		welfare.setEmpSendNo(Integer.parseInt(this.empSendNo));
		welfare.setEmpReceiveNo(Integer.parseInt(this.empReceiveNo));
		welfare.setEditComment(this.getEditComment());
		welfare.setEditUserNo(UserHelper.getEditUserNo());

        if (this.getOper().equalsIgnoreCase("add")) {
        	welfare.setInUserNo(UserHelper.getEditUserNo());
            if (WelfareModel.add(welfare )<=0){
                this.setErrCode("add failed");
                this.setErrDesc("add failed");
            }
        }
        else
        {
            if (this.getId().isEmpty()) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
            }
            else{
                if (this.getOper().equalsIgnoreCase("edit")) {
                    welfare.setId(Integer.parseInt(this.getId()));
                    if (WelfareModel.update(welfare) <= 0){
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                    }
                }
            }
        }

        return SUCCESS;
    }

}
