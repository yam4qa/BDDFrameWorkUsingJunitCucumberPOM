package page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import junit.framework.Assert;

public class SideNavigationPage extends BasePage 
{
	WebDriver driver;
	List<WebElement> webElementList;
	// Every Page must have a constructor to invite the driver
	public SideNavigationPage(WebDriver driver) {
		this.driver = driver;
	}
	// Element Library
	@FindBy(how = How.LINK_TEXT, using = "Dashboard")
	WebElement DASHBOARD_NAVIGATOR_ELELEMENT;
	
	// CRM Tab elements
	@FindBy(how = How.XPATH, using = "//nav[@class='navbar-default navbar-static-side']/descendant :: span[text()='CRM']")
	WebElement CRM_ELELEMENT;
	@FindBy(how = How.LINK_TEXT, using = "Add Contact")
	WebElement AddContactTab_ELEMENT;
	@FindBy(how = How.LINK_TEXT, using = "List Contacts")
	WebElement ListContactsTab_ELEMENT;
	@FindBy(how = How.XPATH, using = "//h2[contains(text() ,'Contacts')]")
	WebElement ContactsHeader;
	@FindBy(how = How.XPATH, using = "//h5[text()='Add Contact']")
	WebElement AddContactHeader;
	@FindBy(how = How.XPATH, using = "//h3[text()='Filter by Tags']")
	WebElement FilterByTagsHeader;

	// Transactions Tab and Deposit,Expenses Elements
	@FindBy(how = How.XPATH, using = "//ul[@id='side-menu']/descendant::span[contains(text() ,'Transactions' )]")
	WebElement TransactionsModuleLink;
	@FindBy(how = How.XPATH, using = "//a[contains(text() ,'New Deposit' )]")
	WebElement NewDepositLink;
	@FindBy(how = How.XPATH, using = "//a[contains(text() ,'New Expense' )]")
	WebElement NewExpenseLink;

	// Sales Tab and Invoice link elements
	@FindBy(how = How.XPATH, using = "//ul[@id='side-menu']/descendant::span[contains(text() ,'Sales' )]")
	WebElement SalesInvoiceModuleLink;
	@FindBy(how = How.XPATH, using = "//ul[@id='side-menu']/descendant::a[contains(text() ,'New Invoice' )]")
	WebElement NewSalesInvoiceLink;
	@FindBy(how = How.XPATH, using = "//ul[@id='side-menu']/descendant::a[text()='Invoices']")
	WebElement ListSalesInvoiceLink;
	@FindBy(how = How.XPATH, using = "//h5[contains(text() , 'Create New Invoice')]")
	WebElement NewSalesInvoiceHeader;
	@FindBy(how = How.XPATH, using = "//h2[contains(text() , 'Invoices' )]")
	WebElement ListSalesInvoiceHeader;
	
	// Bank & Cash Tab elements
	@FindBy(how = How.XPATH, using = "//span[text()='Bank & Cash']")
	WebElement BankCashModule;
	@FindBy(how = How.LINK_TEXT, using = "New Account")
	WebElement NewAccountLink;
	@FindBy(how = How.LINK_TEXT, using = "List Accounts")
	WebElement ListAccountLink;
	
	// Products & Services Tab elements
	@FindBy(how = How.XPATH, using = "//ul[@id='side-menu']/descendant::span[text()='Products & Services']")
	WebElement ProductAndServicesTab_ELEMENT;
	@FindBy(how = How.LINK_TEXT, using = "New Product")
	WebElement NewProductLink;
	@FindBy(how = How.LINK_TEXT, using = "Products")
	WebElement ProductsListLink;

	public void dashboardNavigatorExists()
	{
		waitForElement(DASHBOARD_NAVIGATOR_ELELEMENT, driver);
	}

	// Under CRM tab clicking 'Add Contact' link
	public void clickCRMAddContactMenu() 
	{
		System.out.println("in clickCRMAddContactMenu method");
		waitForElement(CRM_ELELEMENT, driver);
		CRM_ELELEMENT.click();
		waitForElement(AddContactTab_ELEMENT, driver);
		AddContactTab_ELEMENT.click();
	}
	public void checkAddContactFormDispalyed() {
		webElementList = new ArrayList<WebElement>();
		// checking for both heading elements 'Contacts' and 'Add Contact' combined
		webElementList.add(0, ContactsHeader);
		webElementList.add(1, AddContactHeader);
		waitForElementS(webElementList, driver);
	}

	// Under CRM tab clicking 'List Contact' link
	public void clickCRMListContactMenu() throws InterruptedException 
	{
		System.out.println("clickCRMListContactMenu method");
		try {
			ListContactsTab_ELEMENT.click();
		} catch (Exception e) {
			waitForElement(CRM_ELELEMENT, driver);
			CRM_ELELEMENT.click();
			waitForElement(ListContactsTab_ELEMENT, driver);
			ListContactsTab_ELEMENT.click();
		} 
	}
	public void checkContactListDispalyed() {
		// checking for both heading elements 'Contacts' and 'Add Contact' combined
		webElementList = new ArrayList<WebElement>();
		webElementList.add(0, ContactsHeader);
		webElementList.add(1, FilterByTagsHeader);
		waitForElementS(webElementList, driver);
	}

//Transaction Tab Methods	

// Sales tab methods
	public void goToNewSalesInovicePage() throws InterruptedException {
		SalesInvoiceModuleLink.click();
		//Thread.sleep(2000);
		waitForElement(NewSalesInvoiceLink, driver);
		NewSalesInvoiceLink.click();
		Thread.sleep(5000);
		
	}
	public void checkNewInvoiceFormDispalyed() {
		waitForElement(NewSalesInvoiceHeader , driver);
	}

	public void goToListSalesInvoicePage() throws InterruptedException {
		try {
			System.out.println("goToListSalesInvoicePage method in SideNavigationPage page");
			ListSalesInvoiceLink.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			SalesInvoiceModuleLink.click();
			Thread.sleep(2000);
			ListSalesInvoiceLink.click();
			Thread.sleep(2000);
		} 
	}
	public void checkInvoiceListDispalyed() 
	{
		System.out.println("Landed into checkInvoiceListDispalyed method in SideNavigationPage page");
		waitForElement(ListSalesInvoiceHeader, driver);
	}
// Bank & Cash Tab methods
	public void goToNewAccountPage() throws InterruptedException 
	{
		System.out.println("In goToNewAccountPage() method ");
//		try {
//			waitForElement(NewAccountLink, driver);
//			NewAccountLink.click();
//		} catch (Exception e) 
//		{	
			waitForElement(BankCashModule, driver);
			BankCashModule.click();
			Thread.sleep(1000);
			NewAccountLink.click();
			Thread.sleep(1000);
//		}
	}

	public void goToListAccountPage() throws InterruptedException 
	{
		try {
			waitForElement(ListAccountLink, driver);
			ListAccountLink.click();
		} catch (Exception e) {
			BankCashModule.click();
			Thread.sleep(1000);
			ListAccountLink.click();
		} 
	}
	
//Products & Services Tab Methods()
	public void goToNewProductPage() throws InterruptedException
	{
		ProductAndServicesTab_ELEMENT.click();
		waitForElement(NewProductLink, 5 ,driver );
		NewProductLink.click();
		Thread.sleep(3000);
	}

	public void goToProductsListPage() throws InterruptedException
	{
		try {
		waitForElement(ProductsListLink, driver);
		ProductsListLink.click();
		} catch (Exception e) {
			ProductAndServicesTab_ELEMENT.click();
			Thread.sleep(1000);
			ProductsListLink.click();
		} 		
	}

}
