var ManagePage = {
	Resize: function () {
        $("#content_center").css("min-height", "1000px");
    },
    EnableInput: function () {
        $.each($(".data"), function (index, content) {
            var id = $(this).attr("id");
            if (ElementVar[id] == undefined) {
                $(this).removeAttr("disabled");
            }
            if (ElementVar[id] == TagPermissionType.edit) {
                $(this).removeAttr("disabled");
            }
            if (PageVar.ID == 0 && ElementVar[id] == TagPermissionType.none){
                $(this).parent().remove();
            }
            
        });

        if ($("#empNo").val()!=null||$("#empNo").val()!="") {
        	$("#empNo").attr("disabled", "disabled");
		}
        if ($("#deptNo").val()!=null||$("#deptNo").val()!="") {
        	$("#deptNo").attr("disabled", "disabled");
		}
        if ($("#positionNo").val()!=null||$("positionNo").val()!="") {
        	$("#positionNo").attr("disabled", "disabled");
		}
        $("input[type='checkbox'][checked='checked']").removeAttr("disabled");
        
    },
    DisableInput: function () {
        $(".data").attr("disabled", "disabled");
    },
    ShowEditButton: function (currStatus) {
    	var activitID=ManagePage.GetUrlActivitNo();
    	if(!$String.IsNullOrEmpty(activitID)){
    		if ($("#edit").length > 0) {
                $("#edit").show();
                $("#submitExamine").hide();
                $("#submit").hide();
            }
            if ($("#submit").length > 0)
                $("#submit").hide();
    	}else{
    		 if ($("#edit").length > 0) {
    	            $("#edit").show();
    	            $("#submitExamine").show();
    	        }
    	        if ($("#submit").length > 0)
    	            $("#submit").hide();
    	}
    },
    HideEditButton: function () {
    	var activitID=ManagePage.GetUrlActivitNo();
    	if(!$String.IsNullOrEmpty(activitID)){
    		if ($("#edit").length > 0) {
                $("#edit").hide();
                $("#submitExamine").hide();
                $("#examine").hide();
            }
            if ($("#submit").length > 0)
                $("#submit").show();
    	}else{
    		if ($("#edit").length > 0) {
                $("#edit").hide();
                $("#submitExamine").hide();
            }
            if ($("#submit").length > 0)
                $("#submit").show();
    	}
    },
    GetInfo: function (id) {
        var url = $Url.BuildEmployeeUrl("/employee/personalChange/ajaxGetPersonalChange");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: { id: id },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if (data.errCode != "0000") {
                    $("#msg").text(data.errDesc);
                    return;
                }
                $Util.DataToVal(data.info, ElementVar);
                EnumList.GetEnumListToSelect($("#afterDept"), "dept", $Url.BuildEmployeeUrl("/common/enumList.action"));
            	EnumList.GetEnumListToSelect($("#afterPosition"), "positionList", $Url.BuildEmployeeUrl("/common/enumList.action"));
            	$("#afterDept").val(data.info.afterDept);
            	$("#afterPosition").val(data.info.afterPosition);
            	if (!$String.IsNullOrEmpty(data.info.startTime)) {
					var startTime = new Date(data.info.startTime);
					$("#startTime").val(startTime.format("yyyy-MM-dd"));// HH:mm:ss
					}
				if (!$String.IsNullOrEmpty(data.info.applyTime)) {
					var applyTime = new Date(data.info.applyTime);
					$("#applyTime").val(applyTime.format("yyyy-MM-dd"));
					$("#applyTime1").val(applyTime.format("yyyy-MM-dd"));
					}
				if (!$String.IsNullOrEmpty(data.info.forceTime)) {
					var forceTime = new Date(data.info.forceTime);
					$("#forceTime").val(forceTime.format("yyyy-MM-dd"));
					}
				
				$("#empNo1").val(data.info.empNo);
				
				var v = data.info.property;
					var temp = $("input[type='checkbox'][value='"+v+"']");
					temp.attr("checked","checked").prop('checked',true);
					$("input[type='checkbox']").attr("disabled","disabled");
					temp.removeAttr("disabled");
					
				if (id!="0") {
					ManagePage.ShowEditButton();
	                if ($("#edit").length > 0) {
	                    $("#edit").click(function () {
	                        ManagePage.EnableInput();
	                        ManagePage.HideEditButton();
	
	                    });
	                }
	                $("input[type='checkbox'][checked='checked']").attr("disabled", "disabled");
	                if(document.getElementById("checkbox1").checked||document.getElementById("checkbox2").checked){
	                 	$(".change").show();
	                 }
				}else{
					ManagePage.EnableInput();
			        ManagePage.HideEditButton();
				}
//                if(data.info.activitiNo==""){
//                	$("#examine").val("提交审批");
//                	if($("#submit").css("display")=="inline"){
//                		$("#examine").hide();
//                	}else{
//                		$("#examine").show();
//                	}
//                }else{
//                	$("#examine").val("审批");
//                	if($("#activitiStatus").val()=="1"){//申请人查看
//                		$("#edit").hide();
//                		$("#submit").hide();
//                		$("#examine").hide();
//                	}else if($("#activitiStatus").val()=="2"){//申请人修改
//                		$("#examine").hide();
//                	}else if($("#activitiStatus").val()=="3"){//审核人审核
//                		$("#edit").hide();
//                		$("#submit").hide();
//                		$("#examine").show();
//                	}else{
//                		$("#edit").hide();
//                		$("#submit").hide();
//                		$("#examine").hide();
//                	}
//                }
                ManagePage.GetAuditComment(data.info.activitiNo,data.empName);
                ManagePage.GetWindow(data.info.activitiNo);
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
    GetAuditComment: function (activitiNo,empName) {
    	var url = $Url.BuildWorkFlowUrl("/workFlow/processing/ajaxAuditComment");
        $.ajax({
                type: "POST",
                url: url,
                dataType: "html",
                data: {
                	"activitiNo":activitiNo
                },
                error: function (request) {
                   // alert(request);
                },
                success: function (data) {
                	if(empName!=null&&empName!=""&&data.indexOf(empName)>-1){
//                		$("#examine").hide();
                	}
                    $("#aduitComment").append(data);
                    $("#check1").hide();
                }
            })
    },
    StartAudit:function(obj,url,activitiNo){
    	var uri=window.location.href;
		var sendData={
				per:obj.val(),
				id: PageVar.ID,
				activitiNo:activitiNo,
				comment:$("#taskCommet").val(),
				uri:uri
		};
		$.ajax({
			type: "post",
			url: url,
			dataType: "json",
			timeout: 30000,
			data: sendData,
			beforeSend: function () {
			},
			error: function (XMLHttpRequest, textStatus, errorThrown,request) {
				alert(errorThrown);
				//alert(request);
			},
			success: function (data, textStatus) {
				if ($String.IsNullOrEmpty(activitiNo)) {
					alert("提交成功");
					window.location.href = $Url.BuildEmployeeUrl("/employee/personalChange/edit?id=" + PageVar.ID+"&activitiNo=" + data.activitiNo);
				}else{
					alert("审批成功");
//					$("#examine").hide();
					window.location.href = $Url.BuildEmployeeUrl("/employee/personalChange/edit?id=" + PageVar.ID+"&activitiNo=" + activitiNo);
				}
//				$("#taskCommet").val("");
//				$('#w1').window('close');
//				window.location.reload();
				
			},
			complete: function (XMLHttpRequest, textStatus) {
			}
		});
    },
    GetWindow:function(activitiNo){
    	if ($String.IsNullOrEmpty(activitiNo)) {
			$("#submitExamine").click(function () {
				var url = $Url.BuildWorkFlowUrl('/workFlow/processing/ajaxStartPersonalChangeProcess.action');
				ManagePage.StartAudit($("#submit1"), url, activitiNo);
			});
		} else {
			$("#examine").click(function () {
				$('#w1').window('open');
			});
			$(".examine").click(function(){
				var url = $Url.BuildWorkFlowUrl("/workFlow/auditTask/ajaxAddExamine.action");
				ManagePage.StartAudit($(this), url, activitiNo);
			});
		}
    },
    GetUrlActivitNo:function(){
    	var urlTemp = location.search;
        var theRequest = new Object();
        var strs="";
        if (urlTemp.indexOf("?") != -1) {
           var str = urlTemp.substr(1);
           if(str.indexOf("activitiNo=") != -1){
        	   strs = str.split("activitiNo=")[1];
           }
        }
        return strs;
    }
}

var Tools={
		checkBoxInit:function(){
			$("input[type='checkbox']").off().on("click",function(){
					var v = $(this).attr("value");
					if ($(this).attr("checked")=="checked"||$(this).attr("checked")=="true") {
						$(this).removeAttr("checked");
						$("input[type='checkbox']").removeAttr("disabled");
						$("#property").val("");
					}
					else{
						$(this).attr("checked","true").prop('checked',true);
						$("input[type='checkbox']").attr("disabled","disabled");
						$(this).removeAttr("disabled");
						$("#property").val(v);
					}
			});
			
		}	
		
		
}


$(function () {
	ManagePage.Resize();
	Tools.checkBoxInit();
	EnumList.GetEnumListToSelect($("#empNo"), "empListById", $Url.BuildEmployeeUrl("/common/enumList.action"));
	EnumList.GetEnumListToSelect($("#empNo1"), "empListById", $Url.BuildEmployeeUrl("/common/enumList.action"));
	EnumList.GetEnumListToSelect($("#deptNo"), "dept", $Url.BuildEmployeeUrl("/common/enumList.action"));
	EnumList.GetEnumListToSelect($("#positionNo"), "positionList", $Url.BuildEmployeeUrl("/common/enumList.action"));
	$(".checkbox1").hide();
	$(".checkbox2").hide();
	$(".change").hide();
	var val=0;
	$("#checkbox1").click(function(){
		$(".checkbox1").show();
		$(".checkbox2").hide();
		EnumList.GetEnumListToSelect($("#deptId"), "dept", $Url.BuildEmployeeUrl("/common/enumList.action"));
		$("#deptId").change(function () {	
		 EnumList.GetEnumListToSelect($("#positionId"), "positionListBydeptType1", $Url.BuildProductUrl("/common/enumList.action"),$("#deptId").val());
		  }); 
		val=1;
	});
	$("#checkbox2").click(function(){
		$(".checkbox2").show();
		$(".checkbox1").hide();
		EnumList.GetEnumListToSelect($("#pNo"), "positionList", $Url.BuildEmployeeUrl("/common/enumList.action"),$("#deptNo").val());
		val=2;
	});
    $("#back").click(function () {
        window.close();
    });
	$('.trackBtn').on('click',function(){
		var url = $Url.BuildWorkFlowUrl("/workFlow/processing/ajaxAuditProcess");
		var activitiNo = ManagePage.GetUrlActivitNo();
		initAll.GetAuditProcess(url,activitiNo);
	});

    if (Number(PageVar.ID) == 0) {
//        ManagePage.EnableInput();
    	ManagePage.GetInfo(0);
    }
    else {
    	 ManagePage.GetInfo(PageVar.ID);
    	 /*if(document.getElementById("checkbox1").checked||document.getElementById("checkbox2").checked){
         	$(".change").show();
         }*/
    }

	$("#startTime").click(function () {
		WdatePicker({dateFmt: 'yyyy-MM-dd'});// HH:mm:ss
	});
	$("#applyTime").click(function () {
		WdatePicker({dateFmt: 'yyyy-MM-dd'});
	});
	$("#applyTime").blur(function () {
		var applyTime = $("#applyTime").val()
		$("#applyTime1").val(applyTime);
	});
	
	$("#forceTime").click(function () {
		WdatePicker({dateFmt: 'yyyy-MM-dd'});
	});


    var personalChangeAdd = $("#personalChangeAdd").Validform({
        tiptype: function (msg, o, cssctl) {
//            var objtip = o.obj.siblings(".Validform_checktip");
//            cssctl(objtip, o.type);
//            objtip.text(msg);
        	$("#msg").html("");
        	$("#msg").html(msg);
        },
        datatype:{
            "verifySelect": function (gets, obj, curform, datatype) {
            	if (gets == "0" || gets == "")
            		return false;
            	else
            		return true;
            }
        },
        callback: function (form) {
            if (!($("#submit").attr("process") === undefined)) {
                return false;
            }
            var url = $Url.BuildEmployeeUrl("/employee/personalChange/ajaxEditPersonalChange");
            var oper = "add";
            if (Number(PageVar.ID) != 0)
                oper = "edit";
            //获取移动后的部门和职位
            var afterDept="";
        	var afterPosition="";
            if(val==1){
            	afterDept=$("#deptId").val();
            	afterPosition=$("#positionId").val();
            }else{
            	afterDept=$("#deptNo").val()
            	afterPosition=$("#pNo").val();
            }
            var strs=ManagePage.GetUrlActivitNo();
            var info = {
                id: PageVar.ID,
				code: $("#code").val(),
				empNo: $("#empNo").val(),
				companyNo: $("#companyNo").val(),
				deptNo: $("#deptNo").val(),
				positionNo: $("#positionNo").val(),
				startTime: $("#startTime").val().toTimetamp(),
				applyTime: $("#applyTime").val().toTimetamp(),
				forceTime: $("#forceTime").val().toTimetamp(),
				reason: $("#reason").val(),
				property: $("#property").val(),
				remark: $("#remark").val(),
				activitiNo: $("#activitiNo").val(),
				editComment: $("#editComment").val(),
				afterDept:afterDept,
				afterPosition:afterPosition
            }
            $.ajax({
                type: "post",
                url: url,
                dataType: "json",
                timeout: 30000,
                data: {
                    oper: oper,
                    activitiID:strs,
                    info: JSON.stringify(info)
                },
                beforeSend: function () {
                    $("#submit").attr("process", "processing");
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(errorThrown);
                },
                success: function (data, textStatus) {
                    if (data.errCode == "0000") {
                        window.location.href = $Url.BuildEmployeeUrl("/employee/personalChange/edit?id=" + data.errDesc+"&activitiNo="+strs);
                    } else {
                        $("#msg").text(data.errDesc);
                    }
                },
                complete: function (XMLHttpRequest, textStatus) {
                    $("#submit").removeAttr("process");
                }
            });
            return false;
        }
    });
    personalChangeAdd.addRule([
		{				
		    ele:"#empNo",
		    datatype:"verifySelect",
		    //ignore:"ignore",
		    nullmsg:"",
		    errormsg:"请选择填写姓名",
		    sucmsg:" "
		}, 
		{				
		    ele:"#deptNo",
		    datatype:"verifySelect",
		    //ignore:"ignore",
		    nullmsg:"",
		    errormsg:"请选择填写部门",
		    sucmsg:" "
		},
		{				
		    ele:"#positionNo",
		    datatype:"verifySelect",
		    //ignore:"ignore",
		    nullmsg:"",
		    errormsg:"请选择填写职位",
		    sucmsg:" "
		},
		{
			ele:"#startTime",
			dataType:"/^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))$/",
//			dataType:"/^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))\\s+([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$/",
			nullmsg:"请填写入职日期",
			errormsg:"请填写正确的日期",
			sucmsg:" "
		},
		{
			ele:"#applyTime",
			dataType:"/^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))$/",
//			dataType:"/^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))\\s+([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$/",
			nullmsg:"请填写日期",
			errormsg:"请填写正确的日期",
			sucmsg:" "
		},
		{
			ele:"#reason",
		    dataType:"*",
		    nullmsg:"请填写变动原因",
		    sucmsg:" ",
		    errmsg:"请如实请填写变动原因"
		},
		{
			ele:"#property",
		    dataType:"*",
		    nullmsg:"请选择变动性质",
		    sucmsg:" ",
		    errmsg:"请如实请选择变动性质"
		}
    ]);
})
