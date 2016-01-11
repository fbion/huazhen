package com.hzfh.fmp.controller.sales.notify;

import com.hzfh.api.customer.model.*;
import com.hzfh.api.payment.model.PaymentRefund;
import com.hzfh.api.payment.model.common.constant.StatusCode;
import com.hzfh.api.payment.model.response.controller.CompleteTransactionNotify;
import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.api.product.model.Product;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.fmp.controller.common.NotifyAction;
import com.hzfh.fmp.model.common.enumeration.PaymentType;
import com.hzfh.fmp.model.common.enumeration.SalesStatus;
import com.hzfh.fmp.model.common.enumeration.StatusType;
import com.hzfh.fmp.model.common.helper.LogHelper;
import com.hzfh.fmp.model.customer.*;
import com.hzfh.fmp.model.payment.PaymentRefundModel;
import com.hzfh.fmp.model.product.P2pProductModel;
import com.hzfh.fmp.model.product.ProductModel;
import com.hzfh.fmp.model.sales.SalesCreditorModel;
import com.hzfh.fmp.model.sales.SalesModel;

import java.util.List;

/**
 * Created by Administrator on 2015/6/17.
 */
public class CompleteTransactionNotifyAction extends NotifyAction<CompleteTransactionNotify> {
    private static final LogHelper logger = LogHelper.getLogger(CompleteTransactionNotify.class.getName());

    public String confirmTransaction() {
        if (!verifySign()) {
            logger.error("转账授权验签失败!");
            return null;
        }
        if (getNotify() == null) {
            logger.error("转账授权的notify is null!");
            return null;
        }
        if (Integer.valueOf(this.getNotify().getCode()) == StatusCode.SUCCESS) {
            int salesId = Integer.valueOf(this.getNotify().getRequestNo());
            int p2pCustomerNo = SalesModel.getInfo(salesId).getP2pCustomerNo();
            String requestNo = this.getNotify().getRequestNo();
            P2pCustomer p2pCustomer = P2pCustomerModel.getInfo(p2pCustomerNo);
            Sales sales = SalesModel.getInfo(Integer.valueOf(requestNo));
            PaymentMoneyFreeze paymentMoneyFree = PaymentMoneyFreezeModel.getInfoBySnAndType(this.getNotify().getRequestNo(), PaymentType.FREEZETYPE_CONFIRM);
            if (paymentMoneyFree == null) {
                try {
                    PaymentMoneyFreeze paymentMoneyFreeze = new PaymentMoneyFreeze();
                    paymentMoneyFreeze.setMoneyFreeze(sales.getMoney());
                    paymentMoneyFreeze.setRefSn(requestNo);
                    paymentMoneyFreeze.setP2pCustomerNo(p2pCustomerNo);
                    paymentMoneyFreeze.setP2pCustomerName(p2pCustomer.getRealName());
                    paymentMoneyFreeze.setState(PaymentType.FREEZESTATE_THRAW);
                    paymentMoneyFreeze.setChangeType(PaymentType.FREEZETYPE_CONFIRM);
                    PaymentMoneyFreezeModel.add(paymentMoneyFreeze);
                } catch (Exception e) {
                    logger.error("记录到payment_money_freeze（资金冻结流水）表出现异常", e);
                }
            }
            PaymentMoneyChange payMoneyChange = PaymentMoneyChangeModel.getInfoByMoneyChangeTypeAndRefSn(PaymentType.MONEYCHANGE_LOANCONFIRM, this.getNotify().getRequestNo());
            if (payMoneyChange == null) {
                try {
                    PaymentAccountInformation paymentAccountInformation = PaymentAccountInformationModel.getInfoByCustomerNo(p2pCustomerNo);
                    PaymentMoneyChange paymentMoneyChange = new PaymentMoneyChange();
                    paymentMoneyChange.setP2pCustomerNo(p2pCustomerNo);
                    paymentMoneyChange.setP2pCustomerName(p2pCustomer.getRealName());
                    paymentMoneyChange.setMoneyTransferType(PaymentType.TRANSFER_TYPE_OUT);
                    paymentMoneyChange.setMoneyChangeType(PaymentType.MONEYCHANGE_LOANCONFIRM);
                    paymentMoneyChange.setRefSn(String.valueOf(salesId));
                    paymentMoneyChange.setMoneyAmountPre(paymentAccountInformation.getMoneyAmount());
                    paymentMoneyChange.setMoneyAmountLater(paymentAccountInformation.getMoneyAmount() - sales.getMoney());
                    paymentMoneyChange.setMoneyWithdraw(sales.getMoney());
                    PaymentMoneyChangeModel.add(paymentMoneyChange);
                } catch (Exception e) {
                    logger.error("记录到payment_money_change（资金变动流水）表出现异常");
                }

                try {
                    //更新个人账户
                    PaymentAccountInformationModel.updateMoneyAmount(-sales.getMoney(), p2pCustomerNo);
                    PaymentAccountInformationModel.updateMoneyFreeze(-sales.getMoney(), p2pCustomerNo);

                    //更新企业账户
                    int borrowerUserNo = P2pProductModel.getInfo(sales.getP2pProductNo()).getBorrowerUserNo();
                    PaymentAccountInformationModel.updateMoneyAmount(sales.getMoney(), borrowerUserNo);
                    PaymentAccountInformationModel.updateMoneyWithDarw(sales.getMoney(), borrowerUserNo);
                } catch (Exception e) {
                    logger.error("更新payment_account_information（用户账户信息表）里的金额出现异常", e);
                }
            }
            try {
                SalesModel.updateStatus(sales.getId(), SalesStatus.success);
            } catch (Exception e) {
                logger.error("更新sales的状态为认购成功出现异常", e);
            }
            List<PaymentRefund> paymentRefundList = PaymentRefundModel.getInfoBySalesId(salesId);
            if (paymentRefundList == null || paymentRefundList.size() == 0) {
                try {
                    P2pProduct p2pProduct = P2pProductModel.getInfo(sales.getP2pProductNo());
                    p2pProduct.setIncome(Double.valueOf(sales.getIncome()) / 100.00);
                    p2pProduct.setEnd(sales.getRepaymentDate());
                    Product product = ProductModel.getInfo(p2pProduct.getProductNo());
                    PaymentRefund paymentRefund = new PaymentRefund();
                    paymentRefund.setSalesNo(sales.getId());
                    paymentRefund.setProductType(product.getType());
                    paymentRefund.setP2pProductNo(p2pProduct.getId());
                    paymentRefund.setP2pProductName(p2pProduct.getName());
                    paymentRefund.setProductNo(p2pProduct.getProductNo());
                    paymentRefund.setProductName(product.getName());
                    paymentRefund.setP2pCustomerNo(sales.getP2pCustomerNo());
                    paymentRefund.setP2pCustomerName(sales.getCustomerName());
                    paymentRefund.setCustomerNo(sales.getCustomerNo());
                    paymentRefund.setCustomerName(sales.getCustomerName());
                    paymentRefund.setPayerNo(p2pProduct.getBorrowerUserNo());
                    paymentRefund.setPayerName(p2pProduct.getBorrowerUserName());
                    paymentRefund.setPayStartTime(sales.getPurchaseDate());
                    paymentRefund.setSalesMoney(sales.getMoney());
                    paymentRefund.setStatus(StatusType.WAITPAYMENT);
                    paymentRefund.setIsSendSms(1);
                    paymentRefund.setPayType(1);
                    PaymentRefundModel.calculatePaymentRefund(paymentRefund, p2pProduct);
                    SalesCreditorModel.distributionCreditor(salesId);
                } catch (Exception e) {
                    logger.error("写入还款表中出现异常", e);
                }
            }
        } else {
            logger.error("转账授权确认失败Code:" + this.getNotify().getCode());
        }
        this.sendSuccess();
        return SUCCESS;
    }

    public String cancelTransaction() {
        logger.info("转账确认取消操作");

        String requestNo = this.getNotify().getRequestNo();
        Sales sales = SalesModel.getInfo(Integer.valueOf(requestNo));
        P2pCustomer p2pCustomer = P2pCustomerModel.getInfo(sales.getP2pCustomerNo());
        if (Integer.valueOf(this.getNotify().getCode()) == StatusCode.SUCCESS) {

            PaymentMoneyFreeze paymentMoneyFree = PaymentMoneyFreezeModel.getInfoBySnAndType(this.getNotify().getRequestNo(), PaymentType.FREEZETYPE_CANCEL);
            if (paymentMoneyFree == null) {
                try {
                    PaymentMoneyFreeze paymentMoneyFreeze = new PaymentMoneyFreeze();
                    paymentMoneyFreeze.setMoneyFreeze(sales.getMoney());
                    paymentMoneyFreeze.setRefSn(requestNo);
                    paymentMoneyFreeze.setP2pCustomerNo(p2pCustomer.getId());
                    paymentMoneyFreeze.setP2pCustomerName(p2pCustomer.getRealName());
                    paymentMoneyFreeze.setState(PaymentType.FREEZESTATE_THRAW);
                    paymentMoneyFreeze.setChangeType(PaymentType.FREEZETYPE_CANCEL);
                    PaymentMoneyFreezeModel.add(paymentMoneyFreeze);
                } catch (Exception e) {
                    logger.error("记录到payment_money_freeze（资金冻结流水）表出现异常", e);
                }
                try {
                    PaymentAccountInformationModel.updateMoneyFreeze(-sales.getMoney(), p2pCustomer.getId());
                    PaymentAccountInformationModel.updateMoneyWithDarw(sales.getMoney(), p2pCustomer.getId());
                } catch (Exception e) {
                    logger.error("转账成功，更新payment_account_information（用户账户信息表）里的金额出现异常", e);
                }
            }
            PaymentMoneyChange payMoneyChange = PaymentMoneyChangeModel.getInfoByMoneyChangeTypeAndRefSn(PaymentType.MONEYCHANGE_LOANCONFIRM, this.getNotify().getRequestNo());
            if (payMoneyChange == null) {
                try {
                    PaymentAccountInformation paymentAccountInformation = PaymentAccountInformationModel.getInfoByCustomerNo(p2pCustomer.getId());
                    PaymentMoneyChange paymentMoneyChange = new PaymentMoneyChange();
                    paymentMoneyChange.setP2pCustomerNo(p2pCustomer.getId());
                    paymentMoneyChange.setP2pCustomerName(p2pCustomer.getRealName());
                    paymentMoneyChange.setMoneyTransferType(PaymentType.TRANSFER_TYPE_IN);
                    paymentMoneyChange.setMoneyChangeType(PaymentType.MONEYCHANGE_CANCEL);
                    paymentMoneyChange.setRefSn(String.valueOf(sales.getId()));
                    paymentMoneyChange.setMoneyAmountPre(paymentAccountInformation.getMoneyAmount());
                    paymentMoneyChange.setMoneyAmountLater(paymentAccountInformation.getMoneyAmount() - sales.getMoney());
                    paymentMoneyChange.setMoneyWithdraw(sales.getMoney());
                    PaymentMoneyChangeModel.add(paymentMoneyChange);
                } catch (Exception e) {
                    logger.error("记录到payment_money_change（资金变动流水）表出现异常");
                }
            }
            try {
                SalesModel.updateStatus(sales.getId(), SalesStatus.CANCEL);
            } catch (Exception e) {
                logger.error("更新sales的状态出现异常", e);
            }

            try {
                ProductModel.updateAddRemainAmount(sales.getProductNo(), sales.getMoney());
                P2pProductModel.updateRemainAmountByProductNo(sales.getProductNo(), sales.getMoney());
                P2pProductModel.updateOrderCountByProductNo(sales.getProductNo(),-1);
                CustomerPersonal customerPersonal = CustomerPersonalModel.getInfoByP2pCustsomerNo(sales.getP2pCustomerNo());
                if(customerPersonal != null){
                    CustomerPersonalModel.updateTradeTotalById(sales.getCustomerNo(), sales.getMoney());
                }
            } catch (Exception e){
                logger.error("转账授权取消过程中，数据还原出现异常", e);
            }
        } else {
            logger.error("转账授权取消失败Code:" + this.getNotify().getCode());
        }
        this.sendSuccess();
        return SUCCESS;
    }
}
