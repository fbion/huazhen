/**
 * Created by Administrator on 2015/8/21.
 */
$(function() {
    EmployeeTreeControl.startTree({
        param: "on",  //on在职员工，out离职员工，test测试员工
        treeInputId: "employeeSel",//员工控件框ID
        valInputId: "byName", //员工值框id
        inputType: "employee",//employee员工，position职位
        idType: "userNo",        //员工empNo，userNo,职位positionNo,部门deptNo，公司companyNo
        chkStyle: "radio",//选框类型checkbox,radio
        nochecks:[true,true,false],      //逐级不显示单或复选框,true不显示，false显示
        chkboxType:{Y:"ps", N:"ps"},  //Y被勾选时关联父类子类ps，N取消被勾选时关联父类子类ps
        showPreBut: true,   //显示全部员工，在职员工按钮,离职员工，test测试员工
        //showSearch: true,   //显示搜索框
        showLevel:3,         //显示层级
        sizeAuto:true,		//自动调节大小
        width:50,			//宽，单位px
        height:300			//高，单位px
    });


    $("#btnSearch").click(function(){
        if($("#cellphone").val()==""&&$("#byName").val()==""){
           alert("请输查询条件");
        }else{
            var info = {
                byName: $("#byName").val(),
                cellphone: $("#cellphone").val()
            }
            MailList.GetInfo(info);
        }
    })


    if($.getUrlVar('id')!=null){
        var info = {
            byName: $("#byName").val(),
            cellphone: $("#cellphone").val(),
            userNo:$.getUrlVar('id')
        }
        MailList.GetInfo(info);
    }

});
var MailList = {
    ShowPhoto: function (path) {
        $("#emphead").attr("src", path);
    },
    GetInfo:function(info){
        var url = $Url.BuildEmployeeUrl("/employee/employee/ajaxGetInfoByCondition");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {
                byName: info.byName,
                cellphone:info.cellphone,
                userNo:info.userNo
            },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if (data.errCode != "0000") {
                    alert(data.errDesc);
                    return;
                }
                $("#name").text(data.info.name);
                $("#sex").text(data.info.address);
                $("#qq").text(data.info.qq);
                $("#telephone").text(data.info.telephone);
                $("#cellphone1").text(data.info.cellphone1);
                $("#email").text(data.info.email);
                $("#weixin").text(data.info.weixin);
                $Link.MakeUrl($("#parent"), data.info.parentNo, "empListById", $Url.BuildSalesUrl("/common/enumList.action"));
                $Link.MakeUrl($("#dept"), data.info.deptNo, "dept", $Url.BuildSalesUrl("/common/enumList.action"));
                $Link.MakeUrl($("#position"), data.info.positionNo, "positionList", $Url.BuildSalesUrl("/common/enumList.action"));
                $Link.MakeUrl($("#status"), data.info.status, "employeeStatusAll", $Url.BuildSalesUrl("/common/enumList.action"));
                MailList.ShowPhoto($Url.BuildFileUrl(data.info.portraitPath));
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    }
}