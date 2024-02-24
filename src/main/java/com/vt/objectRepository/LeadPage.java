package com.vt.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vt.utilities.WebDriverUtility;

public class LeadPage extends WebDriverUtility {

	@FindBy(linkText = "Leads")
	private WebElement leadsPageHeaderText;

	@FindBy(xpath = "//img[@title='Create Lead...']")
	private WebElement createLeadLookUpImg;

	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement createLeadPageHeaderText;

	@FindBy(xpath = "//select[@name='salutationtype']")
	private WebElement firstNameTitleDrp;

	@FindBy(name = "firstname")
	private WebElement firstNameEdt;

	@FindBy(name = "lastname")
	private WebElement lastNameEdt;

	@FindBy(name = "company")
	private WebElement companyNameEdt;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement leadHeaderText;
	
	@FindBy(xpath = "//*[contains(@name, 'leadsource')]")
	private WebElement leadSourceDrp;
	
	@FindBy(xpath = "//*[contains(@name, 'industry')]")
	private WebElement industryDrp;

	public LeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLeadsPageHeaderText() {
		return leadsPageHeaderText;
	}

	public WebElement getCreateLeadLookUpImg() {
		return createLeadLookUpImg;
	}

	public WebElement getCreateLeadPageHeaderText() {
		return createLeadPageHeaderText;
	}

	public WebElement getFirstNameTitleDrp() {
		return firstNameTitleDrp;
	}

	public WebElement getFirstNameEdt() {
		return firstNameEdt;
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getCompanyNameEdt() {
		return companyNameEdt;
	}
	
	public WebElement getLeadSource() {
		return leadSourceDrp;
	}
	
	public WebElement getIndustry() {
		return industryDrp;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getLeadHeaderText() {
		return leadHeaderText;
	}

	public String getLeadHeader() {
		return getLeadsPageHeaderText().getText();
	}

	public void clickOnLeadLookUpImage() {
		getCreateLeadLookUpImg().click();
	}

	public String getCreateLeadPageHeader() {
		return getCreateLeadPageHeaderText().getText();
	}

	public void createNewLead(WebDriver driver, String firstName, String lastName, String companyName) {
		handleDropDown(getFirstNameTitleDrp(), "Mr.");
		getFirstNameEdt().sendKeys(firstName);
		getLastNameEdt().sendKeys(lastName);
		getCompanyNameEdt().sendKeys(companyName);
		handleDropDown(getLeadSource(), "Cold Call");
		handleDropDown( getIndustry(), "Other");
		getSaveBtn().click();
	}
	
	public void createLeadIndustry(WebDriver driver, String firstName, String lastName, String companyName,String industryType) {
		handleDropDown(getFirstNameTitleDrp(), "Mr.");
		getFirstNameEdt().sendKeys(firstName);
		getLastNameEdt().sendKeys(lastName);
		getCompanyNameEdt().sendKeys(companyName);
		handleDropDown(getLeadSource(), "Cold Call");
		handleDropDown( getIndustry(), industryType);
		getSaveBtn().click();
	}

	public String getLeadNameHeader() {
		return getLeadHeaderText().getText();
	}
}
