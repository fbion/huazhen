package weixin.core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.hzframework.helper.StringHelper;

import weixin.util.SignUtil;

/**
 * 核心处理类
 * @author Administrator
 *
 */
public class CoreProcess{
	
	HttpServletRequest request = ServletActionContext.getRequest();  
	HttpServletResponse response = ServletActionContext.getResponse(); 
	
	private String signature;
	private String timestamp;
	private String nonce;
	private String echostr;
	
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getNonce() {
		return nonce;
	}
	public void setNonce(String nonce) {
		this.nonce = nonce;
	}
	public String getEchostr() {
		return echostr;
	}
	public void setEchostr(String echostr) {
		this.echostr = echostr;
	}

	public void coreProcess() throws Exception{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		if(!StringHelper.isNullOrEmpty(echostr)){
			if(SignUtil.checkSignature(signature, timestamp, nonce)){
				out.print(echostr);
			}
		}else {
			if(SignUtil.checkSignature(signature, timestamp, nonce)){
				String respXml = CoreService.processRequest(request);
				out.print(respXml);
			}
		}
		out.close();
		out = null;
	}
}
