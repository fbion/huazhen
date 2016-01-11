<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layoutProductFeatureCenter">
	<m:Content contentPlaceHolderId="productFeatureNavigation">法律法规</m:Content>
    <m:Content contentPlaceHolderId="productFeatureCenter">
        <div class="proFeature_cont">
        	<p class="icon4"></p>
            <ul class="mt30">
                <li>
                    <a href="${lawsRegulationsContentUrl}?pageType=lawsRegulationsContent" >中华人民共和国合同法</a>
                    <span>2015-06-18 13:18:39</span>
                </li>
                <li>
                    <a href="${lawsRegulationsContentUrl}?pageType=lawsRegulationsContent1" >中华人民共和国信托法</a>
                    <span>2015-06-18 13:20:45</span>
                </li>
                <li>
                    <a href="${lawsRegulationsContentUrl}?pageType=lawsRegulationsContent2">中华人民共和国证券法</a>
<%--                     <a href="${lawsRegulationsContentUrl}?pageType=lawsRegulationsContent2"  title="中国人民银行、工业和信息化部、公安部、财政部、工商总局、法制办、银监会、证监会、保监会、国家互联网信息办公室关于促进互联网金融健康发展的指导意见.">中国人民银行、工业和信息化部、公安部、财政部、工商总局...</a> --%>
                    <span>2015-06-18 16:38:19</span>
                </li>
            </ul>
        </div>
        <input type="hidden" id="pageAlias" value="${pageAlias}" class="pageAlias">
	</m:Content>
</m:ContentPage>