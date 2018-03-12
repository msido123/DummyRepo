/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestSuites;

import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Testing.TestMarshall;
import KeywordDrivenTestFramework.Utilities.ApplicationConfig;
import static TestSuites.AddNewTemplateTestPack.instance;
import java.io.FileNotFoundException;
import org.junit.Test;

/**
 *
 * @author MsimeleloG
 */
public class AddNewTemplateTestPack {
    
    static TestMarshall instance;
    
    public AddNewTemplateTestPack()
    {
        ApplicationConfig appConfig = new ApplicationConfig();
        
        instance.currentEnvironment = Enums.Environment.INT;  
    }
     
    @Test
    public void RunMixTelematicsAddNewTemplateTestPackIE() throws FileNotFoundException
    {
        System.out.println("Mix Telematics Test Pack");   
        instance = new TestMarshall("TestPacks\\AddNewTemplateTestPack.xls", Enums.BrowserType.IE);
        instance.runKeywordDrivenTests();
    }
 
    @Test
    public void RunMixTelematicsAddNewTemplateTestPackChrome() throws FileNotFoundException
    {
        System.out.println("Mix Telematics Test Pack");   
<<<<<<< HEAD
        instance = new TestMarshall("TestPacks\\CheckingEventTemplateFilterTestPack.xlsx", Enums.BrowserType.Chrome);
=======
        instance = new TestMarshall("TestPacks\\CheckEventTemplatesFilterTestPack.xlsx", Enums.BrowserType.Chrome);
>>>>>>> 7cc5941ed4bca2be830907dc67b4b58ac6d8b878
        instance.runKeywordDrivenTests();
    }
    
    @Test
    public void RunMixTelematicsAddNewTemplateTestPackFireFox() throws FileNotFoundException
    {
        System.out.println("Mix Telematics Test Pack");   
        instance = new TestMarshall("TestPacks\\AddNewTemplateTestPack.xls", Enums.BrowserType.FireFox);
        instance.runKeywordDrivenTests();
    }
    
}
