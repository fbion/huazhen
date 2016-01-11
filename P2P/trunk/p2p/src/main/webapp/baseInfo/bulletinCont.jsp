<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:if test="info!=null">
	<h4>
	    <span>BULLETIN</span>
	    <em>网站公告</em>
	    <a href="javascript:void(0)" class="red" id="back"><span class="more_products"></span>返回目录</a>
	</h4>
	<div class="bullTit">
		<h3 class="mt30" style="padding-left: 0px;">${info.subject}</h3>
	    <p>
	    	<span><s:date name="info.startTime" format="yyyy-MM-dd HH:ss:mm"/> </span>${info.typeValue}
	    </p>
	</div>
	<div class="bullCont">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${info.content}
	</div>
</s:if>
<s:else>公告或通知已过期</s:else>
