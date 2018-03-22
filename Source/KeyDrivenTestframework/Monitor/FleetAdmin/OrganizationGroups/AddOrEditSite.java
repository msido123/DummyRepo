/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeyDrivenTestframework.Monitor.FleetAdmin.OrganizationGroups;

import KeyDrivenTestframework.Monitor.Assets.DiagnosticWindowMethods;
import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;

/**
 *
 * @author PhathuxoloJ
 */
public class AddOrEditSite extends BaseClass{
    int counter = 1;
    TestEntity testData;
    String errorMessage;
    
    public AddOrEditSite(TestEntity testData){
        this.testData = testData;
    }
    
    public TestResult runTest() throws InterruptedException{
        DiagnosticWindowMethods run = new DiagnosticWindowMethods(testData);
        AddOrEditSiteMethods methods = new AddOrEditSiteMethods(testData);
        this.setStartTime();
        
        if(!run.navigateToMonitorTab()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Monitor Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Monitor Tab - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click on Monitor Tab",this.getTotalExecutionTime());
        }
        pause(2000);
        if(!methods.navigateToOrgGroups()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on organisation group Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on organisation group Tab - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click on organisation group Tab",this.getTotalExecutionTime());
        }
        pause(2000);
        if(!methods.verifyOrganization()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to verify organisation", true);
            counter++;
            narrator.failedMessage("Failed to verify organisation - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to verify organisation",this.getTotalExecutionTime());
        }
        pause(2000);
        if(!methods.verifyGreen()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to verify colour green", true);
            counter++;
            narrator.failedMessage("Failed to verify colour green - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to verify colour green",this.getTotalExecutionTime());
        }
        pause(2000);
        if(!methods.clickCancel()){
            SeleniumDriverInstance.takeScreenShot(counter+"- Failed to click cancel", false);
            counter++;
            narrator.failedMessage("Failed to click cancel"+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Faield to click cancel",this.getTotalExecutionTime());
        }
        pause(2000);
        if(!methods.clickPlusSignButton()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on plus sign button", true);
            counter++;
            narrator.failedMessage("Failed to click on plus sign button - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click on plus sign button",this.getTotalExecutionTime());
        }
        pause(2000);
        if(!methods.selectSiteFroDropDown()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to select site from drop down menu", true);
            counter++;
            narrator.failedMessage("Failed to select site from drop down menu - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to select site from drop down menu",this.getTotalExecutionTime());
        }
        pause(2000);
        String siteName = SeleniumDriverInstance.DateAndTimeStamp()+ "_MiX Site";
        if(!methods.enterText(siteName, "(//INPUT[@type='text'])[5]")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to type in site name", true);
            counter++;
            narrator.failedMessage("Failed to type in site name - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to type in site name",this.getTotalExecutionTime());
        }
        pause(2000);
        if(!methods.enterText("Site added by MiX", "(//TEXTAREA[@class='span12 no-resize ng-pristine ng-valid'])[1]")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to type in notes", true);
            counter++;
            narrator.failedMessage("Failed to type in notes - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to type in notes",this.getTotalExecutionTime());
        }
        pause(2000);
        if(!methods.clickSave()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click save button", true);
            counter++;
            narrator.failedMessage("Failed to click save button - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click save button",this.getTotalExecutionTime());
        }
        pause(2000);
        if(!methods.verifySite(siteName)){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to compare data", true);
            counter++;
            narrator.failedMessage("Failed to compare data - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to compare data",this.getTotalExecutionTime());
        }
        pause(2000);
        if(!methods.clickSite(siteName)){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on site", true);
            counter++;
            narrator.failedMessage("Failed to click on site - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click on site",this.getTotalExecutionTime());
        }
        pause(2000);
        if(!methods.clickEditButton()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on edit button", true);
            counter++;
            narrator.failedMessage("Failed to click on edit button - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click on edit button",this.getTotalExecutionTime());
        }
        pause(2000);
        if(!methods.editNotes("Site edited by MiX")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to edit in notes", true);
            counter++;
            narrator.failedMessage("Failed to edit in notes - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to edit in notes",this.getTotalExecutionTime());
        }
        pause(2000);
        if(!methods.clickSave()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click save button", true);
            counter++;
            narrator.failedMessage("Failed to click save button - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click save button",this.getTotalExecutionTime());
        }
        pause(2000);
        if(!methods.clickSite(siteName)){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on site", true);
            counter++;
            narrator.failedMessage("Failed to click on site - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click on site",this.getTotalExecutionTime());
        }
        pause(2000);
        if(!methods.clickEditButton()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on edit button", true);
            counter++;
            narrator.failedMessage("Failed to click on edit button - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click on edit button",this.getTotalExecutionTime());
        }
        pause(2000);
        if(!methods.verifyEdit("Site edited by MiX")){
            SeleniumDriverInstance.takeScreenShot(counter+"- Failed to verify data", false);
            counter++;
            narrator.failedMessage("Failed to compare data"+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Faield to compare data",this.getTotalExecutionTime());
        }
        pause(2000);
        if(!methods.clickCancelButton()){
            SeleniumDriverInstance.takeScreenShot(counter+"- Failed to click cancel", false);
            counter++;
            narrator.failedMessage("Failed to click cancel"+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Faield to click cancel",this.getTotalExecutionTime());
        }
        pause(4000);
        if(!methods.clickRemoveButton()){
            SeleniumDriverInstance.takeScreenShot(counter+"- Failed to click remove", false);
            counter++;
            narrator.failedMessage("Failed to click remove"+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Faield to click remove",this.getTotalExecutionTime());
        }
        pause(2000);
        if(!methods.confirmDelete()){
            SeleniumDriverInstance.takeScreenShot(counter+"- Failed to confirm delete", false);
            counter++;
            narrator.failedMessage("Failed to confirm delete"+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Faield to confirm delete",this.getTotalExecutionTime());
        }
        return new TestResult(testData,Enums.ResultStatus.PASS,"Succesfully Added and Edited a new site ",this.getTotalExecutionTime());
    }
    
}
