/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.Monitor.FleetAdmin.Assets;

import java.io.File;

import java.io.FileInputStream;

import KeywordDrivenTestFramework.Core.BaseClass;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author ZiyandaP
 */
public class ReadExcelData extends BaseClass{
    public static void main(String args[]) throws IOException{
        
        File theFile = new File("C:\\Users\\ZiyandaP\\Downloads\\Assets_2018_03_13_14_44_40.xlsx");
        
       
        FileInputStream inputStream = new FileInputStream(theFile);
        
        XSSFWorkbook workbookObj = new XSSFWorkbook(inputStream);
        //String data = null;
        
        //workbookObj.getSheet(data);
        
        XSSFSheet sheet1 = workbookObj.getSheet("Data");
        
        int rowCount = sheet1.getLastRowNum()-sheet1.getFirstRowNum(); //Get number of rows.
        
        for (int i = 0; i < rowCount; i++) {

            Row row = sheet1.getRow(i);       

            for (int j = 0; j < row.getLastCellNum(); j++) {

                System.out.print(row.getCell(j).getStringCellValue()+"|| ");

            }

        System.out.println();
       
    }        
        
        //String data0 = sheet1.getRow(0).getCell(0).getStringCellValue(); //prints single cell value
        
       //System.out.println("Data from Excel is " +data0);
      /** 
       String [] arrayHeadings = {"Asset description","Registration number"};
      // boolean Testing  = SeleniumDriverInstance.ValidateExcelTableHeaders("C:\\Users\\ZiyandaP\\Downloads\\Assets_2018_03_13_14_44_40.xlsx", "Data", arrayHeadings);
       if(!SeleniumDriverInstance.ValidateExcelTableHeaders("C:\\Users\\ZiyandaP\\Downloads\\Assets_2018_03_13_14_44_40.xlsx", "Data", arrayHeadings)){
            System.out.println("INVALID");
       }
       else{
           System.out.println("VALID");
       }
       */       
    
    }
}
//    public boolean isFileDownloaded(){
//        boolean result = new File("C:/Users/" + System.getProperty("user.name") + "/Downloads/Assets_"+newDate+".xlsx").isFile();
//        if(result==false){
//            return result;
//        }
//        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully downloaded file -", false);      
//        counter++;    
//        return result;
//        
//    }

      // private boolean isFileDownloaded(String downloadPath, String fileName){
           
//        File dir = new File(downloadPath);
//	File[] dir_contents = dir.listFiles();
//    
    //    for (int i = 0; i < dir_contents.length; i++) {
    //	        if (!dir_contents[i].getName().equals(fileName))
    //	            return false;
    //	        }
    //              
    //          SeleniumDriverInstance.takeScreenShot(counter + "- File downloaded successfully -", false);
    //            System.out.println("File Downloaded babe!!");
     //        return true;
    // } 