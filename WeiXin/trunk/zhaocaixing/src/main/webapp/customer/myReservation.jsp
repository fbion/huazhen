<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layoutCustomerCenter">
    <m:Content contentPlaceHolderId="customerCenter">
	<div id="content" class="mt20">
	
		<div id="investRecordList" class="investRecordList">
	    	<table border="0" cellspacing="0" cellpadding="0" width="100%" height="50">
				<tbody>
					<tr>
					<input id="tzStatus" value="" type="hidden"/>
						<td align="center">
							<a href="javascript:void(0)" id="status2" class="investcurrent">我的预约</a>
						</td>
						<td align="center">
							<img src="${productLineUrl}">
						</td>
						<td align="center">
							<a href="javascript:void(0)" id="status3">我的投资</a>
							
						</td>
					</tr>
				</tbody>
			</table>
		</div>
        <div class="reservation pt20 pb20">
            <div id="reservation"></div>
            <p class="mt30"><a class="btn" id="loadMore">查看更多</a></p>
            
         </div>
	</div>
    </m:Content>
</m:ContentPage>