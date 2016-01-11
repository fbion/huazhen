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
            url: $Url.BuildEmployeeUrl('/employee/interviewEvaluationRecord/ajaxListInterviewEvaluationRecord.action?showAllList='+ElementVar.showAllList),
            editurl: $Url.BuildEmployeeUrl("/employee/interviewEvaluationRecord/ajaxEditInterviewEvaluationRecord.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","id","姓名","性别","应聘职位","初试时间","录用岗位","总评分合计","综合评价","结论","面试官","面试日期","初试评价","复试评价","修改备注","复试人"],
            colModel: [

				{
					name: "act", index: "act", width: 60, align: "center", sortable: false
				},
				{
					name: "id", index: "id", width: 20, align: "center",hidden:true, sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
				},
				{
					name: "name", index: "name", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "sex", index: "sex", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 },formatter:ManagePage.FmatterSex
				},
				{
					name: "desirePositionNo", index: "desirePositionNo", width: 40, align: "left", formatter:"select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("positionList", $Url.BuildEmployeeUrl("/common/enumList.action"))}, formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true
				},
				{
					name: "firstTime", index: "firstTime", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 },formatter:ManagePage.ToDDMMMYYYY
				},
				{
					name: "hirePositionNo", index: "hirePositionNo", width: 40, align: "left", formatter:"select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("positionList", $Url.BuildEmployeeUrl("/common/enumList.action"))}, formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true
				},
				{
					name: "totalScore", index: "totalScore", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "evaluation", index: "evaluation", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "conclusion", index: "conclusion", width: 40, align: "left",hidden:true, formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "empNo", index: "empName", width: 40, align: "left",hidden:true, formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("empListForEmp", $Url.BuildEmployeeUrl("/common/enumList.action"))},formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true
				},
				{
					name: "interviewDate", index: "interviewDate", width: 40,hidden:true, align: "left", formoptions: { rowpos: 6, colpos: 2 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 },formatter:ManagePage.ToDDMMMYYYY
				},
				{
					name: "firstEvaluation", index: "firstEvaluation", width: 40, align: "left",hidden:true, formoptions: { rowpos: 7, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "secondEvaluation", index: "secondEvaluation", width: 40, align: "left",hidden:true, formoptions: { rowpos: 7, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "editComment", index: "editComment", width: 40, align: "left",hidden:true, formoptions: { rowpos: 10, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
                {
                    name: "retestUserNo", index: "retestUserNo", hidden:true,width: 40, align: "left", formoptions: { rowpos: 10, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
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
                var names = $("#gridTable").jqGrid('getCol', 'name', true);
                var conclusions = $("#gridTable").jqGrid('getCol', 'conclusion', true);
                var evaluations = $("#gridTable").jqGrid('getCol', 'evaluation', true);
                var retestUserNos = $("#gridTable").jqGrid('getCol', 'retestUserNo', true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;
                    var name = names[i].value;
                    var detail = "";
                    var edit = "";
                    detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id + "','"+name+"')\">查看</a>";
                    
                    var conclusion = conclusions[i].value;
                    var evaluation = evaluations[i].value;
                    var retestUserNo = retestUserNos[i].value;
                    var retest = "";
                    var span = "";
                    var showReTest = false;
                    if(conclusion!=4 &&evaluation==""&&retestUserNo==PageVar.UserId){
                    	span = " | ";
                    	showReTest = true;
                    	retest="<a class=\"blue\" href=\"javascript:ManagePage.GetAddReTest('" + id + "','"+name+"','"+showReTest+"')\">复试</a>";
                    }


                    $("#gridTable").jqGrid("setRowData", id, { act: detail + span + retest});
                }
            }
        });
    },
    InitQuery: function () {
    	$("#btnSearch").click(function () {
        	var byName = $("#txtName").val().trim();
            var bySelectPositionNo = $("#selectPositionNo").val();
            var byYear = $("#year").val();
            var byMonth = $("#month").val();
            

            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: { 
                	"byName": byName,
                	"bySelectPositionNo": bySelectPositionNo,
                	"byYear":byYear,
                	"byMonth":byMonth,
                	"showAllList":ElementVar.showAllList
                	},
                page: 1
            }).trigger("reloadGrid");
        });
    },
    GetDetail: function (index,name) {
        window.open($Url.BuildEmployeeUrl("/employee/interviewEvaluationRecord/edit?id="+index+"&&name="+name));
    },
    GetAddReTest:function(index,name,showReTest){
    	window.open($Url.BuildEmployeeUrl("/employee/interviewEvaluationRecord/edit?id="+index+"&name="+name+"&showReTest="+showReTest));
    },

    GetAdd: function () {
        window.open($Url.BuildEmployeeUrl("/employee/interviewEvaluationRecord/edit"));
    },
    ToDDMMMYYYY:function(date, options, rowObject) {  
        var d = new Date(date);  
        var dd = d.getDate() < 10 ? "0" + d.getDate() : d.getDate().toString(); 
        var mm = d.getMonth()+1< 10 ? "0" + (d.getMonth()+1):(d.getMonth()+1).toString();  
        var yyyy = d.getFullYear().toString();  
        return yyyy +"-"+ mm + "-"+dd;  
    },
    FmatterSex:function(cellvalue, options, rowObject){
    	if(cellvalue==0){
    		return "女";
    	}else if(cellvalue==1){
    		return "男";
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
    
    EnumList.GetEnumListToSelect($("#selectPositionNo"), "positionListAll", $Url.BuildEmployeeUrl("/common/enumList.action"));
});