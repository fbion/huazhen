var ManagePage1 = {
    
    InitGrid1: function () {
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildSalesUrl('/sales/applyCustomer/ajaxListApplyCustomer.action'),
            editurl: $Url.BuildSalesUrl("/sales/applyCustomer/ajaxEditApplyCustomer.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["id","客户编号","客户姓名","风险偏好","手机1","手机2","等级","发送短信","状态"],
            colModel: [

				/*{
					name: "act", index: "act", width: 60, align: "center", sortable: false
				},*/
				{
					name: "id", index: "id", width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
				},
				{
					name: "customerNo", index: "customerNo", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "name", index: "name", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name : "riskAppetite", index : "riskAppetite", width : 40, align : "left", formatter : "select", edittype : "select", editoptions : { size : 1, value : EnumList.GetEnumListToEdit( "dicDataforCustomerCompanyRiskHobby", $Url.BuildCustomerUrl("/common/enumList.action"))}, formoptions : {rowpos : 7,colpos : 3},sortable : false,editable : true
				},
				{
					name: "tel", index: "tel", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "mark", index: "mark", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name : "level", index : "level", width : 40, align : "left", formatter : "select", edittype : "select", editoptions : { size : 1, value : EnumList.GetEnumListToEdit( "dicDataforCustomerCompanyRelationLevel", $Url.BuildCustomerUrl("/common/enumList.action")) }, formoptions : { rowpos : 7, colpos : 2 }, sortable : false, editable : true
				},
				{
					name: "isSend", index: "isSend", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 },formatter:ManagePage1.Send
				},
				{
					name: "isSign", index: "isSign", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 },formatter:ManagePage1.Status
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
            //multiselect: true,
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

                    detail = "<a class=\"blue\" href=\"javascript:ManagePage1.GetDetail('" + id + "')\">查看</a>";
                    //edit = "<a class=\"blue\" href=\"javascript:ManagePage.GetEdit('" + id + "')\">编辑</a>";

                    $("#gridTable").jqGrid("setRowData", id, { act: detail });
                }
            }
        });
    },
    InitQuery1: function () {
            var activityNo = $("#activityNo").val();
            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: { "activityNo": activityNo },
                page: 1
            }).trigger("reloadGrid");
    },
    Status:function(cellvalue, options, rowObject){
    	if(cellvalue==0){
    		return "未签到";
    	}
    	if(cellvalue==1){
    		return "已签到";
    	}
    },
    Send:function(cellvalue, options, rowObject){
    	if(cellvalue==0){
    		return "未发";
    	}
    	if(cellvalue==1){
    		return "已发";
    	}
    },
    GetDetail: function (index) {
        window.location.href = $Url.BuildSalesUrl("/sales/applyCustomer/edit?id="+index);
    },
    GetAdd: function () {
        window.location.href = $Url.BuildSalesUrl("/sales/applyCustomer/edit")
    }
}


$(function () {
	$("#invitation").click(function(){
		ManagePage1.InitQuery1();
	});
		ManagePage1.InitGrid1();
    $("#btnAdd").click(function () { ManagePage.GetAdd(); });
});