var ManagePage = {
  DateInputElem: function (value, options) {
        var el = document.createElement("input");
        el.type = "text";
        el.value = value;
        el.onclick = function () { el.focus(); el.select(); WdatePicker({ dateFmt: 'yyyy-MM-dd' }); };
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
            url: $Url.BuildEmployeeUrl('/employee/deptYearNeed/ajaxListDeptYearNeed.action'),
            editurl: $Url.BuildEmployeeUrl("/employee/deptYearNeed/ajaxEditDeptYearNeed.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","编号","编制编号","年度","公司名称","部门名称","现有人数","增加人数","审核编号"],
            colModel: [

				{
					name: "act", index: "act", width: 60, align: "center", sortable: false
				},
				{
					name: "id", index: "id", width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
				},
				{
					name: "code", index: "code", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "financialYear", index: "financialYear", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					 name: "companyNo", index: "companyNo", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: {size: 1, value: EnumList.GetEnumListToEdit("empCompanylist", $Url.BuildEmployeeUrl("/common/enumList.action"))}, formoptions: { rowpos: 8, colpos: 1 }, sortable: false, editable: true
			    },
				{
			        name: "deptNo", index: "deptNo", width: 40, align: "left", formatter:"select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("dept", $Url.BuildEmployeeUrl("/common/enumList.action"))}, formoptions: { rowpos: 8, colpos: 2 }, sortable: false, editable: true
		        },
				{
					name: "nowEmpTotal", index: "nowEmpTotal", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "addEmpTotal", index: "addEmpTotal", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "activitiNo", index: "activitiNo", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
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
                var ids = $("#gridTable").jqGrid('getCol', 'id', true);
                var activitiNos = $("#gridTable").jqGrid('getCol', 'activitiNo', true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;
                    var activitiNo = activitiNos[i].value;
                    var detail = "";
                    detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id +"','" +activitiNo+"')\">查看</a>";
                    $("#gridTable").jqGrid("setRowData", id, { act: detail });
                }
            }
        });
    },
    InitQuery: function () {
        $("#btnSearch").click(function () {
        	 var bySelectDepartment = $("#selectDepartment").val();
        	 var byYear = $("#byYear").val();
        	 $("#gridTable").jqGrid('setGridParam', {
                 datatype: "json",
                 postData: { 
                 	"byYear": byYear,
                 	"bySelectDepartment": bySelectDepartment,
                 	},
                 page: 1
             }).trigger("reloadGrid");
        });
    },
    GetDetail: function (index,activitiNo) {
        window.open($Url.BuildEmployeeUrl("/employee/deptYearNeed/edit?id="+index+"&activitiNo="+activitiNo));

  	  EnumList.GetEnumListToSelect($("#selectDepartment"), "dept", $Url.BuildProductUrl("/common/enumList.action"));
  	   $("#selectDepartment").change(function () {
  	    	EnumList.GetEnumListToSelect($("#selectPositionNo"), "positionListBydeptType1", $Url.BuildProductUrl("/common/enumList.action"),$("#selectDepartment").val());
  		   var positionListUrl = $Url.BuildProductUrl('/employee/deptYearNeedDetail/ajaxListDeptYearNeedDetail');
  	    	$(".position").empty();
  			$("#positionList").empty();
  			deptPositionList.GetPositionListToSelect(positionListUrl, $(this).val()); 
  	   });
  	  $("#back").click(function () {
          window.location.href = $Url.BuildEmployeeUrl("/employee/deptYearNeed/list");
      });
     var deptPositionList = {
  		GetPositionListToSelect : function(listUrl, param) {
     		$.ajax({
     			type : "post",
     			async : false,
     			url : listUrl,
     			dataType : "html",
     			cache : true,
     			beforeSend : function(XMLHttpRequest) {
     			},
     			data : {
     				param : param
     			},
     			success : function(data) {
     				$(".position").html(data);
     		
     			},
     			complete : function(XMLHttpRequest, textStatus) {
     			},
     			error : function() {
     				// 请求出错处理
     				alert("内部错误1");
     			}
     		});
     	}	
     }
      if (Number(PageVar.ID) == 0) {
          ManagePage.EnableInput();
          ManagePage.HideEditButton();
      }
      else {
          ManagePage.GetInfo(PageVar.ID);
      }



      

    },
    GetAdd: function () {
//    	var backUrl = window.location.href;
        window.open($Url.BuildEmployeeUrl("/employee/deptYearNeed/edit"));
    }
}


$(function () {
    $("#btnAdd").click(function () { ManagePage.GetAdd(); });
    ManagePage.InitGrid();
    ManagePage.InitQuery();
    
    EnumList.GetEnumListToSelect($("#selectDepartment"), "deptAll", $Url.BuildEmployeeUrl("/common/enumList.action"));
	 $("#btnYearNeedTotal").click(function (){ 
    	  window.open($Url.BuildEmployeeUrl("/employee/yearNeedTotal/list"));
     });
   
});
