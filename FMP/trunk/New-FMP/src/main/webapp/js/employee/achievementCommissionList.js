var ManagePage = {
    
    InitGrid: function () {
    	var firstShowAllList=ElementVar.showAllList;
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildEmployeeUrl('/employee/achievementCommission/ajaxListAchievementCommission.action?firstShowAllList='+firstShowAllList),
            editurl: $Url.BuildEmployeeUrl("/employee/achievementCommission/ajaxEditAchievementCommission.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","id","员工编号","员工姓名","所属部门","员工职位","年份","月份","标准(万元)","销售总额(万元)","完成比例(%)","提成比例(%)","提成(元)","是否审核"],
            colModel: [

				{
					name: "act", index: "act", width: 60, align: "center", sortable: false,hidden:true
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
					name: "year", index: "year", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "month", index: "month", width: 40, align: "left", formoptions: { rowpos: 8, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "standard", index: "standard", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "salesMoney", index: "salesMoney", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "finishScale", index: "finishScale", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "commissionScale", index: "commissionScale", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "commissionMoney", index: "commissionMoney", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "isExamine", index: "isExamine", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 1 }, sortable: false, editable: true,hidden:true, editoptions: { size: 40 }
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
                var space = "|";
                var ids = $("#gridTable").jqGrid('getCol', 'id', true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;

                    var detail = "";
                    var edit = "";

                    detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id + "')\">查看</a>";
                    edit = "<a class=\"blue\" href=\"javascript:ManagePage.GetEdit('" + id + "')\">编辑</a>";

                    $("#gridTable").jqGrid("setRowData", id, { act: detail + space + edit});
                }
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
    GetDetail: function (index) {
        window.location.href = $Url.BuildEmployeeUrl("/employee/achievementCommission/edit?id="+index);
    },
    GetAdd: function () {
        window.location.href = $Url.BuildEmployeeUrl("/employee/achievementCommission/edit")
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
    ManagePage.GetDate(2015,2020,$("#year"));
    ManagePage.GetDate(1,12,$("#month"));
    
    EnumList.GetEnumListToSelect($("#selectDepartment"), "deptAll", $Url.BuildProductUrl("/common/enumList.action"));
	EnumList.GetEnumListToSelect($("#selectPositionNo"), "positionListAll", $Url.BuildProductUrl("/common/enumList.action"));

    $("#selectDepartment").off().change(function(){
    	EnumList.GetEnumListToSelect($("#selectPositionNo"), "positionListBydeptTypeAll", $Url.BuildProductUrl("/common/enumList.action"),$("#selectDepartment").val());
    	if($("#selectDepartment").val()==0){
    		EnumList.GetEnumListToSelect($("#selectPositionNo"), "positionListAll", $Url.BuildProductUrl("/common/enumList.action"));
    	}
    });
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
    $("#btnExcel").click(function () {
    	var byName = $("#txtName").val().trim();
        var bySelectDepartment = $("#selectDepartment").val();
        var bySelectPositionNo = $("#selectPositionNo").val();
        var year = $("#year").val();
        var month = $("#month").val();
        var url = $Url.BuildEmployeeUrl("/employee/achievementCommission/ajaxExportExcel");
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