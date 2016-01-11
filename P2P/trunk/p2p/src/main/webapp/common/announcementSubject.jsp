<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:if test="#request.announcementList!=null">
	<!-- 公告 -->
	<div class="notice">
		<div class="noticeCont wrapp">
	    	<em class="ml20"></em>
	        <ul>
	        <s:iterator value="#request.announcementList" var="announcement">
	            <li>
	                <a href='<s:property value="#announcement.linkurl"/>' style='<s:if test="#announcement.isRed==1">color:red;</s:if>'><s:property value="#announcement.subject"/></a>
	            </li>
            </s:iterator>
	        </ul>
			<a href="${announcementListUrl}" class="more"><i class="more_products"></i>更多公告</a>
		</div>
	</div>
</s:if>

