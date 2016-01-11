<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
	<table class="imagetable">
		<s:if test="pageIndex==1">
		<thead>
             <tr>
                 <th>用户名</th>
                 <th>手机号码</th>
                 <!-- <th>邀请奖励</th> -->
                 <th>是否生效</th>
             </tr>
        </thead>
		</s:if>
		<s:iterator value="#request.activityCustomerInvitation" id="item">
             <tbody>
                 <tr>
                     <td><s:property value="#item.p2pCustomerName" /></td>
                     <td><s:property value="#item.invitePhoneNo" /></td>
                     <%-- <td><s:property value="#item.showRewardsMoney" /></td> --%>
                     <td><s:property value="#item.invitionStatue" /></td>
                 </tr>
            </tbody>
		</s:iterator>
    </table>
 	<input id="flag" readonly="readonly" type="hidden" value="${flag}"></input> 


