package com.hzfh.p2p.controller.customer.ajax;

import com.hzfh.api.employee.model.Department;
import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.baseInfo.DepartmentModel;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.helper.UrlHelper;
import com.hzfh.p2p.model.common.parameter.StatusType;

public class AjaxStoreAction extends CommonAction {

	private Department info;
	public Department getInfo() {
        return info;
    }
	private String id;
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	private String mapUrl;
	
	public String getMapUrl() {
		return mapUrl;
	}

	public String getInfoById() {
		this.setPageAlias(PageAlias.storeDetail);
		String ret = super.execute();
		if (!ret.equals(SUCCESS))
			return ret;
		
		this.info = DepartmentModel.getInfo(Integer.parseInt(this.getId()));
		if(this.info.getDeptType()!=StatusType.STORE){
			return ERROR;
		}
        
        info.setDepartmentImagePath(UrlHelper.bulidWebUploadPath(info.getDepartmentImagePath()));
        info.setLocationImagePath(UrlHelper.bulidWebUploadPath(info.getLocationImagePath()));
        this.mapUrl = UrlHelper.buildWWWSiteUrl(PageAlias.baiduMap)+"?id="+info.getId();
        /*if(info==null){
        	return SUCCESS;
        }*/
        /*List<DicData> dicList = DicDataModel.getDicDataListByType(StatusType.BULLETINSTATE);
        for(DicData d:dicList){
        	if(d.getCode()==info.getType()){
        		info.setTypeValue(d.getValue());
        		break;
        	}
        }*/
        return SUCCESS;
    }
}
