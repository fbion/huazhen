var ManagePage = {
		CustomerPersonList: EnumList.GetJsonEnumList("customerPerson", $Url.BuildSalesUrl("/common/enumList.action")),
	    CustomerCompanyList: EnumList.GetJsonEnumList("customerCompany", $Url.BuildSalesUrl("/common/enumList.action")),
	    AgentBusinessList:EnumList.GetJsonEnumList("agentBusiness",$Url.BuildSalesUrl("/common/enumList.action")),
	    AgentAdviserList:EnumList.GetJsonEnumList("agentAdviser",$Url.BuildSalesUrl("/common/enumList.action")),
    DateInputElem: function (value, options) {
        var el = document.createElement("input");
        el.type = "text";
        el.value = value;
        el.onclick = function () { el.focus(); el.select(); WdatePicker({ dateFmt: 'yyyy-MM-dd HH:mm:ss' }); };
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
    BindCustomerNo: function () {
        $("#customerNo").html("");
        $("#customerNo").linkageForJqGrid({
            prev: $("#customerType"),
            dataType: {0: "", 1: "customerPerson", 2: "customerCompany"},
            actionUrl: $Url.BuildSalesUrl("/common/enumList.action"),
            all: false
        });
    },
    BindEmpNo: function () {
        $("#empNo").html("");
        $("#empNo").linkageForJqGrid({
            prev: $("#deptNo"),
            dataType: "empNo",
            actionUrl: $Url.BuildSalesUrl("/common/enumList.action"),
            all: false
        });
    },
    BindAgentNo:function(){
    	$("#agentNo").html("");
    	$("#agentNo").linkageForJqGrid({
    		prev:$("#agentType"),
    		dataType:{0:"",1:"agentBusiness",2:"agentAdviser"},
    		actionUrl: $Url.BuildSalesUrl("/common/enumList.action"),
    		all:false
    	});
    },
    
    InitGrid: function () {
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildSalesUrl('/sales/agentExpense/ajaxListAgentExpense.action'),
            editurl: $Url.BuildSalesUrl("/sales/agentExpense/ajaxEditAgentExpense.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","id","打款编号","款项名称","客户类型","客户","订单","应付金额","初步计算金额","实付金额","未付金额","打款日期","下游渠道类型","下游渠道","汇款方式","凭证号","备注","修改备注"],
            colModel: [

				{
					name: "act", index: "act", width: 60, align: "center", sortable: false
				},
				{
					name: "id", index: "id", width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: false, editoptions: { readonly: true, size: 40 }
				},
				{
					name: "code", index: "code", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "name", index: "name", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "customerType", index: "customerType", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: {size: 1, value: EnumList.GetEnumListToEdit("customerType", $Url.BuildSalesUrl("/common/enumList.action"))}, formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true
				},
				{
					name: "customerNo", index: "customerNo", width: 40, align: "left", formatter: ManagePage.CustomerNoFormat, unformat: ManagePage.CustomerNoUnFormat, edittype: "select", editoptions: {size: 1,value: EnumList.GetEnumListToEdit("", $Url.BuildSalesUrl("/common/enumList.action"))}, formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true
				},
				{
					name: "salesNo", index: "salesNo", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("productList", $Url.BuildBaseInfoUrl("/common/enumList.action"))},formoptions: { rowpos: 4, colpos: 1 },sortable: false, editable: true
				},
				{
					name: "payTotal", index: "payTotal", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "payFirst", index: "payFirst", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "payReal", index: "payReal", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "payRemain", index: "payRemain", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "payDate", index: "payDate", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 2 }, sortable: false, formatter:"date",formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 }
				},
				{
					name: "agentType", index: "agentType", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: {size: 1, value: EnumList.GetEnumListToEdit("agentType", $Url.BuildSalesUrl("/common/enumList.action"))}, formoptions: { rowpos: 7, colpos: 1 }, sortable: false, editable: true
				},
				{
					name: "agentNo", index: "agentNo", width: 40, align: "left", formatter: ManagePage.AgentNoFormat, unformat: ManagePage.AgentNoUnFormat, edittype: "select", editoptions: {size: 1, value: EnumList.GetEnumListToEdit("", $Url.BuildSalesUrl("/common/enumList.action"))}, formoptions: { rowpos: 7, colpos: 2 }, sortable: false, editable: true
				},
				{
					name: "payType", index: "payType", width: 40, align: "left", formoptions: { rowpos: 8, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "receiptNumber", index: "receiptNumber", width: 40, align: "left", formoptions: { rowpos: 8, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "comment", index: "comment", width: 40, align: "left", formoptions: { rowpos: 9, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "editComment", index: "editComment", width: 40, align: "left", formoptions: { rowpos: 9, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 },hidden:true,editrules:{edithidden:true}
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
                    var edit = "";

                    detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id + "')\">查看</a>";
                    edit = "<a class=\"blue\" href=\"javascript:ManagePage.GetEdit('" + id + "')\">编辑</a>";

                    $("#gridTable").jqGrid("setRowData", id, { act: detail + space + edit });
                }
            }
        });
    },
    InitQuery: function () {
        $("#btnSearch").click(function () {
            var byCustomerType = $("#selectCustomerType").val();
        	var byCustomer = $("#selectCustomer").val();
        	var byAgentType = $("#selectAgentType").val();
        	var byAgent = $("#selectAgent").val();

            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: { 
                	"byCustomerType": byCustomerType,
                	"byCustomer": byCustomer,
                	"byAgentType": byAgentType,
                	"byAgent": byAgent
                	},
                page: 1
            }).trigger("reloadGrid");
        });
    },
    GetDetail: function (index) {
        jQuery("#gridTable").jqGrid('editGridRow', index, {
            width: 820, editCaption: "查看记录",
            beforeShowForm: function () {
            	ManagePage.BindCustomerNo();
            	ManagePage.BindAgentNo();
                $(".DataTD").children().attr("disabled", "disabled");
                $(".EditButton").html("");
            }, afterShowForm: function () {
            }
        });
    },
    GetEdit: function (index) {
        jQuery("#gridTable").jqGrid('editGridRow', index, {
            width: 820, reloadAfterSubmit: true, closeAfterEdit: true,
            beforeShowForm: function () {
            	ManagePage.BindCustomerNo();
            	ManagePage.BindAgentNo();
            	$("#code").attr("disabled","disabled");
            }, afterShowForm: function () {
            }, afterSubmit: function (response, postdata) {
                var res = jQuery.parseJSON(response.responseText), ok = res.errDesc == "";

                return [ok, ok ? '' : res.errDesc];
            }
        });
    },
    GetAdd: function () {
        jQuery("#gridTable").jqGrid('editGridRow', "new", {
            width: 820, reloadAfterSubmit: true, closeAfterAdd: true, editCaption: "添加记录",
            beforeShowForm: function () {
                $("#tr_id").css("visibility","hidden");
                $("#code").attr("disabled","disabled");
                ManagePage.BindCustomerNo();
            	ManagePage.BindAgentNo();
            }, afterShowForm: function () {
            }, afterSubmit: function (response, postdata) {
                var res = jQuery.parseJSON(response.responseText), ok = res.errDesc == "";

                return [ok, ok ? '' : res.errDesc];
            }
        });
    },
    
    CustomerNoFormat: function (cellvalue, options, rowObject) {
        if (cellvalue == "")
            return cellvalue;
        else {
            if (rowObject.customerType == 2)
                return "<div ref='"+ cellvalue+"'>" + ManagePage.CustomerCompanyList[cellvalue] + "</div>";
            else if (rowObject.customerType == 1)
                return "<div ref='"+ cellvalue+"'>" + ManagePage.CustomerPersonList[cellvalue] + "</div>";
            else
                return cellvalue;
        }
    },
    CustomerNoUnFormat: function (cellvalue, options, cell) {
        return $('div', cell).attr('ref');
    },
    AgentNoFormat: function(cellvalue,options,rowObject){
    	if(cellvalue == "")
    		return cellvalue;
    	else{
    		if(rowObject.peopleType == 2)
    			return "<div ref='" + cellvalue+"'>"+ManagePage.AgentAdviserList[cellvalue]+"</div>";
    		else if(rowObject.peopleType == 1)
    			return "<div ref='" + cellvalue+"'>"+ManagePage.AgentBusinessList[cellvalue]+"</div>";
    		else 
    			return cellvalue;
    	}
    },
    AgentNoUnFormat: function (cellvalue, options, cell) {
        return $('div', cell).attr('ref');
    }
}


$(function () {
    $("#btnAdd").click(function () { ManagePage.GetAdd(); });
    
    $.fn.linkage({
        elements: [$("#selectCustomerType"), $("#selectCustomer")],
        dataTypes: ["customerType", {0: "", 1: "customerPerson", 2: "customerCompany",3:"empNo"}],
        actionUrl: $Url.BuildSalesUrl("/common/enumList.action"),
        all: true
    });
    
    $.fn.linkage({
    	elements: [$("#selectAgentType"),$("#selectAgent")],
    	dataTypes:["agentType",{0:"",1:"agentAdviser",2:"agentBusiness"}],
    	actionUrl: $Url.BuildSalesUrl("/common/enumList.action"),
        all: true
    });
    
    
    ManagePage.InitGrid();
    ManagePage.InitQuery();
});