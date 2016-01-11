/**
 * Created by code generator on #time#.
 */
var P2pCustomerList = {
    InitGrid: function () {
        //默认是通过id倒排序，默认可不写，支持传递多个排序条件
        //var sortList = [{sort:"in_user_no",order:"desc"},{sort:"id",order:"desc"}];
        //var sortList = [{sort:"edit_user_no",order:"desc"}];
        $("#gridTable").datagrid({
            url: $Url.BuildCustomerUrl('/customer/p2pCustomer/easyUIP2pCustomerList'),
            method: 'post',
            resizable: true,
            fit: true,
            multiSort: true,
            autoRowHeight: false,
            singleSelect: false,
            toolbar: "#toolbar",
            loadMsg: "正在加载，请稍等...",
            pagination: true,
            pageSize: 15,
            pageList: [15, 30, 50],
            queryParams: {
                showAllList:ElementVar.showAllList,
                showNoAssignList:ElementVar.showNoAssignList
            },
            columns: [[
                { field: 'checkbox', checkbox:"true",width:'5'},
                { field: 'id', title: '编号', align: 'center', halign: 'center',width:'5%', hidden: false, sortable: false },
                { field: 'userName', title: '用户名', align: 'center', halign: 'center', width:'18%',hidden: false, sortable: false },
                { field: 'status', title: '状态', align: 'center', halign: 'center', width:'5%',hidden: false, sortable: false,
                    formatter: function (value) {
                        return EnumListWithEasyUI.GetEnumListToGrid(value, "p2pCustomerStatus", $Url.BuildNewIndexUrl("/common/enumList.action"));
                    }
                },
                { field: 'email', title: '邮箱', align: 'center', halign: 'center',width:'10%', hidden: false, sortable: false },
                { field: 'cellphone', title: '手机号', align: 'center', halign: 'center', width:'10%',hidden: false, sortable: false },
                { field: 'qq', title: 'qq', align: 'center', halign: 'center',width:'8%', hidden: false, sortable: false },
                { field: 'weixin', title: '微信', align: 'center', halign: 'center',width:'8%', hidden: false, sortable: false },
                { field: 'realName', title: '真实姓名', align: 'center', halign: 'center',width:'5%', hidden: false, sortable: false },
                { field: 'deptNo', title: '部门', align: 'center', halign: 'center',width:'10%', hidden: false, sortable: false,
                    formatter: function (value) {
                        return EnumListWithEasyUI.GetEnumListToGrid(value, "store", $Url.BuildNewIndexUrl("/common/enumList.action"));
                    }
                },
                { field: 'empNo', title: '理财经理', align: 'center', halign: 'center',width:'6%', hidden: false, sortable: false,
                    formatter: function (value) {
                        return EnumListWithEasyUI.GetEnumListToGrid(value, "wealthManagersByUserNo", $Url.BuildNewIndexUrl("/common/enumList.action"));
                    }
                },
                { field: 'customerNo', title: '自然人客户', align: 'center', halign: 'center',width:'6%', hidden: false, sortable: false,
                    formatter: function (value) {
                        return EnumListWithEasyUI.GetEnumListToGrid(value, "customerPerson", $Url.BuildNewIndexUrl("/common/enumList.action"),true);
                    }
                },
                { field: 'weibo', title: '微博', align: 'center', halign: 'center', width:'5%',hidden: true, sortable: false },
                { field: 'phone', title: '固定电话', align: 'center', halign: 'center',width:'5%', hidden: true, sortable: false },
                { field: 'provinceNo', title: '省', align: 'center', halign: 'center', width:'5%',hidden: true, sortable: false ,
                    formatter: function (value) {
                        return EnumListWithEasyUI.GetEnumListToGrid(value, "province", $Url.BuildNewIndexUrl("/common/enumList.action"));
                    }
                },
                { field: 'cityNo', title: '市', align: 'center', halign: 'center',width:'5%', hidden: true, sortable: false,
                    formatter: function (value) {
                        return EnumListWithEasyUI.GetEnumListToGrid(value, "city", $Url.BuildNewIndexUrl("/common/enumList.action"));
                    }
                },
                { field: 'districtNo', title: '区', align: 'center', halign: 'center',width:'5%', hidden: true, sortable: false ,
                    formatter: function (value) {
                        return EnumListWithEasyUI.GetEnumListToGrid(value, "district", $Url.BuildNewIndexUrl("/common/enumList.action"));
                    }
                },
                { field: 'address', title: '地址', align: 'center', halign: 'center', width:'5%',hidden: true, sortable: false },
                { field: 'cardType', title: '证件类型', align: 'center', halign: 'center', width:'5%',hidden: true, sortable: false ,
                    formatter: function (value) {
                        return EnumListWithEasyUI.GetEnumListToGrid(value, "dicDataforCustomerCompanyCardType", $Url.BuildNewIndexUrl("/common/enumList.action"));
                    }
                },
                { field: 'cardNumber', title: '证件号', align: 'center', halign: 'center',width:'5%', hidden: true, sortable: false },
                { field: 'registerTime', title: '注册时间', align: 'center', halign: 'center',width:'5%', hidden: true, sortable: false,
                    formatter: function (value, row, index) {
                        if(!$String.IsNullOrEmpty(value)){
                            return value.toDate().format("yyyy-MM-dd");
                        }
                    }
                },
                { field: 'lastLoginTime', title: '上次登录时间', align: 'center', halign: 'center',width:'5%', hidden: true, sortable: false,
                    formatter: function (value, row, index) {
                        if(!$String.IsNullOrEmpty(value)){
                            return value.toDate().format("yyyy-MM-dd");
                        }
                    }
                }
            ]],
            onBeforeLoad: function (param) {
                $.getJSON($Url.BuildCustomerUrl("/getColumnCookie"), { key: "p2pCustomerList" }, function (data) {
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

            onHeaderContextMenu: function (e, field) {
                e.preventDefault();
                if (!$('#tmenu').length) {
                    P2pCustomerList.CreateColumnMenu();
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
                P2pCustomerList.SetColumnCookie()
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
            key: "p2pCustomerList",
            value: JSON.stringify(columnArray)
        });
    },
    InitQuery: function () {
        var userName = $("#userName").val();
        var empNo = $("#empNo").val();
        var deptNo = $("#deptNo").combobox("getValue");
        $("#gridTable").datagrid("load", {
            userName: userName,
            deptNo:deptNo,
            empNo:empNo,
            showAllList:ElementVar.showAllList,
            showNoAssignList:ElementVar.showNoAssignList
        });
    }
}
$(function () {
    P2pCustomerList.InitGrid();
    $("#deptNo").combobox({
        width:140,
        data: EnumListWithEasyUI.GetEnumListToCombo("store", $Url.BuildProductUrl("/common/enumList.action")),
        valueField:'value',
        textField:'text'
    });
    $("#btnSearch").click(function () {
        P2pCustomerList.InitQuery();
    });
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
    EmployeeTreeControl.startTree({
        param: "on",  //on在职员工，out离职员工，test测试员工
        treeInputId: "assignEmployeeSel",//员工控件框ID
        valInputId: "assignEmpNo", //员工值框id
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
    $("#assignEmp").click(function () {
        var rows = $("#gridTable").datagrid("getChecked");
        if (rows.length == 0) {
            $.messager.alert({title: '提示',msg: '请选择数据！',showType: 'show'});
            return false;
        }
        $("#assignDialog").window("open");
        $("#assignOK").unbind().click(function(){
            $("#assignDialog").window("close");
            $.post($Url.BuildSalesUrl("/customer/p2pCustomer/ajaxAssignEmpNo"),{infoList:JSON.stringify(rows),userId:$("#assignEmpNo").val()},function(data){
                if(data.errCode == "0000"){
                    $.messager.show({msg: '已成功指定理财经理。',showType: 'show'});
                    $("#gridTable").datagrid("reload");
                }
                else{
                    $.messager.alert({msg: '系统出现异常，请重新操作。',showType: 'show'});
                }
            });
        });
    });

    $("#buildCustomer").click(function(){
        var rows = $("#gridTable").datagrid("getChecked");
        if (rows.length == 0) {
            $.messager.alert({title: '提示',msg: '请选择数据！',showType: 'show'});
            return false;
        }
        $.post($Url.BuildSalesUrl("/customer/p2pCustomer/ajaxBuildCustomer"),{infoList:JSON.stringify(rows)},function(data){
            if(data.errCode == "0000"){
                $.messager.show({msg: '创建成功。',showType: 'show'});
                $("#gridTable").datagrid("reload");
            }
            else{
                $.messager.alert({msg: data.errDesc +"已被创建为自然人客户，请不要重复创建！",showType: 'show'});
            }
        });
    });
});