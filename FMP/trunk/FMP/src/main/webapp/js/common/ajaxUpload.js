/**
 * Created by Administrator on 2015/4/9.
 */
var AjaxFileUpload = {
    UploadFile: function (fileInputID, url, loading, callback) {//文件的id,地址,
        var fileInputObj = $("#"+fileInputID);//文件对象根据id获取
        $(fileInputObj).next().remove()//下个元素移除
        $(fileInputObj).after(loading);//
        $.ajaxFileUpload({
            url: url,//用于文件上传的服务器端请求地址
            secureuri: false,//一般设置为false
            fileElementId: fileInputID,//文件上传空间的id属性  <input type="file" id="file" name="file" />
            dataType: 'json',//返回值类型 一般设置为json
            success: function (data, status)  //服务器成功响应处理函数
            {
                //从服务器返回的json中取出message中的数据,其中message为在struts2中定义的成员变量
                callback(data, $("#"+fileInputID));
            },
            error: function (data, status, e)//服务器响应失败处理函数
            {
                alert(e);
            }
        });
        $("#"+fileInputID).off().on("change", function () {
            AjaxFileUpload.UploadFile($(this).attr("id"), urlInfo, loading, callback);
        });
    }
}

