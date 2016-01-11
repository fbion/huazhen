package com.hzfh.fmp.controller.baseInfo.ajax;

import com.hzfh.api.sales.model.Creditor;
import com.hzfh.fmp.model.common.helper.UrlHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.sales.CreditorModel;
import com.sun.net.httpserver.Authenticator;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/10/15.
 */
public class AjaxImportData{
    private String type;
    private String filePath;
    private String  desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String execute() throws Exception{
        if(Integer.parseInt(this.type)==1){
            importCreditor(UrlHelper.buildUploadSiteUrl(this.filePath));
        }
        return "success";
    }
    private String importCreditor(String path) throws IOException {
        URL url = new URL(path);
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);
        Creditor xlsDto = null;
        // 循环工作表Sheet
        HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
        hssfSheet.getColumnBreaks();
        // 循环行Row
        HSSFRow headRow = hssfSheet.getRow(0);
        if (!getValue(headRow.getCell(0)).equals("project_name") || !getValue(headRow.getCell(1)).equals("room_number")
                || !getValue(headRow.getCell(2)).equals("total_money") || !getValue(headRow.getCell(3)).equals("remain_amount")
                || !getValue(headRow.getCell(4)).equals("product_no")) {
            this.setDesc("表格格式不正确");
            return "success";
        }else {
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow == null) {
                    continue;
                }
                xlsDto = new Creditor();
                try{
                    xlsDto.setProjectName(hssfRow.getCell(0) == null ? "" : getValue(hssfRow.getCell(0)));
                    xlsDto.setRoomNumber(hssfRow.getCell(1) == null ? "" : getValue(hssfRow.getCell(1)));
                    xlsDto.setTotalMoney(Double.parseDouble(hssfRow.getCell(2) == null ? "" : getValue(hssfRow.getCell(2))));
                    xlsDto.setRemainAmount(Double.parseDouble(hssfRow.getCell(3) == null ? "" : getValue(hssfRow.getCell(3))));
                    xlsDto.setInUserNo(UserHelper.getUserCache().getUserId());
                    xlsDto.setProductNo(Integer.parseInt(hssfRow.getCell(4) == null ? "" : getValue(hssfRow.getCell(4))));
                }catch (Exception e){
                    this.setDesc("数据错误");
                    return "success";
                }

                CreditorModel.add(xlsDto);
            }
            this.setDesc("导入成功");
            return "success";
        }
    }
    @SuppressWarnings("static-access")
    private String getValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            // 返回布尔类型的值
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            // 返回数值类型的值
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            // 返回字符串类型的值
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }

}
