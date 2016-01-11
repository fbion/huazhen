<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<html>
    <head>
         ${pageHead}
    </head>
    <body>
    <div class="mt50">
        <input type="hidden" id="honourDate" value="<s:property value="honourDate"/>" />
        <input type="hidden" id="type" value="<s:property value="type"/>" />
        <input type="hidden" id="paymentReportId" value="<s:property value="paymentReportId"/>" />
        <div id="paymentReportDeatilContent"></div>
        <table align="center" border="1"  id="aduitComment" class="aduittable"></table>
        <p id="btn" class="mt50">
            <input type="button" id="submitExamine" value="提交审核" class="btn_style">
		<s:if test="showSubmitButton">
            <input type="button" id="examine" value="审核" class="btn_style">
		</s:if>
        </p>
        <div id="w1" class="easyui-window" title="还款审批" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:500px;height:200px;padding:10px;">
            <div>
                <textarea id="taskCommet" style="width:450px; height:100px;"></textarea>
                <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                    <input id="submit1" name="submit" type="submit" value="下一步"class="submit_Btn  btn_style examine"/>
                    <input id="submit2" name="" type="submit" value="驳回" class="submit_Btn  btn_style examine"/>
                </div>
            </div>
        </div>
        <div class="trackBtn"></div>
        <div class="checkTrack" style="left:50%; top:50%; margin-top:250px;">
    </div>
    </body>
</html>

