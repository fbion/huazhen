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
            url: $Url.BuildEmployeeUrl('/employee/attendanceApplication/ajaxListAttendanceApplication.action'),
            editurl: $Url.BuildEmployeeUrl("/employee/attendanceApplication/ajaxEditAttendanceApplication.action"),
            datatype: "json",
            mtype: 'GET',
            postData:{
                showAllList:ElementVar.showAllList
            },
            colNames: ["操作","id","员工姓名","公司","部门","职位","类型","备注","请假开始时间","请假结束时间","合计日","合计时","事由","审核","状态","修改备注"],
            colModel: [

				{
					name: "act", index: "act", width: 60, align: "center", sortable: false
				},
				{
					name: "id", index: "id",hidden:true, width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
				},
				{
					name: "empNo", index: "empNo", width: 40, align: "left", formatter : "select", edittype : "select", editoptions : { size : 40, value : EnumList.GetEnumListToEdit("empListById", $Url.BuildEmployeeUrl("/common/enumList.action")) }, formoptions : { rowpos : 2, colpos : 1 }, sortable : false, editable : true
				},
				{
					name: "companyNo", index: "companyNo", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "deptNo", index: "deptNo", width: 40, align: "left", formatter : "select", edittype : "select", editoptions : { size : 40, value : EnumList.GetEnumListToEdit("dept", $Url.BuildEmployeeUrl("/common/enumList.action")) }, formoptions : { rowpos : 3, colpos : 1 }, sortable : false, editable : true
				},
				{
					name: "positionNo", index: "positionNo", width: 40, align: "left", formatter : "select", edittype : "select", editoptions : { size : 40, value : EnumList.GetEnumListToEdit("positionList", $Url.BuildEmployeeUrl("/common/enumList.action")) }, formoptions : { rowpos : 3, colpos : 2 }, sortable : false, editable : true
				},
				{
					name: "type", index: "type", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 },formatter: ManagePage.TypeFormat, unformat: ManagePage.TypeUnFormat
				},
				{
					name: "remark", index: "remark",hidden:true, width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "startTime", index: "startTime", width: 40, align: "left", formatter : "date",formoptions: { rowpos: 5, colpos: 1 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 }
				},
				{
					name: "endTime", index: "endTime", width: 40, align: "left", formatter : "date",formoptions: { rowpos: 5, colpos: 2 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 }
				},
				{
					name: "totalDay", index: "totalDay", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "totalHour", index: "totalHour", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
                    name: "reason", index: "reason", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "activitiNo", index: "activitiNo", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 },hidden:true,editrules:{edithidden:true}
				},
                {
                    name: "workFlowStatus", index: "workFlowStatus", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 2 }, sortable: false, editable: true,formatter : "select", edittype : "select", editoptions : { size : 40, value : EnumList.GetEnumListToEdit("dicDicDataAttendanceStatus", $Url.BuildEmployeeUrl("/common/enumList.action")) }
                },
				{
					name: "editComment", index: "editComment", width: 40, align: "left", formoptions: { rowpos: 10, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 },hidden:true,editrules:{edithidden:true}
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
                var ids = $("#gridTable").jqGrid('getCol', 'id', true);
                var activitiNos = $("#gridTable").jqGrid('getCol', 'activitiNo', true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;
                    var activitiNo = activitiNos[i].value;
                    var detail = "";
                    detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id +"','" +activitiNo+"')\">查看</a>";
                    $("#gridTable").jqGrid("setRowData", id, { act: detail });
                }
            }
        });
    },
    InitQuery: function () {
        $("#btnSearch").click(function () {
            var byName = $("#byName").val();
            var byType = $("#byType").val();
            var byDept = $("#byDept").val();
            var byYear = $("#byYear").val();
            var byMonth = $("#byMonth").val();
            var byStatus = $("#byStatus").val();
            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: {
                    "byName": byName,
                    "byType": byType,
                    "byDept": byDept,
                    "byYear": byYear,
                    "byMonth": byMonth,
                    "byStatus":byStatus
                },
                page: 1
            }).trigger("reloadGrid");
        });
    },
    GetDetail: function (index,activitiNo) {
        window.open($Url.BuildEmployeeUrl("/employee/attendanceApplication/edit?id="+index+"&activitiNo="+activitiNo));
    },
    GetAdd: function () {
        window.open($Url.BuildEmployeeUrl("/employee/attendanceApplication/edit"));
    },
    TypeFormat:function(cellvalue, options, rowObject){
    	if (cellvalue==0) {
    		return "其他";
		}
    	else if (cellvalue==1) {
    		return "外勤";
		}
    	else if (cellvalue==2) {
    		return "事假";
		}
    	else if (cellvalue==3) {
    		return "病假";
		}
    	else if (cellvalue==4) {
    		return "年假";
		}
    	else if (cellvalue==5) {
    		return "加班";
		}
    	else if (cellvalue==6) {
    		return "调休";
		}
    	else{
    	    return cellvalue;
		}
    },
    TypeUnFormat: function (cellvalue, options, rowObject) {
    	if (cellvalue=="其他") {
    		return 0;
		}
    	else if (cellvalue=="外勤") {
    		return 1;
		}
    	else if (cellvalue=="事假") {
    		return 2;
		}
    	else if (cellvalue=="病假") {
    		return 3;
		}
    	else if (cellvalue=="年假") {
    		return 4;
		}
    	else if (cellvalue=="加班") {
    		return 5;
		}
    	else if (cellvalue=="调休") {
    		return 6;
		}
    	else{
    	    return cellvalue;
		}
    },
    FormatStr:function(cellvalue){
    	if(cellvalue.length>10){
    		return cellvalue.substring(0,10)+"...";
    	}
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

    //EnumList.GetEnumListToSelect($("#byDept"), "deptAll", $Url.BuildEmployeeUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#byType"), "dicDicDataAttendanceTypeAll", $Url.BuildEmployeeUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#byStatus"), "dicDicDataAttendanceStatusAll", $Url.BuildEmployeeUrl("/common/enumList.action"));
    $.fn.linkage({
        elements: [$("#byDept"), $("#byName")],
        dataTypes: ["deptAll", "empNoAll"],
        actionUrl: $Url.BuildEmployeeUrl("/common/enumList.action"),
        all: false
    });
    ManagePage.GetDate(2014,2020,$("#byYear"));
    ManagePage.GetDate(1,12,$("#byMonth"));
    $("#btnAdd").click(function () { ManagePage.GetAdd(); });

    $("#btnExcel").click(function () {
        var byName = $("#byName").val();
        var byDept = $("#byDept").val();
        var byType = $("#byType").val();
        var byYear = $("#byYear").val();
        var byMonth = $("#byMonth").val();
        var url = $Url.BuildEmployeeUrl("/employee/attendanceApplication/ajaxExportExcel");
        location.href= url+"?"+
            "sord=desc"+"&"+
            "sidx=id"+"&"+
            "byName="+ byName+"&"+
            "byDept="+byDept+"&"+
            "byType="+ byType+"&"+
            "byYear="+byYear+"&"+
            "showAllList="+ElementVar.showAllList+"&"+
            "byMonth="+byMonth;
    });

    ManagePage.InitGrid();
    ManagePage.InitQuery();
});