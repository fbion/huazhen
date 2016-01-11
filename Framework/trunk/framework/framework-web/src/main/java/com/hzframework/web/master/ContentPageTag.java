package com.hzframework.web.master;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by paul on 14-11-3.
 */
public class ContentPageTag extends BodyTagSupport {
    private static final String masterFolderPath = "/layout/";
    private static final String masterPageSuffix = ".jsp";

    private static final long serialVersionUID = 1L;

    @Override
    public void doInitBody() throws JspException {
        try {
            this.pageContext.getRequest().setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        super.doInitBody();
    }

    @Override
    public int doAfterBody() throws JspException {
        return SKIP_BODY;
    }

    @Override
    public int doStartTag() throws JspException {
        return EVAL_BODY_BUFFERED;
    }

    @Override
    public int doEndTag() throws JspException {
        JspWriter out = pageContext.getOut();
        CustomResponse bufferedResponse = new CustomResponse((HttpServletResponse) this.pageContext.getResponse());
        try {
            System.out.println("master url :" + this.getMasterPageUrl());
            this.pageContext.getServletContext().getRequestDispatcher(this.getMasterPageUrl()).include(this.pageContext.getRequest(), bufferedResponse);
            System.out.println("master page content : " + bufferedResponse.getContent());
            //out.clearBuffer();
            out.write(bufferedResponse.getContent());
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return SKIP_PAGE;
    }

    /**
     *
     * @return String
     * @Title: getMasterPageUrl
     * @author liheping    2012-5-15  下午02:16:13
     */
    private String getMasterPageUrl() {
        return masterFolderPath + this.materPageId + masterPageSuffix;
    }

    private String materPageId;

    public String getMaterPageId() {
        return materPageId;
    }

    public void setMaterPageId(String materPageId) {
        this.materPageId = materPageId;
    }

}