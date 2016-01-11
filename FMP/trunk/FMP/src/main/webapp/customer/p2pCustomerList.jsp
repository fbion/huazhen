<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="m" uri="/hz-tags"%>

<m:ContentPage materPageId="layout">
	<m:Content contentPlaceHolderId="center">
		<div class="wrappSearch mt30">
			<h3></h3>
			<div class="wrappSearchContent">
				用户名：<input id="p2pCustomerName" type="text" /> 
				门店：<select id="byDeptNo" ></select>
				<div style="display: none;">理财经理：<select id="byEmpNo" ></select></div>
				理财经理：
                <input id="employeeSel" type="text" value="" class="w80"/>
                <input id="selectEmpNo" type="text" style="display:none"/>
				<input id="btnSearch" type="button"value="查询" class="btn_style" />
			</div>
		</div>
		<div class="pic mt20">
			<table id="gridTable" class="gridTable">
			</table>
			<div id="gridPager" class="gridPager"></div>
		</div>
		${pageVar}
	</m:Content>
</m:ContentPage>
