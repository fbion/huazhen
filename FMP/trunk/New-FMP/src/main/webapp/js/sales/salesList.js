/**
 * Created by code generator on #time#.
 */
var SalesList = {
    InitGrid: function () {
        //默认是通过id倒排序，默认可不写，支持传递多个排序条件
        //var sortList = [{sort:"in_user_no",order:"desc"},{sort:"id",order:"desc"}];
        //var sortList = [{sort:"edit_user_no",order:"desc"}];
        $("#gridTable").datagrid({
            url: $Url.BuildSalesUrl('/sales/sales/easyUISalesList'),
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
                showAllList: ElementVar.showAllList,
                showDirectList: ElementVar.showDirectList,
                showChannelList: ElementVar.showChannelList,
                showShopList: ElementVar.showShopList,
                showSalesListForP2p: ElementVar.showSalesListForP2p,
                showSalesListForProduct: ElementVar.showSalesListForProduct,
                payType:0,
                isExpire:$('#isExpire').is(':checked')
            },
            columns: [[
                { field: 'id', title: 'id', align: 'center', halign: 'center', width:'5%',hidden: true, sortable: false },
                { field: 'code', title: '编号', align: 'center', halign: 'center',width:'8%', hidden: false, sortable: false },
                { field: 'contractCode', title: '合同编号', align: 'center', halign: 'center', width:'5%',hidden: false, sortable: false },
                { field: 'productType', title: '产品类型', align: 'center', halign: 'center', width:'5%',hidden: false, sortable: false ,
                    formatter: function (value) {
                        return EnumListWithEasyUI.GetEnumListToGrid(value, "productType", $Url.BuildNewIndexUrl("/common/enumList.action"));
                    }
                },
                { field: 'productNo', title: '产品', align: 'left', halign: 'center',width:'15%', hidden: false, sortable: false,
                    formatter: function (value,row) {
                        var url = $Url.BuildNewIndexUrl("/product/product/detail?id=") + row.productNo;
                        var value = EnumListWithEasyUI.GetEnumListToGrid(value, "productList", $Url.BuildNewIndexUrl("/common/enumList.action"))
                        return "<a href=\"javascript:void(0)\" onclick=\"$EasyUI.AddTab('" + value + "','" + url + "')\">" + value + "</a>";
                    }
                },
                { field: 'customerType', title: '客户类型', align: 'center', halign: 'center',width:'8%', hidden: false, sortable: false,
                    formatter: function (value) {
                        return EnumListWithEasyUI.GetEnumListToGrid(value, "customerType", $Url.BuildNewIndexUrl("/common/enumList.action"));
                    }
                },
                { field: 'customerName', title: '客户', align: 'center', halign: 'center', hidden: false,width:'8%', sortable: false,
                    formatter: function (value,row) {
                        var url = $Url.BuildNewIndexUrl("/customer/customerPersonal/detail?id=") + row.customerNo;
                        return "<a href=\"javascript:void(0)\" onclick=\"$EasyUI.AddTab('" + value + "','" + url + "')\">" + value + "</a>";
                    }
                },
                { field: 'status', title: '状态', align: 'left', halign: 'center', hidden: false, sortable: false,width:'6%',
                    formatter: function (value) {
                        return EnumListWithEasyUI.GetEnumListToGrid(value, "salesStatus", $Url.BuildNewIndexUrl("/common/enumList.action"));
                    }
                },
                { field: 'money', title: '打款金额', align: 'left', halign: 'center', hidden: false, sortable: false,width:'8%' },
                { field: 'income', title: '年化收益率', align: 'center', halign: 'center', hidden: false, sortable: false ,width:'5%',
                    formatter: function (value) {
                        if(value=="0"){
                            return "--"
                        }
                        return value;
                    }
                },
                { field: 'purchaseDate', title: '购买日期', align: 'center', halign: 'center', hidden: false, sortable: false,width:'8%',
                    formatter: function (value, row, index) {
                        if(!$String.IsNullOrEmpty(value)){
                            return value.toDate().format("yyyy-MM-dd");
                        }
                    }
                },
                { field: 'establishDate', title: '成立日期', align: 'center', halign: 'center', hidden: true, sortable: false,width:'8%',
                    formatter: function (value, row, index) {
                        if(!$String.IsNullOrEmpty(value)) {
                            return value.toDate().format("yyyy-MM-dd");
                        }
                    }
                },
                { field: 'repaymentDate', title: '到期日期', align: 'center', halign: 'center', hidden: false, sortable: false,width:'8%',
                    formatter: function (value, row, index) {
                        if(!$String.IsNullOrEmpty(value)) {
                            return value.toDate().format("yyyy-MM-dd");
                        }
                    }
                },
                { field: 'empName', title: '负责人', align: 'center', halign: 'center', hidden: false, sortable: false,width:'8%',
                    formatter: function (value,row) {
                        var url = $Url.BuildNewIndexUrl("/baseInfo/mailList/list?id=") + row.empNo;
                        return "<a href=\"javascript:void(0)\" onclick=\"$EasyUI.AddTab('" + value + "','" + url + "')\">" + value + "</a>";
                    }
                },

                { field: 'protocolStatus', title: '协议状态', align: 'center', halign: 'center', hidden: true, sortable: false ,width:'5%',
                    formatter: function (value) {
                        return EnumListWithEasyUI.GetEnumListToGrid(value, "protocolStatus", $Url.BuildNewIndexUrl("/common/enumList.action"));
                    }

                },
                { field: 'bankAddress', title: '开户行', align: 'center', halign: 'center', hidden: true, sortable: false ,width:'5%'},
                { field: 'bankName', title: '开户名', align: 'center', halign: 'center', hidden: true, sortable: false ,width:'5%'},
                { field: 'accountNumber', title: '银行账号', align: 'center', halign: 'center', hidden: true, sortable: false ,width:'5%'},
                { field: 'editComment', title: '备注', align: 'center', halign: 'center', hidden: true, sortable: false ,width:'5%'},
                { field: 'isTest', title: '是否测试', align: 'center', halign: 'center', hidden: true, sortable: false ,width:'5%'},
                { field: 'relationSalesNo', title: '原订单编号', align: 'center', halign: 'center', hidden: true, sortable: false ,width:'5%'},
                { field: 'type', title: '类型', align: 'center', halign: 'center', hidden: true, sortable: false,width:'5%' }
            ]],
            onBeforeLoad: function (param) {
                $.getJSON($Url.BuildSalesUrl("/getColumnCookie"), { key: "salesList" }, function (data) {
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
                    SalesList.CreateColumnMenu();
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
                SalesList.SetColumnCookie()
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
        $.post($Url.BuildSalesUrl("/setColumnCookie"), {
            key: "salesList",
            value: JSON.stringify(columnArray)
        });
    },
    InitQuery: function () {
        var status = $("#status").combobox("getValue");
        var productType =$("#productType").combobox("getValue");
        var productNo = $("#productNo").combobox("getValue");
        var peopleType = $("#peopleType").combobox("getValue");
        var peopleNo = $("#peopleNo").combobox("getValue");
        var deptNo = $("#deptNo").val();
        var empNo = $("#empNo").val();
        var customerName = $("#customerName").val();
        var isExpire = $('#isExpire').is(':checked');

        $("#gridTable").datagrid("load", {
            status:status,
            productType:productType,
            productNo:productNo,
            peopleType:peopleType,
            peopleNo:peopleNo,
            deptNo:deptNo,
            empNo:empNo,
            customerName:customerName,
            isExpire:isExpire,
            payType:0,
            showAllList: ElementVar.showAllList,
            showDirectList: ElementVar.showDirectList,
            showChannelList: ElementVar.showChannelList,
            showShopList: ElementVar.showShopList,
            showSalesListForP2p: ElementVar.showSalesListForP2p,
            showSalesListForProduct: ElementVar.showSalesListForProduct
        });
    }
}
$(function () {
    $("#status").combobox({
        width:100,
        data: EnumListWithEasyUI.GetEnumListToCombo("salesStatusAll", $Url.BuildProductUrl("/common/enumList.action")),
        valueField:'value',
        textField:'text'
    });
    EmployeeTreeControl.startTree({
        param: "on",  //on在职员工，out离职员工，test测试员工
        treeInputId: "employeeSel",//员工控件框ID
        valInputId: "empNo", //员工值框id
        inputType: "employee",//employee员工，position职位
        idType: "userNo",        //员工empNo，userNo,职位positionNo,部门deptNo，公司companyNo
        chkStyle: "radio",//选框类型checkbox,radio
        nochecks:[true,true,false],      //逐级不显示单或复选框,true不显示，false显示
        chkboxType:{Y:"ps", N:"ps"},  //Y被勾选时关联父类子类ps，N取消被勾选时关联父类子类ps
        showPreBut: true,   //显示全部员工，在职员工按钮,离职员工，test测试员工
        //showSearch: true,   //显示搜索框
        showLevel:3,         //显示层级
        sizeAuto:true,		//自动调节大小
        width:200,			//宽，单位px
        height:300			//高，单位px
    });
    EmployeeTreeControl.startTree({
        param: "on",  //on在职员工，out离职员工，test测试员工
        treeInputId: "departmentSel",//员工控件框ID
        valInputId: "deptNo", //员工值框id
        inputType: "employee",//employee员工，position职位
        idType: "deptNo",        //员工empNo，userNo,职位positionNo,部门deptNo，公司companyNo
        chkStyle: "radio",//选框类型checkbox,radio
        nochecks:[true,false],      //逐级不显示单或复选框,true不显示，false显示
        chkboxType:{Y:"ps", N:"ps"},  //Y被勾选时关联父类子类ps，N取消被勾选时关联父类子类ps
        showPreBut: true,   //显示全部员工，在职员工按钮,离职员工，test测试员工
        //showSearch: true,   //显示搜索框
        showLevel:2,         //显示层级
        sizeAuto:true,		//自动调节大小
        width:200,			//宽，单位px
        height:300			//高，单位px
    });
    SalesList.InitGrid();
    $("#btnSearch").click(function () {
        SalesList.InitQuery();
    });
    $("#btnAddSalesForProduct").click(function () {
        $EasyUI.NewTab("New", $Url.BuildSalesUrl("/sales/sales/editForProduct"));
    });
    $("#btnAddSalesForP2pProduct").click(function () {
        $EasyUI.NewTab("New", $Url.BuildSalesUrl("/sales/sales/editForP2pProduct"));
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
        if(row.productType == 5){
            $EasyUI.NewTab("Edit", $Url.BuildSalesUrl("/sales/sales/editForP2pProduct?id=" + row.id + "&empNo=" + row.empNo +"&activitiNo="+row.activitiNo));
        }else{
            $EasyUI.NewTab("Edit", $Url.BuildSalesUrl("/sales/sales/editForProduct?id=" + row.id + "&empNo=" + row.empNo));
        }
    });
    $("#btnDetail").click(function () {
        var row = $("#gridTable").datagrid("getSelected");
        if (row == null) {
            $.messager.alert({
                title: '提示',
                msg: '请选择数据！',
                showType: 'show'
            });
            return false;
        }
        if (row.productType == 5) {
            $EasyUI.NewTab("Detail", $Url.BuildSalesUrl("/sales/sales/detailForP2pProduct?id=" + row.id + "&activitiNo=" + row.activitiNo));
        } else {
            $EasyUI.NewTab("Detail", $Url.BuildSalesUrl("/sales/sales/detailForProduct?id=" + row.id));
        }
    });
    $("#btnExcel").click(function () {
        var status = $("#status").combobox("getValue");
        var productType =$("#productType").combobox("getValue");
        var productNo = $("#productNo").combobox("getValue");
        var peopleType = $("#peopleType").combobox("getValue");
        var peopleNo = $("#peopleNo").combobox("getValue");
        var deptNo = $("#deptNo").val();
        var empNo = $("#empNo").val();
        var customerName = $("#customerName").val();
        var url = $Url.BuildCustomerUrl("/sales/sales/ajaxExportExcel");
        location.href = url + "?" +
            "sord=desc" + "&" +
            "sidx=id" + "&" +
            "status=" + status + "&" +
            "productType=" + productType + "&" +
            "productNo=" + productNo + "&" +
            "peopleType=" + peopleType + "&" +
            "peopleNo=" + peopleNo + "&" +
            "deptNo=" + deptNo + "&" +
            "empNo=" + empNo + "&" +
            "customerName=" + customerName + "&" +
            "isExpire=" + $('#isExpire').is(':checked') + "&"+
            "showDirectList=" + ElementVar.showDirectList + "&" +
            "showChannelList=" + ElementVar.showChannelList + "&" +
            "showShopList=" + ElementVar.showShopList + "&" +
            "showSalesListForP2p=" + ElementVar.showSalesListForP2p + "&" +
            "showSalesListForProduct=" + ElementVar.showSalesListForProduct + "&" +
            "showAllList=" + ElementVar.showAllList;
        ;
    });
    $("#isExpire").change(function(){
        $("#btnSearch").trigger("click");
    });
});