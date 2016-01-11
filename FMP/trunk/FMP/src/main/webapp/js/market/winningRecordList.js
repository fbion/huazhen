var ManagePage = {
    
    InitGrid: function () {
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildMarketUrl('/market/winningRecord/ajaxListWinningRecord.action'),
            editurl: $Url.BuildMarketUrl("/market/winningRecord/ajaxEditWinningRecord.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["用户头像","id","昵称","姓名","联系方式","奖项","是否领取"],
            colModel: [

				{
					name: "userImgPath", index: "act", width: 30, align: "center", sortable: false
				},
				{
					name: "id", index: "id",hidden:true, width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
				},
				{
					name: "userName", index: "userName", width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
				},
				{
					name: "name", index: "name", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "cellphone", index: "cellphone", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "drawAwards", index: "drawAwards", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "isAwardStr", index: "isAwardStr", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
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

                    detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id + "')\">查看</a> ";
                    //edit = "<a class=\"blue\" href=\"javascript:ManagePage.GetEdit('" + id + "')\">修改</a>";

                    $("#gridTable").jqGrid("setRowData", id, { act: detail });
                }
            }
        });
    },
    InitQuery: function () {
        $("#btnSearch").click(function () {
            var byName = $("#userName").val();
            var drawNo = $("#drawAwards").val();

            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: { "byName": byName,"drawNo":drawNo },
                page: 1
            }).trigger("reloadGrid");
        });
    },
    GetDetail: function (index) {
        window.open($Url.BuildMarketUrl("/market/winningRecord/edit?id="+index));
    },
    GetAdd: function () {
        window.open($Url.BuildMarketUrl("/market/winningRecord/edit"));
    }
}


$(function () {
	EnumList.GetEnumListToSelect($("#drawAwards"), "drawAwards", $Url.BuildSalesUrl("/common/enumList.action"));
    $("#btnAdd").click(function () { ManagePage.GetAdd(); });

    ManagePage.InitGrid();
    ManagePage.InitQuery();
});