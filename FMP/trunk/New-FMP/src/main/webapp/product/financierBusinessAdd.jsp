<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
<m:Content contentPlaceHolderId="center">
<div class="detail mt20 pb30">
<div class="tab">
<div class="tab_title">
    <a href="javascript:;" class="active">企业融资方</a>
</div>
<ul class="tab_content">
    <li class="tab_content1  tabContent" style="display:block;">
        <div class="basic_Info_content p15 info_All">
            <form id="financierBusinessAdd" style="z-index:9999;">
                <ul>
                    <li>
                        <span>编码</span>
                        <input id="code" name="code" type="text" disabled="disabled" class="ml20 data"/>
                        <div class="Validform_checktip"></div>
                    </li>
                    <li>
                        <span>公司名称<em class='color'>*</em></span>
                        <input id="name" name="name" type="text" disabled="disabled" class="ml20 data"/>
                        <div class="Validform_checktip"></div>
                    </li>
                
                </ul>
                <ul>
                    <li>
                        <span>公司法人</span>
                        <input id="owner" name="owner" type="text" disabled="disabled" class="ml20 data"/>
                        <div class="Validform_checktip"></div>
                    </li>
                    <li>
                        <span>公司电话<em class='color'>*</em></span>
                        <input id="telephone" name="telephone" type="text" disabled="disabled" class="ml20 data"/>
                        <div class="Validform_checktip"></div>
                    </li>
                
                </ul>
                <ul>
                    <li>
                        <span>关系等级</span>
                        <select id="relationLevel" name="relationLevel" type="text" disabled="disabled" class="ml20 data"></select>
                        <div class="Validform_checktip"></div>
                    </li>
                    <li>
                        <span>重要程度</span>
                        <select id="contactImportance" name="contactImportance" type="text" disabled="disabled" class="ml20 data"></select>
                        <div class="Validform_checktip"></div>
                    </li>
                
                </ul>
                <ul>
                    <li>
                        <span>传真</span>
                        <input id="fax" name="fax" type="text" disabled="disabled" class="ml20 data"/>
                        <div class="Validform_checktip"></div>
                    </li>
                    <li>
                        <span>邮编</span>
                        <input id="postcode" name="postcode" type="text" disabled="disabled" class="ml20 data"/>
                        <div class="Validform_checktip"></div>
                    </li>
                
                </ul>
                <ul>
                    <li>
                        <span>网站</span>
                        <input id="website" name="website" type="text" disabled="disabled" class="ml20 data"/>
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
                        <span>开户行名称</span>
                        <input id="bankName" name="bankName" type="text" disabled="disabled" class="ml20 data"/>
                        <div class="Validform_checktip"></div>
                    </li>
                    <li>
                        <span>开户行地址</span>
                        <input id="bankAddress" name="bankAddress" type="text" disabled="disabled" class="ml20 data"/>
                        <div class="Validform_checktip"></div>
                    </li>
                
                </ul>
                <ul>
                    <li>
                        <span>银行账户</span>
                        <input id="bankAccount" name="bankAccount" type="text" disabled="disabled" class="ml20 data"/>
                        <div class="Validform_checktip"></div>
                    </li>
                    <li>
                        <span>公司地址<em class='color'>*</em></span>
                        <input id="address" name="address" type="text" disabled="disabled" class="ml20 data"/>
                        <div class="Validform_checktip"></div>
                    </li>
                
                </ul>
                <ul>
                    <li>
                        <span>主要联系人<em class='color'>*</em></span>
                        <input id="contactPrimary" name="contactPrimary" type="text" disabled="disabled" class="ml20 data"/>
                        <div class="Validform_checktip"></div>
                    </li>
                    <li>
                        <span>联系人手机<em class='color'>*</em></span>
                        <input id="contactCellphone1" name="contactCellphone1" type="text" disabled="disabled" class="ml20 data"/>
                        <div class="Validform_checktip"></div>
                    </li>
                
                </ul>
                <ul>
                    <li>
                        <span>联系人手机2</span>
                        <input id="contactCellphone2" name="contactCellphone2" type="text" disabled="disabled" class="ml20 data"/>
                        <div class="Validform_checktip"></div>
                    </li>
                    <li>
                        <span>联系人固话</span>
                        <input id="contactTelephone" name="contactTelephone" type="text" disabled="disabled" class="ml20 data"/>
                        <div class="Validform_checktip"></div>
                    </li>
                
                </ul>
                <ul>
                    <li>
                        <span>联系人职位<em class='color'>*</em></span>
                        <input id="contactPosition" name="contactPosition" type="text" disabled="disabled" class="ml20 data"/>
                        <div class="Validform_checktip"></div>
                    </li>
                    <li>
                        <span>联系人微信</span>
                        <input id="contactWeinxin" name="contactWeinxin" type="text" disabled="disabled" class="ml20 data"/>
                        <div class="Validform_checktip"></div>
                    </li>
                
                </ul>
                <ul>
                    <li>
                        <span>联系人QQ</span>
                        <input id="contactQq" name="contactQq" type="text" disabled="disabled" class="ml20 data"/>
                        <div class="Validform_checktip"></div>
                    </li>
                    <li>
                        <span>联系人住址</span>
                        <input id="contactAddress" name="contactAddress" type="text" disabled="disabled" class="ml20 data"/>
                        <div class="Validform_checktip"></div>
                    </li>
                </ul>
                <ul>
                    <li>
                        <span>融资需求额度</span>
                        <input id="requireMoneyTotal" name="requireMoneyTotal" type="text" disabled="disabled" class="ml20 data"/>
                        <div class="Validform_checktip"></div>
                    </li>
                    <li>
                        <span>融资需求时间</span>
                        <input id="requireTime" name="requireTime" type="text" disabled="disabled" class="ml20 data"/>
                        <div class="Validform_checktip"></div>
                    </li>
                
                </ul>
                <ul>
                    <li>
                        <span>公司执照编号<em class='color'>*</em></span>
                        <input id="permitNumber" name="permitNumber" type="text" disabled="disabled" class="ml20 data"/>
                        <div class="Validform_checktip"></div>
                    </li>
                    <li>
                        <span>机构代码编码</span>
                        <input id="organizationNumber" name="organizationNumber" type="text" disabled="disabled" class="ml20 data"/>
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
                        <span>修改备注</span>
                        <input id="editComment" name="editComment" type="text" disabled="disabled" class="ml20 data"/>
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
                </ul>
                <ol>
                    <li>
                        <span>简述</span>
                        <!--<input id="comment" name="comment" type="text" disabled="disabled" class="ml20 data"/>-->
                        <textarea cols="58" rows="10" class="ml20 data"id="comment" name="comment" disabled="disabled"></textarea>
                        <div class="Validform_checktip"></div>
                    </li>
                </ol>
                <%-- <ol>
                    <li>
                        <span>融资需求描述</span>
                        <!--<input id="requireComment" name="requireComment" type="text" disabled="disabled" class="ml20 data"/>-->
                        <textarea cols="58" rows="10" class="ml20 data" id="requireComment" name="requireComment" disabled="disabled"></textarea>
                        <div class="Validform_checktip"></div>
                    </li>
                </ol> --%>
                
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