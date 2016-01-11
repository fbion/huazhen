package com.hzfh.fmp.model.baseInfo;

import com.hzfh.api.baseInfo.model.CodeIncome;
import com.hzfh.fmp.facade.baseInfo.CodeIncomeFacade;

public class CodeIncomeModel {
 

    public static int getCode() {
        return CodeIncomeFacade.add(new CodeIncome());
    }

 
}
