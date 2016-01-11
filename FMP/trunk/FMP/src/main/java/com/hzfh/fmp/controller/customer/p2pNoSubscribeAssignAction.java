package com.hzfh.fmp.controller.customer;

import com.hzfh.api.employee.model.Employee;
import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.customer.P2pCustomerModel;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzframework.helper.StringHelper;

public class p2pNoSubscribeAssignAction extends CommonAction {
    private String realName;
    private String p2pCustomer;
    private String deptNo;
    private String errCode;

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }


    private String empNo;

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getP2pCustomer() {
        return p2pCustomer;
    }

    public void setP2pCustomer(String p2pCustomer) {
        this.p2pCustomer = p2pCustomer;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.p2pNoSubscribeAssign);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        return SUCCESS;
    }
    
    public String ajaxAssignNoEmpNo(){
        int p2pCustomerNo = Integer.valueOf(this.p2pCustomer);
        if(StringHelper.isNullOrEmpty(this.deptNo)){
            this.setErrCode("请重新指定理财经理");
            return SUCCESS;
        }
        int deptNo = Integer.valueOf(this.deptNo);
        if(StringHelper.isNullOrEmpty(this.empNo)){
            this.setErrCode("请重新指定理财经理");
            return SUCCESS;
        }
        Employee employee = EmployeeModel.getInfo(Integer.valueOf(this.empNo));
        int userNo = employee.getUserNo();
        if(P2pCustomerModel.updateDeptNoAndEmpNoById(p2pCustomerNo,deptNo,userNo) <= 0){
            this.setErrCode("请重新指定理财经理");
            return SUCCESS;
        }
        return SUCCESS;

    }
}
