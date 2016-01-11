package com.hzfh.fmp.controller.sales;

import com.hzfh.api.employee.model.Employee;
import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.customer.P2pCustomerModel;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.sales.P2pSubscribeModel;
import com.hzframework.helper.StringHelper;

public class p2pSubscribeAssignAction extends CommonAction {
    private String realName;
    private String p2pCustomer;
    private String p2pSubscribe;
    private String deptNo;
    private String errCode;

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getP2pSubscribe() {
        return p2pSubscribe;
    }

    private String empNo;

    public void setP2pSubscribe(String p2pSubscribe) {
        this.p2pSubscribe = p2pSubscribe;
    }

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
        this.setPageAlias(PageAlias.p2pSubscribeAssign);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        return SUCCESS;
    }
    
    public String ajaxAssignEmpNo(){
        if (StringHelper.isNullOrEmpty(this.p2pSubscribe)){
            this.setErrCode("请重新指定理财经理");
            return SUCCESS;
        }
        int p2pSubscribeNo = Integer.valueOf(this.p2pSubscribe);
        if(StringHelper.isNullOrEmpty(this.p2pCustomer)){
            this.setErrCode("请重新指定理财经理");
            return SUCCESS;
        }
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
        if(P2pSubscribeModel.updateEmpNoByP2pCustomerNo(p2pCustomerNo,deptNo,userNo) <= 0){
            this.setErrCode("请重新指定理财经理");
            return SUCCESS;
        }
        if(P2pCustomerModel.updateDeptNoAndEmpNoById(p2pCustomerNo,deptNo,userNo) <= 0){
            this.setErrCode("请重新指定理财经理");
            return SUCCESS;
        }
        return SUCCESS;

    }
}
