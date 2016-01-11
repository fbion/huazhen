var ManagePage = {
		BindPositionNo: function () {
			var positionNo = $("#positionNo").val();
	        $("#positionNo").html("");
	        $("#positionNo").linkageForJqGrid({
	            prev: $("#deptNo"),
	            dataType: "positionNo",
	            actionUrl: $Url.BuildEmployeeUrl("/common/enumList.action"),
	            all: false
	        });
	        $("#positionNo").val(positionNo);
	    },
    
    InitGrid: function () {
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildEmployeeUrl('/employee/positionLevel/ajaxListPositionLevel.action'),
            editurl: $Url.BuildEmployeeUrl("/employee/positionLevel/ajaxEditPositionLevel.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","编号","职级名称","职级备注","部门","职位","修改备注"],
            colModel: [

				{
					name: "act", index: "act", width: 60, align: "center", sortable: false
				},
				{
					name: "id", index: "id", width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: false, editoptions: { readonly: true, size: 20 }
				},
				{
					name: "name", index: "name", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },editrules:{required:true}
				},
				{
					name: "comment", index: "comment", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "deptNo", index: "deptNo", width: 40, align: "left",formatter:"select", edittype:"select",editoptions:{size:1, value:EnumList.GetEnumListToEdit("dept", $Url.BuildEmployeeUrl("/common/enumList.action"))},  formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true
				},
				{
					name: "positionNo", index: "positionNo", width: 40, align: "left", formatter:"select", edittype:"select",editoptions:{size:1, value:EnumList.GetEnumListToEdit("positionList", $Url.BuildEmployeeUrl("/common/enumList.action"))},  formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true
				},
				{
					name: "editComment", index: "editComment", width: 40, align: "left", formoptions: { rowpos:4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				}                
            ],
            sortname: "id",
            sortorder: "desc",
            pager: "#gridPager",
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

                    $("#gridTable").jqGrid("setRowData", id, { act: detail + space + edit });
                }
            }
        });
    },
    InitQuery: function () {
        $("#btnSearch").click(function () {
        	var byDept = $("#selectDept").val();
            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: { "byDept": byDept },
                page: 1
            }).trigger("reloadGrid");
        });
    },
    GetDetail: function (index) {
        jQuery("#gridTable").jqGrid('editGridRow', index, {
             editCaption: "查看记录",
            beforeShowForm: function () {
                $(".DataTD").children().attr("disabled", "disabled");
                $(".EditButton").html("");
            }, afterShowForm: function () {
            }
        });
    },
    GetEdit: function (index) {
        jQuery("#gridTable").jqGrid('editGridRow', index, {
             reloadAfterSubmit: true, closeAfterEdit: true,
            beforeShowForm: function () {
            	ManagePage.BindPositionNo();
            	ManagePage.ShowPoint();
            }, afterShowForm: function () {
            }, afterSubmit: function (response, postdata) {
                var res = jQuery.parseJSON(response.responseText), ok = res.errDesc == "";

                return [ok, ok ? '' : res.errDesc];
            }
        });
    },
    GetAdd: function () {
        jQuery("#gridTable").jqGrid('editGridRow', "new", {
             reloadAfterSubmit: true, closeAfterAdd: true, editCaption: "添加记录",
            beforeShowForm: function () {
                $("#tr_id").css("visibility","hidden");
                ManagePage.BindPositionNo();
                ManagePage.ShowPoint();
            }, afterShowForm: function () {
            }, afterSubmit: function (response, postdata) {
                var res = jQuery.parseJSON(response.responseText), ok = res.errDesc == "";

                return [ok, ok ? '' : res.errDesc];
            }
        });
    },
    ShowPoint:function(){
    	var empName = $("#name").parent().prev().text();
    	$("#name").parent().prev().html(empName + "<em class='color'>*</em>");
    }
  //  PositionNoFormat: function (cellvalue, options, rowObject) {
//	        if (cellvalue == "全部"){
//	            return "";
	//        }else{
	  //      	return cellvalue;
	 //       }
	  //  },
//	PositionNoUnFormat: function (cellvalue, options, cell) {
//	    	if (cellvalue=="") {
//	    		return "全部";
//			}else{
//				return cellvalue;
//			}
//	}
}


$(function () {
    $("#btnAdd").click(function () { ManagePage.GetAdd(); });
    EnumList.GetEnumListToSelect($("#selectDept"), "deptAll", $Url.BuildEmployeeUrl("/common/enumList.action"));
    ManagePage.InitGrid();
    ManagePage.InitQuery();
});