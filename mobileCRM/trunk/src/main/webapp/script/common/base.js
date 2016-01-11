var __sp = String.prototype;
//_bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F7e9c82bcb285dccf87292cff3f24e9e0' type='text/javascript'%3E%3C/script%3E"))
__sp.encodeURI = function () {
    return escape(this).replace(/\*/g, "%2A").replace(/\+/g, "%2B").replace(/-/g, "%2D").replace(/\./g, "%2E").replace(/\//g, "%2F").replace(/@/g, "%40").replace(/_/g, "%5F");
};
__sp.encodeHtml = function () {
    return this.replace(/\&/g, "&amp;").replace(/\>/g, "&gt;").replace(/\</g, "&lt;").replace(/\'/g, "&#039;").replace(/\"/g, "&quot;");
};

__sp.format = function (args) {
    if (arguments.length > 0) {
        var result = this;
        if (arguments.length == 1 && typeof (args) == "object") {
            for (var key in args) {
                var reg = new RegExp("({" + key + "})", "g");
                result = result.replace(reg, args[key]);
            }
        }
        else {
            for (var i = 0; i < arguments.length; i++) {
                if (arguments[i] == undefined) {
                    return "";
                }
                else {
                    var reg = new RegExp("({[" + i + "]})", "g");
                    result = result.replace(reg, arguments[i]);
                }
            }
        }
        return result;
    }
    else {
        return this;
    }
}


//var template1 = "sss{0}，ss{1}s";
//var template2 = "ss{name}，ss{age}aa";
//var result1 = template1.format("loogn", 22);
//var result2 = template1.format({ name: "loogn", age: 22 });
//Namespace
__sp.encrypt = function (arg) {
    if (arg === undefined)
        return Base64.encode(this);

    switch (arg) {
        case 1:
            return Base64.encode(this);
        default:
            return Base64.encode(this);
    }
}

Date.prototype.format = function (format) {
    var o = {
        "M+": this.getMonth() + 1, //month
        "d+": this.getDate(),    //day
        "h+": this.getHours(),   //hour
        "m+": this.getMinutes(), //minute
        "s+": this.getSeconds(), //second
        "q+": Math.floor((this.getMonth() + 3) / 3),  //quarter
        "S": this.getMilliseconds() //millisecond
    }
    if (/(y+)/.test(format)) format = format.replace(RegExp.$1,
        (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)if (new RegExp("(" + k + ")").test(format))
        format = format.replace(RegExp.$1,
                RegExp.$1.length == 1 ? o[k] :
                ("00" + o[k]).substr(("" + o[k]).length));
    return format;
}

$.fn.serializeObject = function () {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function () {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
}

window.usingNamespace = function (a) {
    var ro = window;
    if (!(typeof (a) === "string" && a.length != 0)) {
        return ro;
    }

    var co = ro;
    var nsp = a.split(".");
    for (var i = 0; i < nsp.length; i++) {
        var cp = nsp[i];
        if (!ro[cp]) {
            ro[cp] = {};
        }
        ;
        co = ro = ro[cp];
    }
    ;

    return co;
};

var MessageType = { Info: "Info", Warning: "Warning", Error: "Error" };
usingNamespace("Base.Common")["PromptText"] = {
    systemError: function () {
        alert("内部错误");
    }
};


usingNamespace("Base.Utils")["String"] = {
    IsNullOrEmpty: function (v) {
        return !(typeof (v) === "string" && v.length != 0);
    },
    Trim: function (v) {
        return v.replace(/^\s+|\s+$/g, "")
    },
    TrimStart: function (v, c) {
        if ($String.IsNullOrEmpty(c)) {
            c = "\\s";
        }
        ;
        var re = new RegExp("^" + c + "*", "ig");
        return v.replace(re, "");
    },
    TrimEnd: function (v, c) {
        if ($String.IsNullOrEmpty(c)) {
            c = "\\s";
        }
        ;
        var re = new RegExp(c + "*$", "ig");
        return v.replace(re, "");
    },
    Camel: function (str) {
        return str.toLowerCase().replace(/\-([a-z])/g, function (m, c) {
            return "-" + c.toUpperCase()
        })
    },
    Repeat: function (str, times) {
        for (var i = 0, a = new Array(times); i < times; i++)
            a[i] = str;
        return a.join();
    },
    IsEqual: function (str1, str2) {
        if (str1 == str2)
            return true;
        else
            return false;
    },
    IsNotEqual: function (str1, str2) {
        if (str1 == str2)
            return false;
        else
            return true;
    },
    MaxLengthKeyUp: function (obj, len) {
        var value = $(obj).val();
        if (value.length > len) {
            $(obj).val(value.substring(0, len));
        }
    },
    MaxLengthKeyDown: function (obj, len) {
        if ($(obj).val().length > len) {
            return false;
        }
        return true;
    }
};

usingNamespace("Base.Utils")["Converter"] = {
    ToFloat: function (v) {
        if (!v || (v.length == 0)) {
            return 0;
        }
        ;
        return parseFloat(v);
    }
};

usingNamespace("Base.Utils")["Json"] = {
    // Serializes a javascript object, number, string, or arry into JSON.
    ToJson: function (object) {
        try {
            return JSON.stringify(object);
        } catch (e) {
        }
        return false;
    },
    // Converts from JSON to Javascript
    FromJson: function (text) {
        try {
            return JSON.parse(text);
        } catch (e) {
            return false;
        }
        ;
    }
};

var $String = Base.Utils.String;
var $Converter = Base.Utils.Converter;
var $Json = Base.Utils.Json;

usingNamespace("Base")["Url"] = {
    getUrlParam: function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]);
        return null;
    },
    BuildWWWUrl: function (relativePath) {
        return Environment.WWWSite + "/" + $String.TrimStart(relativePath, '\/');
    },
    BuildImgUrl: function (relativePath) {
        return Environment.ImgSite + "/" + $String.TrimStart(relativePath, '\/');
    },
    BuildLocalFileUrl: function (relativePath) {
        return Environment.LocalFileSite + "/" + $String.TrimStart(relativePath, '\/');
    },
    BuildFileUrl: function (relativePath) {
        return Environment.FileSite + "/" + $String.TrimStart(relativePath, '\/');
    }
};
var $Url = Base.Url;

usingNamespace("Base")["QueryString"] = {
    Get: function (key) {
        key = key.toLowerCase();
        var qs = Base.QueryString.Parse();
        var value = qs[key];
        return (value != null) ? value : "";
    },
    Set: function (key, value) {
        key = key.toLowerCase();
        var qs = Base.QueryString.Parse();
        qs[key] = $HttpUtility.UrlEncode(value);
        return Base.QueryString.ToString(qs);
    },
    Parse: function (qs) {
        var params = {};

        if (qs == null) qs = location.search.substring(1, location.search.length);
        if (qs.length == 0) return params;

        qs = qs.replace(/\+/g, ' ');
        var args = qs.split('&');
        for (var i = 0; i < args.length; i++) {
            var pair = args[i].split('=');
            var name = pair[0].toLowerCase();

            var value = (pair.length == 2)
                ? pair[1]
                : name;
            params[name] = value;
        }

        return params;
    },
    ToString: function (qs) {
        if (qs == null) qs = Base.QueryString.Parse();

        var val = "";
        for (var k in qs) {
            if (val == "") val = "?";
            val = val + k + "=" + qs[k] + "&";
        }
        val = val.substring(0, val.length - 1);
        return val;
    }
};
var $QueryString = Base.QueryString;

usingNamespace("Base.Common")["Validation"] = {

    textCount: function (field, counter, maxLimit) {
        var message = $(field).val();
        if ($(field).val().length > maxLimit)
            $(field).val(message.substring(0, maxLimit))
        //$(counter).text(maxLimit-field.value.length);
    },
    isUrl: function (s) {
        var strRegex =
            /^((http(s)?|ftp|telnet|news|rtsp|mms):\/\/)?(((\w(\-*\w)*\.)+[a-zA-Z]{2,4})|(((1\d\d|2([0-4]\d|5[0-5])|[1-9]\d|\d).){3}(1\d\d|2([0-4]\d|5[0-5])|[1-9]\d|\d).?))(:\d{0,5})?(\/+.*)*$/;
        return strRegex.test(s);
    },
    isDecimal: function (d) {
        var pattern = /^(([1-9]\d{0,12})|0)(\.\d{1,2})?$/;
        return pattern.test(d);
    },
    isEmail: function (s) {
        var pattern = /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/;
        return pattern.test(s);
    },
    isLowEmail: function (s) {
        var b, e;
        b = s.indexOf("@");
        e = s.indexOf(".");
        if (b <= 0) return false;
        if (e < 0 || e == (s.length - 1)) {
            return false;
        }
        return true;
    },
    clearNoNum: function (event, obj) {
        event = window.event || event;
        if (event.keyCode == 37 | event.keyCode == 39) {
            return;
        }
        obj.value = obj.value.replace(/[^\d.]/g, "");
        obj.value = obj.value.replace(/^\./g, "");
        obj.value = obj.value.replace(/\.{2,}/g, ".");
        obj.value = obj.value.replace(".", "$#$").replace(/\./g, "").replace("$#$", ".");
    },
    checkNum: function (obj) {
        obj.value = obj.value.replace(/\.$/g, "");
    },
    isInteger: function (value) {
        var integerReg = new RegExp(/^\d+$/);
        return integerReg.test(value);
    },
    isValidateReg: function (value) {
        var validateReg = /^([A-Za-z0-9\s\-\_\~\!\@\#\$\%\^\&\*\(\)\|\<\>\?\:\;\"\'\.\[\]\{\}\,\+\`\/\\\=]){6,16}$/;
        if (validateReg.test(value)) {
            return true;
        }
        return false;
    },
    isDate: function (strValue) {
        var objRegExp = /^\d{4}(\-|\/|\.)\d{1,2}\1\d{1,2}$/

        if (!objRegExp.test(strValue))
            return false;
        else {
            var arrayDate = strValue.split(RegExp.$1);
            var intDay = parseInt(arrayDate[2], 10);
            var intYear = parseInt(arrayDate[0], 10);
            var intMonth = parseInt(arrayDate[1], 10);
            if (intMonth > 12 || intMonth < 1) {
                return false;
            }
            var arrayLookup = {
                '1': 31, '3': 31, '4': 30, '5': 31, '6': 30, '7': 31,
                '8': 31, '9': 30, '10': 31, '11': 30, '12': 31
            }
            if (arrayLookup[parseInt(arrayDate[1])] != null) {
                if (intDay <= arrayLookup[parseInt(arrayDate[1])] && intDay != 0)
                    return true;
            }
            if (intMonth - 2 == 0) {
                var booLeapYear = (intYear % 4 == 0 && (intYear % 100 != 0 || intYear % 400 == 0));
                if (((booLeapYear && intDay <= 29) || (!booLeapYear && intDay <= 28)) && intDay != 0)
                    return true;
            }
        }
        return false;
    },
    isZip: function (value) {
        var validateReg = /^[0-9]{6}$/;
        return validateReg.test(value);
    },
    checkSpecialChar: function (value) {
        var validateReg = /([~!@#$%^&*\/\\,.\(\)]){6,16}$/;
        return validateReg.test(value);
    },
    CheckSpecialString: function (value) {
        var validateReg = /[\u0000-\u0008\u000B\u000C\u000E-\u001F\uD800-\uDFFF\uFFFE\uFFFF]/;
        return validateReg.test(value);
    },
    isTel: function (s) {
        var patrn = /^\d{3,4}-\d{7,8}(-\d{3,4})?$/
        if (!patrn.exec(s)) return false
        return true
    },

    isMobile: function (value) {
        var validateReg = /^1\d{10}$/;
        return validateReg.test(value);
    },
    getLength: function (value) {
        return value.replace(/[^\x00-\xff]/g, "**").length;
    },
    isLicence: function (value) {
        var validateReg = /^[A-Za-z]{10}[0-9]{10}$/;
        return validateReg.test(value);
    },
    isPersonalCard: function (value) {
        var validateReg = /(^\d{15}$)|(^\d{17}(\d|[A-Za-z]{1})$)/;
        return validateReg.test(value);
    },
    isOrganizationCodeCard: function (value) {
        var validateReg = /^[A-Za-z0-9]{9}$/;
        return validateReg.test(value);
    },
    isBankAccount: function (value) {
        var validateReg = /^[1-9]{1}[0-9]*$/;
        return validateReg.test(value);
    },
    CheckCustomerCode: function (value) {
        var validateReg = /^[\w]{4,25}$/;
        return validateReg.test(value.replace(/[^\x00-\xff]/g, "aa"));
    },
    MaxLength: function (field, maxlimit) {
        var j = field.value.replace(/[^\x00-\xff]/g, "**").length;
        var tempString = field.value;
        var tt = "";
        if (j > maxlimit) {
            for (var i = 0; i < maxlimit; i++) {
                if (tt.replace(/[^\x00-\xff]/g, "**").length < maxlimit)
                    tt = tempString.substr(0, i + 1);
                else
                    break;
            }
            if (tt.replace(/[^\x00-\xff]/g, "**").length > maxlimit) {
                tt = tt.substr(0, tt.length - 1);
                field.value = tt;
            }
            else {
                field.value = tt;
            }
        }
    },
    isIDCard: function (value) {
        //该方法由佚名网友提供;

        var Wi = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1];// 加权因子;
        var ValideCode = [1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2];// 身份证验证位值，10代表X;

        if (value.length == 15) {
            return isValidityBrithBy15IdCard(value);
        } else if (value.length == 18) {
            var a_idCard = value.split("");// 得到身份证数组
            if (isValidityBrithBy18IdCard(value) && isTrueValidateCodeBy18IdCard(a_idCard)) {
                return true;
            }
            return false;
        }
        return false;

        function isTrueValidateCodeBy18IdCard(a_idCard) {
            var sum = 0; // 声明加权求和变量
            if (a_idCard[17].toLowerCase() == 'x') {
                a_idCard[17] = 10;// 将最后位为x的验证码替换为10方便后续操作
            }
            for (var i = 0; i < 17; i++) {
                sum += Wi[i] * a_idCard[i];// 加权求和
            }
            valCodePosition = sum % 11;// 得到验证码所位置
            if (a_idCard[17] == ValideCode[valCodePosition]) {
                return true;
            }
            return false;
        }

        function isValidityBrithBy18IdCard(idCard18) {
            var year = idCard18.substring(6, 10);
            var month = idCard18.substring(10, 12);
            var day = idCard18.substring(12, 14);
            var temp_date = new Date(year, parseFloat(month) - 1, parseFloat(day));
            // 这里用getFullYear()获取年份，避免千年虫问题
            if (temp_date.getFullYear() != parseFloat(year) || temp_date.getMonth() != parseFloat(month) - 1 || temp_date.getDate() != parseFloat(day)) {
                return false;
            }
            return true;
        }

        function isValidityBrithBy15IdCard(idCard15) {
            var year = idCard15.substring(6, 8);
            var month = idCard15.substring(8, 10);
            var day = idCard15.substring(10, 12);
            var temp_date = new Date(year, parseFloat(month) - 1, parseFloat(day));
            // 对于老身份证中的你年龄则不需考虑千年虫问题而使用getYear()方法
            if (temp_date.getYear() != parseFloat(year) || temp_date.getMonth() != parseFloat(month) - 1 || temp_date.getDate() != parseFloat(day)) {
                return false;
            }
            return true;
        }

    }
}

var $Validation = Base.Common.Validation;

usingNamespace("Base.Validation")["VerifyCode"] = {
    refreshValidator: function (img, input) {
        $(img).attr('src', $(img).attr('ref1') + "&r=" + Math.random());
        $(input).val("");
        //$(input).focus();
    }
};

var $VerifyCode = Base.Validation.VerifyCode;

if (!$.browser) {
    var ua = navigator.userAgent.toLowerCase();

    var match = /(chrome)[ \/]([\w.]+)/.exec(ua) ||
        /(webkit)[ \/]([\w.]+)/.exec(ua) ||
        /(opera)(?:.*version|)[ \/]([\w.]+)/.exec(ua) ||
        /(msie) ([\w.]+)/.exec(ua) ||
        ua.indexOf("compatible") < 0 && /(mozilla)(?:.*? rv:([\w.]+)|)/.exec(ua) ||
        [];

    var matched = {
        browser: match[ 1 ] || "",
        version: match[ 2 ] || "0"
    };

    var browser = {};

    if (matched.browser) {
        browser[ matched.browser ] = true;
        browser.version = matched.version;
    }

    // Chrome is Webkit, but Webkit is also Safari.
    if (browser.chrome) {
        browser.webkit = true;
    } else if (browser.webkit) {
        browser.safari = true;
    }

    $.browser = browser;
}

//$(function(){
//	$("#header").find("a").each(function(){
//		$("#header").find("a").removeClass("active");
//		var id = $(this).attr("id");
//		if(id!=undefined&&$("#header").attr("value").toLowerCase().indexOf(id.toLowerCase())>-1){
//			$(this).addClass("active");
//			return false;
//		}else{
//			$("#index").addClass("active");
//		}
//	});
//});