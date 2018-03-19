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
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
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
public class ExcelReference extends BaseClass
{
    String errorMessage;
    int counter;
    Date date;
    DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
    private TestEntity testData;
    private File download;
    private String DriverExceptionDetail;
    public ExcelReference(TestEntity testData)
    {
        this.testData = testData;
    }
    public TestResult executeTest() throws FileNotFoundException, InterruptedException, IOException
    {
        this.setStartTime();
        EmptyDownloads();
        if(!ClickMonitorTab())
        {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click Monitor tab", true);
            counter++;
            narrator.failedMessage("Click Monitor - "+ errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Click Monitor", this.getTotalExecutionTime());
        }
        if(!ClickAssetTab())
        {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click Assets tab", true);
            counter++;
            narrator.failedMessage("Navigation to Assets tab - "+ errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Navigation to Assets tab", this.getTotalExecutionTime());
        }
        if(!DownloadImportTemplate())
        {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click Download Import Template button", true);
            counter++;
            narrator.failedMessage("Navigation to Download Import Template button - "+ errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Navigation to Download Import Template button", this.getTotalExecutionTime());
        }
        if(!UpdateExistingRecordsRadio())
        {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click Update Existing Records Radio", true);
            counter++;
            narrator.failedMessage("Navigation to Update Existing Records Radio - "+ errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Navigation to Update Existing Records Radio", this.getTotalExecutionTime());
        }
        if(!Download())
        {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click Download button", true);
            counter++;
            narrator.failedMessage("Navigation to Download button - "+ errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Navigation to Download button", this.getTotalExecutionTime());
        }
        if(!CheckFileExists())
        {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to confirm downloaded file exists", true);
            counter++;
            narrator.failedMessage("confirm downloaded file exists - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "confirm downloaded file exists", this.getTotalExecutionTime());
        }
        if (!CheckFileColumnHeaders())
        {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to confirm column header exists", true);
            counter++;
            narrator.failedMessage("confirm column header exists - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "confirm column header exists", this.getTotalExecutionTime());
        }   
        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully Navigated and Validated Assets", this.getTotalExecutionTime());
    }
    /**
    * Navigates to Monitor tab.
    *
    * @return True or False
    */
    public boolean ClickMonitorTab()
    {
        if(!SeleniumDriverInstance.waitForElementByXpath(MonitorXpath(),20))
        {
            errorMessage = "Failed to find Monitor Tab";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath(MonitorXpath());
        SeleniumDriverInstance.takeScreenShot(counter + " - Navigation to Monitor Tab", false);
        counter++;
        return true;
    }
    /**
    * Navigates to Asset tab.
    *
    * @return True or False
    */
    public boolean ClickAssetTab()
    {
        if(!SeleniumDriverInstance.waitForElementByXpath(AssetXpath(),20))
        {
            errorMessage = "Failed to find Assets Tab";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath(AssetXpath());
        SeleniumDriverInstance.takeScreenShot(counter + " - Navigation to Assets Tab", false);
        counter++;
        return true;
    }
    /**
    * Navigates to Download Import Template button.
    *
    * @return True or False
    */
    public boolean DownloadImportTemplate()
    {
        if(!SeleniumDriverInstance.waitForElementByXpath(DownloadImportTemplateXpath(),20))
        {
            errorMessage = "Failed to navigate to Download Import Template button";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath(DownloadImportTemplateXpath());
        SeleniumDriverInstance.takeScreenShot(counter + " - Navigation to Download Import Template button", false);
        counter++;
        return true;
    }
    /**
    * Navigates to Update Existing Records Radio.
    *
    * @return True or False
    */
    public boolean UpdateExistingRecordsRadio()
    {
        if(!SeleniumDriverInstance.waitForElementByXpath(UpdateExistingRecordsRadioXpath(),20))
        {
            errorMessage = "Failed to navigate to Update Existing Records Radio";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath(UpdateExistingRecordsRadioXpath());
        SeleniumDriverInstance.takeScreenShot(counter + " - Navigation to Update Existing Records Radio", false);
        counter++;
        return true;
    }
    /**
    * Navigates to Download button.
    * 
    * @return True or False
    */
    public boolean Download()
    {
        if(!SeleniumDriverInstance.waitForElementByXpath(DownloadXpath(),20))
        {
            errorMessage = "Failed to click Download";
            return false;
        }
        date = new Date();
        SeleniumDriverInstance.clickElementByXpath(DownloadXpath());
        SeleniumDriverInstance.takeScreenShot(counter + " - Navigation to Download button", false);
        counter++;
        return true;
    }
    /**
    * This function checks if the downloaded with a specific file name does exists.
    *
    * @return True or False
    */
    public boolean CheckFileExists()
    {
        SeleniumDriverInstance.pause(10000);
        testData.extractParameter("Expected Data", "Name: File name" +  "<br>" + "Notes: Assets_"+dateFormat.format(date) , "Pass");
        download = getTheNewestFile("xlsx");
        
        if(download == null)
        {
            errorMessage = "Failed to verify file downloaded";
            testData.extractParameter("Extracted Data", "Name: File name" +  "<br>" + "Notes: No Files exist with this name", "Fail");
            return false;
        }
        if(!download.toString().contains("Assets_"))
        {
            errorMessage = "Failed to verify file downloaded";
            testData.extractParameter("Extracted Data", "Name: File name" +  "<br>" + "Notes: "+ download.getAbsolutePath().substring(0,download.getAbsolutePath().length()-31)+"There is an xlsx file in the directory with an older name", "Fail");
            return false;
        }
        testData.extractParameter("Extracted Data", "Name: File name " +  "<br>" + "Notes: " + download.getAbsolutePath().substring(download.getAbsolutePath().length()-31,download.getAbsolutePath().length()-8), "Pass");
        testData.extractParameter("Extracted Data 2", "Name: File location" +  "<br>" + "Notes: " + download.getAbsolutePath().substring(0,download.getAbsolutePath().length()-31), "Pass");
        SeleniumDriverInstance.takeScreenShot(counter + " - Download file", false);
        counter++;
        return true;
    }
    /**
    * This function gets the newest file in /Downloads/ by ordering them with last modified date.
    *
     * @param ext
    * @return the latest file
    */
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
    /**
    * This function checks if the Column headers of the Asset Grid matches the one on the Excel file
    * @array Selected headers = {Asset description","Registration number"}
    * @return True or False
    */
    public boolean CheckFileColumnHeaders() throws FileNotFoundException, IOException 
    {
         String FilePath = getTheNewestFile("xlsx").getAbsolutePath(); 
        int l = 50;
        if(FilePath.contains("("))
        {
           l += 4; 
        } 
        String fileName=FilePath.substring(FilePath.length()-l,FilePath.length());
           
        if(SeleniumDriverInstance.ValidateExcelTableContent(fileName, "Data","//*[@id=\"MainView\"]/div[1]/div/div[2]/div[2]/div/div[1]/div/div/div[1]/span[1]"))
        {
            testData.extractParameter("Validating Export Content","Content Match" , "Pass");
        }
        else
        {
            testData.extractParameter("Validating Export Content - ","Content Not Matching" , "Fail");
            return false;
        }
        return true;    
    
    }
    private void EmptyDownloads() 
    {
        String file = new File("C:/Users/" + System.getProperty("user.name") + "/Downloads/").toString();

        File dir = new File(file);
        FileFilter fileFilter = new WildcardFileFilter("*.xlsx");
        File[] files = dir.listFiles(fileFilter);

        if (files.length > 0)
        {
            for(int i=0;i<files.length;i++)
            {
                if(files[i].getName().contains("Assets_"))
                {
                    System.out.println("[INFO] Found file "+files[i].getName()+", deleting it");
                    files[i].delete();
                }    
            }    
        }
    }
    //Xpaths
    public static String MonitorXpath()
    {
        return "//li/a[text()='MONITOR ']";
    }
    public String AssetXpath()
    {
        return "//li/a[text()='Assets']";
    }
    public String DownloadImportTemplateXpath()
    {
        return "//I[@class='icon-download-alt']";
    }
    public String UpdateExistingRecordsRadioXpath()
    {
        return "(//INPUT[@type='radio'])[2]";
    }
    public String DownloadXpath()
    {
        return "//A[@class='btn btn-success ng-scope'][text()='Download']";
    }
}