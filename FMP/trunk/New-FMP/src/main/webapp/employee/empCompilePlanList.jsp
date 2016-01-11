<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>
<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="wrappSearch mt30">
            <h3></h3>
            <div class="wrappSearchContent">
                部门：<select id="byDept"></select>
                统计年份：<select id="byYear"></select>
                统计月份：<select id="byMonth"></select>
                <input id="btnSearch" type="button" value="查询" class="btn_style"/>
                <input id="btnExcel" type="button" value="导出Excel" class="btn_style" />
            </div>
        </div>

            <p class="mt50"></p>

        <div class="pic mt20">
            <table id="gridTable" class="gridTable">
            </table>
            <div id="gridPager" class="gridPager">
            </div>
        </div>
        ${pageVar}
    </m:Content>
</m:ContentPage>
