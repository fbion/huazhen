/**
 * Created by Administrator on 2015/6/16.
 */
var ManagePage ={
    GetDate:function(strat,end,obj){
        var op = $("<option></option>").text("全部").val(0);
        obj.append(op);
        for (var i=strat;i<=end;i++){
            var op = $("<option></option>").text(i).val(i);
            obj.append(op);
        }
    },
    Resize: function () {
        $("#content_center").css({"min-height":"803px","height":$(".wrappContent").height()+400});
        $("td[rel1^='dep']").each(function (index, content) {
            $(this).attr("rowspan", $("." + $(this).attr("rel1").split("_")[1]).length);
        });
        $("td[rel3^='dep3']").each(function (index, content) {
            $(this).attr("rowspan", $("." + $(this).attr("rel3").split("_")[1]).length);
        });
        $("td[rel2^='dep_newFinanceTotal']").each(function (index, content) {
            $(this).attr("rowspan", $("." + $(this).attr("rel2").split("_")[1]).length-2);
        });
        $("td[rel3^='dep3']").each(function (index, content) {
            $(this).attr("rowspan", $("." + $(this).attr("rel3").split("_")[1]).length);
        });
    }

}

$(function () {
    ManagePage.Resize();
    EnumList.GetEnumListToSelect($("#deptNo"), "deptListByType", $Url.BuildEmployeeUrl("/common/enumList.action"),3);
    ManagePage.GetDate(2014,2020,$("#week_year"));
    ManagePage.GetDate(1,55,$("#week_week"));
    $("#monthTime").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM'});
    });

    $("#dayTime").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd'});
    });
    $('.tab_title>a').on("click",function() {
        if($(this).text()=='详细信息'){
            //$("#content_center").css({"min-height":"803px","height":$(".tableCenter").eq(1).height()+260});
            $("#content_center").css({"min-height":"803px","height":$(".wrappContent").height()+260});
        }else{
            ManagePage.Resize();
        }
    });
    $("#weekButton").click(function(){
        var url = $Url.BuildEmployeeUrl('/customer/addCustomerReportSelect');
        var year = $("#week_year").val();
        var week = $("#week_week").val();
        var type = 2;
        var deptType = 3;
        var deptNo = $("#deptNo").val();
        if(year==0||week==0){
            alert("请选择日期");
        }else{
            $.ajax({
                type : "post",
                async : false,
                url : url,
                dataType : "html",
                cache : true,
                data : {
                    year : year,
                    week:week,
                    type:type,
                    byDeptNo:deptNo,
                    deptType:deptType
                },
                beforeSend : function(XMLHttpRequest) {
                },
                success : function(data) {
                    $(".position").html(data);
                    ManagePage.Resize();
                },
                complete : function(XMLHttpRequest, textStatus) {
                },
                error : function() {
                    alert("内部错误1");
                }
            });
        }
    });
    $("#monthButton").click(function(){
        var url = $Url.BuildEmployeeUrl('/customer/addCustomerReportSelect');
        var monthTime = $("#monthTime").val();
        var type = 1;
        var deptNo = $("#deptNo").val();
        var deptType = 3;
        if(monthTime==null||monthTime=="") {
            alert("请选择日期");
        }else{
            $.ajax({
                type : "post",
                async : false,
                url : url,
                dataType : "html",
                cache : true,
                data : {
                    monthTime : monthTime,
                    type:type,
                    byDeptNo:deptNo,
                    deptType:deptType
                },
                beforeSend : function(XMLHttpRequest) {
                },
                success : function(data) {
                    $(".position").html(data);
                    ManagePage.Resize();
                },
                complete : function(XMLHttpRequest, textStatus) {
                },
                error : function() {
                    alert("内部错误1");
                }
            });
        }

    });
    $("#dayButton").click(function(){
        var url = $Url.BuildEmployeeUrl('/customer/addCustomerReportSelect');
        var dayTime = $("#dayTime").val();
        var type = 3;
        var deptNo = $("#deptNo").val();
        var deptType = 3;
        if(dayTime==null||dayTime=="") {
            alert("请选择日期");
        }else{
            $.ajax({
                type : "post",
                async : false,
                url : url,
                dataType : "html",
                cache : true,
                data : {
                    dayTime : dayTime,
                    type:type,
                    byDeptNo:deptNo,
                    deptType:deptType
                },
                beforeSend : function(XMLHttpRequest) {
                },
                success : function(data) {
                    $(".position").html(data);
                    ManagePage.Resize();
                },
                complete : function(XMLHttpRequest, textStatus) {
                },
                error : function() {
                    alert("内部错误1");
                }
            });
        }

    });
})
