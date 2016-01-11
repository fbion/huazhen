package com.hzfh.fmp.controller.workFlow.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.workFlow.ProcessDefinitionModel;
import org.activiti.engine.repository.ProcessDefinition;

import java.util.List;


public class AjaxActReProcDefAction extends JqGridBaseAction<ProcessDefinition> {
	private ProcessDefinition info;
	public ProcessDefinition getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, ProcessDefinition.class);
    }

   // @Override
    /*public String execute() throws Exception{
        List<ProcessDefinition> actProcessDefPagedList =  ProcessDefinitionModel.getProcessDef(this.getStartIndex(),this.getPageSize());
        this.setResultList(actProcessDefPagedList);
        this.setPageCount(this.getPageCount());
        this.setPageIndex(this.getPageIndex());
        this.setRecordCount(ProcessDefinitionModel.getProcessDefTotalCount());
        return SUCCESS;
    }
    public int getPageCount() {
		if (this.getPageSize() == 0) {
			throw new ArithmeticException("pageSize");
		}
		return (int) Math.ceil(((double) ProcessDefinitionModel.getProcessDefTotalCount()) / this.getPageSize());
	}
    
    public int getStartIndex(){
    	return (this.getPageIndex()-1)*this.getPageSize();
    }*/
   /* @Override
    public String execute() throws Exception{
    	
    	
    	ACTREPROCDEFCondition aCTREPROCDEFCondition = new ACTREPROCDEFCondition();
        aCTREPROCDEFCondition.setPageSize(this.getPageSize());
        aCTREPROCDEFCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        aCTREPROCDEFCondition.setSortItemList(sortItemList);

        PagedList<ACTREPROCDEF> aCTREPROCDEFPagedList= ACTREPROCDEFModel.getPagingList(aCTREPROCDEFCondition);
        this.setResultList(aCTREPROCDEFPagedList.getResultList());
        this.setPageCount(aCTREPROCDEFPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(aCTREPROCDEFPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(aCTREPROCDEFPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }
*/
    /*public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
			id = ACTREPROCDEFModel.add(info);
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
                    if (ACTREPROCDEFModel.update(info) > 0){
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
            this.info = ACTREPROCDEFModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }
*/
}
