package com.hzfh.fmp.model.baseInfo;

import com.hzfh.api.baseInfo.model.CodeAgent;
import com.hzfh.fmp.facade.baseInfo.CodeAgentFacade;

public class CodeAgentModel {
  
    public static int getCode() {
        return CodeAgentFacade.add(new CodeAgent());
    }

   
}
