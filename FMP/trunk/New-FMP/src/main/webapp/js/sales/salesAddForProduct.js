var SalesAddForProduct ={
    Tree:function(){
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
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data) {
                SalesAdd.GetFileList();
                if (data.errCode != "0000") {
                    $("#msg").text(data.errDesc);
                    return;
                }
                else {
                    if(Number(data.info.status)<=1){
                        $.fn.linkage({
                            elements: [$("#productType"), $("#productNo")],
                            dataTypes: ["productType", "productByTypeAndStatus"],
                            actionUrl: $Url.BuildSalesUrl("/common/enumList.action"),
                            all: false
                        });
                    }
                    else{
                        $.fn.linkage({
                            elements: [$("#productType"), $("#productNo")],
                            dataTypes: ["productType", "productNo"],
                            actionUrl: $Url.BuildSalesUrl("/common/enumList.action"),
                            all: false
                        });
                    }
                    SalesAdd.GetPermission(data.info.status);

                    $Util.DataToVal(data.info, ElementVar);
                    InitValue.InitTriggerSelect();
                    $("#productType").val(data.info.productType);
                    $("#productNo").val(data.info.productNo);
                    $("#peopleNo").val(data.info.peopleNo);
                    $("#empNo").val(data.info.empNo);
                    if(data.info.empNo == PageVar.UserId){
                        $("#customerNo").val(data.info.customerNo);
                    }
                    else{
                        $("#customerNo option").remove();
                        var option = "<option value='"+data.info.customerNo+"'>"+data.info.customerName+"</option>";
                        $("#customerNo").html(option);
                    }
                    SalesAdd.ShowEditButton($("#status").val());
                    SalesAdd.ShowStatusButton($("#status").val());
                    if ($("#edit").length > 0) {
                        $("#edit").click(function () {
                            SalesAdd.GetPermission($("#status").val());
                            SalesAdd.EnableInput();
                            SalesAdd.HideStatusButton();
                            SalesAdd.HideEditButton();
                        });
                    }
                    if (data.productStatus == PageVar.StatusDuration) {
                        $("#cancel").hide();
                    }
                }
                SalesAddForProduct.Tree();
            }
        });
    },
    InitEnum:function(){
        EnumList.GetEnumListToSelect($("#paymentType"), "payType", $Url.BuildSalesUrl("/common/enumList.action"));
        EnumList.GetEnumListToSelect($("#status"), "salesStatus", $Url.BuildSalesUrl("/common/enumList.action"));
        EnumList.GetEnumListToSelect($("#deptNo"), "dept", $Url.BuildSalesUrl("/common/enumList.action"));
        EnumList.GetEnumListToSelect($("#peopleType"), "agentType", $Url.BuildSalesUrl("/common/enumList.action"));
        EnumList.GetEnumListToSelect($("#protocolStatus"), "protocolStatus", $Url.BuildSalesUrl("/common/enumList.action"));
        $.fn.linkage({
            elements: [$("#productType"), $("#productNo")],
            dataTypes: ["productTypeNotP2p", "productNo"],
            actionUrl: $Url.BuildSalesUrl("/common/enumList.action"),
            all: false
        });
        $.fn.linkage({
            elements: [$("#customerType"), $("#customerNo")],
            dataTypes: ["customerType", {1: "myCustomerPerson1", 2: "myCustomerCompany1"}],
            actionUrl: $Url.BuildSalesUrl("/common/enumList.action"),
            all: false
        });
    },
    format:function(data){
        var result = [];
        $.each(data.listItems,function(i,item) {
            var row = {};
            row.id = item.value;
            row.text = item.text;
            result.push(row);
        });
        return result;
    }
}
$(function () {
    SalesAddForProduct.InitEnum();
    $("#peopleType").change(function () {
        $(".peopleNo").show();
        if ($("#peopleType").val() == 1) {
            $.ajax({
                method: "POST",
                url: $Url.BuildEmployeeUrl("/common/enumList.action"),
                data: {
                    type: "myAgentBusiness"
                },
                success: function (data) {
                    $("#peopleNo").select2("destroy");
                    $("#peopleNo").select2({
                        width:150,
                        placeholder: "请选择",
                        data: SalesAddForProduct.format(data)
                    });
                }
            });
        }else if ($("#peopleType").val() == 2) {
            $(".peopleNo").show();
            $.ajax({
                method: "POST",
                url: $Url.BuildEmployeeUrl("/common/enumList.action"),
                data: {
                    type: "myAgentAdviser"
                },
                success: function (data) {
                    $("#peopleNo").select2("destroy");
                    $("#peopleNo").select2({
                        width:150,
                        placeholder: "请选择",
                        data: SalesAddForProduct.format(data)
                    });
                }
            });
        } else {
            $(".peopleNo").hide();
        }
    });
    if (Number(PageVar.ID) == 0) {
        $Util.InitElement(ElementVar);
        $.fn.linkage({
            elements: [$("#productType"), $("#productNo")],
            dataTypes: ["productTypeNotP2p", "productByTypeAndStatus"],
            actionUrl: $Url.BuildSalesUrl("/common/enumList.action"),
            all: false
        });
        SalesAdd.HideStatusButton();
        SalesAdd.HideEditButton();
        $("#empNo").val(PageVar.UserId);
        InitValue.InitTriggerSelect();
    }
    else {
        EnumList.GetEnumListToSelect($("#customerType"), "customerType", $Url.BuildSalesUrl("/common/enumList.action"));
        SalesAdd.DisableInput();
        SalesAddForProduct.GetSalesInfo(PageVar.ID)
    }

    $("#productType").change(function(){
        $("#productNo").trigger("change");
    });
    SalesAddForProduct.Tree();
    $("#purchaseDate").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd', maxDate: '%y-%M-%d'});
    });
    $("#back").click(function () {
        $EasyUI.Close();
    });
    var salesAdd = $("#salesAdd").Validform({
        tiptype: function (msg, o, cssctl) {
            var objtip = o.obj.siblings(".Validform_checktip");
            cssctl(objtip, o.type);
            objtip.text(msg);
        },
        datatype:{
            "verifyMoney": function (gets,obj,curform,datatype) {
                if(gets < 20000){
                    return false;
                }
                var result = true;
                var url = $Url.BuildSalesUrl("/sales/sales/ajaxVerifyMoney");
                $.ajax({
                    type: "post",
                    url: url,
                    dataType: "json",
                    async: false,
                    data: {
                        productType: $("#productType").val(),
                        productNo: $("#productNo").val(),
                        money:$String.Trim(gets)
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
            var info = {
                id: PageVar.ID,
                contractCode: $("#contractCode").val(),
                productType: $("#productType").val(),
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
                agentRate: $("#agentRate").val(),
                agentRateReal: $.trim($("#agentRateReal").val()),
                bankAddress: $("#bankAddress").val(),
                bankName: $("#bankName").val(),
                accountNumber: $("#accountNumber").val(),
                isTest: $String.Trim($("#isTest").val())
            }
            $.ajax({
                type: "post",
                url: url,
                dataType: "json",
                timeout: 30000,
                data: {
                    oper: oper,
                    isP2PSales: ElementVar.isP2PSales,
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
                            window.location.href = $Url.BuildSalesUrl("/sales/sales/editForProduct?id=" + data.dataId + "&empNo=" + data.dataEmpNo);
                        }
                        if (oper == "edit") {
                            SalesAdd.ShowEditButton($("#status").val());
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
                    $("#submit").removeAttr("process");
                }
            });
            return false;
        }
    });
    if(PageVar.ID==0){
        salesAdd.addRule([
            {
                ele: "#customerNo",
                datatype: "*",
                nullmsg: "请选择客户",
                errormsg: "",
                sucmsg: " "
            }
        ]);
    }
    salesAdd.addRule([
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
            ele: "#agentRateReal",//  /^[0-9]+(\.[0-9]+)?$/    /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$/
            datatype: "/^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$/",
            ignore: "ignore",
            nullmsg: "请填写正确的实际成本费率",
            errormsg: "请填写正确的实际成本费率",
            sucmsg: " "
        },
        {
            ele: "#money",
            datatype: "/^[1-9]\\d{6,8}$/",
            nullmsg: "请填写打款金额",
            errormsg: "请填写正确打款金额格式,不得小于100万",
            sucmsg: " "
        }
    ]);
});