package com.hzfh.fmp.controller.employee.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.Department;
import com.hzfh.api.employee.model.DeptYearNeedDetail;
import com.hzfh.api.employee.model.Position;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.DepartmentModel;
import com.hzfh.fmp.model.employee.DeptYearNeedDetailModel;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.employee.PositionModel;
import com.hzframework.helper.StringHelper;

import java.util.List;


public class AjaxDeptYearNeedDetailAction extends JqGridBaseAction<DeptYearNeedDetail> {
	private List<Position>  positionList;
	   private int param;
	public List<Position> getPositionList() {
		return positionList;
	}


	public void setPositionList(List<Position> positionList) {
		this.positionList = positionList;
	}


	public int getParam() {
		return param;
	}


	public void setParam(int param) {
		this.param = param;
	}
	private DeptYearNeedDetail info;
	public DeptYearNeedDetail getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, DeptYearNeedDetail.class);
    }

    @Override
    public String execute() throws Exception{
    	List<Department> deptTypes=DepartmentModel.getDeptTypeBydeptNo(param);
		if(deptTypes!=null){
			this.positionList=PositionModel.getPositionListBydept(deptTypes.get(0).getDeptType());
		}
    	for (int i = 0; i < positionList.size(); i++) {
			int nowPositionEmp=EmployeeModel.getNowEmpListByPositionNo(positionList.get(i).getId()).size();
			positionList.get(i).setNowPositionEmp(nowPositionEmp);
		}
    	return SUCCESS;
 
    }

    public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
			id = DeptYearNeedDetailModel.add(info);
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
                    if (DeptYearNeedDetailModel.update(info) > 0){
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
            this.info = DeptYearNeedDetailModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

}
