package testscripts.testscriptbase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.actions.TestMiniActions;
import pages.driver.DriverManager;
import testcore.helper.ConfigFile;

public abstract class TestScriptBase extends DriverManager {
    protected TestMiniActions testMiniActions;
    protected ConfigFile configFile;

    @BeforeMethod
    protected void initialize() {
        configFile = new ConfigFile();
        DriverManager.setDriver(configFile.getURL());
        setUp();
    }
    @AfterMethod
    public void teardown(){
        DriverManager.teardownTest();
    }

    protected abstract void setUp();
}
