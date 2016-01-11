<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
      	<input type="hidden" value="${oper}" id="oper" />
        <div class="ad p2pBanner1 cor1" value="1">
			<a href="#">
		    	<img  width="100%" height="220" />
		    </a>
		</div>
		<div class="content wrapp pb30">
			<h3>财富产品<strong class="ml20"></strong></h3>
		    <div class="productSelect">
		        <dl class="productPeriod borderBott1">
		            <dt>产品类型</dt>
		            <dd class="productState0" id="productType">
		                <a href="${productTypeUrl}">全部</a>
		                <s:if test="productTypeDicDataList!=null">
		                	<s:iterator value="productTypeDicDataList" var="productTypeDic">
		                		<s:if test="#productTypeDic.code!=4"><a href="${productTypeUrl}&productType=${productTypeDic.code}" value="${productTypeDic.code}">${productTypeDic.value}</a></s:if>
		                	</s:iterator>
		                </s:if>
		            </dd>
		        </dl>
		        <input type="hidden" id="byProductType" value="${productType}"/>
		        
		        <dl class="productRevenue borderBott1">
		            <dt>产品期限</dt>
		            <dd class="productState1">
		                <a href="${durationUrl}" class="selected" id="state11">全部</a>
		                <a href="${durationUrl}&durationDown=0&durationUp=3"  id="state12">3个月以下</a>
		                <a href="${durationUrl}&durationDown=3&durationUp=6" id="state13">3-6个月</a>
		                <a href="${durationUrl}&durationDown=6&durationUp=12" id="state14">6-12个月</a>
		                <a href="${durationUrl}&durationDown=12&durationUp=1000" id="state15">12个月以上</a>
		            </dd>
		        </dl>
		        <input type="hidden" id="byDuration" value="${durationUp}"/>
		        
		        <dl class="productRevenue">
		            <dt>产品收益</dt>
		            <dd class="productState2">
		                <a href="${incomeUrl}" class="selected" id="state21">全部</a>
		                <a href="${incomeUrl}&incomeDown=0&incomeUp=7" id="state22">8%以下</a>
		                <a href="${incomeUrl}&incomeDown=8&incomeUp=12" id="state23">8%-12%</a>
		                <a href="${incomeUrl}&incomeDown=12&incomeUp=15" id="state24">12-15%</a>
		                <a href="${incomeUrl}&incomeDown=16&incomeUp=1000" id="state25">15%以上</a>
		            </dd>
		        </dl>
		        <input type="hidden" id="byIncome" value="${incomeUp}"/>
		        
		    </div>
		    <p class="investStateTit mt20 pl20">
		        <a href="${statusUrl}" class="current" id="status1">全部</a>
		        <a href="${statusUrl}&byStatus=20" id="status2">投资中</a>
		        <a href="${statusUrl}&byStatus=40" id="status3">还款中</a>
		        <a href="${statusUrl}&byStatus=50" id="status4">已结束</a>
		    </p>
		    <input type="hidden" id="byStatus" value="${byStatus}"/>
		    
		    <div class="productList mt20">
		        <div class="sort">
		        	<span class="ml20"><a href="${defaultSortUrl}&sort=0"  style="color: #e94a49;">推荐</a></span>
		            <span><a href="${incomeSortUrl}&sort=1">年化收益<span class="ml5 on"></span></a></span>
		            <span><a href="${durationSortUrl}&sort=2">产品期限<span class="ml5 on"></span></a></span>
		        </div>
		        <input type="hidden" id="sort" value="${sort}">
		        <input type="hidden" id="sortByIncomeOn" value="${sortByIncomeOn}">
		        <input type="hidden" id="sortByDurationOn" value="${sortByDurationOn}">
		        <ul>
		        	<s:iterator value="Pagedp2pProductList.resultList" var="item" status="listStat">
						<%-- <ul>
				          <li class="product_nameValue">
				          	<em class="mr10"></em><a href="${productDetailsUrl}?p2pProductId=<s:property value="#item.id"/>"><s:property value="#item.name"/></a>
				          </li>
				          <li class="project_periodValue"><s:property value="#item.duration"/>个月</li>
				          <li class="project_totalValue"><s:property value="#item.switchTotalAmout"/>元</li>
				          <li class="project_profitValue">
				          	<em class="project_profitRate"><s:property value="#item.income"/>%
				            <s:if test="#item.floatingIncome!=0">
				            +<b><s:property value="#item.floatingIncome"/>%</b>
				            </s:if>
				            </em>
				          </li>
				          <li class="investment_progressValue">
				              <p>
				              	<em></em><span style="width:<s:property value="#item.progress"/>%"></span>
				              </p>
				              <strong><s:property value="#item.progress"/>%</strong>
				          </li>
				          <li class="project_stateValue"><s:if test="#item.status==20||#item.status==30">投资中</s:if> <s:if test="#item.status==40">还款中</s:if></li>
				          <li class="operationValue">
				          	<input type="submit" value="预约投资" class="mt30 ml15" onclick="window.location.href='${productDetailsUrl}?p2pProductId=<s:property value="#item.id"/>'">
				          </li>
				      	</ul> --%>
				      	<!-- //////////////////////// -->
				      	<li class="borderBott">
			            	<img src="${item.logoPath}" width="100" height="100" onclick="window.location.href='${productDetailsUrl}?p2pProductId=${item.id}'"/>
			                <div class="sales_proInfo ml20">
			                	<h4><a href="${productDetailsUrl}?p2pProductId=${item.id}">${item.name}</a></h4>
			                    <ul>
			                        <li>
			                            <span>预期年化收益率</span>
			                            <p>
			                                <%-- <em class="project_profitRate">${item.income}%</em> --%>
			                                <em class="project_profitRate">${item.income}% 
				                                <s:if test="#item.type==5">
													<s:if test="#item.floatingIncome!=0"> ± <b><s:property value="#item.floatingIncome" />%</b></s:if>
												</s:if><s:else>
													<s:if test="#item.floatingIncome!=0"> - <b><s:property value="#item.income+#item.floatingIncome" />%</b></s:if>
												</s:else>
											</em>
			                            </p>
			                        </li>
			                        <li>
			                            <span>融资金额</span>
			                            <p>
			                                <em class="project_total">${item.switchTotalAmout}</em>元
			                            </p>
			                        </li>
			                        <li>
			                            <span>项目期限</span>
			                            <p>
			                                <em class="project_times">${item.duration*1}</em>天
			                            </p>
			                        </li>
			                    </ul>
			                
			                <div class="project_progress">
			                	<s:if test="#item.type==5">
			                    <span class="mt15">筹集进度</span>
			                    <div id="myCanvas${listStat.index}" class="myCanvas${listStat.index}"  _echarts_instance_="142906337193${listStat.index}" 
									style="height:52px; cursor: default; background-color: rgba(0, 0, 0, 0);">
									${item.progress}%  
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
			                    <span>可投余额：<em>${item.switchRemainAmout}元</em></span>
			                	</s:if>
			                </div>
			                <s:if test="#item.status==20 || #item.status==30">
			                	<a href="javascript:void(0)" class="investBtn btnStyle mt10" onclick="window.location.href='${productDetailsUrl}?p2pProductId=${item.id}'">查看详情</a>
			                </s:if>
			                <s:else>
			                	<input value="<s:if test='#item.status==40'>还款中</s:if><s:if test='#item.status==50'>已结束</s:if><s:if test='#item.status==55'>交易取消</s:if><s:if test='#item.status==60'>暂停交易</s:if>" style="color: #CECED1" type="button" class="investBtn btnStyle1 mt10"  onclick="window.location.href='${productDetailsUrl}?p2pProductId=${item.id}'">
			                </s:else>
			              </div>
			              
			        	</li>
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
					</s:iterator>
		           
		        </ul>
                <!-- 页码 -->
					<div class="productList_page mt30 pb30">
						<div class="myInvestment_page">
							<div id="pagination"></div>
							<s:if test="pageIndex!=0">
								第<span class="pl5 pr5">${pageIndex}</span>页&nbsp;
								共<span class="pl5 pr5" >${pageCount}</span>页
							</s:if>
							共<span class="pl5 pr5" id="totalCount">${totalCount}</span>条记录
							<input type="hidden" id="pageIndex" value="${pageIndex}"/>
							<input type="hidden" id="pageUrl" value="${pageUrl}"/>
						</div>
					</div>
                
			</div>
		</div>
		<input type="hidden" value="${pageAlias}" class="pageAlias" />
    </m:Content>
</m:ContentPage>