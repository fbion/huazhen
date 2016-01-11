<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 -pl20 pb30">
            <div class="tab">
                <div class="tab_title">
                    <a href="javascript:;" class="active">P2P公告</a>
                </div>
                <ul class="tab_content">
                    <li class="tab_content1  tabContent" style="display:block;">
                        <div class="basic_Info_content p15 info_All">
                            <form id="announcementAdd" style="z-index:9999;">
                                <ul>
                                    <li>
                                        <span>主题</span>
                                        <input id="subject" name="subject" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>链接地址</span>
                                        <input id="linkurl" name="linkurl" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
                                <ul>
                                    <li>
                                        <span>是否标红</span>
                                        <select id="isRed" name="isRed" type="text" disabled="disabled" class="ml20 data"></select>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>是否置顶</span>
                                        <select id="isTop" name="isTop" type="text" disabled="disabled" class="ml20 data"></select>
                                        <div class="Validform_checktip"></div>
                                    </li>


                                </ul>
                                <ul>

                                    <li>
                                        <span>类型</span>
                                        <select id="type" name="type" type="text" disabled="disabled" class="ml20 data"></select>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>状态</span>
                                        <select id="status" name="status" type="text" disabled="disabled" class="ml20 data"></select>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li>
                                        <span>开始时间</span>
                                        <input id="startTime" name="startTime" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>结束时间</span>
                                        <input id="endTime" name="endTime" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>

                                <ol class="mt30">
                                    <li>
                                        <span>内容</span>
                                        <!--<input id="content" name="content" type="text" disabled="disabled" class="ml20 data"/>-->
                                        <textarea id="content" name="content" cols="80" rows="8" disabled="disabled" class="ml20 data"></textarea>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ol>
                                <p id="btn">
                                    <em id="msg"></em>
                                    <s:if test="showEditButton">
                                        <input type="button" id="edit" value="修改"
                                               class="submit_Btn none btn_style"/>
                                    </s:if>
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