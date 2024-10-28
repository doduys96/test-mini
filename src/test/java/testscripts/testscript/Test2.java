package testscripts.testscript;

import org.testng.annotations.Test;
import pages.actions.TestMiniActions;
import pages.driver.DriverManager;
import testscripts.testscriptbase.TestScriptBase;

public class Test2 extends TestScriptBase {
    @Override
    protected void setUp() {
        testMiniActions = new TestMiniActions(DriverManager.getDriver());
    }
    @Test
    public void testRunner(){
        testMiniActions.gotoScreenCareers();
        testMiniActions.verifyDisplayedMessageHeader();
        testMiniActions.verifyDisplayedMessageButton();
    }
}
