var ManagePage = {
    Tree:function(){
        EmployeeTreeControl.startTree({
            param: "on",  //on在职员工，out离职员工，test测试员工
            treeInputId: "employeeSel",//员工控件框ID
            valInputId: "empNo", //员工值框id
            inputType: "employee",//employee员工，position职位
            idType: "empNo",        //员工empNo，userNo,职位positionNo,部门deptNo，公司companyNo
            chkStyle: "radio",//选框类型checkbox,radio
            nochecks:[true,true,false],      //逐级不显示单或复选框,true不显示，false显示
            chkboxType:{Y:"ps", N:"ps"},  //Y被勾选时关联父类子类ps，N取消被勾选时关联父类子类ps
            showPreBut: true,   //显示全部员工，在职员工按钮,离职员工，test测试员工
            //showSearch: true,   //显示搜索框
            showLevel:3,         //显示层级
            sizeAuto:true,		//自动调节大小
            width:200,			//宽，单位px
            height:300			//高，单位px
        });
    },
    EnableInput: function () {
        $.each($(".data"), function (index, content) {
            var id = $(this).attr("id");
            if (ElementVar[id] == undefined) {
                $(this).removeAttr("disabled");
            } else {
                if (Number(PageVar.ID) == 0){
                    if (ElementVar[id] != TagPermissionType.none){
                        $(this).removeAttr("disabled");
                    }
                }else if (Number(PageVar.ID) != 0){
                    if (ElementVar[id] == TagPermissionType.edit)
                        $(this).removeAttr("disabled");
                }
            }

        });
    },
    DisableInput: function () {
        $(".data").attr("disabled", "disabled");
    },
    ShowEditButton: function (currStatus) {
        if ($("#edit").length > 0){
        	$("#edit").show();
        	$("#uploadInput").attr("disabled","disabled"); 
        	$("#uploadInput2").attr("disabled","disabled"); 
        }else{
        	$("#uploadInput").removeAttr("disabled");
        	$("#uploadInput2").removeAttr("disabled"); 
        }
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
        var url = $Url.BuildEmployeeUrl("/employee/department/ajaxGetDepartment");
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

                if (!$String.IsNullOrEmpty($("#departmentImagePath").val())) {
                    FileManage.ShowPhoto($Url.BuildFileUrl($("#departmentImagePath").val()));
                } else {
                    $("#emphead").attr("src", $Url.BuildImgUrl("head/TestImg.jpg"));
                }
                if (!$String.IsNullOrEmpty($("#locationImagePath").val())) {
                    FileManage.ShowPhoto2($Url.BuildFileUrl($("#locationImagePath").val()));
                } else {
                    $("#emphead2").attr("src", $Url.BuildImgUrl("head/TestImg.jpg"));
                }
                $Util.DataToVal(data.info, ElementVar);
                $("#provinceNo").trigger("change");
                $("#cityNo").val(data.info.cityNo);
                $("#cityNo").trigger("change");
                $("#districtNo").val(data.info.districtNo);

                ManagePage.Tree();
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
	        $("#b .upload").Upload({
	            inputID: "uploadInput2",
	            readOnly: readOnly,
	            multiple: false,
	            fileType: 2,
	            url: $Url.BuildEmployeeUrl("/upload.action"),
	            success: FileManage.SaveFileToPage2,
	            title: ""
	        });
	        $("#uploadInput2").addClass("data");
	    },
	    SaveFileToPage: function (fileName, relativePath) {
            FileManage.ShowPhoto($Url.BuildFileUrl(relativePath));
	        $("#departmentImagePath").val(relativePath);
	    },
	    SaveFileToPage2: function (fileName, relativePath) {

	        FileManage.ShowPhoto2($Url.BuildFileUrl(relativePath));
	        $("#locationImagePath").val(relativePath);
	    },
	    ShowPhoto: function (path) {
	        $(".emphead").attr("src", path);
	        $("#aEmpHead").attr("href", path);
	    },
	    ShowPhoto2: function (path) {
	        $(".emphead2").attr("src", path);
	        $("#aEmpHead2").attr("href", path);
	    }
}
var BindEnumList={
		BindAll:function(){
			BindEnumList.BindDeptType();
			BindEnumList.BindParentDept();
			BindEnumList.BindEmpManager();
			BindEnumList.BindCompany();
//			BindEnumList.BindProvince();
//			BindEnumList.BindCity();
//			BindEnumList.BindDistrict();
		},
		BindDeptType:function(){
			EnumList.GetEnumListToSelect($("#deptType"), "deptType", $Url.BuildEmployeeUrl("/common/enumList.action"));
		},
		BindParentDept:function(){
			EnumList.GetEnumListToSelect($("#parentNo"), "dept", $Url.BuildEmployeeUrl("/common/enumList.action"));
		},
		BindEmpManager:function(){
			EnumList.GetEnumListToSelect($("#empNo"),"empListForEmp",$Url.BuildEmployeeUrl("/common/enumList.action"));
		},
		BindCompany:function(){
			EnumList.GetEnumListToSelect($("#companyNo"), "empCompanylist", $Url.BuildEmployeeUrl("/common/enumList.action"));
		}/*,
		BindProvince:function(){
			var p = $("#provinceNo").val();
			EnumList.GetEnumListToSelect($("#provinceNo"), "provinceAll", $Url.BuildEmployeeUrl("/common/enumList.action"));
			 $("#provinceNo").val(p);
		},
		BindCity:function(){
			var c = $("#cityNo").val();
	        $("#cityNo").html("");
	        $("#cityNo").linkageForJqGrid({
	            prev: $("#provinceNo"),
	            dataType: "cityLinkAll",
	            actionUrl: $Url.BuildEmployeeUrl("/common/enumList.action"),
	            all: false
	        });
	        $("#cityNo").val(c);
		},
		BindDistrict:function(){
			var d = $("#districtNo").val();
	        $("#districtNo").html("");
	        $("#districtNo").linkageForJqGrid({
	            prev: $("#cityNo"),
	            dataType: "districtLinkAll",
	            actionUrl: $Url.BuildEmployeeUrl("/common/enumList.action"),
	            all: false
	        });
	        $("#districtNo").val(d);
		}*/
}

$(function () {
    ManagePage.Tree();
	BindEnumList.BindAll();
    $("#back").click(function () {
        window.location.href = $Url.BuildEmployeeUrl("/employee/department/list");
    });
    $.fn.linkage({
        elements : [ $("#provinceNo"), $("#cityNo")],
        dataTypes : [ "province", "cityLink" ],
        actionUrl : $Url.BuildEmployeeUrl("/common/enumList.action"),
        all : true
    });
    $.fn.linkage({
        elements : [ $("#provinceNo"), $("#cityNo"), $("#districtNo") ],
        dataTypes : [ "province", "cityLink","districtLink" ],
        actionUrl : $Url.BuildEmployeeUrl("/common/enumList.action"),
        all : true
    });
    if (Number(PageVar.ID) == 0) {
        ManagePage.EnableInput();
        ManagePage.HideEditButton();
    }
    else {
        ManagePage.GetInfo(PageVar.ID);
    }
    FileManage.BindFile();
    


    var departmentAdd = $("#departmentAdd").Validform({
        tiptype: function (msg, o, cssctl) {
            var objtip = o.obj.siblings(".Validform_checktip");
            cssctl(objtip, o.type);
            objtip.text(msg);
        },
        datatype:{
        	"verifyTel": function (gets, obj, curform, datatype) {

                var reg = /^\d{3,4}-\d{7,8}(-\d{3,4})?$/;
                if (!reg.test(gets)) {
                    return false;
                }
                	return true;
            }
        },
        callback: function (form) {
            if (!($("#submit").attr("process") === undefined)) {
                return false;
            }
            var url = $Url.BuildEmployeeUrl("/employee/department/ajaxEditDepartment");
            var oper = "add";
            if (Number(PageVar.ID) != 0)
                oper = "edit";

            var info = {
                id: PageVar.ID,
				code: $("#code").val(),
				name: $("#name").val(),
				telephone: $("#telephone").val(),
				empNo: $("#empNo").val(),
				fax: $("#fax").val(),
				comment: $("#comment").val(),
				deptType: $("#deptType").val(),
				duty: $("#duty").val(),
				parentNo: $("#parentNo").val(),
				companyNo: $("#companyNo").val(),
				editComment: $("#editComment").val(),
				provinceNo: $("#provinceNo").val(),
				cityNo: $("#cityNo").val(),
				districtNo: $("#districtNo").val(),
				directStatus: $("#directStatus").val(),
    			isTest:$("#isTest").val(),
				departmentImagePath: $("#departmentImagePath").val(),
				address: $("#address").val(),
				locationImagePath: $("#locationImagePath").val(),
				longitude: $("#longitude").val(),
				latitude: $("#latitude").val()
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
                        window.location.href = $Url.BuildEmployeeUrl("/employee/department/edit?id=" + data.errDesc);
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
    departmentAdd.addRule([
			{
				ele:"#name",
			    dataType:"s1-18",
			    nullmsg:"请填写名称",
			    sucmsg:" ",
			    errmsg:"请填写正确的名称"
			},
			{				
	            ele:"#telephone",
	            datatype:"m|verifyTel",
	            ignore:"ignore",
	            nullmsg:" ",
	            errormsg:"请填写正确的电话号",
	            sucmsg:" "
	        }
                           
    ]);
})