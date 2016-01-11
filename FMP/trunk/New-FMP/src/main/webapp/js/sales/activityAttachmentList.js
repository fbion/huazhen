var ManagePage = {
    
    InitGrid: function () {
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildSalesUrl('/sales/activityAttachment/ajaxListActivityAttachment.action'),
            editurl: $Url.BuildSalesUrl("/sales/activityAttachment/ajaxEditActivityAttachment.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","id","activityNo","name","path","type","status"],
            colModel: [

				{
					name: "act", index: "act", width: 60, align: "center", sortable: false
				},
				{
					name: "id", index: "id", width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
				},
				{
					name: "activityNo", index: "activityNo", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "name", index: "name", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "path", index: "path", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "type", index: "type", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "status", index: "status", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
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
        window.location.href = $Url.BuildSalesUrl("/sales/activityAttachment/edit?id="+index);
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
        window.location.href = $Url.BuildSalesUrl("/sales/activityAttachment/edit")
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