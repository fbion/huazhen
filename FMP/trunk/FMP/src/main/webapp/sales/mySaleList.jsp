<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>
                        	<table border="1" width="70%" class="activityTheme tc">
                                	<tr>
                                        <th class="tc" height="36">员工姓名</th>
                                        <th class="tc">性别</th>
                                        <th class="tc">部门</th>
                                        <th class="tc">职位</th>
                                        <th class="tc">邀约人数</th>
                                        <th class="tc">实到人数</th>
                                        <th class="tc">联系方式</th>
                                        <th class="tc">签到情况</th>
                                    </tr>
                                  <s:iterator value="#request.applyEmployeePagedList.resultList" id="item" >
                                	<tr>
                                    	<td height="30">
                                    	<s:property value="#item.name"/>
                                        </td>
                                        <s:if test="#item.sex==1">
                                        <td>男</td>
                                        </s:if>
                                        <s:if test="#item.sex==2">
                                        <td>女</td>
                                        </s:if>
                                        <s:if test="#item.sex==0">
                                        <td>未知</td>
                                        </s:if>
                                        <td><s:property value="#item.deptName"/></td>
                                        <td><s:property value="#item.positionName"/></td>
                                        <td><s:property value="#item.inviteNum"/></td>
                                        <td><s:property value="#item.arriveNum"/></td>
                                        <td>
                                        <s:property value="#item.tel"/>
                                        </td>
                                        <td height="30">
                                        <s:if test="#item.isSign==0">
             							未签到				
                                    	</s:if>
                                    	<s:if test="#item.isSign==1">
             							已签到				
                                    	</s:if>
                                        </td>
                                    </tr>
                                    </s:iterator>
                            </table>
                        	<!-- 页码 -->
        <div class="productList_page mt50">
            <div class="myInvestment_page">
                共<span class="pl5 pr5" id="saleTotalCount">${totalCount}</span>条记录
                <div id="pagination" class="salePagination"></div>
                <s:if test="pageIndex!=0">
                    第<span class="pl5 pr5">${pageIndex}</span>页&nbsp共<span class="pl5 pr5" >${pageCount}</span>页
                </s:if>
                <input type="hidden" id="pageIndex" value="${pageIndex}"/>
            </div>
        </div>
        
