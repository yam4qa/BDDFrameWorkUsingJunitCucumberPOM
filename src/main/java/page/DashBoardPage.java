package page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class DashBoardPage extends BasePage  
{
	WebDriver driver;

	public DashBoardPage(WebDriver driver) // constructor
	{
		// this driver parameter is assigned to LoginPage class in LoginTest.java
		// this constructor will be invoked when object of this class created in
		// LoginTest.java with assigned driver
		this.driver = driver; // parameter driver is assigned to local driver
	}
	// Element Library
		String contactToBeDeleted ;
		@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Dashboard')]")
		WebElement DashBoardHeader;
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
		//Filter by Tags
		@FindBy(how = How.ID   , using = "account")
		WebElement FULNAME_ELEMENT;
		@FindBy(how = How.NAME , using = "company")
		WebElement COMPANYNAME_ELEMENT;
		@FindBy(how = How.ID, using = "email")
		WebElement EMAIL_ELEMENT;
		@FindBy(how = How.ID , using = "phone")
		WebElement PHONE_ELEMENT;
		@FindBy(how = How.ID , using = "address")
		WebElement ADDRESS_ELEMENT;
		@FindBy(how = How.ID , using = "city")
		WebElement CITY_ELEMENT;
		@FindBy(how = How.ID , using = "state")
		WebElement STATE_ELEMENT;
		@FindBy(how = How.ID , using = "zip")
		WebElement ZIP_ELEMENT;
		@FindBy(how = How.CSS , using = "select#country")
		WebElement COUNTRY_ELEMENT;
		@FindBy(how = How.ID , using = "submit")
		WebElement ADDCONTACT_SUBMIT_ELEMENT;

		@FindBy(how = How.XPATH , using = "//input[@name='name'and contains(@placeholder ,'Search by Name')]")
		WebElement CONTACT_SEARCH_BOX_ELEMENT;
		@FindBy(how = How.XPATH , using = "//td/descendant::a[contains(text(), 'Delete')]")
		WebElement EXACT_CONTACT_DELETE_BUTTON_ELEMENT;
		//a[text()='"+contactToBeDeleted+"']/parent::td/following-sibling::
		@FindBy(how = How.XPATH , using = "//button[text()='OK']")
		WebElement ALERT_OK_BUTTON_ELEMENT;
		@FindBy(how = How.XPATH , using = "//div[@id='page-wrapper']/descendant::button[@data-dismiss='alert']/following-sibling::i[@class='fa-fw fa fa-check']")
		WebElement SUCCESS_ALERT_ELEMENT;
		
		@FindBy(how = How.XPATH , using = "//span[text()='My Account ']")
		WebElement MY_ACCOUNT;
		@FindBy(how = How.XPATH , using = "//nav[@class='navbar-default navbar-static-side']/descendant ::a[text()='Edit Profile']")
		WebElement EDIT_PROFILE_LINK;
		@FindBy(how = How.ID , using = "username")
		WebElement USERNAME;
	
	// Methods to interact with the elements
		public void waitForPage() 
		{
			System.out.println("waitForPage method");
			waitForElement(DashBoardHeader, driver);
		}

		public String getPageTitle() 
		{
			System.out.println("getPageTitle method");
			System.out.println("Title is " +driver.getTitle());
			return driver.getTitle();
		}
		
		public void fillContactDataToAdd(String name, String companyName, String email,String phone, String address, String city,String state,String zip,String country,String Tags)
		{
			FULNAME_ELEMENT.sendKeys(name);
			COMPANYNAME_ELEMENT.sendKeys(companyName);
			EMAIL_ELEMENT.sendKeys(email);
			PHONE_ELEMENT.sendKeys(phone);
			ADDRESS_ELEMENT.sendKeys(address);
			CITY_ELEMENT.sendKeys(city);
			STATE_ELEMENT.sendKeys(state);
			ZIP_ELEMENT.sendKeys(zip);
			Select selctByValu = new Select(COUNTRY_ELEMENT);
			selctByValu.selectByValue(country);
		}
		public void newContactSubmit()
		{
			ADDCONTACT_SUBMIT_ELEMENT.click();
		}
		
		public void deleteContactBySearching(String name)
		{
			System.out.println("In deleteContactBySearching("+name+") method ");
			waitForElement(CONTACT_SEARCH_BOX_ELEMENT, driver);
			CONTACT_SEARCH_BOX_ELEMENT.sendKeys(name);
			CONTACT_SEARCH_BOX_ELEMENT.sendKeys(Keys.ENTER);
			waitForElement(EXACT_CONTACT_DELETE_BUTTON_ELEMENT, driver);
			EXACT_CONTACT_DELETE_BUTTON_ELEMENT.click();
			waitForElement(ALERT_OK_BUTTON_ELEMENT, driver);
			ALERT_OK_BUTTON_ELEMENT.click();
			waitForElement(SUCCESS_ALERT_ELEMENT, driver);
			System.out.println(" Contact Deleted Sucessfully! ");
			
		}
		public void deleteContactFromList(String name)
		{
			
		}
		public boolean isDashboardDisplayed() 
		{
			try {
				waitForPage();
				return true;
			} catch (Exception e) {

			}
			return false;
		}


		public boolean checkUserName(String expectedUsername) throws InterruptedException 
		{
			MY_ACCOUNT.click();
			Thread.sleep(2000);
			EDIT_PROFILE_LINK.click();
			Thread.sleep(3000);
			String actualUserName = USERNAME.getAttribute("value");
			System.out.println("Actual Username in Dashboard page is : "+actualUserName);
			if(actualUserName.equalsIgnoreCase(expectedUsername))
				return true;
			else
				return false;
			
		}

}
