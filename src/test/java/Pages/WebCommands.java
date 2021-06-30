package Pages;

import DriverWrapper.Web;
import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class WebCommands extends Web {

    /**
     * Method to find WebElements
     * Input: By
     * Return type: List<WebElement>
     */
    public List<WebElement> getElements(By locator) {
        // wait for 30sec before declaring element is not found
        Wait fWait = new FluentWait(Web.getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(NoAlertPresentException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Elements are not found within 30 seconds");

        List<WebElement> elements = (List<WebElement>) fWait.until(new Function<WebDriver, List<WebElement>>() {
            public List<WebElement> apply(WebDriver driver) {
                return driver.findElements(locator);
            }
        });
        return elements;
    }

    /**
     * Method to find a WebElement
     * Input: By
     * Return type: WebElement
     */
    public WebElement getElement(By locator) {
        // return Web.getDriver().findElement(locator);

        Wait fWait = new FluentWait(Web.getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(NoAlertPresentException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Element is not found within 30 seconds");

        WebElement element = (WebElement) fWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });

        return element;

    }

    /**
     * Method to click a webElement
     * Input: WebElement
     * Return Type: void
     */
    public void clickThis(WebElement element) {
        element.click();
    }

    /**
     * Method to click a webElement
     * Input: By
     * Return Type: void
     * @param locator
     */
    public void clickThis(By locator) {
        getElement(locator).click();

    }

    /**
     * Method to type in a WebElement
     * Input:
     *      WebElement
     *      String
     * Return Type: void
     */
    public void type(WebElement element, String data) {
        element.sendKeys(data);
    }

    /**
     * Method to type in a WebElement
     * Input:
     *      By
     *      String
     * Return Type: void
     */
    public void type(By locator, String data) {
        getElement(locator).sendKeys(data);
    }

    /**
     * Method to find if WebElement is Enabled
     * Input: By
     * Return Type: boolean
     */
    public boolean isElementEnabled(By locator) {
        return getElement(locator).isEnabled();
    }

    /**
     * Method to find if WebElement is Enabled
     * Input: WebElement
     * Return Type: boolean
     */
    public boolean isElementEnabled(WebElement element) {
        return element.isEnabled();
    }

    /**
     * Method to find if WebElement is Displayed
     * Input: By
     * Return Type: boolean
     */
    public boolean isElementDisplayed(By locator) {
        return getElement(locator).isDisplayed();
    }

    /**
     * Method to find if WebElement is Enabled
     * Input: WebElement
     * Return Type: boolean
     */
    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    /**
     * Method to find if WebElement is Enabled
     * Input: By
     * Return Type: boolean
     */
    public boolean isElementSelected(By locator) {
        return getElement(locator).isSelected();
    }

    /**
     * Method to find if WebElement is Enabled
     * Input: WebElement
     * Return Type: boolean
     */
    public boolean isElementSelected(WebElement element) {
        return element.isSelected();
    }

    /**
     * Method to get text of a WebElement
     * Input: By
     * Return Type: boolean
     */
    public String getElementText(By locator) {
        return getElement(locator).getText();
    }

    /**
     * Method to get text of a WebElement
     * Input: WebElement
     * Return Type: boolean
     */
    public String getElementText(WebElement element) {
        return element.getText();
    }

    /**
     * Method to get an attribute value of a WebElement
     * Input: By
     * Return Type: boolean
     */
    public String getElementAttributeValue(By locator, String attributeName) {
        return getElement(locator).getAttribute(attributeName);
    }

    /**
     * Method to get an attribute value of a WebElement
     * Input: WebElement
     * Return Type: boolean
     */
    public String getElementAttributeValue(WebElement element, String attributeName) {
        return element.getAttribute(attributeName);
    }

    /**
     * Method to move mouse on a WebElement
     * Input: WebElement
     * Return Type: void
     */
    public void moveMouseOverElement(WebElement element) {
        Actions act = new Actions(Web.getDriver());
        act.moveToElement(element).build().perform();
    }

    /**
     * Method to move mouse on a WebElement
     * Input: By
     * Return Type: void
     */
    public void moveMouseOverElement(By locator) {
        Actions act = new Actions(Web.getDriver());
        WebElement element = getElement(locator);
        act.moveToElement(element).build().perform();
    }

    /**
     * Method to scroll to bottom of Webpage
     * Input:
     * Return Type: void
     */
    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor)Web.getDriver();
        js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
    }

    /**
     * Method to scroll down by pixel on Webpage
     * Input: int
     * Return Type: void
     *
     */
    public void scrollDownByPixel(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor)Web.getDriver();
        js.executeScript("scrollBy(0,"+pixels+");");
    }

    /**
     * Method to scroll up by pixel on Webpage
     * Input: int
     * Return Type: void
     */
    public void scrollUpByPixel(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor)Web.getDriver();
        js.executeScript("scrollBy(0,-"+pixels+");");
    }


    /**
     * Method to scroll to a WebElement on Webpage
     * Input: WebElement
     * Return Type: void
     */
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Web.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Method to select any value from dropdown
     * Input: WebElement, data
     * Return type: void
     */
    public void selectFromDropdown(WebElement element, String data) {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(data);
    }

    /**
     * Method to select any value from dropdown
     * Input: By, data
     * Return type: void
     */
    public void selectFromDropdown(By locator, String data) {
        WebElement element = getElement(locator);
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(data);
    }

    /**
     * Method to select value from an auto-suggestion
     * Input: By, String
     * Return type: void
     */
    public void selectFromAutoSuggestion(By locator, String userChoice) {
        List<WebElement> allSuggestions = getElements(locator);
        for (WebElement suggestionElement : allSuggestions) {
            String suggestion = suggestionElement.getText();
            if (suggestion.equalsIgnoreCase(userChoice)) {
                clickThis(suggestionElement);
                break;
            }
        }
    }

    /**
     * Method to get the current window handle
     * Input:
     * Return type: String
     */
    public String getCurrentHandle() {
        return Web.getDriver().getWindowHandle();
    }

    /**
     * Method to get the current window handle
     * Input:
     * Return type: Set<String>
     */
    public Set<String> getAllHandles() {
        return Web.getDriver().getWindowHandles();
    }

    /**
     * Method to switch window handle
     * Input: 1 (String)
     * Return type: void
     */
    public void switchToWindow(String handle) {
        Web.getDriver().switchTo().window(handle);
    }

    /**
     * Method to wait using explicit wait
     */


}