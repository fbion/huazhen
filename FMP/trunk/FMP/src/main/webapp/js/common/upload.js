/**
 * Created by paul on 15-1-19.
 */
var Upload = {//上传
    UploadFile: function (fileInputID, url, loading, callback,weiXinPhoto) {//文件的id,地址,
//        var fileInputObj = $("#" + fileInputID);//文件对象根据id获取
//        $(fileInputObj).next().remove()//下个元素移除
//        $(fileInputObj).after(loading);//

        $.ajaxFileUpload({
            url: url,//用于文件上传的服务器端请求地址
            secureuri: false,//一般设置为false
            fileElementId: fileInputID,//文件上传空间的id属性  <input type="file" id="file" name="file" />
            dataType: 'json',//返回值类型 一般设置为json
            data:{weiXinPhoto:weiXinPhoto},
            success: function (data, status)  //服务器成功响应处理函数
            {
                //从服务器返回的json中取出message中的数据,其中message为在struts2中定义的成员变量
                callback(data, $("#" + fileInputID));
            },
            error: function (data, status, e)//服务器响应失败处理函数
            {
                alert(e);
            }
        });

        $("#" + fileInputID).off().on("change", function () {
            Upload.UploadFile($(this).attr("id"), url, loading, callback, "");
        });
    }
}

$.fn.Upload = function (options) {

    var opts = $.extend({}, $.fn.Upload.defaults, options);

    var previewObj = "<div class=\"upload_end\"></div>"
    $(this).after(previewObj);

    var $this = $(this);

    if (!opts.readOnly) {
        var input = "<span>" + opts.title + "</span><input id=\"" + opts.inputID + "\" name=\"file\" type=\"file\" />";
        $(this).html(input);

        $(this).on("change", "input", function () {
            $(this).next().remove()//下个元素移除
            $(this).after("<p></p>");//

//            if (!$.checkFileType())
//                return;

            Upload.UploadFile(
                opts.inputID,
                opts.url,
                "<p></p>",
                function (msg) {
                    if (msg.message == "0") {
                        alert("上传失败请联系管理员");
                    }else if (msg.message == "1"){
                        alert("请不要上传非法的文件");
                    }
                    else {
                        var fileID = 0;
                        if (opts.success) {
                            fileID = opts.success(msg.fileFileName, msg.relativePath, opts.paramList);
                        }

                        if (!opts.success || fileID > 0)
                            $.showFile($this.next(), msg.message, msg.fileFileName, fileID);
                    }

                    $this.find("p").remove();
                },
                opts.weiXinPhoto
            )
        });
    }else{
        var span = "<span>" + opts.title + "</span>";
        $(this).html(span);
    }

    $.showFile = function (o, path, fileName, fileID) {
        var format = "<span class=\"upload_end1\"><em><a href=\"{0}\">{1}</a></em>";
        if (opts.multiple && !opts.readOnly && opts.deleteFile) {
            format += "<a id=\"a_{2}\" href=\"javascript:void(0)\">删除</a></span>";
            var delObj = format.format(path, fileName, fileID);

            $(o).append(delObj);
            $(o).find('a#a_' + fileID).on("click", function () {
                opts.deleteFile($(this))
            });
        } else {
            format += "</span>";
            $(o).append(format.format(path, fileName));
        }
    }

    $.showFiles = function (pathList) {
        if (opts.multiple) {
            $.each(pathList, function (index, content) {
                $.showFile($this.next(), content.path, content.name, content.id);
            });
        } else {
            $.showFile($this.next(), pathList[0].path, pathList[0].name, pathList[0].id);
        }

    }

//    $.checkFileType = function () {
//        var docType = ["doc","docx","xls","xlsx","ppt","pptx","pdf","txt"];
//        var imageType = ["jpg","jpeg","gif","png"];
//        var vedioType = ["flv"];
//        switch(opts.fileType)
//        {
//            case 1:
//                break;
//            case 2:
//                break;
//            case 3:
//                break;
//            default:
//                break;
//        }
//        return true;
//    }

    if (opts.pathList != undefined && opts.pathList.length > 0) {
        $.showFiles(opts.pathList);
    }
};

$.fn.Upload.defaults = {
	weiXinPhoto:0,		
    inputID: "upload",
    readOnly: false,
    multiple: false,
    fileType: 1,//1文件：doc,docx,xls,xlsx,ppt,pptx,pdf,txt 2图片:jpg,gif,png 3视频
    url: "",
    pathList: [],
    paramList: [],
    title: "上传"
};
