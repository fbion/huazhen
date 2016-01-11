<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layoutCustomerCenter">
	<m:Content contentPlaceHolderId="customerCenterNavigation">充值</m:Content>
    <m:Content contentPlaceHolderId="customerCenter">
        <div class="accountCont">
            <div class="recharge">
            <form class="validform" id="rechargeForm" >  
                <div class="profitTitle tab_title">
                	<a href="javascript:void(0)" class="active">充值</a>
                    <a href="javascript:void(0)" id="rechargeRecord">充值记录</a>
                </div>
                
                <div class="mt20">
                    <div class="tabContent" style="display:block;"> 
                        <dl class="borderBott">
                            <dt class="ml20 mr10">充值金额：</dt>
                            <dd>
                                <input type="text" class="mr5 rechargeMoney" />元
                                <span id="msg1" style="color:red"></span>
                            </dd>
                            <span>手续费为0</span>
                        </dl>
                        <dl>
                            <dt class="ml20 mr10">银行卡：</dt>
                            <dd>
                                <s:if test="#request.bankStatus==1">
			                    	<img src="${bankLogoPath}" width="125" height="38" />
			                        <em class="ml10">${bankCardNo}</em>
		                         </s:if>
		                         <s:else>
		                    		(未绑定，不影响充值)
		                   		</s:else>
                            </dd>
                            <span>限额100万/笔</span>
                        </dl>
                        
                        <s:if test="showPaymentStyle">
	                        <p class="payMethod ml15 mt10">
	                           	 其他支付方式<em>∧</em>
	                        </p>
	                        <div class="onlineRecharge mt30">
	                            <h4>网银充值（由易宝支付提供）</h4>
	                            <ul class="borderBott mt10 pb15">
	                            	<s:if test="paymentBankInfoList!=null">
	                            		<s:iterator value="paymentBankInfoList" var="paymentBankInfo">
	                            			<s:if test="paymentBankInfo.count%4==0"><li></s:if>
			                                    <span>
			                                        <input type="radio" value="${paymentBankInfo.id}">
			                                        <img src="${paymentBankInfo.logo}" width="125" height="38" />
			                                    </span>
			                                <s:if test="paymentBankInfo.count%4==0"></li></s:if>
	                            		</s:iterator>
	                            	</s:if>
	                            </ul>
	                            
	                            <h4 class="mt10">易宝支付余额充值通道</h4>
	                            <ul>
	                                <li>
	                                	<s:if test="paymentPlatformList!=null">
	                                		<s:iterator value="paymentPlatformList" var="paymentPlatform"> 
	                                			<span>
			                                        <input type="radio" value="${paymentPlatform.id}">
			                                        <img src="img/yeepay.jpg" width="125" height="38" />
			                                    </span>
	                                		</s:iterator>
	                                	</s:if>
	                                </li>
	                            </ul>
	                            
	                        </div>
                        </s:if>
                       	<div class="onlineRecharge mt30">
							<input class=" mt50 comfirSubmit rechargeButton btnStyle" type="submit" value="前往充值">
							<a class="rechargeBtn " href="javascript:void(0)"></a>
						</div>
                        <div class="warm ml50">
                            <h4 class="ml40 mt15">温馨提示</h4>
                            <p class="ml40">充值过程遇到问题，请联系客服：400-0340-668</p>
                        </div>
                    </div>
                    
                    <div class="tabContent">
                        <div class="rechargeRecord mt20">
                       	 状态：<span>
                       	 	<s:if test="rechargeStateList!=null">
                       	 		<s:iterator value="rechargeStateList" var="rechargeState">
                       	 			<input type="checkbox" id="state${rechargeState.code}" value="0${rechargeState.code}"><span class="mr10">${rechargeState.value}</span>
                       	 		</s:iterator>
                       	 	</s:if>
                       	 </span>
                        <strong class="ml80">创建时间：</strong><select id="createTime"></select>
                        <input type="button" value="查询" id="btnSearch" class="checks ml10 btnStyle">
                    	</div>
                        
                        <div class="recordList">
							<ul class="mt20" id="paymentMoneyRechargeList">
                            </ul>
                        </div> 
                    </div> 
                </div>
            </form>    
            </div>
        </div>

		<!-- 充值提示弹窗 -->
		<div class="recharge_layer">
			<div class="layerTitle borderBott">
		    	<h2>充值提示</h2>
		        <a href="javascript:;" class="close" id="closeWindow"></a>
		    </div>
		    <div class="layerContent">
		    	<dl>
		        	<dt></dt>
		            <dd>
		                <p class="mt10">请您在新打开的网上银行页面进行支付,支付完成前请不要关闭该窗口</p>
		                <p class="mt30">
		                    <a href="${paymentMoneyRechargeUrl}" class="payQuestion">支付遇到问题</a>
		                    <a href="${moneyDetailUrl}" class="btnStyle paid ml20">已完成支付</a>
		            	</p>
		            </dd>
		            
		        </dl>
		    </div>
		</div>
<input type="hidden" id="pageAlias" value="${pageAlias}">  

</m:Content>
</m:ContentPage>