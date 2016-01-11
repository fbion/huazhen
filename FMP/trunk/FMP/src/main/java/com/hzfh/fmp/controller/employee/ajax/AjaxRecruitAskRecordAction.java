package com.hzfh.fmp.controller.employee.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.employee.model.Position;
import com.hzfh.api.employee.model.RecruitAskRecord;
import com.hzfh.api.employee.model.query.RecruitAskRecordCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.baseInfo.SmsModel;
import com.hzfh.fmp.model.common.helper.ExcelHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.employee.PositionModel;
import com.hzfh.fmp.model.employee.RecruitAskRecordModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxRecruitAskRecordAction extends JqGridBaseAction<RecruitAskRecord> {
	private RecruitAskRecord info;
	public RecruitAskRecord getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, RecruitAskRecord.class);
    }

    private String byName;
    private String bySelectPositionNo;
    private String byIsInterview;
    private String byIsEmploy;
    private String byYear;
    private String byMonth;
    private String showAllList;
    private String byInUserNo;

    public String getByInUserNo() {
        return byInUserNo;
    }

    public void setByInUserNo(String byInUserNo) {
        this.byInUserNo = byInUserNo;
    }

    public String getByName() {
		return byName;
	}

	public void setByName(String byName) {
		this.byName = byName;
	}

	public String getBySelectPositionNo() {
		return bySelectPositionNo;
	}

	public void setBySelectPositionNo(String bySelectPositionNo) {
		this.bySelectPositionNo = bySelectPositionNo;
	}

	public String getByIsInterview() {
		return byIsInterview;
	}

	public void setByIsInterview(String byIsInterview) {
		this.byIsInterview = byIsInterview;
	}

	public String getByIsEmploy() {
		return byIsEmploy;
	}

	public void setByIsEmploy(String byIsEmploy) {
		this.byIsEmploy = byIsEmploy;
	}

	public String getByYear() {
		return byYear;
	}

	public void setByYear(String byYear) {
		this.byYear = byYear;
	}

	public String getByMonth() {
		return byMonth;
	}

	public void setByMonth(String byMonth) {
		this.byMonth = byMonth;
	}

	public String getShowAllList() {
		return showAllList;
	}

	public void setShowAllList(String showAllList) {
		this.showAllList = showAllList;
	}
	private String firstShowAllList;
	public String getFirstShowAllList() {
		return firstShowAllList;
	}
	public void setFirstShowAllList(String firstShowAllList) {
		this.firstShowAllList = firstShowAllList;
	}
	private String fileName;
	private String filePath;
	private String fileType;
	private RecruitAskRecord recruitAskRecordFile;
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public RecruitAskRecord getRecruitAskRecordFile() {
		return recruitAskRecordFile;
	}

	public void setRecruitAskRecordFile(RecruitAskRecord recruitAskRecordFile) {
		this.recruitAskRecordFile = recruitAskRecordFile;
	}

	private String inEmpName;
	public String getInEmpName() {
		return inEmpName;
	}

	public void setInEmpName(String inEmpName) {
		this.inEmpName = inEmpName;
	}

	private RecruitAskRecordCondition getCondition() {
		RecruitAskRecordCondition recruitAskRecordCondition = new RecruitAskRecordCondition();
        recruitAskRecordCondition.setPageSize(this.getPageSize());
        recruitAskRecordCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        recruitAskRecordCondition.setSortItemList(sortItemList);
        
        if ("query".equals(this.showAllList)) {
        	recruitAskRecordCondition.setWorkMateString(null);
        }else{
        	List<Integer> workmate = UserHelper.getUserCache().getWorkMate();
            if (workmate != null) {
                workmate.add(UserHelper.getUserCache().getUserId());
                String workMateString = StringHelper.listToString(workmate);
                recruitAskRecordCondition.setWorkMateString(workMateString);
            } else {
            	recruitAskRecordCondition.setWorkMateString(String.valueOf(UserHelper.getUserCache().getUserId()));
            }
//            List<Integer> workmate = UserHelper.getUserCache().getWorkMate();
//            if (workmate != null) {
//            	List<Integer> workmateEmpNoList = new ArrayList<Integer>();
//            	for(int i=0;i<workmate.size();i++){
//            		int empNo = EmployeeModel.getEmpByUserId(workmate.get(i)).getId(); 
//            		workmateEmpNoList.add(empNo);
//            	}
//            	workmateEmpNoList.add(EmployeeModel.getEmpByUserId(UserHelper.getUserCache().getUserId()).getId());
//                String workMateString = StringHelper.listToString(workmateEmpNoList);
//                recruitAskRecordCondition.setWorkMateString(workMateString);
//            } else {
//            	recruitAskRecordCondition.setWorkMateString(String.valueOf(EmployeeModel.getEmpByUserId(UserHelper.getUserCache().getUserId()).getId()));
//            }
        }
        if(!StringHelper.isNullOrEmpty(this.byName)){
        	recruitAskRecordCondition.setName(this.byName);
        }
        if(!StringHelper.isNullOrEmpty(this.byInUserNo)){
            recruitAskRecordCondition.setByInUserNo(Integer.parseInt(this.byInUserNo));
        }
        if(!StringHelper.isNullOrEmpty(this.bySelectPositionNo)){
        	recruitAskRecordCondition.setPositionNo(Integer.valueOf(this.bySelectPositionNo));
        }
        if(!StringHelper.isNullOrEmpty(this.byIsInterview)){
        	recruitAskRecordCondition.setIsInterview(Integer.valueOf(this.getByIsInterview()));
        }
        if(!StringHelper.isNullOrEmpty(this.byIsEmploy)){
        	recruitAskRecordCondition.setIsEmploy(Integer.valueOf(this.getByIsEmploy()));
        }
        if(!StringHelper.isNullOrEmpty(this.byYear)&&!"".equals(this.byYear)&&!"0".equals(this.byYear)){
        	if(StringHelper.isNullOrEmpty(this.byMonth)||"".equals(this.byMonth)||"0".equals(this.byMonth)){
        		recruitAskRecordCondition.setDateDown(this.byYear+"-"+"01"+"-"+"01");
        		recruitAskRecordCondition.setDateUp(Integer.valueOf(this.byYear)+1+"-"+"01"+"-"+"01");
        	}else{
        		recruitAskRecordCondition.setDateDown(this.byYear+"-"+this.byMonth+"-"+"01");
        		int nextMonth = Integer.valueOf(this.byMonth);
        		if(Integer.valueOf(this.byMonth)<12){
        			nextMonth = Integer.valueOf(this.byMonth)+1;
        		}else{
        			nextMonth=1;
        			this.byYear = Integer.valueOf(this.byYear)+1+"";
        		}
        		recruitAskRecordCondition.setDateUp(this.byYear+"-"+nextMonth+"-"+"01");
        	}
        }
		return recruitAskRecordCondition;
	}

	@Override
    public String execute() throws Exception{
        PagedList<RecruitAskRecord> recruitAskRecordPagedList= RecruitAskRecordModel.getPagingList(this.getCondition());
        this.setResultList(recruitAskRecordPagedList.getResultList());
        this.setPageCount(recruitAskRecordPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(recruitAskRecordPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(recruitAskRecordPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    private String id;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    private String invitationTime;

    public String getInvitationTime() {
        return invitationTime;
    }

    public void setInvitationTime(String invitationTime) {
        this.invitationTime = invitationTime;
    }

    public String sms(){
        RecruitAskRecord recruitAskRecord = RecruitAskRecordModel.getInfo(Integer.parseInt(this.id));
        recruitAskRecord.getName();
        String title = PositionModel.getInfo(recruitAskRecord.getPositionNo()).getName();
        String cellPhone = recruitAskRecord.getCellphone();
        String address = "北京市朝阳区东三环中路5号FFC大厦30层";
        //String time = year+"年"+month+"月"+day+"日";
        Employee employee = EmployeeModel.getInfo(UserHelper.getUserCache().getEmpId());
        SmsModel.smsInterviewInvitation(cellPhone,title,invitationTime,address,employee.getName()
                    ,employee.getTelephone(),employee.getCellphone1());

        return SUCCESS;
    }
    public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
			inEmpName = EmployeeModel.getEmpByUserId(UserHelper.getEditUserNo()).getName();
            info.setInUserNo(UserHelper.getEditUserNo());
			id = RecruitAskRecordModel.add(info);
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
                    if (RecruitAskRecordModel.update(info) > 0){
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
            this.info = RecruitAskRecordModel.getInfo(Integer.parseInt(this.getId()));
            inEmpName = EmployeeModel.getEmpByUserId(info.getInUserNo()).getName();
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }
	
	public String exportExcel(){
		ExcelHelper excelHelper =  new ExcelHelper();
		excelHelper.getExcelForRecruitAskRecord(this.getCondition(), this.showAllList);
		
		return null;
	}
	
	//文件上传
	public String uploadFile() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
            int fileID = RecruitAskRecordModel.updateResumeAttachmentById(this.getFilePath(),Integer.valueOf(this.getId()));
            if (fileID > 0)
            	this.setErrDesc(this.fileName);
            else {
                this.setErrCode("upload failed");
                this.setErrDesc("NoID");
            }
        }
        this.setErrCode("1");
        return SUCCESS;
    }

    public String deleteFile() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
            if (RecruitAskRecordModel.updateResumeAttachmentById(this.getFilePath(),Integer.valueOf(this.getId())) < 0){
                this.setErrCode("deleteFailed");
                this.setErrDesc("deleteFailed");
            }else{
            	fileName = "您没有上传简历！";
            	this.setErrDesc(this.fileName);
            }
        }
        return SUCCESS;
    }

    public String getFileList() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
            this.setRecruitAskRecordFile((RecruitAskRecordModel.getInfo(Integer.valueOf(this.getId()))));
        }
        return SUCCESS;
    }

}
