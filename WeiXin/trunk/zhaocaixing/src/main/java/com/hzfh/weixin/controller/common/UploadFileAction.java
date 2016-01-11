package com.hzfh.weixin.controller.common;


import com.hzfh.weixin.model.common.properties.WebInfoHelper;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UploadFileAction extends ActionSupport {
    //上传文件存放路径
    private final static String UPLOADDIR = "/upload";

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
            Date datePath = new Date();
            String relativeDir ="/" + (datePath.getYear() + 1900) + "/" + (datePath.getMonth() + 1) + "/" + datePath.getDate();
            String fileDir = ServletActionContext.getRequest().getRealPath(UPLOADDIR) + relativeDir;
            try {
                InputStream in = new FileInputStream(file);
                String fileName = (new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date())).toString() +"_"+ this.fileFileName;
                File uploadFile = new File(fileDir, fileName);
                if (!uploadFile.getParentFile().exists()) {
                    if (!uploadFile.getParentFile().getParentFile().exists()) {
                        if (!uploadFile.getParentFile().getParentFile().getParentFile().exists()) {
                            uploadFile.getParentFile().getParentFile().getParentFile().mkdirs();
                        }
                        uploadFile.getParentFile().getParentFile().mkdirs();
                    }
                    uploadFile.getParentFile().mkdirs();
                }
                FileUtils.copyFile(this.file, uploadFile);
                in.close();
                message = WebInfoHelper.WEB_P2P_UPLOAD + UPLOADDIR + relativeDir+ "/"+fileName;
                relativePath = relativeDir + "/"+fileName;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                message = "0";
            } catch (IOException e) {
                e.printStackTrace();
                message = "0";
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
