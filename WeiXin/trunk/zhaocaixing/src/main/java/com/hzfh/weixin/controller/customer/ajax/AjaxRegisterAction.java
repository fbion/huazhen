package com.hzfh.weixin.controller.customer.ajax;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.baseInfo.model.DicData;
import com.hzfh.api.baseInfo.model.helper.SnEnum;
import com.hzfh.api.customer.model.Activities;
import com.hzfh.api.customer.model.ActivityAwardRelation;
import com.hzfh.api.customer.model.ActivityCashBonus;
import com.hzfh.api.customer.model.ActivityCondition;
import com.hzfh.api.customer.model.ActivityCustomerCashBonus;
import com.hzfh.api.customer.model.ActivityCustomerDetail;
import com.hzfh.api.customer.model.ActivityCustomerExperienceGold;
import com.hzfh.api.customer.model.ActivityCustomerInvitation;
import com.hzfh.api.customer.model.ActivityCustomerTask;
import com.hzfh.api.customer.model.ActivityExperienceGold;
import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.weixin.controller.common.DateUtil;
import com.hzfh.weixin.controller.common.JsonBaseAction;
import com.hzfh.weixin.controller.common.JsonBaseAction.MessageType;
import com.hzfh.weixin.model.baseInfo.CaptchaModel;
import com.hzfh.weixin.model.baseInfo.DicDataModel;
import com.hzfh.weixin.model.baseInfo.LetterModel;
import com.hzfh.weixin.model.baseInfo.SmsModel;
import com.hzfh.weixin.model.baseInfo.SnModel;
import com.hzfh.weixin.model.common.helper.CharacterFilter;
import com.hzfh.weixin.model.common.helper.EncodeHelper;
import com.hzfh.weixin.model.common.paramter.ActivitiesInfo;
import com.hzfh.weixin.model.common.state.StateValues;
import com.hzfh.weixin.model.customer.ActivitiesModel;
import com.hzfh.weixin.model.customer.ActivityAwardRelationModel;
import com.hzfh.weixin.model.customer.ActivityCashBonusModel;
import com.hzfh.weixin.model.customer.ActivityConditionModel;
import com.hzfh.weixin.model.customer.ActivityCustomerCashBonusModel;
import com.hzfh.weixin.model.customer.ActivityCustomerDetailModel;
import com.hzfh.weixin.model.customer.ActivityCustomerExperienceGoldModel;
import com.hzfh.weixin.model.customer.ActivityCustomerInvitationModel;
import com.hzfh.weixin.model.customer.ActivityCustomerTaskModel;
import com.hzfh.weixin.model.customer.ActivityExperienceGoldModel;
import com.hzfh.weixin.model.customer.P2pCustomerModel;
import com.hzfh.weixin.model.customer.PaymentAccountInformationModel;
import com.hzfh.weixin.model.product.P2pProductModel;
import com.hzframework.helper.HttpHelper;
import com.hzframework.helper.PropertyHelper;
import com.hzframework.helper.StringHelper;

/**
 * Created by paul on 15-2-5.
 */
public class AjaxRegisterAction extends JsonBaseAction<P2pCustomer> {
    private String userName;//用户名
    private String verifyCode;//验证码
    private P2pCustomer p2pCustomer;//p2p客户对象
    private String code;
    private String isAutoLogin;
    private String telephone;
    private String smsCaptcha;
    private String inviterNo;
    private String activityId;
    private String isCellphoneLogin;
    
    public String getIsCellphoneLogin() {
		return isCellphoneLogin;
	}
	public void setIsCellphoneLogin(String isCellphoneLogin) {
		this.isCellphoneLogin = isCellphoneLogin;
	}
	public String getInviterNo() {
		return inviterNo;
	}
	public void setInviterNo(String inviterNo) {
		this.inviterNo = inviterNo;
	}
	public String getActivityId() {
		return activityId;
	}
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	public void setSmsCaptcha(String smsCaptcha) {
		this.smsCaptcha = smsCaptcha;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getCode() {
		return code;
	}
    public void setIsAutoLogin(String isAutoLogin) {
        this.isAutoLogin = isAutoLogin;
    }
	public void setCode(String code) {
		this.code = code;
	}

	public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public void setP2pCustomer(String p2pCustomer) {
        this.p2pCustomer = JSON.parseObject(p2pCustomer, P2pCustomer.class);
    }
    
	//下面的方法是异步验证用户名是否能填写
    public String checkUserName() {//验证用户名注册是否重复
        this.message = new Message();    //定义返回错误信息对象
        //根据输入的用户名称 查询是否存在用户对象
        P2pCustomer p2pCustomerForCheckUserName = P2pCustomerModel.selectByUserName(userName.trim());
        if (p2pCustomerForCheckUserName == null) {
            this.message.setType(MessageType.Info);    //返回的信息类型
            this.message.setDescription("尚未注册");    //返回的信息内容
        } else {                                        //已经存在用户名
            this.message.setType(MessageType.Warning);    // 返回信息类型
            this.message.setDescription("该账号已注册，请更换账号后再试一次");//返回内容

        }
        return SUCCESS; //本action 成功执行
    }
    
    public String checkTelephone() {
    	this.message = new Message();    //定义返回错误信息对象
    	P2pCustomer p2pCustomerForCheckTelephone = P2pCustomerModel.getInfoByCellphone(this.telephone.trim());
    	if(isCellphoneLogin.equals("1")){
    		if (p2pCustomerForCheckTelephone == null) {
    			this.message.setType(MessageType.Warning);    
    			this.message.setDescription("您还没有注册");
    		}
    	}else{
    		if (p2pCustomerForCheckTelephone == null) {
    			this.message.setType(MessageType.Info);    //返回的信息类型
    			this.message.setDescription("尚未注册");    //返回的信息内容
    		} else {                                       
    			this.message.setType(MessageType.Warning);    // 返回信息类型
    			this.message.setDescription("该手机号码已被注册，请更换其他手机号码");//返回内容
    		}
    	}
    	return SUCCESS;
    }
    public String checkInviteCellphone(){
 	   this.message = new Message();
 	   this.message.setType(MessageType.Info);
 	  
 	   if(!CharacterFilter.isVaildCellphone(this.inviterNo)){
        	this.message.setType(MessageType.Error);
            this.message.setDescription("请输入正确的手机号码");
            return SUCCESS;
        }
 	   if(P2pCustomerModel.getInfoByCellphone(inviterNo) == null){
        	   this.message.setType(MessageType.Warning);
        	   this.message.setDescription("邀请人手机号码未注册，请更换其他手机号码");
        	   return SUCCESS;
        }
 	   if(activityId==null||("").endsWith(activityId)){
 			Activities  activities = ActivitiesModel.getInfoByActivitytype(ActivitiesInfo.ACTIVITY_CASH_TYPE);
 			activityId =activities.getId()+"";
 		}
/* 	   P2pCustomer  customer= P2pCustomerModel.getInfoByCellphone(inviterNo);
 	   ActivityCustomerTask activityCustomerTask = ActivityCustomerTaskModel.getInfoByCondition(customer.getId(),Integer.parseInt(activityId));

 	   if(activityCustomerTask==null){
 		   this.message.setType(MessageType.Warning);
        	   this.message.setDescription(inviterNo+"该用户未参加邀请活动");
        	   return SUCCESS;
 	   }*/
 	   return SUCCESS;
    }
    	

    @SuppressWarnings("static-access")
	@Override
    public String execute() {   

    	
    	//注册主函数
        this.message = new Message();//同理 定义一个返回错误消息函数
        //验证码的 判断
        if (!CharacterFilter.isVaildVerifyCode(verifyCode))//验证码格式正则验证

        {
            this.message.setType(MessageType.Error);//类型  错误 不通过
            this.message.setDescription("validateError:" + "验证码错误，请重新输入");//消息内容按固定格式返回
            return SUCCESS;
        }


        if (CaptchaModel.selectByIdAndCode(StateValues.getCaptchaKey(), verifyCode) == null) {
            this.message.setType(MessageType.Error);//类型  错误 不通过

            this.message.setDescription("validateError:" + "验证码错误，请重新输入");
            return SUCCESS;
        }

        CaptchaModel.delete(StateValues.getCaptchaKey());

        if (!CharacterFilter.isVaildCustomerName(p2pCustomer.getUserName()))//正则验证用户名的格式
        {
            this.message.setType(MessageType.Error);//类型  错误 不通过
            this.message.setDescription("userError:" + "4-20位字符（限字母、数字的组合）");
            return SUCCESS;
        }

        if (P2pCustomerModel.selectByUserName(p2pCustomer.getUserName()) != null)//验证用户名时候存在
        {
            this.message.setType(MessageType.Error);
            this.message.setDescription("该账号已注册，请更换账号后再试一次");
            return SUCCESS;
        }

        if (!CharacterFilter.isVaildPwd(p2pCustomer.getPassword()))//验证用户的密码的格式是否正确
        {
            this.message.setType(MessageType.Error);
            this.message.setDescription("pwdError:" + "6-20位字符，可使用字母、数字或符号的组合，不建议使用纯数字，纯字母，纯符号");
            return SUCCESS;
        }
        
        String vfCode = SmsModel.getCaptchaFromMenCache("captcha", telephone);
		if(StringHelper.isNullOrEmpty(vfCode)){
			this.message.setType(MessageType.Error);
        	this.message.setDescription("smsCaptchaError:" + "请重新获取手机验证码（可能已过期）");
			return SUCCESS;
		}
		if(!vfCode.equals(this.smsCaptcha)){
			this.message.setType(MessageType.Error);
        	this.message.setDescription("smsCaptchaError:" + "手机验证码不正确");
			return SUCCESS;
		}
 

        String key = EncodeHelper.initKey(p2pCustomer.getUserName());//根据用户的姓名获得一个初始化的加密支付key
        //根据上面的key 在可用户名 加密配置文件的编码字符串 再次进行加密
        String pwd = EncodeHelper.encryptPWD(p2pCustomer.getUserName(), EncodeHelper.decryptBASE64(p2pCustomer.getPassword()), key);
        p2pCustomer.setStatus((byte) 1);
        p2pCustomer.setPassword(pwd);//这回 再吧 加密后的密码放到用户对象中去吧
        p2pCustomer.setSecretKey(key);//别忘了把 这个秘钥 也带上
        p2pCustomer.setCellphone(this.telephone);
        p2pCustomer.setLoginFrom((byte)1);
        
        String openId = StateValues.getWXOpenId();
		if(!StringHelper.isNullOrEmpty(openId)){
			if (P2pCustomerModel.getP2pCustomerByWeixin(openId) != null)//验证用户名时候存在
			{
				this.message.setType(MessageType.Error);
				this.message.setDescription("weixinError:" +"当前微信号已注册过，不能重复注册，试着登录吧！");
				return SUCCESS;
			}
			p2pCustomer.setWeixin(openId);
		}
        
        System.out.println(openId);
       /* if(!StringHelper.isNullOrEmpty(this.code)){   
           //use code have openID save weixinNo
         String urlstr = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx9d93a55d91f39b14&secret=13dfa2e9dde5fa8d7bb7ebdc322b62d6&code=" + this.code + "&grant_type=authorization_code";
    	    JSONObject json;
    	    try {
    	        json = JSONObject.fromObject(HttpHelper.doGet(urlstr));
    	        String  weixin = json.getString("openid");
    	        //use openId select DB
    	       // P2pCustomer openIdCustomer=P2pCustomerModel.getP2pCustomerByWeixin(weixin);
    	        if (P2pCustomerModel.getP2pCustomerByWeixin(weixin) != null)//验证用户名时候存在
    	        {
    	            this.message.setType(MessageType.Error);
    	            this.message.setDescription("weixinError:" +"当前微信号已注册过，不能重复注册，试着登录吧！");
    	            return SUCCESS;
    	        }else{
    	        	//no openId add openId(weixin)
    	        	p2pCustomer.setWeixin(weixin);
    	        }
    	    } catch (Exception e) {
    	        return ERROR;
    	    }
        }*/
    	int id = P2pCustomerModel.add(p2pCustomer); //然后把这些信息写入数据库  
        if (id <= 0)    //写入失败 提示 Error
        {
            this.message.setType(MessageType.Error);
            this.message.setDescription("Error:" + "注册失败请稍后再试");
            return SUCCESS;
        }
        
        String subject= "新的客户";
    	String content = "有新的52touzi网站客户注册（微信注册）,用户账号："+p2pCustomer.getUserName()+" 新用户的手机号码为"+p2pCustomer.getCellphone();
        String customerServiceNo =PropertyHelper.getParamProperty("customer.service.no");
        if(!StringHelper.isNullOrEmpty(customerServiceNo)){
        	LetterModel.addReminds(subject, content, Integer.parseInt(customerServiceNo));
        }
        
        if(!StringHelper.isNullOrEmpty(inviterNo)){
        	Activities  activities = null;
        	P2pCustomer  customer= P2pCustomerModel.getInfoByCellphone(inviterNo);
        	if(customer!=null){
        		if(StringHelper.isNullOrEmpty(activityId)){
        			//根据活动的类型和活动最新发布时间
        			DicData dic = DicDataModel.getCodeByTypeNoAndName(53,"普通邀请活动");
					
        			activities = ActivitiesModel.getInfoByActivitytype(1);
        			activityId =activities.getId()+"";
        		}else{
        			activities = ActivitiesModel.getInfo(Integer.parseInt(activityId));
        			activityId =activities.getId()+"";
        		}
        		//插入我的邀请表
        		ActivityCustomerInvitation invitation = new ActivityCustomerInvitation();
        		//invitation.setRewardsMoney(ActivitiesInfo.ACTIVITY_REWARDS_MONEY);
        		invitation.setP2pCustomerNo(customer.getId());
        		invitation.setInvitedNo(id);
        		invitation.setRegisterTime(DateUtil.getNowTimestamp());
        		invitation.setInviteTime(DateUtil.getNowTimestamp());
        		invitation.setActivityNo(Integer.parseInt(activityId));
        		invitation.setStatus(ActivitiesInfo.ACTIVITY_STATUS_DISABLE);
        		invitation.setRequestNo(SnModel.getSn(SnEnum.SN_TRANSFER_REQUEST_NO));//请求流水号
    			ActivityCustomerTask activityCustomerTask = ActivityCustomerTaskModel.getInfoByCondition(customer.getId(),Integer.parseInt(activityId));
    			//插入我的活动详情
    			ActivityCustomerDetail activityCustomerDetail = new ActivityCustomerDetail();
    			if(activityCustomerTask==null){
    				ActivityCustomerTask activityCustTask = new ActivityCustomerTask();
    				activityCustTask.setP2pCustomerNo(customer.getId());
    				activityCustTask.setActivityNo(Integer.parseInt(activityId));
    				int activityCustomerTaskId = ActivityCustomerTaskModel.add(activityCustTask);
    				activityCustomerDetail.setActivityCustomerTaskNo(activityCustomerTaskId);//我的活动外键ID
    			}else{
    				activityCustomerDetail.setActivityCustomerTaskNo(activityCustomerTask.getId());//我的活动外键ID
    			}
    			activityCustomerDetail.setTaskStatus((byte) 0);
    			activityCustomerDetail.setInvitedNo(id);//新用户注册的id
    			/**
    			 * 根据活动id查询活动条件信息 ，获得活动的奖励单号和奖励方式
    			 */
    			List<ActivityAwardRelation> list = new ArrayList<ActivityAwardRelation>();
					list = ActivityAwardRelationModel.getInfoByActId(Integer.parseInt(activityId));//活动条件
    				activityCustomerDetail.setActivityAwardId(list.get(0).getId());
    				int actCustomerId = ActivityCustomerDetailModel.add(activityCustomerDetail);
    				int actRewardType = list.get(0).getActivityRewardType();
    				invitation.setActivityRewardType(actRewardType);//奖励相关单号（现金ID，礼品ID，优惠券ID）
    				int relatedNo =0;
    				boolean isOrdinaryInvite = true;
    				if(actRewardType==1){
    					//插入我的体验金
    					relatedNo = this.addCustomerExperienceGold(customer,activities,actCustomerId,isOrdinaryInvite);
    					int experienceGoldNo = ActivityCustomerExperienceGoldModel.getInfo(relatedNo).getExperienceGoldNo();
    					double expMoney = ActivityExperienceGoldModel.getInfo(experienceGoldNo).getGoldMoney();
    					double rate = 0;
    					int cid = ActivityAwardRelationModel.getInfoByRelatedNo(1,ActivityExperienceGoldModel.getInfo(experienceGoldNo).getId()).getConditionId();
						
    					ActivityCondition activityCondition = ActivityConditionModel.getInfo(cid);
    					if(activityCondition!=null){
    						if(activityCondition.getProductType()==5){
    							rate = P2pProductModel.getP2pByProductNo(activityCondition.getProductName()).getIncome();
    						}
    					}
    					invitation.setRewardsMoney((expMoney)*(rate/100)*(ActivityExperienceGoldModel.getInfo(experienceGoldNo).getDay())/365);
    				}else if(actRewardType==2){
    					//插入我的现金奖励
    	    			relatedNo = this.addCustomerCashBonus(customer,activities,actCustomerId,isOrdinaryInvite);
    	    			int cashBonusNo = (int) ActivityCustomerCashBonusModel.getInfo(relatedNo).getCashBonusNo();
    	    			invitation.setRewardsMoney(ActivityCashBonusModel.getInfo(cashBonusNo).getMoney());
    			}
				invitation.setActivityRewardType(actRewardType);//奖励方式（1.现金，2.礼品，3.优惠券）
				invitation.setRelatedNo(relatedNo);//奖励相关单号（现金ID，礼品ID，优惠券ID）
        		ActivityCustomerInvitationModel.add(invitation);
        	}
        	
        }
        
        
        PaymentAccountInformation paymentAccountInfo=new PaymentAccountInformation();
		paymentAccountInfo.setCustomerNo(id);
		String dateStr = "";
		Date date = new Date();   
	    DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	    dateStr = sdf.format(date); 
	    Timestamp ts = new Timestamp(System.currentTimeMillis());   
        try {   
            ts = Timestamp.valueOf(dateStr);   
			paymentAccountInfo.setAccrualTimePeriod(ts);
		} catch (Exception e) {
			e.printStackTrace();
		}
        paymentAccountInfo.setAuthenticationTel(1);
        paymentAccountInfo.setAccountType((byte)1);
		PaymentAccountInformationModel.add(paymentAccountInfo);

		P2pCustomerModel.SetLoginInfo(P2pCustomerModel.getInfo(id),true);
		
		this.message.setType(MessageType.Info);
		Date lastLoginTime = null;
		if(p2pCustomer.getCurrentLoginTime()!=null){
			lastLoginTime = p2pCustomer.getCurrentLoginTime();
		}
		P2pCustomerModel.updateLastLoginTime(p2pCustomer.getId(),new Timestamp(lastLoginTime.getTime()));
        return SUCCESS;
       
    }
    /**
     * 添加我的体验金
     * @author guojia 
     */
    public static int addCustomerExperienceGold(P2pCustomer  customer,Activities  activities,int actCustomerId,boolean isOrdinaryInvite){
   	 int resultno =0;
   	 if(isOrdinaryInvite){
   		 ActivityExperienceGold actExperienceGoldModel = 
       			 ActivityExperienceGoldModel.getActExperienceGoldModelByActId(activities.getId()).get(0);//根据活动id查询体验金奖励(普通活动时需要遍历)
       	 ActivityCustomerExperienceGold actCutExpGold = new ActivityCustomerExperienceGold();
   			actCutExpGold.setP2pCustomerNo(customer.getId());
   			actCutExpGold.setGainTime(DateUtil.getNowTimestamp());
   			actCutExpGold.setStartTime(activities.getStartTime());
   			actCutExpGold.setEndTime(activities.getEndTime());
   			actCutExpGold.setStatus((byte) 0);
   			actCutExpGold.setExperienceGoldNo(actExperienceGoldModel.getId());//体验金奖励外键
   			actCutExpGold.setMyActivityNo(actCustomerId);//我的活动详情外键
   			resultno = ActivityCustomerExperienceGoldModel.add(actCutExpGold);
   	 }else {
   		 List<ActivityExperienceGold> actExperienceGoldModel = 
       			 ActivityExperienceGoldModel.getActExperienceGoldModelByActId(activities.getId());//根据活动id查询体验金奖励(普通活动时需要遍历)
   		 for(int i=0;i<actExperienceGoldModel.size();i++){
   			ActivityCustomerExperienceGold actCutExpGold = new ActivityCustomerExperienceGold();
    			actCutExpGold.setP2pCustomerNo(customer.getId());
    			actCutExpGold.setGainTime(DateUtil.getNowTimestamp());
    			actCutExpGold.setStartTime(activities.getStartTime());
    			actCutExpGold.setEndTime(activities.getEndTime());
    			actCutExpGold.setStatus((byte) 0);
    			actCutExpGold.setExperienceGoldNo(actExperienceGoldModel.get(i).getId());//体验金奖励外键
    			actCutExpGold.setMyActivityNo(actCustomerId);//我的活动详情外键
    			ActivityCustomerExperienceGoldModel.add(actCutExpGold);
   		 }
   	 }
   	 return resultno;
   	
    }
    /**
     * 添加我的现金奖励
     * @author guojia 
     */
    public static int addCustomerCashBonus(P2pCustomer  customer,Activities  activities,int actCustomerId,boolean isOrdinaryInvite){
   	int resultno =0;
   	if(isOrdinaryInvite){
   		ActivityCashBonus activityCashBonus = 
					ActivityCashBonusModel.getActivityCashBonusByActId(activities.getId()).get(0);
			int actCashBonusId = activityCashBonus.getId();
			ActivityCustomerCashBonus activityCustomerCashBonus = new ActivityCustomerCashBonus();
			activityCustomerCashBonus.setP2pCustomerNo(customer.getId());
			activityCustomerCashBonus.setCashBonusNo(actCashBonusId);//现金奖励外键
			activityCustomerCashBonus.setMyActivityNo(actCustomerId);//我的活动详情外键
			activityCustomerCashBonus.setEditTime(DateUtil.getNowTimestamp());
			activityCustomerCashBonus.setInTime(DateUtil.getNowTimestamp());
			activityCustomerCashBonus.setEditUserNo(customer.getId());
			activityCustomerCashBonus.setAcquisitionTime(DateUtil.getNowTimestamp());
			activityCustomerCashBonus.setStatus((byte) 0);
			resultno = ActivityCustomerCashBonusModel.add(activityCustomerCashBonus); 
   	}else{
   		List<ActivityCashBonus> activityCashBonus = 
					ActivityCashBonusModel.getActivityCashBonusByActId(activities.getId());//根据活动id查询现金奖励(普通活动时需要遍历)
   		for(int i=0;i<activityCashBonus.size();i++){
   			int actCashBonusId = activityCashBonus.get(i).getId();
   			ActivityCustomerCashBonus activityCustomerCashBonus = new ActivityCustomerCashBonus();
   			activityCustomerCashBonus.setP2pCustomerNo(customer.getId());
   			activityCustomerCashBonus.setCashBonusNo(actCashBonusId);//现金奖励外键
   			activityCustomerCashBonus.setMyActivityNo(actCustomerId);//我的活动详情外键
   			activityCustomerCashBonus.setEditTime(DateUtil.getNowTimestamp());
   			activityCustomerCashBonus.setInTime(DateUtil.getNowTimestamp());
   			activityCustomerCashBonus.setEditUserNo(customer.getId());
   			activityCustomerCashBonus.setAcquisitionTime(DateUtil.getNowTimestamp());
   			activityCustomerCashBonus.setStatus((byte) 0);
   			ActivityCustomerCashBonusModel.add(activityCustomerCashBonus); 
   		}
   	}
   	return resultno;
    }

}
