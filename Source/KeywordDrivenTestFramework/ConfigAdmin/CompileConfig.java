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
public class CompileConfig extends BaseClass{
    String error;
    int counter = 1;
    TestEntity testData;
    String configGroupName;
    int randomBuzzer;
    CreateConfigGroup configGroup;
    
    public CompileConfig(TestEntity testData){
        this.testData = testData;
        randomBuzzer = 3000 + (int)(Math.random() * 3000);
        configGroup = new CreateConfigGroup(this.testData);
    }
    
    public TestResult executeTest() throws InterruptedException{
        this.setStartTime();
        
        if(!configGroup.clickManage()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on manage.", false);
            counter++;
            narrator.failedMessage("Failed to click on manage - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on manage.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully clicked on Manage.", false);
        counter++;
        
        
        if(!configGroup.clickConfigGroup()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on config groups.", false);
            counter++;
            narrator.failedMessage("Failed to click on config groups - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on config groups", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully clicked on config groups.", false);
        counter++;
        
        pause(1000);
        
        if(!configGroup.filterConfigGroups("z.MiXConfigGroup")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to filter config groups.", false);
            counter++;
            narrator.failedMessage("Failed to filter config groups - " + error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to filter config groups.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully filtered config groups.", false);
        counter++;
        
        if(!clickMobDevTemplate()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on mobile device template.", false);
            counter++;
            narrator.failedMessage("Failed to click on mobile device template - " + error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on mobile device template.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully clicked on mobile device template.", false);
        counter++;
        
        pause(2000);
        
        if(!clickMobDevType()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on mobile device type.", false);
            counter++;
            narrator.failedMessage("Failed to click on mobile device type - " + error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on mobile device type.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully clicked on mobile device type.", false);
        counter++;
        
        pause(2000);
        
        if(!editBuzzerFreqAndSave()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to edit buzzer frequency.", false);
            counter++;
            narrator.failedMessage("Failed to edit buzzer frequency - " + error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to edit buzzer frequency.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully editted buzzer frequency.", false);
        counter++;
        
        pause(1000);
        if(!configGroup.clickManage()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on manage.", false);
            counter++;
            narrator.failedMessage("Failed to click on manage - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on manage.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully clicked on Manage.", false);
        counter++;
        
        if(!configGroup.clickConfigGroup()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on config groups.", false);
            counter++;
            narrator.failedMessage("Failed to click on config groups - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on config groups", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully clicked on config groups.", false);
        counter++;
        
        pause(1000);
        
        if(!configGroup.filterConfigGroups("z.MiXConfigGroup")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to filter config groups.", false);
            counter++;
            narrator.failedMessage("Failed to filter config groups - " + error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to filter config groups.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully filtered config groups.", false);
        counter++;
        
        if(!checkConfigStatus()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to confirm config status.", false);
            counter++;
            narrator.failedMessage("Failed to confirm config status - " + error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to confirm config status.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully confirmed config status.", false);
        counter++;
        
        pause(1000);
        if(!compile()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to compile.", false);
            counter++;
            narrator.failedMessage("Failed to compile - " + error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to compile.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully compiled.", false);
        counter++;
        
        pause(1000);
        if(!checkConfigStatus2()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to confirm config status.", false);
            counter++;
            narrator.failedMessage("Failed to confirm config status - " + error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to confirm config status.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully confirmed config status.", false);
        counter++;
        
        pause(1000);
        if(!refreshButton()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to refresh.", false);
            counter++;
            narrator.failedMessage("Failed to refresh - " + error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to refresh.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully refreshed.", false);
        counter++;
        
        if(!checkConfigStatus3()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to confirm config status.", false);
            counter++;
            narrator.failedMessage("Failed to confirm config status - " + error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to confirm config status.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully confirmed config status.", false);
        counter++;
        
        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully added and removed a configuration group.", this.getTotalExecutionTime());
    }
    
    public boolean clickMobDevTemplate(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@class='click-cell'][text()='z.MiXFM_Template']")){
            error = "Could not locate the mobile device template.";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//A[@class='click-cell'][text()='z.MiXFM_Template']");
        return true;
    }
    
    public boolean clickMobDevType(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//SPAN[@dmx-translate=''][text()='Mobile device type']", 5)){
            error = "Failed to locate mobile device type.";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//SPAN[@dmx-translate=''][text()='Mobile device type']");
        return true;        
    }
    
    public boolean editBuzzerFreqAndSave(){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[6]")){
            error = "Could not locate buzzer entry field.";
            return false;
        }
        SeleniumDriverInstance.enterTextByXpath("(//INPUT[@type='text'])[6]", randomBuzzer + "");
        pause(500);
        SeleniumDriverInstance.clickElementByXpath("//BUTTON[@class='btn-wide btn-small btn-success btn ng-scope ng-binding'][text()='Save']");
        pause(1000);
        SeleniumDriverInstance.clickElementByXpath("//BUTTON[@ng-show='$modal.okayButton'][text()='Yes']");
        return true;
    }
    
    public boolean checkConfigStatus(){
        System.out.println("STATUS 1");
        boolean truth = false;
        if(!SeleniumDriverInstance.waitForElementByXpath("//DIV[@class='cell alt'][text()='Configuration changed']")){
            error = "Could not locate the configuration status column.";
            return truth;
        }
        String extractedData = SeleniumDriverInstance.retrieveTextByXpath("//DIV[@class='cell alt'][text()='Configuration changed']");
        if(extractedData.contains("Configuration changed")){
            truth = true;
        }
        return truth;
    }
    
    public boolean compile(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@class='row-action']")){
            error = "Could not locate dropdown so as to compile.";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//A[@class='row-action']");
        SeleniumDriverInstance.clickElementByXpath("(//SPAN[text()='Compile'])[3]");
        pause(500);
        SeleniumDriverInstance.clickElementByXpath("(//INPUT[@type='radio'])[9]");
        SeleniumDriverInstance.clickElementByXpath("(//BUTTON[@class='btn ng-scope ng-binding btn-success btn-wide'][text()='Submit'][text()='Submit'])[2]");
        return true;
    }
    
    public boolean checkConfigStatus2(){
        System.out.println("STATUS 2");
        boolean truth = false;
        if(!SeleniumDriverInstance.waitForElementByXpath("//DIV[@class='cell alt'][text()='Compile requested']")){
            error = "Could not locate the configuration status column.";
            return truth;
        }
        String extractedData = SeleniumDriverInstance.retrieveTextByXpath("//DIV[@class='cell alt'][text()='Compile requested']");
        if(extractedData.contains("Compile requested")){
            truth = true;
        }
        return truth;
    }
    
    public boolean refreshButton(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//SPAN[@dmx-translate=''][text()='Refresh']")){
            error = "Could not locate the refresh button.";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//SPAN[@dmx-translate=''][text()='Refresh']");
        return true;
    }
    
    public boolean checkConfigStatus3(){
        System.out.println("STATUS 3");
        pause(1000);
        //refreshButton();
        boolean truth = false;
        if(/**!SeleniumDriverInstance.waitForElementByXpath("//DIV[@class='cell alt'][text()='Compiling']") ||*/ !SeleniumDriverInstance.waitForElementByXpath("//DIV[@class='cell alt'][text()='Ready for upload']")){
            error = "Could not locate the configuration status column.";
            return truth;
        }
        //SeleniumDriverInstance.waitForElementByXpath("//DIV[@class='cell alt'][text()='Ready for upload']", 10);
        String extractedData = SeleniumDriverInstance.retrieveTextByXpath("//DIV[@class='cell alt'][text()='Ready for upload']");
        System.out.println(extractedData + " Right here.");
        if(extractedData.contains("Ready for upload")){
            truth = true;
        }
        return truth;
    }
}
