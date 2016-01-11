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
    </head>
    <body>
    <div id="content_center">
        <div class="wrappContent">
            <m:ContentPlaceHolder id="center"/>
        </div>
    </div>
    <div class="checkTrack">
    </div>
    </body>
    </html>
</m:MasterPage>