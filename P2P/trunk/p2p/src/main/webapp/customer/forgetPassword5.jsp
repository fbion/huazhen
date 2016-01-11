<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <%-- <meta http-equiv="refresh" content="6;url=${ loginUrl}"> --%>
			<div class="main pt30">
				<div class="successPage wrapp">
			        <em class="tipsPic mt40"></em>
			        <div class="tipsInfo mt40">
			        	<h4>重置成功！</h4>
			            <h5>请牢记新的登录密码。</h5>
			            <a href="${loginUrl}" class="mt30"><span id="second">6</span>秒后自行登录</a>
			        </div>
			    </div>
			<script type="text/javascript">
			 settimeToload ();
			 var countdown=6;
			 function settimeToload (){
				if (countdown == 0) {
					window.location.href =  $Url.BuildWWWUrl("/customer/login");
					return;
				} else {
					$("#second").html(countdown);
					countdown--;
				}
				setTimeout(function() {settimeToload()},1000);
			}
			</script>
			</div>
  </m:Content>
</m:ContentPage>