/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeyDrivenTestframework.Manage.Templates.EventTemplates;

import static KeywordDrivenTestFramework.Core.BaseClass.SeleniumDriverInstance;
import KeywordDrivenTestFramework.Entities.TestEntity;

/**
 *
 * @author PhathuxoloJ
 */
public class CheckEventFilterMethods extends CheckEventTemplatesFilter{

    public CheckEventFilterMethods(TestEntity testData) {
        super(testData);
    }
    
    public boolean clickTextFilter(){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[1]")) {    
            errorMessage = "The Event Template Filter did not load";
            return false;
        } 
        SeleniumDriverInstance.clickElementByXpath("(//INPUT[@type='text'])[1]");
        errorMessage = "Filter clicked successfully";
        SeleniumDriverInstance.takeScreenShot(counter + "- filter clicked succesfully -", false);
        counter++; 
        return true;
    }
     public boolean typeTextInFilter(){
         if(!SeleniumDriverInstance.waitForElementByXpath("(//INPUT[@type='text'])[1]")) {    
            errorMessage = "The Event Template Filter did not load";
            return false;
        } 
        SeleniumDriverInstance.EnterTextByXpath("(//INPUT[@type='text'])[1]", "Default event template for MiX2310i");
        errorMessage = "text added successfully";
        SeleniumDriverInstance.takeScreenShot(counter + "- text added successfully -", false);
        counter++; 
        return true;
    }
    
    public boolean checkRowOneColumnOne(String textToCompare){
        if(!SeleniumDriverInstance.waitForElementByXpath("//SPAN[text()='Default event template for MiX2310i']")){
            errorMessage = "No data is returned by the filter";
            return true;
        }
        String extractedText = SeleniumDriverInstance.retrieveTextByXpath("//SPAN[text()='Default event template for MiX2310i']");
        if(!(extractedText.contains(textToCompare))){
            errorMessage = "There is data returned";
            testData.extractParameter("Event template name", extractedText, "FAIL");
            SeleniumDriverInstance.takeScreenShot("Compared values are not the same", false);
            counter++;
            return false;
        }
        testData.extractParameter("Event template name", extractedText, "PASS");
        SeleniumDriverInstance.takeScreenShot("Compared values for row 1 column 1 are the same", false);
        counter++;
        return true;
    }
    
    public boolean checkRowOneColumnTwo(String textToCompare){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//DIV)[104]")){
            errorMessage = "No data is returned by the filter";
            return true;
        }
        String extractedText = SeleniumDriverInstance.retrieveTextByXpath("(//DIV)[104]");
        if(!(extractedText.contains(textToCompare))){
            errorMessage = "There is data returned by the filter";
            testData.extractParameter("Event template asset count", extractedText, "FAIL");
            SeleniumDriverInstance.takeScreenShot("Compared values are not the same", false);
            counter++;
            return false;
        }
        testData.extractParameter("Event template asset count", extractedText, "PASS");
        SeleniumDriverInstance.takeScreenShot("Compared values for row 1 column 2 are the same", false);
        counter++;
        return true;
    }
    
     public boolean checkRowOneColumnThree(String textToCompare){
        if(!SeleniumDriverInstance.waitForElementByXpath("(//DIV)[105]")){
            errorMessage = "No data is returned by the filter";
            return true;
        }
        String extractedText = SeleniumDriverInstance.retrieveTextByXpath("(//DIV)[105]");
        if(!(extractedText.contains(textToCompare))){
            errorMessage = "There is data returned by the filter";
            testData.extractParameter("Event template config group count", extractedText, "FAIL");
            SeleniumDriverInstance.takeScreenShot("Compared values are not the same", false);
            counter++;
            return false;
        }
        testData.extractParameter("Event template config group count", extractedText, "PASS");
        SeleniumDriverInstance.takeScreenShot("Compared values for row 1 column 3 are the same", false);
        counter++;
        return true;
    }
     
     public boolean checkNumberOfRows(){
         
        if(!SeleniumDriverInstance.waitForElementByXpath("//a[@class='table table-scroll table-condensed table-list no-text-clip']")){
            errorMessage = "No data is returned by the filter";
            return true;
        }
        int numberOfRows = SeleniumDriverInstance.getNumberOfRowsInsideAtable("//a[@class='table table-scroll table-condensed table-list no-text-clip']");
        System.out.println(numberOfRows);
        if((numberOfRows != 1)){
            errorMessage = "There is data returned by the filter";
            testData.extractParameter("number of rows ", numberOfRows +"", "FAIL");
            SeleniumDriverInstance.takeScreenShot("Number of rows are not equal to 1", false);
            counter++;
            return false;
        }
    
        testData.extractParameter("number of rows", numberOfRows+"", "PASS");
        SeleniumDriverInstance.takeScreenShot("The table has 1 Row after filter ran", false);
        counter++;
        return true;
        }
}
