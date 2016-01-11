/**
 * Created by Administrator on 2015/3/12.
 */

var FileManage = {
	BindFile: function () {
        var readOnly = false;
        $("#a .upload").Upload({
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
    	
        FileManage.ShowPhoto($Url.BuildFileUrl(relativePath));
        $("#portraitPath").val(relativePath);
    },
    ShowPhoto: function (path) {
        $(".emphead").attr("src", path);
        $("#aEmpHead").attr("href", path);
        if(path!=null &&path!=""){
        	var url = $Url.BuildProductUrl("/product/p2pProduct/ajaxPutP2pProductLogpPath");
            $.ajax({
                type:"post",
                url:url,
                dataType:"json",
                timeout:30000,
                data:{id: PageVar.id,logoPath:path},
                error:function(XMLHttpRequest,textStatus,errorThrown){
                    alert(errorThrown);
                },
                success:function(data){
                	
                }
            });
        }
    },
    ShowUploadFile: function (o, path, fileName, fileID) {
        var format = "<span class=\"upload_end1\"><em><a href=\"{0}\">{1}</a></em>"
            + "<a id=\"a_{2}\" href=\"javascript:void(0)\" onclick=\"FileManage.DeleteFile('a_{3}')\">删除</a></span>";
        $(o).append(format.format(path, fileName, fileID, fileID));
    },
    ShowUploadFiles: function (msg, fileObj) {
        if (msg.message == "0") {
            $(fileObj).parent().find("p").remove();
            $(fileObj).after("上传失败请联系管理员");
        }
        else {
            var url = $Url.BuildProductUrl("/product/p2pProduct/ajaxSaveFilePath");
            var fileID = $(fileObj).attr("id");
            $.ajax({
                type: "post",
                url: url,
                dataType: "html",
                timeout: 30000,
                data: {id: PageVar.id,
                    message:msg.message,
                    fileName: msg.fileFileName,
                    filePath: msg.relativePath,
                    fileType: fileID[fileID.length - 1]
                },
                beforeSend: function () {
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(errorThrown);
                },
                success: function (data, textStatus) {
                    $("#video").html(data);
                },
                complete: function (XMLHttpRequest, textStatus) {
                    $(fileObj).parent().find("p").remove();
                }
            });
        }
    },
    GetFileList: function () {
        var url = $Url.BuildProductUrl("/product/p2pProduct/ajaxListFile");
        $.ajax({
            type: "post",
            url: url,
            dataType: "html",
            timeout: 30000,
            data: {id: PageVar.id
            },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                $("#video").html(data);
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    }
}
var P2pAdd = {
    GetProductInfo:function(){
        var url = $Url.BuildProductUrl("/product/product/ajaxGetProduct");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {id:PageVar.productNo},
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if (data.errCode != "0000") {
                    $("#msg").text(data.errDesc);
                }
                else {
                    $("#productNo").val(data.info.id);
                    $("#name").val(data.info.name);
                    $("#totalAmout").val(data.info.sumMoney);
                    $("#remainAmout").val(data.info.sumMoney);
                    $("#minMoney").val(data.info.baseLimit);
                    $("#description").val(data.info.comment);
                    $("#floatingIncome").val("0")
                    $(".dis").attr("disabled","disabled");
                }
            }
        });
    },
    HideEditButton: function () {
        var activitiNo=Audit.GetUrlActivitNo();
        if(!$String.IsNullOrEmpty(activitiNo)){
            if ($("#edit").length > 0) {
                $("#edit").hide();
                $("#commitCheck").hide();
                $("#examine").hide();
            }
            if ($("#submit").length > 0)
                $("#submit").show();
        }else{
            if ($("#edit").length > 0) {
                $("#edit").hide();
                $("#commitCheck").hide();
            }
            if ($("#submit").length > 0)
                $("#submit").show();
        }
    },
    ShowEditButton:function(currStatus){
        var activitiNo = Audit.GetUrlActivitNo();
        if(!$String.IsNullOrEmpty(activitiNo)){
            if ($("#edit").length > 0){
                if($("#empNo").val() == PageVar.UserId){
                    $("#edit").show();
                    $("#submit").hide();
                    $("#examine").val("提交审核")
                }
                $("#commitCheck").hide();
                $("#examine").show();
            }
        }
        else{
            if ($("#edit").length == 0)
                return;
            $("#submit").hide();
            if(currStatus == PageVar.StatusPreheat){
                $("#commitCheck").show();
                $("#edit").show();
            }
        }
    },

    DisableInput:function(){
        $(".data").attr("disabled","disabled");
    },
    EnableInput:function(){
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
    GetP2pInfo:function(id){
        var url = $Url.BuildProductUrl("/product/p2pProduct/ajaxGetP2pProduct");
        $.ajax({
            type:"post",
            url:url,
            dataType:"json",
            timeout:30000,
            data:{id:id},
            error:function(XMLHttpRequest,textStatus,errorThrown){
                alert(errorThrown);
            },
            success:function(data){
                if(data.errCode != "0000")
                    $("#msg").text(data.errDesc)
                else{
                    $Util.DataToVal(data.info,ElementVar);
                    if(!$String.IsNullOrEmpty(data.info.start)){
                        $("#start").val(new Date(data.info.start).format("yyyy-MM-dd"));
                    }
                    if(!$String.IsNullOrEmpty(data.info.end)){
                        $("#end").val(new Date(data.info.end).format("yyyy-MM-dd"));
                    }
                    P2pAdd.ShowEditButton(data.info.status);
                    FileManage.GetFileList();
                    Audit.GetWindow(data.info.activitiNo);
                    Audit.InitGrid(data.info.activitiNo);
                    if(data.info.status==PageVar.StatusOnSale) {
                        $("#editAmout").show();
                    }
                    if(data.info.logoPath!=null && data.info.logoPath!=""){
                    	if(data.info.logoPath=$Url.BuildFileUrl("null")){
                    		$(".emphead").attr("src", data.info.logoPath);
                            $("#aEmpHead").attr("href", data.info.logoPath);
                    	}else{
                    		$(".emphead").attr("src", "");
                            $("#aEmpHead").attr("href", "");
                    	}
                    }
                }
            }
        });
    },
    EditAmont:function(){
        var url = $Url.BuildProductUrl("/product/p2pProduct/ajaxEditAmont");
        $.ajax({
            type:"post",
            url:url,
            dataType:"json",
            timeout:30000,
            data:{
                id:PageVar.id,
                totalAmout:$("#totalAmout").val()
            },
            error:function(XMLHttpRequest,textStatus,errorThrown){
                alert(errorThrown);
            },
            success:function(data){
                if(data.errCode != "0000")
                    $("#msg").text(data.errDesc)
                else{
                    window.location.href = $Url.BuildProductUrl("/product/p2pProduct/edit?id=" + PageVar.id + "&empNo=" + PageVar.UserId + "&activitiNo=");
                }
            }
        });
    }
}
$(function(){
    $("#content_center").css("min-height", "1450px");
    EnumList.GetEnumListToSelect($("#productNo"),"productList",$Url.BuildProductUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#status"), "p2pProductPartStatus", $Url.BuildProductUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#repaymentIssue"),"p2pProductRepayIssue",$Url.BuildProductUrl("/common/enumList.action"));

    $("#back").click(function(){
        $EasyUI.Close();
    });
    $("#start").click(function(){
        WdatePicker();
    });
    $("#end").click(function(){
        //$dp.$D(\'start\')
        WdatePicker({end: '%y', dateFmt: 'yyyy-MM-dd', minDate: '#F{$dp.$D(\'start\')}'});
    });
    $("#inTime").click(function(){
        //$dp.$D(\'start\')
        WdatePicker({end: '%y', dateFmt: 'yyyy-MM-dd'});
    });
    if (Number(PageVar.id) != 0) {
        P2pAdd.GetP2pInfo(PageVar.id);
        P2pAdd.DisableInput();
        $("#editAmout").click(function(){
            $("#totalAmout").removeAttr("disabled");
            $("#editAmout").hide();
            $("#submitAmout").show();
        });
    }
    else{
        $Util.InitElement(ElementVar);
        P2pAdd.EnableInput();
        P2pAdd.GetProductInfo();
        P2pAdd.HideEditButton();
        $("#duration").parent().hide();
        $("#inTime").val(new Date().format("yyyy-MM-dd"));
    }
    if($("#edit").length > 0 ){
        $("#edit").click(function(){
            P2pAdd.HideEditButton();
            P2pAdd.EnableInput();
        });
    }
    $("#submitAmout").click(function(){
        P2pAdd.EditAmont();
    });
    if ($("input[name='file']").length > 0) {
        $("input[name='file']").off().on("change", function () {
            Upload.UploadFile($(this).attr("id"), $Url.BuildProductUrl("/upload.action"), "<p></p>", FileManage.ShowUploadFiles);
        });
    }
    $('.trackBtn').on('click',function(){
        var url = $Url.BuildWorkFlowUrl("/workFlow/processing/ajaxAuditProcess");
        var activitiNo = Audit.GetUrlActivitNo();
        initAll.GetAuditProcess(url,activitiNo);
    });
    FileManage.BindFile();
    var p2pAdd = $("#p2pProductAdd").Validform({
        tiptype: function (msg, o, cssctl) {
            var objtip = o.obj.siblings(".Validform_checktip");
            cssctl(objtip, o.type);
            objtip.text(msg);
        },
        callback:function (form){
            if(!($("#submit").attr("process") == undefined))
                return false;
            var url = $Url.BuildProductUrl("/product/p2pProduct/ajaxEditP2pProduct");
            var activitiNo = Audit.GetUrlActivitNo();
            var oper = "add";
            if(Number(PageVar.id) != 0)
                oper = "edit";
            var info = {
                id:PageVar.id,
                productNo:$String.Trim($("#productNo").val()),
                name:$String.Trim($("#name").val()),
                income:$String.Trim($("#income").val()),
                floatingIncome:$String.Trim($("#floatingIncome").val()),
                totalAmout:$String.Trim($("#totalAmout").val()),
                remainAmout:$String.Trim($("#remainAmout").val()),
                level:$String.Trim($("#level").val()),
                orderCount:$String.Trim($("#orderCount").val()),
                status:$String.Trim($("#status").val()),
                minMoney:$String.Trim($("#minMoney").val()),
                isTest:$String.Trim($("#isTest").val()),
                start:$String.Trim($("#start").val()),
                end:$String.Trim($("#end").val()),
                productAdvantage:$String.Trim(CKEDITOR.instances.productAdvantage.getData()),
                description:$String.Trim(CKEDITOR.instances.description.getData()),
                repaymentIssue:$String.Trim($("#repaymentIssue").val()),
                contract:$String.Trim(CKEDITOR.instances.contract.getData()),
                activitiNo:activitiNo,
                inTime: $("#inTime").val().toTimetamp()
            }

            $.ajax({
                type:"post",
                url:url,
                datatype:"json",
                timeout:30000,
                data:{
                    oper:oper,
                    info:JSON.stringify(info)
                },
                beforeSend:function(){
                    $("#submit").attr("process","processing");
                },
                error: function(XMLHttpRequest,textStatus,errorThrown){
                    alert(errorThrown);
                },
                success: function(data,textStatus){
                    if(data.errCode == "0000"){
                        if (oper == "add") {
                            window.location.href = $Url.BuildProductUrl("/product/p2pProduct/edit?id=" + data.id + "&empNo=" + PageVar.UserId + "&activitiNo=");
                        }
                        else if (oper == "edit") {
                            window.location.href = $Url.BuildProductUrl("/product/p2pProduct/edit?id=" + PageVar.id + "&empNo=" + PageVar.UserId + "&activitiNo=");
                        }
                        else{
                            $("#msg").text(data.errDesc);
                        }
                    }else{
                        alert(data.errDesc);
                    }
                },
                complete: function(XMLHttpRequest,textStatus){
                    $("#submit").removeAttr("process");
                }
            });
            return false;
        }
    });
    p2pAdd.addRule([
        {
            ele:"#income",
            dataType:"/^\\d{1,2}(\\.[0-9]{1,2})?$/",
            nullmsg:"请填写收益率",
            errormsg:"收益率必须大于0且小于100",
            sucmsg:" "
        },
        {
            ele:"#floatingIncome",
            dataType:"/^\\d{1,2}(\\.[0-9]{1,2})?$/",
            nullmsg:"请填写浮动收益率",
            errormsg:"浮动收益率必须大于0且小于100",
            sucmsg:" "
        },
        {
            ele:"#totalAmout",
            dataType:"/^[1-9]\\d*$/",
            nullmsg:"请填写总额度",
            errormsg:"总额度必须大于0",
            sucmsg:" "
        },
        {
            ele:"#minMoney",
            dataType:"n",
            nullmsg:"请填写起步价",
            errormsg:"起步价应为正整数",
            sucmsg:" "
        }

    ]);
});
