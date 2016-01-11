package com.hzfh.upload;

import com.hzfh.log.LogHelper;
import com.hzframework.helper.PropertyHelper;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Created by paul on 15-3-25.
 */
public class UploadFileAction extends ActionSupport {
    public static final LogHelper logger = LogHelper.getLogger(UploadFileAction.class);
    //上传文件存放路径
    private final static String UPLOADDIR = "/files";

    private String errCode;
    private String errDesc;

    public String getErrDesc() {
        return errDesc;
    }

    public String getErrCode() {
        return errCode;
    }

    private String fileUrl;

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    private String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String relativeDir;

    public void setRelativeDir(String relativeDir) {
        this.relativeDir = relativeDir;
    }

    //批量上传
    @Override
    public String execute() throws Exception {
        logger.info("开始进行文件上传操作");
        downloadFile();
        return SUCCESS;
    }


    public void downloadFile() {
        int nStartPos = 0;
        int nRead = 0;

        //this.resultMessage = new ResultMessage();

        try {
            String extension = this.fileUrl.substring(this.fileUrl.lastIndexOf(".")+1);
            if (!checkFileType(extension)) {
                this.errCode = "0";
                this.errDesc = "非法的文件格式";
                return;
            }


            if (!checkUrl(this.fileUrl)) {
                this.errCode = "0";
                this.errDesc = "非法的url";
                return;
            }

            URL url = new URL(this.fileUrl);
            //打开连接
            HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
            //获得文件长度
            long nEndPos = getFileSize(this.fileUrl);

            String fileDir = ServletActionContext.getRequest().getRealPath(UPLOADDIR) + this.relativeDir;

            File uploadFile = new File(fileDir, this.fileName);
            if (!uploadFile.getParentFile().exists()) {
                uploadFile.getParentFile().mkdirs();
            }

            RandomAccessFile oSavedFile = new RandomAccessFile(fileDir + "/" + this.fileName, "rw");

            httpConnection.setRequestProperty("User-Agent", "Internet Explorer");
            String sProperty = "bytes=" + nStartPos + "-";
            httpConnection.setRequestProperty("RANGE", sProperty);
            System.out.println(sProperty);
            InputStream input = httpConnection.getInputStream();
            byte[] b = new byte[1024];
            while ((nRead = input.read(b, 0, 1024)) > 0
                    && nStartPos < nEndPos) {
                oSavedFile.write(b, 0, nRead);
                nStartPos += nRead;
            }
            this.errCode = "1";
            this.errDesc = this.relativeDir + "/" + this.fileName;
            httpConnection.disconnect();
        } catch (Exception e) {
            logger.error("文件上传出现异常:",e);
            e.printStackTrace();
            this.errCode = "0";
            this.errDesc = e.getMessage();
            System.out.print(this.errDesc);
        }
    }

    private boolean checkUrl(String url){
        List<String> legalUrls = new ArrayList<String>();
        logger.info("当前url："+url+"；合法路径："+String.valueOf(PropertyHelper.getContextProperty("legal.url")));
        Collections.addAll(legalUrls, String.valueOf(PropertyHelper.getContextProperty("legal.url")).split(","));
        for (String legalUrl : legalUrls)
        {
            if (url.contains(legalUrl))
                return true;
        }
        return false;
    }

    private boolean checkFileType(String extension){
        List<String> illegalFileTypes = new ArrayList<String>();
        Collections.addAll(illegalFileTypes, String.valueOf(PropertyHelper.getContextProperty("legal.file.type")).split(","));

        return illegalFileTypes.contains(extension);
    }

    //  获得文件长度
    private long getFileSize(String fileUrl) {
        int nFileLength = -1;
        try {
            URL url = new URL(fileUrl);
            HttpURLConnection httpConnection = (HttpURLConnection) url
                    .openConnection();
            httpConnection.setRequestProperty("User-Agent", "Internet Explorer");

            int responseCode = httpConnection.getResponseCode();
            if (responseCode >= 400) {
                System.err.println("Error Code : " + responseCode);
                return -2; // -2 represent access is error
            }
            String sHeader;
            for (int i = 1; ; i++) {
                sHeader = httpConnection.getHeaderFieldKey(i);
                if (sHeader != null) {
                    if (sHeader.equals("Content-Length")) {
                        nFileLength = Integer.parseInt(httpConnection
                                .getHeaderField(sHeader));
                        break;
                    }
                } else
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(nFileLength);
        return nFileLength;
    }

//    public class ResultMessage {
//        private String errCode;
//        private String errDesc;
//
//        public String getErrDesc() {
//            return errDesc;
//        }
//
//        public void setErrDesc(String errDesc) {
//            this.errDesc = errDesc;
//        }
//
//        public String getErrCode() {
//            return errCode;
//        }
//
//        public void setErrCode(String errCode) {
//            this.errCode = errCode;
//        }
//    }
}
