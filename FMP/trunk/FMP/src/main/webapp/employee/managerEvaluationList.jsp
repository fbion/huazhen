<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="wrappSearch mt30">
            <h3></h3>
            <div class="wrappSearchContent">
                姓名:<input type="text" id="txtName"/>
                公司：<select id="selectCompany"></select>
                部门：
                <%--<select id="selectDepartment"></select>--%>
                <input id="employeeSel" type="text" value="" class="w80"/>
                <input type="text" id="selectDepartment" style="display: none"/>
                审核状态：<select id="activitiStatus"><option value="" selected="selected">全部</option><option value="0">未通过</option><option value="1">通过</option></select>
                创建时间：<select id="year"></select>年<span id="showMonth" hidden="hidden"><select id="month"></select>月</span>
                <input id="btnSearch" type="button" value="查询" class="btn_style"/>
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
