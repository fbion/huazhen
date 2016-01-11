package com.hzfh.fmp.model.baseInfo;

import com.hzfh.api.baseInfo.model.CodeEmp;
import com.hzfh.fmp.facade.baseInfo.CodeEmpFacade;

public class CodeEmpModel {

    public static int getCode() {
        return CodeEmpFacade.add(new CodeEmp());
    }

}
