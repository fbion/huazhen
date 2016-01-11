package com.hzfh.fmp.model.baseInfo;

import com.hzfh.api.baseInfo.model.CodePact;
import com.hzfh.fmp.facade.baseInfo.CodePactFacade;

public class CodePactModel {
  

    public static int getCode() {
        return CodePactFacade.add(new CodePact());
    }


}
