usingNamespace("UI.EditPwd")["EditPwd"] = {
    buildWarningMessage: function (jqueryObj, msg) {
    	//传入jquery对象的|父级元素|的同级元素|当中找到.Validform_checktip类的元素|移除所有样式|并且把样式换成|.desc .Valideform_wrong .Validform_checktip|并且把这个元素的内容文本换成msg|显示|兄弟节点并且样式是.desc的元素隐藏
    	jqueryObj.parent().siblings().find(".Validform_checktip").removeClass().addClass("desc Validform_wrong Validform_checktip").text(msg).show().siblings(".desc").hide();
    },
    clearWarningMessage: function (jqueryObj) {
    	jqueryObj.parent().siblings().find(".Validform_checktip").removeClass().addClass("desc Validform_wrong Validform_checktip").text("").hide();
    }
};

$(document).ready(function () {//文档加载好了之后

    if ($(".validform").length > 0) {//判断这个元素存在否？如果存在之后的一切开始发生
        var getInfoObj = function () {//定义一个能找到本元素的父元素的第一个元素中的带有（.info）的元素
            return $(this).parent().next().find(".info");
        }

        $(".input").focusin(function () {//设计一个触发事件 带有样式（.input） 的元素的焦点移动上
            if (this.timeout) {	//如果这个元素的timeout 是true
                clearTimeout(this.timeout); //清除
            }
            var infoObj = getInfoObj.call(this);//上面定义的函数的调用
            if (infoObj.siblings(".Validform_right").length != 0) {//之后判断这个元素的兄弟节点存在否？
                return;//不存在这个函数就不用执行了
            }
            infoObj.show().siblings(".desc").hide();//在上边的元素存在的时候。隐藏带有.desc样式元素

        }).focusout(function () {//当焦点移出的时候
            var infoObj = getInfoObj.call(this);//上面定义的函数的调用
            this.timeout = setTimeout(function () {//如果超时
                infoObj.hide().siblings(".Validform_wrong,.Validform_loading").show();//本身隐藏，兄弟中带有2个样式的显示。
            }, 0);

        });      


//        $(".submitpwd").on("click", function () {//修改密码按钮点击的时候
//            $("#submit").trigger("click");//提交
//        });

        var register = $(".validform").Validform({//添加验证控件 建立一个验证对象（validform对象）
            tiptype: 2,//显示验证信息显示位置
            usePlugin: {//密码强度控件
                passwordstrength: {
                    minLen: 6,
                    maxLen: 20
                }
            },
          /*  datatype: {
                "verifyOldPwd": function (gets, obj, curform, datatype) {
                	
                    var reg=/^[\w\W]{6,20}$/;///^[\\w\\W]{6,20}$/;
                    if (!reg.test(gets)){
                        return false;
                    }
                    var result;
                    var url = $Url.BuildWWWUrl("/customer/editPwd/ajaxCheckOldPwd");
                    $.ajax({
                        type: "get",
                        url: url,
                        dataType: "json",
                        async: false,
                        data: { oldPwd: Base64.encode($String.Trim(gets)) },
                        success: function (data) {
                            if (data.message.type == MessageType.Warning)
                                result = data.message.description;
                        }
                    });

                    return result;
                }
            },*/
            callback: function (form) {//验证控件的回调
                if (!($("#pwd").attr("process") === undefined)) {//如果用户名的process属性木有
                    return false;//返回
                }
                $.ajax({//异步发送
                    type: "post",//post方式
                    url:$Url.BuildWWWUrl("/customer/editPwd/ajaxEditPwd"),
                    dataType: "json",//数据类型为json
                    timeout: 30000,//超时时间为
                    data: {//发送数据为一个验证码和用户对象（json）
                    	oldPwd: Base64.encode($String.Trim($("#oldPwd").val())),//加密后的旧的密码
                    	pwd: Base64.encode($String.Trim($("#pwd").val()))//加密后新的密码
                    },
                    beforeSend: function () {//在发送之前放一新个属性作为标记
                        $("#pwd").attr("process", "processing");
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        Base.Common.PromptText.systemError();//错了就错了
                    },
                    success: function (data, textStatus) {//如果ok 取回data
                    	
                        if (data.message.type == MessageType.Error) {//当type 是Error的时候
                            var returnInfo = data.message.description.split(':');//返回的报错内容切割它
                            if (returnInfo.length > 0) {//切割
                            	if (returnInfo[0] == 'oldPwdError') {//同理
                                    UI.EditPwd.EditPwd.buildWarningMessage($("#oldPwd"), returnInfo[1]);
                                }
                                else if (returnInfo[0] == 'pwdError') {//同理
                                    UI.EditPwd.EditPwd.buildWarningMessage($("#pwd"), returnInfo[1]);
                                }
                            }
                            //这里可以执行一些动作
                        }
                        else {
                            $("#eidtPwdOk").html(data.message.description);
                            $("#eidtPwdOk").show();
                        //如果没有返回的错误信息可以跳转到一个新的页面
//                            var redirectUrl = $("#redirectUrl").val();//找到页面的跳转Url的值
//                            if (redirectUrl.length > 0) {//如果存在的话
//                                window.location = redirectUrl;//页面跳转吧！
//                            }
                        }
                        $("#oldPwd").val("").click(function (){$("#eidtPwdOk").hide()});
                    	$("#pwd").val("").click(function (){$("#eidtPwdOk").hide()});
                    	$("#rePwd").val("").click(function (){$("#eidtPwdOk").hide()});
                    },
                    complete: function (XMLHttpRequest, textStatus) {
                        $("#pwd").removeAttr("process");//最后的最后，把这个临时工属性process 开除
                    }
                });

                return false;//这是整个回调callback的返回
            }
        });

        register.addRule([//给上面的验证的validform对象添加规则
            /*{
                ele: "#oldPwd",
                datatype: "verifyOldPwd",//密码的干活//
                //ignore: "ignore",
                nullmsg: "请填写密码",
                errormsg: "6-20位字符，可使用字母、数字或符号的组合",
                sucmsg: " "
                //plugin: "passwordStrength"
            },*/
            {
                ele: "#pwd",
                datatype: "pwd",//密码的干活
                //ignore: "ignore",
                nullmsg: "请填写密码",
                errormsg: "6-20位字符，可使用字母、数字或符号的组合",
                sucmsg: " ",
                plugin: "passwordStrength"
            },
            {
                ele: "#rePwd",//复验密码
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

