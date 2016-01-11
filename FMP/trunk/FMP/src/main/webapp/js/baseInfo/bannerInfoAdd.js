var ManagePage = {
    EnableInput: function () {
        $.each($(".data"), function (index, content) {
            var id = $(this).attr("id");
            if (ElementVar[id] == undefined) {
                $(this).removeAttr("disabled");
            }
            if (ElementVar[id] == TagPermissionType.edit) {
                $(this).removeAttr("disabled");
            }
            if (PageVar.ID == 0 && ElementVar[id] == TagPermissionType.none){
                $(this).parent().remove();
            }
        });
    },
    DisableInput: function () {
        $(".data").attr("disabled", "disabled");
    },
    ShowEditButton: function (currStatus) {
        if ($("#edit").length > 0)
            $("#edit").show();
        if ($("#submit").length > 0)
            $("#submit").hide();

    },
    HideEditButton: function () {
        if ($("#edit").length > 0)
            $("#edit").hide();
        if ($("#submit").length > 0)
            $("#submit").show();

    },
    GetInfo: function (id) {
        var url = $Url.BuildBaseInfoUrl("/baseInfo/bannerInfo/ajaxGetBannerInfo");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: { id: id },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if (data.errCode != "0000") {
                    $("#msg").text(data.errDesc);
                    return;
                }
                $Util.DataToVal(data.info, ElementVar);
                if (!$String.IsNullOrEmpty(data.info.startTime)) {
                    var startTime = new Date(data.info.startTime);
                    $("#startTime").val(startTime.format("yyyy-MM-dd HH:mm:ss"));
                }
                if (!$String.IsNullOrEmpty(data.info.endTime)) {
                    var endTime = new Date(data.info.endTime);
                    $("#endTime").val(endTime.format("yyyy-MM-dd HH:mm:ss"));
                }
                if (!$String.IsNullOrEmpty($("#resrcurl").val())) {
                    ManagePage.ShowPhoto($("#resrcurl").val());
                }
                ManagePage.ShowEditButton();
                if ($("#edit").length > 0) {
                    $("#edit").click(function () {
                        ManagePage.EnableInput();
                        ManagePage.HideEditButton();

                    });
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
    BindFile: function () {
        var readOnly = false;
        $(".upload").Upload({
            inputID: "uploadInput",
            readOnly: readOnly,
            multiple: false,
            fileType: 2,
            url: $Url.BuildEmployeeUrl("/upload.action"),
            success: ManagePage.SaveFileToPage,
            title: ""
        });
    },
    SaveFileToPage: function (fileName, relativePath) {
        $("#resrcurl").val(relativePath);
        ManagePage.ShowPhoto(relativePath);
    },
    ShowPhoto:function(path){
        $("#emphead").attr("src", $Url.BuildFileUrl(path));
        $("#empheada").attr("href", $Url.BuildFileUrl(path));
    },
    Resize: function () {
        $("#content_center").css({"min-height":"803px","height":$(".wrappContent ").height()+100});
    }
}
$(function () {
    ManagePage.BindFile();
    ManagePage.Resize();
    EnumList.GetEnumListToSelect($("#locationNo"), "bannerLocationList", $Url.BuildEmployeeUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#type"), "dicDicDataBannerInfoType", $Url.BuildEmployeeUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#status"), "dicDicDataAnnouncementStatus", $Url.BuildEmployeeUrl("/common/enumList.action"));
    $("#back").click(function () {
        window.close();
    });

    if (Number(PageVar.ID) == 0) {
        ManagePage.EnableInput();
        ManagePage.HideEditButton();
    }
    else {
        ManagePage.GetInfo(PageVar.ID);
    }

    $("#startTime").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'});
    });
    $("#endTime").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'});
    });


    var bannerInfoAdd = $("#bannerInfoAdd").Validform({
        tiptype: function (msg, o, cssctl) {
            var objtip = o.obj.siblings(".Validform_checktip");
            cssctl(objtip, o.type);
            objtip.text(msg);
        },
        callback: function (form) {
            if (!($("#submit").attr("process") === undefined)) {
                return false;
            }
            var url = $Url.BuildBaseInfoUrl("/baseInfo/bannerInfo/ajaxEditBannerInfo");
            var oper = "add";
            if (Number(PageVar.ID) != 0)
                oper = "edit";

            var info = {
                id: PageVar.ID,
                locationNo: $("#locationNo").val(),
                pageNo: $("#pageNo").val(),
                exceptPageNo: $("#exceptPageNo").val(),
                type: $("#type").val(),
                description: $("#description").val(),
                title: $("#title").val(),
                text: $("#text").val(),
                resrcurl: $("#resrcurl").val(),
                linkUrl: $("#linkUrl").val(),
                script: $("#script").val(),
                priority: $("#priority").val(),
                startTime: $("#startTime").val().toTimetamp(),
                endTime: $("#endTime").val().toTimetamp(),
                status: $("#status").val(),

            }
            $.ajax({
                type: "post",
                url: url,
                dataType: "json",
                timeout: 30000,
                data: {
                    oper: oper,
                    info: JSON.stringify(info)
                },
                beforeSend: function () {
                    $("#submit").attr("process", "processing");
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(errorThrown);
                },
                success: function (data, textStatus) {
                    if (data.errCode == "0000") {
                        window.location.href = $Url.BuildBaseInfoUrl("/baseInfo/bannerInfo/edit?id=" + data.errDesc);
                    } else {
                        $("#msg").text(data.errDesc);
                    }
                },
                complete: function (XMLHttpRequest, textStatus) {
                    $("#submit").removeAttr("process");
                }
            });
            return false;
        }
    });
    bannerInfoAdd.addRule([
        {
            ele: "#title",
            datatype: /^.{1,15}$/,
            nullmsg: "标题不可为空",
            errormsg:"请输入少于15位的字符",
            sucmsg: " "
        },
        {
            ele: "#text",
            datatype:"*",
            nullmsg: "内容不可为空",
            errormsg:"",
            sucmsg: " "
        }
    ]);
})
