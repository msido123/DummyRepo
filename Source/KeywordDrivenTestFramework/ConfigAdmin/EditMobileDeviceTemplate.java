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
import KeywordDrivenTestFramework.Testing.TestClasses.Login.Navigate;
import static KeywordDrivenTestFramework.Utilities.AppiumDriverUtility.Driver;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author MsimeleloG
 */
public class EditMobileDeviceTemplate extends BaseClass {
    
    int counter = 1;
    String errorMsg = "";
    TestEntity testData;
    
    Navigate_to_Templates navToMobileDevTemplates;
    AddNewTemplate newMobileDevTemplate;
    InputTextAndSearchOnFilter editMobileDeviceNav;
    CreateMobileDeviceTemplate createMobileDevNav;
    Random random = new Random();
    int randomNumber = random.nextInt(5000) + 2000;
    
    public EditMobileDeviceTemplate (TestEntity testData) {
        this.testData = testData;
        
        navToMobileDevTemplates = new Navigate_to_Templates(testData);
        newMobileDevTemplate = new AddNewTemplate(testData);
        editMobileDeviceNav = new InputTextAndSearchOnFilter(testData);
        createMobileDevNav = new CreateMobileDeviceTemplate(testData);
        
        
    }
    
    public EditMobileDeviceTemplate() {}
    
    public TestResult executeTest() throws InterruptedException {
        
        this.setStartTime();
        
        if(!navToMobileDevTemplates.NavigateToManageTab()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Manage Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Manage Tab - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Manage Tab", this.getTotalExecutionTime());
            
        }
        
        if(!navToMobileDevTemplates.clickTemplate()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Templates", true);
            counter++;
            narrator.failedMessage("Failed to click on Templates - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Templates", this.getTotalExecutionTime());
        }
        
        if(!navToMobileDevTemplates.clickMobileDeviceTemp()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Mobile Device templates", true);
            counter++;
            narrator.failedMessage("Failed to click on Templates - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Mobile Device templates", this.getTotalExecutionTime());
        }
        
        if(!editMobileDeviceNav.isFilterClicked()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on the filter", true);
            counter++;
            narrator.failedMessage("Failed to click on the filter - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the filter", this.getTotalExecutionTime());
        }
        
        if(!editMobileDeviceNav.addTextToFilter("z.MiX")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to add text to filter", true);
            counter++;
            narrator.failedMessage("Failed to add text to filter - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to add text to filter", this.getTotalExecutionTime());
        }
        
        if(!clickEditMobileDeviceTemplate()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click edit template", true);
            counter++;
            narrator.failedMessage("Failed to click edit template - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click edit template", this.getTotalExecutionTime());
        }
        
        if(!clickGreenLinkForMobileDeviceType()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click green link", true);
            counter++;
            narrator.failedMessage("Failed to click green link - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click green link", this.getTotalExecutionTime());
        }
        
        if(!editBuzzerFrequency()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to enter buzzer frequency", true);
            counter++;
            narrator.failedMessage("Failed to enter buzzer frequency - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to enter buzzer frequency", this.getTotalExecutionTime());
            
        }
        
        if(!createMobileDevNav.clickSaveOnMobileDevTempPage()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Save button ", true);
            counter++;
            narrator.failedMessage("Failed to click on Save button - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Save button", this.getTotalExecutionTime());
        }
        pause(2000);
        
        if(!showPopUpModal()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to show pop up", true);
            counter++;
            narrator.failedMessage("Failed to show pop up - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to show pop up", this.getTotalExecutionTime());
        }
        
        if(!confirmEditingOfTemplate()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to edit template", true);
            counter++;
            narrator.failedMessage("Failed to edit template - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to edit template", this.getTotalExecutionTime());
        }
        
        if(!newMobileDevTemplate.returnToTemplatesListPage()) {
            
             SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Close button ", true);
            counter++;
            narrator.failedMessage("Failed to click on Close button - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Close button", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!newMobileDevTemplate.returnToTemplatesListPage()) {
            
             SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Close button ", true);
            counter++;
            narrator.failedMessage("Failed to click on Close button - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Close button", this.getTotalExecutionTime());
        }
        pause(1000);
        
        if(!editMobileDeviceNav.isFilterClicked()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on the filter", true);
            counter++;
            narrator.failedMessage("Failed to click on the filter - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the filter", this.getTotalExecutionTime());
        }
        
        if(!editMobileDeviceNav.addTextToFilter("z.MiX")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to add text to filter", true);
            counter++;
            narrator.failedMessage("Failed to add text to filter - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to add text to filter", this.getTotalExecutionTime());
        }
        
        if(!clickEditMobileDeviceTemplate()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click edit template", true);
            counter++;
            narrator.failedMessage("Failed to click edit template - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click edit template", this.getTotalExecutionTime());
        }
        
        if(!clickGreenLinkForMobileDeviceType()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click green link", true);
            counter++;
            narrator.failedMessage("Failed to click green link - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click green link", this.getTotalExecutionTime());
        }
        
        if(!clickBuzzerFrequencyTab()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click Buzzer frequency tab", true);
            counter++;
            narrator.failedMessage("Failed to click Buzzer frequency tab - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click Buzzer frequency tab", this.getTotalExecutionTime());
        }
        
        if(!verifyBuzzerFrequencyValues(randomNumber + "")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to verify random value", true);
            counter++;
            narrator.failedMessage("Failed to verify random value - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to verify random value", this.getTotalExecutionTime());
        }
        
        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully performed edit on Mobile Device Template.", this.getTotalExecutionTime());
    }
    
    
    public boolean clickEditMobileDeviceTemplate() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@fleet-tooltip='Actions']")) {
            
            errorMsg = "Cannot click edit template";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("//A[@fleet-tooltip='Actions']");
        pause(1000);
        SeleniumDriverInstance.clickElementByXpath("//span[text()='Edit']");
        pause(1000);
        SeleniumDriverInstance.takeScreenShot(counter + "- Edit clicked successfully -", false);
        counter++;
        return true;
    }
    
    public boolean clickGreenLinkForMobileDeviceType() {
        if(!SeleniumDriverInstance.waitForElementByXpath("(//H5[@class='ng-binding'])[1]")) {
            
            errorMsg = "Cannot click the link";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("(//H5[@class='ng-binding'])[1]");
        SeleniumDriverInstance.takeScreenShot(counter + "- Link clicked successfully -", false);
        counter++;
        return true;
    }
    
    //String extractData = SeleniumDriverInstance.retrieveTextByXpath("(//INPUT[@type='text'])[2]");
    public boolean editBuzzerFrequency() {
        String extractData = SeleniumDriverInstance.retrieveTextByXpath("(//INPUT[@type='text'])[2]");
        if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[2]")) {
            
            errorMsg = "Buzzer frequency tab not clicked";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("(//INPUT[@type='text'])[2]");
        SeleniumDriverInstance.enterTextByXpath("(//INPUT[@type='text'])[2]", randomNumber + "");
        testData.extractParameter("Expected Value", randomNumber + "", screenshotPath);
        SeleniumDriverInstance.takeScreenShot(counter + "- Random number added successfully -", false);
        counter++;
        return true;
    }
    
    public boolean showPopUpModal() {
        
        if(!SeleniumDriverInstance.waitForElementByXpath("(//DIV[@class='modal-inner-body white-box-padding'])[2]")) {
            
            errorMsg = "Pop Up not displayed";
            return false;
        }
        
        SeleniumDriverInstance.takeScreenShot(counter + "- Pop up showed successfully -", false);
        counter++;
        return true;
    }
    
    public boolean confirmEditingOfTemplate() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//BUTTON[@ng-show='$modal.okayButton'][text()='Yes']")) {
            
            errorMsg = "Template cannot be edited";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("//BUTTON[@ng-show='$modal.okayButton'][text()='Yes']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Template edited successfully -", false);
        counter++;
        return true;
    }
    
    // verify buzzer frequency values
    
    public boolean clickBuzzerFrequencyTab() {
        if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[2]")) {
            
            errorMsg = "Buzzer frequency tab not clicked";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("(//INPUT[@type='text'])[2]");
        SeleniumDriverInstance.takeScreenShot(counter + "- Buzzer frequency tab clicked successfully -", false);
        counter++;
        return true;
    }
    public boolean verifyBuzzerFrequencyValues(String textToCompare) {
        if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[2]")) {
            
            errorMsg = "Buzzer Frequency tab not selected";
             return false;
        }
        
        //String extractData = Driver.findElement(By.xpath("(//INPUT[@type='text'])[2]")).getText();
         String value= SeleniumDriverInstance.Driver.findElement(By.xpath("(//INPUT[@type='text'])[2]")).getAttribute("value");
        //String extractData = SeleniumDriverInstance.retrieveTextByXpath("");
        if((!value.equalsIgnoreCase(textToCompare))) {
             errorMsg = "Random is not the same";
             //return false;
          }
        
        testData.extractParameter("Retrieved value", value, screenshotPath);
        SeleniumDriverInstance.takeScreenShot(counter + "- Random numbers are the same -", false);
        counter++;
        return true;
        
    }
    
    
}
