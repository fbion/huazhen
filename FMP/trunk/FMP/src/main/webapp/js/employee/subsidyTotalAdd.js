var isE;
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
        var url = $Url.BuildEmployeeUrl("/employee/subsidyTotal/ajaxGetSubsidyTotal");
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
                
                isE = $("#isExamine").val();
                $("#isExamine").val(ManagePage.FmatterIsExamine(data.info.isExamine));
				if (!$String.IsNullOrEmpty(data.info.achieveTime)) {
					var achieveTime = new Date(data.info.achieveTime);
					$("#achieveTime").val(achieveTime.format("yyyy-MM-dd"));
					}


                ManagePage.ShowEditButton();
                if ($("#edit").length > 0) {
                    $("#edit").click(function () {
                        ManagePage.EnableInput();
                        ManagePage.HideEditButton();

                    });
                }
                if(data.info.isExamine=="2"){
                	$("#edit").hide();
                	$("#submit").hide();
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
    GetDate:function(strat,end,obj){
    	for (var i=end;i>=strat;i--){
    		var op = $("<option></option>").text(i).val(i);
    		obj.append(op);
    	}
    },
    FmatterIsExamine:function(cellvalue){
    	if(cellvalue==1){
    		return "待审核";
    	}else if(cellvalue==2){
    		return "已审核";
    	}else{
    		return "审核通过，已分月";
    	}
    },
    ToDDMMMYYYY:function(date, options, rowObject) {  
        var d = new Date(date);  
        var dd = d.getDate() < 10 ? "0" + d.getDate() : d.getDate().toString(); 
        var mm = d.getMonth()+1< 10 ? "0" + (d.getMonth()+1):(d.getMonth()+1).toString();  
        var yyyy = d.getFullYear().toString();  
        return yyyy +"-"+ mm;  
    }
}
var BindEnumList={
	BindAll:function(){
		BindEnumList.BindDept();
		BindEnumList.BindPosition();
		BindEnumList.BindEmp();
	},
	BindDept:function(){
		EnumList.GetEnumListToSelect($("#deptNo"),"dept", $Url.BuildEmployeeUrl("/common/enumList.action"));
	},
	BindPosition:function(){
		EnumList.GetEnumListToSelect($("#positionNo"), "positionList", $Url.BuildEmployeeUrl("/common/enumList.action"),$("#deptNo").val());
	},
	BindEmp:function(){
		EnumList.GetEnumListToSelect($("#empNo"),"empListForEmp",$Url.BuildEmployeeUrl("/common/enumList.action"),$("#positionNo").val());
	}
}
$(function () {
	BindEnumList.BindAll();
	$("#deptNo").off().change(function(){
    	EnumList.GetEnumListToSelect($("#positionNo"), "positionListBydeptType1", $Url.BuildEmployeeUrl("/common/enumList.action"),$("#deptNo").val());
    	$("#empNo").empty();
    	EnumList.GetEnumListToSelect($("#empNo"), "empListByPositionNo", $Url.BuildEmployeeUrl("/common/enumList.action"),$("#positionNo").val());
    	$("#empNo1").val($("#empNo").val());
    });
	
	$("#positionNo").off().change(function(){
		EnumList.GetEnumListToSelect($("#empNo"), "empListByPositionNo", $Url.BuildEmployeeUrl("/common/enumList.action"),$("#positionNo").val());
		$("#empNo1").val($("#empNo").val());       
	});
	
	/*$("#empNo").off().change(function(){
		var url= $Url.BuildEmployeeUrl("/employee/employee/ajaxGetEmployeeById");
		$.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {
               id: $("#empNo").val()
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if (data.errCode == "0000") {
                	$("#deptNo").val(data.employee.deptNo);
                	$("#positionNo").val(data.employee.positionNo);
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
               
            }
        });
		////
		$("#empNo1").val($("#empNo").val());
	});*/
	if($("#empNo1").val()==0){
		$("#empNo1").val(1);
	}
	
    $("#back").click(function () {
        window.close();
    });

    if (Number(PageVar.ID) == 0) {
        ManagePage.EnableInput();
        ManagePage.HideEditButton();
    }
    else {
        ManagePage.GetInfo(PageVar.ID);
        var positionV = $("#positionNo").val();
        var empV = $("#empNo").val();
        EnumList.GetEnumListToSelect($("#positionNo"), "positionListBydeptType1", $Url.BuildEmployeeUrl("/common/enumList.action"),$("#deptNo").val());
        $("#positionNo").val(positionV);
        EnumList.GetEnumListToSelect($("#empNo"), "empListByPositionNo", $Url.BuildEmployeeUrl("/common/enumList.action"),$("#positionNo").val());
        $("#empNo").val(empV);
    }

    $("#achieveTime").click(function () {
		WdatePicker({dateFmt: 'yyyy-MM-dd'});
	});


    var subsidyTotalAdd = $("#subsidyTotalAdd").Validform({
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
            },
            "verifySubsidy": function(gets, obj, curform, datatype) {
            	var reg = /^\d+(\.{0,1}\d+){0,1}$/;
            	if (gets == "")
            		return false;
            	else if(!reg.test(gets))
            		return false;
            	else if(parseFloat(gets)<0)
            		return false;
            	else 
            		return true;
            }
        },
        callback: function (form) {
            if (!($("#submit").attr("process") === undefined)) {
                return false;
            }
            var url = $Url.BuildEmployeeUrl("/employee/subsidyTotal/ajaxEditSubsidyTotal");
            var oper = "add";
            if (Number(PageVar.ID) != 0)
                oper = "edit";

            var info = {
            		id: PageVar.ID,
            		empNo: $("#empNo").find("option:selected").val(),
    				empName: $("#empNo").find("option:selected").text(),
    				deptNo: $("#deptNo").val(),
    				positionNo: $("#positionNo").val(),
    				subsidyScale: $("#subsidyScale").val(),
    				salesMoney: $("#salesMoney").val(),
    				subsidy: $("#subsidy").val(),
    				isExamine: isE,
    				//empNo: $("#empNo1").val(),
				    achieveTime: $("#achieveTime").val()
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
                        window.location.href = $Url.BuildEmployeeUrl("/employee/subsidyTotal/edit?id=" + data.errDesc+"&&empNo="+data.empNo);
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
    subsidyTotalAdd.addRule([
		{
			ele:"#deptNo",
		    dataType:"verifySelect",
		    nullmsg:"请选择部门",
		    sucmsg:" ",
		    errmsg:"请选择正确的部门"
		},
		{
			ele:"#positionNo",
			dataType:"verifySelect",
			nullmsg:"请选择职位",
			sucmsg:" ",
			errmsg:"请选择正确的职位"
		},
		{				
		    ele:"#empNo",
		    datatype:"verifySelect",
		    //ignore:"ignore",
		    nullmsg:"请选择员工",
		    errormsg:"请选择正确的员工",
		    sucmsg:" "
		}/*,
		{				
		    ele:"#subsidyScale",
		    datatype:"s1-18",
		    //ignore:"ignore",
		    nullmsg:"请输入津贴比例",
		    errormsg:"请填写正确的津贴比例",
		    sucmsg:" "
		},
		{				
		    ele:"#salesMoney",
		    datatype:"s1-18",
		    //ignore:"ignore",
		    nullmsg:"请输入销售总额",
		    errormsg:"请填写正确的销售总额",
		    sucmsg:" "
		}*/,
		{				
		    ele:"#subsidy",
		    datatype:"verifySubsidy",
		    //ignore:"ignore",
		    nullmsg:"请输入津贴",
		    errormsg:"请填写正确的津贴",
		    sucmsg:" "
		},
		{				
		    ele:"#achieveTime",
		    datatype:"/^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))$/",
		    //datatype:"/^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))\\s+([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$/",
		    //ignore:"ignore",
		    nullmsg:"请选择获得时间",
		    errormsg:"请填写正确的获得时间",
		    sucmsg:" "
		}                  
    ]);
})
