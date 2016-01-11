package com.hzfh.fmp.model.baseInfo;

import com.hzfh.api.baseInfo.model.CodeSales;
import com.hzfh.fmp.facade.baseInfo.CodeSalesFacade;

public class CodeSalesModel {

    public static int getCode() {
        return CodeSalesFacade.add(new CodeSales());
    }

 
}
