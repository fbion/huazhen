package com.hzfh.fmp.controller.workFlow.easyUI;

import com.hzfh.api.workFlow.model.ActHiProcinst;
import com.hzfh.api.workFlow.model.Processing;
import com.hzfh.api.workFlow.model.query.ActHiProcinstCondition;
import com.hzfh.fmp.controller.common.EasyUIBaseAction;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.workFlow.ActHiProcinstModel;
import com.hzfh.fmp.model.workFlow.ProcessingModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.DateHelper;
import com.hzframework.helper.StringHelper;

import org.activiti.engine.repository.ProcessDefinition;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class EasyUIProcessingAction extends EasyUIBaseAction<Processing> {
	private String bySelectTitle;
    private String byStatus;
    private String byDate;
    
    public void setBySelectTitle(String bySelectTitle) {
		this.bySelectTitle = bySelectTitle;
	}

	public void setByStatus(String byStatus) {
		this.byStatus = byStatus;
	}

	public void setByDate(String byDate) {
		this.byDate = byDate;
	}

	private String status;

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String execute() throws Exception {
        String userNo = Integer.toString(UserHelper.getEditUserNo());
        List<Processing> actIdProcessingPagedList = new ArrayList<Processing>();
        ActHiProcinstCondition actHiProcinstCondition = new ActHiProcinstCondition();
        actHiProcinstCondition.setBySelectTitle(bySelectTitle);
        actHiProcinstCondition.setByStatus(byStatus);
        actHiProcinstCondition.setByDate(byDate);
        actHiProcinstCondition.setPageIndex(this.getPage());
        actHiProcinstCondition.setPageSize(this.getPageSize());

        if (!StringHelper.isNullOrEmpty(userNo)) {
            actHiProcinstCondition.setStartUserId(Integer.parseInt(userNo));
        } else {
            actHiProcinstCondition.setStartUserId(0);
        }
//        actHiProcinstCondition.setByStatus(status);
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild("START_TIME_");
        sortItem.setSortType(SortType.DESC);
        sortItemList.add(sortItem);
        actHiProcinstCondition.setSortItemList(sortItemList);
        PagedList<ActHiProcinst> actHiProcPagedList = ActHiProcinstModel.getPagingList(actHiProcinstCondition);
        for (ActHiProcinst actHiProcList : actHiProcPagedList.getResultList()) {
            Processing processing = new Processing();
            ProcessDefinition processDef = ProcessingModel.getProcessDefinitionByProDefId(actHiProcList.getProcDefId());
            processing.setId(actHiProcList.getProcInstId());
            processing.setTitle(processDef.getName());//标题
            processing.setRequestDate(DateHelper.format(new Date(actHiProcList.getStartTime().getTime()), "yyyy-MM-dd HH:mm:ss"));//申请时间
            processing.setUri(actHiProcList.getBusinessKey());

            if (actHiProcList.getEndTime() == null) {
                processing.setStatus("未通过");//未结束
            } else {
            	if(actHiProcList.getEndActId().equals("deleteActiviti")){
                    processing.setStatus("删除");//结束
            	}else{
                    processing.setStatus("通过");//结束
            	}
            }
            actIdProcessingPagedList.add(processing);
        }
        this.setRows(actIdProcessingPagedList);
        this.setTotal(actHiProcPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }
}
