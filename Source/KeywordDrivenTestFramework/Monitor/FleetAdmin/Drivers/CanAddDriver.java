/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.Monitor.FleetAdmin.Drivers;

import KeywordDrivenTestFramework.Core.BaseClass;
import static KeywordDrivenTestFramework.Core.BaseClass.SeleniumDriverInstance;
import static KeywordDrivenTestFramework.Core.BaseClass.narrator;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
import KeywordDrivenTestFramework.Monitor.FleetAdmin.Assets.VerifyingDownloadedExcelFiles;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author ZiyandaP
 */
public class CanAddDriver extends BaseClass{
    int counter = 1;
    String errorMsg;
    TestEntity testData;
    private static final DateFormat dateObj = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
    String newDate;
    

public CanAddDriver(TestEntity testData){
    
    this.testData = testData;

}
public TestResult executeTest(){
    
    this.setStartTime();
    VerifyingDownloadedExcelFiles object = new VerifyingDownloadedExcelFiles(testData);
    
    if(!object.navigateToMonitorTab()){
        SeleniumDriverInstance.takeScreenShot(counter + " Failed to click on Monitor Tab", true);
        counter++;
        narrator.failedMessage("Failed to click on Monitor Tab - "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Monitor Tab", this.getTotalExecutionTime());
    }
    pause(2000);
    if(!navigateToDrivers()){
        SeleniumDriverInstance.takeScreenShot(counter + " Failed to click on Monitor Tab", true);
        counter++;
        narrator.failedMessage("Failed to click on Monitor Tab - "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Monitor Tab", this.getTotalExecutionTime());
    }

    if(!isAddDriverBtnClicked()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Add Driver Button ", true);
        counter++;
        narrator.failedMessage("Failed to click on Add Driver Button- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Add Driver Button", this.getTotalExecutionTime());
    }
    if(!isMobileNumberClicked()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Add Driver Button ", true);
        counter++;
        narrator.failedMessage("Failed to click on Add Driver Button- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Add Driver Button", this.getTotalExecutionTime());
    }
    if(!addTextToMobileNumber("+7990888967")){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Add Driver Button ", true);
        counter++;
        narrator.failedMessage("Failed to click on Add Driver Button- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Add Driver Button", this.getTotalExecutionTime());
    }
    if(!isNameClicked()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Add Driver Button ", true);
        counter++;
        narrator.failedMessage("Failed to click on Add Driver Button- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Add Driver Button", this.getTotalExecutionTime());
    }
    if(!addTextToName("MiX Driver"+newDate)){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Add Driver Button ", true);
        counter++;
        narrator.failedMessage("Failed to click on Add Driver Button- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Add Driver Button", this.getTotalExecutionTime());
    }    
    pause(2000);
    return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully Added Drivers.", this.getTotalExecutionTime());
}
    public boolean navigateToDrivers(){
        
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@ng-href='#/fleet-admin/drivers'][text()='Drivers']")) {
            
            errorMsg = "Failed to click on Assets";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//A[@ng-href='#/fleet-admin/drivers'][text()='Drivers']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Clicked on Drivers successfully -", false);
        counter++;
        return true;
    
    }
    public boolean isAddDriverBtnClicked() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//a[@ng-disabled=\"!$controller.canAddDriver\"]")) {
            
            errorMsg = "Failed to click on Add Driver Button";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//a[@ng-disabled=\"!$controller.canAddDriver\"]");
        SeleniumDriverInstance.takeScreenShot(counter + "- Successfully clicked on Add Driver Button -", false);
        counter++;
        return true;
    }
    public boolean isNameClicked() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//input[@name='driverName']")) {
            
            errorMsg = "Failed to click on Name";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//input[@name='driverName']");
        newDate = dateObj.format(new Date());
        SeleniumDriverInstance.takeScreenShot(counter + "- Successfully clicked on Name -", false);
        counter++;
        return true;
    }
    public boolean addTextToName(String textToEnter) {
        if(!SeleniumDriverInstance.waitForElementByXpath("//input[@name=\"driverName\"]")) {
            
            errorMsg = "Failed to add text to MobileNumber";
            return false;
        }
        
        SeleniumDriverInstance.EnterTextByXpath("//input[@name=\"driverName\"]", textToEnter);
        SeleniumDriverInstance.takeScreenShot(counter + "- Text added successfully -", false);
        counter++;
        return true;
    }

    public boolean isMobileNumberClicked() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//INPUT[@class='span12 ng-pristine ng-valid ng-valid-dmx-minlength ng-valid-dmx-maxlength ng-valid-dmx-phonenumber ng-valid-dmx-phonecountrycode']")) {
            
            errorMsg = "Failed to click on MobileNumber";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//INPUT[@class='span12 ng-pristine ng-valid ng-valid-dmx-minlength ng-valid-dmx-maxlength ng-valid-dmx-phonenumber ng-valid-dmx-phonecountrycode']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Successfully clicked on Mobile Number -", false);
        counter++;
        return true;
    }
    public boolean addTextToMobileNumber(String textToEnter) {
        if(!SeleniumDriverInstance.waitForElementByXpath("//INPUT[@class='span12 ng-pristine ng-valid ng-valid-dmx-minlength ng-valid-dmx-maxlength ng-valid-dmx-phonenumber ng-valid-dmx-phonecountrycode']")) {
            
            errorMsg = "Failed to add text to MobileNumber";
            return false;
        }
        
        SeleniumDriverInstance.EnterTextByXpath("//INPUT[@class='span12 ng-pristine ng-valid ng-valid-dmx-minlength ng-valid-dmx-maxlength ng-valid-dmx-phonenumber ng-valid-dmx-phonecountrycode']", textToEnter);
        SeleniumDriverInstance.takeScreenShot(counter + "- Text added successfully -", false);
        counter++;
        return true;
    }  

    
}