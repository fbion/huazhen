package com.hzfh.fmp.model.common.enumeration;

/**
 * Created by Administrator on 2015/6/18.
 */
public class PaymentType {
    //账户资金冻结流水表
    public final static byte FREEZETYPE_TEND = (byte) 1;//投标
    public final static byte FREEZETYPE_REPAYMENT = (byte) 2;//还款
    public final static byte FREEZETYPE_CONFIRM = (byte) 3;//转账确认
    public final static byte FREEZETYPE_CANCEL = (byte) 4;//转账取消

    public final static byte FREEZESTATE_FREEZE = (byte) 0;//冻结
    public final static byte FREEZESTATE_THRAW = (byte) 1;//解冻

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
    public final static byte MONEYCHANGE_PAYCONFIRM = (byte) 9;//还款确认
    public final static byte MONEYCHANGE_LOANCONFIRM = (byte) 10;//放款确认

    public final static byte PAYMENTREFUND_DICTYPE=39;//还款状态字典类型

    public static final byte TRANSFER_TYPE_IN = 1;//账务变动方式：进账
    public static final byte TRANSFER_TYPE_OUT = 2;//账务变动方式：出账

    public static final byte P2PCUSTOMER_PERSONAL = 0;//个人用户类型
    public static final byte P2PCUSTOMER_COMPANY = 1;//企业用户类型
    
    //暂时定的燕阳的ID
    public static final int YYID = 290;//企业用户类型

}
