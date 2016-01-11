package com.hzfh.fmp.controller.customer.notify;

import com.hzfh.api.customer.model.ActivityCustomerInvitation;
import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.api.customer.model.PaymentMoneyChange;
import com.hzfh.api.customer.model.PaymentMoneyFreeze;
import com.hzfh.api.payment.model.PaymentRefund;
import com.hzfh.api.payment.model.common.constant.StatusCode;
import com.hzfh.api.payment.model.response.gateway.RepaymentNotify;
import com.hzfh.fmp.controller.common.NotifyAction;
import com.hzfh.fmp.model.common.enumeration.PaymentType;
import com.hzfh.fmp.model.common.enumeration.StatusType;
import com.hzfh.fmp.model.common.helper.LogHelper;
import com.hzfh.fmp.model.customer.ActivityCustomerCashBonusModel;
import com.hzfh.fmp.model.customer.ActivityCustomerExperienceGoldModel;
import com.hzfh.fmp.model.customer.ActivityCustomerInvitationModel;
import com.hzfh.fmp.model.customer.P2pCustomerModel;
import com.hzfh.fmp.model.customer.PaymentAccountInformationModel;
import com.hzfh.fmp.model.customer.PaymentMoneyChangeModel;
import com.hzfh.fmp.model.customer.PaymentMoneyFreezeModel;
import com.hzfh.fmp.model.payment.PaymentRefundModel;

/**
 * Created by Administrator on 2015/6/23.
 */
public class RepaymentNotifyAction extends NotifyAction<RepaymentNotify> {

    public static final LogHelper logger = LogHelper.getLogger(RepaymentNotifyAction.class.getName());

    @Override
    public String execute() throws Exception {
        if (!this.verifySign()) {
            logger.error("验签失败");
            return SUCCESS;
        }
        if (this.getNotify() == null) {
            logger.error("notify is null");
            return SUCCESS;
        }

        if (Integer.valueOf(this.getNotify().getCode()) == StatusCode.SUCCESS) {
        	ActivityCustomerInvitation invitation = ActivityCustomerInvitationModel.getInfoByRequestNo(this.getNotify().getRequestNo().split("@")[0]);
            PaymentMoneyFreeze paymentMoneyFree = PaymentMoneyFreezeModel.getInfoBySnAndType(this.getNotify().getRequestNo().split("@")[0], PaymentType.FREEZETYPE_REPAYMENT);/**/
            if (paymentMoneyFree == null) {
                try {
                    PaymentMoneyFreeze paymentMoneyFreeze = new PaymentMoneyFreeze();
                    paymentMoneyFreeze.setAccountType(PaymentType.P2PCUSTOMER_PERSONAL);/**/
                    paymentMoneyFreeze.setP2pCustomerNo(PaymentType.YYID);/**/
                    paymentMoneyFreeze.setP2pCustomerName("YanYang");/**/
                    paymentMoneyFreeze.setMoneyFreeze(invitation.getRewardsMoney());
                    paymentMoneyFreeze.setRefSn(this.getNotify().getRequestNo().split("@")[0]);
                    paymentMoneyFreeze.setState(PaymentType.FREEZESTATE_FREEZE);
                    paymentMoneyFreeze.setChangeType(PaymentType.FREEZETYPE_REPAYMENT);/**/
                    PaymentMoneyFreezeModel.add(paymentMoneyFreeze);
                } catch (Exception e) {
                    logger.error("记录到payment_money_freeze（资金冻结流水）表出现异常", e);
                }

                try {
                    PaymentAccountInformationModel.updateMoneyWithDarw(-invitation.getRewardsMoney(), PaymentType.YYID);/**/
                    PaymentAccountInformationModel.updateMoneyFreeze(invitation.getRewardsMoney(), PaymentType.YYID);
                } catch (Exception e) {
                    logger.error("更新payment_account_information（用户账户信息表）里的金额出现异常", e);
                }

                try {
                	if(this.getNotify().getRequestNo().split("@")[1].equals("1")){
                		ActivityCustomerExperienceGoldModel.updateStatusById(invitation.getRelatedNo(), StatusType.CHECKPAYMENT);
                	}else if(this.getNotify().getRequestNo().split("@")[1].equals("2")){
                    	ActivityCustomerCashBonusModel.updateStatusById(invitation.getRelatedNo(), StatusType.CHECKPAYMENT);
                	}
                } catch (Exception e) {
                    logger.error("更新还款状态出现异常", e);
                }
            }

        } else {
            logger.error("还款操作失败Code:" + this.getNotify().getCode());
        }
        this.sendSuccess();
        return null;
    }

    public String confirmTransaction() {
        if (!this.verifySign()) {
            logger.error("验签失败");
            return SUCCESS;
        }
        if (this.getNotify() == null) {
            logger.error("notify is null");
            return SUCCESS;
        }
        if (Integer.valueOf(this.getNotify().getCode()) == StatusCode.SUCCESS) {
            String requestNo = this.getNotify().getRequestNo().split("@")[0];
//            PaymentRefund paymentRefund = PaymentRefundModel.getInfo(Integer.valueOf(requestNo));
        	ActivityCustomerInvitation invitation = ActivityCustomerInvitationModel.getInfoByRequestNo(requestNo);
            PaymentMoneyFreeze paymentMoneyFree = PaymentMoneyFreezeModel.getInfoBySnAndType(requestNo, PaymentType.FREEZETYPE_CONFIRM);
            if (paymentMoneyFree == null) {
                try {
                    PaymentMoneyFreeze paymentMoneyFreeze = new PaymentMoneyFreeze();
                    paymentMoneyFreeze.setMoneyFreeze(invitation.getRewardsMoney());
                    paymentMoneyFreeze.setRefSn(requestNo);
                    paymentMoneyFreeze.setP2pCustomerNo(PaymentType.YYID);
                    paymentMoneyFreeze.setP2pCustomerName("YanYang");
                    paymentMoneyFreeze.setState(PaymentType.FREEZESTATE_THRAW);
                    paymentMoneyFreeze.setChangeType(PaymentType.FREEZETYPE_CONFIRM);
                    PaymentMoneyFreezeModel.add(paymentMoneyFreeze);
                } catch (Exception e) {
                    logger.error("记录到payment_money_freeze（资金冻结流水）表出现异常", e);
                }
            }

            PaymentMoneyChange payMoneyChange = PaymentMoneyChangeModel.getInfoByMoneyChangeTypeAndRefSn(PaymentType.MONEYCHANGE_PAYCONFIRM, requestNo);
            if (payMoneyChange == null) {
                try {
                    PaymentAccountInformation paymentAccountInformation = PaymentAccountInformationModel.getInfoByCustomerNo(invitation.getP2pCustomerNo());
                    PaymentMoneyChange paymentMoneyChange = new PaymentMoneyChange();
                    paymentMoneyChange.setP2pCustomerNo(invitation.getP2pCustomerNo());
                    paymentMoneyChange.setP2pCustomerName(P2pCustomerModel.getInfo(invitation.getP2pCustomerNo()).getRealName());
                    paymentMoneyChange.setMoneyTransferType(PaymentType.TRANSFER_TYPE_OUT);
                    paymentMoneyChange.setMoneyChangeType(PaymentType.MONEYCHANGE_PAYCONFIRM);
                    paymentMoneyChange.setMoneyAmountPre(paymentAccountInformation.getMoneyAmount());
                    paymentMoneyChange.setMoneyAmountLater(paymentAccountInformation.getMoneyAmount() - invitation.getRewardsMoney());
                    paymentMoneyChange.setMoneyWithdraw(invitation.getRewardsMoney());
                    paymentMoneyChange.setRefSn(requestNo);
                    PaymentMoneyChangeModel.add(paymentMoneyChange);
                } catch (Exception e) {
                    logger.error("记录到payment_money_change（资金变动流水）表出现异常");
                }

                try {
                    //更新企业账户
                    PaymentAccountInformationModel.updateMoneyAmount(-invitation.getRewardsMoney(), PaymentType.YYID);/**/
                    PaymentAccountInformationModel.updateMoneyFreeze(-invitation.getRewardsMoney(), PaymentType.YYID);/**/
                    //更新个人账户
                    PaymentAccountInformationModel.updateMoneyAmount(invitation.getRewardsMoney(), invitation.getP2pCustomerNo());
                    PaymentAccountInformationModel.updateMoneyWithDarw(invitation.getRewardsMoney(), invitation.getP2pCustomerNo());
                } catch (Exception e) {
                    logger.error("更新payment_account_information（用户账户信息表）里的金额出现异常", e);
                }

                try {
                	if(this.getNotify().getRequestNo().split("@")[1].equals("1")){
                		ActivityCustomerExperienceGoldModel.updateStatusById(invitation.getRelatedNo(), StatusType.FINSHPAYMENT);
                	}else if(this.getNotify().getRequestNo().split("@")[1].equals("2")){
                    	ActivityCustomerCashBonusModel.updateStatusById(invitation.getRelatedNo(),StatusType.FINSHPAYMENT);
                	}
                } catch (Exception e) {
                    logger.error("更新paymentRefund的状态为已到账出现异常", e);
                }
            }

        } else {
            logger.error("转账授权确认失败Code:" + this.getNotify().getCode());
        }

        this.sendSuccess();
        return null;
    }

    public String cancelTransaction() {
        if (!this.verifySign()) {
            logger.error("验签失败");
            return SUCCESS;
        }
        if (this.getNotify() == null) {
            logger.error("notify is null");
            return SUCCESS;
        }
        if (Integer.valueOf(this.getNotify().getCode()) == StatusCode.SUCCESS) {
            String requestNo = this.getNotify().getRequestNo().split("@")[0];
//            PaymentRefund paymentRefund = PaymentRefundModel.getInfo(Integer.valueOf(requestNo));
        	ActivityCustomerInvitation invitation = ActivityCustomerInvitationModel.getInfoByRequestNo(requestNo);
            PaymentMoneyFreeze paymentMoneyFree = PaymentMoneyFreezeModel.getInfoBySnAndType(requestNo, PaymentType.FREEZETYPE_CANCEL);
            if (paymentMoneyFree == null) {
                try {
                    PaymentMoneyFreeze paymentMoneyFreeze = new PaymentMoneyFreeze();
                    paymentMoneyFreeze.setMoneyFreeze(invitation.getRewardsMoney());
                    paymentMoneyFreeze.setRefSn(requestNo);
                    paymentMoneyFreeze.setP2pCustomerNo(invitation.getP2pCustomerNo());
                    paymentMoneyFreeze.setP2pCustomerName(P2pCustomerModel.getInfo(invitation.getP2pCustomerNo()).getRealName());
                    paymentMoneyFreeze.setState(PaymentType.FREEZESTATE_THRAW);
                    paymentMoneyFreeze.setChangeType(PaymentType.FREEZETYPE_CANCEL);
                    PaymentMoneyFreezeModel.add(paymentMoneyFreeze);
                } catch (Exception e) {
                    logger.error("记录到payment_money_freeze（资金冻结流水）表出现异常", e);
                }

//                try{
//                    PaymentRefund refund = new PaymentRefund();
//                    refund.setSalesNo(paymentRefund.getSalesNo());
//                    refund.setP2pProductNo(paymentRefund.getP2pProductNo());
//                    refund.setP2pProductName(paymentRefund.getP2pProductName());
//                    refund.setP2pCustomerNo(paymentRefund.getP2pCustomerNo());
//                    refund.setP2pCustomerName(paymentRefund.getP2pCustomerName());
//                    refund.setPayerNo(paymentRefund.getPayerNo());
//                    refund.setPayerName(paymentRefund.getPayerName());
//                    refund.setSalesMoney(paymentRefund.getSalesMoney());
//                    refund.setInterest(paymentRefund.getInterest());
//                    refund.setPayMoney(paymentRefund.getPayMoney());
//                    refund.setStatus(StatusType.WAITPAYMENT);
//                    refund.setPayStartTime(paymentRefund.getPayStartTime());
//                    PaymentRefundModel.add(refund);
//                }catch (Exception e){
//                    logger.error("还款取消重新生成一条还款记录出现异常", e);
//                }

                try {
                    PaymentAccountInformationModel.updateMoneyFreeze(-invitation.getRewardsMoney(), PaymentType.YYID);/**/
                    PaymentAccountInformationModel.updateMoneyWithDarw(invitation.getRewardsMoney(), PaymentType.YYID);/**/
                } catch (Exception e) {
                    logger.error("转账成功,更新payment_account_information（用户账户信息表）里的金额", e);
                }

                try {
                	if(this.getNotify().getRequestNo().split("@")[1].equals("1")){
                		ActivityCustomerExperienceGoldModel.updateStatusById(invitation.getRelatedNo(), StatusType.CANCLEPAYMENT);
                	}else if(this.getNotify().getRequestNo().split("@")[1].equals("2")){
                    	ActivityCustomerCashBonusModel.updateStatusById(invitation.getRelatedNo(), StatusType.CANCLEPAYMENT);
                	}
                } catch (Exception e) {
                    logger.error("更新paymentRefund的状态为取消还款出现异常", e);
                }
            }

        } else {
            logger.error("转账授权取消失败Code:" + this.getNotify().getCode());
        }
        this.sendSuccess();

        return null;
    }
}
