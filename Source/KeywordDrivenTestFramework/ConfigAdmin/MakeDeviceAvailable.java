/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.ConfigAdmin;

import KeywordDrivenTestFramework.Core.BaseClass;
import static KeywordDrivenTestFramework.Core.BaseClass.SeleniumDriverInstance;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
/**
 *
 * @author MzuvukileN
 */
public class MakeDeviceAvailable extends BaseClass{
    String error;
    int counter = 1;
    TestEntity testData;
    NavigateToLibraries nav;
    
    public MakeDeviceAvailable(TestEntity testData){
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
        
        if(!nav.clickMobDevLibrary()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on mobile device libary", false);
            counter++;
            narrator.failedMessage("Failed to click on mobile device libary - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on mobile device libary", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully clicked on mobile device libary.", false);
        counter++;
        
        if(!filterMobileDevices()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to filter mobile devices.", false);
            counter++;
            narrator.failedMessage("Failed to filter mobile devices. - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to filter mobile devices.", this.getTotalExecutionTime());
        }
        pause(1000);
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully filtered mobile devices.", false);
        counter++;
        
        if(!clickDropDownOptionAndMakeAvailabe()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to make device available.", false);
            counter++;
            narrator.failedMessage("Failed to make device available. - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to make device available.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.waitForElementByXpath("//DIV[@class='notification notification-placement notification-success']");
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully made device available.", false);
        counter++;
        
        if(!verifyIfAvailable()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to verify if mobile device available.", false);
            counter++;
            narrator.failedMessage("Failed to verify if mobile device available. - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to verify if mobile device available.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully verified device availability.", false);
        counter++;
        
        if(!clickDropDownOptionAndMakeUnavailabe()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to make device unavailable.", false);
            counter++;
            narrator.failedMessage("Failed to make device unavailable. - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to make device unavailable.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully made device unavailable.", false);
        counter++;
        
        if(!makeUnavailable()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to make device unavailable.", false);
            counter++;
            narrator.failedMessage("Failed to make device unavailable. - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to make device unavailable.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.waitForElementByXpath("//SPAN[@id='pop-alert-message']");
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully made device unavailable.", false);
        counter++;
        pause(1000);
        
        if(!verifyIfUnavailable()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to verify if mobile device unavailable.", false);
            counter++;
            narrator.failedMessage("Failed to verify if mobile device unavailable. - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to verify if mobile device unavailable.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully verified device availability.", false);
        counter++;
        
        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully edited an event.", this.getTotalExecutionTime());
    }
        
    public boolean filterMobileDevices(){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[1]")){
            error = "Could not get to Mobile Device Library.";
            return false;
        }
        SeleniumDriverInstance.enterTextByXpath("(//INPUT[@type='text'])[1]", "FM 3516i (Tracer)");
        return true;
    }
    
    public boolean clickDropDownOptionAndMakeAvailabe(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@fleet-tooltip='Actions']")){
            error = "Could not apply filter to mobile devices.";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//A[@fleet-tooltip='Actions']");
        SeleniumDriverInstance.clickElementByXpath("//span[text() = 'Make available']");
        return true;
    }
    
    public boolean clickDropDownOptionAndMakeUnavailabe(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@fleet-tooltip='Actions']")){
            error = "Could not apply filter to mobile devices.";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//A[@fleet-tooltip='Actions']");
        SeleniumDriverInstance.clickElementByXpath("//span[text() = 'Make unavailable']");
        return true;
    }
    
    public boolean makeUnavailable(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//BUTTON[@ng-show='$modal.okayButton'][text()='Ok']")){
            error = "We cannot make item unavailable.";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//BUTTON[@ng-show='$modal.okayButton'][text()='Ok']");
        return true;
    }
    
    public boolean verifyIfAvailable(){
        boolean isAvail = false;
        if(!SeleniumDriverInstance.waitForElementByXpath("(//DIV)[100]")){
            error = "There is no filtered data.";
            return isAvail;
        }
        String extracted = SeleniumDriverInstance.retrieveTextByXpath("(//DIV)[101]");
        if(extracted.contains("Available") && SeleniumDriverInstance.CheckIfElementIsEnabled("//SPAN[text()='FM 3516i (Tracer)']")){
            isAvail = true;
        }
        return isAvail;
    }
    
    public boolean verifyIfUnavailable(){
        boolean isAvail = false;
        if(!SeleniumDriverInstance.waitForElementByXpath("(//DIV)[100]")){
            error = "There is no filtered data.";
            return isAvail;
        }
        String extracted = SeleniumDriverInstance.retrieveTextByXpath("(//DIV)[101]");
        if(extracted.contains("") && SeleniumDriverInstance.CheckIfElementIsEnabled("//SPAN[text()='FM 3516i (Tracer)']")){
            isAvail = true;
        }
        System.out.println(isAvail + " THIS THE SHIDS.");
        return isAvail;
    }
}
