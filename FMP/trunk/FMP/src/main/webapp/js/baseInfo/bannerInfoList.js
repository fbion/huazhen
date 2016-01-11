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
            url: $Url.BuildBaseInfoUrl('/baseInfo/bannerInfo/ajaxListBannerInfo.action'),
            editurl: $Url.BuildBaseInfoUrl("/baseInfo/bannerInfo/ajaxEditBannerInfo.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","id","类型","状态","标题","位置","优先级","适用页面","排除页面","资源url","Url","开始时间","结束时间"],
            colModel: [

                {
                    name: "act", index: "act", width: 60, align: "center", sortable: false
                },
                {
                    name: "id", index: "id", width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
                },
                {
                    name: "type", index: "type", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 },formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("dicDicDataBannerInfoType", $Url.BuildEmployeeUrl("/common/enumList.action"))}
                },
                {
                    name: "status", index: "status", width: 40, align: "left", formoptions: { rowpos: 8, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 },formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("dicDicDataAnnouncementStatus", $Url.BuildEmployeeUrl("/common/enumList.action"))}
                },
                {
                    name: "title", index: "title", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "locationNo", index: "locationNo", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 },formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("bannerLocationList", $Url.BuildEmployeeUrl("/common/enumList.action"))}
                },
                {
                    name: "priority", index: "priority", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "pageNo", index: "pageNo", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "exceptPageNo", index: "exceptPageNo", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "resrcurl", index: "resrcurl", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "linkUrl", index: "linkUrl", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
                },


                {
                    name: "startTime", index: "startTime", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 2 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 }
                },
                {
                    name: "endTime", index: "endTime", width: 40, align: "left", formoptions: { rowpos: 8, colpos: 1 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 }
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
            var byTitle = $("#byTitle").val();
            var byLocation = $("#byLocation").val();
            var byType = $("#byType").val();
            var byStatus = $("#byStatus").val();

            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: {
                    "byTitle": byTitle,
                    "byLocation": byLocation,
                    "byType": byType,
                    "byStatus": byStatus
                },
                page: 1
            }).trigger("reloadGrid");
        });
    },
    GetDetail: function (index) {
        window.open($Url.BuildBaseInfoUrl("/baseInfo/bannerInfo/edit?id="+index));
    },

    GetAdd: function () {
        window.open($Url.BuildBaseInfoUrl("/baseInfo/bannerInfo/edit"));
    }
}


$(function () {
    EnumList.GetEnumListToSelect($("#byLocation"), "bannerLocationListAll", $Url.BuildEmployeeUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#byType"), "dicDicDataBannerInfoTypeAll", $Url.BuildEmployeeUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#byStatus"), "dicDicDataAnnouncementStatusAll", $Url.BuildEmployeeUrl("/common/enumList.action"));
    $("#btnAdd").click(function () { ManagePage.GetAdd(); });

    ManagePage.InitGrid();
    ManagePage.InitQuery();
});