<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 pb30">
            <div class="tab">
                <div class="tab_title">
                    <a href="javascript:;" class="active">评估确认单管理</a>
                </div>
                <ul class="tab_content">
                    <li class="tab_content1  tabContent" style="display:block;">
                        <div class="basic_Info_content p15 info_All">
                            <form id="managerEvaluationAdd" style="z-index:9999;">
								
					            <div class="detail mt20 pl20 pb30 ">
					              	<div class="tableCenter" >
						            	<h5 class="tc">日常管理评估事实说明及评分确认单</h5>
						            	<%-- <input type="hidden" id="activitiStatus" value="${activitiStatus}"/>
           								<input type="hidden" id="backUrl" value="${backUrl}"/> --%>
						                <table align="center" border='1' id="aduitComment">
						                  <tr >
						                    <td width="355" valign="top" >评估事实说明</td>
						                    <td width="151" valign="top" >评分依据</td>
						                    <td width="172" valign="top" >评分及处理意见</td>
						                  </tr>
						                  <tr >
						                    <td width="355" valign="top" >
						                    	<textarea style="width:345px; height:166px;" id="scoreIntroduction" name="scoreIntroduction" disabled="disabled" class="data"></textarea>
						                    	<div class="Validform_checktip"></div>
						                    </td>
						                    <td width="151" valign="top" ><textarea style="width:140px; height:166px;" id="scoreAccord" name="scoreAccord" disabled="disabled" class="data"></textarea><div class="Validform_checktip"></div></td>
						                    <td width="172" valign="top" >
						                    	评分：<span><input id="score" name="score" type="text" disabled="disabled" class="ml10 data"/>
                                        		<div class="Validform_checktip"></div></span>
						                    	处理意见：<span><textarea style="width:160px; height:136px;" id="suggestion" name="suggestion" disabled="disabled" class="data"></textarea><div class="Validform_checktip"></div></span>
						                    </td>
						                  </tr>
						                  <tr>
						                  	<td><span class="signingDate tr" >被评估人：</span><span class="DivSelects" style="display:inline-block;"><select id="companyNo" name="companyNo" disabled="disabled" class="SelectLists data" style="width:130px;"></select><div class="Validform_checktip"></div></span>
						                	<span class="DivSelects" style="display:inline-block;"><select id="deptNo" name="deptNo" disabled="disabled" class="SelectLists data" style="width:130px;"></select><div class="Validform_checktip"></div></span>
						                	<span class="DivSelect" style="display:inline-block;"><select id="empNo" name="empNo" type="text" disabled="disabled" class="SelectLists data" style="width:95px;"></select><div class="Validform_checktip"></div></span></td>
						                  	<td><span class="signingDate tr">评估人：</span><input type="text"  id="empNameByInUserNo" disabled="disabled" class="" value='<s:property value="empNameByInUserNo"/>' style="width:80px;"/></td>
						                	<td><span class="signingDate tr">日期：</span><input type="text" id="managerTime" class="data" disabled="disabled"/><div class="Validform_checktip"></div></td>
						                  </tr>
						                </table>
						                <!--<strong style="display:block;"><span class="signingDate tr">评估人：</span><input type="text"  id="empNameByInUserNo" disabled="disabled" class="ml20" value='<s:property value="empNameByInUserNo"/>'/><span class="signingDate tr">
						                	审核人：</span><select id="activitiNo" name="activitiNo" disabled="disabled" class="ml20 data"></select>
						                	<span class="signingDate tr" >被评估人：</span>
						                	<span><select id="companyNo" name="companyNo" disabled="disabled" class="ml20 data"></select><div class="Validform_checktip"></div></span>
						                	<span><select id="deptNo" name="deptNo" disabled="disabled" class="ml20 data"></select><div class="Validform_checktip"></div></span>
						                	<span><select id="empNo" name="empNo" type="text" disabled="disabled" class="ml20 data"></select><div class="Validform_checktip"></div></span></strong>
						                <strong style="display:block;"><span class="signingDate tr">日期：</span><input type="text" id="inTime" disabled="disabled" class="ml20"/><span class="signingDate tr">日期：</span><input type="text" id="activitiTime" disabled="disabled" class="ml20 data"/><div class="Validform_checktip"></div><span class="signingDate tr">日期：</span><input type="text" id="inTime1" disabled="disabled" class="ml20"/> </strong>-->
						            	<%-- <strong style="display:block;"><span class="signingDate tr">评估人：</span><input type="text"  id="empNameByInUserNo" disabled="disabled" class="" value='<s:property value="empNameByInUserNo"/>' style="width:80px;"/>
						                	<span class="signingDate tr" >被评估人：</span>
						                	<span class="DivSelects" style="display:inline-block;"><select id="companyNo" name="companyNo" disabled="disabled" class="SelectLists data" style="width:130px;"></select><div class="Validform_checktip"></div></span>
						                	<span class="DivSelects" style="display:inline-block;"><select id="deptNo" name="deptNo" disabled="disabled" class="SelectLists data" style="width:130px;"></select><div class="Validform_checktip"></div></span>
						                	<span class="DivSelect" style="display:inline-block;"><select id="empNo" name="empNo" type="text" disabled="disabled" class="SelectLists data" style="width:80px;"></select><div class="Validform_checktip"></div></span></strong>
						                <strong style="display:block;"><span class="signingDate tr">日期：</span><input type="text" id="inTime" class="data" disabled="disabled"/><span class="signingDate tr">日期：</span><input type="text" id="inTime1" class="data" disabled="disabled"/> </strong> --%>
                                    <div id="errMsg" style="color: red"></div>
                                    </div>
						            <br>    
						        
						        
	                                <p id="btn">
	                                    <em id="msg"></em>
	                                    <s:if test="showEditButton">
	                                        <input type="button" id="edit" value="修改"
	                                               class="submit_Btn none btn_style"/>                                        
	                                    </s:if>
	                                    <s:if test="showSubmitButton">
	                                    <input id="submitExamine" type="button" value="提交审批" class="submit_Btn btn_style"/>
	                                        <input type="submit" id="submit" value="提交" class="submit_Btn none btn_style"/>
	                                    </s:if>
	                                    	<s:if test="showExamineButton">
                                                <input id="examine"  type="button" value="审批" class="submit_Btn btn_style"/>
             							</s:if>   
	                                    <input type="button" id="back" value="返回" class="cancel_Btn btn_style"/>
	                                </p>
                                </div>
								<div class="trackBtn"></div>
                                <div id="w1" class="easyui-window" title="评估确认单审批" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:500px;height:200px;padding:10px;">
									<div>
										<textarea id="taskCommet" style="width:450px; height:100px;"></textarea>
										<div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
											<input id="submit1" name="submit" type="submit" value="通过"class="submit_Btn  btn_style examine"/>
							              		<input id="submit2" name="" type="submit" value="不通过" class="submit_Btn  btn_style examine"/>
										</div>
									</div>
								</div>
                            </form>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        ${pageVar}
    </m:Content>
</m:ContentPage>