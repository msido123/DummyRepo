/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.ConfigAdmin;

import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
import static java.lang.Thread.sleep;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author MsimeleloG
 */
public class AddNewTemplate extends BaseClass {
    
    int counter = 1;
    String errorMsg = "";
    TestEntity testData;
    InputTextAndSearchOnFilter addNewTempNav;
    Navigate_to_Templates addNewTempNavigation;
    
    public AddNewTemplate(TestEntity testData) {
        this.testData = testData;
        addNewTempNav = new InputTextAndSearchOnFilter(testData);
        addNewTempNavigation = new Navigate_to_Templates(testData);
    }
    
    public TestResult executeTest() throws InterruptedException {
        
        this.setStartTime();
        
        if(!addNewTempNavigation.NavigateToManageTab()) {
           
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Manage Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Manage Tab - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Manage Tab", this.getTotalExecutionTime());
        }
        
        if(!addNewTempNavigation.clickTemplate()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Templates", true);
            counter++;
            narrator.failedMessage("Failed to click on Templates - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Templates", this.getTotalExecutionTime());
        }
        
        if(!addNewTempNavigation.clickEventsTemp()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Event templates", true);
            counter++;
            narrator.failedMessage("Failed to click on Templates - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Event templates", this.getTotalExecutionTime());
        }
        
        if(!clickAddNewTemplateButton()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on add new template button", true);
            counter++;
            narrator.failedMessage("Failed to click on add new template button - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on add new template button", this.getTotalExecutionTime());
        }
        
        if(!enterNewEventTemplateName()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to enter new event template name", true);
            counter++;
            narrator.failedMessage("Failed to enter new event template name - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to enter new event template name", this.getTotalExecutionTime());
        }
        
        
        if(!clickSelectEventsButton()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click select events button", true);
            counter++;
            narrator.failedMessage("Failed to click select events button - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click select events button", this.getTotalExecutionTime());
        }
        
        if(!isSelectEventsFilterClicked()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to select events filter ", true);
            counter++;
            narrator.failedMessage("Failed to select events filter - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to select events filter", this.getTotalExecutionTime());
        }
        
        if(!addTextToSelectEventsFilter()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to add text to select events filter ", true);
            counter++;
            narrator.failedMessage("Failed to add text to select events filter - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to add text to select events filter", this.getTotalExecutionTime());
        }
        pause(2000);
        
        if(!selectEventFromList()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to locate event template from list ", true);
            counter++;
            narrator.failedMessage("Failed to locate event template from list - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to locate event template from list", this.getTotalExecutionTime());
        }
        
        if(!clickSelectButton()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click select button ", true);
            counter++;
            narrator.failedMessage("Failed to click select button - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click select button", this.getTotalExecutionTime());
        }
        
        /*
        if(!ensureEventIsShownInList()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to locate event in list ", true);
            counter++;
            narrator.failedMessage("Failed to locate event in list - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to locate event in list", this.getTotalExecutionTime());
        }
        */
        
        if(!clickOnSaveButton()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Save button ", true);
            counter++;
            narrator.failedMessage("Failed to click on Save button - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Save button", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!returnToTemplatesListPage()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Close button ", true);
            counter++;
            narrator.failedMessage("Failed to click on Close button - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Close button", this.getTotalExecutionTime());
        }
        pause(1000);
        
        if(!addNewTempNav.isFilterClicked()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Filter ", true);
            counter++;
            narrator.failedMessage("Failed to click on Filter - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Filter ", this.getTotalExecutionTime());
        }
        
        if(!addNewTempNav.addTextToFilter("Mix Event Template")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Filter ", true);
            counter++;
            narrator.failedMessage("Failed to click on Filter - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Filter ", this.getTotalExecutionTime());
        }
        
        if(!addNewTempNav.compareFilterResults("Mix Event Template")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to get desired text", true);
            counter++;
            narrator.failedMessage("Failed to get desired text - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to get desired text", this.getTotalExecutionTime());
        }
        
        if(!clickRemoveNewTemplate()) {
           
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click remove template", true);
            counter++;
            narrator.failedMessage("Failed to click remove template - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click remove template", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!showPopUp()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to show pop up", true);
            counter++;
            narrator.failedMessage("Failed to show pop up - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to show pop up", this.getTotalExecutionTime());
        }
        
        if(!confirmRemovalOfNewTemplate()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to remove template", true);
            counter++;
            narrator.failedMessage("Failed to remove template - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to remove template", this.getTotalExecutionTime());
        }
        pause(1000);
        
        
             
        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigated to the Events Template Page.", this.getTotalExecutionTime());
    }
    
    // this class navigates to the events template page and adds a new class
    
    public boolean clickAddNewTemplateButton() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//I[@ng-class='iconClass']")) {
            
            errorMsg = "Add new template button not clicked";
            return false;
        }
        
        SeleniumDriverInstance.clickElementbyXpath("//I[@ng-class='iconClass']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Add new template button clicked successfully -", false);
        counter++;
        return true;
    }
    
    
    public String myDateStamp(){
        String dateTimeStamp;
        DateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
        Date date2 = new Date();
        dateTimeStamp = dateFormat2.format(date2);
        dateTimeStamp = dateTimeStamp.replaceAll("/", "");
        
        
        return dateTimeStamp;
    }
     
    public boolean enterNewEventTemplateName() {
        if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[1]")) {
            
            errorMsg = "New Template name cannot be added";
            return false;
        }
        
        SeleniumDriverInstance.EnterTextByXpath("(//INPUT[@type='text'])[1]",myDateStamp() + "_Mix Event Templates");
        SeleniumDriverInstance.takeScreenShot(counter + "- New event template name added successfully -", false);
        counter++;
        return true;
        
    }
    
    public boolean clickSelectEventsButton() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//BUTTON[@class='btn ng-binding btn-small btn-success pull-right'][text()='Select events']")) {
            
            errorMsg = "Select events button not clicked";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("//BUTTON[@class='btn ng-binding btn-small btn-success pull-right'][text()='Select events']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Select Events Button clicked successfully", false);
        counter++;
        return true;        
    }
    
    // first check if the filter is selected
    public boolean isSelectEventsFilterClicked() {
        if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[3]")) {
            
            errorMsg = "Select Events Filter not clicked";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("(//INPUT[@type='text'])[3]");
        SeleniumDriverInstance.takeScreenShot(counter + "- Select Events Filter clicked successfully  -", false);
        counter++;
        return true;
    }
    
    public boolean addTextToSelectEventsFilter() {
        if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[3]")) {
            
            errorMsg = "Text not added";
            return false;
        }
        
        SeleniumDriverInstance.EnterTextByXpath("(//INPUT[@type='text'])[3]", "Over speeding");
        SeleniumDriverInstance.takeScreenShot(counter + "- Text added to Select Events Filter successfully -", false);
        counter++;
        return true;
    }
    
    public boolean selectEventFromList() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//td[@ng-show=\"allowRowSelection\"]")) {
            
            errorMsg = "Event not found";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("//td[@ng-show=\"allowRowSelection\"]");
        SeleniumDriverInstance.takeScreenShot(counter + "- Event selected successfully -", false);
        counter++;
        return true;
    }
    
    public boolean clickSelectButton() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//BUTTON[@class='btn ng-scope ng-binding btn-wide btn-success'][text()='Select']")) {
            
            errorMsg = "Select button not clicked";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("//BUTTON[@class='btn ng-scope ng-binding btn-wide btn-success'][text()='Select']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Select button clicked successfully -", false);
        counter++;
        return true;
    }
    
    /*
    public boolean ensureEventIsShownInList() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@class='clickable-cell ng-scope']", 10)) {
            
            errorMsg = "Selected event not visible in list";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//A[@class='clickable-cell ng-scope']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Selected event is still visible -", false);
        counter++;
        return true;
    }
    */
    
    public boolean clickOnSaveButton() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//BUTTON[@class='btn btn-wide btn-small btn-success btn ng-scope ng-binding'][text()='Save']")) {
            
            errorMsg = "Save button cannot be clicked";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("//BUTTON[@class='btn btn-wide btn-small btn-success btn ng-scope ng-binding'][text()='Save']");
        pause(2000);
        SeleniumDriverInstance.takeScreenShot(counter + "- Save button clicked successfully -", false);
        counter++;
        return true;
    }
    
    public boolean returnToTemplatesListPage() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//BUTTON[@id='Close']")) {
            
            errorMsg = "Cannot click close button";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("//BUTTON[@id='Close']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Close button clicked successfully -", false);
        counter++;
        return true;
    }
    
  
    /*
    public boolean checkIfNewEventTemplateIsDisplayed() {
        if(!SeleniumDriverInstance.CheckIfElementDisplayedByXpath("//A[@class='clickable-cell ng-scope']")) {
            
            errorMsg = "New event template not found";
            return false;
        }
        
        SeleniumDriverInstance.takeScreenShot(counter + "- New event template is displayed successfully -", false);
        counter++;
        return true;
    }
    */
    public boolean clickRemoveNewTemplate() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@fleet-tooltip='Actions']")) {
            
            errorMsg = "Cannot remove template from the list";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//A[@fleet-tooltip='Actions']");
        SeleniumDriverInstance.clickElementByXpath("//span[text()='Remove']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Template Removed successfully -", false);
        counter++;
        return true;
    }
    
    public boolean showPopUp() {
        if(!SeleniumDriverInstance.waitForElementByXpath("(//DIV[@class='modal-inner-body white-box-padding'])[1]")) {
            
            errorMsg = "Pop up not displayed";
            return false;
        }
        
        //SeleniumDriverInstance.clickElementByXpath("(//DIV[@class='modal-inner-body white-box-padding'])[1]");
        SeleniumDriverInstance.takeScreenShot(counter + "- Pop up showed successfully -",false);
        counter++;
        return true;
    }
    
    public boolean confirmRemovalOfNewTemplate() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//BUTTON[@ng-show='$modal.okayButton'][text()='Remove']")) {
            
            errorMsg = "Template not removed";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("//BUTTON[@ng-show='$modal.okayButton'][text()='Remove']");
        pause(5000);
        SeleniumDriverInstance.takeScreenShot(counter + "- Template removed successfully -", false);
        counter++;
        return true;
    }
  
    
    
    
    
}
