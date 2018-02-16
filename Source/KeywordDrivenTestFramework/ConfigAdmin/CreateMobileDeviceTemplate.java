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
public class CreateMobileDeviceTemplate extends BaseClass {
    
    int counter = 1;
    String errorMsg = "";
    TestEntity testData;
    
    Navigate_to_Templates navigationToMobileDevTemp; // /used to access method from the Navigate_to_Templates Class
    AddNewTemplate createMobileDevTemplate; ///used to access method from the AddNewTemplate Class
    InputTextAndSearchOnFilter mobileDeviceTempNav; // used to access method from the InputTextAndSearchOnFilter Class
    
    public CreateMobileDeviceTemplate(TestEntity testData) {
        
        this.testData = testData;
        navigationToMobileDevTemp = new Navigate_to_Templates(testData);
        createMobileDevTemplate = new AddNewTemplate(testData);
        mobileDeviceTempNav = new InputTextAndSearchOnFilter(testData);
    }
    
    public TestResult executeTest() throws InterruptedException {
        
        this.setStartTime();
        
        if(!navigationToMobileDevTemp.NavigateToManageTab()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Manage Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Manage Tab - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Manage Tab", this.getTotalExecutionTime());
        }
        
        if(!navigationToMobileDevTemp.clickTemplate()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Templates", true);
            counter++;
            narrator.failedMessage("Failed to click on Templates - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Templates", this.getTotalExecutionTime());
        }
        
        if(!navigationToMobileDevTemp.clickMobileDeviceTemp()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Mobile Device templates", true);
            counter++;
            narrator.failedMessage("Failed to click on Templates - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Mobile Device templates", this.getTotalExecutionTime());
        }
        
        if(!createMobileDevTemplate.clickAddNewTemplateButton()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on add new template button", true);
            counter++;
            narrator.failedMessage("Failed to click on add new template button - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on add new template button", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!clickDropDownButton()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on drop down button", true);
            counter++;
            narrator.failedMessage("Failed to click on drop down button - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on drop down button", this.getTotalExecutionTime());
        }
        pause(1000);
        
        if(!enterNewMobileDevTemplateName()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to enter new mobile device template name", true);
            counter++;
            narrator.failedMessage("Failed to enter new mobile device template name - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to enter new mobile device template name", this.getTotalExecutionTime());
        }
        pause(1000);
        
        if(!clickSaveOnMobileDevTempPage()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Save button ", true);
            counter++;
            narrator.failedMessage("Failed to click on Save button - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Save button", this.getTotalExecutionTime());
        }
        pause(2000);
        
        if(!verifyThatStringIsOnThePage("Mobile device type : FM 3306/3316")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to find string - " + "- Mobile device type : FM 3306/3316 -", true);
            counter++;
            narrator.failedMessage("Failed to find string  - " + "- Mobile device type : FM 3306/3316 - " +errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to find string" + "- Mobile device type : FM 3306/3316 - " , this.getTotalExecutionTime());
        }
        
        if(!createMobileDevTemplate.returnToTemplatesListPage()) {
            
             SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Close button ", true);
            counter++;
            narrator.failedMessage("Failed to click on Close button - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Close button", this.getTotalExecutionTime());
        }
        
        if(!mobileDeviceTempNav.isFilterClicked()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on the filter", true);
            counter++;
            narrator.failedMessage("Failed to click on the filter - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the filter", this.getTotalExecutionTime());
        }
        
        if(!mobileDeviceTempNav.addTextToFilter("_MiX Mobile Device Template")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to add text to filter", true);
            counter++;
            narrator.failedMessage("Failed to add text to filter - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to add text to filter", this.getTotalExecutionTime());
        }
        
        if(!mobileDeviceTempNav.compareFilterResults("_MiX Mobile Device Template")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to get desired result", true);
            counter++;
            narrator.failedMessage("Failed to get desired result - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to get desired result", this.getTotalExecutionTime());
        }
        
        if(!createMobileDevTemplate.clickRemoveNewTemplate()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click remove template", true);
            counter++;
            narrator.failedMessage("Failed to click remove template - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click remove template", this.getTotalExecutionTime());
        }
        pause(1000);
        
        if(!createMobileDevTemplate.showPopUp()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to show pop up", true);
            counter++;
            narrator.failedMessage("Failed to show pop up - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to show pop up", this.getTotalExecutionTime());
        }
        
        if(!createMobileDevTemplate.confirmRemovalOfNewTemplate()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to remove template", true);
            counter++;
            narrator.failedMessage("Failed to remove template - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to remove template", this.getTotalExecutionTime());
        }
        pause(1000);
        
        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigated to the Events Template Page.", this.getTotalExecutionTime());
    }
    
    public boolean clickDropDownButton() {
        
        if(!SeleniumDriverInstance.waitForElementByXpath("//SELECT[@name='deviceId']")) {
            
            errorMsg = "Drop down button not clicked";
            return false;
        }
        
        SeleniumDriverInstance.selectFromDropDownListUsingXpath("//SELECT[@name='deviceId']", "FM 3306/3316");
        SeleniumDriverInstance.takeScreenShot(counter + "- Drop down button clicked successfully -", false);
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
    
    public boolean enterNewMobileDevTemplateName() {
        
        if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[1]")) {
           
           errorMsg = "Location template name cannot be added";
           return false;
       }
       
       SeleniumDriverInstance.EnterTextByXpath("(//INPUT[@type='text'])[1]",myDateStamp() + "_MiX Mobile Device Template");
       SeleniumDriverInstance.takeScreenShot(counter + "- New location template name added successfully -", false);
       counter++;
       return true;
   }
    
    public boolean clickSaveOnMobileDevTempPage() {
        
        if(!SeleniumDriverInstance.waitForElementByXpath("//BUTTON[@class='btn-wide btn-small btn-success btn ng-scope ng-binding'][text()='Save']")) {
            
            errorMsg = "Could not click save button";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("//BUTTON[@class='btn-wide btn-small btn-success btn ng-scope ng-binding'][text()='Save']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Save button clicked successfully -", false);
        counter++;
        return true;
    }
    
    // verify that text is list
    
    public boolean verifyThatStringIsOnThePage(String textToVerify) {
        
        if(!SeleniumDriverInstance.waitForElementByXpath("(//H5[@class='ng-binding'])[1]")) {
            
            errorMsg = "Text tab not selected ";
            return false;
        }
        
        String extractData = SeleniumDriverInstance.retrieveTextByXpath("(//H5[@class='ng-binding'])[1]");
        if((!extractData.equalsIgnoreCase(textToVerify))) {
             errorMsg = "Text Not found";
          }
         
            SeleniumDriverInstance.takeScreenShot(counter + "- Text found successfully -", false);
            
         counter++;
         return true;
    }
    
    
    
}
