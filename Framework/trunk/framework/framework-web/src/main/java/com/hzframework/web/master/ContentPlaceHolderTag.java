package com.hzframework.web.master;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by paul on 14-11-3.
 */
public class ContentPlaceHolderTag extends TagSupport {
    private static final long serialVersionUID = 1L;

    @Override
    public int doEndTag() throws JspException {
        JspWriter out = pageContext.getOut();
        Object obj = this.pageContext.getRequest().getAttribute(this.getId());
        try {
            if(obj!=null)
                out.write(obj.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }
}