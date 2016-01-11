package com.hzfh.service.payment.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.api.customer.model.PaymentMoneyChange;
import com.hzfh.api.customer.model.PaymentMoneyFreeze;
import com.hzfh.api.customer.model.PaymentMoneyRecharge;
import com.hzfh.api.customer.model.PaymentMoneyWithdraw;
import com.hzfh.api.log.model.Log;
import com.hzfh.api.payment.model.ExamineCallbackRecord;
import com.hzfh.api.payment.model.PaymentRefund;
import com.hzfh.api.payment.model.common.constant.MemberType;
import com.hzfh.api.payment.model.common.constant.QueryType;
import com.hzfh.api.payment.model.common.constant.StatusCode;
import com.hzfh.api.payment.model.common.entity.CpTransactionRecord;
import com.hzfh.api.payment.model.common.entity.RechargeRecord;
import com.hzfh.api.payment.model.common.entity.WithdrawRecord;
import com.hzfh.api.payment.model.query.ExamineCallbackRecordCondition;
import com.hzfh.api.payment.model.request.controller.AccountInfoReq;
import com.hzfh.api.payment.model.request.controller.QueryReq;
import com.hzfh.api.payment.model.response.controller.AccountInfoResp;
import com.hzfh.api.payment.model.response.controller.QueryCpTransactionRecordResp;
import com.hzfh.api.payment.model.response.controller.QueryRechargeRecordResp;
import com.hzfh.api.payment.model.response.controller.QueryWithdrawRecordResp;
import com.hzfh.api.payment.service.AutoCheckingService;
import com.hzfh.api.payment.service.ControllerService;
import com.hzfh.api.payment.service.ExamineCallbackRecordService;
import com.hzfh.api.payment.service.PaymentRefundService;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.service.payment.facade.customer.CustomerOperFacade;
import com.hzfh.service.payment.facade.customer.PaymentAccountOperFacade;
import com.hzfh.service.payment.facade.customer.PaymentMoneyChangeOperFacade;
import com.hzfh.service.payment.facade.customer.PaymentMoneyFreezeOperFacade;
import com.hzfh.service.payment.facade.customer.PaymentMoneyRechargeOperFacade;
import com.hzfh.service.payment.facade.customer.PaymentMoneyWithdrawOperFacade;
import com.hzfh.service.payment.facade.log.LogOperFacade;
import com.hzfh.service.payment.facade.product.P2pProductOperFacade;
import com.hzfh.service.payment.facade.product.ProductOperFacade;
import com.hzfh.service.payment.facade.sales.SalesOperFacade;
import com.hzfh.service.payment.serviceImpl.Helper.LogConstant;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.StringHelper;
@Service("autoCheckingService")
public class AutoCheckingServiceImpl implements AutoCheckingService {
	@Autowired
	private ControllerService controllerService;
	@Autowired
	private ExamineCallbackRecordService examineCallbackRecordService;
	@Autowired
	private PaymentRefundService paymentRefundService; 
	@Override
	public String autoAccountCheck() {
        this.sysLogStart(LogConstant.LOG_LEVEL_INFO,"自动对账开始!",null,null,null);
		int status = 1;
		List<PaymentAccountInformation> paymentAccountInformationList = PaymentAccountOperFacade.getListByAuthenticationName(status);
		if(paymentAccountInformationList==null||paymentAccountInformationList.size()==0){
			this.sysLogStart(LogConstant.LOG_LEVEL_ERROR,"更新账户金额失败!","从账户详情表中获取数据失败！",null,null);
			return "0";
		}
		for (PaymentAccountInformation paymentAccountInformation : paymentAccountInformationList) {
			System.out.println(paymentAccountInformation.getCustomerNo());
			String platformUserNo = String.valueOf(paymentAccountInformation.getCustomerNo());
			AccountInfoReq  accountInfoReq  = new AccountInfoReq();
			accountInfoReq.setPlatformUserNo(platformUserNo);
			accountInfoReq.setPlatformNo(accountInfoReq.getPlatformNo());
			AccountInfoResp accountInfo = controllerService.getAccountInfo(accountInfoReq);			
			if(accountInfo!=null&&String.valueOf(StatusCode.SUCCESS).equals(accountInfo.getCode())&&MemberType.PERSONAL.equals(accountInfo.getMemberType())){
				
				System.out.println("易宝存在的客户！"+paymentAccountInformation.getCustomerNo()+"，类型："+accountInfo.getMemberType()+"代码"+accountInfo.getCode());
				double moneyAmount = paymentAccountInformation.getMoneyAmount();
				double moneyWithdraw = paymentAccountInformation.getMoneyWithdraw();
				double moneyFreeze = paymentAccountInformation.getMoneyFreeze();
				
				paymentAccountInformation.setMoneyAmount(accountInfo.getBalance());
				paymentAccountInformation.setMoneyWithdraw(accountInfo.getAvailableAmount());
				paymentAccountInformation.setMoneyFreeze(accountInfo.getFreezeAmount());
				String cNo =String.valueOf(paymentAccountInformation.getCustomerNo());
				String cNa = paymentAccountInformation.getCustomerName();
				try {
					this.sysLogStart(LogConstant.LOG_LEVEL_INFO,"账户"+cNo+"更新前金额!",cNo+"-"+cNa+"：更新前总额："+moneyAmount+"可用余额："+moneyWithdraw+"冻结金额："+moneyFreeze,cNo,null);
					PaymentAccountOperFacade.update(paymentAccountInformation);
					this.sysLogStart(LogConstant.LOG_LEVEL_INFO,"更新账户"+cNo+"金额成功!",cNo+"-"+cNa+"：更新后总额："+accountInfo.getAvailableAmount()+"可用余额："+accountInfo.getBalance()+"冻结金额："+accountInfo.getFreezeAmount(),cNo,null);
				} catch (Exception e) {
					this.sysLogStart(LogConstant.LOG_LEVEL_ERROR,"更新账户"+cNo+"金额失败!",cNo+"-"+cNa+"：更新失败！",cNo,e);
				}
			}
		}
		this.sysLogStart(LogConstant.LOG_LEVEL_INFO,"自动对账结束!",null,null,null);
        return "1";
	}
    public String test(String name){
        return "hello" + name;
    }
	 public void sysLogStart(String logLevel, String operateName, String supplement,String userId,Throwable e){
	        Log log = new Log();
	        log.setLevel(logLevel);
	        log.setOperateName(operateName);
	        log.setSupplement(supplement);
	        if(!StringHelper.isNullOrEmpty(userId)){
	        	log.setUserNo(Integer.parseInt(userId));
	        }
	        log.setStartTime(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
	        if(e != null){
	        	log.setExceptionMsg(e.toString());
	        }
	        LogOperFacade.add(log);
	    }
	 
	 
	 
	 
	@Override
	public String autoExamineNotify() {
		this.sysLogStart(LogConstant.LOG_LEVEL_INFO,"五分钟一次NOTIFY-自动检测notify开始!",null,null,null);
		List<ExamineCallbackRecord> examineCallbackRecords = getExamineCallbackRecords();
		for (ExamineCallbackRecord examineCallbackRecord : examineCallbackRecords) {
			paymentService(examineCallbackRecord);
		}
		return null;
	}
	
	/**
	 * 分页查询，没有notify 时间间隔5分钟
	 * @return
	 */
	public List<ExamineCallbackRecord> getExamineCallbackRecords(){
		this.sysLogStart(LogConstant.LOG_LEVEL_INFO,"五分钟一次NOTIFY-按条件查询所有没有notify的数据开始!",null,null,null);
		ExamineCallbackRecordCondition examineCallbackRecordCondition = new ExamineCallbackRecordCondition();
		int pageSize = 10;
		int pageIndex = 1;
        examineCallbackRecordCondition.setPageSize(pageSize);
        examineCallbackRecordCondition.setPageIndex(pageIndex);
        byte status = 0 ;//没有notify
        examineCallbackRecordCondition.setStatus(status);
        int minute = 5;//5分钟
        examineCallbackRecordCondition.setMinute(minute);
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild("in_time");
        sortItem.setSortType(SortType.ASC);
        sortItemList.add(sortItem);
        examineCallbackRecordCondition.setSortItemList(sortItemList);
        
        PagedList<ExamineCallbackRecord> examineCallbackRecordPagedList = examineCallbackRecordService.getPagingList(examineCallbackRecordCondition);
        List<ExamineCallbackRecord> examineCallbackRecords = examineCallbackRecordPagedList.getResultList();
        this.sysLogStart(LogConstant.LOG_LEVEL_INFO,"五分钟一次NOTIFY-按条件查询所有没有notify的数据结束!",null,null,null);
		return examineCallbackRecords;
	}
	
	/**
	 * 根据不同serviceName 调用不同的方法，操作不同的数据
	 * @param examineCallbackRecord
	 */
	private void paymentService(ExamineCallbackRecord examineCallbackRecord) {
        switch (examineCallbackRecord.getServiceName()) {
            case QueryType.QUERY_RECHARGE:
            	
            	this.sysLogStart(LogConstant.LOG_LEVEL_INFO,"五分钟一次NOTIFY-充值的数据开始!",null,null,null);
            	if(examineCallbackRecord.getStatus()==QueryType.QUERY_YES_NOTIFY){
            		break;
            	}
            	examineCallbackRecordService.updateStatusById(QueryType.QUERY_YES_NOTIFY, examineCallbackRecord.getId());
            	QueryReq queryReqRecharge = getQueryReq(QueryType.QUERY_RECHARGE_RECORD,examineCallbackRecord.getSn());
            	QueryRechargeRecordResp rechargeRecordResp = controllerService.getRechargeRecord(queryReqRecharge);
            	rechargeNotify(rechargeRecordResp,examineCallbackRecord);
            	break;
            case QueryType.QUERY_WITHDRAW:
            	this.sysLogStart(LogConstant.LOG_LEVEL_INFO,"五分钟一次NOTIFY-提现的数据开始!",null,null,null);
            	if(examineCallbackRecord.getStatus()==QueryType.QUERY_YES_NOTIFY){
            		break;
            	}
            	examineCallbackRecordService.updateStatusById(QueryType.QUERY_YES_NOTIFY, examineCallbackRecord.getId());
            	QueryReq queryReqWithdraw = getQueryReq(QueryType.QUERY_WITHDRAW_RECORD,examineCallbackRecord.getSn());
            	QueryWithdrawRecordResp withdrawRecordResp = controllerService.getWithdrawRecord(queryReqWithdraw);
            	withdrawNotify(withdrawRecordResp,examineCallbackRecord);
            	break;
            case QueryType.QUERY_CP_TRANSACTION:
            	this.sysLogStart(LogConstant.LOG_LEVEL_INFO,"五分钟一次NOTIFY-自动对账的数据开始!",null,null,null);
            	if(examineCallbackRecord.getStatus()==QueryType.QUERY_YES_NOTIFY){
            		break;
            	}
            	examineCallbackRecordService.updateStatusById(QueryType.QUERY_YES_NOTIFY, examineCallbackRecord.getId());
            	QueryReq queryReqTender = getQueryReq(QueryType.QUERY_CP_TRANSACTION_RECORD,examineCallbackRecord.getSn());
            	QueryCpTransactionRecordResp cpTransactionRecordResp = controllerService.getCpTransactionRecord(queryReqTender);
            	
            	List<CpTransactionRecord> cpTransactionRecords = cpTransactionRecordResp.getCpTransactionRecords().getRecords();
            	if(cpTransactionRecords!=null&&cpTransactionRecords.size()!=0) {
            		for (CpTransactionRecord cpTransactionRecord : cpTransactionRecords) {
            			if(QueryType.QUERY_TENDER.equals(cpTransactionRecord.getBizType())){
            				this.sysLogStart(LogConstant.LOG_LEVEL_INFO,"五分钟一次NOTIFY-自动对账-投标的数据开始!",null,null,null);
            				if(examineCallbackRecord.getStatus()==QueryType.QUERY_YES_NOTIFY){
            					break;
            				}
            				examineCallbackRecordService.updateStatusById(QueryType.QUERY_YES_NOTIFY, examineCallbackRecord.getId());
            				tenderNotify(cpTransactionRecord,examineCallbackRecord);
            			}
            			if(QueryType.QUERY_REPAYMENT.equals(cpTransactionRecord.getBizType())){
            				this.sysLogStart(LogConstant.LOG_LEVEL_INFO,"五分钟一次NOTIFY-自动对账-还款的数据开始!",null,null,null);
            				if(examineCallbackRecord.getStatus()==QueryType.QUERY_YES_NOTIFY){
            					break;
            				}
            				examineCallbackRecordService.updateStatusById(QueryType.QUERY_YES_NOTIFY, examineCallbackRecord.getId());
            				reqRepaymentNotify(cpTransactionRecord,examineCallbackRecord);
            			}
            			if(QueryType.QUERY_TRANSFER.equals(cpTransactionRecord.getBizType())){
            				this.sysLogStart(LogConstant.LOG_LEVEL_INFO,"五分钟一次NOTIFY-自动对账-转账的数据开始!",null,null,null);
            				if(examineCallbackRecord.getStatus()==QueryType.QUERY_YES_NOTIFY){
            					break;
            				}
            				examineCallbackRecordService.updateStatusById(QueryType.QUERY_YES_NOTIFY, examineCallbackRecord.getId());
            				transferNotify(cpTransactionRecord,examineCallbackRecord);
            			}
            		}
				}else{
					if(QueryType.QUERY_TENDER.equals(examineCallbackRecord.getOperationType())){
						SalesOperFacade.updateStatus(Integer.parseInt(examineCallbackRecord.getSn()),QueryType.PAYMENT_FAILURE);//认购失败
						this.sysLogStart(LogConstant.LOG_LEVEL_ERROR,"五分钟一次NOTIFY-【投标】更新sales的状态为失败！","【投标】更新sales的状态为失败！",null,null);
					}else if(QueryType.QUERY_REPAYMENT.equals(examineCallbackRecord.getOperationType())){
						
					}else if(QueryType.QUERY_TRANSFER.equals(examineCallbackRecord.getOperationType())){
						
					}
				}
            	break;
            default:
                break;
        }
	}
	
	
	/**
	 * 封装单笔业务查询的数据为实体
	 * @param mode
	 * @param requestNo
	 * @return
	 */
	private QueryReq getQueryReq(String mode,String requestNo){
		QueryReq queryReq = new QueryReq();
		queryReq.setMode(mode);
    	queryReq.setRequestNo(requestNo);
    	queryReq.setPlatformNo(queryReq.getPlatformNo());
    	return queryReq;
	}
	/**
	 * 充值操作数据
	 * @param rechargeRecordResp
	 * @param examineCallbackRecord
	 */
	private void rechargeNotify(QueryRechargeRecordResp rechargeRecordResp,ExamineCallbackRecord examineCallbackRecord){
		this.sysLogStart(LogConstant.LOG_LEVEL_INFO,"五分钟一次NOTIFY-充值操作数据开始!",null,null,null);
		if(rechargeRecordResp.getRechargeRecords().getRecords()!=null){
			RechargeRecord rechargeRecord = rechargeRecordResp.getRechargeRecords().getRecords().get(0);
			if(QueryType.QUERY_RECHARGE_SUCCESS.equals(rechargeRecord.getStatus())){
				double money = Double.parseDouble(rechargeRecord.getAmount());
				int customerNo =  Integer.parseInt(rechargeRecord.getUserNo());
				String sn = examineCallbackRecord.getSn();
				String status = QueryType.RECHARGE_SUCCESS;
				
				//paymentMoneyRecharge
				PaymentMoneyRecharge payMoneyRecharge = PaymentMoneyRechargeOperFacade.getInfoByStateAndSn(QueryType.RECHARGE_SUCCESS,sn);
	        	if(payMoneyRecharge==null){
	        		try {
	        			PaymentMoneyRechargeOperFacade.updateMoneyAmount(money,customerNo,sn);
	        			this.sysLogStart(LogConstant.LOG_LEVEL_INFO,"五分钟一次NOTIFY-充值操作数据-更新充值表中账户金额成功!","更新充值表中账户金额成功!",null,null);
	        		} catch (Exception e) {
	        			this.sysLogStart(LogConstant.LOG_LEVEL_ERROR,"五分钟一次NOTIFY-充值操作数据-更新充值表中账户金额失败!","更新充值表中账户金额失败!",null,e);
	        			e.printStackTrace();
	        		}
	        		try {
	        			PaymentMoneyRechargeOperFacade.updateState(status, customerNo, sn);
	        			this.sysLogStart(LogConstant.LOG_LEVEL_INFO,"五分钟一次NOTIFY-充值操作数据-更新新充值表中充值状态成功!","更新新充值表中充值状态成功!",null,null);
	        		} catch (Exception e) {
	        			this.sysLogStart(LogConstant.LOG_LEVEL_ERROR,"五分钟一次NOTIFY-充值操作数据-更新新充值表中充值状态失败!","更新新充值表中充值状态失败!",null,e);
	        			e.printStackTrace();
	        		}
	        		//paymentAccountOperFacade
	        		PaymentAccountOperFacade.updateMoneyAmount(money,customerNo);
	        	}
				
				//paymentMoneyChange
	        	PaymentMoneyChange payMoneyChange =PaymentMoneyChangeOperFacade.getInfoByMoneyChangeTypeAndRefSn(QueryType.MONEYCHANGE_RECHARGE, sn);
				if(payMoneyChange==null){
					PaymentMoneyChange paymentMoneyChange = new PaymentMoneyChange();
					paymentMoneyChange.setP2pCustomerNo(customerNo);
					paymentMoneyChange.setMoneyChangeType(QueryType.MONEYCHANGE_RECHARGE);
					paymentMoneyChange.setMoneyWithdraw(money);
					paymentMoneyChange.setRefSn(sn);
					double moneyAmountLater =PaymentAccountOperFacade.getInfoByCustomerNo(customerNo).getMoneyAmount();	
					paymentMoneyChange.setMoneyAmountLater(moneyAmountLater);
					PaymentMoneyChangeOperFacade.add(paymentMoneyChange);
				}
			}
		}else {
			PaymentMoneyRechargeOperFacade.updateStateBySn(examineCallbackRecord.getSn(), QueryType.RECHARGE_FAILURE);
			this.sysLogStart(LogConstant.LOG_LEVEL_INFO,"五分钟一次NOTIFY-充值操作数据-records为null 没有到易宝界面中进行充值成功的操作!",null,null,null);
		}
	}
	/**
	 * 提现操作数据
	 * @param withdrawRecordResp
	 * @param examineCallbackRecord
	 */
	private void withdrawNotify(QueryWithdrawRecordResp withdrawRecordResp, ExamineCallbackRecord examineCallbackRecord){
		if(withdrawRecordResp.getWithdrawRecords().getRecords()!=null){
			WithdrawRecord withdrawRecord = withdrawRecordResp.getWithdrawRecords().getRecords().get(0);
			if(QueryType.QUERY_WITHDRAW_SUCCESS.equals(withdrawRecord.getStatus())){
				double money = Double.parseDouble(withdrawRecord.getAmount());
				int customerNo = Integer.parseInt(withdrawRecord.getUserNo());
				
				String sn = examineCallbackRecord.getSn();
				String status = QueryType.WITHDRA_SUCCESS;
				
				//paymentMoneyWithdraw
				PaymentMoneyWithdraw payMoneyWithdraw = PaymentMoneyWithdrawOperFacade.getInfoBystateAndSn(QueryType.WITHDRA_SUCCESS,sn);
				if(payMoneyWithdraw==null){
					try {
						PaymentMoneyWithdrawOperFacade.updateMoneyAmount(money,sn);
						this.sysLogStart(LogConstant.LOG_LEVEL_INFO,"五分钟一次NOTIFY-提现操作数据-更新提现表中提现金额成功!","更新提现表中提现金额成功!",null,null);
					} catch (Exception e) {
						this.sysLogStart(LogConstant.LOG_LEVEL_ERROR,"五分钟一次NOTIFY-提现操作数据-更新提现表中提现金额失败!","更新提现表中提现金额失败!",null,e);
						e.printStackTrace();
					}
					try {
						PaymentMoneyWithdrawOperFacade.updateState(status,sn);
						this.sysLogStart(LogConstant.LOG_LEVEL_INFO,"五分钟一次NOTIFY-提现操作数据-更新提现表中提现状态成功!","更新新充值表中提现状态成功!",null,null);
					} catch (Exception e) {
						this.sysLogStart(LogConstant.LOG_LEVEL_ERROR,"五分钟一次NOTIFY-提现操作数据-更新提现表中提现状态失败!","更新新充值表中提现状态失败!",null,e);
						e.printStackTrace();
					}
					
					//PaymentMoneyWithdrawOperFacade
					try {
						PaymentAccountOperFacade.updateMoneyAmount(-money,customerNo);
						this.sysLogStart(LogConstant.LOG_LEVEL_INFO,"五分钟一次NOTIFY-提现操作数据-更新账户信息表中账户金额成功!","更新账户信息表中账户金额成功!",null,null);
					} catch (Exception e) {
						this.sysLogStart(LogConstant.LOG_LEVEL_ERROR,"五分钟一次NOTIFY-提现操作数据-更新账户信息表中账户金额失败!","更新账户信息表中账户金额失败!",null,e);
						e.printStackTrace();
					}
				}
				
				//paymentMoneyChange
				PaymentMoneyChange payMoneyChange =PaymentMoneyChangeOperFacade.getInfoByMoneyChangeTypeAndRefSn(QueryType.MONEYCHANGE_WITHDRAW,sn);
				if(payMoneyChange==null){
					try {
						PaymentMoneyChange paymentMoneyChange = new PaymentMoneyChange();
						paymentMoneyChange.setP2pCustomerNo(customerNo);
						paymentMoneyChange.setMoneyChangeType(QueryType.MONEYCHANGE_WITHDRAW);
						paymentMoneyChange.setMoneyWithdraw(money);
						paymentMoneyChange.setRefSn(sn);
						double moneyAmountLater =PaymentAccountOperFacade.getInfoByCustomerNo(customerNo).getMoneyAmount();
						paymentMoneyChange.setMoneyAmountLater(moneyAmountLater);
						PaymentMoneyChangeOperFacade.add(paymentMoneyChange);
						this.sysLogStart(LogConstant.LOG_LEVEL_INFO,"五分钟一次NOTIFY-提现操作数据-增加资金变动数据成功!","增加资金变动数据成功!",null,null);
					} catch (Exception e) {
						this.sysLogStart(LogConstant.LOG_LEVEL_ERROR,"五分钟一次NOTIFY-提现操作数据-增加资金变动数据失败!","增加资金变动数据失败!",null,e);
						e.printStackTrace();
					}
				}
			}
		}else{
			PaymentMoneyWithdrawOperFacade.updateState( QueryType.RECHARGE_FAILURE,examineCallbackRecord.getSn());
			this.sysLogStart(LogConstant.LOG_LEVEL_INFO,"五分钟一次NOTIFY-提现操作数据-records为null 没有到易宝界面中进行提现的操作!",null,null,null);
		}
	}
	/**
	 * 投标操作数据
	 * @param cpTransactionRecord 
	 * @param examineCallbackRecord
	 */
	private void tenderNotify(CpTransactionRecord cpTransactionRecord, ExamineCallbackRecord examineCallbackRecord){
		
		if(QueryType.QUERY_CP_TRANSACTION_RECORD_SUCCESS.equals(cpTransactionRecord.getSubStatus())){
		int salesId = Integer.parseInt(examineCallbackRecord.getSn());
		Sales sales = SalesOperFacade.getInfo(salesId);
		P2pCustomer p2pCustomer = CustomerOperFacade.getInfo(sales.getP2pCustomerNo());
		PaymentMoneyFreeze paymentMoneyFre = PaymentMoneyFreezeOperFacade.getInfoBySnAndType(examineCallbackRecord.getSn(), QueryType.FREEZETYPE_TEND);
		if (paymentMoneyFre == null) {
			
			//减少Product和P2pProduct的剩余额度
			//添加P2pProduct打款个数
			//增加客户的累计购买金额
			int productNo = sales.getProductNo();
			long money = sales.getMoney();
			int count = 1;
			try {
				ProductOperFacade.updateReduceRemainAmount(productNo, money);
				P2pProductOperFacade.updateRemainAmountByProductNo(productNo, -money);
				this.sysLogStart(LogConstant.LOG_LEVEL_INFO,"五分钟一次NOTIFY-【投标】减少Product和P2pProduct的剩余额度，成功！","【投标】减少Product和P2pProduct的剩余额度，成功！",null,null);
			} catch (Exception e) {
				this.sysLogStart(LogConstant.LOG_LEVEL_ERROR,"五分钟一次NOTIFY-【投标】减少Product和P2pProduct的剩余额度，失败！","【投标】减少Product和P2pProduct的剩余额度，失败！",null,e);
				e.printStackTrace();
			}
			try {
				P2pProductOperFacade.updateOrderCountByProductNo(productNo,count);
				this.sysLogStart(LogConstant.LOG_LEVEL_INFO,"五分钟一次NOTIFY-【投标】增加客户的累计购买金额，成功！","【投标】增加客户的累计购买金额，成功！",null,null);
			} catch (Exception e) {
				this.sysLogStart(LogConstant.LOG_LEVEL_ERROR,"五分钟一次NOTIFY-【投标】增加客户的累计购买金额，失败！","【投标】增加客户的累计购买金额，失败！",null,e);
				e.printStackTrace();
			}
			try {
				this.updateTradeTotalBySales(sales, money);
				this.sysLogStart(LogConstant.LOG_LEVEL_INFO,"五分钟一次NOTIFY-【投标】添加P2pProduct打款个数，成功！","【投标】添加P2pProduct打款个数，成功！",null,null);
			} catch (Exception e) {
				this.sysLogStart(LogConstant.LOG_LEVEL_ERROR,"五分钟一次NOTIFY-【投标】添加P2pProduct打款个数,失败！","【投标】添加P2pProduct打款个数,失败！",null,e);
				e.printStackTrace();
			}
			
			//账户资金冻结流水记录
			try {
				PaymentMoneyFreeze paymentMoneyFreeze = new PaymentMoneyFreeze();
				paymentMoneyFreeze.setMoneyFreeze(sales.getMoney());
				paymentMoneyFreeze.setRefSn(examineCallbackRecord.getSn());
				paymentMoneyFreeze.setP2pCustomerNo(p2pCustomer.getId());
				paymentMoneyFreeze.setP2pCustomerName(p2pCustomer.getRealName());
				paymentMoneyFreeze.setOrderNo(String.valueOf(sales.getId()));
				paymentMoneyFreeze.setState(QueryType.FREEZESTATE_FREEZE);
				paymentMoneyFreeze.setChangeType(QueryType.FREEZETYPE_TEND);
				PaymentMoneyFreezeOperFacade.add(paymentMoneyFreeze);
				this.sysLogStart(LogConstant.LOG_LEVEL_INFO,"五分钟一次NOTIFY-【投标】记录到payment_money_freeze（资金冻结流水）表成功！","【投标】记录到payment_money_freeze（资金冻结流水）表成功！",null,null);
			} catch (Exception e) {
				this.sysLogStart(LogConstant.LOG_LEVEL_ERROR,"五分钟一次NOTIFY-【投标】记录到payment_money_freeze（资金冻结流水）表失败！","【投标】记录到payment_money_freeze（资金冻结流水）表失败！",null,e);
				e.printStackTrace();
			}
		}
		PaymentMoneyChange payMoneyChange = PaymentMoneyChangeOperFacade.getInfoByMoneyChangeTypeAndRefSn(QueryType.MONEYCHANGE_PAY,examineCallbackRecord.getSn());
		if(payMoneyChange == null){
			try {
				PaymentAccountInformation paymentAccountInformation = PaymentAccountOperFacade.getInfoByCustomerNo(sales.getP2pCustomerNo());
				PaymentMoneyChange paymentMoneyChange = new PaymentMoneyChange();
				paymentMoneyChange.setP2pCustomerNo(p2pCustomer.getId());
				paymentMoneyChange.setP2pCustomerName(p2pCustomer.getRealName());
				paymentMoneyChange.setMoneyTransferType(QueryType.TRANSFER_TYPE_OUT);
				paymentMoneyChange.setMoneyChangeType(QueryType.MONEYCHANGE_PAY);
				paymentMoneyChange.setMoneyAmountPre(paymentAccountInformation.getMoneyAmount());
				paymentMoneyChange.setMoneyAmountLater(paymentAccountInformation.getMoneyAmount());
				paymentMoneyChange.setMoneyWithdraw(sales.getMoney());
				paymentMoneyChange.setRefSn(examineCallbackRecord.getSn());
				PaymentMoneyChangeOperFacade.add(paymentMoneyChange);			
				PaymentAccountOperFacade.updateMoneyFreeze(sales.getMoney(), p2pCustomer.getId());
				this.sysLogStart(LogConstant.LOG_LEVEL_INFO,"五分钟一次NOTIFY-【投标】记录到payment_money_change（资金变动流水）表成功","【投标】记录到payment_money_change（资金变动流水）表成功！",null,null);
			} catch (Exception e) {
				this.sysLogStart(LogConstant.LOG_LEVEL_ERROR,"五分钟一次NOTIFY-【投标】记录到payment_money_change（资金变动流水）表出现异常！","【投标】记录到payment_money_change（资金变动流水）表出现异常！",null,e);
				e.printStackTrace();
			}
			//PaymentAccountOperFacade.updateMoneyWithDarw(-sales.getMoney(), p2pCustomer.getId());
		}
			try {
				SalesOperFacade.updateStatus(sales.getId(), (byte) 1);
				this.sysLogStart(LogConstant.LOG_LEVEL_INFO,"五分钟一次NOTIFY-【投标】更新sales的状态为待审核成功！","【投标】更新sales的状态为待审核成功！",null,null);
			} catch (Exception e) {
				this.sysLogStart(LogConstant.LOG_LEVEL_ERROR,"五分钟一次NOTIFY-【投标】更新sales的状态为待审核出现异常！","【投标】更新sales的状态为待审核出现异常！",null,e);
				e.printStackTrace();
			}
		}else{
			SalesOperFacade.updateStatus(Integer.parseInt(examineCallbackRecord.getSn()),QueryType.PAYMENT_FAILURE);//认购失败
			this.sysLogStart(LogConstant.LOG_LEVEL_ERROR,"五分钟一次NOTIFY-【投标】更新sales的状态失败！","【投标】更新sales的状态为失败！",null,null);
		}
          
	}
	/**
	 * 更新(增加)客户的累计购买金额
	 * @param sales
	 * @param money
	 */
    private void updateTradeTotalBySales(Sales sales, double money) {
        if (sales.getCustomerType() == QueryType.CUSTOMER_PERSONAL_TYPE) {//自然人
        	CustomerOperFacade.updatePersonalTradeTotalById(sales.getCustomerNo(), money);
        } else if (sales.getCustomerType() == QueryType.CUSTOMER_COMPANY_TYPE) {//法人
        	CustomerOperFacade.updateCompanyTradeTotalById(sales.getCustomerNo(), money);
        }
    }
    /**
     * 还款数据操作
     * @param cpTransactionRecord
     * @param examineCallbackRecord
     */
    
    private void reqRepaymentNotify(CpTransactionRecord cpTransactionRecord, ExamineCallbackRecord examineCallbackRecord) {
    	if(QueryType.QUERY_CP_TRANSACTION_RECORD_SUCCESS.equals(cpTransactionRecord.getSubStatus())){
    		PaymentRefund paymentRefund = paymentRefundService.getInfo(Integer.valueOf(examineCallbackRecord.getSn()));
    		PaymentMoneyFreeze paymentMoneyFree = PaymentMoneyFreezeOperFacade.getInfoBySnAndType(examineCallbackRecord.getSn(), QueryType.FREEZETYPE_REPAYMENT);
    		if (paymentMoneyFree == null) {
    			PaymentMoneyFreeze paymentMoneyFreeze = new PaymentMoneyFreeze();
    			paymentMoneyFreeze.setAccountType(QueryType.P2PCUSTOMER_COMPANY);
    			paymentMoneyFreeze.setP2pCustomerNo(paymentRefund.getPayerNo());
    			paymentMoneyFreeze.setP2pCustomerName(paymentRefund.getPayerName());
    			paymentMoneyFreeze.setMoneyFreeze(paymentRefund.getSalesMoney());
    			paymentMoneyFreeze.setRefSn(examineCallbackRecord.getSn());
    			paymentMoneyFreeze.setState(QueryType.FREEZESTATE_FREEZE);
    			paymentMoneyFreeze.setChangeType(QueryType.FREEZETYPE_REPAYMENT);
    			PaymentMoneyFreezeOperFacade.add(paymentMoneyFreeze);
    			
    			//PaymentMoneyChangeOperFacade.updateMoneyWithDarw(-paymentRefund.getPayMoney(), paymentRefund.getPayerNo());
    			PaymentMoneyChangeOperFacade.updateMoneyFreeze(paymentRefund.getPayMoney(), paymentRefund.getPayerNo());
    			
    			paymentRefundService.updateStatusById(Integer.valueOf(examineCallbackRecord.getSn()), QueryType.CHECKPAYMENT);
    		}
    	}
    }
    /**
     * 转账数据操作
     * @param cpTransactionRecord
     * @param examineCallbackRecord
     */
    private void transferNotify(CpTransactionRecord cpTransactionRecord,
			ExamineCallbackRecord examineCallbackRecord) {
		// TODO Auto-generated method stub
		
	}
 
}
