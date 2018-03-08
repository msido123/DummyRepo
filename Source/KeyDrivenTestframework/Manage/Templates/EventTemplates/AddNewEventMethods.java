/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeyDrivenTestframework.Manage.Templates.EventTemplates;

import static KeywordDrivenTestFramework.Core.BaseClass.SeleniumDriverInstance;
import KeywordDrivenTestFramework.Entities.TestEntity;

/**
 *
 * @author PhathuxoloJ
 */
public class AddNewEventMethods extends AddNewEventTemplate{

    public AddNewEventMethods(TestEntity testData) {
        super(testData);
    }
    public boolean clickAddButton(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//I[@ng-class='iconClass']")) {    
            errorMessage = "The green plus sign button is not clicked";
            return false;
        } 
        SeleniumDriverInstance.clickElementByXpath("//I[@ng-class='iconClass']");
        errorMessage = "Green plus sign button clicked successfully";
        SeleniumDriverInstance.takeScreenShot(counter + "- green plus sign button clicked succesfully -", false);
        counter++; 
        return true;
    }
    
    public boolean clickEventNameField(){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[1]")) {    
            errorMessage = "The event field has not been clicked";
            return false;
        } 
        SeleniumDriverInstance.clickElementByXpath("(//INPUT[@type='text'])[1]");
        errorMessage = "Event field  clicked successfully";
        SeleniumDriverInstance.takeScreenShot(counter + "- event field clicked succesfully -", false);
        counter++; 
        return true;
    }
    
    public boolean typeEventName(String eventName){
         if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[1]")) {    
            errorMessage = " No event name is added";
            return false;
        } 
        SeleniumDriverInstance.EnterTextByXpath("(//INPUT[@type='text'])[1]", eventName);
        errorMessage = "Event name added successfully";
        SeleniumDriverInstance.takeScreenShot(counter + "- event name added successfuly -", false);
        counter++; 
        return true;
    }
    
    public boolean clickSelectEventButton(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//BUTTON[@class='btn ng-binding btn-small btn-success pull-right'][text()='Select events']")) {    
            errorMessage = "The select event button is not clicked";
            return false;
        } 
        SeleniumDriverInstance.clickElementByXpath("//BUTTON[@class='btn ng-binding btn-small btn-success pull-right'][text()='Select events']");
        errorMessage = "Select event button clicked successfully";
        SeleniumDriverInstance.takeScreenShot(counter + "- Select event clicked succesfully -", false);
        counter++; 
        return true;
    }
    
    public boolean clickFilter(){
         if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[3]")) {    
            errorMessage = " Text filter is not clicked";
            return false;
        } 
        SeleniumDriverInstance.clickElementByXpath("(//INPUT[@type='text'])[3]");
        errorMessage = "Text filter is clicked successfully";
        SeleniumDriverInstance.takeScreenShot(counter + "- Text filter is not clicked -", false);
        counter++; 
        return true;
    }
    
    public boolean addTextToFilter(String event){
         if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[3]")) {    
            errorMessage = " No text is added into filter";
            return false;
        } 
        SeleniumDriverInstance.EnterTextByXpath("(//INPUT[@type='text'])[3]", event);
        errorMessage = "Text added successfully into filter";
        SeleniumDriverInstance.takeScreenShot(counter + "- Text added successfuly into filter -", false);
        counter++; 
        return true;
    }
    
    public boolean clickCheckBox(){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='checkbox'])[8]")) {    
            errorMessage = "The checkbox is not selected";
            return false;
        } 
        SeleniumDriverInstance.clickElementByXpath("(//INPUT[@type='checkbox'])[8]");
        errorMessage = "the checkbox is selected successfully";
        SeleniumDriverInstance.takeScreenShot(counter + "- the checkbox is selected successfully -", false);
        counter++; 
        return true;
    }
    
    public boolean clickTheSelectButton(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//BUTTON[@class='btn ng-scope ng-binding btn-wide btn-success'][text()='Select']")) {    
            errorMessage = "The select button is not selected";
            return false;
        } 
        SeleniumDriverInstance.clickElementByXpath("//BUTTON[@class='btn ng-scope ng-binding btn-wide btn-success'][text()='Select']");
        errorMessage = "The select button is clicked successfully";
        SeleniumDriverInstance.takeScreenShot(counter + "- The select button is clicked successfully -", false);
        counter++; 
        return true;
    }
    
    public boolean verifyEvent(String textToCompare){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//DIV)[113]")){
            errorMessage = "No data is returned by the filter";
            return true;
        }
        String extractedEvent = SeleniumDriverInstance.retrieveTextByXpath("(//DIV)[113]");
        if(!(extractedEvent.contains(textToCompare))){
            errorMessage = "There are events returned";
            testData.extractParameter("Event template name", extractedEvent, "FAIL");
            SeleniumDriverInstance.takeScreenShot("Compared values are not the same", false);
            counter++;
            return false;
        }
        testData.extractParameter("Event template name", extractedEvent, "PASS");
        SeleniumDriverInstance.takeScreenShot("Compared values are the same", false);
        counter++;
        return true;
    }
    
    public boolean clickSaveButton(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//BUTTON[@class='btn btn-wide btn-small btn-success btn ng-scope ng-binding'][text()='Save']")) {    
            errorMessage = "The save button is not selected";
            return false;
        } 
        SeleniumDriverInstance.clickElementByXpath("//BUTTON[@class='btn btn-wide btn-small btn-success btn ng-scope ng-binding'][text()='Save']");
        errorMessage = "The save button is clicked successfully";
        SeleniumDriverInstance.takeScreenShot(counter + "- The save button is clicked successfully -", false);
        counter++; 
        return true;
    }
    
    public boolean clickCancelButton(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//BUTTON[@id='Close']")) {    
            errorMessage = "The close button is not selected";
            return false;
        } 
        SeleniumDriverInstance.clickElementByXpath("//BUTTON[@id='Close']");
        errorMessage = "The close button is clicked successfully";
        SeleniumDriverInstance.takeScreenShot(counter + "- The close button is clicked successfully -", false);
        counter++; 
        return true;
    }
    
    public boolean clickDropDownMenu(){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//A[@fleet-tooltip='Actions'])[1]")) {    
            errorMessage = "The drop down menu is not clicked";
            return false;
        } 
        SeleniumDriverInstance.clickElementByXpath("(//A[@fleet-tooltip='Actions'])[1]");
        errorMessage = "The drop down menu is clicked successfully";
        SeleniumDriverInstance.takeScreenShot(counter + "- The drop down menu is clicked successfully -", false);
        counter++; 
        return true;
    }
    
   public boolean clickRemoveOnDropDownMenu(){
        if(!SeleniumDriverInstance.waitForElementByXpath("/html/body/ul[2]/li[3]/a")) {    
            errorMessage = "The remove action is not clicked";
            return false;
        } 
        SeleniumDriverInstance.clickElementByXpath("/html/body/ul[2]/li[3]/a");
        errorMessage = "The remove action is clicked successfully";
        SeleniumDriverInstance.takeScreenShot(counter + "- The remove action is clicked successfully -", false);
        counter++; 
        return true;
    } 
    
    
    
}
