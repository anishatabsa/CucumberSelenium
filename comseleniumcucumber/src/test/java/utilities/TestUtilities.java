package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class TestUtilities {

    private WebDriver driver;

    public TestUtilities(WebDriver driver) {
        this.driver = driver;
    }

    public ExpectedCondition<WebElement> waitForElementToBeDisplayed(final By selector) {
        return new ExpectedCondition<WebElement>() {
            @Override
            public String toString() {
                return "first occurance of element " + selector;
            }

            @Override
            public WebElement apply(WebDriver webDriver) {
                WebElement element = webDriver.findElement(selector);
                if(element.isDisplayed()) {
                    return element;
                }
                return null;
            }
        };
    }
}
