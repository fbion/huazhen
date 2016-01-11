package com.hzfh.fmp.model.baseInfo;

import com.hzfh.api.baseInfo.model.CodeProduct2;
import com.hzfh.fmp.facade.baseInfo.CodeProduct2Facade;

public class CodeProduct2Model {
   

    public static int getCode() {
        return CodeProduct2Facade.add(new CodeProduct2());
    }

   
}
