package steps;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import page.BankAndCashPage;
import page.DashBoardPage;
import page.LoginPage;
import page.ProductAndServicesPage;
import page.SideNavigationPage;
import util.BrowserFactory;
import util.Database;

public class SideNavigationSteps extends  StepsBase
{
	WebDriver driver;
	LoginPage loginPage;
	DashBoardPage dashBoardPage;
	SideNavigationPage sideNavgationPage;
	BankAndCashPage bankAndCashPage;
	ProductAndServicesPage productAndServicesPage;

	@Before
	public void starFirst() {
		driver = BrowserFactory.startBrowser();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		dashBoardPage = PageFactory.initElements(driver, DashBoardPage.class);
		sideNavgationPage = PageFactory.initElements(driver, SideNavigationPage.class);
		bankAndCashPage = PageFactory.initElements(driver, BankAndCashPage.class);
		productAndServicesPage = PageFactory.initElements(driver, ProductAndServicesPage.class);
	}

	@Given("^a Valid user credentials \"([^\"]*)\" and \"([^\"]*)\"$")
	public void a_Valid_user_credentials_and(String username, String password) {
		String expectedTitle = "Login - TechFios Test Application - Billing";
		Assert.assertEquals("login page not displayed!", expectedTitle, loginPage.getPageTitle());
		System.out.println("login parameters from feature files are : " + username + " ," + password);
		loginPage.login(username, password);
	}

	@Given("^a Valid user credentials from database$")
	public void a_Valid_user_credentials_from_database() throws ClassNotFoundException, SQLException {
		// give the username and password from database table users
		loginPage.login(Database.get("username"), Database.get("password"));
	}

	@When("^user able to login and go to DashBoard page$")
	public void user_able_to_login_and_go_to_DashBoard_page() throws Exception 
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-HHmmss");
		Date date =new Date();
		String dateTime = formatter.format(date);
		System.out.println(" Todays Date & Time General : "+date+"\n & formatted is :"+dateTime);
		screenShot(driver, "C:\\Users\\kittu\\Work\\Selenium\\Screenshots\\DashboardPageScrnshot"+dateTime+".png");
		dashBoardPage.waitForPage();
	}

	@Then("^On left navigation panel should show Dashbord Menu$")
	public void on_left_navigation_panel_should_show_Dashbord_Menu() {
		sideNavgationPage.dashboardNavigatorExists();
	}

	@When("^user access CRM Tab and add contact$")
	public void user_access_CRM_Tab_and_add_contact() {
		sideNavgationPage.clickCRMAddContactMenu();
	}

	@Then("^User should get New contact Add form$")
	public void user_should_get_New_contact_Add_form() {
		sideNavgationPage.checkAddContactFormDispalyed();
	}

	@When("^user access List contacts under CRM Tab$")
	public void user_access_List_contacts_under_CRM_Tab() throws InterruptedException {
		sideNavgationPage.clickCRMListContactMenu();
	}

	@Then("^User should get List of all contacts$")
	public void user_should_get_List_of_all_contacts() {
		sideNavgationPage.checkContactListDispalyed();
	}

	@When("^User access Transactions tab and New Deposit$")
	public void user_access_Transactions_tab_and_New_Deposit() {
	}

	@Then("^User should get New deposit form$")
	public void user_should_get_New_deposit_form() {
	}

	@When("^User access New Expense under Transactions tab$")
	public void user_access_New_Expense_under_Transactions_tab() {
	}

	@Then("^User should get New Expense form$")
	public void user_should_get_New_Expense_form() {
	}

	@When("^User Access Sales tab and New Invoice$")
	public void user_Access_Sales_tab_and_New_Invoice() throws InterruptedException {
		sideNavgationPage.goToNewSalesInovicePage();
	}

	@Then("^User should get new Invoice form$")
	public void user_should_get_new_Invoice_form() {
		sideNavgationPage.checkNewInvoiceFormDispalyed();
	}

	@When("^User access Invoices under Sales Tab$")
	public void user_access_Invoices_under_Sales_Tab() throws InterruptedException {
		sideNavgationPage.goToListSalesInvoicePage();
	}

	@Then("^User can get to see list of invoices$")
	public void user_can_get_to_see_list_of_invoices() {
		sideNavgationPage.checkInvoiceListDispalyed();
	}

	@When("^User access Bank & Cash and New Account$")
	public void user_access_Bank_Cash_and_New_Account() throws InterruptedException {
		sideNavgationPage.goToNewAccountPage();
	}

	@SuppressWarnings("deprecation")
	@Then("^User should be able to see new account form$")
	public void user_should_be_able_to_see_new_account_form() {
		Assert.assertTrue("Page not found", bankAndCashPage.checkNewAccountFormDispalyed());
	}

	@When("^User access List Accounts under Band&Cash tab$")
	public void user_access_List_Accounts_under_Band_Cash_tab() throws InterruptedException {
		sideNavgationPage.goToListAccountPage();
	}

	@Then("^User should get to see Accounts list$")
	public void user_should_get_to_see_Accounts_list() {
		bankAndCashPage.checkAccountsListDispalyed();
	}

	@When("^user navigates to Products&Services and go to New product$")
	public void user_navigates_to_Products_Services_and_go_to_New_product() throws InterruptedException {
		sideNavgationPage.goToNewProductPage();
	}

	@Then("^New product Page should display$")
	public void new_product_Page_should_display() throws InterruptedException {
		productAndServicesPage.checkNewProductFormDispalyed();
	}

	@When("^User access Products link Under Products&Services tab$")
	public void user_access_Products_link_Under_Products_Services_tab() throws InterruptedException {
		sideNavgationPage.goToProductsListPage();
	}

	@Then("^User should get to see Products list$")
	public void user_should_get_to_see_Products_list() {
		productAndServicesPage.checkProductListDispalyed();
	}

	@Then("^User able to add newBankAccount details \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\"$")
	public void user_able_to_add_newBankAccount_details(String title, String description, String balance)
			throws InterruptedException {
		bankAndCashPage.addBankAndCashNewAccount(title, description, balance);
	}

	@Then("^submit the newBankAccount form$")
	public void submit_the_newBankAccount_form() {
		bankAndCashPage.submitBankAndCashNewAccount();
	}
	
	@After
	public void close() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}
}
