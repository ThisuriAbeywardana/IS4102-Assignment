package com.actitime.qa.stepdefinitions;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.UsersPage;
import com.actitime.qa.util.TestUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ActitimeStepDefinitions extends TestBase {
	
	
	LoginPage loginPage;
	HomePage homePage;
	String sheetName = "Users";
	TestUtil testUtil;

	UsersPage usersPage;

	
	@Given("^User in the Actitime Loging Page$")
	public void user_in_the_Actitime_Loging_Page() throws Throwable {
	    
		initialization();
		loginPage = new LoginPage();
	}

	@When("^User Enter the User Name as  \"([^\"]*)\"$")
	public void user_Enter_the_User_Name_as(String userName) throws Throwable {
		loginPage.enterUserName(userName);
	}

	@Then("^User Enter the Password as  \"([^\"]*)\"$")
	public void user_Enter_the_Password_as(String password) throws Throwable {
		loginPage.enterPassword(password);
	}

	@Then("^User click in Loging button$")
	public void user_click_in_Loging_button() throws Throwable {
		homePage =loginPage.clickSubmitButton();
	}

	@Then("^User should be able to successfuly loging to Actitime$")
	public void user_should_be_able_to_successfuly_loging_to_Actitime() throws Throwable {
	    
		homePage.validateActiTimeLogo();
		driver.quit();
		
	}

	@Given("^User logged into giving \"([^\"]*)\" and \"([^\"]*)\" the Actitime and visited Users Page")
	public void userLoggedIntoGivingAndTheActitimeAndVisitedUsersPage(String username, String password) {
		initialization();
		loginPage = new LoginPage();
		loginPage.loging(username,password);
		usersPage = new UsersPage();
		usersPage.clickUserPage();
	}

	@When("^User click in New User button$")
	public void user_click_in_new_user_button() throws Throwable {
		usersPage.clickAddUserBtn();
	}

	@Then("^User Enter the First Name as \"([^\"]*)\"$")
	public void user_enter_first_name_as(String firstName) throws Throwable{
		usersPage.enterFirstName(firstName);
	}

	@Then("^User Enter the Last Name as \"([^\"]*)\"$")
	public void user_enter_last_name_as(String lastName) throws Throwable{
		usersPage.enterLastName(lastName);
	}

	@Then("^User Enter the Email as \"([^\"]*)\"$")
	public void user_enter_email_as(String email) throws Throwable{
		usersPage.enterEmail(email);
	}

	@Then("^User Select Department as production$")
	public void user_select_production_as_department() throws Throwable{
		usersPage.selectProductionDept();
	}

	@Then("^User click in Save button$")
	public void user_click_in_save_button() throws Throwable{
		usersPage.clickSubmitBtn();
	}

	@Then("^User should be able to successfully add a new user with email as \"([^\"]*)\"$")
	public void user_should_be_able_to_successfully_add_a_new_user(String email) throws Throwable{
		usersPage.confirmEmail(email);
		driver.quit();
	}
}
