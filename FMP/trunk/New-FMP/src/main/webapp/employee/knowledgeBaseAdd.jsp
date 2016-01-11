<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 pb30">
            <div class="tab">
                <div class="tab_title">
                    <a href="javascript:;" class="active">发布知识</a>
                    <s:if test="showEditButton">
                    <a href="javascript:;">附件</a>
                    </s:if>
                </div>
                <ul class="tab_content">
                    <li class="tab_content1  tabContent" style="display:block;">
                        <div class="basic_Info_content p15 info_All">
                            <form id="knowledgeBaseAdd" style="z-index:9999;">
                                <ul>
                                    <li>
										<span>类别</span> 
										<select id="type" name="type" class="ml20 data" disabled="disabled"></select>
                                    </li>

                                </ul>
								<ul>
                                    <li>
										<span>主题</span> 
										<input  id="title"  name="title" type="text" disabled="disabled" class="ml20 data theme"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <span>正文</span> 
                                <textarea id="content" name="content"  class="ckeditor" ></textarea>
                                <!-- <div class="Validform_checktip"></div> -->
                                <div id="btn" class="pt20 tc">
 								<em id="msg"></em>
                                <s:if test="showEditButton">
                                    <input type="button" id="edit" value="修改" class="submit_Btn none btn_style"/> 
                                </s:if>
                                <s:if test="showSubmitButton">
                                    <input type="submit" id="submit" value="提交" class="submit_Btn none btn_style"/>
                                </s:if>
                                	<input type="button" id="back" value="返回" class="cancel_Btn btn_style"/>
                               </div>
                            </form>
                        </div>
                    </li>
                    <s:if test="showEditButton">
                    <li class="tab_content2  tabContent">
                        <div class="details_Info_content p15 info_All" id="uploadDiv">
                            <div class="upload"></div>
                        </div>
                    </li>
                    </s:if>
                </ul>
            </div>
        </div>
        ${pageVar}
    </m:Content>
</m:ContentPage>