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
            url: $Url.BuildEmployeeUrl('/employee/probationEvaluation/ajaxListProbationEvaluation.action?showAllList='+ElementVar.showAllList+'&showPassedList='+ElementVar.showPassedList),
            editurl: $Url.BuildEmployeeUrl("/employee/probationEvaluation/ajaxEditProbationEvaluation.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","id","code","姓名","所属公司","部门","职位","入职时间","总分","审核状态","备注","审核编号","试用期开始日期","试用期结束日期"],
            colModel: [

				{
					name: "act", index: "act", width: 60, align: "center", sortable: false
				},
				{
					name: "id", index: "id", width: 20, align: "center",hidden:true, sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
				},
				{
					name: "code", index: "code", width: 40, align: "left",hidden:true, formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "empNo", index: "empName", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("empListForEmp", $Url.BuildEmployeeUrl("/common/enumList.action"))},formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true
				},
				{
					name: "companyNo", index: "companyNo", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("empCompanylist", $Url.BuildEmployeeUrl("/common/enumList.action"))},formoptions: { rowpos: 6, colpos: 1 }, sortable: false, editable: true
				},
				{
					name: "deptNo", index: "deptNo", width: 40, align: "left", formatter:"select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("dept", $Url.BuildEmployeeUrl("/common/enumList.action"))}, formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true
				},
				{
					name: "positionNo", index: "positionNo", width: 40, align: "left", formatter:"select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("positionList", $Url.BuildEmployeeUrl("/common/enumList.action"))}, formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true
				},
				{
					name: "startTime", index: "startTime", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 },formatter:ManagePage.ToDDMMMYYYY
				},
				{
					name: "totalScore", index: "totalScore", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "activitiStatus", index: "activitiStatus", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 2 }, sortable: false, editable: true,formatter : "select", edittype : "select", editoptions : { size : 40, value : EnumList.GetEnumListToEdit("dicDicDataAttendanceStatus", $Url.BuildEmployeeUrl("/common/enumList.action")) }
				},
				{
					name: "editComment", index: "editComment", width: 40, align: "left",hidden:true, formoptions: { rowpos: 8, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "activitiNo", index: "activitiNo", width: 40, align: "left", formoptions: { rowpos: 9, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "startDate", index: "startDate",hidden:true, width: 40, align: "left", formoptions: { rowpos: 9, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "endDate", index: "endDate",hidden:true, width: 40, align: "left", formoptions: { rowpos: 9, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
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
            	if(ElementVar.showPassedList=="query"){
                	$("#activitiStatus").attr("disabled","disabled");
                	$("#activitiStatus").val(1);
                	jQuery("#gridTable").setGridParam().hideCol("act").trigger("reloadGrid");
                	jQuery("#gridTable").setGridParam().hideCol("startTime").trigger("reloadGrid");
                	jQuery("#gridTable").setGridParam().showCol("startDate").trigger("reloadGrid");
                	jQuery("#gridTable").setGridParam().showCol("endDate").trigger("reloadGrid");
                }
                var ids = $("#gridTable").jqGrid('getCol', 'id', true);
                var activitiNos = $("#gridTable").jqGrid('getCol', 'activitiNo', true);
                var startDates = $("#gridTable").jqGrid('getCol', 'startDate', true);
                var endDates = $("#gridTable").jqGrid('getCol', 'endDate', true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;

                    var detail = "";
                    var edit = "";
                    var activitiNo = activitiNos[i].value;
                    var startDate = startDates[i].value;
                    var endDate = endDates[i].value;
                    detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id +"','" +activitiNo+"')\">查看</a>";
                    //edit = "<a class=\"blue\" href=\"javascript:ManagePage.GetEdit('" + id + "')\">编辑</a>";
                    if(startDate!=null && startDate!=""){
                    	$("#gridTable").jqGrid("setRowData", id, { startDate: startDate.replace("T"," ") });
                    }
                    if(endDate!=null && endDate!=""){
                    	$("#gridTable").jqGrid("setRowData", id, { endDate: endDate.replace("T"," ") });
                    }
                    $("#gridTable").jqGrid("setRowData", id, { act: detail });
                }
            }
        });
    },
    InitQuery: function () {
    	$("#btnSearch").click(function () {
            var byName = $("#txtName").val().trim();
            var bySelectCompany = $("#selectCompany").val().trim();
            var bySelectDepartment = $("#selectDepartment").val();
            var bySelectPositionNo = $("#selectPositionNo").val();
            var byactivitiStatus = $("#activitiStatus").val();
            var byYear = $("#year").val();
            var byMonth = $("#month").val();
            

            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: { 
                	"byName": byName,
                	"bySelectCompany": bySelectCompany,
                	"bySelectDepartment": bySelectDepartment,
                	"bySelectPositionNo": bySelectPositionNo,
                	"byactivitiStatus":byactivitiStatus,
                	"byYear":byYear,
                	"byMonth":byMonth
                	
                	},
                page: 1
            }).trigger("reloadGrid");
        });
    },
    GetDetail: function (index,activitiNo) {

       window.open($Url.BuildEmployeeUrl("/employee/probationEvaluation/edit?id="+index+"&activitiNo="+activitiNo));
    },

    GetAdd: function () {
       window.open($Url.BuildEmployeeUrl("/employee/probationEvaluation/edit"));
    },
    ToDDMMMYYYY:function(date, options, rowObject) {  
        var d = new Date(date);  
        var dd = d.getDate() < 10 ? "0" + d.getDate() : d.getDate().toString(); 
        var mm = d.getMonth()+1< 10 ? "0" + (d.getMonth()+1):(d.getMonth()+1).toString();  
        var yyyy = d.getFullYear().toString();  
        return yyyy +"-"+ mm + "-"+dd;  
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
    $("#btnAdd").click(function () { ManagePage.GetAdd(); });

    ManagePage.InitGrid();
    ManagePage.InitQuery();
    ManagePage.GetDate(2014,new Date().getUTCFullYear(),$("#year"));
    $("#year").off().change(function(){
    	if($("#year").val()!='0'){
    		$("#showMonth").show();
    		$("#month").html("");
    		ManagePage.GetDate(1,12,$("#month"));
    	}else{
    		$("#showMonth").hide();
    		$("#month").html("");
    	}
    	
    });
    
    EnumList.GetEnumListToSelect($("#selectCompany"), "empCompanylistAll", $Url.BuildEmployeeUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#selectDepartment"), "deptAll", $Url.BuildEmployeeUrl("/common/enumList.action"));
	EnumList.GetEnumListToSelect($("#selectPositionNo"), "positionListAll", $Url.BuildEmployeeUrl("/common/enumList.action"));

	
	$("#selectCompany").off().change(function(){
		if($("#selectCompany")==1){
			EnumList.GetEnumListToSelect($("#selectDepartment"), "deptListByCompany", $Url.BuildEmployeeUrl("/common/enumList.action"),$("#selectCompany").val());
			EnumList.GetEnumListToSelect($("#positionNo"), "positionListBydeptType1", $Url.BuildEmployeeUrl("/common/enumList.action"),$("#deptNo").val());
		}
    });
    $("#selectDepartment").off().change(function(){
    	EnumList.GetEnumListToSelect($("#selectPositionNo"), "positionListBydeptTypeAll", $Url.BuildEmployeeUrl("/common/enumList.action"),$("#selectDepartment").val());
    	if($("#selectDepartment").val()==0){
    		EnumList.GetEnumListToSelect($("#selectPositionNo"), "positionListAll", $Url.BuildEmployeeUrl("/common/enumList.action"));
    	}
    });
});