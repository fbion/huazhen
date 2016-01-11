/**
 * Created by code generator on #time#.
 */
var DepartmentList = {
    InitGrid: function () {
        //默认是通过id倒排序，默认可不写，支持传递多个排序条件
        //var sortList = [{sort:"in_user_no",order:"desc"},{sort:"id",order:"desc"}];
        //var sortList = [{sort:"edit_user_no",order:"desc"}];
        $("#gridTable").datagrid({
            url: $Url.BuildEmployeeUrl('/employee/department/easyUIDepartmentList'),
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
            },
            columns: [[
		{ field: 'id', title: '编号', align: 'center', halign: 'center',width:'10%', hidden: false, sortable: true },
		{ field: 'code', title: '编码', align: 'center', halign: 'center',width:'10%', hidden: true },
		{ field: 'name', title: '部门名称', align: 'left', halign: 'center',width:'15%', hidden: false },
		{ field: 'telephone', title: '联系电话', align: 'center', halign: 'center',width:'10%', hidden: true },
		{ field: 'empNo', title: '部门负责人', align: 'left', halign: 'center',width:'10%', hidden: false,
			formatter: function (value) {
                return EnumListWithEasyUI.GetEnumListToGrid(value, "empListForEmp", $Url.BuildNewIndexUrl("/common/enumList.action"));
            }
		},
		{ field: 'fax', title: '传真', align: 'center', halign: 'center',width:'10%', hidden: true },
		{ field: 'comment', title: '备注', align: 'left', halign: 'center',width:'10%', hidden: true },
		{ field: 'deptType', title: '部门类型', align: 'center', halign: 'center',width:'10%', hidden: false ,
			formatter: function (value) {
                return EnumListWithEasyUI.GetEnumListToGrid(value, "deptType", $Url.BuildNewIndexUrl("/common/enumList.action"));
            }
		},
		{ field: 'duty', title: '部门职能', align: 'left', halign: 'center',width:'10%', hidden: false },
		{ field: 'parentNo', title: '上级部门', align: 'left', halign: 'center',width:'20%', hidden: false,
			formatter: function (value) {
                return EnumListWithEasyUI.GetEnumListToGrid(value, "dept", $Url.BuildNewIndexUrl("/common/enumList.action"));
            }
		},
		{ field: 'companyNo', title: '所属公司', align: 'center', halign: 'center',width:'20%', hidden: false,
			formatter: function (value) {
                return EnumListWithEasyUI.GetEnumListToGrid(value, "empCompanylist", $Url.BuildNewIndexUrl("/common/enumList.action"));
            }
		},
		{ field: 'provinceNo', title: '省', align: 'center', halign: 'center',width:'10%', hidden: true,
			formatter: function (value) {
                return EnumListWithEasyUI.GetEnumListToGrid(value, "province", $Url.BuildNewIndexUrl("/common/enumList.action"));
            }
		},
		{ field: 'cityNo', title: '市', align: 'center', halign: 'center',width:'10%', hidden: true ,
			formatter: function (value) {
                return EnumListWithEasyUI.GetEnumListToGrid(value, "city", $Url.BuildNewIndexUrl("/common/enumList.action"));
            }
		},
		{ field: 'districtNo', title: '区', align: 'center', halign: 'center',width:'10%', hidden: true ,
			formatter: function (value) {
                return EnumListWithEasyUI.GetEnumListToGrid(value, "district", $Url.BuildNewIndexUrl("/common/enumList.action"));
            }
		},
		/*{ field: 'directStatus', title: 'directStatus', align: 'center', halign: 'center',width:'10%', hidden: false },
		{ field: 'isTest', title: 'isTest', align: 'center', halign: 'center',width:'10%', hidden: false },*/
		{ field: 'departmentImagePath', title: '部门图片路径', align: 'center', halign: 'center',width:'10%', hidden: true },
		{ field: 'address', title: '部门地址', align: 'center', halign: 'center',width:'10%', hidden: true },
		{ field: 'locationImagePath', title: '地理位置图片路径', align: 'center', halign: 'center',width:'10%', hidden: true },
		{ field: 'longitude', title: '精度', align: 'center', halign: 'center',width:'10%', hidden: true },
		{ field: 'latitude', title: '纬度', align: 'center', halign: 'center',width:'10%', hidden: true }
		]],
        onBeforeLoad: function (param) {
            $.getJSON($Url.BuildEmployeeUrl("/getColumnCookie"), { key: "departmentList" }, function (data) {
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
            	DepartmentList.CreateColumnMenu();
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
            DepartmentList.SetColumnCookie()
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
    	var name = $("#txtName").val();
        var companyNo = $("#selectCompany").combobox("getValue");

        $("#gridTable").datagrid("load", {
            name: name,
            companyNo : companyNo
        });
    },
}
$(function () {
    DepartmentList.InitGrid();
    $("#selectCompany").combobox({
        width:100,
        data: EnumListWithEasyUI.GetEnumListToCombo("empCompanylistAll", $Url.BuildEmployeeUrl("/common/enumList.action")),
        valueField:'value',
        textField:'text'
    });
    $("#btnSearch").click(function () {
        DepartmentList.InitQuery();
    });
    $("#btnAdd").click(function () {
        $EasyUI.NewTab("New", $Url.BuildEmployeeUrl("/employee/department/edit"));
    });
    $("#btnEdit").click(function () {
        var row = $("#gridTable").datagrid("getSelected");
        if (row == null) {
            $.messager.show({
                title: '提示',
                msg: '请选择数据！',
                showType: 'show'
            });
            return false;
        }
        $EasyUI.NewTab("Edit", $Url.BuildEmployeeUrl("/employee/department/edit?id=") + row.id);
    });
});