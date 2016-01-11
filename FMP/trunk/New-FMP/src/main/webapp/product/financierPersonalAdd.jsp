<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 pb30">
            <div class="tab">
                <div class="tab_title">
                    <a href="javascript:;" class="active">个人融资方</a>
                </div>
                <ul class="tab_content">
                    <li class="tab_content1  tabContent" style="display:block;">
                        <div class="basic_Info_content p15 info_All">
                            <form id="financierPersonalAdd" style="z-index:9999;">
                                <ul>
                                    <li>
                                        <span>委托人编号</span>
                                        <input id="code" name="code" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>委托人<em class='color'>*</em></span>
                                        <input id="name" name="name" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
                                <ul>
                                    <li>
                                        <span>性别</span>
                                        <select id="sex" name="sex" type="text" disabled="disabled" class="ml20 data"></select>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>邮箱<em class='color'>*</em></span>
                                        <input id="email" name="email" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
                                <ul>
                                    <li>
                                        <span>微信</span>
                                        <input id="weixin" name="weixin" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>QQ</span>
                                        <input id="qq" name="qq" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
                                <ul>
                                    <li>
                                        <span>手机1<em class='color'>*</em></span>
                                        <input id="cellphone1" name="cellphone1" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>手机2</span>
                                        <input id="cellphone2" name="cellphone2" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
                                <ul>
                                    <li>
                                        <span>固话</span>
                                        <input id="telephone" name="telephone" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>住址</span>
                                        <input id="address" name="address" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
                                <ul>
                                    <li>
                                        <span>年龄</span>
                                        <input id="age" name="age" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>婚姻</span>
                                        <select id="marry" name="marry" type="text" disabled="disabled" class="ml20 data"></select>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
                                <ul>
                                    <li>
                                        <span>公司<em class='color'>*</em></span>
                                        <input id="company" name="company" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>融资需求额度</span>
                                        <input id="money" name="money" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
                                <ul>
                                	<li>
                                        <span>负责人</span>
                                        <input id="employeeSel" type="text" value="" class="ml20" disabled="disabled"/>
                                        <input type="text" id="managerNo" value="" style="display: none" />
                                        <%--<select id="managerNo" name="managerNo" type="text" disabled="disabled" class="ml20 data"></select>--%>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>融资需求时间</span>
                                        <input id="requiretime" name="requiretime" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li><span>是否测试</span>
				                        <select id="isTest" name="isTest" class="ml20 data" disabled="disabled">
				                            <option value="0">否</option>
				                            <option value="1">是</option>
				                        </select>
				                        <div class="Validform_checktip"></div>
				                    </li>
                                    <li>
                                        <span>修改备注</span>
                                        <input id="editComment" name="editComment" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                	<li>
                                        <span>融资需求描述</span>
                                        <!--<input id="requireComment" name="requireComment" type="text" disabled="disabled" class="ml20 data"/>-->
                                        <textarea cols="60" rows="7" class="ml20 data" id="requireComment" name="requireComment" disabled="disabled"></textarea>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>

                                <p id="btn" class="mt100 pt50">
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
