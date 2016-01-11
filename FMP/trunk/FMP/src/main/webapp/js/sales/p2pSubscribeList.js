var ManagePage = {
    BindStoreNo:function(){
        $("#byEmpNo").html("");
        $("#byEmpNo").linkageForJqGrid({
            prev:$("#byDeptNo"),
            dataType:"wealthManagers",
            actionUrl: $Url.BuildEmployeeUrl("/common/enumList.action"),
            all:true
        });
    },
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
        $("#gridTable").jqGrid({
            url: $Url.BuildSalesUrl('/sales/p2pSubscribe/ajaxListP2pSubscribe.action'),
            editurl: $Url.BuildSalesUrl("/sales/p2pSubscribe/ajaxEditP2pSubscribe.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","ID","产品","用户","名字","手机号","省","市","区","地址","门店","证件类型","证件号","金额","理财经理", "自然人客户","预约状态","访问时间","访问结果","测试"],
            colModel: [

				{
					name: "act", index: "act", width: 60, align: "center", sortable: false
				},
				{
					name: "id", index: "id", width: 20, align: "center", hidden:true, sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
				},
                {
                    name: "p2pProductNo", index: "p2pProductNo", width: 40, align: "left", formoptions: { rowpos: 10, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 },formatter: "select", edittype: "select",editoptions: { size: 1, value: EnumList.GetEnumListToEdit("p2pProductList", $Url.BuildSalesUrl("/common/enumList.action"))}
                },
                {
					name: "p2pCustomer", index: "p2pCustomer", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 },formatter: "select", edittype: "select",editoptions: { size: 1, value: EnumList.GetEnumListToEdit("p2pCustomerList", $Url.BuildSalesUrl("/common/enumList.action"))}
				},
				{
					name: "realName", index: "realName", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "cellphone", index: "cellphone", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "provinceNo", index: "provinceNo", width: 40, align: "left", hidden:true,editrules:{edithidden:true}, formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 },formatter: "select", edittype: "select",editoptions: { size: 1, value: EnumList.GetEnumListToEdit("province", $Url.BuildSalesUrl("/common/enumList.action"))}
				},
				{
					name: "cityNo", index: "cityNo", width: 40, align: "left", hidden:true,editrules:{edithidden:true}, formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }, editrules: {edithidden: true}, formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("city", $Url.BuildSalesUrl("/common/enumList.action"))}
				},
				{
					name: "districtNo", index: "districtNo", width: 40, align: "left", hidden:true,editrules:{edithidden:true}, formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }, formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("district", $Url.BuildSalesUrl("/common/enumList.action"))}
				},
				{
					name: "address", index: "address", width: 40, align: "left", hidden:true,editrules:{edithidden:true}, formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "deptNo", index: "deptNo", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 },formatter: "select", edittype: "select",editoptions: { size: 1, value: EnumList.GetEnumListToEdit("store", $Url.BuildSalesUrl("/common/enumList.action"))}
				},
				{
					name: "cardType", index: "cardType", width: 40, align: "left", hidden:true, formoptions: { rowpos: 6, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "cardNumber", index: "cardNumber", width: 40, align: "left",editrules:{edithidden:true},  formoptions: { rowpos: 6, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 60 }
				},
				{
					name: "amount", index: "amount", width: 40, align: "left", editrules:{edithidden:true},formoptions: { rowpos: 7, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "empNo", index: "empNo", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 },formatter: "select", edittype: "select",editoptions: { size: 1, value: EnumList.GetEnumListToEdit("empListJq", $Url.BuildSalesUrl("/common/enumList.action"))}
				},
                {
                    name: "customerNo", index: "customerNo", width: 40, align: "left", formoptions: { rowpos: 12, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }, editrules: {edithidden: true} ,formatter: "select", edittype: "select",editoptions: { size: 1, value: EnumList.GetEnumListToEdit("customerPerson", $Url.BuildSalesUrl("/common/enumList.action"))}
                },
				{
					name: "status", index: "status", width: 40, align: "left", formoptions: { rowpos: 8, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 },formatter: "select", edittype: "select",editoptions: { size: 1, value: EnumList.GetEnumListToEdit("orderStatus", $Url.BuildSalesUrl("/common/enumList.action"))}
				},
				{
					name: "visitTime", index: "visitTime", width: 40, align: "left", formoptions: { rowpos: 8, colpos: 2 }, sortable: false, formatter: "date", formatoptions: { srcformat: 'Y-m-d', newformat: 'Y-m-d'}, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 }
				},
				{
					name: "result", index: "result", width: 40, align: "left", hidden:true, formoptions: { rowpos: 9, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "isTest", index: "isTest", width: 40, align: "left", hidden:true, formoptions: { rowpos: 9, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				}
            ],
            sortname: "id",
            sortorder: "desc",
            viewrecords: true,
            rowNum: 10,
            rowList: [10,20,40],
            altclass: "altRowsColour",
            shrinkToFit:true,
            autowidth: true,
            height: "auto",
// multiselect: true,
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
                var space = "   ";
//                var link = $Url.BuildSalesUrl("/sales/p2pSubscribe/assignEmpNo.action");
                var ids = $("#gridTable").jqGrid('getCol', 'id', true);
                var realNames = $("#gridTable").jqGrid('getCol','realName',true);
                var p2pCustomers = $("#gridTable").jqGrid('getCol','p2pCustomer',true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;
                    var realName = realNames[i].value;
                    var p2pCustomer = p2pCustomers[i].value;
                    var operate = "";
                    var detail = "";
                    var bindCustomer = "";
                    var assign = "";
                    if (RoleVar.CurrentRole == RoleVar.RoleStore || RoleVar.CurrentRole == RoleVar.RoleVp) {
                        if ($("#" + id + " td[aria-describedby='gridTable_status']").text() == "预约中") {
                            operate = "<a class=\"blue\" href=\"javascript:ManagePage.GetEdit('" + id + "')\">受理</a>";
                        }
                        if($("#" + id + " td[aria-describedby='gridTable_customerNo']").text() == 0) {
                            bindCustomer = "<a class=\"blue\" id=\"customer_"+id+"\" href=\"javascript:void(0)\">绑定</a>";
                        }
                        detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id + "')\">查看</a>";
                    }
                    else{
                        if ($("#" + id + " td[aria-describedby='gridTable_status']").text() == "预约中") {
                            assign = "<a class=\"blue\" href=\"javascript:ManagePage.AssignEmp('" + id +"','"+ realName +"','"+ p2pCustomer + "')\">指定理财经理</a>";
                        }

                    }
                    $("#gridTable").jqGrid("setRowData", id, { act: operate + space + detail + space + bindCustomer + assign });
                    if ($("#customer_"+id).length>0){
                        $("#customer_"+id).click(function(){
                            var id = $(this).attr("id").split("_")[1];
                            var rowData = $("#gridTable").jqGrid('getRowData',id);
                            ManagePage.GetCustomer(rowData);
                        });
                    }
                }

            }
        });
    },
    InitQuery: function () {
        $("#btnSearch").click(function () {
            // var byName = $("#byName").val();
        	var byP2pProductNo = $("#byP2pProductNo").val();
        	var byP2pCustomerNo = $("#byP2pCustomerNo").val();
        	var byDeptNo = $("#byDeptNo").val();
        	var byEmpNo = $("#byEmpNo").val();
        	var byStatus = $("#byStatus").val();
            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: {
                    "byP2pProductNo" : byP2pProductNo,
                	"byP2pCustomerNo" : byP2pCustomerNo,
                	"byDeptNo" : byDeptNo,
                	"byEmpNo" : byEmpNo,
                	"byStatus" : byStatus
                },
                page: 1
            }).trigger("reloadGrid");
        });
    },
    GetDetail: function (index) {
        jQuery("#gridTable").jqGrid('editGridRow', index, {
            width: 820, editCaption: "查看记录",
            beforeShowForm: function () {
                $(".DataTD").children().attr("disabled", "disabled");
                $(".EditButton").html("");
            }, afterShowForm: function () {
            }
        });
    },
    GetEdit: function (id) {

        if(confirm("是否确认受理此预约？")){
            var url = $Url.BuildSalesUrl("/sales/p2pSubscribe/ajaxUpdateP2pSubscribeStatus");
            $.ajax({
                type : "post",
                dataType:"json",
                url : url,
                data : {
                    id : id,
                    operate : "updateP2pSubscribeStatus"
                },
                error : function(XMLHttpRequest, textStatus, errorThrown) {
                    alert(errorThrown);
                },
                success : function(data, textStatus) {
                    $("#" + id + " td[aria-describedby='gridTable_status']").text("已受理");
                    $("#" + id + " td[aria-describedby='gridTable_act']").html("");
                    $("#gridTable").trigger("click");
                    $("#btnSearch").trigger("click");
                },
                complete : function(XMLHttpRequest, textStatus) {
                }
            });
        }
    },
    GetCustomer:function(rowData){
        $("#bindCustomer").window('open');
        $(".window").css("z-index", "940");
        $(".window-shadow").css("z-index", "900");
        CustomerPage.InitGrid(rowData);
        $("div[class='panel-body panel-body-noheader layout-body']").css("height", "auto");
    },
    AssignEmp:function(id,realName,p2pCustomer){
        window.location.href=$Url.BuildSalesUrl("/sales/p2pSubscribe/assignEmpNo.action")+"?p2pSubscribe="+id+"&realName="+realName+"&p2pCustomer="+p2pCustomer;
    }
}
var CustomerPage = {
    InitGrid: function (rowData) {
        if ($String.Trim($("#gridTableCustomer").html()) != "") {
            $("#gridTableCustomer").jqGrid('setGridParam', {
                datatype: "json",
                page: 1
            }).trigger("reloadGrid");
        }
        else {
            $("#gridTableCustomer").jqGrid({
                url: $Url.BuildCustomerUrl('/customer/customerPersonal/ajaxListMyCustomerPersonal.action?cellphone='+rowData.cellphone+"&cardNumber="+rowData.cardNumber+"&realName="+rowData.realName),
                datatype: "json",
                mtype: 'GET',
                colNames: ["操作","ID", "证件类型", "证件号码", "客户姓名", "邮箱", "微信", "QQ", "联系电话", "手机1", "手机2", "客户住址",  "负责人", "备注"],
                colModel: [
                    {
                        name: "act", index: "act", width: 60, align: "center", sortable: false
                    },
                    {
                        name: "id", index: "id", width: 20, align: "center", hidden:true, sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: false, editoptions: { readonly: true, size: 20 }
                    },
                    {
                        name: "cardType", index: "cardType", width: 40, align: "center", formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("dicDataforCustomerCompanyCardType", $Url.BuildBaseInfoUrl("/common/enumList.action"))}, formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editrules: {edithidden: true}
                    },
                    {
                        name: "cardNumber", index: "cardNumber", width: 40, align: "center", formoptions: { rowpos: 2, colpos: 3 }, sortable: false, editable: true, editoptions: { size: 20 }, editrules: {edithidden: true, required: false, number: false, custom: true, custom_func: ManagePage.MyCardCheck}
                    },
                    {
                        name: "name", index: "name", width: 40, align: "center", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }, editrules: {required: true}
                    },
                    {
                        name: "email", index: "email", width: 40, align: "center", formoptions: { rowpos: 3, colpos: 3 }, sortable: false, editable: true, editoptions: { size: 20 },editrules: {edithidden: true, required: false, email: true}
                    },
                    {
                        name: "weixin", index: "weixin", width: 40, align: "center", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }, editrules: {edithidden: true}
                    },
                    {
                        name: "qq", index: "qq", width: 40, align: "center", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 }, editrules: {edithidden: true}
                    },
                    {
                        name: "phone", index: "phone", width: 40, align: "center", formoptions: { rowpos: 4, colpos: 3 }, sortable: false, editable: true, editoptions: { size: 20 }, editrules: {edithidden: true, required: true, custom: true, custom_func: ManagePage.Mytelephonecheck}
                    },
                    {
                        name: "cellphone1", index: "cellphone1", width: 40, align: "center", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }, editrules: {edithidden: true, required: false, custom: true, custom_func: ManagePage.Mycellphonecheck}
                    },
                    {
                        name: "cellphone2", index: "cellphone2", width: 40, align: "center", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 }, editrules: {edithidden: true, required: false, custom: true, custom_func: ManagePage.Mycellphonecheck}
                    },
                    {
                        name: "address", index: "address", width: 40, align: "center", formoptions: { rowpos: 6, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }, editrules: {edithidden: true}
                    },
                    {
                        name: "agentNo", index: "agentNo", width: 40, align: "center", formatter: "select", edittype: "select", editoptions: {size: 1, value: EnumList.GetEnumListToEdit("empManager", $Url.BuildSalesUrl("/common/enumList.action"))}, formoptions: { rowpos: 8, colpos: 1 }, sortable: false, editable: true
                    },
                    {
                        name: "editComment", index: "editComment", width: 40, align: "center", formoptions: { rowpos: 9, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }, editrules: {edithidden: true}
                    }
                ],
                sortname: "id",
                sortorder: "desc",
                pager: "#gridPagerCustomerPager",
                viewrecords: true,
                rowNum: 10,
                rowList: [10],
                altclass: "altRowsColour",
                shrinkToFit: true,
                autowidth: true,
                height: "auto",
//                multiselect: true,
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
                gridComplete: function () {
                    var ids = $("#gridTableCustomer").jqGrid('getCol','id',true);
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i].id;
                        var bind = "";
                        bind = "<a class=\"blue\" href=\"javascript:CustomerPage.BindCustomerPerson('"+id+"','"+rowData.id+"','"+rowData.p2pCustomer+"')\">绑定</a>";
                        $("#gridTableCustomer").jqGrid("setRowData", id, {act : bind});
                    }

                }
            });
        }

        if ($("#btnAddCustomer").length > 0) {
            $("#btnAddCustomer").off().on("click",function () {
                CustomerPage.BuildCustomerPerson(rowData);
            });
        }
    },
    BindCustomerPerson:function(id,subscribeId,p2pCustomer){
        var url = $Url.BuildCustomerUrl("/sales/p2pSubscribe/ajaxUpdateP2pSubscribeById.action");
        if(confirm("请核对信息，一经绑定不能修改！！！")){
            $.ajax({
                url:url,
                datatype:"josn",
                type:"post",
                timeout:30000,
                data:{
                    customerNo:id,
                    subscribeNo:subscribeId,
                    p2pCustomer:p2pCustomer
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(errorThrown);
                },
                success: function (data, textStatus) {
                    $("#btnSearch").trigger("click");
                    alert("绑定成功");
                    $("#bindCustomer").window('close');
                },
                complete: function (XMLHttpRequest, textStatus) {

                }
            })
        }
    },
    BuildCustomerPerson:function(rowData){
        var url = $Url.BuildCustomerUrl("/customer/customerPersonal/ajaxEditCustomerPersonal.action");
        if(confirm("是否一键创建自然人客户？")){
            $.ajax({
                url:url,
                datatype:"josn",
                type:"post",
                timeout:30000,
                data:{
                    oper:"build",
                    name:rowData.realName,
                    cellphone1:rowData.cellphone,
                    address:rowData.address,
                    cardType:rowData.cardType,
                    cardNumber:rowData.cardNumber,
                    agentNo:PageVar.UserId,
                    subscribeNo:rowData.id,
                    p2pCustomer:rowData.p2pCustomer

                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(errorThrown);
                },
                success: function (data, textStatus) {
//                    $("#btnAddCustomer").remove();
                    alert("一键创建成功");
                    $("#bindCustomer").window('close');
//                    $("#btnSearch").trigger("click");
                    window.location.reload();
                },
                complete: function (XMLHttpRequest, textStatus) {

                }
            })
        }
    }
}


$(function () {
    EnumList.GetEnumListToSelect($("#byP2pProductNo"), "p2pProductListAll", $Url.BuildSalesUrl("/common/enumList.action"));
	EnumList.GetEnumListToSelect($("#byStatus"), "orderStatusAll", $Url.BuildSalesUrl("/common/enumList.action"));
	EnumList.GetEnumListToSelect($("#byP2pCustomerNo"), "p2pCustomerListAll", $Url.BuildSalesUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#byDeptNo"), "storeAll", $Url.BuildSalesUrl("/common/enumList.action"));
    ManagePage.BindStoreNo();
    ManagePage.InitGrid();
    ManagePage.InitQuery();
});