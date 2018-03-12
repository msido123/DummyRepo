/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeyDrivenTestframework.Manage.Libraries.LocationLibrary;

import KeywordDrivenTestFramework.Entities.TestEntity;
import static KeywordDrivenTestFramework.Core.BaseClass.SeleniumDriverInstance;

/**
 *
 * @author PhathuxoloJ
 */
public class DownloadImportTemplateMethods extends DownloadImportTemplate{
    
    public DownloadImportTemplateMethods(TestEntity testData) {
        super(testData);
    }
    
    public boolean navigateToLibraries(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//A[@ng-href='#/config-admin/libraries'][text()='Libraries']")){
            errorMessage = "Failed to click on Libraries tab";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//A[@ng-href='#/config-admin/libraries'][text()='Libraries']");
        SeleniumDriverInstance.takeScreenShot("Libraries is clicked successfully ", false);
        counter++;
        return true;
    }
    
    public boolean navigateToLocationLibrary(){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//a[@class='ng-binding'])[text()='Location library']")){
            errorMessage = "Failed to click on Location Library tab";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("(//a[@class='ng-binding'])[text()='Location library']");
        SeleniumDriverInstance.takeScreenShot("Library tab is clicked successfully ", false);
        counter++;
        return true;
    }
    
    public boolean clickOnDownloadButton(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//I[@class='icon-download-alt']")){
            errorMessage = "Failed to click on Download button";
            return false;
        }
        SeleniumDriverInstance.clickElementByXpath("//I[@class='icon-download-alt']");
        SeleniumDriverInstance.takeScreenShot("Download button is clicked successfully ", false);
        counter++;
        return true;
    }
    public boolean compareHeaders(){
        if(!SeleniumDriverInstance.waitForElementByXpath("//TH[@class='column-heading  first sortable active ui-draggable']")){
            errorMessage = "no xpath for column 1";
            return false;
        }
        String[] columnHeader = {SeleniumDriverInstance.retrieveTextByXpath("//SPAN[@ng-hide='column.headingClass || !column.title'][text()='Availability']")};
        if(!SeleniumDriverInstance.ValidateExcelTableHeaders("LibraryLocations_2018_03_09_13_43_56.xlsx","Data", columnHeader)){
           errorMessage = "Column headers of the downloaded excel file does not match the grid headings";
           testData.extractParameter("column heading", columnHeader[0], "FAIL");
           SeleniumDriverInstance.takeScreenShot("Column headers of the downloaded excel file does not match the grid headings",false);
           counter++;
           return false;
        }
        testData.extractParameter("column heading", columnHeader[0], "PASS");
        SeleniumDriverInstance.takeScreenShot("Column headers of the downloaded excel file matches with the grid headings",false);
        counter++;
        return true;      
    }  
}
