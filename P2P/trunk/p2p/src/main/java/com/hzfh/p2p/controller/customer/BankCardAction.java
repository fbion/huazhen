package com.hzfh.p2p.controller.customer;

import java.util.List;

import com.hzfh.api.customer.model.PaymentBankInfo;
import com.hzfh.api.customer.model.PaymentCustomerBank;
import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.common.AuthenticationModel;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.helper.UrlHelper;
import com.hzfh.p2p.model.customer.PaymentBankInfoModel;
import com.hzfh.p2p.model.customer.PaymentCustomerBankModel;

public class BankCardAction extends CommonAction{
	private String bankLogoPath;
	private int bankStatus;
	private PaymentCustomerBank paymentCustomerBank;
	public PaymentCustomerBank getPaymentCustomerBank() {
		return paymentCustomerBank;
	}
	public String getBankLogoPath() {
		return bankLogoPath;
	}
	public int getBankStatus() {
		return bankStatus;
	}
	@Override
	public String execute(){
        this.setPageAlias(PageAlias.bankCard);
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        int customerNo = AuthenticationModel.getCustomerId();
        int status = 1;
        List<PaymentCustomerBank> paymentCustomerBanks = PaymentCustomerBankModel.getBankByCustomerNoAndStatus(customerNo,status);
        if(paymentCustomerBanks!=null&&paymentCustomerBanks.size()!=0){
        	this.paymentCustomerBank = paymentCustomerBanks.get(0);
        	String code = paymentCustomerBank.getBankCode();
        	PaymentBankInfo paymentBankInfo = PaymentBankInfoModel.getBankByBankCode(code);
        	String bankLogo = paymentBankInfo.getLogo();
        	bankLogoPath = UrlHelper.bulidWebUploadPath(bankLogo);
        	bankStatus = paymentCustomerBank.getState();
        }
        return SUCCESS;
	}
}
