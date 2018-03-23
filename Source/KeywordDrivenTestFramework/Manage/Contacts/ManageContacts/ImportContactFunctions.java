/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.Manage.Contacts.ManageContacts;

import static KeywordDrivenTestFramework.Core.BaseClass.SeleniumDriverInstance;
import KeywordDrivenTestFramework.Entities.TestEntity;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;



/**
 *
 * @author ZiyandaP
 */
public class ImportContactFunctions extends ImportContactExecuteTestClass{

    public ImportContactFunctions(TestEntity testData) {
        super(testData);
    }

    public boolean navigateToManageTab() {
        
        if(!SeleniumDriverInstance.waitForElementByXpath("(//A[@href='#'])[2]")) {
            
            errorMsg = "Failed to click on Manage Tab";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("(//A[@href='#'])[2]");
        SeleniumDriverInstance.takeScreenShot(counter + "- Clicked Manager tab successfully -", false);
        counter++;
        return true;
}
    public boolean navigateToManageContacts() {
        
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@ng-href='#/contacts'][text()='Manage contacts']")) {
            
            errorMsg = "Failed to click on Manage Contacts";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//A[@ng-href='#/contacts'][text()='Manage contacts']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Clicked Manager Contacts successfully -", false);
        counter++;
        return true;
}
    public boolean isFilterClicked() {
        if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[1]")) {
            
            errorMsg = "Failed to click on the filter";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("(//INPUT[@type='text'])[1]");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked on the filter -", false);
        counter++;
        return true;
    }
    public boolean addTextToFilter(String textToEnter) {
        if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[1]")) {
            
            errorMsg = "Failed to add text to filter";
            return false;
        }
        
        SeleniumDriverInstance.EnterTextByXpath("(//INPUT[@type='text'])[1]", textToEnter);
        SeleniumDriverInstance.takeScreenShot(counter + "- Text addded successfully -", false);
        counter++;
        return true;
    }
    public boolean isImportContactsBtnClicked() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//I[@class=' icon-import']")) {
            
            errorMsg = "Failed to click on import contacts button";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//I[@class=' icon-import']");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked on import contacts button -", false);
        counter++;
        return true;
    }
    public boolean isChooseFileClicked() throws AWTException {
        if(!SeleniumDriverInstance.waitForElementByXpath("//span[@class='btn fileinput-button btn-success']")) {
            
            errorMsg = "Could not click on choose file button";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//span[@class='btn fileinput-button btn-success']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Successfully clicked on choose file button -", false);
        counter++;
        StringSelection absolutePath = new StringSelection("C:\\Users\\ZiyandaP\\Downloads\\MiX_Contacts_training_Import.xlsx");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(absolutePath, null);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        pause(3000);
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
    public boolean isDropDownClicked(){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//A[@fleet-tooltip='Actions'])[2]")) {
            
            errorMsg = "Failed to click drop down";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("(//A[@fleet-tooltip='Actions'])[2]");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked drop down -", false);      
        counter++;
        return true;
    }
    public boolean isRemoveClicked(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//span[@class='ng-binding'][text() ='Remove']")) {
            
            errorMsg = "Failed to click on Remove";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//span[@class='ng-binding'][text() ='Remove']");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked Remove -", false);      
        counter++;
        return true;
    }
    public boolean isRemoveClickedAgain(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//button[@class='btn ng-scope ng-binding btn-success']")) {
            
            errorMsg = "Failed to click on Remove";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//button[@class='btn ng-scope ng-binding btn-success']");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked Remove -", false);      
        counter++;
        return true;
    }
    

}