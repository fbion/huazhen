<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="m" uri="/hz-tags"%>

<m:ContentPage materPageId="layout">
	<m:Content contentPlaceHolderId="center">
	<div class="main wrapp pb30">
	    <h3 class="contCrumbs wrapp">
	    	<a href="${homeUrl}">首页</a>><a href="${helpCenterUrl}">帮助中心</a>><m:ContentPlaceHolder id="helpCenterNavigation" />
	    </h3>
		<m:ContentPlaceHolder id="helpCenterBanner" />
				<div class="helpCenter wrapp">
    				<div class="helpCenter_tit">
			        	<ul>
			            	<li>
			                	<a href="${helpCenterUrl}" class="mt30" id="helpCenter">注册登录</a>
			                </li>
			                <!--<li>
			                	<a href="${popularizeUrl}" id="popularize">如何推广</a>
			                </li>-->
			                <li>
			                	<a href="${reservationHelpUrl}" id="reservationHelp">预约投资</a>
			                </li>
			                <!--<li>
			                	<a href="${financingUrl}" id="financing">如何融资</a>
			                </li>-->
			                <li>
			                	<a href="${accountCentralUrl}" id="accountCentral">账户中心</a>
			                </li>
			                <li>
			                	<a href="${knowledgeForumUrl}" id="knowledgeForum">知识讲堂</a>
			                </li>
			            </ul>
			            
			        </div>
    			<m:ContentPlaceHolder id="helpCenter" />
    			</div>
    			</div>
	</m:Content>
</m:ContentPage>
