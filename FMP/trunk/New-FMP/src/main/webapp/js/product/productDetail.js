var FileManage = {
    BindFile: function (pathMap) {
        var fileTypes = [
            {key: 1, name: "单页"},
            {key: 2, name: "推介材料"},
            {key: 3, name: "电子合同"},
            {key: 4, name: "说明书"},
            {key: 5, name: "尽职调查报告"},
            {key: 6, name: "渠道协议模版"},
            {key: 7, name: "成立公告"},
            {key: 8, name: "项目管理报告"},
            {key: 9, name: "产品认购指南"}
        ];
        var readOnly = true;
        $.each(fileTypes, function (index, content) {
            var div = "<div id=\"div_" + content.key + "\" class=\"upload\"></div>";
            $("#uploadDiv").append(div);

            $("#uploadDiv #div_" + content.key).Upload({
                inputID: "upload" + content.key,
                readOnly: readOnly,
                multiple: true,
                fileType: 1,
                url: $Url.BuildProductUrl("/upload.action"),
                paramList: [content.key],
                pathList: (pathMap == undefined || pathMap == null)?[]:pathMap[content.key],
                success: FileManage.SavaFileToDB,
                deleteFile: FileManage.DeleteFile,
                title: content.name
            });
        })
    },
    GetFileList: function () {
        var url = $Url.BuildProductUrl("/product/productAttachment/ajaxListFile");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {productNo: PageVar.ID
            },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if (data.errCode == "0000") {
                    var pathMap = {};
                    $.each(data.resultList, function (index, content) {
                        if (!pathMap[content.type])
                            pathMap[content.type] = [];
                        pathMap[content.type].push({
                            id: content.id,
                            name: content.name,
                            path: $Url.BuildFileUrl(content.path)
                        })
                    });
                    FileManage.BindFile(pathMap);
                } else {
                    alert(data.errDesc);
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    }
}
var ProductDetail = {
    Resize: function () {
        $("#content_center").css("min-height", "1400px");
        $(".gridTable").setGridWidth($('.wrappContent').width());
    },
    GetProductInfo: function (id) {
        var url = $Url.BuildProductUrl("/product/product/ajaxGetProduct");
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
            success: function (data, textStatus) {
                if (data.errCode != "0000") {
                    $("#msg").text(data.errDesc);
                }
                else {
                    $Util.DataToA(data.info,ElementVar);
                    $(".name").val(data.info.name);
                    $(".settlementType").val(data.info.settlementType);
                    $(".expectProfit").val(data.info.expectProfit);
                    $(".productNo").val(data.info.id);
                    $Link.MakeUrl($("#type"), data.info.type, "productType", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#payType"), data.info.payType, "payType", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#issuerNo"), data.info.issuerNo, "issuerNo", $Url.BuildSalesUrl("/common/enumList.action"),$Url.BuildSalesUrl("/product/partnerIssuer/detail"));
                    $Link.MakeUrl($("#status"), data.info.status, "productStatus", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#tendType"), data.info.tendType, "tendType", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#quota"), data.info.quota, "quotaType", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#empNo"), data.info.empNo, "empList", $Url.BuildSalesUrl("/common/enumList.action"),$Url.BuildBaseInfoUrl("/baseInfo/mailList/list"));
                    $Link.MakeUrl($("#agreementStatus"), data.info.agreementStatus, "protocolStatus", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#financierType"), data.info.financierType, "upStreamType", $Url.BuildSalesUrl("/common/enumList.action"));
                    if(data.info.financierType==1){
                        $Link.MakeUrl($("#financierNo"), data.info.financierNo, "FinancierBusiness", $Url.BuildSalesUrl("/common/enumList.action"),$Url.BuildSalesUrl("/product/financierBusiness/detail"));
                    }else{
                        $Link.MakeUrl($("#financierNo"), data.info.financierNo, "financierPersonal", $Url.BuildSalesUrl("/common/enumList.action"),$Url.BuildSalesUrl("/product/financierPersonal/detail"));
                    }
                    if(data.info.isSaleAll==0){
                        $("#isSaleAll").text("否");
                    }else{
                        $("#isSaleAll").text("是");
                    }
                    if(data.info.isTest==0){
                        $("#isTest").text("否");
                    }else{
                        $("#isTest").text("是");
                    }
                    FileManage.GetFileList();
                    Audit.GetWindow(data.info.activitiNo);
                    Audit.InitGrid(data.info.activitiNo);
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
}

var StagesManage = {
    InitGrid: function () {
        //grid start
        $("#stagesGridTable").jqGrid({
            url: $Url.BuildProductUrl('/product/productStages/ajaxListProductStages.action?byProductNo=' + PageVar.ID),
            datatype: "json",
            mtype: 'GET',
            colNames: ["id", "第几期", "成立日期", "到期日期", "成立金额(万)", "成立原因", "修改备注"],
            colModel: [
                {
                    name: "id", index: "id", width: 20, align: "center", sorttype: "number", hidden: true, formoptions: { rowpos: 1, colpos: 1 }, editable: false, editoptions: { readonly: true, size: 40 }
                },
                {
                    name: "stage", index: "stage", width: 40, align: "center", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }, editrules: {required: true, number: true}
                },
                {
                    name: "start", index: "start", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, formatter: "date", formatoptions: { srcformat: 'Y-m-d', newformat: 'Y-m-d' }, editable: true, edittype: 'custom', editoptions: {size: 40 }, editrules: { required: true}
                },
                {
                    name: "end", index: "end", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, formatter: "date", formatoptions: { srcformat: 'Y-m-d', newformat: 'Y-m-d' }, editable: true, edittype: 'custom', editoptions: {size: 40 }, editrules: { required: true}
                },
                {
                    name: "amount", index: "amount", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }, editrules: {required: true, number: true}
                },
                {
                    name: "reason", index: "reason", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
                {
                    name: "editComment", index: "editComment", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }, hidden: true, editrules: {edithidden: true}
                }
            ],
            sortname: "id",
            sortorder: "desc",
//            pager: "#gridPager",
            viewrecords: true,
            rowNum: 10,
            rowList: [10],
            altclass: "altRowsColour",
            shrinkToFit: true,
            autowidth: true,
            height: "auto",
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
            gridComplete: function () {
            }
        });
    }
}
$(function(){
    ProductDetail.Resize();
    ProductDetail.GetProductInfo(PageVar.ID);
    StagesManage.InitGrid();
    $("#back").click(function(){
        $EasyUI.Close();
    });
});