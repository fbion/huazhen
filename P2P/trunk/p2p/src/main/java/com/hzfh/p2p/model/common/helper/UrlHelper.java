package com.hzfh.p2p.model.common.helper;

import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.properties.WebInfoHelper;
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
            case productDetails:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/product/productDetails";
            case serviceContract:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/product/serviceContract";
            //forgetPassword
            case  forgetPassword:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/forgetPassword";
            case  byEmailPassword:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/byEmailPassword";
            case  resetPassword:
                return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/resetPassword";
            case  resetSuccess:
                return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/resetSuccess";
            case  investorEducationt:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/educationt";
            case  p2pProductList:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/product/p2pProductList";
            case  account:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/account";
            case  paymentAccountSecurity:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/paymentAccountSecurity";
            case  myPaymentMoneyRechargeList:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/paymentMoneyRecharge";
            case  myPaymentMoneyWithdrawList:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/paymentMoneyWithdraw";
            case moneyDetail:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/moneyDetail";
            case announcement:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/baseInfo/announcement/ajaxGetAnnouncement";
            case announcementList:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/baseInfo/announcement/ajaxListAnnouncement";
            case chooseWayPassword:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/chooseWayPassword";
            case bankCard:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/bankCard";
            case myCoupons:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/myCoupons";
            case myIntegral:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/myIntegral";
            case myReward:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/myReward";
            case myInfo:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/myInfo";
            case helpCenter:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/helpCenter";
            case knowledgeForum:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/knowledgeForum";
            case knowledgeForumContent:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/knowledgeForumContent";
            case securityAssurance:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/product/securityAssurance";
            case lawsRegulations:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/product/lawsRegulations";
            case lawsRegulationsContent:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/product/lawsRegulationsContent";	
            case productSuperiority:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/product/productSuperiority";
            case popularize:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/popularize";
            case reservationHelp:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/reservationHelp";
            case financing:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/financing";
            case accountCentral:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/accountCentral";
            	
            	//aboutUs
            case enterpriseCulture:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/enterpriseCulture";
            case aboutCompany:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/aboutCompany";
            case mediaReports:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/mediaReports";
            case bulletin:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/baseInfo/announcement/bulletin";
            case joinUs:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/joinUs";
            case joinUsContent:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/joinUsContent";
            case contactUs:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/contactUs";
            case storeList:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/store/storeList";
            case noviceArea:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/noviceArea";
            case baiduMap:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/baseInfo/map/getStoreMap";
            case myInvite:
            	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/") + "/customer/myInvite";
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
    public static String bulidWebBackUrl(String url){
    	return WebInfoHelper.WEB_BACK_URL+ "/"+url;
    }
    public static String bulidWebUrl(String url){
    	return StringHelper.trimEnd(WebInfoHelper.WEB_P2P_WWW, "/")+url;
    }
    public static String bulidBannerImg(String imgUrl){
    	return WebInfoHelper.WEB_IMG+imgUrl;
    }
}
