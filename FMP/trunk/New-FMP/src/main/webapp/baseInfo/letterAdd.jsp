<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 pb30">
            <div class="tab">
                <div class="tab_title">
                    <a href="javascript:;" class="active">站内信</a>
                </div>
                <ul class="tab_content">
                    <li class="tab_content1  tabContent" style="display:block;">
                        <div class="basic_Info_content p15 info_All">
                            <form id="letterAdd" style="z-index:9999;">
                                <ul>
                                    <li>
                                        <span>主题</span>
                                        <input id="subject" name="subject" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>优先级</span>
                                        <input id="level" name="level" type="text" disabled="disabled" class="ml20 data" />
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li>
                                        <span>公告</span>
                                        <input id="checkBox" name="level" type="checkbox" disabled="disabled" class="ml20 data" />
                                        <div class="Validform_checktip"></div>
                                     </li>
                                    <li>
                                        <span>创建者</span>
                                        <select id="inUserNo" name="inUserNo" type="text" disabled="disabled" class="ml20 data disabled"></select>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li>
                                        <span>重要程度</span>
                                        <select id="importantDegree" name="importantDegree" type="text" disabled="disabled" class="ml20 data"></select>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>新建时间</span>
                                        <input id="inTime" name="inTime" type="text" disabled="disabled" class="ml20 data disabled"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li>
                                        <span>类型</span>
                                        <select id="type" name="type" type="text" class="ml20 data disabled" disabled="disabled"></select>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                    <li>
                                        <span class="hide">解决者</span>
                                        <select id="solveUserNo" name="solveUserNo" type="text" disabled="disabled" class="ml20 data hide disabled"></select>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li>
                                        <span class="isRead">状态</span>
                                        <select id="isRead" name="isRead" type="text" disabled="disabled" class="ml20 data isRead" ></select>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span class="hide">解决时间</span>
                                        <input id="solveTime" name="solveTime" type="text" disabled="disabled" class="ml20 data hide disabled"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li>
                                        <span class="hide">待办人</span>
                                        <input id="employeeSel" type="text" value="" class="ml20 data hide" disabled="disabled"/>
                                        <input type="text" id="recipient" value="" style="display: none" />
                                            <%--<select id="recipient" name="recipient" type="text" disabled="disabled" class="ml20 data"></select>--%>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span class="hide">解决方案</span>
                                        <input id="solvePlan" name="solvePlan" type="text" disabled="disabled" class="ml20 data hide disabled"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li>
                                        <span class="hide">抄送给</span>
                                        <input id="employeeSel1" type="text" value="" class="ml20 data hide" disabled="disabled"/>
                                        <input type="text" id="sendDeplicate" value="" style="display: none" />
                                            <%--<select id="sendDeplicate" name="sendDeplicate" type="text" disabled="disabled" class="ml20 data"></select>--%>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span class="hide">关闭者</span>
                                        <select id="closeUserNo" name="closeUserNo" type="text" disabled="disabled" class="ml20 data hide disabled"></select>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li>
                                        <span class="hide">状态</span>
                                        <select id="status" name="status" type="text" disabled="disabled" class="ml20 data disabled hide"></select>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span class="hide">关闭时间</span>
                                        <input id="closeTime" name="closeTime" type="text" disabled="disabled" class="ml20 data hide disabled"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li>
                                        <span class="hide">期望完成时间</span>
                                        <input id="expectFinishTime" name="expectFinishTime" type="text" disabled="disabled" class="ml20 data hide" />
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>


                                <ol>
                                    <li>
                                        <span>内容</span>
                                        <!--<input id="content" name="content" type="text" disabled="disabled" class="ml20 data"/>-->
                                        <textarea id="content" name="content" cols="80" rows="8" disabled="disabled" class="ml20 data"></textarea>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ol>
                                <ol>    
                                    <li>
                                        <span>备注</span>
                                        <!--<input id="editComment" name="editComment" type="text" disabled="disabled" class="ml20 data"/>-->
                                        <textarea id="comment" name="comment" cols="80" rows="8"  disabled="disabled" class="ml20 data"></textarea>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ol>
                                <div id="step">
                                    <ul>
                                        <s:action name="step"  namespace="/"  executeResult="true">
                                            <s:param name="id" value="%{id}"></s:param>
                                        </s:action>
                                    </ul>
                                </div>
                                <p id="btn">
                                    <em id="msg"></em>
                                    <s:if test="showEditButton">
                                        <input type="button" id="edit" value="修改"
                                               class="submit_Btn none btn_style"/>
                                    </s:if>
                                    <input type="button" id="handel" value="处理" class="submit_Btn btn_style"/>
                                    <input type="button" id="solve" value="解决" class="submit_Btn  btn_style"/>
                                    <input type="button" id="close" value="关闭" class="submit_Btn  btn_style"/>
                                    <s:if test="showSubmitButton">
                                        <input type="submit" id="submit" value="提交" class="submit_Btn none btn_style"/>
                                    </s:if>

                                    <input type="button" id="back" value="返回" class="cancel_Btn btn_style"/>
                                </p>
                            </form>

                        </div>
                    </li>
                </ul>
                
            </div>
        </div>
        ${pageVar}
    </m:Content>
</m:ContentPage>