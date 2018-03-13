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
    
    public boolean navigateToMonitorTab(){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//A[@href='#'])[1]")){
            errorMessage = "Failed to click Monitor tab";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("(//A[@href='#'])[1]");
        SeleniumDriverInstance.takeScreenShot("Clicked Monitor tab succesfully", false);
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
    
    
    
    
}
