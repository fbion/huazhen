<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>
<html>
<head>
  <title></title>
  ${pageHead}
</head>
<body>
<table >
  <tbody>
  <tr>
    <td >
      <div style="padding: 10px 0 15px 15px;">
        <div id="xx" class="easyui-panel  portal-column"
             style="width: 230px; height: 120px; padding: 15px"
             title="审批任务"
             data-options="closable:true">
          <span style="font-size: 16px;font-weight: 800">待审核店铺</span>
          <span>3</span>

        </div>
      </div>
    </td>
    <td >
      <div style="padding: 10px 0 15px 15px;">
        <div id="xx" class="easyui-panel portal-column"
             style="width: 230px; height: 120px; padding: 15px"
             title="站内信"
             data-options="closable:true"">
        <span style="font-size: 16px;font-weight: 800">需审核商品</span>
        <span>3</span>
      </div>
      </div>
    </td>
  </tr>
  </tbody>
</table>
</body>
</html>


