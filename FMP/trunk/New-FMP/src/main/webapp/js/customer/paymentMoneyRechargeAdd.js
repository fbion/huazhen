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
        var url = $Url.BuildCustomerUrl("/customer/paymentMoneyRecharge/ajaxGetPaymentMoneyRecharge");
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
				if (!$String.IsNullOrEmpty(data.info.timeCreate)) {
					var timeCreate = new Date(data.info.timeCreate);
					$("#timeCreate").val(timeCreate.format("yyyy-MM-dd HH:mm:ss"));
					}
				if (!$String.IsNullOrEmpty(data.info.bankTime)) {
					var bankTime = new Date(data.info.bankTime);
					$("#bankTime").val(bankTime.format("yyyy-MM-dd HH:mm:ss"));
					}
				if (!$String.IsNullOrEmpty(data.info.dateWork)) {
					var dateWork = new Date(data.info.dateWork);
					$("#dateWork").val(dateWork.format("yyyy-MM-dd HH:mm:ss"));
					}
				if (!$String.IsNullOrEmpty(data.info.dateSettle)) {
					var dateSettle = new Date(data.info.dateSettle);
					$("#dateSettle").val(dateSettle.format("yyyy-MM-dd HH:mm:ss"));
					}
				if (!$String.IsNullOrEmpty(data.info.checkDate)) {
					var checkDate = new Date(data.info.checkDate);
					$("#checkDate").val(checkDate.format("yyyy-MM-dd HH:mm:ss"));
					}

                ManagePage.ShowEditButton();
                if ($("#edit").length > 0) {
                    $("#edit").click(function () {
                        ManagePage.EnableInput();
                        ManagePage.HideEditButton();

                    });
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    }
}
var BindEnumList={
	BindAll:function(){
		BindEnumList.BindCustomer();
		BindEnumList.BindState();
	},
	BindCustomer:function(){
		EnumList.GetEnumListToSelect($("#customerNo"), "p2pCustomerListWithRealName", $Url.BuildEmployeeUrl("/common/enumList.action"));
	},
	BindState:function(){
		EnumList.GetEnumListToSelect($("#state"),"paymentMoneyRechargeState",$Url.BuildEmployeeUrl("/common/enumList.action"));
	}
}
$(function () {
	BindEnumList.BindAll();
    $("#back").click(function () {
//        window.location.href = $Url.BuildCustomerUrl("/customer/paymentMoneyRecharge/list");
        $EasyUI.Close();
    });

    if (Number(PageVar.ID) == 0) {
        ManagePage.EnableInput();
        ManagePage.HideEditButton();
    }
    else {
        ManagePage.GetInfo(PageVar.ID);
    }

	$("#timeCreate").click(function () {
		WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'});
	});
	$("#bankTime").click(function () {
		WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'});
	});
	$("#dateWork").click(function () {
		WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'});
	});
	$("#dateSettle").click(function () {
		WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'});
	});
	$("#checkDate").click(function () {
		WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'});
	});

})
