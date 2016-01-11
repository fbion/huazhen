<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 -pl20 pb30">
            <div class="tab">
                <div class="tab_title">
                    <a href="javascript:;" class="active">####todo####</a>
                </div>
                <ul class="tab_content">
                    <li class="tab_content1  tabContent" style="display:block;">
                        <div class="basic_Info_content p15 info_All">
                            <form id="activityUsersDetail" style="z-index:9999;">
                                <ul>
    		<li><span class="fw">userOpenid</span><a id="userOpenid" name="userOpenid" class="ml20" target="_blank"></a></li>
		<li><span class="fw">userName</span><a id="userName" name="userName" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">userImgPath</span><a id="userImgPath" name="userImgPath" class="ml20" target="_blank"></a></li>
		<li><span class="fw">drawNo</span><a id="drawNo" name="drawNo" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">isWin</span><a id="isWin" name="isWin" class="ml20" target="_blank"></a></li>
		<li><span class="fw">name</span><a id="name" name="name" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">cellphone</span><a id="cellphone" name="cellphone" class="ml20" target="_blank"></a></li>
		<li><span class="fw">mark</span><a id="mark" name="mark" class="ml20" target="_blank"></a></li>

</ul>

                                <p id="btn">
                                    <em id="msg"></em>
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