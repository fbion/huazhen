<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layoutCustomerCenter">
    <m:Content contentPlaceHolderId="customerCenter">
     <div class="row pb100" align="center">
                    <p class="pb30" style="font-size: 20px">${msg} 去<a style="color: red" href="${paymentAccountSecurityUrl}">账户安全</a>看看</p>
                    
             </div>
    
    </m:Content>
</m:ContentPage>