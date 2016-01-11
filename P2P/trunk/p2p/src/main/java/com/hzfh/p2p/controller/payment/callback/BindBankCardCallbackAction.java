package com.hzfh.p2p.controller.payment.callback;

import com.hzfh.api.payment.model.response.gateway.BindBankCardCallback;
import com.hzfh.p2p.controller.common.CallBackAction;
import com.hzfh.p2p.model.common.helper.LogHelper;

public class BindBankCardCallbackAction extends CallBackAction<BindBankCardCallback>{
	public static final LogHelper logger = LogHelper.getLogger(BindBankCardCallbackAction.class.getName());
	@Override
	public String execute() {
		logger.info("绑定银行卡-callback开始！");
		if(getResp()==null){
	    	 logger.error("绑定银行卡-callback is null！");
	     }
		if(!verifySign()){
			logger.error("绑定银行卡-callback验签失败");
		}
		logger.info("绑定银行卡-callback结束！");
        return SUCCESS;
	}
}
