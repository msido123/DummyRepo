/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.Monitor.FleetAdmin.Assets;

/**
 *
 * @author ZiyandaP
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
/**
 * A dirty simple program that reads an Excel file.
 * @author www.codejava.net
 *
 */
public class SimpleExcelReaderExample {
    public SimpleExcelReaderExample(){
        
    }
    
    public  static boolean readExcel(String excelFilePath, String headers ) throws IOException {
        
//        for(int i = 0; i<x.length; i++){
//            x[i] = 
//        }
        
        boolean found = false;
//        String excelFilePath = "C:\\Users\\ZiyandaP\\Downloads\\Assets_2018_03_16_11_23_20.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
         
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();
         
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
             
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                 
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        if(cell.getStringCellValue().contains(headers)){
                            
                            found = true;
                            return found;
                        }
//                            System.out.print(cell.getStringCellValue());
                        break;
                }
//                System.out.print(" - ");
            }
//            System.out.println();
        }
         
//        workbook.close();
        inputStream.close();
        return found;
    }
    public static void main(String[] args) throws IOException{
        
        String headers [] = {"Asset description","Registration number" };
        for(String element : headers){
            readExcel("C:\\Users\\ZiyandaP\\Downloads\\Assets_2018_03_16_11_23_20.xlsx",element);
        }
        
    }
}
