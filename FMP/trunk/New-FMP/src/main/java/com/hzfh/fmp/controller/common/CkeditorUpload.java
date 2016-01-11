package com.hzfh.fmp.controller.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hzfh.fmp.model.common.properties.WebInfoHelper;
import com.hzframework.helper.HttpHelper;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Administrator on 2015/3/31.
 */
public class CkeditorUpload extends ActionSupport {
    private final static String UPLOADDIR = "/temp";
    private File upload;
    private String uploadContentType;
    private String uploadFileName;

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String execute() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String callback = ServletActionContext.getRequest().getParameter("CKEditorFuncNum");
        String expandedName = "";
        if (uploadContentType.equals("image/pjpeg") || uploadContentType.equals("image/jpeg")) {
            expandedName = ".jpg";
        } else if (uploadContentType.equals("image/png") || uploadContentType.equals("image/x-png")) {
            expandedName = ".png";
        } else if (uploadContentType.equals("image/gif")) {
            expandedName = ".gif";
        } else if (uploadContentType.equals("image/bmp")) {
            expandedName = ".bmp";
        } else {
            out.println("<script type=\"text/javascript\">");
            out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",'','文件格式不正确（必须为.jpg/.gif/.bmp/.png文件）');");
            out.println("</script>");
            return null;
        }
        if (upload.length() > 600 * 1024) {
            out.println("<script type=\"text/javascript\">");
            out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",''," + "'文件大小不得大于600k');");
            out.println("</script>");
            return null;
        }

        if (upload != null) {
            Date datePath = new Date();
            String relativeDir = "/" + (datePath.getYear() + 1900) + "/" + (datePath.getMonth() + 1) + "/" + datePath.getDate();
            String fileDir = ServletActionContext.getRequest().getRealPath(UPLOADDIR) + relativeDir;
            InputStream in = new FileInputStream(upload);
            String fileName = (new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())).toString() + "_" + this.uploadFileName;
            File uploadFile = new File(fileDir, fileName);
            if (!uploadFile.getParentFile().exists()) {
                uploadFile.getParentFile().mkdirs();
            }
            FileUtils.copyFile(upload, uploadFile);
            in.close();

            String message = WebInfoHelper.WEB_FMP_UPLOAD + relativeDir + "/" + fileName;
            HashMap map = new HashMap();
            map.put("fileUrl", URLEncoder.encode(message, "utf-8"));
            map.put("fileName", URLEncoder.encode(fileName, "utf-8"));
            map.put("relativeDir", relativeDir);
            HttpHelper.doPost(WebInfoHelper.WEB_UPLOAD_ACTION, map);
            String result = HttpHelper.doPost(WebInfoHelper.WEB_UPLOAD_ACTION, map);
            Object object = JSON.parseObject(result);
            JSONObject resultMessage = (JSONObject)object;
            if (String.valueOf(resultMessage.get("errCode")).equals("1")){
                message = WebInfoHelper.WEB_UPLOAD + String.valueOf(resultMessage.get("errDesc"));
            }

            out.println("<script type=\"text/javascript\">");
            out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + message + "','')"); // 相对路径用于显示图片
            out.println("</script>");
            return null;
        }
        return null;
    }
}
