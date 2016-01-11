<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="wrappSearch mt30">
            <h3></h3>
            <div class="wrappSearchContent">
                申请人:<input type="text" id="name"/>
               标题：<select id="selectTitle"></select>
                申请日期：<input id="date"/>
                <input id="btnSearch" type="button" value="查询" class="btn_style"/>
            </div>
        </div>
        <%-- <p class="mt50 pl20"> 
			<s:if test="showAddButton">
                <input type="button" id="btnAdd" value="新建" class="btn_style"/>
            </s:if></p>  --%>
        <div class="pic mt20">
            <table id="gridTable" class="gridTable">
            </table>
            <div id="gridPager" class="gridPager">
            </div>
        </div> 
        <!-- <div class="detail mt20 -pl20 pb30">
			<div class="tab">
				<div class="tab_title">
					<a href="javascript:;" class="active" id="unAcceptTask">代办的任务</a><a href="javascript:;" id="acceptTask">受理的任务</a>
				</div>
				<ul class="tab_content">
					<li class="tab_content1  tabContent" style="display:block;">
						<div class="basic_Info_content p15 info_All">
											<div class="wrappSearch mt30">
									            <h3></h3>
									            <div class="wrappSearchContent">
									                ####todo
									                <input id="btnSearch" type="button" value="查询" class="btn_style"/>
									            </div>
									        </div>
									        <div class="pic mt20 pl20">
									            <table id="gridTable" class="gridTable"></table>
									            <div id="gridPager" class="gridPager"></div>
									        </div>
						</div>
					</li>
                   
                    	<li class="tab_content3  tabContent" style="display:none;">
                        <div class="basic_Info_content p15 info_All">
                            <div class="wrappSearch mt30">
					            <h3></h3>
					            <div class="wrappSearchContent">
					                ####todo
					                <input id="btnSearch" type="button" value="查询" class="btn_style"/>
					            </div>
					        </div>
					        <div class="pic mt20 pl20">
					            <table id="gridTableAccept" class="gridTable"></table>
					            <div id="gridPagerAccept" class="gridPager"></div>
					        </div>
                        </div>
                    </li>
				</ul>
			</div>
		</div> -->
		 <div id="w1" class="easyui-window" title="审批" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:500px;height:200px;padding:10px;">
			<div>
				<textarea id="taskCommet" style="width:450px; height:100px;"></textarea>
				<div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
					<input id="submit1" name="submit" type="submit" value="通过"class="submit_Btn  btn_style examine"/>
               		<input id="submit2" name="" type="submit" value="不通过" class="submit_Btn  btn_style examine"/>
				</div>
			</div>
		</div>
		<div id="procImgWin" class="easyui-window" title="流程监控窗口"
		    data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:false,draggable:false,resizable:false,iconCls:'icon-redo'"
		    style="width:400px;height:400px;padding:10px;">
		    <img id="procImg" src="" />
		</div>
    </m:Content>
</m:ContentPage>
