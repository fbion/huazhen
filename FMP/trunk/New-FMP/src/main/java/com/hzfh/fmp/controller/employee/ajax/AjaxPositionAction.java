package com.hzfh.fmp.controller.employee.ajax;

import com.hzfh.api.employee.model.Position;
import com.hzfh.api.employee.model.query.PositionCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.EnumListCacheModel;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.PositionModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxPositionAction extends JqGridBaseAction<Position> {
    
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
	
	
	
	private String byName;
	
	
	public String getByName() {
		return byName;
	}
	public void setByName(String byName) {
		this.byName = byName;
	}
	@Override
    public String execute() throws Exception{
    	PositionCondition positionCondition = new PositionCondition();
        positionCondition.setPageSize(this.getPageSize());
        positionCondition.setPageIndex(this.getPageIndex());
        
        if(!StringHelper.isNullOrEmpty(this.byName));
        	positionCondition.setName(this.byName);
        
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        positionCondition.setSortItemList(sortItemList);

        PagedList<Position> positionPagedList= PositionModel.getPagingList(positionCondition);
        this.setResultList(positionPagedList.getResultList());
        this.setPageCount(positionPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(positionPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(positionPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
        Position position = new Position();
        
		position.setName(this.name);
		position.setComment(this.comment);
		position.setDeptNo(Integer.parseInt(this.deptNo));
		position.setEditComment(this.getEditComment());
		position.setEditUserNo(UserHelper.getEditUserNo());

        if (this.getOper().equalsIgnoreCase("add")) {
        	position.setInUserNo(UserHelper.getEditUserNo());
            if (PositionModel.add(position)<=0){
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
                    position.setId(Integer.parseInt(this.getId()));
                    if (PositionModel.update(position) <= 0){
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                    }
                }
            }
        }
        EnumListCacheModel.getPositionByDept(Integer.parseInt(this.deptNo),false);
        EnumListCacheModel.getPositionListBydept(Integer.parseInt(this.deptNo),false);
        EnumListCacheModel.getPositionList(false);
        return SUCCESS;
    }

}
