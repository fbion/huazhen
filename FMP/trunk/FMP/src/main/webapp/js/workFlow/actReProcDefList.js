var ManagePage = {
    
    InitGrid: function () {
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildWorkFlowUrl('/workFlow/actReProcDef/ajaxListActReProcDef'),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","id","rEV","cATEGORY","流程定义名称","kEY","版本","部署ID","资源名","图片名","dESCRIPTION","hASSTARTFORMKEY","sUSPENSIONSTATE","tENANTID"],
            colModel: [

				{
					name: "act", index: "act", width: 60, align: "center", sortable: false
				},
				{
					name: "iD", index: "iD", width: 40, align: "left", formoptions: { rowpos: 1, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "rEV", index: "rEV", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "cATEGORY", index: "cATEGORY", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "nAME", index: "nAME", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "kEY", index: "kEY", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "vERSION", index: "vERSION", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "dEPLOYMENTID", index: "dEPLOYMENTID", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "rESOURCENAME", index: "rESOURCENAME", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "dGRMRESOURCENAME", index: "dGRMRESOURCENAME", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "dESCRIPTION", index: "dESCRIPTION", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "hASSTARTFORMKEY", index: "hASSTARTFORMKEY", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "sUSPENSIONSTATE", index: "sUSPENSIONSTATE", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "tENANTID", index: "tENANTID", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
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
                    var edit = "";

                    detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id + "')\">查看</a>";
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
    GetDetail: function (index) {
        window.location.href = $Url.BuildWorkFlowUrl("/workFlow/actReProcDef/edit?id="+index);
        //jQuery("#gridTable").jqGrid('editGridRow', index, {
        //    width: 820, editCaption: "查看记录",
        //    beforeShowForm: function () {
        //        $(".DataTD").children().attr("disabled", "disabled");
        //        $(".EditButton").html("");
        //    }, afterShowForm: function () {
        //    }
        //});
    },
    //GetEdit: function (index) {
    //    jQuery("#gridTable").jqGrid('editGridRow', index, {
    //        width: 820, reloadAfterSubmit: true, closeAfterEdit: true,
    //        beforeShowForm: function () {
    //        }, afterShowForm: function () {
    //        }, afterSubmit: function (response, postdata) {
    //            var res = jQuery.parseJSON(response.responseText), ok = res.errDesc == "";

    //            return [ok, ok ? '' : res.errDesc];
    //        }
    //    });
    //},
    GetAdd: function () {
        window.location.href = $Url.BuildWorkFlowUrl("/workFlow/aCTREPROCDEF/edit")
        //jQuery("#gridTable").jqGrid('editGridRow', "new", {
        //    width: 820, reloadAfterSubmit: true, closeAfterAdd: true, editCaption: "添加记录",
        //    beforeShowForm: function () {
        //        $("#tr_id").remove();
        //    }, afterShowForm: function () {
        //    }, afterSubmit: function (response, postdata) {
        //        var res = jQuery.parseJSON(response.responseText), ok = res.errDesc == "";

        //        return [ok, ok ? '' : res.errDesc];
        //    }
        //});
    }
}


$(function () {
    $("#btnAdd").click(function () { ManagePage.GetAdd(); });

    ManagePage.InitGrid();
    ManagePage.InitQuery();
});