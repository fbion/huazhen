package com.hzfh.p2p.model.common.helper;

import com.hzframework.helper.StringHelper;

public class PageAliasHelper {
	public static int getPageType(String pageTpye){
		if(StringHelper.isNullOrEmpty(pageTpye))
			return 0;
		int type = 0;
		switch (pageTpye) {
			case "index"://首页
				type = 1;
				break;
			case "p2pProductList"://产品列表
				type = 2;
				break;
			case "registerSuccess"://注册成功
				type = 4;
				break;
			case "productDetails"://产品详情
				type = 5;
				break;
				
				
			case "aboutCompany"://公司简介
				type = 6;
				break;
			case "enterpriseCulture"://企业文化
				type = 6;
				break;
			case "contactUs"://联系我们
				type = 6;
				break;
			case "joinUs"://加入我们
				type = 6;
				break;
			case "storeList"://门店
				type = 6;
				break;
			case "storeDetail"://门店
				type = 6;
				break;
			case "bulletin"://公告页面
				type = 6;
				break;
			case "mediaReports"://媒体
				type = 6;
				break;
				
			case "register"	:
				type = 7;
				break;
			case "login"	:
				type = 8;
				break;
			default:
				break;
		}
		return type;
	}
}
