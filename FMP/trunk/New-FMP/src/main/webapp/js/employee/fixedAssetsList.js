var ManagePage = {
    
    InitGrid: function () {
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildEmployeeUrl('/employee/fixedAssets/ajaxListFixedAssets.action'),
            editurl: $Url.BuildEmployeeUrl("/employee/fixedAssets/ajaxEditFixedAssets.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","id","分类","编号","名称","品牌","型号","CPU","内存","硬盘","数量","单价","金额","存放位置","使用部门","使用人","状态","备注"],
            colModel: [

				{
					name: "act", index: "act", width: 60, align: "center", sortable: false
				},
				{
					name: "id", index: "id", width: 20,hidden:true, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
				},
				{
					name: "assetType", index: "assetType", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, formatter: "select", edittype: "select", editoptions: {size: 1, value: EnumList.GetEnumListToEdit("assetsType", $Url.BuildSalesUrl("/common/enumList.action"))}
				},
				{
					name: "assetId", index: "assetId", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "assetName", index: "assetName", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "brand", index: "brand", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "model", index: "model", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "CPU", index: "CPU", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "memory", index: "memory", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "hardDisk", index: "hardDisk", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "count", index: "count", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "price", index: "price", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "money", index: "money", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "location", index: "location", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 2 }, sortable: false, editable: true, formatter: "select", edittype: "select", editoptions: {size: 1, value: EnumList.GetEnumListToEdit("assetsLocation", $Url.BuildSalesUrl("/common/enumList.action"))}
				},
				{
					name: "department", index: "department", width: 40, align: "left", formoptions: { rowpos: 8, colpos: 1 }, sortable: false, editable: true, formatter: "select", edittype: "select", editoptions: {size: 1, value: EnumList.GetEnumListToEdit("dept", $Url.BuildSalesUrl("/common/enumList.action"))}
				},
				{
					name: "userNo", index: "userNo", width: 40, align: "left", formoptions: { rowpos: 8, colpos: 2 }, sortable: false, editable: true, formatter: "select", edittype: "select", editoptions: {size: 1, value: EnumList.GetEnumListToEdit("empListById", $Url.BuildSalesUrl("/common/enumList.action"))}
				},
				{
					name: "status", index: "status", width: 40, align: "left", formoptions: { rowpos: 9, colpos: 1 }, sortable: false, editable: true, formatter: "select", edittype: "select", editoptions: {size: 1, value: EnumList.GetEnumListToEdit("assetsStatus", $Url.BuildSalesUrl("/common/enumList.action"))}
				},
				{
					name: "editComment", index: "editComment", width: 40, align: "left", formoptions: { rowpos: 11, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
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

                    $("#gridTable").jqGrid("setRowData", id, { act: detail +space +edit });
                }
            }
        });
    },
    InitQuery: function () {
        $("#btnSearch").click(function () {
        	var byAssetId = $("#byAssetId").val();
        	var byAssetName = $("#byAssetName").val();
        	var byAssetType = $("#byAssetType").val();
        	var byStatus = $("#byStatus").val();
        	var byLocation = $("#byLocation").val();
        	var byDepartment = $("#byDepartment").val();
        	var byUserNo = $("#byUserNo").val();


            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: { "byAssetId": byAssetId,
                			"byAssetName": byAssetName,
                			"byAssetType": byAssetType,
                			"byStatus": byStatus,
                			"byLocation": byLocation,
                			"byDepartment": byDepartment,
                			"byUserNo": byUserNo},
                page: 1
            }).trigger("reloadGrid");
        });
    },
    GetDetail: function (index) {
        $EasyUI.NewTab("Detail",$Url.BuildEmployeeUrl("/employee/fixedAssets/detail?id="+index));
        //jQuery("#gridTable").jqGrid('editGridRow', index, {
        //    width: 820, editCaption: "查看记录",
        //    beforeShowForm: function () {
        //        $(".DataTD").children().attr("disabled", "disabled");
        //        $(".EditButton").html("");
        //    }, afterShowForm: function () {
        //    }
        //});
    },
    GetEdit: function (index) {
        $EasyUI.NewTab("Edit",$Url.BuildEmployeeUrl("/employee/fixedAssets/edit?id="+index));
    //    jQuery("#gridTable").jqGrid('editGridRow', index, {
    //        width: 820, reloadAfterSubmit: true, closeAfterEdit: true,
    //        beforeShowForm: function () {
    //        }, afterShowForm: function () {
    //        }, afterSubmit: function (response, postdata) {
    //            var res = jQuery.parseJSON(response.responseText), ok = res.errDesc == "";

    //            return [ok, ok ? '' : res.errDesc];
    //        }
    //    });
    },
    GetAdd: function () {
        $EasyUI.NewTab("Add",$Url.BuildEmployeeUrl("/employee/fixedAssets/addAll"));
        //jQuery("#gridTable").jqGrid('editGridRow', "new", {
        //    width: 820, reloadAfterSubmit: true, closeAfterAdd: true, editCaption: "添加记录",
        //    beforeShowForm: function () {
        //        $("#tr_id").remove();
        //    }, afterShowForm: function () {
        //    }, afterSubmit: function (response, postdata) {
        //        var res = jQuery.parseJSON(response.responseText), ok = res.errDesc == "";

        //        return [ok, ok ? '' : res.errDesc];
        //    }
        //});
    }
}


$(function () {
    EnumList.GetEnumListToSelect($("#byAssetType"), "assetsTypeAll", $Url.BuildSalesUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#byStatus"), "assetsStatusAll", $Url.BuildSalesUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#byLocation"), "assetsLocationAll", $Url.BuildSalesUrl("/common/enumList.action"));
    $.fn.linkage({
        elements: [$("#byDepartment"), $("#byUserNo")],
        dataTypes: ["dept", "empNo"],
        actionUrl: $Url.BuildSalesUrl("/common/enumList.action"),
        all: true
    });
//	EmployeeTreeControl.startTree({
//        param: "on",  //on在职员工，out离职员工，test测试员工
//        treeInputId: "employeeSel",//员工控件框ID
//        valInputId: "byEmpNo", //员工值框id
//        inputType: "employee",//employee员工，position职位
//        idType: "userNo",        //员工empNo，userNo,职位positionNo,部门deptNo，公司companyNo
//        chkStyle: "radio",//选框类型checkbox,radio
//        nochecks:[true,true,false],      //逐级不显示单或复选框,true不显示，false显示
//        chkboxType:{Y:"ps", N:"ps"},  //Y被勾选时关联父类子类ps，N取消被勾选时关联父类子类ps
//        showPreBut: true,   //显示全部员工，在职员工按钮,离职员工，test测试员工
//        //showSearch: true,   //显示搜索框
//        showLevel:3,         //显示层级
//        sizeAuto:true,		//自动调节大小
//        width:200,			//宽，单位px
//        height:300			//高，单位px
//    });
//    EmployeeTreeControl.startTree({
//        param: "on",  //on在职员工，out离职员工，test测试员工
//        treeInputId: "departmentSel",//员工控件框ID
//        valInputId: "byDeptNo", //员工值框id
//        inputType: "employee",//employee员工，position职位
//        idType: "deptNo",        //员工empNo，userNo,职位positionNo,部门deptNo，公司companyNo
//        chkStyle: "radio",//选框类型checkbox,radio
//        nochecks:[true,false],      //逐级不显示单或复选框,true不显示，false显示
//        chkboxType:{Y:"ps", N:"ps"},  //Y被勾选时关联父类子类ps，N取消被勾选时关联父类子类ps
//        showPreBut: true,   //显示全部员工，在职员工按钮,离职员工，test测试员工
//        //showSearch: true,   //显示搜索框
//        showLevel:2,         //显示层级
//        sizeAuto:true,		//自动调节大小
//        width:200,			//宽，单位px
//        height:300			//高，单位px
//    });
    $("#btnAdd").click(function () { ManagePage.GetAdd(); });

    ManagePage.InitGrid();
    ManagePage.InitQuery();
});