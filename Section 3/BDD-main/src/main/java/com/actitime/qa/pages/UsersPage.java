package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class UsersPage extends TestBase  {

    @FindBy(xpath = "//a[@href='/tabeywardana/administration/userlist.do']")
    @CacheLookup
    WebElement UserPage;

    @FindBy(xpath = "//div[contains(@class,'withPlusIcon')]")
    WebElement addUserBtn;

    @FindBy(xpath = "//div[@id='createUserPanel_accountInformationSection']/ancestor::div[@class='accountInformation section accountInformationScrollPoint']")
    WebElement beforeClick;

//    @FindBy(xpath = "//div[@id='createUserPanel_accountInformationSection']/descendant::input[@name='firstName']")
    @FindBy(xpath = "//input[@name='firstName' and not(@disabled)]")
    WebElement firstName;

    @FindBy(xpath = "//input[@name='lastName' and not(@disabled)]")
    WebElement lastName;

    @FindBy(xpath = "//input[@name='email' and not(@disabled)]")
    WebElement email;

    @FindBy(xpath = "//div[@class='selectorPlaceholder']/descendant::div[@class='downIcon']")
    WebElement dropDownArrow;

    @FindBy(xpath = "//div[@class='itemsContainer']/child::div[text()='Production']")
    WebElement selectProduction;

    @FindBy(xpath = "//div[contains(@class,'submitBtn')]")
    WebElement submitBtn;

    @FindBy(xpath = "//div[@class='createUserPanel_accountCreatedContainer']/child::div[@class='invitationInfo']")
    WebElement addedEmail;

    Logger log = Logger.getLogger(UsersPage.class);

    public UsersPage() {

        PageFactory.initElements(driver, this);



    }

    public void addUser(String firstName1, String lastName1, String email1){
        UserPage.click();
        addUserBtn.click();
        firstName.sendKeys(firstName1);
        lastName.sendKeys(lastName1);
        email.sendKeys(email1);
        dropDownArrow.click();
        selectProduction.click();
        submitBtn.click();
    }

    public void clickUserPage(){
        log.info("driver waiting");
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        UserPage.click();
        log.info("Click add user page button in menu");
    }

    public void clickAddUserBtn() {
        log.info("driver waiting");
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        addUserBtn.click();
        log.info("Click add user button");
    }

    public void enterFirstName(String firstName1){
        log.info("driver waiting");
//        driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(firstName));
        firstName.click();
        firstName.sendKeys(firstName1);
        log.info("First Name enter as "+firstName1);
    }

    public void enterLastName(String lastName1){
        log.info("driver waiting");
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        lastName.sendKeys(lastName1);
        log.info("Last Name enter as "+lastName1);
    }

    public void enterEmail(String email1){
        log.info("driver waiting");
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        email.sendKeys(email1);
        log.info("Email enter as "+email1);
    }

    public void selectProductionDept(){
        log.info("driver waiting");
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        dropDownArrow.click();
        selectProduction.click();
        log.info("Selected Production as the department");
    }

    public void clickSubmitBtn(){
        submitBtn.click();
    }

    public Boolean confirmEmail(String email){
        return addedEmail.getText().contains(email);
    }
}
