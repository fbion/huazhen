package com.hzfh.p2p.model.common.parameter;

/**
 * Created by Administrator on 2015/6/18.
 */
public class PaymentType {
    //账户资金冻结流水表
    public final static byte FREEZETYPE_TEND = (byte) 1;//投标
    public final static byte FREEZETYPE_LOAD = (byte) 2;//放款
    public final static byte FREEZETYPE_CONFIRM = (byte) 3;//转账确认
    public final static byte FREEZETYPE_CANCEL = (byte) 4;//转账取消

    public final static byte FREEZESTATE_FREEZE = (byte) 0;//冻结
    public final static byte FREEZESTATE_THRAW = (byte) 1;//解冻

    public static final byte TRANSFER_TYPE_IN = 1;//账务变动方式：进账
    public static final byte TRANSFER_TYPE_OUT = 2;//账务变动方式：出账

    //账户资金变动流水表
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

    public final static byte PAYMENTREFUND_DICTYPE=39;//还款状态字典类型
    
    //充值 Recharge
    public static final String RECHARGE_SUCCESS ="01";//充值成功
	public static final String RECHARGE_FAILURE ="02";//充值失败
	public static final String RECHARGE_RECHARGEING ="00";//充值中 暂不用
	//提现 Withdraw
	//状态(00 提现申请登记（基金监管时用） 01登记成功  02登记失败（基金监管时用）  03支付中（已生成提现流水） 04 提现成功 05提现失败)
	public static final String WITHDRA_WITHDRAWING ="03";//03 提现中  暂不用
	public static final String WITHDRA_SUCCESS ="04";//04 提现成功
	public static final String WITHDRA_FAILURE ="05";//05提现失败


    //支付类型
    public static final byte SALESPAY_ONLINE=(byte)1;//线上
    public static final byte SALESPAY_ALL=(byte)-1;//all
    
    
    //支付操作类型
    public static final byte RECHARGE = (byte)1; //充值
    public static final byte WITHDRAW = (byte)2; //提现
    public static final byte FREEZE = (byte)3; //冻结
    public static final byte CHANGE = (byte)4; // 
    public static final byte REGISTER = (byte)5;
    public static final byte CHANGEPWD = (byte)6;
    public static final byte ENTERPRISEREGISTER = (byte)7;
    public static final byte BIND_BANK_CARD = (byte)8;
    public static final byte UNBIND_BANK_CARD = (byte)9;
    public static final byte RESET_MOBILE = (byte)10; //重置手机号
    
  //订单状态
    public static final byte TO_SUBMIT = (byte)9;//待提交
    public static final byte CHECK_PENDING = (byte)1;//待审核
    public static final byte PAYMENT_PAYMENTING = (byte)10;//付款中
    public static final byte PAYMENT_FAILURE = (byte)0;//认购失败
}
