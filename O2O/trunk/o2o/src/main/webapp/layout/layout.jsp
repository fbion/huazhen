<%--
  Created by IntelliJ IDEA.
  User: ulei0
  Date: 2015/9/29
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="m" uri="/hz-tags" %>
<m:MasterPage id="layout">
  <html>
  <head>
    <title></title>
      ${pageHead}
  </head>
  <body>
  <m:ContentPlaceHolder id="center"/>

  </body>
  </html>
</m:MasterPage>