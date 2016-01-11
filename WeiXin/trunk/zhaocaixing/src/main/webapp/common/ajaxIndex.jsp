<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:iterator value="#request.p2pProductList.resultList" id="item"  status="index">
		       <div onclick="window.open('${productDetailsUrl}?p2pProductId=<s:property value="#item.id"/>')">
						<li>    
							<h3>
								<a
									href="${productDetailsUrl}?p2pProductId=<s:property value="#item.id"/>">
									<s:property value="#item.name" />
								</a>
							</h3>

							<dl class="project_profit" onclick="${productDetailsUrl}?p2pProductId=<s:property value="#item.id"/>">
								<dt>年化收益</dt>
								
								<dd>
									<em><s:property value="#item.income" />%</em>
									<s:if test="#request.p2pProduct.floatingIncome!=0">
                             +<b><s:property value="#item.floatingIncome" />%</b>
                            </s:if>
								</dd>
							</dl>
							<dl>     
								<dt>项目期限</dt>
								<dd>
									<s:property value="#item.duration" />
									天
								</dd>
							</dl>
							<dl>
								<dt>总金额</dt>
								<dd>
									<s:property value="#item.switchTotalAmout" />
									元
								</dd>
							</dl>
							<s:if test="#item.type==5">
							<dl class="progress_Bar">
								<dt></dt>
								<dd>
                                    <div id="myCanvas<s:property value="#item.rowIndex"/>" class="myCanvas<s:property value="#item.rowIndex"/>" _echarts_instance_="142906337193<s:property value="#item.rowIndex"/>" style="height:50px; cursor: default; background-color: rgba(0, 0, 0, 0);">
                                      <s:property value="#item.progress" />%
                                      <div style="position: relative; overflow: hidden; width: 80px; height: 50px;">
                                        <div width="163" height="44" data-zr-dom-id="bg" style="position: absolute; left: 0px; top: 0px; width: 163px; height: 44px; -webkit-user-select: none;"></div> 
                                            <canvas width="80" height="44" data-zr-dom-id="2" style="position: absolute; left: 0px; top: 0px; width:80px; height: 44px; -webkit-user-select: none;"></canvas>
                    						<canvas width="80" height="44" data-zr-dom-id="3" style="position: absolute; left: 0px; top: 0px; width:80px; height: 44px; -webkit-user-select: none;"></canvas>
                    						<canvas width="80" height="44" data-zr-dom-id="4" style="position: absolute; left: 0px; top: 0px; width:80px; height: 44px; -webkit-user-select: none;"></canvas>
                    						<canvas width="80" height="44" data-zr-dom-id="6" style="position: absolute; left: 0px; top: 0px; width:80px; height: 44px; -webkit-user-select: none;"></canvas>
                                            <canvas width="80" height="44" data-zr-dom-id="_zrender_hover_" style="position: absolute; left: 0px; top: 0px; width:80px; height: 44px; -webkit-user-select: none;"></canvas>
                                        </div>
                                    </div>
								</dd>
								<s:if test="status==20">
								 	<img  src="${productListStateUrl}" class="pic<s:property value="#item.rowIndex"/>" />  
								</s:if>
								<s:if test=" status==30">
								 	<img  src="${productListStateUrl}" class="pic<s:property value="#item.rowIndex"/>" />  
								</s:if>
								<s:if test="status==40 " >
								 <img src="${productListStateFinshedUrl} "  class="pic<s:property value="#item.rowIndex"/>"/> 
								</s:if> 
								<s:else>
								   <img  src="${productListStateUrl}" class="pic<s:property value="#item.rowIndex"/>" />  
								</s:else>
								<s:if test=" status==50" >
								   <img src="${productListStateRepaymentUrl} "  class="pic<s:property value="#item.rowIndex"/>"/>
								</s:if> 
							</dl> 
                            <script>

								var progress = $('#myCanvas<s:property value="#item.rowIndex"/>').html();
								var data1 = progress.split("%")[0];
								var data = data1.split(".")[0];
								
								$("#content li").find('.pic<s:property value="#item.rowIndex"/>').css({
									"top":(<s:property value="#item.rowIndex"/>-1)*140+'px',
									"right":"0px"
								});
								var labelTop = {
									normal : {
										label : { show : false, position : 'center',
											textStyle: { baseline : 'bottom' }
										},
									labelLine : { show : false }
									}
								};

								var labelBottom= {
									normal : {
									color: '#ccc',
										label : {
											show : true,
											position : 'center',
											formatter : function (a,b,c){return 100 - c + '%'},
												textStyle: {
													baseline : 'middle',color:'#000'
												}
										},
										labelLine : {
											show : false
										}
									},
									emphasis: {
										color: 'rgba(0,0,0,0)'
									}
								};
								//设置圆圈的内外半径
								var radius = [16, 20];

								var a = 'option<s:property value="#item.rowIndex"/>';
								a = {
									legend: {
										x : 'center',
										y : 'center',
										data:[
										
										]
									},
									title : {
									
									},
									toolbox: {
										show : true,
										feature : {
										
										}
									},
									series : [
										{
											type : 'pie',
											center : ['50%', '50%'],
											radius : radius,
											data : [
												{value:data,itemStyle : labelTop},
												{value:100-data, itemStyle : labelBottom}
											]
										}
									]
								};
								//为指定对象绑定插件效果
								echarts.init(document.getElementById('myCanvas<s:property value="#item.rowIndex"/>')).setOption(a);
							</script>
							</s:if><s:else>
							<dl class="progress_Bar">
								<s:if test="status==20">
								 	<img  src="${productListStateUrl}" class="pic<s:property value="#item.rowIndex"/>" />  
								</s:if>
								<s:if test=" status==30">
								 	<img  src="${productListStateUrl}" class="pic<s:property value="#item.rowIndex"/>" />  
								</s:if>
								<s:if test="status==40 " >
								 <img src="${productListStateFinshedUrl} "  class="pic<s:property value="#item.rowIndex"/>"/> 
								</s:if> 
								<s:else>
								   <img  src="${productListStateUrl}" class="pic<s:property value="#item.rowIndex"/>" />  
								</s:else>
								<s:if test=" status==50" >
								   <img src="${productListStateRepaymentUrl} "  class="pic<s:property value="#item.rowIndex"/>"/>
								</s:if> 
							</dl> 
							<script>
								$("#content li").find('.pic<s:property value="#item.rowIndex"/>').css({
									"top":(<s:property value="#item.rowIndex"/>-1)*140+'px',
									"right":"0px"
								});
							</script>
							</s:else>
                            
						</li>
						</div>
				</s:iterator>
				