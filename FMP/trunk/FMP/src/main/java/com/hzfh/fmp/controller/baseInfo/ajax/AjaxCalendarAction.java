package com.hzfh.fmp.controller.baseInfo.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.baseInfo.model.Calendar;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.baseInfo.CalendarModel;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzframework.helper.StringHelper;

import java.io.IOException;
import java.util.List;


public class AjaxCalendarAction extends JqGridBaseAction<Calendar> {
    private String xml;

    public String getXml() {
        return xml;
    }

    private Calendar info;

    public Calendar getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, Calendar.class);
    }

    @Override
    public String execute() throws IOException {
        List<Calendar> calendarList = CalendarModel.getList();
        this.xml = "<data>";
        for (int i = 0; i < calendarList.size(); i++) {
            int userNo = calendarList.get(i).getUserNo();
            int state = calendarList.get(i).getState();
            if (userNo == UserHelper.getEditUserNo() || state == 2) {
                Calendar calendar = new Calendar();
                calendar = calendarList.get(i);
                this.xml += "<event id='" + calendar.getId() + "' ";
                this.xml += "start_date='" + calendar.getStartTime() + "' ";
                this.xml += "end_date='" + calendar.getEndTime() + "' ";
                this.xml += "text='" + calendar.getTheme() + "' ";
                this.xml += "details='" + calendar.getContent() + "' ";
                this.xml += "type='" + calendar.getState() + "' />";
            }
        }
        this.xml += "</data>";
        return SUCCESS;
    }

    public String edit() {
        info.setEditUserNo(UserHelper.getEditUserNo());
        int id = 0;
        if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
            info.setUserNo(UserHelper.getEditUserNo());
            id = CalendarModel.add(info);
            if (id <= 0) {
                this.setErrCode("add failed");
                this.setErrDesc("add failed");
                return SUCCESS;
            }
            this.setErrDesc(info.getStartTime().toString());

        } else {
            if (info.getId() == 0) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
                return SUCCESS;
            }
            if (this.getOper().equalsIgnoreCase("edit")) {
                Calendar calendar = new Calendar();
                calendar = CalendarModel.getInfo(info.getId());
                info.setUserNo(calendar.getUserNo());
                if (calendar.getUserNo() != UserHelper.getEditUserNo()) {
                    if (CalendarModel.update(info) <= 0) {
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                        return  SUCCESS;
                    }
                    this.setErrDesc(info.getStartTime().toString());

                } else {
                    this.setErrDesc("没有修改权限" + "@" + info.getStartTime().toString());
                }

            } else if (this.getOper().equalsIgnoreCase("delete")) {
                Calendar calendar = new Calendar();
                calendar = CalendarModel.getInfo(info.getId());
                if (calendar.getUserNo() == UserHelper.getEditUserNo()) {
                    if (CalendarModel.deleteInfo(info.getId()) <= 0) {
                    	this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                        return  SUCCESS;
                    } 
                        this.setErrDesc(info.getStartTime().toString());
                } else {
                    this.setErrDesc("没有删除权限" + "@" + info.getStartTime().toString());
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
            this.info = CalendarModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

}
