package com.hzfh.p2p.model.common.helper;

public class MoneyHelper {
	/**
	 * money 转换 亿、千万、万
	 * @param money
	 * @return
	 */
	public static String getMoney(long money){
		if (money>=100000000){
			long a = money/100000000;
			
			long b = money%100000000;
			
			if (b>0)
				return String.valueOf(a) + "亿" + String.valueOf(b);
			else
				return String.valueOf(a) + "亿";			
		}else if (money>=10000000){
			long a = money/10000000;
			
			long b = money%10000000;
			
			if (b>0)
				return String.valueOf(a) + "千万" + String.valueOf(b);
			else
				return String.valueOf(a) + "千万";			
		}	else	if (money>=10000){
			long a = money/10000;
			
			long b = money%10000;
			
			if (b>0)
				return String.valueOf(a) + "万" + String.valueOf(b);
			else
				return String.valueOf(a) + "万";			
		}		
		else 
			return String.valueOf(money);
	}
}
