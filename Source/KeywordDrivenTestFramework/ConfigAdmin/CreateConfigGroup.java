/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.ConfigAdmin;

import static KeywordDrivenTestFramework.Core.BaseClass.SeleniumDriverInstance;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
import KeywordDrivenTestFramework.Core.BaseClass;
/**
 *
 * @author MzuvukileN
 */
public class CreateConfigGroup extends BaseClass{
    String error;
    int counter = 1;
    TestEntity testData;
    String configGroupName;
    NavigateToLibraries nav;
    NavigateAndAddEvent navAdd;
    
    public CreateConfigGroup(TestEntity testData){
        this.testData = testData;
        nav = new NavigateToLibraries(testData);
        navAdd = new NavigateAndAddEvent(testData);
        configGroupName = navAdd.myDateStamp() + " ConfigGroup";
    }
    
    public TestResult executeTest() throws InterruptedException{
        this.setStartTime();
        
        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully added and removed a configuration group.", this.getTotalExecutionTime());
    }
    
}
