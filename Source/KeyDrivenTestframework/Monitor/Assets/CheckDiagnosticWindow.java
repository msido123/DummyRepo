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
        pause(1000);
        if(!methods.navigateToAssetsTab()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Assets Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Assets Tab - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click on Assets Tab",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.clickFilter()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Filter", true);
            counter++;
            narrator.failedMessage("Failed to click on Filter - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click on Filter",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.enterTextToFilter("Mix Automation Live Unit")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to enter text into filter", true);
            counter++;
            narrator.failedMessage("Failed to enter text into filter - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to enter text into filter",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.clickSearchButton()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click search button", true);
            counter++;
            narrator.failedMessage("Failed to click search button - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click search button",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.clickDropDownActionMenu()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click drop down action menu ", true);
            counter++;
            narrator.failedMessage("Failed to click drop down action menu  - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click drop down action menu ",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.clickDiagnostic()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click Diagnostic on drop down action menu ", true);
            counter++;
            narrator.failedMessage("Failed to click Diagnostic on drop down action menu  - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click Diagnostic on drop down action menu ",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.clickGeneralStatusInfo()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click General status information bar ", true);
            counter++;
            narrator.failedMessage("Failed to click General status information bar  - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click General status information bar ",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.verifyLabel("//strong[text()='Driver']","Driver")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to verify labels ", true);
            counter++;
            narrator.failedMessage("Failed to verify labels  - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to verify labels ",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.verifyLabel("//strong[text()='GPRS context (restricted)']","GPRS context (restricted)")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to verify labels ", true);
            counter++;
            narrator.failedMessage("Failed to verify labels  - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to verify labels ",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.verifyData("MiX DriverJM","+CGDCONT=1,\"IP\",\"internet\"")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to verify data ", true);
            counter++;
            narrator.failedMessage("Failed to verify data  - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to verify data ",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.clickLatestPosition()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click latest position ", true);
            counter++;
            narrator.failedMessage("Failed to click latest position  - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click latest position ",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.scrollDown()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to scroll down ", true);
            counter++;
            narrator.failedMessage("Failed to scroll down  - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to scroll down ",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.verifyLabel("(//TD)[225]","HDOP")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to verify labels ", true);
            counter++;
            narrator.failedMessage("Failed to verify labels  - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to verify labels ",this.getTotalExecutionTime());
        }
        if(!methods.closePopUp()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to close pop up ", true);
            counter++;
            narrator.failedMessage("Failed to close pop up  - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to close pop up ",this.getTotalExecutionTime());
        }
        return new TestResult(testData,Enums.ResultStatus.PASS,"Diagnostic window loads with correct information",this.getTotalExecutionTime());
    }
}
