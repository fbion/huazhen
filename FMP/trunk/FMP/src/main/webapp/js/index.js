
var Index = {
    GetProductIndex: function (index, productID) {
        var url = $Url.BuildLoginUrl('/getProductIndex.action');
        $.ajax({
                type: "POST",
                url: url,
                dataType: "html",
                data: {
                    productID: productID
                },
                error: function (request) {
                    //alert(request);
                },
                success: function (data) {
                    $(".productIndex .tab_content" + index).html(data);
                    var canvasSalesAmount = $(".productIndex .tab_content" + index +" .CanvasSalesAmount");
                    var h1 = Number(canvasSalesAmount.attr("height")) * Number(canvasSalesAmount.attr("rel1"))/ Number(canvasSalesAmount.attr("rel0"));
                    if (canvasSalesAmount.length>0) {
                    	Index.DrawMyChart(h1,canvasSalesAmount[0]);	
					}
                    

                    var canvasSalesCount = $(".productIndex .tab_content" + index +" .CanvasSalesCount");
                    var h2 = Number(canvasSalesCount.attr("height")) * Number(canvasSalesCount.attr("rel1"))/ Number(canvasSalesCount.attr("rel0"));
                    if (canvasSalesCount.length>0) {
                    Index.DrawMyChart(h2,canvasSalesCount[0]);
                    }
                    $(".productIndex .tab_content" + index + " .tab_title a").click(function(){
                        initAll.tabChange($(this));
                    });
                }
            }
        )

    },
//blow all create by Zorro 2015/4/21
    GetPresidentIndex: function (index, productID) {
        var url = $Url.BuildLoginUrl('/getPresidentIndex.action');
        $.ajax({
                type: "POST",
                url: url,
                dataType: "html",
                data: {
                    productID: productID
                },
                error: function (request) {
                   // alert(request);
                },
                success: function (data) {
                    $(".presidentIndex .tab_content" + index).html(data);
                    var canvasSalesAmount = $(".presidentIndex .tab_content" + index +" .CanvasSalesAmount");
                    var h1 = Number(canvasSalesAmount.attr("height")) * Number(canvasSalesAmount.attr("rel1"))/ Number(canvasSalesAmount.attr("rel0"));
                    if (canvasSalesAmount.length>0) {
                    	 Index.DrawMyChart(h1,canvasSalesAmount[0]);
					}
                   
                    
//                    var canvasSalesCount = $(".presidentIndex .tab_content" + index +" .CanvasSalesCount");
//                    var h2 = Number(canvasSalesCount.attr("height")) * Number(canvasSalesCount.attr("rel1"))/ Number(canvasSalesCount.attr("rel0"));
//                    Index.DrawMyChart(h2,canvasSalesCount[0]);
                    
                    $(".presidentIndex .tab_content" + index + " .tab_title a").click(function(){
                        initAll.tabChange($(this));
                    });
                }
            }
        )

    },
    GetSalesIndex: function (index, productID) {
        var url = $Url.BuildLoginUrl('/getSalesIndex.action');
        $.ajax({
                type: "POST",
                url: url,
                dataType: "html",
                data: {
                    productID: productID
                },
                error: function (request) {
                    //alert(request);
                },
                success: function (data) {
                    $(".salesIndex .tab_content" + index).html(data);
                    var canvasSalesAmount = $(".salesIndex .tab_content" + index +" .CanvasSalesAmount");
                    var h1 = Number(canvasSalesAmount.attr("height")) * Number(canvasSalesAmount.attr("rel1"))/ Number(canvasSalesAmount.attr("rel0"));
                    if (canvasSalesAmount.length>0) {
                    	 Index.DrawMyChart(h1,canvasSalesAmount[0]);
					}
                   

//                    var canvasSalesCount = $(".salesIndex .tab_content" + index +" .CanvasSalesCount");
//                    var h2 = Number(canvasSalesCount.attr("height")) * Number(canvasSalesCount.attr("rel1"))/ Number(canvasSalesCount.attr("rel0"));
//                    Index.DrawMyChart(h2,canvasSalesCount[0]);
                    
                    $(".salesIndex .tab_content" + index + " .tab_title a").click(function(){
                        initAll.tabChange($(this));
                    });
                }
            }
        )

    },
    GetSalesDirectorIndex: function (index, productID) {
        var url = $Url.BuildLoginUrl('/getSalesDirectorIndex.action');
        $.ajax({
                type: "POST",
                url: url,
                dataType: "html",
                data: {
                    productID: productID
                },
                error: function (request) {
                    //alert(request);
                },
                success: function (data) {
                    $(".salesDirectorIndex .tab_content" + index).html(data);
                    var canvasSalesAmount = $(".salesDirectorIndex .tab_content" + index +" .CanvasSalesAmount");
                    var h1 = Number(canvasSalesAmount.attr("height")) * Number(canvasSalesAmount.attr("rel1"))/ Number(canvasSalesAmount.attr("rel0"));
                    if (canvasSalesAmount.length>0) {
                    	Index.DrawMyChart(h1,canvasSalesAmount[0]);
					}
                    $(".salesDirectorIndex .tab_content" + index + " .tab_title a").click(function(){
                        initAll.tabChange($(this));
                    });
                }
            }
        )

    },
   GetNeedRealeaseTaskIndex:function(){
    	var url = $Url.BuildLoginUrl('/getNeedReleaseTaskIndex.action');
    	$.ajax({
            type: "POST",
            url: url,
            dataType: "html",
            error: function (request) {
                //alert(request);
            },
            success: function (data) {
            	$(".needReleaseTaskIndex").html(data);
            	}
        	}
    	);
    },
    GetActivityIndex:function(){
    	var url = $Url.BuildLoginUrl('/getActivityIndex.action');
    	$.ajax({
            type: "POST",
            url: url,
            dataType: "html",
            error: function (request) {
                //alert(request);
            },
            success: function (data) {
            	$(".activityIndex").html(data);
            	}
        	}
    	);
    },
    DrawMyChart: function (h,canvas) {
        if (!!document.createElement('canvas').getContext) { //check that the canvas
        	if ($(".presidentIndex").length>0||$(".salesIndex").length>0||$(".salesDirectorIndex").length>0) {
            //var canvas = document.getElementById('myCanvas');
		            var ctx = canvas.getContext('2d');
		            ctx.fillStyle = '#FFF';
		            ctx.fillRect(0, 0, 36, Number($(canvas).attr("height")) - h);
        	}
        }
    }
}

$(function () {
	//productIndex
    if ($(".productIndex").length > 0) {
        var curProduct = $(".productIndex .tab_title a.active");
        Index.GetProductIndex(curProduct.attr("rel0"), curProduct.attr("rel1"));

        curProduct.siblings().on("click", function () {
            if ($String.Trim($(".productIndex .tab_content" + $(this).attr("rel0")).html()) == "")
                Index.GetProductIndex($(this).attr("rel0"), $(this).attr("rel1"));

        });
    }
    //create by Zorro 2015/4/21
    //presidentIndex
    if ($(".presidentIndex").length > 0) {
        var curProduct = $(".presidentIndex .tab_title a.active");
        Index.GetPresidentIndex(curProduct.attr("rel0"), curProduct.attr("rel1"));

        curProduct.siblings().on("click", function () {
            if ($String.Trim($(".presidentIndex .tab_content" + $(this).attr("rel0")).html()) == "")
                Index.GetPresidentIndex($(this).attr("rel0"), $(this).attr("rel1"));

        });
    }
    //salesIndex
    if ($(".salesIndex").length > 0) {
        var curProduct = $(".salesIndex .tab_title a.active");
        Index.GetSalesIndex(curProduct.attr("rel0"), curProduct.attr("rel1"));

        curProduct.siblings().on("click", function () {
            if ($String.Trim($(".salesIndex .tab_content" + $(this).attr("rel0")).html()) == "")
                Index.GetSalesIndex($(this).attr("rel0"), $(this).attr("rel1"));

        });
    }
    //salesDirectorIndex
    if ($(".salesDirectorIndex").length > 0) {
        var curProduct = $(".salesDirectorIndex .tab_title a.active");
        Index.GetSalesDirectorIndex(curProduct.attr("rel0"), curProduct.attr("rel1"));

        curProduct.siblings().on("click", function () {
            if ($String.Trim($(".salesDirectorIndex .tab_content" + $(this).attr("rel0")).html()) == "")
                Index.GetSalesDirectorIndex($(this).attr("rel0"), $(this).attr("rel1"));

        });
    }
    //needReleaseIndex
    if ($(".needReleaseTaskIndex").length > 0) {
        Index.GetNeedRealeaseTaskIndex();
   }
    //activityIndex
    if ($(".activityIndex").length > 0) {
		$("#content_center").css("height","930px");
        Index.GetActivityIndex();
   }
  
})