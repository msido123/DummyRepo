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
import org.openqa.selenium.By;

/**
 *
 * @author MsimeleloG
 */
public class DuplicateMobileDeviceTemplate extends BaseClass {
    
    int counter = 1;
    String errorMsg = "";
    TestEntity testData;
    int valueToCheckFor = 5;
    
    Navigate_to_Templates navigateToTemplates;
    AddNewTemplate  newMobileDeviceTemplate;
    InputTextAndSearchOnFilter duplicateMobileDevFilterNav;
    CreateMobileDeviceTemplate duplicateMobileDeviceNav;
    EditMobileDeviceTemplate editMobileDeviceTemplateNav;

    public DuplicateMobileDeviceTemplate(TestEntity testData) {
        this.testData = testData;
        navigateToTemplates = new Navigate_to_Templates(testData);
        newMobileDeviceTemplate = new AddNewTemplate(testData);
        duplicateMobileDevFilterNav = new InputTextAndSearchOnFilter(testData);
        duplicateMobileDeviceNav = new CreateMobileDeviceTemplate(testData);
        editMobileDeviceTemplateNav = new EditMobileDeviceTemplate(testData);
    }
    
    public TestResult executeTest() throws InterruptedException {
        
        this.setStartTime();
        
        if(!navigateToTemplates.NavigateToManageTab()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Manage Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Manage Tab - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Manage Tab", this.getTotalExecutionTime());
        }
        
        if(!navigateToTemplates.clickTemplate()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Templates", true);
            counter++;
            narrator.failedMessage("Failed to click on Templates - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Templates", this.getTotalExecutionTime());
        }
        
        if(!navigateToTemplates.clickMobileDeviceTemp()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Mobile Device templates", true);
            counter++;
            narrator.failedMessage("Failed to click on Templates - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Mobile Device templates", this.getTotalExecutionTime());
        }
        
        if(!duplicateMobileDevFilterNav.isFilterClicked()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on the filter", true);
            counter++;
            narrator.failedMessage("Failed to click on the filter - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the filter", this.getTotalExecutionTime());
        }
        
        if(!duplicateMobileDevFilterNav.addTextToFilter("FM 3306/3316")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to add text to filter", true);
            counter++;
            narrator.failedMessage("Failed to add text to filter - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to add text to filter", this.getTotalExecutionTime());
        }
        
        if(!clickDuplicateMobileDeviceTemplate()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click duplicate template", true);
            counter++;
            narrator.failedMessage("Failed to click duplicate template - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click duplicate template", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!enterNewDuplicateMobileDevTemplateName()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to enter new mobile device template name", true);
            counter++;
            narrator.failedMessage("Failed to enter new mobile device template name - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to enter new mobile device template name", this.getTotalExecutionTime());
        }
        pause(2000);
        
        if(!duplicateMobileDeviceNav.clickSaveOnMobileDevTempPage()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Save button ", true);
            counter++;
            narrator.failedMessage("Failed to click on Save button - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Save button", this.getTotalExecutionTime());
        }
        
        if(!editMobileDeviceTemplateNav.clickGreenLinkForMobileDeviceType()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click green link", true);
            counter++;
            narrator.failedMessage("Failed to click green link - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click green link", this.getTotalExecutionTime());
        }
        pause(2000);
        if(!clickMinutesDropDownButton()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on minutes drop down button", true);
            counter++;
            narrator.failedMessage("Failed to click on minutes drop down button - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on minutes drop down button", this.getTotalExecutionTime());
        }
        pause(2000);
        if(!verifyArmingDelayValue(valueToCheckFor + "")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to verify Arming delay value", true);
            counter++;
            narrator.failedMessage("Failed to verify Arming delay value - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to verify Arming delay value", this.getTotalExecutionTime());
        }
        
        if(!newMobileDeviceTemplate.returnToTemplatesListPage()) {
            
             SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Close button ", true);
            counter++;
            narrator.failedMessage("Failed to click on Close button - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Close button", this.getTotalExecutionTime());
        }
        pause(2000);
        if(!newMobileDeviceTemplate.returnToTemplatesListPage()) {
            
             SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Close button ", true);
            counter++;
            narrator.failedMessage("Failed to click on Close button - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Close button", this.getTotalExecutionTime());
        }
        pause(2000);
        
        if(!duplicateMobileDevFilterNav.isFilterClicked()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on the filter", true);
            counter++;
            narrator.failedMessage("Failed to click on the filter - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the filter", this.getTotalExecutionTime());
        }
        
        if(!duplicateMobileDevFilterNav.addTextToFilter("_MiX Mobile Device Template")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to add text to filter", true);
            counter++;
            narrator.failedMessage("Failed to add text to filter - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to add text to filter", this.getTotalExecutionTime());
        }
        
        if(!newMobileDeviceTemplate.clickRemoveNewTemplate()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click remove template", true);
            counter++;
            narrator.failedMessage("Failed to click remove template - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click remove template", this.getTotalExecutionTime());
        }
        pause(1000);
        
        if(!newMobileDeviceTemplate.showPopUp()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to show pop up", true);
            counter++;
            narrator.failedMessage("Failed to show pop up - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to show pop up", this.getTotalExecutionTime());
        }
        
        if(!newMobileDeviceTemplate.confirmRemovalOfNewTemplate()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to remove template", true);
            counter++;
            narrator.failedMessage("Failed to remove template - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to remove template", this.getTotalExecutionTime());
        }
        pause(1000);
        
         return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully duplicated item on Mobile Device Template page.", this.getTotalExecutionTime());
    }
    
    public boolean clickDuplicateMobileDeviceTemplate() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@fleet-tooltip='Actions']")) {
            
            errorMsg = "Cannot click duplicate template";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("//A[@fleet-tooltip='Actions']");
        pause(1000);
        SeleniumDriverInstance.clickElementByXpath("//span[text()='Duplicate']");
        pause(1000);
        SeleniumDriverInstance.takeScreenShot(counter + "- Duplicate clicked successfully -", false);
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
    
    public boolean enterNewDuplicateMobileDevTemplateName() {
        
        if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[1]")) {
            
            errorMsg = "Duplicate mobile device template name cannot be added";
           return false;
        }
        
       SeleniumDriverInstance.EnterTextByXpath("(//INPUT[@type='text'])[1]",myDateStamp() + "_MiX Mobile Device Template");
       SeleniumDriverInstance.takeScreenShot(counter + "- New mobile device template name added successfully -", false);
       counter++;
       return true;
    }
    
    public boolean clickMinutesDropDownButton() {
        
        if(!SeleniumDriverInstance.waitForElementByXpath("(//SELECT[@ng-model='minutes'])[1]")) {
            
            errorMsg = "Arming delay dropdown link not selected";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("(//SELECT[@ng-model='minutes'])[1]");
        SeleniumDriverInstance.takeScreenShot(counter + "- Minutes dropdown link clicked successfully -", false);
        counter++;
        return true;
    }
    
    public boolean verifyArmingDelayValue(String textToCompare) {
        if(!SeleniumDriverInstance.waitForElementByXpath("(//SELECT[@ng-model='minutes'])[1]")) {
            
            errorMsg = "Arming delay dropdown link not selected";
            return false;
        }
        
        String value= SeleniumDriverInstance.Driver.findElement(By.xpath("(//SELECT[@ng-model='minutes'])[1]")).getAttribute("value");
        System.out.println(value);
        //String value = SeleniumDriverInstance.retrieveTextByXpath("(//SELECT[@ng-model='minutes'])[1]");
        if((!value.contains(textToCompare))) {
            
            errorMsg = "Arming delay value not the same";
            testData.extractParameter("Retrieved value", value, "fail");
            SeleniumDriverInstance.takeScreenShot(counter + "- Arming delay value is not 5 minutes -", false);
            counter++;
            return false;
        }
        testData.extractParameter("Retrieved value", value, "pass");
        SeleniumDriverInstance.takeScreenShot(counter + "- Arming delay value is 5 minutes -", false);
        counter++;
        return true;
    }
    
}
