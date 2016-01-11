<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 pb30">
            <div class="tab">
                <div class="tab_title">
                    <a href="javascript:;" class="active">员工试用期转正评估</a>
                </div>
                <!--startprint1-->
                <ul class="tab_content">
                    <li class="tab_content1  tabContent" style="display:block;">
                        <div class="basic_Info_content p15 info_All">
                            <form id="probationEvaluationAdd" style="z-index:9999;">
                              	<div class="detail mt20 pb30 ">
									<div class="tableCenter">
									    <input type="hidden" id="addCompanyNo" value="<s:property value="companyNo"/>"/>
									    <input type="hidden" id="addDeptNo" value="<s:property value="deptNo"/>"/>
									    <input type="hidden" id="addPositionNo" value="<s:property value="positionNo"/>"/>
									    <input type="hidden" id="addEmpNo" value="<s:property value="empNo"/>"/>
									    <input type="hidden" id="addStartTime" value='<s:date name="startTime" format="yyyy-MM-dd"/>'/>
							            <%-- <input type="hidden" id="activitiStatus" value="${activitiStatus}"/>
	            						<input type="hidden" id="backUrl" value="${backUrl}"/> --%>
							            <div id="probationEvaluationContent"></div>      
		                                
							        </div>
						        	<p id="btn">
	                                    <em id="msg"></em>
	                                    <s:if test="showEditButton">
	                                        <input type="button" id="edit" value="修改"
	                                               class="submit_Btn none btn_style"/>                                        
	                                    </s:if>
	                                    <s:if test="showSubmitButton">
	                                    <input id="submitExamine" type="button" value="提交审批" class="submit_Btn btn_style"/>
	                                        <input type="submit" id="submit" value="保存" class="submit_Btn btn_style"/>
	                                    </s:if>
	                                    <s:if test="showExamineButton">
                                                <input id="examine"  type="button" value="审批" class="submit_Btn btn_style"/>
                                            </s:if>
	                                    <input type="button" id="back" value="返回" class="cancel_Btn btn_style"/>

                                        <input type="button" id="workSummary" value="查看该员工工作总结" class="cancel_Btn btn_style"/>
                                         
                                         <input type="button" id="print" value="打印" class="cancel_Btn btn_style"/>
                                        
	                                </p>
						        </div>
						        <div id="w1" class="easyui-window" title="员工试用期转正评估表审批" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:500px;height:200px;padding:10px;">
									<div>
										<textarea id="taskCommet" style="width:450px; height:100px;"></textarea>
										<div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
											<input id="submit1" name="submit" type="submit" value="通过"class="submit_Btn  btn_style examine"/>
							              		<input id="submit2" name="" type="submit" value="驳回" class="submit_Btn  btn_style examine"/>
										</div>
									</div>
								</div>
                            </form>
                            <div class="trackBtn"></div>
                        </div>
                    </li>
                </ul>
                <!--endprint1-->
            </div>
        </div>
        ${pageVar}
    </m:Content>
</m:ContentPage>