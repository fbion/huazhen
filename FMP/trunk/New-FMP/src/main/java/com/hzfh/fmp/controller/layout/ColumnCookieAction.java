package com.hzfh.fmp.controller.layout;

import com.hzfh.fmp.controller.common.AjaxBaseAction;
import com.hzfh.fmp.model.common.state.StateValues;
import com.hzframework.helper.StringHelper;

/**
 * Created by 磊 on 2015/12/3.
 */
public class ColumnCookieAction extends AjaxBaseAction {
    public String key;
    public String value;


    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String setColumnCookie(){
        if(StringHelper.isNullOrEmpty(this.key) || StringHelper.isNullOrEmpty(this.value)){
            this.setErrCode("failed");
            this.setErrDesc("no key");
            return SUCCESS;
        }
        StateValues.setColumnProperty(this.key,this.value);
        return SUCCESS;
    }

    public String getColumnCookie(){
        if(StringHelper.isNullOrEmpty(this.key)){
            this.setErrCode("failed");
            this.setErrDesc("no key");
            return SUCCESS;
        }
        this.value = StateValues.getColumnProperty(this.key);
        return SUCCESS;
    }
}
