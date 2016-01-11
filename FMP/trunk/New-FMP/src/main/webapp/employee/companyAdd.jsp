<%--
  Created by IntelliJ IDEA.
  User: 磊
  Date: 2015/11/13
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="newLayout">
  <m:Content contentPlaceHolderId="center">
    <div class="detail mt20 -pl20 pb30">
      <div class="tab">
        <ul class="tab_content">
          <li class="tab_content1  tabContent" style="display:block;">
            <div class="basic_Info_content p15 info_All">
              <form id="companyAdd" style="z-index:9999;">
                <ul>
                  <li>
                    <span>code</span>
                    <input id="code" name="code" type="text" disabled="disabled" class="ml20 data"/>
                    <div class="Validform_checktip"></div>
                  </li>
                  <li>
                    <span>name</span>
                    <input id="name" name="name" type="text" disabled="disabled" class="ml20 data"/>
                    <div class="Validform_checktip"></div>
                  </li>

                </ul>
                <ul>
                  <li>
                    <span>telephone</span>
                    <input id="telephone" name="telephone" type="text" disabled="disabled" class="ml20 data"/>
                    <div class="Validform_checktip"></div>
                  </li>
                  <li>
                    <span>fax</span>
                    <input id="fax" name="fax" type="text" disabled="disabled" class="ml20 data"/>
                    <div class="Validform_checktip"></div>
                  </li>

                </ul>
                <ul>
                  <li>
                    <span>postcode</span>
                    <input id="postcode" name="postcode" type="text" disabled="disabled" class="ml20 data"/>
                    <div class="Validform_checktip"></div>
                  </li>
                  <li>
                    <span>website</span>
                    <input id="website" name="website" type="text" disabled="disabled" class="ml20 data"/>
                    <div class="Validform_checktip"></div>
                  </li>

                </ul>
                <ul>
                  <li>
                    <span>email</span>
                    <input id="email" name="email" type="text" disabled="disabled" class="ml20 data"/>
                    <div class="Validform_checktip"></div>
                  </li>
                  <li>
                    <span>bankAddress</span>
                    <input id="bankAddress" name="bankAddress" type="text" disabled="disabled" class="ml20 data"/>
                    <div class="Validform_checktip"></div>
                  </li>

                </ul>
                <ul>
                  <li>
                    <span>bankName</span>
                    <input id="bankName" name="bankName" type="text" disabled="disabled" class="ml20 data"/>
                    <div class="Validform_checktip"></div>
                  </li>
                  <li>
                    <span>bankAccount</span>
                    <input id="bankAccount" name="bankAccount" type="text" disabled="disabled" class="ml20 data"/>
                    <div class="Validform_checktip"></div>
                  </li>

                </ul>
                <ul>
                  <li>
                    <span>address</span>
                    <input id="address" name="address" type="text" disabled="disabled" class="ml20 data"/>
                    <div class="Validform_checktip"></div>
                  </li>
                  <li>
                    <span>comment</span>
                    <input id="comment" name="comment" type="text" disabled="disabled" class="ml20 data"/>
                    <div class="Validform_checktip"></div>
                  </li>

                </ul>
                <ul>
                  <li>
                    <span>editComment</span>
                    <input id="editComment" name="editComment" type="text" disabled="disabled" class="ml20 data"/>
                    <div class="Validform_checktip"></div>
                  </li>

                </ul>

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