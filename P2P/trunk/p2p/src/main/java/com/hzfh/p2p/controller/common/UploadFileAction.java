package com.hzfh.p2p.controller.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hzfh.p2p.model.common.helper.LogHelper;
import com.hzfh.p2p.model.common.properties.ParamHelper;
import com.hzfh.p2p.model.common.properties.WebInfoHelper;
import com.hzframework.helper.HttpHelper;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UploadFileAction extends ActionSupport {
	private static final LogHelper logHelper = LogHelper.getLogger(UploadFileAction.class);
    //上传文件存放路径
    private final static String UPLOADDIR = "/temp";

    //上传文件集合
    private File file;

    //上传文件名集合
    private String fileFileName;

    //上传文件内容类型集合
    private String fileContentType;

    private String message;

    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }

    private String relativePath;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //执行文件上传
    public void uploadFile() {
        if (file != null) {
            List<String> legalFileTypes = new ArrayList<String>();
            Collections.addAll(legalFileTypes, ParamHelper.LEGAL_FILE_TYPE.split(","));
            String extension = this.fileFileName.substring(this.fileFileName.lastIndexOf(".") + 1);
            if (!legalFileTypes.contains(extension.toLowerCase())) {
                message = "1";
                return;
            }
            Date datePath = new Date();
            String relativeDir = "/" + (datePath.getYear() + 1900) + "/" + (datePath.getMonth() + 1) + "/" + datePath.getDate();
            String fileDir = ServletActionContext.getRequest().getRealPath(UPLOADDIR) + relativeDir;
            try {
                InputStream in = new FileInputStream(file);
                String regEx = "[ `~!@#$%^&*()+=|{}':;',//[//]<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
                Pattern p = Pattern.compile(regEx);
                Matcher m = p.matcher(this.fileFileName);
                this.fileFileName = m.replaceAll("").trim();
                String fileName = (new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())).toString() + "_" + this.fileFileName.toLowerCase();
                File uploadFile = new File(fileDir, fileName);
                if (!uploadFile.getParentFile().exists()) {
                    uploadFile.getParentFile().mkdirs();
                }
                FileUtils.copyFile(this.file, uploadFile);
                in.close();
                message = WebInfoHelper.WEB_P2P_UPLOAD + relativeDir + "/" + fileName;
                //
                HashMap map = new HashMap();
                map.put("fileUrl", URLEncoder.encode(message, "utf-8"));
                map.put("fileName", URLEncoder.encode(fileName, "utf-8"));
                map.put("relativeDir", relativeDir);

                String result = HttpHelper.doPost(WebInfoHelper.WEB_UPLOAD_ACTION, map);
                Object object = JSON.parseObject(result);
                JSONObject resultMessage = (JSONObject) object;
                if (String.valueOf(resultMessage.get("errCode")).equals("1")) {
                    message = WebInfoHelper.WEB_UPLOAD + String.valueOf(resultMessage.get("errDesc"));
                    relativePath = relativeDir + "/" + fileName;
                } else {
                    message = "0";
                    relativePath = String.valueOf(resultMessage.get("errDesc"));
                }
                //

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                message = "0";
                relativePath = e.toString();
                logHelper.error("上传", e);
            } catch (IOException e) {
                e.printStackTrace();
                message = "0";
                relativePath = e.toString();
                logHelper.error("上传", e);
            }
        }
    }

    //批量上传
    @Override
    public String execute() throws Exception {
        uploadFile();
        return SUCCESS;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

}
