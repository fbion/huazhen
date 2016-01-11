var approvalHistoriaList = {
	    InitGrid: function () {
	        //默认是通过id倒排序，默认可不写，支持传递多个排序条件
	        //var sortList = [{sort:"in_user_no",order:"desc"},{sort:"id",order:"desc"}];
	        //var sortList = [{sort:"edit_user_no",order:"desc"}];
	        $("#gridTable").datagrid({
	            url: $Url.BuildWorkFlowUrl('/workFlow/approvalHistoria/easyUIApprovalHistoria'),
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
			{ field: 'id', title: 'id', align: 'left', halign: 'center',width:'10%', hidden: true, sortable: true },
			{ field: 'title', title: '标题', align: 'left', halign: 'center',width:'40%', hidden: false, sortable: false },
			{ field: 'requestUser', title: '申请人', align: 'left', halign: 'center',width:'10%', hidden: false, sortable: false },
			{ field: 'requestDate', title: '申请日期', align: 'center', halign: 'center',width:'20%', hidden: false, sortable: true },
			{ field: 'status', title: '状态', align: 'left', halign: 'center',width:'10%', hidden: false, sortable: false },
			{ field: 'endDate', title: '结束日期', align: 'center', halign: 'center',width:'16.8%', hidden: false, sortable: true },
			{ field: 'uri', title: '链接网址', align: 'left', halign: 'center',width:'10%', hidden: true, sortable: false },
			{ field: 'actProcess', title: '查看流程图', align: 'left', halign: 'center',width:'10%', hidden: true, sortable: false }
	            ]],
	            onBeforeLoad: function (param) {
	                $.getJSON($Url.BuildWorkFlowUrl("/getColumnCookie"), { key: "approvalHistoriaList" }, function (data) {
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
	                    approvalHistoriaList.CreateColumnMenu();
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
	            key: "approvalHistoriaList",
	            value: JSON.stringify(columnArray)
	        });
	    },
	    InitQuery: function () {
	    	 var title = $("#selectTitle").val();
		        var status = $("#status").val();
		        $("#gridTable").datagrid("load", {
		        	bySelectTitle: title,
		        	byStatus: status
		        });
	    },
}

$(function () {
    approvalHistoriaList.InitGrid();
    $("#btnSearch").click(function () {
        approvalHistoriaList.InitQuery();
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
        $EasyUI.NewTab("Detail", $Url.BuildWorkFlowUrl(row.uri)+row.id);
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
		  initAll.GetAuditProcess(url,row.id);
    });
});