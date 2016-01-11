<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center"> 
    <div id="name" style="display: none;">${name}</div> 
    <s:if test="name=='connection'">
    <div id="content" class="mt20">
    <div class="contactUs pb20">
    	<p class="mt20 p20"><img src="${mapUrl}" id="map"/></p>
        <ul class="mt20">
        	<li>电 话：010-59219789</li>
    		<li>传 真：010-59219766</li>
    		<li>热 线：400-0340-668</li>
            <li>邮 箱：hzjk@bestinvestor.com.cn</li>
            <li>地 址：北京市朝阳区东三环中路5号FFC大厦30层</li>
        </ul>
    </div>
</div>
</s:if>

<s:if test="name=='introduce'">
    <div id="introduce" class="mt20">
        <div class="contactUs pt10 pb20">
            <div class="p20 tc"><img src="${logUrl}" id="log"/></div>
            <p class="mt20 p15">
             华镇社区金融，是华镇金融控股集团下属的创新金融业务，华镇互联网金融平台拥有大数据优势资源，多年来在金融行业形成了成熟、完善的线上线下相结合的服务体系。通过专业的投资管理团队联合精干的IT技术团队，运用先进的信息网络技术，倾力打造了集“互联网金融资产交易”和“走入社区全方位贴身服务”于一体的金融创新服务平台。
            </p>
            <p class="mt20 p15">
             华镇社区金融依托自身完善的风险控制体系、丰富的项目管理经验和资深的投资团队，深入分析行业和市场，在交易管理和客户服务方面不断的探索、创新，形成独具特色的社区金融体系。为中小企业和个人提供最专业、全面、安全、高效的投资服务，进而帮助中小企业解决投融资、资本运作、合资并购等方面的问题，助推企业发展；帮助个人投资者实现财富最大化增值。致力于成为国内领先的一站式互联网金融服务商。
            </p>
        </div>
    </div>
</s:if>
    </m:Content>
</m:ContentPage>		
		