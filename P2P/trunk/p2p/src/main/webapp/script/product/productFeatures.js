/*var ManagePage = {
		OnClickElem : function(elem){
		var obj =$("div[name='1']");
			$("div[name='1']").css("display","none");
			$("a[name='2']").removeClass("active");
			$("#" + elem + "").addClass("active");
			$("#" + elem + "Div").css("display", "block");
		}
	};
$(function(){
	var name = $("#name").html();
	ManagePage.OnClickElem(name);
});*/
$(function () {
	if($("#pageAlias").val()=="productFeatures"){
		$("#productFeatures").attr("class", "active");
	}
	$("#header").find("a").removeClass("active");
	$("#security").attr("class", "active");
 });