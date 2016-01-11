<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layoutAboutUsCenter">
	<m:Content contentPlaceHolderId="aboutUsNavigation">旗下门店</m:Content>
	<m:Content contentPlaceHolderId="helpCenterBanner" >
	<div class="ad p2pBanner1 cor2" value="1"></div>
	</m:Content>
    <m:Content contentPlaceHolderId="helpCenter">
    	 <div class="aboutUs_cont">
        <div class="contactUs">
        	<h4>
            	<span>STORE</span>
            	<em>旗下门店</em>
            </h4>
            <div class="mt10 fw none">门店名称：${info.name}</div>
            <img src="${info.departmentImagePath}" width="720"  height="352" class="mt10 none">
            <div class="mt20 fw">门店位置：${info.address}</div>
           <iframe src="${mapUrl}" width="697" height="550" frameborder="0" scrolling="no" class="mt20"></iframe>
           <%-- <img src="${info.locationImagePath}" width="720"  height="352"> --%>
            <dl class="mt50 pt20">
            	<dt class="pb20">
                	<i class="icon1 pl15"></i>联系电话
                </dt>
                <dd>门店联系电话：${info.telephone}</dd>
               <!--  <dd>人工服务时间：7*24 小时</dd> -->
            </dl>
        </div>
        
    </div>
    <input type="hidden" id="pageAlias" value="${pageAlias}" class="pageAlias">
	</m:Content>
</m:ContentPage>