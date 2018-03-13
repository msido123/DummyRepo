/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.Monitor.FleetAdmin.Assets;

import static KeyDrivenTestframework.Manage.Libraries.LocationLibrary.CanEditLocation.object1;
import static KeyDrivenTestframework.Manage.Libraries.LocationLibrary.CanEditLocation.object3;
import KeywordDrivenTestFramework.Core.BaseClass;
import static KeywordDrivenTestFramework.Core.BaseClass.SeleniumDriverInstance;
import static KeywordDrivenTestFramework.Core.BaseClass.narrator;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
import KeywordDrivenTestFramework.Manage.Libraries.AddingNewEventToSystem;
import KeywordDrivenTestFramework.Manage.Templates.CheckTemplatesLoadInfoZee;
import KeywordDrivenTestFramework.Manage.Templates.CheckingEventTemplateFilter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ZiyandaP
 */
public class VerifyingDownloadedExcelFiles extends BaseClass{
    int counter = 1;
    String errorMsg;
    TestEntity testData;
    String defaultWindow;
    String popUpWindow;
    Date date = new Date();
    DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
    
    public static CheckTemplatesLoadInfoZee object1;  
    public static CheckingEventTemplateFilter object2;
    public static AddingNewEventToSystem object3;    
    

public VerifyingDownloadedExcelFiles(TestEntity testData){

this.testData =  testData;
    object1 = new CheckTemplatesLoadInfoZee(testData);
    object2 = new CheckingEventTemplateFilter(testData);
    object3 = new AddingNewEventToSystem(testData);
}

public TestResult executeTest() throws InterruptedException {
        
    this.setStartTime();
    if(!navigateToMonitorTab()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Monitor Tab", true);
        counter++;
        narrator.failedMessage("Failed to click on Manage Tab - "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on Monitor Tab", this.getTotalExecutionTime());
    }
    pause(1000);
    if(!navigateToAssets()){
            
        SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on the Assets ", true);
        counter++;
        narrator.failedMessage("Failed to click on the Libraries Tab - "+errorMsg);
        return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the Assets Tab", this.getTotalExecutionTime());
    }
    pause(1000);
    return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully clicked on the Save button.", this.getTotalExecutionTime()); 
} 
    public boolean navigateToMonitorTab(){
        
        if(!SeleniumDriverInstance.waitForElementByXpath("(//A[@href='#'])[1]")) {
            
            errorMsg = "Failed to click on Monitor Tab";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("(//A[@href='#'])[1]");
        SeleniumDriverInstance.takeScreenShot(counter + "- Clicked Monitor tab successfully -", false);
        counter++;
        return true;
    
    }
    public boolean navigateToAssets(){
        
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@ng-href='#/fleet-admin/assets'][text()='Assets']")) {
            
            errorMsg = "Failed to click on Assets";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//A[@ng-href='#/fleet-admin/assets'][text()='Assets']");
        SeleniumDriverInstance.takeScreenShot(counter + "- Clicked on Assets successfully -", false);
        counter++;
        return true;
    
    }
}