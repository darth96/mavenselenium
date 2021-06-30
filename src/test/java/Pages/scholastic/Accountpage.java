package Pages.scholastic;

import Pages.WebCommands;
import org.openqa.selenium.By;

public class  Accountpage extends WebCommands {
    By closeLoginNotif= By.className("notification-close");
    By signIn= By.linkText("Sign In");
    By signInEmailField= By.xpath("//input[contains(@id,'user-text')]");
    By signInButton= By.id("signin-email-submit-button");
    By signInPasswordField= By.id("password-text-field");
    By signInSubmitButton= By.xpath("//button[text()='sign in']");
    By searchTitleAuthor= By.id("q");
    By closeShopParentPop_up= By.xpath("//span[contains(text(),'undefined')]//following-sibling::span");
    By searchIcon= By.xpath("//i[@class='fa fa-search']");
    By quickLook= By.xpath("//a[@title='Harry Potter and the Goblet of Fire']//following-sibling::a[@class='quickview']");
    By recommended= By.xpath("//span[@class='icon-button-text' and text()='Recommend']");
    By recommendToStudents= By.xpath("//input[@type='checkbox' and @value='recommended']");
    By closeQuickLook= By.xpath("//span[contains(@class,'ui-button-icon ui-icon')]");
    By myLists= By.xpath("//span[text()='My Lists']");
    By listRecommendForStudentsOption= By.partialLinkText("Recommendations for Students");
    By harryInRecommended= By.xpath("//img[@alt='Harry Potter and the Goblet of Fire']");
    By harryInSearch= By.xpath("//img[@alt='Harry Potter and the Goblet of Fire']");
    By myAccount= By.xpath("//span[@class='hide-mobile user-account-name']");
    By accountPaymentMethods= By.linkText("Payment Methods");
    By addCreditCard= By.xpath("//a[contains(text(),'Add a Card') and contains(@data-tooltip-option,'creditcarder')]");
    By creditCardLimit= By.xpath("//div[@class='tooltipster-body']");
    By enterOrders= By.xpath("//div[@class='sidecar-top']/following-sibling::div//a[@id='enter-orders']");
    By ordersStudentFlyer= By.partialLinkText("Student Flyer");
    By ordersYourTeacher= By.partialLinkText("Your Teacher Order");
    By priceQtyField= By.xpath("//input[@type='text' and contains(@class,'itm-qty-usd')]");
    By priceQtyErrorMsg= By.xpath("//div[@class='info-modal-content']");
    By closePriceQtyErrorMsg= By.xpath("//i[@class='fa fa-times info-modal-close']");
    By priceQtyHeaderMSg= By.className("info-modal-hd");
    By itemNumberErrorMsg= By.id("error-message-tooltip");
    By studentNameField= By.id("student-name");
    By itemNumberField= By.id("item-number");
    By addItemButton= By.id("btn-add");
    By itemQuantity= By.xpath("//input[contains(@class,'input-qty')]");////td[@class=' itemNum details-control']
    By reviewCart= By.className("secondary");
    By harryXButton= By.xpath("//tr[@id='2S8']//i[@class='fa fa-times-circle remove']");//"//tr[@id='2S8']//i[@class='fa fa-times-circle remove']"
    By harryYesDeleteButton= By.xpath("//tr[@id='2S8']//button[@value='Remove']");
    By harryTotalPrice= By.xpath("//li[text()='$55.00']");
    By harryTotalQty= By.xpath("//span[text()='6']");
    By totalPrice= By.xpath("//li[@class='std-total-price sfoSubTotalPrice']");
    By totalQty= By.xpath("//span[@class='total-qty sfoSubTotalQty']");
    By proceedToCheckout= By.xpath("//button[@value='Proceed to Checkout']");
    By proceedToCheckout_2= By.xpath("//div[@class='col promo-msg']//button[@value='Proceed to Checkout']");
    By checkoutTax= By.id("order_total_tax");

    public By checkoutTaxText(){
        return checkoutTax;
    }
    public void clickProceedCheckout_2(){
        clickThis(proceedToCheckout_2);
    }

    public void clickProceedCheckout(){
        clickThis(proceedToCheckout);
    }

    public void clickOrderYourTeacher(){
        clickThis(ordersYourTeacher);
    }
    public void clickPriceQtyField(){
        clickThis(priceQtyField);
    }
    public void typePriceQtyField(String data){
        type(priceQtyField, data);
    }
    public By priceQtyHeader(){
        return priceQtyHeaderMSg;
    }
    public By priceQtyError(){
        return priceQtyErrorMsg;
    }
    public void clickClosePriceQtyErrorMsg(){
        clickThis(closePriceQtyErrorMsg);
    }

    public void typeStudentNameField(String data){
        type(studentNameField, data);
    }
    public void typeItemNumberField(String data){
        type(itemNumberField,data);
    }
    public void clickAddItemButton(){
        clickThis(addItemButton);
    }
    public void typeItemQuantity(String data){
        type(itemQuantity,data);
    }
    public void clickReviewCart(){
        clickThis(reviewCart);
    }
    public void clickHarryXButton(){
        clickThis(harryXButton);
    }
    public void clickHarryYesDeleteButton(){
        clickThis(harryYesDeleteButton);
    }
    public By harryTotalPriceText(){
        return harryTotalPrice;
    }
    public By harryTotalQtyText(){
        return harryTotalQty;
    }
    public By totalPriceText(){
        return totalPrice;
    }
    public By totalQtyText(){
        return totalQty;
    }
    public By itemNumberErrorText(){
        return itemNumberErrorMsg;
    }



    public void clickSignIn(){
        clickThis(signIn);
    }
    public void typeEmailField(String data){
        type(signInEmailField, data);
    }
    public void clickSignInEmailButton(){
        clickThis(signInButton);
    }
    public void typeSignInPassword(String data){
        type(signInPasswordField,data);
    }
    public void clickSignInSubmitButton(){
        clickThis(signInSubmitButton);
    }
    public  void clickCloginPageNotif(){
        clickThis(closeLoginNotif);
    }
    public void typeSearchTitleAuthor(String data){
        type(searchTitleAuthor, data);
    }
    public void clickCloseShopParent(){
        clickThis(closeShopParentPop_up);
    }
    public void clickSearchIcon(){
        clickThis(searchIcon);
    }
    public void clickQuickLook(){
        clickThis(quickLook);
    }
    public void clickRecommend(){
        clickThis(recommended);
    }
    public void clickRecommendToStudents(){
        clickThis(recommendToStudents);
    }
    public void clickCloseQuicklook(){
        clickThis(closeQuickLook);
    }
    public void clickMyLists(){
        clickThis(myLists);
    }
    public void clickListRecommendForStudents(){
        clickThis(listRecommendForStudentsOption);
    }
    public void clickMyAccount(){ clickThis(myAccount);}
    public void clickAccountPaymentMethods(){ clickThis(accountPaymentMethods);}
    public void clickAddCreditCard(){ clickThis(addCreditCard);}
    public By creditCardLimit(){
        By cardLimit = this.creditCardLimit;
        return cardLimit;
    }
    public void hoverEnterOrders(){
        moveMouseOverElement(enterOrders);
    }
    public void clickOrderStudentFlyer(){
        clickThis(ordersStudentFlyer);
    }



}

