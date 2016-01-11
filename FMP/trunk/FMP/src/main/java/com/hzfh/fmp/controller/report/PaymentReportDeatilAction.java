package com.hzfh.fmp.controller.report;

import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.enumeration.TagPermission;
import com.hzfh.fmp.model.common.enumeration.TagPermissionType;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.report.PaymentReportModel;
import com.hzfh.fmp.model.workFlow.ActRuTaskModel;
import com.hzframework.helper.StringHelper;

public class PaymentReportDeatilAction extends CommonAction {
	private String activitiNo;
	
	public String getActivitiNo() {
		return activitiNo;
	}

	public void setActivitiNo(String activitiNo) {
		this.activitiNo = activitiNo;
	}

	public boolean showSubmitButton;
    
    public boolean isShowSubmitButton() {
        return showSubmitButton;
    }
	
    private String honourDate;
    private String type;
    private String paymentReportId;
    private boolean showCardNumberAndCellphone;

    public boolean isShowCardNumberAndCellphone() {
        return showCardNumberAndCellphone;
    }

    public void setShowCardNumberAndCellphone(boolean showCardNumberAndCellphone) {
        this.showCardNumberAndCellphone = showCardNumberAndCellphone;
    }

    public String getPaymentReportId() {
        return paymentReportId;
    }

    public void setPaymentReportId(String paymentReportId) {
        this.paymentReportId = paymentReportId;
    }
    public String getHonourDate() {
        return honourDate;
    }

    public void setHonourDate(String honourDate) {
        this.honourDate = honourDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String execute() throws Exception{
        this.setPageAlias(PageAlias.paymentReportDeatilList);
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        if (this.getPagePermissionView().getTagPermission(TagPermission.SHOW_CARDNUMBER_CELLOHONE) == TagPermissionType.query) {
            this.showCardNumberAndCellphone = true;
        } else {
            this.showCardNumberAndCellphone = false;
        }
        
        int userId = UserHelper.getEditUserNo();
        if (!StringHelper.isNullOrEmpty(this.activitiNo)) {
        	if(ActRuTaskModel.getInfoByAciIdAndUserId(activitiNo, userId) != null){
                this.showSubmitButton = true;
        	}
        } else {
            this.showSubmitButton = false;
        }
//        if(!StringHelper.isNullOrEmpty(this.paymentReportId)){
//        	
//        }
        return SUCCESS;
    }

}
