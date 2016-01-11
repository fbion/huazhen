package com.hzfh.service.baseInfo.serviceImpl;

import com.hzfh.api.baseInfo.model.Sn;
import com.hzfh.api.baseInfo.model.helper.SnEnum;
import com.hzfh.api.baseInfo.model.query.SnCondition;
import com.hzfh.api.baseInfo.service.SnService;
import com.hzfh.service.baseInfo.dao.SnDao;
import com.hzfh.service.baseInfo.helper.SnHelper;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import com.hzframework.helper.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. Author: GuoZhenYu Create Date:
 * 2015/6/16 Description:
 * 
 * Revision History: Date Author Description
 * 
 ******************************************************************************/

@Service("snService")
public class SnServiceImpl extends BaseServiceImpl<Sn, SnCondition, SnDao>
		implements SnService {

	@Autowired
	private SnDao snDao;

	@Override
	public void truncateSn() {
		snDao.truncateSn();
	}

	@Override
	public String getSn(SnEnum snEnum) {
		String bizCode = SnHelper.getSnHelper(snEnum);
		
		
		
		/*Calendar Cld = Calendar.getInstance();
		int YY = Cld.get(Calendar.YEAR);
		int MM = Cld.get(Calendar.MONTH) + 1;
		int DD = Cld.get(Calendar.DATE);
		int HH = Cld.get(Calendar.HOUR_OF_DAY);
		int mm = Cld.get(Calendar.MINUTE);
		int SS = Cld.get(Calendar.SECOND);
		int MI = Cld.get(Calendar.MILLISECOND);

		
		String tempTime = String.valueOf(YY) + formatNumber(MM)
				+ formatNumber(DD) + formatNumber(HH) + formatNumber(mm)
				+ formatNumber(SS) + formatNumber3(MI);*/
		
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss.SSS");  
		String tempTime=sdf.format(new Date(System.currentTimeMillis()));  
		String regEx="[^0-9]";   
		Pattern p = Pattern.compile(regEx);   
		Matcher m = p.matcher(tempTime);  
		tempTime = m.replaceAll("").trim();
		//System.out.println(tempTime);

		Sn sn = new Sn();

		sn.setBizCode(bizCode);
		sn.setTimeCode(tempTime);

		int resultNo = add(sn);

		String snCode = "";
		if (!StringHelper.isNullOrEmpty(bizCode)) {
			snCode = tempTime + bizCode + formatNumber3(resultNo);
		} else {
			snCode = tempTime + "XX" + formatNumber3(resultNo);
		}

		return snCode;
	}

	/*private static String formatNumber(int number) {
		String resultString = "";
		if (number < 10) {
			resultString = "0" + number;
		} else {
			resultString = String.valueOf(number);
		}
		return resultString;
	}*/

	private static String formatNumber3(int number) {
		String resultString = "";
		if (number < 10) {
			resultString = "00" + String.valueOf(number);
		} else if (number < 100) {
			resultString = "0" + String.valueOf(number);
		} else if (number < 1000) {
			resultString = String.valueOf(number);
		} else {
			String temp = String.valueOf(number);
			resultString = temp.substring(temp.length() - 3, temp.length());
		}
		return resultString;
	}
	// @Override
	// public String getSnHelper(SnEnum snEnum) {
	// return SnHelper.getSnHelper(snEnum);
	// }

}