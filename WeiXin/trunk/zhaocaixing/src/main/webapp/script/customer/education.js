var ManagePage = {
		OnClickElem : function(elem){
		elem.click();
		}
	};
$(function(){
	var name = $("#name").html();
	var elem = $("#"+name+"");
	ManagePage.OnClickElem(elem);
});