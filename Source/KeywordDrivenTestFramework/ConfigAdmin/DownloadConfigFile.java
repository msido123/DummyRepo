/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.ConfigAdmin;

import KeywordDrivenTestFramework.Core.BaseClass;
import static KeywordDrivenTestFramework.Core.BaseClass.SeleniumDriverInstance;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
/**THE NEXT IMPORTS ARE FOR EXTRACTING DATA FROM THE DOWNLOADED FILE*/
import java.io.File;
import java.io.BufferedReader;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;

/**
 *
 * @author MzuvukileN
 */
public class DownloadConfigFile extends BaseClass{
    String error;
    int counter = 1;
    String extractedData1;
    String extractedData2;
    String extractedData3;
    TestEntity testData;
    
    public DownloadConfigFile(TestEntity testData){
        this.testData = testData;
    }
    
    public TestResult executeTest() throws InterruptedException, FileNotFoundException, IOException{
        this.setStartTime();
        
        if(!clickManage()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on manage.", false);
            counter++;
            narrator.failedMessage("Failed to click on manage - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on manage.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully clicked on Manage.", false);
        counter++;
        
        if(!clickConfigGroup()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on configuration groups.", false);
            counter++;
            narrator.failedMessage("Failed to click on configuration groups - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on configuration groups.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully clicked on configuration groups.", false);
        counter++;
        
        if(!enterFilter()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to entter filter for configuration groups.", false);
            counter++;
            narrator.failedMessage("Failed to entter filter for configuration groups - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to entter filter for configuration groups.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully filtered configuration groups.", false);
        counter++;
        
        if(!selectRadioButton()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to select MiX Live FM Unit.", false);
            counter++;
            narrator.failedMessage("Failed to select MiX Live FM Unit - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to select MiX Live FM Unit.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully selected MiX Live FM Unit.", false);
        counter++;
        
        if(!downloadConfigFile()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to download configuration file.", false);
            counter++;
            narrator.failedMessage("Failed to download configuration file - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to download configuration file.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully downloaded the configuration file.", false);
        counter++;
        
        if(!checkFileSize()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to check file size.", false);
            counter++;
            narrator.failedMessage("Failed to check file size - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to check file size.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully checked the file size.", false);
        counter++;
        
        if(!extractFileData()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to extract data.", false);
            counter++;
            narrator.failedMessage("Failed to extract data - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to extract data.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully extracted data.", false);
        testData.extractParameter("Extracted Data 1 : ", extractedData1, screenshotPath);
        testData.extractParameter("Extracted Data 2 : ", extractedData2, screenshotPath);
        testData.extractParameter("Extracted Data 3 : ", extractedData3, screenshotPath);
        counter++;
        
        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully downloaded configuration file and extracted data.", this.getTotalExecutionTime());
    }
    
    public boolean clickManage(){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//A[@href='#'])[2]")){
            error = "Could not locate manage tab.";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("(//A[@href='#'])[2]");
        return true;
    }
    
    public boolean clickConfigGroup(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@ng-href='#/config-admin/configuration-groups'][text()='Configuration groups']")){
            error = "Could not locate configurations goup button.";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//A[@ng-href='#/config-admin/configuration-groups'][text()='Configuration groups']");
        return true;
    }
    
    public boolean enterFilter(){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[1]")){
            error = "Could not locate filter tab.";
            return false;
        }
        SeleniumDriverInstance.enterTextByXpath("(//INPUT[@type='text'])[1]", "MiX Live FM Unit");
        pause(1000);
        return true;
    }
    
    public boolean selectRadioButton(){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='radio'])[1]")){
            error = "Could not select radio button.";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("(//INPUT[@type='radio'])[1]");
        return true;
    }
    
    public boolean downloadConfigFile(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@class='row-action']")){
            error = "Could not download config file.";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//A[@class='row-action']");
        pause(1000);
        SeleniumDriverInstance.clickElementByXpath("//SPAN[text()='Download config file']");
        pause(500);
        return true;
    }
    
    public boolean checkFileSize(){
        File downloadedFile = getTheNewestFile("txt");
        if(downloadedFile.exists() && downloadedFile.length() > 0){
            return true;
        }
        return false;
    }
    
    private File getTheNewestFile(String ext){
        String file = new File("C:/Users/" + System.getProperty("user.name") + "/Downloads/").toString();

        File theNewestFile = null;
        File dir = new File(file);
        FileFilter fileFilter = new WildcardFileFilter("*." + ext);
        File[] files = dir.listFiles(fileFilter);

        if (files.length > 0){
            /**
             * The newest file comes first *
             */
            Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
            theNewestFile = files[0];
        }
        return theNewestFile;
    }
    
    public boolean extractFileData() throws FileNotFoundException, IOException{
        boolean truth = false;
        BufferedReader fileLink = null;
        File fileName = null;
        try{
            fileName = getTheNewestFile("txt");
            Scanner scanner = new Scanner(fileName);
            //fileLink = new BufferedReader(fileName);
            String currentLine;
            int linesFound = 0;
            while((currentLine = scanner.nextLine()) != null){
                if(currentLine.contains("Asset Description")){
                    extractedData1 = currentLine;
                    linesFound++;
                }else if(currentLine.contains("Vehicle ID ")){
                    extractedData2 = currentLine;
                    linesFound++;
                }else if(currentLine.contains("Configuration Group")){
                    extractedData3 = currentLine;
                    linesFound++;
                }else if(linesFound == 3){
                    truth = true;
                    break;
                }
            }
        }catch(IOException exception){
            //NOT SURE WHAT TO DO HERE YET
        }finally {
            if (fileLink != null)
                fileLink.close();
	}
        
        return truth;
    }
}
