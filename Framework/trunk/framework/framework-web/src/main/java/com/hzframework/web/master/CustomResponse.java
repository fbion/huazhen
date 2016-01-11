package com.hzframework.web.master;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by paul on 14-11-3.
 */
public final class CustomResponse extends HttpServletResponseWrapper {
    private StringWriter strWriter = new StringWriter();
    private PrintWriter out = new PrintWriter(strWriter) ;

    public CustomResponse(HttpServletResponse response) {
        super(response);
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return out;
    }
    public String getContent() {
        return strWriter.toString();
    }
}