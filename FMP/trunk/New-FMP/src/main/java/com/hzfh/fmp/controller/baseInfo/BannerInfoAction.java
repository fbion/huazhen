package com.hzfh.fmp.controller.baseInfo;

import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.baseInfo.SmsModel;
import com.hzfh.fmp.model.common.PageAlias;

public class BannerInfoAction extends CommonAction {
    private boolean showAddButton;

    public boolean isShowAddButton() {
        return showAddButton;
    }

    @Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.bannerInfoList);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        if (this.getPagePermissionView() != null && this.getPagePermissionView().isCreate()) {
            this.showAddButton = true;
        }

        return SUCCESS;
    }
//    public String test(){
//        SmsModel.smsInterviewInvitation("aa","aa","aa","aa","aa","aa","aa");
//        return SUCCESS;
//    }
}
