package com.hzfh.fmp.model.baseInfo;

import com.hzfh.api.baseInfo.model.CodeExpense;
import com.hzfh.fmp.facade.baseInfo.CodeExpenseFacade;

public class CodeExpenseModel {
  
    public static int getCode() {
        return CodeExpenseFacade.add(new CodeExpense());
    }


}
