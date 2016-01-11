/**
 * Created by paul on 14-12-17.
 */
var ManagePage = {
    InitGrid: function () {
        //grid start  
        $("#gridTable").jqGrid({
            url: $Url.BuildPermissionUrl('/permission/user/ajaxListUser.action'),
            editurl: $Url.BuildPermissionUrl("/permission/user/ajaxEditUser.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作", "ID", "用户名","密码","修改备注"],
            colModel: [
                {
                    name: "act", index: "act", width: 60, align: "center", sortable: false
                },
                {
                    name: "id", index: "id", width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 20 }
                },
                {
                    name: "name", index: "name", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }
                },
                {
                    name: "password", index: "password", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 }
                },
                {
                    name: "editComment", index: "editComment", hidden:true, width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, edittype: "textarea", editoptions: { size: 20 }, editrules: { edithidden: true }
                }
            ],
            sortname: "id",
            sortorder: "desc",
            pager: "#gridPager",
            viewrecords: true,
            rowNum: 10,
            rowList: [10],
            altclass: "altRowsColour",
            shrinkToFit:true,
            autowidth: true,
            height: "auto",
            multiselect: true,
            prmNames: {
                search: "search",
                page: "pageIndex",    // 表示请求页码的参数名称
                rows: "pageSize"    // 表示请求行数的参数名称
            },
            jsonReader: {
                root: "resultList",   // json中代表实际模型数据的入口
                page: "pageIndex",   // json中代表当前页码的数据
                total: "pageCount", // json中代表页码总数的数据
                records: "recordCount", // json中代表数据行总数的数据
                repeatitems: false // 如果设为false，则jqGrid在解析json时，会根据name来搜索对应的数据元素（即可以json中元素可以不按顺序）；而所使用的name是来自于colModel中的name设定。
            },
            pager: "#gridPager",
            gridComplete: function () {
                var space = "|";
                var ids = $("#gridTable").jqGrid('getCol', 'id', true);//获取某列的值
                var names = $("#gridTable").jqGrid('getCol', 'name', true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;
                    var name =names[i].value;

                    var detail = "";
                    var edit = "";
                    var assign = "";

                    detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id + "')\">查看</a>";
                    edit = "<a class=\"blue\" href=\"javascript:ManagePage.GetEdit('" + id + "')\">编辑</a>";
                    
                    assign = " <a class=\"blue\" href=\"javascript:ManagePage.AssignRoles('" + id + ","+ name +"')\">分配角色</a>";
                    //assign = "<a onclick=\"$('#w').window('open')\" class=\"blue\" href=\"javascript:void(0)\">分配角色</a>";

                    $("#gridTable").jqGrid("setRowData", id, { act: detail + space + edit + space + assign});
                }
            }
        });
    },
    InitQuery: function () {
        $("#btnSearch").click(function () {
            var byName = $("#byName").val();
           

            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: { "byName": byName }, //发送数据
                page: 1
            }).trigger("reloadGrid"); //重新载入
        });
    },
    GetDetail: function (index) {
        jQuery("#gridTable").jqGrid('editGridRow', index, {
            editCaption: "查看记录",
            beforeShowForm: function () {
                $(".DataTD").children().attr("disabled", "disabled");
                $(".EditButton").html("");
            }, afterShowForm: function () {
            }
        });
    },
    GetEdit: function (index) {
        jQuery("#gridTable").jqGrid('editGridRow', index, {
            reloadAfterSubmit: true, closeAfterEdit: true,
            beforeShowForm: function () {
//            	$("#name").attr("disabled","disabled");
            }, afterShowForm: function () {
            }, afterSubmit: function (response, postdata) {
                var res = jQuery.parseJSON(response.responseText), ok = res.errDesc =="";

                return [ok, ok ? '' : res.errDesc];
            }
        });
    },
    GetAdd: function () {
        jQuery("#gridTable").jqGrid('editGridRow', "new", {
            reloadAfterSubmit: true, closeAfterAdd: true, editCaption: "添加记录",
            beforeShowForm: function () {
                $("#tr_id").css("visibility","hidden");
            }, afterShowForm: function () {
            }, afterSubmit: function (response, postdata) {
                var res = jQuery.parseJSON(response.responseText), ok = res.errDesc =="";

                return [ok, ok ? '' : res.errDesc];
            }
        });
    },
  
  //为用户分配角色
    AssignRoles: function (index) {
       $('#w').window('open');
       
       var strs= new Array(); //定义一数组 
       strs=index.split(","); //字符分割 
       
       //var name = $("#name").val(index);
       EnumList.GetEnumListToSelect($("#unAssignRoleList"), "unAssignRoles", $Url.BuildPermissionUrl("/common/enumList.action"),strs[0]);
       EnumList.GetEnumListToSelect($("#assignRoleList"), "roleByUserId", $Url.BuildPermissionUrl("/common/enumList.action"),strs[0]);
       $("#id").html(strs[0]);
       $("#userName").html(strs[1]);
       $("#userName1").html(strs[1]);
    }
}
$(function () {
	
    $("#btnAdd").click(function () { ManagePage.GetAdd(); });
    
    ManagePage.InitGrid();
    ManagePage.InitQuery();
    
    
    $("#unAssignRoleList").dblclick(function(){
    	EnumList.AssignRole("unAssignRoleList","assignRoleList", $Url.BuildPermissionUrl("/permission/userRole/ajaxUpDateRoles.action"),$("#id").text());
	});
   $("#assignRoleList").dblclick(function(){
	   EnumList.AssignRole("assignRoleList","unAssignRoleList", $Url.BuildPermissionUrl("/permission/userRole/ajaxUpDateRoles.action"),$("#id").text());
	});
   $("#leftToRigth").click(function(){
	   EnumList.AssignRole("unAssignRoleList","assignRoleList", $Url.BuildPermissionUrl("/permission/userRole/ajaxUpDateRoles.action"),$("#id").text());
   });
   $("#rigthToLeft").click(function(){
	   EnumList.AssignRole("assignRoleList","unAssignRoleList", $Url.BuildPermissionUrl("/permission/userRole/ajaxUpDateRoles.action"),$("#id").text());
   });
  
});
