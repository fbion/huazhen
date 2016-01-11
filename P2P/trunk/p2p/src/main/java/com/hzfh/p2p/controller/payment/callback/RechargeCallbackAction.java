package com.hzfh.p2p.controller.payment.callback;

import com.hzfh.api.customer.model.PaymentMoneyRecharge;
import com.hzfh.api.payment.model.common.constant.StatusCode;
import com.hzfh.api.payment.model.response.gateway.RechargeCallback;
import com.hzfh.p2p.controller.common.CallBackAction;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.helper.LogHelper;
import com.hzfh.p2p.model.common.helper.UrlHelper;
import com.hzfh.p2p.model.customer.PaymentMoneyRechargeModel;

public class RechargeCallbackAction extends CallBackAction<RechargeCallback>{
	public static final LogHelper logger = LogHelper.getLogger(RechargeCallbackAction.class.getName());
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
		logger.info("充值-callback开始！");
		
		//返回的callback對象
		 accountUrl = UrlHelper.buildWWWSiteUrl(PageAlias.account);
	     p2pProductListUrl = UrlHelper.buildWWWSiteUrl(PageAlias.p2pProductList);
	     msg1="申请充值失败！";
	     msg2="充值高峰期，充值失败，请您稍后重试。";
	     
	     this.setPageAlias(PageAlias.accountSuccess);
	     String ret = super.execute();
	     if (!ret.equals(SUCCESS))
	    	 return ret;
	     
	     if(!verifySign()){
	    	 logger.error("充值-callback验签失败");
	     }
	     if(getResp()==null){
	    	 logger.error("充值-callback is null！");
	     }
	     
		RechargeCallback rechargeCallback  = this.getResp();
		double money = 0;
		if(Integer.parseInt(rechargeCallback.getCode()) == StatusCode.SUCCESS){
			PaymentMoneyRecharge paymentMoneyRecharge = PaymentMoneyRechargeModel.getbySn(rechargeCallback.getRequestNo());
			money = paymentMoneyRecharge.getAmount();
			msg1="您已申请充值"+money+"元，预计10分钟内到账";
			msg2="充值高峰期，到账时间会延时，请以实际到账时间为准。";
			logger.info("充值-callback成功!");
		}else{
			logger.error("充值-callback返回失败!");
		}
        logger.info("充值-callback结束！");
        return SUCCESS;
	}
}
