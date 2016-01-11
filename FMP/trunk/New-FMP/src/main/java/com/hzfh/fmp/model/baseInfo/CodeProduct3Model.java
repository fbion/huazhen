package com.hzfh.fmp.model.baseInfo;

import com.hzfh.api.baseInfo.model.CodeProduct3;
import com.hzfh.fmp.facade.baseInfo.CodeProduct3Facade;

public class CodeProduct3Model {

    public static int getCode() {
        return CodeProduct3Facade.add(new CodeProduct3());
    }

}
