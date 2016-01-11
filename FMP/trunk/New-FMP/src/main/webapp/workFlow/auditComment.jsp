<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

   <s:iterator value="#request.commentList" id="item" status="index">
   	<tr id="check<s:property value="#index.index+1"/>">
     <td width="83" valign="center" ><input id="checkPosition<s:property value="#index.index+1"/>" readonly="readonly"  value="<s:property value="#item.checkPosition"/>" class="ml10" ></td>
     <td width="629" valign="center" colspan="9" >
     	<textarea style="width:600px; height:90px; border:none;" disabled="disabled" id="checkComment<s:property value="#index.index+1"/>" ><s:property value="#item.checkComment"/></textarea>
         <div>签字：<input type="text" id="checkName<s:property value="#index.index+1"/>" readonly="readonly"  value="<s:property value="#item.checkName"/>"/>时间：<input type="text" id="checkTime<s:property value="#index.index+1"/>" readonly="readonly"  value="<s:property value="#item.checkTime"/>" style="width: 200px;"/></div></td>
   	</tr>
    </s:iterator>