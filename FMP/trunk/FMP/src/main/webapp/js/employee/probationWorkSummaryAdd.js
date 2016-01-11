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
    },
    DisableInput: function () {
        $(".data").attr("disabled", "disabled");
    },
    ShowEditButton: function (currStatus) {
        if ($("#edit").length > 0)
            $("#edit").show();
        if ($("#submit").length > 0)
            $("#submit").hide();

    },
    HideEditButton: function () {
        if ($("#edit").length > 0)
            $("#edit").hide();
        if ($("#submit").length > 0)
            $("#submit").show();

    },
    GetInfo: function (id) {
        var url = $Url.BuildEmployeeUrl("/employee/probationWorkSummary/ajaxGetProbationWorkSummary");
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
                $("#empName").val(data.info.empName);
                $("#empNo").val(data.info.empNo);
                $("#hcompanyNo").val(data.info.companyNo);
                $("#hdeptNo").val(data.info.deptNo);
                $("#hpositionNo").val(data.info.positionNo);
                
				if (!$String.IsNullOrEmpty(data.info.startTime)) {
					var startTime = new Date(data.info.startTime);
					$("#startTime").val(startTime.format("yyyy-MM-dd"));
					}
				if (!$String.IsNullOrEmpty(data.info.endTime)) {
					var endTime = new Date(data.info.endTime);
					$("#endTime").val(endTime.format("yyyy-MM-dd"));
					}
				
				$("#workSummary").text(data.info.workSummary);
				$("#selfEvaluation").text(data.info.selfEvaluation);
				$("#workSuggestion").text(data.info.workSuggestion);

                ManagePage.ShowEditButton();
                if ($("#edit").length > 0) {
                    $("#edit").click(function () {
                        ManagePage.EnableInput();
                        ManagePage.HideEditButton();

                    });
                }
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
                    //alert(request);
                },
                success: function (data) {
                	if(empName!=null&&empName!=""&&data.indexOf(empName)>-1){
                		//$("#examine").hide();
                	}
                    $("#aduitComment").append(data);
                    $("#check1").hide();
					ManagePage.Resize();
                }
            })
    },
       StartAudit:function(url,activitiNo,id,ps){
    	var uri=$Url.BuildEmployeeUrl("/employee/probationEvaluation/edit?id="+id+"&activitiNo=");
		var sendData={
				per:"通过",
				id: 0,
				activitiNo:activitiNo,
				comment:"",
				uri:uri,
				epId:PageVar.ID
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
//					alert("提交成功");
					window.location.href = $Url.BuildEmployeeUrl("/employee/probationWorkSummary/edit?id=" + PageVar.ID+"&activitiNo=" + data.activitiNo);
				}else{
					alert("审批成功");
					window.location.href = $Url.BuildEmployeeUrl("/employee/probationWorkSummary/edit?id=" + ps+"&activitiNo=" + activitiNo);
				}
			},
			complete: function (XMLHttpRequest, textStatus) {
			}
		});
    },
    GetWindow:function(activitiNo){
    	if ($String.IsNullOrEmpty(activitiNo)) {
//			$("#submitExamine").click(function () {
//				var url = $Url.BuildWorkFlowUrl('/workFlow/processing/ajaxStartExtendProbationApplicationProcesss');
//				ManagePage.StartAudit($("#submit1"), url, activitiNo);
//			});
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
			BindEnumList.BindPosition();
		},
		BindCompany:function(){
			EnumList.GetEnumListToSelect($("#companyNo"), "empCompanylist1", $Url.BuildEmployeeUrl("/common/enumList.action"));
		},
		BindDept:function(){
			EnumList.GetEnumListToSelect($("#deptNo"),"dept1", $Url.BuildEmployeeUrl("/common/enumList.action"));
		},
		BindPosition:function(){
			EnumList.GetEnumListToSelect($("#positionNo"),"positionListAll1",$Url.BuildEmployeeUrl("/common/enumList.action"));
		}
	}

$(function () {
	ManagePage.Resize();
	BindEnumList.BindAll();
    $("#back").click(function () {
        window.close();
    });

    if (Number(PageVar.ID) == 0) {
        ManagePage.EnableInput();
        ManagePage.HideEditButton();
    }
    else {
        ManagePage.GetInfo(PageVar.ID);
    }
  $('.trackBtn').on('click',function(){
  var url = $Url.BuildWorkFlowUrl("/workFlow/processing/ajaxAuditProcess");
  var activitiNo = ManagePage.GetUrlActivitNo();
  initAll.GetAuditProcess(url,activitiNo);
  });
  if(ElementVar.print=="none"){
	  $('#print').css("display","none");
  }else{
	  $('#print').css("display","inline");
	  
	  $('#print').on('click',function(){
		  $("#empName").attr("value",$("#empName").val());
		  $("#startTime").attr("value",$("#startTime").val());
		  $("#endTime").attr("value",$("#endTime").val());
		  
		  $("#btn").css("display","none");
		  $(".trackBtn").css("display","none");
		  

		  bdhtml=window.document.body.innerHTML;//获取当前页的html代码
			sprnstr="<!--startprint"+1+"-->";//设置打印开始区域
			eprnstr="<!--endprint"+1+"-->";//设置打印结束区域
			prnhtml=bdhtml.substring(bdhtml.indexOf(sprnstr)+18); //从开始代码向后取html

			prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));//从结束代码向前取html
			window.document.body.innerHTML=prnhtml;
			window.print();
			window.document.body.innerHTML=bdhtml;
			window.location.reload();
	  });
  }
    
    $("#companyNo").find("option[value="+$("#hcompanyNo").val()+"]").attr("selected",true);
    $("#deptNo").find("option[value="+$("#hdeptNo").val()+"]").attr("selected",true);
    $("#positionNo").find("option[value="+$("#hpositionNo").val()+"]").attr("selected",true);
    

    $("#companyNo").off().change(function(){
		if($("#companyNo").val()==1){
			$("#deptNo").empty();
			EnumList.GetEnumListToSelect($("#deptNo"), "deptListByCompany1", $Url.BuildEmployeeUrl("/common/enumList.action"),$("#companyNo").val());
			if($("#deptNo").val()!=0){
				$("#positionNo").empty();
				EnumList.GetEnumListToSelect($("#positionNo"), "positionListBydeptType1", $Url.BuildEmployeeUrl("/common/enumList.action"),$("#deptNo").val());
			}
		}else if($("#companyNo").val()==0){
			$("#deptNo").empty();
			$("#positionNo").empty();
			BindEnumList.BindDept();
			BindEnumList.BindPosition();
		}
	});
	$("#deptNo").off().change(function(){
		if($("#deptNo").val()!=0){
			$("#positionNo").empty();
			EnumList.GetEnumListToSelect($("#positionNo"), "positionListBydeptType1", $Url.BuildEmployeeUrl("/common/enumList.action"),$("#deptNo").val());
		}else{
			BindEnumList.BindPosition();
		}
    });
    
	$("#startTime").click(function () {
		WdatePicker({dateFmt: 'yyyy-MM-dd'});
	});
	$("#endTime").click(function () {
		WdatePicker({dateFmt: 'yyyy-MM-dd'});
	});


    var probationWorkSummaryAdd = $("#probationWorkSummaryAdd").Validform({
        tiptype: function (msg, o, cssctl) {
            var objtip = o.obj.siblings(".Validform_checktip");
            cssctl(objtip, o.type);
            objtip.text(msg);
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
            var url = $Url.BuildEmployeeUrl("/employee/probationWorkSummary/ajaxEditProbationWorkSummary");
            var oper = "add";
            if (Number(PageVar.ID) != 0)
                oper = "edit";
            var strs=ManagePage.GetUrlActivitNo();
            var info = {
                id: PageVar.ID,
				empNo: $("#empNo").val(),
				companyNo: $("#companyNo").val(),
				deptNo: $("#deptNo").val(),
				positionNo: $("#positionNo").val(),
				startTime: $("#startTime").val().toTimetamp(),
				endTime: $("#endTime").val().toTimetamp(),
				selfEvaluation: $("#selfEvaluation").val(),
				workSuggestion: $("#workSuggestion").val(),
				workSummary: $("#workSummary").val(),
				editComment: $("#editComment").val(),
				activitiNo:strs
            }
            $.ajax({
                type: "post",
                url: url,
                dataType: "json",
                timeout: 30000,
                data: {
                    oper: oper,
                    info: JSON.stringify(info),
                    activitiID:strs
                },
                beforeSend: function () {
                    $("#submit").attr("process", "processing");
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(errorThrown);
                },
                success: function (data, textStatus) {
					if (data.errCode == "0000") {
							var url = $Url.BuildWorkFlowUrl("/workFlow/auditTask/ajaxAddExamineForProbationWorkSummary.action");
							ManagePage.StartAudit(url, data.info.activitiNo,PageVar.probationEvaluationId,data.errDesc);

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
    probationWorkSummaryAdd.addRule([
		{
			ele:"#workSummary",
		    dataType:"*",
		    nullmsg:"请填写工作总结",
		    sucmsg:" ",
		    errmsg:""
		},
		{				
		    ele:"#selfEvaluation",
		    datatype:"*",
		    //ignore:"ignore",
		    nullmsg:"请填写自我评价",
		    errormsg:"",
		    sucmsg:" "
		},
		{				
		    ele:"#workSuggestion",
		    datatype:"*",
		    //ignore:"ignore",
		    nullmsg:"请填写工作建议及自我展思路",
		    errormsg:"",
		    sucmsg:" "
		},
		{				
		    ele:"#companyNo",
		    datatype:"verifySelect",
		    //ignore:"ignore",
		    nullmsg:"",
		    errormsg:"请选择公司",
		    sucmsg:" "
		},
		{				
		    ele:"#deptNo",
		    datatype:"verifySelect",
		    //ignore:"ignore",
		    nullmsg:"",
		    errormsg:"请选择部门",
		    sucmsg:" "
		},
		{				
		    ele:"#positionNo",
		    datatype:"verifySelect",
		    //ignore:"ignore",
		    nullmsg:"",
		    errormsg:"请选择职位",
		    sucmsg:" "
		},
		{
			ele:"#startTime",
			dataType:"/^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))$/",
			//dataType:"/^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))\\s+([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$/",
			//ignore:"ignore",
			nullmsg:"请填写开始日期",
			errormsg:"请填写正确的日期",
			sucmsg:" "
		},
		{
			ele:"#endTime",
			dataType:"/^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))$/",
			//dataType:"/^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))\\s+([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$/",
			nullmsg:"请填写结束日期",
			errormsg:"请填写正确的日期",
			sucmsg:" "
		}
    ]);
})
