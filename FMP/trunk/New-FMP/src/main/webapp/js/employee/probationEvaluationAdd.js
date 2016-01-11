var ManagePage = {
	Resize: function () {
        $("#content_center").css("min-height", "1500px");
    },
    EnableInput: function () {
        $.each($(".data"), function (index, content) {
            var id = $(this).attr("id");
            if (ElementVar[id] == undefined) {
                $(this).removeAttr("disabled");
            }
            if (ElementVar[id] == TagPermissionType.edit) {
                $(this).removeAttr("disabled");
            }
            if (PageVar.ID == 0 && ElementVar[id] == TagPermissionType.none){
                $(this).parent().remove();
            }
        });
    },
    DisableInput: function () {
        $(".data").attr("disabled", "disabled");
    },
    ShowEditButton: function (currStatus) {
    	var activitID=ManagePage.GetUrlActivitNo();
    	if(!$String.IsNullOrEmpty(activitID)){
    		if ($("#edit").length > 0) {
                $("#edit").show();
                $("#submitExamine").hide();
                $("#submit").hide();
            }
//            if ($("#submit").length > 0)
//                $("#submit").hide();
    	}else{
    		 if ($("#edit").length > 0) {
    	            $("#edit").show();
    	            $("#submitExamine").show();
    	        }
    	        if ($("#submit").length > 0)
    	            $("#submit").hide();
    	}
    },
    HideEditButton: function () {
    	var activitID=ManagePage.GetUrlActivitNo();
    	if(!$String.IsNullOrEmpty(activitID)){
    		if ($("#edit").length > 0) {
                $("#edit").hide();
                $("#submitExamine").hide();
                $("#examine").hide();
            }
            if ($("#submit").length > 0)
                $("#submit").show();
    	}else{
    		if ($("#edit").length > 0) {
                $("#edit").hide();
                $("#submitExamine").hide();
            }
            if ($("#submit").length > 0)
                $("#submit").show();
    	}
    },
    GetInfo: function (id) {
        var url = $Url.BuildEmployeeUrl("/employee/probationEvaluation/ajaxGetProbationEvaluation");
        $.ajax({
            type: "post",
            url: url,
            dataType: "html",
            timeout: 30000,
            data: { id: id },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
            	$("#probationEvaluationContent").html(data);
            	BindEnumList.BindAll();
            	ProbationEvaluationContent.SetContent();
                if($("#errCode").html()=="0000"){
                	ManagePage.ShowEditButton();
                	ManagePage.DisableInput();
                }else{
                	ManagePage.EnableInput();
                    ManagePage.HideEditButton();
                	$("input[id=score1]").val("");
          		    $("input[id=score2]").val("");
          		    $("input[id=score3]").val("");
          		    $("input[id=scale]").val("");
                }
                if ($("#edit").length > 0) {
                    $("#edit").click(function () {
                        ManagePage.EnableInput();
                        ManagePage.HideEditButton();

                    });
                }
                
                ManagePage.GetAuditComment(ManagePage.GetUrlActivitNo(),$("#empName").val());
                ManagePage.GetWindow(ManagePage.GetUrlActivitNo());
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
    GetAuditComment: function (activitiNo,empName) {
    	var url = $Url.BuildWorkFlowUrl("/workFlow/processing/ajaxAuditComment");
        $.ajax({
                type: "POST",
                url: url,
                dataType: "html",
                data: {
                	"activitiNo":activitiNo
                },
                error: function (request) {
                    alert(request);
                },
                success: function (data) {
                	if(empName!=null&&empName!=""&&data.indexOf(empName)>-1){
//                		$("#examine").hide();
                	}
                	var trStr ="";
                	//if(data.indexOf("HR")>0)
                		trStr ='<tr id="textId"><td width="672" height="30" valign="center" colspan="5" >转正意见</td></tr>';
                    $("#aduitComment").append(trStr);
                    $("#aduitComment").append(data);
                    $("#check1").hide();
                    for(var i=1;i<5;i++){
                    	if($("#checkTime"+i).length>0){
                    		$("#checkTime"+i).val($("#checkTime"+i).val());
                    	}
                    }
					/*$('#textId').parent().next().next().find('textarea').each(function(){
                    	$(this).css('height','35px');
                    });
                    $('#textId').parent().next().next().next().find('textarea').each(function(){
                    	$(this).css('height','35px');
                    });
                    $('#textId').parent().next().next().next().next().find('textarea').each(function(){
                    	$(this).css('height','35px');
                    });
					$('#textId').parent().next().next().next().next().next().find('textarea').each(function(){
                    	$(this).css('height','35px');
                    });*/
					$('#textId').parent().siblings().find("textarea").each(function(){
                        $(this).css('height','35px');
                    });
                }
            })
    },
    StartAudit:function(obj,url,activitiNo){
    	var uri=window.location.href;
		var sendData={
				per:obj.val(),
				id: PageVar.ID,
				activitiNo:activitiNo,
				comment:$("#taskCommet").val(),
				uri:uri,
				epId:PageVar.ID
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
				//alert(request);
			},
			success: function (data, textStatus) {
				if ($String.IsNullOrEmpty(activitiNo)) {
					alert("提交成功");
					window.location.href = $Url.BuildEmployeeUrl("/employee/probationEvaluation/edit?id=" + PageVar.ID+"&activitiNo=" + data.activitiNo);
				}else{
					alert("审批成功");
//					$("#examine").hide();
					window.location.href = $Url.BuildEmployeeUrl("/employee/probationEvaluation/edit?id=" + PageVar.ID+"&activitiNo=" + activitiNo);
				}
//				$("#taskCommet").val("");
//				$('#w1').window('close');
//				window.location.reload();
			},
			complete: function (XMLHttpRequest, textStatus) {
			}
		});
    },
    GetWindow:function(activitiNo){
    	if ($String.IsNullOrEmpty(activitiNo)) {
//			$("#submitExamine").click(function () {
//				var url = $Url.BuildWorkFlowUrl('/workFlow/processing/ajaxStartProbationEvaluationProcess.action');
//				ManagePage.StartAudit($("#submit1"), url, activitiNo);
//			});
		} else {
			$("#examine").click(function () {
				$('#w1').window('open');
			});
			$(".examine").click(function(){
				var url = $Url.BuildWorkFlowUrl("/workFlow/auditTask/ajaxAddExamineForProbationEvaluation.action");
				ManagePage.StartAudit($(this), url, activitiNo);
			});
		}
    },
    GetUrlActivitNo:function(){
    	var urlTemp = location.search;
        var theRequest = new Object();
        var strs="";
        if (urlTemp.indexOf("?") != -1) {
           var str = urlTemp.substr(1);
           if(str.indexOf("activitiNo=") != -1){
        	   strs = str.split("activitiNo=")[1];
           }
        }
        return strs;
    }
}

var BindEnumList={
	BindAll:function(){
		BindEnumList.BindCompany();
		BindEnumList.BindDept();
		BindEnumList.BindPosition();
		BindEnumList.BindEmp();
	},
	BindCompany:function(){
		EnumList.GetEnumListToSelect($("#companyNo"), "empCompanylist1", $Url.BuildEmployeeUrl("/common/enumList.action"));
	},
	BindDept:function(){
		EnumList.GetEnumListToSelect($("#deptNo"),"dept1", $Url.BuildEmployeeUrl("/common/enumList.action"));
	},
	BindPosition:function(){
		EnumList.GetEnumListToSelect($("#positionNo"),"positionListAll1",$Url.BuildEmployeeUrl("/common/enumList.action"));
	},
	BindEmp:function(){
		EnumList.GetEnumListToSelect($("#empNo"),"empListForEmp1",$Url.BuildEmployeeUrl("/common/enumList.action"));
	}
}

$(function () {
	ManagePage.Resize();
	ManagePage.GetInfo(PageVar.ID);
	
    $("#back").click(function () {
        $EasyUI.Close();
    });
    $("#workSummary").click(function(){
        var empNo = $("#empNo").val();
        WorkSummary.GetWorkSummaryByEmpNo(empNo);

    });
    $('.trackBtn').on('click',function(){
    	  var url = $Url.BuildWorkFlowUrl("/workFlow/processing/ajaxAuditProcess");
    	  var activitiNo = ManagePage.GetUrlActivitNo();
    	  initAll.GetAuditProcess(url,activitiNo);
	  });
    if(ElementVar.print=="none"){
  	  $('#print').css("display","none");
    }else{
  	  $('#print').css("display","inline");
  	  
  	  $('#print').on('click',function(){
  		$("#totalScore1").attr("value",$("#totalScore1").val());
  		$("#totalScore2").attr("value",$("#totalScore2").val());
  		$("#totalScore3").attr("value",$("#totalScore3").val());
  		$("#totalScore").attr("value",$("#totalScore").val());
  		$("#companyNo option[value="+$("#companyNo").val()+"]").attr("selected","selected");
  		$("#deptNo option[value="+$("#deptNo").val()+"]").attr("selected","selected");
  		$("#positionNo option[value="+$("#positionNo").val()+"]").attr("selected","selected");
  		$("#empNo option[value="+$("#empNo").val()+"]").attr("selected","selected");
  		  
  		  $("#btn").css("display","none");
  		  $(".trackBtn").css("display","none");
  		
  		$("#probationEvaluationContent").css("margin-left","-10px");
  		
  		  bdhtml=window.document.body.innerHTML;//获取当前页的html代码
  			sprnstr="<!--startprint"+1+"-->";//设置打印开始区域
  			eprnstr="<!--endprint"+1+"-->";//设置打印结束区域
  			prnhtml=bdhtml.substring(bdhtml.indexOf(sprnstr)+18); //从开始代码向后取html

  			prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));//从结束代码向前取html
  			window.document.body.innerHTML=prnhtml;
  			window.print();
  			window.document.body.innerHTML=bdhtml;
  			window.location.reload();
  		 $("#probationEvaluationContent").css("margin-left","0px");
  	  });
    }
})
var WorkSummary = {
    GetWorkSummaryByEmpNo: function (empNo) {
        var id = 0;
        var url = $Url.BuildEmployeeUrl("/employee/probationWorkSummary/ajaxGetWorkSummaryByEmpNo");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: { empNo: empNo },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if(data.info==null){
                    alert("该员工暂时未填写工作总结，请您及时提醒");
                }else{
                    $EasyUI.NewTab("New",$Url.BuildEmployeeUrl( "/employee/probationWorkSummary/edit?id="+data.info.id+"&activitiNo="+data.info.activitiNo));

                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    }

}
var ProbationEvaluationContent = {
	SetContent: function(){
		if($("#hcompanyNo").val()!="0"&&$("#hcompanyNo").val()!=null){
			$("#companyNo").val($("#hcompanyNo").val());
			$("#deptNo").val($("#hdeptNo").val());
			$("#positionNo").val($("#hpositionNo").val());
			$("#empNo").val($("#hempNo").val());
		}else{
            $("#companyNo").val($("#addCompanyNo").val());
			$("#deptNo").val($("#addDeptNo").val());
            $("#empNo").val(PageVar.UserNo);
            $("#positionNo").val(PageVar.PositionNo);
			//ProbationEvaluationContent.SetAddSelect();
			$("#startTime").val($("#addStartTime").val());
			
		}
		
		$("#startTime").click(function () {
			WdatePicker({dateFmt: 'yyyy-MM-dd'});
		});
		
		$("#probationDate").click(function () {
			WdatePicker({dateFmt: 'yyyy-MM-dd'});
		});
		
		var scoreList1 = new Array();
		var s1=$("tr[id=part1]").find("input[id=score1]");
		for(var i=0;i<s1.length;i++){
			scoreList1.push(s1[i].value);
		}
	  
		var scoreList2 = new Array();
		var s2=$("tr[id=part2]").find("input[id=score2]");
	 	for(var i=0;i<s2.length;i++){
	 		scoreList2.push(s2[i].value);
	 	}	
	  
	 	ProbationEvaluationContent.CountScore1(s1,$("#totalScore1"));
	 	ProbationEvaluationContent.CountScore1(s2,$("#totalScore2"));
	 	s1.off().change(function(){ProbationEvaluationContent.CountScore1(s1,$("#totalScore1"));});
	 	s2.off().change(function(){ProbationEvaluationContent.CountScore1(s2,$("#totalScore2"));});
	 	
	 	var scoreList3 = new Array();
		var s3=$("tr[id=part3]").find("input[id=score3]");
	 	for(var i=0;i<s3.length;i++){
	 		scoreList3.push(s3[i].value);
	 	}
	 	var scaleList = new Array();
	 	var s4=$("tr[id=part3]").find("input[id=scale]");//比例
	 	for(var i=0;i<s4.length;i++){
	 		scaleList.push(s4[i].value);
	 	}
	 	ProbationEvaluationContent.CountScore2(s3,s4,$("#totalScore3"));
	 	s3.off().change(function(){ProbationEvaluationContent.CountScore2(s3,s4,$("#totalScore3"));});
	 	s4.off().change(function(){ProbationEvaluationContent.CountScore2(s3,s4,$("#totalScore3"));});
	 	
	 	
	 	//ProbationEvaluationContent.SetSelect();
	 	
	 	var probationEvaluationAdd = $("#probationEvaluationAdd").Validform({
	        tiptype: function (msg, o, cssctl) {
	            /*var objtip = o.obj.siblings(".Validform_checktip");
	            cssctl(objtip, o.type);
	            objtip.text(msg);*/
	        	$("#errMsg").html("");
	        	$("#errMsg").html(msg);
	        },
	        datatype:{
	            "verifySelect": function (gets, obj, curform, datatype) {
	            	if (gets == "0" || gets == "")
	            		return false;
	            	else
	            		return true;
	            },
	            "verifyScore":function (gets, obj, curform, datatype){
	            	if(gets == ""){
	            		return false;
	            	}
	            	if(isNaN(gets)){
	            		return false;
	            	}
	            	if(parseFloat(gets)<0){
	            		return false;
	            	}
	            	if(parseFloat(gets)>5){
	            		return false;
	            	}
	            	return true;
	            }
	        },
	        callback: function (form) {
	            if (!($("#submit").attr("process") === undefined)) {
	                return false;
	            }
	            var url = $Url.BuildEmployeeUrl("/employee/probationEvaluation/ajaxEditProbationEvaluation");
	            var oper = "add";
	            if (Number(PageVar.ID) != 0)
	                oper = "edit";

	            var scoreList1 = new Array();
	    		var s1=$("tr[id=part1]").find("input[id=score1]");
	    		for(var i=0;i<s1.length;i++){
	    			scoreList1.push(s1[i].value);
	    		}
	    		var scoreList2 = new Array();
	    		var s2=$("tr[id=part2]").find("input[id=score2]");
	    	 	for(var i=0;i<s2.length;i++){
	    	 		scoreList2.push(s2[i].value);
	    	 	}
	    	 	var scoreList3 = new Array();
	    		var s3=$("tr[id=part3]").find("input[id=score3]");
	    	 	for(var i=0;i<s3.length;i++){
	    	 		scoreList3.push(s3[i].value);
	    	 	}
	    	 	var scaleList = new Array();
	    	 	var s4=$("tr[id=part3]").find("input[id=scale]");//比例
	    	 	for(var i=0;i<s4.length;i++){
	    	 		scaleList.push(s4[i].value);
	    	 	}
	    	 	var contentList = new Array();
	    	 	var s5=$("tr[id=part3]").find("input[id=content]");//工作业绩
	    	 	for(var i=0;i<s5.length;i++){
	    	 		contentList.push(s5[i].value);
	    	 	}
	    	 	var strs=ManagePage.GetUrlActivitNo();
	            var info = {
	                id: PageVar.ID,
					empNo: $("#empNo").val(),
					companyNo: $("#companyNo").val(),
					deptNo: $("#deptNo").val(),
					positionNo: $("#positionNo").val(),
					startTime: $("#startTime").val().toTimetamp(),
					probationDate: $("#probationDate").val(),
					totalScore: $("#totalScore").val(),
					activitiNo: $("#activitiNo").val()
	            }
	            $.ajax({
	                type: "post",
	                url: url,
	                dataType: "json",
	                timeout: 30000,
	                data: {
	                    oper: oper,
	                    activitiID:strs,
	                    info: JSON.stringify(info),
	                    scoreList1:JSON.stringify(scoreList1),
	                    scoreList2:JSON.stringify(scoreList2),
	                    scoreList3:JSON.stringify(scoreList3),
	                    scaleList:JSON.stringify(scaleList),
	                    contentList:JSON.stringify(contentList)
	                },
	                beforeSend: function () {
	                    $("#submit").attr("process", "processing");
	                },
	                error: function (XMLHttpRequest, textStatus, errorThrown) {
	                    alert(errorThrown);
	                },
	                success: function (data, textStatus) {
	                    if (data.errCode == "0000") {
	                    	window.location.href = $Url.BuildEmployeeUrl("/employee/probationEvaluation/edit?id=" + data.errDesc+"&activitiNo="+strs);
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
	    probationEvaluationAdd.addRule([
			/*{				
			    ele:"#companyNo",
			    datatype:"verifySelect",
			    //ignore:"ignore",
			    nullmsg:"",
			    errormsg:"请选择公司",
			    sucmsg:" "
			},
			{				
			    ele:"#deptNo",
			    datatype:"verifySelect",
			    //ignore:"ignore",
			    nullmsg:"",
			    errormsg:"请选择部门",
			    sucmsg:" "
			},*/
			{
				ele: "#probationDate",
				datatype: "*",
	
				nullmsg: "请填写转正日期",
				errormsg: "",
				sucmsg: " "
			},
			{				
			    ele:"#positionNo",
			    datatype:"verifySelect",
			    //ignore:"ignore",
			    nullmsg:"",
			    errormsg:"请选择职位",
			    sucmsg:" "
			},
			{				
			    ele:"#empNo",
			    datatype:"verifySelect",
			    //ignore:"ignore",
			    nullmsg:"",
			    errormsg:"请选择员工姓名",
			    sucmsg:" "
			},
			{
				ele:"#startTime",
				dataType:"/^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))$/",
				//dataType:"/^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))\\s+([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$/",
				nullmsg:"请填写入职时间",
				errormsg:"请填写正确的入职时间",
				sucmsg:" "
			},
			{				
			    ele:".score1",
			    datatype:"verifyScore",
			    //ignore:"ignore",
			    nullmsg:"请填写分数",
			    errormsg:"请填写正确的分数",
			    sucmsg:" "
			},
			{				
			    ele:".score2",
			    datatype:"verifyScore",
			    //ignore:"ignore",
			    nullmsg:"请填写分数",
			    errormsg:"请填写正确的分数",
			    sucmsg:" "
			},
			{				
			    ele:".score3",
			    datatype:"/^0|[1]0|[1-9]{1}|[1-9]{1,1}?\.[1-9]{1,1}|0\.[1-9]{1,1}?$/",
			    ignore:"ignore",
			    nullmsg:"请填写分数",
			    errormsg:"请填写正确的分数",
			    sucmsg:" "
			},
			{				
			    ele:".scale",
			    datatype:"/^0|[1]0|[1-9]{1}|[1-9]{1,1}?\.[1-9]{1,1}|0\.[1-9]{1,1}?$/",
			    ignore:"ignore",
			    nullmsg:"请填写比例",
			    errormsg:"请填写正确的比例",
			    sucmsg:" "
			}
	    ]);
	    var contentList = new Array();
	 	var s5=$("tr[id=part3]").find("input[id=content]");//工作业绩
	    s5.off().change(function(){
	    	for(var i=0;i<s5.length;i++){
	    		if(s5[i].value.trim()!=null&&s5[i].value.trim()!=""){
	    			probationEvaluationAdd.addRule([
						{				
						    ele:".scale",
						    datatype:"/^0|[1]0|[1-9]{1}|[1-9]{1,1}?\.[1-9]{1,1}|0\.[1-9]{1,1}?$/",
						    //ignore:"ignore",
						    nullmsg:"请填写比例",
						    errormsg:"请填写正确的比例",
						    sucmsg:" "
						},
						{				
						    ele:".score3",
						    datatype:"/^0|[1]0|[1-9]{1}|[1-9]{1,1}?\.[1-9]{1,1}|0\.[1-9]{1,1}?$/",
						    //ignore:"ignore",
						    nullmsg:"请填写分数",
						    errormsg:"请填写正确的分数",
						    sucmsg:" "
						}                         
                    ]);
	    		}
    	 	}
	    });
	},
	CountScore1:function(s,t){
		  var total = 0;
		  for(var i=0;i<s.length;i++){
			  var va = s[i].value;
			  if(va==null||va==""||isNaN(va)){
				  va = "0";
			  }
			  total=parseFloat(total)+parseFloat(va);
		  }
		  t.val(Math.round(total/s.length*100)/100);
		  ProbationEvaluationContent.CountTatalScore();
	},
	CountScore2:function(s,ss,t){
		  var total = 0;
		  for(var i=0;i<s.length;i++){
			  var va = s[i].value;
			  var vs = ss[i].value;//比例
			  if(va==null||va==""||isNaN(va)){
				  va = "0";
			  }
			  if(vs==null||vs==""||isNaN(vs)){
				  vs = "0";
			  }
			  total=parseFloat(total)+parseFloat(va)*parseFloat(vs)/100;
		  }
		  t.val(Math.round(total*100)/100);
		  ProbationEvaluationContent.CountTatalScore();
	},
	CountTatalScore:function(){
		var totalScore1 = $("#totalScore1").val();
		var totalScore2 = $("#totalScore2").val();
		var totalScore3 = $("#totalScore3").val();
		if(totalScore1==null||totalScore1==""){
			totalScore1 = "0";
		}
		if(totalScore2==null||totalScore2==""){
			totalScore2 = "0";
		}
		if(totalScore3==null||totalScore3==""){
			totalScore3 = "0";
		}
		$("#totalScore").val("");
		$("#totalScore").val(Math.round((parseFloat(totalScore1)*0.2+parseFloat(totalScore2)*0.2+parseFloat(totalScore3)*0.6)*100)/100);
	},
	SetSelect:function(){
	    $("#companyNo").off().change(function(){
			if($("#companyNo").val()==1){
				$("#deptNo").empty();
				EnumList.GetEnumListToSelect($("#deptNo"), "deptListByCompany1", $Url.BuildEmployeeUrl("/common/enumList.action"),$("#companyNo").val());

                if($("#deptNo").val()==0){
                    return;
                }
                $("#positionNo").empty();
                EnumList.GetEnumListToSelect($("#positionNo"), "positionListBydeptType2", $Url.BuildEmployeeUrl("/common/enumList.action"),$("#deptNo").val());
                if($("#positionNo").val()==0){
                    return;
                }
                $("#empNo").empty();
                EnumList.GetEnumListToSelect($("#empNo"), "empListByPositionNo1", $Url.BuildEmployeeUrl("/common/enumList.action"),$("#positionNo").val());

            }else if($("#companyNo").val()==0){
				$("#deptNo").empty();
				$("#positionNo").empty();
				$("#empNo").empty();
				BindEnumList.BindDept();
				BindEnumList.BindPosition();
				BindEnumList.BindEmp();
			}
		});
		
		
		$("#deptNo").off().change(function(){
			if($("#deptNo").val()!=0){
				$("#positionNo").empty();
				EnumList.GetEnumListToSelect($("#positionNo"), "positionListBydeptType2", $Url.BuildEmployeeUrl("/common/enumList.action"),$("#deptNo").val());
				if($("#positionNo").val()!=0){
					$("#empNo").empty();
					EnumList.GetEnumListToSelect($("#empNo"), "empListByPositionNo1", $Url.BuildEmployeeUrl("/common/enumList.action"),$("#positionNo").val());
				}
			}else{
				$("#positionNo").empty();
				$("#empNo").empty();
				BindEnumList.BindPosition();
				BindEnumList.BindEmp();
			}
	    });
	
		$("#positionNo").off().change(function(){
			if($("#positionNo").val()!=0){
				$("#empNo").empty();
				EnumList.GetEnumListToSelect($("#empNo"), "empListByPositionNo1", $Url.BuildEmployeeUrl("/common/enumList.action"),$("#positionNo").val());
			}else{
				$("#empNo").empty();
				BindEnumList.BindEmp();
			}
	    });
	},
	SetAddSelect:function(){
		$("#positionNo").empty();
		EnumList.GetEnumListToSelect($("#positionNo"), "positionListBydeptType2", $Url.BuildEmployeeUrl("/common/enumList.action"),$("#deptNo").val());
		$("#empNo").empty();
		EnumList.GetEnumListToSelect($("#empNo"), "empListByPositionNo1", $Url.BuildEmployeeUrl("/common/enumList.action"),$("#positionNo").val());
		$("#empNo").off().change(function(){
			if($("#empNo").val()!="0"){
				var url = $Url.BuildEmployeeUrl("/employee/probationEvaluation/ajaxGetEmployeeStartTime");
				$.ajax({
	                type: "post",
	                url: url,
	                dataType: "json",
	                timeout: 30000,
	                data: {
	                	"empNo":$("#empNo").val()
	                },
	                beforeSend: function () {
	                },
	                error: function (XMLHttpRequest, textStatus, errorThrown) {
	                    alert(errorThrown);
	                },
	                success: function (data, textStatus) {
	                	$("#startTime").val(data.startTime);
	                },
	                complete: function (XMLHttpRequest, textStatus) {
	                }
	            });
			}else{
				$("#startTime").val("");
			}
		});
	}
}