package com.hzfh.service.baseInfo.helper;

import com.hzfh.api.baseInfo.model.helper.SnEnum;
import com.hzframework.helper.PropertyHelper;


public class SnHelper {
	
	public static final String SN_RECHARGE =PropertyHelper.getContextProperty("sn.recharge").toString();
	public static final String SN_WITHDRAW =PropertyHelper.getContextProperty("sn.withdraw").toString();
	public static final String SN_FREEZE =PropertyHelper.getContextProperty("sn.freeze").toString();
	public static final String SN_CHANGE =PropertyHelper.getContextProperty("sn.change").toString();
	public static final String SN_ENTERPRISEREGISTER =PropertyHelper.getContextProperty("sn.enterpriseRegister").toString();
    public static final String SN_BIND_BANK_CARD =PropertyHelper.getContextProperty("sn.bindBankCard").toString();
    public static final String SN_UNBIND_BANK_CARD =PropertyHelper.getContextProperty("sn.unBindBankCard").toString();

	public static final String SN_REGISTER =PropertyHelper.getContextProperty("sn.register").toString();
	public static final String SN_CHANGEPWD =PropertyHelper.getContextProperty("sn.changepwd").toString();
	public static final String SN_RESET_MOBILE =PropertyHelper.getContextProperty("sn.resetMobile").toString();
	public static final String SN_TRANSFER_REQUEST_NO =PropertyHelper.getContextProperty("sn.requestNo").toString();
	
	public static String getSnHelper(SnEnum snEnum){
		
		String result = "";
		
		switch (snEnum) {
		
		case SN_RECHARGE:
			result= SN_RECHARGE;
			break;
		case SN_WITHDRAW:
			result= SN_WITHDRAW;
			break;
		case SN_FREEZE:
			result= SN_FREEZE;
			break;
		case SN_CHANGE:
			result= SN_CHANGE;
			break;
		case SN_ENTERPRISEREGISTER:
			result= SN_ENTERPRISEREGISTER;
			break;
        case SN_BIND_BANK_CARD:
            result= SN_BIND_BANK_CARD;
            break;
        case SN_UNBIND_BANK_CARD:
            result= SN_UNBIND_BANK_CARD;
            break;
        case SN_RESET_MOBILE:
        	result= SN_RESET_MOBILE;
        	break;
        case SN_TRANSFER_REQUEST_NO:
        	result= SN_TRANSFER_REQUEST_NO;
        	break;

		default:
			break;
		}
		
		return result;
	}
	
	

}
