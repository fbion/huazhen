<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layoutAboutUsCenter">
	<m:Content contentPlaceHolderId="aboutUsNavigation">加入我们</m:Content>
	<m:Content contentPlaceHolderId="helpCenterBanner" >
	<div class="ad p2pBanner1 cor2" value="1"></div>
	</m:Content>
	<m:Content contentPlaceHolderId="helpCenter">
	<div class="aboutUs_cont">
        <h4>
            <span>JOIN US</span>
            <em>加入我们</em>
        </h4>
        <ul class="mt30"><!-- target="_blank" -->
            <li>
                <a href="${joinUsContentUrl}?pageType=joinUsContent">金融产品研究员</a>
                <span>2015-08-13</span>
            </li>
            <li>
                <a href="${joinUsContentUrl}?pageType=joinUsContent1">产品经理</a>
                <span>2015-08-13</span>
            </li>
            <li>
                <a href="${joinUsContentUrl}?pageType=joinUsContent2" >产品总监</a>
                <span>2015-08-13</span>
            </li>
            <li>
                <a href="${joinUsContentUrl}?pageType=joinUsContent3">理财经理</a>
                <span>2015-08-13</span>
            </li>
            <li>
                <a href="${joinUsContentUrl}?pageType=joinUsContent4">高级理财经理</a>
                <span>2015-08-13</span>
            </li>
            <li>
                <a href="${joinUsContentUrl}?pageType=joinUsContent5">渠道经理</a>
                <span>2015-08-13</span>
            </li>
            <li>
                <a href="${joinUsContentUrl}?pageType=joinUsContent6">高级渠道经理</a>
                <span>2015-08-13</span>
            </li>
            <li>
                <a href="${joinUsContentUrl}?pageType=joinUsContent7">财富管理中心总监</a>
                <span>2015-08-13</span>
            </li>
            <li>
                <a href="${joinUsContentUrl}?pageType=joinUsContent8">销售总监</a>
                <span>2015-08-13</span>
            </li>
            <li>
                <a href="${joinUsContentUrl}?pageType=joinUsContent9">营业部经理</a>
                <span>2015-08-13</span>
            </li>
            <li>
                <a href="${joinUsContentUrl}?pageType=joinUsContent10">门店经理</a>
                <span>2015-08-13</span>
            </li>
            <li>
                <a href="${joinUsContentUrl}?pageType=joinUsContent11">理财经理&高级理财经理 </a>
                <span>2015-08-13</span>
            </li>
        </ul>
    </div>
    <input type="hidden" id="pageAlias" value="${pageAlias}" class="pageAlias">
	</m:Content>
</m:ContentPage>