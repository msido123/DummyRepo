/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeyDrivenTestframework.Monitor.Assets;

import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;

/**
 *
 * @author PhathuxoloJ
 */
public class CheckDiagnosticWindow extends BaseClass{
    int counter =1;
    TestEntity testData;
    String errorMessage;
    
    public CheckDiagnosticWindow(TestEntity testData){
        this.testData = testData;
    }
    
    public TestResult runTest() throws InterruptedException {
        this.setStartTime();
        DiagnosticWindowMethods methods = new DiagnosticWindowMethods(testData);
        
        if(!methods.navigateToMonitorTab()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Monitor Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Monitor Tab - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click on Monitor Tab",this.getTotalExecutionTime());
        }
        
        if(!methods.navigateToAssetsTab()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Assets Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Assets Tab - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click on Assets Tab",this.getTotalExecutionTime());
        }
        
        if(!methods.clickFilter()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Filter", true);
            counter++;
            narrator.failedMessage("Failed to click on Filter - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click on Filter",this.getTotalExecutionTime());
        }
        
        if(!methods.enterTextToFilter("Mix Automation Live Unit")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to enter text into filter", true);
            counter++;
            narrator.failedMessage("Failed to enter text into filter - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to enter text into filter",this.getTotalExecutionTime());
        }
        
        if(!methods.clickSearchButton()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click search button", true);
            counter++;
            narrator.failedMessage("Failed to click search button - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click search button",this.getTotalExecutionTime());
        }
        
        if(!methods.clickDropDownActionMenu()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click drop down action menu ", true);
            counter++;
            narrator.failedMessage("Failed to click drop down action menu  - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click drop down action menu ",this.getTotalExecutionTime());
        }
        
        if(!methods.clickDiagnostic()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click Diagnostic on drop down action menu ", true);
            counter++;
            narrator.failedMessage("Failed to click Diagnostic on drop down action menu  - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click Diagnostic on drop down action menu ",this.getTotalExecutionTime());
        }
        return new TestResult(testData,Enums.ResultStatus.PASS,"Diagnostic window loads with correct information",this.getTotalExecutionTime());
    }
}
