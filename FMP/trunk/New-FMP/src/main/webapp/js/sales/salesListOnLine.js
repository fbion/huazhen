var SalesList = {

    InitGrid: function () {
        $("#gridTable").jqGrid({
            url: $Url.BuildSalesUrl('/sales/sales/ajaxListSales.action'),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作", "id", "产品类型", "产品", "客户类型","P2P客户ID","P2P客户" ,"订单状态", "订单金额", "购买日期","支付类型","流程","债券到期日","年化利率(%)"],
            colModel: [
                {
                    name: "act", index: "操作", width: 80, align: "center", sortable: false
                },
                {
                    name: "id", index: "id", width: 20, align: "center",hidden:true,editrules:{edithidden:true}, sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 20 }
                },
                {
                    name: "productType", index: "productType", width: 30, align: "left", formatter: "select", edittype: "select", editoptions: {size: 1, value: EnumList.GetEnumListToEdit("productType", $Url.BuildSalesUrl("/common/enumList.action"))}, formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true
                },
                {
                    name: "productNo", index: "productNo", width: 40, align: "center", formatter: $Link.MakeProductUrl,editoptions: { size: 40 }, formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true
                },
                {
                    name: "customerType", index: "customerType", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: {size: 1, value: EnumList.GetEnumListToEdit("customerType", $Url.BuildSalesUrl("/common/enumList.action"))}, formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true
                },
                {
                    name: "p2pCustomerNo", index: "p2pCustomerNo", width: 40, align: "left", hidden:true, formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "customerName", index: "customerName", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "status", index: "status", width: 30, align: "left", formatter: "select", edittype: "select", editoptions: {size: 1, value: EnumList.GetEnumListToEdit("salesStatus", $Url.BuildSalesUrl("/common/enumList.action"))}, formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true
                },
                {
                    name: "money", index: "money", width: 30, align: "left", formoptions: { rowpos: 6, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }
                },
                /*{
                    name: "empName", index: "empName", width: 40, align: "left",formatter: $Link.MakeEmpNameUrl,editrules: { edithidden: false },formoptions: { rowpos: 6, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }
                },
                {
                    name: "empNo", index: "empNo", width: 40, align: "left",hidden:true,editoptions: {size: 1}, formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true
                },*/
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
            postData: {
                showAllList: ElementVar.showAllList,
                payType:"1"
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
                var payTypes = $("#gridTable").jqGrid('getCol','payType',true);
                $("td[aria-describedby='gridTable_customerNo']").css('position', 'relative');
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;
                    var productType = productTypes[i].value;
                    var payType = payTypes[i].value;
                    var operateDetail = "";
                    var operateOk = "";
                    var operateFailed = "";
                    if (ElementVar.operateCheck == TagPermissionType.query) {
                        if ($("#" + id + " td[aria-describedby='gridTable_status']").text() == "待审核") {
                            operateOk = "<a id=\"salesOK_" + id + "\" class=\"btn_style\" href=\"javascript:void(0)\">审核通过</a>";
                            operateFailed = "<a id=\"salesFailed_" + id + "\" class=\"btn_style\" style=\"background:#FF3333 \" href=\"javascript:void(0)\">审核失败</a>";
                        }
                    }
                    operateDetail = "<a class=\"blue\" href=\"javascript:SalesList.GetDetail('" + id +"')\">查看</a>";

                    $("#gridTable").jqGrid("setRowData", id, {act:  operateOk + operateFailed  +" "+operateDetail});
                    if ($("#salesOK_" + id).length > 0) {
                        $("#salesOK_" + id).click(function () {
                            var id = $(this).attr("id").split("_")[1];
                            var rowData = $("#gridTable").jqGrid('getRowData', id);
                            SalesList.CheckOk(rowData.id);
                        });
                    }
                    if ($("#salesFailed_" + id).length > 0) {
                        $("#salesFailed_" + id).click(function () {
                            var id = $(this).attr("id").split("_")[1];
                            var rowData = $("#gridTable").jqGrid('getRowData', id);
                            SalesList.CheckFailed(rowData.id);
                        });
                    }
                }
                $("td[aria-describedby='gridTable_customerNo']").append('<div class="welfareSubsidy p10" id="welfareSubsidy"></div>');
            }
        });
    },
    InitQuery: function () {
        $("#btnSearch").click(function () {
            var byProductType = $("#selectProductType").val();
            var byProduct = $("#selectProduct").val();
            var byStatus = $("#selectStatus").val();
            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: {
                    "byProductType": byProductType,
                    "byProduct": byProduct,
                    "byStatus": byStatus,
                    "payType":1
                },
                page: 1
            }).trigger("reloadGrid");
        });
    },
    GetDetail: function (id) {
        window.open($Url.BuildSalesUrl("/sales/sales/detailOnLine?id=" + id));
    },
    CheckOk: function (id) {
        if (confirm("确定进行审核通过吗？")) {
            var url = $Url.BuildSalesUrl("/sales/sales/ajaxUpdateSalesStatus.action");
            $.ajax({
                type: "post",
                url: url,
                data: {
                    id: id
                },
                beforeSend: function () {
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(errorThrown);
                },
                success: function (data, textStatus) {
                    if(data.errCode == "0000") {
                        alert("操作成功");
                        $("#" + id + " td[aria-describedby='gridTable_status']").text("认购成功");

                        $("#" + id + " td[aria-describedby='gridTable_act']").html("");
                    }
                    else{
                        alert("系统异常，请联系系统管理员");
                        $("#" + id + " td[aria-describedby='gridTable_act']").html("");
                    }

                },
                complete: function (XMLHttpRequest, textStatus) {
                }
            });
        }
    },
    CheckFailed: function (id) {
        if (confirm("确定进行审核失败操作吗？")) {
            var url = $Url.BuildSalesUrl("/sales/sales/ajaxUpdateSalesStatusCancel.action");
            $.ajax({
                type: "post",
                url: url,
                data: {
                    id:id
                },
                beforeSend: function () {
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(errorThrown);
                },
                success: function (data, textStatus) {
                    if(data.errCode == "0000"){
                        alert("操作成功");
                        $("#" + id + " td[aria-describedby='gridTable_status']").text("已取消");
                        $("#" + id + " td[aria-describedby='gridTable_act']").html("");
                    }
                    else{
                        alert("系统异常，请联系系统管理员");
                        $("#" + id + " td[aria-describedby='gridTable_act+']").html("");
                    }
                },
                complete: function (XMLHttpRequest, textStatus) {
                }
            });
        }
    }
}

$(function () {
    EnumList.GetEnumListToSelect($("#selectStatus"), "salesStatusAll", $Url.BuildSalesUrl("/common/enumList.action"));
    $.fn.linkage({
        elements: [$("#selectProductType"), $("#selectProduct")],
        dataTypes: ["productType", "productNo"],
        actionUrl: $Url.BuildSalesUrl("/common/enumList.action"),
        all: true
    });
    SalesList.InitGrid();
    SalesList.InitQuery();
    $("#btnExcel").click(function () {
        var byProduct = $("#selectProduct").val();
        var byStatus = $("#selectStatus").val();
        var url = $Url.BuildCustomerUrl("/sales/sales/ajaxExportExcel");
        location.href = url + "?" +
            "sord=desc" + "&" +
            "sidx=id" + "&" +
            "byProduct=" + byProduct + "&" +
            "byStatus=" + byStatus + "&" +
            "payType=1"+
            "showDirectList=" + ElementVar.showDirectList + "&" +
            "showChannelList=" + ElementVar.showChannelList + "&" +
            "showShopList=" + ElementVar.showShopList + "&" +
            "showAllList=" + ElementVar.showAllList;
        ;
    });
});