<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">

        <div class="detail mt20 pb30">
            <div class="wrappSearch mt30">
                <h3></h3>
                <div class="wrappSearchContent">
                    部门：<select id="deptNo"></select>
                    月报表：<input id="monthTime" />
                    <input type="button" value="查询" id="monthButton" class="btn_style mr30"/>
                    周报表：<select id="week_year"></select>年 <select id="week_week"></select>周
                    <input type="button" value="查询" id="weekButton" class="btn_style mr30"/>
                    日报表：<input id="dayTime" />
                    <input type="button" value="查询" id="dayButton" class="btn_style"/>
                </div>
            </div>
            <div class="tab mt30">
                <div class="tab_title">
                    <a href="javascript:;" class="active">概况</a>
                    <a href="javascript:;">详细信息</a>
                </div>
                <ul class="tab_content position">
                </ul>
            </div>
        </div>
        ${pageVar}
    </m:Content>
</m:ContentPage>