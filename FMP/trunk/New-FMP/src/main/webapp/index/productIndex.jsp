<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<ul class="productInfo">
    <li class="productInfoList1">
        <div class="online_sales">
            <h3>打款情况</h3>

            <div class="online_salesContent">
                <ul>
                    <li>
                        <span>${product.sumMoney}万</span>

                        <div class="play_detail">
                            <canvas class="CanvasSalesAmount" width="200" height="122" rel0="${product.sumMoney}" rel1="${salesAmount}"></canvas>
                        </div>
                        <div class="play_amount">
                            <span>已打款</span><em>${salesAmount}万</em>
                        </div>

                    </li>
                    <li>
                        <span>${salesTotal}</span>

                        <div class="play_detail">
                            <canvas class="CanvasSalesCount" width="200" height="122" rel0="${salesTotal}" rel1="${salesCount}"></canvas>
                        </div>
                        <div class="play_amount">
                            <span>${salesType}</span><strong>${salesCount}</strong>
                        </div>
                    </li>
                </ul>
                <p>
                    <a href="${productDetailUrl}" class="mr10 f12">产品详情</a><a href="${salesDetailUrl}" class="f12">打款详情</a>
                </p>
            </div>
        </div>
        <div class="project_audit">
            <h3>立项审核</h3>

            <s:if test="showReview">
                <div class="project_auditContent">
                    <ul>
                        <li>
                            <p>
                                <em class="audit_icon1"></em><span>风控审核</span>
                            </p>

                            <div class="audit_status  audit_status1">
                                <span class=${riskControlReviewStatus==1?"active":""}>已审核</span><span class=${riskControlReviewStatus==0?"active":""}>待审核</span><span class=${riskControlReviewStatus==2?"active":""}>未通过</span>
                            </div>
                        </li>
                        <li class="mt30">
                            <p>
                                <em class="audit_icon2"></em><span>产品总监审核</span>
                            </p>

                            <div class="audit_status  audit_status2">
                                <span class=${productDirectorReviewStatus==1?"active":""}>已审核</span><span class=${productDirectorReviewStatus==0?"active":""}>待审核</span><span class=${productDirectorReviewStatus==2?"active":""}>未通过</span>
                            </div>
                        </li>
                    </ul>
                </div>
            </s:if>
        </div>
    </li>

    <li class="productInfoList2">
        <div class="all_company">
            <h3>各分公司目前累计打款量</h3>
            <ul class="all_companyDetail">
            	<s:iterator value="#request.companySalesTotalList"  id="item" >
                <li><!--span中 class="bigPic1" -->
                    <span ><s:property value="#item.companyName"/></span>
                    <s:property value="#item.moneyTotal"/>万元
                </li>
                </s:iterator>
            </ul>
        </div>
    </li>

    <li class="productInfoList3">
        <div class="pending_orders">
            <h3>待审核订单</h3>

            <div class="pending_ordersTable">
                <table border="1" bordercolor="#bbb">
                    <thead>
                    <tr>
                        <!--<td>产品类型</td>
                        <th>产品名称</th>-->
                        <th class="h28">认购客户</th>
                        <th>认购金额</th>
                        <th>认购日期</th>
                        <th>审核状态</th>
                    </tr>
                    </thead>
                    <tbody>
                 <s:iterator value="#request.salesList"  id="item" >   
                    <tr>
                        <td class="h28"><s:property value="#item.bankName"/></td>
                        <td><s:property value="#item.money"/>万</td>
                        <td><s:property value="#item.purchaseDate"/></td>
                        <td>
                        <a href="${updateStatusUrl}?salesId=<s:property value="#item.id"/>">未审核</a>
                        </td>
                    </tr>
                  </s:iterator>
                   
                    </tbody>
                </table>
                <a href="${salesDetailUrl}" style="display:block; width:309px; line-height:30px; font-size:12px; text-align:right;">查看更多</a><!-- 查看更多 -->
            </div>
        </div>
        <div class="tabs online_audit">
            <s:if test="showOnlineReview">
            <div class="tab_title">
                <!--<h3>上线审核</h3>-->
                <a href="javascript:;" class="${showSalesChannel==0?"active":""}">直销上线审核</a><a href="javascript:;" class="${showSalesChannel==1?"active":""}">渠道上线审核</a>
            </div>
                <div class="tab_content">
                    <div class="tab_content1s tabContent" style="display:block;">
                        <ul class="online_auditContent">
                            <li>
                                <p>
                                    <em class="audit_icon1"></em><span>风控审核</span>
                                </p>
        
                                <div class="audit_status audit_status3">
                                    <span  class=${onlineRiskControlReviewStatus0==1?"active":""}>已审核</span><span  class=${onlineRiskControlReviewStatus0==0?"active":""}>待审核</span><span  class=${onlineRiskControlReviewStatus0==2?"active":""}>未通过</span>
                                </div>
                            </li>
                            <li>
                                <p>
                                    <em class="audit_icon3"></em><span>财务审核</span>
                                </p>
        
                                <div class="audit_status audit_status4">
                                    <span class=${onlineFinanceReviewStatus0==1?"active":""}>已审核</span><span class=${onlineFinanceReviewStatus0==0?"active":""}>待审核</span><span class=${onlineFinanceReviewStatus0==2?"active":""}>未通过</span>
                                </div>
                            </li>
                            <li>
                                <p>
                                    <em class="audit_icon2"></em><span>总裁审核</span>
                                </p>
        
                                <div class="audit_status audit_status5">
                                    <span class=${onlinePresidentReviewStatus0==1?"active":""}>已审核</span><span class=${onlinePresidentReviewStatus0==0?"active":""}>待审核</span><span class=${onlinePresidentReviewStatus0==2?"active":""}>未通过</span>
                                </div>
                            </li>
                        </ul>
                    </div>    
                    <div class="tab_content2s tabContent" style="display:none;">
                        <ul class="online_auditContent">
                            <li>
                                <p>
                                    <em class="audit_icon1"></em><span>风控审核</span>
                                </p>
        
                                <div class="audit_status audit_status3">
                                    <span  class=${onlineRiskControlReviewStatus1==1?"active":""}>已审核</span><span  class=${onlineRiskControlReviewStatus1==0?"active":""}>待审核</span><span  class=${onlineRiskControlReviewStatus1==2?"active":""}>未通过</span>
                                </div>
                            </li>
                            <li>
                                <p>
                                    <em class="audit_icon3"></em><span>财务审核</span>
                                </p>
        
                                <div class="audit_status audit_status4">
                                    <span class=${onlineFinanceReviewStatus1==1?"active":""}>已审核</span><span class=${onlineFinanceReviewStatus1==0?"active":""}>待审核</span><span class=${onlineFinanceReviewStatus1==2?"active":""}>未通过</span>
                                </div>
                            </li>
                            <li>
                                <p>
                                    <em class="audit_icon2"></em><span>总裁审核</span>
                                </p>
        
                                <div class="audit_status audit_status5">
                                    <span class=${onlinePresidentReviewStatus1==1?"active":""}>已审核</span><span class=${onlinePresidentReviewStatus1==0?"active":""}>待审核</span><span class=${onlinePresidentReviewStatus1==2?"active":""}>未通过</span>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </s:if>
        </div>
    </li>
</ul>