package com.vt.objectRepository;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.vt.utilities.WebDriverUtility;

public class ProductPage extends WebDriverUtility {

	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement createProductLookUpImg;

	@FindBy(linkText = "Products")
	private WebElement productPageHeaderText;

	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement createdProductHeaderText;

	@FindBy(name = "productname")
	private WebElement productNameEdt;

	@FindBy(xpath = "//input[@name='sales_start_date']")
	private WebElement salesStartDateCalender;

	@FindBy(name = "productcategory")
	private WebElement productCategoryDrp;

	@FindBy(xpath = "//*[contains(@title,'Select')]")
	private WebElement vendorLookUpImg;

	@FindBy(name = "search_text")
	private WebElement vendorSearchEdt;

	@FindBy(name = "search")
	private WebElement vendorSearchBtn;

	@FindBy(xpath = "//*[contains(@id,'unit_price')]")//*[contains(@id,'unit_price')] //*[contains(@id, 'multiple_currencies')]
	private WebElement unitPrice;

	@FindBy(xpath = "//*[contains(@id,'commissionrate')]")
	private WebElement commissionRate;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement createdProductHeaderTitel;

	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateProductLookUpImg() {
		return createProductLookUpImg;
	}

	public WebElement getProductPageHeaderText() {
		return productPageHeaderText;
	}

	public WebElement getCreatedproductHeaderText() {
		return createdProductHeaderText;
	}

	public WebElement getProductNameEdt() {
		return productNameEdt;
	}

	public WebElement getSalesStartDate() {
		return salesStartDateCalender;
	}

	public WebElement getProductCategoryDrp() {
		return productCategoryDrp;
	}

	public WebElement getVendorLookUpImg() {
		return vendorLookUpImg;
	}

	public WebElement getVendorSearchEdt() {
		return vendorSearchEdt;
	}

	public WebElement getVendorSearchBtn() {
		return vendorSearchBtn;
	}

	public WebElement getProductUnitPrice() {
		return unitPrice;
	}

	public WebElement getCommissionRate() {
		return commissionRate;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void clickOnProductLookUpImage() {
		getCreateProductLookUpImg().click();
	}

	

	public void createProduct(WebDriver driver, Map<String, String> productDetails) {
		
	    String productName = productDetails.get("productName");
	    String salesStartDate = productDetails.get("salesStartDate");
	    String productCategory = productDetails.get("productCategory");
	    String unitPrice = productDetails.get("unitPrice");
	    String commissionRate = productDetails.get("commissionRate");

	    getProductNameEdt().sendKeys(productName);
	    getSalesStartDate().sendKeys(salesStartDate);
	    handleDropDown(getProductCategoryDrp(), productCategory);

	    scrollAction(driver);
	    
	    /*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].scrollIntoView();", commissionRate);
		 */

	    getProductUnitPrice().clear();
	    getProductUnitPrice().sendKeys(unitPrice);

	    getCommissionRate().sendKeys(commissionRate);
	    getSaveBtn().click();
	}


	public void createProductWithVendor(WebDriver driver, String productName, String salesStartDate,
			String productCategory, String vendorName) {
		getProductNameEdt().sendKeys(productName);
		getSalesStartDate().sendKeys(salesStartDate);
		handleDropDown(getProductCategoryDrp(), productCategory);
		switchToWindow(driver, "Vendors");
		getVendorSearchEdt().sendKeys(vendorName);
		getVendorSearchBtn().click();
		driver.findElement(By.xpath("//a[.='" + vendorName + "']")).click();
		switchToWindow(driver, "Products");
		getSaveBtn().click();
	}

	public String getProductPagetHeaderTitel() {
		return getProductPageHeaderText().getText();
	}

	public String getCreatedProductHeaderTitel() {
		return getCreatedproductHeaderText().getText();
	}

}