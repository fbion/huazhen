var ManagePage = {

    InitGrid: function () {
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildEmployeeUrl('/employee/commissionWealthCenter/ajaxListCommissionWealthCenter.action'),
            editurl: $Url.BuildEmployeeUrl("/employee/commissionWealthCenter/ajaxEditCommissionWealthCenter.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["编号","员工编号","员工姓名","部门","职位","类型","统计时间（年）","统计时间（月）","销售总额","提成比例","成立金额","提成工资"],
            colModel: [
//
//                {
//                    name: "act", index: "act", width: 60, align: "center", sortable: false
//                },
                {
                    name: "id", index: "id", width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
                },
                {
                    name: "empNo", index: "empNo", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "empName", index: "empName", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "deptNo", index: "deptNo", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }, formatter:"select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("dept", $Url.BuildEmployeeUrl("/common/enumList.action"))}
                },
                {
                    name: "positionNo", index: "positionNo", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }, formatter:"select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("positionList", $Url.BuildEmployeeUrl("/common/enumList.action"))}
                },
                {
                    name: "type", index: "type", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "year", index: "year", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "month", index: "month", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "salesMoney", index: "salesMoney", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "commissionScale", index: "commissionScale", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "establishMoney", index: "establishMoney", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "commissionMoney", index: "commissionMoney", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
                }
//                {
//                    name: "isExamine", index: "isExamine", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
//                },

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
            var byName = $("#txtName").val().trim();
            var bySelectDepartment = $("#selectDepartment").val();
            var bySelectPositionNo = $("#selectPositionNo").val();
            var year = $("#year").val();
            var month = $("#month").val();
            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: {
                    "byName": byName,
                    "bySelectDepartment": bySelectDepartment,
                    "bySelectPositionNo": bySelectPositionNo,
                    "year":year,
                    "month":month
                    //"showAllList":ElementVar.showAllList
                },
                page: 1
            }).trigger("reloadGrid");

        });
    },
    GetDetail: function (index) {
        window.location.href = $Url.BuildEmployeeUrl("/employee/commissionWealthCenter/edit?id="+index);
    },
    GetAdd: function () {
        window.location.href = $Url.BuildEmployeeUrl("/employee/commissionWealthCenter/edit")
    },
    GetDate:function(strat,end,obj){
        var op = $("<option></option>").text("全部").val(0);
        obj.append(op);
        for (var i=strat;i<=end;i++){
            var op = $("<option></option>").text(i).val(i);
            obj.append(op);
        }
    }
}


$(function () {
    EnumList.GetEnumListToSelect($("#selectDepartment"), "deptAll", $Url.BuildProductUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#selectPositionNo"), "positionListAll", $Url.BuildProductUrl("/common/enumList.action"));

    $("#selectDepartment").off().change(function(){
        EnumList.GetEnumListToSelect($("#selectPositionNo"), "positionListBydeptTypeAll", $Url.BuildProductUrl("/common/enumList.action"),$("#selectDepartment").val());
        if($("#selectDepartment").val()==0){
            EnumList.GetEnumListToSelect($("#selectPositionNo"), "positionListAll", $Url.BuildProductUrl("/common/enumList.action"));
        }
    });

    ManagePage.GetDate(2014,2020,$("#year"));
    ManagePage.GetDate(1,12,$("#month"));

    $("#btnAdd").click(function () { ManagePage.GetAdd(); });
    ManagePage.InitGrid();
    ManagePage.InitQuery();

    $("#btnExcel").click(function () {
        var byName = $("#txtName").val().trim();
        var bySelectDepartment = $("#selectDepartment").val();
        var bySelectPositionNo = $("#selectPositionNo").val();
        var year = $("#year").val();
        var month = $("#month").val();
        var url = $Url.BuildEmployeeUrl("/employee/commissionWealthCenter/ajaxExportExcel");
        location.href= url+"?"+
//            "showAllList="+ElementVar.showAllList+"&"+
            "sord=desc"+"&"+
            "sidx=id"+"&"+
            "byName="+ byName+"&"+
            "bySelectDepartment="+bySelectDepartment+"&"+
            "bySelectPositionNo="+ bySelectPositionNo+"&"+
            "year="+year+"&"+
            "month="+month;
    });
});