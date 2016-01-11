var ManagePage = {
    EnableInput: function () {
        $.each($(".data"), function (index, content) {
            var id = $(this).attr("id");
            if (ElementVar[id] == undefined) {
                $(this).removeAttr("disabled");
            }
            if (ElementVar[id] == TagPermissionType.edit) {
                $(this).removeAttr("disabled");
            }
            if (PageVar.ID == 0 && ElementVar[id] == TagPermissionType.none){
                $(this).parent().remove();
            }
        });
        $("#p2pProductName").attr("disabled", "disabled");
        $("#customerName").attr("disabled", "disabled");
        $("#payerName").attr("disabled", "disabled");
        $("#salesMoney").attr("disabled", "disabled");
        //$("#status").attr("disabled", "disabled");
    },
    DisableInput: function () {
        $(".data").attr("disabled", "disabled");
    },
    ShowEditButton: function (currStatus) {
        if ($("#edit").length > 0)
            $("#edit").show();
        if ($("#submit").length > 0)
            $("#submit").hide();

    },
    HideEditButton: function () {
        if ($("#edit").length > 0)
            $("#edit").hide();
        if ($("#submit").length > 0)
            $("#submit").show();

    },
    GetInfo: function (id) {
        var url = $Url.BuildPaymentUrl("/payment/paymentRefund/ajaxGetPaymentRefund");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: { id: id },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if (data.errCode != "0000") {
                    $("#msg").text(data.errDesc);
                    return;
                }
                $Util.DataToVal(data.info, ElementVar);

                ManagePage.ShowEditButton();
                if ($("#edit").length > 0) {
                    $("#edit").click(function () {
                        ManagePage.EnableInput();
                        ManagePage.HideEditButton();

                    });
                }
                $("#paymentRefund").click(function () {
                    PaymentRefund.PaymentRefund(data.info);
                });
                $("#paymentCheck").click(function () {
                    PaymentRefund.PaymentCheck(data.info);
                });
                $("#paymentCancelRefund").click(function () {
                    PaymentRefund.PaymentCancelRefund(data.info);
                });
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    }
}
var PaymentRefund = {
	    PaymentRefund: function (rowData) {
	        if(Number(rowData.payMoney) <= 0){
	            alert("请填写还款金额!!!")
	            return false;
	        }
	        if (confirm("确定进行还款操作吗？")) {
	            var url = $Url.BuildPaymentUrl("/payment/paymentRefund/ajaxPaymentRefund.action");
	            var info={
	                id: rowData.id,
	                p2pCustomerNo:rowData.p2pCustomerNo,
	                payerNo:rowData.payerNo,
	                salesNo:$(rowData.salesNo).attr("ref"),
	                p2pProductNo:rowData.p2pProductNo,
	                payMoney:rowData.payMoney
	                //payEndTime:rowData.payEndTime
	            }
	            $.ajax({
	                type: "post",
	                url: url,
	                data: {
	                    info:JSON.stringify(info)
	                },
	                beforeSend: function () {
	                },
	                error: function (XMLHttpRequest, textStatus, errorThrown) {
	                    alert(errorThrown);
	                },
	                success: function (data, textStatus) {
//	                    $("#" + rowData.id + " td[aria-describedby='gridTable_status']").text("已还款");
//	                    $("#" + rowData.id + " td[aria-describedby='gridTable_act']").html("<a class=\"blue\"  href=\"javascript:ManagePage.GetDetail('" + data.paymentData.id + "')\">查看</a>");
	                    var	paymentObj = "<form class=\"pay_data\" action="+data.paymentData.url+" method=\"post\"></form>";
	                    $("body").first().append(paymentObj);
	                    var input = "<input name=\"sign\" value=\"" + data.paymentData.sign+ "\"  type=\"text\" />" +
	                        "<textarea name=\"req\" >"+data.paymentData.xml+"</textarea>"
	                    $(".pay_data").html(input);
	                    $(".pay_data").submit();

	                },
	                complete: function (XMLHttpRequest, textStatus) {
	                }
	            });
	        }
	    },
	    PaymentCheck: function (rowData) {
	        if (confirm("确定进行审核通过操作吗？")) {
	            var url = $Url.BuildPaymentUrl("/payment/paymentRefund/ajaxPaymentCheck.action");
	            $.ajax({
	                type: "post",
	                url: url,
	                data: {
	                    id: rowData.id
	                },
	                beforeSend: function () {
	                },
	                error: function (XMLHttpRequest, textStatus, errorThrown) {
	                    alert(errorThrown);
	                },
	                success: function (data, textStatus) {
	                    if(data.errCode == "0000"){
	                        alert("操作还款成功");
//	                        $("#" + rowData.id + " td[aria-describedby='gridTable_status']").text("已还款");
//	                        $("#" + rowData.id + " td[aria-describedby='gridTable_act']").html("");
	                    }
	                    else{
	                        alert("操作失败，请联系系统管理员");
//	                        $("#" + rowData.id + " td[aria-describedby='gridTable_act']").html("");
	                    }
	                },
	                complete: function (XMLHttpRequest, textStatus) {
	                }
	            });
	        }
	    },
	    PaymentCancelRefund: function (rowData) {
	        if(confirm("确定进行取消还款操作吗？")){
	            var url = $Url.BuildPaymentUrl("/payment/paymentRefund/ajaxCancelPaymentRefund.action");
	            $.ajax({
	                type: "post",
	                url: url,
	                data: {
	                    id: rowData.id
	                },
	                beforeSend: function () {
	                },
	                error: function (XMLHttpRequest, textStatus, errorThrown) {
	                    alert(errorThrown);
	                },
	                success: function (data, textStatus) {
	                    if(data.errCode == "0000"){
	                        alert("操作还款失败成功");
//	                        $("#" + rowData.id + " td[aria-describedby='gridTable_status']").text("还款失败");
//	                        $("#" + rowData.id + " td[aria-describedby='gridTable_act']").html("");
	                    }
	                    else{
	                        alert("操作失败，请联系系统管理员");
//	                        $("#" + rowData.id + " td[aria-describedby='gridTable_act']").html("");
	                    }
	                },
	                complete: function (XMLHttpRequest, textStatus) {
	                }
	            });
	        }
	    },
	    CancelSendSms:function(){
	        var ids = $("#gridTable").jqGrid('getGridParam','selarrrow');
	        $.each(ids,function(i,id) {
	            var isSendSms = $("#gridTable").jqGrid('getCell',id,'isSendSms');
	            if(isSendSms==2){
	                alert("选中数据中含有‘已发送’，请重新选择");
	                ids = 0;
	            }
	        });
	        if(ids==0){
	            return;
	        }

	        var url = $Url.BuildPaymentUrl("/payment/paymentRefund/ajaxCancelSendSms.action");
	        $.ajax({
	            ansyc:false,
	            type: "post",
	            url: url,
	            data: {
	                ids:ids.join(",")
	            },
	            beforeSend: function () {
	            },
	            error: function (XMLHttpRequest, textStatus, errorThrown) {
	                alert(errorThrown);
	            },
	            success: function (data, textStatus) {
	                alert(data.errDesc);
	                location.reload()
	            },
	            complete: function (XMLHttpRequest, textStatus) {
	            }
	        });
	    },
	    SendSms:function(){
	        var ids = $("#gridTable").jqGrid('getGridParam','selarrrow');
	        var url = $Url.BuildPaymentUrl("/payment/paymentRefund/ajaxSendSms.action");
	        $.ajax({
	            type: "post",
	            url: url,
	            data: {
	                ids:ids.join(",")
	            },
	            beforeSend: function () {
	            },
	            error: function (XMLHttpRequest, textStatus, errorThrown) {
	                alert(errorThrown);
	            },
	            success: function (data, textStatus) {
	                alert(data.errDesc);
	                location.reload()
	            },
	            complete: function (XMLHttpRequest, textStatus) {
	            }
	        });
	    }
}
$(function () {
    $("#back").click(function () {
        $EasyUI.Close();
    });
    EnumList.GetEnumListToSelect($("#status"),"paymentRefundStatus",$Url.BuildPaymentUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#productType"),"productType",$Url.BuildPaymentUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#payType"),"dicDicPayType",$Url.BuildPaymentUrl("/common/enumList.action"));
    if (Number(PageVar.ID) == 0) {
        ManagePage.EnableInput();
        ManagePage.HideEditButton();
    }
    else {
        ManagePage.GetInfo(PageVar.ID);
    }
    $("#actualPayTime").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'});
    });
	$("#payStartTime").click(function () {
		WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'});
	});
	$("#payEndTime").click(function () {
		WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'});
	});


    var paymentRefundAdd = $("#paymentRefundAdd").Validform({
        tiptype: function (msg, o, cssctl) {
            var objtip = o.obj.siblings(".Validform_checktip");
            cssctl(objtip, o.type);
            objtip.text(msg);
        },
        callback: function (form) {
            if (!($("#submit").attr("process") === undefined)) {
                return false;
            }
            var url = $Url.BuildPaymentUrl("/payment/paymentRefund/ajaxEditPaymentRefund");
            var oper = "add";
            if (Number(PageVar.ID) != 0)
                oper = "edit";

            var info = {
                id: PageVar.ID,
				salesNo: $("#salesNo").val(),
				p2pProductNo: $("#p2pProductNo").val(),
				p2pProductName: $("#p2pProductName").val(),
				p2pCustomerNo: $("#p2pCustomerNo").val(),
				customerName: $("#customerName").val(),
				payerNo: $("#payerNo").val(),
				payerName: $("#payerName").val(),
				salesMoney: $("#salesMoney").val(),
				interest: $("#interest").val(),
				payMoney: $("#payMoney").val(),
				serviceCharge: $("#serviceCharge").val(),
				payStartTime: $("#payStartTime").val().toTimetamp(),
				payEndTime: $("#payEndTime").val().toTimetamp(),
				status: $("#status").val(),
                actualPayTime: $("#actualPayTime").val().toTimetamp(),
                productType: $("#productType").val(),
                payType: $("#payType").val()
            }
            $.ajax({
                type: "post",
                url: url,
                dataType: "json",
                timeout: 30000,
                data: {
                    oper: oper,
                    info: JSON.stringify(info)
                },
                beforeSend: function () {
                    $("#submit").attr("process", "processing");
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(errorThrown);
                },
                success: function (data, textStatus) {
                    if (data.errCode == "0000") {
                        window.location.href = $Url.BuildPaymentUrl("/payment/paymentRefund/edit?id=" + data.errDesc);
                    } else {
                        $("#msg").text(data.errDesc);
                    }
                },
                complete: function (XMLHttpRequest, textStatus) {
                    $("#submit").removeAttr("process");
                }
            });
            return false;
        }
    });
    paymentRefundAdd.addRule([
        {
            ele:"#interest",
            dataType:"*",
            nullmsg:"请填写利息",
            sucmsg:" ",
            errormsg:"请输入正确格式的数字"
        },
        {
            ele:"#payMoney",
            dataType:"*",
            nullmsg:"请填写还款金额",
            sucmsg:" ",
            errormsg:""
        },

    ]);
})
