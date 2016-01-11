var ManagePage = {
    
    InitGrid: function () {
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildEmployeeUrl('/employee/empBrokerageLadder/ajaxListEmpBrokerageLadder.action'),
            editurl: $Url.BuildEmployeeUrl("/employee/empBrokerageLadder/ajaxEditEmpBrokerageLadder.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","编号","编码","员工","名称","提成上限","提成下限","提成附加值","提成比例","修改备注"],
            colModel: [

				{
					name: "act", index: "act", width: 60, align: "center", sortable: false
				},
				{
					name: "id", index: "id", width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 20 }
				},
				{
					name: "code", index: "code", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }
				},
				{
					name: "empNo", index: "empNo", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("role", $Url.BuildEmployeeUrl("/common/enumList.action"))}, sortable: false, editable: true,formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true
				},
				{
					name: "name", index: "name", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }
				},
				{
					name: "upperLimit", index: "upperLimit", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 }
				},
				{
					name: "lowerLimit", index: "lowerLimit", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }
				},
				{
					name: "moneyAdd", index: "moneyAdd", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 }
				},
				{
					name: "rate", index: "rate", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }
				},
				{
					name: "editComment", index: "editComment", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 }
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
            //var byName = $("#byName").val();


            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                //postData: { "byName": byName },
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
            }, afterShowForm: function () {
            }, afterSubmit: function (response, postdata) {
                var res = jQuery.parseJSON(response.responseText), ok = res.errDesc == "";

                return [ok, ok ? '' : res.errDesc];
            }
        });
    }
}


$(function () {
    $("#btnAdd").click(function () { ManagePage.GetAdd(); });
    //绑定员工 selectEmp
    EnumList.GetEnumListToSelect($("#selectEmp"), "roleAll", $Url.BuildEmployeeUrl("/common/enumList.action"));
    ManagePage.InitGrid();
    ManagePage.InitQuery();
});