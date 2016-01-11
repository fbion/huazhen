var ProductAdd = {
    Resize: function () {
        $("#content_center").css("min-height", "1400px");
        $(".gridTable").setGridWidth($('.wrappContent').width());
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
            if (PageVar.ID == 0 && ElementVar[id] == TagPermissionType.none){
                $(this).parent().remove();
            }

        });
    },
    GetPermission: function (currStatus) {
        switch (currStatus+"") {
            case PageVar.StatusDuration:
                ElementVar.dueDate = ProductAdd.GetTagPermission(ElementVar.dueDate,TagPermissionType.query);
                ElementVar.empNo = ProductAdd.GetTagPermission(ElementVar.empNo,TagPermissionType.query);
            case PageVar.StatusOnSale:
                ElementVar.name = ProductAdd.GetTagPermission(ElementVar.name,TagPermissionType.query);
                ElementVar.sumMoney = ProductAdd.GetTagPermission(ElementVar.sumMoney,TagPermissionType.query);
                ElementVar.type = ProductAdd.GetTagPermission(ElementVar.type,TagPermissionType.query);
                ElementVar.pricePackage = ProductAdd.GetTagPermission(ElementVar.pricePackage,TagPermissionType.query);
                ElementVar.payType = ProductAdd.GetTagPermission(ElementVar.payType,TagPermissionType.query);
                ElementVar.baseLimit = ProductAdd.GetTagPermission(ElementVar.baseLimit,TagPermissionType.query);
                ElementVar.deadLine = ProductAdd.GetTagPermission(ElementVar.deadLine,TagPermissionType.query);
                ElementVar.issuerNo = ProductAdd.GetTagPermission(ElementVar.issuerNo,TagPermissionType.query);
                ElementVar.tendType = ProductAdd.GetTagPermission(ElementVar.tendType,TagPermissionType.query);
                ElementVar.settlementType = ProductAdd.GetTagPermission(ElementVar.settlementType,TagPermissionType.query);
                ElementVar.comment = ProductAdd.GetTagPermission(ElementVar.comment,TagPermissionType.query);
                ElementVar.purpose = ProductAdd.GetTagPermission(ElementVar.purpose,TagPermissionType.query);
                ElementVar.financierType = ProductAdd.GetTagPermission(ElementVar.financierType,TagPermissionType.query);
                ElementVar.financierNo = ProductAdd.GetTagPermission(ElementVar.financierNo,TagPermissionType.query);
                ElementVar.agreementStatus = ProductAdd.GetTagPermission(ElementVar.agreementStatus,TagPermissionType.query);
                ElementVar.bankAddress = ProductAdd.GetTagPermission(ElementVar.bankAddress,TagPermissionType.query);
                ElementVar.accountNumber = ProductAdd.GetTagPermission(ElementVar.accountNumber,TagPermissionType.query);
                ElementVar.bankName = ProductAdd.GetTagPermission(ElementVar.bankName,TagPermissionType.query);
                ElementVar.remainAmount = ProductAdd.GetTagPermission(ElementVar.remainAmount,TagPermissionType.query);
                ElementVar.remainSmall = ProductAdd.GetTagPermission(ElementVar.remainSmall,TagPermissionType.query);
                ElementVar.quota = ProductAdd.GetTagPermission(ElementVar.quota,TagPermissionType.query);
                ElementVar.isSaleAll = ProductAdd.GetTagPermission(ElementVar.isSaleAll,TagPermissionType.query);
                break;
            case PageVar.StatusStore:
            case PageVar.StatusPrepare:
            case PageVar.StatusPreheat:
                ElementVar.start = ProductAdd.GetTagPermission(ElementVar.start,TagPermissionType.query);
                ElementVar.end = ProductAdd.GetTagPermission(ElementVar.end,TagPermissionType.query);
                break;
        }
    },
    GetTagPermission:function(DBPermission,TagPermission){
        var ElementVarToNumber = function(val) {
            if (val == TagPermissionType.none) {
                return 0;
            }
            else if (val == TagPermissionType.query) {
                return 1;
            }
            else {
                return 2;
            }
        }
        return ElementVarToNumber(DBPermission) < ElementVarToNumber(TagPermissionType)?DBPermission:TagPermission;
    },
    HideBeforeNew: function () {
        $("#partnerRate").hide();
        $("#saleTask").hide();
        $("#agentRate").hide();
        $("#fileArea").hide();
    },
    ShowAfterNew: function () {
        $("#partnerRate").show();
        $("#saleTask").show();
        $("#agentRate").show();
        $("#fileArea").show();
    },
    ShowEditButton: function (currStatus) {
        var activitiNo = Audit.GetUrlActivitNo();
        if(!$String.IsNullOrEmpty(activitiNo)){
            if ($("#edit").length > 0){
                if($("#empNo").val() == PageVar.UserId){
                    $("#edit").show();
                    $("#submit").hide();
                    $("#examine").val("提交审核")
                }
                $("#commitCheck").hide();
                $("#examine").show();
            }
        }
        else{
            if ($("#edit").length == 0)
                return;
            $("#submit").hide();
            if(currStatus == PageVar.StatusStore){
                $("#commitCheck").show();
                $("#edit").show();
            }
        }

    },
    HideEditButton: function () {
        var activitiNo=Audit.GetUrlActivitNo();
        if(!$String.IsNullOrEmpty(activitiNo)){
            if ($("#edit").length > 0) {
                $("#edit").hide();
                $("#commitCheck").hide();
                $("#examine").hide();
            }
            if ($("#submit").length > 0)
                $("#submit").show();
        }else{
            if ($("#edit").length > 0) {
                $("#edit").hide();
                $("#commitCheck").hide();
            }
            if ($("#submit").length > 0)
                $("#submit").show();
        }
    },
    ShowStatusButton: function (currStatus) {
        if ($(".status").length == 0)
            return;
        var nextStatus, nextName;
        switch (currStatus) {
            case PageVar.StatusStore:
                return;
            case PageVar.StatusPrepare:
                return;
            case PageVar.StatusPreheat:
                nextStatus = PageVar.StatusOnSale;
                nextName = "上线";
                break;
            case PageVar.StatusOnSale:
                if ($("#stages").length > 0)
                    $("#checkboxStages").remove();
                nextStatus = PageVar.StatusDuration;
                nextName = "成立";
                $("#updateStatus").before('<input id="stages" class="submit_Btn status none btn_style" type="button" value="分期成立" />');
                $("#stages").click(function () {
                    $('#c').window('open');
                    $("#preFinshConfirm1").click(function () {
                        var preStart = $("#startime").val();
                        var preEnd = $("#endTime").val();
                        ProductAdd.BuildProduct(preStart,preEnd);
                        $('#c').window('close');
                    });
                });
                break;
            default:
                $(".status").remove();
                return;
        }
            $("#updateStatus").off().on("click", function () {
                if ($("#accountNumber").val() == ""||$("#bankAddress").val() == ""||$("#bankName").val() == "") {
                    alert("请输入开户行地址、开户名、打款账号");
                    return false;
                }
                if (confirm("您确定要" + nextName + "该产品？"))
                    ProductAdd.UpdateStatus(nextStatus);
            });
            $("#updateStatus").val(nextName);
            $(".status").show();
    },
    HideStatusButton: function () {
        if ($(".status").length == 0)
            return;
        $(".status").hide();
    },
    UpdateStart: function (preStart) {
        var url = $Url.BuildProductUrl("/product/product/ajaxEditProductStart");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {id: PageVar.ID,
                start: preStart},
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                $("#start").val(preStart);
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
    UpdateStatus: function (nextStatus) {
        var url = $Url.BuildProductUrl("/product/product/ajaxEditProductStatus");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {
                id: PageVar.ID,
                status: nextStatus,
                start:$("#start").val()
            },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if (data.errCode == "0000") {
                    $("#status").val(nextStatus);
                    ProductAdd.ShowStatusButton(ProductAdd.GetCurrentStatus());
                }
                $("#msg").text(data.errDesc);
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
    CancelProduct: function () {
        var url = $Url.BuildProductUrl("/product/product/ajaxCancelProduct");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {
                id: PageVar.ID
            },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if (data.errCode == "0000") {
                    $("#status").val("取消");
                    $("#cancel").hide();
                }
                alert(data.errDesc);
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
    GetCurrentStatus: function () {
        return $("#status").val();
    },
    GetProductInfo: function (id) {
        var url = $Url.BuildProductUrl("/product/product/ajaxGetProduct");
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

                    ProductAdd.GetPermission(data.info.status);
                    if(PageVar.UserId == Number(data.info.empNo)){
                        EnumList.GetEnumListToSelect($("#empNo"), "empManager", $Url.BuildProductUrl("/common/enumList.action"));
                    }
                    else{
                        EnumList.GetEnumListToSelect($("#empNo"), "empList", $Url.BuildProductUrl("/common/enumList.action"));
                    }
                    $Util.DataToVal(data.info,ElementVar);
                    $(".name").val(data.info.name);
                    $(".settlementType").val(data.info.settlementType);
                    $(".expectProfit").val(data.info.expectProfit);
                    $(".productNo").val(data.info.id);

                    InitValue.InitTriggerSelect();
                    $("#financierNo").val(data.info.financierNo);
                    if (!$String.IsNullOrEmpty(data.info.dueDate)) {
                        $("#dueDate").val(new Date(data.info.dueDate).format("yyyy-MM-dd"));
                    }
                    if (!$String.IsNullOrEmpty(data.info.start)) {
                        $("#start").val(new Date(data.info.start).format("yyyy-MM-dd"));
                    }
                    if (!$String.IsNullOrEmpty(data.info.end)) {
                        $("#end").val(new Date(data.info.end).format("yyyy-MM-dd"));
                    }
                    ProductAdd.ShowEditButton($("#status").val());
                    ProductAdd.ShowStatusButton($("#status").val());
                    FileManage.GetFileList();
                    if ($("#edit").length > 0)
                        $("#edit").click(function () {
                            ProductAdd.EnableInput();
                            ProductAdd.HideStatusButton();
                            ProductAdd.HideEditButton();
                            if(ElementVar.updateEmpNo!="none"){
                               $("#employeeSel").removeAttr("disabled");
                            }
                        });

                    Audit.GetWindow(data.info.activitiNo);
                    Audit.InitGrid(data.info.activitiNo);
                    }
                if(data.info.status==20){
                    $("#editBank").show();
                    $("#edit").hide();
                }
                EmployeeTreeControl.startTree({
                    param: "on",  //on在职员工，out离职员工，test测试员工
                    treeInputId: "employeeSel",//员工控件框ID
                    valInputId: "empNo", //员工值框id
                    inputType: "employee",//employee员工，position职位
                    idType: "userNo",        //员工empNo，userNo,职位positionNo,部门deptNo，公司companyNo
                    chkStyle: "radio",//选框类型checkbox,radio
                    nochecks:[true,true,false],      //逐级不显示单或复选框,true不显示，false显示
                    chkboxType:{Y:"ps", N:"ps"},  //Y被勾选时关联父类子类ps，N取消被勾选时关联父类子类ps
                    showPreBut: true,   //显示全部员工，在职员工按钮,离职员工，test测试员工
                    //showSearch: true,   //显示搜索框
                    showLevel:3,         //显示层级
                    sizeAuto:true,		//自动调节大小
                    width:200,			//宽，单位px
                    height:300			//高，单位px
                });
            },
            complete: function (XMLHttpRequest, textStatus) {
                if ($("#pricePackage").val() == 0) {
                    $("#pricePackage").val("");
                }
                if ($("#type").val() == 3 || $("#type").val() == 4 || $("#type").val() == 5) {
                    $("#remainSmall").prev("span").text("剩余客户量");
                }
                else {
                    $("#remainSmall").prev("span").text("剩余小额");
                }
            }
        });
    },
    BuildProduct: function (preStart,preEnd) {
        var url = $Url.BuildProductUrl("/product/product/ajaxBuildProduct");
        var start = preStart;
        var end = preEnd;
        var empNo = $("#empNo").val();
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {id: PageVar.ID,
                start: start,
                end: end
            },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                $("#stages").remove();
                window.location.href = $Url.BuildProductUrl("/product/product/edit?id=" + PageVar.ID + "&&empNo=" + empNo);
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
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

        span.append(radio).append(label).append(radio1).append(label1).append(radio2).append(label2);
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
            url: $Url.BuildProductUrl('/product/decision/ajaxListDecisionByProduct.action'),
            editurl: $Url.BuildProductUrl("/product/decision/ajaxEditDecision.action"),
            datatype: "json",
            mtype: 'GET',
            postData: {
                productNo: PageVar.ID,
                aa:PageVar.ID
            },
            colNames: ["操作", "编号", "产品", "审核部门", "是否通过", "审核时间", "审核人", "备注"],
            colModel: [

                {
                    name: "act", index: "act", width: 60, align: "center", sortable: false
                },
                {
                    name: "id", index: "id", hidden: true, editable: false, align: "center", sorttype: "number", editrules: {edithidden: true}, editable: true, editoptions: { readonly: true, size: 40 }
                },
                {
                    name: "productNo", index: "productNo", hidden: true, editrules: {edithidden: true}, editable: true
                },
                {
                    name: "depNo", index: "depNo", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: {readonly: true, size: 1, value: EnumList.GetEnumListToEdit("dept", $Url.BuildProductUrl("/common/enumList.action"))}, sortable: false, editrules: {edithidden: true}, editable: true
                },
                {
                    name: "isOk", index: "isOk", width: 40, align: "left", formatter: "select", sortable: false, editable: true, edittype: "custom", editoptions: {value: "0:待审核;1:通过;2:不通过", custom_value: ReviewManage.GetReviewElementValue, custom_element: ReviewManage.CreateReviewEditElement }
                },
                {
                    name: "checkTime", index: "checkTime", width: 40, align: "left", sortable: false, formatter: "date", formatoptions: { srcformat: 'Y-m-d', newformat: 'Y-m-d' }, editable: false
                },
                {
                    name: "empNo", index: "empNo", width: 40, align: "left", sortable: false, formatter: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("empListJq", $Url.BuildProductUrl("/common/enumList.action")) }, editable: false
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
                    if (DEPTVar.CurrentDEPT == depts[i].value && Number(isOks[i].value) != 1 && ProductAdd.GetCurrentStatus() == PageVar.StatusStore) {
                        if(ElementVar.operateCheck == TagPermissionType.query){
                            var edit = "<a class=\"blue\" href=\"javascript:ReviewManage.GetEdit('" + id + "')\">审核</a>";
                            $("#gridTable").jqGrid("setRowData", id, { act: edit });
                        }
                    }
                }
                if ($("#gridTable tbody tr").length <= 1 && ProductAdd.GetCurrentStatus() == PageVar.StatusStore) {
                    $("#commitCheck").show();
                }
                ProductAdd.Resize();
            }
        });


    },
    GetEdit: function (index) {
        jQuery("#gridTable").jqGrid('editGridRow', index, {
            reloadAfterSubmit: true, closeAfterEdit: true,
            beforeShowForm: function () {
                $("#tr_id").hide();
                $("#tr_productNo").hide();
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
    },
    commit: function () {
        var url = $Url.BuildProductUrl("/product/product/ajaxCommitCheckProduct.action");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {id: PageVar.ID},
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                //location.reload();
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    }
}

var IncomeRateManage = {
    UpperLimitVerify: function (value, colname) {
        if (value == "")
            return [true, ""];
        if (!$Validation.isInteger(value)) {
            return [false, "请输入有效数字"];
        }
        return [true, ""];
    },
    InitGrid: function () {
        $("#incomeGridTable").jqGrid({
            url: $Url.BuildProductUrl("/product/partnerRate/ajaxListPartnerRateByProduct.action"),
            editurl: $Url.BuildProductUrl("/product/partnerRate/ajaxEditPartnerRate.action?productNo=" + PageVar.ID),
            datatype: "json",
            mytype: "GET",
            colNames: ["操作", "ID", "下限金额(万)", "上限金额(万，无上限不填)", "费率(%)", "操作"],
            colModel: [
                {
                    name: "act", index: "act", width: 60, align: "center", sortable: false
                },
                {
                    name: "id", index: "id", width: 40, hidden: true
                },
                /*{
                 name: "partnerNo", index: "partnerNo", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("PartnerList", $Url.BuildBaseInfoUrl("/common/enumList.action"))}, formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true
                 },*/
                {
                    name: "lowerLimit", index: "lowerLimit", width: 80, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 }, editrules: {required: true, number: true, minValue: 1}
                },
                {
                    name: "upperLimit", index: "upperLimit", width: 80, align: "left", formatter: ManagePage.FormatUpperLimit, unformat: ManagePage.UnFormatUpperLimit, formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }, editrules: {custom: true, custom_func: IncomeRateManage.UpperLimitVerify}
                },
                {
                    name: "rate", index: "rate", width: 80, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }, editrules: {required: true, number: true, minValue: 0.01, maxValue: 99}
                },
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
            // multiselect: true,
            postData: {
                productNo: PageVar.ID
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
                var ids = $("#incomeGridTable").jqGrid('getCol', 'id', true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;
                    if(ElementVar.showIncomeEditButton == TagPermissionType.query){
                        var edit = "<a id=\"edit" + id + "\" class=\"blue\" href=\"javascript:IncomeRateManage.GetEdit('" + id + "')\">编辑</a>";
                        var save = "<a id=\"save" + id + "\" class=\"blue\" disabled=\"disabled\" href=\"javascript:IncomeRateManage.GetSave('" + id + "')\">保存</a>";
                        var cancel = "<a id=\"cancel" + id + "\" class=\"blue\" disabled=\"disabled\" href=\"javascript:IncomeRateManage.GetCancel('" + id + "')\">取消</a>";
                        var del = "<a id=\"del" + id + "\" class=\"blue\" href=\"javascript:IncomeRateManage.GetDel('" + id + "')\">删除</a>";
                        $("#incomeGridTable").jqGrid("setRowData", id, { act: edit + space + del});
                        $("#incomeGridTable").jqGrid("setRowData", id, { act1: save + space + cancel});
                    }
                }
            }
        });
    },
    GetEdit: function (index) {
        $("#incomeGridTable").jqGrid('editRow', index);
        $(this).disabled = 'true';
        $("#save" + index + ",#cancel" + index).removeAttr("disabled");
        $("#del" + index).attr("disabled", "disabled");
    },
    GetSave: function (index) {
        if ($.trim($("input[name='upperLimit']").val().trim()) != "") {
            if ($("input[name='lowerLimit']").val() > $("input[name='upperLimit']").val()) {
                $("#message").html("&nbsp&nbsp上限金额要大于等于下线金额");
            } else {
                $("#incomeGridTable").jqGrid('saveRow', index);
                $("#message").html("");
            }
        } else {
            $("#incomeGridTable").jqGrid('saveRow', index);
            $("#message").html("");
        }
        $("#save" + index + ",#cancel" + index).attr("disabled", "disabled");
        $("#edit" + index + ",#del" + index).removeAttr("disabled");
    },
    GetCancel: function (index) {
        $("#message").html("");
        $("#incomeGridTable").jqGrid('restoreRow', index);
        $("#save" + index + ",#cancel" + index).attr("disabled", "disabled");
        $("#edit" + index + ",#del" + index).removeAttr("disabled");


    },
    GetAdd: function () {
        jQuery("#incomeGridTable").jqGrid('addRow');
    },
    GetDel: function (index) {

        $("#message").html("");
        var row = $("#incomeGridTable").jqGrid('getRowData', index);
        jQuery("#incomeGridTable").jqGrid('delGridRow', index, {
            delData: { id: row.id },
            reloadAfterSubmit: false,
            closeAfterDelete: true
        });
    }
}

var AgentRateManage = {
    InitGrid: function () {
        if ($("#expendGridTable").length > 0) {
            $("#expendGridTable").jqGrid({
                url: $Url.BuildSalesUrl('/sales/agentRate/ajaxListAgentRateByProduct.action'),
                datatype: "json",
                mytype: "GET",
                colNames: ["产品类型", "产品", "销售方类型", "销售方", "下限金额", "上限金额", "成本费率(%)", "修改备注"],
                colModel: [
                    {
                        name: "productType", index: "productType", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: {size: 1, value: EnumList.GetEnumListToEdit("productType", $Url.BuildProductUrl("/common/enumList.action"))}, formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, hidden: true
                    },
                    {
                        name: "productNo", index: "productNo", width: 40, align: "left", formatter: "select", edittype: 'select', editoptions: { size: 1, value: EnumList.GetEnumListToEdit("productList", $Url.BuildProductUrl("/common/enumList.action"))}, formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, hidden: true
                    },
                    {
                        name: "agentType", index: "agentType", width: 40, align: "center", formatter: "select", edittype: "select", editoptions: {size: 1, value: EnumList.GetEnumListToEdit("agentType", $Url.BuildProductUrl("/common/enumList.action"))}, formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true
                    },
                    {
                        name: "agentNo", index: "agentNo", width: 40, align: "center", formatter: ManagePage.AgentNoFormat, unformat: ManagePage.AgentNoUnFormat, edittype: "select", editoptions: {size: 1, value: EnumList.GetEnumListToEdit("", $Url.BuildProductUrl("/common/enumList.action"))}, formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true
                    },
                    {
                        name: "lowerLimit", index: "lowerLimit", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }
                    },
                    {
                        name: "upperLimit", index: "upperLimit", width: 40, align: "left", formatter: ManagePage.FormatUpperLimit, formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 }
                    },
                    {
                        name: "rate", index: "rate", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }
                    },
                    {
                        name: "editComment", index: "editComment", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 }, hidden: true, editrules: {edithidden: true}
                    }
                ],
                sortname: "id",
                sortorder: "desc",
                viewrecords: true,
                altclass: "altRowsColour",
                shrinkToFit: true,
                autowidth: true,
                height: "auto",
                //multiselect: true,
                postData: {
                    productNo: PageVar.ID
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

                }
            });
        }
    }
}

var StagesManage = {
    RequireMoneyTotalFormat: function (cellvalue, options, rowObject) {
        if (cellvalue == 0) {
            return "";
        } else {
            return cellvalue;
        }
    },
    RequireMoneyTotalUnFormat: function (cellvalue, options, cell) {
        if (cellvalue == "") {
            return "";
        } else {
            return cellvalue;
        }
    },
    DateInputElem: function (value, options) {
        var el = document.createElement("input");
        el.type = "text";
        el.value = value;
        el.onclick = function () {
            el.focus();
            el.select();
            WdatePicker({ dateFmt: 'yyyy-MM-dd' });
        };//HH:mm:ss
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
        $("#stagesGridTable").jqGrid({
            url: $Url.BuildProductUrl('/product/productStages/ajaxListProductStages.action?byProductNo=' + PageVar.ID),
            datatype: "json",
            mtype: 'GET',
            colNames: ["id", "第几期", "成立日期", "到期日期", "成立金额(万)", "成立原因", "修改备注"],
            colModel: [
                {
                    name: "id", index: "id", width: 20, align: "center", sorttype: "number", hidden: true, formoptions: { rowpos: 1, colpos: 1 }, editable: false, editoptions: { readonly: true, size: 40 }
                },
                {
                    name: "stage", index: "stage", width: 40, align: "center", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }, editrules: {required: true, number: true}
                },
                {																																									//H:i:s							H:i:s
                    name: "start", index: "start", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, formatter: "date", formatoptions: { srcformat: 'Y-m-d', newformat: 'Y-m-d' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 }, editrules: { required: true}
                },
                {																																									//H:i:s
                    name: "end", index: "end", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, formatter: "date", formatoptions: { srcformat: 'Y-m-d', newformat: 'Y-m-d' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 }, editrules: { required: true}
                },
                {
                    name: "amount", index: "amount", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }, editrules: {required: true, number: true}
                },
                {
                    name: "reason", index: "reason", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "editComment", index: "editComment", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }, hidden: true, editrules: {edithidden: true}
                }
            ],
            sortname: "id",
            sortorder: "desc",
//            pager: "#gridPager",
            viewrecords: true,
            rowNum: 10,
            rowList: [10],
            altclass: "altRowsColour",
            shrinkToFit: true,
            autowidth: true,
            height: "auto",
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
            }
        });
    }
}

var FileManage = {
    BindFile: function (pathMap) {
        var fileTypes = [
            {key: 1, name: "单页"},
            {key: 2, name: "推介材料"},
            {key: 3, name: "电子合同"},
            {key: 4, name: "说明书"},
            {key: 5, name: "尽职调查报告"},
            {key: 6, name: "渠道协议模版"},
            {key: 7, name: "成立公告"},
            {key: 8, name: "项目管理报告"},
            {key: 9, name: "产品认购指南"}
        ];
        var readOnly = true;
        if ((Number(ProductAdd.GetCurrentStatus()) < Number(PageVar.StatusFinish)) && $("#empNo").val() == PageVar.UserId)
            readOnly = false;
        $.each(fileTypes, function (index, content) {
            var div = "<div id=\"div_" + content.key + "\" class=\"upload\"></div>";
            $("#uploadDiv").append(div);

            $("#uploadDiv #div_" + content.key).Upload({
                inputID: "upload" + content.key,
                readOnly: readOnly,
                multiple: true,
                fileType: 1,
                url: $Url.BuildProductUrl("/upload.action"),
                paramList: [content.key],
                pathList: (pathMap == undefined || pathMap == null)?[]:pathMap[content.key],
                success: FileManage.SavaFileToDB,
                deleteFile: FileManage.DeleteFile,
                title: content.name
            });
        })
    },
    DeleteFile: function (o) {
        if (confirm("是否要删除当前文件")) {
            var id = $(o).attr("id").split("_")[1];
            var url = $Url.BuildProductUrl("/product/productAttachment/ajaxDeleteFile");
            $.ajax({
                type: "post",
                url: url,
                dataType: "json",
                timeout: 30000,
                data: {id: id
                },
                beforeSend: function () {
                    $(o).after("<p></p>");
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(errorThrown);
                },
                success: function (data, textStatus) {
                    if (data.errCode == "0000") {
                        $(o).parent().remove();
                    } else {
                        alert(data.errDesc);
                    }
                },
                complete: function (XMLHttpRequest, textStatus) {
                    $(o).next().remove();
                }
            });
        }
    },
    SavaFileToDB: function (fileName, relativePath, paramList) {
        var url = $Url.BuildProductUrl("/product/productAttachment/ajaxSaveFilePath");

        var fileID = 0;
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            async: false,
            data: {id: PageVar.ID,
                name: fileName,
                path: relativePath,
                type: paramList[0]
            },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if (data.errCode == "0000") {
                    ProductAdd.Resize();
                    fileID = data.errDesc;
                } else {
                    alert(data.errDesc);
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });

        return fileID;
    },
    GetFileList: function () {
        var url = $Url.BuildProductUrl("/product/productAttachment/ajaxListFile");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {productNo: PageVar.ID
            },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if (data.errCode == "0000") {
                    var pathMap = {};
                    $.each(data.resultList, function (index, content) {
                        if (!pathMap[content.type])
                            pathMap[content.type] = [];
                        pathMap[content.type].push({
                            id: content.id,
                            name: content.name,
                            path: $Url.BuildFileUrl(content.path)
                        })
                    });
                    FileManage.BindFile(pathMap);
                } else {
                    alert(data.errDesc);
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    }
}

var ManagePage = {
    AgentBusinessList: EnumList.GetJsonEnumList("agentBusiness", $Url.BuildProductUrl("/common/enumList.action")),
    AgentAdviserList: EnumList.GetJsonEnumList("agentAdviser", $Url.BuildProductUrl("/common/enumList.action")),
    EmpList: EnumList.GetJsonEnumList("empList", $Url.BuildSalesUrl("/common/enumList.action")),
    AgentNoFormat: function (cellvalue, options, rowObject) {
        if (cellvalue == "")
            return "全部";
        else {
            if (rowObject.agentType == 1)
                return "<div ref='" + cellvalue + "'>" + ManagePage.AgentBusinessList[cellvalue] + "</div>";
            else if (rowObject.agentType == 2)
                return "<div ref='" + cellvalue + "'>" + ManagePage.AgentAdviserList[cellvalue] + "</div>";
            else if (rowObject.agentType == 3)
                return "<div ref='" + cellvalue + "'>" + ManagePage.EmpList[cellvalue] + "</div>";
            else
                return cellvalue;
        }
    },
    AgentNoUnFormat: function (cellvalue, options, cell) {
        return $('div', cell).attr('ref');
    },
    GetEdit: function (index) {
        jQuery("#incomeGridTable").jqGrid('editGridRow', index, {
            width: 820, reloadAfterSubmit: true, closeAfterEdit: true,
            beforeShowForm: function () {
                ManagePage.BindProductNo();
            }, afterShowForm: function () {
            }, afterSubmit: function (response, postdata) {
                var res = jQuery.parseJSON(response.responseText), ok = res.errDesc == "";

                return [ok, ok ? '' : res.errDesc];
            }
        });
    },
    BindProductNo: function () {
        $("#productNo").html("");
        $("#productNo").linkageForJqGrid({
            prev: $("#productType"),
            dataType: "productNo",
            actionUrl: $Url.BuildProductUrl("/common/enumList.action"),
            all: false
        });
    },
    FormatUpperLimit: function (value, options) {
        if (value == 100000)
            return "";
        else
            return value;
    },
    UnFormatUpperLimit: function (cellvalue, options, cell) {
        if ($(cell).html() == "undefined")
            return "";
        else
            return $(cell).html();
    }
}

var InitValue = {
    InitBaseLimit: function () {
        $("#baseLimit").val(100);
    },
    InitEnd: function () {
        if ($("#start").val() == "")
            return;
        if ($("#deadLine").val() == null)
            return;
        var start = $("#start").val().format("yyyy-MM-dd");
        var deadLine = $("#deadLine").val();
        var date = new Date(start.substring(0, 4), Number(start.substring(5, 7)) + Number(deadLine) - 1, start.substring(8, 10));
        var end = date.format("yyyy-MM-dd");
        $("#end").val(end);
    },
    InitRemainSmall: function(){
        if ($("#type").val() == 3 || $("#type").val() == 4 || $("#type").val() == 5) {
            $("#remainSmall").prev("span").text("剩余客户量");
        }
        else {
            $("#remainSmall").prev("span").text("剩余小额");
        }
    },
    InitTriggerSelect: function(){
        $("#financierType").trigger("change");
    }
}

$(function () {
    EnumList.GetEnumListToSelect($("#type"), "productType", $Url.BuildProductUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#payType"), "payType", $Url.BuildProductUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#issuerNo"), "issuerNo", $Url.BuildProductUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#status"), "productStatus", $Url.BuildProductUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#tendType"), "tendType", $Url.BuildProductUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#quota"), "quotaType", $Url.BuildProductUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#agreementStatus"), "protocolStatus", $Url.BuildProductUrl("/common/enumList.action"));
    $.fn.linkage({
        elements: [$("#financierType"), $("#financierNo")],
        dataTypes: ["upStreamType", {1: "FinancierBusiness", 2: "financierPersonal"}],
        actionUrl: $Url.BuildProductUrl("/common/enumList.action"),
        all: false
    });
    $("#startTime").click(function () {
        WdatePicker({end: '%y', dateFmt: 'yyyy-MM-dd', minDate: '#F{$dp.$D(\'start\')}'});
    });
    $("#startime").click(function () {
        WdatePicker({end: '%y', dateFmt: 'yyyy-MM-dd', minDate: '#F{$dp.$D(\'start\')}'});
    });
    $("#endTime").click(function () {
        WdatePicker({end: '%y', dateFmt: 'yyyy-MM-dd', minDate: '#F{$dp.$D(\'start\')}'});
    });
    $("#start").click(function () {
        WdatePicker({startDate: '%y', dateFmt: 'yyyy-MM-dd', minDate: '#F{$dp.$D(\'dueDate\')}', maxDate: '#F{$dp.$D(\'end\')}', onpicked: function () {
            InitValue.InitEnd();
        }});
    });
    $("#onlineTime").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd'});
    });
    $("#end").click(function () {
        WdatePicker({end: '%y', dateFmt: 'yyyy-MM-dd', minDate: '#F{$dp.$D(\'start\')}'});
    });
    $("#dueDate").click(function () {
        WdatePicker({dueDate: '%y', dateFmt: 'yyyy-MM-dd', maxDate: '#F{$dp.$D(\'start\')}'});
    });
    $("#back").click(function () {
        $EasyUI.Close();
    });
    $("#deadLine").blur(function () {
        InitValue.InitEnd();
    });

    $("#editBank").click(function(){
        $(".edit").removeAttr("disabled");
        $("#editBank").hide();
        $("#submit").show();
    });
    $("#type").click(function () {
        if ($("#type").val() == 3 || $("#type").val() == 4 || $("#type").val() == 5) {
            $("#remainSmall").prev("span").text("剩余客户量");
            $("#remainSmall").val("200");
        }
        else if ($("#type").val() == 2) {
            $("#remainSmall").prev("span").text("剩余小额");
            $("#remainSmall").val("200");
        }
        else {
            $("#remainSmall").prev("span").text("剩余小额");
            $("#remainSmall").val("50");
        }
    });

    if ($("#preFinsh").length > 0) {
        $("#preFinsh").click(function () {
            $('#w').window('open');
            $("#preFinshConfirm").click(function () {
                var preStart = $("#startTime").val();
                ProductAdd.UpdateStart(preStart);
                $('#w').window('close');
                ProductAdd.UpdateStatus(PageVar.StatusFinish);
                $("#preFinsh").hide();
            });
        });
    }
    if ($("#publishP2P").length > 0) {
        $("#publishP2P").click(function () {
            if (confirm("确认发布成P2P产品吗？")) {
                window.location.href = $Url.BuildProductUrl("/product/p2pProduct/edit?productNo=" + PageVar.ID);
            }
        });
    }


//    if ($("#incomeGridTable").length > 0) {
//        IncomeRateManage.InitGrid();
//        $("#btnIncomeAdd").click(function () {
//            IncomeRateManage.GetAdd();
//        });
//    }
    if ($("#stagesGridTable").length > 0) {
        StagesManage.InitGrid();
    }
//    if ($("#incomeRateAdd").length > 0) {
//        $("#incomeRateAdd").click(function () {
//            IncomeRateManage.IncomeRateAdd();
//        });
//    }
    if ($("#cancel").length > 0) {
        $("#cancel").click(function () {
            if (confirm("您确定要取消该产品？"))
                ProductAdd.CancelProduct();
        });
    }
    if (Number(PageVar.ID) == 0) {
        InitValue.InitBaseLimit();
        $(".no_new").hide();
        ProductAdd.HideStatusButton();
        ProductAdd.HideEditButton();
        ProductAdd.HideBeforeNew();
        FileManage.BindFile();
        $("#empNo").val(PageVar.UserId);
        EmployeeTreeControl.startTree({
            param: "on",  //on在职员工，out离职员工，test测试员工
            treeInputId: "employeeSel",//员工控件框ID
            valInputId: "empNo", //员工值框id
            inputType: "employee",//employee员工，position职位
            idType: "userNo",        //员工empNo，userNo,职位positionNo,部门deptNo，公司companyNo
            chkStyle: "radio",//选框类型checkbox,radio
            nochecks:[true,true,false],      //逐级不显示单或复选框,true不显示，false显示
            chkboxType:{Y:"ps", N:"ps"},  //Y被勾选时关联父类子类ps，N取消被勾选时关联父类子类ps
            showPreBut: true,   //显示全部员工，在职员工按钮,离职员工，test测试员工
            //showSearch: true,   //显示搜索框
            showLevel:3,         //显示层级
            sizeAuto:true,		//自动调节大小
            width:200,			//宽，单位px
            height:300			//高，单位px
        });
    }
    else {
        ProductAdd.DisableInput();
        ProductAdd.GetProductInfo(PageVar.ID);
        InitValue.InitRemainSmall();
        ReviewManage.InitGrid();
        AgentRateManage.InitGrid();
    }
    ProductAdd.Resize();
    var productAdd = $("#productAdd").Validform({
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
            var url = $Url.BuildProductUrl("/product/product/ajaxEditProduct");
            var activitiNo = Audit.GetUrlActivitNo();
            var oper = "add";
            if (Number(PageVar.ID) != 0)
                oper = "edit";
            var info = {
                id: PageVar.ID,
                code:$("#code").val(),
                name: $("#name").val(),
                sumMoney: $("#sumMoney").val(),
                type: $("#type").val(),
                isSaleAll: $("#isSaleAll").val(),
                pricePackage: $("#pricePackage").val(),
                payType: $("#payType").val(),
                baseLimit: $("#baseLimit").val(),
                comment: $("#comment").val(),
                deadLine: $("#deadLine").val(),
                issuerNo: $("#issuerNo").val(),
                onlineTime:$("#onlineTime").val(),
                start: $("#start").val(),
                end: $("#end").val(),
                status: $("#status").val(),
                empNo: $("#empNo").val(),
                tendType: $("#tendType").val(),
                purpose: $("#purpose").val(),
                agreementStatus: $("#agreementStatus").val(),
                bankAddress: $("#bankAddress").val(),
                bankName: $("#bankName").val(),
                accountNumber: $("#accountNumber").val(),
                quota: $("#quota").val(),
                dueDate: $("#dueDate").val(),
                remainAmount: $("#remainAmount").val(),
                remainSmall: $("#remainSmall").val(),
                financierType: $("#financierType").val(),
                financierNo: $("#financierNo").val(),
                settlementType: $("#settlementType").val(),
                isTest:$String.Trim($("#isTest").val()),
                baseNumber:$("#baseNumber").val(),
                expectProfit:$("#expectProfit").val(),
                activitiNo:activitiNo
            }
            $.ajax({
                type: "post",
                url: url,
                dataType: "json",
                timeout: 30000,
                data: {
                    oper: oper,
                    info: JSON.stringify(info)

                },
                beforeSend: function () {
                    $("#submit").attr("process", "processing");
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(errorThrown);
                },
                success: function (data, textStatus) {
                    if (data.errCode == "0000") {
                        if (oper == "add") {
                            window.location.href = $Url.BuildProductUrl("/product/product/edit?id=" + data.errDesc + "&empNo=" + PageVar.UserId + "&activitiNo=");
                        }
                        else {
                            ProductAdd.ShowEditButton(ProductAdd.GetCurrentStatus());
                            ProductAdd.ShowStatusButton(ProductAdd.GetCurrentStatus());
                            ProductAdd.DisableInput();
                            ProductAdd.ShowAfterNew();
                            if ($("#edit").length > 0)
                                $("#edit").click(function () {
                                    ProductAdd.EnableInput();
                                    ProductAdd.HideStatusButton();
                                    ProductAdd.HideEditButton();
                                    $("#checkboxStages").remove();
                                });
                        }
                    }
                    else
                        $("#msg").text(data.errDesc);
                },
                complete: function (XMLHttpRequest, textStatus) {
                    $("#submit").removeAttr("process");
                }
            });
            return false;
        }
    });
    $("#submit").click(function () {
        if($("#type").val()==5){
            productAdd.addRule([

                {
                    ele: "#baseNumber",
                    datatype: "/^\\d{3}$/",
                    //ignore: "ignore",
                    nullmsg: "请填写基数",
                    errormsg: "请填写正确的基数（三位数字365/360）",
                    sucmsg: " "
                }
            ]);
        }
    });

    productAdd.addRule([
        {
            ele: "#code",
            datatype: "/^.{1,10}$/",//"/^[\u4E00-\u9FA5\uf900-\ufa2d\\w\\.\\s]{1,20}$/",
            ignore: "ignore",
            nullmsg: "",
            errormsg: "产品编码不能超过10位",
            sucmsg: " "
        },
        {
            ele: "#name",
            datatype: "/^.{1,100}$/",
            //ignore: "ignore",
            nullmsg: "请填写产品名称",
            errormsg: "产品名称不能超过100位",
            sucmsg: " "
        },
        {
//            ele: "#sumMoney",
//            datatype: "/^[1-9]\\d{7,12}$/",
//            //ignore: "ignore",
//            nullmsg: "请填写募集规模",
//            errormsg: "募集规模必须大于100万且小于1000亿",
//            sucmsg: " "
        },
        {
            ele: "#pricePackage",
            datatype: "/^([0-9]\\d?(\\.\\d{1,2})?|0.\\d{1,2}|100)$/",
            ignore: "ignore",
            //nullmsg: "请填写打包价",
            errormsg: "打包价必须大于0小于100，且最多两位小数",
            sucmsg: " "
        },
        {
            ele: "#baseLimit",
            datatype: "/^[1-9]\\d{2,8}$/",
            //ignore: "ignore",
            nullmsg: "请填写认购起点",
            errormsg: "认购起点必须大于等于100万",
            sucmsg: " "
        },
        {
            ele: "#comment",
            datatype: "/^[\\s\\S]{1,1000}$/",
            ignore: "ignore",
            nullmsg: "请填写产品描述",
            errormsg: "产品描述不能超过1000字",
            sucmsg: " "
        },
        {
            ele: "#deadLine",
            datatype: "/^[1-9]\\d{0,1}$/",
            //ignore: "ignore",
            nullmsg: "请填写存续期",
            errormsg: "存续期必须大于0且小于100",
            sucmsg: " "
        },
        {
            ele: "#purpose",
            datatype: "/^[\\s\\S]{1,250}$/",
            ignore: "ignore",
            nullmsg: "请填写资金用途",
            errormsg: "资金用途不能超过250字",
            sucmsg: " "
        },
        {
            ele: "#settlementType",
            datatype: "/^[\\s\\S]{1,1000}$/",
            ignore: "ignore",
            nullmsg: "请填写结算方式",
            errormsg: "结算方式不能超过1000字",
            sucmsg: " "
        },
        {
            ele: "#accountNumber",
            datatype: "n",
            ignore: "ignore",
            nullmsg: "请填写打款账号",
            errormsg: "请填写正确格式的打款账号",
            sucmsg: " "
        }
    ]);

});