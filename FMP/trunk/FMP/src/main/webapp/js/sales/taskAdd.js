/**
 * Created by paul on 15-1-26.
 */
var ManagePage = {
    AgentBusinessList: EnumList.GetJsonEnumList("agentBusinessAll", $Url.BuildSalesUrl("/common/enumList.action")),
    AgentAdviserList: EnumList.GetJsonEnumList("agentAdviserAll", $Url.BuildSalesUrl("/common/enumList.action")),
    EmpList: EnumList.GetJsonEnumList("empList", $Url.BuildSalesUrl("/common/enumList.action")),
    EmpDirectorSalesList: EnumList.GetJsonEnumList("empDirectorSalesAll", $Url.BuildSalesUrl("/common/enumList.action")),
    AgentNoFormat: function (cellvalue, options, rowObject) {
        if (cellvalue == 0)
            return "全部";
//            return "<div ref='" + cellvalue + "'>" + "全部" + "</div>";
        else {
            if (rowObject.agentType == 1)
                return "<div ref='" + cellvalue + "'>" + ManagePage.AgentBusinessList[cellvalue] + "</div>";
            else if (rowObject.agentType == 2)
                return "<div ref='" + cellvalue + "'>" + ManagePage.AgentAdviserList[cellvalue] + "</div>";
            else if (rowObject.agentType == 3)
                return "<div ref='" + cellvalue + "'>" + ManagePage.EmpDirectorSalesList[cellvalue] + "</div>";
            else
            	return cellvalue;
        }
    },
    AgentNoUnFormat: function (cellvalue, options, cell) {
        return $('div', cell).attr('ref');
    },
    AgentNoElement: function (value, options) {
        var select = $("<select />");
        $(select).linkageForJqGrid({
            prev: $("select[id$='_agentType']"),
            dataType: {0: "", 1: "agentBusiness", 2: "agentAdviser", 3: "empDirectorSales"},
            actionUrl: $Url.BuildSalesUrl("/common/enumList.action"),
            all: true
        });
        if (value != "undefined")
            $(select).val(value);
        return select;
    },
    AgentNoValue: function (elem, operation, value) {
        if (operation === 'get') {
            return $(elem).val();
        } else if (operation === 'set') {
            $(elem).val(value);
        }
    },
    FormatUpperLimit: function(value,options){
        if(value == 100000)
            return "";
        else
            return value;
    },
    UnFormatUpperLimit: function (cellvalue,options, cell) {
        if($(cell).html() == "undefined")
            return "";
        else
            return $(cell).html();
    }
}
var ReviewManage = {
    CreateReviewEditElement: function (value, editOptions) {

        var span = $("<span />");
        var label = $("<span />", { html: "待定" });
        var radio = $("<input>", { type: "radio", value: "0", name: "isOk", id: "zero", checked: (value != 1 && value != 2) });
        var label1 = $("<span />", { html: "通过" });
        var radio1 = $("<input>", { type: "radio", value: "1", name: "isOk", id: "fifty", checked: value == 1 });
        var label2 = $("<span />", { html: "不通过" });
        var radio2 = $("<input>", { type: "radio", value: "2", name: "isOk", id: "fifty", checked: value == 2 });

        span.append(label).append(radio).append(label1).append(radio1).append(label2).append(radio2);

        return span;
    },
    GetReviewElementValue: function (elem, oper, value) {
        if (oper === "set") {
            var radioButton = $(elem).find("input:radio[value='" + value + "']");
            if (radioButton.length > 0) {
                radioButton.prop("checked", true);
            }
        }

        if (oper === "get") {
            return $(elem).find("input:radio:checked").val();
        }
    },
    InitGrid: function () {
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildSalesUrl('/sales/taskDecision/ajaxListTaskDecisionByTask.action'),
            editurl: $Url.BuildSalesUrl("/sales/taskDecision/ajaxEditTaskDecision.action?productNo=" + PageVar.ProductNo),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作", "编号", "任务编号", "审核部门", "是否通过", "审核时间", "审核人", "备注"],
            colModel: [

                {
                    name: "act", index: "act", width: 60, align: "center", sortable: false
                },
                {
                    name: "id", index: "id", hidden: true, editable: false, align: "center", sorttype: "number", editrules: {edithidden: true}, editable: true, editoptions: { readonly: true, size: 40 }
                },
                {
                    name: "productTaskNo", index: "productTaskNo", hidden: true, editoptions: { readonly: true }, editrules: {edithidden: true}, editable: true
                },
                {
                    name: "depNo", index: "depNo", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: {readonly: true, size: 1, value: EnumList.GetEnumListToEdit("dept", $Url.BuildSalesUrl("/common/enumList.action"))}, sortable: false, editrules: {edithidden: true}, editable: true
                },
                {
                    name: "isOk", index: "isOk", width: 40, align: "left", formatter: "select", sortable: false, editable: true, edittype: "custom", editoptions: {value: "0:待审核;1:通过;2:不通过", custom_value: ReviewManage.GetReviewElementValue, custom_element: ReviewManage.CreateReviewEditElement }
                },
                {
                    name: "checkTime", index: "checkTime", width: 40, align: "left", sortable: false, formatter: "date", formatoptions: { srcformat: 'Y-m-d', newformat: 'Y-m-d' }, editable: false
                },
                {
                    name: "empNo", index: "empNo", width: 40, align: "left", sortable: false, formatter: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("empListJq", $Url.BuildBaseInfoUrl("/common/enumList.action")) }, editable: false
                },
                {
                    name: "editComment", index: "editComment", width: 40, align: "left", hidden: true, edittype: "textarea", sortable: false, editable: true, editoptions: { size: 40 }, editrules: {edithidden: true}
                }
            ],
            sortname: "id",
            sortorder: "desc",
            //pager: "#gridPager",
            viewrecords: true,
            //rowNum: 10,
            //rowList: [10],
            altclass: "altRowsColour",
            shrinkToFit: true,
            autowidth: true,
            height: "auto",
            multiselect: true,
            postData: {
                productTaskNo: PageVar.ID
            },
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
                var ids = $("#gridTable").jqGrid('getCol', 'id', true);
                var depts = $("#gridTable").jqGrid('getCol', 'depNo', true);
                var isOks = $("#gridTable").jqGrid('getCol', 'isOk', true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;

                    if (DEPTVar.CurrentDEPT == depts[i].value && Number(isOks[i].value) != 1) {
                        var edit = "";
                        edit = "<a class=\"blue\" href=\"javascript:ReviewManage.GetEdit('" + id + "')\">审核</a>";

                        $("#gridTable").jqGrid("setRowData", id, { act: edit });
                    }

                }
                TaskAdd.Resize();
            }
        });

    },
    GetEdit: function (index) {
        jQuery("#gridTable").jqGrid('editGridRow', index, {
            reloadAfterSubmit: true, closeAfterEdit: true,
            beforeShowForm: function () {
                $("#tr_id").hide();
                $("#tr_productTaskNo").hide();
                $("#tr_depNo").hide();
            }, afterShowForm: function () {
            }, afterSubmit: function (response, postdata) {
                var res = jQuery.parseJSON(response.responseText), ok = res.errCode == "0000";

                if (ok && res.errDesc != "") {
                    $("#status").val(res.errDesc);
                }

                return [ok, ok ? '' : res.errDesc];
            }
        });
    }
}
var IncomeRateManage = {
    InitGrid: function () {
        if ($("#incomeGridTable").length > 0) {
            $("#incomeGridTable").jqGrid({
                url: $Url.BuildSalesUrl("/product/partnerRate/ajaxListPartnerRateByProduct.action"),
                datatype: "json",
                mytype: "GET",
                colNames: ["产品","下限金额","上限金额",  "费率(%)", "附加费率(%)", "修改备注"],
                colModel: [
                    {
                        name: "productNo", index: "productNo", width: 40, align: "left", formatter: "select", edittype: 'select', editoptions: { size: 1, value: EnumList.GetEnumListToEdit("productList", $Url.BuildSalesUrl("/common/enumList.action"))}, formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true
                    },
                    /*{
                     name: "partnerNo", index: "partnerNo", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("PartnerList", $Url.BuildBaseInfoUrl("/common/enumList.action"))},formoptions: { rowpos: 3, colpos: 1 },sortable: false, editable: true
                     },*/
                    {
                        name: "lowerLimit", index: "lowerLimit", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 }
                    },
                    {
                        name: "upperLimit", index: "upperLimit", width: 40, align: "left", formatter: ManagePage.FormatUpperLimit, formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }
                    },
                    {
                        name: "rate", index: "rate", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }
                    },
                    {
                        name: "rateAdd", index: "rateAdd", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 }
                    },
                    {
                        name: "editComment", index: "editComment", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }, hidden: true, editrules: {edithidden: true}
                    }
                ],
                sortname: "id",
                sortorder: "desc",
                viewrecords: true,
                altclass: "altRowsColour",
                shrinkToFit: true,
                autowidth: true,
                height: "auto",
//                multiselect: true,
                postData: {
                    productNo: $("#productNo").val()
                },
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
                    TaskAdd.Resize();
                }
            });
        }
    }
}
var AgentRateManage = {
    InitGrid: function () {
        $("#expendGridTable").jqGrid({
            url: $Url.BuildSalesUrl('/sales/agentRate/ajaxListAgentRateByProduct.action'),
            editurl: $Url.BuildSalesUrl("/sales/agentRate/ajaxEditAgentRate.action?productNo=" + PageVar.ProductNo),
            datatype: "json",
            mytype: "GET",
            colNames: ["操作", "ID", "销售方类型", "销售方", "下限金额(万)", "上限金额(万,无上限不填)", "成本费率(%)", "操作"],
            colModel: [
                {
                    name: "act", index: "act", width: 60, align: "center", sortable: false
                },
                {
                    name: "id", index: "id", width: 20, align: "center", hidden: true, editrules: {edithidden: true}, sorttype: "number", editable: true, editoptions: { readonly: true, size: 20 }
                },
                {
                    name: "agentType", index: "agentType", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: {size: 1, value: EnumList.GetEnumListToEdit("agentType", $Url.BuildSalesUrl("/common/enumList.action"))}, sortable: false, editable: true
                },
                {
                    name: "agentNo", index: "agentNo", width: 40, align: "left", formatter: ManagePage.AgentNoFormat, unformat: ManagePage.AgentNoUnFormat, edittype: "custom", editoptions: {custom_value: ManagePage.AgentNoValue, custom_element: ManagePage.AgentNoElement}, sortable: false, editable: true
                },
                {
                    name: "lowerLimit", index: "lowerLimit", width: 40, align: "left", sortable: false, editable: true, editoptions: { size: 20 }
                },
                {
                    name: "upperLimit", index: "upperLimit", formatter: ManagePage.FormatUpperLimit, unformat: ManagePage.UnFormatUpperLimit, width: 40, align: "left", sortable: false, editable: true, editoptions: { size: 20 }
                },
                {
                    name: "rate", index: "rate", width: 40, align: "left", sortable: false, editable: true, editoptions: { size: 20 }
                } ,
                {
                    name: "act1", index: "act1", width: 60, align: "center", sortable: false
                }
            ],
            sortname: "id",
            sortorder: "desc",
            viewrecords: true,
            altclass: "altRowsColour",
            shrinkToFit: true,
            autowidth: true,
            height: "auto",
            postData: {
                productNo: PageVar.ProductNo
            },
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
                var space = "|";
                var ids = $("#expendGridTable").jqGrid("getCol", "id", true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;
                    if(ElementVar.showExpendEditBtn == TagPermissionType.edit){
                        var edit = "<a id=\"edit" + id + "\" class=\"blue\" href=\"javascript:AgentRateManage.GetEdit('" + id + "')\">编辑</a>";
                        var save = "<a id=\"save" + id + "\" class=\"blue\" disabled=\"disabled\" href=\"javascript:AgentRateManage.GetSave('" + id + "')\">保存</a>";
                        var cancel = "<a id=\"cancel" + id + "\" class=\"blue\" disabled=\"disabled\" href=\"javascript:AgentRateManage.GetCancel('" + id + "')\">取消</a>";
                        var del = "<a id=\"del" + id + "\" class=\"blue\" href=\"javascript:AgentRateManage.GetDel('" + id + "')\">删除</a>";
                        $("#expendGridTable").jqGrid("setRowData", id, {act: edit + space + cancel});
                        $("#expendGridTable").jqGrid("setRowData", id, {act1: save + space + del });
                    }
                    TaskAdd.Resize();

                }
            }
        });
    },
    GetEdit: function (index) {
        $("#expendGridTable").jqGrid('editRow', index);
        $(this).disabled = 'true';
        $("#save" + index + ",#cancel" + index).removeAttr("disabled");
        $("#del" + index).attr("disabled", "disabled");
    },
    GetSave: function (index) {
    	
    	if($.trim($("input[name='upperLimit']").val().trim())!=""){
    		if($("input[name='lowerLimit']").val()>$("input[name='upperLimit']").val()){
    			//alert("上限金额要大于等于下线金额!");
    			$("#message").html("&nbsp&nbsp上限金额要大于等于下线金额");
    		}else{
    			$("#expendGridTable").jqGrid("saveRow", index);
        		$("#message").html("");
        	}
    	}else {
    		$("#expendGridTable").jqGrid("saveRow", index);
    		$("#message").html("");
    	}
    	
    	
        //$("#expendGridTable").jqGrid("saveRow", index);
//        AgentRateManage.InitGrid();
        $("#save" + index + ",#cancel" + index).attr("disabled", "disabled");
        $("#edit" + index + ",#del" + index).removeAttr("disabled");
    },
    GetCancel: function (index) {
    	$("#message").html("");//mengchong 
        $("#expendGridTable").jqGrid('restoreRow', index);
        $("#save" + index + ",#cancel" + index).attr("disabled", "disabled");
        $("#edit" + index + ",#del" + index).removeAttr("disabled");
    },
    GetDel: function (index) {
    	$("#message").html("");//mengchong 
        var row = $("#expendGridTable").jqGrid('getRowData', index);
        jQuery("#expendGridTable").jqGrid('delGridRow', index, {
            delData: { id: row.id },
            reloadAfterSubmit: false,
            closeAfterDelete: true
        });
    },
    GetAdd: function () {
        jQuery("#expendGridTable").jqGrid("addRow");
    }
}

var TaskAdd = {
    Resize: function () {
        var contentH = $(".wrappContent").css("height") +
        $("#content_center").css("height", $(".wrappContent").css("height"));
        $(".gridTable").setGridWidth($('.tab_content').width());
    },
    DisableInput: function () {
        $(".data").attr("disabled","disabled");
    },
    EnableInput: function () {
        $.each($(".data"), function (index, content) {
            var id = $(this).attr("id");
            if (ElementVar[id] == undefined) {
                $(this).removeAttr("disabled");
            }
            if (ElementVar[id] == TagPermissionType.edit) {
                $(this).removeAttr("disabled");
            }
        });
    },
    GetPermission: function(){
        ElementVar.taskAmout = TagPermissionType.edit;
        ElementVar.salesCycle = TagPermissionType.edit;
        ElementVar.quota = TagPermissionType.edit;
        ElementVar.incentivePolicy = TagPermissionType.edit;
        ElementVar.salesPolicy = TagPermissionType.edit;
    },
    ShowEditButton: function () {
        if ($("#edit").length == 0)
            return;
        $("#submit").hide();
            $("#edit").show();
    },
    HideEditButton: function () {
        if ($("#edit").length == 0)
            return;
        $("#submit").show();
        $("#edit").hide();
    },
    GetCurrentStatus: function () {
        return $("#status").val();
    },
    GetTaskInfo: function (id) {
        var url = $Url.BuildSalesUrl("/sales/productTask/ajaxGetTask");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {id: id},
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if (data.errCode != "0000") {
                    $("#msg").text(data.errDesc);
                }
                else {
//                    TaskAdd.GetPermission();
                    $Util.DataToVal(data.info,ElementVar);
                    TaskAdd.ShowEditButton($("#status").val());
                    if (TaskAdd.GetCurrentStatus() == "0") {
                        $("#ReviewArea").hide();
                        ReviewManage.InitGrid();
                    }
                    else {
                        $("#ReviewArea").show();
                        ReviewManage.InitGrid();
                    }
                    if ($("#edit").length > 0)
                        $("#edit").click(function () {
                            TaskAdd.EnableInput();
                            TaskAdd.HideEditButton();
                        });
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });

    }
}

$(function () {
    $("#back").click(function () {
        window.location.href = $Url.BuildSalesUrl("/sales/productTask/list");
    });

    EnumList.GetEnumListToSelect($("#productNo"), "productList", $Url.BuildSalesUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#deptNo"), "deptByParent", $Url.BuildSalesUrl("/common/enumList.action"), DEPTVar.DEPTSales);
    EnumList.GetEnumListToSelect($("#status"), "taskStatus", $Url.BuildSalesUrl("/common/enumList.action"));

    if (Number(PageVar.ID) == 0) {
        TaskAdd.HideEditButton();
        $("#ReviewArea").hide();
    }
    else {
        TaskAdd.DisableInput();
        TaskAdd.GetTaskInfo(PageVar.ID);
    }

    if ($("#expendGridTable").length > 0) {
        AgentRateManage.InitGrid();
        $("#btnAgentRateAdd").click(function () {
            AgentRateManage.GetAdd();
        });
    }
    TaskAdd.Resize();
    IncomeRateManage.InitGrid();
    var taskAdd = $("#taskAdd").Validform({
        tiptype: function (msg, o, cssctl) {
            var objtip = o.obj.siblings(".Validform_checktip");
            cssctl(objtip, o.type);
            objtip.text(msg);
        },
        //ignoreHidden: true,
        callback: function (form) {
            //var f = $(form[0]);
            if (!($("#submit").attr("process") === undefined)) {
                return false;
            }
            var url = $Url.BuildSalesUrl("/sales/productTask/ajaxEditProductTask");

            var oper = "add";
            if (Number(PageVar.ID) != 0)
                oper = "edit";
            var info = {
                id: PageVar.ID,
                productNo: $("#productNo").val(),
                deptNo: $("#deptNo").val(),
                taskAmout: $("#taskAmout").val(),
                salesCycle: $("#salesCycle").val(),
                quota: $("#quota").val(),
                incentivePolicy: $("#incentivePolicy").val(),
                salesPolicy: $("#salesPolicy").val(),
                status: $("#status").val(),
                isTest:$String.Trim($("#isTest").val())
            }
            $.ajax({
                type: "post",
                url: url,
                dataType: "json",
                timeout: 30000,
                data: {
                    oper: oper,
                    info:JSON.stringify(info)
                },
                beforeSend: function () {
                    addMask();
                    $("#submit").attr("process", "processing");
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(errorThrown);
                },
                success: function (data, textStatus) {
                    if (data.errCode == "0000") {
                        if (oper == "add") {
                            $("#ReviewArea").show();
                            ReviewManage.InitGrid();
                            PageVar.ID = data.errDesc;
                            TaskAdd.Resize();
                        } else {
                            if (TaskAdd.GetCurrentStatus() == "0") {
                                $("#ReviewArea").show();
                                ReviewManage.InitGrid();
                                $("#status").val(PageVar.StatusReceived);
                            }
                        }

                        TaskAdd.ShowEditButton(TaskAdd.GetCurrentStatus());
                        TaskAdd.DisableInput();


                        if ($("#edit").length > 0)
                            $("#edit").click(function () {
                                TaskAdd.EnableInput($("#status").val());
                            });
                    }
                    else
                        $("#msg").text(data.errDesc);
                },
                complete: function (XMLHttpRequest, textStatus) {
                    $("#submit").removeAttr("process");
                    removeMask();
                }
            });

            return false;
        }
    });

    taskAdd.addRule([
        {
            ele: "#taskAmout",
            datatype: "/^([1-9]\\d{2,7}|0)$/",
            //ignore: "ignore",
            nullmsg: "请填写承销金额",
            errormsg: "承销金额必须大于100万且小于1000亿",
            sucmsg: " "
        },
        {
            ele: "#salesCycle",
            datatype: " /^([1-9]|[1-5][0-9]|60)$/",
            //ignore: "ignore",
            nullmsg: "请填写销售周期",
            errormsg: "销售周期必须大于0且小于60",
            sucmsg: " "
        },
        {
            ele: "#quota",
            datatype: "/^[\\s\\S]{1,100}$/",
            ignore: "ignore",
            nullmsg: "请填写大小配额",
            errormsg: "大小配额不能超过100字",
            sucmsg: " "
        },
        {
            ele: "#salesPolicy",
            datatype: "/^[\\s\\S]{1,1000}$/",
            ignore: "ignore",
            nullmsg: "请填写销售策略",
            errormsg: "销售测旅不能超过1000字",
            sucmsg: " "
        },
        {
            ele: "#incentivePolicy",
            datatype: "/^[\\s\\S]{1,1000}$/",
            ignore: "ignore",
            nullmsg: "请填写激励政策",
            errormsg: "激励政策不能超过1000字",
            sucmsg: " "
        }
    ]);
})