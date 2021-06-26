package StepDefinition.scholastic;

import Pages.scholastic.Accountpage;
import cucumber.api.java.cs.A;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class paymentSD {
    Accountpage ap = new Accountpage();

    @Given("^I login on Scholastic$")
    public void signScholastic() {
        ap.openUrl2("https://clubs3qa1.scholastic.com/home");
        ap.clickSignIn();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ap.switchToFrame("iframeMyScholastic");
        ap.typeEmailField("firstlast982@gmail.com");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ap.clickSignInEmailButton();
        ap.typeSignInPassword("password123!");
        ap.clickSignInSubmitButton();
        ap.clickCloginPageNotif();

    }
    @Given("^I login on Scholastic on non taxable state$")
        public void loginNonTaxState (){
        ap.openUrl2("https://clubs3qa1.scholastic.com/home");
        ap.clickSignIn();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ap.switchToFrame("iframeMyScholastic");
        ap.typeEmailField("thirdfourth098@gmail.com");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ap.clickSignInEmailButton();
        ap.typeSignInPassword("password123!");
        ap.clickSignInSubmitButton();
        ap.clickCloginPageNotif();

    }
    @And("Enter student name \"([^\"]*)\" Items \"([^\"]*)\" Items \"([^\"]*)\" Items \"([^\"]*)\" Items \"([^\"]*)\"")
    public void enterName(String arg0, String arg1, String arg2,String arg3,String arg4){
        ap.typeStudentNameField(arg0);
        ap.typeItemNumberField(arg1);
        ap.clickAddItemButton();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ap.typeStudentNameField(arg0);
        ap.typeItemNumberField(arg2);
        ap.clickAddItemButton();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ap.typeStudentNameField(arg0);
        ap.typeItemNumberField(arg3);
        ap.clickAddItemButton();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ap.typeStudentNameField(arg0);
        ap.typeItemNumberField(arg4);
        ap.clickAddItemButton();
    }
    @And("I type on Price-QTY box")
    public void typePrice_QtyField(){
        ap.typePriceQtyField("10");
        ap.scrollToBottom();
       // ap.clickReviewCart();
       // ap.scrollUpByPixel(700);
      //  ap.clickProceedCheckout();
      //  ap.scrollToBottom();
      //  ap.clickProceedCheckout();

    }

    @When("I click on Payment Methods from My Account")
    public void paymentMethodsPage() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ap.clickMyAccount();
        ap.clickAccountPaymentMethods();
        ap.clickAddCreditCard();

    }

    @Then("I verify user get error msg 'You can only store three credit cards' when adding a 4th credit card")
    public void verifyCreditCardErrorMsg() {
        ap.getElementText(ap.creditCardLimit());
        boolean isDisplayed = ap.isElementDisplayed(ap.creditCardLimit());
        Assert.assertTrue(isDisplayed);

    }

    @When("I click on 'Enter Orders'")
    public void enterOrders() {
        ap.hoverEnterOrders();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("Select Student Flyer Orders")
    public void studentFlyingOrder() {
        ap.clickOrderStudentFlyer();
    }

    @And("Click on review cart")
    public void reviewCart() {
        ap.scrollToBottom();
        ap.clickReviewCart();

    }

    @And("Click on 'X button corresponding to 2S8 item for Harry'")
    public void deleteHarryItems() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ap.scrollDownByPixel(1300);
        ap.harryTotalPriceText();
        String harryBeforePrice = ap.getElementText(ap.harryTotalPriceText());
        ap.harryTotalQtyText();
        String harryBeforeQty = ap.getElementText(ap.harryTotalQtyText());
        ap.totalPriceText();
        String totalPriceBefore = ap.getElementText(ap.totalPriceText());
        ap.totalQtyText();
        String totalQtyBefore = ap.getElementText(ap.totalQtyText());
        ap.scrollUpByPixel(500);
        ap.clickHarryXButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @And("Click on 'Yes'")
    public void yesDeleteHarry() {
        ap.clickHarryYesDeleteButton();

    }

    @Then("I verify For Harry, item 2S8 gets deleted")
    public void verifyHarryItemDelete() {
        ap.harryTotalPriceText();
        ap.harryTotalQtyText();

    }

    @And("I verify Respective amounts and quantities get updated")
    public void verifyTotalItems() {
        ap.totalPriceText();
        String totalAfterPrice = ap.getElementText(ap.totalPriceText());
        ap.totalQtyText();
        String totalAfterQty = ap.getElementText(ap.totalQtyText());
    }

    @And("Select 'Your teacher Order'")
    public void orderTeacher() {
        ap.clickOrderYourTeacher();
        ap.scrollUpByPixel(700);
    }

    @And("Click on Price-QTY box")
    public void price_QtyField() {
        ap.clickPriceQtyField();
    }

    @Then("I verify Teacher sees a jumper right above the box with message: Heading - IMPORTANT Message - All student paper flyer orders MUST be entered in the Student Flyer Orders tab")
    public void verifyTeacherErrorMsg() {
        ap.priceQtyHeader();
        String priceQtyHeaderText = ap.getElementText(ap.priceQtyHeader());
        ap.priceQtyError();
        String priceQtyErrorText = ap.getElementText(ap.priceQtyError());
        boolean isPriceQtyHeaderDisplayed = ap.isElementDisplayed(ap.priceQtyHeader());
        boolean isPriceQtyErrorMsgDisplayed = ap.isElementDisplayed(ap.priceQtyError());
        Assert.assertTrue(isPriceQtyHeaderDisplayed, priceQtyHeaderText);
        Assert.assertTrue(isPriceQtyErrorMsgDisplayed, priceQtyErrorText);

    }

    @A("Enter data in the clicked Price-QTY box and click on X on the Jumper")
    public void enterPriceQtyData() {
        ap.typePriceQtyField("10");
        ap.clickClosePriceQtyErrorMsg();
    }

    @And("I verify Teacher does NOT see any jumper")
    public void verifyNoPriceQtyErrorMSg() {
        ap.priceQtyHeader();
        String priceQtyHeaderText = ap.getElementText(ap.priceQtyHeader());
        ap.priceQtyError();
        String priceQtyErrorText = ap.getElementText(ap.priceQtyError());
        boolean isPriceQtyHeaderDisplayed = ap.isElementDisplayed(ap.priceQtyHeader());
        boolean isPriceQtyErrorMsgDisplayed = ap.isElementDisplayed(ap.priceQtyError());
        Assert.assertFalse(isPriceQtyHeaderDisplayed, priceQtyHeaderText);
        Assert.assertFalse(isPriceQtyErrorMsgDisplayed, priceQtyErrorText);
    }

    @And("Enter student name 'Harry' Items '111'")
    public void enterName() {
        ap.typeStudentNameField("Harry");
        ap.typeItemNumberField("111");
    }

    @And("Click on 'Add Button'")
    public void addStudentItems() {
        ap.clickAddItemButton();
    }

    @Then("I verify Expected error msg Please enter a valid item number")
    public void verifyInvalidItemNumber() {
        ap.itemNumberErrorText();
        String invalidItemNumberText = ap.getElementText(ap.itemNumberErrorText());
        boolean isInvalidItemErrorDisplayed = ap.isElementDisplayed(ap.itemNumberErrorText());
        Assert.assertTrue(isInvalidItemErrorDisplayed, invalidItemNumberText);
    }


    @And("^Enter student name \"([^\"]*)\" Items \"([^\"]*)\" Quantity \"([^\"]*)\" Items \"([^\"]*)\" Quantity \"([^\"]*)\"$")
    public void harryItemsGQuantityItemsGQuantity(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) {
        ap.typeStudentNameField(arg0);
        ap.typeItemNumberField(arg1);
        ap.clickAddItemButton();
        ap.typeStudentNameField(arg2);
        ap.typeItemNumberField(arg3);
        ap.clickAddItemButton();
        ap.typeItemQuantity(arg4);
        ap.typeStudentNameField(arg5);
        ap.typeItemNumberField(arg6);
        ap.clickAddItemButton();


    }

    @And("^Enter student name \"([^\"]*)\" Items \"([^\"]*)\" Quantity '(\\d+)' Items \"([^\"]*)\" Quantity '(\\d+)'$")
    public void enterStudentNameItemsNdQuantity(String arg0, String arg1, int arg2, String arg3, int arg4) {
        int num = 0;
        for (int i = 0; i < arg2; i++) {
            if (num < arg2 || num != arg2) {
                ap.typeStudentNameField(arg0);
                ap.typeItemNumberField(arg1);
                ap.clickAddItemButton();
                num++;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else
                break;
        }
        int num2 = 0;
        //boolean arg_3_Empty = arg3.isEmpty();
        // if (arg_3_Empty==false){
        for (int j = 0; j < arg4; j++) {
            if (num2 < arg4 || num != arg4) {
                ap.typeStudentNameField(arg0);
                ap.typeItemNumberField(arg3);
                ap.clickAddItemButton();
                num2++;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else
                break;
        }
    }


    @And("^Enter student name \"([^\"]*)\" Items \"([^\"]*)\" Quantity '(\\d+)'$")
    public void enterStudentNameItemsNdQuantity(String arg0, String arg1, int arg2) {
        int num = 0;
        for (int i = 0; i < arg2; i++) {
            if (num < arg2 || num != arg2) {
                ap.typeStudentNameField(arg0);
                ap.typeItemNumberField(arg1);
                ap.clickAddItemButton();
                num++;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else
                break;

        }
    }

    @And("click on proceed to check out and again click proceed to checkout")
    public void clickOnProceedToCheckout() {
        ap.scrollDownByPixel(1000);
        ap.clickProceedCheckout();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ap.scrollUpByPixel(500);
        ap.clickProceedCheckout_2();

    }


    @Then("^I verify tax amount is \"([^\"]*)\"$")
    public void verifyTaxAmount(String arg0)  {
        String actualCheckTaxText= ap.getElementText(ap.checkoutTaxText());
        Assert.assertEquals(arg0,actualCheckTaxText,"estimated tax isnt zero for taxable state");

    }
}
