var FileManage = {
    BindFile: function () {
        var readOnly = false;
        $(".upload").Upload({
            inputID: "uploadInput",
            readOnly: readOnly,
            multiple: false,
            fileType: 2,
            url: $Url.BuildEmployeeUrl("/upload.action"),
            success: FileManage.SaveFileToPage,
            title: ""
        });
        $("#uploadInput").addClass("data");
    },
    SaveFileToPage: function (fileName, relativePath) {
        $("#portraitPath").val(relativePath);
    }
}


$(function () {
    FileManage.BindFile();
    EnumList.GetEnumListToSelect($("#table"),"excelType",$Url.BuildEmployeeUrl("/common/enumList.action"));

    $("#import").click(function(){
        var type = $("#table").val();
        var filePath = $("#portraitPath").val();
        var url = $Url.BuildEmployeeUrl("/baseInfo/importData/ajaxImportData");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {
                type:type,
                filePath:filePath
            },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                alert(data.desc);
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    });
});