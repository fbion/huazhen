<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="m" uri="/hz-tags"%>

<m:ContentPage materPageId="layout">
	<m:Content contentPlaceHolderId="center">
		<div id="scheduler_here" class="dhx_cal_container" style='width:100%; height:50%; min-height:750px;'>
		<div class="dhx_cal_navline">
			<div class="dhx_cal_prev_button">&nbsp;<img src="../../img/arrow_left.png"  alt="向前"/></div>
			<div class="dhx_cal_next_button">&nbsp;<img src="../../img/arrow_right.png" alt="向后" /></div>
			<div class="dhx_cal_today_button"></div>
			<div class="dhx_cal_date"></div>
			<!-- <div class="dhx_cal_tab" name="day_tab" style="right:204px;"></div> -->
			<div class="dhx_cal_tab" name="week_tab" style="right:140px;"></div>
			<!-- <div class="dhx_cal_tab" name="workweek_tab" style="right:280px;"></div>
			<div class="dhx_cal_tab" name="decade_tab" style="right:345px;"></div> -->
			<div class="dhx_cal_tab" name="month_tab" style="right:76px;"></div>
		</div>
		<div class="dhx_cal_header">
		</div>
		<div class="dhx_cal_data">
		</div>		
	</div>
<style>

	html, body{
		margin:0px;
		padding:0px;
		height:100%;
		/*overflow:hidden;*/
	}
	img{
		margin-left:12px;
	}	

</style>
	</m:Content>
</m:ContentPage>
