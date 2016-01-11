/**
 * Created by code generator on #time#.
 */
var ProductList = {
    InitGrid: function () {
        //默认是通过id倒排序，默认可不写，支持传递多个排序条件
        //var sortList = [{sort:"in_user_no",order:"desc"},{sort:"id",order:"desc"}];
        //var sortList = [{sort:"edit_user_no",order:"desc"}];
        $("#gridTable").datagrid({
            url: $Url.BuildProductUrl('/product/product/easyUIProductList'),
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
                { field: 'id', title: 'ID', align: 'left', halign: 'center',width:'5%', hidden: false, sortable: false },
                { field: 'code', title: '编号', align: 'left', halign: 'center',width:'5%', hidden: false, sortable: false },
                { field: 'type', title: '类型', align: 'left', halign: 'center',width:'5%', hidden: false, sortable: false,
                    formatter: function (value) {
                        return EnumListWithEasyUI.GetEnumListToGrid(value, "productType", $Url.BuildNewIndexUrl("/common/enumList.action"));
                    }
                },
                { field: 'name', title: '产品名称', align: 'left', halign: 'center',width:'15%', hidden: false, sortable: false ,
                    formatter: function (value, row) {
                        var url = $Url.BuildNewIndexUrl("/product/product/detail?id=") + row.id;
                        return "<a href=\"javascript:void(0)\" onclick=\"$EasyUI.AddTab('" + value + "','" + url + "')\">" + value + "</a>";
                    }
                },
                { field: 'baseLimit', title: '认购起点', align: 'left', halign: 'center',width:'5%', hidden: true, sortable: true },
                { field: 'deadLine', title: '存续期', align: 'left', halign: 'center',width:'4%', hidden: false, sortable: true },
                { field: 'expectProfit', title: '预期年化收益', align: 'left', halign: 'center',width:'7%', hidden: false, sortable: true },
                { field: 'payType', title: '付息方式', align: 'left', halign: 'center',width:'5%', hidden: false, sortable: false ,
                    formatter: function (value) {
                        return EnumListWithEasyUI.GetEnumListToGrid(value, "payType", $Url.BuildNewIndexUrl("/common/enumList.action"));
                    }
                },
                { field: 'sumMoney', title: '募集规模', align: 'left', halign: 'center',width:'8%', hidden: false, sortable: true },
                { field: 'remainAmount', title: '剩余额度', align: 'left', halign: 'center',width:'7%', hidden: false, sortable: true },
                { field: 'remainSmall', title: '剩余小额', align: 'left', halign: 'center',width:'5%', hidden: false, sortable: true },
                { field: 'onlineTime', title: '上线时间', align: 'left', halign: 'center',width:'5%', hidden: false, sortable: true,
                    formatter: function (value, row, index) {
                        if(!$String.IsNullOrEmpty(value)){
                            return value.toDate().format("yyyy-MM-dd");
                        }
                    }
                },
                { field: 'start', title: '成立日期', align: 'center', halign: 'center',width:'5%', hidden: false, sortable: true,
                    formatter: function (value, row, index) {
                        if(!$String.IsNullOrEmpty(value)){
                            return value.toDate().format("yyyy-MM-dd");
                        }
                    }
                },
                { field: 'end', title: '债权到期日', align: 'center', halign: 'center',width:'5%', hidden: false, sortable: true,
                    formatter: function (value, row, index) {
                        if(!$String.IsNullOrEmpty(value)){
                            return value.toDate().format("yyyy-MM-dd");
                        }
                    }
                },
                { field: 'status', title: '状态', align: 'left', halign: 'center',width:'5%', hidden: false, sortable: true ,
                    formatter: function (value) {
                        if (value == "30"){
                            var val =  EnumListWithEasyUI.GetEnumListToGrid(value, "productStatus", $Url.BuildNewIndexUrl("/common/enumList.action"));
                            return '<span style="color:#f14a51 !important; font-weight:bold;">'+val+'</span>';
                        } else {
                            return EnumListWithEasyUI.GetEnumListToGrid(value, "productStatus", $Url.BuildNewIndexUrl("/common/enumList.action"));
                        }
                    }
                },
                { field: 'empNo', title: '产品经理', align: 'left', halign: 'center',width:'5%', hidden: false, sortable: false,
                    formatter: function (value,row) {
                    var url = $Url.BuildNewIndexUrl("/baseInfo/mailList/list?id=") + row.empNo;
                    var value = EnumListWithEasyUI.GetEnumListToGrid(value, "empList", $Url.BuildNewIndexUrl("/common/enumList.action"))
                    return "<a href=\"javascript:void(0)\" onclick=\"$EasyUI.AddTab('" + value + "','" + url + "')\">" + value + "</a>";
                }
                },
                { field: 'isSaleAll', title: '是否包销', align: 'left', halign: 'center',width:'5%', hidden: true, sortable: false ,
                    formatter: function (value) {
                        return EnumListWithEasyUI.GetEnumListToGrid(value, "isYes", $Url.BuildNewIndexUrl("/common/enumList.action"));
                    }
                },
                { field: 'comment', title: '产品描述', align: 'left', halign: 'center',width:'5%', hidden: true, sortable: false },
                { field: 'issuerNo', title: '发行机构', align: 'left', halign: 'center',width:'5%', hidden: true, sortable: false ,
                    formatter: function (value,row) {
                        var url = $Url.BuildNewIndexUrl("/product/partnerIssuer/detail?id=") + row.issuerNo;
                        var value = EnumListWithEasyUI.GetEnumListToGrid(value, "issuerNo", $Url.BuildNewIndexUrl("/common/enumList.action"));
                        return "<a href=\"javascript:void(0)\" onclick=\"$EasyUI.AddTab('" + value + "','" + url + "')\">" + value + "</a>";
                    }
                },
                { field: 'tendType', title: '产品投向', align: 'left', halign: 'center',width:'5%', hidden: true, sortable: true,
                    formatter: function (value) {
                        return EnumListWithEasyUI.GetEnumListToGrid(value, "tendType", $Url.BuildNewIndexUrl("/common/enumList.action"));
                    }
                },
                { field: 'purpose', title: '资金用途', align: 'left', halign: 'center',width:'5%', hidden: true, sortable: false },
                { field: 'quota', title: '大小配额', align: 'left', halign: 'center',width:'5%', hidden: true, sortable: false,
                    formatter: function (value) {
                        return EnumListWithEasyUI.GetEnumListToGrid(value, "quotaType", $Url.BuildNewIndexUrl("/common/enumList.action"));
                    }
                },
                { field: 'bankAddress', title: '开户行地址', align: 'left', halign: 'center',width:'5%', hidden: true, sortable: false },
                { field: 'bankName', title: '开户名', align: 'left', halign: 'center',width:'5%', hidden: true, sortable: false },
                { field: 'accountNumber', title: '打款账号', align: 'left', halign: 'center',width:'5%', hidden: true, sortable: false },
                { field: 'dueDate', title: '打款截止日期', align: 'left', halign: 'center',width:'5%', hidden: true, sortable: false,
                    formatter: function (value, row, index) {
                        if(!$String.IsNullOrEmpty(value)){
                            return value.toDate().format("yyyy-MM-dd");
                        }
                    }
                },
                { field: 'agreementStatus', title: '协议签署状态', align: 'left', halign: 'center',width:'5%', hidden: true, sortable: false ,
                    formatter: function (value) {
                        return EnumListWithEasyUI.GetEnumListToGrid(value, "protocolStatus", $Url.BuildNewIndexUrl("/common/enumList.action"));
                    }
                },
                { field: 'settlementType', title: '结算方式', align: 'left', halign: 'center',width:'5%', hidden: true, sortable: false},

                { field: 'financierType', title: '融资方类型', align: 'left', halign: 'center',width:'5%', hidden: true, sortable: false,
                    formatter: function (value) {
                        return EnumListWithEasyUI.GetEnumListToGrid(value, "upStreamType", $Url.BuildNewIndexUrl("/common/enumList.action"));
                    }
                },
                { field: 'financierNo', title: '融资方', align: 'left', halign: 'center',width:'5%', hidden: true, sortable: false,
                    formatter: function (value,row) {
                        if(row.financierType==1){
                            return EnumListWithEasyUI.GetEnumListToGrid(value, "FinancierBusiness", $Url.BuildNewIndexUrl("/common/enumList.action"));
                        }
                        if(row.financierType==2){
                            return EnumListWithEasyUI.GetEnumListToGrid(value, "financierPersonal", $Url.BuildNewIndexUrl("/common/enumList.action"));
                        }
                    }
                }

           ]],
            onBeforeLoad: function (param) {
                $.getJSON($Url.BuildProductUrl("/getColumnCookie"), { key: "productList" }, function (data) {
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
                    ProductList.CreateColumnMenu();
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
                ProductList.SetColumnCookie()
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
            key: "productList",
            value: JSON.stringify(columnArray)
        });
    },
    InitQuery: function () {
        var name = $("#name").val();
        var status = $("#status").combobox("getValue");
        //var type = $("#type").val();
        $("#gridTable").datagrid("load", {
            name: name,
            status:status
            //type:type
        });
    }
}
$(function () {
    ProductList.InitGrid();
    $("#status").combobox({
        width:100,
        data: EnumListWithEasyUI.GetEnumListToCombo("productStatusAll", $Url.BuildProductUrl("/common/enumList.action")),
        valueField:'value',
        textField:'text'
    });
    $("#btnSearch").click(function () {
        ProductList.InitQuery();
    });
    $("#btnAdd").click(function () {
        $EasyUI.NewTab("New", $Url.BuildProductUrl("/product/product/edit"));
    });
    $("#btnEdit").click(function () {
        var row = $("#gridTable").datagrid("getSelected");
        if (row == null) {
            $.messager.alert({title: '提示',msg: '请选择数据！',showType: 'show'});
            return false;
        }
        $EasyUI.NewTab("Edit", $Url.BuildProductUrl("/product/product/edit?id="+row.id+"&empNo="+row.empNo+"&activitiNo="+row.activitiNo) );
    });
    $("#btnDetail").click(function () {
        var row = $("#gridTable").datagrid("getSelected");
        if (row == null) {
            $.messager.alert({title: '提示',msg: '请选择数据！',showType: 'show'});
            return false;
        }
        $EasyUI.NewTab("Detail", $Url.BuildProductUrl("/product/product/detail?id=" + row.id+"&empNo="+row.empNo+"&activitiNo="+row.activitiNo));
    });

});