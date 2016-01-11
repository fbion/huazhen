var EmployeeList = {
	    InitGrid: function () {
	        //默认是通过id倒排序，默认可不写，支持传递多个排序条件
	        //var sortList = [{sort:"in_user_no",order:"desc"},{sort:"id",order:"desc"}];
	        //var sortList = [{sort:"edit_user_no",order:"desc"}];
	        $("#gridTable").datagrid({
	            url: $Url.BuildEmployeeUrl('/employee/employee/easyUIEmployeeList'),
	            method: 'post',
	            resizable: true,
	            fit: true,
	            multiSort: true,
	            autoRowHeight: false,
	            singleSelect: true,
	            toolbar: "#toolbar",
	            loadMsg: "正在加载，请稍等...",
	            pagination: true,
	            pageSize: 15,
	            pageList: [15, 30, 50],
	            queryParams: {
	                //sortList:JSON.stringify(sortList)
	            	showAllList:ElementVar.showAllList
	            },
	            columns: [[
			{ field: 'id', title: 'id', align: 'center', halign: 'center',width:'5%', hidden: false, sortable: false },
			{ field: 'code', title: '编码', align: 'left', halign: 'center',width:'10%', hidden: true, sortable: false },
			{ field: 'portraitPath', title: '图片地址', align: 'center', halign: 'center',width:'10%', hidden: false, sortable: false,
				formatter:function(value){
					return '<img alt=\"员工头像\" id=\"emphead\" class=\"emphead\" src=\"' + $Url.BuildFileUrl(value) + '"\"style=\"width:100px;height=200px\">';
				}
			 },
			{ field: 'name', title: '员工姓名', align: 'left', halign: 'center',width:'10%', hidden: false, sortable: false },
			{ field: 'status', title: '在职状态', align: 'center', halign: 'center',width:'10%', hidden: false, sortable: false,
				formatter: function (value) {
                    return EnumListWithEasyUI.GetEnumListToGrid(value, "employeeStatusAll", $Url.BuildNewIndexUrl("/common/enumList.action"));
                }
			},
			{ field: 'sex', title: '性别', align: 'center', halign: 'center',width:'10%', hidden: true, sortable: false,
				formatter: function (value) {
                    return EnumListWithEasyUI.GetEnumListToGrid(value, "dicDicDataForEmployeeSex", $Url.BuildNewIndexUrl("/common/enumList.action"));
                }
			},
			{ field: 'email', title: '公司邮箱', align: 'left', halign: 'center',width:'10%', hidden: true, sortable: false },
			{ field: 'weixin', title: '微信', align: 'left', halign: 'center',width:'10%', hidden: true, sortable: false },
			{ field: 'qq', title: 'QQ', align: 'left', halign: 'center',width:'10%', hidden: true, sortable: false },
			{ field: 'telephone', title: '电话', align: 'left', halign: 'center',width:'10%', hidden: true, sortable: false },
			{ field: 'cellphone1', title: '手机1', align: 'center', halign: 'center',width:'10%', hidden: false, sortable: false },
			{ field: 'userNo', title: '用户', align: 'left', halign: 'center',width:'10%', hidden: false, sortable: false,
				formatter: function (value) {
                    return EnumListWithEasyUI.GetEnumListToGrid(value, "user", $Url.BuildNewIndexUrl("/common/enumList.action"));
                }
			},
			{ field: 'cellphone2', title: '手机2', align: 'left', halign: 'center',width:'10%', hidden: true, sortable: false },
			{ field: 'address', title: '住址', align: 'left', halign: 'center',width:'10%', hidden: true, sortable: false },
			{ field: 'marry', title: '婚姻', align: 'center', halign: 'center',width:'10%', hidden: true, sortable: false,
				formatter: function (value) {
                    return EnumListWithEasyUI.GetEnumListToGrid(value, "dicDicDataForEmployeeMarry", $Url.BuildNewIndexUrl("/common/enumList.action"));
                }
			},
			{ field: 'deptNo', title: '部门', align: 'left', halign: 'center',width:'21.5%', hidden: false, sortable: false,
				formatter: function (value) {
                    return EnumListWithEasyUI.GetEnumListToGrid(value, "dept", $Url.BuildNewIndexUrl("/common/enumList.action"));
                }
			},
			{ field: 'companyNo', title: '公司', align: 'left', halign: 'center',width:'10%', hidden: false, sortable: false,
				formatter: function (value) {
                    return EnumListWithEasyUI.GetEnumListToGrid(value, "empCompanylist", $Url.BuildNewIndexUrl("/common/enumList.action"));
                }
			},
			{ field: 'parentNo', title: '员工上级', align: 'left', halign: 'center',width:'10%', hidden: false, sortable: false,
				formatter: function (value) {
                    return EnumListWithEasyUI.GetEnumListToGrid(value, "empListById", $Url.BuildNewIndexUrl("/common/enumList.action"));
                }
			}
	            ]],
	            onBeforeLoad: function (param) {
	                $.getJSON($Url.BuildEmployeeUrl("/getColumnCookie"), { key: "employeeList" }, function (data) {
	                    if(!$String.IsNullOrEmpty(data.value)){
	                        $.each(JSON.parse(data.value), function (i, item) {
	                            for (var temp in item) {
	                                if (item[temp]) {
	                                    $("#gridTable").datagrid("hideColumn", temp);
	                                }
	                                else {
	                                    $("#gridTable").datagrid("showColumn", temp);
	                                }
	                            }
	                        });
	                    }
	                });
	            },

	            onHeaderContextMenu: function (e, field) {
	                e.preventDefault();
	                if (!$('#tmenu').length) {
	                    EmployeeList.CreateColumnMenu();
	                }
	                $('#tmenu').menu('show', {
	                    left: e.pageX,
	                    top: e.pageY
	                });
	            }
	        }).datagrid("columnMoving");
	        var page = $("#gridTable").datagrid("getPager");
	        if (page) {
	            page.pagination({
	                beforePageText: "第",
	                afterPageText: "页    共 {pages} 页",
	                displayMsg: "当前显示 {from} - {to} 条记录   共 {total} 条记录"
	            });
	        }
	    },
	    CreateColumnMenu: function () {
	        var fields = $("#gridTable").datagrid("getColumnFields");
	        var tmenu = $('<div id="tmenu" style="width:100px;"></div>').appendTo('body');
	        for (var i = 0; i < fields.length; i++) {
	            var title = $("#gridTable").datagrid("getColumnOption",fields[i]).title
	            if ($("#gridTable").datagrid("getColumnOption", fields[i]).hidden) {
	                $('<div></fields>').html(title).attr("id",fields[i]).appendTo(tmenu);
	            }
	            else {
	                $('<div iconCls="icon-ok"></fields>').html(title).attr("id",fields[i]).appendTo(tmenu);
	            }
	        }
	        tmenu.menu({
	            onClick: function (item) {
	                if (item.iconCls == "icon-ok") {
	                    $("#gridTable").datagrid("hideColumn", item.id);
	                    tmenu.menu("setIcon", {
	                        target: item.target,
	                        iconCls: "icon-empty"
	                    });
	                } else {
	                    $("#gridTable").datagrid("showColumn", item.id);
	                    tmenu.menu("setIcon", {
	                        target: item.target,
	                        iconCls: "icon-ok"
	                    });
	                }
	                EmployeeList.SetColumnCookie()
	            }
	        });
	    },
	    SetColumnCookie: function () {
	        var columnArray = new Array();
	        var fields = $("#gridTable").datagrid("getColumnFields");
	        for (var i = 0; i < fields.length; i++) {
	            var info = new Object();
	            var property = $("#gridTable").datagrid("getColumnOption", fields[i]).hidden;
	            info[fields[i].toString()] = property == undefined || property == false ? false : true;
	            columnArray.push(info);
	        }
	        $.post($Url.BuildEmployeeUrl("/setColumnCookie"), {
	            key: "employeeList",
	            value: JSON.stringify(columnArray)
	        });
	    },
	    InitQuery: function () {
	    	var byName = $("#txtName").val();
            var bySex = $("#selectDicData").combobox("getValue");
            var byCompany = $("#selectCompany").val();
            var byDept = $("#selectDept").val();
            var byVerify = $("#selectVerify").combobox("getValue");
            var byStatus = $("#byStatus").combobox("getValue");

	        $("#gridTable").datagrid("load", {
	        	"byName": byName,
                "bySex": bySex,
                "byCompany": byCompany,
                "byDept": byDept,
                "byVerify": byVerify,
                "status": byStatus,
	            showAllList:ElementVar.showAllList
	        });
	    },
	    ChangeManagerOpen: function () {    //批量修改负责人
	        $('#w').window('open');
	    },
	    ChangeManagerClose: function () {   //批量修改负责人
	        $('#w').window('close');
	    },

	    EmployeeExcel: function () {
	        year = $("#year").val();
	        month = parseInt($("#month").val());
	        if (year == 0 || month == 0) {
	            var d = new Date();
	            var year = d.getFullYear();
	            var month = d.getMonth();
	        }
	        location.href = "http://172.16.28.4/upload/files/"
	            + year + "/" + month + "/人事报表.xls"
	    },
	    GetDate: function (strat, end, obj) {
	        var op = $("<option></option>").text("全部").val(0);
	        obj.append(op);
	        for (var i = strat; i <= end; i++) {
	            var op = $("<option></option>").text(i).val(i);
	            obj.append(op);
	        }
	    },
	    GetPositive: function (id, isPositive, userNo) {
	        var content = ""
	        if (isPositive == "positive") {
	            content = "确认通知该员工转正？"
	        }
	        if (isPositive == "delay") {
	            content = "确认通知该员工延迟转正"
	        }
	        if (confirm(content)) {
	            if (isPositive == "delay") {
//	                $.post($Url.BuildEmployeeUrl("/employee/probationWorkSummary/ajaxGetWorkSummaryByEmpNo"),{empNo:id},function(data){
	                    var url = $Url.BuildWorkFlowUrl('/workFlow/processing/ajaxStartExtendProbationApplicationProcesss');
	                    EmployeeList.StartAudit($("#txtName"), url, "", userNo);
//	                });
	            }
	            if (isPositive == "positive") {
	                $.post($Url.BuildEmployeeUrl("/employee/probationWorkSummary/ajaxGetWorkSummaryByEmpNo"),{empNo:id},function(data){
	                    var infoId = 0;
	                    if(JSON.stringify(data.info) != "null"){
	                        infoId = data.info.id;
	                    }
	                    var url = $Url.BuildWorkFlowUrl('/workFlow/processing/ajaxStartProbationEvaluationProcess');
	                    EmployeeList.StartAuditNow($("#txtName"), url, "", userNo, infoId);
	                });
	            }
	            alert("发送成功");
	        }
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
	                //alert(request);
	            },
	            success: function (data) {
	                if (empName != null && empName != "" && data.indexOf(empName) > -1) {
	                    //$("#examine").hide();
	                }
	                $("#aduitComment").append(data);
	                $("#check1").hide();
	                EmployeeList.Resize();
	            }
	        })
	    },
	    StartAudit: function (obj, url, activitiNo, id) {
	        var uri = $Url.BuildEmployeeUrl("/employee/extendProbationApplication/edit?activitiNo=");
	        var sendData = {
	            per: "通过",
	            id: id,
	            activitiNo: activitiNo,
	            comment: "",
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
	            },
	            success: function (data, textStatus) {
	                if ($String.IsNullOrEmpty(activitiNo)) {
	                	$EasyUI.NewTab("延长试用期", $Url.BuildEmployeeUrl("/employee/extendProbationApplication/edit?id=" + PageVar.ID + "&activitiNo=" + data.activitiNo));
//	                    window.location.href = $Url.BuildEmployeeUrl("/employee/extendProbationApplication/edit?id=" + PageVar.ID + "&activitiNo=" + data.activitiNo);
	                } else {
	                	$EasyUI.NewTab("延长试用期", $Url.BuildEmployeeUrl("/employee/extendProbationApplication/edit?id=" + PageVar.ID + "&activitiNo=" + activitiNo));
//	                    window.location.href = $Url.BuildEmployeeUrl("/employee/extendProbationApplication/edit?id=" + PageVar.ID + "&activitiNo=" + activitiNo);
	                }
	            },
	            complete: function (XMLHttpRequest, textStatus) {
	            }
	        });
	    },
	    StartAuditNow: function (obj, url, activitiNo, id,infoId) {
	        var uri = $Url.BuildEmployeeUrl("/employee/probationWorkSummary/edit?id=" + infoId + "&activitiNo=");
	        var sendData = {
	            per: "通过",
	            id: id,
	            activitiNo: activitiNo,
	            comment: "",
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
	            },
	            success: function (data, textStatus) {
	                if ($String.IsNullOrEmpty(activitiNo)) {
	                	$EasyUI.NewTab("转正", $Url.BuildEmployeeUrl("/employee/probationWorkSummary/edit?id=" + PageVar.ID + "&activitiNo=" + data.activitiNo));
//	                    window.location.href = $Url.BuildEmployeeUrl("/employee/probationWorkSummary/edit?id=" + PageVar.ID + "&activitiNo=" + data.activitiNo);
	                } else {
	                	$EasyUI.NewTab("转正", $Url.BuildEmployeeUrl("/employee/probationWorkSummary/edit?id=" + PageVar.ID + "&activitiNo=" + activitiNo));
//	                    window.location.href = $Url.BuildEmployeeUrl("/employee/probationWorkSummary/edit?id=" + PageVar.ID + "&activitiNo=" + activitiNo);
	                }
	            },
	            complete: function (XMLHttpRequest, textStatus) {
	            }
	        });
	    },
	    GetWindow: function (activitiNo) {
	        if ($String.IsNullOrEmpty(activitiNo)) {
	            $("#submitExamine").click(function () {
	                var url = $Url.BuildWorkFlowUrl('/workFlow/processing/ajaxStartExtendProbationApplicationProcesss');
	                EmployeeList.StartAudit($("#submit1"), url, activitiNo);
	            });
	        } else {
	            $("#examine").click(function () {
	                $('#w1').window('open');
	            });
	            $(".examine").click(function () {
	                var url = $Url.BuildWorkFlowUrl("/workFlow/auditTask/ajaxAddExamine.action");
	                EmployeeList.StartAudit($(this), url, activitiNo);
	            });
	        }
	    },
	    GetUrlActivitNo: function () {
	        var urlTemp = location.search;
	        var theRequest = new Object();
	        var strs = "";
	        if (urlTemp.indexOf("?") != -1) {
	            var str = urlTemp.substr(1);
	            if (str.indexOf("activitiNo=") != -1) {
	                strs = str.split("activitiNo=")[1];
	            }
	        }
	        return strs;
	    },
	    Resize: function () {
	        $("#content_center").css({"min-height": "803px", "height": 1800});
	    }
}

$(function () {
	EmployeeList.Resize();
	EmployeeList.InitGrid();
	EmployeeList.GetDate(2014, 2020, $("#year"));
	EmployeeList.GetDate(1, 12, $("#month"));
	$("#selectDicData").combobox({
        width:100,
        data: EnumListWithEasyUI.GetEnumListToCombo("dicDicDataForEmployeeSexAll", $Url.BuildEmployeeUrl("/common/enumList.action")),
        valueField:'value',
        textField:'text'
    });
	$("#byStatus").combobox({
        width:100,
        data: EnumListWithEasyUI.GetEnumListToCombo("employeeStatus", $Url.BuildEmployeeUrl("/common/enumList.action")),
        valueField:'value',
        textField:'text'
    });
	$("#selectVerify").combobox({
        width:100,
        data: EnumListWithEasyUI.GetEnumListToCombo("employeeVerifyAll", $Url.BuildEmployeeUrl("/common/enumList.action")),
        valueField:'value',
        textField:'text'
    });
	EmployeeTreeControl.startTree({
        param: "on",  //on在职员工，out离职员工，test测试员工
        treeInputId: "departmentSel",//员工控件框ID
        valInputId: "selectDept", //员工值框id
        inputType: "employee",//employee员工，position职位
        idType: "deptNo",        //员工empNo，userNo,职位positionNo,部门deptNo，公司companyNo
        chkStyle: "radio",//选框类型checkbox,radio
        nochecks: [true, false],      //逐级不显示单或复选框,true不显示，false显示
        chkboxType: {Y: "ps", N: "ps"},  //Y被勾选时关联父类子类ps，N取消被勾选时关联父类子类ps
        showPreBut: true,   //显示全部员工，在职员工按钮,离职员工，test测试员工
        //showSearch: true,   //显示搜索框
        showLevel: 2,         //显示层级
        sizeAuto: true,		//自动调节大小
        width: 200,			//宽，单位px
        height: 300			//高，单位px
    });
	$("#btnExcel").click(function () {
        var url = $Url.BuildEmployeeUrl("/employee/employeeInformation/ajaxExportExcel");
        location.href = url + "?" +
            "sord=desc" + "&" +
            "sidx=id";
    });
    $("#btnExcelEmployee").click(function () {
    	EmployeeList.ChangeManagerOpen();
        $("#ok").click(function () {
        	EmployeeList.EmployeeExcel();
        	EmployeeList.ChangeManagerClose();
        });

    });
    $("#btnExcelWxEmployee").click(function () {
        var url = $Url.BuildEmployeeUrl("/employee/employeeInformation/ajaxWxExportExcel");
        location.href = url + "?" +
            "sord=desc" + "&" +
            "sidx=id";
    });
    
    $("#btnSearch").click(function () {
        EmployeeList.InitQuery();
    });
    $("#btnAdd").click(function () {
        $EasyUI.NewTab("New", $Url.BuildEmployeeUrl("/employee/employee/edit"));
    });
    $("#btnEdit").click(function () {
        var row = $("#gridTable").datagrid("getSelected");
        if (row == null) {
            $.messager.alert({
                title: '提示',
                msg: '请选择数据！',
                showType: 'show'
            });
            return false;
        }
        $EasyUI.NewTab("Edit", $Url.BuildEmployeeUrl("/employee/employee/edit?id=") + row.id);
    });
    $("#btnPositive").click(function () {
        var row = $("#gridTable").datagrid("getSelected");
        if (row == null) {
            $.messager.alert({
                title: '提示',
                msg: '请选择数据！',
                showType: 'show'
            });
            return false;
        }
        if (row.status != 5) {
            $.messager.alert({
                title: '提示',
                msg: '请选择试用期员工！',
                showType: 'show'
            });
            return false;
        }
        EmployeeList.GetPositive(row.id,"positive",row.userNo);
    });
    $("#btnDelay").click(function () {
        var row = $("#gridTable").datagrid("getSelected");
        if (row == null) {
            $.messager.alert({
                title: '提示',
                msg: '请选择数据！',
                showType: 'show'
            });
            return false;
        }
        if (row.status != 5) {
            $.messager.alert({
                title: '提示',
                msg: '请选择试用期员工！',
                showType: 'show'
            });
            return false;
        }
        EmployeeList.GetPositive(row.id,"delay",row.userNo);
    });
});