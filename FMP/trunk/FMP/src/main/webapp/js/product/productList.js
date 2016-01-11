var ManagePage = {
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
    InitGrid: function () {
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildProductUrl('/product/product/ajaxListProduct.action'),
            editurl: $Url.BuildProductUrl("/product/product/ajaxEditProduct.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","id","产品编码","产品名称","募集规模","剩余额度","剩余小额","产品类型","付息方式","存续期（月）","发行机构","产品状态","产品经理","审核流程"],
            colModel: [

				{
					name: "act", index: "act", width: 60, align: "center", sortable: false
				},
				{
					name: "id", index: "id", width: 20, align: "center", sorttype: "number", editable: true, editoptions: { readonly: true, size: 20 }
				},
				{
					name: "code", index: "code", width: 40, align: "left", sortable: false, editable: true, editoptions: { size: 20 }
				},
				{
					name: "name", index: "name", width: 40, align: "left", sortable: false, editable: true, editoptions: { size: 20 }
				},
				{
					name: "sumMoney", index: "sumMoney", width: 40, align: "left", sortable: false, editable: true, editoptions: { size: 20 }
				},
				{
					name: "remainAmount", index: "remainAmount", width: 40, align: "left", sortable: false, editable: true, editoptions: { size: 20 }
				},
				{
					name: "remainSmall", index: "remainSmall", width: 40, align: "left", sortable: false, editable: true, editoptions: { size: 20 }
				},
				{
					name: "type", index: "type", width: 40, align: "left",formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("productType", $Url.BuildProductUrl("/common/enumList.action"))},sortable: false, editable: true
				},
				{
					name: "payType", index: "payType", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("payType", $Url.BuildProductUrl("/common/enumList.action"))},sortable: false, editable: true
				},
				{
					name: "deadLine", index: "deadLine", width: 40, align: "left", sortable: false, editable: true, editoptions: { size: 20 }
				},
				{
					name: "issuerNo", index: "issuerNo", width: 40, align: "left",formatter: $Link.MakePartnerIssuerUrl, edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("issuerNo", $Url.BuildPermissionUrl("/common/enumList.action"))}, sortable: false, editable: true
				},
				{
					name: "status", index: "status", width: 40, align: "left",formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("productStatus", $Url.BuildPermissionUrl("/common/enumList.action"))}, sortable: false, editable: true
				},
				{
					name: "empNo", index: "empNo", width: 40, align: "left",formatter: $Link.MakeEmployeeUrl, edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("empList", $Url.BuildPermissionUrl("/common/enumList.action"))}, sortable: false, editable: true
				},
                {
					name: "activitiNo", index: "activitiNo", width: 40, align: "left",hidden:true, editoptions: { size: 20}, sortable: false, editable: true
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
                var empNos = $("#gridTable").jqGrid('getCol', 'empNo', true);
                var activitiNos = $("#gridTable").jqGrid('getCol', 'activitiNo', true);
                var statuses = $("#gridTable").jqGrid('getCol', 'status', true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;
                    var emp = $(empNos[i].value).attr('ref');
                    var activitiNo = activitiNos[i].value;
                    var status = statuses[i].value;
                    if(status=="30"){//在售
                    	$("#gridTable #"+id+" td[aria-describedby='gridTable_status']").addClass("colorBlue");
                    }
//                    else if(status=="40"){//存续
//                    	$("#gridTable #"+id).addClass("colorBluex");
//                    }else if(status=="50" || status=="55"){//结束、取消
//                    	$("#gridTable #"+id).addClass("colorGray");
//                    }
                    var detail = "";
                    var edit = "";

                    detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id + "','"+emp+"','"+activitiNo+"')\">查看</a>";
                    edit = "<a class=\"blue\" href=\"javascript:ManagePage.GetEdit('" + id + "','"+emp+"','"+activitiNo+"')\">编辑</a>";

                    $("#gridTable").jqGrid("setRowData", id, { act: detail+space+edit});
                }
            }
        });
    },
    InitQuery: function () {
        $("#btnSearch").click(function () {
            var byName = $("#txtName").val();
            var byStatus = $("#selectStatus").val();
            var byType = $("#selectType").val();


            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: { 
                	"byName": byName,
                	"byStatus": byStatus,
                	"byType": byType
                	},
                page: 1
            }).trigger("reloadGrid");
        });
    },
    GetDetail: function (id,emp,activitiNo) {
        window.open($Url.BuildProductUrl("/product/product/detail?id="+id +"&empNo="+emp+"&activitiNo="+activitiNo));
    },
    GetEdit: function (id,emp,activitiNo) {
        window.open($Url.BuildProductUrl("/product/product/edit?id="+id +"&empNo="+emp+"&activitiNo="+activitiNo));
    },
    GetAdd: function () {
        if($("#btnAdd").length > 0){
            $("#btnAdd").click(function(){
                window.open($Url.BuildProductUrl("/product/product/edit"));
            });
        }
    }
}

$(function () {
	ManagePage.GetAdd();
    EnumList.GetEnumListToSelect($("#selectType"), "productTypeAll", $Url.BuildProductUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#selectStatus"), "productStatusAll", $Url.BuildProductUrl("/common/enumList.action"));

    ManagePage.InitGrid();
    ManagePage.InitQuery();
});