/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.Manage.Contacts.ManageContacts;

import static KeywordDrivenTestFramework.Core.BaseClass.narrator;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestResult;
import KeywordDrivenTestFramework.Core.BaseClass;
import static KeywordDrivenTestFramework.Core.BaseClass.SeleniumDriverInstance;
import KeywordDrivenTestFramework.Entities.TestEntity;
import java.awt.AWTException;


/**
 *
 * @author ZiyandaP
 */
public class ImportContactExecuteTestClass extends BaseClass{

int counter = 1;
String errorMsg;
TestEntity testData;
ImportContactFunctions object;
    
public ImportContactExecuteTestClass(TestEntity testData){
    
       this.testData = testData;
       
        
}   
public TestResult executingTest() throws InterruptedException, AWTException{
    
    object = new ImportContactFunctions(testData);
    
    this.setStartTime();
    
    
    if(!object.navigateToManageTab()){
        SeleniumDriverInstance.takeScreenShot(counter + " Failed to click on Manage Tab", true);
        counter++;
        narrator.failedMessage("Failed to click on Manage Tab - "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Manage Tab", this.getTotalExecutionTime());
    }
    pause(2000);
    if(!object.navigateToManageContacts()){
        SeleniumDriverInstance.takeScreenShot(counter + " Failed to click on Manage Contacts", true);
        counter++;
        narrator.failedMessage("-Failed to click on Manage Contacts- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Manage Contacts", this.getTotalExecutionTime());
    }
    pause(2000);
    if(!object.isFilterClicked()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " -Failed to click on the Filter-", true);
        counter++;
        narrator.failedMessage("-Failed to click on the Filter- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the Filter", this.getTotalExecutionTime());
    }
    pause(2000);
    if(!object.addTextToFilter("MiX Contact Training")){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to add text on the Filter", true);
        counter++;
        narrator.failedMessage("-Failed to add text on the Filter- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to add text on the Filter", this.getTotalExecutionTime());                
    }
    pause(3000);
    if(!object.isImportContactsBtnClicked()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on the Filter", true);
        counter++;
        narrator.failedMessage("-Failed to click on the Filter- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on import contacts button", this.getTotalExecutionTime());
    }
    pause(3000);
    if(!object.isChooseFileClicked()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on choose file button", true);
        counter++;
        narrator.failedMessage("-Failed to click on choose file button- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on choose file button", this.getTotalExecutionTime());
    }
    pause(3000);
    if(!object.isFilterClickedAgain()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " -Failed to click on the Filter-", true);
        counter++;
        narrator.failedMessage("-Failed to click on the Filter- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the Filter", this.getTotalExecutionTime());
    }
    pause(3000);
    if(!object.addTextToFilterAgain("MiX Contact Training")){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to add text on the Filter", true);
        counter++;
        narrator.failedMessage("-Failed to add text on the Filter- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to add text on the Filter", this.getTotalExecutionTime());                
    }
    pause(3000);
    if(!object.isDropDownClicked()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " -Failed to click on the Dropdown-", true);
        counter++;
        narrator.failedMessage("-Failed to click on the Dropdown- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the Dropdown", this.getTotalExecutionTime());
    }
    pause(3000);
    if(!object.isRemoveClicked()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on remove", true);
        counter++;
        narrator.failedMessage("-Failed to click on remove- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on remove", this.getTotalExecutionTime());
    }
    pause(3000);
    if(!object.isRemoveClickedAgain()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on remove again", true);
        counter++;
        narrator.failedMessage("-Failed to click on remove- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on remove again", this.getTotalExecutionTime());
    }
    pause(3000);
    return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully Imported a Contact.", this.getTotalExecutionTime());
}
}    
    