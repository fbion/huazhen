<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
       <div id="content" class="mt20">
            <div class="productDetails_list pt10 pb20">
               
                    <input type="hidden" id="p2pProductNo"  value="${p2pProduct.id}">
                        <%-- <div id="p2pProductNo" style="display:none;">${p2pProduct.id}</div> --%>
                    <h3>${p2pProduct.name}</h3>
                     <dl>
                     <dt>总金额度</dt>
                     <dd>${p2pProduct.switchTotalAmout}元</dd>
                    </dl>
                     <dl class="project_profit">
                     <dt>年化收益</dt>
                     <dd>${p2pProduct.income}% <s:if test="#request.p2pProduct.floatingIncome!=0">
                             +${p2pProduct.floatingIncome}%
                            </s:if></dd>
                    </dl>
                 	<s:if test="p2pProduct.type==5">
                    <dl class="progress_Bars">
                        <dt>投资进度</dt>
                        <dd>
                           <p class="progressBars">
                              <em></em><span style="width:${p2pProduct.progress}%"></span><strong>${p2pProduct.progress}%</strong>
                           </p>
                        </dd>
                     </dl>
                 	</s:if>
                     <dl>
                        <dt>项目期限</dt>
                        <dd>${p2pProduct.duration}天</dd>
                     </dl>
                      <dl>
                        <dt>剩余金额</dt>
                        <dd>${p2pProduct.switchRemainAmout}元</dd>
                     </dl>
                      
                     <s:if test="showLoginUrl">
                       <input type="button" value="预约" class="submit_btn btn mt10" onclick="javaScript:loginInvest()">
                       <div id="invest" class="wrapp_layer mt20" >
                            <!--<h4 class="text-center pt10">登录后立即预约</h4>-->
                            <div class="tab_title">
                                <a href="javascript:;" class="active">立即预约</a>
                                <a href="javascript:;" >登录后预约</a>
                            </div>
                            
                            <div class="loginInfo">
                                <div class="tabContent" style="display:block;">
                                <form id="callSubscribeForm" class="validform mt30 pb50">
                                    <dl id="userInfo" class="userInfo">
                                        <dt>姓<span class="ml15" style="display:inline-block"></span>名：</dt>
                                        <dd>
                                            <input id="callName" type="text" tabindex="1" placeholder="请输入姓名"
                                            value="" name="callName" class="Validform_error">
                                        </dd>
                                    </dl>
                                    <div class="desc Validform_checktip absolute"></div>
                                    <dl id="phoneNum" class="phoneNum">
                                        <dt>手机号：</dt>
                                        <dd>
                                            <input id="callPhone" type="text" name="callPhone" tabindex="2" 
                                                placeholder="请输入手机号" >
                                        </dd>
                                    </dl>
                                    <div class="desc Validform_checktip absolute"></div>
                                    <p class="pt20"><input type="submit" value="提交" class="btn submit1" /></p>
                                </form>
                                </div>
                                <div class="tabContent" style="display: none;">
                                    <s:include value="../common/loginArea.jsp"/>
                                </div>
                            </div>
                        </div>
                    </s:if>
                    <s:else>   	  
                        <div id="reservation_form">
                            <form>
                              <div id="msg" style="color:red; width:266px; height:50px; line-height:50px;"></div>
                                <dl>
                                    <dt>预约金额</dt>
                                    <dd><input type="text" id="amount"/><span>元</span></dd>
                                </dl>
                                <input type="button" value="预约" class="btn my_appointment"/>
                            </form>
                        </div>
                        <div class="reservation_amount mt50 ml30 reservation_success" style="display:none;">
                            <form>
                                <div class="text-center reservation_success">预约成功</div>
                                <p class="text-center reservationAmount">您预约的金额：<span id="amountMoney"  style="color:red;font-size:26px;"></span>&nbsp元</p>
                            </form>
                        </div>
                  
                    </s:else>
                </div>
               
            </div>
            <div class="productmt20">
                <div class="product_description">
                    <!--<img  src="${productDescriptionUrl}"  width="60" height="60" >-->
                   <ul>
                      <li class="projectli">
                        <table border="0" cellspacing="0" cellpadding="0" height="60">
                          <tbody>
                            <tr>
                               <td width="30%">
                                  <img src="${productDetailsInfoUrl} " width="18" height="24">

                               </td>
                               <td>
                                  <a href="${productDetailsUrl}?p2pProductId=${p2pProduct.id}" >查看产品详情</a>
                               </td>
                            </tr>
                            </tbody>
                        </table>
                      </li>

                      <li>
                        <table border="0" cellspacing="0" cellpadding="0" height="60">
                          <tbody>
                            <tr>
                               <td width="30%">
                                  <img src="${productInvestInfoUrl} " width="24" height="22">
                               </td>
                               <td>
                                  <a href="${investInfoUrl}?p2pProductNo=${p2pProduct.id}" id="investRecord">查看投资记录</a>
                               </td>
                            </tr>
                            </tbody>
                        </table>
                      </li>
                    </ul> 
                </div>
            
            
            <div class="proListRecord tabContent">
            	<div id="investRecordList"></div>
            	<!--<p class="mt30"><a class="btn" id="loadMore">查看更多</a></p>-->
            </div>
                 
                
                <s:if test="#p2pProduct.productAdvantage!=null">
                <div class="product_advantage mt10">
                    <img  src="${productAdvantageUrl}" width="60" height="60"><a href="#">产品优势</a>
                    ${p2pProduct.productAdvantage}
                </div>
                </s:if>
			</div>
			
 		<input id="needVerifyCode" type="hidden">
   </script>
    </m:Content>
</m:ContentPage>