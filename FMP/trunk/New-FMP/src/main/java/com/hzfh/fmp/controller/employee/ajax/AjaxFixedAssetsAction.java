package com.hzfh.fmp.controller.employee.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.baseInfo.model.DicData;
import com.hzfh.api.employee.model.Department;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.employee.model.FixedAssets;
import com.hzfh.api.employee.model.Registration;
import com.hzfh.api.employee.model.query.FixedAssetsCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.employee.DepartmentModel;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.employee.FixedAssetsModel;
import com.hzfh.fmp.model.employee.RegistrationModel;
import com.hzfh.fmp.model.baseInfo.DicDataModel;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class AjaxFixedAssetsAction extends JqGridBaseAction<FixedAssets> {
	private FixedAssets info;
	private Registration rigInfo;
	public FixedAssets getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, FixedAssets.class);
    }
    public Registration getRigInfo() {
        return rigInfo;
    }

    public void setRigInfo(String rigInfo) {
        this.rigInfo = JSON.parseObject(rigInfo, Registration.class);
    }
    private String byAssetId;
    private String byAssetName;
    private String byAssetType;
    private String byStatus;
    private String byLocation;
    private String byDepartment;
    private String byUserNo;
    
    public void setByAssetId(String byAssetId) {
		this.byAssetId = byAssetId;
	}

	public void setByAssetName(String byAssetName) {
		this.byAssetName = byAssetName;
	}

	public void setByAssetType(String byAssetType) {
		this.byAssetType = byAssetType;
	}

	public void setByStatus(String byStatus) {
		this.byStatus = byStatus;
	}

	public void setByLocation(String byLocation) {
		this.byLocation = byLocation;
	}

	public void setByDepartment(String byDepartment) {
		this.byDepartment = byDepartment;
	}

	public void setByUserNo(String byUserNo) {
		this.byUserNo = byUserNo;
	}
//	private List<Byte> ids;
//	private List<String> name;
//	
//	public List<Byte> getIds() {
//		return ids;
//	}
//
//	public List<String> getName() {
//		return name;
//	}

	private String jsonObject;
	
	public String getJsonObject() {
		return jsonObject;
	}
	private String dicNo;

	public void setDicNo(String dicNo) {
		this.dicNo = dicNo;
	}
	private String deptId;

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	@Override
    public String execute(){
    	FixedAssetsCondition fixedAssetsCondition = new FixedAssetsCondition();
        fixedAssetsCondition.setPageSize(this.getPageSize());
        fixedAssetsCondition.setPageIndex(this.getPageIndex());
        
        if(!StringHelper.isNullOrEmpty(this.byAssetId)){
        	fixedAssetsCondition.setAssetId(this.byAssetId);
        }
        if(!StringHelper.isNullOrEmpty(this.byAssetName)){
        	fixedAssetsCondition.setAssetName(this.byAssetName);
        }
        if(!StringHelper.isNullOrEmpty(this.byAssetType)){
        	fixedAssetsCondition.setAssetType(Integer.parseInt(this.byAssetType));
        }
        if(!StringHelper.isNullOrEmpty(this.byStatus)){
        	fixedAssetsCondition.setStatus(Integer.parseInt(this.byStatus));
        }
        if(!StringHelper.isNullOrEmpty(this.byLocation)){
        	fixedAssetsCondition.setLocation(Integer.parseInt(this.byLocation));
        }
        if(!StringHelper.isNullOrEmpty(this.byDepartment)){
        	fixedAssetsCondition.setDepartment(Integer.parseInt(this.byDepartment));
        }
        if(!StringHelper.isNullOrEmpty(this.byUserNo)){
        	fixedAssetsCondition.setUserNo(Integer.parseInt(this.byUserNo));
        }

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        fixedAssetsCondition.setSortItemList(sortItemList);

        PagedList<FixedAssets> fixedAssetsPagedList= FixedAssetsModel.getPagingList(fixedAssetsCondition);
        this.setResultList(fixedAssetsPagedList.getResultList());
        this.setPageCount(fixedAssetsPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(fixedAssetsPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(fixedAssetsPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
			id = FixedAssetsModel.add(info);
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
                    if (FixedAssetsModel.update(info) > 0){
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
            this.info = FixedAssetsModel.getInfo(Integer.parseInt(this.getId()));
            if(this.info!=null){
                this.rigInfo = RegistrationModel.getInfo(Integer.parseInt(this.info.getRegistrationId()));
            }
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }
	public String getAssetTypeList() {
		List<DicData> list = new ArrayList<DicData>();
		list = DicDataModel.getDicDataListByType(Integer.parseInt(this.dicNo));
		JSONObject juser = null;
		String jsonString = "";
		for (int i =0;i<list.size();i++) {
			DicData dicData = list.get(i);
			juser=JSONObject.fromObject(dicData);
			jsonString=jsonString+juser+",";
		}
		jsonString = "["+jsonString.substring(0,jsonString.length()-1)+"]";
		this.jsonObject = jsonString;
        return SUCCESS;
    }
	public String getDeptList() {
		List<Department> list = DepartmentModel.getList();
		JSONObject juser = null;
		String jsonString = "";
		for (int i =0;i<list.size();i++) {
			Department dicData = list.get(i);
			juser=JSONObject.fromObject(dicData);
			jsonString=jsonString+juser+",";
		}
		jsonString = "["+jsonString.substring(0,jsonString.length()-1)+"]";
		this.jsonObject = jsonString;
        return SUCCESS;
    }
    public String getEmpList() {
    	List<Employee> list = new ArrayList<Employee>();
    	if(StringHelper.isNullOrEmpty(this.deptId)  ||  this.deptId.equals("0")){
    		list = EmployeeModel.getList();
    	}else{
    		list = EmployeeModel.getEmpListByDept(Integer.parseInt(this.deptId));
    	}
		JSONObject juser = null;
		String jsonString = "";
		for (int i =0;i<list.size();i++) {
			Employee dicData = list.get(i);
			juser=JSONObject.fromObject(dicData);
			jsonString=jsonString+juser+",";
		}
		jsonString = "["+jsonString.substring(0,jsonString.length()-1)+"]";
		this.jsonObject = jsonString;
        return SUCCESS;
    }

}
