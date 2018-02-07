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
 * @author MzuvukileN
 */
public class NavigateAndSearch extends BaseClass{
    String error;
    int counter = 1;
    TestEntity testData;
    NavigateToLibraries nav;
    
    public NavigateAndSearch(TestEntity testData){
        this.testData = testData;
        nav = new NavigateToLibraries(testData);
    }
    
    public TestResult executeTest() throws InterruptedException{
        this.setStartTime();
        
        if(!nav.clickManage()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on manage", false);
            counter++;
            narrator.failedMessage("Failed to click on manage - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on manage", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully clicked on Manage.", false);
        counter++;
        
        if(!nav.clickLibraries()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on libraries", false);
            counter++;
            narrator.failedMessage("Failed to click on manage - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on libraries", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully clicked on Libraries.", false);
        counter++;
        
        if(!clickFilter()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on filter", false);
            counter++;
            narrator.failedMessage("Failed to click on manage - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on filter", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully clicked on filter.", false);
        counter++;
        
        if(!inputTextToFilter("* Ignition On")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to enter filter.", false);
            counter++;
            narrator.failedMessage("Failed to enter filter. - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to enter filter.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully entered text to filter.", false);
        counter++;
        
        pause(1000);
        
        if(!checkResultsOfFilter("* Ignition On")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Results of filter do not match.", false);
            counter++;
            narrator.failedMessage("Results of filter do not match. - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Results of filter do not match.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully applied the filter.", false);
        counter++;
        
        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully applied filter.", this.getTotalExecutionTime());
    }
     
    public boolean clickFilter(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//SPAN[@ng-hide='column.headingClass || !column.title'][text()='Event description']")){
            error = "Could not get to filter of event library";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("(//INPUT[@type='text'])[1]");
        return true;
    }
     
    public boolean inputTextToFilter(String textToEnter){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[1]")){
            error = "Filter not selected.";
            return false; 
        }
        SeleniumDriverInstance.enterTextByXpath("(//INPUT[@type='text'])[1]", textToEnter); 
        return true;
    }
     
    public boolean checkResultsOfFilter(String expected){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[1]")){
            error = "The filter data was not entered";
            return false;
        }
        
        String extractedData = SeleniumDriverInstance.retrieveTextByXpath("(//A[@class='clickable-cell ng-scope'])[1]");
        if(!extractedData.equals(expected)|| !extractedData.contains(expected)){
            error = "We could not find the filtered data.";
            return false;
        }
        return true;
    }
}
