package pages.actions;

import org.openqa.selenium.WebDriver;
import pages.locator.TestMiniLocator;
import pages.pageobjectbase.PageObjectBase;
import testcore.common.Actions;
import testcore.common.Const;
import testcore.common.Utils;

public class TestMiniActions extends PageObjectBase {
    public TestMiniActions(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickButtonAboutUs(){
        clickElementJs(TestMiniLocator.btnAboutUs);
    }

    public void gotoScreenCareers(){
        clickElementJs(TestMiniLocator.btnCareer);
        switchToScreen();
    }

    public void clickButtonContactNow(){
        clickElement(TestMiniLocator.buttonContactNow);
    }

    public void sendKeysFullName(){
        enterText(TestMiniLocator.txtFullName, Utils.generateRandomUpperString(1) + Utils.generateRandomLowercaseString(5));
    }

    public void sendKeysEmail(){
        enterText(TestMiniLocator.txtEmail, Utils.generateRandomUpperString(1) + Utils.generateRandomLowercaseString(3) + "@gmail.com");
    }

    public void sendKeysReflectionContent(){
        enterText(TestMiniLocator.txtReflectionContent, Utils.generateRandomNumber(10));
    }

    public void verifyDisplayedMessageHeader(){
        Actions.assertEquals(getTextValueOfElement(TestMiniLocator.txtMessage), Const.MESSAGE_HEADER , "Error Message display not match");
    }

    public void verifyDisplayedMessageButton(){
        Actions.assertEquals(getTextValueOfElement(TestMiniLocator.txtMessageButton), Const.MESSAGE_BUTTON , "Error Message display not match");
    }
}
