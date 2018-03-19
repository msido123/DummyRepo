/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeyDrivenTestframework.Monitor.Assets;

import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
import java.awt.AWTException;
import java.io.FileNotFoundException;

/**
 *
 * @author PhathuxoloJ
 */
public class ImportAsset extends BaseClass{
    int counter = 1;
    TestEntity testData;
    String errorMessage;
    
    public ImportAsset(TestEntity testData){
        this.testData = testData;
    }
    
    public TestResult runTest() throws InterruptedException, FileNotFoundException, AWTException{
        this.setStartTime();
        DiagnosticWindowMethods run = new DiagnosticWindowMethods(testData);
        ImportAssetMethods methods = new ImportAssetMethods(testData);
        
        if(!run.navigateToMonitorTab()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Monitor Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Monitor Tab - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click on Monitor Tab",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!run.navigateToAssetsTab()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Assets Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Assets Tab - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click on Assets Tab",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!run.clickFilter()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Filter", true);
            counter++;
            narrator.failedMessage("Failed to click on Filter - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click on Filter",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!run.enterTextToFilter("Training MiX Import Test")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to enter text into filter", true);
            counter++;
            narrator.failedMessage("Failed to enter text into filter - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to enter text into filter",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!run.clickSearchButton()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click search button", true);
            counter++;
            narrator.failedMessage("Failed to click search button - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click search button",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.existOrNot()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to check if the asset exists or not ", true);
            counter++;
            narrator.failedMessage("Failed to check if the asset exists or not  - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to check if the asset exists or not  ",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.clickImportButton()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click import asset button ", true);
            counter++;
            narrator.failedMessage("Failed to click import asset button  - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click import asset button  ",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.clickChooseButton()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click choose button ", true);
            counter++;
            narrator.failedMessage("Failed to click choose button  - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click choose button  ",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!run.clickSearchButton()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click search button", true);
            counter++;
            narrator.failedMessage("Failed to click search button - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click search button",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.existOrNot2()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to check if file is imported succesfully", true);
            counter++;
            narrator.failedMessage("Failed to check if file is imported succesfully - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to check if file is imported succesfully",this.getTotalExecutionTime());
        }
        pause(3000);
         if(!methods.extractData("//A[@class='click-cell'][text()='Training MiX Import Test']", "Asset Description")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to ectract data", true);
            counter++;
            narrator.failedMessage("Failed to click extract data - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to extract data",this.getTotalExecutionTime());
        }
         pause(3000);
        if(!methods.extractData("//DIV[@class='cell alt'][text()='5558']", "Asset ID")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to extract data", true);
            counter++;
            narrator.failedMessage("Failed to extract data - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to extract data",this.getTotalExecutionTime());
        }
        pause(3000);
        if(!methods.extractData("//DIV[@class='cell alt'][text()='Shakedown12']", "Registration Number")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to extract data", true);
            counter++;
            narrator.failedMessage("Failed to extract data - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to extract data",this.getTotalExecutionTime());
        }
        pause(3000);
        if(!methods.extractData("//DIV[@class='cell alt'][text()='South Africa']", "Country")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to extract data", true);
            counter++;
            narrator.failedMessage("Failed to extract data - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to extract data",this.getTotalExecutionTime());
        }
        pause(3000);
        if(!methods.extractData("//DIV[@class='cell alt'][text()='Light Vehicle']", "Asset Type")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to extract data", true);
            counter++;
            narrator.failedMessage("Failed to extract data - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to extract data",this.getTotalExecutionTime());
        }
        pause(3000);
        if(!run.enterTextToFilter("y. MiX Import Test")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to enter text into filter", true);
            counter++;
            narrator.failedMessage("Failed to enter text into filter - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to enter text into filter",this.getTotalExecutionTime());
        }
        pause(3000);
        if(!run.clickSearchButton()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click search button", true);
            counter++;
            narrator.failedMessage("Failed to click search button - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click search button",this.getTotalExecutionTime());
        }
       pause(3000);
        return new TestResult(testData,Enums.ResultStatus.PASS,"Successfully imported asset file",this.getTotalExecutionTime());
    }
}
