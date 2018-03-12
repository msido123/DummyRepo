/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestSuites;

import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Testing.TestMarshall;
import KeywordDrivenTestFramework.Utilities.ApplicationConfig;
import static TestSuites.CheckTemplatesLoadInfoTestPack.instance;
import java.io.FileNotFoundException;
import org.junit.Test;

/**
 *
 * @author PhathuxoloJ
 */
public class CheckTemplatesLoadInfoTestPack {
    static TestMarshall instance;


    public CheckTemplatesLoadInfoTestPack(){
        ApplicationConfig appConfig = new ApplicationConfig();    
        instance.currentEnvironment = Enums.Environment.INT; 
    }
    
     @Test
    public void RunMixTelematicsCheckTemplatesLoadInfoTestPackIE() throws FileNotFoundException
    {
        System.out.println("Mix Telematics Test Pack");   
        instance = new TestMarshall("TestPacks\\CheckTemplatesLoadInfoTestPack.xls", Enums.BrowserType.IE);
        instance.runKeywordDrivenTests();
    }
 
    @Test
    public void RunMixTelematicsCheckTemplatesLoadInfoTestPackChrome() throws FileNotFoundException
    {
        System.out.println("Mix Telematics Test Pack");   
        instance = new TestMarshall("TestPacks\\CheckTemplatesLoadInfoTestPack.xlsx", Enums.BrowserType.Chrome);
        instance.runKeywordDrivenTests();
    }
    
    @Test
    public void RunMixTelematicsCheckTemplatesLoadInfoTestPackFireFox() throws FileNotFoundException
    {
        System.out.println("Mix Telematics Test Pack");   
        instance = new TestMarshall("TestPacks\\CheckTemplatesLoadInfoTestPack.xls", Enums.BrowserType.FireFox);
        instance.runKeywordDrivenTests();
    }
}


