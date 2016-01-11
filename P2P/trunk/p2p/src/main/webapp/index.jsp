<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="m" uri="/hz-tags"%>
<m:ContentPage materPageId="layout">
	<m:Content contentPlaceHolderId="center">
		<div class="banner">
			<!-- 轮播图 -->
			<div class="banner_slide" id="banner_slide">
				<ul class="p2pBanner1" value="1">
				<!-- <li><a href="http://www.52touzi.com"> 
				<img src="http://upload.hzfh.dev/files/2015/7/28/20150728111734652_pic3.jpg">
				</a></li>
			
				<li><a href="http://www.chineseinvestor.com.cn"> 
				<img src="http://upload.hzfh.dev/files/2015/7/28/20150728111556520_pic2.jpg">
				</a></li>
			
				<li><a href="http://www.baidu.com"> 
				<img src="http://upload.hzfh.dev/files/2015/7/28/20150728111300853_pic1.jpg">
				</a></li> -->
					<!-- <li><a href=""><img src="img/pic1.jpg"></a></li>
					<li><a href=""><img src="img/pic2.jpg"></a></li>
					<li><a href=""><img src="img/pic3.jpg"></a></li> -->
				</ul>
				<div class="banner_btn" id="banner_btn"></div>
			</div>
			<s:if test="showLoginUrl">
				<div class="logReg wrapp">
				<div class="wrapp_layer">
					<div class="tab_title selectStyle mt20 tc">
                        <a href="javascript:;" class="active f16">登录</a>
                        <a href="javascript:;" class="f16">手机登录</a>
                    </div>
                    <div class="mt30 pt15">
                        <div class="tabContent mt20" style="display:block;">
							<s:include value="common/loginArea.jsp" />
                        </div>
                        <div class="tabContent mt20">
                        	<span id="msgdemo" class="verifyMsg" style="display: none"></span>
                        	<form id="loginWithCellphoneForm" class="validform">
                        	<p>
                                <span>手机号：</span>
                                <input id="cellphone" type="text" tabindex="1" placeholder="手机号码" value="" name="cellphone" class="Validform_error">
                            </p>
                            <p class="verCode">
                                <span>图形验证码：</span>
                                <input type="text" name="captcha" tabindex="5" class="captcha input" id="verifyCode2" />
                                <a href="javascript:$VerifyCode.refreshValidator('#imgVerifyCode2','#verifyCode2');"
                                class="mt5">
                                <img width="76" height="28"ref1="${captchaUrl}?type=login" id="imgVerifyCode2" alt="请输入验证码"
                                src="${captchaUrl}?type=login"></a>
                                <a href="javascript:$VerifyCode.refreshValidator('#imgVerifyCode2','#verifyCode2');"
                                class="validator_tips mt10">换一张</a> 
                            </p>
                            <p class="verCode">
                                <span>手机验证码：</span>
                                <input type="text" name="captcha" tabindex="5" class="captcha input" id="smsCaptcha" />
                                <a href="javascript:;" class="btnStyle get_verCode" id="getSmsCaptcha">获取验证码</a>
                            </p>
                            <input type="submit" value="手机登录" class="submit_btn btnStyle ml50">
                            </form>
                        </div>
                    </div>
				</div>
				<div class="wrapp_layerWx1">
					<a href="javascript:;"></a><p></p>
				</div>
				</div>
			</s:if>
		</div>
		
		<!-- 公告 -->
		<!-- <div class="notice">
			<div class="noticeCont wrapp">
				<em class="ml20"></em>
				<ul>
					<li><a href="#">不创业也能当老板</a></li>
					<li><a href="#">不创业也能当老板</a></li>
					<li><a href="#" class="borderNone">秒变金融会员 送5元</a></li>
				</ul>
				<a href="#" class="more">更多公告>></a>
			</div>
		</div> -->
		<div id="announcementSubject"></div>

		<div class="adInfo wrapp">
			<ul>
				<li><span class="adInfo1"></span></li>
				<li><span class="adInfo2"></span></li>
				<li class="borRight"><span class="adInfo3"></span></li>
				<li class="padNone"><span class="adInfo4"></span> <a href="${noviceAreaUrl}?scroll=1"
					class="btnStyle">了解详情<i></i></a></li>
			</ul>
		</div>

		<div class="companyInfo wrapp">
			<ul>
				<li><a href="${aboutCompanyUrl}"> <em class="comInfoPic1"></em>
						<h4>公司实力</h4>
						<h5>实力雄厚&nbsp;资金充足</h5>
				</a></li>
				<li><a href="${helpCenterUrl}"> <em class="comInfoPic2"></em>
						<h4>新手引导</h4>
						<h5>新手上路&nbsp;专业引导</h5>
				</a></li>
				<li><a href="${mediaReportsUrl}"> <em class="comInfoPic3"></em>
						<h4>媒体报道</h4>
						<h5>媒体资讯&nbsp;新闻公告</h5>
				</a></li>
				<li><a href="${productSuperiorityUrl}"> <em class="comInfoPic4"></em>
						<h4>产品优势</h4>
						<h5>债权透明 &nbsp;一一对应</h5>
				</a></li>
			</ul>
		</div>

		<div class="ad mt40 p2pBanner2" value="2">
			<!-- <a href="#"> <img src="img/adBg1.png" width="100%" height="174" />
			</a> -->
		</div>

		<!-- 热门产品 -->
		<div class="hotProduct wrapp">
			<h3>
				<span class="ml20">热门产品</span> <a href="${p2pProductListUrl}" class="red">更多产品<i class="more_products"></i></a>
			</h3>
			<div class="productInfo">
				<p class="p2pBanner7" value="7"></p>
				<ul>
					<s:iterator value="#request.p2pProductList.resultList" id="item" status="listStat" >
						<s:if test="#listStat.last">
							<li>
						</s:if>
						<s:else>
							<li class="borderBott">
						</s:else>
						<div class="sales_product">
							<div class="sales_productInfo">
								<h4>
									<a
										href="${productDetailsUrl}?p2pProductId=<s:property value="#item.id"/>"><s:property
											value="#item.name" /></a>
								</h4>
								<p>
									<span>年化收益率 <em class="red project_profitRate"> <s:property
												value="#item.income" />% 
												<s:if test="#item.type==5">
													<s:if test="#item.floatingIncome!=0"> ± <b><s:property value="#item.floatingIncome" />%</b></s:if>
												</s:if><s:else>
													<s:if test="#item.floatingIncome!=0"> - <b><s:property value="#item.income+#item.floatingIncome" />%</b></s:if>
												</s:else>
									</em>
									</span> <span>可购金额<em class="project_total"><s:property
												value="#item.switchTotalAmout" /></em>元
									</span> <span>项目期限<em class="project_times"><s:property
												value="#item.duration" /></em>天
									</span>
								</p>
							</div>
							<div class="project_progress">
							<s:if test="#item.type==5">
								<span>筹集进度</span>
								<div id="myCanvas<s:property value="#listStat.index"/>" class="myCanvas<s:property value="#listStat.index"/>"  _echarts_instance_="142906337193<s:property value="#listStat.index"/>" 
									style="height:52px; cursor: default; background-color: rgba(0, 0, 0, 0);">
									<s:property value="#item.progress"/>%  
									<div
										style="position: relative; left:30px; overflow: hidden; width: 60px; height:52px;">
										<div width="163" height="44" data-zr-dom-id="bg"></div>
										<canvas width="60" height="44" data-zr-dom-id="2"></canvas>
										<canvas width="60" height="44" data-zr-dom-id="3"></canvas>
										<canvas width="60" height="44" data-zr-dom-id="4"></canvas>
										<canvas width="60" height="44" data-zr-dom-id="6"></canvas>
										<canvas width="60" height="44"
											data-zr-dom-id="_zrender_hover_"></canvas>
									</div>
								</div>
							</s:if>
							</div>
							<a
								href="${productDetailsUrl}?p2pProductId=<s:property value="#item.id"/>"
								class="investBtn btnStyle mt10">查看详情</a>
						</div>
						<s:if test="#item.type==5">
						<script type="text/javascript">
							var progress = $( '#myCanvas<s:property value="#listStat.index" />') .html();
							var data1 = progress.split("%")[0];
							var data = data1.split(".")[0];

							/*-------------顶端lable样式----开始---------*/
							var labelTop = {
								normal : {
									label : {
										show : false,
										position : 'center',
										textStyle : {
											baseline : 'bottom'
										}
									},
									labelLine : {
										show : false
									}
								}
							};

							/*-------------顶端lable样式----结束---------*/
							/*-------------底端lable样式----开始---------*/
							var labelBottom = {
								normal : {
									color : '#ccc',
									label : {
										show : true,
										position : 'center',
										formatter : function(a, b, c) {
											return 100 - c + '%'
										},
										textStyle : {
											baseline : 'middle',
											color : '#000'
										}
									},
									labelLine : {
										show : false
									}
								},
								emphasis : {
									color : 'rgba(0,0,0,0)'
								}
							};
							var radius = [ 26, 20 ];
							var a = 'option<s:property value="#listStat.index"/>';
							a = {
								legend : {
									x : 'center',
									y : 'center',
									data : []
								},
								title : {},
								toolbox : {
									show : true,
									feature : {}
								},
								series : [ {
									type : 'pie',
									center : [ '50%', '50%' ],
									radius : radius,
									data : [ {
										value : data,
										itemStyle : labelTop
									}, {
										value : 100 - data,
										itemStyle : labelBottom
									} ]
								} ]
							};
							//为指定对象绑定插件效果
							echarts.init(document.getElementById('myCanvas<s:property value="#listStat.index"/>')).setOption(a);
							/*-------------圆圈数据绑定----结束---------*/
						</script>
						</s:if>
						</li>
					</s:iterator>
				</ul>
				<input id="needVerifyCode" type="hidden">
			</div>
			<div class="productInfo mt10 none">
				<p class="product2"></p>
				<div class="proFeature">
					<ul>
						<li class="proFeature1"></li>
						<li class="proFeature2"></li>
						<li class="proFeature3"></li>
					</ul>
					<a
						href="${productDetailsUrl}?p2pProductId=<s:property value="#item.id"/>"
						class="btnStyle">查看详情</a>
				</div>
			</div>

		</div>
		<!-- 合作机构 -->
		<div id="link" class="partners wrapp pb30">
			<h3>
		    	<span class="mr20"></span>合作机构<span class="ml20"></span>
		    </h3>
		    <p>
		    	<a href="javascript:;" class="prev leftIcon"></a><a href="javascript:;" class="next rightIcon"></a>
		    </p>
		    <div class="parter-inner">
		        <div class="partner-box" id="partnerSlider">
		            <ul>
		                <li style="width: 1099px;" class="p2pBanner3" value="3">
		                	<%-- <span class="p2pBanner3" value="3">
		                	</span>
		                	<span class="p2pBanner4" value="4">
		                	</span> --%>
		                    <!-- <a href="" target="_blank"><img src="img/link1.png" width="183" height="58"></a>
		                    <a href="" target="_blank"><img src="img/link2.png" width="183" height="58"></a>
		                    <a href="" target="_blank"><img src="img/link3.png" width="183" height="58"></a>
		                    <a href="" target="_blank"><img src="img/link4.png" width="183" height="58"></a>
		                    <a href="" target="_blank"><img src="img/link5.png" width="183" height="58"></a>
		                    <a href="" target="_blank"><img src="img/link6.png" width="183" height="58"></a>
		                    <a href="" target="_blank"><img src="img/link7.png" width="183" height="58"></a>
		                    <a href="" target="_blank"><img src="img/link8.png" width="183" height="58"></a>
		                    <a href="" target="_blank"><img src="img/link9.png" width="183" height="58"></a>
		                    <a href="" target="_blank"><img src="img/link10.png" width="183" height="58"></a>
		                    <a href="" target="_blank"><img src="img/link11.png" width="183" height="58"></a>
		                    <a href="" target="_blank"><img src="img/link12.png" width="183" height="58"></a> -->
		                </li>
		                <li style="width: 1099px;" class="p2pBanner4" value="4">
		               		<%-- <span class="p2pBanner5" value="5">
		                	</span>
		               		<span class="p2pBanner6" value="6">
		                	</span> --%>
		                    <!-- <a href="" target="_blank"><img src="img/link1.png" width="183" height="58"></a>
		                    <a href="" target="_blank"><img src="img/link2.png" width="183" height="58"></a>
		                    <a href="" target="_blank"><img src="img/link3.png" width="183" height="58"></a>
		                    <a href="" target="_blank"><img src="img/link4.png" width="183" height="58"></a>
		                    <a href="" target="_blank"><img src="img/link5.png" width="183" height="58"></a>
		                    <a href="" target="_blank"><img src="img/link6.png" width="183" height="58"></a>
		                    <a href="" target="_blank"><img src="img/link7.png" width="183" height="58"></a>
		                    <a href="" target="_blank"><img src="img/link8.png" width="183" height="58"></a>
		                    <a href="" target="_blank"><img src="img/link9.png" width="183" height="58"></a>
		                    <a href="" target="_blank"><img src="img/link10.png" width="183" height="58"></a>
		                    <a href="" target="_blank"><img src="img/link11.png" width="183" height="58"></a>
		                    <a href="" target="_blank"><img src="img/link12.png" width="183" height="58"></a> -->
		                </li>
		            </ul>
		        </div>
		    </div>
		</div>

		<!-- <div class="scroll" id="scroll" style="display:none;"></div> -->
		<%-- <script>
			diyou.use('fullSlide', function(dy) {
				dy.banner_slide('banner_slide', 'banner_btn');
			});
		</script> --%>
		<%-- <script src="js/echarts-plain.js"></script> --%>
		<input type="hidden" value="${pageAlias}" class="pageAlias" />
	</m:Content>
</m:ContentPage>
