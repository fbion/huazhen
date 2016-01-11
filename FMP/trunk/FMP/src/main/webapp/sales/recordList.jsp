<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>
						<%-- <div class="wrappSearch mt10">
                                <h3></h3>
                    
                                <div class="wrappSearchContent">
                                  	  员工姓名: <select class="mr20">
                                    			<option></option>
                                                <option></option>
                                                <option></option>
                                            </select>
                                    	客户手机号: <select class="mr20">
                                            	<option></option>
                                                <option></option>
                                                <option></option>
                                        </select>
                                    <input id="btnSearch" type="button" value="查询" class="btn_style">
                                    
                                </div>
                            </div> --%>
                        	<p class="mt10">
                            	<input type="button" value="导出excel表格" id="btnExcel" class="btn_style" />
                            	<input type="button" value="开始签到" id="updateStatus3" class="btn_style" />
                            	<input type="button" value="签到结束" id="updateStatus4" class="btn_style" />
                            </p>
                            
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
                                            <th width="168" height="40" class="tc">身份</th>
                                            <th width="126" class="tc">姓名</th>
                                            <th width="100" class="tc">性别</th>
                                            <th width="210" class="tc">联系方式</th>
                                            <th width="150" class="tc">客户关系等级</th>
                                            <th width="200" class="tc">风险偏好</th>
                                            <th width="200" class="tc">状态</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <s:iterator value="#request.applyEmployeePagedList.resultList" id="item">
                                    <tr class="customerReg_title">
                                            <td height="40">员工</td>
                                            <td><s:property value="#item.name"/></td>
                                            <s:if test="#item.sex==1">
	                                        <td>男</td>
	                                        </s:if>
	                                        <s:if test="#item.sex==2">
	                                        <td>女</td>
	                                        </s:if>
	                                        <s:if test="#item.sex==0">
	                                        <td>未知</td>
	                                        </s:if>
                                            <td><s:property value="#item.tel"/></td>
                                            <td></td>
                                            <td></td>
                                            <td>
                                            <s:if test="#item.isSign!=1">
                                            <s:if test="#request.activity.status==3">
                                            <a href="javaScript:empSign(<s:property value="#item.id"/>)">签到</a>
                                            </s:if>
                                            </s:if>
                                            <s:else>
                                            	已签到
                                            </s:else>
                                            </td>
                                        </tr>
                                        <s:iterator value="#request.applyCustomerInfos" id="detail" >
						                   <s:if test="#item.empNo== #detail.empNo">
							                  <tr>
	                                            <td height="40">客户</td>
	                                            <td><s:property value="#detail.name"/></td>
	                                            <s:if test="#detail.sex==1">
		                                        <td>男</td>
		                                        </s:if>
		                                        <s:if test="#detail.sex==2">
		                                        <td>女</td>
		                                        </s:if>
		                                        <s:if test="#detail.sex==0">
		                                        <td>未知</td>
		                                        </s:if>
	                                            <td>
	                                            <s:property value="#detail.tel"/>
                                        		<s:if test="#detail.mark!=null"><br>
                                        		<s:property value="#detail.mark"/>
                                        		</s:if>
                                        		</td>
	                                            <td>
	                                            <s:property value="#detail.levelName"/>
	                                           <%--  <input id="level" type="text" value="<s:property value="#detail.level"/>"/>
	                                            <select id="selectRelationLevel"></select> --%>
	                                            </td>
                                        		<td><s:property value="#detail.hobby"/></td>
                                        		<td>
                                        		<s:if test="#detail.isSign!=1">
                                        		<s:if test="#request.activity.status==3">
	                                            <a href="javaScript:customerSign(<s:property value="#detail.id"/>)">签到</a>
	                                            </s:if>
	                                            </s:if>
	                                            <s:else>
	                                            	已签到
	                                            </s:else>
	                                            </td>
                                          </tr>
						                  </s:if> 
						                  </s:iterator>
                                    </s:iterator>
                                    </tbody>
                                </table>
                                <!-- 页码 -->
			        <div class="productList_page mt50">
			            <div class="myInvestment_page">
			                共<span class="pl5 pr5" id="totalCount1">${totalCount}</span>条记录
			                <div id="pagination1"></div>
			                <s:if test="pageIndex!=0">
			                    第<span class="pl5 pr5">${pageIndex}</span>页&nbsp共<span class="pl5 pr5" >${pageCount}</span>页
			                </s:if>
			                <input type="hidden" id="pageIndex" value="${pageIndex}"/>
			            </div>
        		</div>

        </div>
