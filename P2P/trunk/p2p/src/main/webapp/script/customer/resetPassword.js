usingNamespace("UI.LogReg")["resetPwd"] = {
    buildWarningMessage: function (jqueryObj, msg) {

        jqueryObj.parent().siblings().find(".Validform_checktip").removeClass().addClass("desc Validform_wrong Validform_checktip").text(msg).show().siblings(".desc").hide();
    },
    clearWarningMessage: function (jqueryObj) {

        jqueryObj.parent().siblings().find(".Validform_checktip").removeClass().addClass("desc Validform_wrong Validform_checktip").text("").hide();
    }
};

$(document).ready(function () {

    if ($(".create_password").length > 0) {

        var getInfoObj = function () {
            return $(this).parent().next().find(".info");
        }

        $(".input").focusin(function () {
            if (this.timeout) {	
                clearTimeout(this.timeout);
            }
            var infoObj = getInfoObj.call(this);
            if (infoObj.siblings(".Validform_right").length != 0) {
                return;
            }
            infoObj.show().siblings(".desc").hide();

        }).focusout(function () {
            var infoObj = getInfoObj.call(this);
            this.timeout = setTimeout(function () {
                infoObj.hide().siblings(".Validform_wrong,.Validform_loading").show();
            }, 0);

        });

        var resetPwd = $(".create_password").Validform({
        	tiptype:function(msg,o,cssctl){
	        	var objtip=$("#msg");
	        	cssctl(objtip,o.type);
	        	objtip.text(msg);
	        	},
            usePlugin:{
                passwordstrength:{
                    minLen: 6,
                    maxLen: 20
                }
            },
            ignoreHidden:true,
            callback: function (form) {
                if (!($("#pwd").attr("process") === undefined)) {
                    return false;
                }
                $.ajax({
                    type: "post",
                    url: $Url.BuildWWWUrl("customer/forgetPassword/ajaxResetPassword"),//地址
                    dataType: "json",
                    timeout: 30000,
                    data: {
                        password: Base64.encode($String.Trim($("#pwd").val())),
                        key:$("#key").val(),
                        ci: $QueryString.Get("ci"),
		                cn: $QueryString.Get("cn"),
		                t: $QueryString.Get("t")
                    },
                    beforeSend: function () {
                        $("#pwd").attr("process", "processing");
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        Base.Common.PromptText.systemError();
                    },
                    success: function (data, textStatus) {
                        if (data.message.type == MessageType.Error) {
                            var returnInfo = data.message.description.split(':');
                            if (returnInfo.length > 0) {
                                if (returnInfo[0] == 'pwdError') {
                                    UI.LogReg.resetPwd.buildWarningMessage($("#pwd"), returnInfo[1]);
                                    }
                            }
                        }
                        else {
                            var redirectUrl = $("#redirectUrl").val();
                            if (redirectUrl.length > 0) {
                                window.location = redirectUrl;
                            }
                        }
                    },
                    complete: function (XMLHttpRequest, textStatus) {
                        $("#pwd").removeAttr("process");
                    }
                });

                return false;
            }
        });

        resetPwd.addRule([
            {
                ele: "#pwd",
                datatype: "pwd",
                //ignore: "ignore",
                nullmsg: "请填写密码",
                errormsg:"6-20位字符，可使用字母、数字或符号的组合，不建议使用纯数字，纯字母，纯符号",
                sucmsg: " ",
                plugin: "passwordStrength"
            },
            {
                ele: "#pwd_confirm",
                datatype: "pwd",
                //ignore: "ignore",
                nullmsg: "请再次输入密码",
                errormsg: "两次输入的密码不一致",
                sucmsg: " ",
                recheck: "pwd"
            }
        ]);
    }
});