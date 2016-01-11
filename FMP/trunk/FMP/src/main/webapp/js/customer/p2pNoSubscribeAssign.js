
/**
 * Created by Administrator on 2015/3/27.
 */
var Tools = {
    //省 市 区 门店
    GetListToSelect: function (jqueryObj, listUrl, param) {
        $.ajax({
            type: "post",
            async: false,
            url: listUrl,
            dataType: "json",
            cache: true,
            beforeSend: function (XMLHttpRequest) {
            },
            data: { param: param
            },
            success: function (data) {
                data = data.resultList;
                if (data != null) {
                    if (param != "") {
                        jqueryObj.empty();
                    }
                    var p = $("<option></option>").text("请选择").val("");
                    jqueryObj.append(p);
                    for (var i = 0; i < data.length; i++) {
                        var op = $("<option></option>").text(data[i].name).val(data[i].id);
                        jqueryObj.append(op);
                    }
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            },
            error: function () {
                //请求出错处理
                alert("内部错误");
            }
        });
    }

}
var PageManage = {
    Assign: function () {
        var p1 = $("<option></option>").text("请选择").val(0);
        var p2 = $("<option></option>").text("请选择").val(0);
        var p3 = $("<option></option>").text("请选择").val(0);
        var p4 = $("<option></option>").text("请选择").val(0);
        var p5 = $("<option></option>").text("请选择").val(0);
        var province = $(".province");
        var city = $(".city");
        var district = $(".district");
        var department = $(".department");
        var employee = $(".employee");
        city.append(p2);
        district.append(p3);
        department.append(p4);
        employee.append(p5);

        var provinceListUrl = $Url.BuildSalesUrl('/baseInfo/province/ajaxProvince.action');
        var cityListUrl = $Url.BuildSalesUrl('/baseInfo/city/ajaxCity.action');
        var districtListUrl = $Url.BuildSalesUrl('/baseInfo/district/ajaxDistrict.action');
        var departmentListUrl = $Url.BuildSalesUrl('/employee/department/ajaxGetDepartmentByDistrictNo.action');
        var employeeListUrl = $Url.BuildSalesUrl('/employee/employee/ajaxGetEmpListByDeptAndStatus.action');

        Tools.GetListToSelect(province, provinceListUrl, "");
        province.change(function () {
            city.empty();
            district.empty();
            district.append(p3);
            department.append(p4);
            employee.append(p5);
//            employee.empty();
            Tools.GetListToSelect(city, cityListUrl, province.val());

        });
        city.change(function () {
            district.empty();
            department.empty();
            department.append(p4);
            employee.append(p5);
//            employee.empty();
            Tools.GetListToSelect(district, districtListUrl, city.val());

        });
        district.change(function () {
            department.empty();
            employee.append(p5);
//            employee.empty();
            Tools.GetListToSelect(department, departmentListUrl, district.val());


        });
        department.change(function () {
            employee.empty();
            Tools.GetListToSelect(employee, employeeListUrl,department.val());
        });
    },
    CommitAssign:function(){
        var url = $Url.BuildSalesUrl("/customer/p2pSubscribe/ajaxAssignNoEmpNo.action");
        $.ajax({
            type:"post",
            url:url,
            dataType:"json",
            data:{
                deptNo:$("#department").val(),
                empNo:$("#employee").val(),
                p2pCustomer:$("#p2pCustomer").val(),
//                p2pSubscribe: $("#p2pSubscribe").val()
            },
            success: function (data) {
                window.location.href = $Url.BuildSalesUrl("/customer/p2pCustomer/list") + "?navSub=P2P客户";
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("请重新指定理财经理");
            }
        });
    }


}
$(function () {
    PageManage.Assign();
    if($("#commintAssign").length > 0){
        $("#commintAssign").click(function(){
            PageManage.CommitAssign();
        });
    }
});
