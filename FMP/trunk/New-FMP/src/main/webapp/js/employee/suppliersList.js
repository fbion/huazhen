var ManagePage = {
    
    InitGrid: function () {
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildEmployeeUrl('/employee/suppliers/ajaxListSuppliers.action'),
            editurl: $Url.BuildEmployeeUrl("/employee/suppliers/ajaxEditSuppliers.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","id","供应商名称","联系人","联系电话","联系电话2","邮箱","供应商地址","供应种类","备注"],
            colModel: [

				{
					name: "act", index: "act", width: 60, align: "center", sortable: false
				},
				{
					name: "id", index: "id",hidden:true, width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
				},
				{
					name: "supplierName", index: "supplierName", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "contactPerson", index: "contactPerson", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "phone", index: "phone", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "phone2", index: "phone2", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "mail", index: "mail", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "supplierAddr", index: "supplierAddr", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "supplierType", index: "supplierType", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "editComment", index: "editComment", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
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

                    $("#gridTable").jqGrid("setRowData", id, { act: detail +space+edit });
                }
            }
        });
    },
    InitQuery: function () {
        $("#btnSearch").click(function () {
            var bySupplierName = $("#bySupplierName").val();
            var bySupplierType = $("#bySupplierType").val();
            var byContactPerson = $("#byContactPerson").val();


            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: { "bySupplierName": bySupplierName,"bySupplierType":bySupplierType,"byContactPerson":byContactPerson },
                page: 1
            }).trigger("reloadGrid");
        });
    },
    GetDetail: function (index) {
        $EasyUI.NewTab("Detail",$Url.BuildEmployeeUrl("/employee/suppliers/detail?id="+index));
    },
    GetEdit: function (index) {
        $EasyUI.NewTab("Edit",$Url.BuildEmployeeUrl("/employee/suppliers/edit?id="+index));
    //    jQuery("#gridTable").jqGrid('editGridRow', index, {
    //        width: 820, reloadAfterSubmit: true, closeAfterEdit: true,
    //        beforeShowForm: function () {
    //        }, afterShowForm: function () {
    //        }, afterSubmit: function (response, postdata) {
    //            var res = jQuery.parseJSON(response.responseText), ok = res.errDesc == "";

    //            return [ok, ok ? '' : res.errDesc];
    //        }
    //    });
    },
    GetAdd: function () {
        $EasyUI.NewTab("Add",$Url.BuildEmployeeUrl("/employee/suppliers/edit"));
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