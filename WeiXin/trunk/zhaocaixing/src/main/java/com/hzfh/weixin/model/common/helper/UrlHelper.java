package com.hzfh.weixin.model.common.helper;

import com.hzfh.weixin.model.common.PageAlias;
import com.hzfh.weixin.model.common.properties.WebInfoHelper;
import com.hzframework.helper.StringHelper;

/**
 * Created by paul on 15-1-6.
 */
public class UrlHelper {
    public static String buildWWWSiteUrl(PageAlias pageAlias) {
        switch(pageAlias){
            case captcha:
                return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/captcha";
            case index:
                return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/index";
            case register:
                return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/register";
            case registerSuccess:
                return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/registerSuccess";
            case emailValidation:
                return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/emailValidation";
            case login:
                return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/login";
            case logout:
                return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/logout";
            case productDetails:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/productDetails";
            case productDetailsInfo:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/productDetailsInfo";
            case investInfo:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/investInfo";
            case myInvestment:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/myInvestment";
            case personalInfo:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/personalInfo";
            case myReservation:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/myReservation";
            case editPassword:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/editPassword";
            case  productFeatures:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/product/productFeatures";
            case  forgetPassword:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/forgetPassword";
            case  resetPassword:
                return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/resetPassword";
            case  resetSuccess:
                return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/resetSuccess";
            case  investorEducationt:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/educationt";
            case myInvite:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/myInvite";
            case baiduMap:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/baseInfo/map/getStoreMap";
            case serviceContract:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/product/serviceContract";
            case storeList:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/store/storeList";
            default:
                return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/index";
        }
    }

    public static String buildJs(String js) {
        return WebInfoHelper.WEB_P2P_RESOURCE_JS + "/" + js;
    }

    public static String buildCss(String css) {
        return WebInfoHelper.WEB_P2P_RESOURCE_CSS + "/" + css;
    }

    public static String buildImg(String img) {
        return WebInfoHelper.WEB_P2P_RESOURCE_IMG + "/" + img;
    }
    public static String buildWebImg(String webImg) {
    	return WebInfoHelper.WEB_IMG + "/" + webImg;
    }

    public static String buildDevJs(String js) {
        return WebInfoHelper.WEB_P2P_DEV_JS + "/" + js;
    }
    
    public static String bulidWebUploadPath(String path){
    	return WebInfoHelper.WEB_UPLOAD+ "/"+path;
    }
    public static String bulidWinXinBackUrl(String path){
    	return WebInfoHelper.WEB_P2P_WWW+ "/"+path;
    }
}
