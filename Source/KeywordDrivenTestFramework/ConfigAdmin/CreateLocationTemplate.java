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
 * @author MsimeleloG
 */
public class CreateLocationTemplate extends BaseClass {
    
    int counter = 1;
    String errorMsg = "";
    TestEntity testData;
    
    Navigate_to_Templates navigateToLocationTemp; //used to access method from the Navigate_to_Templates Class
    AddNewTemplate createLocationNav; //used to access method from the AddNewTemplate Class
    InputTextAndSearchOnFilter locationTempNav; // used to access method from the InputtextAndSearchOnFilter Class
    
    
    public CreateLocationTemplate(TestEntity testData) {
        this.testData = testData;
        navigateToLocationTemp = new Navigate_to_Templates(testData);
        createLocationNav = new AddNewTemplate(testData);
        locationTempNav = new InputTextAndSearchOnFilter(testData);
    }
    
    public TestResult executeTest() throws InterruptedException {
        
        this.setStartTime();
        
        if(!navigateToLocationTemp.NavigateToManageTab()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Manage Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Manage Tab - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Manage Tab", this.getTotalExecutionTime());
        }
        
        if(!navigateToLocationTemp.clickTemplate()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Templates", true);
            counter++;
            narrator.failedMessage("Failed to click on Templates - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Templates", this.getTotalExecutionTime());
        }
        
        if(!navigateToLocationTemp.clickLocationTemp()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Location templates", true);
            counter++;
            narrator.failedMessage("Failed to click on Templates - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Location templates", this.getTotalExecutionTime());
        }
        
        if(!createLocationNav.clickAddNewTemplateButton()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on add new template button", true);
            counter++;
            narrator.failedMessage("Failed to click on add new template button - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on add new template button", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!clickSelectLocationsButton()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click select locations button", true);
            counter++;
            narrator.failedMessage("Failed to click select locations button - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click select locations button", this.getTotalExecutionTime());
        }
        
        if(!addTextToSelectLocationFilter()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to add text to select locations filter ", true);
            counter++;
            narrator.failedMessage("Failed to add text to select locations filter - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to add text to select locations filter", this.getTotalExecutionTime());
        }
        pause(1000);
        
        if(!createLocationNav.selectEventFromList()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to find location template from list ", true);
            counter++;
            narrator.failedMessage("Failed to find location template from list - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to find location template from list", this.getTotalExecutionTime());
        }
        
        if(!createLocationNav.clickSelectButton()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click select button ", true);
            counter++;
            narrator.failedMessage("Failed to click select button - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click select button", this.getTotalExecutionTime());
        }
        
        if(!enterNewLocationTempName()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to enter new location template name", true);
            counter++;
            narrator.failedMessage("Failed to enter new location template name - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to enter new location template name", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!createLocationNav.clickOnSaveButton()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Save button ", true);
            counter++;
            narrator.failedMessage("Failed to click on Save button - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Save button", this.getTotalExecutionTime());
        }
        pause(2000);
        
        if(!createLocationNav.returnToTemplatesListPage()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Close button ", true);
            counter++;
            narrator.failedMessage("Failed to click on Close button - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Close button", this.getTotalExecutionTime());
        }
        pause(2000);
        if(!locationTempNav.isFilterClicked()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Filter ", true);
            counter++;
            narrator.failedMessage("Failed to click on Filter - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Filter ", this.getTotalExecutionTime());
        }
        
        if(!locationTempNav.addTextToFilter("_MiX Location Template")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Filter ", true);
            counter++;
            narrator.failedMessage("Failed to click on Filter - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Filter ", this.getTotalExecutionTime());
        }
        
        if(!locationTempNav.compareFilterResults("_MiX Location Template")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to find location template being searched for", true);
            counter++;
            narrator.failedMessage("Failed to find location template being searched for - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to find location template being searched for", this.getTotalExecutionTime());
        }
        
        if(!createLocationNav.clickRemoveNewTemplate()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click remove template", true);
            counter++;
            narrator.failedMessage("Failed to click remove template - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click remove template", this.getTotalExecutionTime());
        }
        pause(1000);
        
        if(!createLocationNav.showPopUp()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to show pop up", true);
            counter++;
            narrator.failedMessage("Failed to show pop up - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to show pop up", this.getTotalExecutionTime());
        }
        
        if(!createLocationNav.confirmRemovalOfNewTemplate()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to remove template", true);
            counter++;
            narrator.failedMessage("Failed to remove template - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to remove template", this.getTotalExecutionTime());
        }
        pause(1000);  
        
        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigated to the Location Template Page.", this.getTotalExecutionTime());
    }
    
    public boolean clickSelectLocationsButton() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//BUTTON[@class='btn ng-binding btn-small btn-success pull-right'][text()='Select locations']")) {
            
            errorMsg = "Select Locations button not clicked";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("//BUTTON[@class='btn ng-binding btn-small btn-success pull-right'][text()='Select locations']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Select Locations button clicked successfully -", false);
        counter++;
        return true;
    }
    
   public boolean addTextToSelectLocationFilter() {
       
       if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[3]")) {
            
            errorMsg = "Text not added";
            return false;
        }
        
        SeleniumDriverInstance.EnterTextByXpath("(//INPUT[@type='text'])[3]", "z. MiX");
        SeleniumDriverInstance.takeScreenShot(counter + "- Text added to Select Locations Filter successfully -", false);
        counter++;
        return true;
   }
   
   // select event from list will be called from AddNewTemplate class
   
   public String myDateStamp(){
        String dateTimeStamp;
        DateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
        Date date2 = new Date();
        dateTimeStamp = dateFormat2.format(date2);
        dateTimeStamp = dateTimeStamp.replaceAll("/", "");
        
        
        return dateTimeStamp;
    }
   
   public boolean enterNewLocationTempName() {
       if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[1]")) {
           
           errorMsg = "Location template name cannot be added";
           return false;
       }
       
       SeleniumDriverInstance.EnterTextByXpath("(//INPUT[@type='text'])[1]",myDateStamp() + "_MiX Location Template");
       SeleniumDriverInstance.takeScreenShot(counter + "- New location template name added successfully -", false);
       counter++;
       return true;
   }
   
   // click save new location, method is inherinted from AddNewTemplate class
   
   // close the and go to Location template grid, method is inherinted from AddNewTemplate class
   
   // filter to verify template does exist, method is inherinted from InputTextAndSearchOnFilter class
   
   // Compare results from flter with element from list
   
   
   
    
    
    
}
