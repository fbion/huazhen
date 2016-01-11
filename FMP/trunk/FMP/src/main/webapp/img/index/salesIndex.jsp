<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<ul class="productInfo">
    <li class="productInfoList1">
        <div class="online_sales">
            <h3>打款情况</h3>
            <p>
                <a href="${productDetailUrl}" class="mr10" >产品详情</a><a
            href="${salesDetailUrl}">打款详情</a>
            </p>
            <div class="online_salesContents">
                <table width="82%" border='1' class="tc f14">
                    <thead>
                        <tr>
                            <th width="25%" height="50" class="tc fb">部门</th>
                            <th width="15%" class="tc fb">承销金额(万)</th>
                            <th width="15%" class="tc fb">已打款(万)</th>
                            <th width="15%" class="tc fb">打款数量(个)</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td height="30">财富管理中心</td>
                            <td>----</td>
                            <td>${salesFortuneCenter}</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td height="30" style="text-indent:20px;">--渠道</td>
                            <td>${salesChannelTaskAmout}</td>
                            <td>${salesChannelAll}</td>
                            <td>${countSalesChannel}</td>
                        </tr>
                        <tr>
                            <td height="30" style="text-indent:20px;">--直销</td>
                            <td>${salesDirectTaskAmout}</td>
                            <td>${salesDirectAll}</td>
                            <td>${countSalesDirect}</td>
                        </tr>
                        <tr>
                            <td height="30">新金融事业部</td>
                            <td>----</td>
                            <td>${salesMendianAll}</td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>
                <h4 class="fb">总打款进度</h4>
                <div class="play_details">
                    <canvas class="CanvasSalesAmount" width="200" height="120" rel0="${product.sumMoney}" rel1="${salesAmount}"></canvas>
                </div>
                <div class="play_amount">
                    <em>${salesAmount}万</em>
                </div>
            </div>
        </div>
    </li>

<!-- 	<li class="productInfoList3 mt30">
		<div class="project_audit">
			<h3>员工流动</h3>
            <div class="project_auditContent">
                <h4>敬请期待。。。。</h4>		
            </div>
		</div>
	</li> -->
</ul>