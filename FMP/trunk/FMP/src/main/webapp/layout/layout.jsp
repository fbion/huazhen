<%@ page import="com.hzfh.api.baseInfo.model.Letter" %>
<%@ page import="java.util.List" %>

<%--
  Created by IntelliJ IDEA.
  User: paul
  Date: 14-10-31
  Time: 下午7:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>
<m:MasterPage id="layout">
<html>
<head>
<title></title>
${pageHead}
<script>
$(function(){
    $(".home").attr("href", $Url.BuildNewIndexUrl("/main.action"));
    $("#newIndex").attr("href", $Url.BuildNewIndexUrl("/main.action"));
});

</script>
</head>
<body>
<div id="header">
    <h2></h2>
    <ul>
    </ul>
    <p class="pt50">您好！<span id="fmpEmpName"><s:property value="%{empName}"/></span>。 </p>
</div>
<div id="content_center">
    <div class="siderbar">
        <h3 id="subMenuTab">
            <a href="javascript:;" class="icons"></a>
        </h3>
    <s:action name="menuTree" namespace="/" executeResult="true">
    </s:action>
    </div>

    <div class="wrappContent">
    	<ul class="menus borderBott">
        	<li>
            	<a href="${logoutUrl}">退出登录</a>
            </li>
            <li>
            	<a href="#" class="applyTit">应用中心</a>
                <div class="applyCenter">
                	<div class="arrow-up"></div>
                	<h4 class="borderBott">
                    	<span class="ml10">欢迎使用下面的应用</span>
                    </h4>
                    <div class="applyIcon">
                    	<a href="${calendarUrl}" class="mr30">
                        	<em class="pic1"></em>
                            <strong>日历</strong>
                        </a>
                        <a href="${mailUrl}" class="mr30">
                        	<em class="pic2"></em>
                            <strong>通讯录</strong>
                        </a>
                        <a href="${knowledgeBaseUrl}">
                        	<em class="pic3"></em>
                            <strong>知识库</strong>
                        </a>
                        <a href="${letterUrl}" class="mr30">
                        	<em class="pic4"></em>
                            <strong>站内信</strong>
                        </a>
                        <a href="${remindUrl}" class="mr30">
                            <em class="pic7"></em>
                            <strong>提醒</strong>
                        </a>
                        <a href="${updatePwdUrl}">
                        	<em class="pic5"></em>
                            <strong>修改密码</strong>
                        </a>
                    </div>
                </div>
            </li>
            <li>
            	<a id="newIndex" class="icon mt5"></a>
            </li>
            <p>
                <MARQUEE scrollAmount=2>
                    <s:iterator value="#request.noticeList" id="item">
                        <span class="scrollText mr30">
                            <s:property value="#item.subject"/>：<s:property value="#item.content"/>
                            <s:date name="#item.inTime" format="yyyy-MM-dd hh:mm:ss"/>
                        </span>
                    </s:iterator>
                </MARQUEE>
            </p>
        </ul>
                <%--<s:iterator value="#request.noticeList" id="item">--%>
                        <%--<s:property value="#item.subject"/>：<s:property value="#item.content"/>--%>
                        <%--<s:date name="#item.inTime" format="yyyy-MM-dd hh:mm:ss"/>--%>
                <%--</s:iterator>--%>
        <s:if test="nav.size()!=0">
        <span class="crumbs mt30">当前位置：<a class="home" href="javascript:void(0)">首页</a> >>
            <s:property value="nav[0]"/> >>
            <s:property value="nav[1]"/>
        </span>
        </s:if>

        <m:ContentPlaceHolder id="center"/>

    </div>
    <div class="siderbarDolist">
        <h3><a href="javascript:;" class="iconsv"></a></h3>
        <div class="siderbarContent">
            <s:action name="letter" namespace="/" executeResult="true">
                <s:param name="empId" value="%{empId}"></s:param>
            </s:action>
        </div>

    </div>
</div>
<div id="footer">
    <p>Copyright(C)2013-2015 华镇金融控股集团所有&nbsp;&nbsp;<a href="http://www.miibeian.gov.cn">粤ICP备15003818号-2</a></p>
</div>
<div class="checkTrack" style="left:50%; top:50%; margin-top:-350px;">
</div>
</body>
</html>
</m:MasterPage>