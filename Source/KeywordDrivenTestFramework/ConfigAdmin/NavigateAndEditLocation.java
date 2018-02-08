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
public class NavigateAndEditLocation extends BaseClass{
    String error;
    int counter = 1;
    int randomSpeed = (int)(Math.random() * 200);
    String extractedData1;
    String extractedData2;
    TestEntity testData;
    NavigateToLibraries nav;
    
    public NavigateAndEditLocation(TestEntity testData){
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
        
        if(!nav.clickLocationLibrary()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on location library", false);
            counter++;
            narrator.failedMessage("Failed to click on location library - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on location library", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully clicked on location library.", false);
        counter++;
        
        if(!filter("z. MiX")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click to filter", false);
            counter++;
            narrator.failedMessage("Failed to click to filter - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to filter", this.getTotalExecutionTime());
        }
        //EXTRACTING BEFORE DATA
        extractedData2 = SeleniumDriverInstance.retrieveTextByXpath("(//DIV)[103]");
        
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully filtered.", false);
        counter++;
        
        pause(1000);
        if(!editEvent()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to edit event.", false);
            counter++;
            narrator.failedMessage("Failed to edit event - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to edit event", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully editted event.", false);
        counter++;
        
        
        if(!inputRandomSpeed()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to input random speed.", false);
            counter++;
            narrator.failedMessage("Failed to input random speed - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to input random speed.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully input random speed.", false);
        counter++;
        
        pause(2000);
        if(!filter("z. MiX")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click to filter", false);
            counter++;
            narrator.failedMessage("Failed to click to filter - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to filter", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully filtered.", false);
        counter++;
        
        pause(1000);
        if(!checkResultOfEdit()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Results do not match the input data.", false);
            counter++;
            narrator.failedMessage("Results do not match the input data - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Results do not match the input data.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully edited a location.", false);
        counter++;
        
        testData.extractParameter("Extracted Data Before Edit", extractedData2, screenshotPath);
        testData.extractParameter("Extracted Data After Edit", extractedData1, screenshotPath);
        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully edited an event.", this.getTotalExecutionTime());
    }
    
    public boolean editEvent(){
        if(!SeleniumDriverInstance.CheckIfElementDisplayedByXpath("//A[@fleet-tooltip='Actions']")){
            error = "No drop down option to remove event.";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("//A[@fleet-tooltip='Actions']");
        SeleniumDriverInstance.clickElementByXpath("//span[text()='Edit']");
        return true;
    }
    
    public boolean inputRandomSpeed(){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//DIV[@class='page-header'])[1]")){
            error = "Not able to input random speed;";
        }
        
        //SeleniumDriverInstance.clearAndEnterTextByXpath("//INPUT[@type='number'])[1]", Integer.toString(randomSpeed));
        pause(2000);
        SeleniumDriverInstance.enterTextByXpath("(//INPUT[@type='number'])[1]", randomSpeed+"");
        SeleniumDriverInstance.clickElementByXpath("//BUTTON[@class='btn-wide btn-small btn-success btn ng-scope ng-binding'][text()='Save']");
        return true;
    }
    
    public boolean filter(String textToFilter){
        if(!SeleniumDriverInstance.CheckIfElementDisplayedByXpath("(//INPUT[@type='text'])[1]")){
            error = "Filter is not selected.";
            return false;
        }
        
        SeleniumDriverInstance.enterTextByXpath("(//INPUT[@type='text'])[1]", "z. MiX");
        return true;
    }
    
    public boolean checkResultOfEdit(){
        boolean isEdited = false;
        if(!SeleniumDriverInstance.waitForElementByXpath("(//DIV)[103]")){
            error = "Did not filter properly.";
            return isEdited;
        }
        
        extractedData1 = SeleniumDriverInstance.retrieveTextByXpath("(//DIV)[103]");
        if(extractedData1.contains(randomSpeed+"")){
            isEdited = true;
        }
        return isEdited;
    }
}
