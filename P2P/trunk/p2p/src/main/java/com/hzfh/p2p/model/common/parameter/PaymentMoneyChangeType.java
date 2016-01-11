package com.hzfh.p2p.model.common.parameter;

public class PaymentMoneyChangeType {
	//变动类型(1充值，2支付，3提现，4内部调账，5结息，6利息税，7原交易退款，8原交易撤销)
	public static final byte RECHARG =1;
	public static final byte PAYMENT =2;
	public static final byte WITHDRAW =3;
	public static final byte INTERNAL_TRANSFER =4;
	public static final byte INTEREST_SETTLEMENT =5;
	public static final byte INTEREST_TAX =6;
	public static final byte ORIGINAL_DEAL_REFUND =7;
	public static final byte ORIGINAL_DEAL =8;
}
