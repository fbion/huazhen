var ManagePage = {
    
    InitGrid: function () {
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildEmployeeUrl('/employee/department/ajaxListDepartment.action'),
            editurl: $Url.BuildEmployeeUrl("/employee/department/ajaxEditDepartment.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","编号","编码","部门名称","联系电话","部门负责人","传真","备注","部门职能","上级部门","所属公司","修改备注","部门类型","部门图片路径","部门地址","地理位置图片路径","经度","纬度"],
            colModel: [

				{
					name: "act", index: "act", width: 60, align: "center", sortable: false
				},
				{
					name: "id", index: "id", width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: false, editoptions: { readonly: true, size: 20 }
				},
				{
					name: "code", index: "code", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "name", index: "name", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size:20 },editrules:{edithidden:true,required:true}
				},
				{
					name: "telephone", index: "telephone", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true,required:false,custom:true,custom_func:ManagePage.Mytelephonecheck}
				},
				{
					name: "empNo", index: "empNo", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("empListForEmp", $Url.BuildEmployeeUrl("/common/enumList.action"))},formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true
				},
				{
					name: "fax", index: "fax", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "comment", index: "comment", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "duty", index: "duty", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }
				},
				{
					name: "parentNo", index: "parentNo", width: 40, align: "left",formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("dept", $Url.BuildEmployeeUrl("/common/enumList.action"))},formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true
				},
				{
					name: "companyNo", index: "companyNo", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("empCompanylist", $Url.BuildEmployeeUrl("/common/enumList.action"))},formoptions: { rowpos: 6, colpos: 1 }, sortable: false, editable: true
				},

				{
					name: "editComment", index: "editComment", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
                {
                    name:"deptType", index:"deptType", width:40, align:"left", formatter:"select" ,edittype:"select", editoptions:{size:1,value:EnumList.GetEnumListToEdit("deptType", $Url.BuildEmployeeUrl("/common/enumList.action")) },formoptions:{rowpos:7,colpos:1},soreable:false,editable:true
                },
				{
					name: "departmentImagePath", index: "departmentImagePath", width: 40, align: "left", formoptions: { rowpos: 12, colpos: 1 }, sortable: false, editable: true,hidden:true, editoptions: { size: 40 }
				},
				{
					name: "address", index: "address", width: 40, align: "left", formoptions: { rowpos: 12, colpos: 2 }, sortable: false, editable: true,hidden:true, editoptions: { size: 40 }
				},
				{
					name: "locationImagePath", index: "locationImagePath", width: 40, align: "left", formoptions: { rowpos: 13, colpos: 1 }, sortable: false, editable: true,hidden:true, editoptions: { size: 40 }
				},
				{
					name: "longitude", index: "longitude", width: 40, align: "left", formoptions: { rowpos: 13, colpos: 2 }, sortable: false, editable: true,hidden:true, editoptions: { size: 40 }
				},
				{
					name: "latitude", index: "latitude", width: 40, align: "left", formoptions: { rowpos: 14, colpos: 1 }, sortable: false, editable: true,hidden:true, editoptions: { size: 40 }
				}
            ],
            sortname: "id",
            sortorder: "desc",
            pager: "#gridPager",
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
//                    var edit = "";

                    detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id + "')\">查看</a>";
//                    edit = "<a class=\"blue\" href=\"javascript:ManagePage.GetEdit('" + id + "')\">编辑</a>";

                    $("#gridTable").jqGrid("setRowData", id, { act: detail });//+ space + edit 
                }
            }
        });
    },
    InitQuery: function () {
        $("#btnSearch").click(function () {
            var name = $("#txtName").val();
            var companyNo = $("#selectCompany").val();

            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: {"name": name,"companyNo":companyNo},
                page: 1
            }).trigger("reloadGrid");
        });
    },
    GetDetail: function (index) {

    	 window.location.href = $Url.BuildEmployeeUrl("/employee/department/edit?id=")+index;
    },

    GetAdd: function () {
        window.location.href = $Url.BuildEmployeeUrl("/employee/department/edit");
    },
    ShowPoint:function(){
    	var empName = $("#name").parent().prev().text();
    	$("#name").parent().prev().html(empName + "<em class='color'>*</em>");
    },
    Mytelephonecheck:function(value, telephone) { 
    	//var reg = /^1\d{10}$/ ;
    	var reg =  /(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$/;
    	if (reg.test(value)) 
    		return [true,"OK！"]; 
    	else 
    		return [false,"请输入正确的电话格式！"]; 
    },
    BindCompanyAndDept: function () {
        $("#parentNo").html("");
        $("#parentNo").linkageForJqGrid({
            prev: $("#companyNo"),
            dataType: "deptListByCompany",
            actionUrl: $Url.BuildEmployeeUrl("/common/enumList.action"),
            all: false
        });
    }
    
}


$(function () {
    $("#btnAdd").click(function () { 
    	ManagePage.GetAdd(); 
    });
  
    EnumList.GetEnumListToSelect($("#selectCompany"), "empCompanylistAll", $Url.BuildEmployeeUrl("/common/enumList.action"));
    ManagePage.InitGrid();
    ManagePage.InitQuery();
});