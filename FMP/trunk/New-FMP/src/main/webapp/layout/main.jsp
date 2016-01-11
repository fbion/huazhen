<%--
  Created by IntelliJ IDEA.
  User: 磊
  Date: 2015/10/29
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>
<%--<m:MasterPage id="newLayout">--%>
<html>
<head>
    <title></title>
    ${pageHead}
</head>
<body>
<div class="easyui-layout" data-options="fit:true">
    <div id="header" data-options="region:'north'">
        <h2></h2>

        <div class="wrappContent">
            <ul class="menus borderBott">
                
                <li>
                    <div class="applyCenter" style="display: block; opacity: 1;">

                        <div class="applyIcon">
                            <a id="calendar" class="mr30">
                                <em class="pic1" title="日历"></em>
                                 <strong>日历</strong>
                            </a>
                            <a id="contacts" class="mr30">
                                <em class="pic2" title="通讯录"></em>
                                <strong>通讯录</strong>
                            </a>
                            <a id="knowledge">
                                <em class="pic3" title="知识库"></em>
                                <strong>知识库</strong>
                            </a>
                            <a id="message" class="mr30">
                                <em class="pic4" title="站内信"></em>
                                <strong>站内信</strong>
                            </a>
                            <a id="remind">
                                <em class="pic7" title="提醒"></em>
                                <strong>提醒</strong>
                            </a>
                            <a id="updatePwd">
                                <em class="pic5" title="修改密码"></em>
                                <strong>修改密码</strong>
                            </a>
                            
                        </div>
                    </div>
                </li>
                <li>
                    <p class="pt50">您好！<span id="empName"></span> 。</p>
                </li>
					
                <li>
                   <a id="logout">
                          <em class="pic6" title="退出登录"></em>
                          <strong class="exitlogin">退出登录</strong>
                   </a> 
                </li>
            </ul>
            
        </div>
    </div>
    <div id="footer" data-options="region:'south',split:true">
        <p>Copyright(C)2013-2015 华镇金融控股集团所有&nbsp;&nbsp;<a href="http://www.miibeian.gov.cn">粤ICP备15003818号-2</a></p>
    </div>
    <div data-options="region:'west',split:true" title="菜单" style="width:180px;">
        <div id="menuTree" class="easyui-accordion" data-options="fit:true,border:false">
            <%--<div class="easyui-tree"></div>--%>
            <%--<s:action name="newMenuTree" namespace="/" executeResult="true"></s:action>--%>
        </div>
    </div>
    <div id="indexEast" data-options="region:'east',split:true,border:false" title="East" style="width:265px;">
        <div id="auditModel" class="easyui-panel" style="width: 250px; height: 250px; margin-bottom:-1px; border:0 none;" title="" data-options="">
            <table id="myTaskList" class="indexTable" title="我的任务"></table>
            <a id="taskMore" href="#" class="indexofmore1">More</a>

        </div>
        <div id="messageModel" class="easyui-panel" style="width: 250px; height: 250px; margin-bottom:-2px; border:0 none;" title="" data-options="">
            <table id="letterList" class="indexTable" title="站内信"></table>
            <%--<a href="#" class="indexofmore1">More</a>--%>
        </div>
        <div id="Model" class="easyui-panel" style="width: 250px; height: 250px; border:0 none;" title="" data-options="">
            <table id="myApplyList" class="indexTable" title="我的申请"></table>
            <a id="applyMore" href="#" class="indexofmore1">More</a>
        </div>
    </div>
    <div data-options="region:'center'">
        <!-- Tabs选项卡 -->
        <div id="center" class="easyui-tabs" data-options="selected:0,fit:true"></div>
        <%--<m:ContentPlaceHolder id="center"/>--%>
    </div>

</div>
<div id="tabsMenu">
    <div data-options="iconCls:'icon-clear'" type="close">
        关闭
    </div>
    <div data-options="iconCls:'icon-cancel'" type="closeOther">
        关闭其他
    </div>
    <div data-options="iconCls:'icon-no'" type="closeAll">
        关闭所有
    </div>
</div>
${pageVar}

</body>
</html>

