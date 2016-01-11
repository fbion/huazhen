<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="wrappSearch mt30">
            <h3></h3>
            <div class="wrappSearchContent">
                类型:<select id="byType"></select>
                状态：<select type="text" id="byStatus"></select>

                部门:<select id="byDept"></select>
                姓名:<select id="byName"></select>
                请假开始时间：<select type="text" id="byYear"></select> 年
                <select type="text" id="byMonth"></select> 月
                <input id="btnSearch" type="button" value="查询" class="btn_style"/>

                <input id="btnExcel" type="button" value="导出Excel" class="btn_style"/>
            </div>
        </div>
        <p class="mt50"> 
			<s:if test="showAddButton">
                <input type="button" id="btnAdd" value="新建" class="btn_style"/>
            </s:if></p>
        <div class="pic mt20">
            <table id="gridTable" class="gridTable">
            </table>
            <div id="gridPager" class="gridPager">
            </div>
        </div>
        ${pageVar}
    </m:Content>
</m:ContentPage>
