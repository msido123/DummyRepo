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
public class CreateNewAssetMethods extends CreateNewAsset{
    
    public CreateNewAssetMethods(TestEntity testData) {
        super(testData);
    }
    String description;
    
    public boolean clickAddButton(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//I[@class='icon-plus icon-white']")){
            errorMessage = "Failed to click green plus sign button";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//I[@class='icon-plus icon-white']");
        SeleniumDriverInstance.takeScreenShot("Successfully clicked green plus sign button", false);
        counter++;
        return true;
    }
    
    public boolean clickTextField(String name,String Xpath){
        if(!SeleniumDriverInstance.waitForElementByXpath(Xpath)){
            errorMessage = "Failed to click "+name+" text field";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath(Xpath);
        SeleniumDriverInstance.takeScreenShot("Successfully clicked "+name+" text field",false);
        counter++;
        return true;
    }
     public boolean addTextToField(String textToEnter,String Xpath){
         if(!SeleniumDriverInstance.waitForElementByXpath(Xpath)){
             errorMessage = "Failed to add text into field";
             return false;
         }
         SeleniumDriverInstance.enterTextByXpath(Xpath,textToEnter);
         SeleniumDriverInstance.takeScreenShot("Text added succesfully", false);
         counter++;
         return true;
     }
     public boolean selectFromDropDownMenu(String Xpath,String textToEnter){
         if(!SeleniumDriverInstance.waitForElementByXpath(Xpath)){
             errorMessage = "Failed to click and select from drop down menu";
             return false;
         }
         SeleniumDriverInstance.selectFromDropDownListUsingXpath(Xpath,textToEnter);
         pause(1000);
         SeleniumDriverInstance.takeScreenShot("Clicked and selected from drop down menu successfully", false);
         counter++;
         return true;
     }
     public boolean clickSaveButton(){
         if(!SeleniumDriverInstance.waitForElementByXpath("//BUTTON[@class='btn-wide btn-small btn-success btn ng-scope ng-binding'][text()='Save']")){
             errorMessage = "Failed to click Save button";
             return false;
         }
         SeleniumDriverInstance.clickElementByXpath("//BUTTON[@class='btn-wide btn-small btn-success btn ng-scope ng-binding'][text()='Save']");
         SeleniumDriverInstance.takeScreenShot("Succesfully clicked save button", false);
         counter++;
         return true;
     }
     
     public boolean clickCloseButton(){
         if(!SeleniumDriverInstance.waitForElementByXpath("//BUTTON[@id='Close']")){
             errorMessage = "Failed to click Close button";
             return false;
         }
         SeleniumDriverInstance.clickElementByXpath("//BUTTON[@id='Close']");
         SeleniumDriverInstance.takeScreenShot("Succesfully clicked Close button", false);
         counter++;
         return true;
     }
     
     public boolean clickActionFromMenu(String Xpath){
         if(!SeleniumDriverInstance.waitForElementByXpath(Xpath)){
             errorMessage = "Failed to click action from drop down action menu";
             return false;
         }
         SeleniumDriverInstance.clickElementByXpath(Xpath);
         SeleniumDriverInstance.takeScreenShot("successfully clicked action from drop down action menu",false);
         counter++;
         return true;
     }
    int i = 0;
    public boolean verifyData(String Xpath,String textToVerify){
        if(!SeleniumDriverInstance.waitForElementByXpath(Xpath)){
            errorMessage = "Failed to verify data";
            return false;
        }
        String extractedText =SeleniumDriverInstance.retrieveEnteredTextByXpath(Xpath);
        i++;
        if(!extractedText.contains(textToVerify)){
            testData.extractParameter("Parameter "+i ,extractedText,"FAIL");
            errorMessage = "Entered text does not match with text in Asset details";
            SeleniumDriverInstance.takeScreenShot("Entered text does not match with text in Asset details", false);
            counter++;
            return false;
        }
        testData.extractParameter("Parameter "+i ,extractedText,"PASS");
        SeleniumDriverInstance.takeScreenShot("Text matched 100%", false);
        counter++;
        return true;
    }
    public boolean verifyData2(String Xpath,String textToVerify){
        if(!SeleniumDriverInstance.waitForElementByXpath(Xpath)){
            errorMessage = "Failed to verify data";
            return false;
        }
        String extractedText =SeleniumDriverInstance.retrieveSelectedText(Xpath);
        i++;
        if(!extractedText.contains(textToVerify)){
            testData.extractParameter("Parameter "+i ,extractedText,"FAIL");
            errorMessage = "Entered text does not match with text in Asset details";
            SeleniumDriverInstance.takeScreenShot("Entered text does not match with text in Asset details", false);
            counter++;
            return false;
        }
        testData.extractParameter("Parameter "+i ,extractedText,"PASS");
        SeleniumDriverInstance.takeScreenShot("Text matched 100%", false);
        counter++;
        return true;
    }
    public boolean confirmDelete(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//BUTTON[@ng-show='$modal.okayButton'][text()='Remove']")){
            errorMessage = "Failed to click confirm delete button";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//BUTTON[@ng-show='$modal.okayButton'][text()='Remove']");
        SeleniumDriverInstance.takeScreenShot("confirm delete button clicked successfully", false);
        counter++;
        return true;   
    }
    
}
