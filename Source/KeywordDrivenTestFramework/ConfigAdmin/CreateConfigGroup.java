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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
/**
 *
 * @author MzuvukileN
 */
public class CreateConfigGroup extends BaseClass{
    String error;
    int counter = 1;
    TestEntity testData;
    String configGroupName;
    NavigateAndAddEvent navAdd;
    
    public CreateConfigGroup(TestEntity testData){
        this.testData = testData;
        navAdd = new NavigateAndAddEvent(testData);
        configGroupName = SeleniumDriverInstance.DateAndTimeStamp() + " ConfigGroup";
    }
    
    public TestResult executeTest() throws InterruptedException{
        this.setStartTime();
        
        if(!clickManage()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on manage.", false);
            counter++;
            narrator.failedMessage("Failed to click on manage - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on manage.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully clicked on Manage.", false);
        counter++;
        
        
        if(!clickConfigGroup()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on config groups.", false);
            counter++;
            narrator.failedMessage("Failed to click on config groups - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on config groups", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully clicked on config groups.", false);
        counter++;
        
        pause(1000); // THIS IS TO MAKE SURE CONFIGURATION GROUP SHOWS UP
        
        if(!clickAddButton()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on add button.", false);
            counter++;
            narrator.failedMessage("Failed to click on add button - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on add button", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully clicked on add button.", false);
        counter++;
        
        if(!addDetails()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to add details.", false);
            counter++;
            narrator.failedMessage("Failed to add details - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to add details.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully added details.", false);
        counter++;
        
        if(!filterConfigGroups()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to filter configurations groups.", false);
            counter++;
            narrator.failedMessage("Failed to filter configurations groups - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to filter configurations groups.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully filtered configurations groups.", false);
        counter++;
        
        if(!editFilteredGroup()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to edit filtered configurations groups.", false);
            counter++;
            narrator.failedMessage("Failed to edit filtered configurations groups - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to edit filtered configurations groups.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully edited filtered configurations groups.", false);
        counter++;
        
        if(!checkIfDetsMatch()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to check if details.", false);
            counter++;
            narrator.failedMessage("Failed to check if details - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to check if details.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully confirmed details match the input data;.", false);
        counter++;
        
        if(!filterConfigGroups()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to filter configurations groups.", false);
            counter++;
            narrator.failedMessage("Failed to filter configurations groups - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to filter configurations groups.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully filtered configurations groups.", false);
        counter++;
        
        if(!checkAndDelete()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to check and delete.", false);
            counter++;
            narrator.failedMessage("Failed to check and delete - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to check and delete.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully checked and deleted.", false);
        counter++;
        
        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully added and removed a configuration group.", this.getTotalExecutionTime());
    }

    public boolean clickManage(){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//A[@href='#'])[2]")){
            error = "Could not locate manage button.";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("(//A[@href='#'])[2]");
        return true;
    }
    
    public boolean clickConfigGroup(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@ng-href='#/config-admin/configuration-groups'][text()='Configuration groups']")){
            error = "Could not locate configurations group.";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//A[@ng-href='#/config-admin/configuration-groups'][text()='Configuration groups']");
        return true;
    }
    
    public boolean clickAddButton(){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//I[@ng-class='iconClass'])[1]")){
            error = "Could not locate add button.";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("(//I[@ng-class='iconClass'])[1]");
        return true;
    }
    
    public boolean addDetails(){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//DIV[@class='page-header'])[1]")){
            error = "We could not locate the add new configuration group window.";
            return false;
        }
        pause(1000);
        SeleniumDriverInstance.enterTextByXpath("(//INPUT[@type='text'])[1]", configGroupName);
        SeleniumDriverInstance.selectFromDropDownListUsingXpath("(//SELECT[@type='text'])[1]", "Default mobile device template for MiX2310i");
        SeleniumDriverInstance.selectFromDropDownListUsingXpath("(//SELECT[@type='text'])[2]", "Default event template for MiX2310i");
        SeleniumDriverInstance.clickElementByXpath("//BUTTON[@class='btn-wide btn-small btn-success btn ng-scope ng-binding'][text()='Save']");
        return true;
    }
    
    public boolean filterConfigGroups(){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[1]")){
            error = "Could not find filter input field.";
            return false;
        }
        SeleniumDriverInstance.enterTextByXpath("(//INPUT[@type='text'])[1]", configGroupName);
        pause(1000);
        return true;
    }
    
    public boolean editFilteredGroup(){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//A[@fleet-tooltip='Actions'])[2]")){
            error = "Could not find edit button on filtered groups.";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("(//A[@fleet-tooltip='Actions'])[2]");
        SeleniumDriverInstance.clickElementByXpath("//span[text() = 'Edit']");
        return true;
    }
    
    public boolean checkIfDetsMatch(){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//DIV[@class='page-header'])[1]")){
            error = "Could not get to editting the configuration groups.";
            return false;
        }
        
        pause(1000);
        String extractedData = SeleniumDriverInstance.Driver.findElement(By.xpath("(//INPUT[@type='text'])[1]")).getAttribute("value");
        System.out.println(extractedData + " BITCHES BITCHES BITCHES BITCHES.");
        if(!extractedData.contains(configGroupName)){
            error = "The data does not match input data.";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//BUTTON[@class='btn-wide btn-small btn ng-scope ng-binding'][text()='Cancel']");
        return true;
    }
    
    public boolean checkAndDelete(){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//DIV)[98]")){
            error = "Could not locate the asset count tab.";
            return true;
        }
        String extractedData = SeleniumDriverInstance.retrieveTextByXpath("(//DIV)[98]");
        if(!extractedData.contains("0")){
            error = "The data does not match the input data.";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("(//A[@fleet-tooltip='Actions'])[2]");
        SeleniumDriverInstance.clickElementByXpath("//span[text() = 'Remove']");
        return true;
    }
}
