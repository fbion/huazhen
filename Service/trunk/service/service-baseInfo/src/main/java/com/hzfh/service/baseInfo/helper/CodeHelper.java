package com.hzfh.service.baseInfo.helper;

import com.hzfh.api.baseInfo.model.Sn;
import com.hzfh.api.baseInfo.service.SnService;
import com.hzframework.helper.StringHelper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;


public class CodeHelper {
    
    public static String getSn(String bizCode){

    	Calendar Cld = Calendar.getInstance();
    	int YY = Cld.get(Calendar.YEAR) ;
    	int MM = Cld.get(Calendar.MONTH)+1;
    	int DD = Cld.get(Calendar.DATE);
    	int HH = Cld.get(Calendar.HOUR_OF_DAY);
    	int mm = Cld.get(Calendar.MINUTE);
    	int SS = Cld.get(Calendar.SECOND);
    	int MI = Cld.get(Calendar.MILLISECOND);
    	
    	String tempTime = String.valueOf(YY) + formatNumber(MM) + formatNumber(DD) + formatNumber(HH) +formatNumber(mm) + formatNumber(SS) + formatNumber3(MI);
    	
    	
    	Sn sn = new Sn();
    	
    	sn.setBizCode(bizCode);
    	sn.setTimeCode(tempTime);

    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SnService snService = (SnService) context.getBean("snService");
    	
        int resultNo = snService.add(sn);
    	
    	String snCode = "";
    	if (!StringHelper.isNullOrEmpty(bizCode)) {
    		snCode = tempTime + bizCode + formatNumber3(resultNo);	
		}else{
			snCode = tempTime + "XX" + formatNumber3(resultNo);	
		}
    	
//    	sn.setId(resultNo);
//    	sn.setCode(snCode);
//    	int re = snService.update(sn);
    	
    	return snCode;
    }
    
    private static String formatNumber(int number){
    	String resultString = "";
    	if (number<10) {
    		resultString = "0"+ number;
		}else{
			resultString = String.valueOf(number);
		}
    	return resultString;
    }
    
    private static String formatNumber3(int number){
    	String resultString = "";
    	if (number<10) {
    		resultString = "00" + String.valueOf(number);
		}else if(number<100){
			resultString ="0" + String.valueOf(number);
		}else if(number<1000){
			resultString = String.valueOf(number);
		}else{
			String temp = String.valueOf(number);
			resultString = temp.substring(temp.length()-3, temp.length());
		}
    	return resultString;
    }
    
    
}