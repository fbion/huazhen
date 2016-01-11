/**
 * Created by paul on 15-3-19.
 */
usingNamespace("UI.LogReg")["resetPwd"] = {//设定命名空间("UI.LogReg")["Register"]
    buildWarningMessage: function (jqueryObj, msg) {//这是一个创建警告信息的函数
        //传入jquery对象的|父级元素|的同级元素|当中找到.Validform_checktip类的元素|移除所有样式|并且把样式换成|.desc .Valideform_wrong .Validform_checktip|并且把这个元素的内容文本换成msg|显示|兄弟节点并且样式是.desc的元素隐藏
        jqueryObj.parent().siblings().find(".Validform_checktip").removeClass().addClass("desc Validform_wrong Validform_checktip").text(msg).show().siblings(".desc").hide();
    },
    clearWarningMessage: function (jqueryObj) {
        //传人jquery对象的父级元素的兄弟元素中样式是（.Validform_checktip）的元素移除样式|增加新的样式（.desc .Validform-wrong Validform_checjtip）的内容移除之|
        jqueryObj.parent().siblings().find(".Validform_checktip").removeClass().addClass("desc Validform_wrong Validform_checktip").text("").hide();
    }
};

$(document).ready(function () {//文档加载好了之后

    if ($(".create_password").length > 0) {//判断这个元素存在否？如果存在之后的一切开始发生

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

        var resetPwd = $(".create_password").Validform({//添加验证控件 简历一个验证对象（validform对象）
            tiptype: 2,//显示验证信息显示位置
            usePlugin: {//密码强度控件
                passwordstrength: {
                    minLen: 6,
                    maxLen: 20
                }
            },
            callback: function (form) {//验证控件的回调
                if (!($("#pwd").attr("process") === undefined)) {//如果用户名的process属性木有
                    return false;//返回
                }

                $.ajax({//异步发送
                    type: "post",//post方式
                    url: $Url.BuildWWWUrl("customer/forgetPassword/ajaxResetPassword"),//地址
                    dataType: "json",//数据类型为json
                    timeout: 30000,//超时时间为
                    data: {//发送数据为一个验证码和用户对象（json）
                        password: Base64.encode($String.Trim($("#pwd").val())),
                        key:$("#key").val()
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
                            if (returnInfo.length > 0) {//切割成功
                                if (returnInfo[0] == 'pwdError') {//同理
                                    UI.LogReg.resetPwd.buildWarningMessage($("#pwd"), returnInfo[1]);
                                    }
                            }
                        }
                        else {//如果没有返回的错误信息
                            var redirectUrl = $("#redirectUrl").val();//找到页面的跳转Url的值
                            if (redirectUrl.length > 0) {//如果存在的话
                                window.location = redirectUrl;//页面跳转吧！
                            }
                        }
                    },
                    complete: function (XMLHttpRequest, textStatus) {
                        $("#pwd").removeAttr("process");//最后的最后，把这个临时工属性process 开除
                    }
                });

                return false;//这是整个回调callback的返回
            }
        });

        resetPwd.addRule([//给上面的验证的validform对象添加规则
            {
                ele: "#pwd",
                datatype: "pwd",//密码的干活
                //ignore: "ignore",
                nullmsg: "请填写密码",
                errormsg: "6-20位字符，可使用字母、数字或符号的组合，不建议使用纯数字，纯字母，纯符号",
                sucmsg: " ",
                plugin: "passwordStrength"
            },
            {
                ele: "#pwd_confirm",//密码的干活double
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