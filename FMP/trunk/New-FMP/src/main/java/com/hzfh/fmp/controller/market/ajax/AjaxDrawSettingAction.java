package com.hzfh.fmp.controller.market.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.market.model.ActivityUsers;
import com.hzfh.api.market.model.DrawSetting;
import com.hzfh.api.market.model.query.DrawSettingCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.market.ActivityUsersModel;
import com.hzfh.fmp.model.market.DrawSettingModel;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxDrawSettingAction extends JqGridBaseAction<DrawSetting> {
	
	private List<ActivityUsers> activityUsers;
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public List<ActivityUsers> getActivityUsers() {
		return activityUsers;
	}

	public void setActivityUsers(List<ActivityUsers> activityUsers) {
		this.activityUsers = activityUsers;
	}
	private String checkValue;
	public String getCheckValue() {
		return checkValue;
	}

	public void setCheckValue(String checkValue) {
		this.checkValue = checkValue;
	}
	private DrawSetting info;
	public DrawSetting getInfo() {
        return info;
    }
	private int delUserid;
    public int getDelUserid() {
		return delUserid;
	}
	public void setDelUserid(int delUserid) {
		this.delUserid = delUserid;
	}
	public void setInfo(String info) {
        this.info = JSON.parseObject(info, DrawSetting.class);
    }
	private String hidRoundSetting;



	public String getHidRoundSetting() {
		return hidRoundSetting;
	}

	public void setHidRoundSetting(String hidRoundSetting) {
		this.hidRoundSetting = hidRoundSetting;
	}
	private String hidselSetting;
	

	public String getHidselSetting() {
		return hidselSetting;
	}

	public void setHidselSetting(String hidselSetting) {
		this.hidselSetting = hidselSetting;
	}

	@Override
    public String execute(){
    	DrawSettingCondition drawSettingCondition = new DrawSettingCondition();
        drawSettingCondition.setPageSize(this.getPageSize());
        drawSettingCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        drawSettingCondition.setSortItemList(sortItemList);

        PagedList<DrawSetting> drawSettingPagedList= DrawSettingModel.getPagingList(drawSettingCondition);
        this.setResultList(drawSettingPagedList.getResultList());
        this.setPageCount(drawSettingPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(drawSettingPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(drawSettingPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
			id = DrawSettingModel.add(info);
            if (id > 0){
				this.setErrDesc(String.valueOf(id));                
            }else{
				this.setErrCode("add failed");
                this.setErrDesc("add failed");
			}
            if(!StringHelper.isNullOrEmpty(checkValue) ){
            	activityUsers = new ArrayList<ActivityUsers>();
    			String [] arrId =checkValue.split(",");
    			for(int i=0;i<arrId.length;i++){
    				ActivityUsers actUsers = ActivityUsersModel.getInfo(Integer.parseInt(arrId[i]));
    				actUsers.setDrawNo(id);
    				ActivityUsersModel.update(actUsers);
    				activityUsers.add(actUsers);
    			}
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
                    if (DrawSettingModel.update(info) > 0){
						this.setErrDesc(String.valueOf(info.getId()));
						int updateId = info.getId();
						 List<ActivityUsers> cleanUserList =  ActivityUsersModel.getIntrinsicUsersByDrawNo(updateId);//先执行清空，后更新用户集合
						 for(int i=0;i<cleanUserList.size();i++){
							 ActivityUsers actUsers = cleanUserList.get(i);
			    				actUsers.setDrawNo(0);//清空
			    				ActivityUsersModel.update(actUsers);
						 }
			            if(!StringHelper.isNullOrEmpty(checkValue) ){
			            	activityUsers = new ArrayList<ActivityUsers>();
			    			String [] arrId =checkValue.split(",");
			    			for(int i=0;i<arrId.length;i++){
			    				ActivityUsers actUsers = ActivityUsersModel.getInfo(Integer.parseInt(arrId[i]));
			    				actUsers.setDrawNo(updateId);
			    				ActivityUsersModel.update(actUsers);
			    				activityUsers.add(actUsers);
			    			}
			    		}
						
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
            this.info = DrawSettingModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }
	public String ajaxGetDrawSettingInfo() {
		
		activityUsers = new ArrayList<ActivityUsers>();
		if(!StringHelper.isNullOrEmpty(checkValue) ){
			String [] arrId =checkValue.split(",");
			for(int i=0;i<arrId.length;i++){
				activityUsers.add(ActivityUsersModel.getInfo(Integer.parseInt(arrId[i])));
			}
		}else{
			//hidselSetting = 
			List<DrawSetting> setting =  DrawSettingModel.getInfoListByStatus(1);
			if(setting.size()>0){
				hidRoundSetting = "";
				for (DrawSetting drawSetting : setting) {
					hidRoundSetting += drawSetting.getRound()+",";
				}
				hidRoundSetting = hidRoundSetting.substring(0,hidRoundSetting.length()-1);
			}
			
		}

        return SUCCESS;
    }
	public String ajaxDeldrawUser() {
		
		activityUsers = new ArrayList<ActivityUsers>();
		String newCheckVale="";
		if(!StringHelper.isNullOrEmpty(checkValue) ){
			String [] arrId =checkValue.split(",");
			for(int i=0;i<arrId.length;i++){
				if(Integer.parseInt(arrId[i])!=delUserid){
					newCheckVale+=arrId[i]+",";
					activityUsers.add(ActivityUsersModel.getInfo(Integer.parseInt(arrId[i])));
				}
			}
		}
		checkValue=newCheckVale;

        return SUCCESS;
    }
	public String getInfoListByUsername()  {
		activityUsers = new ArrayList<ActivityUsers>();
		int drawNo =0;
		if(!StringHelper.isNullOrEmpty(checkValue) ){
			List<Integer>  idList= new ArrayList<Integer>();
			String [] arrId =checkValue.split(",");
			for(int i=0;i<arrId.length;i++){
				idList.add(Integer.parseInt(arrId[i]));
			}
			checkValue = checkValue.substring(0,checkValue.length()-1);
			if(!StringHelper.isNullOrEmpty(userName)){
				List<ActivityUsers> listuser = ActivityUsersModel.getInfoByUsernameAndIds(userName,idList,drawNo);
				if(listuser!=null){
					activityUsers=listuser;
				}
			}else{
				activityUsers = ActivityUsersModel.getListByIds(checkValue,idList,drawNo);
			}
		}else{
			if(!StringHelper.isNullOrEmpty(userName)){
				List<ActivityUsers> listuser = ActivityUsersModel.getInfoByUsername(userName,drawNo);
				if(listuser!=null){
					activityUsers=listuser;
				}
			}else{
				activityUsers = ActivityUsersModel.getListByDrawNo(drawNo);
			}
		}
/*		for (ActivityUsers actUser : activityUsers) {
			actUser.setUserImgPath("http://upload.chineseinvestor.com.cn/files"+actUser.getUserImgPath());
		}*/
        return SUCCESS;
    }

}
