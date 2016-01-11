package com.hzfh.weixin.controller.customer;

import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.weixin.controller.common.CommonAction;
import com.hzfh.weixin.model.common.PageAlias;
import com.hzfh.weixin.model.common.helper.EncodeHelper;
import com.hzfh.weixin.model.common.properties.ParamHelper;
import com.hzfh.weixin.model.customer.P2pCustomerModel;
import com.hzframework.helper.DateHelper;

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
        if (strings.length != 3){
            this.showIsActivate = false;
            return SUCCESS;
        }

        int customerId = Integer.valueOf(strings[1]);

        P2pCustomer p2pCustomer = P2pCustomerModel.getInfo(customerId);
        if (p2pCustomer == null){
            this.showIsActivate = false;
            return SUCCESS;
        }

        Date sendTime = new Date(Long.parseLong(strings[2]));

        if (DateHelper.addDay(sendTime, ParamHelper.ACTIVATE_EMAIL_EXPIRE_DAY).before(new Date(System.currentTimeMillis()))){
            this.showIsActivate = false;
            return SUCCESS;
        }

        String cipherText = EncodeHelper.encryptPWD(p2pCustomer.getUserName(), p2pCustomer.getUserName(), p2pCustomer.getSecretKey());

        if (!cipherText.equals(strings[0])){
            this.showIsActivate = false;
            return SUCCESS;
        }

        if (P2pCustomerModel.updateStatusById(customerId,(byte)1)<=0){
            this.showIsActivate = false;
            return SUCCESS;
        }

        this.showIsActivate = true;
        return SUCCESS;
    }
}
