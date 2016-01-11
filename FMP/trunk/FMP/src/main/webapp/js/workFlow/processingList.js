var ManagePage = {
    DateInputElem: function (value, options) {
        var el = document.createElement("input");
        el.type = "text";
        el.value = value;
        el.onclick = function () { el.focus(); el.select(); WdatePicker({ dateFmt: 'yyyy-MM-dd HH:mm:ss' });};
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
            url: $Url.BuildWorkFlowUrl('/workFlow/processing/ajaxListProcessing.action'),
            editurl: $Url.BuildWorkFlowUrl("/workFlow/processing/ajaxEditProcessing.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","id","标题","申请日期","状态","uri","查看流程图"],
            colModel: [

				{
					name: "act", index: "act", width: 60, align: "center", sortable: false
				},
				{
					name: "id", index: "id", hidden:true, width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
				},
				{
					name: "title", index: "title", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "requestDate", index: "requestDate", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false,  editable: true,  editoptions: { size: 40 }
				},
				{
					name: "status", index: "status", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
	           {
	        	   name: "uri", index: "uri", hidden:true, width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
	           },
	           {
	        	   name: "actProcess", index: "actProcess", width: 60, align: "center", sortable: false
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
                rows: "pageSize",
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
                var uris = $("#gridTable").jqGrid('getCol', 'uri', true);
                var stas = $("#gridTable").jqGrid('getCol', 'status', true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;
                    var uri = uris[i].value;
                    var status = stas[i].value;
                    var detail = "";
                    var edit = "";
                    var detailProcess = "";

                    detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id +"','"+uri+"')\">查看</a>";
                    edit = "<a class=\"blue\" href=\"javascript:ManagePage.GetEdit('" + id +"','"+uri+"')\">修改</a>";
	        		detailProcess  = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetailProcess('"+id +"')\">查看</a>";
                    $("#gridTable").jqGrid("setRowData", id, { act: detail });
                    $("#gridTable").jqGrid("setRowData", id, { actProcess: detailProcess });
//                    if(status=="未通过"){
//                    	$("#gridTable").jqGrid("setRowData", id, { act: detail +space + edit });
//                    }
                }
            }
        });
    },
    InitQuery: function () {
        $("#btnSearch").click(function () {
	        var bySelectTitle = $("#selectTitle").val();
	        var byStatus = $("#status").val();
	        var byDate = $("#date").val();
	        
	
	        $("#gridTable").jqGrid('setGridParam', {
	            datatype: "json",
	            postData: { 
	            	"bySelectTitle": bySelectTitle,
	            	"byStatus": byStatus,
	            	"byDate":byDate
	            	},
	            page: 1
	        }).trigger("reloadGrid");
        });
    },
    GetDetail: function (id,uri) {
//        var backUrl = window.location.href;
		window.open($Url.BuildWorkFlowUrl(uri+id));
    },
    GetDetailProcess: function (activitiNo) {
		  var url = $Url.BuildWorkFlowUrl("/workFlow/processing/ajaxAuditProcess");
		  initAll.GetAuditProcess(url,activitiNo);
	},
    GetEdit: function (id,uri) {
//    	var backUrl = window.location.href;
		window.open($Url.BuildWorkFlowUrl(uri+id));
    },
    GetAdd: function () {
        window.location.href = $Url.BuildWorkFlowUrl("/workFlow/processing/edit")
    },
    ToDDMMMYYYY:function(date, options, rowObject) {  
        var d = new Date(date);  
        var dd = d.getDate() < 10 ? "0" + d.getDate() : d.getDate().toString(); 
        var mm = d.getMonth()+1< 10 ? "0" + (d.getMonth()+1):(d.getMonth()+1).toString();  
        var yyyy = d.getFullYear().toString();
        var hh = d.getHours()< 10 ? "0" + d.getHours() : d.getHours().toString();
        var MM = d.getMinutes()<10? "0" + d.getMinutes() : d.getMinutes().toString();
        var ss = d.getSeconds()<10? "0" + d.getSeconds() : d.getSeconds().toString();
        return yyyy +"-"+ mm + "-"+dd+" "+hh+":"+MM+":"+ss;  
    },
    GetTitle:function (obj){
    	var titleArr = ["临时招聘","延长试用期","员工辞职","人事变动","员工考勤"];
       	var typeArr = ["tempRecruitNeedProcess","extendProbationApplicationProcesss","resignApplication  ","personalChangeProcess","attendanceApplicationProcess"];
      	var op = $("<option></option>").text("全部").val("");
       	obj.append(op);
       	for (var i=0;i<titleArr.length;i++){
       		var op = $("<option></option>").text(titleArr[i]).val(typeArr[i]);
       		obj.append(op);
    	}
    },
    GetStatus:function(obj){
    	var statusArr = ["通过","未通过"];
    	var typeArr = ["1","2"];
    	var op = $("<option></option>").text("全部").val("");
    	obj.append(op);
       	for (var i=0;i<statusArr.length;i++){
       		var op = $("<option></option>").text(statusArr[i]).val(typeArr[i]);
       		obj.append(op);
    	}
    }
}


$(function () {
    $("#btnAdd").click(function () { ManagePage.GetAdd(); });

    ManagePage.InitGrid();
    ManagePage.InitQuery();
    ///
    ManagePage.GetTitle($("#selectTitle"));
    ManagePage.GetStatus($("#status"));
    
    $("#date").click(function () {
		WdatePicker({dateFmt: 'yyyy-MM-dd'});
	});
    ///
});