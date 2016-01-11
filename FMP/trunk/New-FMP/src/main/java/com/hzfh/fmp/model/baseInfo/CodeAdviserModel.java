package com.hzfh.fmp.model.baseInfo;

import com.hzfh.api.baseInfo.model.CodeAdviser;
import com.hzfh.fmp.facade.baseInfo.CodeAdviserFacade;

public class CodeAdviserModel {
   
       public static int getCode() {
    	   return CodeAdviserFacade.add(new CodeAdviser());
    }
}
