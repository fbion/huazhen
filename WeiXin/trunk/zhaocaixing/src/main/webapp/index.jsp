<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="m" uri="/hz-tags"%>
<m:ContentPage materPageId="layout">
	<m:Content contentPlaceHolderId="center">
		<div id="investRecordList" class="investRecordList">
	    	<table border="0" cellspacing="0" cellpadding="0" width="100%" height="50">
				<tbody>
					<tr>
					<input id="tzStatus" value="" type="hidden"/>
						<td align="center">
							<a href="javascript:void(0)" id="status2" class="investcurrent">投资中</a>
						</td>
						<td align="center">
							<img src="${productLineUrl}">
						</td>
						<td align="center">
							<a href="javascript:void(0)" id="status3">还款中</a>
							
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div id="content">
			<div class="product_list">
					
				<ul id="p2p_product_list">
				</ul>
				<p class="mt10">
              	<input type="submit"  class="btn" id="loadMore" value="查看更多" onclick="javascript:moreClick()">
                <span hidden="hidden" id="count">1</span>
				</p>
			</div>
		</div>
	</m:Content>
</m:ContentPage>