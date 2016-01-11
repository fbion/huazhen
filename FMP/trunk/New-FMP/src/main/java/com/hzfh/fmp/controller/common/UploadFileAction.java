package com.hzfh.fmp.controller.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hzfh.fmp.model.common.helper.ImageUtils;
import com.hzfh.fmp.model.common.properties.ParamHelper;
import com.hzfh.fmp.model.common.properties.WebInfoHelper;
import com.hzframework.helper.HttpHelper;
import com.hzframework.helper.StringHelper;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UploadFileAction extends ActionSupport {
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
    
    private String weiXinPhoto;

    public String getWeiXinPhoto() {
		return weiXinPhoto;
	}

	public void setWeiXinPhoto(String weiXinPhoto) {
		this.weiXinPhoto = weiXinPhoto;
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
                String fileNameWinXin = "";
                System.out.println("this.weiXinPhoto"+this.weiXinPhoto);

                File uploadFile = new File(fileDir, fileName);
                if (!uploadFile.getParentFile().exists()) {
                    uploadFile.getParentFile().mkdirs();
                }
                FileUtils.copyFile(this.file, uploadFile);
                
                System.out.println("fileNameWinXin"+fileNameWinXin);
//                if(!StringHelper.isNullOrEmpty(fileNameWinXin)){
//                	ImageUtils.scale2(WebInfoHelper.WEB_FMP_UPLOAD + relativeDir + "/" + fileName, WebInfoHelper.WEB_FMP_UPLOAD + relativeDir + "/" + fileNameWinXin, 91, 65, true);
//                	System.out.println("WebInfoHelper.WEB_FMP_UPLOAD + relativeDir + \"/\" + fileName"+WebInfoHelper.WEB_FMP_UPLOAD + relativeDir + "/" + fileName);
//                }
//              if(StringHelper.isNullOrEmpty(fileNameWinXin)){
              	in.close();
//              }
//                if(!StringHelper.isNullOrEmpty(fileNameWinXin)){
//                	File uploadFile2 = new File(fileDir, fileNameWinXin);
//                    if (!uploadFile2.getParentFile().exists()) {
//                    	uploadFile2.getParentFile().mkdirs();
//                    }
//                    FileUtils.copyFile(this.file, uploadFile2);
//                    in.close();
//                    message = WebInfoHelper.WEB_FMP_UPLOAD + relativeDir + "/" + fileNameWinXin;
//                    //
//                    HashMap map2 = new HashMap();
//                    map2.put("fileUrl", URLEncoder.encode(message, "utf-8"));
//                    map2.put("fileName", URLEncoder.encode(fileNameWinXin, "utf-8"));
//                    map2.put("relativeDir", relativeDir);
//
//                    String result2 = HttpHelper.doPost(WebInfoHelper.WEB_UPLOAD_ACTION, map2);
//                    Object object2 = JSON.parseObject(result2);
//                    JSONObject resultMessage2 = (JSONObject) object2;
//                    if (String.valueOf(resultMessage2.get("errCode")).equals("1")) {
//                        message = WebInfoHelper.WEB_UPLOAD + String.valueOf(resultMessage2.get("errDesc"));
//                        relativePath = relativeDir + "/" + fileNameWinXin;
//                    } else {
//                        message = "0";
//                        relativePath = String.valueOf(resultMessage2.get("errDesc"));
//                    }
//                }
                
                message = WebInfoHelper.WEB_FMP_UPLOAD + relativeDir + "/" + fileName;
                //
                HashMap map = new HashMap();
                map.put("fileUrl", URLEncoder.encode(message, "utf-8"));
                map.put("fileName", URLEncoder.encode(fileName, "utf-8"));
                map.put("relativeDir", relativeDir);

                String result = HttpHelper.doPost(WebInfoHelper.WEB_UPLOAD_ACTION, map);
                Object object = JSON.parseObject(result);
                JSONObject resultMessage = (JSONObject) object;
                
                if(!StringHelper.isNullOrEmpty(this.weiXinPhoto) && this.weiXinPhoto.equals("1")){
                	
                	if(fileName!=null){
        				String[] value = fileName.split("\\.");
        				fileNameWinXin = fileName.replace("."+value[value.length-1], "_weixin."+value[value.length-1]);
        			}
                	
                    saveImage(WebInfoHelper.WEB_FMP_UPLOAD + relativeDir + "/" + fileName,fileNameWinXin);
                    File file2 = new File("D:\\"+fileNameWinXin);
                    InputStream in2 = new FileInputStream(file2);
                    File uploadFile2 = new File(fileDir, fileNameWinXin);
                    if (!uploadFile2.getParentFile().exists()) {
                    	uploadFile2.getParentFile().mkdirs();
                    }
                    FileUtils.copyFile(file2, uploadFile2);
                    in2.close();
                    HashMap map2 = new HashMap();
                    map2.put("fileUrl", URLEncoder.encode(WebInfoHelper.WEB_FMP_UPLOAD + relativeDir + "/" + fileNameWinXin, "utf-8"));
                    map2.put("fileName", URLEncoder.encode(fileNameWinXin, "utf-8"));
                    map2.put("relativeDir", relativeDir);

                    HttpHelper.doPost(WebInfoHelper.WEB_UPLOAD_ACTION, map2);
                    deleteTempPhoto(fileNameWinXin);
                }
                
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
            } catch (IOException e) {
                e.printStackTrace();
                message = "0";
                relativePath = e.toString();
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
    /**/
    public static  InputStream getInputStream(String dir){  
        InputStream inputStream=null;  
        HttpURLConnection httpURLConnection=null;  
        try{  
            URL url=new URL(dir);  
            if(url!=null){  
                httpURLConnection=(HttpURLConnection) url.openConnection();  
                httpURLConnection.setConnectTimeout(3000);  
                httpURLConnection.setRequestMethod("GET");  
                int responseCode=httpURLConnection.getResponseCode();  
                if(responseCode==200){  
                    inputStream=httpURLConnection.getInputStream();  
                }  
            }  
              
              
        }catch(Exception e){  
            e.printStackTrace();  
        }  
      
          
          
        return inputStream;  
          
    }  
      
    public static void saveImage(String dir,String fileNameWinXin){  
        InputStream inputStream=getInputStream(dir);  
        FileOutputStream fileOutputStream=null;  
        byte[] data=new byte[1024];  
        int len=0;  
        try{  
        fileOutputStream=new FileOutputStream("D:\\"+fileNameWinXin.replace(".", "_temp."));  
        while((len=inputStream.read(data))!=-1){  
        fileOutputStream.write(data,0,len);   
              
        }  
          
        }catch(Exception e){  
            e.printStackTrace();  
        }finally{  
            try {  
                inputStream.close();  
                fileOutputStream.close();
                
            	ImageUtils.scale2("D:\\"+fileNameWinXin.replace(".", "_temp."), "D:\\"+fileNameWinXin, 98, 70, true);
            	
            	deleteTempPhoto(fileNameWinXin.replace(".", "_temp."));

            } catch (IOException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
          
    }
    public static void deleteTempPhoto(String name){
    	File f = new File("D:\\"+name); // 输入要删除的文件位置
		if(f.exists())
		f.delete();
    }
    public static void main(String[] args) {
//    	try {
    		saveImage("http://fmp.hzfh.dev/temp/2015/12/4/20151204135622931_456.png","20151204135622931_456_weixin.png");
    		
//			String http =HttpHelper.doPost("http://fmp.hzfh.dev/temp/2015/12/4/20151204135622931_456.png");
//			System.out.println(http);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//    	ImageUtils.scale2("http://fmp.hzfh.dev/temp/2015/12/4/20151204135622931_456.png", "http://fmp.hzfh.dev/temp/2015/12/4/20151204135622931_456_weixin.png", 91, 65, true);
	}
}
