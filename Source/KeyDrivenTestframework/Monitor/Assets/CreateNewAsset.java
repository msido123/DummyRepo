/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeyDrivenTestframework.Monitor.Assets;

import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;

/**
 *
 * @author PhathuxoloJ
 */
public class CreateNewAsset extends BaseClass{
    int counter = 1;
    TestEntity testData;
    String errorMessage;
    
    public CreateNewAsset(TestEntity testData){
        this.testData = testData;
    }
    
    
    
    public TestResult runTest() throws InterruptedException{
        this.setStartTime();
        DiagnosticWindowMethods run = new DiagnosticWindowMethods(testData);
        CreateNewAssetMethods methods = new CreateNewAssetMethods(testData);
        if(!run.navigateToMonitorTab()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Monitor Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Monitor Tab - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click on Monitor Tab",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!run.navigateToAssetsTab()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Assets Tab", true);
            counter++;
            narrator.failedMessage("Failed to click on Assets Tab - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click on Assets Tab",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.clickAddButton()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click Add asset button", true);
            counter++;
            narrator.failedMessage("Failed to click Add asset button - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click Add asset button",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.clickTextField("Asset description", "(//INPUT[@type='text'])[1]")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click asset description text field", true);
            counter++;
            narrator.failedMessage("Failed to click asset descripption text field - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click asset description text field",this.getTotalExecutionTime());
        }
        pause(1000);
        String description = SeleniumDriverInstance.DateAndTimeStamp() +"_MiXAsset";
        if(!methods.addTextToField(description,"(//INPUT[@type='text'])[1]")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to Add text in asset description field", true);
            counter++;
            narrator.failedMessage("Failed to Add text in asset description field - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to Add text in asset description field",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.clickTextField("Registration number", "//INPUT[@ui-if='!duplicate']")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click registration number text field", true);
            counter++;
            narrator.failedMessage("Failed to click registration number text field - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click registration number text field",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.addTextToField("TRAIN20180314","//INPUT[@ui-if='!duplicate']")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to Add text in registration number field", true);
            counter++;
            narrator.failedMessage("Failed to Add text in registration number field - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to Add text in registration number field",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.clickTextField("Fleet number", "//INPUT[@ng-switch-when='true']")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click Fleet number text field", true);
            counter++;
            narrator.failedMessage("Failed to click Fleet number text field - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click Fleet number text field",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.addTextToField("TRAINING-FLEET 2018","//INPUT[@ng-switch-when='true']")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to Add text in Fleet number field", true);
            counter++;
            narrator.failedMessage("Failed to Add text in Fleet number field - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to Add text in Fleet number field",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.clickTextField("Vehicle Identification Number", "//INPUT[@ng-switch-default='']")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click VIN number text field", true);
            counter++;
            narrator.failedMessage("Failed to click VIN number text field - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click VIN number text field",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.addTextToField("TRAINING-VIN 2018","//INPUT[@ng-switch-default='']")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to Add text in VIN field", true);
            counter++;
            narrator.failedMessage("Failed to Add text in VIN number field - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to Add text in VIN number field",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.clickTextField("Make", "(//INPUT[@type='text'])[5]")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click make text field", true);
            counter++;
            narrator.failedMessage("Failed to click make text field - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click make text field",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.addTextToField("2018_Make","(//INPUT[@type='text'])[5]")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to Add text in make field", true);
            counter++;
            narrator.failedMessage("Failed to Add text in make field - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to Add text in make field",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.clickTextField("Year", "(//INPUT[@type='text'])[7]")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click year text field", true);
            counter++;
            narrator.failedMessage("Failed to click year text field - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click year text field",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.addTextToField("2018","(//INPUT[@type='text'])[7]")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to Add text in year field", true);
            counter++;
            narrator.failedMessage("Failed to Add text in year field - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to Add text in year field",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.clickTextField("MiX account number", "(//INPUT[@type='text'])[13]")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click MiX account number text field", true);
            counter++;
            narrator.failedMessage("Failed to click MiX account number text field - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click MiX account number text field",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.addTextToField("MIX20180301","(//INPUT[@type='text'])[13]")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to Add text in MiX account number field", true);
            counter++;
            narrator.failedMessage("Failed to Add text in MiX account number field - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to Add text in MiX account number field",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.clickTextField("Notes", "//TEXTAREA[@rows='3']")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click Notes text field", true);
            counter++;
            narrator.failedMessage("Failed to click Notes text field - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click Notes text field",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.addTextToField("Vehicle frequent route is Old Paarl road","//TEXTAREA[@rows='3']")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to Add text in Notes field", true);
            counter++;
            narrator.failedMessage("Failed to Add text in Notes field - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to Add text in Notes field",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.clickTextField("Model", "(//INPUT[@type='text'])[6]")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click Model text field", true);
            counter++;
            narrator.failedMessage("Failed to click Model text field - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click Model text field",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.addTextToField("GTI 2018","(//INPUT[@type='text'])[6]")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to Add text in Model field", true);
            counter++;
            narrator.failedMessage("Failed to Add text in Model field - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to Add text in Model field",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.clickTextField("Engine number", "(//INPUT[@type='text'])[8]")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click Engine number text field", true);
            counter++;
            narrator.failedMessage("Failed to click Engine number text field - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click Engine number text field",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.addTextToField("11223","(//INPUT[@type='text'])[8]")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to Add text in Engine number field", true);
            counter++;
            narrator.failedMessage("Failed to Add text in Engine number field - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to Add text in Engine number field",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.clickTextField("Target fuel consumption", "(//INPUT[@type='text'])[9]")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click Target fuel consumption text field", true);
            counter++;
            narrator.failedMessage("Failed to click Target fuel consumption text field - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click Target fuel consumption text field",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.addTextToField("200","(//INPUT[@type='text'])[9]")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to Add text in Target fuel consumption field", true);
            counter++;
            narrator.failedMessage("Failed to Add text in Target fuel consumption field - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to Add text in Target fuel consumption field",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.clickTextField("Additional mobile device", "(//INPUT[@type='text'])[12]")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click Additional mobile device text field", true);
            counter++;
            narrator.failedMessage("Failed to click Additional mobile device text field - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click Additional mobile device text field",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.addTextToField("Cellphone","(//INPUT[@type='text'])[12]")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to Add text in Additional mobile device field", true);
            counter++;
            narrator.failedMessage("Failed to Add text in Additional mobile device field - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to Add text in Additional mobile device field",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.selectFromDropDownMenu("(//SELECT[@class='span12 ng-pristine ng-valid'])[2]","Petrol")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click and select from drop down menu", true);
            counter++;
            narrator.failedMessage("Failed to click and select from drop down menu - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click and select from drop down menu",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.selectFromDropDownMenu("//SELECT[@ng-disabled='(assetId && asset.isConnectedTrailer) || !canEdit']","Passenger Vehicle")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click and select from drop down menu", true);
            counter++;
            narrator.failedMessage("Failed to click and select from drop down menu - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click and select from drop down menu",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.selectFromDropDownMenu("(//SELECT[@class='span12 ng-pristine ng-valid'])[1]","South Africa")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click and select from drop down menu", true);
            counter++;
            narrator.failedMessage("Failed to click and select from drop down menu - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click and select from drop down menu",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.selectFromDropDownMenu("/html/body/div[4]/span[2]/div/div/div/div[1]/div[2]/div/div/div[3]/div[1]/div[1]/div[1]/form/div[2]/div[2]/div/select","Default Site")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click and select from drop down menu", true);
            counter++;
            narrator.failedMessage("Failed to click and select from drop down menu - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click and select from drop down menu",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.clickSaveButton()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click save button", true);
            counter++;
            narrator.failedMessage("Failed to click save button - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click save button",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.clickCloseButton()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click close button", true);
            counter++;
            narrator.failedMessage("Failed to click close button - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click close button",this.getTotalExecutionTime());
        }
         pause(1000);
        if(!run.clickFilter()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Filter", true);
            counter++;
            narrator.failedMessage("Failed to click on Filter - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click on Filter",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!run.enterTextToFilter(description)){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to enter text into filter", true);
            counter++;
            narrator.failedMessage("Failed to enter text into filter - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to enter text into filter",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!run.clickSearchButton()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click search button", true);
            counter++;
            narrator.failedMessage("Failed to click search button - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click search button",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!run.clickDropDownActionMenu()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click drop down action menu ", true);
            counter++;
            narrator.failedMessage("Failed to click drop down action menu  - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click drop down action menu ",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.clickActionFromMenu("//SPAN[text()='Edit']")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click edit from drop down action menu", true);
            counter++;
            narrator.failedMessage("Failed to click edit from drop down action menu - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click edit from drop down action menu",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.verifyData("(//INPUT[@type='text'])[1]",description)){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to verify Asset description", true);
            counter++;
            narrator.failedMessage("Failed to verify asset description- "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to verify asset description",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.verifyData("//INPUT[@ui-if='!duplicate']","TRAIN20180314")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to verify Registration number", true);
            counter++;
            narrator.failedMessage("Failed to verify Registration number - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to verify Registration number",this.getTotalExecutionTime());
        }
        if(!methods.verifyData("//INPUT[@ng-switch-when='true']","TRAINING-FLEET 2018")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to verify fleet number", true);
            counter++;
            narrator.failedMessage("Failed to verify fleet number - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to verify fleet number",this.getTotalExecutionTime());
        }
        if(!methods.verifyData("//INPUT[@ng-switch-default='']","TRAINING-VIN 2018")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to verify vehicle identification number", true);
            counter++;
            narrator.failedMessage("Failed to vehicle identification number - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to vehicle identification number",this.getTotalExecutionTime());
        }
        if(!methods.verifyData("(//INPUT[@type='text'])[5]","2018_Make")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to verify make", true);
            counter++;
            narrator.failedMessage("Failed to verify make - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to verify make",this.getTotalExecutionTime());
        }
        if(!methods.verifyData("(//INPUT[@type='text'])[7]","2018")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to verify year", true);
            counter++;
            narrator.failedMessage("Failed to verify year - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to verify year",this.getTotalExecutionTime());
        }
        if(!methods.verifyData("(//INPUT[@type='text'])[13]","MIX20180301")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to verify MiX account number", true);
            counter++;
            narrator.failedMessage("Failed to verify MiX account number - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to verify MiX account number",this.getTotalExecutionTime());
        }
        if(!methods.verifyData("//TEXTAREA[@rows='3']","Vehicle frequent route is Old Paarl road")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to verify Notes", true);
            counter++;
            narrator.failedMessage("Failed to verify Notes - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to verify Notes",this.getTotalExecutionTime());
        }
        if(!methods.verifyData("(//INPUT[@type='text'])[6]","GTI 2018")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to verify Model", true);
            counter++;
            narrator.failedMessage("Failed to verify Model - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to verify Model",this.getTotalExecutionTime());
        }
        if(!methods.verifyData("(//INPUT[@type='text'])[8]","11223")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to verify engine number", true);
            counter++;
            narrator.failedMessage("Failed to verify engine number - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to verify engine number",this.getTotalExecutionTime());
        }
        if(!methods.verifyData("(//INPUT[@type='text'])[9]","200")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to verify Target fuel consumption", true);
            counter++;
            narrator.failedMessage("Failed to verify Target fuel consumption - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to verify Target fuel consumption",this.getTotalExecutionTime());
        }
        if(!methods.verifyData("(//INPUT[@type='text'])[12]","Cellphone")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to verify additional device", true);
            counter++;
            narrator.failedMessage("Failed to verify additional device - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to verify additional device",this.getTotalExecutionTime());
        }
        if(!methods.verifyData2("(//SELECT[@class='span12 ng-pristine ng-valid'])[2]","Petrol")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to verify fuel type", true);
            counter++;
            narrator.failedMessage("Failed to verify fuel type - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to verify fuel type",this.getTotalExecutionTime());
        }
        if(!methods.verifyData2("//SELECT[@ng-disabled='(assetId && asset.isConnectedTrailer) || !canEdit']","Passenger Vehicle")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to verify vehicle type", true);
            counter++;
            narrator.failedMessage("Failed to verify vehicle type - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to verify vehicle type",this.getTotalExecutionTime());
        }
        if(!methods.verifyData2("(//SELECT[@class='span12 ng-pristine ng-valid'])[1]","South Africa")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to verify country", true);
            counter++;
            narrator.failedMessage("Failed to verify country - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to verify country",this.getTotalExecutionTime());
        }
        if(!methods.verifyData2("/html/body/div[4]/span[2]/div/div/div/div[1]/div[2]/div/div/div[3]/div[1]/div[1]/div[1]/form/div[2]/div[2]/div/select","Default Site")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to verify Site", true);
            counter++;
            narrator.failedMessage("Failed to verify Site - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to verify Site",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.clickCloseButton()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click close button", true);
            counter++;
            narrator.failedMessage("Failed to click close button - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click close button",this.getTotalExecutionTime());
        }
         pause(1000);
        if(!run.clickFilter()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click on Filter", true);
            counter++;
            narrator.failedMessage("Failed to click on Filter - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click on Filter",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!run.enterTextToFilter(description)){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to enter text into filter", true);
            counter++;
            narrator.failedMessage("Failed to enter text into filter - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to enter text into filter",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!run.clickSearchButton()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click search button", true);
            counter++;
            narrator.failedMessage("Failed to click search button - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click search button",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!run.clickDropDownActionMenu()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click drop down action menu ", true);
            counter++;
            narrator.failedMessage("Failed to click drop down action menu  - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click drop down action menu ",this.getTotalExecutionTime());
        }
         pause(1000);
        if(!methods.clickActionFromMenu("(//span[text()='Remove'])[2]")){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to click remove from drop down action menu", true);
            counter++;
            narrator.failedMessage("Failed to click remove from drop down action menu - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to click remove from drop down action menu",this.getTotalExecutionTime());
        }
        pause(1000);
        if(!methods.confirmDelete()){
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to confirm delete action", true);
            counter++;
            narrator.failedMessage("Failed to confirm delete action - "+errorMessage);
            return new TestResult(testData,Enums.ResultStatus.FAIL,"Failed to confirm delete action",this.getTotalExecutionTime());
        }
        pause(1000);
        
        
        return new TestResult(testData,Enums.ResultStatus.PASS,"Created a new asset succesfully",this.getTotalExecutionTime());
    } 
}
