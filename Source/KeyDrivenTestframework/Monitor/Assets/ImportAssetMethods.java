/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeyDrivenTestframework.Monitor.Assets;

import KeywordDrivenTestFramework.Entities.TestEntity;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;

/**
 *
 * @author PhathuxoloJ
 */
public class ImportAssetMethods extends ImportAsset{
    
    public ImportAssetMethods(TestEntity testData) {
        super(testData);
    }
    DiagnosticWindowMethods function = new DiagnosticWindowMethods(testData);
    CreateNewAssetMethods function2 = new CreateNewAssetMethods(testData);
    DiagnosticWindowMethods run = new DiagnosticWindowMethods(testData);
    
    public boolean existOrNot(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//SPAN[@class='badge badge-grey ng-binding']")){
            errorMessage = "Failed to extract number of rows";
            return false;
        }
        String rowCount = SeleniumDriverInstance.retrieveTextByXpath("//SPAN[@class='badge badge-grey ng-binding']");
        if(rowCount.equals("0")){
            SeleniumDriverInstance.takeScreenShot("Asset does not exist, it's safe to import", false);
            counter++;
            return true;  
        }
        if(rowCount.equals("1")){
            function.clickDropDownActionMenu();
            pause(1000);
            clickRemove();
            pause(1000);
            function2.confirmDelete();
            counter++;
            return true;
        }
        else{
            errorMessage = "Failed to compare row count";
            SeleniumDriverInstance.takeScreenShot("Failed to compare row count", false);
            counter++;
            return false;
        }
        
    }
    public boolean clickRemove(){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//SPAN[text()='Remove'])")){
            errorMessage = "Failed to click remove from drop down action menu";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("(//SPAN[text()='Remove'])");
        SeleniumDriverInstance.takeScreenShot("Successfully clicked remove from drop down action menu",false);
        counter++;
        return true;
    }
    
    public boolean clickImportButton(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//I[@class='icon-import']")){
            errorMessage = "Failed to click import assets button";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//I[@class='icon-import']");
        SeleniumDriverInstance.takeScreenShot("Successfully clicked import assets button", false);
        counter++;
        return true;
    }
 
    public boolean clickChooseButton() throws FileNotFoundException, AWTException{
        if(!SeleniumDriverInstance.waitForElementByXpath("//span[@class='btn fileinput-button btn-success']")){
                errorMessage = "Failed to click choose button";
                return false;
        }        
        SeleniumDriverInstance.clickElementByXpath("//span[@class='btn fileinput-button btn-success']");       
        SeleniumDriverInstance.takeScreenShot("Clicked choose button succesfully",false);
        uploadFile("MIXAssets_import Training.xlsx");
        pause(20000);
        SeleniumDriverInstance.takeScreenShot("Successfully uploaded file",false);
        counter++;
        return true; 
    }
    
    public void uploadFile(String filePath) throws AWTException,FileNotFoundException{
        StringSelection absolutePath = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(absolutePath, null);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
    
    public boolean existOrNot2(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//SPAN[@class='badge badge-grey ng-binding']")){
            errorMessage = "Failed to extract number of rows";
            return false;
        }
        String rowCount = SeleniumDriverInstance.retrieveTextByXpath("//SPAN[@class='badge badge-grey ng-binding']");
        if(rowCount.equals("0")){
            pause(20000);
            run.clickSearchButton();
            counter++;
            return rowCount == "1";  
        }
        if(rowCount.equals("1")){
            SeleniumDriverInstance.takeScreenShot("File exist", false);
            counter++;
            return true;
        }
        else{
            errorMessage = "Failed to compare row count";
            SeleniumDriverInstance.takeScreenShot("Failed to compare row count", false);
            counter++;
            return false;
        }
        
    }
    
    public boolean extractData(String Xpath,String placeHolder){
        if(!SeleniumDriverInstance.waitForElementByXpath(Xpath)){
            errorMessage = "Failed to compare data";
            return false;
        }
        String extractedText = SeleniumDriverInstance.retrieveTextByXpath(Xpath);
        testData.extractParameter( placeHolder +" ",extractedText,"PASS");
        SeleniumDriverInstance.takeScreenShot("Extracted "+placeHolder+" successfully", false);
        counter++;
        return true;     
    }
    
}
