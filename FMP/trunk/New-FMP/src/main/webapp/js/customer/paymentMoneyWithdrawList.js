var ManagePage = {
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
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildCustomerUrl('/customer/paymentMoneyWithdraw/ajaxListPaymentMoneyWithdraw.action'),
            editurl: $Url.BuildCustomerUrl("/customer/paymentMoneyWithdraw/ajaxEditPaymentMoneyWithdraw.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","id","流水编号","账户编号","客户编号","账户号类型","客户名","提现类型","银行类型","银行编号","开户行名称","开户行地区代码","账户","户名","提现金额（元）","备注","返回码","返回说明","状态","创建时间","第三方支付回执更新时间","渠道编号","监管批次","对账状态","会计日期","结算日期","渠道结算日期","账务冻结变动流水","手续费（元）","付手续费方","手续费状态"],
            colModel: [

				{
					name: "act", index: "act", width: 40, align: "center", sortable: false
				},
				{
					name: "id", index: "id",hidden:true, width: 40, align: "left", formoptions: { rowpos: 1, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "sn", index: "sn", width: 40, align: "left", formoptions: { rowpos: 1, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "accountNo", index: "accountNo",hidden:true, width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "customerNo", index: "customerNo", width: 40, align: "left", formoptions: { rowpos: 12, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }, formatter: "select", edittype: "select",editoptions: { size: 1, value: EnumList.GetEnumListToEdit("p2pCustomerListWithRealName", $Url.BuildCustomerUrl("/common/enumList.action"))}
				},
				{
					name: "accountType", index: "accountType", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "customerName", index: "customerName",hidden:true, width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "withdrawType", index: "withdrawType", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "bankType", index: "bankType", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "bankCode", index: "bankCode", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "bankName", index: "bankName", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "bankAddressNo", index: "bankAddressNo", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "bankCardNo", index: "bankCardNo",hidden:true, width: 40, align: "left", formoptions: { rowpos: 6, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "bankCardName", index: "bankCardName",hidden:true, width: 40, align: "left", formoptions: { rowpos: 7, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "amount", index: "amount", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "note", index: "note",hidden:true, width: 40, align: "left", formoptions: { rowpos: 8, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "resultCode", index: "resultCode",hidden:true, width: 40, align: "left", formoptions: { rowpos: 8, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "resultNote", index: "resultNote",hidden:true, width: 40, align: "left", formoptions: { rowpos: 9, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "state", index: "state", width: 40, align: "left", formoptions: { rowpos: 10, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 },formatter:ManagePage.FmatterState
				},
				{
					name: "timeCreate", index: "timeCreate", width: 50, align: "left", formoptions: { rowpos: 9, colpos: 2 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 },formatter:ManagePage.ToDDMMMYYYY
				},
				{
					name: "bankTime", index: "bankTime",hidden:true, width: 40, align: "left", formoptions: { rowpos: 10, colpos: 1 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 },formatter:ManagePage.ToDDMMMYYYY
				},
				{
					name: "channelNo", index: "channelNo",hidden:true, width: 40, align: "left", formoptions: { rowpos: 11, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "monitorBatched", index: "monitorBatched",hidden:true, width: 40, align: "left", formoptions: { rowpos: 11, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "checkState", index: "checkState",hidden:true, width: 40, align: "left", formoptions: { rowpos: 12, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "dateWork", index: "dateWork",hidden:true, width: 40, align: "left", formoptions: { rowpos: 12, colpos: 2 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 },formatter:ManagePage.ToDDMMMYYYY
				},
				{
					name: "dateSettle", index: "dateSettle",hidden:true, width: 40, align: "left", formoptions: { rowpos: 13, colpos: 1 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 },formatter:ManagePage.ToDDMMMYYYY
				},
				{
					name: "checkDate", index: "checkDate",hidden:true, width: 40, align: "left", formoptions: { rowpos: 13, colpos: 2 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 },formatter:ManagePage.ToDDMMMYYYY
				},
				{
					name: "refSnFreeze", index: "refSnFreeze",hidden:true, width: 40, align: "left", formoptions: { rowpos: 14, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "moneyFactorage", index: "moneyFactorage",hidden:true, width: 40, align: "left", formoptions: { rowpos: 14, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "customerMoneyFactorage", index: "customerMoneyFactorage",hidden:true, width: 40, align: "left", formoptions: { rowpos: 15, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "factorageState", index: "factorageState",hidden:true, width: 40, align: "left", formoptions: { rowpos: 15, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				}                
            ],
            sortname: "sn",
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
            pager: "#gridPager",
            gridComplete: function () {
                var ids = $("#gridTable").jqGrid('getCol', 'id', true);
                var sns = $("#gridTable").jqGrid('getCol', 'sn', true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;
                    var sn = sns[i].value;
                    var detail = "";
                    var edit = "";

                    detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + sn + "')\">查看</a>";

                    $("#gridTable").jqGrid("setRowData", id, { act: detail });
                }
            }
        });
    },
    InitQuery: function () {
        $("#btnSearch").click(function () {
        	var bySn = $("#bySn").val();
            var byState = $("#byState").val();
            var byDate = $("#byDate").val();


            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: { 
                	"bySn": bySn,
                	"byState": byState,
                	"byDate": byDate
                	},
                page: 1
            }).trigger("reloadGrid");
        });
    },
    GetDetail: function (index) {
        $EasyUI.NewTab("Edit", $Url.BuildCustomerUrl("/customer/paymentMoneyWithdraw/edit?id="+index));
    },
    
    GetAdd: function () {
        $EasyUI.NewTab("New", $Url.BuildCustomerUrl("/customer/paymentMoneyWithdraw/edit"));
    },
    ToDDMMMYYYY:function(date, options, rowObject) {  
        var d = new Date(date);  
        var dd = d.getDate() < 10 ? "0" + d.getDate() : d.getDate().toString(); 
        var mm = d.getMonth()+1< 10 ? "0" + (d.getMonth()+1):(d.getMonth()+1).toString();  
        var yyyy = d.getFullYear().toString();
        var hh = d.getHours()< 10 ? "0" + d.getHours() : d.getHours().toString();
        var MM = d.getMinutes()<10? "0" + d.getMinutes() : d.getMinutes().toString();
        var ss = d.getSeconds()<10? "0" + d.getSeconds() : d.getSeconds().toString();
        return yyyy +"-"+ mm + "-"+dd+" "+hh+":"+MM+":"+ss;  
    },
    GetState:function(obj){
    	var stateArr = ["提现申请登记","登记成功 ","登记失败","支付中","提现成功","提现失败"];
    	var op = $("<option></option>").text("全部").val("");
    	obj.append(op);
    	for (var i=0;i<stateArr.length;i++){
    		var op = $("<option></option>").text(stateArr[i]).val(i);
    		obj.append(op);
    	}
    },
    FmatterState:function(cellvalue){
    	if(cellvalue==0){
    		return "提现申请登记";
    	}else if(cellvalue==1){
    		return "登记成功";
    	}else if(cellvalue==2){
    		return "登记失败";
    	}else if(cellvalue==3){
    		return "支付中";
    	}else if(cellvalue==4){
    		return "提现成功";
    	}else if(cellvalue==5){
    		return "提现失败";
    	}
    }
}


$(function () {

    ManagePage.InitGrid();
    ManagePage.InitQuery();
    ManagePage.GetState($("#byState"));
    $("#byDate").click(function () {
		WdatePicker({dateFmt: 'yyyy-MM-dd'});
	});
});