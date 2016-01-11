var SalesAddForP2pProduct = {
    Resize: function () {
        $("#content_center").css("min-height", $('.detail').height()+100);
    },
    GetTree:function(){
        EmployeeTreeControl.startTree({
            param: "on",  //on在职员工，out离职员工，test测试员工
            treeInputId: "employeeSel",//员工控件框ID
            valInputId: "empNo", //员工值框id
            inputType: "employee",//employee员工，position职位
            idType: "userNo",        //员工empNo，userNo,职位positionNo,部门deptNo，公司companyNo
            chkStyle: "radio",//选框类型checkbox,radio
            nochecks: [true, true, false],      //逐级不显示单或复选框,true不显示，false显示
            chkboxType: {Y: "ps", N: "ps"},  //Y被勾选时关联父类子类ps，N取消被勾选时关联父类子类ps
            showPreBut: true,   //显示全部员工，在职员工按钮,离职员工，test测试员工
            //showSearch: true,   //显示搜索框
            showLevel: 3,         //显示层级
            sizeAuto: true,		//自动调节大小
            width: 200,			//宽，单位px
            height: 300			//高，单位px
        });
    },
    InitSpan:function(path){
        $("#scode").text($("#contractCode").val());
        $("#sproductNo").text($("#productNo  option:selected").text());
        $("#scustomerNo").text($("#customerNo  option:selected").text());
        $("#smoney").text($("#money").val());
        $("#spurchaseDate").text($("#purchaseDate").val());
        $("#sincome").text($("#income").val());
        $("#srepaymentDate").text($("#repaymentDate").val());
        $(".img").attr("src", path);
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
                $("#submitExamine").hide();
                $("#abandoned").hide();
                $("#examine").show();
            }
        }
        else{
            if ($("#edit").length == 0)
                return;
            $("#submit").hide();
            switch (currStatus) {
                case PageVar.StatusSubmit:
                    $("#submitExamine").show();
                    $("#abandoned").show();
                case PageVar.StatusAccount:
                case PageVar.StatusSuccess:
                    $("#edit").show();
                    break;
            }
        }
    },
    HideEditButton: function () {
        var activitID=Audit.GetUrlActivitNo();
        if(!$String.IsNullOrEmpty(activitID)){
            if ($("#edit").length > 0) {
                $("#edit").hide();
                $("#submitExamine").hide();
                $("#abandoned").hide();
                $("#examine").hide();
            }
            if ($("#submit").length > 0)
                $("#submit").show();
        }else{
            if ($("#edit").length > 0) {
                $("#edit").hide();
                $("#submitExamine").hide();
                $("#abandoned").hide();
            }
            if ($("#submit").length > 0)
                $("#submit").show();
        }
    },
    GetPaymentMoney:function(salesNo){
        var url = $Url.BuildSalesUrl("/payment/paymentRefund/getPayMoneyBySalesNo");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {
                salesNo: salesNo
            },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data) {
                if (data.errCode != "0000") {
                    $("#msg").text(data.errDesc);
                    return;
                }
                else {
                   $("#money").val(data.info.payMoney);
                }
            }
        });
    },
    ContinuedInvestment:function(relationSalesNo,continuedType){
        var url = $Url.BuildSalesUrl("/sales/sales/ajaxGetSales");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {id: relationSalesNo},
            beforeSend: function () {
                SalesAdd.DisableInput();
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data) {
                if (data.errCode != "0000") {
                    $("#msg").text(data.errDesc);
                    return;
                }
                else {
                    if(continuedType==2){
                        $("#money").val(data.info.money);
                    }
                    if(continuedType==3){
                       SalesAddForP2pProduct.GetPaymentMoney(relationSalesNo);
                    }
                    SalesAdd.EnableInput();
                    $("#customerType").val(data.info.customerType);
                    $("#customerNo").val(data.info.customerNo);
                    $("#status").val(PageVar.StatusSubmit);
                    $("#relationSalesNo").val(relationSalesNo);
                    $("#empNo").val(PageVar.UserId);
                    SalesAddForP2pProduct.GetTree();
                    $("#bankAddress").val(data.info.bankAddress);
                    $("#bankName").val(data.info.bankName);
                    $("#accountNumber").val(data.info.accountNumber);
                    $("#peopleType").val(data.info.peopleType);
                    $("#peopleType").trigger("change");
                    $(".hide").attr("disabled","disabled");
                    $("#type").val(continuedType);
                }
            }
        });
    },
    SavaFileToDB: function (fileName, relativePath,paramList) {
        var url = $Url.BuildSalesUrl("/sales/activityAttachment/ajaxSaveFilePath");

        var fileID = 0;
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            async: false,
            data: {
                id: PageVar.ID,
                type: paramList[0],
                name: fileName,
                path: relativePath
            },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if (data.errCode == "0000") {
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
    BindFile: function (pathMap,type) {
        var fileTypes = [];
        if(type==0){
            fileTypes = [
                {key: 1, name: "身份证"},
                {key: 2, name: "银行卡"},
                {key: 3, name: "打款凭条"},
            ];
        }else{
            fileTypes = [
                {key: 4, name: "续投确认单"}
            ];
        }

        var readOnly = true;
        if (ElementVar.showUploadButton == "query" && $("#empNo").val() == PageVar.UserId) {
            readOnly = false;
        }
        if (ElementVar.showUploadButton == "query") {
            readOnly = false;
        }
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
                success: SalesAddForP2pProduct.SavaFileToDB,
                deleteFile: SalesAdd.DeleteFile,
                title: content.name
            });
        })
    },
    GetFileList: function (type) {
        var url = $Url.BuildSalesUrl("/sales/activityAttachment/ajaxListFile");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {
                activityNo: PageVar.ID,
                type:1
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
                    SalesAddForP2pProduct.BindFile(pathMap,type);
                } else {
                    alert(data.errDesc);
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
    GetSalesInfo: function (id) {
        var url = $Url.BuildSalesUrl("/sales/sales/ajaxGetSales");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {id: id},
            beforeSend: function () {
            },
            success: function (data) {
                if (data.errCode != "0000") {
                    $("#msg").text(data.errDesc);
                    return;
                }
                else {
                    SalesAddForP2pProduct.GetFileList(data.info.type);
                    if ((Number(data.info.status) > 2 && Number(data.info.status) < 8 )|| Number(data.info.status) == 10) {
                        EnumList.GetEnumListToSelect($("#productNo"), "p2pProductNoList", $Url.BuildSalesUrl("/common/enumList.action"));
                    }
                    $Util.DataToVal(data.info, ElementVar);
                    InitValue.InitTriggerSelect();
                    $("#peopleNo").val(data.info.peopleNo);
                    $("#editComment").val(data.info.editComment);
                    if(data.info.empNo == PageVar.UserId){
                        $("#customerNo").val(data.info.customerNo);
                    }else{
                        $("#customerNo option").remove();
                        var option = "<option value='"+data.info.customerNo+"'>"+data.info.customerName+"</option>";
                        $("#customerNo").html(option);
                    }
                    SalesAddForP2pProduct.ShowEditButton($("#status").val());
                    SalesAdd.ShowStatusButton($("#status").val());
                    Audit.GetWindow(data.info.activitiNo)
                    Audit.InitGrid(data.info.activitiNo);
                    SalesAddForP2pProduct.InitCancelButton();
                    SalesAddForP2pProduct.GetTree();

                    if(Number($("#status").val())!=9){
                        $("#income").attr("disabled","disabled");
                    }

                    if ($("#edit").length > 0) {
                        $("#edit").click(function () {
                            SalesAdd.EnableInput();
                            SalesAddForP2pProduct.GetP2pPermission($("#status").val());
                            SalesAdd.HideStatusButton();
                            SalesAddForP2pProduct.HideEditButton();
                            if(data.info.relationSalesNo!=0){
                                $(".hide").attr("disabled","disabled");
                            }
                        });
                    }
                }
            }
        });
    },
    InitCancelButton: function () {
        $("#cancelSales").click(function () {
            SalesAdd.CancelSales();
        });
    },
    GetRepaymentDate: function () {
        $("#productNo").change(function () {
            var url = $Url.BuildSalesUrl("/sales/sales/ajaxGetRepaymentDate.action");
            $.ajax({
                type: "post",
                url: url,
                data: {
                    productNo: $("#productNo").val()
                },
                beforeSend: function () {
                },
                success: function (data, textStatus) {
                    if (data.errCode == "0000" && !$String.IsNullOrEmpty(data.errDesc)) {
                        $("#repaymentDate").val(new Date(data.p2pProduct.end).format("yyyy-MM-dd"));
                        $("#income").val(data.p2pProduct.income);
                    }
                    else {
                        alert("该产品信息不完善，请重新选择或联系系统管理员");
                    }
                },
                complete: function (XMLHttpRequest, textStatus) {
                }
            });
        });
        $("#productNo").trigger("change");
    },
    GetP2pPermission: function (currStatus) {
        switch (currStatus + "") {
            case PageVar.StatusRefund:
            case PageVar.StatusSuccess:
                $("#purchaseDate").attr("disabled","disabled");
                $("#customerType").attr("disabled","disabled");
                $("#establishDate").attr("disabled","disabled");
                $("#repaymentDate").attr("disabled","disabled");
            case PageVar.StatusAccount:
            case PageVar.StatusChecking:
            case PageVar.StatusCheck:
                if(!$String.IsNullOrEmpty(Audit.GetUrlActivitNo())){
                    $("#productNo").attr("disabled","disabled");
                    $("#money").attr("disabled","disabled");
                    $("#customerNo").attr("disabled","disabled");
                }
                break;
        }
    }
}
var Audit = {
    StartAudit: function (obj, url, activitiNo) {
        if ($("#ok").attr("processing")== "processing"){
            return;
        }else
            $("#ok").attr("processing","processing");
        var uri = $Url.BuildSalesUrl("/sales/sales/detailForP2pProduct")+"?id="+PageVar.ID+"&activitiNo=";
        var sendData = {
            per: obj.val(),
            id: PageVar.ID,
            activitiNo: activitiNo,
            comment: $("#taskCommet").val(),
            uri: uri
        };

        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: sendData,
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown, request) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if(data.errCode=="0000"){
                    if ($String.IsNullOrEmpty(activitiNo)) {
                        alert("提交成功");
                        window.location.href = $Url.BuildSalesUrl("/sales/sales/editForP2pProduct?id=" + PageVar.ID+"&activitiNo=" + data.activitiNo);
                    } else {
                        alert("审批成功");
                        window.location.href = $Url.BuildSalesUrl("/sales/sales/detailForP2pProduct?id=" + PageVar.ID+"&activitiNo=" + activitiNo);
                    }
                }
                else{
                    alert(data.errDesc);
                }
                //removeMask();
            },
            complete: function (XMLHttpRequest, textStatus) {
                $("#ok").removeAttr("processing");
            }
        });
    },
    GetWindow: function (activitiNo) {
        if ($String.IsNullOrEmpty(activitiNo)) {
            $("#submitExamine").click(function () {
                var resultflag = true;
	            var url = $Url.BuildSalesUrl("/sales/sales/ajaxVerifyMoney");
	            $.ajax({
	                type: "post",
	                url: url,
	                dataType: "json",
	                async: false,
	                data: {
	                    productNo: $("#productNo").val(),
	                    money: $String.Trim($("#money").val()),
	                    productType:"5"
	                },
	                success: function (data) {
	                    if (data.errCode == "failed") {
	                    	resultflag = false;
	                        result = data.errDesc;
	                        alert(result);
	                    }
	                }
	            });
	            if(resultflag==false){
                    return resultflag;
                }
                var path = Audit.GetEnclosureBySalesNo();
                if(path==null||path==""){
                    alert("请上传附件");
                }else{
                    SalesAddForP2pProduct.InitSpan($Url.BuildFileUrl(path));
                    $('#w').window('open');
                    $("#ok").click(function(){
                        var url = $Url.BuildWorkFlowUrl('/workFlow/processing/ajaxStartSalesAuditProcess.action');
                        Audit.StartAudit($("#submit1"), url, activitiNo);
                    });
                }
            });
        } else {
            $("#examine").click(function () {
                $('#w1').window('open');
            });
            $(".examine").click(function(){
                $(".examine").attr("disabled", "disabled");
                var url = $Url.BuildWorkFlowUrl("/workFlow/auditTask/ajaxAddExamine.action");
                Audit.StartAudit($(this), url, activitiNo);
            });
        }
    },
    GetEnclosureBySalesNo:function(){
        var path = "";
        var url = $Url.BuildSalesUrl("/sales/sales/getEnclosureBySalesNo.action");
        $.ajax({
            type: "post",
            url: url,
            async: false,
            data: {
                salesNo: PageVar.ID,
                type:$("#type").val()
            },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                path = data.path;
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
        return path;
    },
    GetUrlActivitNo:function(){
        var urlTemp = location.search;
        var theRequest = new Object();
        var strs="";
        if (urlTemp.indexOf("?") != -1) {
            var str = urlTemp.substr(1);
            if(str.indexOf("activitiNo=") != -1){
                strs = str.split("activitiNo=")[1];
            }
        }
        return strs;
    },
    InitGrid: function (activitiNo) {
        $("#salesExamineTable").jqGrid({
            url: $Url.BuildWorkFlowUrl("/workFlow/processing/ajaxGetAuditComment"),
            datatype: "json",
            mytype: "GET",
            colNames: ["审核人", "审核时间", "审核内容"],
            colModel: [
                {
                    name: "checkName", index: "checkName", width: 10, align: "center", formoptions: { rowpos: 1, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }, editrules: {required: true, number: true, minValue: 0.01, maxValue: 99}
                },
                {
                    name: "checkTime", index: "checkTime", width: 15, align: "center", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }, editrules: {required: true, number: true, minValue: 0.01, maxValue: 99}
                },
                {
                    name: "checkComment", index: "checkComment", width: 60, align: "left",  formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 }, editrules: {required: true, number: true, minValue: 0.01, maxValue: 99}
                }
            ],
            viewrecords: true,
            altclass: "altRowsColour",
            shrinkToFit: true,
            autowidth: true,
            height: "auto",
            postData: {
                activitiNo: activitiNo
            },
            jsonReader: {
                root: "commentList",
                repeatitems: false
            },
            gridComplete: function () {}
        });
    }
}
$(function () {
	SalesAddForP2pProduct.Resize();
    InitValue.FormatAgent();
//    EnumList.GetEnumListToSelect($("#type"), "salesType", $Url.BuildSalesUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#productNo"), "p2pProduct", $Url.BuildSalesUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#status"), "salesStatus", $Url.BuildSalesUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#protocolStatus"), "protocolStatus", $Url.BuildSalesUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($(".creditora"), "creditorList", $Url.BuildSalesUrl("/common/enumList.action"));
    $.fn.linkage({
        elements: [$("#peopleType"), $("#peopleNo")],
        dataTypes: ["agentType", {1: "myAgentBusiness", 2: "myAgentAdviser"}],
        actionUrl: $Url.BuildSalesUrl("/common/enumList.action"),
        all: false
    });
    $.fn.linkage({
        elements: [$("#customerType"), $("#customerNo")],
        dataTypes: ["customerType", {1: "myCustomerPerson1", 2: "myCustomerCompany1"}],
        actionUrl: $Url.BuildSalesUrl("/common/enumList.action"),
        all: false
    });
    SalesAddForP2pProduct.GetRepaymentDate();
    if(Number(PageVar.relationSalesNo)!=0){
        SalesAddForP2pProduct.ContinuedInvestment(PageVar.relationSalesNo,PageVar.continuedType);
        SalesAdd.HideEditButton();
    }else if (Number(PageVar.ID) == 0) {
        $Util.InitElement(ElementVar);
        $("#empNo").val(PageVar.UserId);
        SalesAdd.HideStatusButton();
        SalesAdd.HideEditButton();
        $("#status").val(9);
    }else {
        SalesAdd.DisableInput();
        SalesAddForP2pProduct.GetSalesInfo(PageVar.ID);
        $("#build").click(function () {
            SalesAdd.buildPaymentRefund($(this));
        });
    }
    SalesAddForP2pProduct.GetTree();
    $("#loanSituation").click(function () {
        window.open($Url.BuildSalesUrl("/sales/loanSituation/list?saleNo=" + PageVar.ID));
    });
    $("#confirm").click(function () {
        window.open($Url.BuildSalesUrl("/sales/confirmationLetter/list?saleNo=" + PageVar.ID));
    });
    $("#purchaseDate").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd', maxDate: '%y-%M-%d'});
    });
    $("#establishDate").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd'});
    });
    $("#repaymentDate").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd'});
    });
    $("#paymentTime").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd'});
    });
    $("#back").click(function () {
        $EasyUI.Close();
    });

    $("#abandoned").click(function(){
        var url = $Url.BuildSalesUrl("/sales/sales/ajaxAbandonedSales.action");
        $.ajax({
            type: "post",
            url: url,
            async: false,
            data: {
                salesNo: PageVar.ID
            },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if(data.errCode=="0000"){
                    alert("操作成功");
                    location.reload();
                }else{
                    slert(data.errDesc);
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    });
    $("#purchaseDate").blur(function () {
        if ($("#purchaseDate").val() != null) {
            $("#establishDate").val($("#purchaseDate").val())
        }
    });
    var salesAddForP2pProduct = $("#salesAddForP2pProduct").Validform({
        tiptype: function (msg, o, cssctl) {
            var objtip = o.obj.siblings(".Validform_checktip");
            cssctl(objtip, o.type);
            objtip.text(msg);
        },
        datatype: {
            "verifyMoney": function (gets, obj, curform, datatype) {
                if($("#status").val()!=9){
                    return true;
                }
                var minMonney=0;
                if($("#money").val()!= null && $("#money").val()!=""){
                    var url = $Url.BuildSalesUrl("/sales/sales/getMinMoney");
                    $.ajax({
                        type: "post",
                        url: url,
                        dataType: "json",
                        timeout: 30000,
                        async:false,
                        data: {productNo: $("#productNo").val()
                        },
                        beforeSend: function () {
                        },
                        error: function (XMLHttpRequest, textStatus, errorThrown) {
                            alert(errorThrown);
                        },
                        success: function (data) {
                            minMonney=Number(data.minMony);
                        }
                    });
                }
                if (Number(gets) < Number(minMonney)) {
                    return "请填写正确打款金额格式,不得小于"+minMonney+"元";
                }
                var result = true;
                var url = $Url.BuildSalesUrl("/sales/sales/ajaxVerifyMoney");
                $.ajax({
                    type: "post",
                    url: url,
                    dataType: "json",
                    async: false,
                    data: {
                        productNo: $("#productNo").val(),
                        money: $String.Trim(gets),
                        productType:"5"
                    },
                    success: function (data) {
                        if (data.errCode == "failed") {
                            result = data.errDesc;
                        }
                    }
                });
                return result;
            }
        },
        callback: function (form) {
	        	if (!($("#submit").attr("process") === undefined)) {
	                return false;
	            }
                var url = $Url.BuildSalesUrl("/sales/sales/ajaxEditSales");
                var oper = "add";
                if (Number(PageVar.ID) != 0)
                    oper = "edit";
                var activitiNo = Audit.GetUrlActivitNo();
                var info = {
                    id: PageVar.ID,
                    contractCode: $("#contractCode").val(),
                    productType: "5",
                    productNo: $("#productNo").val(),
                    customerType: $("#customerType").val(),
                    customerNo: $("#customerNo").val(),
                    customerName: $("#customerNo  option:selected").text(),
                    status: $("#status").val(),
                    money: $("#money").val(),
                    empNo: $("#empNo").val(),
                    empName:$("#employeeSel").val(),
                    peopleType: $("#peopleType").val(),
                    peopleNo: $("#peopleNo").val(),
                    protocolStatus: $("#protocolStatus").val(),
                    purchaseDate: $("#purchaseDate").val(),
                    bankAddress: $("#bankAddress").val(),
                    bankName: $("#bankName").val(),
                    accountNumber: $("#accountNumber").val(),
                    isTest: $("#isTest").val(),
                    establishDate: $("#establishDate").val(),
                    repaymentDate: $("#repaymentDate").val(),
                    serviceRate: $("#serviceRate").val(),
                    income: $("#income").val(),
                    editComment: $("#editComment").val(),
                    activitiNo:activitiNo,
                    relationSalesNo: $("#relationSalesNo").val(),
                    type: $("#type").val()
                }
                $.ajax({
                    type: "post",
                    url: url,
                    dataType: "json",
                    timeout: 30000,
                    data: {
                        info: JSON.stringify(info),
                        oper: oper
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
                                window.location.href = $Url.BuildSalesUrl("/sales/sales/editForP2pProduct?id=" + data.dataId + "&empNo=" + data.dataEmpNo+"&activitiNo=");
                            }
                            if (oper == "edit") {
                                SalesAddForP2pProduct.ShowEditButton($("#status").val());
                                SalesAdd.ShowStatusButton($("#status").val());
                                SalesAdd.DisableInput();
                                if ($("#edit").length > 0) {
                                    $("#edit").click(function () {
                                        SalesAdd.EnableInput($("#status").val());
                                        SalesAdd.HideStatusButton();
                                        SalesAdd.HideEditButton();
                                    });
                                }
                            }
                        } else if (data.errCode == "9999") {
                            window.location.href = $Url.BuildSalesUrl("/sales/sales/edit?id=" + data.dataId + "&empNo=" + data.dataEmpNo);
                        }
                        else
                            $("#msg").text(data.errDesc);
                    },
                    complete: function (XMLHttpRequest, textStatus) {
                        removeMask();
                        $("#submit").removeAttr("process");
                    }
                });
            return false;
        }
    });
    salesAddForP2pProduct.addRule([
        {
            ele: "#code",
            datatype: "/^.{1,10}$/",//"/^[\u4E00-\u9FA5\uf900-\ufa2d\\w\\.\\s]{1,20}$/",
            ignore: "ignore",
            nullmsg: "",
            errormsg: "编码不能超过10位",
            sucmsg: " "
        },
        {
            ele: "#purchaseDate",
            datatype: "*",
            nullmsg: "请填写购买日期",
            errormsg: "",
            sucmsg: " "
        },
        {
            ele: "#customerNo",
            datatype: "*",
            nullmsg: "请选择客户",
            errormsg: "",
            sucmsg: " "
        },
        {
            ele: "#bankAddress",
            datatype: "/^[\u4E00-\u9FFF]+$/",
            ignore: "ignore",
            nullmsg: " ",
            errormsg: "请填写正确汉字信息",
            sucmsg: " "
        },
        {
            ele: "#bankName",
            datatype: "/^[\u4E00-\u9FFF]+$/",
            ignore: "ignore",
            nullmsg: " ",
            errormsg: "请填写正确的汉字信息！",
            sucmsg: " "
        },
        {
            ele: "#accountNumber",
            datatype: "/^(\\d{16}|\\d{15}|\\d{18}|\\d{19}|\\d{19}[*])$/",
            ignore: "ignore",
            nullmsg: " ",
            errormsg: "请填写15、16、18、19或者19位加*的号码",
            sucmsg: " "
        },
        {
            ele: "#money",
            datatype: "verifyMoney",
            nullmsg: "请填写打款金额",
            errormsg: "请填写正确打款金额格式",
            sucmsg: " "
        },
        {
            ele: "#contractCode",
            datatype: "/^\\d{4}$/",
            nullmsg: "请填写合同编号",
            errormsg: "请填写正确的合同编号",
            sucmsg: " "
        }
    ]);
});