package com.hzfh.fmp.controller.employee;

import java.util.ArrayList;
import java.util.List;

import com.hzfh.api.baseInfo.model.DicData;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.employee.model.KnowledgeBase;
import com.hzfh.api.employee.model.query.KnowledgeBaseCondition;
import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.baseInfo.DicDataModel;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.helper.UrlHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.employee.KnowledgeBaseModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.StringHelper;

public class KnowledgeBaseAction extends CommonAction {
	private boolean showAddButton;
	private int pageCount;
	private int totalCount;
	private int pageIndex=1;
	private String knowledgeBaseDetailUrl;
	private PagedList<KnowledgeBase> knowledgeBasePagedList;
	private String knowledgeBaseList;//主url
	private String byType;
	private String key;
    public boolean isShowAddButton() {
        return showAddButton;
    }
	public PagedList<KnowledgeBase> getKnowledgeBasePagedList() {
		return knowledgeBasePagedList;
	}
	public void setKnowledgeBasePagedList(
			PagedList<KnowledgeBase> knowledgeBasePagedList) {
		this.knowledgeBasePagedList = knowledgeBasePagedList;
	}
	public String getByType() {
		return byType;
	}
	public void setByType(String byType) {
		this.byType = byType;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getKnowledgeBaseList() {
		return knowledgeBaseList;
	}
	public void setKnowledgeBaseList(String knowledgeBaseList) {
		this.knowledgeBaseList = knowledgeBaseList;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageIndex() {
		return pageIndex <= pageCount?pageIndex:pageCount;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public String getKnowledgeBaseDetailUrl() {
		return knowledgeBaseDetailUrl;
	}
	public void setKnowledgeBaseDetailUrl(String knowledgeBaseDetailUrl) {
		this.knowledgeBaseDetailUrl = knowledgeBaseDetailUrl;
	}
	private String knowledgeBaseInfoUrl;
	
	public String getKnowledgeBaseInfoUrl() {
		return knowledgeBaseInfoUrl;
	}
	public void setKnowledgeBaseInfoUrl(String knowledgeBaseInfoUrl) {
		this.knowledgeBaseInfoUrl = knowledgeBaseInfoUrl;
	}
	private int userId;

    public int getUserId() {
		return userId;
	}
    @Override
    public String execute() throws Exception {
    	this.userId=UserHelper.getUserCache().getUserId();
        this.setPageAlias(PageAlias.knowledgeBaseList);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        if (this.getPagePermissionView() != null && this.getPagePermissionView().isCreate()) {
            this.showAddButton = true;
        }

        return SUCCESS;
    }
//	@Override
//    public String execute() throws Exception {
//        this.setPageAlias(PageAlias.knowledgeBaseList);
//        String ret = super.execute();
//        if (!ret.equals(SUCCESS))
//            return ret;
//        this.knowledgeBasePagedList = KnowledgeBaseModel.getPagingList(this.getCondition());
//		totalCount = knowledgeBasePagedList.getPagingInfo().getTotalCount();
//		pageCount = knowledgeBasePagedList.getPagingInfo().getPageCount();
//		this.knowledgeBaseList = UrlHelper.buildEmployeeSiteUrl("employee/knowledgeBase/list?");
//		this.knowledgeBaseDetailUrl=UrlHelper.buildEmployeeSiteUrl("employee/knowledgeBase/edit?id=");
//		this.knowledgeBaseInfoUrl=UrlHelper.buildEmployeeSiteUrl("employee/knowledgeBase/info?id=");
//		if (this.getPagePermissionView() != null && this.getPagePermissionView().isCreate()) {
//            this.showAddButton = true;
//        }
//		for (int i = 0; i < knowledgeBasePagedList.getResultList().size(); i++) {
//			Employee employee=EmployeeModel.getEmpByUserId(knowledgeBasePagedList.getResultList().get(i).getInUserNo());
//			knowledgeBasePagedList.getResultList().get(i).setInUserName(employee.getName());
//			int code=knowledgeBasePagedList.getResultList().get(i).getType();
//			DicData dcData=DicDataModel.getDicDataByTypeAndCode(42, code);
//			knowledgeBasePagedList.getResultList().get(i).setTypeName(dcData.getValue());
//			knowledgeBasePagedList.getResultList().get(i).setUserNo(UserHelper.getEditUserNo());
//		}
//    	//如果录入人id等于当前user可修改
//        return SUCCESS;
//    }
//	public KnowledgeBaseCondition getCondition(){
//		KnowledgeBaseCondition knowledgeBaseCondition = new KnowledgeBaseCondition();
//		knowledgeBaseCondition.setPageIndex(pageIndex);
//		knowledgeBaseCondition.setPageSize(4);
//		knowledgeBaseCondition.getStartIndex();
//		List<SortItem> sortItemList = new ArrayList<SortItem>();
//		 SortItem sortItem = new SortItem();
//		 sortItem.setSortFeild("id");
//		 sortItem.setSortType(SortType.DESC);
//	     sortItemList.add(sortItem);
//	     knowledgeBaseCondition.setSortItemList(sortItemList);
//	        if(!StringHelper.isNullOrEmpty(this.byType)){
//	        	knowledgeBaseCondition.setByType(Byte.valueOf(this.byType));
//	        }
//	        if(!StringHelper.isNullOrEmpty(this.key)){
//	        	knowledgeBaseCondition.setKey(this.key);
//	        }
//		knowledgeBaseCondition.setSortItemList(sortItemList);
//
//
//
//		return knowledgeBaseCondition;
//	}
//
}
