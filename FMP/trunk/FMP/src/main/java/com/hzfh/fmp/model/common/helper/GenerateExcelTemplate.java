package com.hzfh.fmp.model.common.helper;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class GenerateExcelTemplate<T> {
	private List<T> lists;

    private  List<List<T>> listss;

	public GenerateExcelTemplate(List<T> lists) {
		super();
		this.lists = lists;
	}
    public GenerateExcelTemplate(List<List<T>> listss,int a) {
        super();
        this.listss = listss;
    }

	public void generateExcel(OutputStream out,XLSCallBack<T> xlscaCallBack)throws RuntimeException, IOException{
        HSSFWorkbook workbook=new HSSFWorkbook();
        //create a sheet with specified name
        HSSFSheet sheet= workbook.createSheet(xlscaCallBack.getSheetName());

        for (int i = 0; i < xlscaCallBack.getColumnWidth().length; i++) {
            sheet.setColumnWidth(i, xlscaCallBack.getColumnWidth()[i]*256);
        }

        //create a title for sheet title
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, xlscaCallBack.getHeaders().length-1));

        HSSFCellStyle titleCellStyle=workbook.createCellStyle();//create titleCellStyle for cell
        titleCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFFont titleFont=workbook.createFont();//set font
        titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        titleFont.setFontName("宋体");
        titleFont.setFontHeight((short)(240));
        titleFont.setColor(HSSFColor.AUTOMATIC.index);
        titleCellStyle.setFont(titleFont);
        titleCellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//set border
        titleCellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        titleCellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        titleCellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        titleCellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);//set background
        titleCellStyle.setFillForegroundColor(HSSFColor.LIGHT_BLUE.index);
        titleCellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        titleCellStyle.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);

        HSSFRow title=sheet.createRow(0);
        title.setHeight((short)300);
        for (int i = 0; i < xlscaCallBack.getHeaders().length; i++) {//create tytle for title
            HSSFCell cell=title.createCell(i);
            cell.setCellValue(xlscaCallBack.getTitle());
            cell.setCellStyle(titleCellStyle);
        }

        HSSFCellStyle headerCellStyle=workbook.createCellStyle();//create headerCellStyle for cell
        headerCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFFont headerFont=workbook.createFont();//set font
        headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerFont.setFontName("幼圆");
        headerFont.setColor(HSSFColor.AUTOMATIC.index);
        headerCellStyle.setFont(headerFont);
        headerCellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//set border
        headerCellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        headerCellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        headerCellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        headerCellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);//set background
        headerCellStyle.setFillForegroundColor(HSSFColor.LIGHT_BLUE.index);
        headerCellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        headerCellStyle.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);


        HSSFRow header=sheet.createRow(1);
        for (int i = 0; i < xlscaCallBack.getHeaders().length; i++) {//create tytle for header
            HSSFCell cell=header.createCell(i);
            cell.setCellValue(xlscaCallBack.getHeaders()[i]);
            cell.setCellStyle(headerCellStyle);
        }


        HSSFCellStyle rowCellStyle=workbook.createCellStyle();//create headerCellStyle for cell
        rowCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFFont rowFont=workbook.createFont();//set font
        rowFont.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        rowFont.setFontName("幼圆");
        rowFont.setColor(HSSFColor.AUTOMATIC.index);
        rowCellStyle.setFont(rowFont);
        rowCellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//set border
        rowCellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        rowCellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        rowCellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);

        for (int i = 0; i < lists.size(); i++) {
            HSSFRow row =sheet.createRow(i+2);
            String values[]=xlscaCallBack.getValue(lists.get(i));
            for (int j = 0; j < values.length; j++) {
                HSSFCell cell=row.createCell(j);
                cell.setCellValue(values[j]);
                cell.setCellStyle(rowCellStyle);
            }
        }

        HSSFCellStyle bottomCellStyle=workbook.createCellStyle();//create titleCellStyle for cell
        bottomCellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
        HSSFFont bottomFont=workbook.createFont();//set font
        bottomFont.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        bottomFont.setFontName("幼圆");
        bottomFont.setColor(HSSFColor.AUTOMATIC.index);
        bottomCellStyle.setFont(bottomFont);
        bottomCellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//set border
        bottomCellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        bottomCellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        bottomCellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        bottomCellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);//set background
        bottomCellStyle.setFillForegroundColor(HSSFColor.LIGHT_BLUE.index);
        bottomCellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        bottomCellStyle.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);

        sheet.addMergedRegion(new CellRangeAddress(lists.size()+2, lists.size()+2, 0, xlscaCallBack.getHeaders().length-1));//creaet bootom for xls
        HSSFRow bottomRow =sheet.createRow(lists.size()+2);
        for (int i = 0; i < xlscaCallBack.getHeaders().length; i++) {//create tytle for title
            HSSFCell cell=bottomRow.createCell(i);
            SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            cell.setCellValue("共计导出   "+lists.size()+"  条记录 ,导出日期:"+sf.format(new Date()));
            cell.setCellStyle(bottomCellStyle);
        }

        try {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("create Excel failed due to some unkonw reasion~");
        }

    }
    public void generateExcel(OutputStream out,List<XLSCallBack> xlscaCallBackList)throws RuntimeException, IOException{
        HSSFWorkbook workbook=new HSSFWorkbook();
        //create a sheet with specified name
        HSSFCellStyle titleCellStyle=workbook.createCellStyle();//create titleCellStyle for cell
        titleCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFFont titleFont=workbook.createFont();//set font
        titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        titleFont.setFontName("宋体");
        titleFont.setFontHeight((short)(240));
        titleFont.setColor(HSSFColor.AUTOMATIC.index);
        titleCellStyle.setFont(titleFont);
        titleCellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//set border
        titleCellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        titleCellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        titleCellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        titleCellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);//set background
        titleCellStyle.setFillForegroundColor(HSSFColor.LIGHT_BLUE.index);
        titleCellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        titleCellStyle.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
        HSSFCellStyle headerCellStyle=workbook.createCellStyle();//create headerCellStyle for cell
        headerCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFFont headerFont=workbook.createFont();//set font
        headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerFont.setFontName("幼圆");
        headerFont.setColor(HSSFColor.AUTOMATIC.index);
        headerCellStyle.setFont(headerFont);
        headerCellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//set border
        headerCellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        headerCellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        headerCellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        headerCellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);//set background
        headerCellStyle.setFillForegroundColor(HSSFColor.LIGHT_BLUE.index);
        headerCellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        headerCellStyle.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
        HSSFCellStyle rowCellStyle=workbook.createCellStyle();//create headerCellStyle for cell
        rowCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFFont rowFont=workbook.createFont();//set font
        rowFont.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        rowFont.setFontName("幼圆");
        rowFont.setColor(HSSFColor.AUTOMATIC.index);
        rowCellStyle.setFont(rowFont);
        rowCellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//set border
        rowCellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        rowCellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        rowCellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        HSSFCellStyle bottomCellStyle=workbook.createCellStyle();//create titleCellStyle for cell
        bottomCellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
        HSSFFont bottomFont=workbook.createFont();//set font
        bottomFont.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        bottomFont.setFontName("幼圆");
        bottomFont.setColor(HSSFColor.AUTOMATIC.index);
        bottomCellStyle.setFont(bottomFont);
        bottomCellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//set border
        bottomCellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        bottomCellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        bottomCellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        bottomCellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);//set background
        bottomCellStyle.setFillForegroundColor(HSSFColor.LIGHT_BLUE.index);
        bottomCellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        bottomCellStyle.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);

        for(int a = 0;a<=xlscaCallBackList.size()-1;a++){
            XLSCallBack  xlscaCallBack = xlscaCallBackList.get(a);
            HSSFSheet sheet= workbook.createSheet(xlscaCallBack.getSheetName());
            for (int i = 0; i < xlscaCallBack.getColumnWidth().length; i++) {
                sheet.setColumnWidth(i, xlscaCallBack.getColumnWidth()[i]*256);
            }
            //create a title for sheet title
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, xlscaCallBack.getHeaders().length-1));
            HSSFRow title=sheet.createRow(0);
            title.setHeight((short)300);
            for (int i = 0; i < xlscaCallBack.getHeaders().length; i++) {//create tytle for title
                HSSFCell cell=title.createCell(i);
                cell.setCellValue(xlscaCallBack.getTitle());
                cell.setCellStyle(titleCellStyle);
            }
            HSSFRow header=sheet.createRow(1);
            for (int i = 0; i < xlscaCallBack.getHeaders().length; i++) {//create tytle for header
                HSSFCell cell=header.createCell(i);
                cell.setCellValue(xlscaCallBack.getHeaders()[i]);
                cell.setCellStyle(headerCellStyle);
            }
            List<T> list = new ArrayList<T>();
            list = listss.get(a);
            for (int i = 0; i < list.size(); i++) {
                HSSFRow row =sheet.createRow(i+2);
                String values[] = {};
                values = xlscaCallBack.getValue(list.get(i));
                for (int j = 0; j < values.length; j++) {
                    HSSFCell cell=row.createCell(j);
                    cell.setCellValue(values[j]);
                    cell.setCellStyle(rowCellStyle);
                }
            }
            sheet.addMergedRegion(new CellRangeAddress(list.size()+2, list.size()+2, 0, xlscaCallBack.getHeaders().length-1));//creaet bootom for xls
            HSSFRow bottomRow =sheet.createRow(list.size()+2);
            for (int i = 0; i < xlscaCallBack.getHeaders().length; i++) {//create tytle for title
                HSSFCell cell=bottomRow.createCell(i);
                SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                cell.setCellValue("共计导出   "+list.size()+"  条记录 ,导出日期:"+sf.format(new Date()));
                cell.setCellStyle(bottomCellStyle);
            }
        }

    try {
          workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("create Excel failed due to some unkonw reasion~");
        }

    }
	public	static interface XLSCallBack<T>{
		public String[] getHeaders()throws RuntimeException;
		public String[] getValue(T t)throws RuntimeException;
		public String getTitle()throws RuntimeException;
		public String getSheetName()throws RuntimeException;
		public int[] getColumnWidth() throws RuntimeException;
        //public void getCondition();

	}

}
