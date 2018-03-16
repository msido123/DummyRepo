/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.Monitor.FleetAdmin.Assets;

import KeywordDrivenTestFramework.Core.BaseClass;
import static KeywordDrivenTestFramework.Core.BaseClass.SeleniumDriverInstance;
import static KeywordDrivenTestFramework.Core.BaseClass.narrator;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
import static KeywordDrivenTestFramework.Monitor.FleetAdmin.Assets.SimpleExcelReaderExample.readExcel;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;

/**
 *
 * @author ZiyandaP
 */
public class VerifyingDownloadedExcelFiles extends BaseClass{
    int counter = 1;
    String errorMsg;
    TestEntity testData;
    private File download;
    private static final DateFormat dateObj = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
    String newDate;
    
     
public VerifyingDownloadedExcelFiles(TestEntity testData){

    this.testData =  testData;
}

public TestResult executeTest() throws InterruptedException, IOException {
    
    this.setStartTime();
    removePreviousImports();
    if(!navigateToMonitorTab()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Monitor Tab", true);
        counter++;
        narrator.failedMessage("Failed to click on Manage Tab - "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Monitor Tab", this.getTotalExecutionTime());
    }
    pause(2000);
    if(!navigateToAssets()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on the Assets ", true);
        counter++;
        narrator.failedMessage("Failed to click on the Libraries Tab - "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the Assets Tab", this.getTotalExecutionTime());
    }
    pause(2000);
    if(!isDownloadTemplateClicked()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Download import template ", true);
        counter++;
        narrator.failedMessage("Failed to click on the Download import template - "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Download import template", this.getTotalExecutionTime());
    }            
    pause(2000);
    if(!isUpdateExistingRecordsClicked()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on the Update Existing Records ", true);
        counter++;
        narrator.failedMessage("Failed to click on the Update Existing Records - "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the Update Existing Records", this.getTotalExecutionTime());
    }            
    pause(2000);
    if(!isDownloadButtonClicked()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Download ", true);
        counter++;
        narrator.failedMessage("Failed to click on Download- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Download", this.getTotalExecutionTime());
    }
    if(!CheckFileExists())
        {
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to confirm downloaded file exists", true);
        counter++;
        narrator.failedMessage("confirm downloaded file exists - "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "confirm downloaded file exists", this.getTotalExecutionTime());
        }    
    pause(2000);
    if(!verifyingExcelData()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to check if specified Headings are there ", true);
        counter++;
        narrator.failedMessage("Failed to check if specified Headings are there "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to check if specified Headings are there ", this.getTotalExecutionTime());
    }     
    pause(1000);
    return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully verified Excel Headers.", this.getTotalExecutionTime()); 
} 
    public boolean navigateToMonitorTab(){
        
        if(!SeleniumDriverInstance.waitForElementByXpath("(//A[@href='#'])[1]")) {
            
            errorMsg = "Failed to click on Monitor Tab";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("(//A[@href='#'])[1]");
        SeleniumDriverInstance.takeScreenShot(counter + "- Clicked Monitor tab successfully -", false);
        counter++;
        return true;
    
    }
    public boolean navigateToAssets(){
        
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@ng-href='#/fleet-admin/assets'][text()='Assets']")) {
            
            errorMsg = "Failed to click on Assets";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//A[@ng-href='#/fleet-admin/assets'][text()='Assets']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Clicked on Assets successfully -", false);
        counter++;
        return true;
    
    }
    public boolean isDownloadTemplateClicked(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//I[@class='icon-download-alt']")) {
            
            errorMsg = "Failed to click on Download import template";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//I[@class='icon-download-alt']");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked Download import template -", false);      
        counter++;
        return true;
    }
    public boolean isUpdateExistingRecordsClicked(){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//LABEL[@class='radio'])[3]")) {
            
            errorMsg = "Failed to click on Update Existing Records";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("(//LABEL[@class='radio'])[3]");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked Update Existing Records -", false);      
        counter++;
        return true;
    }
    public boolean isDownloadButtonClicked(){
        removePreviousImports();
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@class='btn btn-success ng-scope'][text()='Download']")) {
            
            errorMsg = "Failed to click on Download ";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("//A[@class='btn btn-success ng-scope'][text()='Download']");
        newDate = dateObj.format(new Date());
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked Downloads -", false);      
        counter++;
        return true;
    }

        public boolean CheckFileExists()
    {
        SeleniumDriverInstance.pause(10000);
        testData.extractParameter("Expected Data", "Name: File name" +  "<br>" + "Notes: Assets_"+newDate+".xlsx", "Pass");
        download = getTheNewestFile("xlsx");
        
        if(download == null)
        {
            errorMsg = "Failed to verify file downloaded";
            testData.extractParameter("Extracted Data", "Name: File name" +  "<br>" + "Notes: No Files exist with this name", "Fail");
            return false;
        }
        if(!download.toString().contains("Assets_"))
        {
            errorMsg = "Failed to verify file downloaded";
            testData.extractParameter("Extracted Data", "Name: File name" +  "<br>" + "Notes: "+ download.getAbsolutePath().substring(0,download.getAbsolutePath().length()-31)+"There is an xlsx file in the directory with an older name", "Fail");
            return false;
        }
        testData.extractParameter("Extracted Data", "Name: File name " +  "<br>" + "Notes: " + download.getAbsolutePath().substring(download.getAbsolutePath().length()-31,download.getAbsolutePath().length()-8), "Pass");
        testData.extractParameter("Extracted Data 2", "Name: File location" +  "<br>" + "Notes: " + download.getAbsolutePath().substring(0,download.getAbsolutePath().length()-31), "Pass");
        SeleniumDriverInstance.takeScreenShot(counter + " - Download file", false);
        counter++;
        return true;
    }
    public File getTheNewestFile(String ext)
    {
        String file = new File("C:/Users/" + System.getProperty("user.name") + "/Downloads/").toString();

        File theNewestFile = null;
        File dir = new File(file);
        FileFilter fileFilter = new WildcardFileFilter("*." + ext);
        File[] files = dir.listFiles(fileFilter);

         if (files.length > 0)
            {
                Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
                theNewestFile = files[0];
            }   
            return theNewestFile;
    
    }

    public boolean verifyingExcelData() throws FileNotFoundException, IOException 
    {
        String FilePath = getTheNewestFile("xlsx").getAbsolutePath(); 
        int l = 50;
        if(FilePath.contains("("))
        {
           l += 4; 
        } 
        String fileName=FilePath;//.substring(FilePath.length()-l,FilePath.length());
        boolean foundThem = false;
        if(readExcel(fileName,"Asset description") && readExcel(fileName,"Registration number")){
            foundThem = true;
        }
        return foundThem;
    }
    public void removePreviousImports(){
        final File folder = new File("C:/Users/" + System.getProperty("user.name") + "/Downloads/");
        final File[] files = folder.listFiles( new FilenameFilter() {
        
        public boolean accept(final File dir,final String name ) {             
             return name.matches( "Assets_2018.*\\.xlsx" );
        }
        } );
        for ( final File file : files ) {
            if ( !file.delete() ) {
                System.err.println( "Can't remove " + file.getAbsolutePath() );
            }
        }   
    }        
}

       
        
