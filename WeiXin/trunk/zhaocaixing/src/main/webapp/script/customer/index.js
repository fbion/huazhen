$(function() {
	var pageIndex = 1;
	var tzStatus = $("#tzStatus").val().trim();
	$("#status2").click(function(){
		window.location.href=$Url.BuildWWWUrl("/index");
    });
	$("#status3").click(function(){
	    document.getElementById('count').innerHTML=parseInt(1);
		$("#status3").addClass("investcurrent");
		$("#status2").removeClass();
		$("#tzStatus").val("40");
		$("#p2p_product_list").empty();
		Index.GetIndex(pageIndex);
    });
	var tzStatus = $("#tzStatus").val().trim();
	Index.GetIndex(pageIndex);
	Index.OnClickElem();
	
});

var Index = {
	GetIndex : function(pageIndex,tzStatus) {
		var url = $Url.BuildWWWUrl("/index/ajaxIndex");
		$.ajax({
			type : "POST",
			url : url,
			//async:true,
			dataType : "html",
			data : {
				"count" : pageIndex,
				"tzStatus" : $("#tzStatus").val()
			},
			error : function(request) {
				// alert(request);
			},
			success : function(data) {
				$("#p2p_product_list").append(data);
				Index.LoadCss(parseInt(document.getElementById("count").innerHTML));
				
			}
		})

	},

	OnClickElem:function(){
		$("#loadMore").click(function(){
			Index.GetIndex(document.getElementById("count").innerHTML);
			
		});
	},
	LoadCss:function(css){
	}
}


function moreClick(){
	document.getElementById('count').innerHTML=parseInt(document.getElementById('count').innerHTML)+1;
	var count = document.getElementById("count").innerHTML;
	
}

