<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/11/26
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>
<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="errPage">
            <ul class="pt400 pl200 lh38">
                <li><span class="f18">出现错误啦！请联系系统管理员</span></li>
                <li><span class="f18">错误内容：<s:property value="#request.exception"/></span></li>
                <li><span class="f18">错误详情：</span><textarea style="height: 300px;width: 1000px;" disabled="disabled"><s:property value="#request.exceptionStack"/></textarea></li>
            </ul>
        </div>
    </m:Content>
</m:ContentPage>
