<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layoutCustomerCenter">
	<m:Content contentPlaceHolderId="customerCenterNavigation">充值成功</m:Content>
    <m:Content contentPlaceHolderId="customerCenter">
        <div class="accountCont">
            <div class="recharge">
            	<h3><em class="pl30">充值</em>
                	<i></i>
                </h3>
				<dl class="successPage">
                	<dt></dt>
                    <dd>
                    	<h4>${msg1}<!-- 您已申请充值100元，预计10分钟内到账。 --></h4>
                        <span>${msg2}<!-- 充值高峰期，到账时间会延迟，请以实际到账时间为准。 --></span>
                        <p class="mt50">您稍后可以通过查看<a href="${accountUrl}" class="ml5 mr5">我的账户</a>是否充值成功</p>
                    </dd>
                </dl>
		    </div>
		</div>
</m:Content>
</m:ContentPage>