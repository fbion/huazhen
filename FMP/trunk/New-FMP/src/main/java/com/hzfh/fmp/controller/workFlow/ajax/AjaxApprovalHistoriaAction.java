package com.hzfh.fmp.controller.workFlow.ajax;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.activiti.engine.repository.ProcessDefinition;

import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.workFlow.model.ActHiTaskinst;
import com.hzfh.api.workFlow.model.Processing;
import com.hzfh.api.workFlow.model.query.ActHiTaskinstCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.workFlow.ActHiTaskinstModel;
import com.hzfh.fmp.model.workFlow.ApprovalHistoriaModel;
import com.hzfh.fmp.model.workFlow.ProcessingModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.DateHelper;


public class AjaxApprovalHistoriaAction extends JqGridBaseAction<Processing> {
	private String bySelectTitle;
	private String byStatus;
	public void setBySelectTitle(String bySelectTitle) {
		this.bySelectTitle = bySelectTitle;
	}

	public void setByStatus(String byStatus) {
		this.byStatus = byStatus;
	}

	String userNo = Integer.toString(UserHelper.getEditUserNo()) ;
	int totalRecordCount ;
	@Override
    public String execute() throws Exception{
        List<Processing> actIdProcessingPagedList= new ArrayList<Processing>();
        
       
        ActHiTaskinstCondition actHiTaskinstCondition = new ActHiTaskinstCondition();
        actHiTaskinstCondition.setAssignee(userNo);
        actHiTaskinstCondition.setPageIndex(this.getPageIndex());
        actHiTaskinstCondition.setPageSize(this.getPageSize());
       
        actHiTaskinstCondition.setBySelectTitle(bySelectTitle);
        actHiTaskinstCondition.setByStatus(byStatus);
        actHiTaskinstCondition.setPageIndex(this.getPageIndex());
        actHiTaskinstCondition.setPageSize(this.getPageSize());
        List<SortItem> sortItemList = new ArrayList<SortItem>();
		SortItem sortItem = new SortItem();
		sortItem.setSortFeild("start_time_");
		sortItem.setSortType(SortType.DESC);
		sortItemList.add(sortItem);
		actHiTaskinstCondition.setSortItemList(sortItemList);
		
		
		PagedList<ActHiTaskinst> actHiTaskinstPagedList = ActHiTaskinstModel.getPagingList(actHiTaskinstCondition);
		
        
       for (ActHiTaskinst actHiTaskinst : actHiTaskinstPagedList.getResultList()) {
        	Processing processing = new Processing();
        	ProcessDefinition processDef = ProcessingModel.getProcessDefinitionByProDefId(actHiTaskinst.getProcDefId());
        	processing.setId(actHiTaskinst.getProcInstId());
        	if(processDef!=null){
        		processing.setTitle(processDef.getName());//标题
        	}
        	processing.setRequestDate(DateHelper.format(new Date(actHiTaskinst.getStartTime().getTime()),"yyyy-MM-dd HH:mm:ss"));//申请时间
           	
           	processing.setUri(actHiTaskinst.getFormKey());
        	
        	Employee employee = EmployeeModel.getEmpByUserId(Integer.parseInt(actHiTaskinst.getOwner()));
        	processing.setRequestUser(employee.getName());//申请人
			if(actHiTaskinst.getEndTime()==null){
				processing.setStatus("未结束");//未结束
			}else{
				processing.setStatus("结束");//结束
				processing.setEndDate(DateHelper.format(new Date(actHiTaskinst.getEndTime().getTime()),"yyyy-MM-dd HH:mm:ss"));//结束时间
			};
			actIdProcessingPagedList.add(processing);
		}
        
        this.setResultList(actIdProcessingPagedList);
        this.setPageCount(actHiTaskinstPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(this.getPageIndex());
        this.setRecordCount(actHiTaskinstPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }
	
	public void getApprovalHistoriaTotalCount(Map<String, Object> paramMap){
		totalRecordCount = ApprovalHistoriaModel.getApprovalHistoriaTotalCount(paramMap);
	} 
    
    public int getStartIndex(){
    	return (this.getPageIndex()-1)*this.getPageSize();
    }
}
