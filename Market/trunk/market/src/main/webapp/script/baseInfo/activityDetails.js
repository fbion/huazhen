var Map = {
			initHeight:function(ditu){
					ditu.height(ditu.width()*1.2);
			}
}


$(function(){
	
	var activityApply = $("#activityApplyForm").Validform({
		tiptype: function(msg,o,cssctl){
			var objtip=$("#message");
			cssctl(objtip,o.type);
            if(""==msg.trim()){
                objtip.hide();
            }else{
                objtip.show();
            }
			objtip.text(msg);},
			ignoreHidden: true,
			datatype:{
				"verifyCellphone":function (gets, obj, curform, datatype) {
					var regCellphone=/^1[3|7|9][0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|18[0-9]{9}|\d{3,4}-\d{7,8}(-\d{3,4})?$/;
					var result;
	        		if (!regCellphone.test(gets)){
	        			return false;
	        		}
	        		var url = $Url.BuildWWWUrl("/market/activityApply/ajaxCheckCellphone");
	                $.ajax({
	                    type: "post",
	                    url: url,
	                    dataType: "json",
	                    async: false,
	                    data: {
	                    	cellphone :$String.Trim(gets),
	                    	id:$String.Trim($("#id").val())
	                    },
	                    success: function (data, textStatus) {
	                    	if(data.message.type == MessageType.Error){
	                    		result = data.message.description;
	                    		//return result;
	                    	}
	                    }
	                });
	        		return result; 
				}
			},
			callback: function (form) {
				if (!($("#name").attr("process") === undefined)) {
					return false;
				}
				var url = $Url.BuildWWWUrl("/baseInfo/ajaxActivityApply");
				$.ajax({
					type: "post",
					url: url,
					dataType: "json",
					timeout: 30000,
					data: {
						name:$String.Trim($("#name").val()),
						cellphone: $String.Trim($("#cellphone").val()),
						email: $String.Trim($("#email").val()),
						unit: $String.Trim($("#unit").val()),
						job: $String.Trim($("#job").val()),
						id:$String.Trim($("#id").val())
					},
					beforeSend: function () {
						$("#name").attr("process", "processing");
					},
					error: function (XMLHttpRequest, textStatus, errorThrown) {
						Base.Common.PromptText.systemError();
					},
					success: function (data, textStatus) {
						if(data.message.type == MessageType.Info){
							alert(data.message.description);
							$(".informations,.mask").hide();
						}else if(data.message.type == MessageType.Error){
							$("#message").removeClass().addClass("negate Validform_checktip Validform_wrong").text(data.message.description).show();
						}
						
					},
					complete: function (XMLHttpRequest, textStatus) {
						$("#name").removeAttr("process");
					}
				});
				
				return false;
			}
	});
	activityApply.addRule([//给上面的验证的validform对象添加规则
       {
           ele: "#name",
           datatype: "/^[\u4e00-\u9fa5]{2,4}$/",
           //ignore: "ignore",
           nullmsg: "请填写姓名",
           errormsg: "请填写正确的姓名",
           sucmsg: " "
       },
       {
           ele: "#cellphone",
           datatype: "verifyCellphone",
           //ignore: "ignore",
           nullmsg: "请填写手机号码",
           errormsg: "请填写正确格式的手机号码",
           sucmsg: " "
       },
       {
    	   ele: "#unit",
    	   datatype: "/^[\u4e00-\u9fa5]+$/",
    	   //ignore: "ignore",
    	   nullmsg: "请填写您的单位",
    	   errormsg: "只支持中文",
    	   sucmsg: " "
       }
   ]);
});

$(document).ready(function(e) {
	$('.goenlist').click(function(e) {
          	$('.mask,.informations').show();  
        });
		$('.closeBtn').click(function(e) {
            $('.mask,.informations,.enterinto,.map').hide();
        });	
//        $('.goshares').click(function(e) {
//            $('.mask,.enterinto').show();
//        });	
        $('.registration_place').click(function(e){
			$('.map').show();
			Map.initHeight($("#dituContent"));
			//setTimeout("window.map.centerAndZoom(new BMap.Point(longitude,latitude),17)",400);
			initMap();
		});
});
