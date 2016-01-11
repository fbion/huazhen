var AttendanceApplicationList = {
	    InitGrid: function () {
	        //默认是通过id倒排序，默认可不写，支持传递多个排序条件
	        //var sortList = [{sort:"in_user_no",order:"desc"},{sort:"id",order:"desc"}];
	        //var sortList = [{sort:"edit_user_no",order:"desc"}];
	        $("#gridTable").datagrid({
	            url: $Url.BuildEmployeeUrl('/employee/attendanceApplication/easyUIAttendanceApplicationList'),
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
			{ field: 'id', title: 'id', align: 'center', halign: 'center', hidden: false, sortable: false },
			{ field: 'empNo', title: '员工姓名', align: 'center', halign: 'center', hidden: false, sortable: false ,
				formatter: function (value) {
                    return EnumListWithEasyUI.GetEnumListToGrid(value, "empListById", $Url.BuildNewIndexUrl("/common/enumList.action"));
                }
			},
			/*{ field: 'companyNo', title: '公司', align: 'center', halign: 'center', hidden: true, sortable: false ,
				formatter: function (value) {
                    return EnumListWithEasyUI.GetEnumListToGrid(value, "empCompanylist", $Url.BuildNewIndexUrl("/common/enumList.action"));
                }
			},*/
			{ field: 'deptNo', title: '部门', align: 'center', halign: 'center', hidden: false, sortable: false ,
				formatter: function (value) {
                    return EnumListWithEasyUI.GetEnumListToGrid(value, "dept", $Url.BuildNewIndexUrl("/common/enumList.action"));
                }
			},
			{ field: 'positionNo', title: '职位', align: 'center', halign: 'center', hidden: false, sortable: false ,
				formatter: function (value) {
                    return EnumListWithEasyUI.GetEnumListToGrid(value, "positionList", $Url.BuildNewIndexUrl("/common/enumList.action"));
                }
			},
			{ field: 'type', title: '类型', align: 'center', halign: 'center', hidden: false, sortable: false ,
				formatter: function (value) {
                    return EnumListWithEasyUI.GetEnumListToGrid(value, "dicDicDataAttendanceTypeAll", $Url.BuildNewIndexUrl("/common/enumList.action"));
                }
			},
			{ field: 'remark', title: '备注', align: 'center', halign: 'center', hidden: true, sortable: false },
			{ field: 'startTime', title: '请假开始时间', align: 'center', halign: 'center', hidden: false, sortable: false, formatter: function (value, row, index) {return value.toDate().format("yyyy-MM-dd HH:mm:ss");}},
			{ field: 'endTime', title: '请假结束时间', align: 'center', halign: 'center', hidden: false, sortable: false, formatter: function (value, row, index) {return value.toDate().format("yyyy-MM-dd HH:mm:ss");}},
			{ field: 'totalDay', title: '合计日', align: 'center', halign: 'center', hidden: false, sortable: false },
			{ field: 'totalHour', title: '合计时', align: 'center', halign: 'center', hidden: false, sortable: false },
			{ field: 'reason', title: '事由', align: 'center', halign: 'center', hidden: false, sortable: false },
			{ field: 'activitiNo', title: '审核', align: 'center', halign: 'center', hidden: true, sortable: false },
//			{ field: 'inUserNo', title: 'inUserNo', align: 'center', halign: 'center', hidden: false, sortable: false },
//			{ field: 'inTime', title: 'inTime', align: 'center', halign: 'center', hidden: false, sortable: false, formatter: function (value, row, index) {return value.toDate().format("yyyy-MM-dd HH:mm:ss");}},
//			{ field: 'editUserNo', title: 'editUserNo', align: 'center', halign: 'center', hidden: false, sortable: false },
//			{ field: 'editTime', title: 'editTime', align: 'center', halign: 'center', hidden: false, sortable: false, formatter: function (value, row, index) {return value.toDate().format("yyyy-MM-dd HH:mm:ss");}},
//			{ field: 'workFlowStatus', title: 'workFlowStatus', align: 'center', halign: 'center', hidden: false, sortable: false }
//			{ field: 'activitiStatus', title: 'activitiStatus', align: 'center', halign: 'center', hidden: false, sortable: false }
	            ]],
	            onBeforeLoad: function (param) {
	                $.getJSON($Url.BuildEmployeeUrl("/getColumnCookie"), { key: "attendanceApplicationList" }, function (data) {
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
	                    AttendanceApplicationList.CreateColumnMenu();
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
	                AttendanceApplicationList.SetColumnCookie()
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
	            key: "attendanceApplicationList",
	            value: JSON.stringify(columnArray)
	        });
	    },
	    InitQuery: function () {
	    	var byName = $("#byName").val();
	        var byDept = $("#byDept").val();
	        var byType = $("#byType").combobox("getValue");
	        var byStatus = $("#byStatus").combobox("getValue");
	        var byYear = $("#byYear").val();
	        var byMonth = $("#byMonth").val();

	        $("#gridTable").datagrid("load", {
	        	"byName": byName,
                "byType": byType,
                "byDept": byDept,
                "byYear": byYear,
                "byMonth": byMonth,
                "byStatus":byStatus,
	            showAllList:ElementVar.showAllList
	        });
	    },
	    GetDate:function(strat,end,obj){
	        var op = $("<option></option>").text("全部").val(0);
	        obj.append(op);
	        for (var i=strat;i<=end;i++){
	            var op = $("<option></option>").text(i).val(i);
	            obj.append(op);
	        }
	    }
}

$(function () {
    $("#btnExcel").click(function () {
        var byName = $("#byName").val();
        var byDept = $("#byDept").val();
        var byType = $("#byType").combobox("getValue");
        var byYear = $("#byYear").val();
        var byMonth = $("#byMonth").val();
        var byStatus = $("#byStatus").val();
        var url = $Url.BuildEmployeeUrl("/employee/attendanceApplication/ajaxExportExcel");
        location.href= url+"?"+
            "sord=desc"+"&"+
            "sidx=id"+"&"+
            "byName="+ byName+"&"+
            "byDept="+byDept+"&"+
            "byType="+ byType+"&"+
            "byYear="+byYear+"&"+
            "byStatus="+byStatus+"&"+
            "showAllList="+ElementVar.showAllList+"&"+
            "byMonth="+byMonth;
    });
	AttendanceApplicationList.InitGrid();
//	$("#byDept").combobox({
//        width:100,
//        data: EnumListWithEasyUI.GetEnumListToCombo("deptAll", $Url.BuildEmployeeUrl("/common/enumList.action")),
//        valueField:'value',
//        textField:'text'
//    });
	$.fn.linkage({
        elements: [$("#byDept"), $("#byName")],
        dataTypes: ["deptAll", "empNoAll"],
        actionUrl: $Url.BuildEmployeeUrl("/common/enumList.action"),
        all: false
    });
	$("#byType").combobox({
        width:100,
        data: EnumListWithEasyUI.GetEnumListToCombo("dicDicDataAttendanceTypeAll", $Url.BuildEmployeeUrl("/common/enumList.action")),
        valueField:'value',
        textField:'text',
        select: '0'
    });
	$("#byStatus").combobox({
        width:100,
        data: EnumListWithEasyUI.GetEnumListToCombo("dicDicDataAttendanceStatusAll", $Url.BuildEmployeeUrl("/common/enumList.action")),
        valueField:'value',
        textField:'text'
    });
	$("#byType").combobox('setValue',-1);
	$("#byStatus").combobox('setValue',-1);
    AttendanceApplicationList.GetDate(2014,2020,$("#byYear"));
    AttendanceApplicationList.GetDate(1,12,$("#byMonth"));
    
    $("#btnSearch").click(function () {
        AttendanceApplicationList.InitQuery();
    });
    $("#btnAdd").click(function () {
        $EasyUI.NewTab("New", $Url.BuildEmployeeUrl("/employee/attendanceApplication/edit"));
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
        $EasyUI.NewTab("Edit", $Url.BuildEmployeeUrl("/employee/attendanceApplication/edit?id=") + row.id);
    });
});