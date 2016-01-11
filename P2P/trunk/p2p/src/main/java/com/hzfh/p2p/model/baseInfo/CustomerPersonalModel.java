package com.hzfh.p2p.model.baseInfo;

import com.hzfh.api.customer.model.CustomerPersonal;
import com.hzfh.p2p.facade.baseInfo.CustomerPersonalFacade;
import com.hzfh.p2p.model.common.helper.EncodeHelper;
import com.hzframework.helper.PropertyHelper;

public class CustomerPersonalModel {

    public static CustomerPersonal getInfo(int id) {
        CustomerPersonal customerPersonal = CustomerPersonalFacade.getInfo(id);

        return decryptDES(customerPersonal);
    }
    public static CustomerPersonal decryptDES(CustomerPersonal customerPersonal){
        if(customerPersonal.getCardNumber()!=null&&customerPersonal.getCardNumber().split("-")[0].equalsIgnoreCase("m")){
            customerPersonal.setCardNumber(EncodeHelper.decryptDESFMP(customerPersonal.getCardNumber().split("-")[1]));
        }
        if(customerPersonal.getCellphone1()!=null&&customerPersonal.getCellphone1().split("-")[0].equalsIgnoreCase("m")){
            customerPersonal.setCellphone1(EncodeHelper.decryptDESFMP(customerPersonal.getCellphone1().split("-")[1]));
        }
        if(customerPersonal.getCellphone2()!=null&&customerPersonal.getCellphone2().split("-")[0].equalsIgnoreCase("m")){
            customerPersonal.setCellphone2(EncodeHelper.decryptDESFMP(customerPersonal.getCellphone2().split("-")[1]));
        }
        if(customerPersonal.getPhone()!=null&&customerPersonal.getPhone().split("-")[0].equalsIgnoreCase("m")){
            customerPersonal.setPhone(EncodeHelper.decryptDESFMP(customerPersonal.getPhone().split("-")[1]));
        }
        return customerPersonal;
    }
	public static CustomerPersonal getInfoByCardNumber(String cardNumber) {
		
		cardNumber = "m-"+EncodeHelper.encryptDESFMP(cardNumber);
		cardNumber = cardNumber.replaceAll("\r|\n", "");
		return  CustomerPersonalFacade.getInfoByCardNumber(cardNumber);
	}




}
