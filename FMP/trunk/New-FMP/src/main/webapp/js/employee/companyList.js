/**
 * Created by 磊 on 2015/11/11.
 */
var CompanyList = {
    InitGrid: function () {
        //默认是通过id倒排序，默认可不写，支持传递多个排序条件
        //var sortList = [{sort:"in_user_no",order:"desc"},{sort:"id",order:"desc"}];
        //var sortList = [{sort:"edit_user_no",order:"desc"}];
        $("#gridTable").datagrid({
            url: $Url.BuildEmployeeUrl('/employee/company/easyUICompanyList'),
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
                {field: 'id', title: 'id', align: 'center', halign: 'center', hidden: false, sortable: true,editor:'text'},
                {field: 'name', title: '名字', align: 'left', halign: 'center',editor:'text', hidden: false, sortable: true},
                {field: 'telephone',title: 'telephone',lign: 'left', halign: 'center',hidden: false,sortable: true,editor:'text'},
                {field: 'fax', title: 'fax', align: 'left', halign: 'center', hidden: false,editor:'text'},
                {field: 'website', title: 'website', align: 'left', halign: 'center', hidden: true,editor:'text'},
                {field: 'address', title: 'address', align: 'left', halign: 'center', hidden: false,editor:'text'},
                {field: 'bankAddress', title: 'bankAddress', align: 'left', halign: 'center', hidden: false,editor:'text'},
                {field: 'bankName', title: 'bankName', align: 'left', halign: 'center', hidden: false,editor:'text'},
                {field: 'bankAccount', title: 'bankAccount', align: 'left', halign: 'center', hidden: false,editor:'text'},
                {field: 'comment', title: 'comment', align: 'left', halign: 'center', hidden: false,editor:'text'},
                {field: 'inUserNo', title: 'inUserNo', align: 'left', halign: 'center', hidden: false, sortable: true,editor:'text'},
                {field: 'editUserNo',title: 'editUserNo',align: 'left',halign: 'center', hidden: false,sortable: true,editor:'text'},
                {field: 'inTime', title: 'inTime', align: 'left', halign: 'center', hidden: false, sortable: true,formatter:function(value,row,index){
                    return value.toDate().format("yyyy-MM-dd HH:mm:ss");
                }},
                {field: 'editTime', title: 'editTime', align: 'left', halign: 'center', hidden: false,formatter:function(value,row,index){
                    return value.toDate().format("yyyy-MM-dd HH:mm:ss");
                }},
                {field: 'editComment', title: 'editComment', align: 'left', halign: 'center', hidden: false}
            ]],
            onBeforeLoad: function (param) {
                $.getJSON($Url.BuildEmployeeUrl("/getColumnCookie"), {key: "companyList"}, function (data) {
                    $.each(JSON.parse(data.value), function (i, item) {
                        for(var temp in item){
                            if(item[temp]){
                                $("#gridTable").datagrid("hideColumn", temp);
                            }
                            else {
                                $("#gridTable").datagrid("showColumn", temp);
                            }
                        }
                    });
                });
            },

            onHeaderContextMenu: function (e, field) {
                e.preventDefault();
                if (!$('#tmenu').length) {
                    CompanyList.CreateColumnMenu();
                }
                $('#tmenu').menu('show', {
                    left: e.pageX,
                    top: e.pageY
                });
            },
            onClickCell: CompanyList.onClickCell
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
                CompanyList.SetColumnCookie()
            }
        });
    },
    SetColumnCookie:function(){
        var columnArray = new Array();
        var fields = $("#gridTable").datagrid("getColumnFields");
        for (var i = 0; i < fields.length; i++) {
            var info = new Object();
            var property = $("#gridTable").datagrid("getColumnOption", fields[i]).hidden;
            info[fields[i].toString()] = property == undefined || property == false ? false : true;
            columnArray.push(info);
        }
        $.post($Url.BuildEmployeeUrl("/setColumnCookie"), {
            key: "companyList",
            value: JSON.stringify(columnArray)
        });
    },
    InitQuery: function () {
        var name = $("#name").val();

        $("#gridTable").datagrid("load", {
            name: name
        });
    },
    onClickCell:function(index, field) { 
        $('#gridTable').datagrid('beginEdit', index);          
        var ed =$('#gridTable').datagrid('getEditor', { index: index, field: field }); 
//        (ed.target).val("dddd");
//        $('#gridTable').datagrid('endEdit', index); 
    }
}
$(function () {
    CompanyList.InitGrid();
//    $('#gridTable').datagrid('acceptChanges');
    $("#btnSearch").click(function () {
        CompanyList.InitQuery();
    });
    $("#btnAdd").click(function () {
        $EasyUI.NewTab("New", $Url.BuildEmployeeUrl("/employee/company/edit"));
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
        $EasyUI.NewTab("Edit", $Url.BuildEmployeeUrl("/employee/company/edit?id=") + row.id);
    });
    $("#btnDetail").click(function () {
        var row = $("#gridTable").datagrid("getSelected");
        if (row == null) {
            $.messager.show({
                title: '提示',
                msg: '请选择数据！',
                showType: 'show'
            });
            return false;
        }
        $EasyUI.NewTab("Detail", $Url.BuildEmployeeUrl("/employee/company/detail?id=") + row.id);
    });

});