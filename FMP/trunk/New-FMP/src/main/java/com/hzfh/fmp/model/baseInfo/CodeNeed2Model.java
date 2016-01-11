package com.hzfh.fmp.model.baseInfo;

import com.hzfh.api.baseInfo.model.CodeNeed2;
import com.hzfh.fmp.facade.baseInfo.CodeNeed2Facade;

public class CodeNeed2Model {

    public static int getCode() {
        return CodeNeed2Facade.add(new CodeNeed2());
    }

}
