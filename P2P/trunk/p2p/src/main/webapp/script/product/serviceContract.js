$(function () {
	if($("#pageAlias").val()=="serviceContract"){
		$("#serviceContract").attr("class", "active");
	}
	$("#header").find("a").removeClass("active");
	$("#security").attr("class", "active");
 });