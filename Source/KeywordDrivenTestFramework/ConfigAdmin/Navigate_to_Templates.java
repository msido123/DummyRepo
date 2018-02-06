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
        
        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigated to mix.", this.getTotalExecutionTime());
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
        if(!SeleniumDriverInstance.CheckIfElementIsSelected("//a[text() = 'Event templates']")) {
            errorMsg = "Failed to select Events template";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("//a[text() = 'Event templates']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Events template clicked successfully -", false);
        counter++;
        return true;
        
   
    }
    public boolean clickEventsTempName() {
        if(!SeleniumDriverInstance.CheckIfElementDisplayedByXpath("//SPAN[@ng-hide='column.headingClass || !column.title'][text()='Template name']")) {
            errorMsg = "Template name cannot be displayed";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("//SPAN[@ng-hide='column.headingClass || !column.title'][text()='Template name']");
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
        if(!SeleniumDriverInstance.CheckIfElementDisplayedByXpath("//SPAN[@ng-hide='column.headingClass || !column.title'][text()='Mobile device type']")) {
            
            errorMsg = "Mobile Device Type cannot be displayed";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("//SPAN[@ng-hide='column.headingClass || !column.title'][text()='Mobile device type']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Mobile Device Type clicked successfully", false);
        counter++;
        return true;
    }
    
    
   

}
    