<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="m" uri="/hz-tags"%>

<m:ContentPage materPageId="layout">
	<m:Content contentPlaceHolderId="center">
		<div class="main wrapp pb30">
	    <h3 class="contCrumbs wrapp">
	    	<a href="${homeUrl}">首页</a>><a href="${accountUrl}">我的账户</a>><m:ContentPlaceHolder id="customerCenterNavigation" />
	    </h3>
	    <div class="accountCenter wrapp">
	    	<div class="accountTit">
	        	<dl>
	            	<dt class="borderTop">我的账户</dt>
	                <dd  id="account">
	                	<a href="${accountUrl}">账户总览</a><em>></em>
	                </dd>
	                <dd id="myReservation">
	                	<a href="${reservationUrl}">我的预约</a><em>></em>
	                </dd>
	                <dd id="myInvestment">
	                	<a href="${investmentUrl}">我的投资</a><em>></em>
	                </dd>
	            </dl>
	            <dl>
	            	<dt>资金管理</dt>
	                <dd id="moneyDetail">
	                	<a href="${moneyDetailUrl}">资产明细</a><em>></em>
	                </dd>
	                <dd id="myPaymentMoneyRechargeList">
	                	<a href="${paymentMoneyRechargeUrl}">充值</a><em>></em>
	                </dd>
	                <dd id="myPaymentMoneyWithdrawList">
	                	<a href="${paymentMoneyWithdrawUrl}">提现</a><em>></em>
	                </dd>
	            </dl>
	            <dl>
	            	<dt>账户信息</dt>
	                <dd id="personalInfo">
	                	<a href="${personalInfoUrl}">个人信息</a><em>></em>
	                </dd>
	                <dd id="bankCard">
	                	<a href="${bankCardUrl}">银行卡管理</a><em>></em>
	                </dd>
	                <dd id="paymentAccountSecurity">
	                	<a href="${paymentAccountSecurityUrl}">安全设置</a><em>></em>
	                </dd>
	                <%-- <dd id="myInfo">
	                	<a href="${myInfoUrl}">我的消息</a><em>></em>
	                </dd> --%>
	            </dl>
	             <dl>
	            	<dt>活动管理</dt>
	                 <dd>
	                	<a href="${myInviteUrl}">我的邀请</a><em>></em>
	                </dd> 
	                <!--<dd id="myCoupons">
	                	<a href="${myCouponsUrl}">我的优惠券</a><em>></em>
	                </dd>
	                <dd id="myIntegral">
	                	<a href="${myIntegralUrl}">我的积分</a><em>></em>
	                </dd>
	                <dd id="myReward">
	                	<a href="${myRewardUrl}">活动奖励</a><em>></em>
	                </dd>-->
	            </dl> 
	        </div>
				<m:ContentPlaceHolder id="customerCenter" />
			</div>
	</div>
	</m:Content>
</m:ContentPage>
