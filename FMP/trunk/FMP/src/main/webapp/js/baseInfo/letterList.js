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
            url: $Url.BuildBaseInfoUrl('/baseInfo/letter/ajaxListLetter.action'),
            editurl: $Url.BuildBaseInfoUrl("/baseInfo/letter/ajaxEditLetter.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","id","重要程度","状态","类型","标题","创建者","待办人","抄送给","解决者","解决方案","预期完成时间"],
            colModel: [
                {
                    name: "act", index: "act", width: 60, align: "center", sortable: false
                },
                {
                    name: "id", index: "id", width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
                },
                {
                    name: "importantDegree", index: "importDegre", width: 20, align: "center", sorttype: "number", editable: true, editoptions: { readonly: true, size: 40},formatter: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("dicDataforCustomerAgentBussinessImportance", $Url.BuildBaseInfoUrl("/common/enumList.action"))}
                },
                {
                    name: "status", index: "status", width: 20, align: "center", sorttype: "number", editable: true, editoptions: { readonly: true, size: 40},formatter: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("letterStatus", $Url.BuildBaseInfoUrl("/common/enumList.action"))}
                },
                {
                    name: "type", index: "type", width: 20, align: "center", sorttype: "number", editable: true, editoptions: { readonly: true, size: 40},formatter: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("letterType", $Url.BuildBaseInfoUrl("/common/enumList.action"))}
                },
                {
                    name: "subject", index: "subject", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true,  editoptions: { size: 40 }
                },
                {
                    name: "inUserNo", index: "inUserNo", width: 20, align: "center", sorttype: "number", editable: true, editoptions: { readonly: true, size: 40},formatter: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("empListJq", $Url.BuildBaseInfoUrl("/common/enumList.action"))}
                },
                {
                    name: "recipient", index: "recipient", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true,formatter: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("empListJqQ", $Url.BuildBaseInfoUrl("/common/enumList.action"))}
                },
                {
                    name: "sendDeplicate", index: "sendDeplicate", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true,formatter: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("empListJq", $Url.BuildBaseInfoUrl("/common/enumList.action"))}
                },
                {
                    name: "solveUserNo", index: "solveUserNo", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 },formatter: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("empListJq", $Url.BuildBaseInfoUrl("/common/enumList.action"))}
                },

                {
                    name: "solvePlan", index: "solvePlan",width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true,  editoptions: { size: 40 }
                },
                {
                    name: "expectFinishTime", index: "expectFinishTime", width: 40, align: "left", formatter: "date", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, formatoptions: { srcformat: 'Y-m-d', newformat: 'Y-m-d' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 }
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
            postData: {
                type:"1"
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
                    //edit = "<a class=\"blue\" href=\"javascript:ManagePage.GetEdit('" + id + "')\">编辑</a>";

                    $("#gridTable").jqGrid("setRowData", id, { act: detail });
                }
            }
        });
    },
    InitQuery: function () {
        $("#btnSearch").click(function () {
            var subject = $("#subject").val();
            var recipient = $("#recipient").val();
            var status = $("#status").val();
            var importantDegree = $("#importantDegree").val();
            var inUserNo = $("#inUserNo").val();
            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: {
                    "subject": subject,
                    "recipient": recipient,
                    "status":status,
                    "importantDegree":importantDegree,
                    "inUserNo":inUserNo
                    },
                page: 1
            }).trigger("reloadGrid");
        });
    },
    GetDetail: function (index) {
        window.open($Url.BuildBaseInfoUrl("/baseInfo/letter/edit?id="+index));
    },
    GetAdd: function () {
        window.open($Url.BuildBaseInfoUrl("/baseInfo/letter/edit"));
    }
}


$(function () {
    EnumList.GetEnumListToSelect($("#recipient"), "empListAllJqQ", $Url.BuildBaseInfoUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#status"), "letterStatusAll", $Url.BuildBaseInfoUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#inUserNo"), "empListAll", $Url.BuildBaseInfoUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#importantDegree"), "dicDataforCustomerAgentBussinessImportanceAll", $Url.BuildBaseInfoUrl("/common/enumList.action"));
    $("#btnAdd").click(function () { ManagePage.GetAdd(); });
    ManagePage.InitGrid();
    ManagePage.InitQuery();
});