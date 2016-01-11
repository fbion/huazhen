<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="displayType==1"><!--内部 链接   循环<li><a><img> -->
	<s:if test="#request.bannerLocation!=null">
	   	<s:if test="bannerInfoList!=null">
	   		<s:iterator value="bannerInfoList" var="bannerInfo">
			<li><a href="${bannerInfo.linkUrl}"> 
			<img data-original="${bannerInfo.resrcurl}" >
			</a></li>
		</s:iterator>
	    </s:if>	
    </s:if>
</s:if>
<s:if test="displayType==2"><!--内部 链接   循环<a><img> -->
	   	<s:if test="bannerInfoList!=null">
	   		<s:iterator value="bannerInfoList" var="bannerInfo">
			<a href="${webUrl}${bannerInfo.linkUrl}" class="wrapp"> 
			<img data-original="${bannerInfo.resrcurl}" width="${bannerLocation.width}"  height="${bannerLocation.height}" >
			</a>
		</s:iterator>
    </s:if>
</s:if>
<s:if test="displayType==3"><!--外部链接   循环<a><img> -->
	   	<s:if test="bannerInfoList!=null">
	   		<s:iterator value="bannerInfoList" var="bannerInfo">
			<a href="${bannerInfo.linkUrl}">
			<img data-original="${bannerInfo.resrcurl}" width="${bannerLocation.width}"  height="${bannerLocation.height}" >
			</a>
		</s:iterator>
    </s:if>
</s:if>
<s:if test="displayType==4"><!--机构logo  前六个循环<a><img> -->
	   	<s:if test="bannerInfoList!=null">
	   		<s:iterator value="bannerInfoList" var="bannerInfo">
			<a href="${bannerInfo.linkUrl}">
			<img data-original="${bannerInfo.resrcurl}" width="${bannerLocation.width}"  height="${bannerLocation.height}"  class="border">
			</a>
		</s:iterator>
    </s:if>
</s:if>
<%-- <s:if test="displayType==5"><!--机构logo  后六个循环<a><img> -->
	   	<s:if test="bannerInfoList!=null">
	   		<s:iterator value="bannerInfoList" var="bannerInfo">
			<a href="${bannerInfo.linkUrl}">
			<img data-original="${bannerInfo.resrcurl}" width="${bannerLocation.width}"  height="${bannerLocation.height}" class="border borderTop">
			</a>
		</s:iterator>
    </s:if>
</s:if> --%>