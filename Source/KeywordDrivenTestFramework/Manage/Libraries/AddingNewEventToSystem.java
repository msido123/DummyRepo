/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.Manage.Libraries;

import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Manage.Templates.CheckTemplatesLoadInfoZee;
import KeywordDrivenTestFramework.Manage.Templates.CheckingEventTemplateFilter;
import static KeywordDrivenTestFramework.Core.BaseClass.SeleniumDriverInstance;
import static KeywordDrivenTestFramework.Core.BaseClass.narrator;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author ZiyandaP
 */
public class AddingNewEventToSystem  extends BaseClass{

    int counter = 1;
    String errorMsg;
    TestEntity testData;
    String defaultWindow;
    String popUpWindow;
    Date date = new Date();
    DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
    public static CheckTemplatesLoadInfoZee obj;  
    public static CheckingEventTemplateFilter object;
   
    //TheConstructor
    public  AddingNewEventToSystem(TestEntity testData){
    
    this.testData = testData;
    obj = new CheckTemplatesLoadInfoZee(testData);
    object = new CheckingEventTemplateFilter(testData);
    
    }
    public TestResult executeTest() throws InterruptedException {
        
        this.setStartTime();
        if(!obj.navigateToManageTabZee()){
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Manage Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Manage Tab - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Manage Tab", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!navigateToLibrariesTab()){
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on the Libraries Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on the Libraries Tab - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the Libraries Tab", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!isAddEventSignClicked()){
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on the greenSign", true);
            counter++;
            narrator.failedMessage("Failed to click on the greenSign - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the GreenSign", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!isEventDescriptionClicked()){
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Event description", true);
            counter++;
            narrator.failedMessage("Failed to click on Event description - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Event description", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!addTextToEventDescription(dateFormat.format(date)+"_MiX Event Library")){
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to add text on Event description", true);
            counter++;
            narrator.failedMessage("Failed to add text on Event description - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to add text on Event description", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!isGreenArrowClicked()){
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on the green arrow", true);
            counter++;
            narrator.failedMessage("Failed to click on the green arrow - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the green arrow", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!isParameterSelected()){
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to select the correct parameter", true);
            counter++;
            narrator.failedMessage("Failed to Add text - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to select the correct parameter", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!isSaveClicked()){
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click Save", true);
            counter++;
            narrator.failedMessage("Failed to click Save - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click Save", this.getTotalExecutionTime());            
        }
        pause(1000);
        if(!verifyTextInPopUp("Please select that this event is recorded or has at least one action.")){
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to verify text", true);
            counter++;
            narrator.failedMessage("Failed to verify text - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to verify text", this.getTotalExecutionTime());            
        }
        pause(1000);
        if(!isOkClicked()){
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click OK", true);
            counter++;
            narrator.failedMessage("Failed to click OK - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click OK", this.getTotalExecutionTime());            
        }
        pause(1000);
        if(!isRecordEventTicked()){
            
            SeleniumDriverInstance.takeScreenShot(counter + " -Failed to tick event ", true);
            counter++;
            narrator.failedMessage("Failed to tick event - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to tick event", this.getTotalExecutionTime());            
        }
        if(!isSavePressed()){
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click Save", true);
            counter++;
            narrator.failedMessage("Failed to click Save - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click Save", this.getTotalExecutionTime());            
        }
        pause(1000);
        if(!isFilterClickedNow()){
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on the Filter", true);
            counter++;
            narrator.failedMessage("Failed to click on the Filter- "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the Filter", this.getTotalExecutionTime());
        }
        pause(2000);
        if(!addTextToFilterNow(dateFormat.format(date)+"_MiX Event Library")){
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to add text on the Filter", true);
            counter++;
            narrator.failedMessage("Failed to add text on the Filter- "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to add text on the Filter", this.getTotalExecutionTime());       
        }
        pause(2000);
        if(!isdropDownClicked()){
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to  remove Event", true);
            counter++;
            narrator.failedMessage("Failed to click remove Event- "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to remove Event", this.getTotalExecutionTime());
        }
        pause(1000);
            if(!isRemoveClicked()){
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to  remove Event", true);
            counter++;
            narrator.failedMessage("Failed to click remove Event- "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to remove Event", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!isOkClickedToFinish()){
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click OK", true);
            counter++;
            narrator.failedMessage("Failed to click OK - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click OK", this.getTotalExecutionTime());            
        }
        pause(1000);
        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully added a new Event on the Filter.", this.getTotalExecutionTime()); 
    }

    public boolean navigateToLibrariesTab(){
        
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@ng-href='#/config-admin/libraries'][text()='Libraries']")) {
            
            errorMsg = "Failed to click on the Libraries Tab";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//A[@ng-href='#/config-admin/libraries'][text()='Libraries']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Clicked Libraries tab successfully -", false);
        counter++;
        return true;
    }
    public boolean isAddEventSignClicked() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@class='btn btn-small btn-success']")) {
            
            errorMsg = "Failed to click on the green sign";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//A[@class='btn btn-small btn-success']");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked on the green sign -", false);      
        counter++;
        return true;
    }
    public boolean isEventDescriptionClicked() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//input[@name=\"description\"]")) {
            
            errorMsg = "Failed to click on Event dscription";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//input[@name=\"description\"]");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked on Event description -", false);
        counter++;
        return true;
    }
   //"//*[@id=\"MainView\"]/div/div/div/div[2]/div/div/div/div/div/form/div[1]/div[1]/div/input"
    public boolean addTextToEventDescription(String textToEnter) {
        if(!SeleniumDriverInstance.waitForElementByXpath("//input[@name=\"description\"]")) {
            
            errorMsg = "Failed to add text to event description";
            return false;
        }       
        SeleniumDriverInstance.EnterTextByXpath("//input[@name=\"description\"]", textToEnter);
        SeleniumDriverInstance.takeScreenShot(counter + "- Text addded successfully -", false);
        counter++;
        return true;
    }
    public boolean isGreenArrowClicked() {
        if(!SeleniumDriverInstance.waitForElementByXpath("(//A[@class='btn btn-small pull-left mr-5'])[1]")) {
            
            errorMsg = "Failed to click on Green Arrow";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("(//A[@class='btn btn-small pull-left mr-5'])[1]");
        SeleniumDriverInstance.
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked on Green Arrow -", false);
        counter++;
        return true;
    }
    public boolean isParameterSelected() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//SELECT[@class='parameter-list span12 ng-pristine ng-valid']")) {
            
            errorMsg = "Failed to click on the parameter";
            return false;
        }
        SeleniumDriverInstance.selectFromDropDownListUsingXpath("//SELECT[@class='parameter-list span12 ng-pristine ng-valid']", "Acceleration");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked on the parameter -", false);
        //SeleniumDriverInstance.
        counter++;
        return true;
    }
    public boolean isSaveClicked() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//BUTTON[@class='btn-wide btn-small btn-success btn ng-scope ng-binding'][text()='Save']")) {
            
            errorMsg = "Failed to click save";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//BUTTON[@class='btn-wide btn-small btn-success btn ng-scope ng-binding'][text()='Save']");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked Save -", false);      
        counter++;
        return true;
    }
        public boolean verifyTextInPopUp(String textToCompare){
        
         if(!SeleniumDriverInstance.waitForElementByXpath("//DIV[@ng-bind-html-unsafe='$modal.message | translate:$modal.data'][text()='Please select that this event is recorded or has at least one action.']")) {
            
            errorMsg = "Failed retrieve " +textToCompare+ "Xpath ";
            return false;
         }
        String checkText  = SeleniumDriverInstance.retrieveTextByXpath("//DIV[@ng-bind-html-unsafe='$modal.message | translate:$modal.data'][text()='Please select that this event is recorded or has at least one action.']");
        if(!(checkText.contains(textToCompare))){
            
            errorMsg = "Failed to compare";
            testData.extractParameter("Event not saved", checkText, "FAIL");
            SeleniumDriverInstance.takeScreenShot(counter + "Verified " +textToCompare+ " successfully -", false);
            counter++;
            return false;
            
        }
            testData.extractParameter("Event PopUp", checkText, "PASS");
            SeleniumDriverInstance.takeScreenShot(counter + "- verified " +textToCompare+ " successfully -",true);
            counter++;        
            return true;
    }
    public boolean isOkClicked() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//BUTTON[@ng-show='$modal.okayButton'][text()='OK']")) {
            
            errorMsg = "Failed to click OK";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//BUTTON[@ng-show='$modal.okayButton'][text()='OK']");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked OK -", false);      
        counter++;
        return true;
    }
    public boolean isRecordEventTicked() {
        if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='checkbox'])[1]")) {
            
            errorMsg = "Failed to tick on the Record Event tick box";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("(//INPUT[@type='checkbox'])[1]");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully recorded Event  -", false);      
        counter++;
        return true;
    }
    public boolean isSavePressed() {
        if(!SeleniumDriverInstance.waitForElementByXpath("(//button[@event=\"saveClicked\"])")) {
            
            errorMsg = "Failed to click save";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("(//button[@event=\"saveClicked\"])");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked Save -", false);      
        counter++;
        return true; 
    }
    public boolean isFilterClickedNow() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//input[@placeholder = \"Filter\"]")) {
            
            errorMsg = "Failed to click on the filter";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//input[@placeholder = \"Filter\"]");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked on the filter -", false);
        counter++;
        return true;
    }
    
    public boolean addTextToFilterNow(String textToEnter) {
        if(!SeleniumDriverInstance.waitForElementByXpath("//input[@placeholder = \"Filter\"]")) {
            
            errorMsg = "Failed to add text to filter";
            return false;
        }
        
        SeleniumDriverInstance.EnterTextByXpath("//input[@placeholder = \"Filter\"]", textToEnter);
        SeleniumDriverInstance.takeScreenShot(counter + "- Text addded successfully -", false);
        counter++;
        return true;
    }


    public boolean isdropDownClicked(){
    if(!SeleniumDriverInstance.waitForElementByXpath("//A[@fleet-tooltip='Actions']")) {
            
            errorMsg = "Failed to click OK";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//A[@fleet-tooltip='Actions']");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked OK -", false);      
        counter++;
        return true;
    }
    public boolean isRemoveClicked(){
    if(!SeleniumDriverInstance.waitForElementByXpath("//i[@class=\"icon icon-remove-sign icon-red\"]")) {
            
            errorMsg = "Failed to click OK";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//i[@class=\"icon icon-remove-sign icon-red\"]");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked OK -", false);      
        counter++;
        return true;
    }
    
    public boolean isOkClickedToFinish() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//BUTTON[@ng-show='$modal.okayButton'][text()='Ok']")) {
            
            errorMsg = "Failed to click OK";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//BUTTON[@ng-show='$modal.okayButton'][text()='Ok']");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked OK -", false);      
        counter++;
        return true;
    }
}
