/**
 * Created by Administrator on 2015/6/16.
 */
var ManagePage ={
    Resize: function () {
        $("#content_center").css('height',$('.datagrid-view').height()+300);
    },
    formatPrice:function(val,row){
        return new Date(val).format("yyyy-MM-dd hh:mm:ss")
    },
    GetPaymentReportList:function(){
        var url = $Url.BuildSalesUrl("/report/paymentReportDeatil/ajaxListPaymentReportByPaymentReportId");
        $.ajax({
            type: "post",
            url: url,
            dataType: "html",
            timeout: 30000,
            data: {
                paymentReportId: $("#paymentReportId").val(),
                showCardNumberAndCellphone: $("#showCardNumberAndCellphone").val()
            },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data) {
                $("#paymentReportDeatilContent").html(data);
            }
        });
    },
    GetPaymentRefundList:function(){
        var url = $Url.BuildSalesUrl("/report/paymentReportDeatil/ajaxListPaymentReportByHonourDate");
        $.ajax({
            type: "post",
            url: url,
            dataType: "html",
            timeout: 30000,
            data: {
                paymentType: $("#type").val(),
                honourDate: $("#honourDate").val(),
                showCardNumberAndCellphone: $("#showCardNumberAndCellphone").val()
            },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data) {
                $("#paymentReportDeatilContent").html(data);
            }
        });
    },
    GetAuditComment: function (activitiNo) {
        var url = $Url.BuildWorkFlowUrl("/workFlow/processing/ajaxAuditComment");
        $.ajax({
            type: "POST",
            url: url,
            dataType: "html",
            data: {
                "activitiNo": activitiNo
            },
            error: function (request) {
                alert(request);
            },
            success: function (data) {
                var trStr ="";
            	//if(data.indexOf("HR")>0)

            		//trStr ='<tr id="textId" class="textId"><td width="672" height="30" valign="center" colspan="5" ><span style="margin-right:30px;">2016年01月01日付息总计:</span><span>10000</span>元</td></tr>';
                $("#aduitComment").append(trStr);

                $("#aduitComment").append(data);
                $("#check1").hide();
                for (var i = 1; i < 5; i++) {
                    if ($("#checkTime" + i).length > 0) {
                        $("#checkTime" + i).val($("#checkTime" + i).val());
                    }
                }
				$("#aduitComment").find("textarea").each(function(){
                    $(this).css({'height':'35px','width':'100%'});
                });
            }
        })
    },
    StartAudit: function (obj, url, activitiNo) {
        var uri = window.location.href;
        var sendData = {
            per: obj.val(),
//            id: PageVar.ID,
            activitiNo: activitiNo,
            comment: $("#taskCommet").val(),
            uri: uri
        };
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            async:false,
            timeout: 30000,
            data: sendData,
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown, request) {
                alert(errorThrown);
                //alert(request);
            },
            success: function (data, textStatus) {
                if ($String.IsNullOrEmpty(activitiNo)) {
                    alert("提交成功");
                    $.ajax({
                        type: "post",
                        url: $Url.BuildSalesUrl("/report/paymentReportDeatil/ajaxAddDetailAndUpdateReport"),
                        dataType: "json",
                        timeout: 30000,
                        data: {
                            honourDate:$("#honourDate").val(),
                            paymentType:$("#type").val(),
                            activitiNo:data.activitiNo
                        },
                        async:false,
                        beforeSend: function () {
                        },
                        error: function (XMLHttpRequest, textStatus, errorThrown, request) {
                            alert(errorThrown);
                        },
                        success: function (data, textStatus) {
                            
                        }
                    });
                    
                    window.close();
                } else {
                    alert("审批成功");
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
    GetWindow: function (activitiNo) {
        if ($String.IsNullOrEmpty(activitiNo)) {
        	$("#examine").hide();
            $("#submitExamine").click(function () {
            	$('#w1').window('close');
                var url = $Url.BuildWorkFlowUrl('/workFlow/processing/ajaxStartRepaymentExaminationProcess.action');
                ManagePage.StartAudit($("#submit1"), url, activitiNo);
            });
        } else {
        	$("#submitExamine").hide();
            $("#examine").click(function () {
                $('#w1').window('open');
            });
            $(".examine").click(function(){
            	 $('#w1').window('close');
                var url = $Url.BuildWorkFlowUrl("/workFlow/auditTask/ajaxAddExamine.action");
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
    },
    GetUrlPaymentReportId:function(){
    	var urlTemp = location.search;
        var theRequest = new Object();
        var strs="";
        if (urlTemp.indexOf("?") != -1) {
           var str = urlTemp.substr(1);
           if(str.indexOf("paymentReportId=") != -1){
        	   strs = str.split("paymentReportId=")[1];
           }
        }
        return strs;
    }
}

$(function () {
    if($("#paymentReportId").val()!=""&&$("#paymentReportId").val()!=null){
        ManagePage.GetPaymentReportList();
    }else{
        ManagePage.GetPaymentRefundList();
    }
    var activitiNo = ManagePage.GetUrlActivitNo();
    var paymentReportId = ManagePage.GetUrlPaymentReportId();
    if(!$String.IsNullOrEmpty(paymentReportId)){
    	$("#submitExamine").hide();
    }
    ManagePage.GetAuditComment(activitiNo);
    ManagePage.GetWindow(activitiNo);
    $('.trackBtn').on('click',function(){
        var url = $Url.BuildWorkFlowUrl("/workFlow/processing/ajaxAuditProcess");
        var activitiNo = ManagePage.GetUrlActivitNo();
        initAll.GetAuditProcess(url,activitiNo);
    });
})
