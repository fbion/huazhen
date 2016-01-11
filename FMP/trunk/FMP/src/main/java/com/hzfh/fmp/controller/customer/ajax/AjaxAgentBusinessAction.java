package com.hzfh.fmp.controller.customer.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.customer.model.AgentBusiness;
import com.hzfh.api.customer.model.query.AgentBusinessCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.EnumListCacheModel;
import com.hzfh.fmp.model.common.helper.ExcelHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.customer.AgentBusinessModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class AjaxAgentBusinessAction extends JqGridBaseAction<AgentBusiness> {

    private AgentBusiness info;
    public AgentBusiness getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, AgentBusiness.class);
    }
	private String byName;
    private String byEmpNo;
    private String byImportance;
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

    public void setByImportance(String byImportance) {
        this.byImportance = byImportance;
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
    private AgentBusinessCondition getCondition(){
    	AgentBusinessCondition agentBusinessCondition = new AgentBusinessCondition();
        agentBusinessCondition.setPageSize(this.getPageSize());
        agentBusinessCondition.setPageIndex(this.getPageIndex());
        if ("query".equals(this.showAllList)) {
            agentBusinessCondition.setWorkMateString(null);
        }else{
            List<Integer> workmate = UserHelper.getUserCache().getWorkMate();
            if (workmate!=null) {
                workmate.add(UserHelper.getUserCache().getUserId());
                String workMateString = StringHelper.listToString(workmate);
                agentBusinessCondition.setWorkMateString(workMateString);
                agentBusinessCondition.setWorkMateString(workMateString);
            }else{
                agentBusinessCondition.setWorkMateString(String.valueOf(UserHelper.getUserCache().getUserId()));
            }
        }
        if (!StringHelper.isNullOrEmpty(this.byName)) {
			agentBusinessCondition.setName(this.byName);
		}
        if(!StringHelper.isNullOrEmpty(this.byEmpNo)){
            agentBusinessCondition.setEmpNo(Integer.valueOf(this.byEmpNo));
        }
        
        if (StringHelper.isNullOrEmpty(this.byImportance)) {
			agentBusinessCondition.setImportance(0);
		}else{
			agentBusinessCondition.setImportance(Integer.parseInt(this.byImportance));
		}
        
        if (StringHelper.isNullOrEmpty(this.byRelationLevel)) {
			agentBusinessCondition.setRelationLevel(0);
		}else{
			agentBusinessCondition.setRelationLevel(Integer.parseInt(this.byRelationLevel));
		}
        if (StringHelper.isNullOrEmpty(this.getIsTest())) {
        	agentBusinessCondition.setIsTest((byte) 0);
        }else{
        	agentBusinessCondition.setIsTest(Byte.valueOf(this.getIsTest()));
        }
        if (!StringHelper.isNullOrEmpty(this.byFindTimeUp)) {
        	agentBusinessCondition.setFindTimeUp(Timestamp.valueOf(this.byFindTimeUp+" 23:59:59"));
		}
		if (!StringHelper.isNullOrEmpty(this.byFindTimeDown)) {
			agentBusinessCondition.setFindTimeDown(Timestamp.valueOf(this.byFindTimeDown+" 00:00:00"));
		}
		if(!StringHelper.isNullOrEmpty(String.valueOf(this.isSales))){
			agentBusinessCondition.setIsSales(isSales);
        }else{
        	agentBusinessCondition.setIsSales((byte) -1);
        }
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        agentBusinessCondition.setSortItemList(sortItemList);
        return agentBusinessCondition;
    }
    
    @Override
    public String execute() throws Exception{

        PagedList<AgentBusiness> agentBusinessPagedList= AgentBusinessModel.getPagingList(this.getCondition());
        this.setResultList(agentBusinessPagedList.getResultList());
        this.setPageCount(agentBusinessPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(agentBusinessPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(agentBusinessPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }


    public String edit(){
        info.setEditUserNo(UserHelper.getEditUserNo());
        int id = 0;
        if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
            id = AgentBusinessModel.add(info);
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
                    if (AgentBusinessModel.update(info) > 0){
                        this.setErrDesc(String.valueOf(info.getId()));
                    }else{
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                    }

                }
            }
        }
        EnumListCacheModel.getAgentBusinessList(false);
        return SUCCESS;
    }

    public String getInfoById() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
            this.info = AgentBusinessModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }
    
    public String exportExcel(){
		ExcelHelper excelHelper =  new ExcelHelper();
		excelHelper.getExcelForAgentBusiness(this.getCondition(), this.showAllList);
		
		return null;
	}

}
