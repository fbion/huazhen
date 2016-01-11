package com.hzfh.fmp.model.common.helper;

import com.hzfh.fmp.model.baseInfo.*;

public class CodeHelper {

    public static String getCode(String codeType, String codeAdd) {
        String x = "";
        int y = 0;
        switch (codeType) {
            case "codeAdviser":
                y = CodeAdviserModel.getCode();
                x = getCodeByY(y, codeAdd, 6);
                break;
            case "codeAgent":
                y = CodeAgentModel.getCode();
                x = getCodeByY(y, codeAdd, 6);
                break;
            case "codeCompany":
                y = CodeCompanyModel.getCode();
                x = getCodeByY(y, codeAdd, 4);
                break;
            case "codeCus1":
                y = CodeCus1Model.getCode();
                x = getCodeByY(y, codeAdd, 8);
                break;
            case "codeCus2":
                y = CodeCus2Model.getCode();
                x = getCodeByY(y, codeAdd, 8);
                break;
            case "codeDept":
                y = CodeDeptModel.getCode();
                x = getCodeByY(y, codeAdd, 4);
                break;
            case "codeEmp":
                y = CodeEmpModel.getCode();
                x = getCodeByY(y, codeAdd, 6);
                break;
            case "codeExpense":
                y = CodeExpenseModel.getCode();
                x = getCodeByY(y, codeAdd, 8);
                break;
            case "codeIncome":
                y = CodeIncomeModel.getCode();
                x = getCodeByY(y, codeAdd, 8);
                break;
            case "codeIssue":
                y = CodeIssueModel.getCode();
                x = getCodeByY(y, codeAdd, 4);
                break;
            case "codeNeed1":
                y = CodeNeed1Model.getCode();
                x = getCodeByY(y, codeAdd, 8);
                break;
            case "codeNeed2":
                y = CodeNeed2Model.getCode();
                x = getCodeByY(y, codeAdd, 8);
                break;
            case "codePact":
                y = CodePactModel.getCode();
                x = getCodeByY(y, codeAdd, 8);
                break;
            case "codeProduct1":
                y = CodeProduct1Model.getCode();
                x = getCodeByY(y, codeAdd, 4);
                break;
            case "codeProduct2":
                y = CodeProduct2Model.getCode();
                x = getCodeByY(y, codeAdd, 4);
                break;
            case "codeProduct3":
                y = CodeProduct3Model.getCode();
                x = getCodeByY(y, codeAdd, 4);
                break;
            case "codeProduct4":
                y = CodeProduct4Model.getCode();
                x = getCodeByY(y, codeAdd, 4);
                break;
            case "codeSales":
                y = CodeSalesModel.getCode();
                x = getCodeByY(y, codeAdd, 8);
                break;
            default:
                x = "";
                break;
        }
        return x;
    }

    public static String getCodeByY(int y, String codeAdd, int length) {
        return codeAdd + String.format("%0" + length + "d", y);
    }

}
