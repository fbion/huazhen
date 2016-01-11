<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
	<table class="imagetable">
		<s:if test="pageIndex==1">
		<thead>
             <tr>
                 <th>投资用户</th>
                 <th>投资金额(元)</th>
                 <th>投资状态</th>
             </tr>
        </thead>
		</s:if>

		<s:iterator value="p2pProductRecordList" var="sales">
				<tr>
                     <td>${sales.p2pCustomerName}</td>
                     <td>${sales.money}</td>
                     <td>成功</td>
                 </tr>
		</s:iterator>
    </table>
 	<input id="flag" readonly="readonly" type="hidden" value="${flag}"></input> 
