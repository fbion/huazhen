<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 -pl20 pb30">
            <div class="tab">
                <div class="tab_title">
                    <a href="javascript:;" class="active">P2P广告</a>
                </div>
                <ul class="tab_content">
                    <li class="tab_content1  tabContent" style="display:block;">
                        <div class="basic_Info_content p15 info_All">
                            <form id="bannerInfoAdd" style="z-index:9999;">
                                <ul>
                                    <li>
                                        <span>标题</span>
                                        <input id="title" name="title" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>Url</span>
                                        <input id="linkUrl" name="linkUrl" type="text" disabled="disabled" class="ml20 data"/>
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
                                        <span>适用页面</span>
                                        <select id="pageNo" name="pageNo" type="text" disabled="disabled" class="ml20 data"></select>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li>
                                        <span>位置</span>
                                        <select id="locationNo" name="locationNo" type="text" disabled="disabled" class="ml20 data"></select>
                                        <div class="Validform_checktip"></div>
                                    </li>


                                    <li>
                                        <span>排除页面</span>
                                        <select id="exceptPageNo" name="exceptPageNo" type="text" disabled="disabled" class="ml20 data"></select>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li>
                                        <span>优先级</span>
                                        <input id="priority" name="priority" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                    <li>
                                        <span>开始时间</span>
                                        <input id="startTime" name="startTime" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li>
                                        <span>状态</span>
                                        <select id="status" name="status" type="text" disabled="disabled" class="ml20 data"></select>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                    <li>
                                        <span>结束时间</span>
                                        <input id="endTime" name="endTime" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ol class="mt10">
                                    <li>
                                        <span>资源url</span>
                                        <input id="resrcurl" name="resrcurl" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="upload uploadW"></div>
                                        <div class="uploadLayer">
                                            <a id="empheada"><img alt="资源" id="emphead" class="emphead" src=""  height="100%" width="100%"/></a>
                                        </div>
                                    </li>
                                </ol>

                                <ol class="mt30">
                                    <li>
                                        <span id="img">内容</span>
                                        <textarea id="text" name="text" cols="80" rows="8" disabled="disabled" class="ml20 data">
                                        </textarea>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ol>
                                <ol>
                                    <li>
                                        <span>描述</span>
                                        <!--<input id="content" name="content" type="text" disabled="disabled" class="ml20 data"/>-->
                                        <textarea id="description" name="description" cols="80" rows="8" disabled="disabled" class="ml20 data"></textarea>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ol>
                                <ol>
                                    <li>
                                        <span>脚本</span>
                                        <!--<input id="content" name="content" type="text" disabled="disabled" class="ml20 data"/>-->
                                        <textarea id="script" name="script" cols="80" rows="8" disabled="disabled" class="ml20 data"></textarea>
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