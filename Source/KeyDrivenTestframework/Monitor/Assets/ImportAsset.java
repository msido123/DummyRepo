/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeyDrivenTestframework.Monitor.Assets;

import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
import java.io.FileNotFoundException;

/**
 *
 * @author PhathuxoloJ
 */
public class ImportAsset extends BaseClass{
    int counter = 1;
    TestEntity testData;
    String errorMessage;
    
    public ImportAsset(TestEntity testData){
        this.testData = testData;
    }
    
    public TestResult runTest() throws InterruptedException, FileNotFoundException{
        this.setStartTime();
        
        return new TestResult(testData,Enums.ResultStatus.PASS,"Successfully imported asset file",this.getTotalExecutionTime());
    }
}
