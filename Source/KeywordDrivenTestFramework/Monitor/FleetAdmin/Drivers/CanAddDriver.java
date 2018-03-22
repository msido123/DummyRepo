/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.Monitor.FleetAdmin.Drivers;

import KeyDrivenTestframework.Manage.Libraries.LocationLibrary.CanEditLocation;
import KeywordDrivenTestFramework.Core.BaseClass;
import static KeywordDrivenTestFramework.Core.BaseClass.SeleniumDriverInstance;
import static KeywordDrivenTestFramework.Core.BaseClass.narrator;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
import KeywordDrivenTestFramework.Monitor.FleetAdmin.Assets.VerifyingDownloadedExcelFiles;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 *
 * @author ZiyandaP
 */
public class CanAddDriver extends BaseClass{
    int counter = 1;
    String errorMsg;
    TestEntity testData;
    private static final DateFormat dateObj = new SimpleDateFormat("yyyy_MM_dd");
    String newDate;
    VerifyingDownloadedExcelFiles object;

public CanAddDriver(TestEntity testData){
    this.testData = testData;
    object = new VerifyingDownloadedExcelFiles(testData);
}
public TestResult executeTest(){
      
    this.setStartTime();
    int randmNum =  generateRandomNum(1,10000);
    
    if(!object.navigateToMonitorTab()){
        SeleniumDriverInstance.takeScreenShot(counter + " Failed to click on Monitor Tab", true);
        counter++;
        narrator.failedMessage("Failed to click on Monitor Tab - "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Monitor Tab", this.getTotalExecutionTime());
    }
    pause(2000);
    if(!navigateToDrivers()){
        SeleniumDriverInstance.takeScreenShot(counter + " Failed to click on Monitor Tab", true);
        counter++;
        narrator.failedMessage("Failed to click on Monitor Tab - "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Monitor Tab", this.getTotalExecutionTime());
    }
    pause(2000);
    if(!isAddDriverBtnClicked()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Add Driver Button ", true);
        counter++;
        narrator.failedMessage("Failed to click on Add Driver Button- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Add Driver Button", this.getTotalExecutionTime());
    }
    pause(2000);
    if(!isNameClicked()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Add Driver Button ", true);
        counter++;
        narrator.failedMessage("Failed to click on Add Driver Button- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Add Driver Button", this.getTotalExecutionTime());
    }
    pause(2000);
    String driverName = "MiX Driver"+newDate;
    if(!addTextToName(driverName)){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Add Driver Button ", true);
        counter++;
        narrator.failedMessage("Failed to click on Add Driver Button- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Add Driver Button", this.getTotalExecutionTime());
    }       
    pause(2000);
    if(!isMobileNumberClicked()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Add Driver Button ", true);
        counter++;
        narrator.failedMessage("Failed to click on Add Driver Button- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Add Driver Button", this.getTotalExecutionTime());
    }
    pause(2000);
    if(!addTextToMobileNumber("+27990888967")){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Add Driver Button ", true);
        counter++;
        narrator.failedMessage("Failed to click on Add Driver Button- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Add Driver Button", this.getTotalExecutionTime());
    }
    pause(2000);
    if(!isSiteClicked()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Site ", true);
        counter++;
        narrator.failedMessage("-Failed to click on Site- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Site", this.getTotalExecutionTime());
    }
    pause(2000);
    if(!isDefaultSelected()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to Select 'Dafault Site ", true);
        counter++;
        narrator.failedMessage("-Failed to click on Site- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to Select 'Dafault Site' ", this.getTotalExecutionTime());
    }
    pause(2000);
    if(!isEmployeeNumFieldClicked()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click Employee Num Field", true);
        counter++;
        narrator.failedMessage("-Failed to click on Site- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Employee Num Field", this.getTotalExecutionTime());
    }
    pause(2000);
    
    if(!enterRandomNumber(randmNum)){
            
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to enter Random number", true);
            counter++;
            narrator.failedMessage("-Failed to enter Random number - "+errorMsg);
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to enter Random number", this.getTotalExecutionTime());       
    }
    pause(2000);
    if(!isEmailAdressClicked()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Email address field", true);
        counter++;
        narrator.failedMessage("-Failed to click on Site- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Email address field", this.getTotalExecutionTime());
    } 
    pause(2000);
    if(!addTextToEmailAdressField("MiXdriver@mailinator.com")){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to add text on Email adress field ", true);
        counter++;
        narrator.failedMessage("Failed to add text on Email adress field- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to add text on Email adress field", this.getTotalExecutionTime());
    }
    pause(2000);
    if(!isCountryClicked()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on country field", true);
        counter++;
        narrator.failedMessage("-Failed to click on Country- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on country field", this.getTotalExecutionTime());
    } 
    pause(2000);
    if(!addTextToCountryField()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to add text on Country field ", true);
        counter++;
        narrator.failedMessage("Failed to add text on Email adress field- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to add text on Country field", this.getTotalExecutionTime());
    }
    pause(2000);
    if(!isSaveButnClicked()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on the Save button", true);
        counter++;
        narrator.failedMessage("Failed to select save- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the Save button", this.getTotalExecutionTime());       
    }
    pause(2000);
    if(!isCloseClicked()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on the closebutton", true);
        counter++;
        narrator.failedMessage("Failed to click close- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the close button", this.getTotalExecutionTime());       
    }
    pause(2000);    
    if(!isFilterClicked()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on the Filter", true);
        counter++;
        narrator.failedMessage("Failed to click on the Filter- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the Filter", this.getTotalExecutionTime());
    }
    pause(2000);
    if(!addTextToFilter(driverName)){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to add text on the Filter", true);
        counter++;
        narrator.failedMessage("Failed to add text on the Filter- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to add text on the Filter", this.getTotalExecutionTime());                
    }
    pause(2000);
    if(!isSearchBtnClicked()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on the Search", true);
        counter++;
        narrator.failedMessage("Failed to click on Search- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the Search", this.getTotalExecutionTime());
    }
    pause(2000);        
    if(!isDropDownClicked()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on the drop down", true);
        counter++;
        narrator.failedMessage("Failed to click on the drop down- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the drop down", this.getTotalExecutionTime());
    } 
    pause(2000);
    if(!isEditClicked()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Edit", true);
        counter++;
        narrator.failedMessage("Failed to add text on the Filter- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Edit", this.getTotalExecutionTime());       
    }
    if(!isCountryClickedAgain()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on country field", true);
        counter++;
        narrator.failedMessage("-Failed to click on Country- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on country field", this.getTotalExecutionTime());
    } 
    pause(2000);
    if(!addTextToCountryFieldAgain()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to add text on Country field ", true);
        counter++;
        narrator.failedMessage("Failed to add text on Email adress field- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to add text on Country field", this.getTotalExecutionTime());
    }
    if(!isSaveButnClickedAgain()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on the Save button", true);
        counter++;
        narrator.failedMessage("Failed to select save- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the Save button", this.getTotalExecutionTime());       
    }
    pause(2000);
    if(!isCloseClickedAgain()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on the closebutton", true);
        counter++;
        narrator.failedMessage("Failed to click close- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the close button", this.getTotalExecutionTime());       
    }    
    pause(2000);    
    if(!isFilterClicked()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on the Filter", true);
        counter++;
        narrator.failedMessage("Failed to click on the Filter- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the Filter", this.getTotalExecutionTime());
    }
    pause(2000);
    if(!addTextToFilter(driverName)){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to add text on the Filter", true);
        counter++;
        narrator.failedMessage("Failed to add text on the Filter- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to add text on the Filter", this.getTotalExecutionTime());                
    }
    if(!isSearchBtnClicked()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on the Search", true);
        counter++;
        narrator.failedMessage("Failed to click on Search- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the Search", this.getTotalExecutionTime());
    }
    pause(2000);
    if(!compareDriverDetails("//DIV[@class='cell alt'][text()='Sweden']", "Sweden")){
        
        SeleniumDriverInstance.takeScreenShot(counter + " - Driver Details do not match - ", true);
        counter++;
        narrator.failedMessage("- Driver Details do not match - "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, " Driver Details do not match!!! ", this.getTotalExecutionTime());                
    }
    pause(2000);
    if(!compareDriverDetails("//DIV[@class='cell alt'][text()='MiXdriver@mailinator.com']", "MiXdriver@mailinator.com")){
        
        SeleniumDriverInstance.takeScreenShot(counter + " - Driver Details do not match - ", true);
        counter++;
        narrator.failedMessage("- Driver Details do not match - "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, " Driver Details do not match!!! ", this.getTotalExecutionTime());                
    }
    pause(2000);
    if(!compareDriverDetails("//DIV[@class='cell alt'][text()='+27990888967']", "+27990888967")){
        
        SeleniumDriverInstance.takeScreenShot(counter + " - Driver Details do not match - ", true);
        counter++;
        narrator.failedMessage("- Driver Details do not match - "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, " Driver Details do not match!!! ", this.getTotalExecutionTime());                
    }
    pause(2000);
     
    String numberAsString = Integer.toString(randmNum);
    if(!compareDriverDetails("//DIV[@class='cell alt'][text()='"+randmNum+"']", numberAsString)){
        
        SeleniumDriverInstance.takeScreenShot(counter + " - Driver Details do not match - ", true);
        counter++;
        narrator.failedMessage("- Driver Details do not match - "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, " Driver Details do not match!!! ", this.getTotalExecutionTime());                
    }
    pause(2000);
    if(!isDropDownClickedAgain()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on the drop down", true);
        counter++;
        narrator.failedMessage("Failed to click on the drop down- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the drop down", this.getTotalExecutionTime());
    }
    pause(2000);
    if(!isRemoveClicked()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Remove", true);
        counter++;
        narrator.failedMessage("Failed to click on Remove- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Remove", this.getTotalExecutionTime());
    }
    pause(2000);
    if(!isRemoveClickedAgain()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Remove", true);
        counter++;
        narrator.failedMessage("Failed to click on Remove- "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Remove", this.getTotalExecutionTime());
    }
    pause(2000);
    System.out.println("Now Its done!!!");
    return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully Added Drivers.", this.getTotalExecutionTime());
    }

    public boolean navigateToDrivers(){
        
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@ng-href='#/fleet-admin/drivers'][text()='Drivers']")) {
            
            errorMsg = "Failed to click on Assets";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//A[@ng-href='#/fleet-admin/drivers'][text()='Drivers']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Clicked on Drivers successfully -", false);
        counter++;
        return true;
    
    }
    public boolean isAddDriverBtnClicked() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//a[@class='btn btn-small btn-success']")) {
            
            errorMsg = "Failed to click on Add Driver Button";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//a[@class='btn btn-small btn-success']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Successfully clicked on Add Driver Button -", false);
        counter++;
        return true;
    }
    public boolean isNameClicked() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//input[@name='driverName']")) {
            
            errorMsg = "Failed to click on Name";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//input[@name='driverName']");
        newDate = dateObj.format(new Date());
        SeleniumDriverInstance.takeScreenShot(counter + "- Successfully clicked on Name -", false);
        counter++;
        return true;
    }
    public boolean addTextToName(String textToEnter) {
        if(!SeleniumDriverInstance.waitForElementByXpath("//input[@name='driverName']")) {
            
            errorMsg = "Failed to add text to MobileNumber";
            return false;
        }
        
        SeleniumDriverInstance.EnterTextByXpath("//input[@name='driverName']", textToEnter);
        SeleniumDriverInstance.takeScreenShot(counter + "- Text added successfully -", false);
        counter++;
        return true;
    }

    public boolean isMobileNumberClicked() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//INPUT[@class='span12 ng-pristine ng-valid ng-valid-dmx-minlength ng-valid-dmx-maxlength ng-valid-dmx-phonenumber ng-valid-dmx-phonecountrycode']")) {
            
            errorMsg = "Failed to click on MobileNumber";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//INPUT[@class='span12 ng-pristine ng-valid ng-valid-dmx-minlength ng-valid-dmx-maxlength ng-valid-dmx-phonenumber ng-valid-dmx-phonecountrycode']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Successfully clicked on Mobile Number -", false);
        counter++;
        return true;
    }
    public boolean addTextToMobileNumber(String textToEnter) {
        if(!SeleniumDriverInstance.waitForElementByXpath("//INPUT[@class='span12 ng-pristine ng-valid ng-valid-dmx-minlength ng-valid-dmx-maxlength ng-valid-dmx-phonenumber ng-valid-dmx-phonecountrycode']")) {
            
            errorMsg = "Failed to add text to MobileNumber";
            return false;
        }
        
        SeleniumDriverInstance.EnterTextByXpath("//INPUT[@class='span12 ng-pristine ng-valid ng-valid-dmx-minlength ng-valid-dmx-maxlength ng-valid-dmx-phonenumber ng-valid-dmx-phonecountrycode']", textToEnter);
        SeleniumDriverInstance.takeScreenShot(counter + "- Text added successfully -", false);
        counter++;
        return true;
    } 
    public boolean isSiteClicked() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//SELECT[@dmx-validate='siteId']")) {
            
            errorMsg = "Failed to click on Site";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//SELECT[@dmx-validate='siteId']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Successfully clicked on Site -", false);
        counter++;
        return true;
    }
    //option[@value='0'][text()= 'Default Site']
    public boolean isDefaultSelected(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//SELECT[@dmx-validate='siteId']")) {
            
            errorMsg = "Failed to click on the the drop down";
            return false;
        }
        SeleniumDriverInstance.selectFromDropDownListUsingXpath("//SELECT[@dmx-validate='siteId']", "Default Site");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked on Default Site -", false);
    
        counter++;
        return true;
    }
    public boolean isEmployeeNumFieldClicked() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//INPUT[@class='span12 ng-pristine ng-valid ng-valid-fleet-driver-employee-number-unique-async']")) {
            
            errorMsg = "Failed to click on Site";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//INPUT[@class='span12 ng-pristine ng-valid ng-valid-fleet-driver-employee-number-unique-async']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Successfully clicked on Site -", false);
        counter++;
        return true;
    }
    public int generateRandomNum(int start, int finish){
        //System.out.println("Unique number is " + dateFormat.format(date));
        
        return (
        start + new Random().nextInt(finish + 1 - start)
        
                );
    
    }
    public boolean enterRandomNumber(int numToEnter) {
        if(!SeleniumDriverInstance.waitForElementByXpath("//INPUT[@class='span12 ng-pristine ng-valid ng-valid-fleet-driver-employee-number-unique-async']")) {
            
            errorMsg = "Failed to Random number";
            return false;
        }       
        SeleniumDriverInstance.EnterTextByXpath("//INPUT[@class='span12 ng-pristine ng-valid ng-valid-fleet-driver-employee-number-unique-async']", numToEnter+"");
        SeleniumDriverInstance.takeScreenShot(counter + "- Random number added successfully -", false);
        counter++;
        return true;
    }    
    public boolean isEmailAdressClicked() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//input[@name='email']")) {
            
            errorMsg = "Failed to click on Email adress field";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//input[@name='email']");
        newDate = dateObj.format(new Date());
        SeleniumDriverInstance.takeScreenShot(counter + "- Successfully clicked on email address field -", false);
        counter++;
        return true;
    }
    public boolean addTextToEmailAdressField(String textToEnter) {
        if(!SeleniumDriverInstance.waitForElementByXpath("//input[@name='email']")) {
            
            errorMsg = "Failed to add text to email address field";
            return false;
        }
        
        SeleniumDriverInstance.EnterTextByXpath("//input[@name='email']", textToEnter);
        SeleniumDriverInstance.takeScreenShot(counter + "- Text added successfully -", false);
        counter++;
        return true;
    }
    public boolean isCountryClicked() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//select[@name='country']")) {
            
            errorMsg = "Failed to click on Country field";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//select[@name='country']");
        newDate = dateObj.format(new Date());
        SeleniumDriverInstance.takeScreenShot(counter + "- Successfully clicked on country field -", false);
        counter++;
        return true;
    }
    public boolean addTextToCountryField(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//select[@name='country']")) {
            
            errorMsg = "Failed to click on the the drop down";
            return false;
        }
        SeleniumDriverInstance.selectFromDropDownListUsingXpath("//select[@name='country']", "Cuba");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully added text on Country field -", false);
    
        counter++;
        return true;
    }
    public boolean isSaveButnClicked() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//button[@event='saveClicked']")) {
            
            errorMsg = "Failed to click on the Save button";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//button[@event='saveClicked']");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked the Save button -", false);
        counter++;
        return true;
    } 
    public boolean isCloseClicked() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//BUTTON[@id='Close']")) {
            
            errorMsg = "Failed to click on the Close button";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//BUTTON[@id='Close']");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked the close button -", false);
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
    public boolean isSearchBtnClicked() {
        if(!SeleniumDriverInstance.waitForElementByXpath("(//I[@class='icon-search'])[1]")) {
            
            errorMsg = "Failed to click on the search button";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("(//I[@class='icon-search'])[1]");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked on the search button -", false);
        counter++;
        return true;
    }    
    public boolean isDropDownClicked(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@class='row-action']")) {
            
            errorMsg = "Failed to click drop down";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//A[@class='row-action']");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked drop down -", false);      
        counter++;
        return true;
    }

    public boolean isEditClicked(){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//A[@event='Edit'])")) {
            
            errorMsg = "Failed to click on Edit";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("(//A[@event='Edit'])");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked Edit -", false);      
        counter++;
        return true;
    }
    public boolean isCountryClickedAgain() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//select[@name='country']")) {
            
            errorMsg = "Failed to click on Country field";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//select[@name='country']");
        newDate = dateObj.format(new Date());
        SeleniumDriverInstance.takeScreenShot(counter + "- Successfully clicked on country field -", false);
        counter++;
        return true;
    }
    public boolean addTextToCountryFieldAgain(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//select[@name='country']")) {
            
            errorMsg = "Failed to click on the the drop down";
            return false;
        }
        SeleniumDriverInstance.selectFromDropDownListUsingXpath("//select[@name='country']", "Sweden");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully added text on Country field -", false);
    
        counter++;
        return true;
    }
    public boolean isSaveButnClickedAgain() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//button[@event='saveClicked']")) {
            
            errorMsg = "Failed to click on the Save button";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//button[@event='saveClicked']");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked the Save button -", false);
        counter++;
        return true;
    }
    public boolean isCloseClickedAgain() {
        if(!SeleniumDriverInstance.waitForElementByXpath("//BUTTON[@id='Close']")) {
            
            errorMsg = "Failed to click on the Close button";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//BUTTON[@id='Close']");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked the close button -", false);
        counter++;
        return true;
    }

    
    /**
     * Data Verification begins here!!!!
     * Filter again for driverName
     * click Save ("To save changes")
     * click close 
     * filter again
     * nOW you check if infor previously entered persisted. 
     *
     * @param textToCompare
     * @param Xpath
     * @return 
     */
    
    public boolean compareDriverDetails(String Xpath,String textToVerify){
        int mover = 0;
        if(!SeleniumDriverInstance.waitForElementByXpath(Xpath)){
            errorMsg = "Failed to verify data";
            return false;
        }
        String extractedText =SeleniumDriverInstance.retrieveTextByXpath(Xpath);
        System.out.println(extractedText);
        System.out.println(textToVerify);
        mover++;
        if(!extractedText.equalsIgnoreCase(textToVerify)){
            testData.extractParameter("Parameter "+mover ,extractedText,"FAIL");
            errorMsg = "Entered text does not match with text in Country";
            SeleniumDriverInstance.takeScreenShot("The text entered  does not match with text in Country Column", false);
            counter++;
            return false;
        }
        testData.extractParameter("Parameter "+mover ,extractedText,"PASS");
        SeleniumDriverInstance.takeScreenShot("Text matched!!", false);
        counter++;
        return extractedText.equalsIgnoreCase(textToVerify);
        
    }
     public boolean isDropDownClickedAgain(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@class='row-action']")) {
            
            errorMsg = "Failed to click drop down";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//A[@class='row-action']");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked drop down -", false);      
        counter++;
        return true;
    }
    //a[@event=\"Remove\"] | //a[@row-index=\"0\"][1]
    public boolean isRemoveClicked(){
    if(!SeleniumDriverInstance.waitForElementByXpath("//body/ul[contains(@class,'grid-row-action-dropdown-menu')][contains(@style,'display: block')]/li/a[@event='Remove']")) {
            
            errorMsg = "Failed to click OK";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//body/ul[contains(@class,'grid-row-action-dropdown-menu')][contains(@style,'display: block')]/li/a[@event='Remove']");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked OK -", false);      
        counter++;
        return true;
    }
    public boolean isRemoveClickedAgain(){
        if(!SeleniumDriverInstance.waitForElementByXpath("/html/body/div[11]/div/div/form/div[2]/div/button[2]")) {
            
            errorMsg = "Failed to click on Remove";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("/html/body/div[11]/div/div/form/div[2]/div/button[2]");
        SeleniumDriverInstance.takeScreenShot(counter + "-Successfully clicked Remove -", false);      
        counter++;
        return true;
    }    
}   
    