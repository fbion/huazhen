var ManagePage = {
    DateInputElem: function (value, options) {
        var el = document.createElement("input");
        el.type = "text";
        el.value = value;
        el.onclick = function () {
            el.focus();
            el.select();
            WdatePicker({dateFmt: 'yyyy-MM-dd'});
        };// HH:mm:ss
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
        // grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildCustomerUrl('/customer/customerPersonal/ajaxListCustomerPersonal.action'),
            editurl: $Url.BuildCustomerUrl("/customer/customerPersonal/ajaxEditCustomerPersonal.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: [ "操作", "编号", "编码", "证件类型", "证件号码", "客户姓名", "客户性别", "邮箱", "微信", "QQ", "联系电话", "手机1", "手机2", "客户生日", "客户住址", "婚姻状况", "客户公司", "所属行业", "关系等级", "风险偏好", "负责人", "客户来源", "可配置资产", "累计购买额度", "备注", "新增时间", "修改时间","是否登陆" ],
            colModel: [
                {
                    name: "act", index: "act", width:80, align: "center", sortable: false
                },
                {
                    name: "id", index: "id", width: 20, align: "center", sorttype: "number", formoptions: {rowpos: 1, colpos: 1}, editable: true, editoptions: {readonly: true, size: 20}, hidden: true, editrules: { edithidden: true }
                },
                {
                    name: "code", index: "code", width: 40, align: "left", formoptions: {rowpos: 2, colpos: 1}, sortable: false, editable: true, editoptions: { size: 20}, hidden: true, editrules: { edithidden: true }
                },
                {
                    name: "cardType", index: "cardType", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: {size: 1, value: EnumList.GetEnumListToEdit("dicDataforCustomerCompanyCardType", $Url.BuildCustomerUrl("/common/enumList.action"))}, formoptions: {rowpos: 2, colpos: 2}, sortable: false, editable: true, hidden: true, editrules: {edithidden: true}
                },
                {
                    name: "cardNumber", index: "cardNumber", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 3 }, sortable: false, editable: true, editoptions: { size: 20 }, hidden: true, editrules: { edithidden: true, required: false, number: false, custom: true, custom_func: ManagePage.MyCardCheck }
                },
                {
                    name: "name", index: "name", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }, editrules: { required: true }
                },
                {
                    name: "sex", index: "sex", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("dicDicDataForEmployeeSex", $Url.BuildCustomerUrl("/common/enumList.action"))}, formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true
                },
                {
                    name: "email", index: "email", width: 40, align: "left", formoptions: {rowpos: 3, colpos: 3}, sortable: false, editable: true, editoptions: { size: 20 }, hidden: true, editrules: { edithidden: true, required: false, email: true}
                },
                {
                    name: "weixin", index: "weixin", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }, hidden: true, editrules: { edithidden: true }
                },
                {
                    name: "qq", index: "qq", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 }, hidden: true, editrules: { edithidden: true }
                },
                {
                    name: "phone", index: "phone", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 3    }, sortable: false, editable: true, editoptions: { size: 20 }, hidden: true, editrules: { edithidden: true, required: true, custom: true, custom_func: ManagePage.Mytelephonecheck }
                },
                {
                    name: "cellphone1", index: "cellphone1", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }, hidden: false, editrules: { edithidden: true, required: false, custom: true, custom_func: ManagePage.Mycellphonecheck }
                },
                {
                    name: "cellphone2", index: "cellphone2", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 }, hidden: true, editrules: { edithidden: true, required: false, custom: true, custom_func: ManagePage.Mycellphonecheck }
                },
                { 																																															// H:i:s //H:i:s
                    name: "birthday", index: "birthday", width: 40, align: "left", formatter: "date", formoptions: { rowpos: 5, colpos: 3 }, sortable: false, formatoptions: { srcformat: 'Y-m-d ', newformat: 'Y-m-d' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 20 }, hidden: true, editrules: { edithidden: true }
                },
                {
                    name: "address", index: "address", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }, hidden: true, editrules: { edithidden: true }
                },
                {
                    name: "marry", index: "marry", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("dicDicDataForEmployeeMarry", $Url.BuildCustomerUrl("/common/enumList.action")) }, formoptions: { rowpos: 6, colpos: 2 }, sortable: false, editable: true, hidden: true, editrules: { edithidden: true }
                },
                {
                    name: "companyName", index: "companyName", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 3 }, sortable: false, editable: true, editoptions: { size: 20 }, hidden: true, editrules: { edithidden: true }
                },
                {
                    name: "field", index: "field", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }, hidden: true, editrules: { edithidden: true }
                },
                {
                    name: "relationLevel", index: "relationLevel", width: 20, align: "left", formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("dicDataforCustomerCompanyRelationLevel", $Url.BuildCustomerUrl("/common/enumList.action")) }, formoptions: { rowpos: 7, colpos: 2 }, sortable: false, editable: true
                },
                {
                    name: "riskHobby", index: "riskHobby", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("dicDataforCustomerCompanyRiskHobby", $Url.BuildCustomerUrl("/common/enumList.action"))}, formoptions: {rowpos: 7, colpos: 3}, sortable: false, editable: true
                },
                {
                    name: "agentNo", index: "agentNo", width: 40, align: "left", formatter:$Link.MakeEmployeeUrl, edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("empList", $Url.BuildCustomerUrl("/common/enumList.action")) }, formoptions: { rowpos: 8, colpos: 1 }, sortable: false, editable: true
                },
                {
                    name: "sourceType", index: "sourceType", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("customerPersonalSourceTypeListAll", $Url.BuildCustomerUrl("/common/enumList.action")) }, formoptions: { rowpos: 8, colpos: 3 }, sortable: false, editable: true
                },
                {
                    name: "wealth", index: "wealth", width: 40, align: "left", formoptions: { rowpos: 8, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 }, hidden: true, editrules: { edithidden: true }, hidden: true, editrules: { edithidden: true }
                },
                {
                    name: "tradeTotal", index: "tradeTotal", width: 40, align: "left", formoptions: { rowpos: 8, colpos: 3 }, sortable: false, editable: true, editoptions: { size: 20 }, hidden: true, editrules: { edithidden: true }
                },
                {
                    name: "editComment", index: "editComment", width: 40, align: "left", formoptions: { rowpos: 9, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }, hidden: true, editrules: { edithidden: true }
                },
                {
                    name: "findTime", index: "findTime", width: 40, align: "left", formoptions: { rowpos: 9, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 }, formatter: "date", formatoptions: { srcformat: 'Y-m-d', newformat: 'Y-m-d' }
                },
                {
                    name: "editTime", index: "editTime", width: 40, align: "left", formoptions: { rowpos: 9, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 }, formatter: "date", formatoptions: { srcformat: 'Y-m-d', newformat: 'Y-m-d' }
                },
                {
                    name: "isLogin", index: "isLogin", width: 20, align: "center", sorttype: "number", formoptions: {rowpos: 1, colpos: 1}, editable: true, editoptions: {readonly: true, size: 20}, editrules: { edithidden: true },formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("isYes", $Url.BuildCustomerUrl("/common/enumList.action")) }
                },
            ],
            sortname: "id",
            sortorder: "desc",
            pager: "#gridPager",
            viewrecords: true,
            rowNum: 10,
            rowList: [ 10 ],
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
            postData: {
                showAllList: ElementVar.showAllList,
                showDirectList: ElementVar.showDirectList,
                showChannelList: ElementVar.showChannelList,
                showShopList: ElementVar.showShopList,
                byIsSales:1
            },
            pager: "#gridPager",
            gridComplete: function () {
                var space = " | ";
                var ids = $("#gridTable").jqGrid('getCol', 'id', true);
                var names = $("#gridTable").jqGrid('getCol', 'name', true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;
                    var sendTime = ids[i].findTime;
                    var detail = "";
                    var details = "";
                    var detailFload = "";
                    var customerFollow = "";
                    var name = names[i].value;
                    var showCus = "";
                    var p2pUser = "";
                    var tempUrl = $Url.BuildCustomerUrl("/customer/customerPersonal/edit?id=" + id);
                    detail = "<a class='blue' target='_blank' href='" + tempUrl + "'>编辑</a>";
                    var tempUrls = $Url.BuildCustomerUrl("/customer/customerPersonal/detail?id=" + id);
                    details = "<a class='blue' target='_blank' href='" + tempUrls + "'>查看</a>";
                    p2pUser = "<a class=\"blue\" href=\"javascript:ManagePage.EstablishP2pUser('" + id + "')\" >创建P2P用户</a>";
                    customerFollow = "<a class=\"blue\" href=\"javascript:ManagePage.GetCustomerFollow('" + id + "')\" >客户跟踪</a>";//onmouseover=\"ManagePage.GetDetailFload('" + id + "')\"
                    $("#gridTable").jqGrid("setRowData", id, {act: details + space+detail+ space + customerFollow+space+p2pUser});

                    showCus = "<div class=\"blue\" onmouseover=\"ManagePage.GetDetailFload('" + id + "')\">" + name + "</div>";
                    $("#gridTable").jqGrid("setRowData", id, {name: showCus});
                }
                $("td[aria-describedby='gridTable_name']").append('<div class="welfareSubsidy p10" id="welfareSubsidy"></div>');
            }
        });
    },
    InitQuery: function () {
        $("#btnSearch").click(function () {
            var byName = $("#txtName").val();
            var byCellphone1 = $("#cellPhone1").val();
            var byEmpNo = $("#selectEmpNo").val();
            var byRelationLevel = $("#selectRelationLevel").val();
            var byRiskHobby = $("#selectRiskHobby").val();
            var byDepartment = $("#selectDepartment").val();
            var byCardType = $("#selectCardType").val();
            var byFindTimeUp = $("#findTimeUp").val();
            var byFindTimeDown = $("#findTimeDown").val();
            var bySourceType = $("#sourceType").val();
            var byResultStatus = $("#selectResultStatus").val();
            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: {
                    "byName": byName,
                    "byCellphone1": byCellphone1,
                    "byEmpNo": byEmpNo,
                    "byRelationLevel": byRelationLevel,
                    "byDepartment": byDepartment,
                    "byRiskHobby": byRiskHobby,
                    "byCardType": byCardType,
                    "byFindTimeUp": byFindTimeUp,
                    "byFindTimeDown": byFindTimeDown,
                    "bySourceType": bySourceType,
                    "byResultStatus": byResultStatus,
                    "byIsSales":1
                },
                page: 1
            }).trigger("reloadGrid");
        });


    },
    GetDetail: function (index) {
    },
    ToDDMMMYYYY: function (date, options, rowObject) {
        var d = new Date(date);
        var dd = d.getDate() < 10 ? "0" + d.getDate() : d.getDate().toString();
        var mm = d.getMonth() + 1 < 10 ? "0" + (d.getMonth() + 1) : (d.getMonth() + 1).toString();
        var yyyy = d.getFullYear().toString();
        return yyyy + "-" + mm;
    },
    GetDetailFload: function (id) {
//		window.location.href = $Url.BuildEmployeeUrl("/employee/subsidy/ajaxGetInfoByEmpNoAndSendTime?empNo="+empNo+"&&sendTime="+sendTime);
//    	var url = $Url.BuildEmployeeUrl("/employee/subsidy/ajaxGetInfoByEmpNoAndSendTime");
        var url = $Url.BuildCustomerUrl("/customer/customerFollow/ajaxListCustomerFollowLastThree");

        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {
                "customerFollowId": id
//            	sendTime:sendTime
            },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                var htmlStr = null;
                var strat = '<table border="0" align="center">' +
                    '<tr>' +
                    '<td width="80" valign="center" align="center">推荐产品</td>' +
                    '<td width="80" valign="center" align="center" >跟踪类型</td>' +
                    '<td width="80" valign="center" align="center" >跟踪时间</td>' +
                    '<td width="80" valign="center" align="center" >下次跟踪</td>' +
                    '<td width="80" valign="center" align="center" >跟踪内容</td>' +
                    '<td width="80" valign="center" align="center" >跟踪结果</td>' +
                    '</tr>';
                var contre1 = '<tr>' +
                    '<td>';
                var contre2 = '</td>' +
                    '<td>';
                var contre3 = '</td>' +
                    '</tr>';
                var end = '</table>';
                htmlStr = strat;
                if (data.customerFollowList != null && data.customerFollowList.length > 0) {
                    for (var i = 0; i < data.customerFollowList.length; i++) {
                        htmlStr = htmlStr + contre1;
                        htmlStr = htmlStr + data.customerFollowList[i].productName + contre2
                            + data.customerFollowList[i].typeName + contre2
                            + data.customerFollowList[i].timeName + contre2
                            + data.customerFollowList[i].nextTimeName + contre2
                            + data.customerFollowList[i].contentName + contre2
                            + data.customerFollowList[i].resultName;
                        htmlStr = htmlStr + contre3;
                    }
                }
                htmlStr = htmlStr + end;
                $('.welfareSubsidy').html("");
                $('.welfareSubsidy').html(htmlStr);
                EnumList.GetEnumListToSelect($(".alertResultStatus"), "customerFollowResultStatus", $Url.BuildCustomerUrl("/common/enumList.action"));

                $(".welfareSubsidy").each(function (i) {
                    $(this).css({'left': '476px', 'top': 31 * i + 'px', 'zIndex': '20000'});
                });
                $(" td[aria-describedby='gridTable_name']").mouseover(function () {
                    $(this).find('.welfareSubsidy').show();
                });

                $(" td[aria-describedby='gridTable_name']").mouseout(function () {
                    $(this).find('.welfareSubsidy').hide();
                });
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
    EstablishP2pUser:function(id){

        var url = $Url.BuildCustomerUrl("/customer/customerPersonal/ajaxEstablishP2pUser");
        $.ajax({
            type : "POST",
            url : url,
            async : false,
            data : {
                customerPersonalNo:id
            },
            error : function(XMLHttpRequest, textStatus, errorThrown) {

            },
            success : function(data) {
                if (data.errCode == "failed") {
                    alert(data.errDesc);
                }else{
                    alert("创建成功");
                }
            }
        });
    },
    GetCustomerFollow: function (index) {
        $('#customerFollow').window('open');
        $("#customerId").val(index);
        $(".window").css("z-index", "940");
        $(".window-shadow").css("z-index", "900");
        ManagePageFollow.InitGrid();
        var h = $("div[class='panel-body panel-body-noheader layout-body']").css("height", "auto");
    },
    GetEdit: function (index) {
        jQuery("#gridTable").jqGrid('editGridRow', index,
            {
                reloadAfterSubmit: true,
                closeAfterEdit: true,
                beforeShowForm: function () {
                    ManagePage.ShowPoint();
                    $("#code").attr("disabled", "disabled");
                },
                afterShowForm: function () {
                },
                afterSubmit: function (response, postdata) {
                    var res = jQuery.parseJSON(response.responseText), ok = res.errDesc == "";
                    return [ ok, ok ? '' : res.errDesc ];
                }
            });
    },
//    GetAdd: function () {
//        window.open($Url.BuildCustomerUrl("/customer/customerPersonal/edit"));
//    },
    ShowPoint: function () {
        var content = $("#content").parent().prev().text();
        $("#content").parent().prev().html(content + "<em class='color'>*</em>");
        $(".window").css("z-index", "940");
        $("#editmodgridTableFollow").css("left", "160px")
        $(".window-shadow").css("z-index", "900");
    }
}
var ExcelManager={
    ExcelManagerInit:function(){
        $("#btnExcel").click(function () {

            var byResultStatus = $("#selectResultStatus").val();
            var byCellphone1 = $("#cellPhone1").val();
            var byName = $("#txtName").val();
            var byEmpNo = $("#selectEmpNo").val();
            var byRelationLevel = $("#selectRelationLevel").val();
            var byRiskHobby = $("#selectRiskHobby").val();
            var byCardType = $("#selectCardType").val();
            var byFindTimeUp = $("#findTimeUp").val();
            var byFindTimeDown = $("#findTimeDown").val();
            var byDepartment = $("#selectDepartment").val();
            var bySourceType = $("#sourceType").val();
            var url = $Url.BuildCustomerUrl("/customer/customerPersonal/ajaxExportExcel");
            location.href= url+"?"+
                "byName="+ byName+"&"+
                "byEmpNo="+byEmpNo+"&"+
                "byRelationLevel="+ byRelationLevel+"&"+
                "byRiskHobby="+byRiskHobby+"&"+
                "byCardType="+byCardType+"&"+
                "byFindTimeUp="+byFindTimeUp+"&"+
                "byFindTimeDown="+byFindTimeDown+"&"+
                "byDepartment="+byDepartment+"&"+
                "bySourceType="+bySourceType+"&"+
                "byResultStatus="+byResultStatus+"&"+
                "byCellphone1="+byCellphone1+"&"+
                "byIsSales=1&"+
                "sord=desc"+"&"+
                "sidx=id"+"&"+
                "showDirectList="+ElementVar.showDirectList+"&"+
                "showChannelList="+ElementVar.showChannelList+"&"+
                "showShopList="+ElementVar.showShopList+"&"+
                "showAllList="+ElementVar.showAllList;
        });
    }
}
var ChangeManager = {
    ChangeManagerOpen: function () {	//批量修改负责人
        $('#w').window('open');
        ChangeManager.GetCustomerList();
    },
    SelectDisabled:function(){
        $("#empStatus0").attr("disabled","disabled");
        $("#empStatus1").attr("disabled","disabled");
    },
    SelectUnDisabled:function(){
        $("#empStatus0").removeAttr("disabled");
        $("#empStatus1").removeAttr("disabled");
    },
    GetCustomerList:function(){
        var status0ManagerNo = $("#empStatus0").val();
        var status1ManagerNo = $("#empStatus1").val();
        url = $Url.BuildCustomerUrl("/customer/customerPersonal/ajaxGetChangeManager");
        $.ajax({
            type : "POST",
            url : url,
            async : false,
            data : {
                status0ManagerNo : status0ManagerNo,
                status1ManagerNo : status1ManagerNo
            },
            error : function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            },
            success : function(data) {
                $("#empStatus0CustomerList").html("");
                for (var int = 0; int < data.empStatus0List.length; int++) {
                    var array_element = data.empStatus0List[int];
                    $("#empStatus0CustomerList").append("<option  value="+array_element.value+">"+array_element.text+"</option>");
                }

                $("#empStatus1CustomerList").html("");
                for (var int = 0; int < data.empStatus1List.length; int++) {
                    var array_element = data.empStatus1List[int];
                    $("#empStatus1CustomerList").append("<option disabled='disabled' value="+array_element.value+">"+array_element.text+"</option>");
                }
            }
        });
    },
    UpdateManagerNo:function(){
        var manager0No = $("#empStatus0").val();
        var json0 = new Array();
        var customers = $("#empStatus0CustomerList option");
        for (var i = 0; i < customers.length; i++) {
            var info = {};
            info.id = customers.eq(i).val();
            json0.push(info);
        }
        var manager1No = $("#empStatus1").val();
        var json1= new Array();
        var customers = $("#empStatus1CustomerList option");
        for (var i = 0; i < customers.length; i++) {
            var info = {};
            info.id = customers.eq(i).val();
            json1.push(info);
        }
        var url = $Url.BuildCustomerUrl("/customer/customerPersonal/ajaxUpdateCustomerManagerNo");
        $.ajax({
            type : "POST",
            url : url,
            async : false,
            data : {
                status0ManagerNo : manager0No,
                status1ManagerNo : manager1No,
                empStatus0CustomerValue:JSON.stringify(json0),
                empStatus1CustomerValue:JSON.stringify(json1)
            },
            error : function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            },
            success : function(data) {
                if (data.errCode=="OK") {
                    alert("提交成功");
                    ChangeManager.GetCustomerList();
                }
                if (data.errCode=="NO") {
                    alert("提交失败");
                }
            }
        });
    },
    ChangeManagerInit:function(){
        EnumList.GetEnumListToSelect($("#empStatus0"),"employeeStatusDimission", $Url.BuildCustomerUrl("/common/enumList.action"));//离职 有客户的员工
        EnumList.GetEnumListToSelect($("#empStatus1"),"employeeStatusDuty", $Url.BuildCustomerUrl("/common/enumList.action"));//全部在职的员工

        $("#btnChangeManager").click(function () {
            ChangeManager.ChangeManagerOpen();
            ChangeManager.SelectUnDisabled();
        });
        $("#empStatus0CustomerList").dblclick(function(){
            EnumList.ChangeManager("empStatus0CustomerList","empStatus1CustomerList");
            ChangeManager.SelectDisabled();
        });
        $("#empStatus1CustomerList").dblclick(function(){
            EnumList.ChangeManager("empStatus1CustomerList","empStatus0CustomerList");
            ChangeManager.SelectDisabled();
        });
        $("#leftToRigth").click(function(){
            EnumList.ChangeManager("empStatus0CustomerList","empStatus1CustomerList");
            ChangeManager.SelectDisabled();
        });
        $("#rigthToLeft").click(function(){
            EnumList.ChangeManager("empStatus1CustomerList","empStatus0CustomerList");
            ChangeManager.SelectDisabled();
        });
        $("#empStatus0").change(function(){
            ChangeManager.GetCustomerList();
        });
        $("#empStatus1").change(function(){
            ChangeManager.GetCustomerList();
        });
        $("#ok").click(function(){
            ChangeManager.UpdateManagerNo();
            ChangeManager.SelectUnDisabled();
        });
    }
}
/**
 *=================================================客户跟踪============================================================
 */

var ManagePageFollow = {
    DateInputElem : function(value, options) {
        var el = document.createElement("input");
        el.type = "text";
        el.value = value;
        el.onclick = function() { el.focus(); el.select(); WdatePicker({ dateFmt : 'yyyy-MM-dd HH:mm:ss' }); };//
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
        if ($String.Trim($("#gridTableFollow").html()) != "") {
            $("#gridTableFollow").jqGrid('setGridParam',
                {
                    datatype : "json",
                    postData : {
                        "customerFollowId" : $("#customerId").val()
                    },
                    page : 1
                }).trigger("reloadGrid");
        } else {
            // grid start
            $("#gridTableFollow").jqGrid(
                {
                    url : $Url.BuildCustomerUrl('/customer/customerFollow/ajaxListCustomerFollow.action'),
                    editurl : $Url.BuildCustomerUrl("/customer/customerFollow/ajaxEditCustomerFollow.action"),
                    datatype : "json",
                    postData : {
                        "customerFollowId" : $("#customerId").val()
                    },
                    mtype : 'GET', // "推荐产品类型",
                    colNames : [ "操作", "编号", "推荐产品", "客户类型", "客户", "跟踪类型", "跟踪时间", "下次跟踪时间", "跟踪内容", "跟踪结果描述" ],//, "备注"
                    colModel : [{
                        name : "act", index : "act", width : 60, align : "center", sortable : false
                    },
                        {
                            name : "id", index : "id", width : 20, align : "center", sorttype : "number", formoptions : { rowpos : 1, colpos : 1 }, editable : false, editoptions : { readonly : true, size : 20 }
                        },
                        {
                            name : "productNo", index : "productNo", width : 40, align : "left", formatter : "select", edittype : "select", editoptions : {size : 1, value : EnumList.GetEnumListToEdit( "productListByStatus30ForCustomerFollow", $Url.BuildSalesUrl("/common/enumList.action")) }, formoptions : { rowpos : 3, colpos : 1 }, sortable : false, editable : true
                        },
                        {
                            name : "customerType", index : "customerType", width : 40, align : "left", formatter : "select", edittype : "select", editoptions : { size : 1, value : EnumList .GetEnumListToEdit( "customerType", $Url.BuildBaseInfoUrl("/common/enumList.action")) }, formoptions : { rowpos : 2, colpos : 2 }, sortable : false, editable : true, hidden : true, editrules : { edithidden : true }
                        },
                        {
                            name : "customerNo", index : "customerNo", width : 40, align : "left", formatter : "select", edittype : "select", editoptions : { size : 1, value : EnumList.GetEnumListToEdit( "customerPerson", $Url.BuildSalesUrl("/common/enumList.action")) }, formoptions : { rowpos :2, colpos : 1 }, sortable : false, editable : true
                        },
                        {
                            name : "type", index : "type", width : 40, align : "left", formatter : "select", edittype : "select", editoptions : { size : 1, value : EnumList.GetEnumListToEdit( "cusFollowType", $Url .BuildBaseInfoUrl("/common/enumList.action")) }, formoptions : { rowpos : 3, colpos : 2 }, sortable : false, editable : true
                        },
                        { 																																										// + H:i:s + H:i:s
                            name : "time", index : "time", width : 40, align : "left", formoptions : { rowpos : 4, colpos : 1 }, sortable : false, formatter : "date", formatoptions : { srcformat : 'Y-m-d H:i:s', newformat : 'Y-m-d H:i:s' }, editable : true, edittype : 'custom', editoptions : { custom_element : ManagePageFollow.DateInputElem, custom_value : ManagePageFollow.DateInputValue, size : 20 }
                        },
                        { // H:i:s //
                            name : "nexttime", index : "nexttime", width : 40, align : "left", formoptions : { rowpos : 4, colpos : 2 }, sortable : false, formatter : "date", formatoptions : { srcformat : 'Y-m-d H:i:s', newformat : 'Y-m-d H:i:s' }, editable : true, edittype : 'custom', editoptions : { custom_element : ManagePageFollow.DateInputElem, custom_value : ManagePageFollow.DateInputValue, size : 20 }
                        },
                        {
                            name : "content", index : "content", width : 40, align : "left", formoptions : { rowpos : 5, colpos :1 }, sortable : false, editable : true, edittype : 'textarea', editoptions : { size : 20 },editrules:{required:true}
                        },
                        {
                            name : "resultStatus", index : "resultStatus", width : 40, align : "left", formatter:"select",formoptions : { rowpos : 5, colpos : 2 }, sortable : false, editable : true, edittype : 'select', editoptions : { size : 1, value: EnumList.GetEnumListToEdit("customerFollowResultStatus",$Url.BuildCustomerUrl("/common/enumList.action"))}
                        }
//								, 
//								{
//									name : "editComment", index : "editComment", width : 20, align : "left", formoptions : { rowpos : 5, colpos : 2 }, sortable : false, editable : true, edittype : 'textarea', editoptions : { size : 20 }
//								}
                    ],
                    sortname : "id",
                    sortorder : "desc",
                    pager : "#gridPagerFollow",
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
                    pager : "#gridPagerFollow",
                    gridComplete : function() {
                        var space = "|";
                        var ids = $("#gridTableFollow").jqGrid('getCol', 'id', true);
                        for (var i = 0; i < ids.length; i++) {
                            var id = ids[i].id;
                            var detail = "";
                            var edit = "";
                            detail = "<a class=\"blue\" href=\"javascript:ManagePageFollow.GetDetail('"	+ id + "')\">查看</a>";
                            edit = "<a class=\"blue\" href=\"javascript:ManagePageFollow.GetEdit('" + id + "')\">编辑</a>";
                            $("#gridTableFollow").jqGrid("setRowData", id, {act : detail + space + edit	});
                        }
                    }
                });
        }
    },
    InitQuery : function() {
        $("#btnSearchFollow").click(function() {
            // var byName = $("#byName").val();
            $("#gridTableFollow").jqGrid('setGridParam', {
                datatype : "json",
                //postData: { "byName": byName },
                page : 1
            }).trigger("reloadGrid");
        });
    },
    GetDetail : function(index) {
        jQuery("#gridTableFollow").jqGrid('editGridRow', index, {
            editCaption : "查看记录",
            beforeShowForm : function() {
                $(".DataTD").children().attr("disabled", "disabled");
                $(".DataTD").find("input").attr("disabled", "disabled");
                ManagePage.ShowPoint();
                $(".EditButton").html("");
            },
            afterShowForm : function() {
            }
        });
    },
    GetEdit : function(index) {
        jQuery("#gridTableFollow").jqGrid('editGridRow',index,
            {
                reloadAfterSubmit : true,
                closeAfterEdit : true,
                beforeShowForm : function() {
                    ManagePageFollow.BindCustomerPerson();
                    ManagePageFollow.TheCustomer();
                    $("#customerType").attr("disabled", "disabled");
                    $("#customerNo").attr("disabled", "disabled");
                    ManagePage.ShowPoint();
                },
                afterShowForm : function() {
                },
                afterSubmit : function(response, postdata) {
                    var res = jQuery.parseJSON(response.responseText), ok = res.errDesc == "";
                    return [ ok, ok ? '' : res.errDesc ];
                }
            });
    },
    GetAdd : function() {
        jQuery("#gridTableFollow").jqGrid('editGridRow',"new",
            {
                reloadAfterSubmit : true,
                closeAfterAdd : true,
                editCaption : "添加记录",
                beforeShowForm : function() {
                    ManagePageFollow.BindCustomerPerson();
                    ManagePageFollow.TheCustomer();
                    $("#customerType").attr("disabled", "disabled");
                    $("#customerNo").attr("disabled", "disabled");
                    ManagePage.ShowPoint();

                },
                afterShowForm : function() {
                },
                afterSubmit : function(response, postdata) {
                    var res = jQuery.parseJSON(response.responseText), ok = res.errDesc == "";
                    return [ ok, ok ? '' : res.errDesc ];
                }
            });
    },
    BindCustomerPerson : function() {
        $("#customerNo").html("");
        $("#customerNo").linkageForJqGrid({
            prev : $("#customerType"),
            dataType : "customerPerson",
            actionUrl : $Url.BuildProductUrl("/common/enumList.action"),
            all : false
        });
    },
    TheCustomer : function() {
        $("#customerType").val(1);
        var customerId = $("#customerId").val();
        $("#customerNo").val(customerId);
    }
}

$(function() {
//    $("#btnAdd").click(function() {
//        ManagePage.GetAdd();
//    });
    $("#btnAddFollow").click(function() {
        ManagePageFollow.GetAdd();
    });
    EnumList.GetEnumListToSelect($("#selectRelationLevel"),"dicDataforCustomerCompanyRelationLevelAll", $Url.BuildCustomerUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#selectRiskHobby"),"dicDataforCustomerCompanyRiskHobbyAll", $Url.BuildCustomerUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#selectCardType"),"dicDataforCustomerCompanyCardTypeAll", $Url.BuildCustomerUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#sourceType"), "customerPersonalSourceTypeListAll", $Url.BuildCustomerUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#selectResultStatus"),"customerFollowResultStatusAll",$Url.BuildCustomerUrl("/common/enumList.action"));

    $("#findTimeUp").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'});
    });
    $("#findTimeDown").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'});
    });
    ManagePage.InitGrid();
    ManagePage.InitQuery();

    ExcelManager.ExcelManagerInit();
    ChangeManager.ChangeManagerInit();

    EmployeeTreeControl.startTree({
        param: "on",  //on在职员工，out离职员工，test测试员工
        treeInputId: "employeeSel",//员工控件框ID
        valInputId: "selectEmpNo", //员工值框id
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

    EmployeeTreeControl.startTree({
        param: "on",  //on在职员工，out离职员工，test测试员工
        treeInputId: "departmentSel",//员工控件框ID
        valInputId: "selectDepartment", //员工值框id
        inputType: "employee",//employee员工，position职位
        idType: "deptNo",        //员工empNo，userNo,职位positionNo,部门deptNo，公司companyNo
        chkStyle: "radio",//选框类型checkbox,radio
        nochecks:[true,false],      //逐级不显示单或复选框,true不显示，false显示
        chkboxType:{Y:"ps", N:"ps"},  //Y被勾选时关联父类子类ps，N取消被勾选时关联父类子类ps
        showPreBut: true,   //显示全部员工，在职员工按钮,离职员工，test测试员工
        //showSearch: true,   //显示搜索框
        showLevel:2,         //显示层级
        sizeAuto:true,		//自动调节大小
        width:200,			//宽，单位px
        height:300			//高，单位px
    });

});