package com.hzfh.weixin.controller.common;

import com.hzfh.weixin.model.common.AuthenticationModel;
import com.hzfh.weixin.model.common.PageAlias;
import com.hzfh.weixin.model.common.resource.CssContext;
import com.hzfh.weixin.model.common.resource.ScriptContext;
import com.hzfh.weixin.model.common.state.StateValues;
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
    private String homeUrl;
    private String registerUrl;
    private String loginUrl;

    public String getLoginUrl() {
        return loginUrl;
    }
    private String codeUrl;
    private String reservationUrl;
    private String investmentUrl;
    private String personalInfoUrl;
    private String editPasswordUrl;
    private String productFeaturesUrl;
    private String forgetPasswordUrl;
    private String logoutUrl;
    private String educationtUrl;
    private String logoUrl;
    private String productDescriptionUrl;
    private String productAdvantageUrl;
    private String serviceContractUrl;
    
public String getServiceContractUrl() {
		return serviceContractUrl;
	}

	//    private String loginWithCellphoneUrl;
    private String storeUrl;

	public String getStoreUrl() {
		return storeUrl;
	}

	public void setStoreUrl(String storeUrl) {
		this.storeUrl = storeUrl;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
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
   
	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}
	
	public String getCodeUrl() {
		return codeUrl;
	}
	
	public void setCodeUrl(String codeUrl) {
		this.codeUrl = codeUrl;
	}

	private String logUrl;
	private String mapUrl;
	private String myInvite;
	
	
	
	public String getMyInvite() {
		return myInvite;
	}

	public String getProductDescriptionUrl() {
		return productDescriptionUrl;
	}

	public String getProductAdvantageUrl() {
		return productAdvantageUrl;
	}


	
	public String getLogUrl() {
		return logUrl;
	}

	public String getMapUrl() {
		return mapUrl;
	}

	@Override
    public String execute() {
	    
	    
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        if (this.pageAlias.toString().isEmpty())
            this.pageAlias = PageAlias.index;
        //save userName cookie
        this.setCurrentUser(StateValues.getUserName());
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
        //img url
        this.logoUrl = this.buildImg("logo.png");
        this.productDescriptionUrl = this.buildImg("productDescription.jpg");
        this.productAdvantageUrl = this.buildImg("productAdvantage.jpg");
        this.logUrl = this.buildImg("log.png");
        this.mapUrl = this.buildImg("map.jpg");
        this.myInvite= this.buildWWWSiteUrl(PageAlias.myInvite);
        this.storeUrl= this.buildWWWSiteUrl(PageAlias.storeList);
        this.serviceContractUrl = this.buildWWWSiteUrl(PageAlias.serviceContract);
        
        if (AuthenticationModel.isLogin()) {
            this.showLoginUrl = false;
           /* this.currentUser = AuthenticationModel.getUserName();*/
            String realName = AuthenticationModel.getLoginInfo().getP2pCustomer().getRealName();
            String userName = AuthenticationModel.getUserName();
            String cellPhone = AuthenticationModel.getLoginInfo().getP2pCustomer().getCellphone();
            if(!StringHelper.isNullOrEmpty(realName))
            	this.currentUser = realName;
            else if(userName.length()<36)
            	this.currentUser = userName;
            else{
            	this.currentUser = cellPhone;
            }
            
           if(this.currentUser.length()>3){
        	   this.currentUser = currentUser.substring(0,3)+"...,您好!";
           }
        } else
            this.showLoginUrl = true;

        return SUCCESS;
    }

    private void buildTitle() {
        switch (this.pageAlias) {
            case  index:
            	 this.title = "现房宝|我爱投资|华镇社区金融";
                 break;
            case  register:
            	 this.title = "注册|现房宝|我爱投资|华镇社区金融";
                 break;
            case  newRegister:
            	this.title = "注册|现房宝|我爱投资|华镇社区金融";
                break;
            case  registerSuccess:
            	this.title = "注册成功|现房宝|我爱投资|华镇社区金融";
                break;
            case  newRegisterSuccess:
            	this.title = "注册成功|现房宝|我爱投资|华镇社区金融";
                break;
            case  login:
            	this.title = "登录|现房宝|我爱投资|华镇社区金融";
            	break;
            case  productDetails:
            	this.title = "产品详情|现房宝|我爱投资|华镇社区金融";
            	break;
            case  productDetailsInfo:
            	this.title = "产品详情|现房宝|我爱投资|华镇社区金融";
            	break;
            case  myInvestment:
            	this.title = "我的投资|现房宝|我爱投资|华镇社区金融";
            	break;
            case  myReservation:
            	this.title = "我的预约|现房宝|我爱投资|华镇社区金融";
            	break;
            case  personalInfo:
            	this.title = "个人信息|现房宝|我爱投资|华镇社区金融";
            	break;
            case  editPassword:
            	this.title = "修改密码|现房宝|我爱投资|华镇社区金融";
            	break;
            case  productFeatures:
            	this.title = "理财产品|现房宝|我爱投资|华镇社区金融";
            	break;
            case  forgetPassword:
            	this.title = "忘记密码|现房宝|我爱投资|华镇社区金融";
            	break;
            case  resetPassword:
            	this.title = "重置密码|现房宝|我爱投资|华镇社区金融";
            	break;
            case  resetSuccess:
            	this.title = "重置成功|现房宝|我爱投资|华镇社区金融";
            	break;
            case  investorEducationt:
            	this.title = "投资者教育|现房宝|我爱投资|华镇社区金融";
            	break;
            case  paymentAccountSecurity:
            	this.title = "安全设置|现房宝|我爱投资|华镇社区金融";
            	break;
            case  myInvite:
            	this.title = "我的投资|现房宝|我爱投资|华镇社区金融";
            	break;
            case  storeDetail:
            	this.title = "门店详情|现房宝|我爱投资|华镇社区金融";
            	break;
            case  storeList:
            	this.title = "旗下门店|现房宝|我爱投资|华镇社区金融";
            	break;
            case  baiduMap:
            	this.title = "登录|现房宝|我爱投资|华镇社区金融";
            	break;
            case  serviceContract:
            	this.title = "服务协议|现房宝|我爱投资|华镇社区金融";
            	break;
            default:
            	 this.title = "现房宝|我爱投资|华镇社区金融";
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

        pageHead += stringBuilder.toString();
    }
   
}
