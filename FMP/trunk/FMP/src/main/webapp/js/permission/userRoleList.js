var ManagePage = {
    
    InitGrid: function () {
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildPermissionUrl('/permission/userRole/ajaxListUserRole.action'),
            editurl: $Url.BuildPermissionUrl("/permission/userRole/ajaxEditUserRole.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","编号","用户","角色","修改备注"],
            colModel: [

				{
					name: "act", index: "act", width: 60, align: "center", sortable: false
				},
				{
					name: "id", index: "id", width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
				},
				{
					name: "userNo", index: "userNo", width: 40, align: "left",formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("user", $Url.BuildPermissionUrl("/common/enumList.action"))}, formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true
				},
				{
					name: "roleNo", index: "roleNo", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("role", $Url.BuildPermissionUrl("/common/enumList.action"))},formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true
				},
				{
					name: "editComment", index: "editComment", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
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
            var userNo = $("#selectUser").val();

            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: { "userNo": userNo },
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
    EnumList.GetEnumListToSelect($("#selectUser"), "userAll", $Url.BuildPermissionUrl("/common/enumList.action"));
    ManagePage.InitGrid();
    ManagePage.InitQuery();
});