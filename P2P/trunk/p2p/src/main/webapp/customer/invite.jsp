 <%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>


          <li class="hd borderBott">
              <span class="span8">用户名</span>
              <span class="span5">手机号码</span>
              <span class="span2">注册时间</span>
              <span class="span5">实名认证时间</span>
              <%-- <span class="span2">邀请奖励</span> --%>
              <span class="span9">是否生效</span>
          </li>
          <s:iterator value="#request.activityCustomerInvitation" id="item">
              <li class="bd borderBott">
                  <span class="span8">
                  
                  <s:if test="#item.p2pCustomerName==null">
                       --
                  </s:if><s:else>
                  <s:property value="#item.p2pCustomerName"/>
                   </s:else>
                  </span>
                  <span class="span5">
                  <s:property value="#item.invitePhoneNo"/>
                  </span>
                  
                  <span class="span2"><s:date name="#item.registerTime" format="yyyy-MM-dd"/></span>
                  
                  <span class="span5">
                  <s:if test="#item.authenticationTime==null">
                       --
                  </s:if><s:else>
                  <s:date name="#item.authenticationTime" format="yyyy-MM-dd"/>
                  </s:else>
                  </span>
                  
                 
                  
                 <%--  <span class="span2"><s:property value="#item.showRewardsMoney"/></span> --%>
                  <span class="span9"><s:property value="#item.invitionStatue"/></span>
              </li>
          </s:iterator>
        <div class="myInvestment_page mt50">
            <div class="myInvestment_page mt50 tc">
                <div id="pagination"></div>
                <s:if test="pageIndex!=0">
                第<span class="pl5 pr5">${pageIndex}</span>页&nbsp;
                共<span class="pl5 pr5" >${pageCount}</span>页
                </s:if>
                共<span class="pl5 pr5" id="totalCount">${totalCount}</span>条记录
            </div>
        </div>
