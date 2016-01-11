package com.hzfh.p2p.controller.baseInfo;

import java.util.ArrayList;
import java.util.List;

import com.hzfh.api.baseInfo.model.Announcement;
import com.hzfh.api.baseInfo.model.DicData;
import com.hzfh.api.baseInfo.model.query.AnnouncementCondition;
import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.baseInfo.AnnouncementModel;
import com.hzfh.p2p.model.baseInfo.DicDataModel;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.helper.UrlHelper;
import com.hzfh.p2p.model.common.parameter.StatusType;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;

public class BulletinAction extends CommonAction {
	private String oper;
	public String getOper() {
		return oper;
	}
	public void setOper(String oper) {
		this.oper = oper;
	}
	

	private List<Announcement> announcementList;
	public List<Announcement> getAnnouncementList() {
		return announcementList;
	}

	public void setAnnouncementList(List<Announcement> announcementList) {
		this.announcementList = announcementList;
	}
	
	private int pageIndex=1;
	private PagedList<Announcement> PagedAnnouncementList;
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

	public PagedList<Announcement> getPagedAnnouncementList() {
		return PagedAnnouncementList;
	}

	public void setPagedAnnouncementList(
			PagedList<Announcement> pagedAnnouncementList) {
		PagedAnnouncementList = pagedAnnouncementList;
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
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
	
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String execute() {
		this.setPageAlias(PageAlias.bulletin);
		String ret = super.execute();
		if (!ret.equals(SUCCESS))
			return ret;
		
		List<SortItem> sortItemList = new ArrayList<SortItem>();
        
    	SortItem sortItem = new SortItem();
    	sortItem.setSortFeild("id");
    	sortItem.setSortType(SortType.DESC);
    	sortItemList.add(sortItem);
    
    	AnnouncementCondition announcementCondition = new AnnouncementCondition();
		announcementCondition.setPageSize(10);
        announcementCondition.setPageIndex(pageIndex);
        announcementCondition.setSortItemList(sortItemList);
        
        PagedList<Announcement> announcementPagedList= AnnouncementModel.getPagingList(announcementCondition);
        this.setAnnouncementList(announcementPagedList.getResultList());
        List<DicData> dicDaList = DicDataModel.getDicDataListByType(StatusType.BULLETINSTATE);
        for(Announcement a:announcementList){
        	for(int i=0;i<dicDaList.size();i++){
        		if(a.getType()==dicDaList.get(i).getCode()){
        			a.setTypeValue(dicDaList.get(i).getValue());
        			break;
        		}
        	}
        }
        this.setPageCount(announcementPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(announcementPagedList.getPagingInfo().getPageIndex());
        totalCount = announcementPagedList.getPagingInfo().getTotalCount();
        
        this.pageUrl = UrlHelper.buildWWWSiteUrl(PageAlias.bulletin)+"?1=1";
		return SUCCESS;
	}
}
