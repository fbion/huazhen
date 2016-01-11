<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">

            <div class="productDescription mt20 productmt20">
                <div class="product_description">
                    <!--<img  src="${productDescriptionUrl}"  width="60" height="60" >-->
                  ${p2pProduct.description}
                </div>
            
            <div class="proListRecord tabContent">
            	<div id="investRecordList"></div>
            	<!--<p class="mt30"><a class="btn" id="loadMore">查看更多</a></p>-->
            </div>
                 
                
                <s:if test="#p2pProduct.productAdvantage!=null">
                <div class="product_advantage mt10">
                    <img  src="${productAdvantageUrl}" width="60" height="60"><a href="#">产品优势</a>
                    ${p2pProduct.productAdvantage}
                </div>
                </s:if>
			</div>
			
 		<input id="needVerifyCode" type="hidden">
   </script>
    </m:Content>
</m:ContentPage>