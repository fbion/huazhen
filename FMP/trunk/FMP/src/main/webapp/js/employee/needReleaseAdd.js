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
        var url = $Url.BuildEmployeeUrl("/employee/needRelease/ajaxGetNeedRelease");
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
            	 EnumList.GetEnumListToSelect($("#positionNo"), "positionListBydeptType1", $Url.BuildProductUrl("/common/enumList.action"),data.info.deptNo);
            		
                if (data.errCode != "0000") {
                    $("#msg").text(data.errDesc);
                    return;
                }
                $Util.DataToVal(data.info, ElementVar);
				if (!$String.IsNullOrEmpty(data.info.workTime)) {
					var workTime = new Date(data.info.workTime);
					$("#workTime").val(workTime.format("yyyy-MM-dd"));
					}


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
    }
}
$(function () {
	   
	$.fn.linkage({
        elements: [$("#companyNo"), $("#deptNo"), $("#positionNo")],
        dataTypes: ["empCompanylist", "deptListByCompany","positionListBydeptType1"],
        actionUrl: $Url.BuildEmployeeUrl("/common/enumList.action"),
        all: false
    });
    $("#back").click(function () {
//        window.location.href = $Url.BuildEmployeeUrl("/employee/needRelease/list");
        window.close();
    });
    $("#workTime").click(function () {
		WdatePicker({dateFmt: 'yyyy-MM-dd'});
		//WdatePicker({minDate:'%y-%M-#{%d+1}'});
	});
    
    if (Number(PageVar.ID) == 0) {
        ManagePage.EnableInput();
        ManagePage.HideEditButton();
    }
    else {
        ManagePage.GetInfo(PageVar.ID);
    }

	$("#companyNo").attr("disabled", "disabled");//temp
//    EmployeeTreeControl.startTree({
//        param: "on",  //on在职员工，out离职员工，test测试员工
//        treeInputId: "employeeSel",//员工控件框ID
//        valInputId: "deptNo", //员工值框id
//        inputType: "employee",//employee员工，position职位
//        idType: "deptNo",        //员工empNo，userNo,职位positionNo,部门deptNo，公司companyNo
//        chkStyle: "radio",//选框类型checkbox,radio
//        nochecks:[true,false],      //逐级不显示单或复选框,true不显示，false显示
//        chkboxType:{Y:"ps", N:"ps"},  //Y被勾选时关联父类子类ps，N取消被勾选时关联父类子类ps
//        showPreBut: true,   //显示全部员工，在职员工按钮,离职员工，test测试员工
//        //showSearch: true,   //显示搜索框
//        showLevel:2,         //显示层级
//        sizeAuto:true,		//自动调节大小
//        width:200,			//宽，单位px
//        height:300			//高，单位px
//    });
    var needReleaseAdd = $("#needReleaseAdd").Validform({
        tiptype: function (msg, o, cssctl) {
            var objtip = o.obj.siblings(".Validform_checktip");
            cssctl(objtip, o.type);
            objtip.text(msg);
            
        },
        datatype:{
            "verifyDate": function (gets, obj, curform, datatype) {
            	var evalue = $("#workTime").val();
                var dB = new Date(evalue.replace(/-/g, "/"));
                if (new Date() > Date.parse(dB))
                	return false;
                else
            		return true; 
            }
        },

        callback: function (form) {
            if (!($("#submit").attr("process") === undefined)) {
                return false;
            }
            var url = $Url.BuildEmployeeUrl("/employee/needRelease/ajaxEditNeedRelease");
            var oper = "add";
            if (Number(PageVar.ID) != 0)
                oper = "edit";

            var info = {
                id: PageVar.ID,
				companyNo: $("#companyNo").val(),
				deptNo: $("#deptNo").val(),
				positionNo: $("#positionNo").val(),
				addEmp: $("#addEmp").val(),
				workProperty: $("#workProperty").val(),
				empRequire: $("#empRequire").val(),
				workTime: $("#workTime").val().toTimetamp(),
				mark: $("#mark").val(),
				editComment: $("#editComment").val()
            }
            $.ajax({
                type: "post",
                url: url,
                dataType: "json",
                timeout: 30000,
                data: {
                    oper: oper,
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
                        window.location.href = $Url.BuildEmployeeUrl("/employee/needRelease/edit?id=" + data.errDesc);
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
    needReleaseAdd.addRule([
                            {
		                           ele:"#addEmp",
		                           datatype:"n",
		                           //ignore:"ignore",
		                           errormsg:"请填数字",
		                           sucmsg:" "
		                       },
                            {
		                           ele:"#workTime",
		                           datatype:"verifyDate",
		                           //ignore:"ignore",
		                           errormsg:"日期不对",
		                           sucmsg:" "
		                       }
    ]);
})
