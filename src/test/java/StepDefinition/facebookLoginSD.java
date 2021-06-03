package StepDefinition;

import DriverWrapper.Web;
import Pages.Homepage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

public class facebookLoginSD {
    Web web = new Web();
    Homepage hp = new Homepage();

    @Given("I am on facebook homepage")
    public void openFacebook() {
        web.openUrl();
    }

    @When("I click on messenger link")
    public void clickFbMessenger()  {
        By messengerLink= By.linkText("Messenger");
        hp.clickThis(messengerLink);

    }

    @And("I click on log in")
    public void clickMessengerLogIn() {
        hp.scrollToBottom();
        By messengerLogIn= By.xpath("//button[@id='loginbutton']");
            hp.clickThis(messengerLogIn);
        }


    }


