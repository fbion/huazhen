var Announcement = {
	GetAnnouncement:function(obj){
		var url = $Url.BuildWWWUrl("/baseInfo/announcement/ajaxGetAnnouncementSubjectList");
		$.ajax({
			type: "post",
			url:url,
			dataTpye: "html",
			timeout: 30000,
			data:{
			},
			success:function(data,textStatus){
				obj.html(data);
			}
		});
	}
}


$(function(){
	Announcement.GetAnnouncement($("#announcementSubject"));
});