package com.hzfh.fmp.controller.baseInfo.ajax;

import com.hzfh.api.baseInfo.model.DicData;
import com.hzfh.api.baseInfo.model.query.DicDataCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.baseInfo.DicDataModel;
import com.hzfh.fmp.model.common.helper.FlushCacheHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxDicDataAction extends JqGridBaseAction<DicData> {
    
	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	private String dicTypeNo;
	public String getDicTypeNo() {
		return dicTypeNo;
	}
	public void setDicTypeNo(String dicTypeNo) {
		this.dicTypeNo = dicTypeNo;
	}
	private String value;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

    @Override
    public String execute() throws Exception{
    	DicDataCondition dicDataCondition = new DicDataCondition();
        dicDataCondition.setPageSize(this.getPageSize());
        dicDataCondition.setPageIndex(this.getPageIndex());

        if (StringHelper.isNullOrEmpty(this.dicTypeNo))
            dicDataCondition.setDicTypeNo(0);
        else
            dicDataCondition.setDicTypeNo(Integer.parseInt(this.dicTypeNo));

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        dicDataCondition.setSortItemList(sortItemList);

        PagedList<DicData> dicDataPagedList= DicDataModel.getPagingList(dicDataCondition);
        this.setResultList(dicDataPagedList.getResultList());
        this.setPageCount(dicDataPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(dicDataPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(dicDataPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
        DicData dicData = new DicData();
        
		dicData.setCode(Byte.valueOf(this.code));
		dicData.setDicTypeNo(Integer.parseInt(this.dicTypeNo));
		dicData.setValue(this.value);
		dicData.setEditComment(this.getEditComment());
        dicData.setEditUserNo(UserHelper.getEditUserNo());

        if (this.getOper().equalsIgnoreCase("add")) {
            dicData.setInUserNo(UserHelper.getEditUserNo());
            if (DicDataModel.add(dicData )<=0){
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
                    dicData.setId(Integer.parseInt(this.getId()));
                    if (DicDataModel.update(dicData) <= 0){
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                    }
                }
            }
        }

        return SUCCESS;
    }
    
    
    public String flushDicDataMemcached(){
    	if (StringHelper.isNullOrEmpty(this.dicTypeNo)) {
    		this.setErrCode("NO");
            this.setErrDesc("NO");
    		return SUCCESS;
		}
    	if (this.dicTypeNo.equals("0")) {
    		FlushCacheHelper.flushEnumListForDictionary();	
		}else{
			FlushCacheHelper.getDicDataListByType(Integer.parseInt(this.dicTypeNo));
		}
    	this.setErrCode("OK");
        this.setErrDesc("OK");
    	return SUCCESS;
    }
    
    
    
    
    
    
    

}
