/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeyDrivenTestframework.Manage.Libraries.LocationLibrary;

import KeyDrivenTestframework.Manage.Templates.CheckTemplatesLoadInfo;
import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
import java.io.FileNotFoundException;

/**
 *
 * @author PhathuxoloJ
 */
public class DownloadImportTemplate extends BaseClass{
    
    int counter = 1;
    TestEntity testData;
    String errorMessage;
    
    public DownloadImportTemplate(TestEntity testData){
        this.testData = testData;
    }
    public TestResult runTest() throws InterruptedException, FileNotFoundException{
        this.setStartTime();
        CheckTemplatesLoadInfo run = new CheckTemplatesLoadInfo(testData);
        DownloadImportTemplateMethods methods = new DownloadImportTemplateMethods(testData);
        if(!run.navigateToManageTab()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Manage Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Manage Tab - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Manage Tab", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.navigateToLibraries()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Library Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Library Tab - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Library Tab", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.navigateToLocationLibrary()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Location Library Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Location Library Tab - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Location Library Tab", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.clickOnDownloadButton()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Download button", true);
            counter++;
            narrator.failedMessage("Failed to click on Download button - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Download button", this.getTotalExecutionTime());
        }
        pause(10000);
        if(!methods.compareHeaders()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to compare table headers", true);
            counter++;
            narrator.failedMessage("Failed to compare table headers - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to compare table headers", this.getTotalExecutionTime());
        }
        pause(1000);
        return new TestResult(testData,Enums.ResultStatus.PASS,"Import template downloaded succesfully",this.getTotalExecutionTime());
    }
}
