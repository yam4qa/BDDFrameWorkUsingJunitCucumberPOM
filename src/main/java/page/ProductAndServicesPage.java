package page;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductAndServicesPage extends BasePage
{
	WebDriver driver;
	List<WebElement> webElementList;
	String actualProductName;
	
	public ProductAndServicesPage(WebDriver driver) // constructor
	{
		this.driver = driver; // parameter driver is assigned to local driver
	}

	@FindBy(how = How.XPATH, using = "//h2[contains(text() , 'Products & Services' )]")
	WebElement ProductHeader;
	@FindBy(how = How.XPATH, using = "//h5[contains(text() , 'Add Product' )]")
	WebElement ProductAddHeader;
	@FindBy(how = How.XPATH, using = "//h5[contains(text() , 'List  Products ' )]")
	WebElement ProductListHeader;
	@FindBy(how = How.ID, using = "name")
	WebElement ProdcutNameElement;
	@FindBy(how = How.ID, using = "sales_price")
	WebElement SalesPriceElement;
	@FindBy(how = How.ID, using = "description")
	WebElement DescriptionElement;
	@FindBy(how = How.XPATH, using = "//button[@id='submit'  and contains(text(),'Submit')]")
	WebElement NewProductSubmitButton;
	@FindBy(how = How.ID, using = "txtsearch")
	WebElement SearchBoxElement;
	@FindBy(how = How.ID, using = "search")
	WebElement SearchButtonElement;
	
	
	public void checkNewProductFormDispalyed() {
//		webElementList = new ArrayList<WebElement>();
//		webElementList.add(0, ProductHeader);
//		webElementList.add(1, ProductAddHeader);
//		waitForElementS(webElementList, driver);
		waitForElement(ProductAddHeader, driver);
	}
	public void checkProductListDispalyed() {
//		webElementList = new ArrayList<WebElement>();
//		webElementList.add(0, ProductHeader);
//		webElementList.add(1, ProductListHeader);
		waitForElement(ProductListHeader, driver);
	}
	public void AddNewProductDetails(String productName, String salesPrice, String description) 
	{
		actualProductName = productName+new Random().nextInt(999);
		ProdcutNameElement.sendKeys(actualProductName);
		SalesPriceElement.sendKeys(salesPrice);
		DescriptionElement.sendKeys(description);
	}
	public void SubmitNewProduct() 
	{
		NewProductSubmitButton.click();
	}
	public void searchProductInTheList() throws InterruptedException 
	{
		SearchBoxElement.sendKeys(actualProductName);
		Thread.sleep(1000);
		SearchButtonElement.click();
	}

}
