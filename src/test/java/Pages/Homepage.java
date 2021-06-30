package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Homepage extends WebCommands {

    // WebCommands webCommands = new WebCommands();

    // Locators of Home page webElements
    By loginEmailLocator = By.id("email");
    By loginPassLocator = By.id("pass");
    By loginButtonLocator = By.tagName("button");




    // Method which user will use in testcase to interact with Homepage webElements
    public void typeLoginEmail(String loginEmail) {
        type(loginEmailLocator, loginEmail);
    }

    public void typeLoginPassword(String loginPwd) {
        type(loginPassLocator, loginPwd);
    }

    public void typeInField(String fieldName, String data) {
        switch (fieldName.toLowerCase()) {
            case "login":
                type(loginEmailLocator, data);
                break;
            case "password":
                type(loginPassLocator, data);
                break;
            default:
                new Exception("Not implemented for " + fieldName);
        }
    }

    public void clickLoginButton() {
        clickThis(loginButtonLocator);
    }

    public WebElement getLoginButton() {
        return getElement(loginButtonLocator);
    }

}
