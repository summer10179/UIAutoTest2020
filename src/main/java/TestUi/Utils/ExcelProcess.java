package TestUi.Utils;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelProcess {

    public  Object[][] proessExcel(String filePath,int sheetId)  {

        //      数据流读入excel
        File file= new File(System.getProperty("user.dir")+"C:\\Users\\lsjingjingw\\Desktop\\A陕西稽查");
        FileInputStream fis= null;
        HSSFWorkbook wb =null;
        try {
            fis = new FileInputStream(file);
            wb = new HSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }


        //读取特定表单，并计算行列数
        HSSFSheet sheet=wb.getSheetAt(sheetId);
        int numberOfRow =sheet.getPhysicalNumberOfRows();
        int numberOfCell =sheet.getRow(0).getLastCellNum();

        //将表单数据处理存入dtt对象
        Object[][] dttData=new Object[numberOfRow][numberOfCell];

        for(int i=0;i<numberOfRow;i++){
            if(null==sheet.getRow(i)||"".equals(sheet.getRow(i))){
                continue;
            }
            for(int j=0;j<numberOfCell;j++) {
                if(null==sheet.getRow(i).getCell(j)||"".equals(sheet.getRow(i).getCell(j))){
                    continue;
                }
                HSSFCell cell = sheet.getRow(i).getCell(j);
                cell.setCellType(CellType.STRING);
                dttData[i][j] = cell.getStringCellValue();
            }
        }
        return dttData;
    }
}
