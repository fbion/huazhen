<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layoutAboutUsCenter">
	<m:Content contentPlaceHolderId="aboutUsNavigation">联系我们</m:Content>
	<m:Content contentPlaceHolderId="helpCenterBanner" >
	<div class="ad p2pBanner1 cor2" value="1"></div>
	</m:Content>
    <m:Content contentPlaceHolderId="helpCenter">
    	<div class="aboutUs_cont">
        <div class="contactUs">
        	<h4>
            	<span>CONTACT US</span>
            	<em>联系我们</em>
            </h4>
            <p class="mt20 iconMap"></p>
            <dl class="mt50 pt20">
            	<dt class="pb20">
                	<i class="icon1 pl15"></i>联系电话
                </dt>
                <dd>全国服务热线：400-0340-668</dd>
                <dd>人工服务时间：9：00-18：00</dd>
            </dl>
            <dl class="mt50">
            	<dt class="pb20">
                	<i class="icon2 pl15"></i>微信扫一扫
                </dt>
                <dd>微信公众号："现房宝"，7＊24小时自助服务，随时随地查询</dd>
            </dl>
            <em class="wx mt5"></em>
        </div>
        
    </div>
    <input type="hidden" id="pageAlias" value="${pageAlias}" class="pageAlias">
	</m:Content>
</m:ContentPage>