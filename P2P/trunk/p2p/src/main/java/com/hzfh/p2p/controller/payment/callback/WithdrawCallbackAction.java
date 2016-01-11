package com.hzfh.p2p.controller.payment.callback;

import java.util.List;

import com.hzfh.api.customer.model.PaymentBankInfo;
import com.hzfh.api.customer.model.PaymentCustomerBank;
import com.hzfh.api.customer.model.PaymentMoneyWithdraw;
import com.hzfh.api.payment.model.common.constant.StatusCode;
import com.hzfh.api.payment.model.response.gateway.WithdrawCallback;
import com.hzfh.p2p.controller.common.CallBackAction;
import com.hzfh.p2p.model.common.AuthenticationModel;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.helper.LogHelper;
import com.hzfh.p2p.model.common.helper.UrlHelper;
import com.hzfh.p2p.model.customer.PaymentBankInfoModel;
import com.hzfh.p2p.model.customer.PaymentCustomerBankModel;
import com.hzfh.p2p.model.customer.PaymentMoneyWithdrawModel;
import com.hzframework.helper.StringHelper;

public class WithdrawCallbackAction extends CallBackAction<WithdrawCallback>{
	public static final LogHelper logger = LogHelper.getLogger(WithdrawCallbackAction.class.getName());
	private String accountUrl;
	private String p2pProductListUrl;
	private String msg1;
	private String msg2;
	public String getMsg1() {
		return msg1;
	}
	public String getMsg2() {
		return msg2;
	}
	
	public String getAccountUrl() {
		return accountUrl;
	}
	public String getP2pProductListUrl() {
		return p2pProductListUrl;
	}
	@Override
	public String execute() {
		logger.info("提现callback开始");
		msg1="申请提现失败！";
	    msg2="支付高峰期，提现失败，请您稍后重试。";
	    accountUrl = UrlHelper.buildWWWSiteUrl(PageAlias.account);
	    p2pProductListUrl = UrlHelper.buildWWWSiteUrl(PageAlias.p2pProductList);
		this.setPageAlias(PageAlias.accountSuccess);
		String ret = super.execute();
		if (!ret.equals(SUCCESS))
			return ret;
		if(!verifySign()){
			logger.error("提现-callback验签失败");
		}
		if(getResp()==null){
			logger.error("提现-callback is null！");
		}
		WithdrawCallback withdrawCallback  = this.getResp();
		if(Integer.parseInt(withdrawCallback.getCode()) == StatusCode.SUCCESS){
			PaymentMoneyWithdraw paymentMoneyWithdraw = PaymentMoneyWithdrawModel.getbySn(withdrawCallback.getRequestNo());
			double money = Math.abs(paymentMoneyWithdraw.getAmount());
			msg1="您已申请提现"+money+"元，预计10分钟内到账";
			int status = 1;
			int customerNo = AuthenticationModel.getCustomerId();
	        List<PaymentCustomerBank> paymentCustomerBanks = PaymentCustomerBankModel.getBankByCustomerNoAndStatus(customerNo,status);
	        if(paymentCustomerBanks!=null&&paymentCustomerBanks.size()!=0){
	        	PaymentCustomerBank paymentCustomerBank = paymentCustomerBanks.get(0);
	        	String bankCardNo = paymentCustomerBank.getBankCard();
	        	String bankCardName = paymentCustomerBank.getBankName();
	        	msg2="具体到达"+bankCardName+"（"+bankCardNo+"）的时间，以实际到账时间为准。";
	        }
		}
		logger.info("提现callback结束");
        return SUCCESS;
	}
}
