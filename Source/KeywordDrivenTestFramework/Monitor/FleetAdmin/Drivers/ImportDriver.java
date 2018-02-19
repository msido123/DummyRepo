/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.Monitor.FleetAdmin.Drivers;

import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author MsimeleloG
 */
public class ImportDriver extends BaseClass {
    
    int counter = 1;
    String errorMsg = "";
    TestEntity testData;
    
    public ImportDriver(TestEntity testData) {
        
        this.testData = testData;
    }
    
    public TestResult executeTest() throws InterruptedException, AWTException {
        
        this.setStartTime();
        
        if(!clickOnMonitor()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Monitor Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Monitor Tab - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Monitor Tab", this.getTotalExecutionTime());           
        }
        
        if(!clickOnDriverTab()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Drivers", true);
            counter++;
            narrator.failedMessage("Failed to click on Drivers - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Drivers", this.getTotalExecutionTime());
        }
        
        if(!isFilterClicked()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on the filter", true);
            counter++;
            narrator.failedMessage("Failed to click on the filter - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the filter", this.getTotalExecutionTime());
        }
        
        if(!addTextToFilter("MiX TrainingDriver")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to add text to filter", true);
            counter++;
            narrator.failedMessage("Failed to add text to filter - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to add text to filter", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!clickOnSearchButton()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click search button", true);
            counter++;
            narrator.failedMessage("Failed to click search button - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click search button", this.getTotalExecutionTime());
        }
        pause(1000);
        
        if(checkIfDriverExists("MiX TrainingDriver")) {
            pause(2000);   
            SeleniumDriverInstance.clickElementByXpath("//A[@class='row-action']");
            pause(1000);
            SeleniumDriverInstance.clickElementByXpath("//span[text()='Remove']");
            removeDriverPopUp();
        }
        pause(2000);
        
        
        if(!importDriver()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to export driver", true);
            counter++;
            narrator.failedMessage("Failed to export driver - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to export driver", this.getTotalExecutionTime());
        }
        pause(2000);
        if(!confirmDriverImportViaPopUp()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to show export driver pop up", true);
            counter++;
            narrator.failedMessage("Failed to show export driver pop up - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to show export driver pop up", this.getTotalExecutionTime());
        }
        pause(30000);
        
        if(!clickOnSearchButton()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click search button", true);
            counter++;
            narrator.failedMessage("Failed to click search button - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click search button", this.getTotalExecutionTime());
        }
        pause(30000);
        
        
        if(!checkIfDriverExists("MiX TrainingDriver")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to check if driver exits", true);
            counter++;
            narrator.failedMessage("Failed to check if driver exits - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to check if driver exits", this.getTotalExecutionTime());
        }
        
        
         return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully exported driver.", this.getTotalExecutionTime());
    }
    
    public boolean clickOnMonitor() {
        
        if(!SeleniumDriverInstance.waitForElementByXpath("(//A[@href='#'])[1]")) {
            
            errorMsg = "Failed to click on Monitor tab";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("(//A[@href='#'])[1]");
        SeleniumDriverInstance.takeScreenShot(counter + "- Clicked on Monitor tab successfully -", false);
        counter++;
        return true;
    }
    
    public boolean clickOnDriverTab() {
        
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@ng-href='#/fleet-admin/drivers'][text()='Drivers']")) {
            
            errorMsg = "Failed to click on the Driver tab";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//A[@ng-href='#/fleet-admin/drivers'][text()='Drivers']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Clicked on Driver tab successfully -", false);
        counter++;
        return true;
    }
    
    public boolean isFilterClicked() {
        
        if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[1]")) {
            
            errorMsg = "Failed to click on filter";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("(//INPUT[@type='text'])[1]");
        SeleniumDriverInstance.takeScreenShot(counter + "- Filter clicked successfully -", false);
        counter++;
        return true;
    }
    
    public boolean addTextToFilter(String textToEnter) {
        
        if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[1]")) {
            
            errorMsg = "Failed to add text to filter";
            return false;
        }
        
        SeleniumDriverInstance.EnterTextByXpath("(//INPUT[@type='text'])[1]", textToEnter);
        SeleniumDriverInstance.takeScreenShot(counter + "- Text added successfully -", false);
        counter++;
        return true;
    }
    
    public boolean clickOnSearchButton() {
        
        if(!SeleniumDriverInstance.waitForElementByXpath("(//I[@class='icon-search'])[1]")) {
            
            errorMsg = "Failed to click on search button";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("(//I[@class='icon-search'])[1]");
        SeleniumDriverInstance.takeScreenShot(counter + "- Clicked on search button successfully -",false);
        counter++;
        return true;
    }
    
    
    public boolean checkIfDriverExists(String textToCheck) {
     
        if(SeleniumDriverInstance.waitForElementByXpath("//SPAN[@class='badge'][text()='No items to display']")) {
            
            errorMsg = "Failed to find the driver tab";
            return false;
        }
   
        SeleniumDriverInstance.takeScreenShot(counter + "- Checked if driver already exists successfully -" , false);
        counter++;
        return true;
    }
    
    public boolean removeDriverPopUp() {
        
        if(!SeleniumDriverInstance.waitForElementByXpath("(//DIV[@class='modal-inner-body white-box-padding'])[2]")) {
            
            errorMsg = "Failed to show driver pop up";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("//BUTTON[@ng-show='$modal.okayButton'][text()='Remove']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Removed driver successfully -", false);
        counter++;
        return true;
    }
    
    public boolean importDriver() {
        
        if(!SeleniumDriverInstance.waitForElementByXpath("//I[@class='icon-import']")) {
            
            errorMsg = "Failed to click import driver button";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//I[@class='icon-import']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Clicked import driver button successfully -", false);
        counter++;
        return true;
    }
    
    public boolean confirmDriverImportViaPopUp() throws AWTException {
        
        if(!SeleniumDriverInstance.waitForElementByXpath("//*[@id='fleetUpload']/span")) {
            
            errorMsg = "Failed to show driver import pop up and choose file button";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("//*[@id='fleetUpload']/span");
        //pause(30000);
        
        //WebElement fileInput = SeleniumDriverInstance.Driver.findElement(By.xpath("//*[@id='fleetUpload']/span"));
        //fileInput.sendKeys("C:\\Users\\MsimeleloG\\Documents\\Work Files\\Import files\\MiXDriverImport Training.xlsx");
        setClipboardData("C:\\Users\\MsimeleloG\\Documents\\Work Files\\Import files\\MiXDriverImport Training.xlsx");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        SeleniumDriverInstance.takeScreenShot(counter + "- Showed pop up and clicked 'Choose file' button successfully -", false);
        counter++;
        return true;
    }
    
    public static void setClipboardData(String string) {
        
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }
    
    
    
}
