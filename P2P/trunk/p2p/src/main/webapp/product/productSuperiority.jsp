<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layoutProductFeatureCenter">
	<m:Content contentPlaceHolderId="productFeatureNavigation">产品优势</m:Content>
    <m:Content contentPlaceHolderId="productFeatureCenter">
       <!-- <div class="proFeature_cont">
       产品优势
        </div>-->
        <div class="proFeature_cont">
        	<p class="icon2"></p>
            <div class="mt50 ml30">
                <span>1、国内首家与房地产商强强联合，联合推出理财新品“现房宝”；</span>
                <span>2、专业财富管理团队，专属理财私人服务，全面严格贷前、贷后风控审核；</span>
                <span>3、投资门槛低，投资收益略高于市场同类产品；</span>
                <span>4、投资资产多重保护，债权透明，一一对应。</span>
			</div>
        </div>
        <input type="hidden" id="pageAlias" value="${pageAlias}" class="pageAlias">
	</m:Content>
</m:ContentPage>