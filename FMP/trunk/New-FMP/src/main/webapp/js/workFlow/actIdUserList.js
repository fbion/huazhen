var ManagePage = {
    
    InitGrid: function () {
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildWorkFlowUrl('/workFlow/actIdUser/ajaxListActIdUser.action'),
            editurl: $Url.BuildWorkFlowUrl("/workFlow/actIdUser/ajaxEditactIdUser.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","id","姓名"],
            colModel: [
				{
					name: "act", index: "act", width: 60, align: "center", sortable: false
				},
				{
					name: "id", index: "id", width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: false, editoptions: { readonly: true, size: 40 }
				},
				{
					name: "lastName", index: "lastName", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
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
                var names = $("#gridTable").jqGrid('getCol', 'lastName', true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;
                    var name =names[i].value;
                    var detail = "";
                    var edit = "";
                    var assign = "";

                    detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id + "')\">查看</a>";
                    assign = " <a class=\"blue\" href=\"javascript:ManagePage.AssignGroup('" + id + "','"+name+"')\">分配流程用户组</a>";
                    //edit = "<a class=\"blue\" href=\"javascript:ManagePage.GetEdit('" + id + "')\">编辑</a>";

                    $("#gridTable").jqGrid("setRowData", id, { act: detail + space + assign });
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
        window.location.href = $Url.BuildWorkFlowUrl("/workFlow/actIdUser/edit?id="+index);
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
        window.location.href = $Url.BuildWorkFlowUrl("/workFlow/actIdUser/edit")
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
    },
    AssignGroup: function (index,name) {
       $('#w').window('open');
       EnumList.GetEnumListToSelect($("#unAssignGroupList"), "unAssignGroups", $Url.BuildWorkFlowUrl("/common/enumList.action"),index);
       EnumList.GetEnumListToSelect($("#assignGroupList"), "assignGroups", $Url.BuildWorkFlowUrl("/common/enumList.action"),index);
       $("#id").html(index);
       $("#userName").html(name);
      $("#userName1").html(name);
    }
}


$(function () {
    $("#btnAdd").click(function () { ManagePage.GetAdd(); });

    ManagePage.InitGrid();
    ManagePage.InitQuery();
    
    $("#leftToRigth").click(function(){
 	   EnumList.AssignRole("unAssignGroupList","assignGroupList", $Url.BuildWorkFlowUrl("/workFlow/actIdUser/ajaxUpdateGroups.action"),$("#id").text());
    });
    $("#rigthToLeft").click(function(){
 	   EnumList.AssignRole("assignGroupList","unAssignGroupList", $Url.BuildWorkFlowUrl("/workFlow/actIdUser/ajaxUpdateGroups.action"),$("#id").text());
    });
});