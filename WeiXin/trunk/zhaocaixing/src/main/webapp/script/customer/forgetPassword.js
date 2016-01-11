/**
 * Created by paul on 15-3-19.
 */
usingNamespace("UI.LogReg")["ForgetPassword"] = {//设定命名空间("UI.LogReg")["Register"]
    buildWarningMessage: function (jqueryObj, msg) {//这是一个创建警告信息的函数
        //传入jquery对象的|父级元素|的同级元素|当中找到.Validform_checktip类的元素|移除所有样式|并且把样式换成|.desc .Valideform_wrong .Validform_checktip|并且把这个元素的内容文本换成msg|显示|兄弟节点并且样式是.desc的元素隐藏
        jqueryObj.siblings().find(".Validform_checktip").removeClass().addClass("desc Validform_wrong Validform_checktip").text(msg).show().siblings(".desc").hide();
    },
    clearWarningMessage: function (jqueryObj) {
        //传人jquery对象的父级元素的兄弟元素中样式是（.Validform_checktip）的元素移除样式|增加新的样式（.desc .Validform-wrong Validform_checjtip）的内容移除之|
        jqueryObj.siblings().find(".Validform_checktip").removeClass().addClass("desc Validform_wrong Validform_checktip").text("").hide();
    }
};

$(document).ready(function () {//文档加载好了之后

    if ($(".create_password").length > 0) {//判断这个元素存在否？如果存在之后的一切开始发生

        var sendMail = $(".create_password").Validform({//添加验证控件 简历一个验证对象（validform对象）
            tiptype: 3,//显示验证信息显示位置
            datatype: {
                "verifyEmail": function (gets, obj, curform, datatype) {
                    var reg = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
                    if (!reg.test(gets)) {
                        return false;
                    }

                    var url = $Url.BuildWWWUrl("/customer/register/ajaxCheckEmailExist");
                    var result;
                    $.ajax({
                        type: "get",
                        url: url,
                        dataType: "json",
                        async: false,
                        data: { email: $String.Trim(gets) },
                        success: function (data) {
                            if (data.message.type == MessageType.Info)
                                result = "";
                        }
                    });

                    return result;
                }
            },
            callback: function (form) {//验证控件的回调
                if (!($("#email").attr("process") === undefined)) {//如果用户名的process属性木有
                    return false;//返回
                }

                var verifyCode = $("#verifyCode").val();//验证码的值
                if (typeof (verifyCode) == "undefined") {//没有输入的时候来个空字符串
                    verifyCode = "";
                }

                $.ajax({//异步发送
                    type: "post",//post方式
                    url: $Url.BuildWWWUrl("customer/forgetPassword/ajaxSendFindPwdEmail"),//地址
                    dataType: "json",//数据类型为json
                    timeout: 30000,//超时时间为
                    data: {//发送数据为一个验证码和用户对象（json）
                        verifyCode: $String.Trim(verifyCode),
                        email: $String.Trim($("#email").val())
                    },
                    beforeSend: function () {//在发送之前放一新个属性作为标记
                        $("#email").attr("process", "processing");
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        Base.Common.PromptText.systemError();//错了就错了
                    },
                    success: function (data, textStatus) {//如果ok 取回data
                        if (data.message.type == MessageType.Error) {//当type 是Error的时候
                            var returnInfo = data.message.description.split(':');//返回的报错内容切割它
                            if (returnInfo.length > 0) {//切割成功
                                if (returnInfo[0] == 'validateError') {//第一条信息调用最上方的命名空间定义的创建一个警告提示信息的方法并且把这个returninfo[1]放到函数中
                                    UI.LogReg.ForgetPassword.buildWarningMessage($("#verifyCode"), returnInfo[1]);//$("#verifyCode")是用来定位的jquery对象
                                }
                                else if (returnInfo[0] == 'emailError') {//同理
                                    UI.LogReg.ForgetPassword.buildWarningMessage($("#email"), returnInfo[1]);
                                    UI.LogReg.ForgetPassword.clearWarningMessage($("#verifyCode"));

                                }
                            }
                            $("#verifyCode").val("");//最后呢，把验证码干掉！
                            $VerifyCode.refreshValidator('#imgVerifyCode', '#verifyCode'); //刷新验证码吧骚年！
                        }
                        else {
                            $(".sendMail").hide();
                            $(".sendSuccess").show();
                        }
                    },
                    complete: function (XMLHttpRequest, textStatus) {
                        $("#email").removeAttr("process");//最后的最后，把这个临时工属性process 开除
                    }
                });

                return false;//这是整个回调callback的返回
            }
        });

        sendMail.addRule([//给上面的验证的validform对象添加规则
            {
                ele: "#email",
                datatype: "verifyEmail",//邮箱的干活
                //ignore: "ignore",
                nullmsg: "请填写邮箱",
                errormsg: "请输入正确的邮箱",
                sucmsg: " "
            },
            {
                ele: "#verifyCode",//验证码的干活
                datatype: "captcha",
                //ignore: "ignore",
                nullmsg: "请输入验证码",
                errormsg: "请输入正确的验证码",
                sucmsg: " "
            }
        ]);
    }
});