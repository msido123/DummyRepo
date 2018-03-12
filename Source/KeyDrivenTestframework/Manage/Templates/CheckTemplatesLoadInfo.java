/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeyDrivenTestframework.Manage.Templates;

import KeywordDrivenTestFramework.Core.BaseClass;
import static KeywordDrivenTestFramework.Core.BaseClass.SeleniumDriverInstance;
import static KeywordDrivenTestFramework.Core.BaseClass.narrator;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;

/**
 *
 * @author PhathuxoloJ
 */
public class CheckTemplatesLoadInfo extends BaseClass {
   int counter = 1;
   String errorMessage;
   TestEntity testData;
   
    public CheckTemplatesLoadInfo(TestEntity testData){
        this.testData = testData;
    }

    public TestResult executeTest() throws InterruptedException{
        this.setStartTime();
        
        if(!navigateToManageTab()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Manage Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Manage Tab - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Manage Tab", this.getTotalExecutionTime());
        }
        
        if(!navigateToTemplatesTab()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Templates Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Templates Tab - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Templates Tab", this.getTotalExecutionTime());
        }
         
        if(!navigateToMobileDeviceTemplates()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Mobile device Templates Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Mobile device Templates Tab - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Mobile device Templates Tab", this.getTotalExecutionTime());
        }
        pause(2000);
        
        if(!compareColumnTitleOne("Template name")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to compare comlumn headings", true);
            counter++;
            narrator.failedMessage("Failed to compare comlumn headings - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to compare comlumn headings", this.getTotalExecutionTime());
        } 
        
        if(!navigateToLocationTemplates()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Location Templates Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Location Templates Tab - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Location Templates Tab", this.getTotalExecutionTime());
        } 
        pause(2000);
        if(!compareColumnTitleTwo("Asset count")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to compare comlumn headings", true);
            counter++;
            narrator.failedMessage("Failed to compare comlumn headings - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to compare comlumn headings", this.getTotalExecutionTime());
        }
        
        if(!navigateToEventTemplates()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Event Templates Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Event Templates Tab - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Event Templates Tab", this.getTotalExecutionTime());
        } 
        pause(200);
         if(!compareColumnTitleThree("Configuration group count")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to compare comlumn headings", true);
            counter++;
            narrator.failedMessage("Failed to compare comlumn headings - "+errorMessage);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to compare comlumn headings", this.getTotalExecutionTime());
        } 
        
        
        return new TestResult(testData,Enums.ResultStatus.PASS,"Successfully checked that all templates contains headings",this.getTotalExecutionTime());
    }

    public boolean navigateToManageTab() {
        if(!SeleniumDriverInstance.waitForElementByXpath("(//A[@href='#'])[2]")) {
            errorMessage = "Failed to click on Manager Tab";
                return false;
        }
        SeleniumDriverInstance.clickElementByXpath("(//A[@href='#'])[2]");
        SeleniumDriverInstance.takeScreenShot(counter + "- Clicked Manager tab successfully -", false);
        counter++;
        return true;
    }
    
    public boolean navigateToTemplatesTab() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@ng-href='#/config-admin/templates'][text()='Templates']")) {    
            errorMessage = "Failed to click on Templates Tab";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//A[@ng-href='#/config-admin/templates'][text()='Templates']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Clicked Templates tab successfully -", false);
        counter++;
        return true;
    } 

    public boolean navigateToMobileDeviceTemplates() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//a[@class='ng-binding'][text()='Mobile device templates']")) {    
            errorMessage = "Failed to click on Mobile Device Templates Tab";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//a[@class='ng-binding'][text()='Mobile device templates']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Clicked  Mobile Device Templates tab successfully -", false);
        counter++;
        return true;
    } 
    
    public boolean navigateToLocationTemplates() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//a[@class='ng-binding'][text()='Location templates']")) {    
            errorMessage = "Failed to click on Location Templates Tab";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//a[@class='ng-binding'][text()='Location templates']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Clicked  Location Templates tab successfully -", false);
        counter++;
        return true;
    } 

    public boolean navigateToEventTemplates() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//a[@class='ng-binding'][text()='Event templates']")) {    
            errorMessage = "Failed to click on Event Templates Tab";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//a[@class='ng-binding'][text()='Event templates']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Clicked  Event Templates tab successfully -", false);
        counter++;
        return true;
    } 
    
    public boolean compareColumnTitleOne(String textToCompare){
        if(!SeleniumDriverInstance.waitForElementByXpath("//SPAN[@ng-hide='column.headingClass || !column.title'][text()='Template name']")) {    
            errorMessage = "no xPath found for "+ textToCompare;
            return false;
        } 
        
        String extractedText = SeleniumDriverInstance.retrieveTextByXpath("//SPAN[@ng-hide='column.headingClass || !column.title'][text()='Template name']");
        if(!(extractedText.contains(textToCompare))){
            errorMessage = "xPath is present";
            testData.extractParameter("Mobile device olumn title", extractedText, "FAIL");
            SeleniumDriverInstance.takeScreenShot("Compared values are not the same", false);
            counter++;
            return false;
        }
        testData.extractParameter("Mobile device column title",extractedText,"PASS");
        SeleniumDriverInstance.takeScreenShot(counter + "- Mobile device templates heading exists -", true);
        counter++;
        return extractedText.contains(textToCompare);      
    }
    
    public boolean compareColumnTitleTwo(String textToCompare){
        if(!SeleniumDriverInstance.waitForElementByXpath("//SPAN[@ng-hide='column.headingClass || !column.title'][text()='Asset count']")) {    
            errorMessage = "no xPath found for "+ textToCompare;
            return false;
        } 
       
       String extractedText = SeleniumDriverInstance.retrieveTextByXpath("//SPAN[@ng-hide='column.headingClass || !column.title'][text()='Asset count']");
       if(!(extractedText.contains(textToCompare))){
            errorMessage = "xPath is present";
            testData.extractParameter("Location template column title", extractedText, "FAIL");
            SeleniumDriverInstance.takeScreenShot("Compared values are not the same", false);
            counter++;
            return false;
       }
       testData.extractParameter("Location template column title",extractedText,"PASS");
       SeleniumDriverInstance.takeScreenShot(counter + "- Location templates heading exists -", true);
       counter++;
       return extractedText.contains(textToCompare);      
    }
     
    public boolean compareColumnTitleThree(String textToCompare){
        if(!SeleniumDriverInstance.waitForElementByXpath("//SPAN[@ng-hide='column.headingClass || !column.title'][text()='Configuration group count']")) {    
            errorMessage = "no xPath found for "+ textToCompare;
            return false;
        } 
       
       String extractedText = SeleniumDriverInstance.retrieveTextByXpath("//SPAN[@ng-hide='column.headingClass || !column.title'][text()='Configuration group count']");
       if(!(extractedText.contains(textToCompare))){
            errorMessage = "xPath is present";
            testData.extractParameter("Event template column title", extractedText, "FAIL");
            SeleniumDriverInstance.takeScreenShot("Compared values are not the same", false);
            counter++;
            return false;
       }
       testData.extractParameter("Event template column title",extractedText,"PASS");
       SeleniumDriverInstance.takeScreenShot(counter + "- Event templates heading exists -", true);
       counter++;
       return extractedText.contains(textToCompare);      
    }
}
