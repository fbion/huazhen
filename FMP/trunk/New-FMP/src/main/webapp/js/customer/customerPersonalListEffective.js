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
                showShopList: ElementVar.showShopList,
                isSales:1
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
            showShopList: ElementVar.showShopList,
            byIsSales:1
        });
    },
    InitEnum:function(){
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