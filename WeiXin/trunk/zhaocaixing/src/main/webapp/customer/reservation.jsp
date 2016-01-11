<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!--<div class="text-center create_password"> -->
	<table class="imagetable">
    <s:if test="pageIndex==1">
         <thead>
             <tr> 
                 <th>产品名称</th>
                 <th>预约金额</th>
                 <th>预约状态</th>
             </tr>
        </thead>
    </s:if>
    <s:iterator value="#request.p2pSubscribePagedList.resultList" id="item">
        <tbody>
            <tr>
                 <td><a href="${productDetailsUrl}?p2pProductId=<s:property value="#item.p2pProductNo"/>"><s:property value="#item.p2pProductName"/></a></td>
                 <td><s:property value="#item.switchAmount"/>元</td>
                 <td><s:if test="#item.status==1">预约中</s:if><s:else>已受理</s:else></td>
            </tr>
        </tbody>
    </s:iterator>
   </table>
     <input readonly="readonly" id="flag" type="hidden" value="${flag}"></input>
