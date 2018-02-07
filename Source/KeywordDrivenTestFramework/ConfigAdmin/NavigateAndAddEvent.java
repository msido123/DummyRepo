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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author MzuvukileN
 */
public class NavigateAndAddEvent extends BaseClass{
    String error;
    int counter = 1;
    TestEntity testData;
    NavigateToLibraries nav;
    NavigateAndSearch navSearch;
    
    public NavigateAndAddEvent(TestEntity testData){
        this.testData = testData;
        nav = new NavigateToLibraries(testData);
        navSearch = new NavigateAndSearch(testData);
    }
    
    public TestResult executeTest() throws InterruptedException{
        this.setStartTime();
        
        if(!nav.clickManage()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on manage", false);
            counter++;
            narrator.failedMessage("Failed to click on manage - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on manage", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully clicked on Manage.", false);
        counter++;
        
        if(!nav.clickLibraries()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on libraries", false);
            counter++;
            narrator.failedMessage("Failed to click on manage - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on libraries", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully clicked on Libraries.", false);
        counter++;
        
        if(!nav.clickEventLibrary()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on event library", false);
            counter++;
            narrator.failedMessage("Failed to click on event libraries - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on event library", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successflly clicked event library.", false);
        counter++;
        
        if(!clickAddButton()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on add button", false);
            counter++;
            narrator.failedMessage("Failed to click on add button - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on add button", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successflly clicked on add button.", false);
        counter++;
        
        if(!enterEventDescript()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to add event description.", false);
            counter++;
            narrator.failedMessage("Failed to add event description. - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to add event description.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successflly added the event description", false);
        counter++;
        
        if(!clickAddEventCondition()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to add event condition.", false);
            counter++;
            narrator.failedMessage("Failed to add event condition. - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to add event condition.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successflly added the event condition", false);
        counter++;
        
        if(!addAccelParameter()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to add accelerate parameter.", false);
            counter++;
            narrator.failedMessage("Failed to add accelerate parameter. - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to add accelerate parameter.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successflly added accelerate parameter.", false);
        counter++;
    
        if(!clickSaveButton()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click save button.", false);
            counter++;
            narrator.failedMessage("Failed to click save button. - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click save button.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successflly clicked save button", false);
        counter++;
        
        if(!checkIfPopUpDisplayed()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Pop up window not displayed.", false);
            counter++;
            narrator.failedMessage("Pop up window not displayed. - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Pop up window not displayed.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + "Pop up window not displayed.", false);
        counter++;
        
        if(!tickRecordEventBox()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed click on record event.", false);
            counter++;
            narrator.failedMessage("Failed click on record event. - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed click on record event.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + "Successfully ticked record event.", false);
        counter++;
        
        if(!clickSaveButton()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click save button.", false);
            counter++;
            narrator.failedMessage("Failed to click save button. - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click save button.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successflly clicked save button", false);
        counter++;
        
        if(!navSearch.clickFilter()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on filter", false);
            counter++;
            narrator.failedMessage("Failed to click on manage - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on filter", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully clicked on filter.", false);
        counter++;
        
        if(!navSearch.inputTextToFilter("07 Feb 2018")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to filter events.", false);
            counter++;
            narrator.failedMessage("Failed to filter events. - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to filter events.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successflly filtered events", false);
        counter++;
        
        pause(1000);
        if(!removeEvent()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to filter events.", false);
            counter++;
            narrator.failedMessage("Failed to remove event. - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to remove.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successflly removed.", false);
        counter++;
        
        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully added an event and removed it.", this.getTotalExecutionTime());
    }
    
    
    public boolean clickAddButton(){
        if(!SeleniumDriverInstance.CheckIfElementDisplayedByXpath("//I[@ng-class='iconClass']")){
            error = "The add event button is not displayed";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//I[@ng-class='iconClass']");
        return true;
    }
    
    public String myDateStamp(){
        String dateTimeStamp;
        DateFormat dateFormat2 = new SimpleDateFormat("dd/MMM/yyyy HHh:mm:ss");
        Date date2 = new Date();
        dateTimeStamp = dateFormat2.format(date2);
        dateTimeStamp = dateTimeStamp.replaceAll("/", " ");
        dateTimeStamp = dateTimeStamp.replaceAll(":", "");
        
        return dateTimeStamp;
    }
    
    public boolean enterEventDescript(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//INPUT[@class='span12 ng-pristine ng-invalid ng-invalid-dmx-required ng-valid-dmx-minlength ng-valid-dmx-maxlength ng-valid-fleet-event-description-unique-async']")){
            error = "There is no input field for event description.";
            return false;
        }
        
        SeleniumDriverInstance.enterTextByXpath("//INPUT[@class='span12 ng-pristine ng-invalid ng-invalid-dmx-required ng-valid-dmx-minlength ng-valid-dmx-maxlength ng-valid-fleet-event-description-unique-async']", myDateStamp());
        return true;
    }
    
    public boolean clickAddEventCondition(){
        if(!SeleniumDriverInstance.CheckIfElementDisplayedByXpath("//I[@class='icon-plus icon-green']")){
            error = "There is no add event condition button.";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("//I[@class='icon-plus icon-green']");
        return true;
    }
    
    public boolean addAccelParameter(){
        if(!SeleniumDriverInstance.CheckIfElementDisplayedByXpath("//SELECT[@class='parameter-list span12 ng-pristine ng-valid']")){
            error = "Drop down panel not showing for add parameter.";
            return false;
        }
        
        SeleniumDriverInstance.selectFromDropDownListUsingXpath("//SELECT[@class='parameter-list span12 ng-pristine ng-valid']", "Acceleration");
        return true;
    }
    
    public boolean clickSaveButton(){
        if(!SeleniumDriverInstance.CheckIfElementDisplayedByXpath("//BUTTON[@class='btn-wide btn-small btn-success btn ng-scope ng-binding'][text()='Save']")){
            error = "There is no save button displayed.";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("//BUTTON[@class='btn-wide btn-small btn-success btn ng-scope ng-binding'][text()='Save']");
        return true;
    }
    
    public boolean checkIfPopUpDisplayed(){
        boolean exit = false;
        if(!SeleniumDriverInstance.waitForElementByXpath("//BUTTON[@ng-show='$modal.okayButton'][text()='OK']")){
            error = "Pop up window did not show up";
            return false;
        }
        
        String extractedData = SeleniumDriverInstance.retrieveTextByXpath("//div[text() = \"Please select that this event is recorded or has at least one action.\"]");
        if(extractedData.equals("Please select that this event is recorded or has at least one action.")){
            exit = true;
            SeleniumDriverInstance.clickElementByXpath("//BUTTON[@ng-show='$modal.okayButton'][text()='OK']");
        }
        return exit;
    }
    
    public boolean tickRecordEventBox(){
        if(!SeleniumDriverInstance.CheckIfElementDisplayedByXpath("(//INPUT[@type='checkbox'])[1]")){
            error = "There is no tick box displayed.";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("(//INPUT[@type='checkbox'])[1]");
        return true;
    }
    
    public boolean removeEvent(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@fleet-tooltip='Actions']")){
            error = "No drop down option to remove event.";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("(//A[@fleet-tooltip='Actions'])[1]");
        SeleniumDriverInstance.clickElementByXpath("//span[text()='Remove']");
        SeleniumDriverInstance.clickElementByXpath("//BUTTON[@ng-show='$modal.okayButton'][text()='Ok']");
        return true;
    }
}
