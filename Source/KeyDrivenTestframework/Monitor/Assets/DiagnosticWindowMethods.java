/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeyDrivenTestframework.Monitor.Assets;

import KeywordDrivenTestFramework.Entities.TestEntity;

/**
 *
 * @author PhathuxoloJ
 */
public class DiagnosticWindowMethods extends CheckDiagnosticWindow{
    
    public DiagnosticWindowMethods(TestEntity testData) {
        super(testData);
    }
    String parentHandle ;
    public boolean navigateToMonitorTab(){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//A[@href='#'])[1]")){
            errorMessage = "Failed to click Monitor tab";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("(//A[@href='#'])[1]");
        SeleniumDriverInstance.takeScreenShot("Clicked Monitor tab succesfully", false);
        parentHandle = SeleniumDriverInstance.Driver.getWindowHandle();
        counter++;
        return true;          
    }
    
    public boolean navigateToAssetsTab(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@ng-href='#/fleet-admin/assets'][text()='Assets']")){
            errorMessage = "Failed to click on Assets";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//A[@ng-href='#/fleet-admin/assets'][text()='Assets']");
        SeleniumDriverInstance.takeScreenShot("Clicked Assets tab succesfully", false);
        counter++;
        return true;
    }
    
    public boolean clickFilter(){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[1]")){
            errorMessage = "Failed to click the filter";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("(//INPUT[@type='text'])[1]");
        SeleniumDriverInstance.takeScreenShot("Clicked filter successfully",false);
        counter++;
        return true;
    }
    
    public boolean enterTextToFilter(String textToEnter){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[1]")){
            errorMessage = "Failed to enter text into the filter";
            return false;
        }
        SeleniumDriverInstance.EnterTextByXpath("(//INPUT[@type='text'])[1]", textToEnter);
        SeleniumDriverInstance.takeScreenShot("Entered text into filter successfully", false);
        counter++;
        return true;
    }
    
    public boolean clickSearchButton(){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//I[@class='icon-search'])[1]")){
            errorMessage = "Failed to click Search button";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("(//I[@class='icon-search'])[1]");
        SeleniumDriverInstance.takeScreenShot("Clickied search button successfully", false);
        counter++;
        return true;
    }
    
    public boolean clickDropDownActionMenu(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@class='row-action']")){
            errorMessage = "Failed to click drop down action menu";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//A[@class='row-action']");
        SeleniumDriverInstance.takeScreenShot("Successfully clicked drop down action menu", false);
        counter++;
        return true;
    }
    
    public boolean clickDiagnostic(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//SPAN[text()='Diagnostics']")){
            errorMessage = "Failed to click Diagnostic on drop down action menu";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//SPAN[text()='Diagnostics']");
        SeleniumDriverInstance.takeScreenShot("Successfully clicked on Diagnostic from drop down action menu", false);
        counter++;
        return true;
    }
    
    public void maximizePopUpWindow(){
        SeleniumDriverInstance.SwitchToNewWindow();
        pause(1000);
        SeleniumDriverInstance.Driver.manage().window().maximize();
    }
    
    public boolean clickGeneralStatusInfo(){
        maximizePopUpWindow();
        if(!SeleniumDriverInstance.waitForElementByXpath("//span[@class='ng-binding'][text()='General status information']")){
            errorMessage = "Failed to click on general status information bar";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//span[@class='ng-binding'][text()='General status information']");
        SeleniumDriverInstance.takeScreenShot("Clicked general status information bar successfully ",false);
        counter++;
        return true;
    }
    
    public boolean verifyData(String Driver,String GPRS){
        if(!SeleniumDriverInstance.waitForElementByXpath("//td[@class='ng-binding'][text()='MiX DriverJM']") && !SeleniumDriverInstance.waitForElementByXpath("//td[@class='ng-binding'][text()='+CGDCONT=1,\"IP\",\"internet\"']") ){
            errorMessage = "Failed to extract data from the grid";
            return false;
        }
        String gridDriver = SeleniumDriverInstance.retrieveTextByXpath("//td[@class='ng-binding'][text()='MiX DriverJM']");
        String gridGPRS = SeleniumDriverInstance.retrieveTextByXpath("//td[@class='ng-binding'][text()='+CGDCONT=1,\"IP\",\"internet\"']");
        if(!(Driver.contains(gridDriver) && GPRS.contains(gridGPRS))){
            errorMessage = "Failed to match entered data with data in the grid";
            testData.extractParameter("Driver : ",gridDriver , "FAIL");
            testData.extractParameter("GPRS context(restricted) : ",gridGPRS , "FAIL");
            SeleniumDriverInstance.takeScreenShot("Failed to match entered data with data in the grid",false);
            counter++;
            return false;
        }
        testData.extractParameter("Driver : ",gridDriver,"PASS");
        testData.extractParameter("GPRS context(restricted) : ",gridGPRS,"PASS");
        SeleniumDriverInstance.takeScreenShot("Entered data matches the grid data",false);
        counter++;
        return true;
    }
    
    public boolean clickLatestPosition(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//span[@class='ng-binding'][text()='Latest position information']")){
            errorMessage = "Failed to click on Latest position information bar";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//span[@class='ng-binding'][text()='Latest position information']");
        SeleniumDriverInstance.takeScreenShot("Clicked latest position information bar successfully ",false);
        counter++;
        return true;
    }
    int i = 0;
    public boolean verifyLabel(String Xpath,String labelToCheck){
        if(!SeleniumDriverInstance.waitForElementByXpath(Xpath)){
            errorMessage = "No label found";
            System.out.println(errorMessage);
            return false;
        }
        String extractedLabel = SeleniumDriverInstance.retrieveTextByXpath(Xpath);
        if(!extractedLabel.contains(labelToCheck)){
            errorMessage = "Failed to verify labels";
            i++;
            testData.extractParameter("Label "+ i, extractedLabel, "FAIL");
            SeleniumDriverInstance.takeScreenShot("Failed to verify labels", false);
            counter++;
            return false;
        }
        i++;
        testData.extractParameter("Label "+ i, extractedLabel, "PASS");
        SeleniumDriverInstance.takeScreenShot("Labels match 100%", false);
        counter++;
        return true;
    }
    
    public boolean scrollDown(){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//TD)[225]")){
            errorMessage = "could not scroll to element";
            return false;
        }
        SeleniumDriverInstance.scrollToElement("(//TD)[225]");
        SeleniumDriverInstance.takeScreenShot("Mouse scrolled to element successfully", false);
        counter++;
        return true;
    }
    
    public boolean closePopUp(){
        if(!SeleniumDriverInstance.isDriverRunning()){
            errorMessage = "Failed to close pop up window";
            return false;
        }
        SeleniumDriverInstance.SwitchToOriginalWindowNoClose(parentHandle);
        pause(500);
        SeleniumDriverInstance.takeScreenShot("Closed pop up window succesfully",false);
        counter++;
        return true;
    }
    
}
