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
    	var activitID=ManagePage.GetUrlActivitNo();
    	if(!$String.IsNullOrEmpty(activitID)){
    		if ($("#edit").length > 0) {
                $("#edit").show();
                $("#submitExamine").hide();
                $("#submit").hide();
            }
//            if ($("#submit").length > 0)
//                $("#submit").hide();
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
        var url = $Url.BuildEmployeeUrl("/employee/extendProbationApplication/ajaxGetExtendProbationApplication");
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
                $("#deptNo").val(data.info.deptNo);
                EnumList.GetEnumListToSelect($("#positionNo"), "positionListBydeptType1", $Url.BuildProductUrl("/common/enumList.action"),data.info.deptNo);
                $("#positionNo").val(data.info.positionNo);
                $("#people1").val(data.info.empName);
                $("#people2").val(data.info.empName);
                if (!$String.IsNullOrEmpty(data.info.startTime)) {
					var startTime = new Date(data.info.startTime);
					$("#startTime").val(startTime.format("yyyy-MM-dd"));
					}
				if (!$String.IsNullOrEmpty(data.info.extendStartTime)) {
					var extendStartTime = new Date(data.info.extendStartTime);
					$("#extendStartTime").val(extendStartTime.format("yyyy-MM-dd"));
					}
				if (!$String.IsNullOrEmpty(data.info.extendEndTime)) {
					var extendEndTime = new Date(data.info.extendEndTime);
					$("#extendEndTime").val(extendEndTime.format("yyyy-MM-dd"));
					}
				if (!$String.IsNullOrEmpty(data.info.inTime)) {
					var inTime = new Date(data.info.inTime);
					$("#inTime1").val(inTime.format("yyyy-MM-dd"));
					}
				if (!$String.IsNullOrEmpty(data.info.editTime)) {
					var editTime = new Date(data.info.editTime);
					$("#editTime2").val(editTime.format("yyyy-MM-dd"));
					}
                ManagePage.ShowEditButton();
                if ($("#edit").length > 0) {
                    $("#edit").click(function () {
                        ManagePage.EnableInput();
                        ManagePage.HideEditButton();
                    });
                };
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
       StartAudit:function(obj,url,activitiNo){
    	var uri=window.location.href;
		var sendData={
				per:obj.val(),
				id: PageVar.ID,
				activitiNo:activitiNo,
				comment:$("#taskCommet").val(),
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
					alert("提交成功");
					window.location.href = $Url.BuildEmployeeUrl("/employee/extendProbationApplication/edit?id=" + PageVar.ID+"&activitiNo=" + data.activitiNo);
				}else{
					alert("审批成功");
					window.location.href = $Url.BuildEmployeeUrl("/employee/extendProbationApplication/edit?id=" + PageVar.ID+"&activitiNo=" + activitiNo);
//					$("#examine").hide();
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
//			$("#submitExamine").click(function () {
//				var url = $Url.BuildWorkFlowUrl('/workFlow/processing/ajaxStartExtendProbationApplicationProcesss');
//				ManagePage.StartAudit($("#submit1"), url, activitiNo);
//			});
		} else {
			$("#examine").click(function () {
				$('#w1').window('open');
			});
			$(".examine").click(function(){
				var url = $Url.BuildWorkFlowUrl("/workFlow/auditTask/ajaxAddExamineForExtendProbationApplication.action");
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
$(function () {
	ManagePage.Resize();
    $('.trackBtn').on('click',function(){
        var url = $Url.BuildWorkFlowUrl("/workFlow/processing/ajaxAuditProcess");
        var activitiNo = ManagePage.GetUrlActivitNo();
        initAll.GetAuditProcess(url,activitiNo);
    });
    $("#back").click(function () {
    	 //history.go(-1);
//    	var urlArr = $("#backUrl").val().split(",");
//    	if(urlArr.length==2){
//    		window.location.href = urlArr[1];
//    	}else{
//    		window.location.href = urlArr[0];
//    	}
    	//window.location.href = $("#backUrl").val();
        $EasyUI.Close();
    });
    EnumList.GetEnumListToSelect($("#deptNo"), "dept", $Url.BuildProductUrl("/common/enumList.action"));
    if (Number(PageVar.ID) == 0) {
    	 var url = $Url.BuildEmployeeUrl("/employee/employee/ajaxExtendEmp");
    	 $.ajax({
             type: "post",
             url: url,
             dataType: "json",
             timeout: 30000,
             data: {},
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
                 $Util.DataToVal(data.employee,ElementVar);
                 if(data.employee.startTime!=null){
                 var startTime = new Date(data.employee.startTime);
                 $("#startTime").val(startTime.format("yyyy-MM-dd"));
                 }
                 $("#deptNo").val(data.employee.deptNo);
                 EnumList.GetEnumListToSelect($("#positionNo"), "positionListBydeptType1", $Url.BuildProductUrl("/common/enumList.action"),data.employee.deptNo);
                 $("#empNo").val(data.employee.id);
                 $("#code").val("");
                 $("#empName").val(data.employee.name);
                 $("#positionNo").val(data.employee.positionNo);
                 $("#people1").val(data.employee.name);
                 $("#people2").val(data.employee.name);
               }
             
             });
    	
        ManagePage.EnableInput();
        ManagePage.HideEditButton();
        $("#inTime1").val(new Date().format("yyyy-MM-dd"));
        $("#editTime2").val(new Date().format("yyyy-MM-dd"));
    }
    else {
        ManagePage.GetInfo(PageVar.ID);
        ManagePage.DisableInput();
    }
	 $("#deptNo").change(function () {	
		 EnumList.GetEnumListToSelect($("#positionNo"), "positionListBydeptType1", $Url.BuildProductUrl("/common/enumList.action"),$("#deptNo").val());
	});
	
	$("#extendStartTime").click(function () {
		WdatePicker({dateFmt: 'yyyy-MM-dd'});
	});
	$("#extendEndTime").click(function () {
		WdatePicker({dateFmt: 'yyyy-MM-dd'});
	});


    var extendProbationApplicationAdd = $("#extendProbationApplicationAdd").Validform({
        tiptype: function (msg, o, cssctl) {
            var objtip = o.obj.siblings(".Validform_checktip");
            cssctl(objtip, o.type);
            objtip.text(msg);
        },
        callback: function (form) {
            if (!($("#submit").attr("process") === undefined)) {
                return false;
            }
            var url = $Url.BuildEmployeeUrl("/employee/extendProbationApplication/ajaxEditExtendProbationApplication");
            var oper = "add";
            if (Number(PageVar.ID) != 0)
                oper = "edit";
            var strs=ManagePage.GetUrlActivitNo();
            var info = {
                id: PageVar.ID,
				code: $("#code").val(),
				empNo: $("#empNo").val(),
				companyNo: $("#companyNo").val(),
				deptNo: $("#deptNo").val(),
				positionNo: $("#positionNo").val(),
				startTime: $("#startTime").val().toTimetamp(),
				period: $("#period").val(),
				selfEvaluation: $("#selfEvaluation").val(),
				//evaluation: $("#evaluation").val(),
				content: $("#content").val(),
				extendStartTime: $("#extendStartTime").val().toTimetamp(),
				extendEndTime: $("#extendEndTime").val().toTimetamp()
				//activitiNo: $("#activitiNo").val(),
				//editComment: $("#editComment").val()
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
                        window.location.href = $Url.BuildEmployeeUrl("/employee/extendProbationApplication/edit?id=" + data.errDesc+"&activitiNo="+strs);
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
    extendProbationApplicationAdd.addRule([
    {
      ele:"#period",
      datatype:"n",
      //ignore:"ignore",
      errormsg:"请填数字",
      sucmsg:" "
     },
     {
        ele:"#selfEvaluation",
        datatype:"*",
        //ignore:"ignore",
        sucmsg:" "
     },
     {
         ele:"#content",
         datatype:"*",
         //ignore:"ignore",
         sucmsg:" "
      },
     {
         ele:"#extendStartTime",
         datatype:"*",
         //ignore:"ignore",
         sucmsg:" "
      },
      {
          ele:"#extendEndTime",
          datatype:"*",
          //ignore:"ignore",
          sucmsg:" "
       }
    ]);
})
