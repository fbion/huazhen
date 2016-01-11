<%--
  Created by IntelliJ IDEA.
  User: paul
  Date: 14-10-31
  Time: 下午5:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>
<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <%-- <meta http-equiv="refresh" content="6;url=${ loginUrl}"> --%>
			<div class="main pt30">
				<div class="successPage wrapp">
			        <em class="tipsPicError mt40"></em>
			        <div class="tipsInfo mt40">
			        	<h4>${message}</h4>
			            <h5>请重新申请。</h5>
			        </div>
			    </div>
			</div>
  </m:Content>
</m:ContentPage>
