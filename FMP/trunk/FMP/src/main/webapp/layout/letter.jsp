<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<ul>
    <s:iterator value="#request.letterList" id="item">
        <li class="p10">
            <a href="/fmp/baseInfo/letter/edit?id=<s:property value="#item.id"/>" >
                <span>
                    <s:property value="#item.subject"/>&nbsp;&nbsp;
                    <br />
                    <s:date name="#item.inTime" format="yyyy-MM-dd hh:mm:ss"/>
                    <s:if test="#item.status==1">待处理</s:if>
                    <s:if test="#item.status==2">处理中</s:if>
                    <s:if test="#item.status==3">已处理</s:if>
                </span>
            </a>
        </li>
    </s:iterator>
</ul>
<a href="/fmp/baseInfo/letter/list" class="tc mt10">查看更多</a>

