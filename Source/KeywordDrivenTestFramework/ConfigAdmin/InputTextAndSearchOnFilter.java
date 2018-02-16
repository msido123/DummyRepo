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

/**
 *
 * @author MsimeleloG
 */
public class InputTextAndSearchOnFilter extends BaseClass{
    
    int counter = 1;
    String errorMsg = "";
    TestEntity testData;
    Navigate_to_Templates navigation;
    
    public InputTextAndSearchOnFilter(TestEntity testData) {
        this.testData = testData;
        navigation = new Navigate_to_Templates(testData);
    }
    
     public TestResult executeTest() throws InterruptedException {
         
         if(!navigation.NavigateToManageTab()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Manage Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Manage Tab - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Manage Tab", this.getTotalExecutionTime());
         }
         
         if(!navigation.clickTemplate()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Templates", true);
            counter++;
            narrator.failedMessage("Failed to click on Templates - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Templates", this.getTotalExecutionTime());
         }
         
         if(!navigation.clickEventsTemp()) {
             
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Event templates", true);
            counter++;
            narrator.failedMessage("Failed to click on Templates - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Event templates", this.getTotalExecutionTime());
         }
         
         if(!isFilterClicked()) {
             SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on the filter", true);
            counter++;
            narrator.failedMessage("Failed to click on the filter - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the filter", this.getTotalExecutionTime());
         }
         
         if(!addTextToFilter("Default event template for MiX2310i")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to add text to filter", true);
            counter++;
            narrator.failedMessage("Failed to add text to filter - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to add text to filter", this.getTotalExecutionTime());
         }
         
         if(!compareFilterResults("Default event template for MiX2310i")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to get desired result", true);
            counter++;
            narrator.failedMessage("Failed to get desired result - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to get desired result", this.getTotalExecutionTime());
         }
         
          return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigated to the Events Template Page.", this.getTotalExecutionTime());
     }
    
     public InputTextAndSearchOnFilter() {}
     
     // This class is responsible for clicking to
     
     public boolean isFilterClicked() {
         if(!SeleniumDriverInstance.waitForElementByXpathVisibility("(//INPUT[@type='text'])[1]", 10)) {
             errorMsg = "Filter tab not clicked";
             return false;
         }
         
         SeleniumDriverInstance.clickElementByXpath("(//INPUT[@type='text'])[1]");
         SeleniumDriverInstance.takeScreenShotIe(counter + "- Filter clicked successfully -", false);
         counter++;
         return true;
     }
     
     public boolean addTextToFilter(String textToEnter) {
         if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[1]", 10)) {
             
             errorMsg = "Filter not selected";
             return false;
         }
         
         SeleniumDriverInstance.EnterTextByXpath("(//INPUT[@type='text'])[1]", textToEnter);
         SeleniumDriverInstance.takeScreenShot(counter + "- Text Added successfully -", false);
         counter++;
         return true;
         
     }
     
     public boolean compareFilterResults(String textToEnter) {
         
         
         if(!SeleniumDriverInstance.waitForElementByXpath("(//A[@class='clickable-cell ng-scope'])[1]", 10)) {
             errorMsg = "Filter tab not selected";
             return false;
         }
         
          String extractData = SeleniumDriverInstance.retrieveTextByXpath("(//A[@class='clickable-cell ng-scope'])[1]");
          if((!extractData.equalsIgnoreCase(textToEnter))) {
             errorMsg = "Text Not found";
          }
         
            SeleniumDriverInstance.takeScreenShot(counter + "- Text found successfully -", false);
            
         counter++;
         return true;
     }
     
    
}
