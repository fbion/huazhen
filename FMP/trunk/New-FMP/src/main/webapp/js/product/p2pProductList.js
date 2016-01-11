/**
 * Created by code generator on #time#.
 */
var P2pProductList = {
    InitGrid: function () {
        //默认是通过id倒排序，默认可不写，支持传递多个排序条件
        //var sortList = [{sort:"in_user_no",order:"desc"},{sort:"id",order:"desc"}];
        //var sortList = [{sort:"edit_user_no",order:"desc"}];
        $("#gridTable").datagrid({
            url: $Url.BuildProductUrl('/product/p2pProduct/easyUIP2pProductList'),
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
                { field: 'id', title: '编号', align: 'center', halign: 'center',width:'5%', hidden: false, sortable: false },
                { field: 'productNo', title: '产品', align: 'left',width:'15%', halign: 'center', hidden: true, sortable: false,
                    formatter: function (value,row) {
                        var url = $Url.BuildNewIndexUrl("/product/product/detail?id=") + row.productNo;
                        var value = EnumListWithEasyUI.GetEnumListToGrid(value, "productList", $Url.BuildNewIndexUrl("/common/enumList.action"));
                        return "<a href=\"javascript:void(0)\" onclick=\"$EasyUI.AddTab('" + value + "','" + url + "')\">" + value + "</a>";
                    }
                },
                { field: 'name', title: '产品名称', align: 'left', width:'15%',halign: 'center', hidden: false, sortable: false,
                    formatter: function (value, row) {
                        var url = $Url.BuildNewIndexUrl("/product/p2pProduct/detail?id=") + row.id;
                        return "<a href=\"javascript:void(0)\" onclick=\"$EasyUI.AddTab('" + value + "','" + url + "')\">" + value + "</a>";
                    }
                },
                { field: 'minMoney', title: '起步价', align: 'center', width:'5%',halign: 'center', hidden: true, sortable: true },
                { field: 'repaymentIssue', title: '付息方式', align: 'center',width:'5%', halign: 'center', hidden: false, sortable: false ,
                    formatter: function (value) {
                        return EnumListWithEasyUI.GetEnumListToGrid(value, "p2pProductRepayIssue", $Url.BuildNewIndexUrl("/common/enumList.action"));
                    }
                },
                { field: 'type', title: '类型', align: 'center',width:'5%', halign: 'center', hidden: false, sortable: false,
                    formatter: function (value) {
                        return EnumListWithEasyUI.GetEnumListToGrid(value, "productType", $Url.BuildNewIndexUrl("/common/enumList.action"));
                    }
                },
                { field: 'income', title: '收益', align: 'center',width:'5%', halign: 'center', hidden: false, sortable: true },
                { field: 'floatingIncome', title: '浮动收益',width:'5%', align: 'center', halign: 'center', hidden: true, sortable: true },
                { field: 'duration', title: '项目期限', align: 'center',width:'5%', halign: 'center', hidden: false, sortable: true },
                { field: 'editComment', title: '剩余天数', align: 'center',width:'5%', halign: 'center', hidden: false, sortable: true },
                { field: 'totalAmout', title: '总额度', align: 'center',width:'5%', halign: 'center', hidden: false, sortable: true },
                { field: 'remainAmout', title: '剩余额度', align: 'center',width:'5%', halign: 'center', hidden: false, sortable: true },
                { field: 'progress', title: '打款进度', align: 'center',width:'5%', halign: 'center', hidden: false, sortable: true },
                { field: 'orderCount', title: '打款个数', align: 'center', width:'5%',halign: 'center', hidden: false, sortable: true },
                { field: 'status', title: '状态', align: 'center',width:'5%', halign: 'center', hidden: false, sortable: true,
                    formatter: function (value) {
                        if (value == "30"){
                            var val =  EnumListWithEasyUI.GetEnumListToGrid(value, "p2pProductPartStatus", $Url.BuildNewIndexUrl("/common/enumList.action"));
                            return '<span style="color:#f14a51 !important; font-weight:bold;">'+val+'</span>';
                        } else {
                            return EnumListWithEasyUI.GetEnumListToGrid(value, "p2pProductPartStatus", $Url.BuildNewIndexUrl("/common/enumList.action"));;
                        }
                    }
                },
                { field: 'start', title: '成立日期', align: 'center', width:'5%',halign: 'center', hidden: false, sortable: true,
                    formatter: function (value, row, index) {
                        if(!$String.IsNullOrEmpty(value)){
                            return value.toDate().format("yyyy-MM-dd");
                        }
                    }
                },
                { field: 'end', title: '债权到期日', align: 'center',width:'5%', halign: 'center', hidden: false, sortable: true,
                    formatter: function (value, row, index) {
                        if(!$String.IsNullOrEmpty(value)){
                            return value.toDate().format("yyyy-MM-dd");
                        }
                    }
                },
                { field: 'inUserNo', title: '录入人', align: 'center',width:'5%', halign: 'center', hidden: false, sortable: false ,
                    formatter: function (value,row) {
                        var url = $Url.BuildNewIndexUrl("/baseInfo/mailList/list?id=") + row.inUserNo;
                        var value = EnumListWithEasyUI.GetEnumListToGrid(value, "empList", $Url.BuildNewIndexUrl("/common/enumList.action"))
                        return "<a href=\"javascript:void(0)\" onclick=\"$EasyUI.AddTab('" + value + "','" + url + "')\">" + value + "</a>";
                    }
                },
                { field: 'inTime', title: '录入时间', align: 'center',width:'5%', halign: 'center', hidden: false, sortable: false,
                    formatter: function (value, row, index) {
                        if(!$String.IsNullOrEmpty(value)){
                            return value.toDate().format("yyyy-MM-dd");
                        }
                    }
                },
                { field: 'description', title: '描述', align: 'center', width:'5%',halign: 'center', hidden: true, sortable: false },
                { field: 'level', title: '优先级', align: 'center', width:'5%',halign: 'center', hidden: true, sortable: false }
            ]],
            onBeforeLoad: function (param) {
                $.getJSON($Url.BuildProductUrl("/getColumnCookie"), { key: "p2pProductList" }, function (data) {
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
                    P2pProductList.CreateColumnMenu();
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
                P2pProductList.SetColumnCookie()
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
        $.post($Url.BuildProductUrl("/setColumnCookie"), {
            key: "p2pProductList",
            value: JSON.stringify(columnArray)
        });
    },
    InitQuery: function () {
        var name = $("#name").val();
        var status =  $("#status").combobox("getValue");
        $("#gridTable").datagrid("load", {
            name: name,
            status:status
        });
    }
}
$(function () {
    $("#status").combobox({
        width:100,
        data: EnumListWithEasyUI.GetEnumListToCombo("p2pProductPartStatusAll", $Url.BuildProductUrl("/common/enumList.action")),
        valueField:'value',
        textField:'text'
    });
    P2pProductList.InitGrid();
    $("#btnSearch").click(function () {
        P2pProductList.InitQuery();
    });
    $("#btnAdd").click(function () {
        $EasyUI.NewTab("New", $Url.BuildProductUrl("/product/p2pProduct/edit"));
    });
    $("#btnEdit").click(function () {
        var row = $("#gridTable").datagrid("getSelected");
        if (row == null) {
            $.messager.alert({title: '提示',msg: '请选择数据！',showType: 'show'});
            return false;
        }
        $EasyUI.NewTab("Edit", $Url.BuildProductUrl("/product/p2pProduct/edit?id=") + row.id+"&productNo=" + row.productNo + "&activitiNo=" + row.activitiNo);
    });
    $("#btnDetail").click(function () {
        var row = $("#gridTable").datagrid("getSelected");
        if (row == null) {
            $.messager.alert({title: '提示',msg: '请选择数据！',showType: 'show'});
            return false;
        }
        $EasyUI.NewTab("Detail", $Url.BuildProductUrl("/product/p2pProduct/detail?id=") + row.id+"&productNo=" + row.productNo + "&activitiNo=" + row.activitiNo);
    });
});