package StepDefinition.scholastic;

import Pages.scholastic.Accountpage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class myAccountSD {
    By harryInRecommended= By.xpath("//img[@alt='Harry Potter and the Goblet of Fire']");
    By harryInSearch= By.xpath("//img[@alt='Harry Potter and the Goblet of Fire']");
    Accountpage ap= new Accountpage();
    By searchTitleAuthor= By.id("q");

    @When("I search Harry")
    public void searchHarry(){
        ap.typeSearchTitleAuthor("harry");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement searchEnter= ap.getElement(searchTitleAuthor);
        ap.pressEnter(searchEnter);

    }
    @And("Click on Quick Look on a book from results")
    public void quickLookHarry(){
        ap.moveMouseOverElement(harryInSearch);
       String harryInSearchText= ap.getElementText(harryInSearch);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ap.clickQuickLook();
    }
    @And("Click on Recommend")
    public void recommendHarry(){
        ap.clickRecommend();

    }
    @And("Select Recommendations to Students from options")
    public void selectRecommendedToStudents(){
        ap.clickRecommendToStudents();
        ap.clickCloseQuicklook();
    }
    @Then("Verify the item is added in Recommendations to Students Lists under My Lists")
    public void verifyHarryAddedInRecommend(){
        ap.clickMyLists();
        String harryInSearchText= ap.getElementText(harryInSearch);
        ap.clickListRecommendForStudents();
        String harryInRecommendedText= ap.getElementText(harryInRecommended);
        Assert.assertEquals(harryInSearchText,harryInRecommendedText,"Harry wasn't added in recommendations");

    }



}
