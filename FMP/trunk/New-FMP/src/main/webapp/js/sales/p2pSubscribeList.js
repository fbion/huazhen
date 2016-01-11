/**
 * Created by code generator on #time#.
 */
var P2pSubscribeList = {
    InitGrid: function () {
        //默认是通过id倒排序，默认可不写，支持传递多个排序条件
        //var sortList = [{sort:"in_user_no",order:"desc"},{sort:"id",order:"desc"}];
        //var sortList = [{sort:"edit_user_no",order:"desc"}];
        $("#gridTable").datagrid({
            url: $Url.BuildSalesUrl('/sales/p2pSubscribe/easyUIP2pSubscribeList'),
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
                { field: 'id', title: 'ID', align: 'left', halign: 'center',width:'10%', hidden: false, sortable: true },
                { field: 'p2pCustomer', title: '网站客户', align: 'left', halign: 'center',width:'10%', hidden: true, sortable: false },
                { field: 'p2pProductNo', title: '网站产品', align: 'left', halign: 'center',width:'10%', hidden: false, sortable: false,formatter:function(value,row,index){
                    return EnumListWithEasyUI.GetEnumListToGrid(value, "p2pProductList", $Url.BuildNewIndexUrl("/common/enumList.action"));
                } },
                { field: 'realName', title: '名字', align: 'left', halign: 'center',width:'10%', hidden: false, sortable: false },
                { field: 'cellphone', title: '手机号', align: 'left', halign: 'center',width:'10%', hidden: false, sortable: false },
                { field: 'amount', title: '预约金额', align: 'left', halign: 'center',width:'10%', hidden: false, sortable: true },
                { field: 'deptNo', title: '门店', align: 'left', halign: 'center',width:'10%', hidden: false, sortable: false,formatter:function(value,row,index){
                    return EnumListWithEasyUI.GetEnumListToGrid(value, "store", $Url.BuildNewIndexUrl("/common/enumList.action"));
                } },
                { field: 'empNo', title: '理财经理', align: 'left', halign: 'center',width:'10%', hidden: false, sortable: false,formatter:function(value,row,index){
                    return EnumListWithEasyUI.GetEnumListToGrid(value, "empListJq", $Url.BuildNewIndexUrl("/common/enumList.action"));
                } },
                { field: 'status', title: '预约状态', align: 'left', halign: 'center',width:'10%', hidden: false, sortable: false,formatter:function(value,row,index){
                    return EnumListWithEasyUI.GetEnumListToGrid(value, "orderStatus", $Url.BuildNewIndexUrl("/common/enumList.action"));
                } },
                { field: 'visitTime', title: '预约时间', align: 'left', halign: 'center',width:'10%', hidden: false, sortable: true, formatter: function (value, row, index) {
                    if(!$String.IsNullOrEmpty(value)){
                        return value.toDate().format("yyyy-MM-dd HH:mm:ss");
                    }
                } }
               /* { field: 'provinceNo', title: '省', align: 'left', halign: 'center',width:'10%', hidden: true, sortable: false },
                { field: 'cardNumber', title: '证件号码', align: 'left', halign: 'center',width:'10%', hidden: true, sortable: false },
                { field: 'cityNo', title: '市', align: 'left', halign: 'center',width:'10%', hidden: true, sortable: false },
                { field: 'districtNo', title: '区', align: 'left', halign: 'center',width:'10%', hidden: true, sortable: false },
                { field: 'address', title: '地址', align: 'left', halign: 'center',width:'10%', hidden: true, sortable: false },
                { field: 'cardType', title: '身份类型', align: 'left', halign: 'center',width:'10%', hidden: true, sortable: false },
                { field: 'result', title: '处理结果', align: 'left', halign: 'center',width:'10%', hidden: true, sortable: false },
                { field: 'isTest', title: '是否测试', align: 'left', halign: 'center',width:'10%', hidden: true, sortable: false },
                { field: 'customerNo', title: 'customerNo', align: 'left', halign: 'center',width:'10%', hidden: false, sortable: false }*/
            ]],
            onBeforeLoad: function (param) {
                $.getJSON($Url.BuildSalesUrl("/getColumnCookie"), { key: "p2pSubscribeList" }, function (data) {
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
                    P2pSubscribeList.CreateColumnMenu();
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
                P2pSubscribeList.SetColumnCookie()
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
        $.post($Url.BuildSalesUrl("/setColumnCookie"), {
            key: "p2pSubscribeList",
            value: JSON.stringify(columnArray)
        });
    },
    InitQuery: function () {
        var p2pProductNo = $("#p2pProductNo").combobox("getValue");
        var customerName = $("#customerName").val();
        var deptNo = $("#deptNo").combobox("getValue");
        var status = $("#status").combobox("getValue");
        var phone = $("#phone").val();
        var empNo = $("#empNo").val();

        $("#gridTable").datagrid("load", {
            p2pProductNo: p2pProductNo,
            customerName: customerName,
            deptNo:deptNo,
            status:status,
            phone:phone,
            empNo:empNo,
            showAllList:ElementVar.showAllList,
            showNoAssignList:ElementVar.showNoAssignList
        });
    },
}
$(function () {
    P2pSubscribeList.InitGrid();
    $("#p2pProductNo").combobox({
        width:150,
        panelHeight:300,
        data: EnumListWithEasyUI.GetEnumListToCombo("p2pProductList", $Url.BuildProductUrl("/common/enumList.action")),
        valueField:'value',
        textField:'text'
    });
    $("#deptNo").combobox({
        width:150,
        data: EnumListWithEasyUI.GetEnumListToCombo("storeAll", $Url.BuildProductUrl("/common/enumList.action")),
        valueField:'value',
        textField:'text'
    });
    $("#status").combobox({
        width:100,
        data: EnumListWithEasyUI.GetEnumListToCombo("orderStatusAll", $Url.BuildProductUrl("/common/enumList.action")),
        valueField:'value',
        textField:'text'
    });
    $("#btnSearch").click(function () {
        P2pSubscribeList.InitQuery();
    });
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
            $.post($Url.BuildSalesUrl("/sales/p2pSubscribe/ajaxAssignEmpNo"),{infoList:JSON.stringify(rows),userId:$("#assignEmpNo").val()},function(data){
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

});