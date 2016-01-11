package com.hzfh.p2p.controller.common;

import com.hzfh.p2p.model.common.AuthenticationModel;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.properties.ComponentHelper;
import com.hzfh.p2p.model.common.resource.CssContext;
import com.hzfh.p2p.model.common.resource.ScriptContext;
import com.hzframework.helper.StringHelper;

/**
 * Created by paul on 14-12-24.
 */
public abstract class CommonAction extends BaseAction {
    public PageAlias getPageAlias() {
        return pageAlias;
    }

    public String getPageHead() {
        return pageHead;
    }

    public void setPageHead(String pageHead) {
        this.pageHead = pageHead;
    }

    public void setPageAlias(PageAlias pageAlias) {
        this.pageAlias = pageAlias;
    }

    private PageAlias pageAlias;
    private String pageHead = "";
    private String title = "";
    
    private int showInvestBtn;
    private int showReservatBtn;
    
    private String homeUrl;
    private String registerUrl;

    private String loginUrl;

    public String getLoginUrl() {
        return loginUrl;
    }
    private String reservationUrl;
    private String investmentUrl;
    private String personalInfoUrl;
    private String editPasswordUrl;
    private String productFeaturesUrl;
    private String forgetPasswordUrl;
    private String logoutUrl;
    private String educationtUrl;
    private String accountUrl;
    private String moneyDetailUrl;
    private String paymentAccountSecurityUrl;
    private String paymentMoneyRechargeUrl;
    private String paymentMoneyWithdrawUrl;
    private String p2pProductListUrl;
    private String productDetailsUrl;
    private String bankCardUrl;
    private String myCouponsUrl;
    private String myIntegralUrl;
    private String myRewardUrl;
    private String myInfoUrl;
    private String helpCenterUrl;
    private String knowledgeForumUrl;
    private String knowledgeForumContentUrl;
    
    
    public String getKnowledgeForumContentUrl() {
		return knowledgeForumContentUrl;
	}

	private String popularizeUrl;
    private String reservationHelpUrl;
    private String financingUrl;
    private String accountCentralUrl;
    private String securityAssuranceUrl;
    private String lawsRegulationsUrl;
    private String lawsRegulationsContentUrl;
    private String productSuperiorityUrl;
    private String serviceContractUrl;
    
    

	private String enterpriseCultureUrl;
    private String mediaReportsUrl;
    private String aboutCompanyUrl;
    private String bulletinUrl;
    private String joinUsUrl;
    private String joinUsContentUrl;
    private String storeUrl;
    private String myInviteUrl;
    

	public String getServiceContractUrl() {
		return serviceContractUrl;
	}
    public String getStoreUrl() {
		return storeUrl;
	}

	public String getJoinUsContentUrl() {
		return joinUsContentUrl;
	}

	public String getMyInviteUrl() {
		return myInviteUrl;
	}

	public String getLawsRegulationsContentUrl() {
		return lawsRegulationsContentUrl;
	}

	private String contactUsUrl;
    private String noviceAreaUrl;
    
    private String qqLoginImg;
   	public String getQqLoginImg() {
   		return qqLoginImg;
   	}
    
    public String getProductDetailsUrl() {
		return productDetailsUrl;
	}

	public String getNoviceAreaUrl() {
		return noviceAreaUrl;
	}

	public String getMediaReportsUrl() {
		return mediaReportsUrl;
	}

	public String getAboutCompanyUrl() {
		return aboutCompanyUrl;
	}

	public String getBulletinUrl() {
		return bulletinUrl;
	}

	public String getJoinUsUrl() {
		return joinUsUrl;
	}

	public String getContactUsUrl() {
		return contactUsUrl;
	}

	public String getAccountCentralUrl() {
		return accountCentralUrl;
	}

	public String getFinancingUrl() {
		return financingUrl;
	}

	public String getReservationHelpUrl() {
		return reservationHelpUrl;
	}

	public String getPopularizeUrl() {
		return popularizeUrl;
	}

	public String getKnowledgeForumUrl() {
		return knowledgeForumUrl;
	}

	public String getHelpCenterUrl() {
		return helpCenterUrl;
	}

	public String getSecurityAssuranceUrl() {
		return securityAssuranceUrl;
	}
	public String getLawsRegulationsUrl() {
		return lawsRegulationsUrl;
	}
	public String getProductSuperiorityUrl() {
		return productSuperiorityUrl;
	}

	public String getMyInfoUrl() {
		return myInfoUrl;
	}

	public String getMyRewardUrl() {
		return myRewardUrl;
	}

	public String getMyIntegralUrl() {
		return myIntegralUrl;
	}

	public String getMyCouponsUrl() {
		return myCouponsUrl;
	}

	public String getBankCardUrl() {
		return bankCardUrl;
	}

	public String getP2pProductListUrl() {
		return p2pProductListUrl;
	}



	public String getEnterpriseCultureUrl() {
		return enterpriseCultureUrl;
	}

	public String getPaymentMoneyWithdrawUrl() {
		return paymentMoneyWithdrawUrl;
	}

	public String getPaymentMoneyRechargeUrl() {
		return paymentMoneyRechargeUrl;
	}

	public String getMoneyDetailUrl() {
		return moneyDetailUrl;
	}

	public String getPaymentAccountSecurityUrl() {
		return paymentAccountSecurityUrl;
	}

	public String getAccountUrl() {
		return accountUrl;
	}

	public String getLogoutUrl() {
        return logoutUrl;
    }

    public String getEducationtUrl() {
		return educationtUrl;
	}

	public String getForgetPasswordUrl() {
        return forgetPasswordUrl;
    }

    public String getProductFeaturesUrl() {
        return productFeaturesUrl;
    }

    public String getInvestmentUrl() {
        return investmentUrl;
    }

    public String getPersonalInfoUrl() {
        return personalInfoUrl;
    }

    public String getEditPasswordUrl() {
        return editPasswordUrl;
    }

    public String getReservationUrl() {
        return reservationUrl;
    }

    public String getRegisterUrl() {
        return registerUrl;
    }

    public String getHomeUrl() {
        return homeUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private boolean showLoginUrl;

    public boolean isShowLoginUrl() {
        return showLoginUrl;
    }

    private String currentUser;

    public String getCurrentUser() {
        return currentUser;
    }

    public String logoUrl;
	public String getLogoUrl() {
		return logoUrl;
	}

	public int getShowInvestBtn() {
		return showInvestBtn;
	}

	public int getShowReservatBtn() {
		return showReservatBtn;
	}

	@Override
    public String execute() {
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        if (this.pageAlias.toString().isEmpty())
            this.pageAlias = PageAlias.index;

        this.buildTitle();
        this.buildCss();
        this.buildJs();

        
        this.homeUrl = this.buildWWWSiteUrl(PageAlias.index);
        this.loginUrl = this.buildWWWSiteUrl(PageAlias.login);
        this.registerUrl = this.buildWWWSiteUrl(PageAlias.register);
        this.reservationUrl = this.buildWWWSiteUrl(PageAlias.myReservation);
        this.investmentUrl = this.buildWWWSiteUrl(PageAlias.myInvestment);
        this.personalInfoUrl = this.buildWWWSiteUrl(PageAlias.personalInfo);
        this.editPasswordUrl = this.buildWWWSiteUrl(PageAlias.editPassword);
        this.productFeaturesUrl = this.buildWWWSiteUrl(PageAlias.productFeatures);
        this.forgetPasswordUrl = this.buildWWWSiteUrl(PageAlias.forgetPassword);
        this.logoutUrl = this.buildWWWSiteUrl(PageAlias.logout);
        this.educationtUrl = this.buildWWWSiteUrl(PageAlias.investorEducationt);
        this.accountUrl = this.buildWWWSiteUrl(PageAlias.account);
        this.moneyDetailUrl = this.buildWWWSiteUrl(PageAlias.moneyDetail);
        this.paymentAccountSecurityUrl = this.buildWWWSiteUrl(PageAlias.paymentAccountSecurity);
        this.paymentMoneyRechargeUrl = this.buildWWWSiteUrl(PageAlias.myPaymentMoneyRechargeList);
        this.paymentMoneyWithdrawUrl = this.buildWWWSiteUrl(PageAlias.myPaymentMoneyWithdrawList);
        this.p2pProductListUrl = this.buildWWWSiteUrl(PageAlias.p2pProductList);
        this.productDetailsUrl = this.buildWWWSiteUrl(PageAlias.productDetails);
        this.bankCardUrl = this.buildWWWSiteUrl(PageAlias.bankCard);
        this.myCouponsUrl = this.buildWWWSiteUrl(PageAlias.myCoupons);
        this.myIntegralUrl = this.buildWWWSiteUrl(PageAlias.myIntegral);
        this.myRewardUrl = this.buildWWWSiteUrl(PageAlias.myReward);
        this.myInfoUrl = this.buildWWWSiteUrl(PageAlias.myInfo);
        this.helpCenterUrl = this.buildWWWSiteUrl(PageAlias.helpCenter);
        this.knowledgeForumUrl = this.buildWWWSiteUrl(PageAlias.knowledgeForum);
        this.knowledgeForumContentUrl = this.buildWWWSiteUrl(PageAlias.knowledgeForumContent);
        this.logoUrl = this.buildImg("favicon.ico");
        this.securityAssuranceUrl = this.buildWWWSiteUrl(PageAlias.securityAssurance);
        this.lawsRegulationsUrl = this.buildWWWSiteUrl(PageAlias.lawsRegulations);
        this.lawsRegulationsContentUrl = this.buildWWWSiteUrl(PageAlias.lawsRegulationsContent);
        this.productSuperiorityUrl = this.buildWWWSiteUrl(PageAlias.productSuperiority);
        this.popularizeUrl = this.buildWWWSiteUrl(PageAlias.popularize);
        this.reservationHelpUrl = this.buildWWWSiteUrl(PageAlias.reservationHelp);
        this.financingUrl = this.buildWWWSiteUrl(PageAlias.financing);
        this.accountCentralUrl = this.buildWWWSiteUrl(PageAlias.accountCentral);
        
        this.enterpriseCultureUrl = this.buildWWWSiteUrl(PageAlias.enterpriseCulture);
        this.mediaReportsUrl = this.buildWWWSiteUrl(PageAlias.mediaReports);
        this.aboutCompanyUrl = this.buildWWWSiteUrl(PageAlias.aboutCompany);
        this.bulletinUrl = this.buildWWWSiteUrl(PageAlias.bulletin);
        this.joinUsUrl = this.buildWWWSiteUrl(PageAlias.joinUs);
        this.joinUsContentUrl = this.buildWWWSiteUrl(PageAlias.joinUsContent);
        this.contactUsUrl = this.buildWWWSiteUrl(PageAlias.contactUs);
        this.storeUrl = this.buildWWWSiteUrl(PageAlias.storeList);
        this.serviceContractUrl = this.buildWWWSiteUrl(PageAlias.serviceContract);
        this.noviceAreaUrl = this.buildWWWSiteUrl(PageAlias.noviceArea);
        this.myInviteUrl = this.buildWWWSiteUrl(PageAlias.myInvite);
        
        qqLoginImg = this.buildImg("qq_login.png");
        
        showInvestBtn = ComponentHelper.SHOW_INVESTBTN;
        showReservatBtn = ComponentHelper.SHOW_RESERVATBTN;
        
        if (AuthenticationModel.isLogin()) {
            this.showLoginUrl = false;
            String realName = AuthenticationModel.getLoginInfo().getP2pCustomer().getRealName();
            String userName = AuthenticationModel.getUserName();
            String cellPhone = AuthenticationModel.getLoginInfo().getP2pCustomer().getCellphone();
            if(!StringHelper.isNullOrEmpty(realName))
            	this.currentUser = realName;
            else if(userName.length()<36)
            	this.currentUser = userName;
            else if(!StringHelper.isNullOrEmpty(cellPhone))
            	this.currentUser = cellPhone;
        } else
            this.showLoginUrl = true;

        return SUCCESS;
    }

    private void buildTitle() {
        switch (this.pageAlias) {
            case index:
                this.title = "我爱投资|华镇社区金融|现房宝";
                break;
            case register:
                this.title = "注册|我爱投资|华镇社区金融|现房宝";
                break;
            case login:
            	this.title = "登录|我爱投资|华镇社区金融|现房宝";
            	break;           
            case editPassword:
            	this.title = "修改密码|我爱投资|华镇社区金融|现房宝";
            	break;
            case forgetPassword:
            	this.title = "忘记密码|我爱投资|华镇社区金融|现房宝";
            	break;
            case investorEducationt:
            	this.title = "投资者教育|我爱投资|华镇社区金融|现房宝";
            	break;
            //安全保障	
            case productFeatures:
            	this.title = "理财产品|我爱投资|华镇社区金融|现房宝";
            	break;
            case productSuperiority:
            	this.title = "产品优势|我爱投资|华镇社区金融|现房宝";
            	break;
            case securityAssurance:
            	this.title = "安全保障|我爱投资|华镇社区金融|现房宝";
            	break;
            case lawsRegulations:
            	this.title = "法律法规|我爱投资|华镇社区金融|现房宝";
            	break;
            case serviceContract:
            	this.title = "服务协议|我爱投资|华镇社区金融|现房宝";
            	break;
            case lawsRegulationsContent:
            	this.title = "法律法规|我爱投资|华镇社区金融|现房宝";
            	break;
            //我的账户	
            case account:
            	this.title = "账户总览|我爱投资|华镇社区金融|现房宝";
            	break;
            case myReservation:
            	this.title = "我的预约|我爱投资|华镇社区金融|现房宝";
            	break;
            case myInvestment:
            	this.title = "我的投资|我爱投资|华镇社区金融|现房宝";
            	break;
            case moneyDetail:
            	this.title = "资金明细|我爱投资|华镇社区金融|现房宝";
            	break;
            case myPaymentMoneyRechargeList:
            	this.title = "充值|我爱投资|华镇社区金融|现房宝";
            	break;
            case myPaymentMoneyWithdrawList:
            	this.title = "提现|我爱投资|华镇社区金融|现房宝";
            	break;
            case personalInfo:
            	this.title = "完善个人信息|我爱投资|华镇社区金融|现房宝";
            	break;
            case bankCard:
            	this.title = "银行卡管理|我爱投资|华镇社区金融|现房宝";
            	break;
            case paymentAccountSecurity:
            	this.title = "安全设置|我爱投资|华镇社区金融|现房宝";
            	break;
            //财富产品	
            case p2pProductList:
            	this.title = "财富产品|我爱投资|华镇社区金融|现房宝";
            	break;
            case productDetails:
            	this.title = "产品详情|我爱投资|华镇社区金融|现房宝";
            	break;
            //帮助中心
            case helpCenter:
            	this.title = "注册登录|我爱投资|华镇社区金融|现房宝";
            	break;
            case reservationHelp:
            	this.title = "预约投资|我爱投资|华镇社区金融|现房宝";
            	break;
            case accountCentral:
            	this.title = "账户中心|我爱投资|华镇社区金融|现房宝";
            	break;
            case knowledgeForum:
            	this.title = "知识讲堂|我爱投资|华镇社区金融|现房宝";
            	break;
            	
            //关于我们	
            case aboutCompany:
            	this.title = "公司简介|我爱投资|华镇社区金融|现房宝";
            	break;
            case enterpriseCulture:
            	this.title = "企业文化|我爱投资|华镇社区金融|现房宝";
            	break;
            case contactUs:
            	this.title = "联系我们|我爱投资|华镇社区金融|现房宝";
            	break;
            case storeList:
            	this.title = "旗下门店|我爱投资|华镇社区金融|现房宝";
            	break;
            case storeDetail:
            	this.title = "门店详情|我爱投资|华镇社区金融|现房宝";
            	break;
            case joinUs:
            	this.title = "加入我们|我爱投资|华镇社区金融|现房宝";
            	break;
            case bulletin:
            	this.title = "网站公告|我爱投资|华镇社区金融|现房宝";
            	break;
            case mediaReports:
            	this.title = "媒体报道|我爱投资|华镇社区金融|现房宝";
            	break;
            default:
                this.title = "我爱投资|华镇社区金融|现房宝";
                break;
        }
    }

    private void buildJs() {
        StringBuilder stringBuilder = new StringBuilder();

        for (String script : ScriptContext.getScriptByPageAlias(this.pageAlias)) {
            stringBuilder.append(script);
        }

        pageHead += stringBuilder.toString();
    }

    private void buildCss() {
        StringBuilder stringBuilder = new StringBuilder();

        for (String css : CssContext.getCssByPageAlias(this.pageAlias)) {
            stringBuilder.append(css);
        }
        //stringBuilder.append("<link type=\"text/css\" rel=\"stylesheet\" href=\""+ UrlHelper.buildCss("page.css")+"\">");

        pageHead += stringBuilder.toString();
    }

}
