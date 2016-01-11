package com.hzfh.p2p.controller.customer;

import java.util.List;

import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.api.customer.model.PaymentBankInfo;
import com.hzfh.api.customer.model.PaymentCustomerBank;
import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.baseInfo.DicDataModel;
import com.hzfh.p2p.model.common.AuthenticationModel;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.helper.UrlHelper;
import com.hzfh.p2p.model.common.parameter.PaymentType;
import com.hzfh.p2p.model.common.parameter.StatusType;
import com.hzfh.p2p.model.customer.PaymentAccountInformationModel;
import com.hzfh.p2p.model.customer.PaymentBankInfoModel;
import com.hzfh.p2p.model.customer.PaymentCustomerBankModel;
import com.hzfh.p2p.model.customer.PaymentMoneyRechargeModel;
import com.hzframework.helper.MathHelper;

public class PaymentMoneyWithdrawAction extends CommonAction {
	private boolean showAddButton;

    public boolean isShowAddButton() {
        return showAddButton;
    }

    private String bankCardNo;
    private String bankLogoPath;
    private double withdrawMoney;
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

	public double getWithdrawMoney() {
		return withdrawMoney;
	}
	
	private List withDrawStateList;
	public List getWithDrawStateList() {
		return withDrawStateList;
	}
	@Override
    public String execute() {
        this.setPageAlias(PageAlias.myPaymentMoneyWithdrawList);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        int customerNo = AuthenticationModel.getCustomerId();
        int status = 1;
        List<PaymentCustomerBank> paymentCustomerBanks=null;
		paymentCustomerBanks = PaymentCustomerBankModel.getBankByCustomerNoAndStatus(customerNo,status);
        if(paymentCustomerBanks!=null&&paymentCustomerBanks.size()!=0){
        	PaymentCustomerBank paymentCustomerBank = paymentCustomerBanks.get(0);
        	String code = paymentCustomerBank.getBankCode();
        	PaymentBankInfo paymentBankInfo = PaymentBankInfoModel.getBankByBankCode(code);
        	String bankLogo = paymentBankInfo.getLogo();
        	bankLogoPath = UrlHelper.bulidWebUploadPath(bankLogo);
        	bankCardNo = paymentCustomerBank.getBankCard();
        	bankStatus = paymentCustomerBank.getState();
        }
        PaymentAccountInformation paymentAccountInformation = PaymentAccountInformationModel.getInfoByCustomerNo(customerNo);
        if(paymentAccountInformation!=null){
        	double availableBalance = paymentAccountInformation.getMoneyAmount()-paymentAccountInformation.getMoneyFreeze();//总金额-冻结金额
        	//double rechargeMoney = PaymentMoneyRechargeModel.getRechargeMoneyByCustomerNoAndStatusAndToday(customerNo,PaymentType.RECHARGE_SUCCESS);//当天充值成功的金额
        	withdrawMoney = MathHelper.divide(availableBalance,1,2);
        	
        	/*double salesMoney = p2pProduct.getTotalAmout()-p2pProduct.getRemainAmout();
            double progress = MathHelper.divide(salesMoney,p2pProduct.getTotalAmout(),2)*100;
            p2pProduct.setProgress(progress);*/
        }
        withDrawStateList = DicDataModel.getDicDataListByType(StatusType.WITHDRAWSTATE);
        return SUCCESS;
    }
}
