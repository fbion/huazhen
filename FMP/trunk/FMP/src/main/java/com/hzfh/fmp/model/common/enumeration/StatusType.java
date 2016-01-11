package com.hzfh.fmp.model.common.enumeration;

/**
 * Created by Administrator on 2015/3/17.
 */
public class StatusType {
    public static final byte AGENT_TYPE_STORE = (byte) 4; // 代理商类型门店
    public static final byte ENABLED = (byte) 1;  // 省市区可用
    public static final int ISASSIGNEMP = -1;   //已经指定过理财经理
    public static final int NOISASSIGNEMP = 0;  //没指定过理财经理

    public static final byte WAITPAYMENT=1;//待还款
    public static final byte CHECKPAYMENT = 2;//还款审核中
    public static final byte FINSHPAYMENT = 3;//已还款
    public static final byte CANCLEPAYMENT = 4;//取消还款



    public static final int CUSTOMERFOLLOW_RESULTSTATUS=41;//客户跟踪类型

    public static final byte CUSTOMER_PERSONAL_TYPE=1;//自然人客户类型
    public static final byte CUSTOMER_COMPANY_TYPE=2;//法人客户类型
    public static final byte P2PCUSTOMER_COMPANY_TYPE = 1;//网站企业用户
    
    public static final byte AGENT_ADVISER_TYPE=2;//兼职投顾类型
    public static final byte AGENT_BUSINESS_TYPE=1;//销售代理商类型


    public static final byte CHECK_DEFAULT = 0;//员工信息默认值（信息可修改）
    public static final byte CHECK_WAIT = 1;//员工信息待审核
    public static final byte CHECK_SUCCESS = 2;//员工信息审核通过


    public static final byte A_CUSTOMERPERSONAL = 4; //A类客户
    public static final byte B_CUSTOMERPERSONAL = 3; //B类客户
    public static final byte C_CUSTOMERPERSONAL = 2; //C类客户
    public static final byte D_CUSTOMERPERSONAL = 1; //D类客户



}
