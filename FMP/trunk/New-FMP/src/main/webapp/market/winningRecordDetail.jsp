<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="m" uri="/hz-tags"%>

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
							<form id="winningRecordDetail" style="z-index:9999;">
								<ul>
									<li><span class="fw">userId</span><a id="userId"
										name="userId" class="ml20" target="_blank"></a></li>
									<li><span class="fw">drawNo</span><a id="drawNo"
										name="drawNo" class="ml20" target="_blank"></a></li>

								</ul>
								<ul>
									<li><span class="fw">isAward</span><a id="isAward"
										name="isAward" class="ml20" target="_blank"></a></li>
									<li><span class="fw">mark</span><a id="mark" name="mark"
										class="ml20" target="_blank"></a></li>

								</ul>

								<p id="btn">
									<em id="msg"></em> <input type="button" id="back" value="返回"
										class="cancel_Btn btn_style" />
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