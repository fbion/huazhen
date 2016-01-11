<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>
	       <form id="valEmail" class="validform">
	           <dl >
	             <dt>邮箱：</dt>
	             <dd>
	                 <input type="text" name="email" placeholder="邮箱" tabindex="2" class="uiText input"
	                        id="email">
	             </dd>
	             <dd>
	                 <div style="display: none;"  class="desc Validform_checktip"></div>
	             </dd>
	         </dl>
             <dl>
             	<dt></dt>
	         	<dd>
	        		<input type="submit" id="identyTel" value="确认"  class="personalInfoSubmit mt20" />
              	</dd>
             </dl>
	      </form>