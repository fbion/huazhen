package com.hzfh.fmp.model.baseInfo;

import com.hzfh.api.baseInfo.model.CodeCus1;
import com.hzfh.fmp.facade.baseInfo.CodeCus1Facade;


public class CodeCus1Model {
    

    public static int getCode() {
        return CodeCus1Facade.add(new CodeCus1());
    }

   
}
