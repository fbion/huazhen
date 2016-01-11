package com.hzfh.fmp.controller.common;

/**
 * Created by paul on 14-12-25.
 */
public abstract class AjaxBaseAction extends BaseAction {

    private String id;
    private String errCode = "0000";
    private String errDesc = "";
    private String oper;

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrDesc() {
        return errDesc;
    }

    public void setErrDesc(String errDesc) {
        this.errDesc = errDesc;
    }
}
