package com.hzfh.market.controller.common;


import java.util.List;
import com.hzfh.market.model.common.PageAlias;
import com.hzfh.market.model.common.resource.CssContext;
import com.hzfh.market.model.common.resource.ScriptContext;


public abstract class CommonAction extends BaseAction {
    private PageAlias pageAlias;
    private String pageHead = ""; 
    public PageAlias getPageAlias() {
        return pageAlias;
    }

    public void setPageAlias(PageAlias pageAlias) {
        this.pageAlias = pageAlias;
    }

    public String getPageHead() {
        return pageHead;
    }
    @Override
    public String execute(){
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        if (this.pageAlias.toString().isEmpty())
            this.pageAlias = PageAlias.index;

        this.buildCss();
        this.buildJs();
        return SUCCESS;
    }

    private void buildJs() {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> scriptList = ScriptContext.getScriptByPageAlias(this.pageAlias);

		for (String script : scriptList) {
		    stringBuilder.append(script);
		}

        pageHead += stringBuilder.toString();
    }

    private void buildCss() {
        StringBuilder stringBuilder = new StringBuilder();

        for (String css : CssContext.getCssByPageAlias(this.pageAlias)) {
            stringBuilder.append(css);
        }
        pageHead += stringBuilder.toString();
    }
}
