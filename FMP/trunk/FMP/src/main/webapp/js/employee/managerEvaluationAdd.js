var ManagePage = {
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
    },
    DisableInput: function () {
        $(".data").attr("disabled", "disabled");
    },
    ShowEditButton: function () {
    	var activitID=ManagePage.GetUrlActivitNo();
    	if(!$String.IsNullOrEmpty(activitID)){
    		if ($("#edit").length > 0) {
                $("#edit").show();
                $("#submitExamine").hide();
                $("#examine").show();
            }
            if ($("#submit").length > 0)
                $("#submit").hide();
    	}else{
    		 if ($("#edit").length > 0) {
    	            $("#edit").show();
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
            }
            if ($("#submit").length > 0)
                $("#submit").show();
    	}

    },
    GetInfo: function (id) {
        var url = $Url.BuildEmployeeUrl("/employee/managerEvaluation/ajaxGetManagerEvaluation");
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
                if(data.info!=null){
                	$Util.DataToVal(data.info, ElementVar);
                	$("#score").val(data.info.score);
                	$("#companyNo").val(data.info.companyNo);
                	$("#deptNo").val(data.info.deptNo);
                	$("#empNo").val(data.info.empNo);
                	$("#managerTime").val(ManagePage.ToDDMMMYYYY(data.info.managerTime));
                }
                ManagePage.ShowEditButton();
                if ($("#edit").length > 0) {
                    $("#edit").click(function () {
                        ManagePage.EnableInput();
                        ManagePage.HideEditButton();

                    });
                }
                if(id==0){
                	$("#examine").hide();
                	ManagePage.HideEditButton();
                }else{
//                	if(data.info.activitiNo==""){
//                		$("#examine").val("提交审批");
//                		if($("#submit").css("display")=="inline"){
//                			$("#examine").hide();
//                		}else{
//                			$("#examine").show();
//                		}
//                	}else{
//                		$("#examine").val("审批");
//                		if($("#activitiStatus").val()=="1"){//申请人查看
//                			$("#edit").hide();
//                			$("#submit").hide();
//                			$("#examine").hide();
//                		}else if($("#activitiStatus").val()=="2"){//申请人修改
//                			$("#examine").hide();
//                		}else if($("#activitiStatus").val()=="3"){//审核人审核
//                			$("#edit").hide();
//                			$("#submit").hide();
//                			$("#examine").show();
//                		}else{
//                			$("#edit").hide();
//                			$("#submit").hide();
//                			$("#examine").hide();
//                		}
//                	}
                }
                if(data.info!=null){
                	ManagePage.GetAuditComment(data.info.activitiNo,data.empName);
                	ManagePage.GetWindow(data.info.activitiNo);
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
    ToDDMMMYYYY:function(date) {  
        var d = new Date(date);  
        var dd = d.getDate() < 10 ? "0" + d.getDate() : d.getDate().toString(); 
        var mm = d.getMonth()+1< 10 ? "0" + (d.getMonth()+1):(d.getMonth()+1).toString();  
        var yyyy = d.getFullYear().toString();
        return yyyy +"-"+ mm + "-"+dd;  
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
                    alert(request);
                },
                success: function (data) {
                	if(empName!=null&&empName!=""&&data.indexOf(empName)>-1){
//                		$("#examine").hide();
                	}
                    $("#aduitComment").append(data);
                    $("#check1").hide();
                    for(var i=1;i<5;i++){
                    	if($("#checkTime"+i).length>0){
                    		$("#checkTime"+i).val($("#checkTime"+i).val());
                    	}
                    }
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
					window.location.href = $Url.BuildEmployeeUrl("/employee/managerEvaluation/edit?id=" + PageVar.ID+"&activitiNo=" + data.activitiNo);
				}else{
					alert("审批成功");
//					$("#examine").hide();
					window.location.href = $Url.BuildEmployeeUrl("/employee/managerEvaluation/edit?id=" + PageVar.ID+"&activitiNo=" + activitiNo);
				}
//				$("#taskCommet").val("");
//				$('#w1').window('close');
//				window.location.reload();////
				
			},
			complete: function (XMLHttpRequest, textStatus) {
			}
		});
    },
    GetWindow:function(activitiNo){
    	if ($String.IsNullOrEmpty(activitiNo)) {
			$("#submitExamine").click(function () {
				var url = $Url.BuildWorkFlowUrl('/workFlow/processing/ajaxStartManagerEvaluationProcess.action');
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

var BindEnumList={
	BindAll:function(){
		BindEnumList.BindDept();
		BindEnumList.BindCompany();
		BindEnumList.BindEmp();
	},
	BindCompany:function(){
		EnumList.GetEnumListToSelect($("#companyNo"), "empCompanylist1", $Url.BuildEmployeeUrl("/common/enumList.action"));
	},
	BindDept:function(){
		EnumList.GetEnumListToSelect($("#deptNo"),"dept1", $Url.BuildEmployeeUrl("/common/enumList.action"));
	},
	BindEmp:function(){
		EnumList.GetEnumListToSelect($("#empNo"),"empListForEmp1",$Url.BuildEmployeeUrl("/common/enumList.action"));
	}
}

$(function () {
	BindEnumList.BindAll();
	if (Number(PageVar.ID) == 0) {
        ManagePage.EnableInput();
        ManagePage.HideEditButton();
        ManagePage.GetInfo(0);
    }
    else {
        ManagePage.GetInfo(PageVar.ID);
    }
	
	$("#managerTime").click(function () {
		WdatePicker({dateFmt: 'yyyy-MM-dd'});
	});
	
	/*var companyNoV = "";
	var deptV = "";
	var empNoV = "";
	companyNoV = $("#companyNo").val();
	deptV = $("#deptNo").val();
	empNoV = $("#empNo").val();
	if(companyNoV!="0"&&empNoV!="0"&&deptV!="0"){
		EnumList.GetEnumListToSelect($("#deptNo"), "deptListByCompany1", $Url.BuildEmployeeUrl("/common/enumList.action"),companyNoV);
		$("#deptNo").val(deptV);
		EnumList.GetEnumListToSelect($("#empNo"), "empListByPositionNo", $Url.BuildEmployeeUrl("/common/enumList.action"),deptV);
		$("#empNo").val(empNoV);
	}*/
	$("#companyNo").off().change(function(){
		if($("#companyNo").val()==1){
			$("#deptNo").empty();
			EnumList.GetEnumListToSelect($("#deptNo"), "deptListByCompany1", $Url.BuildEmployeeUrl("/common/enumList.action"),$("#companyNo").val());
			$("#empNo").empty();
			EnumList.GetEnumListToSelect($("#empNo"), "empNo1", $Url.BuildEmployeeUrl("/common/enumList.action"),$("#deptNo").val());
		}
	});
	$("#deptNo").off().change(function(){
		if($("#deptNo").val()!=0){
			$("#empNo").empty();
			EnumList.GetEnumListToSelect($("#empNo"), "empNo1", $Url.BuildEmployeeUrl("/common/enumList.action"),$("#deptNo").val());
		}else{
			BindEnumList.BindEmp();
		}
    });
	
	
	
    $("#back").click(function () {
        window.close();
    });
	$('.trackBtn').on('click',function(){
		var url = $Url.BuildWorkFlowUrl("/workFlow/processing/ajaxAuditProcess");
		var activitiNo = ManagePage.GetUrlActivitNo();
		initAll.GetAuditProcess(url,activitiNo);
	});


    var managerEvaluationAdd = $("#managerEvaluationAdd").Validform({
        tiptype: function (msg, o, cssctl) {
//            var objtip = o.obj.siblings(".Validform_checktip");
//            cssctl(objtip, o.type);
//            objtip.text(msg);
        	$("#errMsg").html("");
        	$("#errMsg").html(msg);
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
            var url = $Url.BuildEmployeeUrl("/employee/managerEvaluation/ajaxEditManagerEvaluation");
            var oper = "add";
            if (Number(PageVar.ID) != 0)
                oper = "edit";
            var strs=ManagePage.GetUrlActivitNo();
            var info = {
                id: PageVar.ID,
				companyNo: $("#companyNo").val(),
				deptNo: $("#deptNo").val(),
				empNo: $("#empNo").val(),
				scoreIntroduction: $("#scoreIntroduction").val(),
				scoreAccord: $("#scoreAccord").val(),
				score: $("#score").val(),
				suggestion: $("#suggestion").val(),
				activitiNo: $("#activitiNo").val(),
				editComment: $("#editComment").val(),
				managerTime: $("#managerTime").val()
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
                    	window.location.href = $Url.BuildEmployeeUrl("/employee/managerEvaluation/edit?id=" + data.errDesc+"&activitiNo="+strs);
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
    managerEvaluationAdd.addRule([
		{
			ele:"#scoreIntroduction",
		    dataType:"*",
		    nullmsg:"请填写评估事实说明",
		    sucmsg:" ",
		    errmsg:""
		},
		{				
		    ele:"#scoreAccord",
		    datatype:"*",
		    //ignore:"ignore",
		    nullmsg:"请填写评分依据",
		    errormsg:"",
		    sucmsg:" "
		},
		{				
		    ele:"#score",
		    datatype:"/^0|[1]0|[1-9]{1}|[1-9]{1,1}?\.[1-9]{1,1}|0\.[1-9]{1,1}?$/",
		    //ignore:"ignore",
		    nullmsg:"请填写分数",
		    errormsg:"请填写正确的分数",
		    sucmsg:" "
		},
		{				
		    ele:"#suggestion",
		    datatype:"*",
		    //ignore:"ignore",
		    nullmsg:"请填写处理意见",
		    errormsg:"",
		    sucmsg:" "
		},
		{				
		    ele:"#companyNo",
		    datatype:"verifySelect",
		    //ignore:"ignore",
		    nullmsg:"",
		    errormsg:"请选择被评估人公司",
		    sucmsg:" "
		},
		{				
		    ele:"#deptNo",
		    datatype:"verifySelect",
		    //ignore:"ignore",
		    nullmsg:"",
		    errormsg:"请选择被评估人部门",
		    sucmsg:" "
		},
		{				
		    ele:"#empNo",
		    datatype:"verifySelect",
		    //ignore:"ignore",
		    nullmsg:"",
		    errormsg:"请选择被评估人姓名",
		    sucmsg:" "
		},
		{
			ele:"#managerTime",
			dataType:"/^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))$/",
			//dataType:"/^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))\\s+([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$/",
			//ignore:"ignore",
			nullmsg:"请填写评估日期",
			errormsg:"请填写正确的日期",
			sucmsg:" "
		}
    ]);
})
