package com.hzfh.p2p.controller.customer;

import java.util.ArrayList;
import java.util.List;

import com.hzfh.api.customer.model.PaymentBankInfo;
import com.hzfh.api.customer.model.PaymentCustomerBank;
import com.hzfh.api.customer.model.PaymentPlatform;
import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.baseInfo.DicDataModel;
import com.hzfh.p2p.model.common.AuthenticationModel;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.helper.UrlHelper;
import com.hzfh.p2p.model.common.parameter.StatusType;
import com.hzfh.p2p.model.customer.PaymentBankInfoModel;
import com.hzfh.p2p.model.customer.PaymentCustomerBankModel;
import com.hzfh.p2p.model.customer.PaymentPlatformModel;

public class PaymentMoneyRechargeAction extends CommonAction {
	private boolean showAddButton;

    public boolean isShowAddButton() {
        return showAddButton;
    }
    private String bankCardNo;
    private String bankLogoPath;
    private int  bankStatus;
    
    public int getBankStatus() {
		return bankStatus;
	}
    public String getBankCardNo() {
		return bankCardNo;
	}
	public String getBankLogoPath() {
		return bankLogoPath;
	}
	private List rechargeStateList;
	public List getRechargeStateList() {
		return rechargeStateList;
	}
	
	private List<PaymentBankInfo> paymentBankInfoList;
	private List<PaymentPlatform> paymentPlatformList;
	public List<PaymentBankInfo> getPaymentBankInfoList() {
		return paymentBankInfoList;
	}
	public List<PaymentPlatform> getPaymentPlatformList() {
		return paymentPlatformList;
	}
	public boolean showPaymentStyle;
	public boolean isShowPaymentStyle() {
		return showPaymentStyle;
	}
	@Override
    public String execute() {
        this.setPageAlias(PageAlias.myPaymentMoneyRechargeList);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        int customerNo = AuthenticationModel.getCustomerId();
        int status = 1;
        List<PaymentCustomerBank> paymentCustomerBanks = PaymentCustomerBankModel.getBankByCustomerNoAndStatus(customerNo,status);
		
        if(paymentCustomerBanks!=null&&paymentCustomerBanks.size()!=0){
        	PaymentCustomerBank paymentCustomerBank = paymentCustomerBanks.get(0);
        	String code = paymentCustomerBank.getBankCode();
        	PaymentBankInfo paymentBankInfo = PaymentBankInfoModel.getBankByBankCode(code);
        	String bankLogo = paymentBankInfo.getLogo();
        	bankStatus = paymentCustomerBank.getState();
        	bankLogoPath = UrlHelper.bulidWebUploadPath(bankLogo);
        	bankCardNo = paymentCustomerBank.getBankCard();
        }
        showPaymentStyle=false;
        if(showPaymentStyle){
        	paymentBankInfoList = PaymentBankInfoModel.getListByStatus(1);
        	paymentPlatformList = PaymentPlatformModel.getList();
        }
        rechargeStateList = DicDataModel.getDicDataListByType(StatusType.RECHARGESTATE);
        return SUCCESS;
    }
}
