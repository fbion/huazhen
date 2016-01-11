<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <form id="extendProbationApplicationAdd" method="post">
            <!--<div class="wrappContent p30">-->
            <div class="detail mt20 pb30 ">
                <div class="tableCenter">
                    <h5 class="tc">延长试用期申请表</h5>
                        <%-- <input type="hidden" id="activitiStatus" value="${activitiStatus}"/>
                        <input type="hidden" id="backUrl" value="${backUrl}"/> --%>
                    <p style="height:auto;">编号：<span
                            style="display:inline-block; width:150px; border-bottom:none; vertical-align:top; margin-top:6px;"><input
                            type="text" id="code" class="data"/><span class="Validform_checktip"></span></span></p>
                    <table align="center" border="1" id="aduitComment">
                        <tr>
                            <td width="79" height="30" valign="center">姓名</td>
                            <td width="104" valign="center">
                                <input type="hidden" id="empNo"/>
                                <input type="text" id="empName" class='data' readonly="readonly"/>
                            </td>
                            <td width="108" valign="center">部门</td>
                            <td width="132" valign="center">
                                <div class="DivSelects" disabled="disabled">
                                    <select disabled="disabled" class='SelectLists tc' id="deptNo"
                                            style="width:130px;"></select>
                                </div>
                            </td>
                            <td width="108" valign="center">职位</td>
                            <td width="159" valign="center">
                                <div class="DivSelects" disabled="disabled">
                                    <select disabled="disabled" class='SelectLists tc' id="positionNo"
                                            style="width:205px;"></select>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td width="79" valign="center">入职日期</td>
                            <td width="212" valign="center" colspan="2">
                                <input type="text" readonly="readonly" class="data dateYMD workDate" id="startTime"/>
                            </td>
                            <td width="132" valign="center">试用期周期</td>
                            <td width="267" valign="center" colspan="2"><input type="text" class="data" id="period"/>个月
                                <div class="Validform_checktip"></div>
                            </td>
                        </tr>
                        <tr>
                            <td width="691" valign="top" colspan="6">
                                <div class="tl">试用期工作自评：</div>
                                <textarea style="width:670px; height:138px;" id="selfEvaluation"
                                          class="data"></textarea>

                                <div class="Validform_checktip"></div>
                                <div>签名：<input type="text" readonly="readonly" class="data" id="people1"/>日期：<input
                                        type="text" readonly="readonly" id="inTime1" class="data dateYMD workDate"/>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td width="691" valign="top" colspan="6" class="tl">
                                申请内容：<input type="text" class="data" style="width:600px; text-align:left;" class="mt5"
                                            id="content"/>

                                <div class="Validform_checktip"></div>
                                <!-- <div class="mt10">试用期周期为：<input type="text" style="width:60px;" />年<input type="text" style="width:20px;" />月<input type="text" style="width:20px;" />日&nbsp;--<input type="text" style="width:60px;" />年<input type="text" style="width:20px;" />月<input type="text" style="width:20px;" />日 </div>
                                -->
                                <div class="mt10">延长至：<input type="text" style="width:120px;"
                                                             class="data dateYMD workDate"
                                                             id="extendStartTime"/>--<input type="text"
                                                                                            style="width:120px;"
                                                                                            class="data dateYMD workDate"
                                                                                            id="extendEndTime"/></div>
                                <div class="Validform_checktip"></div>
                                <div class="tc mt15">申请人：<input type="text" class="data" readonly="readonly"
                                                                id="people2"/>日期：<input type="text" readonly="readonly"
                                                                                        id="editTime2"
                                                                                        class="data dateYMD workDate"/>
                                </div>
                            </td>
                        </tr>
                        <!-- <tr >
                           <td width="691" valign="top" colspan="6" >
                               <div class="tl">试用期考察评定：</div>
                                 <textarea style="width:670px; height:124px;" ></textarea>
                               <div>评定人：<input type="text" />日期：<input type="text" class="data"/></div>
                           </td>
                         </tr>
                         <tr >
                           <td width="691" valign="top" colspan="6" >
                              <div class="tl">延长试用期考核要求及薪资：</div>
                              <textarea style="width:670px; height:102px;"></textarea>
                              <div>HR：<input type="text" />日期：<input type="text" /></div>
                           </td>
                         </tr>
                         <tr >
                           <td width="691" valign="top" colspan="6" >
                               <div class="tl">公司领导意见：</div>
                               <textarea style="width:670px; height:80px;"></textarea>
                               <div>签名：<input type="text" />日期：<input type="text" /></div>
                         </tr> -->
                    </table>
                    <div id="btn" class="mt20">
                        <em id="msg"></em>
                        <s:if test="showEditButton">
                            <input type="button" id="edit" value="修改"
                                   class="submit_Btn none btn_style"/>
                        </s:if>
                        <s:if test="showSubmitButton">
                            <input type="submit" id="submit" value="提交" class="submit_Btn none btn_style"/>
                            <input id="submitExamine" type="button" value="提交审批" class="submit_Btn btn_style"/>
                        </s:if>
                        <s:if test="showExamineButton">
                            <input id="examine" type="button" value="审批" class="submit_Btn btn_style"/>
                        </s:if>
                        <input type="button" id="back" value="返回" class="cancel_Btn btn_style"/>
                    </div>
                </div>
            </div>
        </form>
        <div class="trackBtn"></div>
        <div id="w1" class="easyui-window" title="延长试用期申请表审批"
        data-options="modal:true,closed:true,iconCls:'icon-save'"
        style="width:500px;height:200px;padding:10px;">
        <div>
            <textarea id="taskCommet" style="width:450px; height:100px;"></textarea>

            <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                <input id="submit1" name="submit" type="submit" value="通过"
                       class="submit_Btn  btn_style examine"/>
                <input id="submit2" name="" type="submit" value="驳回" class="submit_Btn  btn_style examine"/>
            </div>
        </div>
        </div>

        ${pageVar}
    </m:Content>
</m:ContentPage>