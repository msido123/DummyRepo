/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeyDrivenTestframework.Manage.Templates.EventTemplates;

import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
import KeyDrivenTestframework.Manage.Templates.CheckTemplatesLoadInfo;
import static KeywordDrivenTestFramework.Core.BaseClass.SeleniumDriverInstance;
import static KeywordDrivenTestFramework.Core.BaseClass.narrator;


/**
 *
 * @author PhathuxoloJ
 */
public class CheckEventTemplatesFilter extends BaseClass{
    int counter = 1;
    TestEntity testData;
    String errorMessage;
    
    public CheckEventTemplatesFilter(TestEntity testData){
        this.testData = testData;
    }
    
    
    
    public TestResult executeTest() throws InterruptedException{
        this.setStartTime();
        
        CheckTemplatesLoadInfo run = new CheckTemplatesLoadInfo(testData);
        CheckEventFilterMethods method = new CheckEventFilterMethods(testData);
        if(!run.navigateToManageTab()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Manage Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Manage Tab - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Manage Tab", this.getTotalExecutionTime());
        }
        
        if(!run.navigateToTemplatesTab()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Templates Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Templates Tab - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Templates Tab", this.getTotalExecutionTime());
        }
         if(!run.navigateToEventTemplates()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Event Templates Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Event Templates Tab - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Event Templates Tab", this.getTotalExecutionTime());
        } 
        pause(1000);
        if(!method.clickTextFilter()) {
           
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click text filter", true);
            counter++;
            narrator.failedMessage("Failed to click text filter - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click text filter", this.getTotalExecutionTime());
        }
        if(!method.typeTextInFilter()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to enter text in event template filter", true);
            counter++;
            narrator.failedMessage("Failed to enter text in event template filter - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to enter text in event template filter", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!method.checkRowOneColumnOne("Default event template for MiX2310i")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to compare text under template name ", true);
            counter++;
            narrator.failedMessage("Failed to compare text under template name - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to compare text under template name", this.getTotalExecutionTime());
        } 
        pause(1000);
        if(!method.checkRowOneColumnTwo("0")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to compare text under asset count ", true);
            counter++;
            narrator.failedMessage("Failed to compare text under asset count  - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to compare text under asset count ", this.getTotalExecutionTime());
        } 
        pause(1000);
        if(!method.checkRowOneColumnThree("2")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to compare text under cofiguration group count ", true);
            counter++;
            narrator.failedMessage("Failed to compare text under cofiguration group count  - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to compare text under cofiguration group count ", this.getTotalExecutionTime());
        } 
        pause(1000);
//         if(!method.checkNumberOfRows()) {
//            
//            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to check number of rows ", true);
//            counter++;
//            narrator.failedMessage("Failed to check number of rows  - "+errorMessage);
//            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to check number of rows ", this.getTotalExecutionTime());
//        }
        
        return new TestResult(testData, Enums.ResultStatus.PASS, "Event templates filter works perferctly", this.getTotalExecutionTime());
    }
           
}
