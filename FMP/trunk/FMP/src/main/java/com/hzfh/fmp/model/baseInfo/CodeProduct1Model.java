package com.hzfh.fmp.model.baseInfo;

import com.hzfh.api.baseInfo.model.CodeProduct1;
import com.hzfh.fmp.facade.baseInfo.CodeProduct1Facade;

public class CodeProduct1Model {

    public static int getCode() {
        return CodeProduct1Facade.add(new CodeProduct1());
    }

 
}
