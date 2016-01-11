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
            url: $Url.BuildBaseInfoUrl('/baseInfo/announcement/ajaxListAnnouncement.action'),
            editurl: $Url.BuildBaseInfoUrl("/baseInfo/announcement/ajaxEditAnnouncement.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","编号","主题","内容","类型","状态","是否指定","是否标红","链接地址","开始时间","结束时间"],
            colModel: [

                {
                    name: "act", index: "act", width: 40, align: "center", sortable: false
                },
                {
                    name: "id", index: "id", width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
                },
                {
                    name: "subject", index: "subject", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "content", index: "content", width: 80, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "type", index: "type", width: 20, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 },formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("dicDicDataAnnouncementType", $Url.BuildEmployeeUrl("/common/enumList.action"))}
                },
                {
                    name: "status", index: "status", width: 20, align: "left", formoptions: { rowpos: 6, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 },formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("dicDicDataAnnouncementStatus", $Url.BuildEmployeeUrl("/common/enumList.action"))}
                },
                {
                    name: "isTop", index: "isTop", width:20, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 } ,formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("isYes", $Url.BuildEmployeeUrl("/common/enumList.action"))}
                },
                {
                    name: "isRed", index: "isRed", width: 20, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }, formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("isYes", $Url.BuildEmployeeUrl("/common/enumList.action"))}
                },
                {
                    name: "linkurl", index: "linkurl", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "startTime", index: "startTime", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 }
                },
                {
                    name: "endTime", index: "endTime", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 }
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
                    //edit = "<a class=\"blue\" href=\"javascript:ManagePage.GetEdit('" + id + "')\">编辑</a>";

                    $("#gridTable").jqGrid("setRowData", id, { act: detail });
                }
            }
        });
    },
    InitQuery: function () {
        $("#btnSearch").click(function () {
            var bySubject = $("#bySubject").val();
            var byType = $("#byType").val();
            var byStatus = $("#byStatus").val();
            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: {
                    "bySubject": bySubject,
                    "byType": byType,
                    "byStatus": byStatus
                },
                page: 1
            }).trigger("reloadGrid");
        });
    },
    GetDetail: function (index) {
        window.open($Url.BuildBaseInfoUrl("/baseInfo/announcement/edit?id="+index));
    },
    GetAdd: function () {
        window.open($Url.BuildBaseInfoUrl("/baseInfo/announcement/edit"));
    }
}


$(function () {
    EnumList.GetEnumListToSelect($("#byType"), "dicDicDataAnnouncementTypeAll", $Url.BuildEmployeeUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#byStatus"), "dicDicDataAnnouncementStatusAll", $Url.BuildEmployeeUrl("/common/enumList.action"));
    $("#btnAdd").click(function () { ManagePage.GetAdd(); });
    ManagePage.InitGrid();
    ManagePage.InitQuery();
});