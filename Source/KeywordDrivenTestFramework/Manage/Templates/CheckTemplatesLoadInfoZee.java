/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.Manage.Templates;

import KeywordDrivenTestFramework.Core.BaseClass;
import static KeywordDrivenTestFramework.Core.BaseClass.SeleniumDriverInstance;
import static KeywordDrivenTestFramework.Core.BaseClass.narrator;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;

/**
 *
 * @author ZiyandaP
 */
public class CheckTemplatesLoadInfoZee extends BaseClass {
    //Variables
    
    int counter = 1;
    String errorMsg;
    TestEntity testData;
  //  WebDriver driver = new ChromeDriver();
    String defaultWindow;
    String popUpWindow;
    
    //Constructor
    
    public CheckTemplatesLoadInfoZee(TestEntity testData) {
        
        this.testData = testData;
    }
    
    //MethodsForNavigation
    
    public boolean navigateToManageTabZee(){
        
        if(!SeleniumDriverInstance.waitForElementByXpath("(//A[@href='#'])[2]")) {
            
            errorMsg = "Failed to click on Manage Tab";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("(//A[@href='#'])[2]");
        SeleniumDriverInstance.takeScreenShot(counter + "- Clicked Manager tab successfully -", false);
        counter++;
        return true;
    
    }
    public boolean navigateToTemplatesTabZee(){
        
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@ng-href='#/config-admin/templates'][text()='Templates']")) {
            
            errorMsg = "Failed to click on Templates Tab";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//A[@ng-href='#/config-admin/templates'][text()='Templates']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Clicked Templates tab successfully -", false);
        counter++;
        return true;
    }
    public boolean navigateToMobileDeviceZee(){
        
        if(!SeleniumDriverInstance.waitForElementByXpath("//a[@class='ng-binding'][text()='Mobile device templates']")) {
            
            errorMsg = "Failed to click on MobileDevice Tab";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//a[@class='ng-binding'][text()='Mobile device templates']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Clicked MobileDevice tab successfully -", false);
        counter++;
        return true;
    }
    public boolean compareColum1(String textToCompare){
        
         if(!SeleniumDriverInstance.waitForElementByXpath("//SPAN[@ng-hide='column.headingClass || !column.title'][text()='Template name']")) {
            
            errorMsg = "Failed to click "+textToCompare+" Column";
            return false;
         }
        String checkText  = SeleniumDriverInstance.retrieveTextByXpath("//SPAN[@ng-hide='column.headingClass || !column.title'][text()='Template name']");
        if(!(checkText.contains(textToCompare))){
            
            errorMsg = "Failed to compare";
            testData.extractParameter("Mobile device templates title", checkText, "FAIL");
            SeleniumDriverInstance.takeScreenShot(counter + "- Clicked " +textToCompare+ " successfully -", false);
            counter++;
            return false;
            
        }
            testData.extractParameter("Mobile device templates title", checkText, "PASS");
            SeleniumDriverInstance.takeScreenShot(counter + "- Clicked " +textToCompare+ " successfully -",true);
            counter++;        
        return true;
    }   
    public boolean navigateToLocationTemplatesZee(){
        
        if(!SeleniumDriverInstance.waitForElementByXpath("//a[@class='ng-binding'][text()='Location templates']")) {
            
            errorMsg = "Failed to click on LocationTemplates Tab";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//a[@class='ng-binding'][text()='Location templates']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Clicked LocationTemplates tab successfully -", false);
        counter++;
        return true;
    }
    public boolean compareColum2(String textToCompare){
        
         if(!SeleniumDriverInstance.waitForElementByXpath("//SPAN[@ng-hide='column.headingClass || !column.title'][text()='Asset count']")) {
            
            errorMsg = "Failed to click on " +textToCompare+ " Column";
            return false;
         }
        String checkText  = SeleniumDriverInstance.retrieveTextByXpath("//SPAN[@ng-hide='column.headingClass || !column.title'][text()='Asset count']");
        if(!(checkText.contains(textToCompare))){
            
            errorMsg = "Failed to compare";
            testData.extractParameter("Location templates title", checkText, "FAIL");
            SeleniumDriverInstance.takeScreenShot(counter + "- Clicked " +textToCompare+ " successfully -", false);
            counter++;
            return false;
            
        }
            testData.extractParameter("Location templates title", checkText, "PASS");
            SeleniumDriverInstance.takeScreenShot(counter + "- Clicked " +textToCompare+ " successfully -",true);
            counter++;        
            return true;
    }    
    public boolean navigateToEventTemplatesZee(){
        
        if(!SeleniumDriverInstance.waitForElementByXpath("//a[@class='ng-binding'][text()='Event templates']")) {
            
            errorMsg = "Failed to click on EventTemplates Tab";
            return false;
        }
 
        SeleniumDriverInstance.clickElementByXpath("//a[@class='ng-binding'][text()='Event templates']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Clicked EventTemplates tab successfully -", false);
        counter++;
        return true;
    }
    public boolean compareColum3(String textToCompare){
        
         if(!SeleniumDriverInstance.waitForElementByXpath("//SPAN[@ng-hide='column.headingClass || !column.title'][text()='Configuration group count']")) {
            
            errorMsg = "Failed to click " +textToCompare+ " Column";
            return false;
         }
        String checkText  = SeleniumDriverInstance.retrieveTextByXpath("//SPAN[@ng-hide='column.headingClass || !column.title'][text()='Configuration group count']");
        if(!(checkText.contains(textToCompare))){
            
            errorMsg = "Failed to compare";
            testData.extractParameter("Event templates title", checkText, "FAIL");
            SeleniumDriverInstance.takeScreenShot(counter + "- Clicked " +textToCompare+ " successfully -", false);
            counter++;
            return false;
            
        }
            testData.extractParameter("Event templates title", checkText, "PASS");
            SeleniumDriverInstance.takeScreenShot(counter + "- Clicked " +textToCompare+ " successfully -",true);
            counter++;        
            return true;
    }

public TestResult executeTest() throws InterruptedException {
        
        this.setStartTime();
        
        if(!navigateToManageTabZee()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Manage Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Manage Tab - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Manage Tab", this.getTotalExecutionTime());
        }
        
        if(!navigateToTemplatesTabZee()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Templates Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Templates Tab - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Templates Tab", this.getTotalExecutionTime());
        }
        if(!navigateToMobileDeviceZee()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Mobile Device Templates", true);
            counter++;
            narrator.failedMessage("Failed to click on Mobile Device Templates- "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Mobile Device Templates ", this.getTotalExecutionTime());
        } 
        
        if(!compareColum1("Template name")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Template name", true);
            counter++;
            narrator.failedMessage("Failed to click on Template name - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Template name ", this.getTotalExecutionTime());
        }


        if(!navigateToLocationTemplatesZee()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Location Templates", true);
            counter++;
            narrator.failedMessage("Failed to click on Location Templates - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Location Templates", this.getTotalExecutionTime());
        }
        if(!compareColum2("Asset count")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Asset count", true);
            counter++;
            narrator.failedMessage("Failed to click on Asset count - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Asset count", this.getTotalExecutionTime());
        }
        if(!navigateToEventTemplatesZee()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Event Templates", true);
            counter++;
            narrator.failedMessage("Failed to click on Event Templates- "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Event Templates", this.getTotalExecutionTime());
        }
        if(!compareColum3("Configuration group count")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Configuration group count", true);
            counter++;
            narrator.failedMessage("Failed to click on Configuration group count "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Configuration group count", this.getTotalExecutionTime());
        }        
        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully Check that Templates loads with info.", this.getTotalExecutionTime());
}   
}


        