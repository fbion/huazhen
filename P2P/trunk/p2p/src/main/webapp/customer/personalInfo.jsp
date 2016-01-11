<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layoutCustomerCenter">
	<m:Content contentPlaceHolderId="customerCenterNavigation">个人信息</m:Content>
    <m:Content contentPlaceHolderId="customerCenter">
        <div class="accountCont">
            <h3>
                <em class="pl15">个人信息</em>
                <i></i>
            </h3>
            <div class="personalInfo">
            	<dl>
                	<dt class="ml20"></dt>
                    <dd>
                    	<span>用户名：</span><em>${p2pCustomer.userName}</em>	
                    </dd>
                    <dd>
                    	<span>真实姓名：</span><em>${p2pCustomer.realName}</em>	
                    </dd>
                    <dd>
                    	<span>身份证号：</span>
                    	<s:if test="#request.paymentAccountInformation.authenticationIdcard==1">
                    	<em>${p2pCustomer.cardNumber}</em>	
                    	</s:if><s:else>
                    	<em>${p2pCustomer.cardNumber}（未认证）</em>	
                    	</s:else>
                    </dd>
                    <dd>
                    	<span>手机号码：</span>
                    	<s:if test="#request.paymentAccountInformation.authenticationTel==1">
                    	<em>${p2pCustomer.cellphone}</em>	
                    	</s:if><s:else>
                    	<em>${p2pCustomer.cellphone}（未认证）</em>	
                    	</s:else>
                    </dd>
                    <dd>
                    	<span>注册邮箱：</span>
                    	<s:if test="#request.paymentAccountInformation.authenticationEmail==1">
                    	<em>${p2pCustomer.email}</em>	
                    	</s:if><s:else>
                    	<em>${p2pCustomer.email}（未认证）</em>	
                    	</s:else>
                    </dd>
                    <dd>
                    	<span>银行卡：</span>
                    	<s:if test="#request.paymentCustomerBank==null">
                    	<em>未绑定</em>	
                    	</s:if><s:else>
                    	<em>${paymentCustomerBank.bankCard}</em>	
                    	</s:else>
                    </dd>
                </dl>
            </div>
            <h3>
                <em class="pl15">基本信息</em>
                <input type="button" id="editInfoBut" value="编辑本基信息"  class="btnStyle" />
                <input type="button" id="cancelEditBut" value="取消编辑" class="btnStyle" />
                <i></i>
            </h3>
            <div class="basicInfo" id="p2pCustomerInfo">
            	<dl>
                	<dt class="ml20"></dt>
                    <dd>
                    	<span>性别：</span><em>${sex}</em>	
                    </dd>
                    <dd>
                    	<span>公司名称：</span><em>${loginP2pCustomer.companyName}</em>	
                    </dd>
                    <dd>
                    	<span>公司地址：</span><em>${loginP2pCustomer.companyAddress}</em>	
                    </dd>
                    <dd>
                    	<span>家庭地址：</span><em>${loginP2pCustomer.address}</em>	
                    </dd>
                    <dd>
                    	<span>婚姻状况：</span><em>${marry}</em>	
                    </dd>
                </dl>
            </div>
            
            
            <form id="personalInfoEdit" class=" personalInfoEdit validform" >
	            <div class="basicInfo" id="editP2pCustomerInfo">
	            	<dl>
	                	<dt class="ml20"></dt>
	                    <dd>
	                    	<span>性别：</span>
	                        <select id="sex">
	                        	<option value="1" selected="selected">男性</option>
	                            <option value="2" >女性</option>
	                        </select>
	                    </dd>
	                    <dd>
	                    	<span>公司名称：</span>
	                        <input type="text" id="companyName"/>
	                    </dd>
	                    <dd>
	                    	<span>公司地址：</span>
	                        <input type="text" id="companyAddress" />
	                    </dd>
	                    <dd>
	                    	<span>家庭地址：</span>
	                        <input type="text" id="address"/>
	                    </dd>
	                    <dd>
	                    	<span>婚姻状况：</span>
	                        <select id="marry" >
	                        	<option value="1">未婚</option>
	                            <option value="2">已婚</option>
	                        </select>	
	                    </dd>
	                    <dd>
	                    	<span></span>
	                        <input  type="submit" value="保存" class="saveBtn btnStyle mt20" />	
	                    </dd>
	                </dl>
	            </div>
	         </form>
            <h3>
                <em class="pl15">我的理财师</em>
                <i></i>
            </h3>
            <s:if test="#request.p2pCustomer.empNo==0">
            <div class="basicInfo">
            	您还没有指定理财师
            </div>
            </s:if><s:else>
            <div class="basicInfo">
            	<dl>
                	<dt class="ml20">
                	<img src="${employee.portraitPath}" width="150" height="200" />
                	</dt>
                    <dd>
                    	<span>姓名：</span><em>${employee.name}</em>
                    </dd>
					<dd>
                    	<span>性别：</span><em>${employee.sexStr}</em>
                    </dd> 
                    <dd>
                    	<span>门店名称：</span><em>${department.name}</em>
                    </dd>                   
                </dl>
            </div>
            </s:else>
	         <input type="hidden" id="pageAlias" value="${pageAlias}">
        </div>
    </m:Content>
</m:ContentPage>