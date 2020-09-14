package page;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BankAndCashPage extends BasePage
{
	WebDriver driver;
	List<WebElement> webElementList;
	
	public BankAndCashPage(WebDriver driver) // constructor
	{
		this.driver = driver; // parameter driver is assigned to local driver
	}
	
	@FindBy(how = How.XPATH, using = "//h2[contains(text() , 'Accounts ' )]")
	WebElement AccountsPageHeader;
	@FindBy(how = How.XPATH, using = "//h5[contains(text() , 'Add New Account' )]")
	WebElement NewAccountHeader;
	@FindBy(how = How.XPATH, using = "//h5[contains(text() , 'Manage Accounts' )]")
	WebElement ListAccountHeader;
	@FindBy(how = How.ID, using = "account")
	WebElement AccountsTitle;
	@FindBy(how = How.ID, using = "description")
	WebElement AccountDescription;
	@FindBy(how = How.ID, using = "balance")
	WebElement AccountBalance;
	@FindBy(how = How.XPATH, using = "//button[@type='submit' and contains(text(),' Submit')]")
	WebElement AccountSubmitButton;
	
	public boolean checkNewAccountFormDispalyed() 
	{
		//waitForElement(NewAccountHeader , driver);
		try		{
			return NewAccountHeader.isDisplayed(); // if exists it returns true or it fails does'nt return true/false it throws exception
		}catch(Exception e) {return false;}
	}
	
	public void checkAccountsListDispalyed() {
		waitForElement(ListAccountHeader, driver);
	}
	
	public void addBankAndCashNewAccount(String title , String description , String balance) throws InterruptedException 
	{
//		webElementList = new ArrayList<WebElement>();
//		webElementList.add(0 ,AccountsTitle );
//		webElementList.add(1 ,AccountDescription );
//		webElementList.add(2 ,AccountBalance );
//		waitForElementS(webElementList , driver);
		//OR
		waitForElement(AccountsTitle, driver);
		AccountsTitle.sendKeys(title + new Random().nextInt(999));
		Thread.sleep(1000);
		AccountDescription.sendKeys(description);
		AccountBalance.sendKeys(balance);
	}

	public void submitBankAndCashNewAccount() {
		AccountSubmitButton.click();
	}
}
