package Pages.scholastic;

import Pages.WebCommands;
import org.openqa.selenium.By;

public class Homepage extends WebCommands {
    //locators to create new account
    By createAnAccount = By.xpath("//a[text()='Create an Account']/ancestor::li[@class='mylists']");
    By accountTeacher = By.xpath("//label[@for='acccountTeacther']");
    By accountParent = By.id("acccountParent");
    By nextButton = By.xpath("//a[@id='linkChooseAcount']");
    By selectTitle= By.xpath("//select[@id='dwfrm_profile_customer_title']");
    By firstNameField = By.xpath("//input[@id='dwfrm_profile_customer_firstname']");//input[@id='dwfrm_profile_customer_firstname']
    By lastNameField = By.xpath("//input[@id='dwfrm_profile_customer_lastname']");
    By emailField = By.id("dwfrm_profile_customer_email");
    By passwordField = By.id("dwfrm_profile_login_password");
    By tosCheckBoxTeacher = By.id("dwfrm_registration_termsofuseteacher");
    By createAccountNextButton = By.xpath("//button[@name='dwfrm_profile_confirm']");
    By zipCodeField = By.id("dwfrm_myschool_schoolzip");
    By zipNdStateButton = By.xpath("//button[@id='button-search' and not(@disabled)]");
    By schoolNameSearch = By.xpath("//input[@id='dwfrm_searchschool_schoolvalue']");
    By selectByState= By.xpath("//div[@class='selected-option input-select']");
    By stateNy= By.xpath("//span[text()=' New York']");
    By citySearch= By.id("dwfrm_myschool_schoolcity");
    By cityStateSearchButton= By.name("dwfrm_myschool_searchone");
    By cityOptions= By.xpath("//li[@class='ui-menu-item']");
    By schoolName= By.id("dwfrm_searchschool_schoolvalue");
    By schoolNameOptions= By.xpath("//li[@class='ui-menu-item']");
    By schoolNameNextButton = By.name("dwfrm_searchschool_findnext");
    By selectRole = By.xpath("//div[text()='Select Role']");
    By teacherGradeRole= By.xpath("//span[text()='Teacher (by Grade)']");
    By selectGrade = By.xpath("//div[text()='Select Grade']");
    By twelfthGradeSelect= By.xpath("//span[text()='12th Grade']");
    By numberOfStudents = By.name("dwfrm_myrole_students");
    By roleGradeNextButton = By.name("dwfrm_myrole_findgrade");
    By readingLvl = By.xpath("//div[text()='Select Type']");
    By guidedReadingLvl=By.xpath("//span[contains(text(),'Guided Reading')]");
    By continueToSite = By.name("dwfrm_profileselection_confirmed");
    By homepageClassCode = By.xpath("//div[@class='value' and contains(text(),'322C68')]");
    By schoolAddress= By.xpath("//div[@class='school-add']");
    By profileSchoolAddress= By.xpath("//span[@class='city-school']//preceding-sibling::span");
    public By createAccountAddress(){
        return schoolAddress;
    }
    public By profileAccountAddress(){
        return profileSchoolAddress;
    }

    public void clickCreateAnAccount() {
        clickThis(createAnAccount);
    }
    public void clickAccountTeacher(){
        clickThis(accountTeacher);
    }
    public void clickAccountParent(){
        clickThis(accountParent);
    }
    public void clickNextButton(){
        clickThis(nextButton);
    }
    public void selectTitle(String data){
        selectFromDropdown(selectTitle,data);}
    public void typeFirstName(String data){
        type(firstNameField,data);
    }
    public void typeLastName(String data){
        type(lastNameField, data);
    }
    public void typeEmail(String data){
        type(emailField,data);
    }
    public void typePassword(String data){
        type(passwordField,data);
    }
    public void clickTosCheckBox(){
        clickThis(tosCheckBoxTeacher);
    }
    public void clickCreateAccountNextButton(){
        clickThis(createAccountNextButton);
    }
    public void typeZipCode(String data){
        type(zipCodeField, data);
    }
    public void clickZipCodeNdStateButton(){
        clickThis(zipNdStateButton);
    }
    public void typeSchoolName(String data){type(schoolName, data);}
    public void typeSchoolNameSuggestion(String data){
        selectFromAutoSuggestion(schoolNameOptions, data);
    }
    public void clickState(){
        clickThis(selectByState);
    }
    public void clickNyState(){
        clickThis(stateNy);
    }
    public void typeCity(String data){
        type(citySearch, data
        );
    }
    public void typeCityAutoSuggestion(String data){
        selectFromAutoSuggestion(cityOptions, data);
    }

    public void clickSchoolNameNextButton(){
        clickThis(schoolNameNextButton);
    }
    public void clickSelectRole(){
        clickThis(selectRole);
    }
    public void clickTeacherRoleGrade(){
        clickThis(teacherGradeRole);
    }
    public void clickSelectGrade(){
        clickThis(selectGrade);
    }
    public void click_12th_Grade(){
      clickThis(twelfthGradeSelect);

    }
    public void typeNumberOfStudents(String data){
        type(numberOfStudents, data);

    }
    public void clickRoleGradeNextButton(){
        clickThis(roleGradeNextButton);

    }
    public void clickReadingLvl(){
       clickThis(readingLvl);
    }
    public void clickGuidedReadingLvl(){
        clickThis(guidedReadingLvl);
    }
    public void clickContinueToSite(){
        clickThis(continueToSite);
    }

}
