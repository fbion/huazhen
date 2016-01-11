<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 pb30">
        <div class="tab">
        <div class="tab_title">
            <a href="javascript:;" class="active">考勤申请管理</a>
        </div>
        <ul class="tab_content">
        <li class="tab_content1  tabContent" style="display:block;">
        <div class="basic_Info_content p15 info_All">
         <form id="attendanceApplicationAdd" style="z-index:9999;">
            <!--<div class="detail mt20 pb30 ">-->
              <div class="tableCenter">
            	<h5 class="tc">员工考勤申请表</h5>
                <table align="center" border="1" id="aduitComment">
                  <tr >
                    <td width="66" height="30" valign="center" >姓名</td>
                    <td width="123" valign="center" >
                    <div class="DivSelect">
                    <select id="empNo" name="empNo"  disabled="disabled" class="SelectList data" width="100%"></select><div class="Validform_checktip">
                    </div></div>
                    </td>
                    <td width="66" valign="center" >部门</td>
                    <td width="137" valign="center" >
                    <div class="DivSelect" style="width:100px;">
                    <select id="deptNo" name="deptNo"  disabled="disabled" class="SelectList data" style="width:150px;"></select><div class="Validform_checktip"></div>
                    </div></td>
                    <td width="71" valign="center" >职位</td>
                    <td width="207" valign="center" >
                       <div class="DivSelect" style="width:100px;">
                    <select id="positionNo" name="positionNo" disabled="disabled" class="SelectList data" style="width:180px;"></select><div class="Validform_checktip"></div>
                    </div></td>
                  </tr>
                  <tr >
                    <td width="66" valign="center" >类型</td>
                    <td width="605" valign="center" colspan="5"  class="tl"><input type="checkbox"  value="1" style="width:20px; height:20px; vertical-align:middle;" />事假&nbsp;<input type="checkbox"  value="2" style="width:20px; height:20px; vertical-align:middle;" />病假&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"  value="3" style="width:20px; height:20px; vertical-align:middle;" />调休&nbsp;<input type="checkbox"  value="4" style="width:20px; height:20px; vertical-align:middle;" />婚假&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"  value="5" style="width:20px; height:20px; vertical-align:middle;" />孕检&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"  value="6" style="width:20px; height:20px; vertical-align:middle;" />产假<br />
                    <input type="checkbox"  value="7" style="width:20px; height:20px; vertical-align:middle;" />丧假
                    <input type="checkbox"  value="8" style="width:20px; height:20px; vertical-align:middle;" />护理假
                    <input type="checkbox"  value="9" style="width:20px; height:20px; vertical-align:middle;" />年假
                    <input type="checkbox"  value="10" style="width:20px; height:20px; vertical-align:middle;" />福利假
                    <input type="checkbox"  value="11" style="width:20px; height:20px; vertical-align:middle;" />工伤假
                      <div class="tl mt15"><input type="checkbox" value="0" style="width:20px; height:20px; vertical-align:middle;" />其他(请注明)：
                      <input id="remark" name="remark" type="text" disabled="disabled" class="data" style="width:480px; text-align:left;"/><div class="Validform_checktip"></div>
                      </div>
                     </td>
                  </tr>
                  <div  hidden="hidden">
                  <input id="type" name="type" type="text" disabled="disabled" class="ml20 data"/><div class="Validform_checktip"></div>
                  </div>
                  <tr >
                    <td width="66" valign="center" >时间</td>
                    
                    <td width="605" valign="center" colspan="5" >
                    	<%-- 自<input type="text" style="width:50px;" />年<input type="text" style="width:22px;" />月<input type="text" style="width:22px;" />日<input type="text" style="width:22px;" />时至<input type="text" style="width:22px;" />月<input type="text" style="width:22px;" />日<input type="text" style="width:22px;" />时<span class="ml30"></span>共计<input type="text" style="width:22px;" />日<input type="text" style="width:22px;" />时 --%>
                    	自：<input id="startTime" name="startTime" type="text" disabled="disabled" class="data" style="width:160px;"/>至：<input id="endTime" name="endTime" type="text" 
                        disabled="disabled" class="data"  style="width:160px;"/>
                    	共计：<input id="totalDay" name="totalDay" type="text" disabled="disabled" class="data" style="width:30px;"/>日
                    	<input id="totalHour" name="totalHour" type="text" disabled="disabled" class="data" style="width:30px;"/>小时
                    </td>
                  </tr>
                  <tr >
                    <td width="66" valign="center" >事由</td>
                    <td width="605" valign="center" colspan="5" >
                    	<textarea id="reason" name="reason" type="text" disabled="disabled" class="data" style="width:600px;"></textarea><div class="Validform_checktip"></div>
                    </td>
                  </tr>
                 <!--  <tr >
                    <td width="66" valign="center" >审批</td>
                    <td width="605" valign="center" colspan="5" >主管：<input type="text" style="width:136px;" />HR：<input type="text" style="width:136px;" />公司领导：<input type="text" style="width:136px;" /></td>
                  </tr> -->
                </table>
	             <!--</div>-->
                 <p id="btn" class="mt20">
                   <em id="msg" class="color"></em>
                   <s:if test="showEditButton">
                        <input type="button" id="edit" value="修改"
                               class="submit_Btn none btn_style"/>                                        
                    </s:if>
                    <s:if test="showSubmitButton">
                        <input type="submit" id="submit" value="保存" class="submit_Btn none btn_style"/>
                        <input id="submitExamine"  type="button" value="提交审批" class="submit_Btn btn_style"/>
                    </s:if>
				     <s:if test="showExamineButton">
                         <input id="examine"  type="button" value="审批" class="submit_Btn btn_style"/>
                     </s:if>
                    <input type="button" id="back" value="返回" class="cancel_Btn btn_style"/>
                </p>
            </div>
            <div id="w1" class="easyui-window" title="员工考勤申请表审批" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:500px;height:200px;padding:10px;">
				<div>
					<textarea id="taskCommet" style="width:450px; height:100px;"></textarea>
					<div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
						<input id="submit1" name="submit" type="submit" value="下一步"class="submit_Btn  btn_style examine"/>
		              		<input id="submit2" name="" type="submit" value="驳回" class="submit_Btn  btn_style examine"/>
					</div>
				</div>
			</div>
             <div class="trackBtn"></div>
        </form>

        </div>
        </li>
        </ul>
        </div>
        </div>
        
        
        ${pageVar}
    </m:Content>
</m:ContentPage>