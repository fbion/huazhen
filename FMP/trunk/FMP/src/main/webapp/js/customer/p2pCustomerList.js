var ManagePage = {
    BindStoreNo: function () {
        $("#byEmpNo").html("");
        $("#byEmpNo").linkageForJqGrid({
            prev: $("#byDeptNo"),
            dataType: "wealthManagers",
            actionUrl: $Url.BuildCustomerUrl("/common/enumList.action"),
            all: true
        });
    },
    DateInputElem: function (value, options) {
        var el = document.createElement("input");
        el.type = "text";
        el.value = value;
        el.onclick = function () {
            el.focus();
            el.select();
            WdatePicker({ dateFmt: 'yyyy-MM-dd HH:mm:ss' });
        };
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
        $("#gridTable").jqGrid({
            url: $Url.BuildCustomerUrl('/customer/p2pCustomer/ajaxListP2pCustomer.action'),
            editurl: $Url.BuildCustomerUrl("/customer/p2pCustomer/ajaxEditP2pCustomer.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作", "ID", "用户名", "密码", "注册时间", "上次登录时间", "邮箱", "手机", "QQ", "微信", "微博", "固定电话", "第三方登录", "证件复印件", "真实名字", "门店", "理财经理", "省", "市", "区", "地址", "密钥", "自然人客户", "证件类型", "证件号", "头像", "状态"],
            colModel: [
                {
                    name: "act", index: "act", width: 60, align: "center", sortable: false
                },
                {
                    name: "id", index: "id", width: 20, align: "center", hidden: true, sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
                },
                {
                    name: "userName", index: "userName", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "password", index: "password", width: 40, align: "left", hidden: true, formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editoptions: { size: 40 }, editrules: {edithidden: true}
                    // name: "qq",       index: "qq",       width: 40, align: "left",hidden:true, formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "registerTime", index: "registerTime", width: 40, align: "left", hidden: true, formoptions: { rowpos: 3, colpos: 1 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 }
                },
                {
                    name: "lastLoginTime", index: "lastLoginTime", width: 40, align: "left", hidden: true, formoptions: { rowpos: 3, colpos: 2 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 }
                },
                {
                    name: "email", index: "email", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "cellphone", index: "cellphone", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "qq", index: "qq", width: 40, align: "left", hidden: true, formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }, editrules: {edithidden: true}
                },
                {
                    name: "weixin", index: "weixin", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }, editrules: {edithidden: true}
                },
                {
                    name: "weibo", index: "weibo", width: 40, align: "left", hidden: true, formoptions: { rowpos: 6, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }, editrules: {edithidden: true}
                },
                {
                    name: "phone", index: "phone", width: 40, align: "left", hidden: true, formoptions: { rowpos: 6, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "thirdPartyUser", index: "thirdPartyUser", width: 40, align: "left", hidden: true, formoptions: { rowpos: 7, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }, editrules: {edithidden: true}
                },
                {
                    name: "cardUrl", index: "cardUrl", width: 40, align: "left", hidden: true, formoptions: { rowpos: 7, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "realName", index: "realName", width: 40, align: "left", formoptions: { rowpos: 8, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "deptNo", index: "deptNo", width: 40, align: "left", formoptions: { rowpos: 8, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }, formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("store", $Url.BuildCustomerUrl("/common/enumList.action"))}
                },
                {
                    name: "empNo", index: "empNo", width: 40, align: "left", formoptions: { rowpos: 9, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }, formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("wealthManagersByUserNo", $Url.BuildCustomerUrl("/common/enumList.action"))}
                },
                {
                    name: "provinceNo", index: "provinceNo", width: 40, align: "left", hidden: true, formoptions: { rowpos: 9, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }, formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("province", $Url.BuildCustomerUrl("/common/enumList.action"))}
                },
                {
                    name: "cityNo", index: "cityNo", width: 40, align: "left", hidden: true, formoptions: { rowpos: 10, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }, editrules: {edithidden: true}, formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("city", $Url.BuildCustomerUrl("/common/enumList.action"))}
                },
                {
                    name: "districtNo", index: "districtNo", width: 40, align: "left", hidden: true, formoptions: { rowpos: 10, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }, formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("district", $Url.BuildCustomerUrl("/common/enumList.action"))}
                },
                {
                    name: "address", index: "address", width: 40, align: "left", hidden: true, formoptions: { rowpos: 11, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }, editrules: {edithidden: true}
                },
                {
                    name: "secretKey", index: "secretKey", width: 40, align: "left", hidden: true, formoptions: { rowpos: 11, colpos: 2 }, sortable: false, editoptions: { size: 40 }
                },
                {
                    name: "password", index: "password", width: 40, align: "left", formoptions: { rowpos: 12, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }

                    //name: "deptNo",     index: "deptNo",   width: 40, align: "left", formoptions: { rowpos: 8, colpos: 2 },  sortable: false, editable: true, editoptions: { size: 40 }, formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("store", $Url.BuildCustomerUrl("/common/enumList.action"))}
                },
                {
                    name: "cardType", index: "cardType", width: 40, align: "left", hidden: true, formoptions: { rowpos: 12, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }, formatter: "select", edittype: "select",editoptions: { size: 1, value: EnumList.GetEnumListToEdit("dicDataforCustomerCompanyCardType", $Url.BuildCustomerUrl("/common/enumList.action"))}
                },
                {
                    name: "cardNumber", index: "cardNumber", width: 40, align: "left", hidden: true, formoptions: { rowpos: 13, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }, editrules: {edithidden: true}
                },
                {
                    name: "avatar", index: "avatar", width: 40, align: "left", hidden: true, formoptions: { rowpos: 13, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "status", index: "status", width: 40, align: "left", hidden: true,editrules: {edithidden: true},formoptions: { rowpos: 14, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }, formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("p2pCustomerStatus", $Url.BuildCustomerUrl("/common/enumList.action"))}

                }
            ],
            sortname: "id",
            sortorder: "desc",
            viewrecords: true,
            rowNum: 10,
            rowList: [10],
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
            postData:{"showCustomerList":ElementVar.showP2pCustomerList},
            pager: "#gridPager",
            gridComplete: function () {
                var space = " | ";
                var ids = $("#gridTable").jqGrid('getCol', 'id', true);
                var realNames = $("#gridTable").jqGrid('getCol','realName',true);
                var p2pCustomers = $("#gridTable").jqGrid('getCol','p2pCustomer',true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;
                    var realName = realNames[i].value;
                    var detail = "";
                    var assign = "";
                    assign= "<a class=\"blue\" href=\"javascript:ManagePage.AssignEmp('"+ realName +"','"+ id + "')\">指定理财经理</a>";
                    detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id + "')\">查看</a>";
                    $("#gridTable").jqGrid("setRowData", id, { act: assign+"|"+detail });
                }
            }
        });
    },
    InitQuery: function () {
        $("#btnSearch").click(function () {
            var p2pCustomerName = $("#p2pCustomerName").val();
            var byDeptNo = $("#byDeptNo").val();
            var byEmpNo = $("#selectEmpNo").val();
            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: {
                    "p2pCustomerName": p2pCustomerName,
                    "byDeptNo": byDeptNo,
                    "byEmpNo": byEmpNo
                },
                page: 1
            }).trigger("reloadGrid");
        });
    },
    GetDetail: function (index) {
        jQuery("#gridTable").jqGrid('editGridRow', index, {
            width: 820, editCaption: "查看记录",
            beforeShowForm: function () {
                $(".DataTD").children().attr("disabled", "disabled");
                $(".EditButton").html("");
            }, afterShowForm: function () {
            }
        });
    },
    AssignEmp:function(realName,p2pCustomer){
        window.location.href=$Url.BuildSalesUrl("/customer/p2pSubscribe/assignNoEmpNo.action")+"?realName="+realName+"&p2pCustomer="+p2pCustomer;
    },
    GetEdit: function (index) {
        jQuery("#gridTable").jqGrid('editGridRow', index, {
            width: 820, reloadAfterSubmit: true, closeAfterEdit: true,
            beforeShowForm: function () {
            }, afterShowForm: function () {
            }, afterSubmit: function (response, postdata) {
                var res = jQuery.parseJSON(response.responseText), ok = res.errDesc == "";

                return [ok, ok ? '' : res.errDesc];
            }
        });
    }

}


$(function () {
    $("#btnBindCustomer").click(function(){
        CustomerPage.BindCustomerPerson();
    });
    EnumList.GetEnumListToSelect($("#byDeptNo"), "storeAll", $Url.BuildCustomerUrl("/common/enumList.action"));
    ManagePage.BindStoreNo();
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
    ManagePage.InitGrid();
    ManagePage.InitQuery();
});