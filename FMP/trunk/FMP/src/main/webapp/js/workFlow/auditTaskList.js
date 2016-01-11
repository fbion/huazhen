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
		$("#gridTable").jqGrid({
			url: $Url.BuildWorkFlowUrl('/workFlow/auditTask/ajaxListAuditTaskAccept.action'),
			datatype: "json",
			mtype: 'GET',
			colNames: ["操作","id","标题","申请人","任务","实例","申请日期","获得任务日期","申请人ID","流程实例ID","name","查看流程图"],
			colModel: [
			           {
			        	   name: "act", index: "act", width: 60, align: "center", sortable: false
			           },
			           {
			        	   name: "id", index: "id", hidden:true, width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
			           },
			           {
			        	   name: "title", index: "title", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
			        	   
			           },
			           {
			        	   name: "requestUser", index: "requestUser", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
			           },
			           {
			        	   name: "taskId", index: "taskId", hidden:true, width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
			           },
			           {
			        	   name: "uri", index: "uri", hidden:true, width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
			           },
			           {
			        	   name: "requestDate", index: "requestDate", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false,  editable: true, editoptions: { size: 40 }
			           }, 
			           {
			        	   name: "taskDate", index: "taskDate", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false,editable: true, editoptions: { size: 40 }
			           },
						{
							name: "startUserId", hidden:true, index: "startUserId",width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
						}  ,              
			           {
			        	   name: "activitiNo",index: "activitiNo",width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
			           }  ,              
			           {
			        	   name: "name",index: "name",width: 40, hidden:true, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
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
			        	   var uris = $("#gridTable").jqGrid('getCol', 'uri', true);
			        	   var startUserIds = $("#gridTable").jqGrid('getCol', 'startUserId', true);
			        	   var titles = $("#gridTable").jqGrid('getCol', 'title', true);
			        	   var names = $("#gridTable").jqGrid('getCol', 'name', true);
			        	   for (var i = 0; i < ids.length; i++) {
			        		   var space = "|";
			        		   var id = ids[i].id;
			        		   var activitiNo = activitiNos[i].value;
			        		   var uri = uris[i].value;
			        		   var startUserId = startUserIds[i].value;
			        		   var title = titles[i].value;
			        		   var name = names[i].value;
			        		   var detail = "";
			        		   var completeTask = "";
			        		   var detailProcess = "";
			        		   
			        		   detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + uri+"','"+activitiNo +"')\">查看</a>";
			        		   completeTask = "<a class=\"blue\" href=\"javascript:ManagePage.GetWindow('" + id +"','"+activitiNo+"')\">审批</a>";
			        		   detailProcess  = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetailProcess('"+activitiNo +"')\">查看</a>";
			        		   if(title=="试用期评估审批" && name!="HR"){
			        			   space = "";
			        			   completeTask = "";
			        		   }
			        		   if(title=="延长试用起申请审批" && name!="延长试用期考核要求及薪资" && name!="试用期考察评定："){
			        			   space = "";
			        			   completeTask = "";
			        		   }
			        		   $("#gridTable").jqGrid("setRowData", id, { act: detail +space + completeTask });
			        		   $("#gridTable").jqGrid("setRowData", id, { actProcess: detailProcess});
			        	   }
			           }
		});
	},
	GetDetail: function (uri,activitiNo) {
		window.open($Url.BuildLoginUrl(uri)+activitiNo);
	},
	GetDetailProcess: function (activitiNo) {
		  var url = $Url.BuildWorkFlowUrl("/workFlow/processing/ajaxAuditProcess");
		  initAll.GetAuditProcess(url,activitiNo);
	},
    GetWindow:function(id,activitiNo){
    	$('#w1').window('open')
    	$(".examine").click(function(){
    		var url = $Url.BuildWorkFlowUrl("/workFlow/auditTask/ajaxAddExamine.action");
    		var uri=window.location.href;
    		var sendData={
    				per:$(this).val(),
    				id:id,
    				activitiNo:activitiNo,
    				comment:$("#taskCommet").val(),
    		};
    		$.ajax({
				type: "post",
				url: url,
				dataType: "json",
				timeout: 30000,
				data: sendData,
				beforeSend: function () {
				},
				error: function (XMLHttpRequest, textStatus, errorThrown,request) {
					alert(errorThrown);
				},
				success: function (data, textStatus) {
					alert("审批完成");
					$("#taskCommet").val("");
					$('#w1').window('close');
					window.location.reload();
					$("#examine").hide();
					
				},
				complete: function (XMLHttpRequest, textStatus) {
				}
			});
    	});
    },
    InitQuery: function () {
        $("#btnSearch").click(function () {
        	var bySelectTitle = $("#selectTitle").val();
	        var byRequestUser = $("#name").val().trim();
	        var byDate = $("#date").val();
	        
	
	        $("#gridTable").jqGrid('setGridParam', {
	            datatype: "json",
	            postData: { 
	            	"bySelectTitle": bySelectTitle,
	            	"byRequestUser": byRequestUser,
	            	"byDate":byDate
	            	},
	            page: 1
	        }).trigger("reloadGrid");
        });
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
    	/*var titleArr = ["临时招聘","延长试用期","员工辞职","人事变动","员工考勤"];
    	var op = $("<option></option>").text("全部").val("");
    	obj.append(op);
    	for (var i=0;i<titleArr.length;i++){
    		var op = $("<option></option>").text(titleArr[i]).val(titleArr[i]);
    		obj.append(op);
    	}*/
    }
}
$(function () {
    /*$("#btnAdd").click(function () { ManagePage.GetAdd(); });*/
    ManagePage.InitGrid();
    ManagePage.InitQuery();
    ManagePage.GetTitle($("#selectTitle"));
    $("#date").click(function () {
		WdatePicker({dateFmt: 'yyyy-MM-dd'});
	});
});