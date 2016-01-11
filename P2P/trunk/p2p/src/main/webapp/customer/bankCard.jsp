<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="m" uri="/hz-tags"%>

<m:ContentPage materPageId="layoutCustomerCenter">
	<m:Content contentPlaceHolderId="customerCenterNavigation">银行卡管理</m:Content>
	<m:Content contentPlaceHolderId="customerCenter">
        <div class="accountCont">
            <h3> <em class="pl5">银行卡管理</em> <i></i></h3>
        <s:if test="#request.bankStatus==1">
            <div class="bankManage mt30">
            	<h3>
                	<img src="${bankLogoPath}" width="112" height="34" />
                    <a href="javascript:void(0)" id="cancel_bind">解绑</a>
                </h3>
                <div class="bankInfo">
                    <dl class="mt15">
                        <dt>银行卡号：</dt> <dd>${paymentCustomerBank.bankCard}</dd>
                    </dl>
                    <dl>
                        <dt>账户名称：</dt> <dd>${paymentCustomerBank.customerName}</dd>
                    </dl>
                    <dl>
                        <dt>银行名称：</dt> <dd>${paymentCustomerBank.bankName}</dd>
                    </dl>
              </div>
            </div>
        <br>    
          <h5 style="color: green">  温馨提示：     </h5><br>
     <h6> 快捷解绑，需要提供以下信息发送到hzjk@bestinvestor.com.cn：</h6>
      &nbsp;&nbsp;1.  绑定的手机号<br>
      &nbsp;&nbsp;2.  开户人+开户银行+卡号<br>
      &nbsp;&nbsp;3.【附件】清晰地手持身份证半身照+银行卡正面照片<br><br>
	<div style="color: red">
	<h6 style="color: red">注意：</h6>
	&nbsp;&nbsp;1.  银行卡丢失，请提供银行书面丢失证明的原件照片；<br>
	   &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;银行卡被银行收回，请提供银行相关书面凭证的原件照片。 <br>
	&nbsp;&nbsp;2.  居民身份证丢失，请提供手持临时身份证半身照+用户户口本的首页和本人页的原件照片；<br>
	   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 如果用户情况紧急，请提供手持社保卡半身照+用户户口本的首页和本人页的原件照片。<br>
    </div>        
        </s:if><s:else>
            <div class="recharge">
				<p class="bankCard f16 mt40">您尚未绑定银行卡，请<a href="javascript:void(0)" class="bank_bindBtn btnStyle ml10" id="bind">前往绑定</a></p>
            </div>
        </s:else>
        <input type="hidden" id="pageAlias" value="${pageAlias}">
        </div>
	</m:Content>
</m:ContentPage>
