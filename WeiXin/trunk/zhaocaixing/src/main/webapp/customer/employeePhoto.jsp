<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
	<dl class="managingdirectordl">
         <dt>理财经理:</dt>
         <span id="employeeMsg"></span>
   </dl>
  <div id="carousel" class="es-carousel-wrapper">
             <div class="es-carousel" >
                 <ul>
           <s:iterator value="#request.employeeList" id="item">
           	 <li>
                
            	<label for='<s:property value="#item.userNo"/>'>
                	<img  src="<s:property value="#item.portraitPath"/>"/>
                </label>
                
                <p>
                    <input type="radio" id='<s:property value="#item.userNo"/>' value='<s:property value="#item.userNo"/>' name="choose_customers" />
                    <label class="pl5" for='<s:property value="#item.userNo"/>'><s:property value="#item.name"/></label>
                </p>
            </li>
        </s:iterator>
             </ul>
          </div>
   </div> 
<script type="text/javascript">
	$(":radio").change(function(){
		$("#employeeMsg").removeClass().text("");
	});
	
	
	
	$('#carousel').elastislide({
		imageW 		: 180,
		minItems	: 3,
		margin		: 2,
		border		: 0,
		current		: 12
	});
</script> 