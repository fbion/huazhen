<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="m" uri="/hz-tags"%>

<m:ContentPage materPageId="layout">
	<m:Content contentPlaceHolderId="center">
		<div class="mt20 contentmt">
			<div class="aboutUs_cont">
				<h4>
					<span>STORE</span> <em>旗下门店</em>
				</h4>
				<div class="mt20 fw">门店位置：${info.address}</div>
				<iframe src="${mapUrl}" frameborder="0" marginheight="0"
					marginwidth="0"  scrolling="no" id="ifm"
					name="ifm" onload="javascript:dyniframesize('ifm');" width="100%" class="mt20">
				</iframe>
				<%-- <iframe src="${mapUrl}" width="100%" height="500" frameborder="0"
					scrolling="no" class="mt20"></iframe> --%>
				<dl class="mt50 pt20">
					<dt class="pb20">
						<i class="icon1 pl15"></i>联系电话
					</dt>
					<dd>门店联系电话：${info.telephone}</dd>
				</dl>

			</div>
		</div>
	</m:Content>
</m:ContentPage>
