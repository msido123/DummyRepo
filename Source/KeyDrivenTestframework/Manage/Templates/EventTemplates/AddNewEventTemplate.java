/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeyDrivenTestframework.Manage.Templates.EventTemplates;

import KeyDrivenTestframework.Manage.Templates.CheckTemplatesLoadInfo;
import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;

/**
 *
 * @author PhathuxoloJ
 */
public class AddNewEventTemplate extends BaseClass{
    
    int counter = 1;
    TestEntity testData;
    String errorMessage;
    
    public AddNewEventTemplate(TestEntity testData){
        this.testData = testData;
    }
    
    public TestResult executeTest() throws InterruptedException{
        this.setStartTime();
        CheckTemplatesLoadInfo run = new CheckTemplatesLoadInfo(testData);
        CheckEventFilterMethods eventFilterObj = new CheckEventFilterMethods(testData); 
        AddNewEventMethods methods = new AddNewEventMethods(testData);
        
        if(!run.navigateToManageTab()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Manage Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Manage Tab - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Manage Tab", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!run.navigateToTemplatesTab()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Templates Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Templates Tab - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Templates Tab", this.getTotalExecutionTime());
        }
        pause(1000);
         if(!run.navigateToEventTemplates()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Event Templates Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Event Templates Tab - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Event Templates Tab", this.getTotalExecutionTime());
        } 
        pause(1000);
        if(!methods.clickAddButton()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Add button", true);
            counter++;
            narrator.failedMessage("Failed to click on Add button - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Add button", this.getTotalExecutionTime());
        }
        if(!methods.clickEventNameField()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on event name field", true);
            counter++;
            narrator.failedMessage("Failed to click on event name field - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on event name field", this.getTotalExecutionTime());
        }
        
        if(!methods.typeEventName("070220180916_MiX Event Template")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to type event name", true);
            counter++;
            narrator.failedMessage("Failed to type event name - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to type event name", this.getTotalExecutionTime());
        }
        if(!methods.clickSelectEventButton()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click select event button", true);
            counter++;
            narrator.failedMessage("Failed to click select event button - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click select event button", this.getTotalExecutionTime());
        }
         if(!methods.clickFilter()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click filter", true);
            counter++;
            narrator.failedMessage("Failed to click filter- "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click filter", this.getTotalExecutionTime());
        }
        if(!methods.addTextToFilter("Over speeding")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to add text to filter", true);
            counter++;
            narrator.failedMessage("Failed to add text to filter- "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to add text to filter", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.clickCheckBox()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click check box", true);
            counter++;
            narrator.failedMessage("Failed to click check box- "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click check box", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.clickTheSelectButton()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click the select button", true);
            counter++;
            narrator.failedMessage("Failed to click the select button- "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click the select button", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.verifyEvent("Over speeding")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to verify the event", true);
            counter++;
            narrator.failedMessage("Failed to verify the event- "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to verify the event", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.clickSaveButton()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click save button", true);
            counter++;
            narrator.failedMessage("Failed to click save button - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click save button", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.clickCancelButton()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click cancel button", true);
            counter++;
            narrator.failedMessage("Failed to click cancel button - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click cancel button", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!eventFilterObj.clickTextFilter()) {
           
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click text filter", true);
            counter++;
            narrator.failedMessage("Failed to click text filter - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click text filter", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!eventFilterObj.typeTextInFilter("070220180916_MiX Event Template")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to enter text in event template filter", true);
            counter++;
            narrator.failedMessage("Failed to enter text in event template filter - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to enter text in event template filter", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.extractParameters()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to extract parameters from the event template", true);
            counter++;
            narrator.failedMessage("Failed to extract parameters from the event template - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to extract parameters from the event template", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.clickDropDownMenu()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click drop down menu", true);
            counter++;
            narrator.failedMessage("Failed to click drop down menu - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click drop down menu", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.clickRemoveOnDropDownMenu()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click remove on drop down menu", true);
            counter++;
            narrator.failedMessage("Failed to click remove on drop down menu - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click remove on drop down menu", this.getTotalExecutionTime());
        }
        return new TestResult(testData,Enums.ResultStatus.PASS,"New Event Template added Succesfully",this.getTotalExecutionTime());
    }
    
}
