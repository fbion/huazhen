var ManagePage = {
    
    InitGrid: function () {
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildMarketUrl('/market/winningRecord/ajaxListWinningRecord.action'),
            editurl: $Url.BuildMarketUrl("/market/winningRecord/ajaxEditWinningRecord.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","用户头像","id","昵称","姓名","联系方式","奖项","是否领取"],
            colModel: [
				{
				    name: "act", index: "act", width: 20, align: "center", sortable: false
				},
				{
					name: "userImgPath", index: "userImgPath", width: 30, align: "center", sortable: false
				},
				{
					name: "id", index: "id",hidden:true, width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
				},
				{
					name: "userName", index: "userName", width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
				},
				{
					name: "name", index: "name", width: 30, align: "center", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "cellphone", index: "cellphone", width: 30, align: "center", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "drawAwards", index: "drawAwards", width: 30, align: "center", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "isAwardStr", index: "isAwardStr", width: 20, align: "center", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
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
                var paths = $("#gridTable").jqGrid('getCol','userImgPath',true);
                var isAwards = $("#gridTable").jqGrid('getCol','isAwardStr',true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;
                    var path = paths[i].value;
                    var isAward = isAwards[i].value
                    if(isAward == "否"){
                    	var award = "<a class=\"blue\" href=\"javascript:ManagePage.GetAward('" + id + "')\">领奖</a>";
                    	$("#gridTable").jqGrid("setRowData",id,{act:award});
                    }
                    if(isAward == "是"){
                    	var award = "<a class=\"blue\" href=\"javascript:ManagePage.UndoGetAward('" + id + "')\">撤销</a>";
                    	$("#gridTable").jqGrid("setRowData",id,{act:award});
                    }
                    
                    var img = "<img alt=\"用户头像\" id=\"userimg\" class=\"userimg\" src=\"" + path + "\" style=\"width:100px;height=100px\">";
                    $("#gridTable").jqGrid("setRowData", id, { userImgPath: img });
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
    GetAward: function(id){
    	var content = "确认领奖？";
		 if (confirm(content)) {
	         $.post($Url.BuildMarketUrl("/market/winningRecord/ajaxGetAwardWinningRecord"),{winRecordId:id},function(data){
	    	 if(data.errCode == "0000"){
	        		 alert(data.errDesc);
	        		 var award = "<a class=\"blue\" href=\"javascript:ManagePage.UndoGetAward('" + id + "')\">撤销</a>";
                 	 $("#gridTable").jqGrid("setRowData",id,{act:award});
                 	 $("#gridTable").jqGrid("setRowData",id,{isAwardStr:"是"});
	        	 }else{
	        		 alert(data.errDesc);
	        	 }
	         });
		 }
    },
    UndoGetAward: function(id){
    	var content = "撤销领奖？";
    	if(confirm(content)){
    		$.post($Url.BuildMarketUrl("/market/winningRecord/ajaxUndoGetAwardWinningRecord"),{winRecordId:id},function(data){
    			if(data.errCode == "0000"){
	        		 alert(data.errDesc);
	        		 var award = "<a class=\"blue\" href=\"javascript:ManagePage.GetAward('" + id + "')\">领奖</a>";
                 	 $("#gridTable").jqGrid("setRowData",id,{act:award});
                 	 $("#gridTable").jqGrid("setRowData",id,{isAwardStr:"否"});
	        	 }else{
	        		 alert(data.errDesc);
	        	 }
    		});
    	}
    }
    
//    ,
//    GetDetail: function (index) {
//        $EasyUI.NewTab("Eidt", $Url.BuildMarketUrl("/market/winningRecord/edit?id="+index));
//    },
//    GetAdd: function () {
//        $EasyUI.NewTab("New", $Url.BuildMarketUrl("/market/winningRecord/edit"));
//    }
}


$(function () {
	EnumList.GetEnumListToSelect($("#drawAwards"), "drawAwards", $Url.BuildSalesUrl("/common/enumList.action"));
    $("#btnAdd").click(function () { ManagePage.GetAdd(); });
    $("#btnExcel").click( function () { 
    	var url = $Url.BuildCustomerUrl("/market/winningRecord/exportExcel");
        location.href= url;
    	
    });

    ManagePage.InitGrid();
    ManagePage.InitQuery();
});