/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.FleetAdmin;

import KeywordDrivenTestFramework.Core.BaseClass;
import static KeywordDrivenTestFramework.Core.BaseClass.SeleniumDriverInstance;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

/**
 *
 * @author MzuvukileN
 */
public class ImportAsset extends BaseClass{
    String error;
    int counter = 1;
    TestEntity testData;
    
    public ImportAsset(TestEntity testData){
        this.testData = testData;
    }
    
    public TestResult executeTest() throws InterruptedException, AWTException{
        this.setStartTime();
        
        if(!clickMonitor()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on monitor.", false);
            counter++;
            narrator.failedMessage("Failed to click on monitor - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on monitor.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully clicked on monitor.", false);
        counter++;
        
        if(!clickAssets()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on assets.", false);
            counter++;
            narrator.failedMessage("Failed to click on assets - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on assets.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully clicked on assets.", false);
        counter++;
        
        if(!filterAssets()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to filter assets.", false);
            counter++;
            narrator.failedMessage("Failed to filter assets - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to filter assets.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully filtered assets.", false);
        counter++;
        
        if(!doWeDelete()){
            if(!deleteAsset()){
                SeleniumDriverInstance.takeScreenShot(counter + " - Failed to delete asset.", false);
                counter++;
                narrator.failedMessage("Failed to delete asset - "+error);
                return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to delete asset.", this.getTotalExecutionTime());
            }
            SeleniumDriverInstance.takeScreenShot(counter + " Successfully deleted assets.", false);
            counter++;
        }
        
        pause(1000);
        
        if(!clickImportAsset()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click import asset.", false);
            counter++;
            narrator.failedMessage("Failed to click import asset - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click import asset.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully to click import asset.", false);
        counter++;
        
        pause(1500);
        if(!selectAssetToImport()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to select import asset.", false);
            counter++;
            narrator.failedMessage("Failed to select import asset - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to select import asset.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully selected import asset.", false);
        counter++;
        
        pause(1500);
        if(!clickMonitor()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on monitor.", false);
            counter++;
            narrator.failedMessage("Failed to click on monitor - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on monitor.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully clicked on monitor.", false);
        counter++;
        
        if(!clickAssets()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on assets.", false);
            counter++;
            narrator.failedMessage("Failed to click on assets - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on assets.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully clicked on assets.", false);
        counter++;
        
        SeleniumDriverInstance.clickElementByXpath("(//I[@class='icon-remove-sign'])[1]");
        if(!filterAssets()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to filter assets.", false);
            counter++;
            narrator.failedMessage("Failed to filter assets - "+error);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to filter assets.", this.getTotalExecutionTime());
        }
        SeleniumDriverInstance.takeScreenShot(counter + " Successfully filtered assets.", false);
        counter++;
        
        SeleniumDriverInstance.clickElementByXpath("//SPAN[@dmx-translate=''][text()='Refresh']");
        pause(30000);
        SeleniumDriverInstance.clickElementByXpath("//SPAN[@dmx-translate=''][text()='Refresh']");
        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully imported asset.", this.getTotalExecutionTime());
    }
    
    public boolean clickMonitor(){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//A[@href='#'])[1]")){
            error = "Could not locate the monitor tab.";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("(//A[@href='#'])[1]");
        return true;
    }
    
    public boolean clickAssets(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@ng-href='#/fleet-admin/assets'][text()='Assets']")){
            error = "Could not locate the assets tab.";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//A[@ng-href='#/fleet-admin/assets'][text()='Assets']");
        return true;
    }
    
    public boolean filterAssets(){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[1]")){
            error = "Could not locate the filter entry bar.";
            return false;
        }
        SeleniumDriverInstance.enterTextByXpath("(//INPUT[@type='text'])[1]", "Training MiX Import Test");
        SeleniumDriverInstance.clickElementByXpath("(//I[@class='icon-search'])[1]");
        return true;
    }
    
    public boolean doWeDelete(){
        boolean isFilterEmpty = false;
        if(SeleniumDriverInstance.CheckIfElementDisplayedByXpath("//SPAN[@class='badge'][text()='No items to display']")){
            isFilterEmpty = true;
            return isFilterEmpty;
        }
        return isFilterEmpty;
    }     
    
    public boolean deleteAsset(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@class='row-action']")){
            error = "Could not locate the option tab to delete.";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//A[@class='row-action']");
        pause(500);
        SeleniumDriverInstance.clickElementByXpath("//A[@event='Remove']");
        pause(500);
        SeleniumDriverInstance.clickElementByXpath("//BUTTON[@ng-show='$modal.okayButton'][text()='Remove']");
        return true;
    }
    
    public boolean clickImportAsset(){
        if(!SeleniumDriverInstance.CheckIfElementDisplayedByXpath("//I[@class='icon-import']")){
            error = "Could not locate the import asset button.";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//I[@class='icon-import']");
        return true;
    }
    
    public boolean selectAssetToImport() throws AWTException{
        if(!SeleniumDriverInstance.waitForElementByXpath("//*[@id='fleetUpload']/span")){
            error = "Could not locate the import window popup";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//*[@id='fleetUpload']/span");
        pause(500);
        StringSelection absolutePath = new StringSelection("C:\\Users\\MzuvukileN\\Desktop\\Work Folder\\Import files\\Testing_Assets_import.xlsx");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(absolutePath, null);
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        return true;
    }
}
