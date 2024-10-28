package pages.pageobjectbase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testcore.model.Locator;

import java.time.Duration;
import java.util.List;

public class PageObjectBase {
    private final WebDriver webDriver;

    public PageObjectBase(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    protected WebElement getWebElement(Locator locator) {

        try {
            switch (locator.getType()) {
                case XPATH:
                    return webDriver.findElement(By.xpath(locator.getLocator()));
                case ID:
                    return webDriver.findElement(By.id(locator.getLocator()));
                case NAME:
                    return webDriver.findElement(By.name(locator.getLocator()));
                case CLASS:
                    return webDriver.findElement(By.className(locator.getLocator()));
                case TAG_NAME:
                    return webDriver.findElement(By.tagName(locator.getLocator()));
                case LINK_TEXT:
                    return webDriver.findElement(By.linkText(locator.getLocator()));
                case CSS:
                    return webDriver.findElement(By.cssSelector(locator.getLocator()));
                default:
                    return null;
            }
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.err.println(">>Could not found element: " + locator.toString());
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected List<WebElement> getWebElements(Locator locator) {
        switch (locator.getType()) {
            case XPATH:
                return webDriver.findElements(By.xpath(locator.getLocator()));
            case ID:
                return webDriver.findElements(By.id(locator.getLocator()));
            case NAME:
                return webDriver.findElements(By.name(locator.getLocator()));
            case CLASS:
                return webDriver.findElements(By.className(locator.getLocator()));
            case TAG_NAME:
                return webDriver.findElements(By.tagName(locator.getLocator()));
            case LINK_TEXT:
                return webDriver.findElements(By.linkText(locator.getLocator()));
            default:
                return null;
        }
    }


    protected boolean waitElementClickable(Locator locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(seconds));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator.getBy()));
        return element != null;
    }

    protected boolean waitVisibilityOfElementLocated(Locator locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(seconds));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator.getBy()));
        return element != null;
    }

    protected void clickElement(Locator locator) {
        WebElement element = this.getWebElement(locator);
        waitElementClickable(locator, 10);
        if (element != null){
            element.click();
        }
    }

    protected void switchToScreen() {
        Object[] windowHandles=webDriver.getWindowHandles().toArray();
        webDriver.switchTo().window((String) windowHandles[1]);
    }

    protected void clickElementJs(Locator locator) {
        WebElement element = this.getWebElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click();", element);
    }

    protected String getTextValueOfElement(Locator locator) {
        waitVisibilityOfElementLocated(locator, 10);
        WebElement element = getWebElement(locator);
        String value = element.getText();
        return value.trim();
    }

    protected void clearText(Locator locator) {
        WebElement element = getWebElement(locator);
        element.clear();
    }

    protected void enterText(Locator locator, String inputValue) {
        waitVisibilityOfElementLocated(locator, 10);
        // Clear text before send key
        clearText(locator);
        // Send key
        WebElement element = getWebElement(locator);
        element.sendKeys(inputValue);
    }
}
