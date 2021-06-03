package StepDefinition;

import DriverWrapper.Web;
import Pages.Homepage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

public class facebookRadioButtonSD {
    Web web= new Web();
    Homepage hp= new Homepage();

    @When("I click on sign up more")
    public void fbSignupMore(){
        web.openUrl();
        By signUpButton= By.linkText("Create New Account");
        hp.clickThis(signUpButton);
    }
    @Then("I verify radio button is selected")
    public void isRadioButtonSelected(){
        By isRadioSelected= By.name("sex");
        hp.isElementSelected(isRadioSelected);


    }

}
