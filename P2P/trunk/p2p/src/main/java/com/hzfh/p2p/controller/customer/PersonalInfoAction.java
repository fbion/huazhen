package com.hzfh.p2p.controller.customer;

import java.util.List;

import com.hzfh.api.baseInfo.model.DicData;
import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.api.customer.model.PaymentCustomerBank;
import com.hzfh.api.employee.model.Company;
import com.hzfh.api.employee.model.Department;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.baseInfo.CompanyModel;
import com.hzfh.p2p.model.baseInfo.DepartmentModel;
import com.hzfh.p2p.model.baseInfo.DicDataModel;
import com.hzfh.p2p.model.baseInfo.EmployeeModel;
import com.hzfh.p2p.model.common.AuthenticationModel;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.helper.UrlHelper;
import com.hzfh.p2p.model.customer.P2pCustomerModel;
import com.hzfh.p2p.model.customer.PaymentAccountInformationModel;
import com.hzfh.p2p.model.customer.PaymentCustomerBankModel;
import com.hzframework.helper.StringHelper;

/**
 * Created by paul on 15-2-5.
 */
public class PersonalInfoAction extends CommonAction{
 
	private P2pCustomer p2pCustomer;
	private String returnUrl;
	private PaymentAccountInformation paymentAccountInformation;
	private PaymentCustomerBank paymentCustomerBank;
	private Employee employee;
	private Department department;
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Employee getEmployee() {
		return employee;
	}
	private String sex;
	private String marry;
	private P2pCustomer loginP2pCustomer;//显示用户详情
	
    public P2pCustomer getLoginP2pCustomer() {
		return loginP2pCustomer;
	}
	public String getSex() {
		return sex;
	}
	public String getMarry() {
		return marry;
	}
	public String getReturnUrl() {
		return returnUrl;
	}
	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}
	public P2pCustomer getP2pCustomer() {
		return p2pCustomer;
	}
	public void setP2pCustomer(P2pCustomer p2pCustomer) {
		this.p2pCustomer = p2pCustomer;
	}
	public PaymentAccountInformation getPaymentAccountInformation() {
		return paymentAccountInformation;
	}
	public PaymentCustomerBank getPaymentCustomerBank() {
		return paymentCustomerBank;
	}
	/*private String userName;
	private String realName;
	private String cardNo;
	private String cellphone;
	private String email;
	private String bankCard;*/
	@Override
	public String execute(){
		
		
        this.setPageAlias(PageAlias.personalInfo);
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        int customerNo = AuthenticationModel.getCustomerId();
        this.paymentAccountInformation = PaymentAccountInformationModel.getInfoByCustomerNo(customerNo);
        if(paymentAccountInformation!=null){
        	this.p2pCustomer  =  P2pCustomerModel.getInfo(customerNo);
        	if(this.p2pCustomer.getUserName().length() >= 36){
        		p2pCustomer.setUserName(p2pCustomer.getCellphone());
        	}
        	if(paymentAccountInformation.getAuthenticationIdcard()!=0&&(!StringHelper.isNullOrEmpty(p2pCustomer.getCardNumber()))){
        		p2pCustomer.setCardNumber("**************"+p2pCustomer.getCardNumber().substring(14));
        	}
        	if(paymentAccountInformation.getAuthenticationTel()!=0&&(!StringHelper.isNullOrEmpty(p2pCustomer.getCellphone()))){
        		p2pCustomer.setCellphone(p2pCustomer.getCellphone().substring(0,3)+"****"+p2pCustomer.getCellphone().substring(7));
        	}
        	if(paymentAccountInformation.getAuthenticationEmail()!=0&&(!StringHelper.isNullOrEmpty(p2pCustomer.getEmail()))){
        		p2pCustomer.setEmail(p2pCustomer.getEmail().substring(0,1)+"***"+p2pCustomer.getEmail().substring(p2pCustomer.getEmail().indexOf("@")-1));
        	}
        }
        int status = 1;
        List<PaymentCustomerBank>  paymentCustomerBanks = PaymentCustomerBankModel.getBankByCustomerNoAndStatus(customerNo, status);
        if(paymentCustomerBanks!=null&&paymentCustomerBanks.size()!=0){
    	   this.paymentCustomerBank = paymentCustomerBanks.get(0);
        }
        
        this.loginP2pCustomer = P2pCustomerModel.getInfo(customerNo);
        employee = EmployeeModel.getEmpByUserId(p2pCustomer.getEmpNo());
        List<DicData> DicDatas = DicDataModel.getDicDataListByType(1);
        for (DicData dicData : DicDatas) {
        	if(dicData.getCode()==loginP2pCustomer.getSex()){
        		this.sex = dicData.getValue();
        	}
        	if(employee!=null&&dicData.getCode()==employee.getSex()){
        		employee.setSexStr(dicData.getValue());
        	}
		}
        DicDatas = DicDataModel.getDicDataListByType(9);
        for (DicData dicData : DicDatas) {
        	if(dicData.getCode()==loginP2pCustomer.getMarry()){
        		this.marry = dicData.getValue();
        	}
		}
        if(employee!=null){
        	String path = employee.getPortraitPath();
        	if(!StringHelper.isNullOrEmpty(path)){
        		path = UrlHelper.bulidWebUploadPath(path);
        		employee.setPortraitPath(path);
        	}
        	department = DepartmentModel.getInfo(employee.getDeptNo());
        }
        return SUCCESS;
	}
	
}
