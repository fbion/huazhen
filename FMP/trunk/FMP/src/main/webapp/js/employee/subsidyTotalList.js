var objArr = new Array();
var lastsel;
var firstEmpNo;
var ManagePage = {
    DateInputElem: function (value, options) {
        var el = document.createElement("input");
        el.type = "text";
        el.value = value;
        el.onclick = function () { el.focus(); el.select(); WdatePicker({ dateFmt: 'yyyy-MM-dd' }); };
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
    SubsidyScaleCheck:function(value,obj){
    	if (value.trim() == ""&&obj=="津贴(元)"){return [ false, obj+"不能为空!" ];}
    	var reg = /^\d+(\.{0,1}\d+){0,1}$/;
		if (reg.test(value))
			return [ true, "" ];
		else{
			//obj.focus();
			return [ false, "请输入正确的"+obj+"!" ];
		}
    },
    isEmpty:function(val,obj){
    	if(val==undefined) {return [ false, obj+"不能为空!" ];}
    	if (val.trim() != "" || val.trim().match(/^\s+$/))	{
			return [ true, "" ];
		}
			return [ false, obj+"不能为空!" ];
    },
    InitGrid: function () {
    	var lastFlag ;
    	var firstShowAllList=ElementVar.showAllList;
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildEmployeeUrl('/employee/subsidyTotal/ajaxListSubsidyTotal.action?firstShowAllList='+firstShowAllList),
            editurl: $Url.BuildEmployeeUrl("/employee/subsidyTotal/ajaxEditSubsidyTotal?oper="+"add"),
            cellurl: $Url.BuildEmployeeUrl("/employee/subsidyTotal/ajaxEditSubsidyTotal?oper="+"add"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","id","员工编号","所属部门","员工职位","员工姓名","津贴比例(%)","销售总额(元)","津贴(元)","获得时间","是否审核","操作"],
            colModel: [
				{
					name: "act", index: "act", width: 60, align: "center", sortable: false
				},
				{
					name: "id", index: "id", width: 20, align: "center", sorttype: "number",hidden:true, formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
				},
				{
					name: "empNo", index: "empNo", width: 40, align: "left",hidden:true, formoptions: { rowpos: 6, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "deptNo", index: "deptNo", width: 40, align: "left", formatter:"select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("dept", $Url.BuildEmployeeUrl("/common/enumList.action"))}, formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true,editrules :{custom : true,custom_func : ManagePage.isEmpty}
				},
				{
					name: "positionNo", index: "positionNo", width: 40, align: "left", formatter:"select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("positionList", $Url.BuildEmployeeUrl("/common/enumList.action"))}, formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true,editrules :{custom : true,custom_func : ManagePage.isEmpty}
				},
				{
					name: "empNo", index: "empName", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("empListForEmp", $Url.BuildEmployeeUrl("/common/enumList.action"))},formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true,editrules :{custom : true,custom_func : ManagePage.isEmpty}
				},
				{
					name: "subsidyScale", index: "subsidyScale", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }, editrules : { edithidden : true, required : false, custom : true, custom_func : ManagePage.SubsidyScaleCheck }
				},
				{
					name: "salesMoney", index: "salesMoney", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }, editrules : { edithidden : true, required : false, custom : true, custom_func : ManagePage.SubsidyScaleCheck }
				},
				{
					name: "subsidy", index: "subsidy", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }, editrules : { edithidden : true, custom : true, custom_func : ManagePage.SubsidyScaleCheck }
				},
				{
					name: "achieveTime", index: "achieveTime", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, formatoptions: { srcformat: 'Y-m-d', newformat: 'Y-m-d' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 },formatter:ManagePage.ToDDMMMYYYY, editrules : {edithidden : true,custom : true,custom_func : ManagePage.isEmpty}
				},
				{
					name: "isExamine", index: "isExamine", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: false, editoptions: { size: 40 },formatter:ManagePage.FmatterIsExamine
				},
				{
					name: "act1", index: "act1", width: 60, align: "center", sortable: false
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
            onSelectRow : function(id){
            	$("#"+id).addClass("ui-state-highlight");
            	if(id!=lastsel){
            		$("#"+lastsel).attr("aria-selected",false);
            	}
            	if($("#save").length>0) {
            		//if(!$("#"+id).attr("aria-selected")) {$("#"+id).click();return;}
            		ManagePage.ChangeBtuState();
            		
            	}
            	if(!isNaN(id)){
            		if(lastsel!=undefined&&lastsel!=id){
        				$("#"+lastsel).removeClass("ui-state-highlight");
            			jQuery('#gridTable').jqGrid('restoreRow',lastsel);
        			}
            		if($("#" + id + " td[aria-describedby='gridTable_isExamine']").text()!="已审核"){
	            		jQuery('#gridTable').jqGrid('editRow',id,true);
	            		lastsel=id;
            		}else{
        				$("#"+id).removeClass("ui-state-highlight");
        				jQuery('#gridTable').jqGrid('restoreRow',id);
        				alert("已审核通过不能修改！");
        			}
            		
            	}else{
            		if(id!=lastsel){
            			if(lastsel!=undefined&&parseInt(lastsel.replace(/[^0-9]/ig,""))>parseInt(id.replace(/[^0-9]/ig,""))&&isNaN(id)&&isNaN(lastsel)){
            				/*jQuery('#gridTable').jqGrid('restoreRow',lastsel); 
            				jQuery('#gridTable').jqGrid('editRow',id,true);
            				$("#gridTable").jqGrid("setRowData", id, { act1: ""});
            				lastsel=id;
            				ManagePage.SetJqgripSel();*/
            				alert("你已取消继续添加，点击行可以进行修改！");
            				$("#gridTable_ilcancel").click();
            				return;
            			}
            			
            			/*if(lastsel!=undefined){
            				$("#"+lastsel).removeClass("ui-state-highlight");
                			jQuery('#gridTable').jqGrid('restoreRow',lastsel);
            			}*/
            			
            			if($("#" + id + " td[aria-describedby='gridTable_isExamine']").text()!="已审核"){
            				jQuery('#gridTable').jqGrid('editRow',id,true);
            				
            				var save ="<span id='save'>保存</span>";
            				var span = " | "
            				var cancel="<span id='cancel'>取消</span>";
            				$("#gridTable").jqGrid("setRowData", id, { act1: save  + span + cancel});
            				if(lastsel!=undefined){
            					$("#"+lastsel).removeClass("ui-state-highlight");
                    			jQuery('#gridTable').jqGrid('restoreRow',lastsel);
            					$("#gridTable").jqGrid("setRowData", lastsel, { act1: ""});
            				}
            				//$("#gridTable_iladd").removeClass("ui-state-disabled");
            				//$("#gridTable_ilsave").addClass("ui-state-disabled");
            				
            				$("#save").off().click(function(){
            					ManagePage.ChangeBtuState();
            					$("#gridTable_ilsave").click();
            					//$("#gridTable_iladd").click();
            				});
            				$("#cancel").off().click(function(){
            					$("#gridTable_ilcancel").click();
            				});
            				lastsel=id;
            			}/*else{
            				$("#"+id).removeClass("ui-state-highlight");
            				jQuery('#gridTable').jqGrid('restoreRow',id);
            			}*/
            		}/*else{
            			//jQuery('#gridTable').jqGrid('restoreRow',lastsel); 
            			lastsel=undefined;
            		}*/
            	}
            	
            	ManagePage.SetJqgripSel();
            	/*$("select[name=deptNo]").attr("disabled",true);
            	$("select[name=positionNo]").attr("disabled",true);
            	$("select[name=empNo]").off().change(function(){
            		var url= $Url.BuildEmployeeUrl("/employee/employee/ajaxGetEmployeeById");
            		$.ajax({
                        type: "post",
                        url: url,
                        dataType: "json",
                        timeout: 30000,
                        data: {
                           id: $("select[name=empNo]").val()
                        },
                        error: function (XMLHttpRequest, textStatus, errorThrown) {
                            alert(errorThrown);
                        },
                        success: function (data, textStatus) {
                            if (data.errCode == "0000") {
                            	$("select[name=deptNo]").val(data.employee.deptNo);
                            	$("select[name=positionNo]").val(data.employee.positionNo);
                            }
                        },
                        complete: function (XMLHttpRequest, textStatus) {
                           
                        }
                    });
            	});*/
            },
            gridComplete: function () {
                var ids = $("#gridTable").jqGrid('getCol', 'id', true);
                var empNos = $("#gridTable").jqGrid('getCol', 'empNo', true);
                for (var i = 0; i < ids.length; i++) {
                	var space = "";
                    var id = ids[i].id;
                    var empNo = empNos[i].value;
                    if(isNaN(Number(empNo))){
                    	empNo = firstEmpNo;
                    }
                    if(i==1){
                    	firstEmpNo =empNo;
                    }

                    var detail = "";
                    var audit = "";
                    var edit = "";
                    var space1 = "";
                    

                    //detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id + "',"+empNo+")\">查看</a>";
                    //edit = "<a class=\"blue\" href=\"javascript:ManagePage.GetEdit('" + id + "',"+empNo+")\">查看</a>";
                    var gridTable_isExamine = $("#" + id + " td[aria-describedby='gridTable_isExamine']");
                    if (gridTable_isExamine.text() == '待审核') {
                    	space = " | ";
                    	//space1 = " | ";
                    	
                    	audit = "<a class=\"blue\" href=\"javascript:ManagePage.UpdateIsExamine('" + id + "',"+empNo+")\">审核</a>";
                    }
                    
                    //$("#gridTable").jqGrid("setRowData", id, { act: detail  + space1 + edit+ space + audit});
                    //$("#gridTable").jqGrid("setRowData", id, { act:  edit+ space + audit});
                    $("#gridTable").jqGrid("setRowData", id, { act:  audit});
                    
                    
                }
            }
        });
        jQuery("#gridTable").jqGrid('navGrid',"#gridPager",{edit:false,add:false,del:false,search:false,refresh:true}); 
        jQuery("#gridTable").jqGrid('inlineNav',"#gridPager",{addtext:"批量新建",addtitle:"批量新建",savetext:"",savetitle:"",edit:false,edittext:"编辑所选纪录",canceltext:"",canceltitle:"取消",refresh:true,del:true,deltext:"删除"});
        
        $("#gridTable_ilsave").click(function(){
        	$("#gridTable_iladd").click();
        });
        $("#gridTable_ilcancel").click(function(){
        	window.location.reload();
        	//$("#refresh_gridTable").click();
        });
        $("#refresh_gridTable").hide();
        /** 设置增行按钮的click事件处理 */
	    /* $("#gridTable_iladd").bind("click", function() {
	    	 $('#gridTable').jqGrid('addRow',lastFlag);
	      　 })*/
	    /**save保存新添纪录**//*
	    $("#gridTable_ilsave").click(function(){
	    	 var selectedId = $("#gridTable").jqGrid("getGridParam", "selrow");
		  　　　 var dataRow = {　
		  　　　　　 empNo: "empNo",
		  　　　　　 deptNo: "deptNo",
		        positionNo:"positionNo",
		        subsidyScale:"subsidyScale",
		        salesMoney:"salesMoney",
		        subsidy:"subsidy",
		        achieveTime:"achieveTime",
		        isExamine:"1"
		  　　　 };　
		   	 objArr.push(dataRow);　
		  　　　 var ids = jQuery("#gridTable").jqGrid('getDataIDs');
		  　　　 var rowid = getMaxId(ids) + 1;
		  　　　 if (selectedId) {　　　
		  　　　　　 $("#gridTable").jqGrid("addRowData", rowid, dataRow, "after", selectedId);
		  　　　 } else {　
		  　　　　　 $("#gridTable").jqGrid("addRowData", rowid, dataRow, "last");　　
		  　　　 }
	    });*/
    },
    ChangeBtuState:function(){
    	$("#gridTable_iladd").addClass("ui-state-disabled");
		$("#gridTable_ilsave").removeClass("ui-state-disabled");
    },
    SetJqgripSel:function(){
    	var deptV = "";
    	var positionNoV = "";
    	var empNoV = "";
    	positionNoV = $("select[name='positionNo']").val();
    	empNoV = $("select[name='empNo']").val();
    	deptV = $("select[name='deptNo']").val();
    	if(positionNoV!=undefined&&empNoV!=undefined&&deptV!=undefined){
    		EnumList.GetEnumListToSelect($("select[name='positionNo']"), "positionListBydeptType1", $Url.BuildEmployeeUrl("/common/enumList.action"),deptV);
    		$("select[name='positionNo']").val(positionNoV);
    		EnumList.GetEnumListToSelect($("select[name='empNo']"), "empListByPositionNo", $Url.BuildEmployeeUrl("/common/enumList.action"),positionNoV);
    		$("select[name='empNo']").val(empNoV);
    	}
    	$("select[name='deptNo']").off().change(function(){
        	EnumList.GetEnumListToSelect($("select[name='positionNo']"), "positionListBydeptType1", $Url.BuildEmployeeUrl("/common/enumList.action"),$("select[name='deptNo']").val());
        	$("select[name='empNo']").empty();
        	EnumList.GetEnumListToSelect($("select[name='empNo']"), "empListByPositionNo", $Url.BuildEmployeeUrl("/common/enumList.action"),$("select[name='positionNo']").val());
        });
    	
    	$("select[name='positionNo']").off().change(function(){
    		EnumList.GetEnumListToSelect($("select[name='empNo']"), "empListByPositionNo", $Url.BuildEmployeeUrl("/common/enumList.action"),$("select[name='positionNo']").val());
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
            
            /*$("#byTxtNameForExcel").val(byName);
            $("#bySelectDepartmentForExcel").val(bySelectDepartment);
            $("#bySelectPositionNoForExcel").val(bySelectPositionNo);
            $("#byYearForExcel").val(year);
            $("#byMonthForExcel").val(month);*/
        });
    },
    GetDetail: function (index,empNo) {
        //window.location.href = $Url.BuildEmployeeUrl("/employee/subsidyTotal/edit?id="+index);
        jQuery("#gridTable").jqGrid('editGridRow', index, {
            width: 820, editCaption: "查看员工津贴",
            beforeShowForm: function () {
                $(".DataTD").children().attr("disabled", "disabled");
                $(".EditButton").html("");
            }, afterShowForm: function () {
            }
        });
    },
    GetEdit: function (index,empNo) {
    	window.location.href = $Url.BuildEmployeeUrl("/employee/subsidyTotal/edit?id="+index+"&&empNo="+empNo);
    	
        /*jQuery("#gridTable").jqGrid('editGridRow', index, {
            width: 820, reloadAfterSubmit: true, closeAfterEdit: true,
            beforeShowForm: function () {
            }, afterShowForm: function () {
            }, afterSubmit: function (response, postdata) {
                var res = jQuery.parseJSON(response.responseText), ok = res.errDesc == "";

                return [ok, ok ? '' : res.errDesc];
            }
        });*/
    },
    UpdateIsExamine: function (id,empNo) {
    	if (confirm("确定审核通过吗？")) {
            var url = $Url.BuildSalesUrl("/employee/subsidyTotal/ajaxUpdateIsExamine.action");
            if(isNaN(id)){
            	if(confirm("刷新后才能继续操作！")){
            		window.location.reload();
            	}
            }else{
            	$.ajax({
            		type : "post",
            		url : url,
            		data : {
            			id : id
            		},
            		beforeSend : function() {
            		},
            		error : function(XMLHttpRequest, textStatus, errorThrown) {
            			alert(errorThrown);
            		},
            		success : function(data, textStatus) {
            			var gridTable_isExamine = $("#" + id + " td[aria-describedby='gridTable_isExamine']");
            			var gridTable_act = $("#" + id + " td[aria-describedby='gridTable_act']");
            			//var detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id + "',"+empNo+")\">查看</a>";
            			gridTable_isExamine.text("已审核");
            			//var space1 = " | ";
            			var edit = "";
            			//edit = "<a class=\"blue\" href=\"javascript:ManagePage.GetEdit('" + id + "',"+empNo+")\">查看</a>";
            			//gridTable_act.html(detail + space1 + edit);
            			gridTable_act.html("");
            			/*if(!data.errCode=="NoID"&&!data.errCode=="updateIsExamine failed"){
                		gridTable_isExamine.text("已审核");
            		    gridTable_act.html(detail);
                	}*/
            		},
            		complete : function(XMLHttpRequest, textStatus) {
            		}
            	});
            }
        }
    },
    GetAdd: function () {
        window.open($Url.BuildEmployeeUrl("/employee/subsidyTotal/edit"));
        /*jQuery("#gridTable").jqGrid('editGridRow', "new", {
            width: 820, reloadAfterSubmit: true, closeAfterAdd: true, editCaption: "新建员工津贴",
            beforeShowForm: function () {
                $("#tr_id").remove();
            }, afterShowForm: function () {
            }, afterSubmit: function (response, postdata) {
                var res = jQuery.parseJSON(response.responseText), ok = res.errDesc == "";

                return [ok, ok ? '' : res.errDesc];
            }
        });*/
    },
    FmatterIsExamine:function(cellvalue, options, rowObject){
    	if(cellvalue==1){
    		return "待审核";
    	}else if(cellvalue==2){
    		return "已审核";
    	}else{
    		return "待审核";
    	}
    },
    GetDate:function(strat,end,obj){
    	for (var i=strat;i<=end;i++){
    		var op = $("<option></option>").text(i).val(i);
    		obj.append(op);
    	}
    },
    ToDDMMMYYYY:function(date, options, rowObject) {
    	if(date!=null&&date!=""){
    		var d = new Date(date);  
    		var dd = d.getDate() < 10 ? "0" + d.getDate() : d.getDate().toString(); 
    		var mm = d.getMonth()+1< 10 ? "0" + (d.getMonth()+1):(d.getMonth()+1).toString();  
    		var yyyy = d.getFullYear().toString();  
    		return yyyy +"-"+ mm;  
    	}else{
    		return "";
    	}
    }
}


$(function () {
    $("#btnAdd").click(function () { ManagePage.GetAdd(); });
    EmployeeTreeControl.startTree({
        param: "on",  //on在职员工，out离职员工，test测试员工
        treeInputId: "employeeSel",//员工控件框ID
        valInputId: "selectDepartment", //员工值框id
        inputType: "employee",//employee员工，position职位
        idType: "deptNo",        //员工empNo，userNo,职位positionNo,部门deptNo，公司companyNo
        chkStyle: "radio",//选框类型checkbox,radio
        nochecks:[true,false],      //逐级不显示单或复选框,true不显示，false显示
        chkboxType:{Y:"ps", N:"ps"},  //Y被勾选时关联父类子类ps，N取消被勾选时关联父类子类ps
        showPreBut: true,   //显示全部员工，在职员工按钮,离职员工，test测试员工
        //showSearch: true,   //显示搜索框
        showLevel:2,         //显示层级
        sizeAuto:true,		//自动调节大小
        width:200,			//宽，单位px
        height:300			//高，单位px
    });
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
    
    EnumList.GetEnumListToSelect($("#selectDepartment"), "deptAll", $Url.BuildEmployeeUrl("/common/enumList.action"));
	EnumList.GetEnumListToSelect($("#selectPositionNo"), "positionListAll", $Url.BuildEmployeeUrl("/common/enumList.action"));

    $("#selectDepartment").off().change(function(){
    	EnumList.GetEnumListToSelect($("#selectPositionNo"), "positionListBydeptTypeAll", $Url.BuildEmployeeUrl("/common/enumList.action"),$("#selectDepartment").val());
    	if($("#selectDepartment").val()==0){
    		EnumList.GetEnumListToSelect($("#selectPositionNo"), "positionListAll", $Url.BuildEmployeeUrl("/common/enumList.action"));
    	}
    });
    
    $("#btnExcel").click(function () {
    	/*
    	var condition = {
    			empName:$("#byTxtNameForExcel").val(),
    			deptNo:$("#bySelectDepartmentForExcel").val(),
    			positionNo:$("#bySelectPositionNoForExcel").val(),
    			year:$("#byYearForExcel").val(),
    			month:$("#byMonthForExcel").val()
            }
        var url = $Url.BuildCustomerUrl("/employee/subsidyTotal/ajaxExportExcel");
    	location.href= url+"?condition="+JSON.stringify(condition)+"&"+"excelType="+"subsidyTotal"+"&"+"showAllList="+ElementVar.showAllList;*/
    	var byName = $("#txtName").val().trim();
        var bySelectDepartment = $("#selectDepartment").val();
        var bySelectPositionNo = $("#selectPositionNo").val();
        var year = $("#year").val();
        var month = $("#month").val();
        var url = $Url.BuildEmployeeUrl("/employee/subsidyTotal/ajaxExportExcel");
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