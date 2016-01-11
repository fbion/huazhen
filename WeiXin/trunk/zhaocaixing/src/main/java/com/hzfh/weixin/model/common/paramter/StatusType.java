package com.hzfh.weixin.model.common.paramter;

/**
 * Created by Administrator on 2015/3/17.
 * 
 * Directly copied from the FMP by MengChong on 2015/07/22
 */
public class StatusType {
    /*public static final byte AGENT_TYPE_STORE = (byte) 4; // 代理商类型门店
    public static final byte ENABLED = (byte) 1;  // 省市区可用
    public static final int ISASSIGNEMP = -1;   //已经指定过理财经理
    public static final int NOISASSIGNEMP = 0;  //没指定过理财经理
*/
    public static final byte WAITPAYMENT=1;//待还款
    public static final byte CHECKPAYMENT = 2;//还款审核中
    public static final byte FINISHPAYMENT = 3;//已还款
    public static final byte CANCLEPAYMENT = 4;//取消还款


    public static final byte AUTHENTICATIONOK=3;//认购成功
    public static final byte PAYMENTING=6;//待收本金状态6

    //线上线下sales数据都展示
    public static final byte PAY_TYPE=-1;
    
    public static final byte PRODUCTTYPE=4;
    public static final byte RECHARGESTATE=37;//充值状态
    public static final byte WITHDRAWSTATE=38;//提现状态
   /* public static final int CUSTOMERFOLLOW_RESULTSTATUS=41;//客户跟踪类型

    public static final byte CUSTOMER_PERSONAL_TYPE=1;//自然人客户类型
    public static final byte CUSTOMER_COMPANY_TYPE=2;//法人客户类型




	
    public static final byte CHECK_DEFAULT = 0;//员工信息默认值（信息可修改）
    public static final byte CHECK_WAIT = 1;//员工信息待审核
    public static final byte CHECK_SUCCESS = 2;//员工信息审核通过
*/
    public static final byte BULLETINSTATE=47;//公告状态
	public static final int PAYMENTTYPE = 2;//付息方式
	public static final int PAYMENTTYPE_NUM = 45;//还款分期数
	
	/**
	 * 部门类型
	 */
	public static final byte IS_TEST =1 ;//是测试
	public static final byte IS_NO_TEST =0 ;//不是测试
	
	public static final int STORE = 1;//门店

	/**
	 * 员工类型
	 * 
	 */
	public static final int ON_THE_JOB_EMPLOYEES = 1;//在职员工股
	public static final int PROBATIONARY_EMPLOYEES = 4;//试用员工
	public static final int INTERNSHIP_EMPLOYEES = 5;//实习员工
	
	/**
	 * 
	 * 绑定银行卡
	 * 
	 */
	public static final int BIND_BANK_STATUS = 1;//绑定银行卡
	public static final int UN_BIND_BANK_STATUS = 0;//取消绑定银行卡
	
	public static final byte CUSTOMER_PERSONAL_TYPE=1;//自然人客户类型
	public static final byte CUSTOMER_COMPANY_TYPE=2;//法人客户类型
}
