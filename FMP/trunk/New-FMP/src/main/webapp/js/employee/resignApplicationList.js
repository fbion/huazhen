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
            url: $Url.BuildEmployeeUrl('/employee/resignApplication/ajaxListResignApplication.action'),
            editurl: $Url.BuildEmployeeUrl("/employee/resignApplication/ajaxEditResignApplication.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","id","编号","员工姓名","公司","部门","职位","入职日期","离职方式","离职日期","是否保留邮件","保留至何时","审核","修改备注"],
            colModel: [

				{
					name: "act", index: "act", width: 60, align: "center", sortable: false
				},
				{
					name: "id", index: "id", width: 20,hidden:true, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
				},
				{
					name: "code", index: "code", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "empNo", index: "empNo", width: 40, align: "left", formatter : "select", edittype : "select", editoptions : { size : 40, value : EnumList.GetEnumListToEdit("empListById", $Url.BuildEmployeeUrl("/common/enumList.action")) }, formoptions : { rowpos : 2, colpos : 2 }, sortable : false, editable : true
				},
				{
					name: "companyNo", index: "companyNo", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "deptNo", index: "deptNo", width: 40, align: "left", formatter : "select", edittype : "select", editoptions : { size : 40, value : EnumList.GetEnumListToEdit("dept", $Url.BuildEmployeeUrl("/common/enumList.action")) }, formoptions : { rowpos : 3, colpos : 2 }, sortable : false, editable : true
				},
				{
					name: "positionNo", index: "positionNo", width: 40, align: "left", formatter : "select", edittype : "select", editoptions : { size : 40, value : EnumList.GetEnumListToEdit("positionList", $Url.BuildEmployeeUrl("/common/enumList.action")) }, formoptions : { rowpos : 4, colpos : 1 }, sortable : false, editable : true
				},
				{
					name: "hireTime", index: "hireTime", width: 40, align: "left",formatter : "date", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "method", index: "method", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 },formatter: ManagePage.MethodFormat, unformat: ManagePage.MethodUnFormat
				},
				{
					name: "leaveTime", index: "leaveTime", width: 40, align: "left", formatter : "date",formoptions: { rowpos: 5, colpos: 2 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 },hidden:true,editrules:{edithidden:true}
				},
				
				{
					name: "iskeepEmail", index: "iskeepEmail", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 },formatter: ManagePage.IsKeepEmailFormat, unformat: ManagePage.IsKeepEmailUnFormat
				},
				{
					name: "keepTime", index: "keepTime", width: 40, align: "left",formatter : "date", formoptions: { rowpos: 7, colpos: 1 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "activitiNo", index: "activitiNo", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 },hidden:true,editrules:{edithidden:true}
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
                //var space = "|";
                var ids = $("#gridTable").jqGrid('getCol', 'id', true);
                var activitiNos = $("#gridTable").jqGrid('getCol', 'activitiNo', true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;

                    var detail = "";
                    var edit = "";
                    var activitiNo = activitiNos[i].value;
                    detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id +"','" +activitiNo+"')\">查看</a>";
                    //edit = "<a class=\"blue\" href=\"javascript:ManagePage.GetEdit('" + id + "')\">编辑</a>";

                    $("#gridTable").jqGrid("setRowData", id, { act: detail });
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
    GetDetail: function (index,activitiNo) {
        $EasyUI.NewTab("Detail", $Url.BuildEmployeeUrl("/employee/resignApplication/edit?id="+index+"&activitiNo="+activitiNo));
    },

    GetAdd: function () {
        $EasyUI.NewTab("New", $Url.BuildEmployeeUrl("/employee/resignApplication/edit"));
    },
    IsKeepEmailFormat:function(cellvalue, options, rowObject){
    	if (cellvalue==1) {
    		return "是";
		}
    	else if (cellvalue==0) {
    		return "否";
		}else{
    	    return cellvalue;
		}
    },
    IsKeepEmailUnFormat: function (cellvalue, options, rowObject) {
    	if (cellvalue=="是") {
    		return 1;
		}
    	else if (cellvalue=="否") {
    		return 0;
		}else{
    	    return cellvalue;
		}
    },
    MethodFormat:function(cellvalue, options, rowObject){
    	if (cellvalue==0) {
    		return "其他";
		}
    	else if (cellvalue==1) {
    		return "辞退";
		}
    	else if (cellvalue==2) {
    		return "辞职";
		}
    	else{
    	    return cellvalue;
		}
    },
    MethodUnFormat: function (cellvalue, options, rowObject) {
    	if (cellvalue=="其他") {
    		return 0;
		}
    	else if (cellvalue=="辞退") {
    		return 1;
		}
    	else if (cellvalue=="辞职") {
    		return 2;
		}
    	else{
    	    return cellvalue;
		}
    },
    FormatStr:function(cellvalue){
    	if(cellvalue.length>10){
    		return cellvalue.substring(0,10)+"...";
    	}
    }
}


$(function () {
    $("#btnAdd").click(function () { ManagePage.GetAdd(); });

    ManagePage.InitGrid();
    ManagePage.InitQuery();
});