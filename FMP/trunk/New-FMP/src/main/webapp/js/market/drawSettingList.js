var ManagePage = {
    
    InitGrid: function () {
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildMarketUrl('/market/drawSetting/ajaxListDrawSetting.action'),
            editurl: $Url.BuildMarketUrl("/market/drawSetting/ajaxEditDrawSetting.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","id","轮次","奖项","抽奖人数"],
            colModel: [

				{
					name: "act", index: "act", width: 60, align: "center", sortable: false
				},
				{
					name: "id", index: "id",hidden:true, width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
				},
				{
					name: "round", index: "round", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "drawAwards", index: "drawAwards", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "drawNumber", index: "drawNumber", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
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
                var space = "|";
                var ids = $("#gridTable").jqGrid('getCol', 'id', true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;

                    var detail = "";
                    var edit = "";

                    detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id + "')\">查看</a>";
                    edit = "<a class=\"blue\" href=\"javascript:ManagePage.GetEdit('" + id + "')\">编辑</a>";

                    $("#gridTable").jqGrid("setRowData", id, { act: detail+space+edit });
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
        $EasyUI.NewTab("Edit", $Url.BuildMarketUrl("/market/drawSetting/edit?id="+index));
    },
    GetAdd: function () {
        $EasyUI.NewTab("New", $Url.BuildMarketUrl("/market/drawSetting/edit"));
    },
    GetEdit: function (index) {
    	$EasyUI.NewTab("Edit", $Url.BuildCustomerUrl("/market/drawSetting/edit?id="+index));
    },
    Reset:function(){
        var url = $Url.BuildSalesUrl("/market/drawSetting/resetDrawSeeting");
        var bool = window.confirm("此操作将重置中奖设置,您确定操作吗?"); 
        if(bool){
                	window.location.href = $Url.BuildMarketUrl("/market/drawSetting/resetDrawSeeting");
            
        }
       
    }
}


$(function () {
    $("#btnAdd").click(function () { ManagePage.GetAdd(); });
    $("#resetbtn").click(function () { ManagePage.Reset(); });

    ManagePage.InitGrid();
    ManagePage.InitQuery();
});