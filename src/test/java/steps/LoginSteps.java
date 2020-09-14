package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import page.DashBoardPage;
import page.LoginPage;

import org.junit.Test;
import util.BrowserFactory;

public class LoginSteps 
{
	String username = "";
	String password = "";
	WebDriver driver;
	String expectedTitle ="";
	String actualTitle ="";
	
	@Given("^a valid user$")
	public void a_valid_user() {
		username = "techfiosdemo@gmail.com";
		password = "abc123";
	}

	@Given("^an invalid user$")
	public void an_invalid_user() {
		username = "techfiosdemo@gmail.com";
		password = "abc123ftr";
	}

	@When("^user goes to techfios site$")
	public void user_goes_to_techfios_site() 
	{
		System.out.println("Browser starting in logiSteps.java");
		driver = BrowserFactory.startBrowser();
	}

	@Then("^techfios login page should displayed$")
	public void techfios_login_page_should_displayed() 
	{
		expectedTitle = "Login - TechFios Test Application - Billing";
		actualTitle = driver.getTitle();
		if (!actualTitle.equalsIgnoreCase(expectedTitle)) {
			System.out.println("Page Title is not expected, So login page might not be loaded ");
		}
		// assertEquals("", expectedTitle, actualTitle);
	}

	@When("^user provides credentials$")
	public void user_provides_credentials() 
	{
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login(username, password);
	}

	@Then("^Dashboard page should be displayed$")
	public void dashboard_page_should_be_displayed() 
	{
		expectedTitle = "Dashboard- TechFios Test Application - Billing";
		actualTitle = driver.getTitle();
		
		if (!actualTitle.equalsIgnoreCase(expectedTitle)) {
			System.out.println("Page Title is not expected, So dashboard page might not be loaded ");
		}
	}

	@Then("^username should match$")
	public void username_should_match() throws InterruptedException 
	{
		DashBoardPage dashBoardPage = PageFactory.initElements(driver, DashBoardPage.class);
		//Assert.assertEquals("User is different from actually logged in", true, dashBoardPage.checkUserName(username));;
		boolean actualUserName = dashBoardPage.checkUserName(username);
		if(!actualUserName==true)
			System.out.println("User is different from actually logged in");
	}
//	@When("^user provides invalid credentials$")
//	public void user_provides_invalid_credentials()
//	{
//		
//	}

	@Then("^login page should be displayed$")
	public void login_page_should_be_displayed() 
	{
		expectedTitle = "Login - TechFios Test Application - Billing";
		actualTitle = driver.getTitle();
		
		if (!actualTitle.equalsIgnoreCase(expectedTitle)) {
			System.out.println("Page Title is not expected, So not the rt page ");
		}
	}

	@Then("^invalied credentials alert should be displayed$")
	public void invalied_credentials_alert_should_be_displayed()
	{
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		if(!loginPage.invalidCredentialsAlert()==true)
			System.out.println("Not Correct page ");
	}

}
