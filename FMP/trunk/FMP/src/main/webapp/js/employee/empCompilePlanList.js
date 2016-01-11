/**
 * Created by Administrator on 2015/5/11.
 */

var ManagePage = {
    DateInputElem: function (value, options) {
        var el = document.createElement("input");
        el.type = "text";
        el.value = value;
        el.onclick = function () { el.focus(); el.select(); WdatePicker({ dateFmt: 'yyyy-MM-dd HH:mm:ss' }); };
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
            url: $Url.BuildEmployeeUrl('/employee/empCompilePlan/ajaxListEmpCompilePlan.action'),
            editurl: $Url.BuildEmployeeUrl("/employee/empCompilePlan/ajaxEditEmpCompilePlan.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["编号","公司","部门","岗位名称","定编人数","现有人数","现有人员姓名","缺编人数","计划招聘时间","统计年份","统计月份"],
            colModel: [
                {
                    name: "id", index: "id", width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
                },
                {
                    name: "companyNo", index: "companyNo", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }, formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("empCompanylist", $Url.BuildEmployeeUrl("/common/enumList.action"))}
                },
                {
                    name: "deptNo", index: "deptNo", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }, formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("dept", $Url.BuildEmployeeUrl("/common/enumList.action"))}
                },
                {
                    name: "positionNo", index: "positionNo", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }, formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("positionList", $Url.BuildEmployeeUrl("/common/enumList.action"))}
                },
                {
                    name: "dueEmpNumber", index: "dueEmpNumber", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "realEmpNumber", index: "realEmpNumber", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "allEmpName", index: "allEmpName", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "lackEmpNumber", index: "lackEmpNumber", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "planTime", index: "planTime", width: 40, align: "left", formatter: "date", formatoptions: { srcformat: 'Y-m-d', newformat: 'Y-m-d' },formoptions: { rowpos: 8, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "year", index: "year", width: 40, align: "left", formoptions: { rowpos: 8, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "month", index: "month", width: 40, align: "left", formoptions: { rowpos: 8, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
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
                    $("#gridTable").jqGrid("setRowData", id, { act: detail });
                }
            }
        });
    },
    InitQuery: function () {

        $("#btnSearch").click(function () {
            var byDept = $("#byDept").val();
            var byYear = $("#byYear").val();
            var byMonth = $("#byMonth").val();
            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: {
                    "byDept": byDept,
                    "byYear":byYear,
                    "byMonth":byMonth
                    },
                page: 1
            }).trigger("reloadGrid");
        });
    },
    GetDetail: function (index) {
        window.location.href = $Url.BuildEmployeeUrl("/employee/empCompilePlan/edit?id="+index);

    },

    GetAdd: function () {
        window.location.href = $Url.BuildEmployeeUrl("/employee/empCompilePlan/edit")
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
    ManagePage.InitGrid();
    ManagePage.InitQuery();
    ManagePage.GetDate(2014,2020,$("#byYear"));
    ManagePage.GetDate(1,12,$("#byMonth"));
    EnumList.GetEnumListToSelect($("#byDept"), "deptAll", $Url.BuildEmployeeUrl("/common/enumList.action"));
    $("#btnExcel").click(function () {
        var byDept = $("#byDept").val().trim();
        var byMonth = $("#byMonth").val();
        var byYear = $("#byYear").val();
        var url = $Url.BuildEmployeeUrl("/employee/empCompilePlan/ajaxExportExcel");
        location.href= url+"?"+
            "sord=desc"+"&"+
            "sidx=id"+"&"+
            "byDept="+ byDept+"&"+
            "byMonth="+byMonth+"&"+
            "byYear="+ byYear;
    });
});