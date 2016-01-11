import com.hzfh.api.sales.model.Creditor;
import org.apache.poi.hssf.model.Workbook;
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
 * Created by Administrator on 2015/10/14.
 */


public class XlsMain {

    public static void main(String[] args) throws IOException {
        XlsMain xlsMain = new XlsMain();

//        URL url = new URL("http://upload.hzfh.dev/files/2015/10/15/20151015102745668_crm.xls");
//        URLConnection urlConnection = url.openConnection();
//        InputStream inputStream = urlConnection.getInputStream();
        Creditor xls = null;
        List<Creditor> list = null;
//        HSSFWorkbook wb = null;
        try {
            list = xlsMain.readXls("http://upload.hzfh.dev/files/2015/10/15/20151015114309527_t.xls");
        }catch (Exception e){
            System.out.print("文件读取异常");
        }

        for (int i = 0; i < list.size(); i++) {
            xls = (Creditor) list.get(i);
            System.out.println(xls.getProjectName() + "    " + xls.getRoomNumber() + "    "
                    + xls.getRemainAmount() + "    " + xls.getTotalMoney() + "    "
                    + xls.getProductNo());
        }


    }
    /**
     * 读取xls文件内容
     *
     * @return List<XlsDto>对象
     * @throws IOException 输入/输出(i/o)异常
     */
    private List<Creditor> readXls(String path) throws IOException {
        URL url = new URL(path);
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);
        Creditor xlsDto = null;
        List<Creditor> list = new ArrayList<Creditor>();
        // 循环工作表Sheet
        HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
        hssfSheet.getColumnBreaks();
        // 循环行Row
        HSSFRow headRow = hssfSheet.getRow(0);
        if (!getValue(headRow.getCell(0)).equals("project_name") || !getValue(headRow.getCell(1)).equals("room_number")
                || !getValue(headRow.getCell(2)).equals("total_money") || !getValue(headRow.getCell(3)).equals("remain_amount")
                || !getValue(headRow.getCell(4)).equals("in_user_no") || !getValue(headRow.getCell(5)).equals("product_no")) {
            System.out.println("表格格式不正确");
        }else {
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow == null) {
                    continue;
                }
                xlsDto = new Creditor();
                xlsDto.setProjectName(hssfRow.getCell(0) == null ? "" : getValue(hssfRow.getCell(0)));
                xlsDto.setRoomNumber(hssfRow.getCell(1) == null ? "" : getValue(hssfRow.getCell(1)));
                xlsDto.setTotalMoney(Double.parseDouble(hssfRow.getCell(2) == null ? "" : getValue(hssfRow.getCell(2))));
                xlsDto.setRemainAmount(Double.parseDouble(hssfRow.getCell(3) == null ? "" : getValue(hssfRow.getCell(3))));
                //xlsDto.setInUserNo(Integer.parseInt(hssfRow.getCell(4) == null ? "" : getValue(hssfRow.getCell(4))));
                xlsDto.setProductNo(Integer.parseInt(hssfRow.getCell(5) == null ? "" : getValue(hssfRow.getCell(5))));
//                list.add(xlsDto);
            }
        }
        return list;
    }
    /**
     * 得到Excel表中的值
     *
     * @param hssfCell Excel中的每一个格子
     * @return Excel中每一个格子中的值
     */
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
