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
        var url = $Url.BuildEmployeeUrl("/employee/fixedAssets/ajaxGetFixedAssets");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            async:false,
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
                $Util.DataToVal(data.rigInfo, ElementVar);
                

                $("#department").trigger("change");
                $("#userNo").val(data.info.userNo);
                
                
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
    }
}
$(function () {
    $("#back").click(function () {
        //window.location.href = $Url.BuildEmployeeUrl("/employee/fixedAssets/list");
        $EasyUI.Close();
    });
	 $.fn.linkage({
	        elements: [$("#department"), $("#userNo")],
	        dataTypes: ["dept", "empNo"],
	        actionUrl: $Url.BuildSalesUrl("/common/enumList.action"),
    	        all: true
     });
   

    EnumList.GetEnumListToSelect($("#type"), "assetsTypeGlobal", $Url.BuildSalesUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#assetType"), "assetsType", $Url.BuildSalesUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#status"), "assetsStatus", $Url.BuildSalesUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#location"), "assetsLocation", $Url.BuildSalesUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#suppliersId"), "suppliersList", $Url.BuildSalesUrl("/common/enumList.action"));
    
//    EnumList.GetEnumListToSelect($("#department"), "dept", $Url.BuildSalesUrl("/common/enumList.action"));
    if (Number(PageVar.ID) == 0) {
        ManagePage.EnableInput();
        ManagePage.HideEditButton();
    }
    else {
        ManagePage.GetInfo(PageVar.ID);
        if($("#department").val()!=0){
        	
       }else{
    	   $("#userNo").empty();
    	   $("#userNo").append("<option  selected = selected >全部</option>");
       }
    }
    
    $("#money").focus(function(){
    	if(!$String.IsNullOrEmpty($("#price").val())&&!$String.IsNullOrEmpty($("#price").val())){
        	$("#money").val($("#price").val() * $("#count").val());
    	}    });
    $("#price").blur(function(){
    	if(!$String.IsNullOrEmpty($("#price").val())&&!$String.IsNullOrEmpty($("#price").val())){
        	$("#money").val($("#price").val() * $("#count").val());
    	}
    });
    $("#count").blur(function(){
    	if(!$String.IsNullOrEmpty($("#price").val())&&!$String.IsNullOrEmpty($("#price").val())){
        	$("#money").val($("#price").val() * $("#count").val());
    	}    
	});

    var fixedAssetsAdd = $("#fixedAssetsAdd").Validform({
        tiptype: function (msg, o, cssctl) {
            var objtip = o.obj.siblings(".Validform_checktip");
            cssctl(objtip, o.type);
            objtip.text(msg);
        },
        callback: function (form) {
            if (!($("#submit").attr("process") === undefined)) {
                return false;
            }
            var url = $Url.BuildEmployeeUrl("/employee/fixedAssets/ajaxEditFixedAssets");
            var oper = "add";
            if (Number(PageVar.ID) != 0)
                oper = "edit";

            var info = {
                id: PageVar.ID,
                registrationId:$("#registrationId").val(),
				assetType: $("#assetType").val(),
				assetId: $("#assetId").val(),
				assetName: $("#assetName").val(),
				brand: $("#brand").val(),
				model: $("#model").val(),
				cPU: $("#CPU").val(),
				memory: $("#memory").val(),
				hardDisk: $("#hardDisk").val(),
				count: $("#count").val(),
				price: $("#price").val(),
				money: $("#money").val($("#price").val() * $("#count").val()),
				location: $("#location").val(),
				department: $("#department").val(),
				userNo: $("#userNo").val(),
				status: $("#status").val(),
				editComment: $("#editComment").val()
            }
            if($("#count").val()*1*$("#price").val()!=$("#money").val()*1){
            	alert("单价数量乘积不是总价");
            	return false;
            }
            if($("#assetType").val()==1 &&($String.IsNullOrEmpty($("#CPU").val()) || $String.IsNullOrEmpty($("#memory").val()) || $String.IsNullOrEmpty($("#hardDisk").val()))){
            	alert("类型电脑必须填写CPU，内存以及硬盘信息");
            	return false;
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
                        window.location.href = $Url.BuildEmployeeUrl("/employee/fixedAssets/edit?id=" + data.errDesc);
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
    fixedAssetsAdd.addRule([
{
	 ele:"#assetId",
    dataType:"*",
    nullmsg:"请填写编号",
    sucmsg:" ",
    errmsg:""
},
{
	 ele:"#assetName",
    dataType:"*",
    nullmsg:"请填写名称",
    sucmsg:" ",
    errmsg:""
},
{
	 ele:"#brand",
    dataType:"*",
    nullmsg:"请填写品牌",
    sucmsg:" ",
    errmsg:""
},
{
	 ele:"#model",
   dataType:"*",
   nullmsg:"请填写型号",
   sucmsg:" ",
   errmsg:""
},
{
	 ele:"#count",
  dataType:"n",
  nullmsg:"请填写数量",
  sucmsg:" ",
  errmsg:""
},
{
	 ele:"#price",
  dataType:"*",
  nullmsg:"请填写单价",
  sucmsg:" ",
  errmsg:""
},
{
	 ele:"#money",
  dataType:"*",
  nullmsg:"请填写金额",
  sucmsg:" ",
  errmsg:""
}

    ]);
})
