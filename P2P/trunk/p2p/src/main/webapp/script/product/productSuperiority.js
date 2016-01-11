$(function () {
	if($("#pageAlias").val()=="productSuperiority"){
		$("#productSuperiority").attr("class", "active");
	}
	$("#header").find("a").removeClass("active");
	$("#security").attr("class", "active");
 });