var ManagePage = {

    InitGrid: function () {
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildEmployeeUrl('/report/paymentReport/ajaxListPaymentReport.action'),
            //editurl: $Url.BuildEmployeeUrl("/employee/company/ajaxEditCompany.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","编号","付款日期","还款类型","提交申请时间","流程编号","流程状态"],
            colModel: [

                {
                    name: "act", index: "act", width: 30, align: "center", sortable: false
                },
                {
                    name: "id", index: "id", width: 30, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
                },
                {
                    name: "payDate", index: "payDate", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 },formatter: "date",editoptions: {size: 1}, formoptions: {  srcformat: 'Y-m-d', newformat: 'Y-m-d'  }
                },
                {
                    name: "type", index: "type", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 },formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("paymentType", $Url.BuildBaseInfoUrl("/common/enumList.action"))}
                },
                {
                    name: "submitTime", index: "submitTime", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 },formatter: "date",editoptions: {size: 1}, formoptions: {  srcformat: 'Y-m-d', newformat: 'Y-m-d'  }
                },
                {
                    name: "activitiNo", index: "activitiNo", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "activitiStatus", index: "activitiStatus", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
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
                var activitiNos = $("#gridTable").jqGrid('getCol', 'activitiNo', true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;
                    var activitiNo = activitiNos[i].value;

                    var detail = "";
                    var edit = "";

                    detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id +"','"+activitiNo+ "')\">查看</a>";
                    //edit = "<a class=\"blue\" href=\"javascript:ManagePage.GetEdit('" + id + "')\">编辑</a>";

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
    GetDetail: function (index,index2) {
        window.open($Url.BuildEmployeeUrl("/report/paymentReportDeatil/list?paymentReportId="+index+"&activitiNo="+index2));
    }
}


$(function () {
    ManagePage.InitGrid();
    ManagePage.InitQuery();
});