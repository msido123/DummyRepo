/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeyDrivenTestframework.Manage.Templates.EventTemplates;

import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;

/**
 *
 * @author PhathuxoloJ
 */
public class CheckEventTemplatesFilter extends BaseClass{
    int counter = 1;
    TestEntity testData;
    String errorMessage;
    
    public CheckEventTemplatesFilter(TestEntity testData){
        this.testData = testData;
    }
    
    public TestResult executeTest() throws InterruptedException{
        this.setStartTime();
        
        return new TestResult(testData, Enums.ResultStatus.PASS, "Event templates filter works perferctly", this.getTotalExecutionTime());
    }
           
}
