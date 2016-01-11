
var ManagePage = {

    InitGrid: function () {
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildSalesUrl('/sales/creditor/ajaxListCreditor.action'),
            editurl: $Url.BuildSalesUrl("/sales/creditor/ajaxEditCreditor.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","id","项目名称","编号","总房款（50%）","剩余抵用额","产品"],
            colModel: [

                {
                    name: "act", index: "act", width: 60, align: "center", sortable: false
                },
                {
                    name: "id", index: "id", width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
                },
                {
                    name: "projectName", index: "projectName", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "roomNumber", index: "roomNumber", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "totalMoney", index: "totalMoney", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "remainAmount", index: "remainAmount", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "productNo", index: "productNo", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 },formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("p2pProductNoList", $Url.BuildBaseInfoUrl("/common/enumList.action"))}
                }
            ],
            sortname: "id",
            sortorder: "desc",
            viewrecords: true,
            rowNum: 10,
            rowList: [10],
            altclass: "altRowsColour",
            shrinkToFit:true,
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
                //var space = "|";
                var ids = $("#gridTable").jqGrid('getCol', 'id', true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;
                    var detail = "";
                    detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetEdit('" + id + "')\">编辑</a>";
                    $("#gridTable").jqGrid("setRowData", id, { act: detail });
                }
            }
        });
    },
    InitQuery: function () {
        $("#btnSearch").click(function () {
            //var byName = $("#byName").val();
            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                //postData: { "byName": byName },
                page: 1
            }).trigger("reloadGrid");
        });
    },
//    GetDetail: function (index) {
////        window.open($Url.BuildSalesUrl("/sales/creditor/edit?id="+index));
//        jQuery("#gridTable").jqGrid('editGridRow', index, {
//            width: 820, editCaption: "查看记录",
//            beforeShowForm: function () {
//                $(".DataTD").children().attr("disabled", "disabled");
//                $(".EditButton").html("");
//            }, afterShowForm: function () {
//            }
//        });
//    },
    GetEdit: function (index) {
        jQuery("#gridTable").jqGrid('editGridRow', index, {
            width: 820, reloadAfterSubmit: true, closeAfterEdit: true,
            beforeShowForm: function () {
            }, afterShowForm: function () {
            }, afterSubmit: function (response, postdata) {
                var res = jQuery.parseJSON(response.responseText), ok = res.errDesc == "";

                return [ok, ok ? '' : res.errDesc];
            }
        });
    },
    GetAdd: function () {
//        window.open($Url.BuildSalesUrl("/sales/creditor/edit"));
        jQuery("#gridTable").jqGrid('editGridRow', "new", {
            width: 820, reloadAfterSubmit: true, closeAfterAdd: true, editCaption: "添加记录",
            beforeShowForm: function () {
                $("#tr_id").remove();
            }, afterShowForm: function () {
            }, afterSubmit: function (response, postdata) {
                var res = jQuery.parseJSON(response.responseText), ok = res.errDesc == "";
                return [ok, ok ? '' : res.errDesc];
            }
        });
    }
}


$(function () {
    $("#btnAdd").click(function () { ManagePage.GetAdd(); });
    ManagePage.InitGrid();
    ManagePage.InitQuery();
});