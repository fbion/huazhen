package com.hzfh.p2p.controller.payment.notify;

import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.api.customer.model.PaymentMoneyChange;
import com.hzfh.api.customer.model.PaymentMoneyFreeze;
import com.hzfh.api.payment.model.ExamineCallbackRecord;
import com.hzfh.api.payment.model.common.constant.QueryType;
import com.hzfh.api.payment.model.common.constant.StatusCode;
import com.hzfh.api.payment.model.response.gateway.TenderNotify;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.p2p.model.payment.ExamineCallbackRecordModel;
import com.hzfh.p2p.model.product.P2pProductModel;
import com.hzfh.p2p.model.product.ProductModel;
import com.hzfh.p2p.controller.common.NotifyAction;
import com.hzfh.p2p.model.baseInfo.SmsModel;
import com.hzfh.p2p.model.common.helper.LogHelper;
import com.hzfh.p2p.model.common.parameter.ContactInfo;
import com.hzfh.p2p.model.common.parameter.PaymentType;
import com.hzfh.p2p.model.common.parameter.StatusType;
import com.hzfh.p2p.model.common.properties.WebInfoHelper;
import com.hzfh.p2p.model.common.state.StateValues;
import com.hzfh.p2p.model.customer.CustomerModel;
import com.hzfh.p2p.model.customer.P2pCustomerModel;
import com.hzfh.p2p.model.customer.PaymentAccountInformationModel;
import com.hzfh.p2p.model.customer.PaymentMoneyChangeModel;
import com.hzfh.p2p.model.customer.PaymentMoneyFreezeModel;
import com.hzfh.p2p.model.sales.SalesModel;

/**
 * Created by Administrator on 2015/6/18.
 */
public class TenderNotifyAction extends NotifyAction<TenderNotify> {
    public final static LogHelper logger = LogHelper.getLogger(TenderNotifyAction.class);

    public String execute() {
        if (!verifySign()) {
            logger.error("投标验签失败!");
            return null;
        }
        System.out.println("验签成功!");
        if (getNotify() == null) {
            logger.error("投标的notify is null!");
            return null;
        }
        
        
        String operationType = QueryType.QUERY_TENDER;
		String sn = this.getNotify().getRequestNo();
		/*ExamineCallbackRecord examineCallbackRecord = ExamineCallbackRecordModel.getinfoByoperationTypeAndSn(operationType,sn);
		byte callbackStatus = examineCallbackRecord.getStatus();
		if(callbackStatus==QueryType.QUERY_NO_NOTIFY){
			return sendSuccess();
		}
		ExamineCallbackRecordModel.updateStatusByoperationTypeAndSn(QueryType.QUERY_YES_NOTIFY,operationType,sn);*/
		
		ExamineCallbackRecord examineCallbackRecord  = new ExamineCallbackRecord();
		try {
			examineCallbackRecord = ExamineCallbackRecordModel.getinfoByoperationTypeAndSn(operationType,sn);
			logger.info("【投标】通过QUERY_TENDER,sn获取examineCallbackRecord！");
		} catch (Exception e1) {
			logger.error("【投标】通过QUERY_TENDER,sn获取examineCallbackRecord失败！", e1);
		}
		
		byte callbackStatus = examineCallbackRecord.getStatus();
		if(callbackStatus==QueryType.QUERY_YES_NOTIFY){
			logger.info("【投标】examineCallbackRecord记录中已经有notify,操作不在向下进行！");
			return sendSuccess();
		}
        
        if (Integer.parseInt(this.getNotify().getCode()) == StatusCode.SUCCESS) {
        	try {
        		logger.info("【投标】examineCallbackRecord记录中没有notify,更新记录中的status开始！");
        		ExamineCallbackRecordModel.updateStatusByoperationTypeAndSn(QueryType.QUERY_YES_NOTIFY,operationType,sn);
        		logger.info("【投标】examineCallbackRecord记录中没有notify,更新记录中的status成功！");
        	} catch (Exception e2) {
        		logger.error("【投标】examineCallbackRecord记录中没有notify,更新记录中的status失败！",e2);
        	}
            int salesId = Integer.parseInt(this.getNotify().getRequestNo());
            Sales sales = SalesModel.getInfo(salesId);
            
            
            P2pCustomer p2pCustomer = P2pCustomerModel.getInfo(sales.getP2pCustomerNo());
            PaymentMoneyFreeze paymentMoneyFre = PaymentMoneyFreezeModel.getInfoBySnAndType(this.getNotify().getRequestNo(), PaymentType.FREEZETYPE_TEND);
            if (paymentMoneyFre == null) {
            	//减少Product和P2pProduct的剩余额度
            	//添加P2pProduct打款个数
            	//增加客户的累计购买金额
            	int productNo = sales.getProductNo();
            	long money = sales.getMoney();
            	int count = 1;
            	try {
            		logger.info("【投标】减少Product和P2pProduct的剩余额度，开始！");
					ProductModel.updateReduceRemainAmount(productNo, money);
					P2pProductModel.updateRemainAmountByProductNo(productNo, -money);
					logger.info("【投标】减少Product和P2pProduct的剩余额度，成功！");
				} catch (Exception e1) {
					logger.error("【投标】减少Product和P2pProduct的剩余额度，失败！",e1);
				}
            	try {
            		logger.info("【投标】增加客户的累计购买金额，开始！");
					this.updateTradeTotalBySales(sales, money);
					logger.info("【投标】增加客户的累计购买金额，成功！");
				} catch (Exception e1) {
					logger.error("【投标】增加客户的累计购买金额，失败！",e1);
				}
            	try {
            		logger.info("【投标】添加P2pProduct打款个数，开始！");
					P2pProductModel.updateOrderCountByProductNo(productNo,count);
					logger.info("【投标】添加P2pProduct打款个数，成功！");
				} catch (Exception e1) {
					logger.error("【投标】添加P2pProduct打款个数,失败！",e1);
				}
                //账户资金冻结流水记录
                try {
                    PaymentMoneyFreeze paymentMoneyFreeze = new PaymentMoneyFreeze();
                    paymentMoneyFreeze.setMoneyFreeze(sales.getMoney());
                    paymentMoneyFreeze.setRefSn(this.getNotify().getRequestNo());
                    paymentMoneyFreeze.setP2pCustomerNo(p2pCustomer.getId());
                    paymentMoneyFreeze.setP2pCustomerName(p2pCustomer.getRealName());
                    paymentMoneyFreeze.setOrderNo(String.valueOf(sales.getId()));
                    paymentMoneyFreeze.setState(PaymentType.FREEZESTATE_FREEZE);
                    paymentMoneyFreeze.setChangeType(PaymentType.FREEZETYPE_TEND);
                    PaymentMoneyFreezeModel.add(paymentMoneyFreeze);
                    logger.info("【投标】记录到payment_money_freeze（资金冻结流水）表，成功！");
                } catch (Exception e) {
                    logger.error("记录到payment_money_freeze（资金冻结流水）表出现异常", e);
                }
            }
            PaymentMoneyChange payMoneyChange = PaymentMoneyChangeModel.getInfoByMoneyChangeTypeAndRefSn(PaymentType.MONEYCHANGE_PAY,this.getNotify().getRequestNo());
            if(payMoneyChange == null){
                try {
                    PaymentAccountInformation paymentAccountInformation = PaymentAccountInformationModel.getInfoByCustomerNo(sales.getP2pCustomerNo());
                    PaymentMoneyChange paymentMoneyChange = new PaymentMoneyChange();
                    paymentMoneyChange.setP2pCustomerNo(p2pCustomer.getId());
                    paymentMoneyChange.setP2pCustomerName(p2pCustomer.getRealName());
                    paymentMoneyChange.setMoneyTransferType(PaymentType.TRANSFER_TYPE_OUT);
                    paymentMoneyChange.setMoneyChangeType(PaymentType.MONEYCHANGE_PAY);
                    paymentMoneyChange.setMoneyAmountPre(paymentAccountInformation.getMoneyAmount());
                    paymentMoneyChange.setMoneyAmountLater(paymentAccountInformation.getMoneyAmount());
                    paymentMoneyChange.setMoneyWithdraw(sales.getMoney());
                    paymentMoneyChange.setRefSn(this.getNotify().getRequestNo());
                    PaymentMoneyChangeModel.add(paymentMoneyChange);
                    logger.info("【投标】记录到payment_money_change（资金变动流水）表，成功！");
                } catch (Exception e) {
                    logger.error("记录到payment_money_change（资金变动流水）表出现异常", e);
                }

                try {
                    PaymentAccountInformationModel.updateMoneyFreeze(sales.getMoney(), p2pCustomer.getId());
                    logger.info("【投标】转账成功，更新payment_account_information（用户账户信息表）里的金额，成功！");
                    //PaymentAccountInformationModel.updateMoneyWithDarw(-sales.getMoney(), p2pCustomer.getId());
                }catch (Exception e){
                    logger.error("转账成功，更新payment_account_information（用户账户信息表）里的金额出现异常", e);
                }
            }

            try {
                SalesModel.updateStatus(sales.getId(), PaymentType.CHECK_PENDING);//待审核
                logger.info("【投标】更新sales的状态为待审核，成功！");
            } catch (Exception e) {
                logger.error("更新sales的状态为待审核出现异常", e);
            }
            
            SmsModel.smsInvestmentApply(p2pCustomer.getCellphone(), sales.getP2pProductName(), WebInfoHelper.WEB_P2P_WWW, String.valueOf(sales.getMoney()), ContactInfo.P2P_HOTLINE);

        } else {
        	SalesModel.updateStatus(Integer.parseInt(sn),PaymentType.PAYMENT_FAILURE);//认购失败
            logger.error("转账授权确认失败Code:" + this.getNotify().getCode());
        }
        this.sendSuccess();

        return null;
    }
    
    //更新(增加)客户的累计购买金额
    private void updateTradeTotalBySales(Sales sales, double money) {
        if (sales.getCustomerType() == StatusType.CUSTOMER_PERSONAL_TYPE) {//自然人
            CustomerModel.updatePersonalTradeTotalById(sales.getCustomerNo(), money);
        } else if (sales.getCustomerType() == StatusType.CUSTOMER_COMPANY_TYPE) {//法人
            CustomerModel.updateCompanyTradeTotalById(sales.getCustomerNo(), money);
        }
    }
}
