package com.hzfh.fmp.controller.workFlow.easyUI;

import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.workFlow.model.ActHiProcinst;
import com.hzfh.api.workFlow.model.ActRuTask;
import com.hzfh.api.workFlow.model.TaskVO;
import com.hzfh.api.workFlow.model.query.ActRuTaskCondition;
import com.hzfh.fmp.controller.common.EasyUIBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.workFlow.ActHiProcinstModel;
import com.hzfh.fmp.model.workFlow.ActRuTaskModel;
import com.hzfh.fmp.model.workFlow.ProcessingModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.DateHelper;

import org.activiti.engine.repository.ProcessDefinition;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class EasyUIAuditTaskAction extends EasyUIBaseAction<TaskVO> {
	private String bySelectTitle;
    private String byRequestUser;
    private String byDate;

    public void setBySelectTitle(String bySelectTitle) {
        this.bySelectTitle = bySelectTitle;
    }

    public void setByRequestUser(String byRequestUser) {
        this.byRequestUser = byRequestUser;
    }

    public void setByDate(String byDate) {
		this.byDate = byDate;
	}

	@Override
	public String execute() throws Exception{
		String userNo = Integer.toString(UserHelper.getEditUserNo());
		ActRuTaskCondition actRuTaskCondition = new ActRuTaskCondition();
		actRuTaskCondition.setByDate(byDate);
        actRuTaskCondition.setByRequestUser(byRequestUser);
        actRuTaskCondition.setBySelectTitle(bySelectTitle);
		actRuTaskCondition.setAssignee(userNo);
		actRuTaskCondition.setPageIndex(this.getPage());
		actRuTaskCondition.setPageSize(this.getPageSize());
    	List<SortItem> sortItemList = new ArrayList<SortItem>();
		SortItem sortItem = new SortItem();
		sortItem.setSortFeild("CREATE_TIME_");
		sortItem.setSortType(SortType.DESC);
		sortItemList.add(sortItem);
		actRuTaskCondition.setSortItemList(sortItemList);
		PagedList<ActRuTask> actRuTaskPagedList = ActRuTaskModel.getPagingList(actRuTaskCondition);
    	List<TaskVO> auditTaskPagedList = new ArrayList<TaskVO>();
    	for(ActRuTask actRuTask:actRuTaskPagedList.getResultList()){
    			TaskVO taskVO = new TaskVO();
    			ActHiProcinst actHiProIns = ActHiProcinstModel.getInfoByProInsId(actRuTask.getProcInstId());
    			ProcessDefinition processDef = ProcessingModel.getProcessDefinitionByProDefId(actHiProIns.getProcDefId());
    			Employee employee = EmployeeModel.getEmpByUserId(Integer.parseInt(actHiProIns.getStartUserId()));
    			taskVO.setId(actHiProIns.getID());
    			taskVO.setStartUserId(actHiProIns.getStartUserId());
    			taskVO.setRequestDate(DateHelper.format(new Date(actHiProIns.getStartTime().getTime()),"yyyy-MM-dd HH:mm:ss"));
    			taskVO.setTitle(processDef.getName());
    			taskVO.setUri(actHiProIns.getBusinessKey());
    			taskVO.setRequestUser(employee.getName());//申请人
    			taskVO.setTaskId(actRuTask.getID());
    			taskVO.setActivitiNo(actRuTask.getProcInstId());
    			taskVO.setTaskDate(DateHelper.format(new Date(actRuTask.getCreateTime().getTime()),"yyyy-MM-dd HH:mm:ss"));
    			taskVO.setName(actRuTask.getName());
    			auditTaskPagedList.add(taskVO);
    	}
    	this.setRows(auditTaskPagedList);
        this.setTotal(actRuTaskPagedList.getPagingInfo().getTotalCount());
    	return SUCCESS;
    }
}
