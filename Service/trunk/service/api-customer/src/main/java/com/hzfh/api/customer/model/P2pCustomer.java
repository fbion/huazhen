package com.hzfh.api.customer.model;
import com.hzframework.contract.BaseEntity;
import java.io.Serializable;
import java.util.Date;

/*******************************************************************************
 * Copyright 2015 HZFH. All rights reserved.
 * Author: GuoZhenYu
 * Create Date: 2015/3/5
 * Description:
 * <p/>
 * Revision History:
 * Date         Author               Description
 ******************************************************************************/


public class P2pCustomer extends BaseEntity implements Serializable {
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private Date registerTime;

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    private Date lastLoginTime;
    private Date currentLoginTime;

    public Date getCurrentLoginTime() {
        return currentLoginTime;
    }

    public void setCurrentLoginTime(Date currentLoginTime) {
        this.currentLoginTime = currentLoginTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String cellphone;

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    private String qq;

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    private String weixin;

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    private String weibo;

    public String getWeibo() {
        return weibo;
    }

    public void setWeibo(String weibo) {
        this.weibo = weibo;
    }

    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String thirdPartyUser;

    public String getThirdPartyUser() {
        return thirdPartyUser;
    }

    public void setThirdPartyUser(String thirdPartyUser) {
        this.thirdPartyUser = thirdPartyUser;
    }

    private String cardUrl;

    public String getCardUrl() {
        return cardUrl;
    }

    public void setCardUrl(String cardUrl) {
        this.cardUrl = cardUrl;
    }

    private String realName;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    private int deptNo;

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    private int empNo;

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    private int provinceNo;

    public int getProvinceNo() {
        return provinceNo;
    }

    public void setProvinceNo(int provinceNo) {
        this.provinceNo = provinceNo;
    }

    private int cityNo;

    public int getCityNo() {
        return cityNo;
    }

    public void setCityNo(int cityNo) {
        this.cityNo = cityNo;
    }

    private int districtNo;

    public int getDistrictNo() {
        return districtNo;
    }

    public void setDistrictNo(int districtNo) {
        this.districtNo = districtNo;
    }

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String secretKey;

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    private int customerNo;

    public int getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(int customerNo) {
        this.customerNo = customerNo;
    }

    private byte cardType;

    public byte getCardType() {
        return cardType;
    }

    public void setCardType(byte cardType) {
        this.cardType = cardType;
    }

    private String cardNumber;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    private String avatar;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    private byte status;

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private int customerType;

    public int getCustomerType() {
        return customerType;
    }

    public void setCustomerType(int customerType) {
        this.customerType = customerType;
    }

    private byte sex;
    private byte marry;
    private String companyName;
    private String companyAddress;

    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }

    public byte getMarry() {
        return marry;
    }

    public void setMarry(byte marry) {
        this.marry = marry;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    private String cardPath;
    private String portraitPath;
    private byte pathStatus;

    public String getCardPath() {
        return cardPath;
    }

    public void setCardPath(String cardPath) {
        this.cardPath = cardPath;
    }

    public String getPortraitPath() {
        return portraitPath;
    }

    public void setPortraitPath(String portraitPath) {
        this.portraitPath = portraitPath;
    }

    public byte getPathStatus() {
        return pathStatus;
    }

    public void setPathStatus(byte pathStatus) {
        this.pathStatus = pathStatus;
    }

    private byte loginFrom;

    public byte getLoginFrom() {
        return loginFrom;
    }

    public void setLoginFrom(byte loginFrom) {
        this.loginFrom = loginFrom;
    }
}