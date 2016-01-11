package com.hzfh.p2p.controller.product;

import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.api.payment.model.common.constant.ServiceType;
import com.hzfh.api.payment.model.request.ControllerRequest;
import com.hzfh.api.payment.model.request.controller.AccountInfoReq;
import com.hzfh.api.payment.model.response.controller.AccountInfoResp;
import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.cache.CacheManager;
import com.hzfh.p2p.model.common.cache.CachePrefix;
import com.hzfh.p2p.model.common.helper.LogHelper;
import com.hzfh.p2p.model.common.state.StateValues;
import com.hzfh.p2p.model.customer.PaymentAccountInformationModel;
import com.hzfh.p2p.model.payment.ControllerModel;
import com.hzfh.p2p.model.product.P2pProductModel;
import com.hzframework.helper.DateHelper;
import com.hzframework.helper.StringHelper;

/**
 * Created by Administrator on 2015/6/10.
 */
public class PaymentConfirmAction extends CommonAction {

    private static final LogHelper logger = LogHelper.getLogger(PaymentConfirmAction.class.getName());
    private int p2pProductNo;
    private int investmentMoney;
    private double availableBanlance;
    private String investTime;
    private String productEndTime;

    public String getInvestTime() {
		return investTime;
	}

	public String getProductEndTime() {
		return productEndTime;
	}

	public int getInvestmentMoney() {
        return investmentMoney;
    }

    public void setAvailableBanlance(double availableBanlance) {
        this.availableBanlance = availableBanlance;
    }

    private String captchaUrl;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setInvestmentMoney(int investmentMoney) {
        this.investmentMoney = investmentMoney;
    }

    public void setP2pProductNo(int p2pProductNo) {
        this.p2pProductNo = p2pProductNo;
    }

    public int getP2pProductNo() {
        return p2pProductNo;
    }


    public double getAvailableBanlance() {
        return availableBanlance;
    }

    public String getCaptchaUrl() {
        return captchaUrl;
    }
    private int contractNo;
    public void setContractNo(int contractNo) {
		this.contractNo = contractNo;
	}
    public int getContractNo() {
		return contractNo;
	}
    private P2pProduct p2pProduct;
	public P2pProduct getP2pProduct() {
		return p2pProduct;
	}

	@Override
    public String execute() {
        logger.info("支付确认，并检查当前余额是否可进行交易。");
        this.setPageAlias(PageAlias.paymentConfirm);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        this.captchaUrl = this.buildWWWSiteUrl(PageAlias.captcha);
        PaymentAccountInformation info = PaymentAccountInformationModel.getInfoByCustomerNo(StateValues.getCustomerId());
        if(info == null){
            this.message="对不起，您的用户账户信息不完善。";
            return SUCCESS;
        }

        AccountInfoReq accountInfoReq = new AccountInfoReq();
        accountInfoReq.setPlatformUserNo(String.valueOf(info.getCustomerNo()));
        accountInfoReq.setPlatformNo(accountInfoReq.getPlatformNo());
        AccountInfoResp accountInfoResp = ControllerModel.getAccountInfo(accountInfoReq);
        this.availableBanlance = accountInfoResp.getAvailableAmount();
        if (this.availableBanlance < this.investmentMoney) {
            this.message = "账户余额不足，请充值！";
        }
        this.p2pProduct = P2pProductModel.getInfo(p2pProductNo);
        if(p2pProduct == null){
            this.message="对不起，产品信息错误。";
            return SUCCESS;
        }
        this.investTime = DateHelper.getToday();
        this.productEndTime = DateHelper.format(new java.sql.Date(p2pProduct.getEnd().getTime()));
        
        return SUCCESS;
    }
}
