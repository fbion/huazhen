package com.hzfh.fmp.model.baseInfo;

import com.hzfh.api.baseInfo.model.CodeIssue;
import com.hzfh.fmp.facade.baseInfo.CodeIssueFacade;

public class CodeIssueModel {
 

	public static int getCode() {
        return CodeIssueFacade.add(new CodeIssue());
    }

   
}
