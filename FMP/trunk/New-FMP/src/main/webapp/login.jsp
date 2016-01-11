<%--
  Created by IntelliJ IDEA.
  User: paul
  Date: 14-10-31
  Time: 上午11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
    ${pageHead}
</head>
<body>
<!--<div id="box">
    <div class="wrapp">
        <h2></h2>

        <div class="nones"></div>

        <div class="login">
            <p>
                <span class="pr10 tl">用户名</span><input type="text" id="name" name="name"/>
            </p>

            <p>
                <span class="pr10 tl">密<span class="pr12"></span>码</span>
                <input id="pwd" type="password" name="password"/>
            </p>

            <div id="error" class="warnInfo pl60"></div>
        </div>
        <a href="javascript:void(0)" class="loginSubmit"></a>
    </div>
</div>
<input type="hidden" id="redirectUrl" value="${redirectUrl}">-->
<div id="box">
    <div class="wrapp">
        <h2></h2>
        <div class="nones"></div>
        <div class="login">
        	<h3>
            	<span>登录CRM系统</span>
                <em>User Login</em>
            </h3>
            <p>
                <span class="pr10 tl ml30">用户名</span><input type="text" id="name" name="name"/>
            </p>
            <p class="mt5">
                <span class="pr10 tl ml30">密<span class="pr12"></span>码</span>
                <input id="pwd" type="password" name="password"/>
            </p>
            <div id="error" class="warnInfo pl60 ml30"></div>
        </div>
        <a href="javascript:void(0)" class="loginSubmit btn_style">登录</a>
        <i></i>
    </div>
    <div class="rightInfo">华镇金融控股集团所有  粤ICP备15003818号-2</div>
</div>
<input type="hidden" id="redirectUrl" value="${redirectUrl}">
</body>
</html>
