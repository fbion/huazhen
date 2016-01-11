var ManagePage = {
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
    DisableInput: function () {
        $(".data").attr("disabled", "disabled");
    },
    ShowEditButton: function (currStatus) {
        if ($("#edit").length > 0)
            $("#edit").show();
        if ($("#submit").length > 0)
            $("#submit").hide();
    },
    HideEditButton: function () {
        if ($("#edit").length > 0)
            $("#edit").hide();
        if ($("#submit").length > 0)
            $("#submit").show();
    },
    GetInfo: function (id) {
        var url = $Url.BuildCustomerUrl("/customer/customerPersonal/ajaxGetCustomerPersonal");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: { id: id },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if (data.errCode != "0000") {
                    $("#msg").text(data.errDesc);
                    return;
                }
                $Util.DataToVal(data.info, ElementVar);
                ManagePage.ShowEditButton();
                if ($("#edit").length > 0) {
                    $("#edit").click(function () {
                        ManagePage.EnableInput();
                        ManagePage.HideEditButton();
                    });
                }
                EmployeeTreeControl.startTree({
                    param : "on", // on在职员工，out离职员工，test测试员工
                    treeInputId : "employeeSel",// 员工控件框ID
                    valInputId : "agentNo", // 员工值框id
                    inputType : "employee",// employee员工，position职位
                    idType : "userNo", // 员工empNo，userNo,职位positionNo,部门deptNo，公司companyNo
                    chkStyle : "radio",// 选框类型checkbox,radio
                    nochecks : [ true, true, false ], // 逐级不显示单或复选框,true不显示，false显示
                    chkboxType : {Y : "ps",N : "ps"
                    }, // Y被勾选时关联父类子类ps，N取消被勾选时关联父类子类ps
                    showPreBut : true, // 显示全部员工，在职员工按钮,离职员工，test测试员工
                    // showSearch: true, //显示搜索框
                    showLevel : 3, // 显示层级
                    sizeAuto : true, // 自动调节大小
                    width : 200, // 宽，单位px
                    height : 300
                    // 高，单位px
                });
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
    getFollowInfo : function(id) {

        var url = $Url.BuildCustomerUrl("/customer/customerFollow/ajaxGetFollowInfoById");
        $.ajax({
            type : "post",
            url : url,
            async : false,
            data : {
                followId : id
            },
            beforeSend : function() {
            },
            error : function(XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success : function(data, textStatus) {
                var result = data.customerFollow;
                FollowList.ShowEditButton();
                $("#product_no").val(result.productNo);
                $("#followType").val(result.type);
                $("#followTime").val(new Date(result.time).format("yyyy-MM-dd hh:mm:ss"));
                if (result.nexttime != null) {
                    $("#nexttime").val( new Date(result.nexttime).format("yyyy-MM-dd hh:mm:ss"));
                }
                $("#contentFollow").val(result.content);
                $("#resultStatus").val(result.resultStatus);

            },
            complete : function(XMLHttpRequest, textStatus) {
            }
        });
    },
    Resize : function() {
        $("#content_center").css("min-height", "1200px");
    },
    ValidForm:function(){
        var customerPersonalAdd = $("#customerPersonalAdd").Validform({
            tiptype: function (msg, o, cssctl) {
                var objtip = o.obj.siblings(".Validform_checktip");
                cssctl(objtip, o.type);
                objtip.text(msg);
            },
            datatype : {
                "verifyCardId" : function(gets, obj, curform, datatype) {
                    var result = true;
                    if (gets == "") {
                        return true;
                    }
                    var idCard18 = $Validation.isIDCard(gets);
                    if (!idCard18) {
                        return false;
                    }
                    var url = $Url .BuildCustomerUrl("/customer/customerPersonal/cardCheck.action");
                    $.ajax({
                        type : "post",
                        url : url,
                        dataType : "json",
                        async : false,
                        data : {
                            cardNumber : $String.Trim(gets),
                            id : Number(PageVar.ID)
                        },
                        success : function(data) {
                            if (data.errCode == "failed") {
                                result = data.errDesc;
                            }
                        }
                    });
                    return result;
                },
                "verifyNameAndCellPhone" : function(gets, obj,curform, datatype) {
                    if ($("#cellphone1").val() == "") {
                        if ($("#relationLevel").val() == "7") {
                            return true;
                        }
                        if ($("#phone").val() == "") {
                            return "固定电话或者手机号必填一项";
                        }
                        return true;
                    }
                    if (!$Validation.isMobile(gets)) {
                        return false;
                    }
                    var result = true;
                    var url = $Url.BuildCustomerUrl("/customer/customerPersonal/cellPhoneCheck.action");
                    $.ajax({
                        type : "post",
                        url : url,
                        dataType : "json",
                        async : false,
                        data : {
                            id : Number(PageVar.ID),
                            nameCheck : "",// $("#name").val()
                            cellPhoneCheck : $String.Trim(gets)
                        },
                        success : function(data) {
                            if (data.errCode == "failed") {
                                result = data.errDesc;
                            }
                        }
                    });
                    return result;
                },
                "verifyPhoneAndCellPhone" : function(gets, obj,curform, datatype) {
                    if ($("#phone").val() == ""
                        && $("#cellphone1").val() == "") {
                        return "固定电话或者手机号必填一项";
                    }
                    return true;
                },
                "verifyTel" : function(gets, obj, curform,datatype) {
                    var reg = /^\d{3,4}-\d{7,8}(-\d{3,4})?$/;
                    if ($("#phone").val() == "") {
                        if ($("#relationLevel").val() == "7") {
                            return true;
                        }
                        if ($("#cellphone1").val() == "") {
                            return "固定电话或者手机号必填一项";
                        }
                        return true;
                    }
                    if (!reg.test(gets)) {
                        return false;
                    }
                    return true;
                }
            },
            callback: function (form) {
                if (!($("#submit").attr("process") === undefined)) {
                    return false;
                }
                var url = $Url.BuildCustomerUrl("/customer/customerPersonal/ajaxEditCustomerPersonal");
                var oper = "add";
                if (Number(PageVar.ID) != 0)
                    oper = "edit";

                var info = {
                    id: PageVar.ID,
                    code: $("#code").val(),
                    cardType: $("#cardType").val(),
                    cardNumber: $("#cardNumber").val(),
                    name: $("#name").val(),
                    sex: $("#sex").val(),
                    email: $("#email").val(),
                    weixin: $("#weixin").val(),
                    qq: $("#qq").val(),
                    cellphone1: $("#cellphone1").val(),
                    phone: $("#phone").val(),
                    cellphone2: $("#cellphone2").val(),
                    birthday: $("#birthday").val().toTimetamp(),
                    address: $("#address").val(),
                    marry: $("#marry").val(),
                    companyName: $("#companyName").val(),
                    field: $("#field").val(),
                    relationLevel: $("#relationLevel").val(),
                    riskHobby: $("#riskHobby").val(),
                    sourceType: $("#sourceType").val(),
                    agentNo: $("#agentNo").val(),
                    wealth: $("#wealth").val(),
                    tradeTotal: $("#tradeTotal").val(),
                    editComment: $("#editComment").val(),
                    findTime: $("#findTime").val().toTimetamp(),
                    isTest: $("#isTest").val(),
                    p2pCustomerNo: $("#p2pCustomerNo").val(),
                    isLogin: $("#isLogin").val()
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
                            window.location.href = $Url.BuildCustomerUrl("/customer/customerPersonal/edit?id=" + data.errDesc);
                        } else {
                            $("#msg").text(data.errDesc);
                        }
                    },
                    complete: function (XMLHttpRequest, textStatus) {
                        $("#submit").removeAttr("process");
                    }
                });
                return false;
            }
        });
        customerPersonalAdd.addRule([
            {
                ele : "#cellphone1",
                // ignore: "ignore",
                datatype : "verifyNameAndCellPhone",
                nullmsg : "手机号或固定电话必填一项",
                errormsg : "请填写正确格式的手机号",
                sucmsg : " "
            },
            {
                ele : "#phone",
                ignore : "ignore",
                datatype : "verifyTel",
                nullmsg : "手机号或固定电话必填一项",
                errormsg : "电话格式000-xxxxyyyy",
                sucmsg : " "
            },
            {
                ele : "#qq",
                ignore : "ignore",
                dataType : "n",
                nullmsg : "",
                sucmsg : " ",
                errmsg : "qq错误"
            },
            {
                ele : "#wealth",
                ignore : "ignore",
                dataType : "n",
                nullmsg : "",
                sucmsg : " ",
                errmsg : "格式不正确"
            },
            {
                ele : "#tradeTotal",
                ignore : "ignore",
                dataType : "n",
                nullmsg : "",
                sucmsg : " ",
                errmsg : "格式不正确"
            },
            {
                ele : "#cardNumber",
                dataType : "verifyCardId",
                ignore : "ignore",
                nullmsg : "",
                sucmsg : " ",
                errmsg : "请填写正确格式的身份证号"
            },
            {
                ele : "#name",
                dataType : "s1-18",
                nullmsg : "请填写名称",
                sucmsg : " ",
                errmsg : "请填写正确的名称"
            },
            {
                ele : "#email",
                datatype : "e",// 汉字验证/^[\u4E00-\u9FFF]+$/
                ignore : "ignore",
                nullmsg : " ",
                errormsg : "请填写正确邮箱信息",
                sucmsg : " "
            },
            {
                ele : "#cellphone2",
                datatype : "verifyNameAndCellPhone",
                ignore : "ignore",
                nullmsg : " ",
                errormsg : "请填写正确的手机号",
                sucmsg : " "
            },
            {
                ele : "#findTime",
                dataType : "*",
                nullmsg : "请填写客户新增时间",
                sucmsg : " ",
                errmsg : " "
            }
        ]);
    }
}
var FollowList = {
    EnableInput: function () {
        $.each($(".follow"), function (index, content) {
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
    DisableInput: function () {
        $(".follow").attr("disabled", "disabled");
    },
    ShowEditButton: function (currStatus) {
        if ($("#editFollow").length > 0)
            $("#editFollow").show();
        if ($("#submitFollow").length > 0)
            $("#submitFollow").hide();
    },
    HideEditButton: function () {
        if ($("#editFollow").length > 0)
            $("#editFollow").hide();
        if ($("#submitFollow").length > 0)
            $("#submitFollow").show();
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
        $("#gridTableFollow").jqGrid({
            url: $Url.BuildCustomerUrl('/customer/customerFollow/ajaxListCustomerFollow.action'),
            editurl: $Url.BuildCustomerUrl("/customer/customerFollow/ajaxEditCustomerFollow.action"),
            datatype: "json",
            mtype: 'GET',
            postData : {
                "customerId" : PageVar.ID,
                "customerType" : PageVar.CustomerType
            },
            colNames: ["操作","","推荐产品","跟踪类型","跟踪时间","下次跟踪时间","跟踪内容","跟踪结果"],
            colModel: [
                {
                    name : "act",index : "act",width : 60,align : "center",sortable : false
                },
                {
                    name : "id",index : "id",width : 20,align : "center",sorttype : "number",formoptions : {rowpos : 1,colpos : 1},editable : false,editoptions : {readonly : true,size : 2},hidden : true,editrules : {edithidden : true}
                },
                {
                    name : "productNo",index : "productNo",width : 40,align : "left",formatter : "select",edittype : "select",editoptions : {size : 1,value : EnumList.GetEnumListToEdit("productListByStatus30ForCustomerFollow",$Url.BuildCustomerUrl("/common/enumList.action"))},formoptions : {rowpos : 2,colpos : 2},sortable : false,editable : true,editrules : {edithidden : true}
                },
                {
                    name : "type",index : "type",width : 40,align : "left",formatter : "select",edittype : "select",editoptions : {size : 1,value : EnumList.GetEnumListToEdit("cusFollowType",$Url.BuildCustomerUrl("/common/enumList.action"))},formoptions : {rowpos : 4,colpos : 1},sortable : false,editable : true
                },
                {
                    name : "time",index : "time",width : 40,align : "left",formoptions : {rowpos : 4,colpos : 2},sortable : false,formatter : "date",formatoptions : {srcformat : 'Y-m-d H:i:s',newformat : 'Y-m-d H:i:s'},editable : true,edittype : 'custom'
                },
                {
                    name : "nexttime",index : "nexttime",width : 40,align : "left",formoptions : {rowpos : 5,colpos : 1},sortable : false,formatter : "date",formatoptions : {srcformat : 'Y-m-d H:i:s',newformat : 'Y-m-d H:i:s'},editable : true,edittype : 'custom'
                },
                {
                    name : "content",index : "content",width : 40,align : "left",formoptions : {rowpos : 6,colpos : 1},sortable : false,editable : true,edittype : 'textarea',editoptions : {size : 40},editrules : {edithidden : true}
                },
                {
                    name : "resultStatus",index : "resultStatus",width : 40,align : "left",formatter : "select",formoptions : {rowpos : 6,colpos : 2},sortable : false,editable : true,edittype : 'textarea',editoptions : {size : 20,value : EnumList.GetEnumListToEdit("customerFollowResultStatus",$Url.BuildCustomerUrl("/common/enumList.action"))}
                }
            ],
            sortname: "id",
            sortorder: "desc",
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
            pager: "#gridPagerFollow",
            gridComplete: function () {
                var ids = $("#gridTableFollow").jqGrid('getCol', 'id', true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;
                    var detail = "";
                    detail = "<a class=\"blue\" href=\"javascript:FollowList.GetDetail('" + id + "')\">查看</a>";
                    $("#gridTableFollow").jqGrid("setRowData", id, { act: detail });
                }
            }
        });
    },
    GetDetail : function(index) {
        $("#customerFollowAdd").show();
        $("#hideId").val(index);
        ManagePage.getFollowInfo(index);
        FollowList.DisableInput();
    },
    ValidFollow:function(){
        var customerFollowAdd = $("#customerFollowAdd").Validform({
            tiptype: function (msg, o, cssctl) {
                var objtip = o.obj.siblings(".Validform_checktip");
                cssctl(objtip, o.type);
                objtip.text(msg);
            },
            callback: function (form) {
                if (!($("#submit").attr("process") === undefined)) {
                    return false;
                }
                var url = $Url.BuildCustomerUrl("/customer/customerFollow/ajaxEditCustomerFollow");
                var oper = "add";
                if ($("#hideId").val() != 0)
                    oper = "edit";

                var info = {
                    id : $("#hideId").val(),
                    customerNo : Number(PageVar.ID),
                    customerType : Number(PageVar.CustomerType),
                    productNo : $("#product_no").val(),
                    type : $("#followType").val(),
                    time : $("#followTime").val(),
                    nexttime : $("#nexttime").val(),
                    content : $("#contentFollow").val(),
                    resultStatus : $("#resultStatus").val()
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
                            window.location.reload();
                        } else {
                            alert(data.errDesc)
                        }
                    },
                    complete: function (XMLHttpRequest, textStatus) {
                        $("#submit").removeAttr("process");
                    }
                });
                return false;
            }
        });
        customerFollowAdd.addRule([
            {
                ele : "#contentFollow",
                dataType : "*",
                nullmsg : "请描述跟踪",
                sucmsg : " ",
                errmsg : ""
            },
            {
                ele : "#result",
                dataType : "*",
                ignore : "ignore",
                nullmsg : " ",
                sucmsg : " ",
                errmsg : ""
            }
        ]);
    }
}
var SalesList = {
    DateInputElem : function(value, options) {
        var el = document.createElement("input");
        el.type = "text";
        el.value = value;
        el.onclick = function() {
            el.focus();
            el.select();
            WdatePicker({
                dateFmt : 'yyyy-MM-dd HH:mm:ss'
            });
        };
        $(el).addClass("FormElement");
        $(el).addClass("ui-widget-content");
        $(el).addClass("ui-corner-all");
        $(el).css("width", "204px");
        return el;
    },
    DateInputValue : function(elem, operation, value) {
        if (operation === 'get') {
            return $(elem).val();
        } else if (operation === 'set') {
            $(elem).val(value);
        }
    },
    InitGrid : function() {
        $("#gridTable").jqGrid({
            url : $Url.BuildSalesUrl('/sales/sales/ajaxListSalesByCustomerNo.action'),
            editurl : $Url.BuildSalesUrl("/sales/sales/ajaxEditSales.action"),
            datatype : "json",
            postData : {
                "customerNo" : Number(PageVar.ID)
            },
            mtype : 'GET',
            colNames : [ "操作", "id", "产品类型", "产品名称", "客户类型","客户", "订单状态", "订单金额", "部门", "理财经理", "购买日期" ],
            colModel : [

                {
                    name : "act",index : "act",width : 60,align : "center",sortable : false
                },
                {
                    name : "id",index : "id",width : 20,align : "center",sorttype : "number",formoptions : {rowpos : 1,colpos : 1},editable : true,editoptions : {readonly : true,size : 40}
                },
                {
                    name : "productType",index : "productType",width : 40,align : "left",formatter : "select",edittype : "select",editoptions : {size : 1,value : EnumList.GetEnumListToEdit("productType",$Url.BuildSalesUrl("/common/enumList.action"))},formoptions : {rowpos : 3,colpos : 1},sortable : false,editable : true
                },
                {
                    name : "editComment",index : "editComment",width : 40,align : "left",formatter: $Link.MakeP2pProductUrl,edittype : 'select',editoptions : {size : 1,value : EnumList.GetEnumListToEdit("productList",$Url.BuildSalesUrl("/common/enumList.action"))},formoptions : {rowpos : 3,colpos : 2},sortable : false,editable : true
                },
                {
                    name : "customerType",index : "customerType",width : 40,align : "left",formatter : "select",edittype : "select",editoptions : {size : 1,value : EnumList.GetEnumListToEdit("customerType",$Url.BuildSalesUrl("/common/enumList.action"))},formoptions : {rowpos : 4,colpos : 1},sortable : false,editable : true
                },
                {
                    name : "customerName",index : "customerName",width : 40,align : "left",formatter: $Link.MakeCustomerUrl,unformat : ManagePage.CustomerNoUnFormat,edittype : "select",editoptions : {size : 1,value : EnumList.GetEnumListToEdit("",$Url.BuildSalesUrl("/common/enumList.action"))},formoptions : {rowpos : 4,colpos : 2},sortable : false,editable : true
                },
                {
                    name : "status",index : "status",width : 40,align : "left",formatter : "select",edittype : "select",editoptions : {size : 1,value : EnumList.GetEnumListToEdit("salesStatus",$Url.BuildSalesUrl("/common/enumList.action"))},formoptions : {rowpos : 5,colpos : 1},sortable : false,editable : true
                },
                {
                    name : "money",index : "money",width : 40,align : "left",formoptions : {rowpos : 6,colpos : 1},sortable : false,editable : true,editoptions : {size : 40}
                },
                {
                    name : "deptNo",index : "deptNo",width : 40,align : "left",formatter : "select",edittype : "select",editoptions : {size : 1,value : EnumList.GetEnumListToEdit("dept",$Url.BuildSalesUrl("/common/enumList.action"))},formoptions : {rowpos : 7,colpos : 1},sortable : false,editable : true
                },
                {
                    name : "empNo",index : "empNo",width : 40,align : "left",hidden : false,editrules : {edithidden : false},formatter : "select",edittype : 'select',editoptions : {size : 1,value : EnumList.GetEnumListToEdit("empList",$Url.BuildSalesUrl("/common/enumList.action"))},formoptions : {rowpos : 7,colpos : 2},sortable : false,editable : true
                },
                {
                    name : "purchaseDate",index : "purchaseDate",width : 40,align : "left",formatter : "date",formoptions : {rowpos : 9,colpos : 2},sortable : false,formatoptions : {srcformat : 'Y-m-d',newformat : 'Y-m-d'},editable : true,edittype : 'custom',editoptions : {custom_element : ManagePage.DateInputElem,custom_value : ManagePage.DateInputValue,size : 20}
                }
            ],
            sortname : "id",
            sortorder : "desc",
            viewrecords : true,
            rowNum : 10,
            rowList : [ 10 ],
            altclass : "altRowsColour",
            shrinkToFit : true,
            autowidth : true,
            height : "auto",
            multiselect : true,
            prmNames : {
                search : "search",
                page : "pageIndex",
                rows : "pageSize"
            },
            jsonReader : {
                root : "resultList",
                page : "pageIndex",
                total : "pageCount",
                records : "recordCount",
                repeatitems : false
            },
            pager : "#gridPager",
            gridComplete : function() {
                // var space = "|";
                var ids = $("#gridTable").jqGrid('getCol','id', true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;
                    var detail = "";
                    detail = "<a class=\"blue\" href=\"javascript:SalesList.GetDetail('"+ id + "')\">查看</a>";
                    $("#gridTable").jqGrid("setRowData", id, {act : detail});
                }
            }
        });
    },
    InitQuery : function() {
        $("#btnSearch").click(function() {
            var byProductType = $("#selectProductType").val();
            var byProduct = $("#selectProduct").val();
            var byAgentType = $("#selectAgentType").val();
            var byAgent = $("#selectAgent").val();
            var byStatus = $("#selectStatus").val();

            $("#gridTable").jqGrid('setGridParam', {
                datatype : "json",
                postData : {
                    "byProductType" : byProductType,
                    "byProduct" : byProduct,
                    "byAgentType" : byAgentType,
                    "byAgent" : byAgent,
                    "byStatus" : byStatus
                },
                page : 1
            }).trigger("reloadGrid");
        });
    },
    GetDetail : function(index) {
        $EasyUI.NewTab("Detail", $Url.BuildSalesUrl("/sales/sales/edit?id=" + index));
    },
    GetAdd : function() {
        $EasyUI.NewTab("New", $Url.BuildSalesUrl("/sales/sales/edit"))
    }
}
$(function () {
    EnumList.GetEnumListToSelect($("#selectStatus"), "salesStatusAll", $Url.BuildSalesUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#relationLevel"),"dicDataforCustomerCompanyRelationLevel", $Url.BuildCustomerUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#riskHobby"),"dicDataforCustomerCompanyRiskHobby", $Url.BuildCustomerUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#product_no"),"productListByStatus30ForCustomerFollow", $Url.BuildCustomerUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#followType"), "cusFollowType", $Url.BuildCustomerUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#sex"), "dicDicDataForEmployeeSex",$Url.BuildCustomerUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#marry"), "dicDicDataForEmployeeMarry",$Url.BuildCustomerUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#sourceType"), "customerPersonalSourceTypeList", $Url.BuildCustomerUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#resultStatus"),"customerFollowResultStatus", $Url.BuildCustomerUrl("/common/enumList.action"));
    $.fn.linkage({
        elements : [ $("#selectProductType"), $("#selectProduct") ],
        dataTypes : [ "productType", "productNo" ],
        actionUrl : $Url.BuildSalesUrl("/common/enumList.action"),
        all : true
    });
    $.fn.linkage({
        elements : [ $("#selectAgentType"), $("#selectAgent") ],
        dataTypes : [ "agentType", {
            0 : "",
            1 : "myAgentBusiness",
            2 : "myAgentAdviser",
            3 : "zhixiaoEmp"
        } ],// zhixiaoEmpAll
        actionUrl : $Url.BuildSalesUrl("/common/enumList.action"),
        all : true
    });
    $("#back").click(function () {
        $EasyUI.Close();
    });
    $("#followTime").click(function() {
        WdatePicker({dateFmt : 'yyyy-MM-dd HH:mm:ss'});
    });
    $("#nexttime").click(function() {
        WdatePicker({dateFmt : 'yyyy-MM-dd HH:mm:ss'});
    });
    ManagePage.Resize();
    if (Number(PageVar.ID) == 0) {
        $Util.InitElement(ElementVar);
        $("#btnAddFollow").hide();
        ManagePage.HideEditButton();
        $("#agentNo").val(PageVar.UserId);
        $("#findTime").val(new Date().format("yyyy-MM-dd hh:mm:ss"));
    }
    else {
        ManagePage.DisableInput();
        SalesList.InitGrid();
        SalesList.InitQuery();
        FollowList.InitGrid();
        $("#btnAddFollow").show();
        ManagePage.GetInfo(PageVar.ID);
    }
    $("#btnAddFollow").click(function() {
        $(".follow").val("");
        $("#product_no").val(0);
        $("#followType").val(1);
        $("#customerFollowAdd").show();
    });
    $("#editFollow").click(function() {
       FollowList.EnableInput();
       FollowList.HideEditButton();
    });
    $("#birthday").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'});
    });
    $("#findTime").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'});
    });
    $("#btnAddFollow").click(function() {
        $("#customerFollowAdd").show();
        FollowList.HideEditButton();
        FollowList.EnableInput();
    });
    EmployeeTreeControl.startTree({
        param : "on", // on在职员工，out离职员工，test测试员工
        treeInputId : "employeeSel",// 员工控件框ID
        valInputId : "agentNo", // 员工值框id
        inputType : "employee",// employee员工，position职位
        idType : "userNo", // 员工empNo，userNo,职位positionNo,部门deptNo，公司companyNo
        chkStyle : "radio",// 选框类型checkbox,radio
        nochecks : [ true, true, false ], // 逐级不显示单或复选框,true不显示，false显示
        chkboxType : {Y : "ps",N : "ps"}, // Y被勾选时关联父类子类ps，N取消被勾选时关联父类子类ps
        showPreBut : true, // 显示全部员工，在职员工按钮,离职员工，test测试员工
        // showSearch: true, //显示搜索框
        showLevel : 3, // 显示层级
        sizeAuto : true, // 自动调节大小
        width : 200, // 宽，单位px
        height : 300 // 高，单位px
    });
    FollowList.ValidFollow();
    ManagePage.ValidForm();
})
