/**
 * Created by code generator on #time#.
 */
var CustomerPersonalList = {
    InitGrid: function () {
        //默认是通过id倒排序，默认可不写，支持传递多个排序条件
        //var sortList = [{sort:"in_user_no",order:"desc"},{sort:"id",order:"desc"}];
        //var sortList = [{sort:"edit_user_no",order:"desc"}];
        $("#gridTable").datagrid({
            url: $Url.BuildCustomerUrl('/customer/customerPersonal/easyUICustomerPersonalList'),
            method: 'post',
            resizable: true,
            fit: true,
            multiSort: true,
            autoRowHeight: false,
            singleSelect: true,
            toolbar: "#toolbar",
            loadMsg: "正在加载，请稍等...",
            pagination: true,
            pageSize: 15,
            pageList: [15, 30, 50],
            queryParams: {
                showAllList: ElementVar.showAllList,
                showDirectList: ElementVar.showDirectList,
                showChannelList: ElementVar.showChannelList,
                showShopList: ElementVar.showShopList
                //sortList:JSON.stringify(sortList)
            },
            columns: [[
                { field: 'id', title: '编号', align: 'center',width:'5%', halign: 'center', hidden: false, sortable: true },
                { field: 'code', title: '编号', align: 'center',width:'5%', halign: 'center', hidden: true, sortable: false },
                { field: 'name', title: '姓名', align: 'center', width:'7%',halign: 'center', hidden: false, sortable: false ,
                    formatter: function (value, row) {
                        return  "<div class=\"blue\" onmouseout=\"$('#w1').window('close')\" onmouseover=\"CustomerPersonalList.GetDetailFload('" + row.id + "')\">" + row.name + "</div>";
                    }
                },
                { field: 'sex', title: '性别', align: 'center',width:'5%', halign: 'center', hidden: false, sortable: false,
                    formatter: function (value) {
                        return EnumListWithEasyUI.GetEnumListToGrid(value, "dicDicDataForEmployeeSex", $Url.BuildNewIndexUrl("/common/enumList.action"));
                    }
                },
                { field: 'email', title: '邮箱', align: 'center',width:'5%', halign: 'center', hidden: false, sortable: false },
                { field: 'weixin', title: '微信', align: 'center',width:'5%', halign: 'center', hidden: false, sortable: false },
                { field: 'qq', title: 'qq', align: 'center', width:'5%',halign: 'center', hidden: false, sortable: false },
                { field: 'cellphone1', title: '手机1', align: 'center', width:'8%',halign: 'center', hidden: false, sortable: false },
                { field: 'cardNumber', title: '证件号码', align: 'center', width:'10%',halign: 'center', hidden: false, sortable: false },
                { field: 'phone', title: '固定电话', align: 'center',width:'5%', halign: 'center', hidden: false, sortable: false },
                { field: 'cellphone2', title: '手机2', align: 'center',width:'5%', halign: 'center', hidden: true, sortable: false },
                { field: 'birthday', title: '生日', align: 'center',width:'5%', halign: 'center', hidden: false, sortable: false,
                    formatter: function (value, row, index) {
                        if(!$String.IsNullOrEmpty(value)){
                            return value.toDate().format("yyyy-MM-dd");
                        }
                    }
                },
                { field: 'relationLevel', title: '关系等级', align: 'center', width:'5%',halign: 'center', hidden: false, sortable: false,
                    formatter: function (value) {
                        return EnumListWithEasyUI.GetEnumListToGrid(value, "dicDataforCustomerCompanyRelationLevel", $Url.BuildNewIndexUrl("/common/enumList.action"));
                    }
                },
                { field: 'sourceType', title: '客户来源', align: 'center',width:'5%', halign: 'center', hidden: false, sortable: false,
                    formatter: function (value) {
                        return EnumListWithEasyUI.GetEnumListToGrid(value, "customerPersonalSourceTypeList", $Url.BuildNewIndexUrl("/common/enumList.action"));
                    }
                },
                { field: 'wealth', title: '可配置资产', align: 'center', width:'5%',halign: 'center', hidden: false, sortable: false },
                { field: 'tradeTotal', title: '累计购买量', align: 'center',width:'5%', halign: 'center', hidden: false, sortable: false },
                { field: 'agentNo', title: '负责人', align: 'center',width:'5%', halign: 'center', hidden: false, sortable: false,
                    formatter: function (value,row) {
                        var url = $Url.BuildNewIndexUrl("/baseInfo/mailList/list?id=") + row.agentNo;
                        var value = EnumListWithEasyUI.GetEnumListToGrid(value, "empList", $Url.BuildNewIndexUrl("/common/enumList.action"))
                        return "<a href=\"javascript:void(0)\" onclick=\"$EasyUI.AddTab('" + value + "','" + url + "')\">" + value + "</a>";
                    }
                },

                { field: 'findTime', title: '新增时间', align: 'center',width:'5%', halign: 'center', hidden: false, sortable: false,
                    formatter: function (value, row, index) {
                        if(!$String.IsNullOrEmpty(value)){
                            return value.toDate().format("yyyy-MM-dd");
                        }
                    }
                },
                { field: 'riskHobby', title: '风险偏好', align: 'center',width:'5%', halign: 'center', hidden: true, sortable: false,
                    formatter: function (value) {
                        return EnumListWithEasyUI.GetEnumListToGrid(value, "dicDataforCustomerCompanyRiskHobby", $Url.BuildNewIndexUrl("/common/enumList.action"));
                    }
                },
                { field: 'address', title: '地址', align: 'center', width:'5%',halign: 'center', hidden: true, sortable: false },
                { field: 'marry', title: '婚姻', align: 'center', width:'5%',halign: 'center', hidden: true, sortable: false,
                    formatter: function (value) {
                        return EnumListWithEasyUI.GetEnumListToGrid(value, "dicDicDataForEmployeeMarry", $Url.BuildNewIndexUrl("/common/enumList.action"));
                    }

                },
                { field: 'companyName', title: '所属公司', align: 'center', width:'5%',halign: 'center', hidden: true, sortable: false },
                { field: 'field', title: '所属行业', align: 'center',width:'5%', halign: 'center', hidden: true, sortable: false }
            ]],
            onBeforeLoad: function (param) {
                $.getJSON($Url.BuildCustomerUrl("/getColumnCookie"), { key: "customerPersonalList" }, function (data) {
                    if(!$String.IsNullOrEmpty(data.value)){
                        $.each(JSON.parse(data.value), function (i, item) {
                            for (var temp in item) {
                                if (item[temp]) {
                                    $("#gridTable").datagrid("hideColumn", temp);
                                }
                                else {
                                    $("#gridTable").datagrid("showColumn", temp);
                                }
                            }
                        });
                    }

                });
            },
            onLoadSuccess:function(data){
//                $("td[field='name']").append('<div class="welfareSubsidy p10" id="welfareSubsidy"></div>');

            },

            onHeaderContextMenu: function (e, field) {
                e.preventDefault();
                if (!$('#tmenu').length) {
                    CustomerPersonalList.CreateColumnMenu();
                }
                $('#tmenu').menu('show', {
                    left: e.pageX,
                    top: e.pageY
                });
            }
        }).datagrid("columnMoving");
        var page = $("#gridTable").datagrid("getPager");
        if (page) {
            page.pagination({
                beforePageText: "第",
                afterPageText: "页    共 {pages} 页",
                displayMsg: "当前显示 {from} - {to} 条记录   共 {total} 条记录"
            });
        }
    },
    CreateColumnMenu: function () {
        var fields = $("#gridTable").datagrid("getColumnFields");
        var tmenu = $('<div id="tmenu" style="width:100px;"></div>').appendTo('body');
        for (var i = 0; i < fields.length; i++) {
            var title = $("#gridTable").datagrid("getColumnOption",fields[i]).title
            if ($("#gridTable").datagrid("getColumnOption", fields[i]).hidden) {
                $('<div></fields>').html(title).attr("id",fields[i]).appendTo(tmenu);
            }
            else {
                $('<div iconCls="icon-ok"></fields>').html(title).attr("id",fields[i]).appendTo(tmenu);
            }
        }
        tmenu.menu({
            onClick: function (item) {
                if (item.iconCls == "icon-ok") {
                    $("#gridTable").datagrid("hideColumn", item.id);
                    tmenu.menu("setIcon", {
                        target: item.target,
                        iconCls: "icon-empty"
                    });
                } else {
                    $("#gridTable").datagrid("showColumn", item.id);
                    tmenu.menu("setIcon", {
                        target: item.target,
                        iconCls: "icon-ok"
                    });
                }
                CustomerPersonalList.SetColumnCookie()
            }
        });
    },
    SetColumnCookie: function () {
        var columnArray = new Array();
        var fields = $("#gridTable").datagrid("getColumnFields");
        for (var i = 0; i < fields.length; i++) {
            var info = new Object();
            var property = $("#gridTable").datagrid("getColumnOption", fields[i]).hidden;
            info[fields[i].toString()] = property == undefined || property == false ? false : true;
            columnArray.push(info);
        }
        $.post($Url.BuildCustomerUrl("/setColumnCookie"), {
            key: "customerPersonalList",
            value: JSON.stringify(columnArray)
        });
    },
    InitQuery: function () {
        var name = $("#name").val();
        var agentNo = $("#agentNo").val();
        var startTime = $("#startTime").val();
        var endTime = $("#endTime").val();
        var cellphone = $("#cellphone").val();
        var sourceType = $("#sourceType").combobox("getValue");
        var relationLevel = $("#relationLevel").combobox("getValue");
        var riskHobby = $("#riskHobby").combobox("getValue");
        var resultStatus = $("#resultStatus").combobox("getValue");
        var isSales = $("#isSales").combobox("getValue");
        $("#gridTable").datagrid("load", {
            name:name,
            startTime:startTime,
            endTime:endTime,
            cellphone:cellphone,
            sourceType:sourceType,
            relationLevel:relationLevel,
            riskHobby:riskHobby,
            resultStatus:resultStatus,
            isSales:isSales,
            agentNo:agentNo,
            showAllList: ElementVar.showAllList,
            showDirectList: ElementVar.showDirectList,
            showChannelList: ElementVar.showChannelList,
            showShopList: ElementVar.showShopList
        });
    },
    InitEnum:function(){
        ChangeManager.ChangeManagerInit();
        $("#sourceType").combobox({
            width:100,
            data: EnumListWithEasyUI.GetEnumListToCombo("customerPersonalSourceTypeListAll", $Url.BuildProductUrl("/common/enumList.action")),
            valueField:'value',
            textField:'text'
        });
        $("#relationLevel").combobox({
            width:100,
            data: EnumListWithEasyUI.GetEnumListToCombo("dicDataforCustomerCompanyRelationLevelAll", $Url.BuildProductUrl("/common/enumList.action")),
            valueField:'value',
            textField:'text'
        });
        $("#resultStatus").combobox({
            width:138,
            data: EnumListWithEasyUI.GetEnumListToCombo("customerFollowResultStatusAll", $Url.BuildProductUrl("/common/enumList.action")),
            valueField:'value',
            textField:'text'
        });
        $("#riskHobby").combobox({
            width:100,
            data: EnumListWithEasyUI.GetEnumListToCombo("dicDataforCustomerCompanyRiskHobbyAll", $Url.BuildProductUrl("/common/enumList.action")),
            valueField:'value',
            textField:'text'
        });
        $("#isSales").combobox({
            width:100,
            data: EnumListWithEasyUI.GetEnumListToCombo("isYesAll", $Url.BuildProductUrl("/common/enumList.action")),
            valueField:'value',
            textField:'text'
        });
        $('#startTime').click(function(){
            WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'});
        });
        $('#endTime').click(function(){
            WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'});
        });
        EmployeeTreeControl.startTree({
            param: "on",  //on在职员工，out离职员工，test测试员工
            treeInputId: "employeeSel",//员工控件框ID
            valInputId: "agentNo", //员工值框id
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
    GetDetailFload: function (id) {
        var url = $Url.BuildCustomerUrl("/customer/customerFollow/ajaxListCustomerFollowLastThree");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {
                "customerFollowId": id
            },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if (data.customerFollowList == null || data.customerFollowList.length == 0) {
                    return;
                }
                var htmlStr = "";
                var contre1 = '<tr>' +
                    '<td>';
                var contre2 = '</td>' +
                    '<td>';
                var contre3 = '</td>' +
                    '</tr>';
                for (var i = 0; i < data.customerFollowList.length; i++) {
                    var nextTimeName = data.customerFollowList[i].nextTimeName.substring(0,10);
                    var timeName = data.customerFollowList[i].timeName.substring(0,10);
                    htmlStr = htmlStr + contre1;
                    htmlStr = htmlStr + data.customerFollowList[i].productName + contre2
                        + data.customerFollowList[i].typeName + contre2
                        + timeName + contre2
                        + nextTimeName + contre2
                        + data.customerFollowList[i].contentName + contre2
                        + data.customerFollowList[i].resultName;
                    htmlStr = htmlStr + contre3;
                }
                $('#w1').window('open');
                $('#followList').html("");
                $('#followList').html(htmlStr);
                EnumList.GetEnumListToSelect($(".alertResultStatus"), "customerFollowResultStatus", $Url.BuildCustomerUrl("/common/enumList.action"));
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    }
}
var ChangeManager = {
    ChangeManagerOpen: function () {
        $('#w').window('open');
        ChangeManager.GetCustomerList();
    },
    SelectDisabled: function () {
        $("#empStatus0").attr("disabled", "disabled");
        $("#empStatus1").attr("disabled", "disabled");
    },
    SelectUnDisabled: function () {
        $("#empStatus0").removeAttr("disabled");
        $("#empStatus1").removeAttr("disabled");
    },
    GetCustomerList: function () {
        var status0ManagerNo = $("#empStatus0").val();
        var status1ManagerNo = $("#empStatus1").val();
        url = $Url.BuildCustomerUrl("/customer/customerPersonal/ajaxGetChangeManager");
        $.ajax({
            type: "POST",
            url: url,
            async: false,
            data: {
                status0ManagerNo: status0ManagerNo,
                status1ManagerNo: status1ManagerNo
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            },
            success: function (data) {
                $("#empStatus0CustomerList").html("");
                for (var int = 0; int < data.empStatus0List.length; int++) {
                    var array_element = data.empStatus0List[int];
                    $("#empStatus0CustomerList").append("<option  value=" + array_element.value + ">" + array_element.text + "</option>");
                }

                $("#empStatus1CustomerList").html("");
                for (var int = 0; int < data.empStatus1List.length; int++) {
                    var array_element = data.empStatus1List[int];
                    $("#empStatus1CustomerList").append("<option disabled='disabled' value=" + array_element.value + ">" + array_element.text + "</option>");
                }
            }
        });
    },
    UpdateManagerNo: function () {
        var manager0No = $("#empStatus0").val();
        var json0 = new Array();
        var customers = $("#empStatus0CustomerList option");
        for (var i = 0; i < customers.length; i++) {
            var info = {};
            info.id = customers.eq(i).val();
            json0.push(info);
        }
        var manager1No = $("#empStatus1").val();
        var json1 = new Array();
        var customers = $("#empStatus1CustomerList option");
        for (var i = 0; i < customers.length; i++) {
            var info = {};
            info.id = customers.eq(i).val();
            json1.push(info);
        }
        var url = $Url.BuildCustomerUrl("/customer/customerPersonal/ajaxUpdateCustomerManagerNo");
        $.ajax({
            type: "POST",
            url: url,
            async: false,
            data: {
                status0ManagerNo: manager0No,
                status1ManagerNo: manager1No,
                empStatus0CustomerValue: JSON.stringify(json0),
                empStatus1CustomerValue: JSON.stringify(json1)
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            },
            success: function (data) {
                if (data.errCode == "OK") {
                    alert("提交成功");
                    ChangeManager.GetCustomerList();
                }
                if (data.errCode == "NO") {
                    alert("提交失败");
                }
            }
        });
    },
    ChangeManagerInit: function () {
        EnumList.GetEnumListToSelect($("#empStatus0"), "employeeStatusDimission", $Url.BuildCustomerUrl("/common/enumList.action"));//离职 有客户的员工
        EnumList.GetEnumListToSelect($("#empStatus1"), "employeeStatusDuty", $Url.BuildCustomerUrl("/common/enumList.action"));//全部在职的员工

        $("#btnChangeManager").click(function () {
            ChangeManager.ChangeManagerOpen();
            ChangeManager.SelectUnDisabled();
        });
        $("#empStatus0CustomerList").dblclick(function () {
            EnumList.ChangeManager("empStatus0CustomerList", "empStatus1CustomerList");
            ChangeManager.SelectDisabled();
        });
        $("#empStatus1CustomerList").dblclick(function () {
            EnumList.ChangeManager("empStatus1CustomerList", "empStatus0CustomerList");
            ChangeManager.SelectDisabled();
        });
        $("#leftToRigth").click(function () {
            EnumList.ChangeManager("empStatus0CustomerList", "empStatus1CustomerList");
            ChangeManager.SelectDisabled();
        });
        $("#rigthToLeft").click(function () {
            EnumList.ChangeManager("empStatus1CustomerList", "empStatus0CustomerList");
            ChangeManager.SelectDisabled();
        });
        $("#empStatus0").change(function () {
            ChangeManager.GetCustomerList();
        });
        $("#empStatus1").change(function () {
            ChangeManager.GetCustomerList();
        });
        $("#ok").click(function () {
            ChangeManager.UpdateManagerNo();
            ChangeManager.SelectUnDisabled();
        });
    }
}
$(function () {
    CustomerPersonalList.InitGrid();
    CustomerPersonalList.InitEnum();

    $("#btnSearch").click(function () {
        CustomerPersonalList.InitQuery();
    });
    $("#btnAdd").click(function () {
        $EasyUI.NewTab("New", $Url.BuildCustomerUrl("/customer/customerPersonal/edit"));
    });
    $("#btnEdit").click(function () {
        var row = $("#gridTable").datagrid("getSelected");
        if (row == null) {
            $.messager.alert({title: '提示',msg: '请选择数据！',showType: 'show'});
            return false;
        }
        $EasyUI.NewTab("Edit", $Url.BuildCustomerUrl("/customer/customerPersonal/edit?id=") + row.id);
    });
    $("#btnDetail").click(function () {
        var row = $("#gridTable").datagrid("getSelected");
        if (row == null) {
            $.messager.alert({title: '提示',msg: '请选择数据！',showType: 'show'});
            return false;
        }
        $EasyUI.NewTab("Detail", $Url.BuildCustomerUrl("/customer/customerPersonal/detail?id=") + row.id);
    });
    $("#btnChangeManager").click(function () {
        ChangeManager.ChangeManagerOpen();
        ChangeManager.SelectUnDisabled();
    });
    $("#establishP2pUser").click(function(){
        var row = $("#gridTable").datagrid("getSelected");
        if (row == null) {
            $.messager.show({
                title: '提示',
                msg: '请选择数据！',
                showType: 'show'
            });
            return false;
        }
        var url = $Url.BuildCustomerUrl("/customer/customerPersonal/ajaxEstablishP2pUser");
        $.ajax({
            type: "POST",
            url: url,
            async: false,
            data: {
                customerPersonalNo: row.id
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {

            },
            success: function (data) {
                if (data.errCode == "failed") {
                    $.messager.alert({msg: data.errDesc,showType: 'show'});
                } else {
                    $.messager.show({msg: '创建成功。',showType: 'show'});
                }
            }
        });
    });
    $("#btnExcel").click(function () {
        var name = $("#name").val();
        var agentNo = $("#agentNo").val();
        var startTime = $("#startTime").val();
        var endTime = $("#endTime").val();
        var cellphone = $("#cellphone").val();
        var sourceType = $("#sourceType").combobox("getValue");
        var relationLevel = $("#relationLevel").combobox("getValue");
        var riskHobby = $("#riskHobby").combobox("getValue");
        var resultStatus = $("#resultStatus").combobox("getValue");
        var isSales = $("#isSales").combobox("getValue");
        var url = $Url.BuildCustomerUrl("customer/customerPersonal/ajaxExportExcel");
        location.href = url + "?" +
            "name=" + name + "&" +
            "startTime=" + startTime + "&" +
            "endTime=" + endTime + "&" +
            "cellphone=" + cellphone + "&" +
            "sourceType=" + sourceType + "&" +
            "relationLevel=" + relationLevel + "&" +
            "riskHobby=" + riskHobby + "&" +
            "resultStatus=" + resultStatus + "&" +
            "isSales=" + isSales + "&" +
            "agentNo=" + agentNo + "&" +
            "sord=desc" + "&" +
            "sidx=id" + "&" +
            "showDirectList=" + ElementVar.showDirectList + "&" +
            "showChannelList=" + ElementVar.showChannelList + "&" +
            "showShopList=" + ElementVar.showShopList + "&" +
            "showAllList=" + ElementVar.showAllList;
    });
});