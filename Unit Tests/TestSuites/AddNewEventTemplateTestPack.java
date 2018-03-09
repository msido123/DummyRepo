/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestSuites;

import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Testing.TestMarshall;
import KeywordDrivenTestFramework.Utilities.ApplicationConfig;
import java.io.FileNotFoundException;
import org.junit.Test;

/**
 *
 * @author PhathuxoloJ
 */
public class AddNewEventTemplateTestPack {
    static TestMarshall instance;
    
    public AddNewEventTemplateTestPack()
    {
        ApplicationConfig appConfig = new ApplicationConfig();
        instance.currentEnvironment = Enums.Environment.INT;  
    }
     
    @Test
    public void RunMixTelematicsAddNewEventTemplateTestPackIE() throws FileNotFoundException
    {
        System.out.println("Mix Telematics Test Pack");   
        instance = new TestMarshall("TestPacks\\AddNewEventTemplateTestPack.xlsx", Enums.BrowserType.IE);
        instance.runKeywordDrivenTests();
    }
 
    @Test
    public void RunMixTelematicsAddNewEventTemplateTestPackChrome() throws FileNotFoundException
    {
        System.out.println("Mix Telematics Test Pack");   
        instance = new TestMarshall("TestPacks\\AddNewEventTemplateTestPack.xlsx", Enums.BrowserType.Chrome);
        instance.runKeywordDrivenTests();
    }
    
    @Test
    public void RunMixTelematicsAddNewEventTemplateTestPackFireFox() throws FileNotFoundException
    {
        System.out.println("Mix Telematics Test Pack");   
        instance = new TestMarshall("TestPacks\\AddNewEventTemplateTestPack.xlsx", Enums.BrowserType.FireFox);
        instance.runKeywordDrivenTests();
    }
}
