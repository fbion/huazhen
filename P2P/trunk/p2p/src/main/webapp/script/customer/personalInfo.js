var ManagePage = {
		OnclickEditButton:function(){
			$("#editInfoBut").click(function(){
				$("#cancelEditBut").show();
				$("#editInfoBut").hide();
				$("#editP2pCustomerInfo").show();
				$("#p2pCustomerInfo").hide();
				ManagePage.GetCustomerInfo();
			});
			$("#cancelEditBut").click(function(){
				$("#cancelEditBut").hide();
				$("#editInfoBut").show();
				$("#editP2pCustomerInfo").hide();
				$("#p2pCustomerInfo").show();
			});
		},
		GetCustomerInfo:function(){
		     $.ajax({
	                type: "post",
	                url: $Url.BuildWWWUrl("customer/personalInfo/ajaxGetP2pCustomerInfo"),
	                dataType: "json",
	                success: function (data) {
	                	if(data.p2pCustomer.sex!=0){
	                		$("#sex").val(data.p2pCustomer.sex);
	                	}
                		$("#companyName").val(data.p2pCustomer.companyName);
                		$("#companyAddress").val(data.p2pCustomer.companyAddress);
                		$("#address").val(data.p2pCustomer.address);
                		if(data.p2pCustomer.marry!=0){
                			$("#marry").val(data.p2pCustomer.marry);
                		}
	                }
            });
		}
}

$(function () {
	$("#cancelEditBut").hide();
	$("#editP2pCustomerInfo").hide();
	ManagePage.GetCustomerInfo();
	ManagePage.OnclickEditButton();
	if($("#pageAlias").val()=="personalInfo"){
		$("#personalInfo").attr("class", "active");
	}
	var PersonalInfo = $(".personalInfoEdit").Validform({
        tiptype: 3,
        callback: function (form) {
            var customer ={
            		address:$String.Trim($("#address").val()),
            		sex:$String.Trim($("#sex option:selected").val()),
            		marry:$String.Trim($("#marry option:selected").val()),
					companyAddress:$String.Trim($("#companyAddress").val()),
					companyName:$String.Trim($("#companyName").val())
					}
            if (!($(".saveBtn").attr("process") === undefined)) {
                return false;
            }
            $.ajax({
                type: "post",
                url: $Url.BuildWWWUrl("customer/personalInfo/ajaxUpdateInfo"),
                dataType: "json",
                timeout: 30000,
                data: {
                	p2pCustomer: JSON.stringify(customer)
                },
                beforeSend: function () {
                    $(".saveBtn").attr("process", "processing");
                },
                success: function (data) {
                	location.reload();
                	/*if(data.message.type==MessageType.Info){
                		$(".province").val(customer.provinceNo);
                		$(".city").val(customer.cityNo);
                		$(".district").val(customer.districtNo);
                		$("#address").val(customer.address);
                		
                		var returnUrl = $("#returnUrl").html();
                    	if(returnUrl!=""){
                    		window.location.href = returnUrl;
                    	}
                	}
                	*/	
                },
                complete: function (XMLHttpRequest, textStatus) {
                    $(".saveBtn").removeAttr("process");
                }
            });
            return false;
        }
    });
});




/*$(document).ready(function () {
        var register = $(".validform").Validform({
            tiptype: 3,
            callback: function (form) {
                var customer ={
                		provinceNo:$String.Trim($(".province option:selected").val()),
                		cityNo:$String.Trim($(".city option:selected").val()),
                		address:$String.Trim($("#address").val()),
                		districtNo:$String.Trim($(".district option:selected").val())}
                $.ajax({
                    type: "post",
                    url: $Url.BuildWWWUrl("customer/personalInfo/ajaxUpdateInfo"),
                    dataType: "json",
                    timeout: 30000,
                    data: {
                    	p2pCustomer: JSON.stringify(customer)
                    },
                    success: function (data) {
                    	if(data.message.type==MessageType.Info){
                    		$(".msg").html("<font color='green'>"+data.message.description+"</font>");
                    		$(".province").val(customer.provinceNo);
                    		$(".city").val(customer.cityNo);
                    		$(".district").val(customer.districtNo);
                    		$("#address").val(customer.address);
                    		
                    		var returnUrl = $("#returnUrl").html();
                        	if(returnUrl!=""){
                        		window.location.href = returnUrl;
                        	}
                    	}
                    		
                    },
                    complete: function (XMLHttpRequest, textStatus) {
                        $("#realName").removeAttr("process");
                    }
                });

                return false;
            }
        });
    ManagePage.checkCardNo();
    personalInfo.personalInfoSelect();
});
var ManagePage = {
		checkCardNo: function (){
			if($("#cardNo").val()!=""){
		    	$("#cardNumber").attr("disabled","disabled");
		    }else{
		    	$("#cardNumber").removeAttr("disabled","disabled");
		    }
		}
}
var personalInfo = {
	personalInfoSelect : function () {
		var elements = [$(".province"),$(".city"),$(".district")];
		var defVals = [$("#provinceNo").html(),$("#cityNo").html(),$("#districtNo").html()]
		var enumUrl = $Url.BuildWWWUrl("/common/enumList.action");
		var dataTypes = ["getProvince","getCity","getDistrict"];
		$.fn.linkage({	//填充下拉框	省 市区
	        elements: elements,
	        dataTypes: dataTypes,//方法
	        actionUrl: enumUrl,//地址
	        all: true
	    });
		
		for(var i=0;i<elements.length;i++){//set defaultVal
			var supNo = "";
			if(i!=0) supNo = defVals[i-1];
			EnumList.GetEnumListToSelect(elements[i], dataTypes[i]+"All", enumUrl, supNo);
			elements[i].find("option[value='" + defVals[i] + "']").attr("selected",true);
		}
	}
}*/