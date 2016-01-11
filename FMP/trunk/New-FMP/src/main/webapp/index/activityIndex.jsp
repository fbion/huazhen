<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<div class="viewDetails tr">
     <s:if test="#request.activity.size>0">
     <a href="${activityListUrl}">更多任务>></a>
    </s:if> 
   
</div>
 <ul class="tab_content">
  <s:iterator value="#request.activity" id="item" >
    <li class="tab_content1 tabContent" style="display: block;">
        <div class="recruitInfo">
            <h4 class="mt5">关于<s:property value="#item.title"/>的活动</h4>
            <p class="mt10">
                <span class="recruitTit">发布时间：</span><strong class="mr30">
                <s:date name="#item.publisherTime" format="yyyy-MM-dd" /></strong>
                <span class="recruitTit">主讲嘉宾：</span><em><s:property value="#item.empName"/> </em>
            </p>
            <p class="mt10">
                <span>活动主题</span>
                <span class="span1">活动时间</span>
                <span class="span2">活动地点</span>
            </p>
            <p class="mt5">
                <span><s:property value="#item.title"/></span>
                <span class="span1"><s:date name="#item.activityTime" format="yyyy-MM-dd" /></span>
                <span><s:property value="#item.address"/></span>
            </p>
        </div>
       
        <div class="btn mt20 tc" style="width:70%;">
        
        <a href="${activityDetailUrl}<s:property value="#item.id"/>">查看更多>></a>
            <!-- <input type="button"  value="查看更多" class="mr15 btn_style" /> -->
        </div>
    </li>
    </s:iterator>
</ul>

${pageVar} 
