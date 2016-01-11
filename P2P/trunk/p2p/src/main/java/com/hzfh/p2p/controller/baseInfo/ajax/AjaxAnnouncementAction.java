package com.hzfh.p2p.controller.baseInfo.ajax;

import java.util.ArrayList;
import java.util.List;

import com.hzfh.api.baseInfo.model.Announcement;
import com.hzfh.api.baseInfo.model.query.AnnouncementCondition;
import com.hzfh.p2p.controller.common.BaseAction;
import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.baseInfo.AnnouncementModel;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.helper.UrlHelper;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.StringHelper;


public class AjaxAnnouncementAction extends CommonAction {
	/*private Announcement info;
	public Announcement getInfo() {
        return info;
    }
	private String id;
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	private String errCode;
    private String errDesc;
	public String getErrCode() {
		return errCode;
	}


	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}


	public String getErrDesc() {
		return errDesc;
	}

	public void setErrDesc(String errDesc) {
		this.errDesc = errDesc;
	}*/

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

	private String announcementListUrl;
	public String getAnnouncementListUrl() {
		return announcementListUrl;
	}

	@Override
    public String execute(){
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
        this.setPageCount(announcementPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(announcementPagedList.getPagingInfo().getPageIndex());
        totalCount = announcementPagedList.getPagingInfo().getTotalCount();
        return SUCCESS;
    }


	/*public String getInfoById() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
            this.info = AnnouncementModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }*/

	public String getAnnouncementTitleList(){
		List<SortItem> sortItemList = new ArrayList<SortItem>();
    	SortItem sortItem = new SortItem();
    	sortItem.setSortFeild("id");
    	sortItem.setSortType(SortType.DESC);
    	sortItemList.add(sortItem);
    	
    	AnnouncementCondition announcementCondition = new AnnouncementCondition();
    	announcementCondition.setPageIndex(1);
		announcementCondition.setPageSize(3);
		announcementCondition.setSortItemList(sortItemList);
        
		try {
			this.announcementList = AnnouncementModel.getAnnouncementTitleList(announcementCondition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		announcementListUrl = UrlHelper.buildWWWSiteUrl(PageAlias.bulletin);
        for(int i=0;i<announcementList.size();i++){
        	announcementList.get(i).setLinkurl(announcementListUrl+"?id="+announcementList.get(i).getId());
        }
		return SUCCESS;
	}
}
