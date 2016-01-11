<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="wrappSearch mt30">
            <h3></h3>
            <div class="wrappSearchContent">
			编号： <input id="byAssetId" type="text" class="w80"/>
			名称： <input id="byAssetName" type="text" class="w80"/>
			分类： <select id="byAssetType"></select>
			状态： <select id="byStatus"></select>
			存放位置： <select id="byLocation"></select>
			使用部门： 
			<select id="byDepartment"></select>
                <!-- <input id="byDeptNo" type="text" style="display:none"/> -->
			使用人：
			<select id="byUserNo"></select>
                <!-- <input type="text" id="byEmpNo" style="display: none"/> -->
                <input id="btnSearch" type="button" value="查询" class="btn_style"/>
            </div>
        </div>
        <p class="mt50 pl20"> 
			<s:if test="showAddButton">
                <input type="button" id="btnAdd" value="新建" class="btn_style"/>
            </s:if></p>
        <div class="pic mt20 pl20">
            <table id="gridTable" class="gridTable">
            </table>
            <div id="gridPager" class="gridPager">
            </div>
        </div>
    </m:Content>
</m:ContentPage>
