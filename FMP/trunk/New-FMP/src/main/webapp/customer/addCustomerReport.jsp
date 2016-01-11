<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
<m:Content contentPlaceHolderId="center">

    <div class="wrappSearchContent">
        月报表：
        <input id="monthTime" />
        <input type="button" value="查询" id="monthButton" class="btn_style mr30"/>
        周报表：
        <input id="weekTime" />

        <input type="button" value="查询" id="weekButton" class="btn_style mr30"/>
        日报表：
        <input id="dayTime" />
        <input type="button" value="查询" id="dayButton" class="btn_style"/>


        <input type="button" value="折叠表格" id="collapse" class="btn_style"/>
        <input type="button" value="展开表格" id="expand" class="btn_style"/>
    </div>

    <h5 class="tc mt30 f18 pb30">
        <span id="time"></span>
        新增客户报表
    </h5>
    <table id="tt" style="width:1032px" ></table>
    ${pageVar}
</m:Content>
</m:ContentPage>