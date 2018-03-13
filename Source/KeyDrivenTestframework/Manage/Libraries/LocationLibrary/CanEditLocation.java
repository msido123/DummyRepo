/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeyDrivenTestframework.Manage.Libraries.LocationLibrary;

import java.util.Random;
import KeywordDrivenTestFramework.Core.BaseClass;
import static KeywordDrivenTestFramework.Core.BaseClass.SeleniumDriverInstance;
import static KeywordDrivenTestFramework.Core.BaseClass.narrator;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Manage.Templates.CheckTemplatesLoadInfoZee;
import KeywordDrivenTestFramework.Manage.Templates.CheckingEventTemplateFilter;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
import KeywordDrivenTestFramework.Manage.Libraries.AddingNewEventToSystem;
import static com.sun.jmx.snmp.EnumRowStatus.active;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ZiyandaP
 */
public class CanEditLocation  extends BaseClass{
    int counter = 1;
    String errorMsg;
    TestEntity testData;
    String defaultWindow;
    String popUpWindow;
    Date date = new Date();
    DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
    
    public static CheckTemplatesLoadInfoZee object1;  
    public static CheckingEventTemplateFilter object2;
    public static AddingNewEventToSystem object3;

public CanEditLocation(TestEntity testData){

    this.testData = testData;
    object1 = new CheckTemplatesLoadInfoZee(testData);
    object2 = new CheckingEventTemplateFilter(testData);
    object3 = new AddingNewEventToSystem(testData);
}
    public TestResult executeTest() throws InterruptedException {
        
        this.setStartTime();
        if(!object1.navigateToManageTabZee()){
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Manage Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Manage Tab - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Manage Tab", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!object3.navigateToLibrariesTab()){
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on the Libraries Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on the Libraries Tab - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the Libraries Tab", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!navigateToLocationLibrary()){
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on the Libraries Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on the Libraries Tab - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the Libraries Tab", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!isFilterClicked()){
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on the Filter", true);
            counter++;
            narrator.failedMessage("Failed to click on the Filter- "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the Filter", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!addTextToFilter("z. MiX")){
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to add text on the Filter", true);
            counter++;
            narrator.failedMessage("Failed to add text on the Filter- "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to add text on the Filter", this.getTotalExecutionTime());       
        }
        pause(1000);
        if(!isActiondropDownClicked()){
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Action dropDown", true);
            counter++;
            narrator.failedMessage("Failed to click on Action dropDown- "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Action dropDown", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!isEditClicked()){
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Edit", true);
            counter++;
            narrator.failedMessage("Failed to add text on the Filter- "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Edit", this.getTotalExecutionTime());       
        }

        pause(1000);
        if(!isOverSpeedingValueClicked()){
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click click Over speeding value", true);
            counter++;
            narrator.failedMessage("Failed to click on click Over speeding value- "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on click Over speeding value", this.getTotalExecutionTime());
        }
        pause(1000);
       int randmNum =  generateRandomNum(0,200);
        if(!enterRandomNumber(randmNum)){
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to enter Random number", true);
            counter++;
            narrator.failedMessage("-Failed to enter Random number - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to enter Random number", this.getTotalExecutionTime());       
        }        
        pause(1000);
        if(!isSaveButtonClicked()){
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on the Save button", true);
            counter++;
            narrator.failedMessage("Failed to add text on the Filter- "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the Save button", this.getTotalExecutionTime());       
        }
        pause(1000);
        if(!isFilterClickedAgain()){
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on the Filter", true);
            counter++;
            narrator.failedMessage("Failed to click on the Filter- "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the Filter", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!addTextToFilterAgain("z. MiX")){
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to add text on the Filter", true);
            counter++;
            narrator.failedMessage("Failed to add text on the Filter- "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to add text on the Filter", this.getTotalExecutionTime());       
        } 
        
        if(!checkSpeedValue(randmNum)){
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to match Speed limits", true);
            counter++;
            narrator.failedMessage("Failed to match Speed limits- "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to match Speed limits", this.getTotalExecutionTime());       
        }
        pause(1000);
        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully clicked on the Save button.", this.getTotalExecutionTime()); 
    }


    public boolean navigateToLocationLibrary(){
        
        if(!SeleniumDriverInstance.waitForElementByXpath("(//A[@class='ng-binding'])[text()='Location library']")) {
            
            errorMsg = "Failed to click on the Libraries Tab";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("(//A[@class='ng-binding'])[text()='Location library']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Clicked Location Library successfully -", false);
        counter++;
        return true;
    }
    public boolean isFilterClicked() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//input[@placeholder='Filter']")) {
            
            errorMsg = "Failed to click on the filter";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//input[@placeholder='Filter']");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked on the filter -", false);
        counter++;
        return true;
    }
    
    public boolean addTextToFilter(String textToEnter) {
        if(!SeleniumDriverInstance.waitForElementByXpath("//input[@placeholder='Filter']")) {
            
            errorMsg = "Failed to add text to filter";
            return false;
        }
        
        SeleniumDriverInstance.EnterTextByXpath("//input[@placeholder='Filter']", textToEnter);
        SeleniumDriverInstance.takeScreenShot(counter + "- Text addded successfully -", false);
        counter++;
        return true;
    }
    public boolean isActiondropDownClicked(){
    if(!SeleniumDriverInstance.waitForElementByXpath("//a[@fleet-tooltip='Actions']")) {
            
            errorMsg = "Failed to click Action drop down";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//a[@fleet-tooltip='Actions']");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked Action drop down -", false);      
        counter++;
        return true;
    }
    public boolean isEditClicked(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//i[@class='icon icon-edit icon-green'][1]")) {
            
            errorMsg = "Failed to click on Edit";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//i[@class='icon icon-edit icon-green'][1]");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked Edit -", false);      
        counter++;
        return true;
    }
    public boolean isOverSpeedingValueClicked(){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='number'])[1]")) {
            
            errorMsg = "Failed to click on Over speeding value";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("(//INPUT[@type='number'])[1]");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked Over speeding value -", false);      
        counter++;
        return true;
    }
    public int generateRandomNum(int start, int finish){
        //System.out.println("Unique number is " + dateFormat.format(date));
        
        return (
        start + new Random().nextInt(finish + 1 - start)
        
                );
    
    }
    public boolean enterRandomNumber(int numToEnter) {
        if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='number'])[1]")) {
            
            errorMsg = "Failed to Random number";
            return false;
        }       
        SeleniumDriverInstance.EnterTextByXpath("(//INPUT[@type='number'])[1]", numToEnter+"");
        SeleniumDriverInstance.takeScreenShot(counter + "- Random number added successfully -", false);
        counter++;
        return true;
    }
    public boolean isSaveButtonClicked() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//BUTTON[@class='btn-wide btn-small btn-success btn ng-scope ng-binding'][text()='Save']")) {
            
            errorMsg = "Failed to click on the Save button";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//BUTTON[@class='btn-wide btn-small btn-success btn ng-scope ng-binding'][text()='Save']");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked the Save button -", false);
        counter++;
        return true;
    }
    public boolean isFilterClickedAgain() {
        if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[1]")) {
            
            errorMsg = "Failed to click on the filter";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("(//INPUT[@type='text'])[1]");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked on the filter -", false);
        counter++;
        return true;
    }
    public boolean addTextToFilterAgain(String textToEnter) {
        if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[1]")) {
            
            errorMsg = "Failed to add text to filter";
            return false;
        }
        
        SeleniumDriverInstance.EnterTextByXpath("(//INPUT[@type='text'])[1]", textToEnter);
        SeleniumDriverInstance.takeScreenShot(counter + "- Text addded successfully -", false);
        counter++;
        return true;
    }
    public boolean checkSpeedValue(int speedToCheck){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//DIV)[103]")) {
            
            errorMsg = "Failed to return data typed on the filter";
            return false;
         }
        String checkSpeedValue  = SeleniumDriverInstance.retrieveTextByXpath("(//DIV)[103]");
        if(!(checkSpeedValue.equals(speedToCheck +" km/h"))){
            
            errorMsg = "Failed to match speed values";
            testData.extractParameter("Speed Value for z. MiX location", checkSpeedValue, "FAIL");
            SeleniumDriverInstance.takeScreenShot("compared text does not match!!", false);
            counter++;
            return false;
            
        }
        testData.extractParameter("Speed Value for z. MiX location", checkSpeedValue, "PASS");
        SeleniumDriverInstance.takeScreenShot("compared text matches!!", false);
        counter++;
        return true;
    }
}