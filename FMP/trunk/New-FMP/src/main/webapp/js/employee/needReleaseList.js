var ManagePage = {
    DateInputElem: function (value, options) {
        var el = document.createElement("input");
        el.type = "text";
        el.value = value;
        el.onclick = function () { el.focus(); el.select(); WdatePicker({ dateFmt: 'yyyy-MM-dd HH:mm:ss' }); };
        $(el).addClass("FormElement");
        $(el).addClass("ui-widget-content");
        $(el).addClass("ui-corner-all");
        $(el).css("width", "204px");
        return el;
    },
    DateInputValue: function (elem, operation, value) {
        if (operation === 'get') {
            return $(elem).val();
        } else if (operation === 'set') {
            $(elem).val(value);
        }
    },
    InitGrid: function () {
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildEmployeeUrl('/employee/needRelease/ajaxListNeedRelease.action'),
            editurl: $Url.BuildEmployeeUrl("/employee/needRelease/ajaxEditNeedRelease.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","编号","分公司","部门","职位","需求人数","到岗时间","录入时间"],
            colModel: [
				{
					name: "act", index: "act", width: 60, align: "center", sortable: false
				},
				{
					name: "id", index: "id", width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
				},
				{
					name: "companyNo", index: "companyNo", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("empCompanylist", $Url.BuildEmployeeUrl("/common/enumList.action"))},formoptions: { rowpos: 6, colpos: 1 }, sortable: false, editable: true
				},
				{
			        name: "deptNo", index: "deptNo", width: 40, align: "left", formatter:"select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("dept", $Url.BuildEmployeeUrl("/common/enumList.action"))}, formoptions: { rowpos: 8, colpos: 2 }, sortable: false, editable: true
		        },
		        {
			        name: "positionNo", index: "positionNo", width: 40, align: "left", formatter:"select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("positionList", $Url.BuildEmployeeUrl("/common/enumList.action"))}, formoptions: { rowpos: 8, colpos: 2 }, sortable: false, editable: true
		        },
				{
					name: "addEmp", index: "addEmp", width: 40, align: "left",formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "workTime", index: "workTime", width: 40, align: "left",formatter: "date", formoptions: { rowpos: 4, colpos: 2 }, sortable: false,editable: true, editoptions: { size: 40 },formatter:ManagePage.ToDDMMMYYYY
				},
				{
					name: "inTime", index: "inTime", width: 40, align: "left", formatter: "date",formoptions: { rowpos: 5, colpos: 2 }, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, sortable: false, editable: true, editoptions: { size: 40 }
				}
				             
            ],
            sortname: "id",
            sortorder: "desc",
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
                page: "pageIndex",
                rows: "pageSize"
            },
            jsonReader: {
                root: "resultList",
                page: "pageIndex",
                total: "pageCount",
                records: "recordCount",
                repeatitems: false
            },
            pager: "#gridPager",
            gridComplete: function () {
                //var space = "|";
                var ids = $("#gridTable").jqGrid('getCol', 'id', true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;

                    var detail = "";
                    var edit = "";

                    detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id + "')\">查看</a>";
                    //edit = "<a class=\"blue\" href=\"javascript:ManagePage.GetEdit('" + id + "')\">编辑</a>";

                    $("#gridTable").jqGrid("setRowData", id, { act: detail });
                }
            }
        });
    },
    InitQuery: function () {
        $("#btnSearch").click(function () {
            //var byName = $("#byName").val();


            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                //postData: { "byName": byName },
                page: 1
            }).trigger("reloadGrid");
        });
    },
    ToDDMMMYYYY:function(date, options, rowObject) {  
        var d = new Date(date);  
        var dd = d.getDate() < 10 ? "0" + d.getDate() : d.getDate().toString(); 
        var mm = d.getMonth()+1< 10 ? "0" + (d.getMonth()+1):(d.getMonth()+1).toString();  
        var yyyy = d.getFullYear().toString();  
        return yyyy +"-"+ mm + "-"+dd;  
    },
    GetDetail: function (index) {
        $EasyUI.NewTab("Detail",$Url.BuildEmployeeUrl("/employee/needRelease/edit?id="+index));
    },

    GetAdd: function () {
        $EasyUI.NewTab("New",$Url.BuildEmployeeUrl("/employee/needRelease/edit"));
    }
}


$(function () {
    $("#btnAdd").click(function () { ManagePage.GetAdd(); });
    $("#needReleaseTask").click(function (){ 
  	  window.location.href = $Url.BuildEmployeeUrl("/employee/needRelease/needReleaseTask")
    });
    ManagePage.InitGrid();
    ManagePage.InitQuery();
});