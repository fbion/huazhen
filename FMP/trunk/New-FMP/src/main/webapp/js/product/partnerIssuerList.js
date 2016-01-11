var ManagePage = {
    
    InitGrid: function () {
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildProductUrl('/product/partnerIssuer/ajaxListPartnerIssuer.action'),
            editurl: $Url.BuildProductUrl("/product/partnerIssuer/ajaxEditPartnerIssuer.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","编号","机构编码","机构类型","机构名称","法人代表","联系人","联系人职位","负责人","联系人手机1","联系人手机2","联系人固话","联系人微信","联系人QQ","机构网址","机构地址","关系等级","重要程度","机构邮箱","发行机构简介","是否发行机构","是否销售代理","修改备注"],
            colModel: [

				{
					name: "act", index: "act", width: 60, align: "center", sortable: false
				},
				{
					name: "id", index: "id", width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: false, editoptions: { readonly: true, size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "code", index: "code", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "type", index: "type", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("dicDataforProductpartnerIssuertype", $Url.BuildProductUrl("/common/enumList.action"))},formoptions: { rowpos: 2, colpos: 2 },sortable: false, editable: true
				},
				{
					name: "name", index: "name", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 3 }, sortable: false, editable: true, editoptions: { size: 20 },editrules:{required:true}
				},
				{
					name: "owner", index: "owner", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },editrules:{required:false}
				},
				{
					name: "contactPrimary", index: "contactPrimary", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },editrules:{required:true}
				},
				{
					name: "contactPosition", index: "contactPosition", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 3 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true,required:true}
				},
				{
					name: "empNo", index: "empNo", width: 40, align: "left", formatter:$Link.MakeEmployeeUrl,edittype:"select",formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 1,value:EnumList.GetEnumListToEdit("empList", $Url.BuildProductUrl("/common/enumList.action"))}
				},
				{
					name: "contactCellphone1", index: "contactCellphone1", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true,required:true,number:true,custom:true, custom_func:ManagePage.Mycellphonecheck}
				},
				{
					name: "contactCellphone2", index: "contactCellphone2", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 3 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true,required:false,number:true,custom:true, custom_func:ManagePage.Mycellphonecheck}
				},
				{
					name: "contactTelephone", index: "contactTelephone", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true,required:false,number:true,custom:true, custom_func:ManagePage.Mytelephonecheck}
				},
				{
					name: "contactWeixin", index: "contactWeixin", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "contactQq", index: "contactQq", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 3 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "website", index: "website", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },editrules:{edithidden:true,required:false,url:true}
				},
				{
					name: "address", index: "address", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "relationLevel", index: "relationLevel", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("dicDataforCustomerCompanyRelationLevel", $Url.BuildProductUrl("/common/enumList.action"))},formoptions: { rowpos: 6, colpos: 3 },sortable: false, editable: true
				},
				{
					name: "importanceLevel", index: "importanceLevel", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("dicDataforCustomerAgentBussinessImportance", $Url.BuildProductUrl("/common/enumList.action"))},formoptions: { rowpos: 7, colpos: 1 },sortable: false, editable: true
				},
				{
					name: "email", index: "email", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true,required:false,email:true}
				},
				{
					name: "comment", index: "comment", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 3 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true,required:true}
				},
				{
					name: "isIssuer", index: "isIssuer", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("isYes", $Url.BuildProductUrl("/common/enumList.action"))},formoptions: { rowpos: 8, colpos: 1 },sortable: false, editable: true,hidden:true,editrules:{edithidden:true}
				},
				{
					name: "isAgent", index: "isAgent", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("isYes", $Url.BuildProductUrl("/common/enumList.action"))},formoptions: { rowpos: 8, colpos: 2 },sortable: false, editable: true,hidden:true,editrules:{edithidden:true}
				},
				{
					name: "editComment", index: "editComment", width: 40, align: "left", formoptions: { rowpos: 8, colpos: 3 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
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
                showAllList:ElementVar.showAllList
            },
            pager: "#gridPager",
            gridComplete: function () {
                //var space = "|";
                var ids = $("#gridTable").jqGrid('getCol', 'id', true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;
                    var detail = "";
                    var edit = "";
                    detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id + "')\">编辑</a>";
                    edit = "<a class=\"blue\" href=\"javascript:ManagePage.GetEdit('" + id + "')\">查看</a>";
                    $("#gridTable").jqGrid("setRowData", id, { act: edit + "|"+detail });
                }
            }
        });
    },
    InitQuery: function () {
        $("#btnSearch").click(function () {
            var byName = $("#txtName").val();
            var byPartnerIssuertype = $("#selectPartnerIssuertype").val();
            var byRelationLevel = $("#selectRelationLevel").val();
            var byImportance = $("#selectImportance").val();
            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: { 
                	"byName": byName,
                	"byPartnerIssuertype": byPartnerIssuertype,
                	"byRelationLevel": byRelationLevel,
                	"byImportance": byImportance
                	},
                page: 1
            }).trigger("reloadGrid");
        });
    },
    GetAdd:function(){
        $EasyUI.NewTab("New", $Url.BuildProductUrl("/product/partnerIssuer/edit"));
    },
    GetDetail:function(id){
        $EasyUI.NewTab("Detail", $Url.BuildProductUrl("/product/partnerIssuer/edit?id="+id));
    },
    GetEdit:function(id){
        $EasyUI.NewTab("Edit", $Url.BuildProductUrl("/product/partnerIssuer/detail?id="+id));
    },
    ShowPoint:function(){
    	var empName = $("#code").parent().next().text();
    	$("#code").parent().next().html(empName + "<em class='color'>*</em>");
    	var empName1 = $("#name").parent().prev().text();
    	$("#name").parent().prev().html(empName1 + "<em class='color'>*</em>");
    	var empName2 = $("#contactPrimary").parent().prev().text();
    	$("#contactPrimary").parent().prev().html(empName2 + "<em class='color'>*</em>");
    	var empName3 = $("#contactPosition").parent().prev().text();
    	$("#contactPosition").parent().prev().html(empName3 + "<em class='color'>*</em>");
    	var empName4 = $("#contactCellphone1").parent().prev().text();
    	$("#contactCellphone1").parent().prev().html(empName4 + "<em class='color'>*</em>");
    	var empName5 = $("#comment").parent().prev().text();
    	$("#comment").parent().prev().html(empName5 + "<em class='color'>*</em>");
    },
    Mytelephonecheck:function(value, telephone) { 
    	//var reg = /^1\d{10}$/ ;
    	var reg =  /(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$/;
    	if (reg.test(value)) 
    		return [true,"OK！"]; 
    	else 
    		return [false,"请输入正确的电话格式！"]; 
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
    
    EnumList.GetEnumListToSelect($("#selectPartnerIssuertype"), "dicDataforProductpartnerIssuertypeAll", $Url.BuildProductUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#selectRelationLevel"), "dicDataforCustomerCompanyRelationLevelAll", $Url.BuildProductUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#selectImportance"), "dicDataforCustomerAgentBussinessImportanceAll", $Url.BuildProductUrl("/common/enumList.action"));
    ManagePage.InitGrid();
    ManagePage.InitQuery();
});