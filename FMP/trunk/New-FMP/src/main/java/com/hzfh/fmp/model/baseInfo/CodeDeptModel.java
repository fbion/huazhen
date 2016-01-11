package com.hzfh.fmp.model.baseInfo;

import com.hzfh.api.baseInfo.model.CodeDept;
import com.hzfh.fmp.facade.baseInfo.CodeDeptFacade;

public class CodeDeptModel {
   
    public static int getCode() {
        return CodeDeptFacade.add(new CodeDept());
    }

}
