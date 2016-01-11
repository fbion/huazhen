package com.hzfh.fmp.model.common.properties;

import com.hzframework.helper.PropertyHelper;

public class DictionaryHelper {

    //type
    public static final int DIC_TYPE_SEX = Integer.parseInt(PropertyHelper.getContextProperty("type.sexType").toString());
    public static final int DIC_TYPE_MARRY = Integer.parseInt(PropertyHelper.getContextProperty("type.marryType").toString());
    public static final int DIC_TYPE_RELATION = Integer.parseInt(PropertyHelper.getContextProperty("type.relationType").toString());
    public static final int DIC_TYPE_RISK = Integer.parseInt(PropertyHelper.getContextProperty("type.riskType").toString());
    public static final int DIC_TYPE_IMPORTANT = Integer.parseInt(PropertyHelper.getContextProperty("type.importanceType").toString());
    public static final int DIC_TYPE_PRODUCT_TYPE = Integer.parseInt(PropertyHelper.getContextProperty("type.productType").toString());
    public static final int DIC_TYPE_PEOPLE_TYPE = Integer.parseInt(PropertyHelper.getContextProperty("type.peropleType").toString());
    public static final int DIC_TYPE_ORDER_TYPE = Integer.parseInt(PropertyHelper.getContextProperty("type.orderType").toString());
    public static final int DIC_TYPE_DECISION_TYPE = Integer.parseInt(PropertyHelper.getContextProperty("type.decisionType").toString());
    public static final int DIC_TYPE_CUSTOMER_TYPE = Integer.parseInt(PropertyHelper.getContextProperty("type.customerType").toString());
    //type.departmentType
    public static final int DIC_TYPE_DEPT_TYPE = Integer.parseInt(PropertyHelper.getContextProperty("type.departmentType").toString());
    

	//customer and agent
    public static final int DIC_CUSTOMERPERSONAL = Integer.parseInt(PropertyHelper.getContextProperty("customer.customerPersonal").toString());
    public static final int DIC_CUSTOMERCOMPANY = Integer.parseInt(PropertyHelper.getContextProperty("customer.customerCompany").toString());
    public static final int DIC_AgentBusiness = Integer.parseInt(PropertyHelper.getContextProperty("customer.AgentBusiness").toString());
    public static final int DIC_AgentAdviser = Integer.parseInt(PropertyHelper.getContextProperty("customer.AgentAdviser").toString());
    public static final int DIC_FOLLOW_TYPE = Integer.parseInt(PropertyHelper.getContextProperty("type.followType").toString());
    public static final int DIC_CUSTOMER_SOURCE_TYPE = Integer.parseInt(PropertyHelper.getContextProperty("type.sourceType").toString());
    

    //employee status 在职状态
    public static final int DIC_EMPLOYEE_STATUS_DUTY = Integer.parseInt(PropertyHelper.getContextProperty("employee.status.duty").toString());
    public static final int DIC_EMPLOYEE_STATUS_DIMISSION = Integer.parseInt(PropertyHelper.getContextProperty("employee.status.dimission").toString());
    public static final int DIC_EMPLOYEE_STATUS_RETIRE = Integer.parseInt(PropertyHelper.getContextProperty("employee.status.retire").toString());
    public static final int DIC_EMPLOYEE_STATUS_INTERNSHIP = Integer.parseInt(PropertyHelper.getContextProperty("employee.status.internship").toString());
    public static final int DIC_EMPLOYEE_STATUS_PROBATION = Integer.parseInt(PropertyHelper.getContextProperty("employee.status.probation").toString());
    
    
}
