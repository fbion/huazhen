var ManagePage = {
    
    InitGrid: function () {
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildEmployeeUrl('/employee/managerEvaluation/ajaxListManagerEvaluation.action?showAllList='+ElementVar.showAllList),
            editurl: $Url.BuildEmployeeUrl("/employee/managerEvaluation/ajaxEditManagerEvaluation.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","id","姓名","公司","部门","评估事实说明","评分依据","评分","处理意见","创建时间","修改备注","审核状态","审核编号"],
            colModel: [

				{
					name: "act", index: "act", width: 60, align: "center", sortable: false
				},
				{
					name: "id", index: "id", width: 20, align: "center",hidden:true, sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
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
					name: "scoreIntroduction", index: "scoreIntroduction", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "scoreAccord", index: "scoreAccord", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "score", index: "score", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "suggestion", index: "suggestion", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "inTime", index: "inTime", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 },formatter:ManagePage.ToDDMMMYYYY
				},
				{
					name: "editComment", index: "editComment", width: 40,hidden:true, align: "left", formoptions: { rowpos: 8, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "workFlowStatus", index: "workFlowStatus", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 2 }, sortable: false, editable: true,formatter : "select", edittype : "select", editoptions : { size : 40, value : EnumList.GetEnumListToEdit("dicDicDataAttendanceStatus", $Url.BuildEmployeeUrl("/common/enumList.action")) }
				},
				{
					name: "activitiNo", index: "activitiNo", width: 40, align: "left", formoptions: { rowpos: 8, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
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
                    var activitiNo = activitiNos[i].value;
                    var detail = "";
                    var edit = "";

                    detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id +"','" +activitiNo+"')\">查看</a>";
                    //edit = "<a class=\"blue\" href=\"javascript:ManagePage.GetEdit('" + id + "')\">编辑</a>";

                    $("#gridTable").jqGrid("setRowData", id, { act: detail });
                }
            }
        });
    },
    InitQuery: function () {
    	$("#btnSearch").click(function () {
    		var byName = $("#txtName").val().trim();
	        var bySelectCompany = $("#selectCompany").val();
	        var bySelectDepartment = $("#selectDepartment").val();
	        var byactivitiStatus = $("#activitiStatus").val();
	        var byYear = $("#year").val();
	        var byMonth = $("#month").val();
	        
	
	        $("#gridTable").jqGrid('setGridParam', {
	            datatype: "json",
	            postData: { 
	            	"byName": byName,
	            	"bySelectCompany": bySelectCompany,
	            	"bySelectDepartment": bySelectDepartment,
	            	"byactivitiStatus":byactivitiStatus,
	            	"byYear":byYear,
	            	"byMonth":byMonth
	            	},
	            page: 1
	        }).trigger("reloadGrid");
        });
    },
    GetDetail: function (index,activitiNo) {
        $EasyUI.NewTab("Detail",$Url.BuildEmployeeUrl("/employee/managerEvaluation/edit?id="+index+"&activitiNo="+activitiNo));
    },
    GetAdd: function () {
        $EasyUI.NewTab("New",$Url.BuildEmployeeUrl("/employee/managerEvaluation/edit"));
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
    $("#selectCompany").off().change(function(){
		if($("#selectCompany")==1){
			EnumList.GetEnumListToSelect($("#selectDepartment"), "deptListByCompany", $Url.BuildEmployeeUrl("/common/enumList.action"),$("#selectCompany").val());
			EnumList.GetEnumListToSelect($("#positionNo"), "positionListBydeptType1", $Url.BuildEmployeeUrl("/common/enumList.action"),$("#deptNo").val());
		}
    });
});