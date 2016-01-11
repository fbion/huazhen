var ManagePage = {

    InitGrid: function () {
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildEmployeeUrl('/employee/employee/ajaxListEmployee.action'),
            editurl: $Url.BuildEmployeeUrl("/employee/employee/ajaxEditEmployee.action"),
            datatype: "json",
            mtype: 'GET',
            postData: {
                showAllList: ElementVar.showAllList
            },
            colNames: ["操作", "编号", "编码", "头像", "path", "员工姓名 ", "在职状态", "性别", "邮箱", "微信", "QQ", "电话", "手机1", "手机2", "地址", "婚姻状况", "用户", "所属部门", "所属公司", "员工上级", "职位", "职称", "职称级别", "修改备注", "是否发送邮件"],
            colModel: [

                {
                    name: "act", index: "act", width: 60, align: "center", sortable: false
                },
                {
                    name: "id",
                    index: "id",
                    width: 20,
                    align: "center",
                    sorttype: "number",
                    formoptions: {rowpos: 1, colpos: 1},
                    editable: false,
                    editoptions: {readonly: true, size: 20}
                },
                {
                    name: "code",
                    index: "code",
                    width: 40,
                    align: "left",
                    formoptions: {rowpos: 2, colpos: 1},
                    sortable: false,
                    editable: true,
                    editoptions: {size: 20},
                    hidden: true,
                    editrules: {edithidden: true}
                },
                {
                    name: "img", index: "img", width: 40, align: "center", sortable: false
                },
                {
                    name: "portraitPath",
                    index: "portraitPath",
                    width: 40,
                    hidden: true,
                    align: "left",
                    formoptions: {rowpos: 2, colpos: 2},
                    sortable: false,
                    editable: true,
                    editoptions: {size: 20},
                    editrules: {edithidden: true, required: true}
                },
                {
                    name: "name",
                    index: "name",
                    width: 40,
                    align: "left",
                    formoptions: {rowpos: 2, colpos: 2},
                    sortable: false,
                    editable: true,
                    editoptions: {size: 20},
                    editrules: {edithidden: true, required: true}
                },
                {
                    name: "status",
                    index: "status",
                    width: 20,
                    align: "left",
                    formoptions: {rowpos: 2, colpos: 2},
                    sortable: false,
                    editable: true,
                    editoptions: {size: 20},
                    editrules: {edithidden: true, required: true},
                    formatter: "select",
                    edittype: "select",
                    editoptions: {
                        size: 1,
                        value: EnumList.GetEnumListToEdit("employeeStatusAll", $Url.BuildEmployeeUrl("/common/enumList.action"))
                    }
                },
                {
                    name: "sex",
                    index: "sex",
                    width: 40,
                    align: "left",
                    formatter: "select",
                    edittype: "select",
                    editoptions: {
                        size: 1,
                        value: EnumList.GetEnumListToEdit("dicDicDataForEmployeeSex", $Url.BuildEmployeeUrl("/common/enumList.action"))
                    },
                    formoptions: {rowpos: 3, colpos: 1},
                    sortable: false,
                    editable: true,
                    hidden: true,
                    editrules: {edithidden: true}
                },
                {
                    name: "email",
                    index: "email",
                    width: 40,
                    align: "left",
                    formoptions: {rowpos: 3, colpos: 2},
                    sortable: false,
                    editable: true,
                    editoptions: {size: 20},
                    hidden: true,
                    editrules: {edithidden: true, required: false, email: true}
                },
                {
                    name: "weixin",
                    index: "weixin",
                    width: 40,
                    align: "left",
                    formoptions: {rowpos: 4, colpos: 1},
                    sortable: false,
                    editable: true,
                    editoptions: {size: 20},
                    hidden: true,
                    editrules: {edithidden: true}
                },
                {
                    name: "qq",
                    index: "qq",
                    width: 40,
                    align: "left",
                    formoptions: {rowpos: 4, colpos: 2},
                    sortable: false,
                    editable: true,
                    editoptions: {size: 20},
                    hidden: true,
                    editrules: {edithidden: true}
                },
                {
                    name: "telephone",
                    index: "telephone",
                    width: 40,
                    align: "left",
                    formoptions: {rowpos: 5, colpos: 1},
                    sortable: false,
                    editable: true,
                    editoptions: {size: 20},
                    hidden: true,
                    editrules: {
                        edithidden: true,
                        required: false,
                        custom: true,
                        custom_func: ManagePage.Mytelephonecheck
                    }
                },
                {
                    name: "cellphone1",
                    index: "cellphone1",
                    width: 40,
                    align: "left",
                    formoptions: {rowpos: 5, colpos: 2},
                    sortable: false,
                    editable: true,
                    editoptions: {size: 20},
                    editrules: {
                        edithidden: true,
                        required: false,
                        custom: true,
                        custom_func: ManagePage.Mycellphonecheck
                    }
                },
                {
                    name: "cellphone2",
                    index: "cellphone2",
                    width: 40,
                    align: "left",
                    formoptions: {rowpos: 6, colpos: 1},
                    sortable: false,
                    editable: true,
                    editoptions: {size: 20},
                    hidden: true,
                    editrules: {
                        edithidden: true,
                        required: false,
                        custom: true,
                        custom_func: ManagePage.Mycellphonecheck
                    }
                },
                {
                    name: "address",
                    index: "address",
                    width: 40,
                    align: "left",
                    formoptions: {rowpos: 6, colpos: 2},
                    sortable: false,
                    editable: true,
                    editoptions: {size: 20},
                    hidden: true,
                    editrules: {edithidden: true}
                },
                {
                    name: "marry",
                    index: "marry",
                    width: 40,
                    align: "left",
                    formatter: "select",
                    edittype: "select",
                    editoptions: {
                        size: 1,
                        value: EnumList.GetEnumListToEdit("dicDicDataForEmployeeMarry", $Url.BuildEmployeeUrl("/common/enumList.action"))
                    },
                    formoptions: {rowpos: 3, colpos: 1},
                    formoptions: {rowpos: 7, colpos: 1},
                    sortable: false,
                    editable: true,
                    hidden: true,
                    editrules: {edithidden: true}
                },
                {
                    name: "userNo",
                    index: "userNo",
                    width: 40,
                    align: "left",
                    formatter: "select",
                    edittype: "select",
                    editoptions: {
                        size: 1,
                        value: EnumList.GetEnumListToEdit("user", $Url.BuildEmployeeUrl("/common/enumList.action"))
                    },
                    formoptions: {rowpos: 7, colpos: 2},
                    sortable: false,
                    editable: true
                },
                {
                    name: "deptNo",
                    index: "deptNo",
                    width: 40,
                    align: "left",
                    formatter: "select",
                    edittype: "select",
                    editoptions: {
                        size: 1,
                        value: EnumList.GetEnumListToEdit("dept", $Url.BuildEmployeeUrl("/common/enumList.action"))
                    },
                    formoptions: {rowpos: 8, colpos: 2},
                    sortable: false,
                    editable: true
                },
                {
                    name: "companyNo",
                    index: "companyNo",
                    width: 40,
                    align: "left",
                    formatter: "select",
                    edittype: "select",
                    editoptions: {
                        size: 1,
                        value: EnumList.GetEnumListToEdit("empCompanylist", $Url.BuildEmployeeUrl("/common/enumList.action"))
                    },
                    formoptions: {rowpos: 8, colpos: 1},
                    sortable: false,
                    editable: true
                },
                {
                    name: "parentNo",
                    index: "parentNo",
                    width: 40,
                    align: "left",
                    formatter: "select",
                    edittype: "select",
                    editoptions: {
                        size: 1,
                        value: EnumList.GetEnumListToEdit("empListById", $Url.BuildEmployeeUrl("/common/enumList.action"))
                    },
                    formoptions: {rowpos: 9, colpos: 1},
                    sortable: false,
                    editable: true
                },
                {
                    name: "positionNo",
                    index: "positionNo",
                    width: 40,
                    align: "left",
                    formatter: "select",
                    edittype: "select",
                    editoptions: {
                        size: 1,
                        value: EnumList.GetEnumListToEdit("positionList", $Url.BuildEmployeeUrl("/common/enumList.action"))
                    },
                    formoptions: {rowpos: 9, colpos: 2},
                    sortable: false,
                    editable: true,
                    hidden: true,
                    editrules: {edithidden: true}
                },
                {
                    name: "positionTitle",
                    index: "positionTitle",
                    width: 40,
                    align: "left",
                    formoptions: {rowpos: 10, colpos: 1},
                    sortable: false,
                    editable: true,
                    editoptions: {size: 20},
                    hidden: true,
                    editrules: {edithidden: true}
                },
                {
                    name: "positionLevelNo",
                    index: "positionLevelNo",
                    width: 40,
                    align: "left",
                    formatter: "select",
                    edittype: "select",
                    editoptions: {
                        size: 1,
                        value: EnumList.GetEnumListToEdit("positionLevelList", $Url.BuildEmployeeUrl("/common/enumList.action"))
                    },
                    formoptions: {rowpos: 10, colpos: 2},
                    sortable: false,
                    editable: true,
                    hidden: true,
                    editrules: {edithidden: true}
                },
                {
                    name: "editComment",
                    index: "editComment",
                    width: 40,
                    align: "left",
                    formoptions: {rowpos: 11, colpos: 1},
                    sortable: false,
                    editable: true,
                    editoptions: {size: 20},
                    hidden: true,
                    editrules: {edithidden: true}
                },
                {
                    name: "isSendEmail",
                    index: "isSendEmail",
                    width: 40,
                    align: "left",
                    formoptions: {rowpos: 11, colpos: 1},
                    sortable: false,
                    editable: true,
                    editoptions: {size: 20},
                    hidden: true,
                    editrules: {edithidden: true}
                }
            ],
            sortname: "id",
            sortorder: "desc",
            pager: "#gridPager",
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
            pager: "#gridPager",
            gridComplete: function () {
                var space = "  |  ";
                var ids = $("#gridTable").jqGrid('getCol', 'id', true);
                var userNos = $("#gridTable").jqGrid('getCol', 'userNo', true);
                var paths = $("#gridTable").jqGrid('getCol', 'portraitPath', true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;
                    var path = paths[i].value;
                    var userNo = userNos[i].value;
                    var editAdd = "";
                    var positive = "";
                    var delay = "";

                    editAdd = "<a class=\"blue\" href=\"javascript:ManagePage.GetEditAdd('" + id + "')\">查看详情</a>";

                    if ($("#" + id + " td[aria-describedby='gridTable_status']").text() == "试用") {
                        positive = "<a class=\"blue\" href=\"javascript:ManagePage.GetPositive('" + id + "','" + "positive" + "','" + userNo + "')\">通知转正</a>";
                        delay = "<a class=\"blue\" href=\"javascript:ManagePage.GetPositive('" + id + "','" + "delay" + "','" + userNo + "')\">通知延迟</a>";
                        $("#gridTable").jqGrid("setRowData", id, {act: editAdd + space + positive + space + delay});
                    } else {
                        $("#gridTable").jqGrid("setRowData", id, {act: editAdd});
                    }
                    var img = "<img alt=\"员工头像\" id=\"emphead\" class=\"emphead\" src=\"" + $Url.BuildFileUrl(path) + "\" style=\"width:100px;height=200px\">";
                    $("#gridTable").jqGrid("setRowData", id, {img: img});

//                    ManagePage.GetAuditComment(data.info.activitiNo,data.empName);

                }
            }
        });
    },
    InitQuery: function () {
        $("#btnSearch").click(function () {
            var byName = $("#txtName").val();
            var bySex = $("#selectDicData").val();
            var byCompany = $("#selectCompany").val();
            var byDept = $("#selectDept").val();
            var byVerify = $("#selectVerify").val();
            var byStatus = $("#byStatus").val();
            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: {
                    "byName": byName,
                    "bySex": bySex,
                    "byCompany": byCompany,
                    "byDept": byDept,
                    "byVerify": byVerify,
                    "status": byStatus
                },
                page: 1
            }).trigger("reloadGrid");
        });
    },

    GetPositive: function (id, isPositive, userNo) {
        var content = ""
        if (isPositive == "positive") {
            content = "确认通知该员工转正？"
        }
        if (isPositive == "delay") {
            content = "确认通知该员工延迟转正"
        }
        if (confirm(content)) {
            if (isPositive == "delay") {
//                $.post($Url.BuildEmployeeUrl("/employee/probationWorkSummary/ajaxGetWorkSummaryByEmpNo"),{empNo:id},function(data){
                    var url = $Url.BuildWorkFlowUrl('/workFlow/processing/ajaxStartExtendProbationApplicationProcesss');
                    ManagePage.StartAudit($("#txtName"), url, "", userNo);
//                });
            }
            if (isPositive == "positive") {
                $.post($Url.BuildEmployeeUrl("/employee/probationWorkSummary/ajaxGetWorkSummaryByEmpNo"),{empNo:id},function(data){
                    var infoId = 0;
                    if(JSON.stringify(data.info) != "null"){
                        infoId = data.info.id;
                    }
                    var url = $Url.BuildWorkFlowUrl('/workFlow/processing/ajaxStartProbationEvaluationProcess');
                    ManagePage.StartAuditNow($("#txtName"), url, "", userNo, infoId);
                });
            }
            alert("发送成功");
        }
    },

    GetEditAdd: function (id) {
        window.open($Url.BuildEmployeeUrl("/employee/employee/edit?id=") + id);
    },
    GetAddAdd: function () {
        window.open($Url.BuildEmployeeUrl("/employee/employee/edit"))
    },


    GetAdd: function () {
        jQuery("#gridTable").jqGrid('editGridRow', "new", {
            reloadAfterSubmit: true, closeAfterAdd: true, editCaption: "添加记录",
            beforeShowForm: function () {
                ManagePage.BindCompanyAndDept();
                $("#tr_id").css("visibility", "hidden");
                $("#code").attr("disabled", "disabled");
                ManagePage.ShowPoint();
                EnumList.GetEnumListToSelect($("#userNo"), "userForNew", $Url.BuildEmployeeUrl("/common/enumList.action"));
            }, afterShowForm: function () {
            }, afterSubmit: function (response, postdata) {
                var res = jQuery.parseJSON(response.responseText), ok = res.errDesc == "";

                return [ok, ok ? '' : res.errDesc];
            }
        });
    },
    ShowPoint: function () {
        var empName = $("#name").parent().prev().text();
        $("#name").parent().prev().html(empName + "<em class='color'>*</em>");
    },
    Mytelephonecheck: function (value, telephone) {
        //var reg = /^1\d{10}$/ ;
        var reg = /(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$/;
        if (reg.test(value))
            return [true, "OK！"];
        else
            return [false, "请输入正确的电话格式！"];
    },
    Mycellphonecheck: function (value, telephone) {
        var reg = /^1\d{10}$/;
        //var reg =  /(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$/;
        if (reg.test(value))
            return [true, "OK！"];
        else
            return [false, "请输入正确的手机格式！"];
    },
    BindCompanyAndDept: function () {
        var dept = $("#deptNo").val();
        $("#deptNo").html("");
        $("#deptNo").linkageForJqGrid({
            prev: $("#companyNo"),
            dataType: "deptListByCompany",
            actionUrl: $Url.BuildEmployeeUrl("/common/enumList.action"),
            all: false
        });
        $("#deptNo").val(dept);
    },
    GetDate: function (strat, end, obj) {
        var op = $("<option></option>").text("全部").val(0);
        obj.append(op);
        for (var i = strat; i <= end; i++) {
            var op = $("<option></option>").text(i).val(i);
            obj.append(op);
        }
    },
    ChangeManagerOpen: function () {    //批量修改负责人
        $('#w').window('open');
    },
    ChangeManagerClose: function () {   //批量修改负责人
        $('#w').window('close');
    },

    EmployeeExcel: function () {
        year = $("#year").val();
        month = parseInt($("#month").val());
        if (year == 0 || month == 0) {
            var d = new Date();
            var year = d.getFullYear();
            var month = d.getMonth();
        }
        location.href = "http://172.16.28.4/upload/files/"
            + year + "/" + month + "/人事报表.xls"
    },
    Resize: function () {
        $("#content_center").css({"min-height": "803px", "height": 1800});
    },
    GetAuditComment: function (activitiNo, empName) {
        var url = $Url.BuildWorkFlowUrl("/workFlow/processing/ajaxAuditComment");
        $.ajax({
            type: "POST",
            url: url,
            dataType: "html",
            data: {
                "activitiNo": activitiNo
            },
            error: function (request) {
                //alert(request);
            },
            success: function (data) {
                if (empName != null && empName != "" && data.indexOf(empName) > -1) {
                    //$("#examine").hide();
                }
                $("#aduitComment").append(data);
                $("#check1").hide();
                ManagePage.Resize();
            }
        })
    },
    StartAudit: function (obj, url, activitiNo, id) {
        var uri = $Url.BuildEmployeeUrl("/employee/extendProbationApplication/edit?activitiNo=");
        var sendData = {
            per: "通过",
            id: id,
            activitiNo: activitiNo,
            comment: "",
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
                //alert(request);
            },
            success: function (data, textStatus) {
                if ($String.IsNullOrEmpty(activitiNo)) {
//					alert("提交成功");
                    window.location.href = $Url.BuildEmployeeUrl("/employee/extendProbationApplication/edit?id=" + PageVar.ID + "&activitiNo=" + data.activitiNo);
                } else {
//					alert("审批成功");
                    window.location.href = $Url.BuildEmployeeUrl("/employee/extendProbationApplication/edit?id=" + PageVar.ID + "&activitiNo=" + activitiNo);
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
    StartAuditNow: function (obj, url, activitiNo, id,infoId) {
        var uri = $Url.BuildEmployeeUrl("/employee/probationWorkSummary/edit?id=" + infoId + "&activitiNo=");
        var sendData = {
            per: "通过",
            id: id,
            activitiNo: activitiNo,
            comment: "",
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
                //alert(request);
            },
            success: function (data, textStatus) {
                if ($String.IsNullOrEmpty(activitiNo)) {
//					alert("提交成功");
                    window.location.href = $Url.BuildEmployeeUrl("/employee/probationWorkSummary/edit?id=" + PageVar.ID + "&activitiNo=" + data.activitiNo);
                } else {
//					alert("审批成功");
                    window.location.href = $Url.BuildEmployeeUrl("/employee/probationWorkSummary/edit?id=" + PageVar.ID + "&activitiNo=" + activitiNo);
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
    GetWindow: function (activitiNo) {
        if ($String.IsNullOrEmpty(activitiNo)) {
            $("#submitExamine").click(function () {
                var url = $Url.BuildWorkFlowUrl('/workFlow/processing/ajaxStartExtendProbationApplicationProcesss');
                ManagePage.StartAudit($("#submit1"), url, activitiNo);
            });
        } else {
            $("#examine").click(function () {
                $('#w1').window('open');
            });
            $(".examine").click(function () {
                var url = $Url.BuildWorkFlowUrl("/workFlow/auditTask/ajaxAddExamine.action");
                ManagePage.StartAudit($(this), url, activitiNo);
            });
        }
    },
    GetUrlActivitNo: function () {
        var urlTemp = location.search;
        var theRequest = new Object();
        var strs = "";
        if (urlTemp.indexOf("?") != -1) {
            var str = urlTemp.substr(1);
            if (str.indexOf("activitiNo=") != -1) {
                strs = str.split("activitiNo=")[1];
            }
        }
        return strs;
    }
//    format:function(data){
//        var result = [];
//        $.each(data.listItems,function(i,item) {
//            var row = {};
//            row.id = item.value;
//            row.text = item.text;
//            result.push(row);
//        });
//        return result;
//    }
}


$(function () {
    ManagePage.Resize();
    $("#btnAdd").click(function () {
        ManagePage.GetAdd();
    });
//    $.ajax({
//        method: "POST",
//        url: $Url.BuildEmployeeUrl("/common/enumList.action?type=dicDicDataForEmployeeSex"),
//        success: function (data) {
//            $("#sexList").select2({
//                placeholder: "请选择",
//                data: ManagePage.format(data)
//            });
//            $("#sexList").val(-1).trigger("change");
//        }
//    });
    $("#btnAddNew").click(function () {
        ManagePage.GetAddAdd();
    });
    ManagePage.GetDate(2014, 2020, $("#year"));
    ManagePage.GetDate(1, 12, $("#month"));
    EnumList.GetEnumListToSelect($("#byStatus"), "employeeStatus", $Url.BuildEmployeeUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#selectDicData"), "dicDicDataForEmployeeSexAll", $Url.BuildEmployeeUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#selectVerify"), "employeeVerifyAll", $Url.BuildEmployeeUrl("/common/enumList.action"))

    ManagePage.InitGrid();
    ManagePage.InitQuery();
    EmployeeTreeControl.startTree({
        param: "on",  //on在职员工，out离职员工，test测试员工
        treeInputId: "departmentSel",//员工控件框ID
        valInputId: "selectDept", //员工值框id
        inputType: "employee",//employee员工，position职位
        idType: "deptNo",        //员工empNo，userNo,职位positionNo,部门deptNo，公司companyNo
        chkStyle: "radio",//选框类型checkbox,radio
        nochecks: [true, false],      //逐级不显示单或复选框,true不显示，false显示
        chkboxType: {Y: "ps", N: "ps"},  //Y被勾选时关联父类子类ps，N取消被勾选时关联父类子类ps
        showPreBut: true,   //显示全部员工，在职员工按钮,离职员工，test测试员工
        //showSearch: true,   //显示搜索框
        showLevel: 2,         //显示层级
        sizeAuto: true,		//自动调节大小
        width: 200,			//宽，单位px
        height: 300			//高，单位px
    });
    $("#btnExcel").click(function () {
        var url = $Url.BuildEmployeeUrl("/employee/employeeInformation/ajaxExportExcel");
        location.href = url + "?" +
            "sord=desc" + "&" +
            "sidx=id";
    });
    $("#btnExcelEmployee").click(function () {
        ManagePage.ChangeManagerOpen();
        $("#ok").click(function () {
            ManagePage.EmployeeExcel();
            ManagePage.ChangeManagerClose();
        });

    });

    $("#btnExcelWxEmployee").click(function () {
        var url = $Url.BuildEmployeeUrl("/employee/employeeInformation/ajaxWxExportExcel");
        location.href = url + "?" +
            "sord=desc" + "&" +
            "sidx=id";
    });

});