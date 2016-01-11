package com.hzfh.fmp.model.baseInfo;

import com.hzfh.api.baseInfo.model.CodeNeed1;
import com.hzfh.fmp.facade.baseInfo.CodeNeed1Facade;

public class CodeNeed1Model {

    public static int getCode() {
    	
        return CodeNeed1Facade.add(new CodeNeed1());
    }

   
}
