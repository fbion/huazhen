<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 pb30"> 
            <div class="tab">
                <div class="tab_title">
                    <a href="javascript:;" class="active">####todo####</a>
                </div>
                <ul class="tab_content">
                    <li class="tab_content1  tabContent" style="display:block;">
                        <div class="basic_Info_content p15 info_All">
                            <form id="aCTIDUSERAdd" style="z-index:9999;">
                                <ul>
                                    <li>
										<span>用户流程ID</span> 
										<input id="ID" name="iD" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
<li>
										<span>rEV</span> 
										<input id="REV" name="rEV" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
<ul>
                                    <li>
										<span>fIRST</span> 
										<input id="FIRST" name="fIRST" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
<li>
										<span>姓名</span> 
										<input id="LAST" name="lAST" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
<ul>
                                    <li>
										<span>eMAIL</span> 
										<input id="EMAIL" name="eMAIL" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
<li>
										<span>pWD</span> 
										<input id="PWD" name="pWD" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
<ul>
                                    <li>
										<span>pICTUREID</span> 
										<input id="pICTUREID" name="pICTUREID" type="text" disabled="disabled" class="ml20 data"/>
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