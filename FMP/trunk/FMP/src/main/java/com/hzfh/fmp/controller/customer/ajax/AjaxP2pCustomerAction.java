package com.hzfh.fmp.controller.customer.ajax;

import com.hzfh.api.customer.model.CustomerPersonal;
import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.customer.model.query.P2pCustomerCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.customer.CustomerPersonalModel;
import com.hzfh.fmp.model.customer.P2pCustomerModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class AjaxP2pCustomerAction extends JqGridBaseAction<P2pCustomer> {
    private P2pCustomer p2pCustomer;
	public P2pCustomer getP2pCustomer() {
		return p2pCustomer;
	}
	public void setP2pCustomer(P2pCustomer p2pCustomer) {
		this.p2pCustomer = p2pCustomer;
	}
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
	private String registerTime;
	public String getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}
	private String lastLoginTime;
	public String getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(String lastLoginTime) {
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
	private String deptNo;
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	private String empNo;
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	private String provinceNo;
	public String getProvinceNo() {
		return provinceNo;
	}
	public void setProvinceNo(String provinceNo) {
		this.provinceNo = provinceNo;
	}
	private String cityNo;
	public String getCityNo() {
		return cityNo;
	}
	public void setCityNo(String cityNo) {
		this.cityNo = cityNo;
	}
	private String districtNo;
	public String getDistrictNo() {
		return districtNo;
	}
	public void setDistrictNo(String districtNo) {
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
	private String customerNo;
	public String getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	private String cardType;
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
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
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String p2pCustomerName;
	public String getP2pCustomerName() {
		return p2pCustomerName;
	}
	public void setP2pCustomerName(String p2pCustomerName) {
		this.p2pCustomerName = p2pCustomerName;
	}
	private String byStatus;
	private String byEmpNo;
	private String byDeptNo;
	public String getByStatus() {
		return byStatus;
	}
	public void setByStatus(String byStatus) {
		this.byStatus = byStatus;
	}
	public String getByEmpNo() {
		return byEmpNo;
	}
	public void setByEmpNo(String byEmpNo) {
		this.byEmpNo = byEmpNo;
	}
	public String getByDeptNo() {
		return byDeptNo;
	}
	public void setByDeptNo(String byDeptNo) {
		this.byDeptNo = byDeptNo;
	}
	public String showCustomerList;
	public String getShowCustomerList() {
		return showCustomerList;
	}
	public void setShowCustomerList(String showCustomerList) {
		this.showCustomerList = showCustomerList;
	}
	@Override
    public String execute() throws Exception{

    	P2pCustomerCondition p2pCustomerCondition = new P2pCustomerCondition();
        p2pCustomerCondition.setPageSize(this.getPageSize());
        p2pCustomerCondition.setPageIndex(this.getPageIndex());
        List<Integer> workmate = UserHelper.getUserCache().getWorkMate();

        if(StringHelper.isNullOrEmpty(this.showCustomerList) || ((this.showCustomerList).equals("none"))){
        	if (workmate!=null) {
                workmate.add(UserHelper.getUserCache().getUserId());
                String workMateString = StringHelper.listToString(workmate);
                p2pCustomerCondition.setWorkMateString(workMateString);
                p2pCustomerCondition.setWorkMateString(workMateString);
            }else{
                p2pCustomerCondition.setWorkMateString(String.valueOf(UserHelper.getUserCache().getUserId()));
            }
		}
        if (!StringHelper.isNullOrEmpty(this.p2pCustomerName)) {
        	p2pCustomerCondition.setP2pCustomerName(this.p2pCustomerName);
        }
        if(!StringHelper.isNullOrEmpty(this.byStatus)) {
            p2pCustomerCondition.setByStatus(Integer.parseInt(this.byStatus));
        }
        if(!StringHelper.isNullOrEmpty(this.byEmpNo)){
        	p2pCustomerCondition.setByEmpNo(Integer.parseInt(byEmpNo));
        }
        if(!StringHelper.isNullOrEmpty(this.byDeptNo)){
        	p2pCustomerCondition.setByDeptNo(Integer.parseInt(this.byDeptNo));
        }

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        p2pCustomerCondition.setSortItemList(sortItemList);


        PagedList<P2pCustomer> p2pCustomerPagedList= P2pCustomerModel.getPagingList(p2pCustomerCondition);
        for(P2pCustomer p2pCustomer:p2pCustomerPagedList.getResultList()){
            if(p2pCustomer.getCustomerNo()!=0){
                p2pCustomer.setPassword(CustomerPersonalModel.getInfo(p2pCustomer.getCustomerNo()).getName());
            }else{
                p2pCustomer.setPassword("");
            }
        }
        this.setResultList(p2pCustomerPagedList.getResultList());
        this.setPageCount(p2pCustomerPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(p2pCustomerPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(p2pCustomerPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
        P2pCustomer p2pCustomer = new P2pCustomer();
        
		p2pCustomer.setUserName(this.userName);
		p2pCustomer.setPassword(this.password);
		p2pCustomer.setRegisterTime(Timestamp.valueOf(this.registerTime));
		p2pCustomer.setLastLoginTime(Timestamp.valueOf(this.lastLoginTime));
		p2pCustomer.setEmail(this.email);
		p2pCustomer.setCellphone(this.cellphone);
		p2pCustomer.setQq(this.qq);
		p2pCustomer.setWeixin(this.weixin);
		p2pCustomer.setWeibo(this.weibo);
		p2pCustomer.setPhone(this.phone);
		p2pCustomer.setThirdPartyUser(this.thirdPartyUser);
		p2pCustomer.setCardUrl(this.cardUrl);
		p2pCustomer.setRealName(this.realName);
		p2pCustomer.setDeptNo(Integer.valueOf(this.deptNo));
		p2pCustomer.setEmpNo(Integer.valueOf(this.empNo));
		p2pCustomer.setProvinceNo(Integer.valueOf(this.provinceNo));
		p2pCustomer.setCityNo(Integer.valueOf(this.cityNo));
		p2pCustomer.setDistrictNo(Integer.valueOf(this.districtNo));
		p2pCustomer.setAddress(this.address);
		p2pCustomer.setSecretKey(this.secretKey);
		p2pCustomer.setCustomerNo(Integer.valueOf(this.customerNo));
		p2pCustomer.setCardType(Byte.valueOf(this.cardType));
		p2pCustomer.setCardNumber(this.cardNumber);
		p2pCustomer.setAvatar(this.avatar);
		p2pCustomer.setStatus(Byte.valueOf(this.status));
		p2pCustomer.setEditUserNo(UserHelper.getEditUserNo());

        if (this.getOper().equalsIgnoreCase("add")) {
            p2pCustomer.setInUserNo(UserHelper.getEditUserNo());
            if (P2pCustomerModel.add(p2pCustomer )<=0){
                this.setErrCode("add failed");
                this.setErrDesc("add failed");
            }
        }
        else
        {
            if (this.getId().isEmpty()) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
            }
            else{
                if (this.getOper().equalsIgnoreCase("edit")) {
                    p2pCustomer.setId(Integer.parseInt(this.getId()));
                    if (P2pCustomerModel.update(p2pCustomer) <= 0){
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                    }
                }
            }
        }

        return SUCCESS;
    }

    public String getP2pCustomerById(){
    	if(StringHelper.isNullOrEmpty(this.getId())){
    		this.setErrCode("no id");
    	}
    	this.p2pCustomer = P2pCustomerModel.getInfo(Integer.valueOf(this.getId()));
    	if(p2pCustomer==null){
    		this.setErrCode("p2pCustomer id null!");
    	}else{
    		this.userName = p2pCustomer.getUserName();
    		this.realName = p2pCustomer.getRealName();
    	}
    	return SUCCESS;
    }

    public String checkUserName() {
        P2pCustomer p2pCustomerForCheckUserName = P2pCustomerModel.selectByUserName(userName.trim());
        if (p2pCustomerForCheckUserName != null) {
        	this.setErrCode("failed");
            this.setErrDesc("该用户名已注册，请更换其他用户名");   
        }
        return SUCCESS; 
    }
}
