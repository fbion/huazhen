package com.hzfh.fmp.controller.employee.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.Suppliers;
import com.hzfh.api.employee.model.query.SuppliersCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.employee.SuppliersModel;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class AjaxSuppliersAction extends JqGridBaseAction<Suppliers> {
	private Suppliers info;
	public Suppliers getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, Suppliers.class);
    }
    private String bySupplierName;
    private String bySupplierType;
    private String byContactPerson;
    
    public void setBySupplierName(String bySupplierName) {
		this.bySupplierName = bySupplierName;
	}

	public void setBySupplierType(String bySupplierType) {
		this.bySupplierType = bySupplierType;
	}

	public void setByContactPerson(String byContactPerson) {
		this.byContactPerson = byContactPerson;
	}

	@Override
    public String execute(){
    	SuppliersCondition suppliersCondition = new SuppliersCondition();
    	if (!StringHelper.isNullOrEmpty(this.bySupplierName)) {
    		suppliersCondition.setSupplierName(this.bySupplierName);
		}
    	if (!StringHelper.isNullOrEmpty(this.bySupplierType)) {
    		suppliersCondition.setSupplierType(Integer.parseInt(this.bySupplierType));
		}
    	if (!StringHelper.isNullOrEmpty(this.byContactPerson)) {
    		suppliersCondition.setContactPerson(this.byContactPerson);
		}
    	
        suppliersCondition.setPageSize(this.getPageSize());
        suppliersCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        suppliersCondition.setSortItemList(sortItemList);

        PagedList<Suppliers> suppliersPagedList= SuppliersModel.getPagingList(suppliersCondition);
        this.setResultList(suppliersPagedList.getResultList());
        this.setPageCount(suppliersPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(suppliersPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(suppliersPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
			id = SuppliersModel.add(info);
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
                    if (SuppliersModel.update(info) > 0){
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
            this.info = SuppliersModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

}
