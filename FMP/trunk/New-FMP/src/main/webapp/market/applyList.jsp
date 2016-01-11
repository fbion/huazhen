<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>
                        	<div class="recruitInfo">
                                <h4 class="mt10">【活动主题】${activity.title}</h4>
                                <p class="mt10">
                                    活动时间：<strong class="mr30"><s:date name ="#request.activity.activityTime" format ="yyyy-MM-dd"/></strong>主讲嘉宾：<em class="mr30">${activity.empName}</em>
                                    状态：<em>              
                                    <s:if test="#request.activity.status==1">储备中</s:if>
                                    <s:if test="#request.activity.status==2">已发布</s:if>
                                    <s:if test="#request.activity.status==3">正在进行中</s:if>
                                    <s:if test="#request.activity.status==4">已结束</s:if>
                                    <s:if test="#request.activity.status==5">已取消</s:if>
				</em>
                                </p>
                                <table width="70%" class="mt30 tc customerReg">
                                	<thead>
                                        <tr>
                                            <th width="100" height="40" class="tc">姓名</th>
                                            <th width="126" class="tc">手机号</th>
                                            <th width="150" class="tc">邮箱</th>
                                            <th width="210" class="tc">单位</th>
                                            <th width="210" class="tc">职务</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <s:iterator value="activityApplyUserPagedList.resultList" var="activityApplyUser">
                                    <tr class="customerReg_title">
                                            <td height="40">${activityApplyUser.name}</td>
                                            <td>${activityApplyUser.cellphone}</td>
	                                        <td>${activityApplyUser.email}</td>
	                                        <td>${activityApplyUser.unit}</td>
                                            <td>${activityApplyUser.job}</td>
                                        </tr>
                                    </s:iterator>
                                    </tbody>
                                </table>
                                <!-- 页码 -->
			        <div class="productList_page mt50">
			            <div class="myInvestment_page">
			                共<span class="pl5 pr5" id="applyTotalCount">${activityApplyUserPagedList.pagingInfo.totalCount}</span>条记录
			                <div id="applyPagination"></div>
			                <s:if test="activityApplyUserPagedList.pagingInfo.totalCount!=0">
			                    第<span class="pl5 pr5">${activityApplyUserPagedList.pagingInfo.pageIndex}</span>页&nbsp共<span class="pl5 pr5" >${activityApplyUserPagedList.pagingInfo.pageCount}</span>页
			                </s:if>
			                <input type="hidden" id="pageIndex" value="${activityApplyUserPagedList.pagingInfo.pageIndex}"/>
			            </div>
        		</div>

        </div>
