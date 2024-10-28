package testcore.model;

import org.openqa.selenium.By;

public class Locator {
    private LocatorType type;
    private String value;

    public Locator(String locator, LocatorType type) {
        this.value = locator;
        this.type = type;
    }

    public LocatorType getType() {
        return type;
    }

    public String getLocator() {
        return value;
    }

    public By getBy() {

        switch (type) {

            case XPATH:
                return By.xpath(value);
            case ID:
                return By.id(value);
            case NAME:
                return By.name(value);
            case CLASS:
                return By.className(value);
            case TAG_NAME:
                return By.tagName(value);
            case LINK_TEXT:
                return By.linkText(value);
            case CSS:
                return By.cssSelector(value);
            default:
                return null;
        }
    }
}
