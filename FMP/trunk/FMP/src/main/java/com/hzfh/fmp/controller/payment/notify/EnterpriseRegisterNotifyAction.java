package com.hzfh.fmp.controller.payment.notify;

import com.hzfh.api.customer.model.CustomerCompany;
import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.api.payment.model.common.constant.StatusCode;
import com.hzfh.api.payment.model.response.gateway.EnterpriseRegisterNotify;
import com.hzfh.fmp.controller.common.NotifyAction;
import com.hzfh.fmp.model.common.enumeration.CardType;
import com.hzfh.fmp.model.common.helper.LogHelper;
import com.hzfh.fmp.model.customer.CustomerCompanyModel;
import com.hzfh.fmp.model.customer.P2pCustomerModel;
import com.hzfh.fmp.model.customer.PaymentAccountInformationModel;

import java.io.IOException;


public class EnterpriseRegisterNotifyAction extends NotifyAction<EnterpriseRegisterNotify> {
    public static final LogHelper logger = LogHelper.getLogger(EnterpriseRegisterNotifyAction.class);

    @Override
    public String execute() throws Exception {
        if (!verifySign()) {
            logger.error("企业注册验签失败!!!");
            return null;
        }
        if (getNotify() == null) {
            logger.error("企业注册notify is null!");
            return null;
        }
        int id = Integer.parseInt(getNotify().getPlatformUserNo());
        if (Integer.parseInt(this.getNotify().getCode()) == StatusCode.SUCCESS) {
            CustomerCompany customerCompany = CustomerCompanyModel.getInfoByP2pCustomerNo(id);
            if (PaymentAccountInformationModel.getInfoByCustomerNo(id) == null) {
                try {
                    PaymentAccountInformation paymentAccountInformation = new PaymentAccountInformation();
                    paymentAccountInformation.setCustomerNo(id);
                    paymentAccountInformation.setCustomerName(customerCompany.getLegal());
                    paymentAccountInformation.setAuthenticationName(1);
                    paymentAccountInformation.setAuthenticationIdcard(1);
                    paymentAccountInformation.setAuthenticationEmail(1);
                    paymentAccountInformation.setAuthenticationTel(1);
                    paymentAccountInformation.setAccountType((byte) 2);
                    paymentAccountInformation.setProperty((byte) 1);
                    paymentAccountInformation.setState((byte) 0);
                    paymentAccountInformation.setAccountPwd(1);
                    paymentAccountInformation.setSn(getNotify().getRequestNo());
                    PaymentAccountInformationModel.add(paymentAccountInformation);
                } catch (Exception e) {
                    logger.error("企业注册写入PaymentAccountInformation出现异常", e);
                }
            }
            try {
                P2pCustomer p2pCustomer = P2pCustomerModel.getInfo(id);
                p2pCustomer.setStatus((byte) 1);//激活企业账户
                p2pCustomer.setCustomerType(1);//用户类型
                p2pCustomer.setEmail(customerCompany.getEmail());//邮箱
                p2pCustomer.setCellphone(customerCompany.getContactCellphone1());//联系人电话
                p2pCustomer.setRealName(customerCompany.getName());//公司名字
                p2pCustomer.setCardType((byte) CardType.IDCARD);//法人证件类型
                p2pCustomer.setCardNumber(customerCompany.getLegalIdcard());//法人身份证
                p2pCustomer.setPhone(customerCompany.getContactTelephone());//公司固定电话
                P2pCustomerModel.update(p2pCustomer);
                CustomerCompanyModel.updateCustomerNoById(id, customerCompany.getId());
            } catch (Exception e) {
                logger.error("更新P2pCustomer信息出现异常", e);
            }
        } else {
            logger.error("企业注册失败返回代码：" + this.getNotify().getCode());
        }
        this.sendSuccess();
        return null;
    }
}
