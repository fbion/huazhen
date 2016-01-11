<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="wrappSearch mt30">
            <h3></h3>
            <div class="wrappSearchContent">
                姓名：<input id="employeeSel" type="text" value="" class="w80"/>
                <input type="text" id="byName" style="display: none">
                手机：<input type="text" id="cellphone">
                <input id="btnSearch" type="button" value="查询" class="btn_style"/>
            </div>
        </div>
        <div class="contactMethod mt30">
            <div class="employeeInfo">
            </div>
            <div class="contactInfo ml20">
                <p>
                    <i>
                        <img alt="员工头像" id="emphead" class="emphead" src=""/>
                    </i>
                <table width="54%" align="center" border="1">
                    <tr>
                        <td align="center" colspan="1" width="150" height="30">姓名</td>
                        <td align="center" colspan="3" width="260" id="name" ></td>
                    </tr>
                    <tr>
                        <td align="center" colspan="1" height="30">性别</td>
                        <td align="center" colspan="3" id="sex"></td>
                    </tr>
                    <tr>
                        <td align="center" colspan="1" height="30">部门</td>
                        <td align="center" colspan="3" id="dept"></td>
                    </tr>
                    <tr>
                        <td align="center" colspan="1" height="30">职位</td>
                        <td align="center" colspan="3" id="position"></td>
                    </tr>
                    <tr>
                        <td align="center" colspan="1" height="30">在职状态</td>
                        <td align="center" colspan="3" id="status"></td>
                    </tr>
                </table>
                </p>
                <h5 class="mt10">联系方式</h5>
                <table width="50%" align="center" border="1">
                    <tr>
                        <td align="center" colspan="1" width="200" height="30">手机</td>
                        <td align="center" colspan="2" id="cellphone1"></td>
                    </tr>
                    <tr>
                        <td align="center" colspan="1" height="30">邮箱</td>
                        <td align="center" colspan="2" id="email"></td>
                    </tr>
                    <tr>
                        <td align="center" colspan="1" height="30">固定电话</td>
                        <td align="center" colspan="2" id="telephone"></td>
                    </tr>
                    <tr>
                        <td align="center" colspan="1" height="30">qq</td>
                        <td align="center" colspan="2" id="qq"></td>
                    </tr>
                    <tr>
                        <td align="center" colspan="1" height="30">微信</td>
                        <td align="center" colspan="2" id="weixin"></td>
                    </tr>
                    <tr>
                        <td align="center" colspan="1" height="30">直属上级</td>
                        <td align="center" colspan="2" id="parent"></td>
                    </tr>
                </table>
            </div>
        </div>
    </m:Content>
</m:ContentPage>
