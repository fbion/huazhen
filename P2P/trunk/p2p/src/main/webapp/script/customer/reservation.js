var Reservation = {
    GetReservation: function (pageIndex) {
        var url=$Url.BuildWWWUrl("customer/reservation/reservation");
        $.ajax({
                type: "POST",
                url: url,
                dataType: "html",
                data: {
                	"pageIndex":pageIndex+1,
                	p2pProductNo:$("#reservationProductSelect").val(),
                	visitTime: $("#reservationTime").val().trim()
                },
                error: function (request) {
                    //alert(request);
                },
                success: function (data) {
                    $("#reservation").html(data);
                    if($("#totalCount").html()!=0){
                    	
                    	$("#pagination").pagination($("#totalCount").html(), {//总记录条数
                    		callback: Reservation.GetReservation,//每次点击分页按钮的时候 执行该操作
                    		items_per_page:8,//每页显示多少条记录
                    		current_page:pageIndex,//当前页
                    		link_to:"javascript:void(0)",//不期望链接到某个目的地，只希望执行回调函数
                    		num_display_entries:2,//显示几个页码
                    		next_text:"下一页",//下一页按钮显示的内容
                    		next_show_always:true,//如果没有下一页  仍然显示按钮  但是灰化 
                    		prev_text:"上一页",//上一页按钮显示的内容
                    		prev_show_always:true,//如果没有上一页  不显示按钮 
                    		num_edge_entries:1,//页码多的时候...省略
                    		ellipse_text:"..."
                    	});
                    }
                }
            }
        )

    }
}
$(function () {
   Reservation.GetReservation(0);
   if($("#status").html()==1){
	   $("#status").empty().html("预约中");
   }else{
	   $("#status").empty().html("已受理");
   }
   EnumList.GetEnumListToSelect($("#reservationProductSelect"), "reservationProductSelect", $Url.BuildWWWUrl("/common/enumList.action"));
   /*$("#reservationProductSelect").change(function(){
	   Reservation.GetReservation(0);
   });*/
   laydate.skin('dahong');
   laydate(reservationTime);
   /*$("#reservationTime").bind("input propertychange",function(){
	   Reservation.GetReservation(0);
   });*/
   $("#seach").click(function(){
	   Reservation.GetReservation(0);
   });
	if($("#pageAlias").val()=="myReservation"){
		$("#myReservation").attr("class", "active");
	}
});

var reservationTime = {
	    elem: '#reservationTime',
	    format: 'YYYY-MM-DD',
	    min: '2000-01-01', //设定最小日期为当前日期 laydate.now()
	    max: '2099-06-16', //最大日期
	    istime: true,
	    istoday: false
};