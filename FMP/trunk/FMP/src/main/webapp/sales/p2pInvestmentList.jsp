<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="m" uri="/hz-tags"%>

<m:ContentPage materPageId="layout">
	<m:Content contentPlaceHolderId="center">
		<div class="wrappSearch mt30">
			<h3></h3>
			<div class="wrappSearchContent">
			    产品名称：<select id="byP2pProductNo"></select>
				用户名称：<select id="byP2pCustomerNo"></select> 
				门店：<select id="byDeptNo"></select>
				理财经理：<select id="byEmpNo"></select>
				状态：<select id="byStatus"></select>
				
				<input id="btnSearch"
					type="button" value="查询" class="btn_style" />
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
