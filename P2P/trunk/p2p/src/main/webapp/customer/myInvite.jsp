 <%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layoutCustomerCenter">
	<m:Content contentPlaceHolderId="customerCenterNavigation">安全设置</m:Content>
    <m:Content contentPlaceHolderId="customerCenter">
	<div class="accountCont">
		<h3><em class="pl15">我的邀请</em><i></i></h3>
        <div class="productShare mt10">
            <!-- <a href="javascript:ProductDetails.copyUrl();" class="mr20 fl"><i class="icon1"></i>复制链接</a> -->
            <div class="shareBtn">
                <i class="icon2"></i>分享
                <div class="shareBox">
                    <div class="point"></div>
                    <h3 class="borderBott">分享到</h3>
                    <ul>
                        <!-- <li><i class="icon1"></i> <a href="javascript:;" id="qqZUrl" target="_blank">QQ空间</a></li> -->
                        <li><i class="icon2"></i> <a href="javascript:;" id="tengxunUrl" target="_blank">腾讯微博</a></li>
                        <li><i class="icon3"></i> <a href="javascript:;" id="renrenUrl" target="_blank">人人网</a></li>
                        <li><i class="icon5"></i> <a href="javascript:;" id="qqFUrl" target="_blank">QQ好友</a></li>
                        <!-- <li><i class="icon6"></i> <a href="javascript:;" id="feixinUrl" target="_blank">飞信</a></li> -->
                    </ul>
                    <ul>
                        <li><i class="icon7"></i> <a href="javascript:;" id="xinlangUrl" target="_blank" >新浪微博</a></li>
                        <li><i class="icon8"></i> <a href="javascript:;" id="weixin">微信</a></li>
                        <!-- <li><i class="icon11"></i> <a href="javascript:;" id="kaixinUrl" target="_blank">开心网</a></li> -->
                        <li><i class="icon12"></i> <a href="javascript:;" id="doubanUrl" target="_blank">豆瓣网</a></li>
                    </ul>
                 </div>  
            </div>
         
            <div id="weixinlayer" style="display:none;">
                <div id="weixinlayer_cont" style="position:absolute;">
                    <span>分享到微信朋友圈</span>
                    <a href="javascript:void(0)" id="winxinClose">×</a>
                    <img id="weixinUrl" width="220" height="220">
                    <p style="">打开微信，点击底部的“发现”，<br />使用“扫一扫”即可将网页分享至朋友圈。</p>
                </div>
            </div>
        </div>
        
        <div class="tradeRecord  mt50">
            <ul class="mt20" id="reservation">
            </ul>
        </div>
        
        <div class="warm ml50">
            <h4 class="ml40 mt15">温馨提示</h4>
            <p class="ml40">1.邀请奖励注意事项。</p>
            <p class="ml40">2.操作过程中如遇到问题，请联系客服：400-0340-668。</p>
            <p class="ml40">3.${activityRule}</p>
        </div>
        
        <input id="tel"  type="hidden" value="${telephone}"/>
        <input type="hidden" id="pageAlias" value="${pageAlias}">   
        <input id="inviterNo"  type="hidden" value="${inviterNo}"/>
        <input id="activityId"  type="hidden" value="${activityId}"/>
	</div>
    </m:Content>
</m:ContentPage>