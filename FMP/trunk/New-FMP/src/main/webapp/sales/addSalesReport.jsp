<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="wrappSearchContent">
            <div class="kindlyreminder">
                温馨提示：默认展示昨日新增数据
            </div>
            <div class="folddevelop">
                <input type="button" value="折叠表格" id="collapse" class="btn_style"/>
                <input type="button" value="展开表格" id="expand" class="btn_style"/><br />
            </div>
            <div class="tabfilter">
            筛选
                时间区间 <input id="startTime" />--<input id="endTime" />
                打款状态 <select id="status"></select>
                <input type="button" id="btnSearch" class="btn_style" value="查询" />
            </div>
        </div>
        <%--<h5 class="tc mt30 f18 pb30">--%>
            <%--<span id="time"></span>--%>
            <%--新增打款报表--%>
        <%--</h5>--%>
        <table id="tt" style="width:708px" ></table>
        ${pageVar}
    </m:Content>
</m:ContentPage>