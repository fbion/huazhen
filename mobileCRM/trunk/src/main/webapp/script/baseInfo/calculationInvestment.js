var ManagePage = {

}
$(function () {
	var CalculationInvestment = $("#calculationInvestment").Validform({
		tiptype:function(msg,o,cssctl){
			var objtip = $("#message");
			cssctl(objtip,o.type);
			objtip.text(msg);
		},
        callback: function (form) {
            if (!($("#message").attr("process") === undefined)) {
                return false;
            }
            $.ajax({
                type: "post",
                url: $Url.BuildWWWUrl("/baseInfo/calculationa/ajaxCalculationInvestment"),
                dataType: "json",
                timeout: 30000,
                data: {
                	n:$String.Trim($("#n").val()),
                	loanRates:$String.Trim($("#loanRates").val()),
                	finishedAutomobile:$String.Trim($("#finishedAutomobile").val()),
                	downPayment:$String.Trim($("#downPayment").val())
                },
                beforeSend: function () {
                    $("#message").attr("process", "processing");
                },
                success: function (data) {
                	if(data.errcode=="00"){
                		$("#message").removeClass().addClass("negate Validform_checktip Validform_wrong").text("不满足投资条件");
                	}else{
                		$("#totalLoanInterest").html(data.totalLoanInterest);
                		$("#rente").html(data.rente);
                		$("#x").html(data.x);
                	}
                },
                complete: function (XMLHttpRequest, textStatus) {
                    $("#message").removeAttr("process");
                }
            });
            return false;
        }
    });
	CalculationInvestment.addRule([            
          {
              ele: "#n",
              datatype: "/^[1-9]\\d*$/",
              nullmsg: "请输入期限",
              errormsg: "请输入正确的期限",
              sucmsg: " "
          },
          {
              ele: "#loanRates",
              datatype: "/^(?:0|[1-9][0-9]?|100)(\\.\\d+)?$/",
              nullmsg: "请输入贷款利率",
              errormsg: "请输入正确的贷款利率",
              sucmsg: " "
          }, 
  		  {				
  		      ele:"#finishedAutomobile",
  		      datatype:"/^[1-9]\\d*$/",
  		      nullmsg:"请输入车款",
  		      errormsg:"请输入正确的车款",
  		      sucmsg:" "
  		  }, 
		  {				
			  ele:"#downPayment",
			  datatype:"/^(?:0|[1-9][0-9]?|100)(\\.\\d+)?$/",
			  nullmsg:"请输入首付比例",
			  errormsg:"请输入正确的首付比例",
			  sucmsg:" "
		  }
        
          ]);
  	
});