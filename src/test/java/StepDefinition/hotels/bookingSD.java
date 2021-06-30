package StepDefinition.hotels;

import DriverWrapper.Web;
import Pages.hotels.Homepage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

public class bookingSD {
    Web web = new Web();
    Homepage hp = new Homepage();


    @Given("I am on hotels homepage")
    public void openHotels() {
        web.openUrl2("https://www.hotels.com/");

    }

    @When("^Enter \"([^\"]*)\" in destination$")
    public void enterInDestination(String arg0) {
        hp.clickButtonDestination();
        hp.typeDestination(arg0);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @And("Select \"([^\"]*)\" from auto suggestion")
    public void selectDestinationFromSuggestion(String arg0) {
        By destinationSuggestion = By.xpath("//section[contains(@class,'in-viewport-root')]//div[@class]//ul//child::li");

        System.out.println(hp.getElementText(destinationSuggestion));
        hp.destinationAutoSuggestion(arg0);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        hp.clickCheckIn_Out();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hp.clickNextCheckButton();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hp.clickNextCheckButton();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hp.clickNextCheckButton();

    }


    @And("^Select October 10, 2021 as Check-in$")
    public void selectOctoberAsCheckIn() {
        hp.selectCheckIn();
    }

    @And("^Select October 31,2021 as Check-out$")
    public void selectOctoberAsCheckOut() {
        hp.selectCheckOut();
    }

    @And("^Click apply$")
    public void clickApply() {
        hp.clickApplyCheckIn_Out();
    }

    @And("^Click on Search button$")
    public void clickOnSearchButton() {
        hp.clickSearchIn_Out();
    }

    @Then("^I verify at the end of search results changes dates is displayed and enabled$")
    public void verifyChangesDatesDisplayedNdEnabled() {
        try {
            Object lastHeight = ((JavascriptExecutor) web.getDriver()).executeScript("return document.body.scrollHeight");

            while (true) {
                ((JavascriptExecutor) web.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight);");
                Thread.sleep(2000);

                Object newHeight = ((JavascriptExecutor) web.getDriver()).executeScript("return document.body.scrollHeight");
                if (newHeight.equals(lastHeight)) {
                    break;
                }
                lastHeight = newHeight;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            hp.scrollUpByPixel(500);
            Assert.assertTrue(hp.isChangeDatesDisplayed());
            Assert.assertTrue(hp.nisChangeDAtesEnabled());
        }
    }

    @When("^I Click on Guests$")
    public void clickOnGuests() {
        hp.clickGuests();
    }

    @And("^Select Adults as \"([^\"]*)\"$")
    public void selectAdults(String arg0) {
       hp.adultsDropdown(arg0);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("^Select Children as \"([^\"]*)\"$")
    public void selectChildren(String arg0) {
        hp.childrenDropdown(arg0);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("^Select first child age \"([^\"]*)\"$")
    public void selectFirstChildAge(String arg0) {
        hp.ageChild_1Dropdown(arg0);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("^Select second child age \"([^\"]*)\"$")
    public void selectSecondChildAge(String arg0) {
        hp.ageChild_2Dropdown(arg0);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^I verify on rooms pop-up, number of adults and children same as selected on step #3 and #4$")
    public void verifyRoomsNumberAdultsNdChildrenSameAsSelected() {
        String adults= hp.getAdultsText();
        String children= hp.getChildrenText();
        String[] adultsNdChildrenArray= hp.getRoomPopUpText().trim().split("");
        String adultsIndex= adultsNdChildrenArray[7];
        String childrenIndex= adultsNdChildrenArray[17];
        Assert.assertEquals(adultsIndex,adults,"adults number dont match");
        Assert.assertEquals(childrenIndex, children,"children number dont match");

    }

    @And("^Click on Apply$")
    public void clickOnApply() {
        hp.clickApplyCheckIn_Out();
    }

    @And("^I verify total number of guests in sum of adults and children same as selected on steps #3 and #4")
    public void verifyTotalNumberGuestsInAdultsAndChildrenSameAsSelected() {
        String totalGuests= hp.getTotalGuestsText();
        String[] totalGuestsArray= totalGuests.trim().split("");
        String totalGuestsIndex= totalGuestsArray[8];
        int totalGuestIndexInt= Integer.valueOf(totalGuestsIndex);
        hp.clickGuests();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String adults= hp.getAdultsText();
        String children= hp.getChildrenText();
        int adultsInt= Integer.valueOf(adults);
        int childrenInt= Integer.valueOf(children);
        int totalAdultsNdChildren= adultsInt + childrenInt;
        Assert.assertEquals(totalGuestIndexInt, totalAdultsNdChildren, "total number guests dont match" );
    }
}

