<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<div class="viewDetails tr">
     <s:if test="#request.needReleases.size>0">
     <a href="${needReleaseListUrl}">更多任务>></a>
    </s:if> 
   
</div>
<ul class="tab_content">
    <s:iterator value="#request.needReleases" id="item" >
        <li class="tab_content1 tabContent" style="display: block;">
            <div class="recruitInfo">
                <h4 class="mt5">关于<s:property value="#item.deptName"/>的人员招聘</h4>
                <p class="mt10">
                      发布时间：<strong class="mr30">
                    <s:date name="#item.inTime" format="yyyy-MM-dd HH:mm:ss" />
                    </strong>发布人：<em><s:property value="#item.inUserName"/> </em>
                </p>
                <p>
                    <span><s:property value="#item.deptName"/></span>
                    <span class="span1"><s:property value="#item.PositionName"/></span>
                    <span class="span2"><s:property value="#item.addEmp"/> 人</span>
                    到岗时间：<span><s:date name="#item.workTime" format="yyyy-MM-dd" /></span>
                </p>
                <div class="recruitCont">
                    <span>主要职责：</span>
                    <em><s:property value="#item.workProperty"/></em>
                </div>
                <p class="viewDetails">
                    <a href="${needReleaseDetailUrl}<s:property value='#item.id'/>">查看详情>></a>
                </p>
            </div>
        </li>
    </s:iterator>
</ul>
${pageVar} 
