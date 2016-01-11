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
            url: $Url.BuildCustomerUrl('/customer/paymentMoneyRecharge/ajaxListPaymentMoneyRecharge.action'),
            editurl: $Url.BuildCustomerUrl("/customer/paymentMoneyRecharge/ajaxEditPaymentMoneyRecharge.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","id","流水号","账户编号","客户名","账户号类型","客户名","充值类型","支付方式","充值金额（元）","备注","状态","返回码","返回说明","创建时间","第三方支付平台回执更新时间","平台编号","监管批次","对账状态","会计日期","结算日期","渠道结算日期","手续费（元）","付手续费方","手续费状态"],
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
					name: "customerName",hidden:true, index: "customerName", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "rechargeType", index: "rechargeType", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "bankType", index: "bankType", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "amount", index: "amount", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "note", index: "note",hidden:true, width: 40, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "state", index: "state", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 },formatter:ManagePage.FmatterState
				},
				{
					name: "resultCode", index: "resultCode",hidden:true, width: 40, align: "left", formoptions: { rowpos: 6, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "resultNote", index: "resultNote",hidden:true, width: 40, align: "left", formoptions: { rowpos: 7, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "timeCreate", index: "timeCreate", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 2 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 },formatter:ManagePage.ToDDMMMYYYY
				},
				{
					name: "bankTime", index: "bankTime",hidden:true, width: 40, align: "left", formoptions: { rowpos: 8, colpos: 1 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 },formatter:ManagePage.ToDDMMMYYYY
				},
				{
					name: "channelNo", index: "channelNo",hidden:true, width: 40, align: "left", formoptions: { rowpos: 8, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "monitorBatched", index: "monitorBatched",hidden:true, width: 40, align: "left", formoptions: { rowpos: 9, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "checkState", index: "checkState",hidden:true, width: 40, align: "left", formoptions: { rowpos: 9, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "dateWork", index: "dateWork",hidden:true, width: 40, align: "left", formoptions: { rowpos: 10, colpos: 1 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 },formatter:ManagePage.ToDDMMMYYYY
				},
				{
					name: "dateSettle", index: "dateSettle",hidden:true, width: 40, align: "left", formoptions: { rowpos: 10, colpos: 2 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 },formatter:ManagePage.ToDDMMMYYYY
				},
				{
					name: "checkDate", index: "checkDate",hidden:true, width: 40, align: "left", formoptions: { rowpos: 11, colpos: 1 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 },formatter:ManagePage.ToDDMMMYYYY
				},
				{
					name: "moneyFactorage", index: "moneyFactorage",hidden:true, width: 40, align: "left", formoptions: { rowpos: 11, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "customerMoneyFactorage", index: "customerMoneyFactorage",hidden:true, width: 40, align: "left", formoptions: { rowpos: 12, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "factorageState", index: "factorageState",hidden:true, width: 40, align: "left", formoptions: { rowpos: 12, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
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
        $EasyUI.NewTab("Edit", $Url.BuildCustomerUrl("/customer/paymentMoneyRecharge/edit?id="+index));
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
    	var stateArr = ["充值中","充值成功","充值失败"];
    	var op = $("<option></option>").text("全部").val("");
    	obj.append(op);
    	for (var i=0;i<stateArr.length;i++){
    		var op = $("<option></option>").text(stateArr[i]).val(i);
    		obj.append(op);
    	}
    },
    FmatterState:function(cellvalue){
    	if(cellvalue==0){
    		return "充值中";
    	}else if(cellvalue==1){
    		return "充值成功";
    	}else if(cellvalue==2){
    		return "充值失败";
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