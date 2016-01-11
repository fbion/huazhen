<%--
  Created by IntelliJ IDEA.
  User: 磊
  Date: 2015/10/29
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>
<%--<m:MasterPage id="newLayout">--%>
    <html>
    <head>
        <title></title>
            ${pageHead}
    </head>
    <body>
    <div class="easyui-layout" style="width:700px;height:350px;" data-options="fit:true">
        <div id="header" data-options="region:'north'" style="height:50px"></div>
        <div id="footer" data-options="region:'south',split:true" style="height:50px;"></div>
        <div data-options="region:'west',split:true" title="West" style="width:180px;">
            <div id="menuTree" class="easyui-accordion" data-options="fit:true,border:false">
                <s:action name="newMenuTree" namespace="/" executeResult="true"></s:action>
            </div>
        </div>
        <div data-options="region:'east',split:true" title="East" style="width:100px;">
            <%--<ul class="easyui-tree" data-options="url:'tree_data1.json',method:'get',animate:true,dnd:true"></ul>--%>
        </div>
        <div data-options="region:'center'"
             style="padding: 10px; background: #eee;">
            <!-- Tabs选项卡 -->
            <div id="tabsID" class="easyui-tabs" data-options="plain:true,border:false,selected:0,fit:true"></div>
            <%--<m:ContentPlaceHolder id="center"/>--%>
        </div>

    </div>
    <div id="tabsMenu">
        <div data-options="iconCls:'icon-applicationdelete'" type="close">
            关闭
        </div>
        <div data-options="iconCls:'icon-cancel'" type="closeOther">
            关闭其他
        </div>
        <div data-options="iconCls:'icon-cross'" type="closeAll">
            关闭所有
        </div>
    </div>
    </body>
    </html>
<%--</m:MasterPage>--%>