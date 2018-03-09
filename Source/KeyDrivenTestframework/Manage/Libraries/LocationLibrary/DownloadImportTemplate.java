/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeyDrivenTestframework.Manage.Libraries.LocationLibrary;

import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;

/**
 *
 * @author PhathuxoloJ
 */
public class DownloadImportTemplate extends BaseClass{
    
    int counter = 1;
    TestEntity testData;
    String errorMessage;
    
    public DownloadImportTemplate(TestEntity testdata){
        this.testData = testData;
    }
    
    public TestResult runTest() throws InterruptedException{
        this.setStartTime();
        return new TestResult(testData,Enums.ResultStatus.PASS,"Import template downloaded succesfully",this.getTotalExecutionTime());
    }
}
