package com.hzfh.weixin.controller.customer;

import java.util.ArrayList;
import java.util.List;

import com.hzfh.api.baseInfo.model.Announcement;
import com.hzfh.api.baseInfo.model.DicData;
import com.hzfh.api.employee.model.Department;
import com.hzfh.api.employee.model.query.DepartmentCondition;
import com.hzfh.weixin.controller.common.CommonAction;
import com.hzfh.weixin.model.baseInfo.DepartmentModel;
import com.hzfh.weixin.model.common.PageAlias;
import com.hzfh.weixin.model.common.helper.UrlHelper;
import com.hzfh.weixin.model.common.paramter.StatusType;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;

public class StoreAction extends CommonAction {
	private List<Department> departmentList;
	public List<Department> getDepartmentList() {
		return departmentList;
	}
	private int pageIndex=1;
	private int pageCount;
	private int totalCount;
	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageIndex() {
		return pageIndex <= pageCount?pageIndex:pageCount;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	
	private String pageUrl;
	public String getPageUrl() {
		return pageUrl;
	}
	@Override
	public String execute() {
		this.setPageAlias(PageAlias.storeList);
		String ret = super.execute();
		if (!ret.equals(SUCCESS))
			return ret;
		
		List<SortItem> sortItemList = new ArrayList<SortItem>();
        
    	SortItem sortItem = new SortItem();
    	sortItem.setSortFeild("id");
    	sortItem.setSortType(SortType.ASC);
    	
    	sortItemList.add(sortItem);
    
    	DepartmentCondition departmentCondition = new DepartmentCondition();
    	departmentCondition.setPageSize(100);
    	departmentCondition.setPageIndex(pageIndex);
    	departmentCondition.setByDeptType(StatusType.STORE);
    	departmentCondition.setIsTest(StatusType.IS_NO_TEST);
    	departmentCondition.setSortItemList(sortItemList);
        
    	PagedList<Department> departmentPagedList= DepartmentModel.getPagingList(departmentCondition);
    	this.departmentList = departmentPagedList.getResultList();
       // this.setAnnouncementList(announcementPagedList.getResultList());
        //List<DicData> dicDaList = DicDataModel.getDicDataListByType(StatusType.BULLETINSTATE);
       /* for(Announcement a:announcementList){
        	for(int i=0;i<dicDaList.size();i++){
        		if(a.getType()==dicDaList.get(i).getCode()){
        			a.setTypeValue(dicDaList.get(i).getValue());
        			break;
        		}
        	}
        }*/
        this.setPageCount(departmentPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(departmentPagedList.getPagingInfo().getPageIndex());
        totalCount = departmentPagedList.getPagingInfo().getTotalCount();
        
        this.pageUrl = UrlHelper.buildWWWSiteUrl(PageAlias.storeList)+"?1=1";
		return SUCCESS;
	}
}
