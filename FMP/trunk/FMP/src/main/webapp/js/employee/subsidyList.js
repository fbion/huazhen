var ManagePage = {
    DateInputElem: function (value, options) {
        var el = document.createElement("input");
        el.type = "text";
        el.value = value;
        el.onclick = function () { el.focus(); el.select(); WdatePicker({ dateFmt: 'yyyy-MM' }); };
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
    	var firstShowAllList=ElementVar.showAllList;
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildEmployeeUrl('/employee/subsidy/ajaxListSubsidy.action?firstShowAllList='+firstShowAllList),
            editurl: $Url.BuildEmployeeUrl("/employee/subsidy/ajaxEditSubsidy.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","id","员工编号","员工姓名","所属部门","员工职位","金额(元)","来源","应发时间","是否发出"],
            colModel: [

				{
					name: "act", index: "act", width: 60, align: "center", sortable: false
				},
				{
					name: "id", index: "id", width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true,hidden:true, editoptions: { readonly: true, size: 40 }
				},
				{
					name: "empNo", index: "empNo", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true,hidden:true, editoptions: { size: 40 }
				},
				{
					name: "empName", index: "empName", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "deptNo", index: "deptNo", width: 40, align: "left", formatter:"select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("dept", $Url.BuildEmployeeUrl("/common/enumList.action"))}, formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true
				},
				{
					name: "positionNo", index: "positionNo", width: 40, align: "left", formatter:"select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("positionList", $Url.BuildEmployeeUrl("/common/enumList.action"))}, formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true
				},
				{
					name: "money", index: "money", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "source", index: "source", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true,hidden:true, editoptions: { size: 40 }
				},
				{
					name: "sendTime", index: "sendTime", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 },formatter:ManagePage.ToDDMMMYYYY
				},
				{
					name: "isSend", index: "isSend", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 },formatter:ManagePage.FmatterIsSend
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
                var idsForEmpNo = $("#gridTable").jqGrid('getCol', 'empNo', true);
                var idsForSendTime = $("#gridTable").jqGrid('getCol', 'sendTime', true);
                for (var i = 0; i < idsForEmpNo.length; i++) {
                	var id = idsForEmpNo[i].id;
                    var empNo = idsForEmpNo[i].value;
	                var sendTime = idsForSendTime[i].value;
	                var detail = "";

	                detail = "<a class=\"blue\" href=\"#\" onmouseover=\"ManagePage.GetDetail('" + empNo + "','"+sendTime+"')\" >查看详情</a>";
	                $("#gridTable").jqGrid("setRowData", id, { act: detail });
				}
				$("td[aria-describedby='gridTable_act']").append('<div class="welfareSubsidy p10" id="welfareSubsidy"></div>');
            }
        });
    },
    InitQuery: function () {
    	$("#btnSearch").click(function () {
            var byName = $("#txtName").val().trim();
            var bySelectDepartment = $("#selectDepartment").val();
            var bySelectPositionNo = $("#selectPositionNo").val();
            var year = $("#year").val();
            var month = $("#month").val();
            

            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: { 
                	"byName": byName,
                	"bySelectDepartment": bySelectDepartment,
                	"bySelectPositionNo": bySelectPositionNo,
                	"year":year,
                	"month":month,
                	"showAllList":ElementVar.showAllList
                	},
                page: 1
            }).trigger("reloadGrid");
        });
    },
    GetDetail: function (empNo,sendTime) {
    	
        //window.location.href = $Url.BuildEmployeeUrl("/employee/subsidy/ajaxGetInfoByEmpNoAndSendTime?empNo="+empNo+"&&sendTime="+sendTime);
    	var url = $Url.BuildEmployeeUrl("/employee/subsidy/ajaxGetInfoByEmpNoAndSendTime");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: { 
            	empNo: empNo,
            	sendTime:sendTime
            	},
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
	            	var htmlStr = null;
	            	var strat = '<table border="0" align="center">'+
				              	  '<tr>'+
						       	     '<td width="80" valign="center" align="center">员工姓名</td>'+
						       	     '<td width="80" valign="center" align="center" >所属部门</td>'+
						       	     '<td width="80" valign="center" align="center" >员工职位</td>'+
						       	     '<td width="80" valign="center" align="center" >金额(元)</td>'+
						       	     '<td width="80" valign="center" align="center" >应发时间</td>'+
						       	     '<td width="80" valign="center" align="center" >获得时间</td>'+
						       	  '</tr>';
	            	var contre1 = '<tr>'+
	           	                     '<td>';
	            	var contre2 =        '</td>'+
	            	                 '<td>';
	            	var contre3 =        '</td>'+
	            	              '</tr>';
	            	var end = '</table>';
	            	htmlStr = strat;
	            	for(var i=0;i<data.subsidyList.length;i++){
	            		htmlStr = htmlStr+contre1;
	            		htmlStr=htmlStr+data.subsidyList[i].empName+contre2+data.deptName+contre2+
	            		                data.positionName+contre2+
	            		                data.subsidyList[i].money+contre2+ManagePage.ToDDMMMYYYY(data.subsidyList[i].sendTime)+contre2+
	            		                ManagePage.ToDDMMMYYYY(data.subsidyList[i].sourceDate);
	            		htmlStr = htmlStr+contre3;
	            	}
	            	htmlStr = htmlStr+end;
	            	$('.welfareSubsidy').html(htmlStr);
					
					$(".welfareSubsidy").each(function(i){
						$(this).css({'left':'220px','top':25*i+'px','zIndex':'20000'});
					});
					$(" td[aria-describedby='gridTable_act']").mouseover(function(){
						$(this).find('.welfareSubsidy').show()
					});
					
					$(" td[aria-describedby='gridTable_act']").mouseout(function(){
						$(this).find('.welfareSubsidy').hide();
					});
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
    /*GetAdd: function () {
        window.location.href = $Url.BuildEmployeeUrl("/employee/subsidy/edit");
    },*/
    FmatterIsSend:function(cellvalue, options, rowObject){
    	if(cellvalue==""||cellvalue==0){
    		return "未发出";
    	}else{
    		return "已发出";
    	}
    },
    GetDate:function(strat,end,obj){
    	for (var i=strat;i<=end;i++){
    		var op = $("<option></option>").text(i).val(i);
    		obj.append(op);
    	}
    },
    ToDDMMMYYYY:function(date, options, rowObject) {  
        var d = new Date(date);  
        var dd = d.getDate() < 10 ? "0" + d.getDate() : d.getDate().toString(); 
        var mm = d.getMonth()+1< 10 ? "0" + (d.getMonth()+1):(d.getMonth()+1).toString();  
        var yyyy = d.getFullYear().toString();  
        return yyyy +"-"+ mm;  
    }
}

$(function () {
    /*$("#btnAdd").click(function () { ManagePage.GetAdd(); });*/
    ManagePage.InitGrid();
    ManagePage.InitQuery();
    $("#year").append($("<option></option>").text("全部").val(0));
    ManagePage.GetDate(2015,2020,$("#year"));
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

	//alert($("td[aria-describedby='gridTable_act']").length);
	//$("td[aria-describedby='gridTable_act']").append('<div class="welfareSubsidy p10" id="welfareSubsidy">aa</div>');
    /*$.fn.linkage({	//填充下拉框
        elements: [$("#selectDepartment"),$("#selectPositionNo")],
        dataTypes: ["deptAll","positionListAll"],//方法
        actionUrl: $Url.BuildEmployeeUrl("/common/enumList.action"),
        all: false
    });*/
    EnumList.GetEnumListToSelect($("#selectDepartment"), "deptAll", $Url.BuildEmployeeUrl("/common/enumList.action"));
	EnumList.GetEnumListToSelect($("#selectPositionNo"), "positionListAll", $Url.BuildEmployeeUrl("/common/enumList.action"));

    $("#selectDepartment").off().change(function(){
    	EnumList.GetEnumListToSelect($("#selectPositionNo"), "positionListBydeptTypeAll", $Url.BuildEmployeeUrl("/common/enumList.action"),$("#selectDepartment").val());
    	if($("#selectDepartment").val()==0){
    		EnumList.GetEnumListToSelect($("#selectPositionNo"), "positionListAll", $Url.BuildEmployeeUrl("/common/enumList.action"));
    	}
    });
    
    $("#btnExcel").click(function () {
    	var byName = $("#txtName").val().trim();
        var bySelectDepartment = $("#selectDepartment").val();
        var bySelectPositionNo = $("#selectPositionNo").val();
        var year = $("#year").val();
        var month = $("#month").val();
        var url = $Url.BuildEmployeeUrl("/employee/subsidy/ajaxExportExcel");
        location.href= url+"?"+
		"showAllList="+ElementVar.showAllList+"&"+
		"sord=desc"+"&"+
		"sidx=id"+"&"+
		"byName="+ byName+"&"+
        "bySelectDepartment="+bySelectDepartment+"&"+
        "bySelectPositionNo="+ bySelectPositionNo+"&"+
		"year="+year+"&"+
		"month="+month;
    });
	

});