var ManagePage = {
	Resize: function () {
        $("#content_center").css("min-height", $('.wrappContent').height()+300);
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
            if (PageVar.ID == 0 && ElementVar[id] == TagPermissionType.none) {
                $(this).parent().remove();
            }

        });
        if ($("#empNo").val() != null || $("#empNo").val() != "") {
            $("#empNo").attr("disabled", "disabled");
        }
        if ($("#deptNo").val() != null || $("#deptNo").val() != "") {
            $("#deptNo").attr("disabled", "disabled");
        }
        if ($("#positionNo").val() != null || $("positionNo").val() != "") {
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
        var url = $Url.BuildEmployeeUrl("/employee/attendanceApplication/ajaxGetAttendanceApplication");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {id: id},
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
                if (!$String.IsNullOrEmpty(data.info.startTime)) {
                    var startTime = new Date(data.info.startTime);
                    $("#startTime").val(startTime.format("yyyy-MM-dd HH:mm:ss"));
                }
                if (!$String.IsNullOrEmpty(data.info.endTime)) {
                    var endTime = new Date(data.info.endTime);
                    $("#endTime").val(endTime.format("yyyy-MM-dd HH:mm:ss"));
                }

                var v = data.info.type;
                var temp = $("input[type='checkbox'][value='" + v + "']");
                temp.attr("checked", "checked").prop('checked', true);
                $("input[type='checkbox']").attr("disabled", "disabled");
                temp.removeAttr("disabled");

                if (id != 0) {
                    ManagePage.ShowEditButton();
                    if ($("#edit").length > 0) {
                        $("#edit").click(function () {
                            ManagePage.EnableInput();
                            ManagePage.HideEditButton();

                        });
                    }
                    $("input[type='checkbox'][checked='checked']").attr("disabled", "disabled");
                } else {
                    ManagePage.EnableInput();
                    ManagePage.HideEditButton();
                }
                ManagePage.GetAuditComment(data.info.activitiNo, data.empName);
                ManagePage.GetWindow(data.info.activitiNo);
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
    GetAuditComment: function (activitiNo, empName) {
        var url = $Url.BuildWorkFlowUrl("/workFlow/processing/ajaxAuditComment");
        $.ajax({
            type: "POST",
            url: url,
            dataType: "html",
            data: {
                "activitiNo": activitiNo
            },
            error: function (request) {
                alert(request);
            },
            success: function (data) {
                $("#aduitComment").append(data);
                for (var i = 1; i < 5; i++) {
                    if ($("#checkTime" + i).length > 0) {
                        $("#checkTime" + i).val($("#checkTime" + i).val());
                    }
                }
            }
        })
    },
    StartAudit: function (obj, url, activitiNo) {
        var uri = window.location.href;
        var sendData = {
            per: obj.val(),
            id: PageVar.ID,
            activitiNo: activitiNo,
            comment: $("#taskCommet").val(),
            uri: uri
        };
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: sendData,
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown, request) {
                alert(errorThrown);
                //alert(request);
            },
            success: function (data, textStatus) {
                if ($String.IsNullOrEmpty(activitiNo)) {
                    alert("提交成功");
                    window.location.href = $Url.BuildEmployeeUrl("/employee/attendanceApplication/edit?id=" + PageVar.ID+"&activitiNo=" + data.activitiNo);
                } else {
                    alert("审批成功");
                    window.location.href = $Url.BuildEmployeeUrl("/employee/attendanceApplication/edit?id=" + PageVar.ID+"&activitiNo=" + activitiNo);
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
    GetWindow: function (activitiNo) {
        if ($String.IsNullOrEmpty(activitiNo)) {
            $("#submitExamine").click(function () {
                var url = $Url.BuildWorkFlowUrl('/workFlow/processing/ajaxStartAttendanceApplicationProcess.action');
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

var Tools = {
    checkBoxInit: function () {
        $("input[type='checkbox']").off().on("click", function () {
            var v = $(this).attr("value");
            if ($(this).attr("checked") == "checked" || $(this).attr("checked") == "true") {
                $(this).removeAttr("checked");
                $("input[type='checkbox']").removeAttr("disabled");
                $("#type").val("");
            }
            else {
                $(this).attr("checked", "true").prop('checked', true);
                $("input[type='checkbox']").attr("disabled", "disabled");
                $(this).removeAttr("disabled");
                $("#type").val(v);
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
    $("#back").click(function () {
        window.close();
    });

    if (Number(PageVar.ID) == 0) {
        ManagePage.GetInfo(0);
    }
    else {
        ManagePage.GetInfo(PageVar.ID);
    }

    $("#startTime").click(function () {
        WdatePicker({
            dateFmt: 'yyyy-MM-dd HH:00:00',
            skin: 'whyGreen',
            maxDate: '#F{$dp.$D(\'endTime\')||\'2020-10-01\'}'
        });
    });
    $("#endTime").click(function () {
        WdatePicker({
            dateFmt: 'yyyy-MM-dd HH:00:00',
            skin: 'whyGreen',
            minDate: '#F{$dp.$D(\'startTime\')}',
            maxDate: '2020-10-01'
        });
    });
    $('.trackBtn').on('click',function(){
        var url = $Url.BuildWorkFlowUrl("/workFlow/processing/ajaxAuditProcess");
        var activitiNo = ManagePage.GetUrlActivitNo();
        initAll.GetAuditProcess(url,activitiNo);
    });

//    $("#endTime").blur(function () {
//        var startTime = $("#startTime").val();
//        startTime = startTime.replace(/-/g, "/");
//        var startTime = new Date(startTime);
//        var endTime = $("#endTime").val();
//        endTime = endTime.replace(/-/g, "/");
//        var endTime = new Date(endTime);
//        var time = endTime - startTime;
//        var newTime = new Date(time);
//        var newDay = newTime.getDate() - 1;
//        var newHour = newTime.getUTCHours();
//        var x = $("#endTime").val();
//        if (x != null && x != "") {
//            $("#totalDay").val(newDay);
//            $("#totalHour").val(newHour);
//        } else {
//            $("#totalDay").val("");
//            $("#totalHour").val("");
//        }

//    });


    var attendanceApplicationAdd = $("#attendanceApplicationAdd").Validform({
        tiptype: function (msg, o, cssctl) {
//            var objtip = o.obj.siblings(".Validform_checktip");
//            cssctl(objtip, o.type);
//            objtip.text(msg);
            $("#msg").html("");
            $("#msg").html(msg);
        },
        datatype: {
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
            var url = $Url.BuildEmployeeUrl("/employee/attendanceApplication/ajaxEditAttendanceApplication");
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
                type: $("#type").val(),
                remark: $("#remark").val(),
                startTime: $("#startTime").val().toTimetamp(),
                endTime: $("#endTime").val().toTimetamp(),
                totalDay: $("#totalDay").val(),
                totalHour: $("#totalHour").val(),
                reason: $("#reason").val(),
                editComment: $("#editComment").val()
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
                        window.location.href = $Url.BuildEmployeeUrl("/employee/attendanceApplication/edit?id=" + data.errDesc+"&activitiNo="+strs);
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
    attendanceApplicationAdd.addRule([
        {
            ele: "#empNo",
            datatype: "verifySelect",
            //ignore:"ignore",
            nullmsg: "",
            errormsg: "请选择填写姓名",
            sucmsg: " "
        },
        {
            ele: "#deptNo",
            datatype: "verifySelect",
            //ignore:"ignore",
            nullmsg: "",
            errormsg: "请选择填写部门",
            sucmsg: " "
        },
        {
            ele: "#positionNo",
            datatype: "verifySelect",
            //ignore:"ignore",
            nullmsg: "",
            errormsg: "请选择填写职位",
            sucmsg: " "
        },
        {
            ele: "#startTime",
//			dataType:"/^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))$/",
            dataType: "/^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))\\s+([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$/",
            nullmsg: "请填写开始时间",
            errormsg: "请填写正确的日期",
            sucmsg: " "
        },
        {
            ele: "#endTime",
//			dataType:"/^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))$/",
            dataType: "/^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))\\s+([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$/",
            nullmsg: "请填写截止日期",
            errormsg: "请填写正确的日期",
            sucmsg: " "
        },
        {
            ele: "#reason",
            dataType: "*",
            nullmsg: "请填写原因",
            sucmsg: " ",
            errmsg: "请如实请填写原因"
        },
        {
            ele: "#totalDay",
            dataType: "*",
            nullmsg: "请选择请假几日",
            sucmsg: " ",
            errmsg: "请如实请请选择请假几天日"
        },
        {
            ele: "#totalHour",
            dataType: "*",
            nullmsg: "请选择请假几小时",
            sucmsg: " ",
            errmsg: "请如实请请选择请假几小时"
        },
        {
            ele: "#type",
            dataType: "*",
            nullmsg: "请选择请假类型",
            sucmsg: " ",
            errmsg: "请如实选择请假类型"
        }
    ]);
})
