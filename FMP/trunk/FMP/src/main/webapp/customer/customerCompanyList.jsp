<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="wrappSearch mt30">
            <h3></h3>
            <div class="wrappSearchContent">
                法人客户: <input type="text" id="txtName">
                关系等级: <select id="selectRelationLevel"></select>
                风险偏好: <select id="selectRiskHobby"></select>
                部门：

                <input id="departmentSel" type="text" value="" class="w80"/>
                <input id="selectDepartment" type="text" style="display:none"/>
                负责人：
                <input id="employeeSel" type="text" value="" class="w80"/>
                <input id="selectEmpNo" type="text" style="display:none"/>
                时间下限：<input id="findTimeDown" type="text"/>
                时间上限：<input id="findTimeUp" type="text"/>
                <input id="btnSearch" type="button" value="查询" class="btn_style"/>
                <s:if test="showExcelButton">
                    <input type="button" id="btnExcel" value="导出Excel" class="btn_style"/>
                </s:if>
            </div>
        </div>
        <p class="mt50">
            <s:if test="showAddButton">
                <input type="button" id="btnAdd" value="新建" class="btn_style"/>
            </s:if>
        </p>

        <div class="pic mt20">
            <table id="gridTable" class="gridTable">
            </table>
            <div id="gridPager" class="gridPager">
            </div>
        </div>

        ${pageVar}
    </m:Content>
</m:ContentPage>
