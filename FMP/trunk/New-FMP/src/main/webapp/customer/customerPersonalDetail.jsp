<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 -pl20 pb30">
            <div class="tab">
                <div class="tab_title">
                    <a href="javascript:;" class="active">自然人客户</a>
                    <a href="javascript:;">打款详情</a>
                </div>
                <ul class="tab_content">
                    <li class="tab_content1  tabContent" style="display:block;">
                        <div class="basic_Info_content p15 info_All">
                            <form id="customerPersonalDetail" style="z-index:9999;">
                                <ul>
                                    <li><span class="fw">姓名</span><a id="name" name="name" class="ml20"
                                                                     target="_blank"></a></li>
                                    <li><span class="fw">证件号码</span><a id="cardNumber" name="cardNumber" class="ml20"
                                                                       target="_blank"></a></li>
                                </ul>

                                <ul>
                                    <li><span class="fw">性别</span><a id="sex" name="sex" class="ml20"
                                                                     target="_blank"></a></li>
                                    <li><span class="fw">邮箱</span><a id="email" name="email" class="ml20"
                                                                     target="_blank"></a></li>

                                </ul>
                                <ul>
                                    <li><span class="fw">微信</span><a id="weixin" name="weixin" class="ml20"
                                                                     target="_blank"></a></li>
                                    <li><span class="fw">QQ</span><a id="qq" name="qq" class="ml20" target="_blank"></a>
                                    </li>

                                </ul>
                                <ul>
                                    <li><span class="fw">手机1</span><a id="cellphone1" name="cellphone1" class="ml20"
                                                                      target="_blank"></a></li>
                                    <li><span class="fw">手机2</span><a id="cellphone2" name="cellphone2" class="ml20"
                                                                      target="_blank"></a></li>

                                </ul>
                                <ul>
                                    <li><span class="fw">固定电话</span><a id="phone" name="phone" class="ml20"
                                                                       target="_blank"></a></li>
                                    <li><span class="fw">生日</span><a id="birthday" name="birthday" class="ml20"
                                                                     target="_blank"></a></li>

                                </ul>
                                <ul>
                                    <li><span class="fw">住址</span><a id="address" name="address" class="ml20"
                                                                     target="_blank"></a></li>
                                    <li><span class="fw">婚姻情况</span><a id="marry" name="marry" class="ml20"
                                                                       target="_blank"></a></li>

                                </ul>
                                <ul>
                                    <li><span class="fw">所属公司</span><a id="companyName" name="companyName" class="ml20"
                                                                       target="_blank"></a></li>
                                    <li><span class="fw">所属行业</span><a id="field" name="field" class="ml20"
                                                                       target="_blank"></a></li>

                                </ul>
                                <ul>
                                    <li><span class="fw">关系等级</span><a id="relationLevel" name="relationLevel"
                                                                       class="ml20" target="_blank"></a></li>
                                    <li><span class="fw">风险偏好</span><a id="riskHobby" name="riskHobby" class="ml20"
                                                                       target="_blank"></a></li>

                                </ul>
                                <ul>
                                    <li><span class="fw">新增时间</span><a id="findTime" name="findTime" class="ml20"
                                                                       target="_blank"></a></li>
                                    <li><span class="fw">负责人</span><a id="agentNo" name="agentNo" class="ml20"
                                                                      target="_blank"></a></li>
                                </ul>
                                <ul>
                                    <li><span class="fw">可配置资产</span><a id="wealth" name="wealth" class="ml20"
                                                                        target="_blank"></a>万元
                                    </li>
                                    <li><span class="fw">累计购买额</span><a id="tradeTotal" name="tradeTotal" class="ml20"
                                                                        target="_blank"></a>元
                                    </li>

                                </ul>
                                <ul>
                                    <li><span class="fw">是否测试</span><a id="isTest" name="isTest" class="ml20"
                                                                       target="_blank"></a></li>
                                    <li><span class="fw">客户来源</span><a id="sourceType" name="sourceType" class="ml20"
                                                                       target="_blank"></a></li>
                                </ul>
                                <ul>
                                    <li><span class="fw">备注</span><a id="editComment" name="editComment" class="ml20"
                                                                     target="_blank"></a></li>

                                </ul>
                                <ul style="display: none">
                                    <li><span class="fw">是否测试</span><a id="isTest" name="isTest" class="ml20"
                                                                       target="_blank"></a></li>
                                    <li><span class="fw">p2p客户</span><a id="p2pCustomerNo" name="p2pCustomerNo"
                                                                        class="ml20" target="_blank"></a></li>

                                </ul>
                                <ul style="display: none">

                                    <li><span class="fw">客户编号</span><a id="code" name="code" class="ml20"
                                                                       target="_blank"></a></li>
                                    <li><span class="fw">证件类型</span><a id="cardType" name="cardType" class="ml20"
                                                                       target="_blank"></a></li>

                                </ul>
                                <ul style="display: none">

                                    <li><span class="fw">isLogin</span><a id="isLogin" name="isLogin" class="ml20"
                                                                          target="_blank"></a></li>

                                </ul>

                                <p id="btn" class="mt50">
                                    <em id="msg"></em>
                                    <input type="button" id="back" value="返回" class="cancel_Btn btn_style"/>
                                </p>
                            </form>
                            <div class="pic mt20 pl20">
								<table id="gridTableFollow" class="gridTable">
								</table>
								<div id="gridPagerFollow" class="gridPager"></div>
							</div>
							<form id="Follow" hidden="hidden">
								<input type="text" id="hideId" hidden="hidden" />
								<ul>
									<li><span>推荐产品<em class='color'>*</em></span> <select
										id="product_no" name="product_no"  class="ml20"></select>
										<div class="Validform_checktip"></div></li>
									<li><span>跟踪类型</span> <select id="followType"
										name="followType"  class="ml20"></select>
										<div class="Validform_checktip"></div></li>
								</ul>
								<ul>
									<li><span>跟踪时间</span> <input id="followTime"
										name="followTime" type="text" class="ml20" />
										<div class="Validform_checktip"></div></li>
									<li><span>下次跟踪</span> <input id="nexttime" name="nexttime"
										type="text" class="ml20" />
										<div class="Validform_checktip"></div></li>
								</ul>
								<ul>
									<li><span>跟踪内容<em class='color'>*</em></span> <textarea
										id="contentFollow" name="contentFollow" 
										class="ml20" ></textarea>
										<div class="Validform_checktip"></div></li>
									<li><span>跟踪结果</span>
										<select id="resultStatus" name="resultStatus" class="ml20"></select>
										<div class="Validform_checktip"></div></li>
								</ul>
								<div style="margin-left: 43px">
									<p id="btn" style="display: none;">
										<em id="showMsg" class='color'></em><em id="msg"></em> <input
											type="submit" id="submitFollow" value="跟踪"
											class="submit_Btn btn_style" /> <input type="button"
											id="editFollow" value="修改" class="submit_Btn btn_style" />
									</p>
								</div>
							</form>
                        </div>
                    </li>
                    <li class="tab_content1 tabContent">

                        <div class="wrappSearch mt30">
                            <h3></h3>
                            <div class="wrappSearchContent">
                                打款状态:<select id="selectStatus"></select>
                                产品类型：<select id="selectProductType"></select>
                                产品：<select id="selectProduct"></select>
                                销售类型:<select id="selectAgentType"></select>
                                <span>销售:</span><select id="selectAgent"></select>
                                <input id="btnSearch" type="button" value="查询" class="btn_style"/>
                                <s:if test="showExcelButton">
                                    <input type="button" id="btnExcel" value="导出Excel" class="btn_style" />
                                </s:if>
                            </div>
                        </div>
                        <p class="btnSales mt50" style="display: none">
                            <s:if test="showAddButton">
                                <input type="button" id="btnAddSales" class="btnAdd btn_style" value="新建"/>
                            </s:if>

                        </p>
                        <div class="pic mt20">
                            <table id="gridTable" class="gridTable">
                            </table>
                            <div id="gridPager" class="gridPager">
                            </div>
                        </div>

                    </li>
                </ul>
            </div>
        </div>
        ${pageVar}
    </m:Content>
</m:ContentPage>