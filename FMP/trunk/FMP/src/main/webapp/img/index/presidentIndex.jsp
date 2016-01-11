<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<ul class="productInfo">
    <li class="productInfoList1 proInfoList">
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
                            <th width="15%" class="tc fb">打款数量(笔)</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td height="30">财富管理中心</td>
                            <td>${productTaskAmoutAll}</td>
                            <td>${salesFortuneCenter}</td>
                            <td>${countSalesChannel+countSalesDirect}</td>
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
                            <td>${countsalesMendian}</td>
                        </tr>
                    </tbody>
                </table>
                <h4 class="fb">总打款进度<span>已打款${salesAmount}万</span></h4>
                <div class="play_details">
                    <canvas class="CanvasSalesAmount" width="100" height="100" rel0="${salesAmountAll}" rel1="${salesAmount}"></canvas>
                </div>
                <div class="play_amount">
                    <em>总额${salesAmountAll}万</em>
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