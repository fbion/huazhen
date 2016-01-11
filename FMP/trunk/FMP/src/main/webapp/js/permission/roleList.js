var ManagePage = {
    
    InitGrid: function () {
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildPermissionUrl('/permission/role/ajaxListRole.action'),
            editurl: $Url.BuildPermissionUrl("/permission/role/ajaxEditRole.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","编号","角色名称","角色描述","修改备注"],
            colModel: [

				{
					name: "act", index: "act", width: 60, align: "center", sortable: false
				},
				{
					name: "id", index: "id", width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
				},
				{
					name: "name", index: "name", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "comment", index: "comment", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "editComment", index: "editComment", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
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
                var space = "|";
                var ids = $("#gridTable").jqGrid('getCol', 'id', true);
                var names = $("#gridTable").jqGrid('getCol', 'name', true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;
                    var name =names[i].value; 

                    var detail = "";
                    var edit = "";
                    var assign = "";

                    detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id + "')\">查看</a>";
                    edit = "<a class=\"blue\" href=\"javascript:ManagePage.GetEdit('" + id + "')\">编辑</a>";
                    assign = " <a class=\"blue\" href=\"javascript:ManagePage.Assignprivileges('" + id +","+name+"')\">分配权限</a>";
                    $("#gridTable").jqGrid("setRowData", id, { act: detail + space + edit  + space + assign});
                }
            }
        });
    },
    InitQuery: function () {
        $("#btnSearch").click(function () {
            var name = $("#txtName").val();

            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: { "name": name },
                page: 1
            }).trigger("reloadGrid");
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
            }, afterShowForm: function () {
            }, afterSubmit: function (response, postdata) {
                var res = jQuery.parseJSON(response.responseText), ok = res.errDesc == "";

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
                var res = jQuery.parseJSON(response.responseText), ok = res.errDesc == "";

                return [ok, ok ? '' : res.errDesc];
            }
        });
    },
   GetElementInfo:function(eleNo,roleNo){
	   var url = $Url.BuildPermissionUrl("permission/roleElement/ajaxGetInfoRoleElement.action");
		//alert(url);
		$.ajax({
			type:"post",
			url:url,
			dataType: "json",
           timeout: 30000,
           data: {
        	   eleNo: eleNo,
        	   roleNo:roleNo
        	   },
           beforeSend: function () {
           },
           error: function (XMLHttpRequest, textStatus, errorThrown) {
               alert(errorThrown);
           },
           success:function(data,textStatus){
        	   if(data.roleElementInfo.level>3){
        		   if(data.roleElementInfo.edit==1)
            		   $("#edit").prop("checked",true);
            	   if(data.roleElementInfo.query==1)
            		   $("#query").prop("checked",true);
            	   $("#newItem1").hide();
            	   $("#del1").hide();
        	   }else{
        		   $("#del1").show();
        		   $("#newItem1").show();
        		   if(data.roleElementInfo.newItem==1)
        			   $("#newItem").prop("checked",true);
        		   if(data.roleElementInfo.edit==1)
        			   $("#edit").prop("checked",true);
        		   if(data.roleElementInfo.query==1)
        			   $("#query").prop("checked",true);
        		   if(data.roleElementInfo.newItem==1)
        			   $("#del").prop("del",true);
        	   }
        	   
        	   
        	   $("#roleElementId").val(data.roleElementInfo.id);
           }
		});
   },
    MakeTree:function(roleNo){
		 tree=new dhtmlXTreeObject($("#treeboxbox_tree").get(0),"100%","100%",0);
		    var xml = $Url.BuildImgUrl("/dhtmlxTree/imgs/csh_bluefolders/");
			tree.setImagePath(xml);
			var url=$Url.BuildPermissionUrl("permission/roleElement/getRoleElementTree.action");
			tree.loadXML(url);
			tree.setOnClickHandler(function(){
				$("#roleElement").show();
				$("input:checked").removeAttr("checked");
				//alert(tree.getSelectedItemId());
				ManagePage.GetElementInfo(tree.getSelectedItemId(),roleNo);
			});
	},
    Assignprivileges: function (index) {
    	//alert(index);
    	$("#treeboxbox_tree").empty();
        $('#w').window('open');
        var strs= new Array(); //定义一数组 
        strs=index.split(","); //字符分割 
        $("#userName").html(strs[1]);
        
        ManagePage.MakeTree(strs[0]); 
        ManagePage.FlushMenuTree(strs[0]);
     },
     FlushMenuTree: function(roleNo){
    	 $("#flushMenuTree").click(function(){
    		 $.ajax({
 	            type: "post",
 	            url: $Url.BuildPermissionUrl("permission/roleElement/ajaxFlushMenuTree"),
 	            dataType: "json",
 	            timeout: 30000,
 	            data: {
 	               roleNo:roleNo
 	            },
 	            beforeSend: function () {
 	                $("#submit").attr("process", "processing");
 	            },
 	            error: function (XMLHttpRequest, textStatus, errorThrown) {
 	                alert(errorThrown);
 	            },
 	            success: function (data, textStatus) {
 	               $("#flush_msg").html("刷新成功！");
 	            },
 	            complete: function (XMLHttpRequest, textStatus) {
 	                $("#submit").removeAttr("process");
 	            }
 	        });
    		 
    	 });
     }
     
}


$(function () {
    $("#btnAdd").click(function () { ManagePage.GetAdd(); });
    $("#roleElement").hide();
    ManagePage.InitGrid();
    ManagePage.InitQuery();
    var RoleElementEdit = $("#roleElementFrom").Validform({//验证控件
	    tiptype: 2,
	    callback: function (form) {
	    	//alert($('input:checkbox:checked').length);
	    	if (!($("#submit").attr("process") === undefined)) {
	            return false;
	        }
	        var url = $Url.BuildPermissionUrl("permission/roleElement/ajaxEditRoleElement");
	        	
	        	var  oper = "edit";
	        	if($('#newItem').is(':checked')){
	        		var newItem= 1;
	        	}else{
	        		var newItem=0;
	        	}
	        	if($('#edit').is(':checked')){
	        		var edit= 1;
	        	}else{
	        		var edit=0;
	        	}
	        	if($('#query').is(':checked')){
	        		var query= 1;
	        	}else{
	        		var query=0;
	        	}
	        	if($('#del').is(':checked')){
	        		var del= 1;
	        	}else{
	        		var del=0;
	        	}
	        	/*alert($('input:checkbox[name=newItem]:checked').val());
	        	 alert($('#newItem').is(':checked'));*/
	        $.ajax({
	            type: "post",
	            url: url,
	            dataType: "json",
	            timeout: 30000,
	            data: {
	                oper: oper,
	                id: $("#roleElementId").val(),
	                newItem: newItem,
	                edit:edit,
	                query:query,
	                del:del
	            },
	            beforeSend: function () {
	            	
	                $("#submit").attr("process", "processing");
	            },
	            error: function (XMLHttpRequest, textStatus, errorThrown) {
	                alert(errorThrown);
	            },
	            success: function (data, textStatus) {
	               alert("权限分配成功！");
	            },
	            complete: function (XMLHttpRequest, textStatus) {
	                $("#submit").removeAttr("process");
	            }
	        });
	        return false;
	    }
	});
});