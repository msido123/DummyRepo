/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeyDrivenTestframework.Monitor.FleetAdmin.OrganizationGroups;

import KeywordDrivenTestFramework.Entities.TestEntity;

/**
 *
 * @author PhathuxoloJ
 */
public class AddOrEditSiteMethods extends AddOrEditSite{
    
    public AddOrEditSiteMethods(TestEntity testData) {
        super(testData);
    }
    
    public boolean navigateToOrgGroups(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@ng-href='#/fleet-admin/organisation-groups'][text()='Organisation groups']")){
            errorMessage = "Failed to click Organisation Groups";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//A[@ng-href='#/fleet-admin/organisation-groups'][text()='Organisation groups']");
        SeleniumDriverInstance.takeScreenShot("Successfuly clicked Organisation groups", false);
        counter++;
        return true;
    }
    
    public boolean clickPlusSignButton(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//I[@class='icon-plus icon-white']")){
            errorMessage = "Failed to click the plus sign button";
            return false;
        }
        SeleniumDriverInstance.clickElementbyXpath("//I[@class='icon-plus icon-white']");
        SeleniumDriverInstance.takeScreenShot("Successfully clicked the plus sign button",false);
        counter++;
        return true;
    }
    
    public boolean selectSiteFroDropDown(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@ng-click='addSite()'][text()='Site']")){
            errorMessage = "Failed to select Site from drop down menu";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//A[@ng-click='addSite()'][text()='Site']");
        SeleniumDriverInstance.takeScreenShot("Successfully selected site from drop down menu", false);
        counter++;
        return true;
    }
    
    public boolean enterText(String textToAdd,String Xpath){
        if(!SeleniumDriverInstance.waitForElementByXpath(Xpath)){
            errorMessage = "Failed to enter text";
            return false;
        }
        SeleniumDriverInstance.enterTextByXpath(Xpath, textToAdd);
        SeleniumDriverInstance.takeScreenShot("Successfully added text to text field", false);
        counter++;
        return true;
    }
    
    public boolean clickSave(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//BUTTON[@class='btn ng-scope ng-binding btn-wide btn-success'][text()='Save']")){
            errorMessage = "Failed to click save button";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//BUTTON[@class='btn ng-scope ng-binding btn-wide btn-success'][text()='Save']");
        SeleniumDriverInstance.takeScreenShot("Successfully clicked save button", false);
        counter++;
        return true;
    }
    
    public boolean verifySite(String textToVerify){
        if(!SeleniumDriverInstance.waitForElementByXpath("//SPAN[@class='tree-item-label'][text()='"+textToVerify+" (UTC)']")){
            errorMessage = "Failed to retrive text from xpath";
            return false;
        }
        String extractedText = SeleniumDriverInstance.retrieveTextByXpath("//SPAN[@class='tree-item-label'][text()='"+textToVerify+" (UTC)']");
        if(!extractedText.contains(textToVerify)){
            errorMessage = "compared text does not match";
            testData.extractParameter("Site ", extractedText, "FAIL");
            SeleniumDriverInstance.takeScreenShot("Compared text does not match", false);
            counter++;
            return false;
        }
        testData.extractParameter("Site", extractedText,"PASS");
        SeleniumDriverInstance.takeScreenShot("compared data matches 100%", false);
        counter++;
        return true;
    }
    
    public boolean clickSite(String siteToClick){
        if(!SeleniumDriverInstance.waitForElementByXpath("//SPAN[@class='tree-item-label'][text()='"+siteToClick+" (UTC)']")){
            errorMessage = "failed to click on site";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//SPAN[@class='tree-item-label'][text()='"+siteToClick+" (UTC)']");
        SeleniumDriverInstance.takeScreenShot("clicked on site successfully", false);
        counter++;
        return true;
    }
    
    public boolean clickEditButton(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//I[@class='icon-edit']")){
            errorMessage = "Failed to click on edit button";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//I[@class='icon-edit']");
        SeleniumDriverInstance.takeScreenShot("Successfully clicked on edit button", false);
        counter++;
        return true;
    }
    
    
    public boolean editNotes(String textToEnter){
        if(!SeleniumDriverInstance.waitForElementByXpath("//TEXTAREA[1]")){
            errorMessage = "Failed to edit notes";
            counter++;
        }
        SeleniumDriverInstance.EnterTextByXpathNew("//TEXTAREA[1]", textToEnter);
        SeleniumDriverInstance.takeScreenShot("Successfully edited notes", false);
        counter++;
        return true;
    }
    
    public boolean verifyEdit(String textToVerify){
        if(!SeleniumDriverInstance.waitForElementByXpath("//TEXTAREA[1]")){
            errorMessage = "Failed to compare data";
            return false;
        }
        String extractedText = SeleniumDriverInstance.retrieveEnteredTextByXpath("//TEXTAREA[1]");
        if(!extractedText.contains(textToVerify)){
            errorMessage = "compared text does not match";
            testData.extractParameter("extracted notes", extractedText,"FAIL");
            SeleniumDriverInstance.takeScreenShot("Compared text does not match", false);
            counter++;
            return false;
        }
        testData.extractParameter("extracted notes", extractedText,"PASS");
        SeleniumDriverInstance.takeScreenShot("Compared data matches 100%",false);
        counter++;
        return true;
    }
    
    public boolean clickCancelButton(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//BUTTON[@class='btn ng-scope ng-binding btn-wide'][text()='Cancel']")){
            errorMessage = "Failed to click cancel button";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//BUTTON[@class='btn ng-scope ng-binding btn-wide'][text()='Cancel']");
        SeleniumDriverInstance.takeScreenShot("Successfully clicked cancel button", false);
        counter++;
        return true;
    }
    
    public boolean clickRemoveButton(){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//i[@class='icon-red icon-remove-sign'])[1]")){
            errorMessage = "Failed to click remove button";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("(//i[@class='icon-red icon-remove-sign'])[1]");
        SeleniumDriverInstance.takeScreenShot("Successfully clicked remove button", false);
        counter++;
        return true;
    }
    
    public boolean confirmDelete(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//BUTTON[@ng-show='$modal.okayButton'][text()='Delete']")){
            errorMessage = "Failed to confirm delete";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//BUTTON[@ng-show='$modal.okayButton'][text()='Delete']");
        SeleniumDriverInstance.takeScreenShot("Successfully confirmed delete", false);
        counter++;
        return true;
    }
    
    public boolean verifyOrganization(){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//B[@class='caret'])[4]")){
            errorMessage = "Failed to check for organization";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("(//B[@class='caret'])[4]");
        pause(2000);
        String extractedText = SeleniumDriverInstance.retrieveTextByXpath("//SPAN[@bind-once='item.name'][text()='MiX Automation']");
        if(!extractedText.contains("MiX Automation")){
            errorMessage = "Compared text does not match";
            testData.extractParameter("Organisation", extractedText,"FAIL");
            SeleniumDriverInstance.takeScreenShot("Compared etxt does not match",false);
            counter++;
            return false;
        }
        testData.extractParameter("Organisation",extractedText,"PASS");
        SeleniumDriverInstance.takeScreenShot("Compared data matches 100%",false);
        counter++;
        return true;
    }
    
    public boolean verifyGreen(){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//A[@ng-class='$directive.itemClass(item)'])[5]")){
            errorMessage = "Failed to verify colour";
            return false;
        }
        String colour = SeleniumDriverInstance.CheckColourfElement("(//A[@ng-class='$directive.itemClass(item)'])[5]","background-color");
        if(!colour.equals("rgba(80, 184, 72, 1)")){
            errorMessage = "the colour is not green";
            testData.extractParameter("extracted colour", colour,"FAIL");
            SeleniumDriverInstance.takeScreenShot("The colour is not green", false);
            counter++;
            return false;
        }
        testData.extractParameter("extracted colour", colour, "PASS");
        SeleniumDriverInstance.takeScreenShot("Successfully extracted colour", false);
        counter++;
        return true;
    }
    
    public boolean clickCancel(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@ng-click='$directive.cancel()'][text()='Cancel']")){
            errorMessage = "Failed to click cancel";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//A[@ng-click='$directive.cancel()'][text()='Cancel']");
        SeleniumDriverInstance.takeScreenShot("Successfully clicked cacel", false);
        counter++;
        return true;
    }
}
