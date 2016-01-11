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
    InitGrid: function () {
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildSalesUrl('/sales/income/ajaxListIncome.action'),
            editurl: $Url.BuildSalesUrl("/sales/income/ajaxEditIncome.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","ID","编号","款项名称","客户类型","客户","订单号码","应收金额","初步计算金额","实收金额","未收金额","打款日期","上游合作方","付款方式","凭证号","备注","修改备注"],//"上游类型",
            colModel: [

				{
					name: "act", index: "act", width: 60, align: "center", sortable: false
				},
				{
					name: "id", index: "id", width: 20, align: "center", hidden:true,editrules:{edithidden:true}, sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: false, editoptions: { readonly: true, size: 20 }
				},
				{
					name: "code", index: "code", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "name", index: "name", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 }
				},
				{
					name: "customerType", index: "customerType", width: 40, align: "left", formatter:"select", edittype:"select",editoptions:{size:1, value:EnumList.GetEnumListToEdit("customerType", $Url.BuildSalesUrl("/common/enumList.action"))},formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true
				},
				{
					name: "customerNo", index: "customerNo", width: 40, align: "left",formatter:"select", edittype:"select",editoptions:{size:1, value:EnumList.GetEnumListToEdit("customerNo", $Url.BuildSalesUrl("/common/enumList.action"))}, formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true
				},
				{
					name: "salesNo", index: "salesNo", width: 40, align: "left",formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }
				},
				{
					name: "incomeTotal", index: "incomeTotal", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 }
				},
				{
					name: "incomeFirst", index: "incomeFirst", width: 40, align: "left", hidden:true,editrules:{edithidden:true}, formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }
				},
				{
					name: "incomeReal", index: "incomeReal", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 }
				},
				{
					name: "incomeRemain", index: "incomeRemain", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }
				},
				{
					name: "receiveDate", index: "receiveDate", width: 40, align: "left",formatter:"date", formoptions: { rowpos: 6, colpos: 2 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 20 }
				},
//				{
//					name: "partnerType", index: "partnerType", width: 40, align: "left",formatter:"select", edittype:"select",editoptions:{size:1, value:EnumList.GetEnumListToEdit("peopleType", $Url.BuildSalesUrl("/common/enumList.action"))}, formoptions: { rowpos: 7, colpos: 1 }, sortable: false, editable: true
//				},
				{
					name: "partnerNo", index: "partnerNo", width: 40, align: "left",formatter:"select", edittype:"select",editoptions:{size:1, value:EnumList.GetEnumListToEdit("PartnerList", $Url.BuildSalesUrl("/common/enumList.action"))}, formoptions: { rowpos: 7, colpos: 1 }, sortable: false, editable: true
				},
				{
					name: "payType", index: "payType", width: 40, align: "left", hidden:true,editrules:{edithidden:true}, formatter:"select", edittype:"select",editoptions:{size:1, value:EnumList.GetEnumListToEdit("payType", $Url.BuildSalesUrl("/common/enumList.action"))},formoptions: { rowpos: 7, colpos: 2 }, sortable: false, editable: true
				},
				{
					name: "receiptNumber", index: "receiptNumber", width: 40, align: "left", hidden:true,editrules:{edithidden:true}, formoptions: { rowpos: 8, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }
				},
				{
					name: "comment", index: "comment", width: 40, align: "left", hidden:true,editrules:{edithidden:true}, formoptions: { rowpos: 8, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "editComment", index: "editComment", width: 40, align: "left", formoptions: { rowpos: 9, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
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
            var byName = $("#txtName").val();
            var byCustomerType = $("#selectCustomerType").val();
            var byCustomer = $("#selectCustomer").val();
            var byPartner = $("#selectPartner").val();


            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: { 
                	"byName": byName,
                	"byCustomerType": byCustomerType,
                	"byCustomer": byCustomer,
                	"byPartner": byPartner
                	},
                page: 1
            }).trigger("reloadGrid");
        });
    },
    GetDetail: function (index) {
        jQuery("#gridTable").jqGrid('editGridRow', index, {
            editCaption: "查看记录",
            beforeShowForm: function () {
            	ManagePage.BindCustomerNo();
                $(".DataTD").children().attr("disabled", "disabled");
                $(".EditButton").html("");
            }, afterShowForm: function () {
            }
        });
    },
    GetEdit: function (index) {
        jQuery("#gridTable").jqGrid('editGridRow', index, {
            reloadAfterSubmit: true, closeAfterEdit: true,
            beforeShowForm: function () {
            $("#code").attr("disabled","disabled");
            	ManagePage.BindCustomerNo();
            }, afterShowForm: function () {
            }, afterSubmit: function (response, postdata) {
                var res = jQuery.parseJSON(response.responseText), ok = res.errDesc == "";

                return [ok, ok ? '' : res.errDesc];
            }
        });
    },
    GetAdd: function () {
        jQuery("#gridTable").jqGrid('editGridRow', "new", {
            reloadAfterSubmit: true, closeAfterAdd: true, editCaption: "添加记录",
            beforeShowForm: function () {
                $("#tr_id").css("visibility","hidden");
                $("#code").attr("disabled","disabled");
                ManagePage.BindCustomerNo();
            }, afterShowForm: function () {
            }, afterSubmit: function (response, postdata) {
                var res = jQuery.parseJSON(response.responseText), ok = res.errDesc == "";

                return [ok, ok ? '' : res.errDesc];
            }
        });
    }
}


$(function () {
//    新建按钮去掉$("#btnAdd").click(function () { ManagePage.GetAdd(); });

    $.fn.linkage({
        elements: [$("#selectCustomerType"), $("#selectCustomer")],
        dataTypes: ["customerType", {0: "", 1: "customerPerson", 2: "customerCompany"}],
        actionUrl: $Url.BuildSalesUrl("/common/enumList.action"),
        all: true
    });
    EnumList.GetEnumListToSelect($("#selectPartner"), "PartnerListAll", $Url.BuildBaseInfoUrl("/common/enumList.action"));
    ManagePage.InitGrid();
    ManagePage.InitQuery();
});