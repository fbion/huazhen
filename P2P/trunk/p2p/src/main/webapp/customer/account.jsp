<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="m" uri="/hz-tags"%>

<m:ContentPage materPageId="layoutCustomerCenter">
	<m:Content contentPlaceHolderId="customerCenterNavigation">账户总览</m:Content>
	<m:Content contentPlaceHolderId="customerCenter">
       <div class="accountCont">
       	<div class="">
           	<h3>
               	<em class="pl15" >我的账户</em>
               	<i></i>
               </h3>
               <div class="myAcount mt10">
               	<div class="myAcountInfo">
                       <dl class="ml20 mt10">
                           <dt></dt>
                           <dd class="ml15">
                           	<h4>${name}</h4>
                               <ul class="mt10">
                               <li class="phones">
                               <s:if test="#request.paymentAccountInformationl.authenticationName==1"><li class="realAuthents mr5"></li></s:if>
	                           <s:else><li class="realAuthent mr5"></li></s:else>
                               <s:if test="#request.paymentAccountInformationl.authenticationBankCard==1"><li class="bankBinds mr5"></li></s:if>
	                           <s:else><li class="bankBind mr5"></li></s:else>
                               <s:if test="#request.accountPwdCheck==1"><li class="pwds mr5"></li></s:if>
	                           <s:else><li class="pwd mr5"></li></s:else>
                               <s:if test="#request.paymentAccountInformationl.authenticationEmail==1"><li class="emails"></li></s:if>
	                           <s:else><li class="email"></li></s:else>
                               </ul>
                           </dd>
                       </dl>
                       <s:if test="#request.authenticationAccountStatus==0||authenticationBankCardStatus==0">
	                       <p class="ml20 mt10" >
	                       		<s:if test="#request.authenticationAccountStatus==0">
	                       		<span>您还有安全认证没有完成</span>
	                           		<a href="${accountSecurityUrl}" class="btnStyle ml30">去认证</a>
	                          	</s:if>
		                       	<s:if test="#request.authenticationBankCardStatus==0&&#request.authenticationAccountStatus==1">
			                           <span>您还有没有</span><a href="${bankCardUrl}" class="btnStyle ml10">绑定银行卡</a> <span>，赶紧去绑定吧！</span>
		                       	</s:if>
	                       </p>
                       </s:if>
                       <p class="ml20">
                       	<strong>上次登录时间：</strong><em>${lastTime}</em>
                       </p>
                   </div>
                   <ul class="fundInfo">
                   	<li>
                       	<span>账户总额</span>
                           <em class="em1">￥<i id="ibalance"></i><s1 id="balance"></s1></em>
                           <span>冻结总额</span>
                           <em>￥<i id="ifreezeAmount"></i><s1 id="freezeAmount"></s1></em>
                       </li>
                       <li>
                       	<span>可用余额</span>
                           <em class="em1">￥<i id="iavailableAmount"></i><s1 id="availableAmount"></s1></em>
                           <a href="${paymentMoneyRechargeUrl}" class="btnStyle">充值</a>
                           <a href="${paymentMoneyWithdrawUrl}" class="" >提现</a>
                       </li>
                       <li>
                       	<span>累计收益</span>
                           <em class="em1">￥<i id="iincome"></i><s1 id="income"></s1></em>
                           <span>待收收益</span>
                           <em>￥<i id="iunIncome"></i><s1 id="unIncome"></s1></em>
                       </li>
                   </ul>
               </div>
           </div>
           <div class="tradeRecord mt30">
           	<h3> <em class="pl15" >交易记录</em> <i></i> </h3>
               <dl>
               	<dt>交易类型：</dt>
                   <dd>
                   	<a href="javascript:void(0)" name="moneyChangeType"   class="active">全部</a>
                   	<a href="javascript:void(0)" name="moneyChangeType" value="1" >充值</a>
                   	<a href="javascript:void(0)" name="moneyChangeType" value="3">提现</a>
                   	<a href="javascript:void(0)" name="moneyChangeType" value="-1">其它</a>
                   </dd>
               </dl>
               <ul id="transactionRecord"></ul>
           </div>
           <input type="hidden" id="pageAlias" value="${pageAlias}">
       </div>
	</m:Content>
</m:ContentPage>