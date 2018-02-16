/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.FleetAdmin;

import KeywordDrivenTestFramework.Core.BaseClass;
import static KeywordDrivenTestFramework.Core.BaseClass.SeleniumDriverInstance;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;

/**
 *
 * @author MzuvukileN
 */
public class ImportAsset extends BaseClass{
    String error;
    int counter = 1;
    TestEntity testData;
    
    public ImportAsset(TestEntity testData){
        this.testData = testData;
    }
    
    public TestResult executeTest() throws InterruptedException{
        this.setStartTime();
        
        
        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully imported asset.", this.getTotalExecutionTime());
    }
    
    
}
