var ManagePage = {
    InitGrid: function () {
        $("#gridTable").jqGrid(
            {
                url: $Url.BuildProductUrl('/product/p2pProduct/ajaxListP2pProduct.action'),
                editurl: $Url.BuildProductUrl("/product/p2pProduct/ajaxEditP2pProduct.action"),
                datatype: "json",
                mtype: 'GET',
                colNames: ["操作","ID","","名称","描述","收益(%)","项目期限(天)","剩余天数","还款周期","总额度","进度(%)","剩余额度","打款个数","状态","成立日期","债权到期日","流程"],
                colModel: [
                    {name: "act", index: "act", width: 60, align: "center", sortable: false},
                    {name: "id", index: "id", width: 20, align: "center", hidden:true,sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }},
                    {name: "productNo", index: "productNo", width: 40, align: "left",hidden:true, formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }},
                    {name: "name", index: "name", width: 80, align: "left",formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }},
                    {name: "description", index: "description", width: 40, align: "center", hidden:true, formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }},
                    {name: "income", index: "income", width: 30, align: "center", formoptions: { rowpos: 3, colpos: 2 }, sortable: true, editable: true, editoptions: { size: 40 }},
                    {name: "duration", index: "duration", width: 35, align: "center", formoptions: { rowpos: 4, colpos: 2 }, sortable: true, editable: true, editoptions: { size: 40 }},
                    {name: "editComment", index: "editComment", width: 30, align: "center",formoptions: { rowpos: 11, colpos: 2 }, sortable: true, editable: true, editoptions: { size: 40 }},
                    {name: "repaymentIssue", index: "repaymentIssue", width: 40, align: "center", formoptions: { rowpos: 4, colpos: 2 }, sortable: true, editable: true, editoptions: { size: 40 },formatter: "select", edittype: "select",editoptions: { size: 1, value: EnumList.GetEnumListToEdit("p2pProductRepayIssue", $Url.BuildProductUrl("/common/enumList.action"))}},
                    {name: "totalAmout", index: "totalAmout", width: 40, align: "center", formoptions: { rowpos: 5, colpos: 1 }, sortable: true, editable: true, editoptions: { size: 40 }},
                    {name: "progress", index: "progress", width: 35, align: "center", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }},
                    {name: "remainAmout", index: "remainAmout", width: 40, align: "center", formoptions: { rowpos: 6, colpos: 1 }, sortable: true, editable: true, editoptions: { size: 40 }},
                    {name: "orderCount", index: "orderCount", width: 30, align: "center", formoptions: { rowpos: 7, colpos: 1 }, sortable: true, editable: true, editoptions: { size: 40 }},
                    {name: "status", index: "status", width: 20, align: "center", formoptions: { rowpos: 7, colpos: 2 }, sortable: true, editable: true, editoptions: { size: 40 },formatter: "select", edittype: "select",editoptions: { size: 1, value: EnumList.GetEnumListToEdit("productStatus", $Url.BuildProductUrl("/common/enumList.action"))}},
                    {name: "start", index: "start", width: 40, align: "center", formatter: "date", formatoptions: { srcformat: 'Y-m-d', newformat: 'Y-m-d' },formoptions: { rowpos: 8, colpos: 1 }, sortable: true, editable: true, editoptions: { size: 40 }},
                    {name: "end", index: "end", width: 40, align: "center", formatter: "date", formatoptions: { srcformat: 'Y-m-d', newformat: 'Y-m-d' },formoptions: { rowpos: 8, colpos: 2 }, sortable: true, editable: true, editoptions: { size: 40 }},
                    {name: "activitiNo", index: "activitiNo", width: 80, align: "left",hidden:true,formoptions: { rowpos: 9, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }},
                ],
                sortable:true,
                sortname: "status",
                sortorder: "asc",
                viewsortcols:[true,'vertical',false],
                viewrecords: true,
                rowNum: 10,
                rowList: [ 10, 20, 40 ],
                altclass: "altRowsColour",
                shrinkToFit: true,
                autowidth: true,
                height: "auto",
                // multiselect: true,
                prmNames: {
                    search: "search",
                    page: "pageIndex",
                    rows: "pageSize"
                },
                postData: {
                    type:"5"
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
                    var ids = $("#gridTable").jqGrid('getCol','id', true);
                    var productNos = $("#gridTable").jqGrid('getCol','productNo',true);
                    var activitiNos = $("#gridTable").jqGrid('getCol','activitiNo',true);
                    var statuses = $("#gridTable").jqGrid('getCol', 'status', true);
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i].id;
                        var productNo = productNos[i].value;
                        var activitiNo = activitiNos[i].value;
                        var detail = "";
                        var edit = "";
                        var status = statuses[i].value;
                        if(status=="30"){//在售
                            $("#gridTable #"+id+" td[aria-describedby='gridTable_status']").addClass("colorBlue");
                        }
                        detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id + "','" + productNo +"','" +activitiNo+ "')\">查看</a>";
                        edit = "<a class=\"blue\" href=\"javascript:ManagePage.GetEdit('" + id + "','" + productNo +"','" +activitiNo+ "')\">编辑</a>";
                        $("#gridTable").jqGrid("setRowData", id, {act: detail+"|"+edit});

//                        var days = ManagePage.DateDiff(start,end)
//                        $("#gridTable").jqGrid("setRowData", id, {remainingDays: days});
                    }
                }
            });
    },
    DateDiff:function(sDate1,sDate2){
        var  aDate,  oDate1,  oDate2,  iDays
        aDate  =  sDate1.split("-")
        oDate1  =  new  Date(aDate[1]  +  '-'  +  aDate[2]  +  '-'  +  aDate[0])    //转换为12-18-2006格式
        aDate  =  sDate2.split("-")
        oDate2  =  new  Date(aDate[1]  +  '-'  +  aDate[2]  +  '-'  +  aDate[0])
        iDays  =  parseInt(Math.abs(oDate1  -  oDate2)  /  1000  /  60  /  60  /24)    //把相差的毫秒数转换为天数
        return  iDays
    },


    InitQuery: function () {
        $("#btnSearch").click(function () {
            // var byName = $("#byName").val();
            var byProductName = $("#byProductName").val();
            var byStatus = $("#byStatus").val();
            var byLevel = $("#byLevel").val();
            var startTime = $("#startTime").val();
            var endTime = $("#endTime").val();
            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: {
                    "byProductName": byProductName,
                    "byStatus": byStatus,
                    "byLevel":byLevel,
                    "startTime":startTime,
                    "endTime":endTime
                },
                page: 1
            }).trigger("reloadGrid");
        });
    },
    GetDetail: function (id, productNo, activitiNo) {
        window.open($Url.BuildProductUrl("/product/p2pProduct/detail?id=" + id + "&productNo=" + productNo + "&activitiNo=" + activitiNo));
    },
    GetEdit: function (id, productNo, activitiNo) {
        window.open($Url.BuildProductUrl("/product/p2pProduct/edit?id=" + id + "&productNo=" + productNo + "&activitiNo=" + activitiNo));
    },
    GetAdd: function () {
        window.open($Url.BuildProductUrl("/product/p2pProduct/edit"));
    }
}

$(function () {
    $(".date").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd'});
    });
    $("#btnAdd").click(function () {
        ManagePage.GetAdd();
    });
    EnumList.GetEnumListToSelect($("#byStatus"), "p2pProductPartStatusAll", $Url.BuildProductUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#byLevel"), "priority", $Url.BuildProductUrl("/common/enumList.action"));
    ManagePage.InitGrid();
    ManagePage.InitQuery();
});