<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="content container border-line">
            <h3>忘记密码<strong></strong></h3>
            <div class="row">
                <div class="col-md-12 mt50 text-center forget_password">
                    <p class="forget_password3"></p>
                </div>
             </div>
             <div class="row pb100 mt100 pt5">
                <div class="col-md-12 pt30 text-center create_password">
                    <p>
                        <strong class="eidtPassword_tip">密码修改成功</strong><br/>请<a href="${loginUrl}">登录</a>
                    </p>
                </div>
             </div>
        </div>  
  </m:Content>
</m:ContentPage>