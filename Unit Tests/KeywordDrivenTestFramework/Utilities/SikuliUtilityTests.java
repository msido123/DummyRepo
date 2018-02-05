/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package KeywordDrivenTestFramework.Utilities;

import org.junit.Test;
import org.testng.Assert;

/**
 *
 * @author Ferdinand
 */
public class SikuliUtilityTests
{
    @Test
    public void OpenSeeTestManualAndLaunchDevice() 
    {
        SikuliDriverUtility sikuliDriver = new SikuliDriverUtility("SikuliImages\\SikuliUnitTest\\");
        
        Assert.assertTrue(sikuliDriver.openSeeTest());
        
        Assert.assertTrue(sikuliDriver.openDevice("GT-I9500.PNG", "GT-I9500_WindowTitle.PNG"));
        
        sikuliDriver.MouseClickElement("0.png");
        sikuliDriver.MouseClickElement("8.png");
        sikuliDriver.MouseClickElement("0.png");
        sikuliDriver.MouseClickElement("2.png");
        
        Assert.assertTrue(sikuliDriver.MouseClickElement("OK.png"));
        
        sikuliDriver.pause(5000);
        
        Assert.assertTrue(sikuliDriver.WaitForElementToAppear("S4BottomRibbon.PNG"));
        
        sikuliDriver.setScreenshotDirectory("SikuliImages\\SikuliUnitTest\\WhatsAppMessage\\");
        
        sikuliDriver.MouseClickElement("SocialIcon.PNG");
        
        sikuliDriver.MouseClickElement("WhatsAppIcon.PNG");
        
        sikuliDriver.WaitForElementToAppear("WhatsAppWindowTitle.png");
        
        sikuliDriver.MouseClickElement("MarioConvoIcon.PNG");
        
        sikuliDriver.MouseClickElement("TextField.PNG");
        
        sikuliDriver.pause(2000);
        
        sikuliDriver.TypeTextAtElement("TextFieldSelected.PNG", "This message was generated by the DVT KISSAT Framework using SeeTest and Sikuli");
        
        sikuliDriver.pause(5000);
        
        sikuliDriver.MouseClickElement("SendButton.PNG");
        
        sikuliDriver.pause(5000);
        
        sikuliDriver.exitSeeTest();
        
        
        
    }
}
