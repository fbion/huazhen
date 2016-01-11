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
            colNames: ["操作","id","重要程度","状态","类型","标题","创建者","待办人","内容","备注"],
            colModel: [
                {
                    name: "act", index: "act", width: 30, align: "center", sortable: false
                },
                {
                    name: "id", index: "id", width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
                },
                {
                    name: "importantDegree", index: "importDegre", width: 20, align: "center", sorttype: "number", editable: true, editoptions: { readonly: true, size: 40},formatter: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("dicDataforCustomerAgentBussinessImportance", $Url.BuildBaseInfoUrl("/common/enumList.action"))}
                },
                {
                    name: "isRead", index: "isRead", width: 20, align: "center", sorttype: "number", editable: true, editoptions: { readonly: true, size: 40},formatter: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("remindType", $Url.BuildBaseInfoUrl("/common/enumList.action"))}
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
                    name: "recipient", index: "recipient", width: 20, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true,formatter: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("empListJqQ", $Url.BuildBaseInfoUrl("/common/enumList.action"))}
                },
                {
                    name: "content", index: "content", width: 60, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true,  editoptions: { size: 40 }
                },
                {
                    name: "comment", index: "comment", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true,  editoptions: { size: 40 }
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
            postData: {
                type:"3,2"
            },
            pager: "#gridPager",
            gridComplete: function () {
                var ids = $("#gridTable").jqGrid('getCol', 'id', true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;
                    if ($("#" + id + " td[aria-describedby='gridTable_type']").text() == "通知" ) {
                        $("#gridTable").jqGrid("setRowData", id, {isRead: "-1"});
                    }
                    var detail = "";
                    detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id + "')\">查看</a>";
                    $("#gridTable").jqGrid("setRowData", id, { act: detail });
                }
            }
        });
    },
    InitQuery: function () {
        $("#btnSearch").click(function () {
            var subject = $("#subject").val();
            var recipient = $("#recipient").val();
//            var isRead = $("#isRead").val();
            var importantDegree = $("#importantDegree").val();
            var inUserNo = $("#inUserNo").val();
            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: {
                    "subject": subject,
                    "recipient": recipient,
//                    "isRead":isRead,
                    "importantDegree":importantDegree,
                    "inUserNo":inUserNo
                },
                page: 1
            }).trigger("reloadGrid");
        });
    },
    GetDetail: function (index) {
        $EasyUI.NewTab("Edit",$Url.BuildBaseInfoUrl("/baseInfo/letter/edit?id="+index));
    },
}


$(function () {
    EnumList.GetEnumListToSelect($("#recipient"), "empListAllJqQ", $Url.BuildBaseInfoUrl("/common/enumList.action"));
    //EnumList.GetEnumListToSelect($("#isRead"), "remindType", $Url.BuildBaseInfoUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#inUserNo"), "empListAll", $Url.BuildBaseInfoUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#importantDegree"), "dicDataforCustomerAgentBussinessImportanceAll", $Url.BuildBaseInfoUrl("/common/enumList.action"));
    $("#btnAdd").click(function () { ManagePage.GetAdd(); });
    ManagePage.InitGrid();
    ManagePage.InitQuery();
});