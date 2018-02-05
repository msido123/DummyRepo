/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.Testing.TestClasses.Assets;

import KeywordDrivenTestFramework.Core.BaseClass;
import static KeywordDrivenTestFramework.Core.BaseClass.SeleniumDriverInstance;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
import KeywordDrivenTestFramework.Testing.PageObjects.AssetsPageObjects;
import KeywordDrivenTestFramework.Testing.PageObjects.RemindOnDurationPageObjects;
import static java.lang.System.err;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author nmayekiso
 */
public class RemindOnDurationOverdue extends BaseClass{
    
    int counter = 1;
    TestEntity testData;
    String selectedLanguage;
    String measurementUnits;
    String odometer;
    String lastService;
    int randNum;
    String StrRandNum;
    
    public RemindOnDurationOverdue(TestEntity testData) {
        this.testData = testData;
    }
    
    public TestResult executeTest() {

        this.setStartTime();
        
        if (!navigateToDatabaseAdministration()) 
        {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed To Navigate To Database Administration Page", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed To Navigate To Database Administration Page", this.getTotalExecutionTime());
        }
        
        if (!expandOrganisationTree()) 
        {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed To expand Test RSO tree", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed To expand Test RSO tree", this.getTotalExecutionTime());
        }
        
        if (!selectOrganisation()) 
        {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed To select Organisation", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed To select Organisation", this.getTotalExecutionTime());
        }
        
        if (!selectMeasurementSettings()) 
        {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed To select Measurement Settings", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed To select Measurement Settings", this.getTotalExecutionTime());
        }
        
        if (!inspectLanguageSelected()) 
        {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed To inspect Language Selected", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed To inspect Language Selected", this.getTotalExecutionTime());
        }
        
        if (!inspectMeasurementUnits()) 
        {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed To inspect Measurement Units", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed To inspect Measurement Units", this.getTotalExecutionTime());
        }
        
        if (!navigateToAssetManagementPage()) 
        {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed To Navigate To Asset Management Page", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed To Navigate To Asset Management Page", this.getTotalExecutionTime());
        }
        
        if (!selectAssetToEdit()) 
        {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to select asset", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, " Failed to select asset", this.getTotalExecutionTime());
        }
        
        if (!selectReminders()) 
        {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to select Reminders", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, " Failed to select Reminders", this.getTotalExecutionTime());
        }
        
        if (!inspectOdometer()) 
        {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed To inspect Last Service", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed To inspect Last Service", this.getTotalExecutionTime());
        }
        
        if (!inspectLastService()) 
        {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed To inspect Last Service", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed To inspect Last Service", this.getTotalExecutionTime());
        }
        
        if (!clickRemindOnDurationCheckbox()) 
        {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed To click Remind On Duration Checkbox", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed To click Remind On Duration Checkbox", this.getTotalExecutionTime());
        }
        
        if (!enterNextServiceDate()) 
        {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed To enter Next Service Date", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed To enter Next Service Date", this.getTotalExecutionTime());
        }
        
        if (!enterServiceInterval()) 
        {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed To enter Service Interval", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed To enter Service Interval", this.getTotalExecutionTime());
        }
        
        if (!enterReminderPeriod()) 
        {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed To enter Reminder Period", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed To enter Reminder Period", this.getTotalExecutionTime());
        }
                
        if (!clickSelectRecipientButton()) 
        {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed To click Select Recipient Button", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed To click Select Recipient Button", this.getTotalExecutionTime());
        }
        
        if (!clickRecipientCheckbox()) 
        {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed To click Recipient Checkbox", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed To click Recipient Checkbox", this.getTotalExecutionTime());
        }
        
        if (!clickSelectButton()) 
        {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed To click Select Button", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed To click Select Button", this.getTotalExecutionTime());
        }
                
        if (!clickOnClickHere()) 
        {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed To click On Click Here to add", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed To click On Click Here to add", this.getTotalExecutionTime());
        }
                
        if (!AddNewContact()) 
        {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed To Add New Contact", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed To Add New Contact", this.getTotalExecutionTime());
        }
        
        if (!clickSelectRecipientButton()) 
        {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed To click Select Recipient Button", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed To click Select Recipient Button", this.getTotalExecutionTime());
        }
        
        if (!searchForRecipient()) 
        {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed To search For Recipient", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed To search For Recipient", this.getTotalExecutionTime());
        }
        
        if (!clickNewRecipientCheckbox()) 
        {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed To click New Recipient Checkbox", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed To click New Recipient Checkbox", this.getTotalExecutionTime());
        }
        
        if (!clickSelectButton()) 
        {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed To click Select Button", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed To click Select Button", this.getTotalExecutionTime());
        }
        
        if (!clickSaveButton()) 
        {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed To click Save Button", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed To click Save Button", this.getTotalExecutionTime());
        }   
                
        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully selected recipients for reminder on duration", this.getTotalExecutionTime());
    }
    
    private boolean navigateToDatabaseAdministration()
    {
        SeleniumDriverInstance.waitForElementByXpath(RemindOnDurationPageObjects.ManageMenuRelativeXpath(),30);
        //Click Manage Menu
        if (!SeleniumDriverInstance.clickElementbyXpath(RemindOnDurationPageObjects.ManageMenuRelativeXpath()))
            return false;
        //Take Screenshot
        SeleniumDriverInstance.takeScreenShot("Manage Menu Clicked", false);
        
         //Click Database Administration Sub Menu
        if (!SeleniumDriverInstance.clickElementbyXpath(RemindOnDurationPageObjects.DatabaseAdministrationRelativeXpath()))
            return false;
        //Take Screenshot
        SeleniumDriverInstance.takeScreenShot("Database Administration Menu Clicked", false);
        
        return true;
    }
    
    private boolean expandOrganisationTree()
    {
        SeleniumDriverInstance.waitForElementByXpath(RemindOnDurationPageObjects.TestRSOTreeRelativeXpath(),30);
        //Click Organisation
        if (!SeleniumDriverInstance.clickElementbyXpath(RemindOnDurationPageObjects.TestRSOTreeRelativeXpath()))
            return false;
        //Take Screenshot
        SeleniumDriverInstance.takeScreenShot("Test RSO tree expanded", false);
        
        return true;
    }
    
    private boolean selectOrganisation()
    {
        SeleniumDriverInstance.waitForElementByXpath(RemindOnDurationPageObjects.DVTAutomationOrgRelativeXpath(),30);
        //Click Organisation
        if (!SeleniumDriverInstance.clickElementbyXpath(RemindOnDurationPageObjects.DVTAutomationOrgRelativeXpath()))
            return false;
        //Take Screenshot
        SeleniumDriverInstance.takeScreenShot("DVT Automation Organisation selected", false);
        
        return true;
    }
    
    private boolean selectMeasurementSettings()
    {
        SeleniumDriverInstance.waitForElementByXpath(RemindOnDurationPageObjects.MeasurementSettingsRelativeXpath(),30);
        //Click Measurement Settings
        if (!SeleniumDriverInstance.clickElementbyXpath(RemindOnDurationPageObjects.MeasurementSettingsRelativeXpath()))
            return false;
        //Take Screenshot
        SeleniumDriverInstance.takeScreenShot("Measurement Settings selected", false);
        
        return true;
    }
    
    private boolean inspectLanguageSelected()
    {
        SeleniumDriverInstance.waitForElementByXpath(RemindOnDurationPageObjects.LanguageRelativeXpath(),30);
        //Retrieve Language Selected
        selectedLanguage = SeleniumDriverInstance.retrieveTextByXpath(RemindOnDurationPageObjects.LanguageRelativeXpath());
        if (selectedLanguage.equals(""))
        {
            testData.extractParameter("Language Selected: "+ selectedLanguage , "Measurement uniits: "+ measurementUnits, "FAIL");
            return false;
        }
        //Take Screenshot
        SeleniumDriverInstance.takeScreenShot("Language text inspected", false);
        
        return true;
    }
    
    private boolean inspectMeasurementUnits()
    {
        SeleniumDriverInstance.waitForElementByXpath(RemindOnDurationPageObjects.MeasurementUnitsRelativeXpath(),30);
        //Retrieve Measurement Units
        measurementUnits = SeleniumDriverInstance.retrieveTextByXpath(RemindOnDurationPageObjects.MeasurementUnitsRelativeXpath());
        if (measurementUnits.equals(""))
        {
            testData.extractParameter("Language Selected: "+ selectedLanguage , "Measurement uniits: "+ measurementUnits, "FAIL");
            return false;
        }
        //Take Screenshot
        SeleniumDriverInstance.takeScreenShot("Measurement units inspected", false);
        
        return true;
    }
    
    private boolean navigateToAssetManagementPage()
    {
        //Click Monitor Menu
        if (!SeleniumDriverInstance.clickElementbyXpath(RemindOnDurationPageObjects.MonitorMenuRelativeXpath()))
            return false;
        
        //Take Screenshot
        SeleniumDriverInstance.takeScreenShot("ManageMenuClicked", false);
        
         //Click TripTimeline Menu
        if (!SeleniumDriverInstance.clickElementbyXpath(RemindOnDurationPageObjects.AssetSubMenuRelativeXpath()))
            return false;
        //Take Screenshot
        SeleniumDriverInstance.takeScreenShot("AssetSubMenuClicked", false);
        
         //Click TripTimeline Menu
        if (!SeleniumDriverInstance.waitForElementByXpath(AssetsPageObjects.AddAssetButtonRelativeXpath()))
            return false;
        
        //Take Screenshot
        SeleniumDriverInstance.takeScreenShot("LandedOnAssetManagementPage", false);
        
        return true;
    }
    
    private boolean selectAssetToEdit()
    {
        SeleniumDriverInstance.waitForElementByXpath(RemindOnDurationPageObjects.AssetRelativeXpath(),30);
        //Click Asset Menu
        if (!SeleniumDriverInstance.clickElementbyXpath(RemindOnDurationPageObjects.AssetRelativeXpath()))
            return false;
        //Take Screenshot
        SeleniumDriverInstance.takeScreenShot("Asset selected", false);
        
        return true;
    }
    
    private boolean selectReminders()
    {
        SeleniumDriverInstance.waitForElementByXpath(RemindOnDurationPageObjects.RemindersRelativeXpath(),30);
        //Click Reminders Menu
        if (!SeleniumDriverInstance.clickElementbyXpath(RemindOnDurationPageObjects.RemindersRelativeXpath()))
            return false;
        //Take Screenshot
        SeleniumDriverInstance.takeScreenShot("Reminders selected", false);
        
        return true;
    }
    
    private boolean inspectOdometer()
    {
        SeleniumDriverInstance.waitForElementByXpath(RemindOnDurationPageObjects.OdometerRelativeXpath(),30);
        //Retrieve Current Odometer
        odometer = SeleniumDriverInstance.retrieveTextByXpath(RemindOnDurationPageObjects.OdometerRelativeXpath());
        if (selectedLanguage.equals(""))
        {
            testData.extractParameter("Language Selected: "+ selectedLanguage + "<br>Measurement units: "+ measurementUnits, "Odometer: "+ odometer + "<br>Last service: "+ lastService, "FAIL");
            return false;
        }
        //Take Screenshot
        SeleniumDriverInstance.takeScreenShot("Current odometer inspected", false);
        
        return true;
    }
    
    private boolean inspectLastService()
    {
        SeleniumDriverInstance.waitForElementByXpath(RemindOnDurationPageObjects.LastServiceRelativeXpath(),30);
        //Retrieve Last Service
        lastService = SeleniumDriverInstance.retrieveTextByXpath(RemindOnDurationPageObjects.LastServiceRelativeXpath());
        if (measurementUnits.equals(""))
        {
            testData.extractParameter("Language Selected: "+ selectedLanguage + "<br>Measurement units: "+ measurementUnits, "Odometer: "+ odometer + "<br>Last service: "+ lastService, "FAIL");
            return false;
        }
        
        testData.extractParameter("Language Selected: "+ selectedLanguage + "<br>Measurement units: "+ measurementUnits, "Odometer: "+ odometer + "<br>Last service: "+ lastService, "PASS");
        //Take Screenshot
        SeleniumDriverInstance.takeScreenShot("Last service inspected", false);
        
        return true;
    }
    
    private boolean clickRemindOnDurationCheckbox()
    {
        SeleniumDriverInstance.waitForElementByXpath(RemindOnDurationPageObjects.RemindOnDurationRelativeXpath(),30);
        if(SeleniumDriverInstance.getCheckboxState(RemindOnDurationPageObjects.RemindOnDurationName()))
            return true;
        //Click Remind On Duration Checkbox
        if (!SeleniumDriverInstance.clickElementbyXpath(RemindOnDurationPageObjects.RemindOnDurationRelativeXpath()))
            return false;
        //Take Screenshot
        SeleniumDriverInstance.takeScreenShot("Remind On Duration checked", false);
        
        return true;
    }
    
    private boolean enterNextServiceDate()
    {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 28);
        Date result = cal.getTime();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String effectiveDate = dateFormat.format(result);

        if (!SeleniumDriverInstance.enterTextByXpath(RemindOnDurationPageObjects.NextServiceRelativeXpath(), effectiveDate))
            return false;
        //Take Screenshot
        SeleniumDriverInstance.takeScreenShot("Next Service date entered", false);
        
        return true;
    }
    
    private boolean enterServiceInterval()
    {
        SeleniumDriverInstance.waitForElementByXpath(RemindOnDurationPageObjects.ServiceIntervalRelativeXpath(),30);
        //Enter service interval
        if (!SeleniumDriverInstance.enterTextByXpath(RemindOnDurationPageObjects.ServiceIntervalRelativeXpath(), testData.getData("ServiceInterval")))
            return false;
        //Take Screenshot
        SeleniumDriverInstance.takeScreenShot("Service interval entered", false);
        
        return true;
    }
    
    private boolean enterReminderPeriod()
    {
        SeleniumDriverInstance.waitForElementByXpath(RemindOnDurationPageObjects.ReminderPeriodRelativeXpath(),30);
        //Enter reminder period
        if (!SeleniumDriverInstance.enterTextByXpath(RemindOnDurationPageObjects.ReminderPeriodRelativeXpath(), testData.getData("ReminderPeriod")))
            return false;
        //Take Screenshot
        SeleniumDriverInstance.takeScreenShot("Reminder period entered", false);
        
        return true;
    }
    
    private boolean clickSelectRecipientButton()
    {
        SeleniumDriverInstance.waitForElementByXpath(RemindOnDurationPageObjects.SelectRecipientsRelativeXpath(),45);
        SeleniumDriverInstance.pause(2000);
        //Click Select Recipient Button
        if (!SeleniumDriverInstance.clickElementbyXpath(RemindOnDurationPageObjects.SelectRecipientsRelativeXpath()))
            return false;
        //Take Screenshot
        SeleniumDriverInstance.takeScreenShot("Select recipient successfully clicked", false);
        
        return true;
    }
    
    private boolean clickRecipientCheckbox()
    {
        SeleniumDriverInstance.waitForElementByXpath(RemindOnDurationPageObjects.RecipientsCheckboxRelativeXpath(),45);
        if(SeleniumDriverInstance.getCheckboxState(RemindOnDurationPageObjects.RecipientsCheckboxRelativeXpath()))
            return true;
        //Click Recipient Checkbox
        if (!SeleniumDriverInstance.clickElementbyXpath(RemindOnDurationPageObjects.RecipientsCheckboxRelativeXpath()))
            return false;
        //Take Screenshot
        SeleniumDriverInstance.takeScreenShot("Recipient Checkbox checked", false);
        
        return true;
    }
    
    private boolean clickSelectButton()
    {
        SeleniumDriverInstance.waitForElementByXpath(RemindOnDurationPageObjects.SelectButtonRelativeXpath(),30);
        //Click Select Button
        if (!SeleniumDriverInstance.clickElementbyXpath(RemindOnDurationPageObjects.SelectButtonRelativeXpath()))
            return false;
        //Take Screenshot
        SeleniumDriverInstance.takeScreenShot("SelectButton clicked", false);
        
        return true;
    }
    
    private boolean clickOnClickHere()
    {
        SeleniumDriverInstance.pause(1000);
        //Click on Click here
        if (!SeleniumDriverInstance.clickElementbyXpath(RemindOnDurationPageObjects.ClickHereRelativeXpath()))
            return false;
        //Take Screenshot
        SeleniumDriverInstance.takeScreenShot("Click here to add clicked", false);
        
        return true;
    }
    
    public boolean AddNewContact() 
       {
//        Random rand = new Random();
//        randNum = rand.nextInt(900) + 100;
        StrRandNum = generateDateTimeStampValue();
        
         //Enter First Name from spreadsheet
         if (!SeleniumDriverInstance.enterTextByXpath(RemindOnDurationPageObjects.FirstNameTextboxRelativeXpath(), this.testData.getData("FirstName")+StrRandNum))
           {
              testData.extractParameter("Test result: ", "Failed to Enter First Name", "FAIL");
              err.println("[ERROR] Failed to Enter First Name");
              return false;
           }
         
         //Enter Last Name from spreadsheet
         if (!SeleniumDriverInstance.enterTextByXpath(RemindOnDurationPageObjects.LastNameTextboxRelativeXpath(),this.testData.getData("LastName")+StrRandNum))
            {
                testData.extractParameter("Test result: ", "Failed to Enter Last Name", "FAIL");
                err.println("[ERROR] Failed to Enter Last Name");
                return false;
            }
            
         //Enter Employer from spreadsheet
         if (!SeleniumDriverInstance.enterTextByXpath(RemindOnDurationPageObjects.EmployerTextboxRelativeXpath(), this.testData.getData("Employer")))
            {
                testData.extractParameter("Test result: ", "Failed to Enter Employer", "FAIL");
                err.println("[ERROR] Failed to Enter Employer");
                return false;
            }
         
         //Enter Position from spreadsheet  
         if (!SeleniumDriverInstance.enterTextByXpath(RemindOnDurationPageObjects.PositionTextboxRelativeXpath(),this.testData.getData("Position")))
            {
                testData.extractParameter("Test result: ", "Failed to Enter Position", "FAIL");
                err.println("[ERROR] Failed to Enter Position");
                return false;
            }
         
         //Enter Home Number from spreadsheet
        if (!SeleniumDriverInstance.enterTextByXpath(RemindOnDurationPageObjects.HomeNumberTextboxRelativeXpath(),this.testData.getData("HomeNumber")))
          {
               testData.extractParameter("Test result: ", "Failed to enter Enter Home Number", "FAIL");
               err.println("[ERROR] Failed to enter Enter Home Number");
               return false;
          }
            
         //Enter Work Number from spreadsheet
         if (!SeleniumDriverInstance.enterTextByXpath(RemindOnDurationPageObjects.WorkNumberTextboxRelativeXpath(),this.testData.getData("WorkNumber")))
           {
                testData.extractParameter("Test result: ", "Failed to Enter Work Number", "FAIL");
                err.println("[ERROR] Failed to Enter Work Number");
                return false;
           }
         
         //Enter Mobile Number from spreadsheet
         if (!SeleniumDriverInstance.enterTextByXpath(RemindOnDurationPageObjects.MobileNumberTextboxRelativeXpath(),this.testData.getData("MobileNumber")))
          {
               testData.extractParameter("Test result: ", "Failed to Enter Mobile Number", "FAIL");
               err.println("[ERROR] Failed to Enter Mobile Number");
               return false;
          }
         
         //Enter Email Address from spreadsheet
         if (!SeleniumDriverInstance.enterTextByXpath(RemindOnDurationPageObjects.EmailTextboxRelativeXpath(),this.testData.getData("EmailAddress")))
          {
               testData.extractParameter("Test result: ", "Failed to Enter Email Address", "FAIL");
               err.println("[ERROR] Failed to Enter Email Address");
               return false;
          }
         
         //Take Screenshot
         SeleniumDriverInstance.takeScreenShot("Successfully Completed the fields, and submit button is enabled", false);
         
         SeleniumDriverInstance.pause(3000);
         //Click on the Save button
         if (!SeleniumDriverInstance.clickElementByXpath(RemindOnDurationPageObjects.SubmitButtonRelativeXpath()))
           {
                testData.extractParameter("Test result: ", "Failed to Click Submit Button", "FAIL");
                err.println("[ERROR] Failed to Click Submit Button");
                return false;
           }
            
         return true;
     }
    
    private boolean searchForRecipient()
    {
        SeleniumDriverInstance.waitForElementByXpath(RemindOnDurationPageObjects.FilterTextboxRelativeXpath(),30);
        //Search for recipient
        if (!SeleniumDriverInstance.enterTextByXpath(RemindOnDurationPageObjects.FilterTextboxRelativeXpath(),this.testData.getData("LastName")+StrRandNum))
            return false;
        //Take Screenshot
        SeleniumDriverInstance.takeScreenShot("Searched for recipient successfully", false);
        
        return true;
    }
    
    private boolean clickNewRecipientCheckbox()
    {
        SeleniumDriverInstance.waitForElementByXpath(RemindOnDurationPageObjects.RecipientsCheckboxRelativeXpath(),30);
        //Click Recipient Checkbox
        if (!SeleniumDriverInstance.clickElementbyXpath(RemindOnDurationPageObjects.RecipientsCheckboxRelativeXpath()))
            return false;
        //Take Screenshot
        SeleniumDriverInstance.takeScreenShot("Recipient Checkbox checked", false);
        
        return true;
    }
    
    private boolean clickSaveButton()
    {
        SeleniumDriverInstance.pause(1000);
        SeleniumDriverInstance.waitForElementByXpath(RemindOnDurationPageObjects.SaveButtonRelativeXpath(),30);
        //Click Save Button
        if (!SeleniumDriverInstance.clickElementbyXpath(RemindOnDurationPageObjects.SaveButtonRelativeXpath()))
            return false;
        //Take Screenshot
        SeleniumDriverInstance.pause(2000);
        SeleniumDriverInstance.takeScreenShot("Save Button clicked", false);
        
        return true;
    }
    
    public String generateDateTimeStampValue()
    {
        try{
           String value = "";

           value = SeleniumDriverInstance.generateDateTimeString("yyyy-MM-dd_HH-mm");
           value = value.replace('-', ' ').replace('_', ' ').trim().replaceAll("\\s", "");

           return value;
       } catch (Exception e) {
            System.err.println("[Error] Failed to generate DateTimeStamp Value - " + e.getMessage());
            return null;
        }
    }
}
