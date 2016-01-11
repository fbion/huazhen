<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
    	<input type="hidden" value="${oper}" id="oper" />
<div class="main pb30">
	<h3 class="wrapp">
    	<a href="${homeUrl}">首页</a>><a href="${p2pProductListUrl}">财富产品</a>>产品详情
    </h3>
    <div class="productCont wrapp">
    <input type="text" id="p2pProductNo" hidden="hidden" value="${p2pProduct.id}">
    	<h2 id="p2pProductName">${p2pProduct.name}</h2>
        <div class="productConts">
        	<!--<b class="mt30"></b>-->
            <img src="${p2pProduct.logoPath}" width="190" height="190" />
            <div class="sales_productInfo mt30">
            	<s:if test="p2pProduct.type!=6"><!-- 汽车金融方案 -->
	                <ul>
	                	<li>
	                    	<span>预期年化收益率</span>
	                        <p>
	                        	<em class="project_profitRate">${p2pProduct.income}%
	                            <%-- <s:if test="#request.p2pProduct.floatingIncome!=0">
	                             +${p2pProduct.floatingIncome}%
	                            </s:if> --%>
	                            <s:if test="#request.p2pProduct.type==5">
									<s:if test="#request.p2pProduct.floatingIncome!=0"> ± <b><s:property value="#request.p2pProduct.floatingIncome" />%</b></s:if>
								</s:if><s:else>
									<s:if test="#request.p2pProduct.floatingIncome!=0"> - <b><s:property value="#request.p2pProduct.maxIncome" />%</b></s:if>
								</s:else>
	                            </em>
	                        </p>
	                    </li>
	                    <li>
	                    	<span>融资金额</span>
	                        <p>
	                        	<em class="project_total">${p2pProduct.switchTotalAmout}</em>元
	                        </p>
	                    </li>
	                    <li>
	                    	<span>项目期限</span>
	                        <p>
	                        	<em class="project_times">${p2pProduct.duration}天</em>
	                        </p>
	                    </li>
	                </ul>
	                <div class="publishInfo">
	                	<p>
	                    	<!--<b><b>
	                        <b class="ml20"></b>-->
	                        <a href="${securityAssuranceUrl}"><i class="safe1"></i></a>
	                    	<a href="${noviceAreaUrl}?scroll=1"><i class="safe2 ml5"></i></a>
	                    </p>
	                    <ul class="pl20">
	                    	<li>
	                        	<span>发布日期：</span><em>${startTime}</em>
	                        </li>
	                        <li>
	                        	<span>发布机构：</span><em>${financier}</em>
	                        </li>
	                        <li>
	                        	<span>付息方式：</span><em>${payType}，到期还本</em>
	                        </li>
	                    </ul>
	                </div>
            	</s:if>
            	<s:else>
            		<ul class="sales_productInfo1">
	                	<li>
	                    	<span>指导价</span>
	                        <p>
	                        	<em class="guided_price">185,000</em>元
	                        </p>
	                    </li>
	                    <li>
	                        <span>优惠价</span>
	                        <p>
	                        	<em class="project_profitRate">157,250</em>元
	                        </p>
	                    </li>
	                    <li>
	                        <span class="fw">首付</span>
	                        <p>
	                        	<em class="project_profitRate fw">47,175</em>元
	                        </p>
	                    </li>
	                    <li>
	                    	<span class="fw">投资额</span>
	                        <p>
	                        	<em class="project_total fw">450,000</em>元
	                        </p>
	                    </li>
	                    <li>
	                    	<span>理财期限</span>
	                        <p>
	                        	<em class="project_times">3</em>年
	                        </p>
	                    </li>
	                </ul>
	                <div class="publishInfo">
	                	<!--<p>-->
	                    	<!--<b><b>
	                        <b class="ml20"></b>-->
	                        <!--<i class="safe1"></i>
	                    	<i class="safe2 ml5"></i>
	                    </p>-->
	                    <ul class="pl20">
	                    	<li>
	                        	<span>发布日期：</span><em>2015-06-24</em>
	                        </li>
	                        <li>
	                        	<span>合作商家：</span><em>北京翼翔行汽车销售服务有限公司</em>
	                        </li>
	                        <li>
	                        	<span>还款方式：</span><em>按年付息，到期还款</em>
	                        </li>
	                    </ul>
	                </div>
            	</s:else>
            </div>
            
            <div class="investInfo">
            	<i></i>
            	
                <div class="investInfos">
                	<s:if test="p2pProduct.type==5"><!--现房宝 -->
	                    <dl>
	                        <dt>可投金额：</dt>
	                        <dd><em>${p2pProduct.switchRemainAmout}</em>元</dd>
	                    </dl>
	                    <dl>
	                        <dt>投资进度：</dt>
	                        <dd class="item_proBars">
	                        	<p class="progressBars">
	                            	<em></em>
	                                <span style="width:${p2pProduct.progress}%"></span>
	                            </p>
	                            <strong>${p2pProduct.progress}%</strong>
	                        </dd>
	                    </dl>
                	</s:if><s:else>
                		<dl>
	                        <dt>融资金额：</dt>
	                        <dd><em>${p2pProduct.switchTotalAmout}</em>元</dd>
	                    </dl>
	                    <dl>
	                        <dt>可投金额：</dt>
	                        <dd><em>${p2pProduct.switchRemainAmout}</em>元</dd>
	                    </dl>
                	</s:else>
                    <s:if test="p2pProduct.status==20 || p2pProduct.status==30">
	                    <form class="validform" id="transactionForm">
	                    <p class="pt5">
	                        <input type="text" id="amount" class=".amount" placeholder="预投入金额"/>元<em>（${p2pProduct.minMoney}元起投）</em>
	                    </p>
	                    <dl>
	                    <span id="msg" style="color:red;"></span>
	                    </dl>
	                    <p class="mt40">
	                        <s:if test="showInvestBtn==1 and p2pProduct.type==5"><a href="javascript:void(0)" class="btnStyle investBtn  my_invest">立即投资</a></s:if>
	                        <s:if test="showReservatBtn==1"><a href="javascript:void(0)" id="submit" class="btnStyle RreservatBtn my_appointment">预约</a></s:if>
	                    </p>
	                    </form>
                    </s:if>
                    <s:else>状态：
	                    <s:if test="p2pProduct.status==40">还款中</s:if>
	                    <s:if test="p2pProduct.status==50">已结束</s:if>
	                    <s:if test="p2pProduct.status==55">交易取消</s:if>
	                    <s:if test="p2pProduct.status==60">暂停交易</s:if>
                    </s:else>
                </div>
            </div>
            
        </div>
	    <div class="productShare">
           <a href="javascript:ProductDetails.copyUrl();" class="mr20">
               <i class="icon1"></i>复制链接
           </a>
           <div class="shareBtn">
           	<i class="icon2"></i>分享
               <div class="shareBox">
                   <div class="point"></div>
                   <h3 class="borderBott">分享到</h3>
                   <ul>
                       <li>
                           <i class="icon1"></i>
                           <a href="javascript:;" id="qqZUrl" target="_blank">QQ空间</a>
                       </li>
                       <li>
                           <i class="icon2"></i>
                           <a href="javascript:;" id="tengxunUrl" target="_blank">腾讯微博</a>
                       </li>
                       <li>
                           <i class="icon3"></i>
                           <a href="javascript:;" id="renrenUrl" target="_blank">人人网</a>
                       </li>
                       <!-- <li>
                           <i class="icon4"></i>
                           <a href="javascript:;" id="wangyiUrl" target="_blank">网易微博</a>
                       </li> -->
                       <li>
                           <i class="icon5"></i>
                           <a href="javascript:;" id="qqFUrl" target="_blank">QQ好友</a>
                       </li>
                       <li>
                           <i class="icon6"></i>
                           <a href="javascript:;" id="feixinUrl" target="_blank">飞信</a>
                       </li>
                   </ul>
                   <ul>
                       <li>
                           <i class="icon7"></i>
                           <a href="javascript:;" id="xinlangUrl" target="_blank">新浪微博</a>
                       </li>
                       <li>
                           <i class="icon8"></i>
                           <a href="javascript:;" id="weixin">微信</a>
                       </li>
                       <!-- <li>
                           <i class="icon9"></i>
                           <a href="javascript:;" id="yixinUrl" target="_blank">易信</a>
                       </li> -->
                       <!-- <li>
                           <i class="icon10"></i>
                           <a href="javascript:;" id="shouhuUrl" target="_blank">搜狐微博</a>
                       </li> -->
                       <li>
                           <i class="icon11"></i>
                           <a href="javascript:;" id="kaixinUrl" target="_blank">开心网</a>
                       </li>
                       <li>
                           <i class="icon12"></i>
                           <a href="javascript:;" id="doubanUrl" target="_blank">豆瓣网</a>
                       </li>
                   </ul>
               </div>
           </div>
           
       </div>
       <div id="weixinlayer" style="display:none;">
	    	<div id="weixinlayer_cont">
                <span>分享到微信朋友圈</span>
				<a href="javascript:void(0)" id="winxinClose">×</a>
                <img id="weixinUrl" width="220" height="220">
                <p style="">打开微信，点击底部的“发现”，<br />使用“扫一扫”即可将网页分享至朋友圈。</p>
	    	</div>
            <!--<div style="padding:0 10px 15px;">
                <img id="weixinUrl" width="220" height="220"></img>
                <p style="width:220px; -text-align:center; padding:0 10px 0 5px;">打开微信，点击底部的“发现”，<br />使用“扫一扫”即可将网页分享至朋友圈。</p>
	    	</div>-->
	    	<!--<div style="color: #666;font-size: 12px;line-height: 22px;text-align:left;">
                <br>
               	 打开微信，点击底部的“发现”，
				<br>
				使用“扫一扫”即可将网页分享至朋友圈。
	    	</div>-->
	   </div>
    </div>
    
    <div class="productList wrapp">
    	<div class="proListTit tab_title">
        	<a href="javascript:void(0)" class="active borderNone">产品详情</a>
            <a href="javascript:void(0)" id="investRecord">投资记录</a>
            <a href="javascript:void(0)">风险保障</a>
        </div>
        <div class="proListCont">
        	<div class="proListConts tabContent" style="display:block;">
            	<!-- <p></p> -->
            	${p2pProduct.description}
                <!-- <dl class="mt40">
                	<dt>收益方式：</dt>
                    <dd>每月等额本息</dd>
                </dl>
                <dl>
                	<dt>项目简介：</dt>
                    <dd>"稳赢-安e"服务是华镇金控面向个人借款和个人出借推出的个人借贷中介服务...<a href="#">理解更多></a></dd>
                </dl> -->
                <!--<div class="expectProfit">
                	<p class="mt20"><strong>预期收益*</strong>（以下数据根据"投资金额2万元，期限36个月"计算,您的收益以实际到帐为准）</p>
                    <ul>
                    	<li>
                        	共<em>36</em>期
                        </li>
                        <li>
                        	总计
                        </li>
                        <li class="mr20">
                        	应收本息：<span>22,695.28元</span>
                        </li>
                        <li class="mr20"
                        	应收本金：<span>20,000.00元</span>
                        </li>
                        <li class="mr20">
                        	应收利息：<span>2,695.28元</span>
                        </li>
                    </ul>
                </div>-->
                
            </div>
            <div class="proListRecord tabContent">
            	<div id="investRecordList"></div>
            </div>
            <div class="riskSafe tabContent">
            	<dl>
                	<dt class="riskPic1"></dt>
                    <dd>
                    	<h5>投资金额</h5>
                        <p>最小投资金额为<span>${p2pProduct.minMoney}</span>元人民币。</p>
                    </dd>
                </dl>
                <dl>
                	<dt class="riskPic2"></dt>
                    <dd>
                    	<h5>投资提前退出说明</h5>
                        <p>投资人同意《个人借款及担保协议》并通过交易密码验证，将被视为投资成功，不能主动撤销投资。注：现已推出债权转让功能，投资人可通过该功能将已持有的投资转让。</p>
                    </dd>
                </dl>
                <dl>
                	<dt class="riskPic3"></dt>
                    <dd>
                    	<h5>可投资时间</h5>
                        <p>本网站提供7*24小时服务，投资人可在任何时间对网站上的借款请求发起投资。</p>
                    </dd>
                </dl>
                <dl>
                	<dt class="riskPic4"></dt>
                    <dd>
                    	<h5>信息安全性</h5>
                        <p>本网站将履行客户隐私保密协议，只在法院、公安等机构提出调取要求及其他法律法规规定的条件下，且按照规范流程完成申请和审批后，才会将信息提供给指定部门。</p>
                    </dd>
                </dl>
            </div>
        </div>
    </div>
</div>

<s:if test="showLogin">
	<!-- 除首页外_未登录时弹出登录框 -->
	<div class="noLogin_layer" >
		<div class="layerTitle">
	    	<h2>会员登录</h2>
	        <a href="javascript:;" class="close"></a>
	    </div>
	    <div class="layerContent mt20">
	    	<div id="noLoginPic">
	    	<div class="p2pBanner1" value="1"></div>
	    	</div>
	    	<input type="hidden" value="${pageAlias}" class="pageAlias" />
	    	<!-- <img src="img/noLoginPic.png" width="342" height="345" /> -->
	    	<div class="logReg wrapp">
	            <div class="tab_title selectStyle" style="right:66px;">
                    <a href="javascript:;" class="active">立即预约</a>
                    <a href="javascript:;" >登录后预约</a>
                </div>
                <div>
                    <div class="tabContent" style="display:block;">
                    	<div class="wrapp_layer" style="top:30px; width:222px;">
                            <!--<h4>欢迎来到华镇社区金融</h4>-->
                            <form id="callSubscribeForm" class="validform">
                                <!--<p><span>姓名：</span><input id="callName" type="text" /></p>
                                <p class="mt10"><span>手机号：</span><input id="callPhone" type="text" /></p>
                                <p> <span id="msgdemo"></span></p>
                                <input type="submit" value="提交" class="btnStyle submit1 ml100 mt10" />-->
                                <dl id="userInfo" class="userInfo">
                                        <dt></dt>
                                        <dd>
                                            <input id="callName" type="text" tabindex="1" placeholder="请输入姓名" value="" name="callName" class="Validform_error">
                                        </dd>
                                    </dl>
                                    <dl id="phoneNum" class="phoneNum">
                                        <dt></dt>
                                        <dd>
                                            <input id="callPhone" type="text" name="callPhone" tabindex="2" placeholder="请输入手机号" >
                                        </dd>
                                    </dl>
                                    <span id="msgdemo" class="verifyMsg Validform_checktip" style="display: none;margin-left: 0px; margin-bottom: 0px;"></span>
                                    <input type="submit" value="提交" class="btnStyle submit1 -ml100 -mt10" />
                            	<dl>
                            	</dl>
                            </form>
                    	</div>
                    </div>
                    <div class="tabContent" > 
                        <div class="wrapp_layer" style="top:60px; width:222px;">
                            <!--<h4>欢迎来到华镇社区金融</h4>-->
                            <s:include value="../common/loginArea.jsp" />
                        </div>
                    </div>
                </div>
	        </div>
	    </div>
	</div>
	<div class="layer" >
		<div class="layerTitle">
	        <a href="javascript:;" class="close mt30"></a>
	    </div>
	    <div class="layerContent">
	    	<dl>
	        	<dt></dt>
	            <dd>
	            	<h4>您已经预约成功！</h4>
	                <p>理财顾问会尽快的给您拨打电话进行服务，请您耐心等待并保持电话畅通。</p>
	            </dd>
	        </dl>
	    </div>
	</div>
	
</s:if>
<s:else>
	<!-- 预约弹窗 -->
	<div class="layer">
		<div class="layerTitle">
	        <a href="javascript:;" class="close mt30"></a>
	    </div>
	    <div class="layerContent">
	    	<dl>
	        	<dt></dt>
	            <dd>
	            	<h4>您已经预约成功！</h4>
	                <p>理财顾问会尽快的给您拨打电话进行服务，请您耐心等待并保持电话畅通。</p>
	                <a href="${reservationUrl}" class="mt30">查看我的预约>></a>
	            </dd>
	        </dl>
	    </div>
	</div>
	
	
	<!-- 未完善个人信息出现弹窗 -->
	<s:if test="paymentAccountInformation.authenticationEmail==0 || paymentAccountInformation.authenticationName==0 || paymentAccountInformation.accountPwd==0">
		<div class="unfinished_layer">
			<div class="layerTitle">
		    	<h2>您的安全认证没有完善</h2>
		        <a href="javascript:;" class="close"></a>
		    </div>
		    <div class="layerContent">
		    	<ul>
		    		<s:if test="paymentAccountInformation.authenticationEmail==0">
			        	<li>
			            	<i class="icon1"></i>
			                <strong>邮箱认证</strong>
			                <span>获取账户资金变动通知和投资讯息</span>
			                <a href="${paymentAccountSecurityUrl}" class="btnStyle">立即认证</a>
			            </li>
		            </s:if>
		            <s:if test="paymentAccountInformation.authenticationName==0">
			            <li class="mt5">
			            	<i class="icon2"></i>
			                <strong>实名认证</strong>
			                <span>保障账户安全，确人投资身份</span>
			                <a href="${paymentAccountSecurityUrl}" class="btnStyle">立即认证</a>
			            </li>
		            </s:if>
		            <s:if test="paymentAccountInformation.accountPwd==0">
			            <li class="mt5">
			            	<i class="icon3"></i>
			                <strong>交易密码</strong>
			                <span>您充值或提现的默认银行卡，确人投资身份</span>
			                <a href="${paymentAccountSecurityUrl}" class="btnStyle">去设置</a>
			            </li>
		            </s:if>
		        </ul>
		    </div>
		</div>
	</s:if>
</s:else>
<input type="hidden" id="pageAlias" value="${pageAlias}"/>
</body>
</html>
</m:Content>
</m:ContentPage>