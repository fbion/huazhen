var ManagePage = {
    
    InitGrid: function () {
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildCustomerUrl('/customer/agentAdviser/ajaxListAgentAdviser.action'),
            editurl: $Url.BuildCustomerUrl("/customer/agentAdviser/ajaxEditAgentAdviser.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","编号","编码","姓名","邮箱","微信","QQ","手机","手机2","电话","累计销售额","个人住址","备注","负责人","录入时间"],
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
					name: "name", index: "name", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },editrules:{required:true}
				},
				{
					name: "email", index: "email", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },editrules:{required:true,email:true}
				},
				{
					name: "weixin", index: "weixin", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "qq", index: "qq", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "cellphone1", index: "cellphone1", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },editrules:{required:true,number:true,custom:true, custom_func:ManagePage.Mycellphonecheck}
				},
				{
					name: "cellphone2", index: "cellphone2", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true,required:false,number:true,custom:true,custom_func:ManagePage.Mycellphonecheck}
				},
				{
					name: "telephone", index: "telephone", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },editrules:{edithidden:true,required:false,number:true,custom:true,custom_func:ManagePage.Mytelephonecheck}
				},
				{
					name: "saleTotal", index: "saleTotal", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },editrules:{required:false,number:true}
				},
				{
					name: "address", index: "address", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "editComment", index: "editComment", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "managerNo", index: "managerNo", width: 40, align: "left", formatter:$Link.MakeEmployeeUrl, edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("empList", $Url.BuildCustomerUrl("/common/enumList.action"))},formoptions: { rowpos:7, colpos: 2 },sortable: false, editable: true
				},
                {
                    name: "inTime", index: "inTime", width: 40, align: "left", formoptions: { rowpos: 8, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }, formatter: "date", formatoptions: { srcformat: 'Y-m-d', newformat: 'Y-m-d' }
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
            postData:{
                showAllList:ElementVar.showAllList,
                isSales:1
            },
            pager: "#gridPager",
            gridComplete: function () {
                //var space = "|";
                var ids = $("#gridTable").jqGrid('getCol', 'id', true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;

                    var detail = "";
                    var edit = "";
                    detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetEdit('" + id + "')\">查看</a>";
                    edit = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id + "')\">编辑</a>";

                    $("#gridTable").jqGrid("setRowData", id, { act: detail+"|"+edit });
                }
            }
        });
    },
    InitQuery: function () {
        $("#btnSearch").click(function () {
            var byName = $("#txtName").val();
            var byEmpNo = $("#selectEmpNo").val();
            var byRelationlevel = $("#selectRelationlevel").val();
            var byFindTimeUp = $("#findTimeUp").val();
    		var byFindTimeDown = $("#findTimeDown").val();
            
            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: {
                    "byName": byName,
                    "byEmpNo":byEmpNo,
                    "byRelationLevel":byRelationlevel,
            		"byFindTimeUp":byFindTimeUp,
            		"byFindTimeDown":byFindTimeDown
            },
                page: 1
            }).trigger("reloadGrid");
            
        });
    },

    GetDetail:function(id){
    	$EasyUI.NewTab("Edit", $Url.BuildCustomerUrl("/customer/agentAdviser/edit?id="+id));
    },
    GetEdit:function(id){
    	$EasyUI.NewTab("Detail", $Url.BuildCustomerUrl("/customer/agentAdviser/detail?id="+id));
    },
    GetAdd:function () {
    	$EasyUI.NewTab("New", $Url.BuildCustomerUrl("/customer/agentAdviser/edit"));
    },
    ShowPoint:function(){
    	var name = $("#name").parent().prev().text();
    	$("#name").parent().prev().html(name + "<em class='color'>*</em>");
    	var emailName = $("#email").parent().prev().text();
    	$("#email").parent().prev().html(emailName + "<em class='color'>*</em>");
    	var cellphone1 = $("#cellphone1").parent().prev().text();
    	$("#cellphone1").parent().prev().html(cellphone1 + "<em class='color'>*</em>");
    },
    Mytelephonecheck:function(value, telephone) { 
    	//var reg = /^1\d{10}$/ ;
    	var reg =  /(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$/;
    	if (reg.test(value)) 
    		return [true,"OK！"]; 
    	else 
    		return [false,"请输入正确的电话格式!"]; 
    },
    Mycellphonecheck:function(value, telephone) { 
    	var reg = /^1\d{10}$/ ;
    	//var reg =  /(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$/;
    	if (reg.test(value)) 
    		return [true,"OK！"]; 
    	else 
    		return [false,"请输入正确的手机格式！"]; 
    }
}


$(function () {
    $("#btnAdd").click(function () { ManagePage.GetAdd(); });

    EnumList.GetEnumListToSelect($("#selectEmpNo"),"empManagerAll",$Url.BuildCustomerUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#selectRelationlevel"), "dicDataforCustomerCompanyRelationLevelAll", $Url.BuildCustomerUrl("/common/enumList.action"));
    ManagePage.InitGrid();
    ManagePage.InitQuery();
    $("#findTimeUp").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd'});
    });
    $("#findTimeDown").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd'});
    });
    
    
    $("#btnExcel").click(function () {
        var byName = $("#txtName").val();
        var byEmpNo = $("#selectEmpNo").val();
        var byRelationlevel = $("#selectRelationlevel").val();
        var byFindTimeUp = $("#findTimeUp").val();
		var byFindTimeDown = $("#findTimeDown").val();

        var url = $Url.BuildCustomerUrl("/customer/agentAdviser/ajaxExportExcel");
        location.href= url+"?"+
		"showAllList="+ElementVar.showAllList+"&"+
		"sidx=id"+"&"+
		"sord=desc"+"&"+
        "isSales=1&"+
		"byName="+byName+"&"+
		"byEmpNo="+byEmpNo+"&"+
		"byRelationLevel="+byRelationlevel+"&"+
		"byFindTimeUp="+byFindTimeUp+"&"+
		"byFindTimeDown="+byFindTimeDown;
    });
    
    
});