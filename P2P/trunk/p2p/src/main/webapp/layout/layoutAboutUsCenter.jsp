<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="m" uri="/hz-tags"%>

<m:ContentPage materPageId="layout">
	<m:Content contentPlaceHolderId="center">
		<div class="main wrapp pb30">
		 <h3 class="contCrumbs wrapp">
	    	<a href="${homeUrl}">首页</a>><a href="${aboutCompanyUrl}">关于我们</a>><m:ContentPlaceHolder id="aboutUsNavigation" />
	    </h3>
		<m:ContentPlaceHolder id="helpCenterBanner" />
		<div class="contents wrapp">
			<div class="aboutUs_tit">
		        <a href="${aboutCompanyUrl}" id="aboutCompany">公司简介</a>
		        <a href="${enterpriseCultureUrl}" id="enterpriseCulture">企业文化</a>
		        <a href="${contactUsUrl}" id="contactUs" >联系我们</a>
		        <a href="${storeUrl}" id="store" >旗下门店</a>
		        <a href="${joinUsUrl}" id="joinUs" >加入我们</a>
		        <a href="${bulletinUrl}" id="bulletin">网站公告</a>
		        <a href="${mediaReportsUrl}" id="mediaReports">媒体报道</a>
		    </div>
			<m:ContentPlaceHolder id="helpCenter" />
			</div>
			</div>
	</m:Content>
</m:ContentPage>
