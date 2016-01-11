package com.hzfh.fmp.controller.permission;

import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.permission.ElementModel;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class ElementAction extends CommonAction {

	private int elementId;
	
    public int getElementId() {
		return elementId;
	}
	public void setElementId(int elementId) {
		this.elementId = elementId;
	}
	
	@Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.elementList);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        return SUCCESS;
    }
    public String getElementTree() throws Exception{
		//return xmlOut(PrivilegeModel.getAllPrivilegeListXML());
		String xml;
		try {
			xml = ElementModel.getElementTree(elementId);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/xml;charset=UTF-8");
			PrintWriter out = response.getWriter();
			System.out.println(xml);
			out.print(xml);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
}
