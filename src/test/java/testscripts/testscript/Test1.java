package testscripts.testscript;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.actions.TestMiniActions;
import pages.driver.DriverManager;
import testscripts.testscriptbase.TestScriptBase;

public class Test1 extends TestScriptBase {

    @Override
    protected void setUp() {
        testMiniActions = new TestMiniActions(DriverManager.getDriver());
    }
    @Test
    public void testRunner(){
        testMiniActions.clickButtonAboutUs();
        testMiniActions.clickButtonContactNow();
        testMiniActions.sendKeysFullName();
        testMiniActions.sendKeysEmail();
        testMiniActions.sendKeysReflectionContent();
    }
}
