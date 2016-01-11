<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="wrappSearch mt30">
            <h3></h3>
               <div class="wrappSearchContent">
			 活动时间：
			 <input type="text" id="byTime" class="data dateYMD"  />
				活动状态：<select id="byStatus">
				<option value="0">全部</option>
				<option value="1">储备中</option>
				<option value="2">已发布</option>
				<option value="3">已开始</option>
				<option value="4">已结束</option>
				<option value="5">已取消</option>
				</select>
				
				<input id="btnSearch" type="button" value="查询" class="btn_style" />
			</div>
        </div>
        <p class="mt50"> 
			<s:if test="showAddButton">
                <input type="button" id="btnAdd" value="新建" class="btn_style"/>
            </s:if></p>
        <div class="pic mt20">
            <table id="gridTable" class="gridTable">
            </table>
            <div id="gridPager" class="gridPager">
            </div>
        </div>
    </m:Content>
</m:ContentPage>
