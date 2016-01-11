package com.hzfh.fmp.controller.customer.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.customer.model.AgentAdviser;
import com.hzfh.api.customer.model.query.AgentAdviserCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.EnumListCacheModel;
import com.hzfh.fmp.model.common.helper.ExcelHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.customer.AgentAdviserModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class AjaxAgentAdviserAction extends JqGridBaseAction<AgentAdviser> {

    private AgentAdviser info;
    public AgentAdviser getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, AgentAdviser.class);
    }
    private String byName;
    private String byEmpNo;
    private String byRelationLevel;
    private String byFindTimeUp;
	private String byFindTimeDown;
    private String showAllList;

    public void setByFindTimeUp(String byFindTimeUp) {
		this.byFindTimeUp = byFindTimeUp;
	}

	public void setByFindTimeDown(String byFindTimeDown) {
		this.byFindTimeDown = byFindTimeDown;
	}

	public void setByName(String byName) {
        this.byName = byName;
    }

    public void setByEmpNo(String byEmpNo) {
        this.byEmpNo = byEmpNo;
    }

    public void setByRelationLevel(String byRelationLevel) {
		this.byRelationLevel = byRelationLevel;
	}

	public void setShowAllList(String showAllList) {
        this.showAllList = showAllList;
    }
	private int isSales;

    public int getIsSales() {
        return isSales;
    }

    public void setIsSales(int isSales) {
        this.isSales = isSales;
    }
    private AgentAdviserCondition getCondiction(){
    	AgentAdviserCondition agentAdviserCondition = new AgentAdviserCondition();
        agentAdviserCondition.setPageSize(this.getPageSize());
        agentAdviserCondition.setPageIndex(this.getPageIndex());
        if ("query".equals(this.showAllList)) {
            agentAdviserCondition.setWorkMateString(null);
        }else{
            List<Integer> workmate = UserHelper.getUserCache().getWorkMate();
            if (workmate!=null) {
                workmate.add(UserHelper.getUserCache().getUserId());
                String workMateString = StringHelper.listToString(workmate);
                agentAdviserCondition.setWorkMateString(workMateString);
            }else{
                agentAdviserCondition.setWorkMateString(String.valueOf(UserHelper.getUserCache().getUserId()));
            }
        }

        if (!StringHelper.isNullOrEmpty(this.byName)){
            agentAdviserCondition.setName(this.byName);
        }
        if(!StringHelper.isNullOrEmpty(this.byEmpNo)){
            agentAdviserCondition.setEmpNo(Integer.valueOf(this.byEmpNo));
        }
        if (!StringHelper.isNullOrEmpty(this.byRelationLevel)){
            agentAdviserCondition.setRelationLevel(Byte.parseByte(byRelationLevel));
        }
        if (!StringHelper.isNullOrEmpty(this.getIsTest())) {
        	agentAdviserCondition.setIsTest(Byte.valueOf(this.getIsTest()));
		}else{
			agentAdviserCondition.setIsTest((byte) 0);
		}
        if (!StringHelper.isNullOrEmpty(this.byFindTimeUp)) {
        	agentAdviserCondition.setFindTimeUp(Timestamp.valueOf(this.byFindTimeUp+" 23:59:59"));
		}
		if (!StringHelper.isNullOrEmpty(this.byFindTimeDown)) {
			agentAdviserCondition.setFindTimeDown(Timestamp.valueOf(this.byFindTimeDown+" 00:00:00"));
		}
		if(!StringHelper.isNullOrEmpty(String.valueOf(this.isSales))){
			agentAdviserCondition.setIsSales(isSales);
        }else{
        	agentAdviserCondition.setIsSales((byte) -1);
        }
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        agentAdviserCondition.setSortItemList(sortItemList);
        return agentAdviserCondition;
    }
    
    @Override
    public String execute() throws Exception{
    	
        PagedList<AgentAdviser> agentAdviserPagedList= AgentAdviserModel.getPagingList(this.getCondiction());
        this.setResultList(agentAdviserPagedList.getResultList());
        this.setPageCount(agentAdviserPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(agentAdviserPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(agentAdviserPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
        info.setEditUserNo(UserHelper.getEditUserNo());
        int id = 0;
        if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
            id = AgentAdviserModel.add(info);
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
                    if (AgentAdviserModel.update(info) > 0){
                        this.setErrDesc(String.valueOf(info.getId()));
                    }else{
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                    }

                }
            }
        }
        EnumListCacheModel.getAgentAdviser(false);
        return SUCCESS;
    }

    public String getInfoById() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
            this.info = AgentAdviserModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }
    
    public String exportExcel(){
		ExcelHelper excelHelper =  new ExcelHelper();
		excelHelper.getExcelForAgentAdviser(this.getCondiction(), this.showAllList);
		
		return null;
	}
    
    

}
