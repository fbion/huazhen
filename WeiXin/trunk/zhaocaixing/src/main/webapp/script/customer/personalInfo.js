$(document).ready(function () {
    if ($(".validform").length > 0) {
        var register = $(".validform").Validform({
            tiptype:function (msg, o, cssctl) {
			   var objtip = o.obj.parent().parent().next(".Validform_checktip");
				 cssctl(objtip, o.type);
				 objtip.text(msg);
			},
            callback: function (form) {
                if (!($("#realname").attr("process") === undefined)) {
                    return false;
                }
                var customer ={realname:$String.Trim($("#realName").val()),
                		cardNumber:$String.Trim($("#cardNumber").val()),
                		cellPhone:$String.Trim($("#cellPhone").val()),
                		provinceNo:$String.Trim($(".province option:selected").val()),
                		cityNo:$String.Trim($(".city option:selected").val()),
                		address:$String.Trim($("#address").val()),
                		districtNo:$String.Trim($(".district option:selected").val())}
                $.ajax({
                    type: "post",
                    url: $Url.BuildWWWUrl("customer/personalInfo/ajaxPersonalInfo"),
                    dataType: "json",
                    timeout: 30000,
                    data: {
                    	p2pCustomer: JSON.stringify(customer)
                    },
                    beforeSend: function () {
                        $("#realName").attr("process", "processing");
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                    	//alert(errorThrown);
                    },
                    success: function (data) {
                    	if(data.message.type==MessageType.Info){
                    		$(".msg").html("<font color='green'>"+data.message.description+"</font>");
                    		$("#cardNumber").attr("disabled","disabled");
                    		
                    		$("#cardNumber").val(customer.cardNumber);
                    		$("#cellPhone").val(customer.cellPhone);
                    		$("#realName").val(customer.realname);
                    		$(".province").val(customer.provinceNo);
                    		$(".city").val(customer.cityNo);
                    		$(".district").val(customer.districtNo);
                    		$("#address").val(customer.address);
                    		
                    		var returnUrl = $("#returnUrl").html();
                        	if(returnUrl!=""){
                        		window.location.href = returnUrl;
                        	}
                    	}
                    	if(data.message.type==MessageType.Warning){
                    		$(".card").html("<font color='red'>"+data.message.description+"</font>");
                    		$("#cardNumber").removeAttr("disabled");
                    	}   
                    	
                    		
                    },
                    complete: function (XMLHttpRequest, textStatus) {
                        $("#realName").removeAttr("process");
                    }
                });

                return false;
            }
        });

        register.addRule([
            {
            	 ele: "#cardNumber",
                 datatype: "idcard",//idcardTest|
                 //ignore: "ignore",
                 nullmsg: "请填写信息！",
                 errormsg: "请输入正确的身份证号！",
                 sucmsg: " "
            	 
            },
            {
            	  ele: "#cellPhone",
                  datatype: "m",
                  //ignore: "ignore",
                  nullmsg: "请填写信息！",
                  errormsg: "请输入您的手机号码！",
                  sucmsg: " "
            },
            {
            ele: "#realName",
            datatype: "/^[\u4e00-\u9fa5]{2,4}$/",
            //ignore: "ignore",
            nullmsg: "请填写中文名！",
            errormsg: "请输入2到4个中文字符！",
            sucmsg: " "
    		}
        ]);
    }
    
    

    
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
/*$("#cardNumber").click(function(){
	$.ajax({//同步请求
		type: "get",//get 方式
		url: $Url.BuildWWWUrl("customer/personalInfo/checkCardNumber"),//访问地址如上
		dataType: "json",//请求格式为json
		async: false,//同步
		data: { cardNumber:$String.Trim($("#cardNumber").val()) },//传入的参数为用户名
		success: function (data) {//请求发送OK，返回data
			if (data.message.type == MessageType.Warning)//如果data中的message的类型是Waring
				result = data.message.description;//就把信息内容放入result中间		
			}
	});
});*/
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
}





