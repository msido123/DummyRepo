/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeyDrivenTestframework.Manage.Libraries.LocationLibrary;

import KeywordDrivenTestFramework.Entities.TestEntity;
import static KeywordDrivenTestFramework.Core.BaseClass.SeleniumDriverInstance;
import java.io.File;
import java.io.FilenameFilter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author PhathuxoloJ
 */
public class DownloadImportTemplateMethods extends DownloadImportTemplate{
    
    public DownloadImportTemplateMethods(TestEntity testData) {
        super(testData);
    }
    private static final DateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
    String date;
    public boolean navigateToLibraries(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@ng-href='#/config-admin/libraries'][text()='Libraries']")){
            errorMessage = "Failed to click on Libraries tab";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//A[@ng-href='#/config-admin/libraries'][text()='Libraries']");
        SeleniumDriverInstance.takeScreenShot("Libraries is clicked successfully ", false);
        counter++;
        return true;
    }
    
    public boolean navigateToLocationLibrary(){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//a[@class='ng-binding'])[text()='Location library']")){
            errorMessage = "Failed to click on Location Library tab";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("(//a[@class='ng-binding'])[text()='Location library']");
        SeleniumDriverInstance.takeScreenShot("Library tab is clicked successfully ", false);
        counter++;
        return true;
    }
    
    public boolean clickOnDownloadButton(){
        removePreviousImports();
        if(!SeleniumDriverInstance.waitForElementByXpath("//I[@class='icon-download-alt']")){
            errorMessage = "Failed to click on Download button";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//I[@class='icon-download-alt']");
        date = sdf.format(new Date());
        SeleniumDriverInstance.takeScreenShot("Download button is clicked successfully ", false);
        counter++;
        return true;
    }
    
    public boolean isFileDownloaded(){
        boolean result = new File("C:/Users/" + System.getProperty("user.name") + "/Downloads/LibraryLocations_"+date+".xlsx").isFile();
        if(result==false){
            return result;
        }
        return result;
        
    }
    
    public void removePreviousImports(){
        final File folder = new File("C:/Users/" + System.getProperty("user.name") + "/Downloads/");
        final File[] files = folder.listFiles( new FilenameFilter() {
        public boolean accept( final File dir,final String name ) {             
             return name.matches( "LibraryLocations_2018.*\\.xlsx" );
        }
        } );
        for ( final File file : files ) {
            if ( !file.delete() ) {
                System.err.println( "Can't remove " + file.getAbsolutePath() );
            }
        }

    }
    public boolean compareHeaders(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//TH[@class='column-heading  first sortable active ui-draggable']")){
            errorMessage = "no xpath for column 1";
            return false;
        }
        if(isFileDownloaded()==false){
            errorMessage = "The file is not downloaded";
            SeleniumDriverInstance.takeScreenShot("the file is not downloaded",false);
            counter++;
            return false;
        }
        String[] columnHeader = {SeleniumDriverInstance.retrieveTextByXpath("//SPAN[@ng-hide='column.headingClass || !column.title'][text()='Availability']")};
        if(!SeleniumDriverInstance.ValidateExcelTableHeaders("LibraryLocations_"+date+".xlsx","Data", columnHeader)){
           errorMessage = "Column headers of the downloaded excel file does not match the grid headings";
           testData.extractParameter("column heading", columnHeader[0], "FAIL");
           SeleniumDriverInstance.takeScreenShot("Column headers of the downloaded excel file does not match the grid headings",false);
           counter++;
           return false;
        }
        testData.extractParameter("File name :","LibraryLocations_"+date+".xlsx", "PASS");
        testData.extractParameter("column heading", columnHeader[0], "PASS");
        SeleniumDriverInstance.takeScreenShot("Column headers of the downloaded excel file matches with the grid headings",false);
        counter++;
        return true;      
    }  
}
