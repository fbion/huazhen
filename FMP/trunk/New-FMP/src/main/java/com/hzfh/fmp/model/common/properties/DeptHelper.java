package com.hzfh.fmp.model.common.properties;

import com.hzframework.helper.PropertyHelper;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by paul on 15-1-22.
 */
public class DeptHelper {
	//总裁办
    public static final int DEPT_PRESIDENT = Integer.parseInt(PropertyHelper.getContextProperty("department.president").toString());
    //人事部门
    public static final int DEPT_ADMINISTRATION = Integer.parseInt(PropertyHelper.getContextProperty("department.administration").toString());
    //财务部
    public static final int DEPT_FINANCE = Integer.parseInt(PropertyHelper.getContextProperty("department.finance").toString());
    //审核门店打款的财务
    public static final int DEPT_FINANCE_SHOP = Integer.parseInt(PropertyHelper.getContextProperty("department.finance.shop").toString());
    //运营
    public static final int DEPT_OPERATOR = Integer.parseInt(PropertyHelper.getContextProperty("department.operator").toString());
    //门店运营
    public static final int DEPT_SHOPOPERATOR = Integer.parseInt(PropertyHelper.getContextProperty("department.shop.operator").toString());
    //财富金融中心
    public static final int DEPT_SALES = Integer.parseInt(PropertyHelper.getContextProperty("department.sales").toString());
    //产品部
    public static final int DEPT_PRODUCT = Integer.parseInt(PropertyHelper.getContextProperty("department.product").toString());
    //市场部
    public static final int DEPT_MARKET = Integer.parseInt(PropertyHelper.getContextProperty("department.market").toString());
    //开发部
    public static final int DEPT_DEV = Integer.parseInt(PropertyHelper.getContextProperty("department.dev").toString());
    //风控部
    public static final int DEPT_RISK_CONTROL = Integer.parseInt(PropertyHelper.getContextProperty("department.riskControl").toString());
    //销售 渠道  要废弃
    public static final List<Integer> DEPT_SALES_CHANNEL = DeptHelper.toList(PropertyHelper.getContextProperty("department.sales.channel").toString().split(","));
    //销售 直销 要废弃
    public static final int DEPT_SALES_DIRECT1 = Integer.parseInt(PropertyHelper.getContextProperty("department.sales.direct").toString());
    public static final List<Integer> DEPT_SALES_DIRECT = DeptHelper.toList(PropertyHelper.getContextProperty("department.sales.direct").toString().split(","));
    //销售 门店  create by Zorro 2015/4/21
    public static final int DEPT_SALES_SHOP = Integer.parseInt(PropertyHelper.getContextProperty("department.sales.shop").toString()); 



    public static List<Integer> toList(String[] strs) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < strs.length; i++) {
            list.add(Integer.parseInt(strs[i]));
        }
        return list;
    }
    
    public static final int TYEP_CHANNEL = Integer.parseInt(PropertyHelper.getContextProperty("type.channel").toString());
    public static final int TYEP_DIRECT = Integer.parseInt(PropertyHelper.getContextProperty("type.direct").toString());
    public static final int TYEP_DEPT = Integer.parseInt(PropertyHelper.getContextProperty("type.dept").toString());
    public static final int TYEP_SHOP = Integer.parseInt(PropertyHelper.getContextProperty("type.shop").toString());

}
