<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="m" uri="/hz-tags"%>

<m:ContentPage materPageId="layout">
	<m:Content contentPlaceHolderId="center">
		<div class="main wrapp pb30">
		<h3 class="contCrumbs wrapp">
	    	<a href="${homeUrl}">首页</a>><a href="${securityAssuranceUrl}">安全保障</a>><m:ContentPlaceHolder id="productFeatureNavigation" />
	    </h3>
			<div class="proFeature wrapp">
				<div class="proFeature_tit">
		        	<a href="${productFeaturesUrl}" id="productFeatures">理财产品</a>
		            <a href="${productSuperiorityUrl}" id="productSuperiority">产品优势</a>
		            <a href="${securityAssuranceUrl}" id="securityAssurance">安全保障</a>
		            <a href="${lawsRegulationsUrl}" id="lawsRegulations">法规政策</a>
		            <a href="${serviceContractUrl}" id="serviceContract">服务协议</a>
		        </div>
   			<m:ContentPlaceHolder id="productFeatureCenter" />
   			</div>
   			</div>
	</m:Content>
</m:ContentPage>
