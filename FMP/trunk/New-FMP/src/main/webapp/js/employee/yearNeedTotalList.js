var ManagePage = {

    InitGrid: function () {
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildEmployeeUrl('/employee/yearNeedTotal/ajaxListYearNeedTotal.action'),
            editurl: $Url.BuildEmployeeUrl("/employee/yearNeedTotal/ajaxEditYearNeedTotal.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","id","编号","年份","总数","状态","备注","审核编号"],
            colModel: [

                {
                    name: "act", index: "act", width: 60, align: "center", sortable: false
                },
                {
                    name: "id", index: "id", width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
                },
                {
                    name: "code", index: "code", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "financialYear", index: "financialYear", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "total", index: "total", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
                },

                {
                    name: "activitiStatus", index: "activitiStatus", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "editComment", index: "editComment", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
				{
					name: "activitiNo", index: "activitiNo", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
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

                    var detail = "";
                    var edit = "";
                    var activitiNo = activitiNos[i].value;
                    detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id +"','" +activitiNo+"')\">查看</a>";
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
    GetDetail: function (index,activitiNo) {
        $EasyUI.NewTab("Detail", $Url.BuildEmployeeUrl("/employee/yearNeedTotal/edit?id="+index+"&activitiNo="+activitiNo));
    },
    GetAdd: function () {
        $EasyUI.NewTab("New", $Url.BuildEmployeeUrl("/employee/yearNeedTotal/edit"));
    }
}
$(function () {
    $("#btnAdd").click(function () { ManagePage.GetAdd(); });
    $("#btnBack").click(function(){
        $EasyUI.Close();
    })
    ManagePage.InitGrid();
    ManagePage.InitQuery();
});