var ManagePage = {
    
    InitGrid: function () {
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildCustomerUrl('/customer/agentBusiness/ajaxListAgentBusiness.action'),
            editurl: $Url.BuildCustomerUrl("/customer/agentBusiness/ajaxEditAgentBusiness.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","编号","编码","企业名称","企业邮箱","企业电话","企业法人","企业网址","企业地址","联系人","联系人职位","联系人微信","联系人QQ","手机1","手机2","固话","联系人住址","重要等级","企业描述","关系等级","累计销售额","备注","负责人","录入时间"],
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
					name: "email", index: "email", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 3 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{required:true,edithidden:true,email:true}
				},
				{
					name: "telephone", index: "telephone", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true,required:true,number:true,custom:true, custom_func:ManagePage.Mytelephonecheck}
				},
				{
					name: "owner", index: "owner", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 }
				},
				{
					name: "website", index: "website", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 3 }, sortable: false, editable: true, editoptions: { size: 20 },editrules:{edithidden:true,required:false,url:true}
				},
				{
					name: "address", index: "address", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "contactPrimary", index: "contactPrimary", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },editrules:{edithidden:true,required:true}
				},
				{
					name: "contactPosition", index: "contactPosition", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 3 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "contactWeixin", index: "contactWeixin", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "contactQq", index: "contactQq", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "contactCellphone1", index: "contactCellphone1", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 3 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true,required:true,number:true,custom:true, custom_func:ManagePage.Mycellphonecheck}
				},
				{
					name: "contactCellphone2", index: "contactCellphone2", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true,required:false,number:true,custom:true, custom_func:ManagePage.Mycellphonecheck}
				},
				{
					name: "contactTelephone", index: "contactTelephone", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true,required:false,number:true,custom:true, custom_func:ManagePage.Mytelephonecheck}
				},
				{
					name: "contactAddress", index: "contactAddress", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 3 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "contactImportance", index: "contactImportance", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("dicDataforCustomerAgentBussinessImportance", $Url.BuildCustomerUrl("/common/enumList.action"))},formoptions: { rowpos: 7, colpos: 1 },sortable: false, editable: true
				},
				{
					name: "comment", index: "comment", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "relationLevel", index: "relationLevel", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("dicDataforCustomerCompanyRelationLevel", $Url.BuildCustomerUrl("/common/enumList.action"))},formoptions: { rowpos: 7, colpos: 3 },sortable: false, editable: true
				},
				{
					name: "saleTotal", index: "saleTotal", width: 40, align: "left", formoptions: { rowpos: 8, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "editComment", index: "editComment", width: 40, align: "left", formoptions: { rowpos: 8, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "managerNo", index: "managerNo", width: 40, align: "left", formatter:$Link.MakeEmployeeUrl, edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("empList", $Url.BuildCustomerUrl("/common/enumList.action"))},formoptions: { rowpos:8, colpos: 3 },sortable: false, editable: true
				},
                {
                    name: "inTime", index: "inTime", width: 40, align: "left", formoptions: { rowpos: 9, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }, formatter: "date", formatoptions: { srcformat: 'Y-m-d', newformat: 'Y-m-d' }
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
//            multiselect: true,
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
                var ids = $("#gridTable").jqGrid('getCol', 'id', true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;
                    var edit = "";
                    var details= "";
                    details = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetails('" + id + "')\">查看</a>";
                    edit = "<a class=\"blue\" href=\"javascript:ManagePage.GetEdit('" + id + "')\">编辑</a>";
                    $("#gridTable").jqGrid("setRowData", id, { act: details+"|"+edit});
                }
            }
        });
    },
    InitQuery: function () {
        $("#btnSearch").click(function () {
            var byName = $("#txtName").val();
            var byEmpNo = $("#selectEmpNo").val();
            var byImportance=$("#selectImportance").val();
            var byRelationLevel = $("#selectRelationLevel").val();
            var byFindTimeUp = $("#findTimeUp").val();
    		var byFindTimeDown = $("#findTimeDown").val();
            
            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: { 
                	"byName": byName,
                    "byEmpNo":byEmpNo,
                	"byImportance": byImportance,
                	"byRelationLevel": byRelationLevel,
            		"byFindTimeUp":byFindTimeUp,
            		"byFindTimeDown":byFindTimeDown
                },
                page: 1
            }).trigger("reloadGrid");
        });
        
       
        
    },
    GetDetail: function (index) {
        jQuery("#gridTable").jqGrid('editGridRow', index, {
             editCaption: "查看记录",
            beforeShowForm: function () {
                $(".DataTD").children().attr("disabled", "disabled");
                $(".EditButton").html("");
				$(".FormData:last").after('<tr class="h30"><td ></td></tr>');
            }, afterShowForm: function () {
            }
        });
    },
    GetDetails: function (id) {
    	$EasyUI.NewTab("Detail", $Url.BuildCustomerUrl("/customer/agentBusiness/detail?id=" + id));
    },
    GetEdit: function (id) {
    	$EasyUI.NewTab("Edit", $Url.BuildCustomerUrl("/customer/agentBusiness/edit?id=" + id));
    },
    GetAdd: function () {
    	$EasyUI.NewTab("New", $Url.BuildCustomerUrl("/customer/agentBusiness/edit"));
    },
    ShowPoint:function(){
    	var empName = $("#name").parent().prev().text();
    	$("#name").parent().prev().html(empName + "<em class='color'>*</em>");
    	var emailName = $("#email").parent().prev().text();
    	$("#email").parent().prev().html(emailName + "<em class='color'>*</em>");
    	var telephoneName = $("#telephone").parent().prev().text();
    	$("#telephone").parent().prev().html(telephoneName + "<em class='color'>*</em>");
    	var contactPrimaryName = $("#contactPrimary").parent().prev().text();
    	$("#contactPrimary").parent().prev().html(contactPrimaryName + "<em class='color'>*</em>");
    	var contactCellphone1Name = $("#contactCellphone1").parent().prev().text();
    	$("#contactCellphone1").parent().prev().html(contactCellphone1Name + "<em class='color'>*</em>");
    	
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
    		return [false,"请输入正确的手机格式!"]; 
    }
}


$(function () {
    $("#btnAdd").click(function () { ManagePage.GetAdd(); });
    EnumList.GetEnumListToSelect($("#selectEmpNo"),"empManagerAll",$Url.BuildCustomerUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#selectRelationLevel"), "dicDataforCustomerCompanyRelationLevelAll", $Url.BuildCustomerUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#selectImportance"), "dicDataforCustomerAgentBussinessImportanceAll", $Url.BuildCustomerUrl("/common/enumList.action"));
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
        var byImportance=$("#selectImportance").val();
        var byRelationLevel = $("#selectRelationLevel").val();
        var byFindTimeUp = $("#findTimeUp").val();
		var byFindTimeDown = $("#findTimeDown").val();
        var url = $Url.BuildCustomerUrl("/customer/agentBusiness/ajaxExportExcel");
        location.href= url+"?"+
		"showAllList="+ElementVar.showAllList+"&"+
		"sord=desc"+"&"+
		"sidx=id"+"&"+
        "isSales=1&"
		"byName="+ byName+"&"+
        "byEmpNo="+byEmpNo+"&"+
        "byRelationLevel="+ byRelationLevel+"&"+
		"byFindTimeUp="+byFindTimeUp+"&"+
		"byFindTimeDown="+byFindTimeDown+"&"+
		"byImportance="+byImportance;
    });
    $("#btnSendLetter").click(function () {
        var url = $Url.BuildCustomerUrl("/sendLetter");
    	location.href= url;
    });
});