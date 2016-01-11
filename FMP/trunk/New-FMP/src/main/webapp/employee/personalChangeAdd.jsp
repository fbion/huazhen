<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
    
    <!-- <input id="positionNo" name="positionNo" type="text" disabled="disabled" class="ml20 data"/><div class="Validform_checktip"></div> -->
        <div class="detail mt20 pb30">
        <div class="tab">
        <div class="tab_title">
            <a href="javascript:;" class="active">人事变动管理</a>
        </div>
        <ul class="tab_content">
        <li class="tab_content1  tabContent" style="display:block;">
        <div class="basic_Info_content p15 info_All">
        <form id="personalChangeAdd" style="z-index:9999;">
        
            <div class="detail mt20 pb30 ">
              <div class="tableCenter">
            	<h5 class="tc">人事变动表</h5>
            	<%-- <input type="hidden" id="activitiStatus" value="${activitiStatus}"/>
            	<input type="hidden" id="backUrl" value="${backUrl}"/> --%>
                <p>编号:<span>
                <input id="code" name="code" type="text" disabled="disabled" class="data"/><span class="Validform_checktip yz"></span></span></p>
                <table align="center" border="1" id="aduitComment">
                  <tr >
                    <td width="79" height="30" valign="center" >姓名</td>
                    <td width="104" valign="center" >
                    <div class="DivSelect">
					<select id="empNo" name="empNo"  disabled="disabled" class="data SelectList" style="width:100px;"></select><div class="Validform_checktip"></div>
					</div>
                    </td>
                    <td width="108" valign="center" >部门</td>
                    <td width="132" valign="center" >
                    <div class="DivSelect" style="width:100px;">
                    <select id="deptNo" name="deptNo" disabled="disabled" class="data SelectList" style="width:130px;"></select><div class="Validform_checktip"></div>
                    </div>
                    </td>
                    <td width="108" valign="center" >职位</td>
                    <td width="159" valign="center" >
                    <div class="DivSelect" style="width:100px;">
                    <select id="positionNo" name="positionNo" type="text" disabled="disabled" class="data SelectList" style="width:120px;"></select><div class="Validform_checktip"></div>
                    </div>
                    </td>
                  </tr>
                  <tr >
                    <td width="79" valign="center" >入职日期</td>
                    <td width="104" valign="center" >
                    <input id="startTime" name="startTime" type="text" disabled="disabled" class="data"/><div class="Validform_checktip"></div>
                    </td>
                    <td width="108" valign="center" >变动申请日</td>
                    <td width="132" valign="center" >
                    <input id="applyTime" name="applyTime" type="text" disabled="disabled" class="data"/><div class="Validform_checktip"></div>
					</td>
                    <td width="108" valign="center" >变动生效日</td>
                    <td width="159" valign="center" >
                    <input id="forceTime" name="forceTime" type="text" disabled="disabled" class="data"/><div class="Validform_checktip"></div>
                    </td>
                  </tr>
                  <tr >
                    <td width="691" align="center" valign="top" colspan="6" >
                    <div class="m10 tl">变动原因申请：</div>
                      <textarea style="width:680px;" id="reason" name="reason" type="text" disabled="disabled" class="data"/></textarea>
                      	<div>申请人：<span class="DivSelect mr15" style="display:inline-block;"><select 
                        id="empNo1" name="empNo"  disabled="disabled" class="SelectList" ></select>
						</span>日期：<input id="applyTime1" name="applyTime" type="text" disabled="disabled"/>
                     </div>
                    </td>
                  </tr>
                  <tr >
                    <td width="691" valign="top" colspan="6" align="left">
                      <div class="m10 tl">变动性质：</div>
                      <div class="mt10 tl">
                      <input type="checkbox" class="checkboxVal" id="checkbox1" style="width:20px; vertical-align:middle;" value="1"/>部门调动
                      <input type="checkbox" class="checkboxVal" id="checkbox2" style="width:20px; vertical-align:middle;" value="2"/>职位变动
                      <input type="checkbox" class="checkboxVal" id="checkbox3"  style="width:20px; vertical-align:middle;" value="3"/>工资调整
                      <input type="checkbox" class="checkboxVal" id="checkbox0" style="width:20px; vertical-align:middle;" value="0"/>其他</div>
                      <div hidden="hidden">
		            	<input id="activitiNo" name="activitiNo" type="text" disabled="disabled" class="ml20 data"/>
		            	<input id="property" name="property" type="text" disabled="disabled" class="ml20 data" />
		              </div>
                      <!-- <div class="mt30 tc">部门负责人：<input type="text" />日期：<input type="text" /></div>
                      <div class="ml10 tc">HR负责人：<input type="text" />日期：<input type="text" /></div></td> -->
                  </tr>
                  <tr class="checkbox1">
                     <td width="108" valign="center" >部门</td>
                    <td width="132" valign="center" >
                    <div class="DivSelect" style="width:100px;">
                    <select id="deptId"   class="data SelectList" style="width:130px;"></select><div class="Validform_checktip"></div>
                    </div>
                    </td>
                    <td width="108" valign="center" >职位</td>
                    <td width="159" valign="center" >
                    <div class="DivSelect" style="width:100px;">
                    <select id="positionId"  type="text"  class="data SelectList" style="width:120px;"></select><div class="Validform_checktip"></div>
                    </div>
                    </td>
                  </tr>
                  <tr class="checkbox2">
                   <!--  <td width="108" valign="center" >部门</td>
                    <td width="132" valign="center" >
                    <div class="DivSelect" style="width:100px;">
                     <input type="text" id="dNo" hidden="hidden">
                     </div>
                    </td> -->
                    <td width="108" valign="center" >职位</td>
                    <td width="159" valign="center" >
                    <div class="DivSelect" style="width:100px;">
                    <select id="pNo" name="positionNo" type="text"  class="data SelectList" style="width:120px;"></select><div class="Validform_checktip"></div>
                    </div>
                    </td>
                  </tr>
                  
                  <tr class="change">
                    <td width="108" valign="center" >部门</td>
                    <td width="132" valign="center" >
                    <div class="DivSelect" style="width:100px;">
                    <select id="afterDept" name="deptNo" disabled="disabled" class="data SelectList" style="width:130px;"></select><div class="Validform_checktip"></div>
                    </div>
                    </td>  
                    <td width="108" valign="center" >职位</td>
                    <td width="159" valign="center" >
                    <div class="DivSelect" style="width:100px;">
                    <select id="afterPosition" name="positionNo" type="text" disabled="disabled" class="data SelectList" style="width:120px;"></select><div class="Validform_checktip"></div>
                    </div>
                    </td>
                  </tr>
                  
                  <!--<tr >
                    <td width="691" valign="center" colspan="6" >
                      <div class="m10 tl">主管领导审批意见：</div>
                      <textarea style="width:670px;"></textarea>
                      <div>签名：<input type="text" />日期：<input type="text" /></div></td>
                  </tr>
                  <tr>
                    <td width="691" valign="top" colspan="6">
                    <div class="m10 tl">人事变动当事人确认：</div>
                    <textarea style="width:670px;"></textarea>
                    <div>签名：<input type="text" />日期：<input type="text" /></div></td>
                  </tr> -->
                </table>
            	</div>
                <p id="btn" class="mt20">
                    <em id="msg" class="color"></em>
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
            <div id="w1" class="easyui-window" title="人事变动表审批" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:500px;height:200px;padding:10px;">
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