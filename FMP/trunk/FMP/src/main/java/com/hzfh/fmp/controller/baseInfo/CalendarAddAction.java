package com.hzfh.fmp.controller.baseInfo;

import java.sql.Timestamp;

import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.permission.view.TagPermissionView;

public class CalendarAddAction extends CommonAction {
//    public boolean showEditButton;
//
//    public boolean isShowEditButton() {
//        return showEditButton;
//    }
//
//    public boolean showSubmitButton;
//    
//    public boolean isShowSubmitButton() {
//        return showSubmitButton;
//    }
//
//    private String pageVar;
//
//    public String getPageVar() {
//        return pageVar;
//    }

    private int id;

    public void setId(int id) {
        this.id = id;
    }
    private int userNo;
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	private String content;
	public void setContent(String content) {
		this.content = content;
	}
	private Timestamp startTime;
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	private Timestamp endTime;
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	private int state;
	public void setState(int state) {
		this.state = state;
	}
	private String theme;
	public void setTheme(String theme) {
		this.theme = theme;
	}

    @Override
    public String execute() throws Exception {
    	System.out.println("******************************"+this.theme);
        this.setPageAlias(PageAlias.calendarAdd);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

//        if (this.getPagePermissionView() != null && this.getPagePermissionView().isCreate())
//            this.showSubmitButton = true;
//
//        if (this.getPagePermissionView() != null && this.getPagePermissionView().isEdit()) {
//            this.showEditButton = true;
//            this.showSubmitButton = true;
//        }



//        initPageVar();
        System.out.println("******************************"+this.theme);
        return SUCCESS;
    }

    private void initPageVar() {
        StringBuilder sb = new StringBuilder();

        sb.append("<script type=\"text/javascript\">");
        sb.append("var PageVar={");
        sb.append(String.format("%1$s:'%2$s',", "ID", this.id));
        sb.append(String.format("%1$s:'%2$s',", "UserId", UserHelper.getEditUserNo()));
        sb.append("};");

        sb.append("var ElementVar={");
        for(TagPermissionView tagPermissionView: this.getPagePermissionView().getTagPermissionViewList()){
            sb.append(String.format("%1$s:'%2$s',", tagPermissionView.getTagName(), String.valueOf(tagPermissionView.getTagPermissionType())));
        }
        sb.append("};");

        sb.append("</script>");

//        this.pageVar = sb.toString();
    }

}