var SalesList = {
    GetAdd: function () {
        $("#btnAddSales").click(function () {
            if ($("#btnAddSales").length > 0) {
                window.open($Url.BuildSalesUrl("/sales/sales/edit"));
            }
        });
        if ($("#btnAddSalesForProduct").length > 0) {
            $("#btnAddSalesForProduct").click(function () {
                window.open($Url.BuildSalesUrl("/sales/sales/editForProduct"));
            });
        }
        if ($("#btnAddSalesForP2pProduct").length > 0) {
            $("#btnAddSalesForP2pProduct").click(function () {
                window.open($Url.BuildSalesUrl("/sales/sales/editForP2pProduct"));
            });
        }
    },

    InitGrid: function () {
        $("#gridTable").jqGrid({
            url: $Url.BuildSalesUrl('/sales/sales/ajaxListSales.action'),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作", "id", "产品类型","p2pCustomerNo", "产品","productNo", "客户类型", "客户","customerNo","订单状态", "订单金额","销售经理","empNo", "购买日期", "支付类型","流程","债权到期日","年化利率(%)"],
            colModel: [
                {
                    name: "act", index: "操作", width: 40, align: "center", sortable: false
                },
                {
                    name: "id", index: "id", width: 20, align: "center",editrules:{edithidden:true}, sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 20 }
                },
                {
                    name: "productType", index: "productType", width: 30, align: "left", formatter: "select", edittype: "select", editoptions: {size: 1, value: EnumList.GetEnumListToEdit("productType", $Url.BuildSalesUrl("/common/enumList.action"))}, formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true
                },
                {
                    name: "p2pCustomerNo", index: "p2pCustomerNo", width: 40, align: "center",hidden:true,  editoptions: { size: 40 }, formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true
                },
                {
                    name: "editComment", index: "editComment", width: 60, align: "center", formatter: $Link.MakeP2pProductUrl , editoptions: { size: 40 }, formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true
                },
                {
                    name: "productNo", index: "productNo", width:40, align: "left",hidden:true,  editoptions: { size: 40 }, formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true
                },
                {
                    name: "customerType", index: "customerType", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: {size: 1, value: EnumList.GetEnumListToEdit("customerType", $Url.BuildSalesUrl("/common/enumList.action"))}, formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true
                },
                {
                    name: "customerName", index: "customerName", width: 40, align: "left", formatter: $Link.MakeCustomerUrl, formoptions: { rowpos: 24, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "customerNo", index: "customerNo", width: 40, align: "left",hidden:true, editoptions: {size: 1}, formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true
                },
                {
                    name: "status", index: "status", width: 30, align: "left", formatter: "select", edittype: "select", editoptions: {size: 1, value: EnumList.GetEnumListToEdit("salesStatus", $Url.BuildSalesUrl("/common/enumList.action"))}, formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true
                },
                {
                    name: "money", index: "money", width: 30, align: "left", formoptions: { rowpos: 6, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }
                },
                {
                    name: "empName", index: "empName", width: 40, align: "left",formatter: $Link.MakeEmpNameUrl,editrules: { edithidden: false },formoptions: { rowpos: 6, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }
                },
                {
                    name: "empNo", index: "empNo", width: 40, align: "left",hidden:true,editoptions: {size: 1}, formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true
                },
                {
                    name: "purchaseDate", index: "purchaseDate", width: 40, align: "left", formatter: "date", formoptions: { rowpos: 9, colpos: 2 }, sortable: false, formatoptions: { srcformat: 'Y-m-d', newformat: 'Y-m-d' }, editable: true, edittype: 'custom', editoptions: {size: 20 }
                },
                {
                    name: "payType", index: "payType", width: 40, align: "left",hidden:true, editrules: { edithidden: false }, formoptions: { rowpos: 16, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 }
                },
                {
                    name: "activitiNo", index: "activitiNo", width: 40, align: "left",hidden:true, formoptions: { rowpos: 7, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 },hidden:true,editrules:{edithidden:true}
                },
                {
                    name: "repaymentDate", index: "repaymentDate", width: 40, align: "left",hidden:false, formatter: "date",editoptions: {size: 1}, formoptions: {  srcformat: 'Y-m-d', newformat: 'Y-m-d'  }, sortable: false, editable: true
                },
                {
                    name: "income", index: "income", width: 40, align: "left",hidden:false,editoptions: {size: 1}, formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true
                }
            ],
            sortname: "id",
            sortorder: "desc",
            pager: "#gridPager",
            viewrecords: true,
            rowNum: 10,
            rowList: [10, 20],
            altclass: "altRowsColour",
            shrinkToFit: true,
            autowidth: true,
            height: "auto",
//            multiselect : true,
            postData: {
                showAllList: ElementVar.showAllList,
                showDirectList: ElementVar.showDirectList,
                showChannelList: ElementVar.showChannelList,
                showShopList: ElementVar.showShopList,
                showSalesListForP2p: ElementVar.showSalesListForP2p,
                showSalesListForProduct: ElementVar.showSalesListForProduct,
                payType:0,
                isExpire:$('#isExpire').is(':checked')
            },
            prmNames: {
                search: "search",
                page: "pageIndex",
                rows: "pageSize"
            },
            jsonReader: {
                root: "resultList",
                page: "pageIndex",
                total: "pageCount",
                records: "recordCount",
                repeatitems: false
            },
            pager: "#gridPager",
            gridComplete: function () {
                var ids = $("#gridTable").jqGrid('getCol', 'id', true);
                var productTypes = $("#gridTable").jqGrid('getCol', 'productType', true);
                var empNos = $("#gridTable").jqGrid('getCol', 'empNo', true);
                var payTypes = $("#gridTable").jqGrid('getCol','payType',true);
                var activitiNos = $("#gridTable").jqGrid('getCol','activitiNo',true);
                $("td[aria-describedby='gridTable_customerNo']").css('position', 'relative');
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;
                    var productType = productTypes[i].value;
                    var empNo = empNos[i].value;
                    var payType = payTypes[i].value;
                    var activitiNo = activitiNos[i].value;
                    var operateEdit = "";
                    var operateDetail = "";
                    if (ElementVar.showEditName == TagPermissionType.query) {
                        operateEdit = "<a class=\"blue\" href=\"javascript:SalesList.GetEdit('" + id + "','" + empNo + "','" + productType + "','"+activitiNo+"')\">编辑</a>";
                    }else{
	                    if(PageVar.UserID==empNo){
	                        operateEdit = "<a class=\"blue\" href=\"javascript:SalesList.GetEdit('" + id + "','" + empNo + "','" + productType + "','"+activitiNo+"')\">编辑</a>";
	                    }else{
	                    	operateEdit = "";
	                    }
                    }
                    if ($("#" + id + " td[aria-describedby='gridTable_income']").text() == "0" ) {
                        $("#gridTable").jqGrid("setRowData", id, { income: "-"});
                    }
                    operateDetail = "<a class=\"blue\" href=\"javascript:SalesList.GetDetail('" + id + "','" + productType + "','"+activitiNo+"')\">查看</a>";
                    $("#gridTable").jqGrid("setRowData", id, {act: operateDetail+" "+operateEdit});
                }
            }
        });
    },
    InitQuery: function () {
        $("#btnSearch").click(function () {
            var byProductType = $("#selectProductType").val();
            var byProduct = $("#selectProduct").val();
            var byCustomerType = $("#selectCustomerType").val();
            var byCustomer = $("#selectCustomer").val();
            var byAgentType = $("#selectAgentType").val();
            var byAgent = $("#selectAgent").val();
            var byStatus = $("#selectStatus").val();
            var byEmpNo = $("#byEmpNo").val();
            var byDeptNo = $("#byDeptNo").val();
            var byCustomerName = $("#customerName").val();
            var isExpire = $('#isExpire').is(':checked');
            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: {
                    "byProductType": byProductType,
                    "byProduct": byProduct,
                    "byCustomerType": byCustomerType,
                    "byCustomer": byCustomer,
                    "byAgentType": byAgentType,
                    "byAgent": byAgent,
                    "byStatus": byStatus,
                    "byEmpNo": byEmpNo,
                    "byDeptNo": byDeptNo,
                    "byCustomerName": byCustomerName,
                    "isExpire":isExpire,
                    "payType":0
                },
                page: 1
            }).trigger("reloadGrid");
        });

    },
    GetEdit: function (id, emp,productType,activitiNo) {
        if(productType==5){
            window.open($Url.BuildSalesUrl("/sales/sales/editForP2pProduct?id=" + id + "&empNo=" + emp +"&activitiNo="+activitiNo));
        }else{
            window.open($Url.BuildSalesUrl("/sales/sales/editForProduct?id=" + id + "&empNo=" + emp));
        }

    },
    GetDetail: function (id, productType, activitiNo) {
        if (productType == 5) {
            window.open($Url.BuildSalesUrl("/sales/sales/detailForP2pProduct?id=" + id + "&activitiNo=" + activitiNo));
        } else {
            window.open($Url.BuildSalesUrl("/sales/sales/detailForProduct?id=" + id));
        }
    }
}

var InitValue = {
    InitShowAgent: function () {
        $("#selectAgentType").change(function () {
            if ($(this).val() == 0) {
                $("#selectAgent").prev().html("销售");
            } else if ($(this).val() == 1) {
                $("#selectAgent").prev().html("渠道");
            } else if ($(this).val() == 2) {
                $("#selectAgent").prev().html("投顾");
            } else {
                $("#selectAgent").prev().html("直销");
            }
        });
    }
}


$(function () {
    EnumList.GetEnumListToSelect($("#byDeptNo"), "deptAll", $Url.BuildSalesUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#selectStatus"), "salesStatusAll", $Url.BuildSalesUrl("/common/enumList.action"));
    $.fn.linkage({
        elements: [$("#selectProductType"), $("#selectProduct")],
        dataTypes: ["productType", "productNo"],
        actionUrl: $Url.BuildSalesUrl("/common/enumList.action"),
        all: true
    });

    $.fn.linkage({
        elements: [$("#selectCustomerType"), $("#selectCustomer")],
        dataTypes: ["customerType", {0: "", 1: "myCustomerPerson", 2: "myCustomerCompany"}],
        actionUrl: $Url.BuildSalesUrl("/common/enumList.action"),
        all: true
    });

    $.fn.linkage({
        elements: [$("#selectAgentType"), $("#selectAgent")],
        dataTypes: ["agentType", {0: "", 1: "myAgentBusiness", 2: "myAgentAdviser", 3: "zhixiaoEmp"}],//zhixiaoEmpAll
        actionUrl: $Url.BuildSalesUrl("/common/enumList.action"),
        all: true
    });
    EmployeeTreeControl.startTree({
        param: "on",  //on在职员工，out离职员工，test测试员工
        treeInputId: "employeeSel",//员工控件框ID
        valInputId: "byEmpNo", //员工值框id
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
        valInputId: "byDeptNo", //员工值框id
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
    SalesList.GetAdd();
    InitValue.InitShowAgent();
    SalesList.InitGrid();
    SalesList.InitQuery();
    $("#btnExcel").click(function () {
        var byProductType = $("#selectProductType").val();
        var byProduct = $("#selectProduct").val();
        var byCustomerType = $("#selectCustomerType").val();
        var byCustomer = 0;
        if($("#selectCustomer").val()!=null){
            byCustomer = $("#selectCustomer").val();
        }
        var byAgentType = $("#selectAgentType").val();
        var byAgent = 0;
        if($("#selectAgent").val()!=null){
            byAgent = $("#selectAgent").val();
        }
       var byStatus = $("#selectStatus").val();
        var byEmpNo = $("#byEmpNo").val();
        var byDeptNo = $("#byDeptNo").val();
        var byCustomerName = "";
        if($("#customerName").length>0){
            byCustomerName = $("#customerName").val();
        }
        var url = $Url.BuildCustomerUrl("/sales/sales/ajaxExportExcel");
        location.href = url + "?" +
            "sord=desc" + "&" +
            "sidx=id" + "&" +
            "byProductType=" + byProductType + "&" +
            "byProduct=" + byProduct + "&" +
            "byCustomerType=" + byCustomerType + "&" +
            "byCustomer=" + byCustomer + "&" +
            "byAgentType=" + byAgentType + "&" +
            "byAgent=" + byAgent + "&" +
            "byStatus=" + byStatus + "&" +
            "payType=0&"+
            "byEmpNo=" + byEmpNo + "&" +
            "byDeptNo=" + byDeptNo + "&" +
            "byCustomerName=" + byCustomerName + "&" +
            "isExpire=" + $('#isExpire').is(':checked') + "&"+
            "showDirectList=" + ElementVar.showDirectList + "&" +
            "showChannelList=" + ElementVar.showChannelList + "&" +
            "showShopList=" + ElementVar.showShopList + "&" +
            "showAllList=" + ElementVar.showAllList;
        ;
    });
    $("#isExpire").change(function(){
        $("#btnSearch").trigger("click");
    });
});