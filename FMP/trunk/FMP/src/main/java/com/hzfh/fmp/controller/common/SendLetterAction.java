package com.hzfh.fmp.controller.common;


import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.properties.LetterHelper;
import com.hzfh.fmp.model.permission.view.TagPermissionView;


public class SendLetterAction extends CommonAction {

	private String pageVar;
	
	public String getPageVar() {
		return pageVar;
	}


	@Override
	public String execute() throws Exception {
		 this.setPageAlias(PageAlias.sendLetter);
	        String ret = super.execute();
	        if (!ret.equals(SUCCESS))
	            return ret;
	     //权限暂时 空
	        
	        initPageVar();
		return SUCCESS;
	}
	
	
	 private void initPageVar() {
	        StringBuilder sb = new StringBuilder();
	        sb.append("<script type=\"text/javascript\">");

	        sb.append("var PageVar={");
	        sb.append(String.format("%1$s:'%2$s',", "LetterType", LetterHelper.LETTER_AGENTBUSINESS));
	        sb.append("};");

	        sb.append("var ElementVar={");
	        for (TagPermissionView tagPermissionView : this.getPagePermissionView().getTagPermissionViewList()) {
	            sb.append(String.format("%1$s:'%2$s',", tagPermissionView.getTagName(), String.valueOf(tagPermissionView.getTagPermissionType())));
	        }
	        sb.append("};");
	        sb.append("</script>");
	        this.pageVar = sb.toString();
	    }

}
