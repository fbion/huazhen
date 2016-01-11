package com.hzfh.fmp.controller.sales.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.baseInfo.model.Sms;
import com.hzfh.api.baseInfo.model.Smstemplete;
import com.hzfh.api.customer.model.CustomerPersonal;
import com.hzfh.api.sales.model.Activity;
import com.hzfh.api.sales.model.ApplyCustomer;
import com.hzfh.api.sales.model.ApplyEmployee;
import com.hzfh.api.sales.model.query.ApplyCustomerCondition;
import com.hzfh.fmp.controller.baseInfo.SmsTempleteType;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.sales.ActivityModel;
import com.hzfh.fmp.model.sales.ApplyCustomerModel;
import com.hzfh.fmp.model.sales.ApplyEmployeeModel;
import com.hzfh.fmp.model.baseInfo.SmsModel;
import com.hzfh.fmp.model.baseInfo.SmstempleteModel;
import com.hzfh.fmp.model.common.cache.CacheManager;
import com.hzfh.fmp.model.common.cache.CachePrefix;
import com.hzfh.fmp.model.common.helper.EncodeHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.customer.CustomerPersonalModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class AjaxApplyCustomerAction extends JqGridBaseAction<ApplyCustomer> {
	private int customerNo;
	private int customerId;
	public int getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	private int activityNo;
	
	public int getActivityNo() {
		return activityNo;
	}
	public void setActivityNo(int activityNo) {
		this.activityNo = activityNo;
	}
	private ApplyCustomer info;
	public ApplyCustomer getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = JSON.parseObject(info, ApplyCustomer.class);
    }
    private ApplyCustomerCondition getCondition(){
    	ApplyCustomerCondition applyCustomerCondition=new ApplyCustomerCondition();
    	applyCustomerCondition.setPageSize(this.getPageSize());
    	applyCustomerCondition.setPageIndex(this.getPageIndex());
    	 List<SortItem> sortItemList = new ArrayList<SortItem>();
         SortItem sortItem = new SortItem();
         sortItem.setSortFeild(this.getSidx());
         sortItem.setSortType(this.getSortType());
         sortItemList.add(sortItem);
         applyCustomerCondition.setSortItemList(sortItemList);
         //条件为当前的活动
         if(this.activityNo>0){
         applyCustomerCondition.setActivityNo(this.activityNo);
         }
         //当前的用户邀请的客户
         applyCustomerCondition.setEmpNo(UserHelper.getEditUserNo());
    	return applyCustomerCondition;
    }
    @Override
    public String execute() throws Exception{
        PagedList<ApplyCustomer> applyCustomerPagedList= ApplyCustomerModel.getPagingList(this.getCondition());
        this.setResultList(applyCustomerPagedList.getResultList());
        this.setPageCount(applyCustomerPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(applyCustomerPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(applyCustomerPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }
   public String invit(){
	   	 ApplyCustomer applyCustomer=new ApplyCustomer();
	   	 int id = 0;
	   	 CustomerPersonal customerPersonal=CustomerPersonalModel.getInfo(customerNo);
	   	 applyCustomer.setActivityNo(activityNo);
	   	 applyCustomer.setEmpNo(UserHelper.getEditUserNo());
	   	 applyCustomer.setCustomerNo(customerNo);
	   	 applyCustomer.setName(customerPersonal.getName());
	   	 applyCustomer.setRiskAppetite(customerPersonal.getRiskHobby());
	   	 applyCustomer.setLevel(customerPersonal.getRelationLevel());
	   	 applyCustomer.setSex(customerPersonal.getSex());
	   	 //存入手机号需要加密
	   	if(customerPersonal.getCellphone1()!=null){
		   	 if(customerPersonal.getCellphone1().split("-")[0].equalsIgnoreCase("m")){
		   		 applyCustomer.setTel(customerPersonal.getCellphone1());
		   	 }else{
		   		 applyCustomer.setTel("m-"+EncodeHelper.encryptDES(customerPersonal.getCellphone1()));
		   	 }
	   	}
	   	 if(customerPersonal.getCellphone2()!=null){
	   		if(customerPersonal.getCellphone2().split("-")[0].equalsIgnoreCase("m")){
		   		 applyCustomer.setMark(customerPersonal.getCellphone2());
		   	 }else{
		   		 applyCustomer.setMark("m-"+EncodeHelper.encryptDES(customerPersonal.getCellphone2()));
		   	 }
	   	 }
	   	 
	   	 applyCustomer.setInUserNo(UserHelper.getEditUserNo());
	   	 //短信发送成功状态存入已发送
	   	 SmsModel.templeteCache(CachePrefix.SMS_TEMPLETE, 15);
	   	 Activity activity=ActivityModel.getInfo(activityNo);
	   	 String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(activity.getActivityTime());
	   	 if(customerPersonal.getCellphone1()!=null){
	   	 String telephone1=customerPersonal.getCellphone1();
		 //String telephone1="15701225635";
	   	 int isSend=SmsModel.smsActivityInvitation(telephone1,activity.getTitle(),dateStr, activity.getAddress());
		   	if(isSend>0){
			   	 applyCustomer.setIsSend(1);
			}
	   	 }
	   	 if(customerPersonal.getCellphone2()!=null){
	   	 String telephone2=customerPersonal.getCellphone2();
	     //String telephone2="15701225635";
	   	 int isSend1=SmsModel.smsActivityInvitation(telephone2,activity.getTitle(),dateStr, activity.getAddress());
		   	if(isSend1>0){
			   	 applyCustomer.setIsSend(1);
			}
	   	 }
	     id = ApplyCustomerModel.add(applyCustomer);
	     //成功邀约后applyEmployee当前客户的邀约数量加1
	     ApplyEmployee applyEmployee=new ApplyEmployee();
	     applyEmployee.setActivityNo(activityNo);
	     applyEmployee.setEmpNo(UserHelper.getEditUserNo());
	     ApplyEmployee applyEmployee1=ApplyEmployeeModel.getInfoByAnoEno(applyEmployee);
	     applyEmployee1.setInviteNum(applyEmployee1.getInviteNum()+1);
	     ApplyEmployeeModel.update(applyEmployee1);
	   	 return SUCCESS;
   }
	//客户签到
   	public String sign(){
   		 ApplyCustomer applyCustomer=ApplyCustomerModel.getInfo(customerId);
   		 applyCustomer.setIsSign(1);
   		 int empNo=applyCustomer.getEmpNo();
   		 ApplyCustomerModel.update(applyCustomer);
   		//成功签到后applyEmployee当前客户的实到数量加1
	     //并改变isSign的状态为1
	     ApplyEmployee applyEmployee=new ApplyEmployee();
	     applyEmployee.setActivityNo(activityNo);
	     applyEmployee.setEmpNo(empNo);
	     ApplyEmployee applyEmployee1=ApplyEmployeeModel.getInfoByAnoEno(applyEmployee);
	     applyEmployee1.setArriveNum(applyEmployee1.getArriveNum()+1);
	     ApplyEmployeeModel.update(applyEmployee1);
   		return SUCCESS;
   	}
    public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
			id = ApplyCustomerModel.add(info);
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
                    if (ApplyCustomerModel.update(info) > 0){
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
            this.info = ApplyCustomerModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

}
