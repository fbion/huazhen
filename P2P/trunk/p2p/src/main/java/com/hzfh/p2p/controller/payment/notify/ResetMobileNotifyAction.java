package com.hzfh.p2p.controller.payment.notify;
import com.hzfh.api.payment.model.common.constant.StatusCode;
import com.hzfh.api.payment.model.response.gateway.ResetMobileNotify;
import com.hzfh.p2p.controller.common.NotifyAction;
import com.hzfh.p2p.model.common.helper.LogHelper;
import com.hzfh.p2p.model.customer.P2pCustomerModel;


public class ResetMobileNotifyAction extends NotifyAction<ResetMobileNotify> {
	public static final LogHelper logger = LogHelper.getLogger(ResetMobileNotifyAction.class.getName());
	@Override
	public String execute() {
		logger.info("修改手机号Notify开始！");
		if (!verifySign()){
        	logger.error("修改手机号-验签失败！");
			return null;
        }
		System.out.println("验签成功!");
		if(getNotify()==null){
			logger.error("修改手机号-notify is null!");
			return null;
		}
		int customerNo=Integer.parseInt(getNotify().getPlatformUserNo());
		ResetMobileNotify resetMobileNotify = this.getNotify();
		if(Integer.parseInt(resetMobileNotify.getCode())==StatusCode.SUCCESS){
			int id = P2pCustomerModel.updateCellphoneByCustomerNo(resetMobileNotify.getMobile(),customerNo);
			if(id>0){
				logger.info("修改手机号 -用户账户信息表payment_account_information更新成功！");
			}else{
				logger.error("修改手机号-修改手机号 -用户账户信息表payment_account_information更新失败！");
			}
			logger.info("修改手机号-成功");
		}else{
			logger.error("修改手机号-失败！");
		}
		logger.info("修改手机号Notify结束！！");
		return sendSuccess();
	}
}
