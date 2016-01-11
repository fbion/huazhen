package com.hzfh.api.payment.model.common.constant;

public class StatusCode {
	public static final int SUCCESS = 1;//成功
	public static final int Failure = 0;//失败
	
	
	public static final int Parameter_Format = 2;//xml参数格式错诨
	public static final int Sign_Verifi_Failed = 3;//签名验证失败
	public static final int Object_Nonexist  = 101;//引用了丌存在的对象（例如错诨的订单号）
	public static final int Business_Status_Error = 102;//业务状态丌正确
	public static final int Not_Performed  = 103;//由亍业务限制导致业务丌能执行
	public static final int RealName_Verifi_Failed = 104;//实名讣证失败
}
