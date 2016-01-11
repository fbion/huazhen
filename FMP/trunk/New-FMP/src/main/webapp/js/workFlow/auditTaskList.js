var auditTaskList = {
	    InitGrid: function () {
	        //默认是通过id倒排序，默认可不写，支持传递多个排序条件
	        //var sortList = [{sort:"in_user_no",order:"desc"},{sort:"id",order:"desc"}];
	        //var sortList = [{sort:"edit_user_no",order:"desc"}];
	        $("#gridTable").datagrid({
	            url: $Url.BuildWorkFlowUrl('/workFlow/auditTask/easyUIAuditTaskList'),
	            method: 'post',
	            resizable: true,
	            fit: true,
	            multiSort: true,
	            autoRowHeight: false,
	            singleSelect: true,
	            rownumbers: true,
	            toolbar: "#toolbar",
	            loadMsg: "正在加载，请稍等...",
	            pagination: true,
	            pageSize: 15,
	            pageList: [15, 30, 50],
	            queryParams: {
	                //sortList:JSON.stringify(sortList)
	            },
	            columns: [[
			{ field: 'id', title: 'id', align: 'left', halign: 'center',width:'10%', hidden: true },
			{ field: 'title', title: '标题', align: 'left', halign: 'center',width:'47%', hidden: false, sortable: false },
			{ field: 'requestUser', title: '申请人', align: 'left', halign: 'center',width:'10%', hidden: false, sortable: false },
			{ field: 'taskId', title: '任务', align: 'left', halign: 'center',width:'10%', hidden: true, sortable: false },
			{ field: 'uri', title: '实例', align: 'left', halign: 'center',width:'10%', hidden: true, sortable: false },
			{ field: 'requestDate', title: '申请日期', align: 'center', halign: 'center',width:'15%', hidden: false, sortable: true },
			{ field: 'taskDate', title: '获得任务日期', align: 'center', halign: 'center',width:'15%', hidden: false, sortable: true },
			{ field: 'startUserId', title: '申请人ID', align: 'left', halign: 'center',width:'10%', hidden: true, sortable: false },
			{ field: 'activitiNo', title: '流程实例ID', align: 'center', halign: 'center',width:'10%', hidden: false, sortable: false },
			{ field: 'name', title: '名字', align: 'left', halign: 'center',width:'10%', hidden: true, sortable: false },
			{ field: 'actProcess', title: '查看流程图', align: 'left', halign: 'center',width:'10%', hidden: true, sortable: false }
	            ]],
	            onBeforeLoad: function (param) {
	                $.getJSON($Url.BuildWorkFlowUrl("/getColumnCookie"), { key: "auditTaskList" }, function (data) {
	                	if(!$String.IsNullOrEmpty(data.value)){
	                    $.each(JSON.parse(data.value), function (i, item) {
	                        for (var temp in item) {
	                            if (item[temp]) {
	                                $("#gridTable").datagrid("hideColumn", temp);
	                            }
	                            else {
	                                $("#gridTable").datagrid("showColumn", temp);
	                            }
	                        }
	                    });
	                	}
	                });
	            },

	            onHeaderContextMenu: function (e, field) {
	                e.preventDefault();
	                if (!$('#tmenu').length) {
	                    auditTaskList.CreateColumnMenu();
	                }
	                $('#tmenu').menu('show', {
	                    left: e.pageX,
	                    top: e.pageY
	                });
	            }
	        }).datagrid("columnMoving");
	        var page = $("#gridTable").datagrid("getPager");
	        if (page) {
	            page.pagination({
	                beforePageText: "第",
	                afterPageText: "页    共 {pages} 页",
	                displayMsg: "当前显示 {from} - {to} 条记录   共 {total} 条记录"
	            });
	        }
	    },
	    CreateColumnMenu: function () {
	        var fields = $("#gridTable").datagrid("getColumnFields");
	        var tmenu = $('<div id="tmenu" style="width:100px;"></div>').appendTo('body');
	        for (var i = 0; i < fields.length; i++) {
	            var title = $("#gridTable").datagrid("getColumnOption",fields[i]).title
	            if ($("#gridTable").datagrid("getColumnOption", fields[i]).hidden) {
	                $('<div></fields>').html(title).attr("id",fields[i]).appendTo(tmenu);
	            }
	            else {
	                $('<div iconCls="icon-ok"></fields>').html(title).attr("id",fields[i]).appendTo(tmenu);
	            }
	        }
	        tmenu.menu({
	            onClick: function (item) {
	                if (item.iconCls == "icon-ok") {
	                    $("#gridTable").datagrid("hideColumn", item.id);
	                    tmenu.menu("setIcon", {
	                        target: item.target,
	                        iconCls: "icon-empty"
	                    });
	                } else {
	                    $("#gridTable").datagrid("showColumn", item.id);
	                    tmenu.menu("setIcon", {
	                        target: item.target,
	                        iconCls: "icon-ok"
	                    });
	                }
	                ProductList.SetColumnCookie()
	            }
	        });
	    },
	    SetColumnCookie: function () {
	        var columnArray = new Array();
	        var fields = $("#gridTable").datagrid("getColumnFields");
	        for (var i = 0; i < fields.length; i++) {
	            var info = new Object();
	            var property = $("#gridTable").datagrid("getColumnOption", fields[i]).hidden;
	            info[fields[i].toString()] = property == undefined || property == false ? false : true;
	            columnArray.push(info);
	        }
	        $.post($Url.BuildWorkFlowUrl("/setColumnCookie"), {
	            key: "auditTaskList",
	            value: JSON.stringify(columnArray)
	        });
	    },
	    InitQuery: function () {
	    	var requestUser = $("#requestUser").val().trim();
	        var title =  $("#title").val();
	        var requestDate = $("#requestDate").val();
	        $("#gridTable").datagrid("load", {
	        	byRequestUser: requestUser,
	        	bySelectTitle:title,
	        	byDate:requestDate
	        });
	    },
	    GetWindow:function(id,activitiNo){
	    	$('#w1').window('open')
	    	$(".examine").click(function(){
	    		var url = $Url.BuildWorkFlowUrl("/workFlow/auditTask/ajaxAddExamine.action");
	    		var uri=window.location.href;
	    		var sendData={
	    				per:$(this).val(),
	    				id:id,
	    				activitiNo:activitiNo,
	    				comment:$("#taskCommet").val(),
	    		};
	    		$.ajax({
					type: "post",
					url: url,
					dataType: "json",
					timeout: 30000,
					data: sendData,
					beforeSend: function () {
					},
					error: function (XMLHttpRequest, textStatus, errorThrown,request) {
						alert(errorThrown);
					},
					success: function (data, textStatus) {
						alert("审批完成");
						$("#taskCommet").val("");
						$('#w1').window('close');
						window.location.reload();
						$("#examine").hide();
						
					},
					complete: function (XMLHttpRequest, textStatus) {
					}
				});
	    	});
	    }
}
$(function () {
    auditTaskList.InitGrid();

    $("#btnSearch").click(function () {
        auditTaskList.InitQuery();
    });
    $('#requestDate').click(function(){
        WdatePicker({dateFmt: 'yyyy-MM-dd'});
    });
    $("#btnExamine").click(function () {
//    	var rows=$('#gridTable').datagrid('getRows');
        var row = $("#gridTable").datagrid("getSelected");
        
        if (row == null) {
            $.messager.alert({
                title: '提示',
                msg: '请选择数据！',
                showType: 'show'
            });
            return false;
        }
        
//        for (var i = 0; i <rows.length; i++) {
     	   if(row.title=="试用期评估审批" && row.name!="HR"){
     		  $.messager.alert({
                  title: '提示',
                  msg: '请点击Detail！',
                  showType: 'show'
              });
     		   return false;
     	   }
     	  if(row.title=="延长试用起申请审批" &&row.name!="延长试用期考核要求及薪资" && row.name!="试用期考察评定："){
     		 $.messager.alert({
                 title: '提示',
                 msg: '请点击Detail！',
                 showType: 'show'
             });
     		  return false;
            }
//     	}
    	
//        $EasyUI.NewTab("Detail", $Url.BuildWorkFlowUrl(row.uri)+row.activitiNo);
     	 auditTaskList.GetWindow(row.id,row.activitiNo);
    });
    $("#btnDetails").click(function () {
        var row = $("#gridTable").datagrid("getSelected");
        if (row == null) {
            $.messager.alert({
                title: '提示',
                msg: '请选择数据！',
                showType: 'show'
            });
            return false;
        }
        $EasyUI.NewTab("Detail", $Url.BuildWorkFlowUrl(row.uri)+row.activitiNo);
    });
    $("#btnProcess").click(function () {
        var row = $("#gridTable").datagrid("getSelected");
        if (row == null) {
            $.messager.alert({
                title: '提示',
                msg: '请选择数据！',
                showType: 'show'
            });
            return false;
        }
//        $EasyUI.NewTab("查看流程图", $Url.BuildWorkFlowUrl(row.uri)+row.activitiNo);
        var url = $Url.BuildWorkFlowUrl("/workFlow/processing/ajaxAuditProcess");
		  initAll.GetAuditProcess(url,row.activitiNo);
    });
});