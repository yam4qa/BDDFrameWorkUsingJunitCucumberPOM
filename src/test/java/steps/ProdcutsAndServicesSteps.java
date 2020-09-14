package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import page.DashBoardPage;
import page.LoginPage;
import page.ProductAndServicesPage;
import page.SideNavigationPage;
import util.BrowserFactory;

public class ProdcutsAndServicesSteps 
{
	WebDriver driver;
	String expectedTitle ="";
	String actualTitle ="";
	LoginPage loginPage;
	DashBoardPage dashboardPage;
	SideNavigationPage sideNavigationPage;
	ProductAndServicesPage productAndServicesPage;
	
	//@Before
	public void beforeRun() {
		driver = BrowserFactory.startBrowser();
		System.out.println("driver in ProdcutsAndServicesSteps.class :" );
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		dashboardPage = PageFactory.initElements(driver, DashBoardPage.class);
		sideNavigationPage = PageFactory.initElements(driver, SideNavigationPage.class);
		productAndServicesPage = PageFactory.initElements(driver, ProductAndServicesPage.class);
	}
	/*
	 * @Then("^user navigates to dashboard page$") public void
	 * user_navigates_to_dashboard_page(){ expectedTitle =
	 * "Dashboard- TechFios Test Application - Billing"; actualTitle =
	 * driver.getTitle();
	 * System.out.println("When user navigates to dashboard page actual Title is " +
	 * actualTitle); if (!actualTitle.equalsIgnoreCase(expectedTitle)) { System.out.
	 * println("Page Title is not expected, So dashboard page might not be loaded "
	 * ); } }
	 */	
	@And("^user able to enter product details \"([^\"]*)\", \"([^\"]*)\" , \"([^\"]*)\"$")
	public void user_able_to_enter_product_details(String productName, String salesPrice, String description) 
	{
		productAndServicesPage.AddNewProductDetails(productName,salesPrice, description);
	}

	@And("^user submits New Product Form$")
	public void user_submits_New_Product_Form()  
	{
		productAndServicesPage.SubmitNewProduct();
	}	

	@When("^user want to see created product in the list$")
	public void user_want_to_see_created_product_in_the_list() throws InterruptedException 
	{
		productAndServicesPage.searchProductInTheList();
	}

	@Then("^user able to search the product in the list$")
	public void user_able_to_search_the_product_in_the_list() 
	{
		
	}

}
