package StepDefinition.scholastic;

import DriverWrapper.Web;
import Pages.scholastic.Homepage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class createAccountSD extends Homepage {
    Web web= new Web();
   Homepage hp= new Homepage();

   By classCodeHomePage= By.xpath("//div[text()='Class Code']//following-sibling::div[@class='details']//div[@class='value']");
   By classCodeMyAccount= By.xpath("//h3[text()='Class Code']//following-sibling::span");
   By clickMyAccount= By.xpath("//span[@class='hide-mobile user-account-name']");
   By clickTopProfile= By.xpath("//a[@class='null' and @title='Profile']");

    @Given("^I am on scholastic homepage$")
    public void openScholastic(){
        web.openUrl2("https://clubs3qa1.scholastic.com/home");
    }
    @When("I click on Create an Account as a teacher/administrator")
    public void clickCreateAccount()  {
        hp.clickCreateAnAccount();
        hp.clickAccountTeacher();
        hp.clickNextButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @And("I select role teacher by 12th grade")
    public void SelectRole(){
        hp.clickSelectRole();
        hp.clickTeacherRoleGrade();
        hp.clickSelectGrade();
        hp.click_12th_Grade();
        hp.typeNumberOfStudents("10");
        hp.clickRoleGradeNextButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @And("I select guided reading level")
    public void SelectReadingLvl(){
        hp.clickReadingLvl();
        hp.clickGuidedReadingLvl();
        hp.clickContinueToSite();
    }
    @Then("I verify there is a CLASS CODE allocated to the teacher, present on Home-Page and MyAccount-Page")
    public void verifyClassCode(){
        String  homepageCodeText= hp.getElementText(classCodeHomePage);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hp.clickThis(clickMyAccount);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hp.clickThis(clickTopProfile);
        String myAccountCodeText=hp.getElementText(classCodeMyAccount);
       Assert.assertEquals(homepageCodeText,myAccountCodeText,"My account and Homepage code arent the same");
        System.out.println(homepageCodeText);
        System.out.println(myAccountCodeText);
    }
    @Then("I verify same Teacher name is present on My Accounts")
    public void verifyTeacherName(){

    }
    @And("I search by state and city")
    public void searchByStateCity(){
       hp.clickState();
       hp.clickNyState();
       hp.typeCity("New Yor");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hp.typeCityAutoSuggestion("New York");
       hp.clickZipCodeNdStateButton();


    }


    @And("^I enter firstname \"([^\"]*)\" lastname \"([^\"]*)\" email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iEnterAnd(String arg0, String arg1, String arg2, String arg3)  {
        By select= By.xpath("//div[@class='selected-option input-select profile-title required']");
        hp.clickThis(select);
        By mr= By.xpath("//span[text()='Mr.']");
        hp.clickThis(mr);
        hp.typeFirstName(arg0);
        hp.typeLastName(arg1);
        hp.typeEmail(arg2);
        hp.typePassword(arg3);
        hp.scrollDownByPixel(1000);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hp.clickTosCheckBox();
        hp.clickCreateAccountNextButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("^I search by zipcode \"([^\"]*)\"$")
    public void iSearchBy(String arg0) {
        hp.typeZipCode(arg0);
        hp.clickZipCodeNdStateButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String createAccountAddressText= hp.getElementText(hp.createAccountAddress());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
    }

    @And("^I enter schoolname \"([^\"]*)\"$")
    public void iEnter(String arg0) {
        hp.typeSchoolName(arg0);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }

    @And("^I select autosuggestion \"([^\"]*)\"$")
        public void autoSuggestion(String arg0){
        hp.typeSchoolNameSuggestion(arg0);
        hp.clickSchoolNameNextButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }

    @And("^I enter firstname lastname emailAddress and password$")
    public void iEnterFirstnameLastnameEmailAddressAndPassword() {
        By select= By.xpath("//div[@class='selected-option input-select profile-title required']");
        hp.clickThis(select);
        By mr= By.xpath("//span[text()='Mr.']");
        hp.clickThis(mr);
        hp.typeFirstName("firstname");
        hp.typeLastName("lastname");
        hp.typeEmail("emailaddress@gmail.com");
        hp.typePassword("password123!");
        hp.scrollDownByPixel(1000);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hp.clickTosCheckBox();
        hp.clickCreateAccountNextButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("^I enter schoolname$")
    public void iEnterSchoolname() {
        hp.typeSchoolName("Scholastic+Book+Clu");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hp.typeSchoolNameSuggestion("Scholastic+Book+Clubs");
        hp.clickSchoolNameNextButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^I verify same school address is present as selected while creating the account$")
    public void verifySameSchoolAddressI() {
        List<WebElement> elements= hp.getElements(hp.createAccountAddress());
        String createAccountAddressText= hp.getElementText(hp.createAccountAddress());
        for (WebElement expected: elements){
            if (createAccountAddressText.equalsIgnoreCase(String.valueOf(expected)));
            String actual= String.valueOf(expected);
            Assert.assertEquals(expected, actual,"school address doesnt match");

        }





    }
}








