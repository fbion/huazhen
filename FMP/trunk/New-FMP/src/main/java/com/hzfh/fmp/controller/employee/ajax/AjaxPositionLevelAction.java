package com.hzfh.fmp.controller.employee.ajax;

import com.hzfh.api.employee.model.PositionLevel;
import com.hzfh.api.employee.model.query.PositionLevelCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.PositionLevelModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxPositionLevelAction extends JqGridBaseAction<PositionLevel> {
    
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String comment;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	private String deptNo;
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	private String positionNo;
	public String getPositionNo() {
		return positionNo;
	}
	public void setPositionNo(String positionNo) {
		this.positionNo = positionNo;
	}
	
	private String byDept;
	
	

    public String getByDept() {
		return byDept;
	}
	public void setByDept(String byDept) {
		this.byDept = byDept;
	}
	@Override
    public String execute() throws Exception{
    	PositionLevelCondition positionLevelCondition = new PositionLevelCondition();
        positionLevelCondition.setPageSize(this.getPageSize());
        positionLevelCondition.setPageIndex(this.getPageIndex());

        if (StringHelper.isNullOrEmpty(this.byDept)) {
        	positionLevelCondition.setDept(0);
		}else{
			positionLevelCondition.setDept(Integer.parseInt(this.byDept));
		}
        
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        positionLevelCondition.setSortItemList(sortItemList);

        PagedList<PositionLevel> positionLevelPagedList= PositionLevelModel.getPagingList(positionLevelCondition);
        this.setResultList(positionLevelPagedList.getResultList());
        this.setPageCount(positionLevelPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(positionLevelPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(positionLevelPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
        PositionLevel positionLevel = new PositionLevel();
        
		positionLevel.setName(this.name);
		positionLevel.setComment(this.comment);
		if (!StringHelper.isNullOrEmpty(this.deptNo)) {
		positionLevel.setDeptNo(Integer.parseInt(this.deptNo));	
		}
		if (!StringHelper.isNullOrEmpty(this.positionNo)) {
		positionLevel.setPositionNo(Integer.parseInt(this.positionNo));	
		}else{
		positionLevel.setPositionNo(0);	
		}
		positionLevel.setEditComment(this.getEditComment());
		positionLevel.setEditUserNo(UserHelper.getEditUserNo());

        if (this.getOper().equalsIgnoreCase("add")) {
        	positionLevel.setInUserNo(UserHelper.getEditUserNo());
            if (PositionLevelModel.add(positionLevel )<=0){
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
                    positionLevel.setId(Integer.parseInt(this.getId()));
                    if (PositionLevelModel.update(positionLevel) <= 0){
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                    }
                }
            }
        }

        return SUCCESS;
    }

}
