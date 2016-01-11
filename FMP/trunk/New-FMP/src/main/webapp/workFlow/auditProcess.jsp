<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%-- <s:property value="#request.url"/> --%>
<h3>
    <span>审核流程跟踪</span>
    <i id=<s:property value="#request.actHiTaskinstList[0].procInstId"/> class="delete" style="margin-left: -100px;font-size: 17px;margin-right: 20px;">删除</i>
    <i class="close" style="display: inline;">关闭</i>
</h3>
<ul class="mt20">
    <s:iterator value="#request.actHiTaskinstList" id="task" status="index">
        <s:if test="#task.description != null">
            <li>
                <i class="iconActive"></i>
                <span><s:property value="#task.assignee"/></span>
                <strong><s:property value="#task.description"/></strong>
            </li>
        </s:if>
        <s:else>
            <li>
                <i class="icon"></i>
                <span id="origEmp"><s:property value="#task.assignee"/></span>
                <strong><s:property value="#task.description"/></strong>
                
                <input id="employeeSel" type="text" value="" class="w80 ml36" style="display: none;"/>
                <input id="selectEmpNo" type="text" style="display:none"/>
                
                <input id="updateActivitiAssignee" type="button" value="修改" class="m20" style="margin-left: 36px;width: 80px;"/>
                <input id="updateActivitiAssigneeConfirm" type="button" value="确定" class="m20" style="margin-left: 36px;width: 80px;display: none;"/>
            </li>
        </s:else>
        <s:if test="!#index.last">
            <li class="checkPoint">
                <p class="mt50 ml10"></p>
            </li>
        </s:if>
    </s:iterator>
</ul>
<script type="text/javascript">
$(document).ready(function(){
	var showDeActsByTabs = top.ElementVar.showDeleteActs;
	var showUpActsByTabs = top.ElementVar.showUpdateActs;

   	if(showDeActsByTabs=="none"){
   		$(".delete").hide();
   	}else{
   		$(".delete").show();
   	}
   	if(showUpActsByTabs=="none"){
   		$("#updateActivitiAssignee").hide();
   	}else{
   		$("#updateActivitiAssignee").show();
   	}
   	
   	EmployeeTreeControl.startTree({
        param: "on",  //on在职员工，out离职员工，test测试员工
        treeInputId: "employeeSel",//员工控件框ID
        valInputId: "selectEmpNo", //员工值框id
        inputType: "employee",//employee员工，position职位
        idType: "empNo",        //员工empNo，userNo,职位positionNo,部门deptNo，公司companyNo
        chkStyle: "radio",//选框类型checkbox,radio
        nochecks:[true,true,false],      //逐级不显示单或复选框,true不显示，false显示
        chkboxType:{Y:"ps", N:"ps"},  //Y被勾选时关联父类子类ps，N取消被勾选时关联父类子类ps
        showPreBut: true,   //显示全部员工，在职员工按钮,离职员工，test测试员工
        //showSearch: true,   //显示搜索框
        showLevel:3,         //显示层级
        sizeAuto:true,		//自动调节大小
        width:200,			//宽，单位px
        height:300			//高，单位px
    });
   	
   	$("#updateActivitiAssignee").click(function(){
   		$("#updateActivitiAssigneeConfirm").show();
   		$("#employeeSel").show();
   		$("#updateActivitiAssignee").hide();
   	});
   	$("#updateActivitiAssigneeConfirm").click(function(){
   		if($String.IsNullOrEmpty($("#selectEmpNo").val())){
   			alert("请输入修改后审核人");
   			return false;
   		}
		if(confirm("确定要把审核人由\""+$("#origEmp").text()+"\"修改为\""+$("#employeeSel").val()+"\"吗？")){
			var url = $Url.BuildWorkFlowUrl("/workFlow/processing/ajaxUpdateActivitis");
	        $.ajax({
	            type: "post",
	            url: url,
	            dataType: "json",
	            timeout: 30000,
	            data: { activitiNo: $(".delete").attr("id"),
	            		updateActivitiAssigneeInput:$("#selectEmpNo").val()},
	            async:false,
	            beforeSend: function () {
	            },
	            error: function (XMLHttpRequest, textStatus, errorThrown) {
	                alert(errorThrown);
	            },
	            success: function (data, textStatus) {
	            	alert(data.errDesc);
	            	if(data.errCode == "0000"){
	            		$("#updateActivitiAssigneeConfirm").hide();
		           		$("#employeeSel").hide();
		           		$("#updateActivitiAssignee").show();
		           		$("#origEmp").text($("#employeeSel").val());
	            	}
	            },
	            complete: function (XMLHttpRequest, textStatus) {
	            }
	        });
		}
	});
   	
   		
	$(".delete").click(function(){
		if(confirm("确定删除该流程吗？\n删除后需由申请人重新发起")){
			var url = $Url.BuildWorkFlowUrl("/workFlow/processing/ajaxDeleteActivitis");
	        $.ajax({
	            type: "post",
	            url: url,
	            dataType: "json",
	            timeout: 30000,
	            data: { activitiNo: this.id },
	            async:false,
	            beforeSend: function () {
	            },
	            error: function (XMLHttpRequest, textStatus, errorThrown) {
	                alert(errorThrown);
	            },
	            success: function (data, textStatus) {
	            	alert(data.errDesc);
	            },
	            complete: function (XMLHttpRequest, textStatus) {
	            }
	        });
		}
	});
});
</script>