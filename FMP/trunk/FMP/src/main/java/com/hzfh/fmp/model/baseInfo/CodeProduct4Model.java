package com.hzfh.fmp.model.baseInfo;

import com.hzfh.api.baseInfo.model.CodeProduct4;
import com.hzfh.fmp.facade.baseInfo.CodeProduct4Facade;

public class CodeProduct4Model {
   
    public static int getCode() {
        return CodeProduct4Facade.add(new CodeProduct4());
    }

}
