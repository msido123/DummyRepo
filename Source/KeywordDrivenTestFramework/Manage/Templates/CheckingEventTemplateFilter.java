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
import static KeywordDrivenTestFramework.Manage.Templates.CheckingEventTemplateFilter.obj;
;
/**
 *
 * @author ZiyandaP
 */
public class CheckingEventTemplateFilter extends BaseClass{
    
    int counter = 1;
    String errorMsg;
    TestEntity testData;
    String defaultWindow;
    String popUpWindow;
    public static CheckTemplatesLoadInfoZee obj;
    
    
     
    
    public CheckingEventTemplateFilter(TestEntity testData) {
        
        this.testData = testData;
        obj = new CheckTemplatesLoadInfoZee(testData);
        
    }
    public TestResult executeTest() throws InterruptedException {
        
        this.setStartTime();
       // System.out.println("I ATLEAST GOT IN HERE!!!!");
        //pause(1500);
        if(!obj.navigateToManageTabZee()){
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Manage Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Manage Tab - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Manage Tab", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!obj.navigateToTemplatesTabZee()){
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Templates Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Templates Tab - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Templates Tab", this.getTotalExecutionTime());
        }
        pause(1000);
        
        if(!obj.navigateToEventTemplatesZee()){
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Event Templates", true);
            counter++;
            narrator.failedMessage("Failed to click on Event Templates- "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Event Templates", this.getTotalExecutionTime());
        }
        pause(1000);
        
        if(!isFilterClicked()){
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on the filter", true);
            counter++;
            narrator.failedMessage("Failed to click on the filter - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the filter", this.getTotalExecutionTime());
        }
        pause(1000);
        
        if(!addTextToFilter("Default event template for Mix2310i")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to add text to filter", true);
            counter++;
            narrator.failedMessage("Failed to add text to filter - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to add text to filter", this.getTotalExecutionTime());
        }
        pause(1000);
        
        if(!checkRow1Column1("Default event template for Mix2310i")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to match data of Row1Column1 with that of Filter", true);
            counter++;
            narrator.failedMessage("Failed to click on Template name - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to match data of Row1Column2 with that of Filter ", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!checkRow1Column2("0")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to match data of Row1Column2 with that of Filter", true);
            counter++;
            narrator.failedMessage("Failed to click on Template name - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to match data of Row1Column2 with that of Filter ", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!checkRow1Column3("2")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to match data of Row1Column2 with that of Filter", true);
            counter++;
            narrator.failedMessage("Failed to click on Template name - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to match data of Row1Column3 with that of Filter ", this.getTotalExecutionTime());
        }
        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully Checks that the Filter works.", this.getTotalExecutionTime());
    }      
      
    public boolean isFilterClicked() {
        if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[1]")) {
            
            errorMsg = "Failed to click on the filter";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("(//INPUT[@type='text'])[1]");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked on the filter -", false);
        //SeleniumDriverInstance.
        counter++;
        return true;
    }
    
    public boolean addTextToFilter(String textToEnter) {
        if(!SeleniumDriverInstance.waitForElementByXpath("//input[@class=\"filter-search-input input-medium filter-clear ng-pristine ng-valid\"]")) {
            
            errorMsg = "Failed to add text to filter";
            return false;
        }
        
        SeleniumDriverInstance.EnterTextByXpath("//input[@class=\"filter-search-input input-medium filter-clear ng-pristine ng-valid\"]", textToEnter);
        SeleniumDriverInstance.takeScreenShot(counter + "- Text addded successfully -", false);
        pause(1000);
        counter++;
        return true;
    }
   
    public boolean checkRow1Column1(String textToCheck){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//SPAN[text()='Default event template for MiX2310i'])")) {
            
            errorMsg = "Failed to return data typed on the filter";
            return false;
         }
        String checkText  = SeleniumDriverInstance.retrieveTextByXpath("(//SPAN[text()='Default event template for MiX2310i'])");
        System.out.println(checkText);
        if(!(checkText.equalsIgnoreCase(textToCheck))){
            
            errorMsg = "Failed to match data on the filter with that of first row";
            testData.extractParameter("Event template name", checkText, "FAIL");
            SeleniumDriverInstance.takeScreenShot("compared text does not match!!", false);
            counter++;
            return false;
            
        }
        
            testData.extractParameter("Event template name", checkText, "PASS");
            SeleniumDriverInstance.takeScreenShot("compared text is now matching!!",false);
            counter++;        
            return true;       
        
   
    }
    public boolean checkRow1Column2(String dataToCheck){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//DIV)[104]")) {
            
            errorMsg = "Failed to check "+dataToCheck+" row1column2";
            return false;
         }
        String checkData = SeleniumDriverInstance.retrieveTextByXpath("(//DIV)[104]");
        System.out.println(checkData);
        if((!checkData.contains(dataToCheck))){
            
            errorMsg = "Failed to match data on the filter with that of first row";
            testData.extractParameter("Asset count", checkData, "FAIL");
            SeleniumDriverInstance.takeScreenShot(counter + "- Clicked " +dataToCheck+ " successfully -", false);
            counter++;
            return false;
            
        }
            testData.extractParameter("Asset count", checkData, "PASS");
            SeleniumDriverInstance.takeScreenShot(counter + "- Clicked " +dataToCheck+ " successfully -",false);
            counter++;        
        return true;       
           
    }
    public boolean checkRow1Column3(String dataToCheck){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//DIV)[105]")) {
            
            errorMsg = "Failed to click "+dataToCheck+" row";
            return false;
         }
        String checkData = SeleniumDriverInstance.retrieveTextByXpath("(//DIV)[105]");
        System.out.println(checkData);
        if(!(checkData.contains(dataToCheck))){
            
            errorMsg = "Failed to match data on the filter with that of first row";
            testData.extractParameter("Configuration group count", checkData, "FAIL");
            SeleniumDriverInstance.takeScreenShot(counter + "- Clicked " +dataToCheck+ " successfully -", false);
            counter++;
            return false;
            
        }
            testData.extractParameter("Configuration group count", checkData, "PASS");
            SeleniumDriverInstance.takeScreenShot(counter + "- Clicked " +dataToCheck+ " successfully -",false);
            counter++;        
        return true;       
           
    }

}