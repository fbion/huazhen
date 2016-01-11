<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
	<form >
            <div class="sendEmail p5">
            	<h2 class="p5">写邮件</h2>
                <div class="sendEmailContent p30"> 
                    <div class="customerChoose">
                        <h3>客户选择</h3>
                        <ul>
                            <li><span style="font-weight:bold;"><input id="allckecked" type="checkbox" />全选</span><em class="color">此处只显示有邮箱的代理</em></li>
                          	<li>
                          	<s:iterator value="#request.agentBusinessList"  id="item" >
                            <span><input type="checkbox" class="checkAgentBusiness "  email="<s:property value="#item.email"/>"/>
                            <s:property value="#item.name"/>
                           </span>
                            </s:iterator>
                            </li>
                        </ul>
                    </div>
                    <div class="productChoose">
                        <h3>产品选择</h3>
                        <ul>
                            <li>
                                <select id="productType"></select><select class="ml15" id="productNo"></select>
                            </li>
                        </ul>
                    </div>
                    <div class="annexChoose pt15">
                        <h3>附件选择</h3>
                        <input type="checkbox" id="fileschecked" /><span style="font-weight:bold;">全选</span>
                        <ul class="mt10">
                            <li id="getLi1"><strong>单页</strong></li>
                            <li id="getLi2"><strong>推介材料</strong></li>
                            <li id="getLi3"><strong>电子合同</strong></li>
                            <li id="getLi4"><strong>说明书</strong></li>
                            <li id="getLi5"><strong>尽职调查报告</strong></li>
                            <li id="getLi6"><strong>渠道协议模板</strong></li>
                            <li id="getLi7"><strong>成立公告</strong></li>
                            <li id="getLi8"><strong>项目管理报告</strong></li>
                            <li id="getLi9"><strong>产品认购指南</strong></li>
                        </ul>
                    </div>
                    <div class="mailTheme">
                        <dl>
                            <dt>邮件主题</dt>
                            <dd><input type="text" id="emailTheme" /></dd>
                        </dl>
                    </div>
                    <div class="mailContent mt15">
                        <dl>
                            <dt>邮件内容</dt>
                            <dd><textarea id="emailContext" cols="" rows=""></textarea></dd>
                        </dl>
                    </div>
                    <div class="sendBtn mt15">
                    	<em class="color">如已经填写员工管理中员工邮箱，如果有回复邮件会回复到您的邮箱</em>
                    	<input id="sendLetterSubmit" type="button" value="发送" class="btn_style mr30"/><input id="backBtn" type="button" value="返回" class="btn_style"/>
                    </div>
                </div>
            </div>
            </form>
