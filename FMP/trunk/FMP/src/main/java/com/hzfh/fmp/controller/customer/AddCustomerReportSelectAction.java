package com.hzfh.fmp.controller.customer;

import com.hzfh.api.employee.model.Department;
import com.hzfh.api.report.model.AddCustomerReport;
import com.hzfh.api.report.model.query.AddCustomerReportCondition;
import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.customer.AddCustomerReportModel;
import com.hzfh.fmp.model.employee.DepartmentModel;
import com.hzframework.helper.DateHelper;
import com.hzframework.helper.StringHelper;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class AddCustomerReportSelectAction extends CommonAction {



    @Override
    public String execute() throws Exception{
        return SUCCESS;
    }
}
