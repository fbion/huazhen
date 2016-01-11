package com.hzfh.fmp.controller.customer.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.baseInfo.model.helper.SnEnum;
import com.hzfh.api.customer.model.CustomerCompany;
import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.customer.model.query.CustomerCompanyCondition;
import com.hzfh.api.payment.model.common.PaymentData;
import com.hzfh.api.payment.model.request.gateway.EnterpriseRegisterReq;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.baseInfo.SnModel;
import com.hzfh.fmp.model.common.enumeration.StatusType;
import com.hzfh.fmp.model.common.helper.*;
import com.hzfh.fmp.model.customer.CustomerCompanyModel;
import com.hzfh.fmp.model.customer.P2pCustomerModel;
import com.hzfh.fmp.model.payment.GatewayModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AjaxCustomerCompanyAction extends
		JqGridBaseAction<CustomerCompany> {

	
	private String findTime;
	public String getFindTime() {
		return findTime;
	}
	public void setFindTime(String findTime) {
		this.findTime = findTime;
	}

	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private String telephone;

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private String field;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	private String contactName;

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	private String contactTelephone;

	public String getContactTelephone() {
		return contactTelephone;
	}

	public void setContactTelephone(String contactTelephone) {
		this.contactTelephone = contactTelephone;
	}

	private String contactCellphone1;

	public String getContactCellphone1() {
		return contactCellphone1;
	}

	public void setContactCellphone1(String contactCellphone1) {
		this.contactCellphone1 = contactCellphone1;
	}

	private String contactCellphone2;

	public String getContactCellphone2() {
		return contactCellphone2;
	}

	public void setContactCellphone2(String contactCellphone2) {
		this.contactCellphone2 = contactCellphone2;
	}

	private String relationLevel;

	public String getRelationLevel() {
		return relationLevel;
	}

	public void setRelationLevel(String relationLevel) {
		this.relationLevel = relationLevel;
	}

	private String riskHobby;

	public String getRiskHobby() {
		return riskHobby;
	}

	public void setRiskHobby(String riskHobby) {
		this.riskHobby = riskHobby;
	}

	private String sourceType;

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	private String agentNo;

	public String getAgentNo() {
		return agentNo;
	}

	public void setAgentNo(String agentNo) {
		this.agentNo = agentNo;
	}

	private String wealth;

	public String getWealth() {
		return wealth;
	}

	public void setWealth(String wealth) {
		this.wealth = wealth;
	}

	private String tradeTotal;

	public String getTradeTotal() {
		return tradeTotal;
	}

	public void setTradeTotal(String tradeTotal) {
		this.tradeTotal = tradeTotal;
	}

	private String byName;
	private String byRelationLevel;
	private String byRiskHobby;
	private String byCardType;
	private String byEmpNo;
	private String byFindTimeUp;
	private String byFindTimeDown;
    private String showAllList;
	
	public void setByFindTimeUp(String byFindTimeUp) {
		this.byFindTimeUp = byFindTimeUp;
	}

	public void setByFindTimeDown(String byFindTimeDown) {
		this.byFindTimeDown = byFindTimeDown;
	}

	public void setByEmpNo(String byEmpNo) {
		this.byEmpNo = byEmpNo;
	}

	public void setByName(String byName) {
		this.byName = byName;
	}

	public void setByRelationLevel(String byRelationLevel) {
		this.byRelationLevel = byRelationLevel;
	}

	public void setByRiskHobby(String byRiskHobby) {
		this.byRiskHobby = byRiskHobby;
	}

	public void setByCardType(String byCardType) {
		this.byCardType = byCardType;
	}

    public void setShowAllList(String showAllList) {
        this.showAllList = showAllList;
    }
    private String memberClassType;
    private String legal;
    private String legalIdcard;
    private String bankLicense;

    public void setMemberClassType(String memberClassType) {
		this.memberClassType = memberClassType;
	}
	public void setLegal(String legal) {
		this.legal = legal;
	}

	public void setLegalIdcard(String legalIdcard) {
		this.legalIdcard = legalIdcard;
	}

	public void setBankLicense(String bankLicense) {
		this.bankLicense = bankLicense;
	}

	private String inputUserName;
    public void setInputUserName(String inputUserName) {
		this.inputUserName = inputUserName;
	}
    private PaymentData paymentData;
	
    public PaymentData getPaymentData() {
		return paymentData;
	}
	public void setPaymentData(PaymentData paymentData) {
		this.paymentData = paymentData;
	}
    private String isSales;

    public String getIsSales() {
        return isSales;
    }

    public void setIsSales(String isSales) {
        this.isSales = isSales;
    }

    private CustomerCompanyCondition getCondition(){
    	CustomerCompanyCondition customerCompanyCondition = new CustomerCompanyCondition();
		customerCompanyCondition.setPageSize(this.getPageSize());
		customerCompanyCondition.setPageIndex(this.getPageIndex());
        if ("query".equals(this.showAllList)) {
            customerCompanyCondition.setWorkMateString(null);
        }else{
            List<Integer> workmate = UserHelper.getUserCache().getWorkMate();
            if (workmate != null) {
                workmate.add(UserHelper.getUserCache().getUserId());
                String workMateString = StringHelper.listToString(workmate);
                customerCompanyCondition.setWorkMateString(workMateString);
            } else {
                customerCompanyCondition.setWorkMateString(String.valueOf(UserHelper.getUserCache().getUserId()));
            }
        }
		if (!StringHelper.isNullOrEmpty(this.byFindTimeUp)) {
			customerCompanyCondition.setFindTimeUp(Timestamp.valueOf(this.byFindTimeUp));
		}
		if (!StringHelper.isNullOrEmpty(this.byFindTimeDown)) {
			customerCompanyCondition.setFindTimeDown(Timestamp.valueOf(this.byFindTimeDown));
		}
		
		
		if (!StringHelper.isNullOrEmpty(this.byName)) {
			customerCompanyCondition.setName(this.byName);
		}
		if (!StringHelper.isNullOrEmpty(this.byEmpNo)) {
			customerCompanyCondition.setEmpNo(Integer.valueOf(this.byEmpNo));
		}

		if (StringHelper.isNullOrEmpty(byRelationLevel)) {
			customerCompanyCondition.setRelationLevel(0);
		} else {
			customerCompanyCondition.setRelationLevel(Integer
					.parseInt(this.byRelationLevel));
		}
		if (StringHelper.isNullOrEmpty(byRiskHobby)) {
			customerCompanyCondition.setRiskHobby(0);
		} else {
			customerCompanyCondition.setRiskHobby(Integer
					.parseInt(this.byRiskHobby));
		}
		if (StringHelper.isNullOrEmpty(byCardType)) {
			customerCompanyCondition.setCardType(0);
		} else {
			customerCompanyCondition.setCardType(Integer
					.parseInt(this.byCardType));
		}
		if (!StringHelper.isNullOrEmpty(this.getIsTest())) {
			customerCompanyCondition.setIsTest(Byte.valueOf(this.getIsTest()));
		}else{
			customerCompanyCondition.setIsTest((byte) 0);
		}
        if(!StringHelper.isNullOrEmpty(this.isSales)){
            customerCompanyCondition.setIsSales(Integer.parseInt(isSales));
        }else{
            customerCompanyCondition.setIsSales((byte) -1);
        }
		List<SortItem> sortItemList = new ArrayList<SortItem>();
		SortItem sortItem = new SortItem();
		sortItem.setSortFeild(this.getSidx());
		sortItem.setSortType(this.getSortType());
		sortItemList.add(sortItem);
		customerCompanyCondition.setSortItemList(sortItemList);
		return customerCompanyCondition;
    }
    
	@Override
	public String execute() throws Exception {
		
		try {
			PagedList<CustomerCompany> customerCompanyPagedList = CustomerCompanyModel
					.getPagingList(this.getCondition());
			this.setResultList(customerCompanyPagedList.getResultList());
			this.setPageCount(customerCompanyPagedList.getPagingInfo()
					.getPageCount());
			this.setPageIndex(customerCompanyPagedList.getPagingInfo()
					.getPageIndex());
			this.setRecordCount(customerCompanyPagedList.getPagingInfo()
					.getTotalCount());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String edit() {
		CustomerCompany customerCompany = new CustomerCompany();
		
		if (!StringHelper.isNullOrEmpty(this.findTime)) {
			customerCompany.setFindTime(Timestamp.valueOf(this.findTime));
		}
		
		customerCompany.setCardNumber(this.cardNumber);
		customerCompany.setName(this.name);
		customerCompany.setAddress(this.address);
		customerCompany.setTelephone(this.telephone);
		customerCompany.setEmail(this.email);
		customerCompany.setField(this.field);
		customerCompany.setContactName(this.contactName);
		customerCompany.setContactTelephone(this.contactTelephone);
		customerCompany.setContactCellphone1(this.contactCellphone1);
		customerCompany.setContactCellphone2(this.contactCellphone2);
		customerCompany.setRelationLevel(Byte.parseByte(this.relationLevel));
		customerCompany.setRiskHobby(Byte.parseByte(this.riskHobby));
		customerCompany.setAgentNo(Integer.parseInt(this.agentNo));
		
		if (!StringHelper.isNullOrEmpty(this.wealth)) {
			customerCompany.setWealth(Integer.parseInt(this.wealth));
		} else {
			customerCompany.setWealth(0);
		}
		if (!StringHelper.isNullOrEmpty(this.tradeTotal)) {
			customerCompany.setTradeTotal(Long.parseLong(this.tradeTotal));
		} else {
			customerCompany.setTradeTotal(0);
		}
		if (!StringHelper.isNullOrEmpty(this.getIsTest())) {
			customerCompany.setIsTest(Byte.valueOf(this.getIsTest()));
		}else{
			customerCompany.setIsTest((byte) 0);
		}

		customerCompany.setEditComment(this.getEditComment());
		customerCompany.setEditUserNo(UserHelper.getEditUserNo());

		if (this.getOper().equalsIgnoreCase("add")) {
			customerCompany.setInUserNo(UserHelper.getEditUserNo());
			String r = CodeHelper.getCode("codeCus2", "FR");
			if (!StringHelper.isNullOrEmpty(r)) {
				customerCompany.setCode(r);
			}

			if (CustomerCompanyModel.add(customerCompany) <= 0) {
				this.setErrCode("add failed");
				this.setErrDesc("add failed");
			}
		} else {
			if (this.getId().isEmpty()) {
				this.setErrCode("NoID");
				this.setErrDesc("NoID");
			} else {
				if (this.getOper().equalsIgnoreCase("edit")) {
					customerCompany.setId(Integer.parseInt(this.getId()));
					if (CustomerCompanyModel.update(customerCompany) <= 0) {
						this.setErrCode("update failed");
						this.setErrDesc("update failed");
					}
				}
			}
		}

		return SUCCESS;
	}

	public String cardCheck() {
		String cardNumber = this.getCardNumber();
		int id = 0;
		if (!StringHelper.isNullOrEmpty(this.getId())) {
			id = Integer.parseInt(this.getId());
		}
		List<CustomerCompany> customerCompanyList = new ArrayList<CustomerCompany>();
		customerCompanyList = CustomerCompanyModel.cardCheck(cardNumber, id);
		if (customerCompanyList.size() > 0) {
			this.setErrCode("failed");
			this.setErrDesc("组织机构代码已经存在,请从新输入！");
		} else {
			this.setErrCode("ok");
			this.setErrDesc("组织机构代码不没重复！");
		}

		return SUCCESS;
	}

	private CustomerCompany customerCompany;
	private String customerId;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public CustomerCompany getCustomerCompany() {
		return customerCompany;
	}

	public void setCustomerCompany(CustomerCompany customerCompany) {
		this.customerCompany = customerCompany;
	}

	public String ajaxGetInfoById() {
		if (!StringHelper.isNullOrEmpty(this.customerId)) {
			this.customerCompany = CustomerCompanyModel.getInfo(Integer
					.parseInt(this.customerId));
		}

		return SUCCESS;
	}


	private String cardLicense;
	private String cardTax;

	public String getCardTax() {
		return cardTax;
	}

	public void setCardTax(String cardTax) {
		this.cardTax = cardTax;
	}

	public String getCardLicense() {
		return cardLicense;
	}

	public void setCardLicense(String cardLicense) {
		this.cardLicense = cardLicense;
	}
	private CustomerCompany info;
	public CustomerCompany getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, CustomerCompany.class);
    }
	public String ajaxSetInfo() {
		CustomerCompany cc = new CustomerCompany();

		if (!StringHelper.isNullOrEmpty(this.findTime)) {
			cc.setFindTime(Timestamp.valueOf(this.findTime));
		}
		
		if (!StringHelper.isNullOrEmpty(this.name)) {
			cc.setName(this.name);
		}

		if (!StringHelper.isNullOrEmpty(this.cardLicense)) {
			cc.setCardLicense(this.cardLicense);
		}

		if (!StringHelper.isNullOrEmpty(this.cardTax)) {
			cc.setCardTax(this.cardTax);
		}
		
		if (!StringHelper.isNullOrEmpty(this.cardNumber)) {
			cc.setCardNumber(this.cardNumber);
		}
		
		if (!StringHelper.isNullOrEmpty(this.address)) {
			cc.setAddress(this.address);
		}
		
		if (!StringHelper.isNullOrEmpty(this.telephone)) {
			cc.setTelephone(this.telephone);
		}
		
		if (!StringHelper.isNullOrEmpty(this.email)) {
			cc.setEmail(this.email);
		}
		
		if (!StringHelper.isNullOrEmpty(this.field)) {
			cc.setField(this.field);
		}
		
		if (!StringHelper.isNullOrEmpty(this.contactName)) {
			cc.setContactName(this.contactName);
		}
		
		if (!StringHelper.isNullOrEmpty(this.contactTelephone)) {
			cc.setContactTelephone(this.contactTelephone);
		}
		
		if (!StringHelper.isNullOrEmpty(this.contactCellphone1)) {
			cc.setContactCellphone1(this.contactCellphone1);
		}
		
		if (!StringHelper.isNullOrEmpty(this.contactCellphone2)) {
			cc.setContactCellphone2(this.contactCellphone2);
		}
		
		if (!StringHelper.isNullOrEmpty(this.relationLevel)) {
			cc.setRelationLevel(Byte.valueOf(this.relationLevel));
		}
		
		if (!StringHelper.isNullOrEmpty(this.riskHobby)) {
			cc.setRiskHobby(Byte.valueOf(this.riskHobby));
		}
		
		if (!StringHelper.isNullOrEmpty(this.tradeTotal)) {
			cc.setTradeTotal(Integer.parseInt(this.tradeTotal));
		}
		if (!StringHelper.isNullOrEmpty(this.agentNo)) {
			cc.setAgentNo(Integer.parseInt(this.agentNo));
		}
		if (!StringHelper.isNullOrEmpty(this.wealth)) {
			cc.setWealth(Integer.parseInt(this.wealth));
		}
		if (!StringHelper.isNullOrEmpty(this.getEditComment())) {
			cc.setEditComment(this.getEditComment());
		}
		if (!StringHelper.isNullOrEmpty(this.getIsTest())) {
			cc.setIsTest(Byte.valueOf(this.getIsTest()));
		}else{
			cc.setIsTest((byte) 0);
		}
		if(!StringHelper.isNullOrEmpty(this.memberClassType)){
			cc.setMemberClassType(Byte.valueOf(this.memberClassType));
		}
		if(!StringHelper.isNullOrEmpty(this.legal)){
			cc.setLegal(this.legal);
		}
		if(!StringHelper.isNullOrEmpty(this.legalIdcard)){
			cc.setLegalIdcard(this.legalIdcard);
		}
		if(!StringHelper.isNullOrEmpty(this.bankLicense)){
			cc.setBankLicense(this.bankLicense);
		}
		

		int result = -1;
		if (!this.customerId.equals("0")) {
			cc.setId(Integer.parseInt(this.customerId));
			result = CustomerCompanyModel.update(cc);
		} else {
			try {
				result = CustomerCompanyModel.add(cc);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.customerId = String.valueOf(result);
		}

		if (result < 0) {
			this.setErrCode("NO");
			this.setErrDesc("提交失败！");
		} else {
			this.setErrCode("OK");
			this.setErrDesc("提交成功！");
		}

		return SUCCESS;
	}

	public String exportExcel(){
		ExcelHelper excelHelper =  new ExcelHelper();
		excelHelper.getExcelForCustomerCompany(this.getCondition(), this.showAllList);
		
		return null;
	}

	/**
	 * 企业用户绑定p2p用户
	 * @return
	 */
	public String boundP2pCustomer(){
		CustomerCompany customerCompany = CustomerCompanyModel.getInfo(Integer.valueOf(this.getId()));
		String sn = SnModel.getSn(SnEnum.SN_ENTERPRISEREGISTER);//请求流水号
		if(StringHelper.isNullOrEmpty(sn)||StringHelper.isNullOrEmpty(customerCompany.getName())||StringHelper.isNullOrEmpty(customerCompany.getBankLicense())
				||StringHelper.isNullOrEmpty(customerCompany.getCardNumber())||StringHelper.isNullOrEmpty(customerCompany.getCardLicense())||StringHelper.isNullOrEmpty(customerCompany.getCardTax())
				||StringHelper.isNullOrEmpty(customerCompany.getLegal())||StringHelper.isNullOrEmpty(customerCompany.getLegalIdcard())||StringHelper.isNullOrEmpty(customerCompany.getContactName())
				||StringHelper.isNullOrEmpty(customerCompany.getContactCellphone1())||StringHelper.isNullOrEmpty(customerCompany.getEmail())||StringHelper.isNullOrEmpty(String.valueOf(customerCompany.getMemberClassType()))){
			this.setErrCode("NO");
			this.setErrDesc("绑定失败，请完善必要信息保存后绑定！");
			return SUCCESS;
		}
		P2pCustomer p2pCustomerForCheckUserName = P2pCustomerModel.selectByUserName(inputUserName.trim());
        if (p2pCustomerForCheckUserName != null) {//检查p2p用户名是否存在
        	this.setErrCode("failed");
            this.setErrDesc("该用户名已注册，请更换其他用户名");   
            return SUCCESS;
        }
        this.setErrCode("OK");
		this.setErrDesc("绑定成功！");
		
		if(customerCompany.getP2pCustomerNo()!=0){
			this.setErrCode("failed");
            this.setErrDesc("该企业已绑定p2p用户，请勿重复绑定！");   
            return SUCCESS;
		}
		P2pCustomer p2pCustomer = new P2pCustomer();
		p2pCustomer.setUserName(inputUserName.trim());
		String key = EncodeHelper.initKey(inputUserName.trim());
		p2pCustomer.setSecretKey(key);
        p2pCustomer.setCustomerType(StatusType.P2PCUSTOMER_COMPANY_TYPE);
		int p2pCustomerId = P2pCustomerModel.add(p2pCustomer);
		if(p2pCustomerId<=0){
			this.setErrCode("fail");
			this.setErrDesc("创建p2p客户失败！");
			return SUCCESS;
		}
		if(CustomerCompanyModel.updateCustomerNoById(p2pCustomerId,Integer.valueOf(this.getId())) <= 0){
			this.setErrCode("fail");
			this.setErrDesc("绑定p2p客户失败!");
			return SUCCESS;
		}
		EnterpriseRegisterReq enterpriseRegisterReq = new EnterpriseRegisterReq();
		enterpriseRegisterReq.setPlatformNo("");//商户编号
		enterpriseRegisterReq.setRequestNo(sn);//请求流水号
		enterpriseRegisterReq.setPlatformUserNo(p2pCustomerId + "");//平台用户编号
		enterpriseRegisterReq.setEnterpriseName(customerCompany.getName());//企业名称
		enterpriseRegisterReq.setBankLicense(customerCompany.getBankLicense());//开户银行许可证
		enterpriseRegisterReq.setOrgNo(customerCompany.getCardNumber());//组织机构代码0-10位大小
		enterpriseRegisterReq.setBusinessLicense(customerCompany.getCardLicense());//营业执照编号
		enterpriseRegisterReq.setTaxNo(customerCompany.getCardTax());//税务证编号
		enterpriseRegisterReq.setLegal(customerCompany.getLegal());//法人姓名
		enterpriseRegisterReq.setLegalIdNo(customerCompany.getLegalIdcard());//法人身份证
		enterpriseRegisterReq.setContact(customerCompany.getContactName());//企业联系人
		enterpriseRegisterReq.setContactPhone(customerCompany.getContactCellphone1());//企业联系人电话
		enterpriseRegisterReq.setEmail(customerCompany.getEmail());//企业联系人邮箱
		if(customerCompany.getMemberClassType()==1){
			enterpriseRegisterReq.setMemberClassType("ENTERPRISE");//会员类型     ENTERPRISE：企业借款人，GUARANTEE_CORP：担保公司
		}else{
			enterpriseRegisterReq.setMemberClassType("GUARANTEE_CORP");//会员类型     ENTERPRISE：企业借款人，GUARANTEE_CORP：担保公司
		}
		enterpriseRegisterReq.setCallbackUrl(UrlHelper.buildBackUrl("/customer/customerCompany/enterpriseRegisterCallBack"));//页面回跳URL
		enterpriseRegisterReq.setNotifyUrl(UrlHelper.buildBackUrl("/customer/customerCompany/enterpriseRegisterNotify"));//服务器通知URL
		try {
			this.paymentData = GatewayModel.enterpriseRegister(enterpriseRegisterReq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String getInfoById() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
            this.info = CustomerCompanyModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }
}
