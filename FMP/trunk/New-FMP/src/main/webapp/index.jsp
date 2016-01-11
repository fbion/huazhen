<%--
  Created by IntelliJ IDEA.
  User: paul
  Date: 14-10-30
  Time: 下午7:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
       <s:if test="showSubsidyAndAchievementCommission">
       <s:if test="showSubsidy">
		<span class="fb">员工津贴------></span>
		<span>未发津贴：<em class="color" ><s:property value="subsidyTotal"/></em></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<span><s:property value="sendMonth"/>月发放津贴：<em class="color" ><s:property value="subsidyMonth"/></em></span>
       </s:if>
       <s:if test="showAchievementCommission">
		<hr/>
		<span class="fb">员工提成------></span>
		<span><s:property value="commissionMonth"/>月发放提成：<em class="color" ><s:property value="commissionMoneyMonth"/></em></span>
		<hr/>	
		<br/>
	   </s:if>
	   </s:if>
		
		
        <div class="detail mt20 pb30">

            <s:if test="showProductIndex">
                <div class="tab productIndex">
                    <div class="tab_title">
                        <s:iterator value="#request.productList" id="product" status="L">
                            <s:if test="#L.index == 0">
                                <a href="javascript:;" class="active" rel0="<s:property value="#L.index+1"/>" rel1="<s:property value="#product.getId()"/>" rel2="<s:property value="#product.status"/>">
                                    <s:property value="#product.name"/></a>
                            </s:if>
                            <s:else>
                                <a href="javascript:;" rel0="<s:property value="#L.index+1"/>" rel1="<s:property value="#product.getId()"/>" rel2="<s:property value="#product.status"/>">
                                    <s:property value="#product.name"/></a>
                            </s:else>
                        </s:iterator>
                    </div>
                    <div class="tab_content mt30">
                        <s:iterator value="#request.productList" id="product" status="L">
                            <s:if test="#L.index == 0">
                                <div class="tab_content<s:property value="#L.index+1"/> tabContent"
                                     style="display:block;">
                                </div>
                            </s:if>
                            <s:else>
                                <div class="tab_content<s:property value="#L.index+1"/> tabContent"
                                     style="display:none;">
                                </div>
                            </s:else>
                        </s:iterator>
                    </div>
                </div>
            </s:if>
            
            <!-- blow all create by Zorro 2015/4/21-->
            
            
            
            
            
            <s:if test="showSalesIndex">
                <div class="tab salesIndex">
                    <div class="tab_title">
                        <s:iterator value="#request.productList" id="product" status="L">
                            <s:if test="#L.index == 0">
                                <a href="javascript:;" class="active" rel0="<s:property value="#L.index+1"/>" rel1="<s:property value="#product.getId()"/>" rel2="<s:property value="#product.status"/>">
                                    <s:property value="#product.name"/></a>
                            </s:if>
                            <s:else>  
                                <a href="javascript:;" rel0="<s:property value="#L.index+1"/>" rel1="<s:property value="#product.getId()"/>" rel2="<s:property value="#product.status"/>">
                                    <s:property value="#product.name"/></a>
                            </s:else>
                        </s:iterator>
                    </div>
                    <div class="tab_content mt30">
                        <s:iterator value="#request.productList" id="product" status="L">
                            <s:if test="#L.index == 0">
                                <div class="tab_content<s:property value="#L.index+1"/> tabContent"
                                     style="display:block;">
                                </div>
                            </s:if>
                            <s:else>
                                <div class="tab_content<s:property value="#L.index+1"/> tabContent"
                                     style="display:none;">
                                </div>
                            </s:else>
                        </s:iterator>
                    </div>
                </div>
            </s:if>
            
            
            <s:if test="showNeedReleaseIndex">
	             <div class="tab needReleaseTaskIndex">
	            </div>
            </s:if>
<s:if test="showPresidentIndex">
<s:if  test="showPresidentIndex&&showActivityIndex">  
      <div class="tab">
            <div class="tab_title">
            <s:if test="showPresidentIndex">
            <a href="javascript:;" class="active" >销售首页</a>
            </s:if>
            <s:if test="showActivityIndex">
            <a href="javascript:;" >活动中心</a>
            </s:if>
            </div>
      <ul class="tab_content mt30">
        <li class="tab_content1 tabContent" style="display: block;">
                <div class="tab presidentIndex">
                    <div class="tab_title">
                        <s:iterator value="#request.productList" id="product" status="L">
                            <s:if test="#L.index == 0">
                                <a href="javascript:;" class="active" rel0="<s:property value="#L.index+1"/>" rel1="<s:property value="#product.getId()"/>" rel2="<s:property value="#product.status"/>">
                                    <s:property value="#product.name"/></a>
                            </s:if>
                            <s:else>
                                <a href="javascript:;" rel0="<s:property value="#L.index+1"/>" rel1="<s:property value="#product.getId()"/>" rel2="<s:property value="#product.status"/>">
                                    <s:property value="#product.name"/></a>
                            </s:else>
                        </s:iterator>
                    </div>
                    <div class="tab_content mt30">
                        <s:iterator value="#request.productList" id="product" status="L">
                            <s:if test="#L.index == 0">
                                <div class="tab_content<s:property value="#L.index+1"/> tabContent"
                                     style="display:block;">
                                </div>
                            </s:if>
                            <s:else>
                                <div class="tab_content<s:property value="#L.index+1"/> tabContent"
                                     style="display:none;">
                                </div>
                            </s:else>
                        </s:iterator>
                    </div>
                </div>
        	</li>
        	<li class="tab_content2 tabContent">
                <div class="tab activityIndex">
	            </div>
           </li>
      </ul>
    </div>
</s:if>
</s:if>
<s:else>
<s:if test="showActivityIndex">
<div class="tab activityIndex"></div>
</s:if>
</s:else>
             <s:if test="showSalesDirectorIndex">
                <div class="tab salesDirectorIndex">
                    <div class="tab_title">
                        <s:iterator value="#request.productList" id="product" status="L">
                            <s:if test="#L.index == 0">
                                <a href="javascript:;" class="active" rel0="<s:property value="#L.index+1"/>" rel1="<s:property value="#product.getId()"/>" rel2="<s:property value="#product.status"/>">
                                    <s:property value="#product.name"/></a>
                            </s:if>
                            <s:else>
                                <a href="javascript:;" rel0="<s:property value="#L.index+1"/>" rel1="<s:property value="#product.getId()"/>" rel2="<s:property value="#product.status"/>">
                                    <s:property value="#product.name"/></a>
                            </s:else>
                        </s:iterator>
                    </div>
                    <div class="tab_content mt30">
                        <s:iterator value="#request.productList" id="product" status="L">
                            <s:if test="#L.index == 0">
                                <div class="tab_content<s:property value="#L.index+1"/> tabContent"
                                     style="display:block;">
                                </div>
                            </s:if>
                            <s:else>
                                <div class="tab_content<s:property value="#L.index+1"/> tabContent"
                                     style="display:none;">
                                </div>
                            </s:else>
                        </s:iterator>
                    </div>
                </div>
            </s:if> 
                
            
            
            
            
            ${pageVar}
        </div>
    </m:Content>
</m:ContentPage>
