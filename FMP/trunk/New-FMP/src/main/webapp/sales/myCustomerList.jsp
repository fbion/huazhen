<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>
                        	<table border="1" width="70%" class="activityTheme tc">
                                	<tr>
                                    	<th height="36" valign="middle" class="tc">操作</th>
                                        <th class="tc">客户姓名</th>
                                        <th class="tc">客户性别</th>
                                        <th class="tc">联系方式</th>
                                        <th class="tc">客户等级</th>
                                        <th class="tc">风险偏好</th>
                                    </tr>
                                  <s:iterator value="#request.customerPersonalPagedList.resultList" id="item" >
                                	<tr>
                                		<td>
                                		<s:if test="#item.invit==1">
                                		已邀请
                                		</s:if>
                                		<s:else>
                                		<a href="javascript:invit(<s:property value="#item.id"/>)">邀请</a>
                                		</s:else>
                                		</td>
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
                                        <td>
                                        <s:property value="#item.cellphone1"/>
                                        <s:if test="#item.cellphone2!=null"><br>
                                        <s:property value="#item.cellphone2"/>
                                        </s:if>
                                        </td>
                                        <td><s:property value="#item.level"/></td>
                                        <td><s:property value="#item.hobby"/></td>
                                    </tr>
                                    </s:iterator>
                            </table>
                        	<!-- 页码 -->
        <div class="productList_page mt50">
            <div class="myInvestment_page">
                共<span class="pl5 pr5" id="totalCount">${totalCount}</span>条记录
                <div id="pagination"></div>
                <s:if test="pageIndex!=0">
                    第<span class="pl5 pr5">${pageIndex}</span>页&nbsp共<span class="pl5 pr5" >${pageCount}</span>页
                </s:if>
                <input type="hidden" id="pageIndex" value="${pageIndex}"/>
                <input type="hidden" id="pageUrl" value="${knowledgeBaseList}"/>
            </div>
        </div>
        
