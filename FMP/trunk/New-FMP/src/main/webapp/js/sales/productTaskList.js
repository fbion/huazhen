var ManagePage = {

    InitGrid: function () {
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildSalesUrl('/sales/productTask/ajaxListProductTask.action'),
//            editurl: $Url.BuildSalesUrl("/sales/productTask/ajaxEditProductTask.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作", "id", "产品", "部门", "领取状态", "承销金额", "当前完成", "大小额配", "产品销售周期", "奖励", "销售策略", "修改备注"],
            colModel: [

                {
                    name: "act", index: "act", width: 60, align: "center", sortable: false
                },
                {
                    name: "id", index: "id", width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
                },
                {
                    name: "productNo", index: "productNo", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("productList", $Url.BuildBaseInfoUrl("/common/enumList.action"))}, formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true
                },
                {
                    name: "deptNo", index: "deptNo", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("dept", $Url.BuildBaseInfoUrl("/common/enumList.action"))}, formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true
                },
                {
                    name: "status", index: "status", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("taskStatus", $Url.BuildBaseInfoUrl("/common/enumList.action"))}, formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true
                },
                {
                    name: "taskAmout", index: "taskAmout", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "currAmout", index: "currAmout", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "quota", index: "quota", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }, hidden: true
                },
                {
                    name: "salesCycle", index: "salesCycle", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "incentivePolicy", index: "incentivePolicy", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }, hidden: true
                },
                {
                    name: "salesPolicy", index: "salesPolicy", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }, hidden: true
                },
                {
                    name: "editComment", index: "editComment", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }, hidden: true, editrules: {edithidden: true}
                }
            ],
            sortname: "id",
            sortorder: "desc",
            pager: "#gridPager",
            viewrecords: true,
            rowNum: 10,
            rowList: [10],
            altclass: "altRowsColour",
            shrinkToFit: true,
            autowidth: true,
            height: "auto",
            multiselect: true,
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
                var space = "|";
                var ids = $("#gridTable").jqGrid('getCol', 'id', true);
                var status = $("#gridTable").jqGrid('getCol', 'status', true);
                var products = $("#gridTable").jqGrid('getCol', 'productNo', true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;

                    var title = "查看";
                    if (status[i].value == "0" && RoleVar.CurrentRole == RoleVar.RoleSalesFortune)
                        title = "领取销售任务";

                    var detail = "";

                    detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id + "','"+products[i].value+"')\">"+title+"</a>";
                    $("#gridTable").jqGrid("setRowData", id, { act: detail });
                }
            }
        });
    },
    InitQuery: function () {
        $("#btnSearch").click(function () {
            var byProduct = $("#selectProduct").val();
            var byDept = $("#selectDept").val();
            var byStatus = $("#selectStatus").val();

            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: {
                    "byProduct": byProduct,
                    "byDept": byDept,
                    "byStatus":byStatus
                },
                page: 1
            }).trigger("reloadGrid");
        });
    },
    GetDetail: function (index,productNo) {
        window.location.href = $Url.BuildProductUrl("/sales/productTask/edit?id=" + index+"&productNo="+productNo);
    }
}


$(function () {
    $("#btnAdd").click(function () {
        ManagePage.GetAdd();
    });
    EnumList.GetEnumListToSelect($("#selectProduct"), "productListAll", $Url.BuildBaseInfoUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#selectDept"), "deptByParentAll", $Url.BuildSalesUrl("/common/enumList.action"),DEPTVar.DEPTSales);
    EnumList.GetEnumListToSelect($("#selectStatus"), "taskStatusAll", $Url.BuildBaseInfoUrl("/common/enumList.action"));
    ManagePage.InitGrid();
    ManagePage.InitQuery();
});