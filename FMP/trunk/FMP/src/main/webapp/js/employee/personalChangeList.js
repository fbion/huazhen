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
            url: $Url.BuildEmployeeUrl('/employee/personalChange/ajaxListPersonalChange.action'),
            editurl: $Url.BuildEmployeeUrl("/employee/personalChange/ajaxEditPersonalChange.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","id","编号","姓名","公司","部门","职位","入职时间","变动申请日","变动生效日","变动性质","备注","审核","修改备注"],
            colModel: [

				{
					name: "act", index: "act", width: 60, align: "center", sortable: false
				},
				{
					name: "id", index: "id",hidden:true, width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }, hidden: true,editrules: {edithidden: true}
				},
				{
					name: "code", index: "code",hidden:true, width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }, hidden: true,editrules: {edithidden: true}
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
					name: "startTime", index: "startTime", width: 40, align: "left", formatter : "date",formoptions: { rowpos: 4, colpos: 2 }, sortable: false, formatoptions: { srcformat: 'Y-m-d', newformat: 'Y-m-d' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 }
				},
				{
					name: "applyTime", index: "applyTime", width: 40, align: "left",formatter : "date", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, formatoptions: { srcformat: 'Y-m-d', newformat: 'Y-m-d ' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 }
				},
				{
					name: "forceTime", index: "forceTime", width: 40, align: "left",formatter : "date", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, formatoptions: { srcformat: 'Y-m-d', newformat: 'Y-m-d' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 }
				},
				{
					name: "property", index: "property", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40},formatter: ManagePage.PropertyValueFormat, unformat: ManagePage.PropertyValueUnFormat
				},
				{
					name: "remark", index: "remark",hidden:true, width: 40, align: "left", formoptions: { rowpos: 7, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }, hidden: true,editrules: {edithidden: true}
				},
				{
					name: "activitiNo", index: "activitiNo", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 },hidden : true, editrules : { edithidden : true }
				},
				{
					name: "editComment", index: "editComment",hidden:true, width: 40, align: "left", formoptions: { rowpos: 10, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }, hidden: true,editrules: {edithidden: true}
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
            var byName = $("#byName").val();
            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: {"byName": byName },
                page: 1
            }).trigger("reloadGrid");
        });
    },
    GetDetail: function (index,activitiNo) {

//        var backUrl = window.location.href;
        window.open($Url.BuildEmployeeUrl("/employee/personalChange/edit?id="+index+"&activitiNo="+activitiNo));

    },

    GetAdd: function () {
//    	var backUrl = window.location.href;
        window.open($Url.BuildEmployeeUrl("/employee/personalChange/edit"));
    },
    PropertyValueFormat:function(cellvalue, options, rowObject){
    	if (cellvalue==0) {
    		return "其他";
		}
    	else if (cellvalue==1) {
    		return "部门调动";
		}
    	else if (cellvalue==2) {
    		return "职位变动";
		}
    	else if (cellvalue==3) {
    		return "工资调整";
		}else{
    	    return cellvalue;
		}
    },
    PropertyValueUnFormat: function (cellvalue, options, rowObject) {
    	if (cellvalue=="其他") {
    		return 0;
		}
    	else if (cellvalue=="部门调动") {
    		return 1;
		}
    	else if (cellvalue=="职位变动") {
    		return 2;
		}
    	else if (cellvalue=="工资调整") {
    		return 3;
		}else{
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