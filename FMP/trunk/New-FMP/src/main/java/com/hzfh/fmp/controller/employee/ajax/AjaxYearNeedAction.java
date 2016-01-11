package com.hzfh.fmp.controller.employee.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.YearNeed;
import com.hzfh.api.employee.model.YearNeedDetail;
import com.hzfh.api.employee.model.YearNeedTotal;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.*;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;



public class AjaxYearNeedAction extends JqGridBaseAction<YearNeed> {
	private YearNeed info;
	private YearNeedTotal yearNeedTotal;
	private List<YearNeed> yearNeeds;
	private List<YearNeedDetail> yearNeedDetails;
	public YearNeed getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, YearNeed.class);
    }
    private String param;
    
    public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public List<YearNeed> getYearNeeds() {
		return yearNeeds;
	}

	public void setYearNeeds(List<YearNeed> yearNeeds) {
		this.yearNeeds = yearNeeds;
	}

	public List<YearNeedDetail> getYearNeedDetails() {
		return yearNeedDetails;
	}

	public void setYearNeedDetails(List<YearNeedDetail> yearNeedDetails) {
		this.yearNeedDetails = yearNeedDetails;
	}
    private String totalCode;
    
	public String getTotalCode() {
		return totalCode;
	}

	public void setTotalCode(String totalCode) {
		this.totalCode = totalCode;
	}

	public YearNeedTotal getYearNeedTotal() {
		return yearNeedTotal;
	}

	public void setYearNeedTotal(YearNeedTotal yearNeedTotal) {
		this.yearNeedTotal = yearNeedTotal;
	}
	private String activitiID;
	    
	public void setActivitiID(String activitiID) {
		this.activitiID = activitiID;
	}
	@Override
    public String execute() throws Exception{
    	this.yearNeeds=YearNeedModel.getListByYear(Integer.parseInt(param));
    	this.yearNeedDetails=new ArrayList<YearNeedDetail>();
    	for (int i = 0; i < yearNeeds.size(); i++) {
    		List<YearNeedDetail> yearNeedDetailInfo=YearNeedDetailModel.getListByNeedNo(yearNeeds.get(i).getId());
    		    int deptNo=yearNeeds.get(i).getDeptNo();
    		    String deptName=DepartmentModel.getInfo(deptNo).getName();
    		    yearNeeds.get(i).setDeptName(deptName);
    		    if(yearNeeds.get(i).getYearNeedTotalNo()>0){
    		    	this.yearNeedTotal=YearNeedTotalModel.getInfo(yearNeeds.get(i).getYearNeedTotalNo());
    		    }
    		for (int j = 0; j < yearNeedDetailInfo.size(); j++) {
    			int position=yearNeedDetailInfo.get(j).getPositionNo();
    			String positionName=PositionModel.getInfo(position).getName();
    			yearNeedDetailInfo.get(j).setPositionName(positionName);
			}
    		yearNeedDetails.addAll(yearNeedDetailInfo);
		}
    	
    	return SUCCESS;
    }

    public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
			id = YearNeedModel.add(info);
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
            	if(!StringHelper.isNullOrEmpty(this.activitiID)){
            		info.setActivitiNo(this.activitiID);
            	}
                if (this.getOper().equalsIgnoreCase("edit")) {                    
                    if (YearNeedModel.update(info) > 0){
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
            this.info = YearNeedModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

}
