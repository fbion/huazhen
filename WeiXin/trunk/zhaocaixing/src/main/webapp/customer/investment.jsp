<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
	<table class="imagetable">
		<s:if test="pageIndex==1">
		<thead>
             <tr>
                 <th>产品名称</th>
                 <th>投资金额</th>
                 <th>投资状态</th>
             </tr>
        </thead>
		</s:if>
		<s:iterator value="#request.salesList.resultList" id="item">
             <tbody>
                 <tr>
                     <td><a href="${productDetailsUrl}?p2pProductId=<s:property value="#item.p2pProductNo"/>"><s:property value="#item.p2pProductName" /></a></td>
                     <td><s:property value="#item.switchTotalAmout" />元</td>
                     <td><s:if test="#item.status==1 or #item.status==2 or #item.status==8 or #item.status==9" >待审核</s:if>
             <s:if test="#item.status==4 or #item.status==5 or #item.status==0">认购失败</s:if>
             <s:if test="#item.status==6 or #item.status==3">还款中</s:if>
             <s:if test="#item.status==10">付款中</s:if>
             <s:if test="#item.status==7">已还款</s:if></td>
                 </tr>
            </tbody>
		</s:iterator>
    </table>
	<input id="flag" readonly="readonly" type="hidden" value="${flag}"></input>
