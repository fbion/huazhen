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
            url: $Url.BuildCustomerUrl('/customer/activities/ajaxListActivities.action'),
            editurl: $Url.BuildCustomerUrl("/customer/activities/ajaxEditActivities.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","id","活动名称","活动状态","活动类型","活动开始时间","活动结束时间","是否发布","是否显示在新手专区","活动规则","修改备注","是否测试"],
            colModel: [

				{
					name: "act", index: "act", width: 60, align: "center", sortable: false
				},
				{
					name: "id", index: "id", width: 20, align: "center",hidden:true, sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
				},
				{
					name: "activityName", index: "activityName", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "activityStatus", index: "activityStatus",hidden:true, width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
                    name: "activityType", index: "activityType", width: 20, align: "left", formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("activityType", $Url.BuildCustomerUrl("/common/enumList.action")) }, formoptions: { rowpos: 7, colpos: 2 }, sortable: false, editable: true
				},
				{
					name: "startTime", index: "startTime", width: 30, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 }
				},
				{
					name: "endTime", index: "endTime", width: 30, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 }
				},
				{
                    name: "status", index: "status", width: 20, align: "left", formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("activityStatuses", $Url.BuildCustomerUrl("/common/enumList.action")) }, formoptions: { rowpos: 7, colpos: 2 }, sortable: false, editable: true
				},
				{
                    name: "isDisplay", index: "isDisplay", width: 20, align: "left", formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("isDisplay", $Url.BuildCustomerUrl("/common/enumList.action")) }, formoptions: { rowpos: 7, colpos: 2 }, sortable: false, editable: true
				},
				{
					name: "activityRule", index: "activityRule", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "editComment", index: "editComment",hidden:true, width: 40, align: "left", formoptions: { rowpos: 8, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "isTest", index: "isTest", width: 40,hidden:true, align: "left", formoptions: { rowpos: 8, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
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
                var startTimes = $("#gridTable").jqGrid('getCol', 'startTime', true);
                var endTimes = $("#gridTable").jqGrid('getCol', 'endTime', true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;
                    var startTime = startTimes[i].value;
                    var endTime = endTimes[i].value;
                    if(startTime.indexOf("T")>-1){
                    	$("#gridTable #"+id+" td[aria-describedby='gridTable_startTime']").text(startTime.replace("T"," "));
                    }
                    if(endTime.indexOf("T")>-1){
                    	$("#gridTable #"+id+" td[aria-describedby='gridTable_endTime']").text(endTime.replace("T"," "));
                    }
                    
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
            var byActivityType = $("#byActivityType").val();
            var byStatus = $("#byStatus").val();
            var byStartTime = "";
            var byEndTime = "";
            if($("#byStartTime").val()!="" && $("#byStartTime").val()!=null){
                byStartTime = $("#byStartTime").val()+":00:00";
            }
            if($("#byEndTime").val()!="" && $("#byEndTime").val()!=null){
                byEndTime = $("#byEndTime").val()+":00:00";
            }
            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: { 
                	"byActivityType": byActivityType, 
                	"byStatus": byStatus, 
                	"byStartTime": byStartTime, 
                	"byEndTime": byEndTime
                	},
                page: 1
            }).trigger("reloadGrid");
        });
    },
    GetDetail: function (index) {
    	$EasyUI.NewTab("Edit", $Url.BuildCustomerUrl("/customer/activities/edit?id="+index));
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
    	$EasyUI.NewTab("New", $Url.BuildCustomerUrl("/customer/activities/edit"));
    }
}


$(function () {
    $("#btnAdd").click(function () { ManagePage.GetAdd(); });
    EnumList.GetEnumListToSelect($("#byActivityType"),"activityTypeAll",$Url.BuildCustomerUrl("/common/enumList.action"));
	EnumList.GetEnumListToSelect($("#byStatus"),"activityStatusesAll",$Url.BuildCustomerUrl("/common/enumList.action"));
	$("#byStartTime").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd HH'});
    });
    $("#byEndTime").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd HH'});
    });
    ManagePage.InitGrid();
    ManagePage.InitQuery();
});