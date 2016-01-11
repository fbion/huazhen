package com.hzfh.p2p.controller.customer;

import com.hzfh.api.customer.model.EmailChange;
import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.helper.EncodeHelper;
import com.hzfh.p2p.model.common.properties.ParamHelper;
import com.hzfh.p2p.model.customer.EmailChangeModel;
import com.hzfh.p2p.model.customer.P2pCustomerModel;
import com.hzfh.p2p.model.customer.PaymentAccountInformationModel;
import com.hzframework.helper.DateHelper;
import com.hzframework.helper.StringHelper;

import java.sql.Date;

/**
 * Created by paul on 15-3-12.
 */
public class EmailValidationAction extends CommonAction {
    private String key;

    public void setKey(String key) {
        this.key = key;
    }

    private boolean showIsActivate;

    public boolean isShowIsActivate() {
        return showIsActivate;
    }

    @Override
    public String execute() {
        this.setPageAlias(PageAlias.emailValidation);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        //String plaintextUrl = EncodeHelper.decryptDES(key);

        String[] strings = key.split(",");
        if (strings.length != 4){
            return SUCCESS;
        }

        int customerId = Integer.valueOf(strings[1]);

        P2pCustomer p2pCustomer = P2pCustomerModel.getInfo(customerId);
        if (p2pCustomer == null){
            return SUCCESS;
        }

        //验证有效期
        Date sendTime = new Date(Long.parseLong(strings[2]));
        if (DateHelper.addDay(sendTime, ParamHelper.ACTIVATE_EMAIL_EXPIRE_DAY).before(new Date(System.currentTimeMillis()))){
            return SUCCESS;
        }

        //
        EmailChange emailChange = EmailChangeModel.getInfo(Integer.valueOf(strings[3]));
        if(emailChange==null){
            return SUCCESS;
        }
        if(emailChange.getPathStatus()!=1){
            return SUCCESS;
        }
        
        //验证加密串
        String cipherText = EncodeHelper.encryptPWD(p2pCustomer.getUserName(), emailChange.getNewEmali(), p2pCustomer.getSecretKey());
        if (!cipherText.equals(strings[0])){
            return SUCCESS;
        }
        
        //更新p2p客户表的邮箱和证件路径
        p2pCustomer.setEmail(emailChange.getNewEmali());
        String cardPath = emailChange.getCardPath();
        String portraitPath = emailChange.getPortraitPath();
        if(!StringHelper.isNullOrEmpty(cardPath))
        	p2pCustomer.setCardPath(cardPath);
        if(!StringHelper.isNullOrEmpty(portraitPath))
        	p2pCustomer.setPortraitPath(portraitPath);
        if(P2pCustomerModel.update(p2pCustomer)<=0){
            return SUCCESS;
        }
        
        //更改认证状态
        PaymentAccountInformation paymentAccountInformation=PaymentAccountInformationModel.getInfoByCustomerNo(customerId);
        if(paymentAccountInformation.getAuthenticationEmail()==0){
        	paymentAccountInformation.setAuthenticationEmail(1);
        	if (PaymentAccountInformationModel.update(paymentAccountInformation)<=0){
        		return SUCCESS;
        	}
        }

        this.showIsActivate = true;
        return SUCCESS;
    }
}
