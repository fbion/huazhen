package com.hzfh.p2p.controller.payment.notify;

import com.hzfh.api.customer.model.Activities;
import com.hzfh.api.customer.model.ActivityCashBonus;
import com.hzfh.api.customer.model.ActivityCustomerCashBonus;
import com.hzfh.api.customer.model.ActivityCustomerDetail;
import com.hzfh.api.customer.model.ActivityCustomerInvitation;
import com.hzfh.api.customer.model.ActivityCustomerTask;
import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.api.payment.model.common.constant.StatusCode;
import com.hzfh.api.payment.model.response.gateway.RegisterNotify;
import com.hzfh.p2p.controller.common.DateUtil;
import com.hzfh.p2p.controller.common.NotifyAction;
import com.hzfh.p2p.model.common.AuthenticationModel;
import com.hzfh.p2p.model.common.helper.LogHelper;
import com.hzfh.p2p.model.common.parameter.ActivitiesInfo;
import com.hzfh.p2p.model.customer.ActivitiesModel;
import com.hzfh.p2p.model.customer.ActivityCashBonusModel;
import com.hzfh.p2p.model.customer.ActivityCustomerCashBonusModel;
import com.hzfh.p2p.model.customer.ActivityCustomerDetailModel;
import com.hzfh.p2p.model.customer.ActivityCustomerInvitationModel;
import com.hzfh.p2p.model.customer.ActivityCustomerTaskModel;
import com.hzfh.p2p.model.customer.P2pCustomerModel;
import com.hzfh.p2p.model.customer.PaymentAccountInformationModel;
import com.hzframework.helper.StringHelper;

public class RegisterNotifyAction extends NotifyAction<RegisterNotify> {
	public static final LogHelper logger = LogHelper.getLogger(RegisterNotifyAction.class.getName());
	@Override
	public String execute() {
		
		logger.info("注册-Notify开始!");
		 if (!verifySign()){
	        	logger.error("注册-验签失败!");
				return null;
	        }
		logger.info("注册-验签成功!");
		if(getNotify()==null){
			logger.error("注册-notify is null!");
			return null;
		}
		int id = Integer.parseInt(getNotify().getPlatformUserNo());
		String sn = PaymentAccountInformationModel.getInfoByCustomerNo(id).getSn();
		
		
		if (Integer.parseInt(this.getNotify().getCode()) == StatusCode.SUCCESS&&StringHelper.isNullOrEmpty(sn)) {
			// 认证通过修改认证表的实名认证的状态
			PaymentAccountInformation paymentAccountInformation = PaymentAccountInformationModel.getInfoByCustomerNo(id);
			paymentAccountInformation.setCustomerNo(id);
			P2pCustomer p2pCustomer = P2pCustomerModel.getInfo(id);
			paymentAccountInformation.setCustomerName(p2pCustomer.getRealName());
			paymentAccountInformation.setAuthenticationName(1);
			paymentAccountInformation.setAuthenticationIdcard(1);
			paymentAccountInformation.setAccountPwd(1);
			paymentAccountInformation.setSn(this.getNotify().getRequestNo());
			try {
				PaymentAccountInformationModel.update(paymentAccountInformation);
				Activities activitiesModel = ActivitiesModel.getInfoByActivitytype(ActivitiesInfo.ACTIVITY_CASH_TYPE);
				//被邀请人id，活动id
				ActivityCustomerInvitation invitation = ActivityCustomerInvitationModel.getInfoByCondition(id,activitiesModel.getId());
				if(invitation!=null){
					//更新我的邀请
					invitation.setAuthenticationTime(DateUtil.getNowTimestamp());
					invitation.setStatus(ActivitiesInfo.ACTIVITY_CUSTOMER_INVITATION_STATUS);
					ActivityCustomerInvitationModel.update(invitation);
					//更新我的活动详情状态
					int myactId=ActivityCustomerTaskModel.getInfoByCondition(invitation.getP2pCustomerNo(), activitiesModel.getId()).getId();
					ActivityCustomerDetail activityCustomerDetail =ActivityCustomerDetailModel.getActivityCustomerDetailById(myactId);
					activityCustomerDetail.setTaskStatus(ActivitiesInfo.ACTIVITY_TASK_STATUS);
					activityCustomerDetail.setFinishTime(DateUtil.getNowTimestamp());
					ActivityCustomerDetailModel.update(activityCustomerDetail);
				}
				
				logger.info("注册-更新账户详情表成功！");
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("注册-更新账户详情表出现异常！",e);
			}
			logger.info("注册易宝用户成功！");
		}else{
			// 易宝掉接口不成功
			P2pCustomer p2pCustomer = P2pCustomerModel.getInfo(id);
			p2pCustomer.setRealName(null);
			p2pCustomer.setCardNumber(null);
			try {
				P2pCustomerModel.updateRealNameCustomerNo(p2pCustomer);
				logger.info("注册失败-还原p2p客户表成功！");
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("注册失败-还原p2p客户表出现异常！",e);
			}	
			logger.error("注册易宝用户失败！");
		}
		logger.info("注册-Notify结束!");
		return sendSuccess();
	}
}
