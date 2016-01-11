<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layoutCustomerCenter">
	<m:Content contentPlaceHolderId="customerCenterNavigation">提现</m:Content>
    <m:Content contentPlaceHolderId="customerCenter">
        <div class="accountCont">
        	<form class="validform" id="rechargeForm" >
            <div class="recharge">
            	<div class="profitTitle tab_title">
                	<a href="#" class="active">提现</a>
                    <a href="#" id="withDrawRecord">提现记录</a>
                </div>
                <div class="mt20">
                	<div class="tabContent" style="display:block;"> 
                        <dl class="borderBott">
                            <dt class="ml20 mr10">可提现金额：</dt>
                            <dd>
                              	  ￥<em class="f18" id="canWithdrawMoney">${withdrawMoney}</em>
                            </dd>
                        </dl>
                        <dl class="borderBott">
                            <dt class="ml20 mr10">提现金额：</dt>
                            <dd>
                                <input type="text" class="mr5 withdrawMoney" />元
                            </dd>
                            <span>手续费为0</span>
                        </dl>
                        <dl class="borderBott">
                            <dt class="ml20 mr10">银行卡：</dt>
                            <dd>
                                <s:if test="#request.bankStatus==1">
			                    	<img src="${bankLogoPath}" width="125" height="38" id="bankLogoImg"/>
			                        <em class="ml10">${bankCardNo}</em>
			                    </s:if><s:else>
			                    	(未绑定)
			                    </s:else>
			                    <em class="ml20 f16">设置提现银行卡</em>
                        		<a href="${bankCardUrl}" class="f16">前往设置</a>
                            </dd>
                            <span>限额100万/笔</span>
                        </dl>
        
                        <div class="onlineRecharge mt20">
                            <a href="javascript:void(0)" class="withdrawBtn btnStyle ml50">前往提现</a>
                        </div>
                        <div class="warm ml50">
		                	<h4 class="ml40 mt15">温馨提示</h4>
		                	<p class="ml40">当天充值金额，次日起方可提现，当天无法提现</p>
		                    <p class="ml40">提现过程遇到问题，请联系客服：400-0340-668</p>
			             </div>
                       
                    </div>
                    
                    <div class="tabContent">
                    	<div class="rechargeRecord mt20">
                        	状态：<span>
	                        	<%-- <s:if test="withDrawStateList!=null">
	                        		<s:iterator value="withDrawStateList" var="withDrawState">
	                        			<input type="checkbox" id="state${withDrawState.code}" value="0${withDrawState.code}"><span class="mr10">${withDrawState.value}</span>
	                        		</s:iterator>
	                        	</s:if> --%>
	                        	<input id="state3" type="checkbox" value="03">
								<span class="mr10">提现中</span>
								<input id="state4" type="checkbox" value="04">
								<span class="mr10">提现成功</span>
								<input id="state5" type="checkbox" value="05">
								<span class="mr10">提现失败</span>
                        	</span>
                        	<strong class="ml80">创建时间：</strong><select id="createTime"></select>
                        	<input type="button" value="查询" id="btnSearch" class="checks ml10 btnStyle">
                    	</div>
                        
                        <div class="recordList">
							<ul class="mt20" id="paymentMoneyWithdrowList">
                                
                            </ul>
                        </div>
                    </div>
                    
                </div>
                

                
		    </div>
		    </form>
		    <input type="hidden" id="pageAlias" value="${pageAlias}">
		</div>

    </m:Content>
</m:ContentPage>