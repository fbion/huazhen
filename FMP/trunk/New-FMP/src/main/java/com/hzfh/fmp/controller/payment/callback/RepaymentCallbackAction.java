package com.hzfh.fmp.controller.payment.callback;

import com.hzfh.api.payment.model.response.gateway.RepaymentCallback;
import com.hzfh.fmp.controller.common.CallBackAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.helper.UrlHelper;

/**
 * Created by Administrator on 2015/6/23.
 */
public class RepaymentCallbackAction extends CallBackAction<RepaymentCallback> {
    private String errorCode = "0000";
    private String message = "还款操作完成，请等待进一步审核";
    private String paymentRefundUrl;

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public String getPaymentRefundUrl() {
        return paymentRefundUrl;
    }

    @Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.paymentRefundList);
        String ret = super.execute();
        if(!ret.equals(SUCCESS)){
            return ret;
        }
        if(!verifySign()){
            this.errorCode="0001";
            this.message="还款操作失败!!!";
            return SUCCESS;
        }
        paymentRefundUrl = UrlHelper.buildPaymentSiteUrl("/payment/paymentRefund/list?navSub=还款管理");
        return SUCCESS;
    }
}
