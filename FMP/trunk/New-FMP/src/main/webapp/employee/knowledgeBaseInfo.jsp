<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>
<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 pb30">
            <div class="-basic_Info_content p15 info_All">
                <form id="knowledgeBaseAdd" style="z-index:9999;">
                <div class="recruitInfo">
                    <p class="mt10">
                        <span class="recruitTit">类别：</span><em id="typeName" class="mr30">${knowledgeBase.typeName}</em>
                        <span class="recruitTit">发布时间：</span><strong class="mr30">${knowledgeBase.inTime}</strong>
                        <span class="recruitTit">发布人：</span><em class="mr30">${knowledgeBase.inUserName}</em>
                    </p>
                     <p class="mt10">
                        <span class="recruitTit">主题：</span><em class="mr30">${knowledgeBase.title}</em>
                    </p>
                    <div class="recruit_cont mt10">
                        <span class="mt20 recruitTitle">正文：</span>
                        <div class="recruitContent">${knowledgeBase.content}</div>
                    </div>
                    <div class="details_Info_content p15 info_All" id="uploadDiv">
                        <div class="upload"></div>
                    </div>
                     <div class="tc">
                    <input type="button" id="back" value="返回" class="cancel_Btn btn_style"/>
               		 </div>
               </div>
              </form>
            </div>
        </div>
    	${pageVar}
    </m:Content>
</m:ContentPage>


