<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">

            <div class="productDescription mt20 productmt20">
            <input type="hidden" id="p2pProductNo"  value="${p2pProduct.id}">
                            <div class="proListRecord tabContent">
            	<div id="investRecordList"></div>
            	<p class="mt30"><a class="btn" id="loadMore">查看更多</a></p>
                </div>
			</div>
			
 		<input id="needVerifyCode" type="hidden">
   </script>
    </m:Content>
</m:ContentPage>