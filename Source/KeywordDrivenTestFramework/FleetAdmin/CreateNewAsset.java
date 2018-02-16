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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;

/**
 *
 * @author MsimeleloG
 */
public class CreateNewAsset extends BaseClass{
    
    int counter = 1;
    String errorMsg = "";
    String regNumber;
    TestEntity testData;
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public CreateNewAsset(TestEntity testData) {
        
        this.testData = testData;
        regNumber = randomAlphaNumeric(12);
        
    }
    
    public TestResult executeTest() throws InterruptedException {
        
        this.setStartTime();
        
        if(!navigateToMonitorTab()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Monitor Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Monitor Tab - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Monitor Tab", this.getTotalExecutionTime());
        }
        
        if(!clickAssets()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Assets", true);
            counter++;
            narrator.failedMessage("Failed to click on Assets - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Assets", this.getTotalExecutionTime());
        }
        
        if(!clickAddNewAssetButton()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on add new asset button", true);
            counter++;
            narrator.failedMessage("Failed to click on add new asset button - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on add new asset button", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!enterAssetDescription()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to add asset description", true);
            counter++;
            narrator.failedMessage("Failed to add asset description - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to add asset description", this.getTotalExecutionTime());
        }
        
        if(!selectAssetType()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to select asset type", true);
            counter++;
            narrator.failedMessage("Failed to select asset type- "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to select asset type", this.getTotalExecutionTime());
        }
        
        if(!enterRegistrationNumber()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to enter registration number", true);
            counter++;
            narrator.failedMessage("Failed to enter registration number - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to enter registration number", this.getTotalExecutionTime());
            
        }
        
        if(!selectSite()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to select site", true);
            counter++;
            narrator.failedMessage("Failed to select site - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to select site", this.getTotalExecutionTime());
        }
        pause(1000);
        
        if(!clickSaveAssetButton()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click save asset button", true);
            counter++;
            narrator.failedMessage("Failed to click save asset button - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click save asset button", this.getTotalExecutionTime());
        }
        
        if(!clickCloseButton()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click close asset button", true);
            counter++;
            narrator.failedMessage("Failed to click close asset button - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click close asset button", this.getTotalExecutionTime());
        }
        pause(1000);
        
        if(!isFilterClicked()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on the filter", true);
            counter++;
            narrator.failedMessage("Failed to click on the filter - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the filter", this.getTotalExecutionTime());
        }
        
        if(!addTextToFilter("_MiXAsset")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to add text to filter", true);
            counter++;
            narrator.failedMessage("Failed to add text to filter - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to add text to filter", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!clickSearchButton()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click search button", true);
            counter++;
            narrator.failedMessage("Failed to click search button - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click search button", this.getTotalExecutionTime());
        }
        
        if(!clickEditAsset()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click edit asset button", true);
            counter++;
            narrator.failedMessage("Failed to click edit asset button - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click edit asset button", this.getTotalExecutionTime());
        }
        
        if(!verifyAssetDescriptionValue("_MiXAsset")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to verify Asset Description value", true);
            counter++;
            narrator.failedMessage("Failed to verify Asset Description value - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to verify Asset Description value", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!verifyRegistrationNumber()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to verify Registration number", true);
            counter++;
            narrator.failedMessage("Failed to verify Registration number - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to verify Registration number", this.getTotalExecutionTime());
        }
        pause(1000);  
        if(!returnToAssetList()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click close button", true);
            counter++;
            narrator.failedMessage("Failed to click close button - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click close button", this.getTotalExecutionTime());
            
        }
        pause(1000);
        
        if(!isFilterClicked()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on the filter", true);
            counter++;
            narrator.failedMessage("Failed to click on the filter - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the filter", this.getTotalExecutionTime());
        }
        
        if(!addTextToFilter("_MiXAsset")) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to add text to filter", true);
            counter++;
            narrator.failedMessage("Failed to add text to filter - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to add text to filter", this.getTotalExecutionTime());
        }
        
        if(!clickSearchButton()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click search button", true);
            counter++;
            narrator.failedMessage("Failed to click search button - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click search button", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!removeAsset()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click remove asset from dropdown button", true);
            counter++;
            narrator.failedMessage("Failed to click remove asset from dropdown button - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click remove asset from dropdown button", this.getTotalExecutionTime());
        }
        pause(1000);
        
        if(!showRemoveAssetPopUp()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to show remove asset pop up", true);
            counter++;
            narrator.failedMessage("Failed to show remove asset pop up - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to show remove asset pop up", this.getTotalExecutionTime());
        }
        pause(1000);
        if(!confirmRemovalOfAsset()) {
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click remove asset button", true);
            counter++;
            narrator.failedMessage("Failed to click remove asset button - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed click remove asset button", this.getTotalExecutionTime());
        }
        pause(1000);
        
        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully created and removed new asset.", this.getTotalExecutionTime());
    }
    
    public boolean navigateToMonitorTab() {
        
        if(!SeleniumDriverInstance.waitForElementByXpath("(//A[@href='#'])[1]")) {
            
            errorMsg = "Failed to click monitor";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("(//A[@href='#'])[1]");
        SeleniumDriverInstance.takeScreenShot(counter + "-Monitor tab clicked successfully -", false);
        counter++;
        return true;
    }
    
    public boolean clickAssets() {
        
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@ng-href='#/fleet-admin/assets'][text()='Assets']")) {
            
            errorMsg = "Failed to click assets";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("//A[@ng-href='#/fleet-admin/assets'][text()='Assets']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Assets clicked successfully -", false);
        counter++;
        return true;
    }
    
    public boolean clickAddNewAssetButton() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@fleet-tooltip='Add asset']")) {
            
            errorMsg = "Failed to click add new asset button";
            return false;
        }
        
        SeleniumDriverInstance.clickElementByXpath("//A[@fleet-tooltip='Add asset']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Add new asset button clicked successfully -", false);
        counter++;
        return true;
    }
    
    public String myDateStamp(){
        String dateTimeStamp;
        DateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date2 = new Date();
        dateTimeStamp = dateFormat2.format(date2);
        dateTimeStamp = dateTimeStamp.replaceAll("/", "");
        
        
        return dateTimeStamp;
    }
    
    public boolean enterAssetDescription() {
        if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[1]")) {
            
            errorMsg = "Failed to click asset description";
            return false;
        }
        
        SeleniumDriverInstance.EnterTextByXpath("(//INPUT[@type='text'])[1]", myDateStamp() + "_MiXAsset");
        SeleniumDriverInstance.takeScreenShot(counter + "- Asset description entered successfully -", false);
        counter++;
        return true;
    }
    
    public boolean selectAssetType() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//SELECT[@name='assetTypeId']")) {
            
            errorMsg = "Failed to click asset type droptown";
            return false;
        }
        
        SeleniumDriverInstance.selectFromDropDownListUsingXpath("//SELECT[@name='assetTypeId']", "Boat");
        SeleniumDriverInstance.takeScreenShot(counter + "- Asset type dropdown button clicked successfuly -", false);
        counter++;
        return true;
    }
    
  
        public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
        }

        public boolean enterRegistrationNumber() {
            if(!SeleniumDriverInstance.waitForElementByXpath("//INPUT[@ui-if='!duplicate']")) {
                
                errorMsg = "Failed to add registration number";
                return false;
            }
            
            SeleniumDriverInstance.EnterTextByXpath("//INPUT[@ui-if='!duplicate']", regNumber);
            SeleniumDriverInstance.takeScreenShot(counter + "- Registration number entered successfully -", false);
            counter++;
            return true;
        }
        
        public boolean selectSite() {
            if(!SeleniumDriverInstance.waitForElementByXpath("//SELECT[@name='siteId']")) {
                
                errorMsg = "Failed to click select site dropdown";
                return false;
            }
            
            SeleniumDriverInstance.selectFromDropDownListUsingXpath("//SELECT[@name='siteId']", "Default Site");
            SeleniumDriverInstance.takeScreenShot(counter + "- Select Site dropdown button clicked successfully -", false);
            counter++;
            return true;
        }
        
        public boolean clickSaveAssetButton() {
            if(!SeleniumDriverInstance.waitForElementByXpath("//BUTTON[@class='btn-wide btn-small btn-success btn ng-scope ng-binding'][text()='Save']")) {
                
                errorMsg = "Failed to click on save button";
                return false;
            }
            
            SeleniumDriverInstance.clickElementByXpath("//BUTTON[@class='btn-wide btn-small btn-success btn ng-scope ng-binding'][text()='Save']");
            SeleniumDriverInstance.takeScreenShot(counter + "- Save button clicked successfully -", false);
            counter++;
            return true;
        }
        
        public boolean clickCloseButton() {
            if(!SeleniumDriverInstance.waitForElementByXpath("//BUTTON[@id='Close']")) {
                
                errorMsg = "Failed to click close button";
                return false;
            }
            
            SeleniumDriverInstance.clickElementByXpath("//BUTTON[@id='Close']");
            SeleniumDriverInstance.takeScreenShot(counter + "- Close button clicked succesfully -", false);
            counter++;
            return true;
        }
        
        public boolean isFilterClicked() {
            
            if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[1]")) {
                
                errorMsg = "Failed to click filter";
                return false;
            }
            
            SeleniumDriverInstance.clickElementByXpath("(//INPUT[@type='text'])[1]");
            SeleniumDriverInstance.takeScreenShot(counter + "- Filter clicked successfully -", false);
            counter++;
            return true;
        }
        
        public boolean addTextToFilter(String textToEnter) {
            if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[1]")) {
                
                errorMsg = "Cannot add text to fiter";
                return false;
            }
            
            SeleniumDriverInstance.EnterTextByXpath("(//INPUT[@type='text'])[1]", textToEnter);
            SeleniumDriverInstance.takeScreenShot(counter + "- Text added to filter successfully -", false);
            counter++;
            return true;
        }
        
        public boolean clickSearchButton() {
            if(!SeleniumDriverInstance.waitForElementByXpath("(//I[@class='icon-search'])[1]")) {
                errorMsg = "Failed to click search button";
                return false;
            }
            SeleniumDriverInstance.clickElementByXpath("(//I[@class='icon-search'])[1]");
            SeleniumDriverInstance.takeScreenShot(counter + "- Search button clicked successfully -", false);
            counter++;
            return true;
        }
        
        public boolean clickEditAsset() {
            if(!SeleniumDriverInstance.waitForElementByXpath("//A[@class='row-action']")) {
                
                errorMsg = "Failed to click action dropdown";
                return false;
            }
            SeleniumDriverInstance.clickElementByXpath("//A[@class='row-action']");
            SeleniumDriverInstance.clickElementByXpath("//span[text()='Edit']");
            SeleniumDriverInstance.takeScreenShot(counter + "- Clicked edit asset successfully -", false);
            counter++;
            return true;
        }
        
        public boolean verifyAssetDescriptionValue(String textToCheck) {
            if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[1]")) {
                
                errorMsg = "Asset description text box not selected";
                return false;
            }
            
            String value= SeleniumDriverInstance.Driver.findElement(By.xpath("(//INPUT[@type='text'])[1]")).getAttribute("value");
            System.out.println(value);
            if((!value.contains(textToCheck))) {
                
                errorMsg = "Asset description does not match with pre-described one";
                testData.extractParameter("Retrieved value", value, "FAIL");
                SeleniumDriverInstance.takeScreenShot(counter + "- Asset Description value is not the same -", false);
                counter++;
                return false;
            }
            
            testData.extractParameter("Retrieved value", value, "PASS");
            SeleniumDriverInstance.takeScreenShot(counter + "- Asset Description matches the pre-described one -", false);
            counter++;
            return true;
        }
        
        public boolean verifyRegistrationNumber() {
            if(!SeleniumDriverInstance.waitForElementByXpath("//INPUT[@ui-if='!duplicate']")) {
                
                errorMsg = "Failed to find registration number text box";
                return false;
            }
            String value = SeleniumDriverInstance.Driver.findElement(By.xpath("//INPUT[@ui-if='!duplicate']")).getAttribute("value");
            System.out.println(value);
            if(!value.contains(regNumber))
            {
                errorMsg = "Registration number does not match with pre-described one";
                testData.extractParameter("Retrieved value", value, "FAIL");
                SeleniumDriverInstance.takeScreenShot(counter + "- Registration number is not the same -", false);
                counter++;
                return false;
            }
            
            testData.extractParameter("Retrieved value", value, "PASS");
            SeleniumDriverInstance.takeScreenShot(counter + "- Registration number matches the pre-described one -", false);
            counter++;
            return true;
        }
        
        
        public boolean verifyAssetTypeValue(String textToCompare) {
            
            if(!SeleniumDriverInstance.waitForElementByXpath("//SELECT[@name='assetTypeId']")) {
                
                errorMsg = "Failed to click on asset type value dropdown";
                return false;
            }
            
            String value = SeleniumDriverInstance.Driver.findElement(By.xpath("//SELECT[@name='assetTypeId']")).getAttribute("value");
            System.out.println(value + "BITCHES");
            if((!value.contains(textToCompare))) {
                
                errorMsg = "Asset type value does not match with pre-described one";
                testData.extractParameter("Retrieved value", value, "FAIL");
                SeleniumDriverInstance.takeScreenShot(counter + "- Asset type value is not the same -", false);
                counter++;
                return false;
            }
            
            testData.extractParameter("Retrieved value", value, "PASS");
            SeleniumDriverInstance.takeScreenShot(counter + "- Asset type value matches the pre-described one -", false);
            counter++;
            return true;
        }
        
        
        public boolean verifySiteType(String assetSiteToCompare) {
            
            if(!SeleniumDriverInstance.waitForElementByXpath("//SELECT[@name='siteId']")) {
                
                errorMsg = "Failed to click asset site";
                return false;
            }
            String value = SeleniumDriverInstance.Driver.findElement(By.xpath("//SELECT[@name='siteId']")).getAttribute("value");
            System.out.println(value);
            if(!value.contains(assetSiteToCompare)) {
                
                errorMsg = "Asset site value does not match with pre-described one";
                testData.extractParameter("Retrieved value", value, "FAIL");
                SeleniumDriverInstance.takeScreenShot(counter + "- Asset site value is not the same -", false);
                counter++;
                return false;
            }
            testData.extractParameter("Retrieved value", value, "PASS");
            SeleniumDriverInstance.takeScreenShot(counter + "- Asset site value matches the pre-described one -", false);
            counter++;
            return true;
        }
        
        public boolean returnToAssetList() {
            
            if(!SeleniumDriverInstance.waitForElementByXpath("//BUTTON[@id='Close']")) {
                
                errorMsg = "Failed to click close button";
                return false;
            }
            
            SeleniumDriverInstance.clickElementByXpath("//BUTTON[@id='Close']");
            SeleniumDriverInstance.takeScreenShot(counter + "- Close button clicked successfully", false);
            counter++;
            return true;
        }
        
        public boolean removeAsset() {
            if(!SeleniumDriverInstance.waitForElementByXpath("//A[@class='row-action']")) {
                
                errorMsg = "Failed to click remove button";
                return false;
            }
            SeleniumDriverInstance.clickElementByXpath("//A[@class='row-action']");
            SeleniumDriverInstance.clickElementByXpath("//body/ul[@class= 'dropdown-menu grid-row-action-dropdown-menu'][contains(@style,'display: block')]/li/a[@event='Remove']");
            SeleniumDriverInstance.takeScreenShot(counter + "- Clicked remove asset successfully -", false);
            counter++;
            return true;
        }
        
        public boolean showRemoveAssetPopUp() {
            if(!SeleniumDriverInstance.waitForElementByXpath("(//DIV[@class='modal-inner-body white-box-padding'])[2]"))
            {
                errorMsg = "Failed to show remove asset pop up";
                return false;
            }
            
            SeleniumDriverInstance.takeScreenShot(counter + "- Remove asset pop up shown successfully -", false);
            counter++;
            return true;
        }
        
        public boolean confirmRemovalOfAsset() {
            
            if(!SeleniumDriverInstance.waitForElementByXpath("//BUTTON[@ng-show='$modal.okayButton'][text()='Remove']")) {
                
                errorMsg = "Failed to clicked remove asset";
                return false;
            }
            SeleniumDriverInstance.clickElementByXpath("//BUTTON[@ng-show='$modal.okayButton'][text()='Remove']");
            SeleniumDriverInstance.takeScreenShot(counter + "- Remove button clicked successfully - ", false);
            counter++;
            return true;
        }
        
}
