package com.vt.objectRepository;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vt.utilities.RandomUtilsImpliments;
import com.vt.utilities.WebDriverUtility;

public class VendorsPage extends WebDriverUtility {

	@FindBy(css = "[alt='Create Vendor...']")
	private WebElement createVendorsLookUpImg;

	@FindBy(xpath = "//td[@class='moduleName']")
	private WebElement vendorsPageHeaderText;

	@FindBy(className = "lvtHeaderText")
	private WebElement vendorsFormHeaderText;

	@FindBy(name = "vendorname")
	private WebElement vendorNameEdt;

	@FindBy(id = "email")
	private WebElement emailTextEdt;

	@FindBy(xpath = "//select[@name='glacct']")
	private WebElement gLAccountDrp;

	@FindBy(id = "category")
	private WebElement categoryTextEdt;

	@FindBy(id = "phone")
	private WebElement phoneNumberTextEdt;

	@FindBy(name = "website")
	private WebElement websiteTextEdt;

	@FindBy(name = "street")
	private WebElement addressEdt;

	@FindBy(xpath = "//*[contains(@name,'description')]")
	private WebElement descriptionEdt;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement createdVendorsHeaderTitel;

	// initialization
	public VendorsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public WebElement getCreateVendorsLookUpImg() {
		return createVendorsLookUpImg;
	}

	public WebElement getVendorsPageHeaderText() {
		return vendorsPageHeaderText;
	}

	public WebElement getVendorsFormHeaderText() {
		return vendorsFormHeaderText;
	}

	public WebElement getVendorNameEdt() {
		return vendorNameEdt;
	}

	public WebElement getEmailTextEdt() {
		return emailTextEdt;
	}

	public WebElement getGLAccountDrp() {
		return gLAccountDrp;
	}

	public WebElement getCategoryTextEdt() {
		return categoryTextEdt;
	}

	public WebElement getPhoneNumberTextEdt() {
		return phoneNumberTextEdt;
	}

	public WebElement getWebsiteTextEdt() {
		return websiteTextEdt;
	}

	public WebElement getAddressEdt() {
		return addressEdt;
	}

	public WebElement getDetailedTextBox() {
		return descriptionEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getCreatedVendorsHeaderTitel() {
		return createdVendorsHeaderTitel;
	}

	// Business Library
	public void clickOnVendorsookUpImage() {
		getCreateVendorsLookUpImg().click();
	}

	public void createVendorsSingleGLaccount(WebDriver driver, String vendorName, String email, String category,
			String phoneNumber, String webSite, String address) {

		getVendorNameEdt().sendKeys(vendorName);
		getEmailTextEdt().sendKeys(email);
		getCategoryTextEdt().sendKeys(category);
		getPhoneNumberTextEdt().sendKeys(phoneNumber);
		getWebsiteTextEdt().sendKeys(webSite);
		getAddressEdt().sendKeys(address);
		scrollAction(driver);
		waitForElementToBeVisisble(driver, descriptionEdt);
		getDetailedTextBox().sendKeys(RandomUtilsImpliments.generateDescription());
		mouseHoverAction(driver, saveBtn);
		getSaveBtn().click();
	}
	
	public String getVendorsPageHeader() {
		return getVendorsPageHeaderText().getText();
	}

	public String getCreatedVendorsHeader() {
		return getCreatedVendorsHeaderTitel().getText();
	}

	public void createVendorsMultipuleGLaccount(WebDriver driver, String vendorName, String email, String gLAccount,
			String category, String phoneNumber, String address) {

		getVendorNameEdt().sendKeys(vendorName);
		getEmailTextEdt().sendKeys(email);
		handleDropDown(getGLAccountDrp(), gLAccount);
		getCategoryTextEdt().sendKeys(category);
		getPhoneNumberTextEdt().sendKeys(phoneNumber);
		getWebsiteTextEdt().sendKeys(RandomUtilsImpliments.generateWebsite());
		getAddressEdt().sendKeys(address);
		scrollAction(driver);
		waitForElementToBeVisisble(driver, descriptionEdt);
		getDetailedTextBox().sendKeys(RandomUtilsImpliments.generateDescription());
		mouseHoverAction(driver, saveBtn);
		getSaveBtn().click();
	}
	
	
	public void createVendor(WebDriver driver, Map<String, String> vendorInfo) {
		if (driver == null || vendorInfo == null || vendorInfo.isEmpty()) {
			throw new IllegalArgumentException("Driver or vendor information cannot be null or empty.");
		}

		// Extracting vendor information from the map
		String vendorName = vendorInfo.get("vendorName");
		String email = vendorInfo.get("email");
		String gLAccount = vendorInfo.get("gLAccount");
		String category = vendorInfo.get("category");
		String phoneNumber = vendorInfo.get("phoneNumber");
		String webSite = vendorInfo.get("webSite");
		String address = vendorInfo.get("address");
		String description = vendorInfo.get("description");

		// Vendor Information:
		getVendorNameEdt().sendKeys(vendorName);
		getEmailTextEdt().sendKeys(email);
		handleDropDown(getGLAccountDrp(), gLAccount);
		getCategoryTextEdt().sendKeys(category);
		getPhoneNumberTextEdt().sendKeys(phoneNumber);
		getWebsiteTextEdt().sendKeys(webSite);

		// Address Information:
		getAddressEdt().sendKeys(address);

		// Description Name:
		scrollAction(driver);
		waitForElementToBeVisisble(driver, descriptionEdt);
		getDetailedTextBox().sendKeys(description);

		// Save
		mouseHoverAction(driver, saveBtn);
		getSaveBtn().click();
	}

	

	

}
