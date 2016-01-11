<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">

	   <div class="wrappContent p30">
            <div class="detail mt20 pb30 ">
                <div class="tab">
                    <div class="tab_title">
                            <a  class="active">招聘需求</a>
                    </div>
                    <ul class="tab_content">
                    <s:iterator value="#request.needReleases" id="item" >
                        <li class="tab_content1 tabContent" style="display: block;">
                        	<div class="recruitInfo">
                                <h4 class="mt30">关于<s:property value="#item.deptName"/>的人员招聘</h4>
                                <p class="mt10">
                                	发布时间：<strong class="mr30"><s:date name="#item.inTime" format="yyyy-MM-dd HH:mm:ss" /></strong>
                                	发布人：<em><s:property value="#item.inUserName"/></em>
                                </p>
                                <p>
                                    <span><s:property value="#item.deptName"/></span>
                                    <span class="span1"><s:property value="#item.PositionName"/></span>
                                    <span class="span2"><s:property value="#item.addEmp"/> 人</span>
                                  	  到岗时间：<span><s:date name="#item.workTime" format="yyyy-MM-dd" /></span>
                                </p>
                                <div class="recruitCont">
                                    <span>主要职责：</span>
                                    <em ><s:property value="#item.workProperty"/></em>
                                </div>
                                <p class="viewDetails">
                                	<a href="${needReleaseDetailUrl}<s:property value='#item.id'/>">查看详情>></a>
                                </p>
                            </div>
                        </li>
                        </s:iterator>
                    </ul>
                </div>
            </div>    
        </div>
	    
        ${pageVar}
    </m:Content>
</m:ContentPage>