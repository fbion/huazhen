package com.hzfh.fmp.controller.employee.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.TempRecruitDetail;
import com.hzfh.api.employee.model.TempRecruitNeed;
import com.hzfh.api.employee.model.query.TempRecruitNeedCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.DepartmentModel;
import com.hzfh.fmp.model.employee.TempRecruitDetailModel;
import com.hzfh.fmp.model.employee.TempRecruitNeedModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxTempRecruitNeedAction extends JqGridBaseAction<TempRecruitNeed> {
	private TempRecruitNeed info;
	private int byYear;
    private String bySelectDepartment;
    private String byCode;
	public TempRecruitNeed getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = JSON.parseObject(info, TempRecruitNeed.class);
    }
    private TempRecruitDetail detailInfo;
    public TempRecruitDetail getDetailInfo() {
		return detailInfo;
	}

	public void setDetailInfo(String detailInfo) {
		this.detailInfo = JSON.parseObject(detailInfo,TempRecruitDetail.class);
	}

	private int  activitiStatus;
    
    public int getActivitiStatus() {
		return activitiStatus;
	}
	public void setActivitiStatus(int activitiStatus) {
		this.activitiStatus = activitiStatus;
	}
	
	public String getByCode() {
		return byCode;
	}
	public void setByCode(String byCode) {
		this.byCode = byCode;
	}
	
	public int getByYear() {
		return byYear;
	}
	public void setByYear(int byYear) {
		this.byYear = byYear;
	}
	public String getBySelectDepartment() {
		return bySelectDepartment;
	}
	public void setBySelectDepartment(String bySelectDepartment) {
		this.bySelectDepartment = bySelectDepartment;
	}
	
	private String empName;
    public String getEmpName() {
		return empName;
	}
    private String activitiID;
    
    public void setActivitiID(String activitiID) {
		this.activitiID = activitiID;
	}
	private TempRecruitNeedCondition getCondition() {
		TempRecruitNeedCondition tempRecruitNeedCondition = new TempRecruitNeedCondition();
		tempRecruitNeedCondition.setPageSize(this.getPageSize());
		tempRecruitNeedCondition.setPageIndex(this.getPageIndex());
	    
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        tempRecruitNeedCondition.setSortItemList(sortItemList);
        if(this.byYear>0){
        	tempRecruitNeedCondition.setFinancialYear(this.byYear);
        }
        if(!StringHelper.isNullOrEmpty(this.byCode)){
        	tempRecruitNeedCondition.setCode(this.byCode);
        }
        if(!StringHelper.isNullOrEmpty(this.bySelectDepartment)){
        	tempRecruitNeedCondition.setDeptNo(Byte.valueOf(this.bySelectDepartment));
        }
		return tempRecruitNeedCondition;
	}
	@Override
    public String execute() throws Exception{
        PagedList<TempRecruitNeed> tempRecruitNeedPagedList= TempRecruitNeedModel.getPagingList(this.getCondition());
        this.setResultList(tempRecruitNeedPagedList.getResultList());
        this.setPageCount(tempRecruitNeedPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(tempRecruitNeedPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(tempRecruitNeedPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }
    public String edit(){
		
		if (this.getOper().equalsIgnoreCase("add")) {
			try {
				info.setEditUserNo(UserHelper.getEditUserNo());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			int id = 0;
			int id1=0;
            info.setInUserNo(UserHelper.getEditUserNo());
            try {
            	  int companyNo=DepartmentModel.getInfo(detailInfo.getDeptNo()).getCompanyNo();
                  info.setCompanyNo(companyNo);
			} catch (Exception e) {
				e.printStackTrace();
			}
            id = TempRecruitNeedModel.add(info);
             try {
            	detailInfo.setEditUserNo(UserHelper.getEditUserNo());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
            detailInfo.setInUserNo(UserHelper.getEditUserNo());
            detailInfo.setTempRecruitNeedNo(id);
            id1=TempRecruitDetailModel.add(detailInfo);
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
            	if(!StringHelper.isNullOrEmpty(this.activitiID)){
            		info.setActivitiNo(this.activitiID);
            	}
                if (this.getOper().equalsIgnoreCase("edit")) {   
                	 try {
                   	   int companyNo=DepartmentModel.getInfo(detailInfo.getDeptNo()).getCompanyNo();
		               info.setCompanyNo(companyNo);
		       			} catch (Exception e) {
		       				e.printStackTrace();
		       			}
                	 int infoUpdate=TempRecruitNeedModel.update(info);
                	 System.out.println(info.getId());
                	 try {
                		 detailInfo.setTempRecruitNeedNo(info.getId());
                		 int detailUpdate=TempRecruitDetailModel.updateByNeedNo(detailInfo);
                		 if (infoUpdate > 0&&detailUpdate>0){
     						this.setErrDesc(String.valueOf(info.getId()));
     						this.setErrDesc(String.valueOf(detailInfo.getId()));
                         }else{
     						this.setErrCode("update failed");
                             this.setErrDesc("update failed");
     					}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
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
            this.info = TempRecruitNeedModel.getInfo(Integer.parseInt(this.getId()));
            this.detailInfo=TempRecruitDetailModel.getInfoByNeedNo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }
        this.empName = UserHelper.getUserCache().getEmpName();
        return SUCCESS;
    }

}
