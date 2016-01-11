package com.hzfh.api.payment.model.common.constant;

public class QueryType 
{
	//单笔业务查询
	public static final String QUERY_TENDER = "TENDER";//投标
	public static final String QUERY_REPAYMENT = "REPAYMENT";//还款
	public static final String QUERY_TRANSFER = "TRANSFER";//转账
	
	
	
	public static final String QUERY_CP_TRANSACTION = "CP_TRANSACTION";//转账授权
	public static final String QUERY_WITHDRAW = "WITHDRAW";//提现
	public static final String QUERY_RECHARGE = "RECHARGE";//充值
	public static final String QUERY_FREEZERE = "FREEZERE";//冻结
	
	//单笔业务查询  查询模式
	public static final String QUERY_WITHDRAW_RECORD = "WITHDRAW_RECORD" ;//提现记录
	public static final String QUERY_RECHARGE_RECORD = "RECHARGE_RECORD" ;//充值记录 
	public static final String QUERY_CP_TRANSACTION_RECORD = "CP_TRANSACTION" ;//转账 记录
	public static final String QUERY_FREEZERE_RECORD= "FREEZERE_RECORD" ;//冻结 /解
	
	
	public static final String QUERY_RECHARGE_SUCCESS = "SUCCESS";
	public static final String QUERY_RECHARGE_INIT = "INIT";
	public static final String QUERY_WITHDRAW_SUCCESS = "SUCCESS";
	public static final String QUERY_WITHDRAW_INIT = "INIT";
	public static final String QUERY_CP_TRANSACTION_RECORD_SUCCESS = "SUCCESS";
	
	
	
	//examineCallbackRecord中的status状态
	public static final byte QUERY_NO_NOTIFY= 0;
	public static final byte QUERY_YES_NOTIFY= 1;
	
	 //充值 Recharge
    public static final String RECHARGE_SUCCESS ="01";//充值成功
	public static final String RECHARGE_FAILURE ="02";//充值失败
	public static final String RECHARGE_RECHARGEING ="00";//充值中 暂不用
	//提现 Withdraw
	//状态(00 提现申请登记（基金监管时用） 01登记成功  02登记失败（基金监管时用）  03支付中（已生成提现流水） 04 提现成功 05提现失败)
	public static final String WITHDRA_WITHDRAWING ="03";//03 提现中  暂不用
	public static final String WITHDRA_SUCCESS ="04";//04 提现成功
	public static final String WITHDRA_FAILURE ="05";//05提现失败
	
	
	//变动类型(1充值，2投标确认，3提现，4,支付利息，5还本付息) 为准 mengChong 2015/07/02
    public final static byte MONEYCHANGE_RECHARGE = (byte) 1;//充值
    public final static byte MONEYCHANGE_PAY = (byte) 2;//投标确认
    public final static byte MONEYCHANGE_WITHDRAW = (byte) 3;//提现
    public final static byte MONEYCHANGE_ADJUSTMENT = (byte) 4;//内部调账
    public final static byte MONEYCHANGE_SETTLEINTEREST = (byte) 5;//结息
    public final static byte MONEYCHANGE_INTERESTTAX = (byte) 6;//利息税
    public final static byte MONEYCHANGE_REFUND = (byte) 7;//原交易退款
    public final static byte MONEYCHANGE_CANCEL = (byte) 8;//原交易撤销
    public final static byte MONEYCHANGE_PAYCONFIRM = (byte) 9;//还款确认 收款
    public final static byte MONEYCHANGE_LOANCONFIRM = (byte) 10;//放款确认 付款
    
    
    //账户资金冻结流水表
    public final static byte FREEZETYPE_REPAYMENT = (byte) 2;//还款
    //账户资金冻结流水表
    public final static byte FREEZETYPE_TEND = (byte) 1;//投标
    public final static byte FREEZETYPE_LOAD = (byte) 2;//放款
    public final static byte FREEZETYPE_CONFIRM = (byte) 3;//转账确认
    public final static byte FREEZETYPE_CANCEL = (byte) 4;//转账取消

    public final static byte FREEZESTATE_FREEZE = (byte) 0;//冻结
    public final static byte FREEZESTATE_THRAW = (byte) 1;//解冻
    public static final byte TRANSFER_TYPE_IN = 1;//账务变动方式：进账
    public static final byte TRANSFER_TYPE_OUT = 2;//账务变动方式：出账
    
    
	public static final int BIND_BANK_STATUS = 1;//绑定银行卡
	public static final int UN_BIND_BANK_STATUS = 0;//取消绑定银行卡
	
	public static final byte CUSTOMER_PERSONAL_TYPE=1;//自然人客户类型
	public static final byte CUSTOMER_COMPANY_TYPE=2;//法人客户类型
    public static final byte P2PCUSTOMER_PERSONAL = 0;//个人用户类型
    public static final byte P2PCUSTOMER_COMPANY = 1;//企业用户类型
    
    
    public static final byte WAITPAYMENT=1;//待还款
    public static final byte CHECKPAYMENT = 2;//还款审核中
    public static final byte FINSHPAYMENT = 3;//已还款
    
    
    //订单状态
    public static final byte TO_SUBMIT = (byte)9;//待提交
    public static final byte CHECK_PENDING = (byte)1;//待审核
    public static final byte PAYMENT_PAYMENTING = (byte)10;//付款中
    public static final byte PAYMENT_FAILURE = (byte)0;//认购失败
    
}                               
                                