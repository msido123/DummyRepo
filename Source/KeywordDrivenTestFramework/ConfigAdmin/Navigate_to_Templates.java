/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.ConfigAdmin;

import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.TestEntity;
import static KeywordDrivenTestFramework.Core.BaseClass.SeleniumDriverInstance;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestResult;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

/**
 *
 * @author MsimeleloG
 */
public class Navigate_to_Templates extends BaseClass {
    
    int counter = 1;
    String errorMsg = "";
    TestEntity testData;
    
    public Navigate_to_Templates(TestEntity testData) {
        this.testData = testData;
    }
    
    public TestResult executeTest() throws InterruptedException {
        this.setStartTime();
        
        if(!NavigateToManageTab()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Manage Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Manage Tab - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Manage Tab", this.getTotalExecutionTime());
        }
        
        if(!clickTemplate()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Templates", true);
            counter++;
            narrator.failedMessage("Failed to click on Templates - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Templates", this.getTotalExecutionTime());
        }
        
        if(!clickEventsTemp()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Event templates", true);
            counter++;
            narrator.failedMessage("Failed to click on Templates - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Event templates", this.getTotalExecutionTime());
        }
        
        if(!clickLocationTemp()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Location templates", true);
            counter++;
            narrator.failedMessage("Failed to click on Templates - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Location templates", this.getTotalExecutionTime());
        }
        
        if(!clickMobileDeviceTemp()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Mobile Device templates", true);
            counter++;
            narrator.failedMessage("Failed to click on Templates - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Mobile Device templates", this.getTotalExecutionTime());
        }
        
        if(!clickEventsTempName()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Template Name", true);
            counter++;
            narrator.failedMessage("Failed to click on Template name - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Template Name", this.getTotalExecutionTime());
        }
        
        if(!clickMobileDeviceType()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Mobile Device Type", true);
            counter++;
            narrator.failedMessage("Failed to click on Template name - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Mobile Device Type", this.getTotalExecutionTime());
        }
           
      return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigated to Templates.", this.getTotalExecutionTime());
    }
    
    public Navigate_to_Templates() {}
    
    // Navigates to Manage tab
    
    public boolean NavigateToManageTab()
    {
        if(!SeleniumDriverInstance.waitForElementByXpath("(//A[@href='#'])[2]", 10)) {
            errorMsg = "Falied to click Manage ";
            return false;
        }
        
        // Take Screenshot
        SeleniumDriverInstance.clickElementByXpath("(//A[@href='#'])[2]");
        SeleniumDriverInstance.takeScreenShot(counter +  "- Clicked the Manage Tab successful - ", false);
        counter++;
        return true;
    }
    
    public boolean clickTemplate() {
       if(!SeleniumDriverInstance.waitForElementByXpath("//A[@ng-href='#/config-admin/templates'][text()='Templates']", 10)) {
           errorMsg = "Failed to click Templates";
           return false;
       }
       
       // Take Screenshot
        SeleniumDriverInstance.clickElementByXpath("//A[@ng-href='#/config-admin/templates'][text()='Templates']");
        SeleniumDriverInstance.takeScreenShot(counter +  "- Template clicked successfully - ", false);
        counter++;
        return true;
    }
    
    public boolean clickEventsTemp() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//a[text() = 'Event templates']", 10)) {
            errorMsg = "Failed to select Events template";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("//a[text() = 'Event templates']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Events template clicked successfully -", false);
        counter++;
        return true;
        
   
    }
    public boolean clickEventsTempName() {
       
        String extractData = SeleniumDriverInstance.retrieveTextByXpath("//SPAN[@ng-hide='column.headingClass || !column.title'][text()='Template name']");
        
        if(!SeleniumDriverInstance.CheckIfElementDisplayedByXpath("//SPAN[@ng-hide='column.headingClass || !column.title'][text()='Template name']")) {
            errorMsg = "Template name cannot be displayed";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("//SPAN[@ng-hide='column.headingClass || !column.title'][text()='Template name']");
        //testData.extractParameter("Extracted Data ", "Name: Data" +  "<br>" + "Notes: data not found","Fail");
        testData.extractParameter("Exrtracted Data", extractData, screenshotPath);
        SeleniumDriverInstance.takeScreenShot(counter + "- Events template name clicked successfully -" , false);
        counter++;
        return true;
    }
    
    public boolean clickAssetCount() {
        if(!SeleniumDriverInstance.CheckIfElementDisplayedByXpath("//SPAN[@ng-hide='column.headingClass || !column.title'][text()='Asset count']")) {
            
            errorMsg = "Asset count cannot be displayed";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//SPAN[@ng-hide='column.headingClass || !column.title'][text()='Asset count']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Asset count clicked sucessfully -", false);
        counter++;
        return true;
    }
    
    public boolean ConfigGrougCount() {
        if(!SeleniumDriverInstance.CheckIfElementDisplayedByXpath("//SPAN[@ng-hide='column.headingClass || !column.title'][text()='Configuration group count']")) {
            
            errorMsg = "Confiiguration Group count cannot be displayed";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("//SPAN[@ng-hide='column.headingClass || !column.title'][text()='Configuration group count']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Configuration Group Count clicked successfully -", false);
        counter++;
        return true;
    }
    
    public boolean clickLocationTemp() {
        
        
        if(!SeleniumDriverInstance.waitForElementByXpath("//a[text() = 'Location templates']", 10)) {
            
            errorMsg = "Failed to click location templates";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("//a[text() = 'Location templates']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Location Templates clicked successfully -", false);
        counter++;
        return true;
    }
    
    public boolean clickMobileDeviceTemp() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//a[text() = 'Mobile device templates']", 10)) {
            
            errorMsg = "Failed to click Mobile Device Template";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("//a[text() = 'Mobile device templates']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Mobile Device Template clicked successfully", false);
        counter++;
        return true;
    }
    
    public boolean clickMobileDeviceType() {
        
        String extractedData = SeleniumDriverInstance.retrieveTextByXpath("//SPAN[@ng-hide='column.headingClass || !column.title'][text()='Mobile device type']");
        
        if(!SeleniumDriverInstance.CheckIfElementDisplayedByXpath("//SPAN[@ng-hide='column.headingClass || !column.title'][text()='Mobile device type']")) {
            
            errorMsg = "Mobile Device Type cannot be displayed";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("//SPAN[@ng-hide='column.headingClass || !column.title'][text()='Mobile device type']");
        testData.extractParameter("Exrtracted Data 1", extractedData, screenshotPath);
        SeleniumDriverInstance.takeScreenShot(counter + "- Mobile Device Type clicked successfully", false);
        counter++;
        return true;
    }
    
    
   

}
    