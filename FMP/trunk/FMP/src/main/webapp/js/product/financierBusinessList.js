var ManagePage = {
	RequireMoneyTotalFormat: function (cellvalue, options, rowObject) {
	        if (cellvalue == 0){
	            return "";
	        }else{
	        	return cellvalue;
	        }
	    },
	RequireMoneyTotalUnFormat: function (cellvalue, options, cell) {
	    	if (cellvalue=="") {
	    		return "";
			}else{
				return cellvalue;
			}
	},
    DateInputElem: function (value, options) {
        var el = document.createElement("input");
        el.type = "text";
        el.value = value;
        el.onclick = function () { el.focus(); el.select(); WdatePicker({ dateFmt: 'yyyy-MM-dd' }); };//HH:mm:ss
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
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildProductUrl('/product/financierBusiness/ajaxListFinancierBusiness.action'),
            editurl: $Url.BuildProductUrl("/product/financierBusiness/ajaxEditFinancierBusiness.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","编号","编码","公司名称","公司法人","公司电话","关系等级","重要程度","传真","邮编","网站","邮箱","开户行名称","开户行地址","银行账户","公司地址","主要联系人","联系人手机1","联系人手机2","联系人固话","联系人职位","联系人微信","联系人QQ","联系人住址","融资需求额度","融资需求时间","融资需求描述","公司执照编号","机构代码编号","简述","负责人","修改备注"],
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
					name: "owner", index: "owner", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 3 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "telephone", index: "telephone", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true,required:false,number:true,custom:true, custom_func:ManagePage.Mytelephonecheck}
				},
				{
					name: "relationLevel", index: "relationLevel", width: 40, align: "left",formoptions: { rowpos: 3, colpos: 2 },sortable: false, editable: true
                    ,formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("dicDataforCustomerCompanyRelationLevel", $Url.BuildProductUrl("/common/enumList.action"))}
				},
				{
					name: "contactImportance", index: "contactImportance", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("dicDataforCustomerAgentBussinessImportance", $Url.BuildProductUrl("/common/enumList.action"))},formoptions: { rowpos: 3, colpos: 3 },sortable: false, editable: true
				},
				{
					name: "fax", index: "fax", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "postcode", index: "postcode", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "website", index: "website", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 3 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true,required:false,url:true}
				},
				{
					name: "email", index: "email", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },editrules:{required:false,email:true}
				},
				{
					name: "bankName", index: "bankName", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "bankAddress", index: "bankAddress", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 3 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "bankAccount", index: "bankAccount", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "address", index: "address", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "contactPrimary", index: "contactPrimary", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 3 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "contactCellphone1", index: "contactCellphone1", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true,required:false,number:true,custom:true, custom_func:ManagePage.Mycellphone1check}
				},
				{
					name: "contactCellphone2", index: "contactCellphone2", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true,required:false,number:true,custom:true, custom_func:ManagePage.Mycellphone2check}
				},
				{
					name: "contactTelephone", index: "contactTelephone", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 3 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true,required:false,number:true,custom:true, custom_func:ManagePage.MycontactTelephonecheck}
				},
				{
					name: "contactPosition", index: "contactPosition", width: 40, align: "left", formoptions: { rowpos: 8, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true,required:false}
				},
				{
					name: "contactWeinxin", index: "contactWeinxin", width: 40, align: "left", formoptions: { rowpos: 8, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "contactQq", index: "contactQq", width: 40, align: "left", formoptions: { rowpos: 8, colpos: 3 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "contactAddress", index: "contactAddress", width: 40, align: "left", formoptions: { rowpos: 9, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "requireMoneyTotal", index: "requireMoneyTotal", width: 40, align: "left", formoptions: { rowpos: 9, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },formatter: ManagePage.RequireMoneyTotalFormat, unformat: ManagePage.RequireMoneyTotalUnFormat,editrules:{required:true},hidden:true
				},
				{
					name: "requireTime", index: "requireTime", width: 40, align: "left", formatter:"date",formoptions: { rowpos: 9, colpos: 3 }, sortable: false, formatoptions: { srcformat: 'Y-m-d', newformat: 'Y-m-d' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 20 }//H:i:s
				},
				{
					name: "requireComment", index: "requireComment", width: 40, align: "left", formoptions: { rowpos: 10, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "permitNumber", index: "permitNumber", width: 40, align: "left", formoptions: { rowpos: 10, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "organizationNumber", index: "organizationNumber", width: 40, align: "left", formoptions: { rowpos: 10, colpos: 3 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "comment", index: "comment", width: 40, align: "left", formoptions: { rowpos: 11, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true,required:false}
				},
				{
					name: "managerNo", index: "managerNo", width: 40, align: "left", formatter:$Link.MakeEmployeeUrl, edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("empList", $Url.BuildProductUrl("/common/enumList.action"))},formoptions: { rowpos: 11, colpos: 3 },sortable: false, editable: true
				},
				{
					name: "editComment", index: "editComment", width: 40, align: "left", formoptions: { rowpos: 11, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
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
                var ids = $("#gridTable").jqGrid('getCol', 'id', true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;
                    var detail = "";
                    var edit = "";
                    edit = "<a class=\"blue\" href=\"javascript:ManagePage.GetEdit('" + id + "')\">查看</a>";
                    detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id + "')\">编辑</a>";
                    $("#gridTable").jqGrid("setRowData", id, { act: edit+"|"+detail});
                }
            }
        });
    },
    InitQuery: function () {
        $("#btnSearch").click(function () {
            var byName = $("#txtName").val();
            var byRelationLevel = $("#selectRelationLevel").val();
            var byImportance = $("#selectImportance").val();

            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: { 
                	"byName": byName,
                	"byRelationLevel": byRelationLevel,
                	"byImportance": byImportance
                	},
                page: 1
            }).trigger("reloadGrid");
        });
    },
    GetAdd:function(){
        window.open($Url.BuildProductUrl("/product/financierBusiness/edit"));
    },
    GetEdit:function(id){
        window.open($Url.BuildProductUrl("/product/financierBusiness/detail?id="+id));
    },
    GetDetail:function(id){
        window.open($Url.BuildProductUrl("/product/financierBusiness/edit?id="+id));
    },
    ShowPoint:function(){
    	var empName = $("#code").parent().next().text();
    	$("#code").parent().next().html(empName + "<em class='color'>*</em>");
    },
    Mytelephonecheck:function(value, telephone) { 
    	//var reg = /^1\d{10}$/ ;
    	var reg =  /(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$/;
    	if (reg.test(value)) 
    		return [true,"OK！"]; 
    	else 
    		return [false,"请输入正确的电话格式！"]; 
    },
    MycontactTelephonecheck:function(value,contactTelephone) { 
    	//var reg = /^1\d{10}$/ ;
    	var reg =  /(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$/;
    	if (reg.test(value)) 
    		return [true,"OK！"]; 
    	else 
    		return [false,"请输入正确的电话格式！"]; 
    },
    Mycellphone1check:function(value, contactCellphone1) { 
    	var reg = /^1\d{10}$/ ;
    	//var reg =  /(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$/;
    	if (reg.test(value)) 
    		return [true,"OK！"]; 
    	else 
    		return [false,"请输入正确的手机格式！"]; 
    },
    Mycellphone2check:function(value, contactCellphone1) { 
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
    EnumList.GetEnumListToSelect($("#selectRelationLevel"), "dicDataforCustomerCompanyRelationLevelAll", $Url.BuildProductUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#selectImportance"), "dicDataforCustomerAgentBussinessImportanceAll", $Url.BuildProductUrl("/common/enumList.action"));
    ManagePage.InitGrid();
    ManagePage.InitQuery();
});