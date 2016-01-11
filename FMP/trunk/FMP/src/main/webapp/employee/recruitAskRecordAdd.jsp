<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 pb30">
            <div class="tab">
                <div class="tab_title">
                    <a href="javascript:;" class="active">招聘过程记录信息</a>
                </div>
                <ul class="tab_content">
                    <li class="tab_content1  tabContent" style="display:block;">
                        <div class="basic_Info_content p15 info_All">
                            <form id="recruitAskRecordAdd" style="z-index:9999;">
                                <ul>
                                    <li>
                                        <span>姓名</span> 
                                        <input id="name" name="name" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>简历来源</span> 
                                        <select id="resumeSource" name="resumeSource" type="text" disabled="disabled" class="ml20 data"></select>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li class="resumeAnnex" >
                                        <span>简历附件</span>
                                        <div id="uploadDiv" style="display:inline-block;"></div>
                                        <div hidden="hidden" id="upLoadPath"></div>
                                    </li>
                                    <li>
                                        <span>首次联系时间</span> 
                                        <input id="firstContactTime" name="firstContactTime" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li>
                                        <span>现公司（行业）和职位</span> 
                                        <input id="workCondition" name="workCondition" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>应聘职位</span>
                                        <span class="ml20">
                                             <input class="form-control ml20 data" id="positionNo"/>
                                        </span>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li>
                                        <span>电话号码</span>  
                                        <input id="cellphone" name="cellphone" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>邮箱地址</span> 
                                        <input id="email" name="email" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li>
                                        <span>邀约初试时间</span> 
                                        <input id="firstTime" name="firstTime" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>面试与否</span> 
                                        <select id="isInterview" name="isInterview" type="text" disabled="disabled" class="ml20 data"></option><option value="0">否</option><option value="1">是</option></select>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li>
                                        <span>复试时间</span> 
                                        <input id="secondTime" name="secondTime" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>是否录用</span> 
                                        <select id="isEmploy" name="isEmploy" type="text" disabled="disabled" class="ml20 data"></option><option value="0">否</option><option value="1">是</option></select>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li>
                                        <span>录入人</span> 
                                        <input id="inUserNo" type="text" name="inUserNo" disabled="disabled" class="ml20"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ol class="recordInfo" style="display: none;">
                                    <li>
                                        <span style="vertical-align:top">首次联系情况</span> 
                                        <textarea id="firstContactSituation" cols="89" rows="3" name="firstContactSituation" disabled="disabled" class="ml20 data"></textarea>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ol>	
                                <ol class="recordInfo" style="display: none;">	
                                    <li>
                                        <span style="vertical-align: top">回访记录</span> 
                                        <textarea id="visitRecord" name="visitRecord" cols="89" rows="3"  disabled="disabled" class="ml20 data"></textarea>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ol>        
                                <ol class="recordInfo" style="display: none;">
                                    <li>
                                        <span style="vertical-align: top">后续联系记录</span> 
                                        <textarea id="laterContactRecord" name="laterContactRecord" cols="89" rows="3"  disabled="disabled" class="ml20 data"></textarea>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ol>   
                                <ol class="recordInfo" style="display: none;">
                                    <li>
                                        <span style="vertical-align: top">修改备注</span> 
                                        <textarea id="editComment" name="editComment" cols="89" rows="3"  disabled="disabled" class="ml20 data"></textarea>
                                        <div class="Validform_checktip"></div><br><br>
                                    </li>
                                </ol>
                            
                                <p id="btn">
                                    <em id="msg"></em>
                                    <s:if test="showEditButton">
                                    <input type="button" id="edit" value="修改" class="submit_Btn none btn_style"/>                                        
                                    </s:if>
                                    <s:if test="showSubmitButton">
                                    <input type="submit" id="submit" value="提交" class="submit_Btn none btn_style"/>
                                    </s:if>
                                    <input type="button" id="back" value="返回" class="cancel_Btn btn_style"/>
                                </p>
                            </form>
                        <!--</div>-->
                                <p class="mt50"> 
                                    <s:if test="showFollowAddButton">
                                    <input type="button" id="btnAdd" value="新建跟踪" class="btn_style"/>
                                    </s:if>
                                </p>
                                <div class="pic mt20">
                                    <table id="gridTable" class="gridTable">
                                    </table>
                                    <div id="gridPager" class="gridPager"></div>
                                </div>
                        <!--<div>-->
                                <h3></h3>
                                <form id="recruitFollowAdd" style="z-index:9999;">
                                <div class="wrappSearchContent mt30" id="Follow" style="display: none;">
                                    <ol>
                                        <li>
                                            <span>内容</span> 
                                            <textarea id="inContent" name="inContent" type="text" disabled="disabled" class="ml20 data"/></textarea>
                                            <div class="Validform_checktip"></div>
                                        </li>
                                    </ol>
                                    <ol>
                                        <li>
                                            <span>备注</span> 
                                            <textarea id="inEditComment" name="inEditComment" type="text" disabled="disabled" class="ml20 data"/></textarea>
                                            <div class="Validform_checktip"></div>
                                        </li>
                                    </ol>
                                    <ul>
                                        <li style="display: none;">
                                            <span>隐藏ID</span> 
                                            <input id="inID" name="inID" type="text" disabled="disabled" class="ml20 data"/>
                                        </li>
                                    </ul>
                                    <div style="margin-left:43px;">
                                        <s:if test="showFollowEditButton">
                                            <p id="btn">
                                                <em id="showMsg" class='color'></em><em id="msg"></em> <input type="submit" id="submitFollow" value="跟踪"
                                            class="submit_Btn btn_style" /> <input type="button" id="editFollow" value="修改" class="submit_Btn btn_style" />
                                            </p>
                                        </s:if>
                                    </div>
                                    <%--  <p id="btn">
                                    <em id="followMsg"></em>
                                    <s:if test="showEditButton">
                                    <input type="button" id="followEdit" value="修改"
                                    class="submit_Btn none btn_style"/>                                        
                                    </s:if>
                                    <s:if test="showSubmitButton">
                                    <input type="submit" id="followSubmit" value="提交" class="submit_Btn none btn_style"/>
                                    </s:if> 
                                    <input type="button" id="followBack" value="返回" class="cancel_Btn btn_style"/>
                                    </p --%>                                
                                    <%-- <input id="btnSearch" type="button" value="查询" class="btn_style"/>
                                    <s:if test="showExcelButton">
                                    <input type="button" id="btnExcel" value="导出Excel" class="btn_style" />
                                    </s:if> --%>
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