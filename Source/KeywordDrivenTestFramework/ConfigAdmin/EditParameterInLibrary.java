/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.ConfigAdmin;

import static KeywordDrivenTestFramework.Core.BaseClass.SeleniumDriverInstance;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
import KeywordDrivenTestFramework.Core.BaseClass;

/**
 *
 * @author MzuvukileN
 */
public class EditParameterInLibrary extends BaseClass{
    String error;
    int counter = 1;
    int randomValue = 2 + (int)(Math.random() * 98);
    TestEntity testData;
    NavigateToLibraries nav;
    
    public EditParameterInLibrary(TestEntity testData){
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
            narrator.failedMessage("Failed to click on libraries - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on libraries", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully clicked on libraries.", false);
        counter++;
        
        if(!nav.clickParaLibrary()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on parameters library.", false);
            counter++;
            narrator.failedMessage("Failed to click on parameters library - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on parameters library", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully clicked on parameter library.", false);
        counter++;
        
        if(!filterParameterLib("MiX Parameter")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to filter parameter library.", false);
            counter++;
            narrator.failedMessage("Failed to filter parameter library. - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to filter parameter library.", this.getTotalExecutionTime());
        }
        pause(1000);
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully filtered parameter library.", false);
        counter++;
        
        if(!verifyParaTypeAndUnit("Value", "87 Apples")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to verify parameter type and units.", false);
            counter++;
            narrator.failedMessage("Failed to verify parameter type and units. - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to verify parameter type and units.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully verified parameter type and units.", false);
        counter++;
        
        if(!selectEdit()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on edit", false);
            counter++;
            narrator.failedMessage("Failed to click on edit.- "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on edit.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully clicked on edit.", false);
        counter++;
        
        if(!editUnits()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to edit units.", false);
            counter++;
            narrator.failedMessage("Failed to edit units. - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to edit units.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully editted units.", false);
        counter++;
        
        if(!clickSave()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click save.", false);
            counter++;
            narrator.failedMessage("Failed to click save. - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click save.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully clicked save.", false);
        counter++;
        
        pause(2000);
        
        if(!filterParameterLib("MiX Parameter")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to filter parameter library.", false);
            counter++;
            narrator.failedMessage("Failed to filter parameter library. - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to filter parameter library.", this.getTotalExecutionTime());
        }
        pause(1000);
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully filtered parameter library.", false);
        counter++;
        
        if(!verifyParaTypeAndUnit("Value", randomValue + " Apples")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to verify parameter type and units.", false);
            counter++;
            narrator.failedMessage("Failed to verify parameter type and units. - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to verify parameter type and units.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully verified parameter type and units.", false);
        counter++;
        
        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully edited a parameter.", this.getTotalExecutionTime());
    }
    
    public boolean filterParameterLib(String inputText){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[1]")){
            error = "Could not locate the filter tab in Parameter library.";
            return false;
        }
        SeleniumDriverInstance.enterTextByXpath("(//INPUT[@type='text'])[1]", inputText);
        return true;
    }
    
    public boolean verifyParaTypeAndUnit(String parameterType, String units){
        String extractedData1 = SeleniumDriverInstance.retrieveTextByXpath("(//DIV)[101]");
        String extractedData2 = SeleniumDriverInstance.retrieveTextByXpath("(//DIV)[102]");
        if(extractedData1.contains(parameterType) && extractedData2.contains(units)){
            testData.extractParameter("This is the parameter type", extractedData1, screenshotPath);
            testData.extractParameter("This is the parameter units", extractedData2, screenshotPath);
            return true;
        }
        return false;
    }
    
    public boolean selectEdit(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@fleet-tooltip='Actions']")){
            error = "Could not get to the edit panel.";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//A[@fleet-tooltip='Actions']");
        SeleniumDriverInstance.clickElementByXpath("//span[text() = \"Edit\"]");
        return true;
    }
    
    public boolean editUnits(){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[4]")){
            error = "Could not get to the edit page.";
            return false;
        }
        SeleniumDriverInstance.enterTextByXpath("(//INPUT[@type='text'])[4]", randomValue + " Apples");
        return true;
    }
    
    public boolean clickSave(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//BUTTON[@class='btn-wide btn-small btn-success btn ng-scope ng-binding'][text()='Save']")){
            error = "Could enter the new value for units.";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//BUTTON[@class='btn-wide btn-small btn-success btn ng-scope ng-binding'][text()='Save']");
        return true;
    }
}
