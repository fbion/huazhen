<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>
<style> @media Print { #header , .siderbarDolist , .borderBott , .siderbar , #footer , .notPrint { DISPLAY: none }}
</style>
<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 pb30">
            <div class="tab">
                <div class="tab_title notPrint">
                    <a href="javascript:;" class="active">试用期工作总结</a>
                </div>
                <!--startprint1-->
                <ul class="tab_content" id="contentUl">
                    <li class="tab_content1  tabContent" style="display:block;">
                        <div class="basic_Info_content p15 info_All">
                            <form id="probationWorkSummaryAdd" style="z-index:99;">
							   	<div class="wrappContent p30">
							        <div class="detail mt20 pl20 pb30 ">
							          <div class="tableCenter" id="contentDiv">
							        	<h5 class="tc">试用期工作总结</h5>
							            <table align="center" border="1" >
							              <tr>
							                <td width="60" valign="center" >姓名 </td>
							                <td width="188" valign="top" ><input type="hidden"  id="empNo" name="empNo" value="<s:property value="empNo"/>"/><input id="empName" type="text" value='<s:property value="#request.empName"/>' disabled="disabled" class="ml20" style="width:130px;"/>
                                        	<div class="Validform_checktip"></div></td>
							               <td width="132" valign="center" >部门</td>
							               <td width="279" valign="center" >
											   <%--<span class="DivSelects" style="display:inline-block;"><input type="hidden" id="hcompanyNo" value="<s:property value="companyNo"/>"/> <select id="companyNo" name="companyNo" type="text" disabled="disabled" class="SelectLists" style="width:130px;" ></select><div class="Validform_checktip"></div></span>--%>
											   <span class="DivSelects" style="display:inline-block; width:200px;"><input type="hidden" id="hdeptNo" value="<s:property value="deptNo"/>"/><select id="deptNo" name="deptNo" type="text" disabled="disabled" class="SelectLists"  style="width:205px;"></select><div class="Validform_checktip"></div></span>
							               </td>
							             </tr>
							             <tr>
							               <td width="60" valign="center" >职位</td>
							               <td width="188" valign="center" ><span class="DivSelects" style="display:inline-block;"><input type="hidden" id="hpositionNo" value="<s:property value="positionNo"/>"/><select id="positionNo" name="positionNo" type="text" disabled="disabled" class="SelectLists" style="width:130px;"></select>
                                           <div class="Validform_checktip"></div></span></td>
							               <td width="132" valign="center" >试用期起止时间</td>
							               <td width="279" valign="top" ><span><input id="startTime" name="startTime" type="text" disabled="disabled" class="data" style="width:100px;"/><div class="Validform_checktip"></div></span>
							               	至<span><input id="endTime" name="endTime" type="text" disabled="disabled" class="data" style="width:100px;"/><div class="Validform_checktip"></div></span></td>
							             </tr>
							             <tr >
							               <td width="60" valign="center" >工<br />作<br />总<br />结</td>
							               <td width="600" valign="top" colspan="3" >
							               	<div class="tl">主要工作任务及业绩：</div>
							               	<textarea id="workSummary" name="workSummary" type="text" disabled="disabled" class="data" style="height:220px;"></textarea>
                                            <div class="Validform_checktip"></div>
										</td>
							             </tr>
							             <tr >
							               <td width="60" valign="center" >自<br />我<br />评<br />价</td>
							               <td width="600" valign="top" colspan="3" ><textarea id="selfEvaluation" name="selfEvaluation" type="text" disabled="disabled" class="data" style="height:200px;"></textarea>
                                           <div class="Validform_checktip"></div></td>
							             </tr>
							             <tr >
						                    <td width="60" valign="center" >工作<br />建议<br />及自<br />我发<br />展思<br />路</td>
						                    <td width="600" valign="top" colspan="3" ><textarea id="workSuggestion" name="workSuggestion" type="text" disabled="disabled" class="data" style="height:220px;"></textarea>
						                    <div class="Validform_checktip"></div></td>
						                 </tr>
							           </table>
							           <div>申请转正人员填写，试用期结束前两周作为考核评估材料提交直接上级。</div>
							       	</div>
							       </div>


                                <p id="btn"  class="notPrint">
                                    <em id="msg"></em>
                                    <s:if test="showEditButton">
                                        <input type="button" id="edit" value="修改"
                                               class="submit_Btn none btn_style"/>
                                    </s:if>
                                    <s:if test="showSubmitButton">
                                        <input type="submit" id="submit" value="提交" class="submit_Btn none btn_style"/>
                                    </s:if>
                                    <input type="button" id="back" value="返回" class="cancel_Btn btn_style"/>
                                    <input type="button" id="print" value="打印" class="cancel_Btn btn_style"/>
                                </p>
                                </div>
                            </form>
                            <div class="trackBtn notPrint" style="position:absolute;z-index:1;"></div>
                        </div>
                    </li>
                </ul>
                <!--endprint1-->
            </div>
        </div>
        
        ${pageVar}
    </m:Content>
</m:ContentPage>