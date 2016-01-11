<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
    	<div  hidden="hidden">
                  <input id="iskeepEmail" name="iskeepEmail" type="text"  class="data"/><div class="Validform_checktip"></div>
                  <input id="method" name="method" type="text" class="data"/><div class="Validform_checktip"></div>
        </div>
        <div class="detail mt20 pb30">
        <div class="tab">
        <div class="tab_title">
            <a href="javascript:;" class="active">离职申请管理</a>
        </div>
        <ul class="tab_content">
        <li class="tab_content1  tabContent" style="display:block;">
        <div class="basic_Info_content p15 info_All">
         <form id="resignApplicationAdd" style="z-index:9999;">
            <div class="detail mt20 pb30 ">
              <div class="tableCenter">
            	<h5 class="tc">离职申请表</h5>
            	<%-- <input type="hidden" id="activitiStatus" value="${activitiStatus}"/>
            	<input type="hidden" id="backUrl" value="${backUrl}"/> --%>
                <p>编号:<span><input id="code" name="code" type="text" disabled="disabled" class="ml5 data"/></span></p>
                <table align="center" border="1" id="aduitComment">
                  <tr>
                    <td width="142" height="30" valign="center" >员工姓名</td>
                    <td width="176" valign="center" >
                     <div class="DivSelects">
                    <select id="empNo" name="empNo"  disabled="disabled" class="SelectLists data" style="width:150px;"></select><div class="Validform_checktip"></div>
                     </div>
					
                    </td>
                    <td width="120"valign="center" >部门</td>
                    <td width="216" valign="center" >
                    <div class="DivSelects" style="width:150px;">
                    <select id="deptNo" name="deptNo"  style="width:180px;" type="text" disabled="disabled" class="SelectLists data"></select><div class="Validform_checktip"></div>
                    </div>
                    </td>
                  </tr>
                  <tr>
                    <td width="142"valign="center" >职位</td>
                    <td width="176" valign="center" >
                      <div class="DivSelects" style="width:120px;">
                    <select id="positionNo" name="positionNo" disabled="disabled" class="SelectLists data" style="width:150px;" ></select><div class="Validform_checktip"></div>
                    </div>
                    </td>
                    <td width="120"valign="center" >入职日期</td>
                    <td width="216" valign="top" >
                    <input id="hireTime" name="hireTime" type="text" disabled="disabled" class="data" style="width:180px;"/><div class="Validform_checktip"></div>
					</td>
                   </tr>
                  <tr>
                    <td width="142" valign="center" >离职方式</td>
                    <td width="176" valign="center" ><input type="radio" name="methodradio" value="2" style="width:20px; vertical-align:middle;"/>辞职<input type="radio" name="methodradio" value="1" style="width:20px; vertical-align:middle;"/>辞退<input type="radio" name="methodradio" value="0" style="width:20px; vertical-align:middle;"/>其他</td>
                    <td width="142"valign="center" >离职日期</td>
                    <td width="216" valign="top" >
                    <input id="leaveTime" style="width:180px;" name="leaveTime" type="text" disabled="disabled" class="data"/><div class="Validform_checktip"></div>
					</td>
                  </tr>
                  <tr>
                    <td width="142" valign="center" >离职原因</td>
                    <td width="630" valign="top" colspan="3" >
                      <textarea style="width:600px; height:130px;" id="reason" name="reason" type="text" disabled="disabled" class="data"></textarea><div class="Validform_checktip"></div>
                      <div>申请人（签字）：<span class="DivSelect mr15" style="display:inline-block;"><select 
                      id="empNo1" name="empNo"  disabled="disabled" class="SelectList" ></select></span>
						<!-- 申请时间<input id="applyTime1" name="applyTime" type="text" disabled="disabled" class="ml20"/> --></div>
                    </td>
                  </tr>
                  <tr>
                    <td width="142" valign="center" >是否保留邮箱</td>
                    <td width="176" valign="center" ><input type="radio" name="iskeepEmailr" value="1" style="width:20px; vertical-align:middle;"/>是<input type="radio" name="iskeepEmailr" value="0" class="ml15" style="width:20px; vertical-align:middle;"/>否</td>
                    <td width="120" valign="center" >保留至何时</td>
                    <td width="216" valign="center" >
                    <input id="keepTime" name="keepTime" style="width:192px;" type="text" disabled="disabled" class="data"/><div class="Validform_checktip"></div>
                    </td>
                  </tr>
                  <!-- <tr>
                    <td width="142" valign="center" >主管意见</td>
                    <td width="513" valign="top" colspan="3" >
                      <textarea style="width:510px; height:130px;"></textarea>
                      <div>签字：<input type="text" style="width:80px;"/><input type="text" style="width:50px;"/>年<input type="text" style="width:30px;"/>月<input type="text" style="width:30px;"/>日</div>
                    </td>
                  </tr>
                  <tr>
                    <td width="142" valign="center" >部门意见</td>
                    <td width="513" valign="top" colspan="3" >
                      <textarea style="width:510px; height:130px;"></textarea>
                      <div>签字：<input type="text" style="width:80px;"/><input type="text" style="width:50px;"/>年<input type="text" style="width:30px;"/>月<input type="text" style="width:30px;"/>日</div></td>
                  </tr>
                  <tr>
                    <td width="142" valign="center" >HR意见</td>
                    <td width="513" valign="top" colspan="3" >
                      <textarea style="width:510px; height:130px;"></textarea>
                      <div>签字：<input type="text" style="width:80px;"/><input type="text" style="width:50px;"/>年<input type="text" style="width:30px;"/>月<input type="text" style="width:30px;"/>日</div></td>
                  </tr>
                  <tr>
                    <td width="142" valign="center" >公司领导意见</td>
                    <td width="513" valign="top" colspan="3" >
                      <textarea style="width:510px; height:130px;"></textarea>
                      <div>签字：<input type="text" style="width:80px;"/><input type="text" style="width:50px;"/>年<input type="text" style="width:30px;"/>月<input type="text" style="width:30px;"/>日</div></td>
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
            <div id="w1" class="easyui-window" title="离职申请表审批" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:500px;height:200px;padding:10px;">
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