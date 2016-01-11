<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="m" uri="/hz-tags"%>

<m:ContentPage materPageId="layout">
	<m:Content contentPlaceHolderId="center">
		<div class="detail mt20 -pl20 pb30">
			<div class="tab">
				<div class="tab_title">
					<a href="javascript:;" class="active">验收登记表</a>
				</div>
				<ul class="tab_content">
					<li class="tab_content1  tabContent" style="display: block;">
						<div class="basic_Info_content p15 info_All">
							<form id="fixedAssetsAddAll" style="z-index: 9999;">
								<ul>
									<li><span>采购单号</span> <input id="registrationOrder"
										name="registrationOrder" type="text" class="ml20" width="100px;"/></li>
									<li><span>资产类型</span> <select id="type" name="type"
										class="ml20" style="width:150px;"></select></li>

								</ul>
								<ul>
									<li><span >供应商</span>
									<input class="form-control ml20" id="suppliersId" width="100px;" style="margin-left: 20px;"/>
									<li><span>操作员</span> <input id="operator" name="operator" disabled="disabled"
										type="text" class="ml20"  width="100px;"/></li>
								</ul>
								<ul>
									<li><span>登记时间</span> <input id="registrationDate"
										name="registrationDate" type="text" class="ml20"  width="100px;"/></li>
									<li style="display: none;"><span>ID</span> <input
										id="registrationId" name="registrationId" type="text"
										disabled="disabled" class="ml20" /></li>

								</ul>
								<table id="gridTable"></table>
								<p id="btn">
									<em id="msg"></em>
									<s:if test="showEditButton">
										<input type="button" id="edit" value="修改"
											class="submit_Btn none btn_style" />
									</s:if>
									<%-- <s:if test="showSubmitButton"> --%>
										<input type="submit" id="submit" value="提交"
											class="submit_Btn none btn_style" />
									<%-- </s:if> --%>
									<input type="button" id="back" value="返回"
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