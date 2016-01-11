<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="m" uri="/hz-tags"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <!-- 视图窗口，移动端特属的标签。 -->
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no" />
    <!-- 是否启动webapp功能，会删除默认的苹果工具栏和菜单栏。 -->
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <!-- 这个主要是根据实际的页面设计的主体色为搭配来进行设置。 -->
    <meta name="apple-mobile-web-app-status-bar-style" content="black" />
    <!-- 忽略页面中的数字识别为电话号码,email识别 -->
    <meta name="format-detection"content="telephone=no, email=no" />
    <!-- 启用360浏览器的极速模式(webkit) -->
    <meta name="renderer" content="webkit">
    <!-- 避免IE使用兼容模式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- 针对手持设备优化，主要是针对一些老的不识别viewport的浏览器，比如黑莓 -->
    <meta name="HandheldFriendly" content="true">
    <!-- 微软的老式浏览器 -->
    <meta name="MobileOptimized" content="320">
    <!-- uc强制竖屏 -->
    <meta name="screen-orientation" content="portrait">
    <!-- QQ强制竖屏 -->
    <meta name="x5-orientation" content="portrait">
    <!-- UC强制全屏 -->
    <meta name="full-screen" content="yes">
    <!-- QQ强制全屏 -->
    <meta name="x5-fullscreen" content="true">
    <!-- UC应用模式 -->
    <meta name="browsermode" content="application">
    <!-- QQ应用模式 -->
    <meta name="x5-page-mode" content="app">
    <!-- windows phone 点击无高光 -->
    <meta name="msapplication-tap-highlight" content="no">
    ${pageHead}
</head>
<body class="regbody">
	<header class="enrollheader">
        <div>
            <ul>
                <li class="lotterysite">
                    <span class="sculpture">
                        <img src="${snsUserInfo.headImgUrl}" alt="" width="70">
                    </span>
                    <div class="huazhen_name">
                        <span id="nickname">${snsUserInfo.nickname}</span>已进入华镇屏幕抽奖现场
                        <div id ="headImgUrl" class="none">${snsUserInfo.headImgUrl}</div>
                        <div id="openid" class="none">${snsUserInfo.openid}</div>
                    </div>
                </li>
                 <s:if test="#request.res==1">
	               <li class="lotterygift ">
	                   <span class="sculpture"></span>
	                  	<div class="huazhen_name">您已经参加抽奖</div>
	               </li>
                 </s:if><s:else>
	               <li class="lotterygift a">
	                   <span class="sculpture"></span>
	                <div class="huazhen_name">抽奖</div>
	               </li>
                 </s:else>
            </ul>
        </div>
    </header>
    <div class="mask"></div>
    <div class="informations">
       <span class="closeBtn">
            <!--<img src="img/close.png" alt="">-->
        </span>
        <div class="info">
            <ul>
                <li>
                    <span class="infoleft"><span class="redstar">*</span>
                	    姓名：</span><input type="text" id="name" placeholder="2~4位中文字符" value="${user.name}">
                	    <div id="nameMsg"></div> 
                </li>
                <li>
                    <span class="infoleft"><span class="redstar">*</span>
                   	 手机：</span><input type="text" id="telephone" placeholder="11位手机号" value="${user.cellphone}">
                   	 <div id="telMsg"></div>
                </li>
               
                <li class="get_submit">
                    <input type="submit" value="提交" class="submit_info" id="submit">
                </li>
            </ul>
        </div>
     </div>
    
    <div class="submitsuccess">
         <p>您已具备参加抽奖条件，请听从现场主持人的安排。</p>
         <p class="neglect">我知道了</p>
    </div>

</body>
</html>