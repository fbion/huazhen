package com.hzfh.p2p.model.common.helper;

import com.hzfh.p2p.model.common.properties.RegexHelper;
import com.hzframework.helper.StringHelper;

/**
 * Created by paul on 15-3-12.
 */
public class CharacterFilter {//本类别进行验 传入字符串的各种正则的正确

    public static boolean isEmailAddress(String email)//邮箱验证
    {
        if (StringHelper.isNullOrEmpty(email))
        {
            return false;
        }
        else
        {
            return email.matches(RegexHelper.REGEX_EMAIL);
        }
    }

    /**
     用户名字符验证

     @param customerName 用户名
     @return
     */
    public static boolean isVaildCustomerName(String customerName)//用户名验证
    {
        if (StringHelper.isNullOrEmpty(customerName))
        {
            return false;
        }
        else
        {
            return customerName.matches(RegexHelper.REGEX_CUSTOMER_NAME);
        }
    }

    public static boolean isVaildPwd(String pwd)//密码验证
    {
        if (StringHelper.isNullOrEmpty(pwd))
        {
            return false;
        }
        else
        {
            return pwd.matches(RegexHelper.REGEX_PWD);
        }
    }

    public static boolean isVaildVerifyCode(String verifyCode)//注册验证码的验证
    {
        if (StringHelper.isNullOrEmpty(verifyCode))
        {
            return false;
        }
        else
        {
            return verifyCode.matches(RegexHelper.REGEX_VERIFY_CODE);
        }
    }
    public static boolean isVaildNumber(String number)//注册验证码的验证
    {
    	if (StringHelper.isNullOrEmpty(number))
    	{
    		return false;
    	}
    	else
    	{
    		return number.matches(RegexHelper.REGEX_NUMBER);
    	}
    }
    public static boolean isVaildUserName(String userName)//注册验证码的验证
    {
    	if (StringHelper.isNullOrEmpty(userName))
    	{
    		return false;
    	}
    	else
    	{
    		return userName.matches(RegexHelper.REGEX_USER_NAME);
    	}
    }

    /**
     * 正则验证手机号码
     * @param cellphone
     * @return
     */
	public static boolean isVaildCellphone(String cellphone) {
		if (StringHelper.isNullOrEmpty(cellphone))
        {
            return false;
        }
        else
        {
            return cellphone.matches(RegexHelper.REGEX_CELLPHONE);
        }
	}

	public static boolean isVaildCardNumber(String cardNumber) {
		// TODO Auto-generated method stub
		return true;
	}

	public static boolean isVaildRealName(String realName) {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * 验证短信验证码
	 * @param smsCaptcha
	 * @return
	 */
	public static boolean isVaildSmsCaptcha(String smsCaptcha) {
		if (StringHelper.isNullOrEmpty(smsCaptcha))
        {
            return false;
        }
        else
        {
            return smsCaptcha.matches(RegexHelper.REGEX_SMS_CAPTCHA);
        }
	}

	/**
	 * 登录用户名、邮箱、手机号验证
	 * @param verifyCode
	 * @return
	 */
	public static boolean isVaildLoginName(String verifyCode){
		if (StringHelper.isNullOrEmpty(verifyCode)){
            return false;
        }
		if(verifyCode.matches(RegexHelper.REGEX_CUSTOMER_NAME)){
        	return true;
        }
		if(verifyCode.matches(RegexHelper.REGEX_EMAIL)){
			return true;
		}
		if(verifyCode.matches(RegexHelper.REGEX_CELLPHONE)){
			return true;
		}
		return false;
	}
	
	public static boolean isVaildPicPath(String verifyCode){
		if(verifyCode.matches(RegexHelper.REGEX_PIC)){
			return true;
		}
		return false;
	}
	/**
	 * 验证预约用户姓名
	 * liyh
	 * @param verifyCode
	 * @return
	 * 下午3:53:08
	 */
	public static boolean isVaildCallName(String verifyCode){
		if(verifyCode.matches(RegexHelper.SUBSCRIBE_CALLNAME)){
			return true;
		}
		return false;
	}
	
}
