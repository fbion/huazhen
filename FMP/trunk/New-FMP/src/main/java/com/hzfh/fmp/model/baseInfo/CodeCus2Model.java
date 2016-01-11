package com.hzfh.fmp.model.baseInfo;

import com.hzfh.api.baseInfo.model.CodeCus2;
import com.hzfh.fmp.facade.baseInfo.CodeCus2Facade;

public class CodeCus2Model {

	
    public static int getCode() {
    	
        return CodeCus2Facade.add(new CodeCus2());
    }
}
