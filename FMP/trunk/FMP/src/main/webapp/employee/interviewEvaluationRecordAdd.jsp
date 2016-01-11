<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 pb30">
            <div class="tab">
                <div class="tab_title">
                    <a href="javascript:;" class="active">面试评估记录</a>
                </div>
                <ul class="tab_content">
                    <li class="tab_content1  tabContent" style="display:block;">
                        <div class=" p15 info_All">
                        <div hidden="hidden" id="byName">${name}</div>
                        <input id="showReTest" type="hidden" value='${showReTest}'/>
                            <form id="interviewEvaluationRecordAdd" style="z-index:9999;">
                            	<div id="interviewEvaluationConTent"></div>
                            	
                            	<p id="btn">
				          	       <span hidden="hidden" id="showEditButton"></span>
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