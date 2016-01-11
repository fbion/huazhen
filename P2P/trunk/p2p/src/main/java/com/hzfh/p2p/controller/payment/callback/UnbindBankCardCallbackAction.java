package com.hzfh.p2p.controller.payment.callback;

import com.hzfh.api.customer.model.TradeReqnoInfo;
import com.hzfh.api.payment.model.common.constant.StatusCode;
import com.hzfh.api.payment.model.response.gateway.UnbindBankCardCallback;
import com.hzfh.p2p.controller.common.CallBackAction;
import com.hzfh.p2p.model.common.AuthenticationModel;
import com.hzfh.p2p.model.common.helper.LogHelper;
import com.hzfh.p2p.model.common.parameter.StatusType;
import com.hzfh.p2p.model.common.state.StateValues;
import com.hzfh.p2p.model.customer.PaymentAccountInformationModel;
import com.hzfh.p2p.model.customer.PaymentCustomerBankModel;
import com.hzfh.p2p.model.customer.TradeReqnoInfoModel;

public class UnbindBankCardCallbackAction extends CallBackAction<UnbindBankCardCallback> {
	public static final LogHelper logger = LogHelper.getLogger(UnbindBankCardCallbackAction.class.getName());
	@Override
	public String execute() {
		logger.info("解绑银行卡callback开始");
		if(!verifySign()){
			logger.error("解绑银行卡-callback验签失败");
		}
		if(getResp()==null){
			logger.error("解绑银行卡-callback is null！");
		}
		if (Integer.parseInt(this.getResp().getCode()) == StatusCode.SUCCESS) {
			try {
				PaymentCustomerBankModel.unBindCardBank(AuthenticationModel.getCustomerId());
				logger.info("更新银行卡状态成功！");
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("更新银行卡状态失败！");
			}
			TradeReqnoInfo tradeReqnoInfo = new TradeReqnoInfo();
			tradeReqnoInfo.setCustomerNo(AuthenticationModel.getCustomerId());
			tradeReqnoInfo.setStatus((byte)9);
			tradeReqnoInfo.setSn(getResp().getRequestNo());
			tradeReqnoInfo.setIsOk(1);
			try {
				TradeReqnoInfoModel.add(tradeReqnoInfo);
				logger.info("解除绑定银行卡成功-trade_reqno_info数据添加成功！");
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("解除绑定银行卡成功-trade_reqno_info数据添加失败！");
			}
			try {
				PaymentAccountInformationModel.updateAuthenticationBankCard(StatusType.UN_BIND_BANK_STATUS,AuthenticationModel.getCustomerId());
				logger.info("解绑-更新paymenAccountInformation中银行卡的状态成功！");
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
				logger.error("解绑-更新paymenAccountInformation中银行卡的状态失败！",e1);
			}
			
		}else{
			TradeReqnoInfo tradeReqnoInfo = new TradeReqnoInfo();
			tradeReqnoInfo.setCustomerNo(StateValues.getCustomerId());
			tradeReqnoInfo.setStatus((byte) 06);
			tradeReqnoInfo.setSn(getResp().getRequestNo());
			tradeReqnoInfo.setIsOk(0);
			try {
				TradeReqnoInfoModel.add(tradeReqnoInfo);
				logger.info("解除绑定银行卡失败-trade_reqno_info数据添加成功！");
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("解除绑定银行卡失败-trade_reqno_info数据添加失败！");
			}
		}
		logger.info("绑定银行卡callback结束！");
		return SUCCESS;
	}
}
