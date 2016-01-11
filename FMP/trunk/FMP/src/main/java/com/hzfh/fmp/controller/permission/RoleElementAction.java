package com.hzfh.fmp.controller.permission;

import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.permission.RoleElementModel;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class RoleElementAction extends CommonAction {

    @Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.roleElementList);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        return SUCCESS;
    }
    
    public String getRoleElementTree() throws Exception{
		String xml;
		try {
			xml = RoleElementModel.getElementTree();
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/xml;charset=UTF-8");
			PrintWriter out = response.getWriter();
			//System.out.println(xml);
			out.print(xml);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
}
