<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="m" uri="/hz-tags"%>

<m:ContentPage materPageId="layout">
	<m:Content contentPlaceHolderId="center">
		<div class="wrappSearch mt30">
			<h3></h3>
			<div class="wrappSearchContent">
			    产品名称：<select id="byP2pProductNo"></select>
				用户名称：<select id="byP2pCustomerNo"></select>
				门店：<select id="byDeptNo"></select>
				理财经理：<select id="byEmpNo"></select>
				状态：<select id="byStatus"></select>
				
				<input id="btnSearch"
					type="button" value="查询" class="btn_style" />
			</div>
		</div>
		<div class="pic mt20">
			<table id="gridTable" class="gridTable">
			</table>
			<div id="gridPager" class="gridPager"></div>
		</div>

        <%--绑定到自然人客户--%>
        <div id="bindCustomer" class="easyui-window" title="客户绑定" data-options="closed:true" style="width:1500px;height:520px;padding:5px;">
            <input type="text" hidden="hidden"  id="customerId" value="">
            <div class="easyui-layout" data-options="fit:true">
                <div data-options="region:'center'" style="padding:10px;">
                    <div>
                        <h3></h3>
                        <div class="wrappSearchContent"></div>
                    </div>
                    <p class="pl20" style="display: inline-block"><input type="button" id="btnAddCustomer" value="一键创建" class="btn_style"/></p>
                    <div class="pic mt20">
                        <table id="gridTableCustomer" class="gridTable">
                        </table>
                        <div id="gridPagerCustomerPager" class="gridPager">
                        </div>
                    </div>
                </div>
                <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                    <span id="message" style="width:80px"></span>
                    <a class="easyui-linkbutton"  href="javascript:void(0)" onclick="$('#bindCustomer').window('close')" style="width:80px">关闭</a>
                </div>
            </div>
        </div>
${pageVar}
	</m:Content>
</m:ContentPage>
