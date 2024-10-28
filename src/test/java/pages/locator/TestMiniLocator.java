package pages.locator;

import testcore.model.Locator;
import testcore.model.LocatorType;

public class TestMiniLocator {
    // It is a test, I'll leave the locators together
    public static final Locator btnAboutUs =
            new Locator("//div[@id='ftco-nav']//a[@href='about-us.html']", LocatorType.XPATH);
    public static final Locator btnCareer =
            new Locator("//div[@id='ftco-nav']//a[@href='https://vtit.jobday.vn/']", LocatorType.XPATH);
    public static final Locator buttonContactNow =
            new Locator("//button[@id='popup-btn']", LocatorType.XPATH);
    public static final Locator txtFullName =
            new Locator("//input[@id='username']", LocatorType.XPATH);
    public static final Locator txtEmail =
            new Locator("//input[@id='email']", LocatorType.XPATH);
    public static final Locator txtReflectionContent =
            new Locator("//textarea[@id='phone']", LocatorType.XPATH);
    public static final Locator txtMessage =
            new Locator("//h2[@class='main-title']", LocatorType.XPATH);
    public static final Locator txtMessageButton =
            new Locator("//button[@class='button-header']", LocatorType.XPATH);
}
