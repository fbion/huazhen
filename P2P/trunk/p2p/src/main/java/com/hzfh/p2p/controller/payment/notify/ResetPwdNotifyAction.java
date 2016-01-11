package com.hzfh.p2p.controller.payment.notify;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.hzfh.api.customer.model.TradeReqnoInfo;
import com.hzfh.api.payment.model.common.constant.StatusCode;
import com.hzfh.api.payment.model.response.gateway.RegisterNotify;
import com.hzfh.p2p.controller.common.NotifyAction;
import com.hzfh.p2p.model.common.helper.LogHelper;
import com.hzfh.p2p.model.customer.TradeReqnoInfoModel;


public class ResetPwdNotifyAction extends NotifyAction<RegisterNotify> {
	public static final LogHelper logger = LogHelper.getLogger(ResetPwdNotifyAction.class.getName());
	@Override
	public String execute() {
		logger.info("充值交易密码Notify开始！");
		if (!verifySign()){
        	logger.error("重置交易密码-验签失败！");
			return null;
        }
		System.out.println("验签成功!");
		if(getNotify()==null){
			logger.error("重置交易密码-notify is null!");
			return null;
		}
		int id=Integer.parseInt(getNotify().getPlatformUserNo());
		TradeReqnoInfo tradeReqnoInfo=new TradeReqnoInfo();
		tradeReqnoInfo.setCustomerNo(Integer.parseInt(this.getNotify().getPlatformUserNo()));
		tradeReqnoInfo.setStatus((byte)6);
		tradeReqnoInfo.setSn(this.getNotify().getRequestNo());
		String dateStr = "";
		Date date = new Date();   
	    DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	    dateStr = sdf.format(date); 
	    Timestamp ts = new Timestamp(System.currentTimeMillis());   
        ts = Timestamp.valueOf(dateStr);   
        tradeReqnoInfo.setInTime(ts);
    	TradeReqnoInfo  tradeReqInfo = TradeReqnoInfoModel.getInfoBySnAndIsOk(this.getNotify().getRequestNo(), 1);
		if(Integer.parseInt(this.getNotify().getCode())==StatusCode.SUCCESS&&tradeReqInfo==null){
			//易宝通过后在账户交易里添加一条流水号记录信息，isok为1
			tradeReqnoInfo.setIsOk(1);
			try {
				TradeReqnoInfoModel.add(tradeReqnoInfo);
				logger.info("重置交易密码成功-trade_reqno_info添加成功！");
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("重置交易密码成功-trade_reqno_info添加出现异常！ ",e);
			}
			logger.info("重置交易密码-成功");
		}else{
			//易宝失败后在账户交易里添加一条流水号记录信息，isok为0
			tradeReqnoInfo.setIsOk(0);
			try {
				TradeReqnoInfoModel.add(tradeReqnoInfo);
				logger.info("重置交易密码失败-trade_reqno_info添加成功！");
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("重置交易密码失败-trade_reqno_info添加出现异常！ ",e);
			}
			logger.error("重置交易密码-失败！");
		}
		logger.info("充值交易密码Notify结束！！");
		return sendSuccess();
	}
}
