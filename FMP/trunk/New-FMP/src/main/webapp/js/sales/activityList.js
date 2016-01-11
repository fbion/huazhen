var ManagePage = {
    DateInputElem: function (value, options) {
        var el = document.createElement("input");
        el.type = "text";
        el.value = value;
        el.onclick = function () { el.focus(); el.select(); WdatePicker({ dateFmt: 'yyyy-MM-dd' }); };
        $(el).addClass("FormElement");
        $(el).addClass("ui-widget-content");
        $(el).addClass("ui-corner-all");
        $(el).css("width", "204px");
        return el;
    },
    DateInputValue: function (elem, operation, value) {
        if (operation === 'get') {
            return $(elem).val();
        } else if (operation === 'set') {
            $(elem).val(value);
        }
    },
    InitGrid: function () {
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildSalesUrl('/sales/activity/ajaxListActivity.action'),
            editurl: $Url.BuildSalesUrl("/sales/activity/ajaxEditActivity.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","id","活动标题","开始时间","主讲嘉宾","邀约人数","地点","状态"],
            colModel: [

				{
					name: "act", index: "act", width: 60, align: "center", sortable: false
				},
				{
					name: "id", index: "id", width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
				},
				{
					name: "title", index: "title", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "activityTime", index: "activityTime", width: 40, align: "left",formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 },formatter:ManagePage.ToDDMMMYYYY
				},
				{
					name: "empName", index: "empName", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "peopleNum", index: "peopleNum", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true, editoptions: {size: 40},formatter:ManagePage.FmatterIsSend
				},
				{
					name: "address", index: "address", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "status", index: "status", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 },formatter:ManagePage.Status
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
    Status:function(cellvalue, options, rowObject){
    	if(cellvalue==0){
    		return "已取消";
    	}
    	if(cellvalue==1){
    		return "储备中";
    	}
    	if(cellvalue==2){
    		return "已发布";
    	}
    	if(cellvalue==3){
    		return "已开始";
    	}
    	
    	if(cellvalue==4){
    		return "已结束";
    	}
    	
    },
    FmatterIsSend:function(cellvalue, options, rowObject){
    	if(cellvalue==0){
    		return "不限";
    	}else{
    		return cellvalue;
    	}
    },
    InitQuery: function () {
   	 $("#btnSearch").click(function () {
       	 var byTime = $("#byTime").val();
       	 var byStatus = $("#byStatus").val();
       	 $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: { 
                	"byTime": byTime,
                	"byStatus": byStatus,
                	},
                page: 1
            }).trigger("reloadGrid");
       });
   },
    GetDetail: function (index) {
        $EasyUI.NewTab("Detail", $Url.BuildSalesUrl("/sales/activity/edit?id="+index));

    },

    GetAdd: function () {
        $EasyUI.NewTab("New", $Url.BuildSalesUrl("/sales/activity/edit"));

    },
    ToDDMMMYYYY:function(date, options, rowObject) {  
        var d = new Date(date);  
        var dd = d.getDate() < 10 ? "0" + d.getDate() : d.getDate().toString(); 
        var mm = d.getMonth()+1< 10 ? "0" + (d.getMonth()+1):(d.getMonth()+1).toString();  
        var yyyy = d.getFullYear().toString();  
        return yyyy +"-"+ mm + "-"+dd;  
    }
}


$(function () {
    $("#btnAdd").click(function () { ManagePage.GetAdd(); });
    $("#byTime").click(function () {
		WdatePicker({dateFmt: 'yyyy-MM-dd'});
	});
    ManagePage.InitGrid();
    ManagePage.InitQuery();
});