package com.hzfh.fmp.model.sales;

import com.hzfh.api.baseInfo.model.DicData;
import com.hzfh.api.customer.model.CustomerCompany;
import com.hzfh.api.customer.model.query.CustomerCompanyCondition;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.sales.model.ApplyEmployee;
import com.hzfh.api.sales.model.query.ApplyEmployeeCondition;
import com.hzfh.fmp.facade.customer.CustomerCompanyFacade;
import com.hzfh.fmp.facade.sales.ApplyEmployeeFacade;
import com.hzfh.fmp.model.baseInfo.DicDataModel;
import com.hzfh.fmp.model.common.properties.DictionaryHelper;
import com.hzfh.fmp.model.customer.view.CustomerCompanyView;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.sales.view.ApplyEmployeeView;
import com.hzframework.contract.PagedList;

import java.util.List;

import net.hydromatic.linq4j.Linq4j;
import net.hydromatic.linq4j.function.EqualityComparer;
import net.hydromatic.linq4j.function.Function1;
import net.hydromatic.linq4j.function.Function2;

public class ApplyEmployeeModel {
    public static PagedList<ApplyEmployee> getPagingList(ApplyEmployeeCondition applyEmployeeCondition) {
        return ApplyEmployeeFacade.getPagingList(applyEmployeeCondition);
    }

    public static int add(ApplyEmployee applyEmployee) {
        return ApplyEmployeeFacade.add(applyEmployee);
    }

    public static int update(ApplyEmployee applyEmployee) {
        return ApplyEmployeeFacade.update(applyEmployee);
    }

    public static List<ApplyEmployee> getList() {
        return ApplyEmployeeFacade.getList();
    }

    public static ApplyEmployee getInfo(int id) {
        return ApplyEmployeeFacade.getInfo(id);
    }

	public static ApplyEmployee getInfoByAnoEno(ApplyEmployee applyEmployee) {
		// TODO Auto-generated method stub
		return ApplyEmployeeFacade.getInfoByAnoEno(applyEmployee);
	}
	//create by Zorro 2014/4/30
	public static List<ApplyEmployee> getListForExcel(ApplyEmployeeCondition applyEmployeeCondition) {
        return ApplyEmployeeFacade.getListForExcel(applyEmployeeCondition);
    }

	public static List<ApplyEmployee> getCustomerListForExcel(
			ApplyEmployeeCondition applyEmployeeCondition) {
		return ApplyEmployeeFacade.getCustomerListForExcel(applyEmployeeCondition);
	}
		



}
